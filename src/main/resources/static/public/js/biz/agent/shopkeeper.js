$(function () {
    $("#jqGrid").jqGrid({
        url: '../../agencies/list',
        postData:vm.q,
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户名', name: 'username', index: 'username', width: 120 }, 			
			{ label: '邮箱', name: 'email', index: 'email', width: 120 },
			{ label: '角色', name: 'agencyrole', index: 'agencyrole', width: 80 },
			{ label: '合同开始时间', name: 'contractStartdt', index: 'contract_startDt', width: 100 ,formatter: function(value, options, row){
				return  value!=null?vm.parseDate(value):"";
			}}, 			
			{ label: '合同结束时间', name: 'contractEnddt', index: 'contract_endDt', width: 100 ,formatter: function(value, options, row){
				return  value!=null?vm.parseDate(value):"";
			}},
			//{ label: '地域', name: 'region', index: 'region', width: 80 }, 			
			//{ label: '区域', name: 'address', index: 'address', width: 150 }, 			
			//{ label: '类型', name: 'type', index: 'type', width: 80 },
			//{ label: '性质', name: 'type', index: 'type', width: 80 },
			{ label: '企业名称', name: 'name', index: 'name', width: 80 },
			{ label: '营业执照注册号', name: 'businessNo', index: 'business_no', width: 80 }, 			
			{ label: '营业执照副本', name: 'businessImg', index: 'business_img', width: 80 },
			{ label: '法人姓名', name: 'legaluserName', index: 'legaluser_name', width: 80 }, 			
			{ label: '法人身份证号', name: 'legaluserNo', index: 'legaluser_no', width: 80 }, 			
			{ label: '法人身份证扫描件', name: 'legaluserImg', index: 'legaluser_img', width: 80 },
			{ label: '开户名称', name: 'bankname', index: 'bankname', width: 80 }, 
			{ label: '开户银行', name: 'openBank', index: 'open_bank', width: 80 }, 			
			{ label: '银行卡号', name: 'bankCardno', index: 'bank_cardno', width: 80 }, 
			{ label: '父级ID', name: 'parent', index: 'parent', width: 80 },
			//{ label: '推广二维码', name: 'qrcode', index: 'qrcode', width: 80 },
			{ label: '申请时间', name: 'createDt', index: 'create_dt', width: 80 }, 
			{ label: '通过审核时间', name: 'examineDt', index: 'examine_dt', width: 80 },
			{ label: '最后登录IP', name: 'sysLogList', index: 'sysLogList' ,formatter: function(value, options, row){
				return value.length>0?value[0].ip:"";
			}},
			{ label: '最后登录时间', name: 'sysLogList', index: 'sysLogList' ,formatter: function(value, options, row){
				return value.length>0?value[0].create_date:"";
			}},
			{ label: '状态', name: 'status', index: 'status', width: 80 },
			{ label: '访问次数', name: 'sysLogList', index: 'sysLogList' ,formatter: function(value, options, row){
				return value.length>0?value.length:0;
			}},
			//{ label: '修改时间', name: 'updateDt', index: 'update_dt', width: 80 }, 			
			//{ label: '创建人', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '修改人', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '代理商类型', name: 'agencytype', index: 'agencytype', width: 80 }		
			 			
			
			
						
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        shrinkToFit:false, 
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
        	//$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			type:"SHOP",status:"2",name:""
		},
		showList: true,
		title: null,
		status:null,
		username:"",
		Startdt:"",
		password:"",
		agencies: {}
	},
	mounted: function(){
		var bodywidth = $(document.body).width();
		$(".grid-btn").css("width",bodywidth);
	},
	methods: {
		query: function () {
			$("#jqGrid").jqGrid('setGridParam',{page:1});
			vm.reload();
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			var rowData = $("#jqGrid").jqGrid('getRowData',id);
			vm.username = rowData.username;
			vm.password = "";
			vm.showList = false;
            vm.title = "编辑";
            vm.status = "edit";
            $('#endTime').datetimepicker({autoclose:true,language:'zh-CN',minView:2,format:'yyyy-mm-dd',startDate:rowData.contractStartdt});
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			if($('#endTime').val()==""){alert('请输入合同结束时间！');return;}else{
				vm.agencies.contractEnddt = $('#endTime').val()+" 23:59:59";
			}
			if(vm.password==""){alert('请输入登录密码！');return;}
			$.getJSON("../../sys/user/checkPwd?password="+vm.password, function(r){
				if(r.code==0){
					var url =  "../../agencies/update";
					$.ajax({
						type: "POST",
					    url: url,
					    contentType: "application/json",
					    data: JSON.stringify(vm.agencies),
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
				}else{alert(r.msg);}
			});
		},
		getInfo: function(id){
			$.get("../../agencies/info/"+id, function(r){
                vm.agencies = r.agencies;
                vm.Startdt = vm.parseDate(r.agencies.contractStartdt);
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
		parseDate: function(value){
			if(value==null||value==""){return "";}
			return new Date(value).format("yyyy-MM-dd");
		}
	}
});