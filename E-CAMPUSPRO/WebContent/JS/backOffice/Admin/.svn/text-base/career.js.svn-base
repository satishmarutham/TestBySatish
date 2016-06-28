$(document)
		.ready(
				function() {
					$('.errormessagediv1').hide();
					$('.successmessagediv').hide();

					if ($('#jobid').val() == null || $('#jobid').val() == "") {
						$("#statusid").hide();
					} else {
						$("#statusid").show();
						$("#description").val($("#descriptionId").val());

						$(
								"#status option[value='"
										+ $('#staid').val().trim() + "']")
								.attr('selected', 'true');
					}

					$("#editDesignationId")
							.click(
									function() {
										var cnt = 0;
										$(
												'input.Checkbox_Class:checkbox:checked')
												.map(
														function() {

															var term_id = $(
																	this).attr(
																	"id");
															var split_id = term_id
																	.split('_');
															getData = split_id[1]
																	.split(',');

															cnt++;
														});
										if (cnt == 0 || cnt > 1) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Select Any One Job");
										} else {

											window.location.href = "careerview.html?method=careerView&Code="
													+ getData[0];

										}

									});

					$("#save")
							.click(
									function() {

										var title = $('#title').val().trim();
										var qualification = $('#qualification')
												.val().trim();
										var noofposition = $('#noofposition')
												.val().trim();
										var experience = $('#experience').val()
												.trim();
										var description = $('#description')
												.val().trim();
										var jobid = $('#jobid').val().trim();
										var status = $('#status').val().trim();

										if (title == "" || title == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter Title");
											return false;
										}
										/*else if (!title
												.match("^[a-zA-Z/0-9]+$")) {
											$('.errormessagediv1').show();
											$('.validateTips1')
													.text(
															"Title should be Alphanumeric");
											return false;
										} */
										
										else if (qualification == ""
												|| qualification == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter Qualification");
											return false;
										} else if (!qualification
												.match("^[a-zA-Z]+$")) {
											$('.errormessagediv1').show();
											$('.validateTips1')
													.text(
															"Qualification should be Alphabets");
											return false;
										} else if (experience == ""
												|| experience == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter Experience");
											return false;
										} else if (noofposition == ""
												|| noofposition == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter No Of Position");
											return false;
										} else if (!noofposition
												.match("^[0-9]+$")) {
											$('.errormessagediv1').show();
											$('.validateTips1')
													.text(
															"No Of Position should be Numbers");
											return false;
										}/*
											 * else if (checkName()) {
											 * $('.errormessagediv1').show();
											 * $('.validateTips1').text( "Title
											 * already Exist"); return false; }
											 */else {
											if (jobid == "" || jobid == null) {
												jobid = "NULL";
											}

											var Check = {
												"title" : title,
												"qualification" : qualification,
												"experience" : experience,
												"description" : description,
												"noofposition" : noofposition,
												"jobid" : jobid,
												"status" : status
											};
											$
													.ajax({
														type : "POST",
														url : "careerview.html?method=addJobs",
														data : Check,
														async : false,
														success : function(data) {
															var result = $
																	.parseJSON(data);
															if (result.status == "success") {
																
																
																$('.errormessagediv1').hide();
																
																$(
																		'.successmessagediv')
																		.show();
																$(
																		'.successmessage')
																		.text(
																				"Job Inserted Successfully");
																setTimeout(
																		function() {

																			window.location.href = "adminMenu.html?method=careerupdate";

																		}, 3000);
															} else if (result.status == "duplicate") {

																$(
																		'.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Job already mapped can't Deactivated");
																setTimeout(
																		function() {

																			window.location
																					.reload();

																		}, 3000);

															} else {
																$(
																		'.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Job Insertion failed");
																setTimeout(
																		function() {

																			window.location.href = "adminMenu.html?method=careerupdate";

																		}, 3000);
															}

														}
													});

										}
									});

					$("#list")
							.click(
									function() {
										window.location.href = "adminMenu.html?method=careerupdate";
									});

					$("#searchid")
							.click(
									function() {
										var searchid = $("#search").val()
												.trim();
										window.location.href = "adminMenu.html?method=careerupdate&searhval="
												+ searchid;

									});

					$("#plus").click(function() {
						window.location.href = "adminMenu.html?method=addJob";
					});

					$('#excelDownload')
					.click(
							function() {
								
								
								var searchTerm = $("#searchexamid").val().trim();
								
								window.location.href = 'careerview.html?method=InternaljobXLS&searchTerm='+searchTerm;
								
							});

					$("#pdfDownload").click(function(){
						
						
						
						var searchTerm = $("#searchexamid").val().trim();
						
						window.location.href = "careerview.html?method=InternaljobPDFReport&searchTerm="+searchTerm;
							
					});	
					
					$("#trash")
							.click(
									function() {

										var cnt = 0;
										$(
												'input.Checkbox_Class:checkbox:checked')
												.map(
														function() {

															var term_id = $(
																	this).attr(
																	"id");
															var split_id = term_id
																	.split('_');
															getData = split_id[1]
																	.split(',');

															cnt++;
														});
										if (cnt == 0 || cnt > 1) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Select Any One Job");
										} else {

											var Check = {
												"Code" : getData[0]
											};
											$
													.ajax({
														type : "POST",
														url : "careerview.html?method=careerDelete",
														data : Check,
														async : false,
														success : function(data) {
															var result = $
																	.parseJSON(data);
															if (result.status == true) {
																$(
																		'.successmessagediv')
																		.show();
																$(
																		'.successmessage')
																		.text(
																				"Job Deactivated Successfully");
																setTimeout(
																		function() {

																			location
																					.reload();

																		}, 3000);
															} else {
																$(
																		'.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Job already mapped can't Deactivated");

																setTimeout(
																		function() {

																			location
																					.reload();

																		}, 3000);

															}

														}
													});

										}

									});

				});
/*
 * function checkName() {
 * 
 * jobid = $("#jobid").val();
 * 
 * if (jobid == "" || jobid == null) { jobid = "NULL"; }
 * 
 * var checkname = { "jobid" : jobid, "title" : $("#title").val(), }; var status =
 * false; $.ajax({ type : "POST", url : "careerview.html?method=checkTitle",
 * data : checkname, async : false, success : function(data) {
 * 
 * var result = $.parseJSON(data);
 * 
 * status = result.status;
 * 
 * if (status == true) { $('.errormessagediv1').show();
 * $('.validateTips1').text("Title already Exist"); } else {
 * $('.errormessagediv1').hide(); } } });
 * 
 * return status; }
 */
