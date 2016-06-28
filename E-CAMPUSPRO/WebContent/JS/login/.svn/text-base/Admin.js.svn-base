$(document).ready(function() {
	
	$(".loginTips").hide();
	
	
	var UserName = $('#usernamehidden').val();
	if (UserName != 'null') {
		$('#adminname').text(UserName);
	} else {
		window.location.href = "index.jsp";
	}

	$('.ui-x .ui-collapse .ui-close').click(function(e) {
		e.preventDefault();
		$(this).parents(".ui-collapse").css("display", "none");
	});

	$('button.close').click(function(e) {
		$("#myModal").css('display', 'none');
		$("#myModal").attr('class', 'modal fade');
		$("#myModal").attr('aria-hidden', 'true');
		$(".parentDisable").css('display', 'none');
	});
});

function validateFields() {
	
	
	var UserName = $("#user_name").val();
	var password = $("#user_password").val();


	if (UserName == '') {

		$(".loginTips").show();
		$(".loginTips").html("Enter Username ");
		
		return false;
	}else
	if (password == '') {
		
		$(".loginTips").show();
		$(".loginTips").html("Enter Password");
		
		return false;
		
	} else
	if(checkuser(UserName,password)){
		
		$(".loginTips").show();
		$(".loginTips").html("Enter valid username and password ");
		
		return false;
		
	}else{
		
		$(".loginTips").hide();
		return true;
	
	}
	
	
}

function  checkuser(username,password){
	
	
	var flag=false;
	
	var UserDetails={
			
			"UserName" : username,
			"password" : password
		};
		
		$.ajax({
			type : "POST",
			url : "login.html?method=checkValidateuser",
			data : UserDetails,
			async : false,
			success : function(data) {
				
				var response = $.parseJSON(data);
				
				if(response.Status==null || response.Status.trim()==""){
					
					$(".loginTips").show();
					$(".loginTips").html("Enter valid username and password ");
				
					flag=true;
					
				}
				
				}
			
		});
		return flag;
}



function gotoRespectiveLogin() {
	
	$(window.location).attr('href', 'login.html?method=login');

	/*var login_type = $("#usertypehidden").val().trim();

	if (login_type == 'Admin') {
		$(window.location).attr('href', 'login.html?method=login');
	}
	if (login_type == 'Teacher') {
		$(window.location).attr('href', 'login.html?method=teacherLogin');
	}
	if (login_type == 'Parent') {
		$(window.location).attr('href', 'login.html?method=parentLogin');
	}
	if (login_type == 'Principle') {
		$(window.location).attr('href', 'login.html?method=principleLogin');
	}*/
}

function gotoLogout() {
	$(window.location).attr('href', 'login.html?method=logout');
}

function changePassword() {

	var oldPassword = $("#oldpassword").val();
	var newPassword = $("#newPassword").val();
	var confirmPassword = $("#confirmPassword").val();

	if (oldPassword.trim() == "") {

		$(".errormessagediv1").show();
		$(".validateTips").text("Enter Old Password");

	} else if (newPassword.trim() == "") {

		$(".errormessagediv1").show();
		$(".validateTips").text("Enter New Password");

	} else if (confirmPassword.trim() == "") {

		$(".errormessagediv1").show();
		$(".validateTips").text("Enter Confirm Password");

	} else if (newPassword.trim() != confirmPassword.trim()) {
		$(".errormessagediv1").show();
		$(".validateTips").text(
				"New password and Confirmed password should be same");

	} else if (checkCurrentPassword() == "false") {

		$(".errormessagediv1").show();
		$(".validateTips").text("Enter Correct Old Password");

	} else {

		$(".errormessagediv1").hide();

		var passwordDetails = {
			"oldPassword" : oldPassword,
			"newPassword" : newPassword,
			"confirmPassword" : confirmPassword
		};
		$.ajax({
			type : 'POST',
			url : 'login.html?method=changePassword',
			data : passwordDetails,
			async : false,
			success : function(response) {

				var data = $.parseJSON(response);

				if (data.status == "true") {

					$(".successmessagediv").show();
					$("#sucessmessage").text("PassWord Changed Successfully");

					setTimeout("removeMessage()", 3000);

				}
			}
		});
	}
}

function checkCurrentPassword() {

	var status1 = null;

	var currentPassword = {
		"oldPassword" : $("#oldpassword").val()
	};
	$.ajax({
		type : 'POST',
		url : 'login.html?method=checkCurrentPassword',
		data : currentPassword,
		async : false,
		success : function(response) {

			var data = $.parseJSON(response);

			status1 = data.status;

		}
	});

	return status1;
}

function removeMessage() {

	location.reload();
}

function opendialog(type) {
	if (type == 'admin') {
		$("#myModal").css('display', 'block');
		$("#myModal").attr('class', 'modal fade in');
		$("#myModal").attr('aria-hidden', 'false');
		$(".parentDisable").css('display', 'block');
	}
}
function closeDialog() {
	location.reload();
}