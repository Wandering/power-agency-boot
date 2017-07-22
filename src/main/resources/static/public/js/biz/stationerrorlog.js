$(function () {
    $("#jqGrid").jqGrid({
        url: '../stationerrorlog/list',
        datatype: "json",
        postData: vm.q,
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '充电桩', name: 'deviceId', index: 'device_id', width: 80 }, 			
			{ label: '卡槽号', name: 'slotNo', index: 'slot_no', width: 80 }, 			
			{ label: '处理方式', name: 'type', index: 'type', width: 80 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.dealTypes)[value]:"";
			}}, 			
			{ label: '类型', name: 'errorCode', index: 'error_code', width: 80 , width: 280 ,formatter: function(value, options, row){
				for(var i in vm.types){if(value==vm.types[i].code){value=vm.types[i].note}}
				return value;
			}}, 			
			{ label: '上报时间', name: 'upTime', index: 'up_time', width: 80 }, 			
			{ label: '处理状态', name: 'status', index: 'status', width: 80 }			
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
        	if(vm.dealTypes.length==0){
        		$.ajax({
					type: "POST",
				    url: "../dict/DEAL_TYPE",
				    async: false,
				    success: function(r){
				    	if(r.code === 0){
				    		vm.dealTypes = r.data;
						}else{
							alert(r.msg);
						}
					}
				});
        	}
        	if(vm.types.length==0){
        		vm.changType(0);
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
		q:{
			deviceType:1,
			type:1,
			errorCode:""
		},
		showList: true,
		title: null,
		status:null,
		dealTypes:[],
		types:[],
		stationErrorLog: {}
	},
	methods: {
		query: function () {
			$("#jqGrid").jqGrid('setGridParam',{page:1});
			vm.reload();
		},
		changType:function (e) {
			vm.q.errorCode="";
			if(e==1){vm.reload();}
			$.ajax({
				type: "POST",
				data:vm.q,
			    url: "../dict/queryErrorType",
			    success: function(r){
			    	if(r.code === 0){
			    		vm.types = r.data;
					}else{
						alert(r.msg);
					}
				}
			});
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.status = "add";
			vm.stationErrorLog = {};
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
			var url = vm.stationErrorLog.id == null ? "../stationerrorlog/save" : "../stationerrorlog/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.stationErrorLog),
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
				    url: "../stationerrorlog/delete",
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
			$.get("../stationerrorlog/info/"+id, function(r){
                vm.stationErrorLog = r.stationErrorLog;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:vm.q,
                page:page
            }).trigger("reloadGrid");
		},
		lockSwich: function(type){
			var id = getSelectedRow();
			if(id == null){
				return ;
			}else{
				var rowData = $("#jqGrid").jqGrid('getRowData',id);
				$.ajax({
					type: "POST",
				    url: "../operate/lockSwich",
				    data: {deviceId:rowData.deviceId,slotNo:rowData.slotNo,slotSwitch:type},
				    success: function(r){
						if(r.code == 0){
							alert('操作成功');
						}else{
							alert(r.msg);
						}
					}
				});
			}
		}
	}
});