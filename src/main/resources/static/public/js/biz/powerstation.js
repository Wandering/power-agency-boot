$(function () {
    $("#jqGrid").jqGrid({
        url: '../powerstation/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '服务商', name: 'agent', index: 'agent', width: 80 }, 			
			{ label: '充电桩ID', name: 'code', index: 'code', width: 80 }, 			
			{ label: '充电桩网点地址', name: 'address', index: 'address', width: 80 }, 			
			{ label: '表region.地点ID(如深圳南山1000103)', name: 'region', index: 'region', width: 80 }, 			
			{ label: '网点地址对应纬度', name: 'latitude', index: 'latitude', width: 80 }, 			
			{ label: '网点地址对应经度', name: 'longitude', index: 'longitude', width: 80 }, 			
			{ label: '维修人员/负责人', name: 'wxUser', index: 'wx_user', width: 80 }, 			
			{ label: '维修人员联系电话', name: 'wxUserPhone', index: 'wx_user_phone', width: 80 }, 			
			{ label: '', name: 'dimensionCode', index: 'dimension_code', width: 80 }, 			
			{ label: '充电桩状态，启用（正常运营） or 禁用 or 审核 ', name: 'status', index: 'status', width: 80 }, 			
			{ label: '', name: 'createDt', index: 'create_dt', width: 80 }, 			
			{ label: '', name: 'updateDt', index: 'update_dt', width: 80 }, 			
			{ label: '生产日期', name: 'productDt', index: 'product_dt', width: 80 }, 			
			{ label: '生产厂家', name: 'productCreator', index: 'product_creator', width: 80 }, 			
			{ label: '充电桩网点名称', name: 'shopName', index: 'shop_name', width: 80 }, 			
			{ label: '充电桩联网方式，wifi GPRS 4G BLE', name: 'connectType', index: 'connect_type', width: 80 }, 			
			{ label: '', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '开始营业时间', name: 'shopStartDt', index: 'shop_start_dt', width: 80 }, 			
			{ label: '结束营业时间', name: 'shopEndDt', index: 'shop_end_dt', width: 80 }, 			
			{ label: '', name: 'activeBankNo', index: 'active_bank_no', width: 80 }, 			
			{ label: '网点联系电话', name: 'shopPhone', index: 'shop_phone', width: 80 }, 			
			{ label: '充电桩在网点的摆放位置，如收银台', name: 'shopStationPoint', index: 'shop_station_point', width: 80 }, 			
			{ label: '收费模式', name: 'feescale', index: 'feescale', width: 80 }, 			
			{ label: '最后编辑人员', name: 'lasteditor', index: 'lastEditor', width: 80 }			
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
		powerStation: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.status = "add";
			vm.powerStation = {};
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
			var url = vm.powerStation.id == null ? "../powerstation/save" : "../powerstation/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.powerStation),
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
				    url: "../powerstation/delete",
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
			$.get("../powerstation/info/"+id, function(r){
                vm.powerStation = r.powerStation;
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