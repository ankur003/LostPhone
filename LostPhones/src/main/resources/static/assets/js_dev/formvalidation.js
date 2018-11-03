

function phonedetailsvalid() {
	var valid = true;
	/*var email = document.getElementById("emp_email").value;*/

	/*var reg = new RegExp("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	if (reg.test(email) == false) {
		document.getElementById('emp_email_error').style.display = "block";
		document.getElementById('emp_email_error').innerHTML = "Please give correct Email";
		valid = false;
	}*/
	if (document.getElementById("name-form1-w").value == '') 
	{
		document.getElementById("imei_error").style.display = "block";
		document.getElementById("imei_error").innerHTML = "Select Title".fontcolor("red");
		valid = false;
		
	}
	/*if (document.getElementById("emp_firstname").value == '') {
		document.getElementById("emp_firstname_error").style.display = "block";
		document.getElementById("emp_firstname_error").innerHTML = "Enter First name";
		valid = false;
	}

	if (document.getElementById("emp_lastname").value == '') {
		document.getElementById("emp_lastname_error").style.display = "block";
		document.getElementById("emp_lastname_error").innerHTML = "Enter Last name";
		valid = false;
	}*/

	return valid;

}
