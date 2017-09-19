$(function () {


	new AjaxUpload('#uploadBiz', {
        action: '../sys/oss/Agency/Imgupload',
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
            vm.agencies.businessImg = 'text0.jpg';
            return false;
        },
        onComplete : function(file, r){
            if(r.code == 0){
            	vm.agencies.businessImg = r.url;
            }else{
                alert(r.msg);
            }
        }
    });
	
	new AjaxUpload('#uploadID', {
        action: '../sys/oss/Agency/Imgupload',
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
            vm.agencies.legaluserImg = 'text1.jpg';
            return false;
        },
        onComplete : function(file, r){
            if(r.code == 0){
            	vm.agencies.legaluserImg = r.url;
            }else{
                alert(r.msg);
            }
        }
    });
})

var vm = new Vue({
    el:'#app',
    data:{
    	showinfo:"",
    	status:"",
        active:0,
        basic:1,
        bankCardno:"",
        recommend:null,
        recommendId:null,
        agencies:{}
    },
    created: function(){
    	$.get("../agencies/checkStatus", function(r){
            if(r.code==0){//判断显示内容：是否注册 审核是否通过
            	if(r.status==0){//未提交代理商信息
            		vm.showinfo=true;
            	}else if(r.status=='3'){//未通过审核
            		vm.showinfo=true;vm.status=r.status;vm.agencies=r.agencies;
            		if(vm.agencies.parent==1){
            			vm.recommend=vm.agencies.parent
            		}else{
            			vm.recommend=0;vm.recommendId=vm.agencies.parent;
            		}
            		$("input[name='recommend']").attr("disabled","disabled");
            	}else{vm.status=r.status;}//待审核审核
            }else{vm.showinfo=false;}//不用提交代理商信息
        });
    },
    methods:{
    	deleNterprise(){
    		vm.active = 1;
    		vm.basic = 2;
	    },
	    deleIndividual(){
	    	vm.active = 2;
	        vm.basic = 2;
	    },
	    shopkeeper(){
	    	vm.active = 3;
	    	vm.basic = 2;
	    },
	    previousStep(){
            switch(vm.basic){
          	  case 2: 
          		vm.basic = 1;$(".st-error").html("");
          	  break;
          	  case 3: 
          		vm.basic = 2;
          	  break;
            }
	    },
	    nextStep(){
	    	//判断选择代理商还是店主
	    	if(vm.active!=2){//代理商公司和店主
	    		if(//校验输入
                    eles.agencyname.validator( eles.norm_agencyname, eles.err1, eles.errTxt1 ) ||
                    eles.registrationnum.validator( eles.norm_registrationnum, eles.err2, eles.errTxt2 ) ||
                    eles.userbank.validator( eles.norm_userbank, eles.err3, eles.errTxt3 ) ||
                    eles.bankname.validator( eles.norm_bankname, eles.err4, eles.errTxt4 ) ||
                    eles.accountnum.validator( eles.norm_accountnum, eles.err5, eles.errTxt5 ) ||
                    eles.repeataccountnum.validator( eles.norm_repeataccountnum, eles.err6, eles.errTxt6 ) ||
                    eles.corporate.validator( eles.norm_corporate, eles.err7, eles.errTxt7 ) ||
                    eles.corporateidentity.validator( eles.norm_corporateidentity, eles.err8, eles.errTxt8 )
                ){
	    			if(vm.active==1){vm.agencies.type="AGENCY"}else if(vm.active==3){vm.agencies.type="SHOP";};
	    			if(vm.agencies.businessImg==undefined){alert("请上传营业执照注册号");return;};
	    			if(vm.agencies.legaluserImg==undefined){alert("请上传法人身份证扫描件");return;};
	    			console.log(vm.agencies)
	    			vm.basic = 3;
    	    	}
	    	}else{//代理商个人
	    		if(//校验输入
                    eles.corporate.validator( eles.norm_corporate, eles.err7, eles.errTxt7 ) ||
                    eles.corporateidentity.validator( eles.norm_corporateidentity, eles.err8, eles.errTxt8 ) ||
                    eles.companybankname.validator(eles.norm_companybankname,eles.err9,eles.errTxt9) ||
                    eles.companyacc.validator(eles.norm_companyacc,eles.err10,eles.errTxt10) ||
                    eles.againcompanyacc.validator(eles.norm_againcompanyacc,eles.err11,eles.errTxt11)
                ){
	    			vm.agencies.type="AGENCY";
	    			if(vm.agencies.legaluserImg==undefined){alert("请上传法人身份证扫描件");return;};
	    			if(vm.agencies.businessNo!=undefined){vm.agencies.businessNo=null;}
	    			if(vm.agencies.businessImg!=undefined){vm.agencies.businessImg=null;}
	    			vm.agencies.name=vm.agencies.legaluserName;
	    			vm.agencies.bankname=vm.agencies.legaluserName;
	    			console.log(vm.agencies)
	    			vm.basic = 3;
    	    	}
	    	}
	    	
	    	 
	    },
        subAngency(){
        	if(vm.recommend==0){
        		vm.agencies.parent=vm.recommendId;
        	}else{
        		vm.agencies.parent=1;
        	}
        	console.log(vm.agencies);
        	var url = vm.status==3 ? "../../agencies/update" : "../../agencies/save";
        	if(vm.status==3){vm.agencies.status=1}
        	$.ajax({
				type: "POST",
			    url: url ,
			    contentType: "application/json",
			    data: JSON.stringify(vm.agencies),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功');
						vm.showinfo="";vm.status=1;
					}else{
						alert(r.msg);
					}
				}
			});
        },
    },
});
