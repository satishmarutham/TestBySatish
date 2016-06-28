$(document)
		.ready(
				function()

				{

					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);

					
					
					
					
					$("#totalleave").change(function() {

						var total = $('#totalleave').val();
						if (total <= 5 && total > 0) {
							var permonth = 1;
							$("#allowedleave").val(permonth);
						} else if (total == 0) {
							var permonth = 0;
							$("#allowedleave").val(permonth);
						} else {
							calculate(total);
						}
					});

					function calculate(total) {

						var permonth = Math.round(total / 12);
						$("#allowedleave").val(permonth);

					}
					
					
					
					$("#paidleave,#sickleave,#casualleave").change(function()
							
							{
								
								var pl = $("#paidleave").val();
								
								var sl = $("#sickleave").val();
								
								var cl = $("#casualleave").val();
								
								var totalval=Number(pl) + Number(sl) + Number(cl);
								
								$("#totalleave").val(totalval);
								
								if (totalval <= 5 && totalval > 0) {
									var permonth = 1;
									$("#allowedleave").val(permonth);
								} else if (totalval == 0) {
									var permonth = 0;
									$("#allowedleave").val(permonth);
								} else {
									calculate(totalval);
								}
								
								
								
								
							});
					
					
					
					
				$("#search")
					.click(
							function()

							{
								var searchvalue = $('#searchvalue').val();
						
								
								window.location.href = "adminMenu.html?method=LeaveBankList&searchvalue="
									+ searchvalue;
								

							});		
										
					
					var hidden1 = $('#hiddenAccYear').val();

					$("#academicyear option[value=" + hidden1 + "]").attr(
							'selected', 'true');

					
					$('#xlss')
					.click(
							function() {
								
								window.location.href = 'leavebank.html?method=leavebankexcel';
								
							});

					$("#pdfDownload").click(function(){
						
						window.location.href = "leavebank.html?method=leavebankpdf";
							
					});	
					
					
					$('#addleavebank')
					.click(
							function()

							{

								window.location.href = "leavebank.html?method=addingleavebankscreen";

							});
					
					$('#submit')
					.click(
							function()

							{


                              var snoid = $("#snoid").val();
								
								//alert("snoid"+snoid);

								var academicyear = $('#academicyear').val();

								var paidleave = $('#paidleave')	.val();
								
								var totalleave = $('#totalleave')	.val();

								var sickleave = $('#sickleave')	.val();

								var casualleave = $('#casualleave')	.val();
								
								var allowedleave = $('#allowedleave')	.val();

						
								if(academicyear=="----Select----")
									{
									$(".errormessagediv").show();
									$(".validateTips").text(
											"Select Academic Year");

									return false;
									}
								
								else if(sickleave==""||sickleave==null)
								{
								$(".errormessagediv").show();
								$(".validateTips").text(
										"Enter Sick Leave");

								return false;
								}
								else if(paidleave==""||paidleave==null)
								{
								$(".errormessagediv").show();
								$(".validateTips").text(
										"Enter Paid Leave");

								return false;
								}
								else if(casualleave==""||casualleave==null)
								{
								$(".errormessagediv").show();
								$(".validateTips").text(
										"Enter Casual Leave");

								return false;
							}
							
								else{
											
								
											datalist = {
												"academicyear" : academicyear,
												"paidleave" : paidleave,
												"totalleave" : totalleave,
												"sickleave" : sickleave,
												"casualleave" : casualleave,
												"allowedleave" : allowedleave,
												"snoid" : snoid

											},

											$
													.ajax({

														type : "POST",

														url : "leavebank.html?method=submit",

														data : datalist,

														success : function(
																data)

														{

															var result = $
																	.parseJSON(data);

															window.location.href = "adminMenu.html?method=LeaveBankList&result="
																	+ result.jsonResponse;

														}

													});

								}

							});
					
					$("#editleavebank")
					.click(
							function() {

								var snoid = $("#snoid").val();
								
								alert("snoid"+snoid);
								

								if (snoid == "" || snoid == null) {

									$(".errormessagediv").show();
									$(".validateTips").text(
											"Select any one CheckBox");
									setTimeout(function() { $('#errormessagediv').fadeOut();  }, 3000);

									return false;
								}

								else {

									window.location.href = "leavebank.html?method=editleavebank&snoid="
											+ snoid;
								}

							});
					
					
					 $("#deleteleavebank").click(function(){
						  
						 
						  
							var snoList = new Array();
							var selectArray = document.getElementsByName('selectBox');
							
							alert("selectArray"+selectArray);
							
							var count = 0;
							
							for ( var i = 0; i < selectArray.length; i++) {
								if (selectArray[i].checked == true) {

									snoList.push(selectArray[i].value);
								}
							}

							$('input[name="selectBox"]:checked').each(function() {
								count = count + 1;
								
							});
							

							if (count > 1 || count == 0) {
								
								    $(".errormessagediv").show();
									$(".validateTips").text("Select Any One record");
									  setTimeout(function() { $('.errormessagediv').fadeOut();  }, 3000);
							} else {
								
								$("errormessagediv").hide();
								var X = confirm("Are you sure to delete the record");
								if(X){
									
														
									var leavelist={"year":snoList };
									
								
									
								    $.ajax({
										 type: 'POST', 
										  url: "leavebank.html?method=deleteLeavebank",
								          data:leavelist,
								          async:false,
										  success: function(response) {
											  
												var result = $.parseJSON(response);
												
												if (result.deletestatus == true) {
													deletekey = "Leave Data Deleted Successfully";
												} else {
													deletekey = "Deletion failed";
												}	 
												window.location.href="adminMenu.html?method=LeaveBankList&deletekey="+ deletekey;
												
										  }
									 });
								   }
								}
						});
					
					
					
				});


function getvaldetails(value) {

	var s1 = value.id;

	var snoid = s1;
	
	 
	$("#snoid").val(snoid);

}

function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}

/*
function deleteLeave() {

	var snoList = new Array();
	alert("snoList"+snoList);
	
	var selectArray = document.getElementsByName('selectBox');
	var x = confirm("Confirm delete");
	for ( var i = 0; i < selectArray.length; i++) {
		if (selectArray[i].checked == true) {

			snoList.push(selectArray[i].value);
		}
	}

	if (snoList.length < 1) {
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("please select atleast one record");

	} else if(x) {
		var leavelist = {
			"year" : snoList

		};
		callAjaxLeave("leavebank.html?method=editleavebank", leavelist);

		if (result.deletestatus == true) {
			statusdelete = "Leave data deleted successfully";
		} else {
			statusdelete = "Deletion failed";
		}

	}

	window.location.href = "GetLeaves.do?parameter=getLeave&deletekey="
			+ statusdelete;

}
function selectAll() {

	var selectall = document.getElementsByName("selectall");
	var selectArray = document.getElementsByName('selectBox');

	if (selectall[0].checked == true) {
		for ( var i = 0; i < selectArray.length; i++) {
			selectArray[i].checked = true;
		}
	} else {
		for ( var i = 0; i < selectArray.length; i++) {
			selectArray[i].checked = false;
		}
	}
}
var result;
function callAjaxLeave(urlWithMethod, dataToBeSend) {
	var jsonResult = "";
	try {
		$.ajax({
			type : "GET",
			url : urlWithMethod,
			data : dataToBeSend,
			async : false,
			success : function(data) {
				result = $.parseJSON(data);
				jsonResult = result;

			}
		});
	} catch (e) {
		jsonResult = "";
	}
	return jsonResult;
}

*/
