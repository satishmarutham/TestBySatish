function callAjax(urlWithMethod, dataToBeSend) {
	var jsonResult = "";
	try {
		$.ajax({
			type : "GET",
			url : urlWithMethod,
			data : dataToBeSend,
			async : false,
			success : function(data) {
				var result = $.parseJSON(data);

				jsonResult = result.teacherdetails;

			}
		});
	} catch (e) {
		jsonResult = "";
	}
	return jsonResult;
}





$(document).ready(function() {
	
	
	var hserachText = $("#hsearchTextId").val();
	var htype = $("#htype").val();
		
		if(htype!=""){
			
			$("#typename option[value="+htype+"]").attr('selected','true');
			
		}
		
	    if(hserachText!=""){
			
	    	$("#searchTextId").val(hserachText);
			
		}


 $("#searchButtonId").click(function() {
	
			var type=$("#typename").val();
			
			var searchText = $("#searchTextId")	.val();
			
			if(type== "" || undefined){
				 
				    $(".errormessagediv").show();
					$(".validateTips").text("Select Type");
					return false; 
				
				
			}else if(searchText== "" || undefined){
				
				  $(".errormessagediv").show();
					$(".validateTips").text("Enter Name");
					return false; 
			
			
			}else{
				
				 $(".errormessagediv").hide();
				
				window.location.href = "adminMenu.html?method=getUserRecords&searchText="+ searchText+"&type="+ type;

			}
			
			
			


});

 
 
 	$('#Edit').click(function() {
		
		
			var count = 0;
			var user_Code = null;

			$('input[name="userid"]:checked').each(function() {
				count = count + 1;
				user_Code = this.value;
			});
			
	
			if (count > 1 || count == 0) {
				
				$('.errormessagediv').show();
				$('.validateTips').text("Select Any User");

				return false;
			} else {
				$('.errormessagediv').hide();
				
				window.location.href="userManagement.html?method=changePasswordHome&userId="+user_Code;
				
				
			}
			
					
	});
 	
 	
	$('#excelDownload')
	.click(
			function() {
				
				var hsearchTextId=$("#hsearchTextId").val();
				var type=$("#htype").val();
				
				
				window.location.href = 'userManagement.html?method=downloaduserManagementXLS&searchterm='+hsearchTextId+"&type="+ type;
				
				
				
				
				
				
				
				
				
				
				
			});
	$("#pdfDownload").click(function(){
		var hsearchTextId=$("#hsearchTextId").val();
		var type=$("#htype").val();
		
		window.location.href = "userManagement.html?method=downloaduserManagementPDF&searchterm="+hsearchTextId+"&type="+ type;
			
	});
		
 	
 	$('#delete').click(function() {
		
 		
		var count = 0;
		var user_Code = null;

		$('input[name="userid"]:checked').each(function() {
			count = count + 1;
			user_Code = this.value;
		});
		

		if (count > 1 || count == 0) {
			
			$('.errormessagediv').show();
			$('.validateTips').text("Select Any User");

		
		} else {
			
			$('.errormessagediv').hide();
			var flag =confirm("Are you sure to block the selected user");
		
			if(flag){
			
			var user = {
					"userId" : user_Code
				};
				$
						.ajax({
							type : "GET",
							url : "userManagement.html?method=blockUser",
							data : user,
							async : false,

							success : function(data) {
								var result = $.parseJSON(data);
								
								$('.errormessagediv').hide();
								
								if(result.status=="User Blocked Successfully"){
									
								$(".successmessagediv").show();
								$(".successmessage").text(result.status);
								
								}else{
									
									$('.errormessagediv').show();
									$('.validateTips').text(result.status);
									
								}
								
								
								 setTimeout(function(){									   
									
									 location.reload();
								 
								 },3000);
								
							
							}

						});

			}
			
		}
		
				
});
 	
 	
 	
 	
 
});

	
			

