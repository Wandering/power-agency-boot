$(function () {
    $("#jqGrid").jqGrid({
        url: '../poweruseracounts/list',
        datatype: "json",
        colModel: [			
			{ label: '用户id', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '用户余额', name: 'balance', index: 'balance', width: 80 }, 			
			{ label: '用户会员级别', name: 'roles', index: 'roles', width: 80 },
			{ label: '用户信用分', name: 'credit', index: 'credit', width: 80 }, 			
			{ label: '进行中借电费', name: 'user_id', index: 'userId', width: 80 }, 			
			{ label: '结余', name: 'endbalance', index: 'endbalance', width: 80 },
			
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
		q:{
			userId: null
		},
		showList: true,
		title:null,
		accout:{}
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
			vm.poweruseracounts = {};
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
		
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../poweruseracounts/delete",
				    contentType: "application/json",
				    data: JSON.stringify(userId),
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
			$.get("../poweruseracounts/info/"+id, function(r){
                vm.poweruseracounts = r.poweruseracounts;
            });
		},
		  reload: function (event) {
		    	vm.showList = true;
				var page = $("#jqGrid").jqGrid('getGridParam','page');
				$("#jqGrid").jqGrid('setGridParam',{ 
	                postData:{'userId': vm.q.userId},
	                page:page
	            }).trigger("reloadGrid");
			}
	}
});