function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}



function myFunction()

{

	var id = $('#stageid').val();

	var name = $('#stagename').val();

	if (name == "" || name == null)

	{

		$(".errormessagediv1").show();

		$(".validateTips1").text("Enter Stage Name");

		return false;

	}

	var status = false;

	datalist = {
		"name" : name,
		"id" : id
	},

	$.ajax({

		type : "POST",

		url : "addstage.html?method=getstagecount",

		data : datalist,

		async : false,

		success : function(data)

		{

			var result = $.parseJSON(data);

			if (result.message)

			{

				$('#stagename').val("");

				$(".successmessagediv").hide();

				$(".errormessagediv1").show();

				$(".validateTips1").text("Name Already Exists");

				status = false;

			}

			else

			{

				status = true;

			}

		}

	});

	return status;

}

$(document)
		.ready(
				function()

				{

					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);
					
					
					$('#view')
							.click(
									function()

									{

										window.location.href = "adminMenu.html?method=StageList";

									});

					$('#savestage')
							.click(
									function()

									{

										var id = $('#stageid').val();

										var name = $('#stagename').val();

										var description = $('#description')
												.val();

										if (myFunction())

										{

													datalist = {
														"name" : name,
														"description" : description,
														"id" : id
													},

													$
															.ajax({

																type : "POST",

																url : "adminMenu.html?method=savestage",

																data : datalist,

																success : function(
																		data)

																{

																	var result = $
																			.parseJSON(data);

																	window.location.href = "adminMenu.html?method=addstage&result="
																			+ result.jsonResponse;

																}

															});

										}

									});

					// edit

					$('#editStageId')
							.click(
									function()

									{

										var cnt = 0;

										$(
												'input.stageMaster_Checkbox_Class:checkbox:checked')

										.map(function() {

											var term_id = $(this).attr("id");

											var split_id = term_id.split('_');
											getData = split_id[1].split(',');

											cnt++;
										});

										if (cnt == 0 || cnt > 1) {

											$(".errormessagediv").show();
											$(".validateTips").text(
													"Select Any One Stage");

										}

										else {

											// alert(getData[0]);

											var name = getData[0];

											window.location.href = "addstage.html?method=Edit&name="
													+ name;

										}

									});

					// to delete
					$('#deleteStageId')
							.click(
									function() {

										var cnt = 0;

										$(
												'input.stageMaster_Checkbox_Class:checkbox:checked')
												.map(
														function()

														{

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
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Select Any One Stage");

										} else {

											var x = confirm("Are You Sure You Want To Delete This Stage");
											if (x) {

												var datalist = 'des_name='
														+ getData[0];

												$
														.ajax({
															type : "GET",
															url : "addstage.html?method=Delete",
															data : datalist,
															async : false,

															success : function(
																	response) {
																var result = $
																		.parseJSON(response);

																if (result.jsonResponse == "Stage Details Deleted Successfully") {

																	window.location.href = "adminMenu.html?method=StageList&value="
																			+ result.jsonResponse;

																}
																if (result.jsonResponse == "Stage Details Not Deleted Successfully") {
																	$(
																			".errormessagediv")
																			.show();
																	$(
																			".validateTips")
																			.text(
																					result.jsonResponse);
																}

																else if (result.jsonResponse == "Stage Details Already Mapped") {

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

					$("#search")
							.click(
									function()

									{
										var searchvalue = $('#searchvalue')
												.val();

										window.location.href = "adminMenu.html?method=StageList&searchvalue="
												+ searchvalue;

									});

					$("#xls")
							.click(
									function()

									{
										var searchTerm = $("#searchexamid").val().trim();
										window.location.href = "addstage.html?method=downloadStageDetailsXLS&searchTerm="+ searchTerm;

									});
					
					
					
					
					$("#pdfDownload")
					.click(
							function()

							{
								var searchTerm = $("#searchexamid").val().trim();
								window.location.href = "addstage.html?method=downloadStageDetailsPDF&searchTerm="+ searchTerm;

							});
					

				});









