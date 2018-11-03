
function onlyNumbers(e) {

	var keynum="";
	
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	/*keychar = String.fromCharCode(keynum); 
	alert(keychar);*/
	/*var e = event || evt; // for trans-browser compatibility
	var charCode = e.which || e.keyCode;*/

	if (keynum > 31 && (keynum < 48 || keynum > 57)) {
		return false;
	} else {
		return true;
	}
}
function onlyNumbersDot(e){
	var keynum="";
	
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	/*keychar = String.fromCharCode(keynum); 
	alert(keychar);*/
	/*var e = event || evt; // for trans-browser compatibility
	var charCode = e.which || e.keyCode;*/

	if ((keynum  <48 || keynum > 58) && keynum != 46 && keynum!=8) {
		return false;
	} else {
		return true;
	}
}

function onlySpaceDotChars(e) {
	/*
		if (keynum==37 ||keynum == 8|| keynum== 9||keynum == 32||keynum==46 ||(keynum >= 65 && keynum <= 90)
				|| (keynum >= 97 && keynum <= 122)) {
			return true;
		} else {
			return false;
		}*/
		var keynum="";
		
		if (window.event) {
			keynum = e.keyCode;
		}
		else if (e.which) {
			keynum = e.which;
		}
		if ((keynum < 65 || keynum > 90) && (keynum < 97 || keynum > 122) && keynum!=8 && keynum != 9 && keynum != 32 &&( keynum < 45 || keynum >46) && keynum!='') {
			return false;
		} else {
			return true;
		}

	}
function onlySpaceCommChars(e) {
	/*
		if (keynum==37 ||keynum == 8|| keynum== 9||keynum == 32||keynum==46 ||(keynum >= 65 && keynum <= 90)
				|| (keynum >= 97 && keynum <= 122)) {
			return true;
		} else {
			return false;
		}*/
		var keynum="";
		
		if (window.event) {
			keynum = e.keyCode;
		}
		else if (e.which) {
			keynum = e.which;
		}
		if ((keynum < 65 || keynum > 90) && (keynum < 97 || keynum > 122) && (keynum != 44) && keynum!=8 && keynum != 9 && keynum != 32 && keynum!='') {
			return false;
		} else {
			return true;
		}

	}

function restictSpace(e) {

	var keynum="";
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	if (keynum ==32 ) {
		return false;
	} else {
		return true;
	}
}
function onlyalphaNumbers(e) {

	keynum="";
	
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	/*keychar = String.fromCharCode(keynum); 
	alert(keychar);*/
	/*var e = event || evt; // for trans-browser compatibility
	var charCode = e.which || e.keyCode;*/
	if (keynum > 31 && (keynum < 48 || keynum > 57)
			&& (keynum < 65 || keynum > 90) && (keynum < 97 || keynum > 122))
		return false;
	else {
		return true;
	}
}

function restrictSpaceWithoutData(e,id) {

	var keynum="";
	
	if (window.event) {
		keynum = e.keyCode;
	}
	else if (e.which) {
		keynum = e.which;
	}
	if(document.getElementById(id).value.trim() == '' && keynum == 32){
		return false;
	}else{ 
		return true;
		}
	
	}
function onlyChars(e) {

	var keynum="";
	
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	
	if (keynum > 31 && (keynum < 65 || keynum > 90)
			&& (keynum < 97 || keynum > 122)) {
		{
			
		return false;
		}
	} else {

		return true;
	}

}

function onlyNumSpecChar(e) {

	var keynum="";
	
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}

	if (keynum > 31 && (keynum < 48 || keynum > 57)
			&& (keynum < 65 || keynum > 90) && (keynum < 97 || keynum > 122)
			&& keynum != 32 && keynum != 35 && keynum != 58 && keynum != 38
			&& keynum != 40 && keynum != 41 && keynum != 46 && keynum != 64
			&& keynum != 45 && keynum != 91 && keynum != 93 && keynum != 95
			&& keynum != 123 && keynum != 125 && keynum != 44 && keynum != 13) {

		return false;
	} else {
		return true;
	}
}

function onlyDotChar(e) {

	var keynum="";
	
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}

	if (keynum > 31 && (keynum < 65 || keynum > 90) && (keynum != 46) &&(keynum!=32)
			&& (keynum < 97 || keynum > 122)) {
		return false;
	} else {
		return true;
	}
}

function blockBackspace(e) {
	var keynum="";
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	if (keynum == 8) {
		return false;
	} else {
		return true;
	}
}

function restict_commercial(e) {

	keynum="";
	
	if (window.event) {
		keynum = e.keyCode;
	}
	else if (e.which) {
		keynum = e.which;
	}
	if (keynum == 64)
		return false;
	else {
		return true;
	}
}

function onlyChars_spc(e) {

	var keynum="";
	
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	
	if (keynum > 31 &&  (keynum < 65 || keynum > 90)&&(keynum != 32)
			&& (keynum < 97 || keynum > 122)) {
		{
			
		return false;
		}
	} else {

		return true;
	}

}

function only_char_coma(e) {

	var keynum="";
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	
	if (keynum > 31 &&(keynum != 44)&&(keynum != 32) &&(keynum < 65 || keynum > 90)
			&& (keynum < 97 || keynum > 122 )) {
		{
		
		return false;
		}
	} else {

		return true;
	}

}

function only_num_coma_dot_char(e) {

	var keynum="";
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	
	if (keynum > 31 && (keynum < 48 || keynum > 57) &&(keynum != 44)&&(keynum != 32)  &&(keynum != 46)&&(keynum < 65 || keynum > 90)
			&& (keynum < 97 || keynum > 122))
	{
		{
		
		return false;
		}
	} else {

		return true;
	}

}

/*Only cahr and comma allowed*/

function onlyChars_comma(e) {
	var keynum="";
	
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	
	if (keynum > 31 && (keynum < 48 || keynum > 57) && (keynum < 65 || keynum > 90)&&(keynum != 46)&&(keynum != 95)
			&& (keynum < 97 || keynum > 122)) {
		{
			
		return false;
		}
	} else {

		return true;
	}

}


function onlyNumbers_desh(e) {

	var keynum="";
	
	//var numcheck  
	// For Internet Explorer  
	if (window.event) {
		keynum = e.keyCode;
	}
	// For Netscape/Firefox/Opera  
	else if (e.which) {
		keynum = e.which;
	}
	/*keychar = String.fromCharCode(keynum); 
	alert(keychar);*/
	/*var e = event || evt; // for trans-browser compatibility
	var charCode = e.which || e.keyCode;*/

	if (keynum > 31 && (keynum < 48 || keynum > 57)&& keynum != 45) {
		return false;
	} else {
		return true;
	}
}























function hideMessage(divId){
	document.getElementById(divId).style.display="none";
}


function hideLoginMsg(divId,msg,msg1){

	document.getElementById(divId).style.display="none";
	document.getElementById(msg).style.display="none";
	document.getElementById(msg1).style.display="none";
}



function limitText(limitField, limitCount, limitNum) {
	 if (limitField.value.length > limitNum){
	  limitField.value = limitField.value.substring(0, limitNum);
	  
	 } else {
	  limitCount.value = limitNum - limitField.value.length;
	 
	 }
	}
	




function copyExmple(l_id,tb_id){
	document.getElementById(tb_id).value="";
	var exmple = document.getElementById(l_id).innerHTML;
	exmple=exmple.replace("<br>", " ");
	    document.getElementById(tb_id).value=exmple;
}


function setExamplePlaceholder(message,id){
	
	var example=message.split("<br/>").join("\n");
	var txtarea=document.getElementById(id);
	txtarea.placeholder=example;

}




function varifypassword(id,password,uid){
	var array=new Array();	
	array[0]=document.getElementById(password).value;
	array[1]=document.getElementById(id).value;
	var arr = {"ru_id":array[1],"pwd":array[0]};
	if (array[0]!= '')
		{
	$.ajax(
			{
	     url: localurl+"/generic/ver_pwd",
	     type: "POST",
	    data: JSON.stringify(arr),
	    dataType: "json",
	    contentType: "application/json; charset=utf-8",
	    success: function(data){
	    	document.getElementById(uid).value=data.logincredentials;
	    	if(data.logincredentials!=document.getElementById(id).value){
	    		document.getElementById("old_password_error").style.display="block";
	   		    document.getElementById("old_password_error").innerHTML=tnl_correct_old_password;
	    	}
	    	else{
	    		//alert("Technical Problem");
	    	}
	    	},
	    failure: function(errMsg) {
	        alert(errMsg);
	    }
	});}
	
}

function activedeactive(){
	var valid=true;
	if(document.getElementById("password").value == ""){
		document.getElementById("password_error").style.display="block";
		document.getElementById("password_error").innerHTML=tnl_correct_old_password;
		 valid=false;
	}else{
		if(document.getElementById("ru_id").value!=document.getElementById("ur_id").value){
    		document.getElementById("password_error").style.display="block";
   		    document.getElementById("password_error").innerHTML=tnl_correct_old_password;
   		 valid=false;
    	}
	}
	return valid;
}
function getId(url) {
    var regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|\&v=)([^#\&\?]*).*/;
    var match = url.match(regExp);

    if (match && match[2].length == 11) {
        return match[2];
    } else {
        return 'error';
    }
}
















