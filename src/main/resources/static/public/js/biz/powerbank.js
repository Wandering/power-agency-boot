$(function () {
    $("#jqGrid").jqGrid({
        url: '../powerbank/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '充电宝IMEI号', name: 'code', index: 'code', width: 80 }, 			
			{ label: '充电宝型号', name: 'type', index: 'type', width: 80 ,formatter: function(value, options, row){
				return value!=null?getModel(vm.models)[value]:"";
			}},
			{ label: '充电桩IMEI号', name: 'station', index: 'station', width: 80 }, 			
			{ label: '卡槽号', name: 'position', index: 'position', width: 80 },
			{ label: '当前使用用户', name: 'customer', index: 'customer', width: 80 },
			{ label: '充电宝被借出次数', name: 'borrowCount', index: 'borrow_count', width: 80 },		
			{ label: '充电宝状态', name: 'status', index: 'status', width: 80 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.bankStatus)[value]:"";
			}},
			{ label: '服务商', name: 'agency', index: 'agency', width: 80 }, 
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
        	if(vm.bankStatus.length==0){
	        	$.ajax({
					type: "POST",
				    url: "../dict/BANK_STATUS",
				    success: function(r){
				    	if(r.code === 0){
				    		vm.bankStatus = r.data;
						}else{
							alert(r.msg);
						}
					}
				});
        	}
        	if(vm.models.length==0){
        		$.ajax({
					type: "POST",
				    url: "../dict/queryStationModel",
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
		bankStatus:[],
		models:[],
		powerBank: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.status = "add";
			vm.powerBank = {};
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
			var url = vm.powerBank.id == null ? "../powerbank/save" : "../powerbank/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.powerBank),
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
				    url: "../powerbank/delete",
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
			$.get("../powerbank/info/"+id, function(r){
                vm.powerBank = r.powerBank;
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