$(document)
		.ready(
				function() {

					$('#deleteid')
							.click(
									function() {

										var depcode = [];

										var count = 0;
										$(
												"input.dep_Checkbox_Class:checkbox:checked")
												.map(
														function() {

															var term_id = $(
																	this).attr(
																	"id");
															var split_id = term_id
																	.split('_');
															getData = split_id[1]
																	.split(',');
															depcode
																	.push(getData[0]);
															count++;

														});
										if (count == 0 || count > 1) {

											$(".errormessagediv").show();
											$(".validateTips")
													.text("Select any one department");
											return false;

										} else if (depcode != "") {
											var depcode1 = depcode.toString();
											var x = confirm("Are you sure you want to delete this Department");

											if (x) {
												var termcodeToBeDeleted = {
													"depid" : depcode1
												};
												$
														.ajax({
															type : 'POST',
															url : "departmentMenu.html?method=deleteDepartment",
															data : termcodeToBeDeleted,
															async : false,
															success : function(
																	data) {
																var result = $
																		.parseJSON(data);

																if (result.status == "Department Deleted Successfully") {

																	$(
																			".errormessagediv")
																			.hide();
																	$(
																			".successmessagediv")
																			.show();
																	$(
																			".successmessage")
																			.text(
																					result.status);

																} else {
																	$(
																			".errormessagediv")
																			.show();
																	$(
																			".validateTips")
																			.text(
																					result.status);
																}

																setTimeout(
																		function() {

																			location
																					.reload();

																		}, 3000);

															}

														});
											}
										} else {
											$(".validateTips")
													.html(
															"Select any Department to Delete");
										}
									});

					$('#editdep')
							.click(
									function() {

										$(".errormessagediv").hide();
										$(".errormessagediv1").hide();

										var count = 0;

										$(
												"input.dep_Checkbox_Class:checkbox:checked")
												.map(
														function() {

															var checkdep_id = $(
																	this).attr(
																	"id");
															var split_id = checkdep_id
																	.split('_');
															getData = split_id[1]
																	.split(',');
															count++;
														});

										if (count == 0 || count > 1) {

											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Select any one department");

											return false;

										}

										else {

											var id = getData[0];

											window.location.href = "departmentMenu.html?method=editDepartment&name="
													+ id;

										}
									});

					$('#search').click(function() {

						var searchname = $("#searchname").val().trim();

						myFunction();
						$("#searchname").val("");
						
						//window.location.href = "departmentMenu.html?method=searchDepartment&searchname="+searchname;

					});
					
					
					$('#xls').click(
							function() {
								
								var searchTerm = $("#searchexamid").val().trim();
								window.location.href = 'departmentMenu.html?method=downloadDepartmentDetailsXLS&searchTerm='+ searchTerm;
							});
					
					
					
					$('#pdfDownload').click(
							function() {
								
								var searchTerm = $("#searchexamid").val().trim();
								window.location.href = 'departmentMenu.html?method=downloadDepartmentDetailsPDF&searchTerm='+ searchTerm;
							});	
					
					
					
							

				});

function myFunction() {

	document.getElementById("myForm").submit();

}
