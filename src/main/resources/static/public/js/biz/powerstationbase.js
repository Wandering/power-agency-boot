$(function () {
    $("#jqGrid").jqGrid({
        url: '../powerstationbase/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '充电桩IMEI号', name: 'code', index: 'code', width: 120 }, 
			{ label: '充电桩型号', name: 'type', index: 'type', width: 90 ,formatter: function(value, options, row){
				return value!=null&&value!=""?getModel(vm.models)[value]:"";
			}},
			{ label: '通讯方式 ', name: 'channel', index: 'channel', width: 90 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.channels)[value]:"";
			}}, 			
			{ label: '充电桩槽位', name: 'slotNo', index: 'slot_no', width: 100 },
			{ label: '服务商', name: 'facilitatorId', index: 'facilitator_id', width: 100 }, 	
			{ label: '充电桩错误状态', name: 'errorCode', index: 'error_code', width: 100 }, 			
			{ label: '是否同步', name: 'isSync', index: 'is_sync', width: 100 }, 			
			{ label: '是否正在被使用', name: 'status', index: 'status', width: 100 }, 			
			{ label: '异常槽位数量', name: 'errorSlot', index: 'error_slot', width: 100 }, 			
			{ label: '空闲槽位', name: 'free', index: 'free', width: 100 }, 			
			{ label: '可借', name: 'canBorrow', index: 'can_borrow', width: 100 }, 			
			{ label: '充电桩状态', name: 'stateCode', index: 'state_code', width: 100 }, 			
			{ label: '总借出次数', name: 'borrowCount', index: 'borrow_count', width: 100 }, 			
			//{ label: '编辑人', name: 'editName', index: 'edit_name', width: 100 }, 			
			//{ label: '编辑人ID', name: 'editId', index: 'edit_id', width: 100 }, 			
			{ label: '批次', name: 'batch', index: 'batch', width: 100 }, 			
			{ label: '备注', name: 'note', index: 'note', width: 100 }, 			
			{ label: '生产日期', name: 'production', index: 'production', width: 100 }, 			
			//{ label: '运营商ID', name: 'agencyid', index: 'agencyId', width: 100 }, 			
			/*{ label: '创建时间', name: 'createDt', index: 'create_dt', width: 80 },
			{ label: '创建人', name: 'createBy', index: 'create_by', width: 80 },
			{ label: '更新时间', name: 'updateDt', index: 'update_dt', width: 80 }, 			
			{ label: '更新人', name: 'updateBy', index: 'update_by', width: 80 }*/
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        beforeRequest:function(e){
        	if(vm.channels.length==0){
        		$.ajax({
					type: "POST",
				    url: "../dictcommon/STATION_CHANNEL",
				    success: function(r){
				    	if(r.code === 0){
				    		vm.channels = r.data;
						}else{
							alert(r.msg);
						}
					}
				});
        	}
        	if(vm.models.length==0){
        		$.ajax({
					type: "POST",
				    url: "../dictcommon/queryStationModel",
				    success: function(r){
				    	if(r.code === 0){
				    		vm.models = r.data;
						}else{
							alert(r.msg);
						}
					}
				});
        	}
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		status:null,
		models:[],
		channels:[],
		powerStationBase: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.status = "add";
			vm.powerStationBase = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.status = "edit";
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.powerStationBase.id == null ? "../powerstationbase/save" : "../powerstationbase/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.powerStationBase),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../powerstationbase/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../powerstationbase/info/"+id, function(r){
                vm.powerStationBase = r.powerStationBase;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
		selectModel: function(){
			for(i in vm.models){ 
				if(vm.powerStationBase.type==vm.models[i].id){
					vm.powerStationBase.channel = vm.models[i].channel
					vm.powerStationBase.slotNo = vm.models[i].slotNo
					if(vm.status=='add'){
						$("select[name='channel']").val(vm.models[i].channel);
						$("input[name='slotNo']").val(vm.models[i].slotNo);
					}
				}
			}
		}
	}
});