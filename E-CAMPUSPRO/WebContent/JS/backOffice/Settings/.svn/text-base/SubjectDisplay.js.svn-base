
$(document)
		.ready(
				function() {

					 setTimeout("removeMessage()" ,3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);

					$('#deleteSubject')
					.click(
							function() {
								 
								
								
								var count = 0;
								$(
										'input.vehicle_Checkbox_Class:checkbox:checked')
										.map(
												function() {

													var vehicle_id = $(
															this).attr(
															"id");
													var split_id = vehicle_id
															.split('_');
													getData = split_id[1]
															.split(',');

													count++;
												});
								if (count == 0 || count > 1) {
									$(".errormessagediv").show();
									$(".validateTips").text(
											"Check any one checkbox");
									return false;

								} else {
									
									
									/*window.location.href = "transport.html?method=deleteVehicleDetails&vehiclecode="+getData[0];*/
								  	
									var datalist = {
											"subjectcode" :getData[0]
										};
									
									$
									.ajax({
										type : 'POST',
										url : "subject.html?method=DeleteSubject",
										data : datalist,
										async : false,
										success : function(data) {
											
											var result = $.parseJSON(data);
											
											if (result.status == true) {
												var msg = "Subject Deleted Successfully";
												
												window.location.href = "adminMenu.html?method=subjectdetails&message="+msg;

											} else {
												$(
														".errormessagediv")
														.show();
												$(
														".validateTips")
														.text(
																"Subject Deletion Failed");
											}
										}

									});
									
								}
								
							});
					
					$('#search')
					.click(
							function() {
							
							var searchname=$("#searchname").val();
							if(searchname==""){
								
								$('.errormessagediv').show();
								$('.validateTips').text("Enter search term");
							
							}
							else{
							
							window.location.href = "adminMenu.html?method=subjectdetails&searchname="+searchname;
							
							}
							
							});
					
					
					$('#editVehicle')
					.click(
							function() {
								
								
								var count = 0;
								$(
										'input.vehicle_Checkbox_Class:checkbox:checked')
										.map(
												function() {

													var vehicle_id = $(
															this).attr(
															"id");
													var split_id = vehicle_id
															.split('_');
													getData = split_id[1]
															.split(',');

													count++;
												});
								if (count == 0 || count > 1) {
									$(".errormessagediv").show();
									$(".validateTips").text(
											"Check any one checkbox");
									return false;

								} else {
								
									window.location.href = "subject.html?method=getSubjectDetails&subjectcode="+getData[0];
								
								}
							});
					
					$('#excelDownload')
					.click(
							function() {
								
								window.location.href = 'subject.html?method=downloadsubjectDetailsXLS';
								
							});
					$("#pdfDownload").click(function(){
            			
            			window.location.href = "subject.html?method=downloadsubjectDetailsPDF";
            				
            		});
					
				});

function removeMessage() {
	

	
	$(".successmessagediv").hide();
	$(".successmessagediv").hide();
	

}
					