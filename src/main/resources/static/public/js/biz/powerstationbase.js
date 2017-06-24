$(function () {
    $("#jqGrid").jqGrid({
        url: '../powerstationbase/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '充电桩code，充电桩IMEI编号', name: 'code', index: 'code', width: 80 }, 			
			{ label: '主要通信信道 0：Wi-Fi,1：GPRS,2：4G 字典表STATION_CHANNEL', name: 'channel', index: 'channel', width: 80 }, 			
			{ label: '充电桩型号', name: 'type', index: 'type', width: 80 }, 			
			{ label: '服务商id(由哪个服务商提供服务，默认是1知路)', name: 'facilitatorId', index: 'facilitator_id', width: 80 }, 			
			{ label: '充电桩槽位', name: 'slotNo', index: 'slot_no', width: 80 }, 			
			{ label: '充电桩错误状态：0、正常', name: 'errorCode', index: 'error_code', width: 80 }, 			
			{ label: '是否同步到知路服务器(1：是 0：否)', name: 'isSync', index: 'is_sync', width: 80 }, 			
			{ label: '是否正在被使用(1，正在使用  2未使用)', name: 'status', index: 'status', width: 80 }, 			
			{ label: '异常槽位数量', name: 'errorSlot', index: 'error_slot', width: 80 }, 			
			{ label: '空闲槽位', name: 'free', index: 'free', width: 80 }, 			
			{ label: '可借(记录当前充电中状态，减少每次统计)', name: 'canBorrow', index: 'can_borrow', width: 80 }, 			
			{ label: '充电桩状态码：0、正常、1、禁用 2、删除', name: 'stateCode', index: 'state_code', width: 80 }, 			
			{ label: '总共借出次数', name: 'borrowCount', index: 'borrow_count', width: 80 }, 			
			{ label: '编辑人', name: 'editName', index: 'edit_name', width: 80 }, 			
			{ label: '编辑人ID', name: 'editId', index: 'edit_id', width: 80 }, 			
			{ label: '批次', name: 'batch', index: 'batch', width: 80 }, 			
			{ label: '备注', name: 'note', index: 'note', width: 80 }, 			
			{ label: '生产日期', name: 'production', index: 'production', width: 80 }, 			
			{ label: '运营商ID', name: 'agencyid', index: 'agencyId', width: 80 }, 			
			{ label: '', name: 'createDt', index: 'create_dt', width: 80 }, 			
			{ label: '', name: 'updateDt', index: 'update_dt', width: 80 }, 			
			{ label: '', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '', name: 'updateBy', index: 'update_by', width: 80 }			
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
		}
	}
});