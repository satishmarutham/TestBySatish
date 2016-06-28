/*$(document).ready(
		function() {

			if ($('#duplicateid').val() == "status") {
				$("#fromdate").val("12-11-2015");
				$("#todate").val("12-11-2015");
				$("#startdate").val("12-11-2015");
				$("#enddate").val("12-11-2015");
				$("#reason").val("Fever");
				$("#totalleaves").val("2");
				$("#requested option[value=" + "Chiru" + "]").attr('selected',
						'true');
				$("#leavetype option[value=" + "SL" + "]").attr('selected',
						'true');
				$("#noofleave").val("2");
				$("#requested option[value=" + "Chiru" + "]").attr('selected',
						'true');
				$("#leavestatus option[value=" + "APPROVE" + "]").attr(
						'selected', 'true');
				$("#description").val("Approved");

			}

			$("#fromdate").datepicker({

				dateFormat : "dd-mm-yy",
				changeMonth : "true",
				changeYear : "true",
				buttonImage : "images/calendar.GIF",
				buttonImageOnly : true

			});
			$("#todate").datepicker({

				dateFormat : "dd-mm-yy",
				changeMonth : "true",
				changeYear : "true",
				buttonImage : "images/calendar.GIF",
				buttonImageOnly : true

			});
			$("#startdate").datepicker({

				dateFormat : "dd-mm-yy",
				changeMonth : "true",
				changeYear : "true",
				buttonImage : "images/calendar.GIF",
				buttonImageOnly : true

			});
			$("#enddate").datepicker({

				dateFormat : "dd-mm-yy",
				changeMonth : "true",
				changeYear : "true",
				buttonImage : "images/calendar.GIF",
				buttonImageOnly : true

			});
		});*/

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

					$(".successmessagediv").hide();
					$(".validateTips").hide();

					var sucessmsg = $('#success').val();

					if (!sucessmsg == "") {
						$(".errormessagediv").hide();
						$(".successmessagediv").show();
						$(".validateTips").show();
						$(".validateTips").text("Leave Updated Successfully");
					}

					var leavetype = $('#leavetype').val();

					var hidden1 = $('#hiddenleavetype').val();

					$("#leavetype option[value=" + hidden1 + "]").attr(
							'selected', 'true');

					var hidden2 = $('#hiddenstartsession').val();

					$("#startsessionDay option[value=" + hidden2 + "]").attr(
							'selected', 'true');

					var hidden3 = $('#hiddenendsession').val();

					$("#endsessionDay option[value=" + hidden3 + "]").attr(
							'selected', 'true');

					$("#startsessionDay").attr("disabled", 'true');
					$("#leavetype").attr("disabled", 'true');
					$("#endsessionDay").attr("disabled", 'true');

					$("#search")
							.click(
									function() {
										//alert("search is working");

										var searchTerm = $("#searchterm").val()
												.trim();

										//alert("searchTerm" + searchTerm);

										window.location.href = "teachermenuaction.html?method=leaveApproval&searchTerm="
												+ searchTerm;

									});

					$('#excelDownload')
							.click(
									function() {
										var searchTerm = $("#searchid").val()
										.trim();
										//alert(searchTerm);

										window.location.href = 'teachermenuaction.html?method=downloadLeaveDetailsXLS&searchTerm='
											+ searchTerm;

									});
					$("#pdfDownload")
							.click(
									function() {
										var searchTerm = $("#searchid").val()
										.trim();

										window.location.href = "teachermenuaction.html?method=downloadLeaveDetailsPDF&searchTerm="
											+ searchTerm;

									});

					$("#editleaveapproval")
							.click(
									function() {

										var snoid = $("#snoid").val();

										if (snoid == "" || snoid == null) {

											$(".errormessagediv").show();
											$(".validateTips1").text(
													"Select any one CheckBox");

											return false;
										}

										else {

											window.location.href = "teachermenuaction.html?method=LeaveApprovalScreen&snoid="
													+ snoid;
										}

									});
					$("#fromdate").datepicker({

						dateFormat : "dd-mm-yy",
						changeMonth : "true",
						changeYear : "true",
						buttonImage : "images/calendar.GIF",
						buttonImageOnly : true

					});
					$("#todate").datepicker({

						dateFormat : "dd-mm-yy",
						changeMonth : "true",
						changeYear : "true",
						buttonImage : "images/calendar.GIF",
						buttonImageOnly : true

					});
					$("#approvedstartdate").datepicker({

						dateFormat : "dd-mm-yy",
						changeMonth : "true",
						changeYear : "true",
						buttonImage : "images/calendar.GIF",
						buttonImageOnly : true

					});
					$("#approvedenddate").datepicker({

						dateFormat : "dd-mm-yy",
						changeMonth : "true",
						changeYear : "true",
						buttonImage : "images/calendar.GIF",
						buttonImageOnly : true

					});
					var snoid = $("#snoid").val();

					$(
							'#approvedstartdate,#approvedenddate,#approvedstartsessionDay,#approvedendsessionDay')
							.change(
									function()

									{

										var total = "";
										var shalfday = $(
												'#approvedstartsessionDay')
												.val();
										var ehalfday = $(
												'#approvedendsessionDay').val();

										var date1 = $('#approvedstartdate')
												.val();
										startDate = date1.split("-");
										var dstartdate = new Date(startDate[2],
												startDate[1] - 1, startDate[0]);

										var date2 = $('#approvedenddate').val();
										endDate = date2.split("-");
										var denddate = new Date(endDate[2],
												endDate[1] - 1, endDate[0]);

										var oneDay = 24 * 60 * 60 * 1000; // hours*minutes*seconds*milliseconds

										var diffDays = Math
												.round(Math.abs((dstartdate
														.getTime() - denddate
														.getTime())
														/ (oneDay)));

										var total_leave = diffDays + 1;

										if (shalfday == "FH"
												&& ehalfday == "FH") {

											total = total_leave - 0.5;

										}

										else if (shalfday == "FH"
												&& ehalfday == "SH") {

											total = total_leave;
										}

										else if (shalfday == "SH"
												&& ehalfday == "SH") {

											total = total_leave - 0.5;

										} else if ((shalfday == "SH" && ehalfday == "FH")) {

											total = total_leave - 1;

										}

										var d1 = Date
												.parse(dateConverter(date1));
										var d2 = Date
												.parse(dateConverter(date2));
										if (d1 > d2) {

											$("#errormessagediv1").show();
											$(".validateTips1")
													.text(
															"StartDate Should Be Less Then EndDate");
											setTimeout(function() {
												$('#errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;
										}

										var total_reqleaves = $('#noofleaves')
												.val();

										$('#totalleavesapproved').val("");
										if (total > total_reqleaves) {
											$("#errormessagediv1").show();
											$(".validateTips1")
													.text(
															"Approved Leaves Should be Less than Requested Leaves");
											setTimeout(function() {
												$('#errormessagediv1')
														.fadeOut();
											}, 3000);

										} else
											$('#leavesapproved').val(total);

									});

					$("#submit")
							.click(
									function() {

										var snoid = $("#snoid").val();

										var fdate = $('#fromdate').val();
										var edate = $('#todate').val();
										var approved_leaves = $(
												'#leavesapproved').val();
										var total_leaves_approved = $(
												'#approvedleavestatus').val();
										var ApprovedStartdate = $(
												'#approvedstartdate').val();
										var ApprovedEndDate = $(
												'#approvedenddate').val();
										var comments = $('#comments').val();
										var approvedstartsessionDay = $(
												"#approvedstartsessionDay")
												.val();

										var approvedendsessionDay = $(
												"#approvedendsessionDay").val();

										var d1 = Date
												.parse(dateConverter(fdate));
										var d2 = Date
												.parse(dateConverter(edate));
										var d3 = Date
												.parse(dateConverter(ApprovedStartdate));
										var d4 = Date
												.parse(dateConverter(ApprovedEndDate));
										var d5 = d4 - d3;
										var days = Math
												.round((d5 / 1000 / 60 / 60 / 24) + 1);
										var approvedleaves = Math
												.round(approved_leaves);

										if (ApprovedStartdate == ""
												|| ApprovedStartdate == null) {

											$(".errormessagediv1").show();
											$(".validateTips1")
													.text(
															" Approved StartDate Should Not Be Empty");

											setTimeout(function() {
												$('.errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;

										}

										else if (d1 > d3) {

											$(".errormessagediv1").show();
											$(".validateTips1")
													.text(
															" Approved StartDate Should Match Requested FromDate");

											setTimeout(function() {
												$('.errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;
										}

										else if (ApprovedEndDate == ""
												|| ApprovedEndDate == null) {

											$(".errormessagediv1").show();
											$(".validateTips1")
													.text(
															" Approved EndDate Should Not Be Empty");

											setTimeout(function() {
												$('.errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;

										}

										else if (d2 < d4 || d1 > d4) {

											$(".errormessagediv1").show();
											$(".validateTips1")
													.text(
															" Approved EndDate Should Match Requested ToDate");

											setTimeout(function() {
												$('.errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;
										}

										else if (approved_leaves == ""
												|| approved_leaves == null) {

											$(".errormessagediv1").show();
											$(".validateTips1")
													.text(
															"No Of Leaves Should Not Be Empty");

											setTimeout(function() {
												$('.errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;

										}

										else if (approvedleaves != days) {

											$(".errormessagediv1").show();
											$(".validateTips1")
													.text(
															"Total Leaves Approved Doesn't Match With Start Date & End Date");
											$(".validateTips1")
													.text(
															" Approved Leaves should not be Empty");

											setTimeout(function() {
												$('.errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;
										}

										else if (approvedstartsessionDay == ''
												|| approvedstartsessionDay == null) {
											$(".errormessagediv1").show();
											$(".validateTips1")
													.text(
															"Start Session Should Not Be Empty");

											setTimeout(function() {
												$('.errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;
										} else if (approvedendsessionDay == ''
												|| approvedendsessionDay == null) {
											$(".errormessagediv1").show();
											$(".validateTips1")
													.text(
															"End Session Should Not Be Empty");

											setTimeout(function() {
												$('.errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;
										} else if (total_leaves_approved == ''
												|| total_leaves_approved == null) {
											$(".errormessagediv1").show();
											$(".validateTips1")
													.text(
															"Leave Status Should Not Be Empty");

											setTimeout(function() {
												$('.errormessagediv1')
														.fadeOut();
											}, 3000);
											return false;
										}

										else {

											var leavesapproved = $(
													"#leavesapproved").val();
											var approvedstartdate = $(
													"#approvedstartdate").val();
											var approvedleavestatus = $(
													"#approvedleavestatus")
													.val();
											var comments = $("#comments").val();
											var approvedenddate = $(
													"#approvedenddate").val();
											var approvedstartsessionDay = $(
													"#approvedstartsessionDay")
													.val();

											var approvedendsessionDay = $(
													"#approvedendsessionDay")
													.val();

											window.location.href = "teachermenuaction.html?method=ApprovingLeaveforleaveRequest&snoid="
													+ snoid
													+ "&leavesapproved="
													+ leavesapproved
													+ "&approvedstartdate="
													+ approvedstartdate
													+ "&approvedenddate="
													+ approvedenddate
													+ "&approvedstartsessionDay="
													+ approvedstartsessionDay
													+ "&approvedendsessionDay="
													+ approvedendsessionDay
													+ "&approvedleavestatus="
													+ approvedleavestatus
													+ "&comments=" + comments;
										}
									});

				});

function getvaldetails(value) {

	var s1 = value.id;

	var snoid = s1;
	/*
	 * alert("snoid "+snoid);
	 */
	$("#snoid").val(snoid);

}
function dateConverter(dateString) {
	var dateArray = [];
	var dateStringArray = dateString.split("-");
	dateArray.push(dateStringArray[2]);
	dateArray.push(dateStringArray[1]);
	dateArray.push(dateStringArray[0]);
	var dateString1 = dateArray.join("-");
	return dateString1;

}
