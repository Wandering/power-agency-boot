$(function () {
    $("#jqGrid").jqGrid({
        url: '../chargemodel/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '模式名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '计费机制 0 24小时 1 自然日制', name: 'chargeDay', index: 'charge_day', width: 80 }, 			
			{ label: '每次需要充值多少', name: 'firstDeposit', index: 'first_deposit', width: 80 }, 			
			{ label: '账号本金最少值', name: 'minDeposit', index: 'min_deposit', width: 80 }, 			
			{ label: '年费', name: 'yearFee', index: 'year_fee', width: 80 }, 			
			{ label: '免费时长（小时）', name: 'freeTime', index: 'free_time', width: 80 }, 			
			{ label: '逾期单价（元/时）', name: 'overdueFee', index: 'overdue_fee', width: 80 }, 			
			{ label: '封顶（元/天）', name: 'maxOverdueFee', index: 'max_overdue_fee', width: 80 }, 			
			{ label: '还电缓冲时间 单位s', name: 'bufferTime', index: 'buffer_time', width: 80 }, 			
			{ label: '扣费比例', name: 'borrowScale', index: 'borrow_scale', width: 80 }, 			
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
		chargeModel: {}
	},
	methods: {
		query: function () {
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