$(function () {
    $("#jqGrid").jqGrid({
        url: '../stationmodel/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 30, key: true },
			{ label: '充电桩型号', name: 'model', index: 'model', width: 80 }, 			
			{ label: '卡槽数量', name: 'slotNo', index: 'slot_no', width: 80 }, 			
			{ label: '通讯方式', name: 'channel', index: 'channel', width: 80 ,formatter: function(value, options, row){return getDict(vm.channels)[value];}}, 			
			{ label: '输入电压', name: 'inputVoltage', index: 'input_voltage', width: 80 }, 			
			{ label: '最大输入电流', name: 'maxInputCurrent', index: 'max_input_current', width: 90 }, 			
			{ label: '最大输入功耗', name: 'maxInputPower', index: 'max_input_power', width: 90 }, 			
			{ label: '静态输入功耗', name: 'staticInputPower', index: 'static_input_power', width: 90 }, 			
			{ label: '认证', name: 'authentication', index: 'authentication', width: 70 }, 			
			{ label: '尺寸', name: 'size', index: 'size', width: 70 }, 			
			{ label: 'NFC', name: 'isnfc', index: 'isNFC', width: 70 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.nfcs)[value]:"";
			}},
			{ label: '出仓方式', name: 'deliveryModel', index: 'delivery_model', width: 80 }, 			
			{ label: '生产厂家', name: 'manufacturer', index: 'manufacturer', width: 80 }, 			
			{ label: '创建时间', name: 'createDt', index: 'create_dt', width: 80 },
			{ label: '创建人', name: 'createBy', index: 'create_by', width: 80 },
			{ label: '更新时间', name: 'updateDt', index: 'update_dt', width: 80 }, 			
			{ label: '更新人', name: 'updateBy', index: 'update_by', width: 80 }		
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
        	if(vm.nfcs.length==0){
	        	$.ajax({
					type: "POST",
				    url: "../dict/ISNFC",
				    success: function(r){
				    	if(r.code === 0){
				    		vm.nfcs = r.data;
						}else{
							alert(r.msg);
						}
					}
				});
        	}
        	if(vm.channels.length==0){
        		$.ajax({
					type: "POST",
				    url: "../dict/STATION_CHANNEL",
				    success: function(r){
				    	if(r.code === 0){
				    		vm.channels = r.data;
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
		nfcs:[],
		channels:[],
		stationModel: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.status = "add";
			vm.stationModel = {};
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
			var url = vm.stationModel.id == null ? "../stationmodel/save" : "../stationmodel/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.stationModel),
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
				    url: "../stationmodel/delete",
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
			$.get("../stationmodel/info/"+id, function(r){
                vm.stationModel = r.stationModel;
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