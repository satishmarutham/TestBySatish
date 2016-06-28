function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}

$(document)
		.ready(
				function()

				{

					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv1").hide();
					}, 3000);
					
					$("#delete")
							.click(
									function()

									{

										var cnt = 0;

										$(
												'input.academic_Checkbox_Class:checkbox:checked')
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

											$(".successmessagediv").hide();
											$(".errormessagediv1").show();
											$(".validateTips1").text(
													"Select Any One Checkbox");

										}

										else {

											var x = confirm("Are you sure want to delete this fee details");
											if (x) {

												var datalist = 'name='
														+ getData[0];

												$
														.ajax({
															type : "GET",
															url : "termfee.html?method=deleteTermDetails",
															data : datalist,
															async : false,

															success : function(
																	response) {

																var result = $
																		.parseJSON(response);

																if (result.jsonResponse == "Term Details Deleted Successfully") {

																	window.location.href = "adminMenu.html?method=termList&result="
																			+ result.jsonResponse;

																}
																if (result.jsonResponse == "Term Details not Deleted Successfully") {
																	$(
																			".errormessagediv")
																			.show();
																	$(
																			".validateTips")
																			.text(
																					result.jsonResponse);
																}

																else if (result.jsonResponse == "Term Details Already Mapped") {

																	$(
																			".errormessagediv")
																			.show();
																	$(
																			".validateTips")
																			.text(
																					result.jsonResponse);

																}

																setTimeout(
																		function() {

																			location
																					.reload();

																		}, 3000);

															}
														});

											}

										}

									});

					$("#termedit")
							.click(
									function() {

										var cnt = 0;

										$(
												'input.academic_Checkbox_Class:checkbox:checked')
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

											$(".successmessagediv").hide();
											$(".errormessagediv1").show();
											$(".validateTips1").text(
													"Select Any One Checkbox");

										}

										else {

											var id = getData[0];
											window.location.href = "termfee.html?method=edittermDetails&id="
													+ id;

										}

									});

					$("#search")
							.click(
									function()

									{
										var searchvalue = $('#searchvalue')
												.val();

										window.location.href = "adminMenu.html?method=termList&searchvalue="
												+ searchvalue;

									});

					$('#excelDownload')
							.click(
									function() {

										var searchvalue = $('#termsearchid')
										.val();
										window.location.href = 'termfee.html?method=downloadtermlistDetailsXLS&searchvalue='
											+ searchvalue;

									});
					$("#pdfDownload")
							.click(
									function() {
										
										var searchvalue = $('#termsearchid')
										.val();

										window.location.href = "termfee.html?method=downloadtermlistDetailsPDF&searchvalue="
												+ searchvalue;

									});

				});
