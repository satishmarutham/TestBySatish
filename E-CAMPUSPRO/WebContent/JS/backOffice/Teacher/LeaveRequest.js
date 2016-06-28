function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}

$(document)
		.ready(
				function() {

					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);

					/*
					 * 
					 * 
					 * $("#editID").click(function(){
					 * 
					 * 
					 * var snoid=$("#snoid").val();
					 * 
					 * if(snoid==""||snoid==null){
					 * 
					 * $(".errormessagediv").show();
					 * $(".validateTips").text("Select any one CheckBox");
					 * 
					 * return false; }
					 * 
					 * 
					 * 
					 * else{
					 * 
					 * window.location.href =
					 * "parentMenu.html?method=editRequestLeaveAction&snoid="+snoid;
					 * 
					 * 
					 * 
					 * });
					 */

					$("#delete")
							.click(
									function() {

										var snoid = $("#snoid").val();

										if (snoid == "" || snoid == null) {

											$(".errormessagediv").show();
											$(".validateTips").text(
													"Select any one CheckBox");

											return false;
										} else {

											var datalist = 'snoid=' + snoid;

											$
													.ajax({
														type : "GET",
														url : "teachermenuaction.html?method=deleteLeaveRequestAction",
														data : datalist,
														async : false,

														success : function(
																response) {

															var result = $
																	.parseJSON(response);

															$(
																	'.errormessagediv')
																	.hide();
															$(
																	".successmessagediv")
																	.show();
															$(".validateTips")
																	.text(
																			"Leave Request Deleted Successfully");

															setTimeout(
																	function() {

																		location
																				.reload();

																	}, 2000);

														}

													});

										}

									});

					$('#excelDownload')
							.click(
									function() {
										
										var searchTerm = $("#searchterms").val()
										.trim();
										
										
										window.location.href = 'teachermenuaction.html?method=downloadLeaveRequestXLS&searchTerm='
											+ searchTerm;

									});
					$("#pdfDownload")
							.click(
									function() {
										
										var searchTerm = $("#searchterms").val()
										.trim();
										

										window.location.href = "teachermenuaction.html?method=downloadLeaveRequestPDF&searchTerm="
											+ searchTerm;

									});

					$("#search")
							.click(
									function() {
										var searchTerm = $("#searchterm").val()
												.trim();
										window.location.href = "teachermenuaction.html?method=leaveRequest&searchTerm="
												+ searchTerm;

									});

				});

function getvaldetails(value) {

	var s1 = value.id;

	var snoid = s1;

	$("#snoid").val(snoid);

}

function sendrequest() {

	var userhiddenid = $("#userhiddenid").val();

	if (userhiddenid.match("^PAR")) {

		window.location.href = "parentMenu.html?method=requestLeavescreenadd";
	}

	else {

		window.location.href = "teachermenuaction.html?method=teacherLeaveRequestAdd";
	}

}

function editequest() {

	var userhiddenid = $("#userhiddenid").val();

	if (userhiddenid.match("^PAR")) {

		var snoid = $("#snoid").val();
		
		if(snoid==null||snoid=='')
			{
			$(".errormessagediv").show();
			$(".validateTips").text(
					"Select any one CheckBox");
			}
		
		else
			{
		window.location.href = "parentMenu.html?method=editRequestLeaveAction&snoid="
				+ snoid;
			}
	}

	/* if(userhiddenid.match("^TEA")){ */

	else {

		var snoid = $("#snoid").val();
		if(snoid==null||snoid=='')
		{
		$(".errormessagediv").show();
		$(".validateTips").text(
				"Select any one CheckBox");
		}
	
	else
		{

		window.location.href = "teachermenuaction.html?method=editRequestLeaveAction&snoid="
				+ snoid;
		}
	}

}
