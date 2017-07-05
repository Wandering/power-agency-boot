$(function () {
    $("#jqGrid").jqGrid({
        url: '../powerdynamicparams/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '参数类型', name: 'category', index: 'category', width: 80 }, 			
			{ label: '参数名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '字符类型', name: 'type', index: 'type', width: 80 }, 			
			{ label: '具体数值', name: 'value', index: 'value', width: 280 },
			{ label: '该参数允许被编码', name: 'code', index: 'code', width: 50 }
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
		powerDynamicParams: {}
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
			vm.powerDynamicParams = {};
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
			var url = vm.powerDynamicParams.id == null ? "../powerdynamicparams/save" : "../powerdynamicparams/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.powerDynamicParams),
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
				    url: "../powerdynamicparams/delete",
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
			$.get("../powerdynamicparams/info/"+id, function(r){
                vm.powerDynamicParams = r.powerDynamicParams;
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