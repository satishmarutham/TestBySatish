function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}

function myFunction()

{

	var id = $('#designationid').val();

	var name = $('#designation').val();

	if (name == "" || name == null)

	{

		$(".errormessagediv1").show();

		$(".validateTips1").text("Enter Designation Name");

		return false;

	}

	/*if (!name.match(/[A-Za-z]+$/i))

	{

		$(".successmessagediv").hide();
		$(".errormessagediv1").show();
		$(".validateTips1").text("Enter Valid Designation Name");

		return false;

	}*/

	var status = false;

	datalist = {
		"name" : name,
		"id" : id
	},

	$.ajax({

		type : "POST",

		url : "adddesignation.html?method=getnamecount",

		data : datalist,

		async : false,

		success : function(data)

		{

			var result = $.parseJSON(data);

			if (result.message)

			{

				$('#designation').val("");

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

										window.location.href = "adminMenu.html?method=designationList";

									});

					$('#submit')
							.click(
									function()

									{

										var id = $('#designationid').val();

										var name = $('#designation').val();

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

																url : "adminMenu.html?method=submit",

																data : datalist,

																success : function(
																		data)

																{

																	var result = $
																			.parseJSON(data);

																	window.location.href = "adminMenu.html?method=designationList&result="
																			+ result.jsonResponse;

																}

															});

										}

									});

					// edit function

					$('#editDesignationId')
							.click(
									function()

									{
										var cnt = 0;

										$(
												'input.designationDetails_Checkbox_Class:checkbox:checked')
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

											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Select Any One Designation");

										}

										else {

											var name = getData[0];

											window.location.href = "adddesignation.html?method=Edit&name="
													+ name;

										}

									});

					// to delete

					$('#deleteDesignationId')
							.click(
									function() {

										var cnt = 0;

										$(
												'input.designationDetails_Checkbox_Class:checkbox:checked')
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
											$(".validateTips")
													.text(
															"Select Any One Designation");

										} else {

											var x = confirm("Are You Sure You Want To Delete This Designation");
											if (x) {

												var datalist = 'des_name='
														+ getData[0];

												$
														.ajax({
															type : "GET",
															url : "adddesignation.html?method=Delete",
															data : datalist,
															async : false,

															success : function(
																	response) {
																var result = $
																		.parseJSON(response);

																if (result.jsonResponse == "Designation Details Deleted Successfully") {
																	
																	$(".errormessagediv").hide();

																	window.location.href = "adminMenu.html?method=designationList&value="
																			+ result.jsonResponse;

																}
																if (result.jsonResponse == "Designation Details Not Deleted Successfully") {
																	$(
																			".errormessagediv")
																			.show();
																	$(
																			".validateTips")
																			.text(
																					result.jsonResponse);
																}

																else if (result.jsonResponse == "Designation Details Already Mapped") {

																	
																	$(
																	".successmessagediv")
																	.hide();
																	
																	
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
										var searchvalue = $('#searchvalue').val();
								
														
										
										window.location.href = "adminMenu.html?method=designationList&searchvalue="
											+ searchvalue;
										

									});

					$("#xlss")
							.click(
									function()

									{

										window.location.href = "adddesignation.html?method=downloadDesignationDetailsXLS";

									});
					
					
					
					
					$("#pdfDownload")
					.click(
							function()

							{

								window.location.href = "adddesignation.html?method=downloadDesignationDetailsPDF";

							});
					
					
					
					
					
					
					

				});
