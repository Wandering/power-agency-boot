$(function () {
    $("#jqGrid").jqGrid({
        url: '../chargemodel/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 30, key: true },
			{ label: '模式名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '计费机制', name: 'chargeDay', index: 'charge_day', width: 80 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.chargeConfigs)[value]:"";
			}}, 			
			{ label: '首次充值', name: 'firstDeposit', index: 'first_deposit', width: 80 ,formatter: function(value){return value+"元";}}, 			
			{ label: '最低余额', name: 'minDeposit', index: 'min_deposit', width: 80 ,formatter: function(value){return value+"元";}}, 			
			{ label: '年费', name: 'yearFee', index: 'year_fee', width: 80 ,formatter: function(value){return value+"元";}}, 			
			{ label: '免费时长', name: 'freeTime', index: 'free_time', width: 80 ,formatter: function(value){return value+"分钟";}}, 			
			{ label: '逾期单价', name: 'overdueFee', index: 'overdue_fee', width: 80 ,formatter: function(value){return value+"分/时";}}, 			
			{ label: '封顶', name: 'maxOverdueFee', index: 'max_overdue_fee', width: 80 ,formatter: function(value){return value+"分/天";}}, 			
			{ label: '还电缓冲时间', name: 'bufferTime', index: 'buffer_time', width: 80 ,formatter: function(value){return value+"分";}}, 			
			{ label: '扣费比例', name: 'borrowScale', index: 'borrow_scale', width: 80 }, 			
			{ label: '创建时间', name: 'createDt', index: 'create_dt', width: 80 },
			{ label: '创建人', name: 'createBy', index: 'create_by', width: 80 },
			{ label: '编辑时间', name: 'updateDt', index: 'update_dt', width: 80 }, 			
			{ label: '编辑人', name: 'updateBy', index: 'update_by', width: 80 }			
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
        	if(vm.chargeConfigs.length==0){
	        	$.ajax({
					type: "POST",
				    url: "../dict/CHARGE_COF",
				    async: false,
				    success: function(r){
				    	if(r.code === 0){
				    		vm.chargeConfigs = r.data;
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
		chargeConfigs:[],
		chargeModel: {}
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
			vm.chargeModel = {};
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
			var url = vm.chargeModel.id == null ? "../chargemodel/save" : "../chargemodel/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.chargeModel),
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
				    url: "../chargemodel/delete",
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
			$.get("../chargemodel/info/"+id, function(r){
                vm.chargeModel = r.chargeModel;
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