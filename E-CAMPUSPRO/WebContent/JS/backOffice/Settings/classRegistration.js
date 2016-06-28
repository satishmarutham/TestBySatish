
function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv1").hide();

}



$(document)
		.ready(
				function() {
					getStream();
					
					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);	
					
					
					
					// $("#role option[value='"+ result.roleVo[0].roleId +"']").attr("selected", "selected");
						var hiddenStreamId=$("#hiddenStreamId").val().trim();
						if(hiddenStreamId!=undefined){
							
						$("#streamId option[value=" + hiddenStreamId + "]").attr('selected', 'true');
						
							}
					
					
			
					$('#classSave').click(function() {
						var stream = $('#streamId').val();
						var className = $('#className').val();
						var status = $('#statusId').val();
						var updateClassCode = $('#updateClassCode').val();
						
				

						if (stream == "" || stream == null) {
							$(".errormessagediv").show();
							$(".validateTips").text(
									"Select Stream Name");
							$("#streamId").focus();
							document.getElementById("streamId").style.border = "1px solid #AF2C2C";
							document.getElementById("streamId").style.backgroundColor = "#FFF7F7";
							setTimeout(function() {
							$('.errormessagediv').fadeOut();
							}, 3000);
							return false;
												
							
							
							return false;
						}else if(className == "" || className == null){
							$(".errormessagediv").show();
							$(".validateTips").text(
									"Enter Class Name");
							$("#className").focus();
							document.getElementById("className").style.border = "1px solid #AF2C2C";
							document.getElementById("className").style.backgroundColor = "#FFF7F7";
							setTimeout(function() {
							$('.errormessagediv').fadeOut();
							}, 3000);
							return false;
						}else if (!className
								.match(/^[a-zA-Z0-9\s]+$/i)) {
							$(
									".errormessagediv")
									.show();
							$(".validateTips")
									.text(
											"Enter Proper Class Name");
							return false;
						}/*else if(checkClassName()){
							$(".errormessagediv").show();
							$(".validateTips").text("Class Name Already Exists");

							return false;
						}*/ else {
				
							var datalist = {
									"stream" : stream,
									"className" : className,
									"status" :status,
									"updateClassCode":updateClassCode,
									
								};

								$.ajax({
											type : 'POST',
											url : "classPath.html?method=insertClassAction",
											data : datalist,
											success : function(
													response) {
												var result = $
														.parseJSON(response);
												
												if (result.check == true) {
												
													
													var msg = "class details Added Successfully";
													
													window.location.href = "classPath.html?method=addClass&msg="
															+ msg;
													
													
													
													 setTimeout(function(){
															
														 window.location.href = "adminMenu.html?method=classList";
											
													 
													 },3000);
													

												} else {
													$(
															".errormessagediv")
															.show();
													$(
															".validateTips")
															.text(
																	"class Already Exist");
													
													
													 setTimeout(function(){
															
														 window.location.href = "adminMenu.html?method=classList";
													 
													 },3000);
												}
												
												
												 setTimeout(function(){
														
													 window.location.href = "adminMenu.html?method=classList";
												 
												 },3000);
												 
												
											}

								
								
								
								
								
								
								
								
										});
						}
								
							});
					
					$('#editClass').click(function() {
					
						$(".errormessagediv1").hide();
						var cnt = 0;
						$('input.class_Checkbox_Class:checkbox:checked')
								.map(function() {
									if (cnt > 0) {
										$(
												".errormessagediv")
												.show();
										$(
												'.validateTips')
												.text(
														"You can update only one Class Details at a time");
										cnt++;
										return false;
									} else {
										var check_id = $(this).attr("id");
										var split_id = check_id.split('_');
										getData = split_id[1].split(',');
										var classCode=getData[0];
										cnt++;
									}
								});
						if (cnt == 0) {

							$(".errormessagediv").show();
							$('.validateTips').text(
									"Select Class to Update");
						}
						if (cnt == 1) {

					
							
							window.location.href = "classPath.html?method=editClass&classCode="
								+ classCode;
			
						}
		
					});
					
				});

function checkClassName() {
	var className = $("#className").val();
	var stream = $("#streamId").val(); 
	var updateClassCode = $('#updateClassCode').val();
	var checkClassName = {
		"className" : className,
		"stream" : stream,
		"updateClassCode":updateClassCode,
	};

	var status = false;

	$.ajax({
		type : "POST",
		url : "classPath.html?method=classNameCheck",
		data : checkClassName,
		async : false,
		success : function(data) {

			var result = $.parseJSON(data);

			status = result.status;

		}
	});

	return status;

}



function getStream(){
	$.ajax({
		url : "classPath.html?method=getStreamDetailAction",
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			for ( var j = 0; j < result.streamList.length; j++) {
				
				$('#streamId')
						.append(
								'<option value="'
										+ result.streamList[j].streamId
										+ '">'
										+ result.streamList[j].streamName
										+ '</option>');

			}

		}
	});
}



function HideError() 
{
	document.getElementById("streamId").style.border = "1px solid #ccc";
	document.getElementById("streamId").style.backgroundColor = "#fff";
	
document.getElementById("className").style.border = "1px solid #ccc";
document.getElementById("className").style.backgroundColor = "#fff";

}
