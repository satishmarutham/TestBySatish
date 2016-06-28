$(document)
		.ready(
				function() {
					setTimeout("removeMessage()" ,2000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);
					
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
									
								
									window.location.href = "transport.html?method=getSingleVehicleDetails&vehiclecode="+getData[0];
								  	
									
								}
							});
					
					$('#deleteVehicle')
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
											"vehiclecode" :getData[0]
										};
									
									$
									.ajax({
										type : 'POST',
										url : "transport.html?method=deleteVehicleDetails",
										data : datalist,
										async : false,
										success : function(data) {
											
											var result = $.parseJSON(data);
											
											if (result.status == true) {
												var msg = "Vehicle details Deleted Successfully";
												
												window.location.href = "adminMenu.html?method=vehicleList&message="+msg;

											} else {
												$(
														".errormessagediv")
														.show();
												$(
														".validateTips")
														.text(
																"Vehicle details Deletion Failed");
											}
										}

									});
									
								}
								
							});
					
					
					$('#search')
					.click(
							function() {
							
							var searchname=$("#searchname").val();
							
							window.location.href = "transport.html?method=searchvehicledetails&searchname="+searchname;
							
							});
					
					$('#excelDownload')
					.click(
							function() {
								
								window.location.href = 'transport.html?method=VehicleDetailsXLS';
								
							});
					
					$("#pdfDownload").click(function(){
						
						window.location.href = "transport.html?method=VehicleDetailsPDFReport";
							
					});	

					
					
				});


function removeMessage() {
	

	$(".successmessagediv").hide();

}