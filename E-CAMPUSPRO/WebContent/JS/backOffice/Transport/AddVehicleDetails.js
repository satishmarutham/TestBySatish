$(document)
		.ready(
				function() {

					setTimeout("removeMessage()", 2000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 2000);

					$
							.ajax({
								type : 'POST',
								url : "transport.html?method=getRouteDetails",
								async : false,
								success : function(response) {
									var result = $.parseJSON(response);
									$('#routename').html("");
									$('#routename').append(
											'<option value="' + "" + '">'
													+ "-----Select-----"
													+ '</option>');
									for ( var j = 0; j < result.routelist.length; j++) {
										$('#routename')
												.append(
														'<option value="'
																+ result.routelist[j].routeCode
																+ '">'
																+ result.routelist[j].routeName
																+ '</option>');
									}

								}
							});

					if ($('#updatevehicleCode').val() == null
							|| $('#updatevehicleCode').val() == "") {

						$
								.ajax({
									type : 'POST',
									url : "transport.html?method=getDriverDetails",
									async : false,
									success : function(response) {
										var result = $.parseJSON(response);
										$('#drivername').html("");
										$('#drivername').append(
												'<option value="' + "" + '">'
														+ "-----Select-----"
														+ '</option>');

										for ( var j = 0; j < result.drivernamelist.length; j++) {
											$('#drivername')
													.append(
															'<option value="'
																	+ result.drivernamelist[j].driverCode
																	+ '">'
																	+ result.drivernamelist[j].driverName
																	+ '</option>');
										}

									}
								});
					} else {
						var dataval = {
							"vehicleCode" : $('#updatevehicleCode').val(),
						};

						$
								.ajax({
									type : 'POST',
									url : "transport.html?method=getDriverDetailsWhileUpdate",
									data : dataval,
									async : false,
									success : function(response) {
										var result = $.parseJSON(response);

										for ( var j = 0; j < result.drivernamelist.length; j++) {
											$('#drivername')
													.append(
															'<option value="'
																	+ result.drivernamelist[j].driverCode
																	+ '">'
																	+ result.drivernamelist[j].driverName
																	+ '</option>');
										}
										$(
												"#drivername option[value="
														+ $('#driverCode')
																.val() + "]")
												.attr('selected', 'true');

										$(
												"#routename option[value="
														+ $('#routecodeid')
																.val() + "]")
												.attr('selected', 'true');
									}
								});
					}

					$('#save')
							.click(
									function() {
										var driverCode = "";

										var routename = $("#routename").val();

										if ($("#driverCode").val() == null
												|| $("#driverCode").val() == "") {
											driverCode = $("#drivername").val();
										} else {
											driverCode = $("#driverCode").val();
										}

										var updatevehiclecode = $(
												"#updatevehicleCode").val();

										var status = $("#statusId").val();

										var vehicleregno = $("#vehicleregno")
												.val();
										var vehicletype = $("#vehicletype")
												.val();
										var typeofbody = $("#typeofbody").val();
										var makersname = $("#makersname").val();
										var manufacturerdate = $(
												"#manufacturerdate").val();
										var chassisno = $("#chassisno").val();
										var settingcapacity = $(
												"#settingcapacity").val();
										var fuelengine = $("#fuelengine").val();
										var colorofbody = $("#colorofbody")
												.val();

										var vehiclename = $("#vehiclename")
												.val();

										var companyname = $("#companyname")
												.val();
										var issueddate = $("#issueddate").val();
										var expirydate = $("#expirydate").val();
										var doneby = $("#doneby").val();

										if (vehicleregno == ""
												|| vehicleregno == null) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Enter Vehicle Registration No");
											return false;
										} else if (registernumberValidation() == true) {

											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Vehicle Register No already Exists");
											return false;

										} else if (vehiclename == ""
												|| vehiclename == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Vehicle Name");
											return false;
										} else if (!vehiclename
												.match(/^[a-z]([a-z_" "])+$/i)) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Vehicle Name Should Be Alphabet");
											return false;
										}

										else if (vehicletype == ""
												|| vehicletype == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Vehicle Type");
											return false;
										} else if (!vehicletype
												.match(/^[a-z]([a-z_" "])+$/i)) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Vehicle Type should be Alphabet");
											return false;
										} else if (typeofbody == ""
												|| typeofbody == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Type Of Body");
											return false;
										} else if (!typeofbody
												.match(/^[a-z]([a-z_" "])+$/i)) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Type Of Body should be Alphabet");
											return false;
										} else if (makersname == ""
												|| makersname == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Maker's Name");
											return false;
										} else if (!makersname
												.match(/^[a-z]([a-z_" "])+$/i)) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Maker's Name should be Alphabet");
											return false;
										} else if (manufacturerdate == ""
												|| manufacturerdate == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Manufacturing Date");
											return false;
										} else if (chassisno == ""
												|| chassisno == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Chassis No");
											return false;
										} /*
											 * else if (chassisnovalidation() ==
											 * true) { $( ".errormessagediv")
											 * .show(); $(".validateTips")
											 * .text( "Chassis Number already
											 * Exists"); return false; }
											 */else if (settingcapacity == ""
												|| settingcapacity == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Seating Capacity");
											return false;
										} else if (!settingcapacity
												.match(/^([0-9])+$/i)) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Seating Capacity should be Numeric");
											return false;
										} else if (fuelengine == ""
												|| fuelengine == null) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Select Fuel Used In Engine");
											return false;
										} else if (colorofbody == ""
												|| colorofbody == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Color Of Body");
											return false;
										} else if (!colorofbody
												.match(/^[a-z]([a-z_" "])+$/i)) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Color Of Body should be Alphabet");
											return false;
										}

										else if (companyname == ""
												|| companyname == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Company Name");
											return false;
										} else if (!companyname
												.match(/^[a-z]([a-z_" "])+$/i)) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Company Name should be Alphabet");
											return false;
										} else if (issueddate == ""
												|| issueddate == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Select Issued Date");
											return false;
										} else if (expirydate == ""
												|| expirydate == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Select Expiry Date");
											return false;
										} else if (chkdate == true) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Vehicle Insurance dates already Exists");
											return false;
										} else if (doneby == ""
												|| doneby == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Done By");
											return false;
										} else if (!doneby
												.match(/^[a-zA-Z\s]+$/g)) {
											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Done By should be Numeric");
											return false;
										}

										else if (status == "update"
												&& updateregisternumberValidation()) {

											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Vehicle Register No already Exists");
											return false;
										} else if (status == "update"
												&& updatechassisnovalidation()) {

											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Chassis No already Exists");
											return false;
										} else if (checkforduplicateSave()) {

											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Vehicle Details Already Exists");
											return false;

										} else if (checkforduplicateupdate()
												&& status == "update") {

											$(".errormessagediv").show();
											$(".validateTips")
													.text(
															"Vehicle Details Already Exists");
											return false;
										} else if (routename = ""
												&& routename == null) {

											$(".errormessagediv").show();
											$(".validateTips").text(
													"Select Route Name");
											return false;
										}

										else {
											var datalist = {
												"routename" : $("#routename")
														.val(),
												"vehicleregno" : vehicleregno,
												"vehiclename" : vehiclename,
												"vehicletype" : vehicletype,
												"typeofbody" : typeofbody,
												"makersname" : makersname,
												"manufacturerdate" : manufacturerdate,
												"chassisno" : chassisno,
												"settingcapacity" : settingcapacity,
												"fuelengine" : fuelengine,
												"colorofbody" : colorofbody,
												"companyname" : companyname,
												"issueddate" : issueddate,
												"expirydate" : expirydate,
												"doneby" : doneby,
												"updatevehiclecode" : updatevehiclecode,
												"status" : status,
												"driverCode" : driverCode

											};
											$
													.ajax({
														type : 'POST',
														url : "transport.html?method=saveVehicleDetails",
														data : datalist,
														async : false,
														success : function(data) {

															var result = $
																	.parseJSON(data);

															if (result.status == true) {
																var msg = "Vehicle details Saved Successfully";

																window.location.href = "adminMenu.html?method=vehicleList&message="
																		+ msg;

															} else {
																$(
																		".errormessagediv")
																		.show();
																$(
																		".validateTips")
																		.text(
																				"Vehicle details save Failed");
															}
														}

													});
										}

									});

					var hiddenfuel = $("#hiddenfuelId").val();
					$("#fuelengine option[value=" + hiddenfuel + "]").attr(
							'selected', 'true');

					var chkdate = false;

					$("#manufacturerdate").datepicker({

						dateFormat : "dd-mm-yy",
						maxDate : 0,
						yearRange : "1997",
						changeMonth : true,
						changeYear : true,
						dateFormat : 'dd-mm-yy',
						numberOfMonths : 1,

					});

					$("#issueddate").datepicker(
							{
								dateFormat : "dd-mm-yy",
								yearRange : 'c-65:c+65',
								maxDate : -1,
								changeMonth : "true",
								changeYear : "true",
								yearRange : '1997:' + (new Date).getFullYear(),
								onClose : function(selectedDate) {
									var date2 = $('#issueddate').datepicker(
											'getDate');
									date2.setDate(date2.getDate() + 1);
									$("#expirydate").datepicker("option",
											"minDate", date2);

								}
							});
					$("#expirydate").datepicker(
							{

								dateFormat : "dd-mm-yy",
								yearRange : 'c-65:c+65',
								changeMonth : "true",
								changeYear : "true",
								onClose : function(selectedDate) {

									var date2 = $('#expirydate').datepicker(
											'getDate');
									date2.setDate(date2.getDate() - 1);
									$("#issueddate").datepicker("option",
											"maxDate", date2);

								}
							});

				});

function registernumberValidation() {

	var regno = null;
	var vehicleregno = $("#vehicleregno").val();
	var status = $("#statusId").val();

	var vehicleregnumber = {
		"vehicleregno" : vehicleregno

	};
	if (status != "update") {
		$.ajax({
			type : 'POST',
			url : "transport.html?method=registernumberValidation",
			data : vehicleregnumber,

			success : function(response) {

				var result = $.parseJSON(response);

				if (result.status) {
					regno = true;

					$(".errormessagediv").show();
					$(".validateTips").text(
							"Vehicle Register No already Exists");
					return false;

				} else {
					regno = false;

					$(".errormessagediv1").hide();
				}

			}

		});
	}

	return regno;

}
var regno = null;
function updateregisternumberValidation() {

	var vehicleregno = $("#vehicleregno").val();
	var vehicleCode = $("#updatevehicleCode").val();

	var vehicleregnumber = {
		"vehicleregno" : vehicleregno,
		"vehicleCode" : vehicleCode
	};

	$.ajax({
		type : 'POST',
		url : "transport.html?method=updateregisternumberValidation",
		data : vehicleregnumber,
		async : false,

		success : function(response) {

			var result = $.parseJSON(response);

			if (result.status == true) {
				regno = true;

			} else {
				regno = false;

			}

		}

	});

	return regno;

}

function clearAll() {

	$("#vehicleregno").val("");
	$("#vehicletype").val("");
	$("#typeofbody").val("");
	$("#makersname").val("");
	$("#manufacturerdate").val("");
	$("#chassisno").val("");
	$("#settingcapacity").val("");
	$("#fuelengine").val("");
	$("#colorofbody").val("");

	$("#vehiclename").val("");

	/*
	 * var vehiclename = $( "#vehiclename") .val();
	 */
	$("#companyname").val("");
	$("#issueddate").val("");
	$("#expirydate").val("");
	$("#doneby").val("");
}
function chassisnovalidation() {

	var chas = null;
	var chassisno = $("#chassisno").val();
	var status = $("#statusId").val();

	var chassisnumber = {
		"chassisno" : chassisno

	};
	if (status != "update") {
		$.ajax({
			type : 'POST',
			url : "transport.html?method=chassisnovalidationvalidation",
			data : chassisnumber,

			success : function(response) {

				var result = $.parseJSON(response);

				if (result.status) {
					chas = true;

					$(".errormessagediv").show();
					$(".validateTips").text("Chassis No already Exists");
					return false;

				} else {
					chas = false;

					$(".errormessagediv").hide();
				}

			}

		});
	}

	return chas;

}

var updatechass = null;
function updatechassisnovalidation() {

	var updatechassisno = $("#chassisno").val();
	var vehicleCode = $("#updatevehicleCode").val();

	var chassisnumber = {
		"chassisno" : updatechassisno,
		"vehicleCode" : vehicleCode
	};
	$.ajax({
		type : 'POST',
		url : "transport.html?method=updatechassisnovalidation",
		data : chassisnumber,
		async : false,

		success : function(response) {

			var result = $.parseJSON(response);

			if (result.status) {
				updatechass = true;

				/*
				 * $(".errormessagediv").show();
				 * $(".validateTips").text("Chassis No already Exists");
				 * 
				 * return false;
				 */

			} else {
				updatechass = false;
				/* $(".errormessagediv").hide(); */

			}

		}

	});

	return updatechass;

}

function checkforduplicateSave() {

	var status = $("#statusId").val();

	var isduplicate = null;

	var vehicleregno = $("#vehicleregno").val();
	var vehicletype = $("#vehicletype").val();
	var typeofbody = $("#typeofbody").val();
	var makersname = $("#makersname").val();
	var manufacturerdate = $("#manufacturerdate").val();
	var chassisno = $("#chassisno").val();
	var settingcapacity = $("#settingcapacity").val();
	var fuelengine = $("#fuelengine").val();
	var colorofbody = $("#colorofbody").val();

	var vehiclename = $("#vehiclename").val();

	var vehicledata = {
		"vehicleregno" : vehicleregno,
		"vehiclename" : vehiclename,
		"vehicletype" : vehicletype,
		"typeofbody" : typeofbody,
		"makersname" : makersname,
		"manufacturerdate" : manufacturerdate,
		"chassisno" : chassisno,
		"settingcapacity" : settingcapacity,
		"fuelengine" : fuelengine,
		"colorofbody" : colorofbody,
	};
	if (status != "update") {
		$.ajax({
			type : 'POST',
			url : "transport.html?method=checkforduplicateAddTime",
			data : vehicledata,
			async : false,

			success : function(response) {

				var result = $.parseJSON(response);

				if (result.status) {
					isduplicate = true;

				} else {
					isduplicate = false;

				}

			}

		});
	}

	return isduplicate;

}

var isduplicateupdate = null;
function checkforduplicateupdate() {

	var vehicleCode = $("#updatevehicleCode").val();
	var vehicleregno = $("#vehicleregno").val();
	var vehicletype = $("#vehicletype").val();
	var typeofbody = $("#typeofbody").val();
	var makersname = $("#makersname").val();
	var manufacturerdate = $("#manufacturerdate").val();
	var chassisno = $("#chassisno").val();
	var settingcapacity = $("#settingcapacity").val();
	var fuelengine = $("#fuelengine").val();
	var colorofbody = $("#colorofbody").val();

	var vehiclename = $("#vehiclename").val();

	var vehicledata = {
		"vehicleregno" : vehicleregno,
		"vehiclename" : vehiclename,
		"vehicletype" : vehicletype,
		"typeofbody" : typeofbody,
		"makersname" : makersname,
		"manufacturerdate" : manufacturerdate,
		"chassisno" : chassisno,
		"settingcapacity" : settingcapacity,
		"fuelengine" : fuelengine,
		"colorofbody" : colorofbody,
		"vehicleCode" : vehicleCode
	};
	$.ajax({
		type : 'POST',
		url : "transport.html?method=checkforduplicateUpdateTime",
		data : vehicledata,
		async : false,

		success : function(response) {

			var result = $.parseJSON(response);

			if (result.status) {
				isduplicateupdate = true;

			} else {
				isduplicateupdate = false;

			}

		}

	});

	return isduplicateupdate;

}

function getDriverEntireDetails() {
	var dataval = {
		"driverid" : $('#drivername').val(),
	};
	$.ajax({
		type : 'POST',
		url : "transport.html?method=getDriverEntireDetails",
		data : dataval,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);

			$('#experience').val(result.driverlist[0].experience);
			$('#dlissued').val(result.driverlist[0].dl_issued_date);
			$('#licencedrive').val(result.driverlist[0].license);
			$('#phoneno').val(result.driverlist[0].mobile);
			$('#doj').val(result.driverlist[0].dateofJoin);
			$('#dlno').val(result.driverlist[0].drivingliecenseNo);
			$('#dlexpiray').val(result.driverlist[0].dl_validity);

		}
	});
}

function getRouteEntireDetails() {

	var dataval = {
		"routeid" : $('#routename').val(),
	};
	$.ajax({
		type : 'POST',
		url : "transport.html?method=GetRouteEntireDetails",
		data : dataval,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);
			$('#totalstops').val(result.routelist[0].totalStops);
			$('#totaldistance').val(result.routelist[0].totalDistance);
			$('#routeno').val(result.routelist[0].routeCode);
			$('#halttime').val(result.routelist[0].halttime);
			$('#destination').val(result.routelist[0].destination);
		}
	});
}

function removeMessage() {

	$(".successmessagediv").hide();

}
