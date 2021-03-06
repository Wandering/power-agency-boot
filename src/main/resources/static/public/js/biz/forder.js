$(function () {
    $("#jqGrid").jqGrid({
        url: '../forder/queryOrderModel',
        datatype: "json",
        colModel: [			
            { label: '订单ID', name: 'id', index: 'id', width: 40, key: true },
			//{ label: '订单编号', name: 'order_no', index: 'orderNo', width: 100 },
			{ label: '用户ID', name: 'order_owner', index: 'order_owner', width: 50 }, 			
			{ label: '充电宝ID', name: 'power_bank', index: 'power_bank', width:70 }, 			
			{ label: '借电时间', name: 'start_dt', index: 'start_dt', width: 80 ,formatter: function(value, options, row){
				return  value!=undefined?vm.parseDate(value):"";
			}}, 			
			{ label: '借电桩ID', name: 'from_station', index: 'from_station', width: 70 }, 			
			{ label: '还电时间', name: 'end_dt', index: 'end_dt', width: 80 ,formatter: function formatDate(value, options, row)
			{ 
				return value!=undefined?vm.parseDate(value):""; 
			}}, 			
			{ label: '还电桩ID', name: 'to_station', index: 'to_station', width: 70 }, 			
			{ label: '费用', name: 'fee', index: 'fee', width: 40 }, 			
			{ label: '交易状态', name: 'status', index: 'status', width: 70 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.orderStatus)[value]:"";
			}}, 			
			{ label: '付款方式', name: 'trade_type', index: 'trade_type', width: 50 }, 			
			{ label: '租借时长', name: 'borrow_time', index: 'borrow_time', width: 70 }, 			
			{ label: '实付款', name: 'total_fee', index: 'total_fee', width: 50 }, 			
			{ label: '付款时间', name: 'update_dt', index: 'update_dt', width: 100 }, 			
			{ label: '计费模式', name: 'user_roles', index: 'user_roles', width: 50 ,formatter: function(value, options, row){
				for(var i in vm.models){if(vm.models[i].id==value){value=vm.models[i].name}};return value!=null?value:"";
			}},
			{ label: '备注', name: 'des', index: 'des', width: 50 },	
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
        	if(vm.orderStatus.length==0){
	        	$.ajax({
					type: "POST",
				    url: "../dict/ORDER_STATUS",
				    async: false,
				    success: function(r){
				    	if(r.code === 0){
				    		vm.orderStatus = r.data;
						}else{alert(r.msg);}
					}
				});
        	}
        	if(vm.models.length==0){
        		$.ajax({
        			type: "POST",
        			url: "../dict/queryChargerModel",
        			async: false,
        			success: function(r){
        				if(r.code === 0){
        					vm.models = r.data;
        				}else{alert(r.msg);}
        			}
        		});
        	}
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        	$('#startDt').datetimepicker({autoclose:true,todayBtn:true,language:'zh-CN'}).on('hide', function(ev){
        	    vm.q.startDt=$('#startDt').val();
        	});
        	$('#endDt').datetimepicker({autoclose:true,todayBtn:true,language:'zh-CN'}).on('hide', function(ev){
        		vm.q.endDt=$('#endDt').val();
        	});
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
			orderOwner: null
		},
		showList: true,
		title: null,
		status:null,
		orderStatus:[],
		orderLine: {},
		models:[]
	},
	methods: {
		query: function () {
			$("#jqGrid").jqGrid('setGridParam',{page:1});
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
			var url = vm.orderLine.id == null ? "../forder/queryorder" : "../forder/queryorder";
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
				postData:vm.q,
                page:page 
            }).trigger("reloadGrid");
		},
		parseDate: function(value){
			if(value==null){
				return "";
			}else{
				return new Date(parseInt(value)*1000).format("yyyy-MM-dd hh:mm:ss");
			}
		}
	}
});