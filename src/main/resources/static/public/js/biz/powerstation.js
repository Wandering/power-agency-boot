$(function () {
    $("#jqGrid").jqGrid({
        url: '../powerstation/list',
        datatype: "json",
        colModel: [			
			//{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '网点名称', name: 'shopName', index: 'shop_name' },
			{ label: '充电桩IMEI号', name: 'code', index: 'code'}, 			
			{ label: '网点地址', name: 'address', index: 'address' , width: 250}, 			
			{ label: '营业时间', name: 'shopStartDt', index: 'shop_start_dt' ,formatter: function(value, options, row){
				return vm.getTime(row.shopStartDt)+"-"+vm.getTime(row.shopEndDt);
			}}, 		
			{ label: '收费模式', name: 'feescale', index: 'feescale' ,formatter: function(value, options, row){
				for(var i in vm.models){if(vm.models[i].id==value){value=vm.models[i].name}};return value;
			}}, 
			{ label: '摆放位置', name: 'shopStationPoint', index: 'shop_station_point' },
			{ label: '网点联系电话', name: 'shopPhone', index: 'shop_phone' },
			{ label: '负责人', name: 'wxUser', index: 'wx_user' , width: 110}, 			
			{ label: '联系电话', name: 'wxUserPhone', index: 'wx_user_phone' , width: 110 },
			{ label: '状态 ', name: 'status', index: 'status' , width: 110,formatter: function(value, options, row){
				return value!=null?getDict(vm.s_status)[value]:"";
			}},
			{ label: '最后编辑人员', name: 'lasteditor', index: 'lastEditor' , width: 115},
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
        multiselect: true,
        shrinkToFit:false,  
        autowidth:true,
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
        	//$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-y" : "hidden" }); 
        	$('#demo').citys({
        		code:vm.powerStation.region,onChange:function(data){
        			vm.powerStation.region = data.code;
        		}
        	});
        }
    });
    
    new AjaxUpload('#upload', {
        action: '../sys/oss/Station/Imgupload',
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.code == 0){
                vm.addImg(r.url);
            }else{
                alert(r.msg);
            }
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
		geolocation:null,
		placeSearch:null,
		showList: true,
		title: null,
		status:null,
		channels:[],
		models:[],
		stations:[],
		s_status:[],
		pictures:[],
		delStatus:false,
		powerStation: {region:"440300"}
	},
	mounted: function(){
		var bodywidth = $(document.body).width();
		$(".grid-btn").css("width",bodywidth);
		this.map = new AMap.Map('mapViewContainer', {
			resizeEnable: true,
             zoom: 11
		});
		var that = this;
		 this.map.plugin('AMap.Geolocation', function() {
			 that.geolocation = new AMap.Geolocation({
	            enableHighAccuracy: true,//是否使用高精度定位，默认:true
	            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
	            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
	            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
	            buttonPosition:'LB'
	        });
	        that.map.addControl(that.geolocation);
	        //that.geolocation.getCurrentPosition();
	        AMap.event.addListener(that.geolocation, 'complete', that.onComplete);//返回定位信息
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
			vm.pictures = [];
			vm.powerStation.region = "440300";
			vm.map.clearMap();
			vm.geolocation.getCurrentPosition();
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
			if(vm.pictures!=''){vm.powerStation.pictures=JSON.stringify(vm.pictures)}else{vm.powerStation.pictures=null}
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
                $('#demo').citys({
            		code:r.powerStation.region,onChange:function(data){
            			vm.powerStation.region = data.code;
            		}
            	});
                if(r.powerStation.pictures==null){vm.pictures=[]}else{
                	vm.pictures = eval(r.powerStation.pictures);
                }
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
		getTime: function(num){
			var min = Math.ceil((num-num.toFixed(0))*60);
			min = min<= 9 ? "0"+min : min;
			return num.toFixed(0)+":"+min;
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
		onComplete: function(data) {
	        vm.powerStation.latitude = data.position.getLat();
	    	vm.powerStation.longitude = data.position.getLng();
	    	vm.powerStation.address = data.formattedAddress;
	    	$("input[id='shopLocationId']").val(data.formattedAddress);
	    },
		addMarker: function(longitude, latitude) {
	        vm.map.setZoomAndCenter(14, [longitude, latitude]);
	        // 在新中心点添加 marker 
	        var marker = new AMap.Marker({
	            map: vm.map,
	            position: [longitude, latitude]
	        });
		},
		setStation: function(state){
			var id = getSelectedRow();
			if(id == null){
				return ;
			}else{
				switch(state){
					case 0:vm.powerStation={id:id,status:'ENABLE'} ; break;
					case 1:vm.powerStation={id:id,status:'DISABLE'} ; break;
				}
				$.ajax({
					type: "POST",
				    url: "../powerstation/update",
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
			}
		},
		showImg: function(url){
			var photos = {
	    	  "title": "", //相册标题
	    	  "id": 123, //相册id
	    	  "start": 0, //初始显示的图片序号，默认0
	    	  "data": [{   //相册包含的图片，数组格式
	    	      "alt": "图片名","src": url, //原图地址
	    	  }]
	    	}
			for(var i=0;i<vm.pictures.length;i++){
				if(vm.pictures[i].img==url){
					if(vm.delStatus){vm.pictures.splice(i,1);return;}
				}else{
					photos.data.push({
		    	      "alt": "图片名", "src": vm.pictures[i].img, //原图地址
		    	    })
				}
			}
			layer.photos({
			    photos: photos,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
			});
		},
		addImg: function(url){
			vm.pictures.push({img:url});
		},
		deleteImg: function(){
			vm.delStatus = true;
			layer.open({
			  type: 1,
			  title: false,
			  closeBtn: 0,
			  shade: 0.8,
			  skin: 'layui-layer-nobg', //没有背景色
			  shadeClose: true,
			  content: $('#photos-box'),
			  end: function(){
				  vm.delStatus = false; 
			  }
			});
		}
	}
});