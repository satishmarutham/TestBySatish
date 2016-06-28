function removeMessage() {

	$(".successmessagediv").hide();
	$(".errormessagediv").hide();
	$(".errormessagediv1").hide();

}

$(document)
		.ready(
				function() {

					setTimeout("removeMessage()", 3000);
					setInterval(function() {

						$(".errormessagediv").hide();
					}, 3000);

					getClass();
					// $("#role option[value='"+ result.roleVo[0].roleId
					// +"']").attr("selected", "selected");
					var hiddenStreamId = $("#hiddenStreamId").val().trim();
					if (hiddenStreamId != undefined) {

						$("#classId option[value=" + hiddenStreamId + "]")
								.attr('selected', 'true');

					}

					$('#classSave')
							.click(
									function() {
										var classId = $('#classId').val();
										var sectionName = $('#sectionName')
												.val();
										var sectionStrength = $(
												'#sectionStrength').val();
										var status = $('#statusId').val();
										var updateClassCode = $(
												'#updateClassCode').val();

										if (classId == "" || classId == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Select Class");

											return false;
										} else if (sectionName == ""
												|| sectionName == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Section Name");
											return false;
										} else if (!classId
												.match(/^[a-zA-Z0-9\s]+$/i)) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Proper Stream Name");
											return false;
										} else if (sectionStrength == ""
												|| sectionStrength == null) {
											$(".errormessagediv").show();
											$(".validateTips").text(
													"Enter Section Strength");
											return false;
										} else {

											window.location.href = "sectionPath.html?method=insertSection&classId="
													+ classId
													+ "&sectionName="
													+ sectionName
													+ "&sectionStrength="
													+ sectionStrength
													+ "&status="
													+ status
													+ "&updateClassCode="
													+ updateClassCode;

											/*
											 * $.ajax({ type : 'POST', url :
											 * "sectionPath.html?method=insertSection",
											 * data : datalist, success :
											 * function( response) { var result =
											 * $.parseJSON(response);
											 * 
											 * if (result.status == true) { var
											 * msg = "Section Deleted
											 * Successfully";
											 * window.location.href =
											 * "adminMenu.html?method=sectionList&msg=" +
											 * msg;
											 * 
											 *  } else { var msg = "Class is
											 * mapped Cannot delete";
											 * window.location.href =
											 * "adminMenu.html?method=sectionList&msg="+msg;
											 *  } }
											 * 
											 * });
											 */
										}

									});

					$('#editClass')
							.click(
									function() {

										$(".errormessagediv1").hide();
										var cnt = 0;
										$(
												'input.class_Checkbox_Class:checkbox:checked')
												.map(
														function() {
															if (cnt > 0) {
																$(
																		".errormessagediv")
																		.show();
																$(
																		'.validateTips')
																		.text(
																				"You can update only one Class Details at a time");
																cnt++;
																return false;
															} else {
																var check_id = $(
																		this)
																		.attr(
																				"id");
																var split_id = check_id
																		.split('_');
																getData = split_id[1]
																		.split(',');
																var classCode = getData[0];
																cnt++;
															}
														});
										if (cnt == 0) {

											$(".errormessagediv").show();
											$('.validateTips').text(
													"Select Class to Update");
										}
										if (cnt == 1) {

											window.location.href = "classPath.html?method=editClass&classCode="
													+ classCode;

										}

									});

				});

function checkClassName() {
	var className = $("#className").val();
	var stream = $("#stream").val();

	var updateClassCode = $('#updateClassCode').val();
	var checkClassName = {
		"className" : className,
		"stream" : stream,
		"updateClassCode" : updateClassCode,
	};

	var status = false;

	$.ajax({
		type : "POST",
		url : "classPath.html?method=classNameCheck",
		data : checkClassName,
		async : false,
		success : function(data) {

			var result = $.parseJSON(data);

			status = result.status;

		}
	});

	return status;

}

function getClass() {
	$
			.ajax({
				url : "sectionPath.html?method=getCampusClassDetailsIDandClassDetailsNameAction",
				async : false,
				success : function(data) {

					var result = $.parseJSON(data);
					for ( var j = 0; j < result.classDetailsIDandClassDetailsNameList.length; j++) {

						$('#classId')
								.append(
										'<option value="'
												+ result.classDetailsIDandClassDetailsNameList[j].secDetailsId
												+ '">'
												+ result.classDetailsIDandClassDetailsNameList[j].secDetailsName
												+ '</option>');

					}

				}
			});
}

function HideError() {
	document.getElementById("streamId").style.border = "1px solid #ccc";
	document.getElementById("streamId").style.backgroundColor = "#fff";
	document.getElementById("className").style.border = "1px solid #ccc";
	document.getElementById("className").style.backgroundColor = "#fff";
	document.getElementById("className").style.border = "1px solid #ccc";
	document.getElementById("className").style.backgroundColor = "#fff";

}
