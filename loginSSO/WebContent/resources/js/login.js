var contEnter = 0;

$(document).ready(function(){
	$(PF('tmpUsername').jqId).val($('#username').val());
	$(PF('tmpPassword').jqId).val($('#password').val());
});

$(document).keyup(function(e){
    if(e.keyCode == 13){
    	
    	if($(PF('tmpUsername').jqId).val() === ''){
    		$(PF('tmpUsername').jqId).focus();
    	}else if ($(PF('tmpPassword').jqId).val() === '' && contEnter === 0){
    		$(PF('tmpPassword').jqId).focus();
    		contEnter++;
    	} else {
    		contEnter = 0;
    		doLogin();
    	}
    }
});

function doLogin(){
	$('#username').val($(PF('tmpUsername').jqId).val());
	$('#password').val($(PF('tmpPassword').jqId).val());
	$('#hiddenForm').submit();
}

