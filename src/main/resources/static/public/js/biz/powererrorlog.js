$(function () {
    $("#jqGrid").jqGrid({
        url: '../powererrorlog/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '充电宝id', name: 'batteryId', index: 'battery_id', width: 80 }, 			
			{ label: '幢ID', name: 'deviceId', index: 'device_id', width: 80 }, 			
			{ label: '槽位', name: 'slotNo', index: 'slot_no', width: 80 }, 			
			{ label: '错误类型(1：认为处理，2：系统处理)', name: 'type', index: 'type', width: 80 }, 			
			{ label: '错误码', name: 'errorCode', index: 'error_code', width: 80 }, 			
			{ label: '重放次数', name: 'chargeCount', index: 'charge_count', width: 80 }, 			
			{ label: '电量当前', name: 'eq', index: 'eq', width: 80 }, 			
			{ label: '电压', name: 'vol', index: 'vol', width: 80 }, 			
			{ label: '温度', name: 'tempNow', index: 'temp_now', width: 80 }, 			
			{ label: '充电宝状态(上报字段)', name: 'state', index: 'state', width: 80 }, 			
			{ label: '上报时间', name: 'upTime', index: 'up_time', width: 80 }, 			
			{ label: '当前处理状态(已处理，未处理)', name: 'status', index: 'status', width: 80 }			
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
		powerErrorLog: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.status = "add";
			vm.powerErrorLog = {};
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
			var url = vm.powerErrorLog.id == null ? "../powererrorlog/save" : "../powererrorlog/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.powerErrorLog),
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
				    url: "../powererrorlog/delete",
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
			$.get("../powererrorlog/info/"+id, function(r){
                vm.powerErrorLog = r.powerErrorLog;
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