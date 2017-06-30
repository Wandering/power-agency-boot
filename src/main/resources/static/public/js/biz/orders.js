$(function () {
    $("#jqGrid").jqGrid({
        url: '../orders/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '产生费用', name: 'totalFee', index: 'total_fee', width: 80 }, 			
			{ label: '用户ID', name: 'orderOwner', index: 'order_owner', width: 80 }, 			
			{ label: '服务商ID', name: 'agency', index: 'agency', width: 80 }, 			
			{ label: '类别', name: 'type', index: 'type', width: 80 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.orderType)[value]:"";
			}}, 			
			{ label: '订单状态', name: 'status', index: 'status', width: 80 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.orderStatus)[value]:"";
			}}, 			
			{ label: '交易时间', name: 'createDt', index: 'create_dt', width: 80 }, 			
			{ label: '订单编号', name: 'orderNo', index: 'order_no', width: 80 }, 			
			{ label: '计费模式', name: 'userRoles', index: 'user_roles', width: 80 }			
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
        	if(vm.orderType.length==0){
	        	$.ajax({
					type: "POST",
				    url: "../dict/ORDER_TYPE",
				    success: function(r){
				    	if(r.code === 0){
				    		vm.orderType = r.data;
						}else{
							alert(r.msg);
						}
					}
				});
        	}
        	if(vm.orderStatus.length==0){
        		$.ajax({
        			type: "POST",
        			url: "../dict/ORDER_STATUS",
        			success: function(r){
        				if(r.code === 0){
        					vm.orderStatus = r.data;
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
		q:{
			startDt:null,
			endDt:null,
			id:null,
			orderOwner: null,
			orderType:null,
			
		},
		showList: true,
		title: null,
		status:null,
		type:null,
		orders: {},
		orderStatus:[],
		orderType:[]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.status = "add";
			vm.orders = {};
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
			var url = vm.orders.id == null ? "../orders/save" : "../orders/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.orders),
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
				    url: "../orders/delete",
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
			$.get("../orders/info/"+id, function(r){
                vm.orders = r.orders;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				 postData:vm.q,
                page:page
            }).trigger("reloadGrid");
		}
	}
});