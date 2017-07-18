$(function () {
    $("#jqGrid").jqGrid({
        url: '../userInfo/list',
        datatype: "json",
        postData:vm.q,
        colModel: [			
			{ label: '用户Id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '昵称', name: 'nickname', index: 'nickname', width: 80 },
			{ label: 'openId', name: 'openId', index: 'openId', width: 140 },
			{ label: '头像', name: 'headimgurl', index: 'headimgurl', width: 80 ,formatter: function(value, options, row){
				var imgStr = "<img src='"+value+"' height='20'/>";
				return imgStr;
			}},
			{ label: '是否关注', name: 'status', index: 'status', width: 80 ,formatter: function(value, options, row){
				return value==1?"是":"否";
			}},
			{ label: '性别', name: 'sex', index: 'sex', width: 80 },
			{ label: '国家', name: 'country', index: 'country', width: 80 },
			{ label: '省份', name: 'province', index: 'province', width: 80 },		
			{ label: '城市', name: 'city', index: 'city', width: 80 },
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
			userId:"",agencyId:""
		},
		showList: true,
		title: null,
		status:null,
	},
	methods: {
		query: function () {
			$("#jqGrid").jqGrid('setGridParam',{page:1});
			vm.reload();
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