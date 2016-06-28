function myFunction()

{

	var id = $('#feemasterid').val();

	var name = $('#feename').val();
	var concessiontype = $('.concession[name="concession"]:checked').val();

	if (name == "" || name == null)

	{

		$(".successmessagediv").hide();

		$(".errormessagediv1").show();

		$(".validateTips1").text("Enter Fee Name");

		return false;

	}

	if (!name.match(/[A-Za-z]+$/i))

	{

		$(".successmessagediv").hide();
		$(".errormessagediv1").show();
		$(".validateTips1").text("Enter Valid Fee Name");

		return false;

	}

	if (concessiontype == "" || concessiontype == null)

	{

		$(".successmessagediv").hide();

		$(".errormessagediv1").show();

		$(".validateTips1").text("Enter Concession Type");

		return false;

	}

	var status = false;

	datalist = {
		"name" : name,
		"id" : id
	},

	$.ajax({

		type : "POST",

		url : "addfee.html?method=getnamecount",

		data : datalist,
		async : false,

		success : function(data)

		{

			var result = $.parseJSON(data);

			if (result.message)

			{

				$('#feename').val("");

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

					var type = $('#concession').val();

					if (type == "Y") {
						$("#yes").attr("checked", true);
					} else if (type == "N") {
						$("#no").attr("checked", true);
					}

					$("#save")
							.click(
									function(event)

									{

										// alert("ddddd");

										var id = $('#feemasterid').val();

										var name = $('#feename').val();

										var description = $('#feedescription')
												.val();

										var concessiontype = $(
												'.concession[name="concession"]:checked')
												.val();

										// alert(concessiontype);

										if (myFunction())

										{

													datalist = {
														"name" : name,
														"description" : description,
														"id" : id,
														"concessiontype" : concessiontype
													},

													$
															.ajax({

																type : "POST",

																url : "addfee.html?method=AddFeeDetailsMaster",

																data : datalist,

																success : function(
																		data)

																{

																	var result = $
																			.parseJSON(data);
																	// alert("response"+result.jsonResponse);

																	if (result.jsonResponse == "Fee Details Added Successfully") {
																		$(
																				".errormessagediv")
																				.hide();
																		$(
																				".successmessagediv")
																				.show();
																		$(
																				".validateTips")
																				.text(
																						"Fee Details Added Successfully");

																		setTimeout(
																				function() {

																					window.location.href = "adminMenu.html?method=feeDetailsList";

																				},
																				3000);

																	}

																	if (result.jsonResponse == "Fee Details not Created Successfully") {

																		$(
																				".errormessagediv")
																				.hide();
																		$(
																				".successmessagediv")
																				.show();
																		$(
																				".validateTips")
																				.text(
																						"Fee Details not Created Successfully");

																		setTimeout(
																				function() {

																					window.location.href = "addfee.html?method=addfeedetails";

																				},
																				3000);

																	}
																	if (result.jsonResponse == "Fee Details Updated Successfully") {
																		$(
																				".errormessagediv")
																				.hide();
																		$(
																				".successmessagediv")
																				.show();
																		$(
																				".validateTips")
																				.text(
																						"Fee Details Updated Successfully");

																		setTimeout(
																				function() {

																					window.location.href = "adminMenu.html?method=feeDetailsList";

																				},
																				3000);

																	}

																	if (result.jsonResponse == "Fee Details not Updated Successfully") {

																		$(
																				".errormessagediv")
																				.hide();
																		$(
																				".successmessagediv")
																				.show();
																		$(
																				".validateTips")
																				.text(
																						"Fee Details not Updated Successfully");

																		setTimeout(
																				function() {

																					window.location.href = "addfee.html?method=addfeedetails";

																				},
																				3000);

																	}

																	/*	var result = $.parseJSON(data);
																		
																		
																		
																		window.location.href = "addfee.html?method=addfeedetails&result="+ result.jsonResponse;
																		
																		
																		if(result.jsonResponse=='')
																		{
																			
																		
																		 setTimeout(function(){
																				
																			 window.location.href="adminMenu.html?method=examList";
																		 
																		 },2000);
																		}*/

																}

															});

										}

									});

					$("#view")
							.click(
									function(event)

									{

										window.location.href = "adminMenu.html?method=feeDetailsList";

									});

				});