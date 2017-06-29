$(function () {
    $("#jqGrid").jqGrid({
        url: '../powererrortype/list',
        datatype: "json",
        colModel: [			
			//{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '错误码', name: 'code', index: 'code', width: 80 }, 			
			{ label: '异常所属设备', name: 'deviceType', index: 'device_type', width: 80 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.deviceTypes)[value]:"";
			}}, 			
			{ label: '故障类别', name: 'type', index: 'type', width: 80 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.errorTypes)[value]:"";
			}}, 		
			{ label: '故障等级', name: 'lv', index: 'lv', width: 80 },
			{ label: '故障描述', name: 'note', index: 'note', width: 280 }			
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
        	if(vm.deviceTypes.length==0){
        		$.ajax({
					type: "POST",
				    url: "../dict/DEVICE_TYPE",
				    success: function(r){
				    	if(r.code === 0){
				    		vm.deviceTypes = r.data;
						}else{
							alert(r.msg);
						}
					}
				});
        	}
        	if(vm.errorTypes.length==0){
        		$.ajax({
					type: "POST",
				    url: "../dict/POWER_ERROR_TYPE",
				    success: function(r){
				    	if(r.code === 0){
				    		vm.errorTypes = r.data;
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
			deviceType:"",
			type:""
		},
		showList: true,
		title: null,
		status:null,
		deviceTypes:[],
		errorTypes:[],
		powerErrorType: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.status = "add";
			vm.powerErrorType = {};
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
			var url = vm.powerErrorType.id == null ? "../powererrortype/save" : "../powererrortype/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.powerErrorType),
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
				    url: "../powererrortype/delete",
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
			$.get("../powererrortype/info/"+id, function(r){
                vm.powerErrorType = r.powerErrorType;
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