function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}

function callAjax(urlWithMethod, dataToBeSend) {
	
	$.ajax({
         
		url : urlWithMethod,
		data : dataToBeSend,
		async : false,
		success : function(data) {
			var result = $.parseJSON(data);
			jsonResult = result.status;
			
			 setTimeout(function(){
				   
				 location.reload();
			 
			 },5000);
	
		}
	});
	return jsonResult;
}

function insertValidate() {

	
	
	$(".errormessagediv").hide();
	
	tips = $(".validateTips");
	var bValid = true;

	bValid = bValid && checkLengthText($('#streamName'), "Stream Name", 0, 30);

	bValid = bValid
			&& checkRegexpText($('#streamName'), /^[a-zA-Z\s]+$/g,
					"Name should be Alphabet");

	if (!bValid) {
		$(".errormessagediv").show();
	} else {

		$(".errormessagediv").hide();
	}

	return bValid;
		
}

$(document)
		.ready(
				function() {
					
/*					$('.errormessagediv').hide();
*/					
					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);
				
					$("#savestreamid").click(function(){
						
				              	$(".successmessagediv").hide();
				              	$(".errormessagediv").hide();
						
						
						var streamname = $("#streamName").val().trim();
						var description = $("#description").val().trim();
						var streamId = $("#streamId").val().trim();
						
						if (streamname == "" || streamname==null) {
							
							$(".errormessagediv").show();
							
							$(".validateTips").text("Enter Stream Name");
							$("#streamName").focus();
							document.getElementById("streamName").style.border = "1px solid #AF2C2C";
							document.getElementById("streamName").style.backgroundColor = "#FFF7F7";
							setTimeout(function() {
								$('.errormessagediv').fadeOut();
							}, 3000);
							
							return false;
						}
						else if(validateStreamName() == 1 ) {
							
                            $(".errormessagediv").show();
							
							$(".validateTips").text(" Stream Name already exists");
							
							return false;
						}
						
						else{
							//alert("insert");
							
								datalist = {
										"streamId" : streamId,"streamname" : streamname, "description" :description
										
									};
								
								//alert(JSON.stringify(datalist));
								
								
								$
								.ajax({
									type : 'POST',
									url : "streamDetails.html?method=insertStreamDetailsAction",
									data : datalist,
									async : false,
									success : function(
											data) {
									
										
										var result = $.parseJSON(data);
										//alert("response"+result.jsonResponse);
										
										if(result.jsonResponse=="Stream Added Successfully"){
											
											$(".errormessagediv").hide();
											$(".successmessagediv").show();
											 $(".validateTips").text("Stream Added Successfully");
											 
											 
											 setTimeout(function(){
													
													window.location.href = "adminMenu.html?method=streamList";
											 
											 },3000);
											
										}
											
										if(result.jsonResponse=="Stream Updated Successfully"){
											
											$(".errormessagediv").hide();
											$(".successmessagediv").show();
											 $(".validateTips").text("Stream Updated Successfully");
											 
											 
											
											 setTimeout(function(){
													
													window.location.href = "adminMenu.html?method=streamList";
											 
											 },3000);
											 
										}		
										
										
										
										
									}

								});
						
								
						}
						
						
						
					});
					
					
						
				});


function validateStreamName(){
	
	var streamname_validate=0;
	
		var streamId = $("#streamId").val().trim();
	
	 	var streamname=$("#streamName").val();
		var streamObject = {
			"streamname" : streamname, "streamId" : streamId
		};
	
	
	$.ajax({

		type : "GET",
		url : 'streamDetails.html?method=validateStreamName',
		data : streamObject,
		async : false,
		success : function(data) {
			
			var result = $.parseJSON(data);
			
		if (result.status=="true") {
				
				streamname_validate = 1;

			}
			else 
				
			{
				streamname_validate = 0;
			}
		
		}
	});
	
	return streamname_validate;
	
}

function HideError() 
{
	
document.getElementById("streamName").style.border = "1px solid #ccc";
document.getElementById("streamName").style.backgroundColor = "#fff";

}