$(function () {
    $("#jqGrid").jqGrid({
        url: '../powerstation/list',
        datatype: "json",
        colModel: [			
			//{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '网点名称', name: 'shopName', index: 'shop_name', width: 80 },
			{ label: '充电桩IMEI号', name: 'code', index: 'code', width: 80 }, 			
			{ label: '网点地址', name: 'address', index: 'address', width: 80 }, 			
			{ label: '开始营业时间', name: 'shopStartDt', index: 'shop_start_dt', width: 80 }, 			
			{ label: '结束营业时间', name: 'shopEndDt', index: 'shop_end_dt', width: 80 }, 	
			{ label: '收费模式', name: 'feescale', index: 'feescale', width: 80 ,formatter: function(value, options, row){
				for(var i in vm.models){if(vm.models[i].id==value){value=vm.models[i].name}};return value;
			}}, 
			{ label: '摆放位置', name: 'shopStationPoint', index: 'shop_station_point', width: 80 },
			{ label: '网点联系电话', name: 'shopPhone', index: 'shop_phone', width: 80 },
			{ label: '负责人', name: 'wxUser', index: 'wx_user', width: 80 }, 			
			{ label: '联系电话', name: 'wxUserPhone', index: 'wx_user_phone', width: 80 },
			{ label: '状态 ', name: 'status', index: 'status', width: 80 ,formatter: function(value, options, row){
				return value!=null?getDict(vm.s_status)[value]:"";
			}},
			{ label: '最后编辑人员', name: 'lasteditor', index: 'lastEditor', width: 80 },
			/*{ label: '', name: 'dimensionCode', index: 'dimension_code', width: 80 }, 
			{ label: '表region.地点ID(如深圳南山1000103)', name: 'region', index: 'region', width: 80 },
			{ label: '网点地址对应纬度', name: 'latitude', index: 'latitude', width: 80 }, 			
			{ label: '网点地址对应经度', name: 'longitude', index: 'longitude', width: 80 },
			{ label: '', name: 'createDt', index: 'create_dt', width: 80 }, 			
			{ label: '', name: 'updateDt', index: 'update_dt', width: 80 }, 			
			{ label: '生产日期', name: 'productDt', index: 'product_dt', width: 80 }, 			
			{ label: '生产厂家', name: 'productCreator', index: 'product_creator', width: 80 }, 			
			{ label: '充电桩联网方式，wifi GPRS 4G BLE', name: 'connectType', index: 'connect_type', width: 80 }, 			
			{ label: '', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '', name: 'activeBankNo', index: 'active_bank_no', width: 80 }, 			
			{ label: '服务商', name: 'agent', index: 'agent', width: 80 }*/
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
        	if(vm.channels.length==0){
        		$.ajax({
					type: "POST",
				    url: "../dict/STATION_CHANNEL",
				    async: false,
				    success: function(r){
				    	if(r.code === 0){
				    		vm.channels = r.data;
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
        	if(vm.s_status.length==0){
        		$.ajax({
					type: "POST",
				    url: "../dict/STATION_POS_STATUS",
				    async: false,
				    success: function(r){
				    	if(r.code === 0){
				    		vm.s_status = r.data;
						}else{alert(r.msg);}
					}
				});
        	}
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        	$('#demo').citys({
        		code:vm.powerStation.region,onChange:function(data){
        			vm.powerStation.region = data.code;
        		}
        	});
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			shopName:"",code:"",feescale:""
		},
		map:null,
		placeSearch:null,
		showList: true,
		title: null,
		status:null,
		channels:[],
		models:[],
		stations:[],
		s_status:[],
		powerStation: {region:"440300"}
	},
	mounted: function(){
		this.map = new AMap.Map('mapViewContainer', {
			resizeEnable: false,
             zoom: 11,
             scrollWheel:false,
		});
	    this.$watch("powerStation.latitude", function(){
	    	this.addMarker(this.powerStation.longitude, this.powerStation.latitude);
		});
	    this.$watch("powerStation.region", function(){
		    var autoOptions = {
		    	city: this.powerStation.region,
		        input: "shopLocationId"
		    };
		    var auto = new AMap.Autocomplete(autoOptions);//输入提示
		    this.placeSearch = new AMap.PlaceSearch({//构造地点查询类
		        map: this.map
		    });
		    AMap.event.addListener(auto, "select", this.select);//注册监听，当选中某条记录时会触发
	    });
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
			vm.powerStation = {};
			vm.powerStation.region = "440300";
			vm.map.clearMap();
			vm.requestStations();
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.status = "edit";
            vm.map.clearMap();
            vm.requestStations();
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
				postData:vm.q,
                page:page
            }).trigger("reloadGrid");
		},
		requestStations: function(){
			$.ajax({
				type: "POST",
			    url: "../dict/queryStations",
			    success: function(r){
			    	if(r.code === 0){
			    		vm.stations = r.data;
					}else{alert(r.msg);}
				}
			});
		},
		selectcode: function(){
			for(i in vm.stations){ 
				if(vm.powerStation.code==vm.stations[i].code){
					vm.powerStation.connectType = vm.stations[i].channel
					if(vm.status=='add'){
						$("select[name='channel']").val(vm.stations[i].channel);
					}
				}
			}
		},
		select: function(e){
			if(e.poi.location==undefined){alert("找不到该地址！");return;}
			vm.powerStation.address = e.poi.name;
			vm.powerStation.latitude = e.poi.location.lat;
	    	vm.powerStation.longitude = e.poi.location.lng;
	    	vm.placeSearch.setCity(e.poi.adcode);
	    	vm.placeSearch.search(e.poi.name);  //关键字查询查询
		},
		addMarker: function(longitude, latitude) {
	        vm.map.setZoomAndCenter(14, [longitude, latitude]);
	        // 在新中心点添加 marker 
	        var marker = new AMap.Marker({
	            map: vm.map,
	            position: [longitude, latitude]
	        });
		}
	}
});