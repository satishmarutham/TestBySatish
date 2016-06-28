$(document)
		.ready(
				function() {
					
					
					 setTimeout("removeMessage()" ,3000);
						setInterval(function() {
							$(".errormessagediv").hide();
						}, 3000);

					$('#search')
					.click(
							function() {
								
								
								document.getElementById("searchForm").submit();

	 							/*var searchTerm=$("#searchname").val().trim();
								
								if(searchTerm==""){
								
									$('.errormessagediv').show();
									$('.validateTips').text("Enter search term");
								
								}else{
									
									document.getElementById("searchForm").submit();
									
								}
						   */
							
							
							
							});
					
					$('#deleteTeacher')
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
									
									var datalist = {
											"teachercode" :getData[0]
										};
									
									$
									.ajax({
										type : 'POST',
										url : "teacherregistration.html?method=deleteStaffDetails",
										data : datalist,
										async : false,
										success : function(data) {
											
											var result = $.parseJSON(data);
											
											if (result.status == true) {
												var msg = "Staff details Deleted Successfully";
												
												window.location.href = "adminMenu.html?method=staffList&message="+msg;

											} else {
												$(
														".errormessagediv")
														.show();
												$(
														".validateTips")
														.text(
																"Staff details Deletion Failed");
											}
										}

									});
									
								}
								
							});
					

					$('#editTeacher')
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
								
									window.location.href = "teacherregistration.html?method=getTeacherDetails&teachercode="+getData[0];
								
								}
							});
					
					
					
					$('#excelDownload')
					.click(
							function() {
								
								window.location.href = 'teacherregistration.html?method=downloadStaffDetailsXLS';
								
							});
					$("#pdfDownload").click(function(){
            			
            			window.location.href = "teacherregistration.html?method=downloadStaffDetailsPDF";
            				
            		});
							
					
					
					
					
				});



function salaryDeatails(){
	
	window.location.href = "teacherregistration.html?method=getTeacherSalary";
	
	
	
}



function removeMessage() {
	

	
	$(".successmessagediv").hide();
	
	

}