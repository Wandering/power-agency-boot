$(function () {
	$.ajax({
		type: "POST",
	    url: "../questionNaire/"+vm.id,
	    success: function(r){
	    	if(r.code === 0){
	    		vm.qndata = r.data;
			}else{
				alert(r.msg);
			}
		}
	});
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		id : 1,
		qndata:null,
	},
	methods: {
		
	}
});