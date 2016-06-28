$(document)
		.ready(
				function() {

					$('.errormessagediv1').hide();
					$('.successmessagediv').hide();
					
					$('#excelDownload')
					.click(
							function() {
								
								window.location.href = 'transport.html?method=RouteDetailsXLS';
								
							});
					
					$("#pdfDownload").click(function(){
						
						window.location.href = "transport.html?method=RouteDetailsPDFReport";
							
					});	


					$("#plus")
							.click(
									function() {
										window.location.href = "transport.html?method=addRouteScreen";
									});

					$("#savestops")
							.click(
									function() {

										var allstudent = 1;
										var stopNoArray = [];
										var stopArrivalTimeArray = [];
										var stopDepartureTimeArray = [];
										var stopNameArray = [];
										var stopHaltTimeArray = [];
										var stopDistanceArray = [];
										var status = true;

										var regexpforalphabets = /^[a-zA-Z ]+$/i;
										var regexpforInteger = /^([0-9])+$/;

										$('table#allstudent tr:gt(0)')
												.each(
														function() {

															var stopNo = $(this)
																	.find(
																			'[name=stopNo]')
																	.val()
																	.trim();
															var stop_Name = $(
																	this)
																	.find(
																			'[name=stopName]')
																	.val()
																	.trim();
															var stop_arrTime = $(
																	this)
																	.find(
																			'[name=arrTime]')
																	.val()
																	.trim();
															var stop_haltTime = $(
																	this)
																	.find(
																			'[name=haltTime]')
																	.val()
																	.trim();
															var stop_deptTime = $(
																	this)
																	.find(
																			'[name=depTime]')
																	.val()
																	.trim();
															var stop_distance = $(
																	this)
																	.find(
																			'[name=distance]')
																	.val()
																	.trim();

															if (stopNo != undefined
																	&& stopNo != '') {
																stopNoArray
																		.push(stopNo);
																status = true;
															}

															if (stop_Name == ""
																	|| stop_Name == null) {

																$(
																		'.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Stop Name field is not entered for "
																						+ stopNo);
																status = false;
																return false;
															} /*
																 * else if
																 * (!(regexpforalphabets
																 * .test(stop_Name
																 * .trim()))) { $(
																 * '.errormessagediv1')
																 * .show(); $(
																 * '.validateTips1')
																 * .text( "Stop
																 * Name field
																 * allows
																 * Characters
																 * only for " +
																 * stopNo);
																 * status =
																 * false; return
																 * false; }
																 */else if (stop_Name != undefined
																	&& stop_Name != '') {
																stopNameArray
																		.push(stop_Name);
																status = true;
															}

															if (stop_arrTime == ''
																	|| stop_arrTime == null) {

																$(
																		'.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Arrival Time field is not selected for "
																						+ stopNo);
																status = false;
																return false;
															} else if (stop_arrTime != undefined
																	&& stop_arrTime != '') {
																stopArrivalTimeArray
																		.push(stop_arrTime);
																status = true;
															}

															if (stop_haltTime == ''
																	|| stop_haltTime == null) {

																$(
																		'.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Halt Time field is not entered for "
																						+ stopNo);
																status = false;
																return false;
															} else if (!(regexpforInteger
																	.test(stop_haltTime
																			.trim()))) {

																$(
																		'.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Halt Time field allows Number only for "
																						+ stopNo);
																status = false;
																return false;
															} else if (stop_haltTime != undefined
																	&& stop_haltTime != '') {
																stopHaltTimeArray
																		.push(stop_haltTime);
																status = true;
															}

															if (stop_deptTime == ''
																	|| stop_deptTime == null) {

																$(
																		'.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Departure Time field is not selected for "
																						+ stopNo);
																status = false;
																return false;
															} else if (stop_deptTime != undefined
																	&& stop_deptTime != '') {
																stopDepartureTimeArray
																		.push(stop_deptTime);
																status = true;
															}

															if (stop_distance == ''
																	|| stop_distance == null) {

																('.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Distance field is not entered for "
																						+ stopNo);
																status = false;
																return false;
															} else if (!(regexpforInteger
																	.test(stop_distance
																			.trim()))) {

																('.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Distance field allows Number only for "
																						+ stopNo);
																status = false;
																return false;
															} else if (stop_distance != undefined
																	&& stop_distance != '') {
																stopDistanceArray
																		.push(stop_distance);
																status = true;
															}
															allstudent++;
														});
										if (status == true) {

											var answer = confirm("Are you sure to Add Route Details");
											if (answer) {

												$('#stopNoArray').val(
														stopNoArray);
												$('#stopArrivalTimeArray').val(
														stopArrivalTimeArray);
												$('#stopNameArray').val(
														stopNameArray);
												$('#stopHaltTimeArray').val(
														stopHaltTimeArray);
												$('#stopDistanceArray').val(
														stopDistanceArray);
												$('#stopDepartureTimeArray')
														.val(
																stopDepartureTimeArray);

												document.getElementById(
														"formRoute").submit();

												/*
												 * $("#formRoute")
												 * .attr('action',
												 * 'transportdetails.html?parameter=addRoute');
												 * $('#methodNameId').val(
												 * 'addRoute');
												 * $("#formRoute").submit();
												 */

											}
										}

									});

					$("#list")
							.click(
									function() {
										window.location.href = "adminMenu.html?method=routeMasterSettings";
									});

					$("#searchid")
							.click(
									function() {
										var searchid = $("#search").val()
												.trim();
										window.location.href = "adminMenu.html?method=routeMasterSettings&searhval="
												+ searchid;

									});

					$("#save")
							.click(
									function() {

										var routeName = $('#routeName').val()
												.trim();
										var routeNo = $('#routeNo').val()
												.trim();

										var routeLogicName = $(
												'#routeLogicName').val();

										var destination = $('#destination')
												.val().trim();
										var totalStops = $('#totalStops').val()
												.trim();

										var startTime = $('#starttime').val()
												.trim();
										var endTime = $('#endtime').val()
												.trim();

										var totalDistance = $('#totalDistance')
												.val().trim();

										var halttime = $('#halttime').val()
												.trim();

										var routeid = $('#routeid').val()
												.trim();

										if (!checkTime()) {
											$('.errormessagediv1').show();
											$('.validateTips1')
													.text(
															"Start time should be less then End time");
											return false;
										}
										if (routeNo == "" || routeNo == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter Route No");
											return false;
										} else if (checkRouteNo()) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Route No already Exist");
											return false;
										} else if (routeName == ""
												|| routeName == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter Route Name");
											return false;
										} else if (destination == ""
												|| destination == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter Destination");
											return false;
										} else if (!destination
												.match("^[a-zA-Z]+$")) {
											$('.errormessagediv1').show();
											$('.validateTips1')
													.text(
															"Destination should be Alphabets");
											return false;
										} else if (totalStops == ""
												|| totalStops == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter Total Stops");
											return false;
										} else if (!totalStops
												.match("^[0-9]+$")) {
											$('.errormessagediv1').show();
											$('.validateTips1')
													.text(
															"Total Stops should be Numbers");
											return false;
										} else if (totalDistance == ""
												|| totalDistance == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter Total Distance");
											return false;
										} else if (!totalDistance
												.match("^[0-9]+$")) {
											$('.errormessagediv1').show();
											$('.validateTips1')
													.text(
															"Total Distance should be Numbers");
											return false;
										} else if (startTime == ""
												|| startTime == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Select Start Time");
											return false;
										} else if (endTime == ""
												|| endTime == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Select End Time");
											return false;
										} else if (halttime == ""
												|| halttime == null) {
											$('.errormessagediv1').show();
											$('.validateTips1').text(
													"Enter Total Halt Time");
											return false;
										} else if (!halttime.match("^[0-9]+$")) {
											$('.errormessagediv1').show();
											$('.validateTips1')
													.text(
															"Total Halt Time should be Numbers");
											return false;
										} else {
											if (routeid == ""
													|| routeid == null) {
												routeid = "NULL";
											}
											var Check = {
												"routeName" : routeName,
												"routeNo" : routeNo,
												"routeLogicName" : routeLogicName,
												"destination" : destination,
												"halttime" : halttime,
												"totalStops" : totalStops,
												"startTime" : startTime,
												"endTime" : endTime,
												"totalDistance" : totalDistance,
												"routeid" : routeid

											};

											$
													.ajax({
														type : "POST",
														url : "transport.html?method=insertRouteMasterDetails",
														data : Check,
														async : false,
														success : function(data) {
															var result = $
																	.parseJSON(data);
															if (result.status == "success") {
																$(
																		'.successmessagediv')
																		.show();
																$(
																		'.successmessage')
																		.text(
																				"Route Inserted Successfully");
																setTimeout(
																		function() {

																			window.location.href = "transport.html?method=addRouteScreen";

																		}, 3000);
															} else if (result.status == "faild") {
																$(
																		'.errormessagediv1')
																		.show();
																$(
																		'.validateTips1')
																		.text(
																				"Route Insertion failed");
																setTimeout(
																		function() {

																			window.location.href = "transport.html?method=addRouteScreen";

																		}, 3000);
															}

														}
													});

										}
									});

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
													"Select Any One Route");
										} else {

											window.location.href = "transport.html?method=editRouteMasterDetails&Code="
													+ getData[0];

										}

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
													"Select Any One Route");
										} else {

											var Check = {
												"Code" : getData[0]
											};
											$
													.ajax({
														type : "POST",
														url : "transport.html?method=removeRouteMasterDetails",
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
																				"Route Deleted Successfully");
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
																				"Route already mapped can't Delete");

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

$(document).ready(function() {
	$('#datetimepicker3').datetimepicker({
		pickDate : false
	});
	$('#datetimepicker4').datetimepicker({
		pickDate : false
	});
	createRow($('#totalstopsid').val().trim());
});

function createRow(val1) {
	/*
	 * var tt = $('table#allstudent tr:last input[name=stopNo]').val(); if ((tt !=
	 * undefined) && (tt != '')) { var thenum = tt.replace(/^\D+/g, ''); for (
	 * var i = thenum; i > 0; i--) { removeRow(i); } }
	 */

	var value = val1;
	allstudent = 0;
	for ( var j = 0; j < value; j++) {
		addMoreRows();
	}
}

function removeRow(removeNum) {

	jQuery('#rowId' + removeNum).remove();
}

var allstudent = 0;
function addMoreRows() {
	allstudent++;
	$('#allstudent tr')
			.last()
			.after(
					'<tr id="rowId'
							+ allstudent
							+ '" cellpadding="5" cellspacing="5"><td><input value="    '
							+ allstudent
							+ '" type="text" name="stopNo" readonly="readonly" style="margin-left: 8px;height: 108%" size="3%""/></td><td><select name="stopName" id="stopName'
							+ allstudent
							+ '" class="form-control" onClick="return testFunction(this)"><option value=" ">----------Select----------</option></select><input type="hidden" class="htageid" id="htageid'
							+ allstudent
							+ '"></td><td class="arrivalTime"><div onclick="return getTime();" class="datetimepicker input-append"><input type="text" class="form-control" data-format="hh:mm" size="20%" name="arrTime" onblur="getDeptTime('
							+ allstudent
							+ ');" /><img src="./images/time1.jpg" width="25" height="20" class="add-on" style="margin-top:-14%;margin-left: 86%;"/></div></td><td><input name="haltTime" class="haltTime" id="haltTimeID" readonly="readonly" type="text"  maxlength="2" style="width: 38px;height: 32px;margin: 0 40px;    text-align: center;" /></td><td><input name="depTime" readonly="readonly" class="form-control" type="text" maxlength="5" /></td><td><input type="text" name="distance" class="form-control"   maxlength="3" /></td></td></tr>');

	$('.haltTime').val($('#hidstopid').val());

	$.ajax({
		type : 'POST',
		url : "transport.html?method=getStopNames",
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);

			for ( var j = 0; j < result.stopslist.length; j++) {
				$("#stopName" + allstudent).append(
						'<option value="' + result.stopslist[j].stageCode
								+ '">' + result.stopslist[j].stageName
								+ '</option>');
			}

		}
	});

	/*
	 * <select class="form-control" name="category" id="category"> <option
	 * value=" ">----------Select----------</option> </select>
	 */

}
function getTime() {
	$('.datetimepicker').datetimepicker({
		pickDate : false,
		onClose : function() {
			getDeptTime(removeNum);
		}
	});
}
function getDeptTime(removeNum) {
	var dept_time = "";

	var regexpforInteger = /^([0-9])+$/;
	$('table#allstudent td input[name=arrTime]').blur(
			function() {
				var arrival_Time = $(this).parents('tr:first').find(
						'td:nth-child(3)').find('input').val().trim();
				var halt_Time = $(this).parents('tr:first').find(
						'td:nth-child(4)').find('input').val().trim();

				if ((arrival_Time != '') && (halt_Time != '')
						&& (regexpforInteger.test(halt_Time.trim()))) {

					var t1 = arrival_Time.split(/\D/);

					var x1 = parseInt(t1[0]) * 60 * 60 + parseInt(t1[1]) * 60;
					var x2 = parseInt('00') * 60 * 60 + parseInt(halt_Time)
							* 60;
					var s = x1 + x2;
					var m = Math.floor(s / 60);
					s = s % 60;
					var h = Math.floor(m / 60);
					m = m % 60;
					if (h.toString().length == 1) {
						h = "0" + h;
					}
					if (m.toString().length == 1) {
						m = "0" + m;
					}
					dept_time = h + ":" + m;
					$(this).parents('tr:first').find('td:nth-child(5)').find(
							'input').val(dept_time);
				}
			});
}

function testFunction(current) {

	var curid = "#" + current.id;

	// var arr = current.id.split('stopName');

	// var stagid = "#htageid" + arr[1].trim();

	$.ajax({
		type : 'POST',
		url : "transport.html?method=getStopNames",
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);
			/* $(curid).html(""); */
			/*
			 * $(curid).append( '<option value="' + "" + '">' +
			 * "-----Select-----" + '</option>');
			 */

			for ( var j = 0; j < result.stopslist.length; j++) {
				$(curid).append(
						'<option value="' + result.stopslist[j].stageCode
								+ '">' + result.stopslist[j].stageName
								+ '</option>');
			}

		}
	});

	/*
	 * $(curid).autocomplete({ source : function(request, response) {
	 * 
	 * $.ajax({
	 * 
	 * url : "transport.html?method=getStopNames", data : { searchTerm :
	 * request.term }, async : false, success : function(data) { var result =
	 * $.parseJSON(data);
	 * 
	 * response($.map(result.stopslist, function(item) { return { label :
	 * item.stageName, value : item.stageCode, } })); } }); },
	 * 
	 * select : function(event, ui) {
	 * 
	 * $(curid).val(ui.item.label); $(stagid).val(ui.item.value);
	 * 
	 * return false; }
	 * 
	 * });
	 */

}
var status = false;
function checkTime() {

	var ftime = document.getElementById("starttime").value;
	var ttime = document.getElementById("endtime").value;

	if ((ftime != "") && (ttime != "")) {

		var ftimeSplitHour = ftime.split(':')[0];
		var ftimeSplitMin = ftime.split(':')[1];
		var ftimeSplitSec = ftime.split(':')[2];

		var ttimeSplitHour = ttime.split(':')[0];
		var ttimeSplitMin = ttime.split(':')[1];
		var ttimeSplitSec = ttime.split(':')[2];

		if (ftimeSplitHour.charAt(0) == 0) {
			ftimeSplitHour = ftimeSplitHour.charAt(1);
		}
		if (ttimeSplitHour.charAt(0) == 0) {
			ttimeSplitHour = ttimeSplitHour.charAt(1);
		}

		if (ftimeSplitMin.charAt(0) == 0) {
			ftimeSplitMin = ftimeSplitMin.charAt(1);
		}
		if (ttimeSplitMin.charAt(0) == 0) {
			ttimeSplitMin = ttimeSplitMin.charAt(1);
		}

		if (ftimeSplitSec.charAt(0) == 0) {
			ftimeSplitSec = ftimeSplitSec.charAt(1);
		}
		if (ttimeSplitSec.charAt(0) == 0) {
			ttimeSplitSec = ttimeSplitSec.charAt(1);
		}

		ftimeSplitHour = parseInt(ftimeSplitHour);
		ttimeSplitHour = parseInt(ttimeSplitHour);
		ftimeSplitMin = parseInt(ftimeSplitMin);
		ttimeSplitMin = parseInt(ttimeSplitMin);

		ftimeSplitSec = parseInt(ftimeSplitSec);
		ttimeSplitSec = parseInt(ttimeSplitSec);

		if (ftimeSplitHour > ttimeSplitHour) {
			$(".errormessagediv").show();
			$(".validateTips").text(
					"The End Time should not less than Start Time");
			return false;
			status = false;
			document.getElementById("endtime").value = "";
		}
		if (ttimeSplitHour == ftimeSplitHour) {
			if (ftimeSplitMin > ttimeSplitMin) {
				$(".validateTips").text(
						"The End Time should not less than Start Time");
				$(".errormessagediv").show();

				return false;
				status = false;
				document.getElementById("endtime").value = "";

			}
			if (ftimeSplitMin == ttimeSplitMin) {
				if (ftimeSplitSec >= ttimeSplitSec) {
					$(".validateTips").text(
							"The End Time should not less than Start Time");
					$(".errormessagediv").show();

					return false;
					status = false;
					document.getElementById("endtime").value = "";
				}
			}
		} else {
			$(".errormessagediv").hide();
			status = true;
		}
	} else {
		status = true;
	}
	return status;
}

function checkRouteNo() {
	routeid = $("#routeid").val().trim();

	if (routeid == "" || routeid == null) {
		routeid = "NULL";
	}
	var checkName = {
		"routeNo" : $("#routeNo").val(),
		"routeid" : routeid
	};
	var status = false;
	$.ajax({
		type : "POST",
		url : "transport.html?method=checkrouteNo",
		data : checkName,
		async : false,
		success : function(data) {

			var result = $.parseJSON(data);
			text = result.status;

			if (text == true) {
				$('.errormessagediv1').show();
				$('.validateTips1').text("Route No already Exist");
				status = true;
			} else {
				$('.errormessagediv1').hide();
			}
		}
	});

	return status;

}
