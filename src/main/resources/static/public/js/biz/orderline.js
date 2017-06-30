$(function () {
    $("#jqGrid").jqGrid({
        url: '../orderline/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '费用', name: 'fee', index: 'fee', width: 80 }, 			
			{ label: '用户ID', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '服务商ID', name: 'agency', index: 'agency', width: 80 }, 			
			{ label: '借出充电桩ID', name: 'fromStation', index: 'from_station', width: 80 }, 			
			{ label: '归还充电桩ID', name: 'toStation', index: 'to_station', width: 80 }, 			
			{ label: '充电宝ID', name: 'powerBank', index: 'power_bank', width: 80 }, 			
			{ label: '交易类型，BALANCE,CONSUME,DEPOSIT', name: 'feeType', index: 'fee_type', width: 80 }, 			
			{ label: '订单ID', name: 'orderId', index: 'order_id', width: 80 }, 			
			{ label: '', name: 'createDt', index: 'create_dt', width: 80 }, 			
			{ label: '', name: 'updateDt', index: 'update_dt', width: 80 }, 			
			{ label: '', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '开始时间', name: 'startDt', index: 'start_dt', width: 80 }, 			
			{ label: '结束时间', name: 'endDt', index: 'end_dt', width: 80 }			
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
		orderLine: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.status = "add";
			vm.orderLine = {};
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
			var url = vm.orderLine.id == null ? "../orderline/save" : "../orderline/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.orderLine),
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
				    url: "../orderline/delete",
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
			$.get("../orderline/info/"+id, function(r){
                vm.orderLine = r.orderLine;
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