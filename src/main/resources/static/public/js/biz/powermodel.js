$(function () {
    $("#jqGrid").jqGrid({
        url: '../powermodel/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 30, key: true },
			{ label: '充电宝型号', name: 'model', index: 'model', width: 80 }, 			
			{ label: '电池容量', name: 'capacity', index: 'capacity', width: 80 }, 			
			{ label: '电芯类型', name: 'coreType', index: 'core_type', width: 80 }, 			
			{ label: '输入电流', name: 'inputCurrent', index: 'input_current', width: 80 }, 			
			{ label: '输出电流', name: 'outputCurrent', index: 'output_current', width: 80 }, 			
			{ label: '输入电压', name: 'inputVoltage', index: 'input_voltage', width: 80 }, 			
			{ label: '输出电压', name: 'outputVoltage', index: 'output_voltage', width: 80 }, 			
			{ label: '认证', name: 'authentication', index: 'authentication', width: 80 }, 			
			{ label: '尺寸', name: 'size', index: 'size', width: 80 }, 			
			{ label: 'NFC', name: 'isnfc', index: 'isNFC', width: 80 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.nfcs)[value]:"";
			}}, 			
			{ label: '充电线', name: 'chargeLine', index: 'charge_line', width: 180 }, 			
			{ label: '生产厂家', name: 'manufacturer', index: 'manufacturer', width: 80 }, 			
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
        	if(vm.nfcs.length==0){
	        	$.ajax({
					type: "POST",
				    url: "../dict/ISNFC",
				    async: false,
				    success: function(r){
				    	if(r.code === 0){
				    		vm.nfcs = r.data;
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
		nfcs:[],
		powerModel: {}
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
			vm.powerModel = {};
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
			var url = vm.powerModel.id == null ? "../powermodel/save" : "../powermodel/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.powerModel),
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
				    url: "../powermodel/delete",
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
			$.get("../powermodel/info/"+id, function(r){
                vm.powerModel = r.powerModel;
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