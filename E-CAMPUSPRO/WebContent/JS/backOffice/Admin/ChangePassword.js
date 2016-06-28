$(document).ready(function(){
	
	
$("#save").click(function(){
		
	var selectUser = $("#hUser").val().trim();
	var newpasswrd = 	$("#newpassword").val().trim();
	var confirmpasswrd =	$("#confirmpassword").val().trim();
	
	
	if (newpasswrd.trim() == "") {

		$(".errormessagediv").show();
		$(".validateTips").text("Enter New Password");
		return false;
	 }else if(confirmpasswrd.trim() == ""){
			
		   $(".errormessagediv").show();
			$(".validateTips").text("Enter Confirm Password");
			return false; 
		 
	 }else if( !(newpasswrd.trim() == confirmpasswrd.trim()) ){
		 
		   $(".errormessagediv").show();
			$(".validateTips").text("Password should match with confirm password");
			return false; 
		 
	 }else{
		 
		  $(".errormessagediv").hide();
		 $
			.ajax({
				type : "POST",
				url : "userManagement.html?method=changePassword",
				data :{"selectUser":selectUser,"confirmpasswrd":confirmpasswrd},		
			 	success : function(response) {
			 		
			 	var result = $.parseJSON(response);
			 	
		         if(result.status=="true"){	 	
		        	 
					 $(".successmessagediv").show();
					 $(".successmessage").text("Password Changed Successfully");
					 $("#newpassword").val("");
				   	$("#confirmpassword").val("");
			 	 }else{
			 		 
			 		  $(".errormessagediv").show();
						$(".validateTips").text("Password not changed,Please try again");
						 $("#newpassword").val("");
						   	$("#confirmpassword").val("");
			 	 }
			 	
			 		
		         setTimeout(function(){
					   
					 window.location.href="adminMenu.html?method=getUserRecords";
					
				 
				 },3000);
		         
		         
		         
		         
				}
			});
	
		 return false;
	 }
	
	
});
	
	

	$("#listing").click(function(){
		
		window.location.href="adminMenu.html?method=getUserRecords";
	});
	
	
	
});
