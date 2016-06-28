
function callAjax(urlWithMethod, dataToBeSend) {
	
	$.ajax({
         
		url : urlWithMethod,
		data : dataToBeSend,
		async : false,
		success : function(data) {
			var result = $.parseJSON(data);
			jsonResult = result.status;

		}
	});
	return jsonResult;
}
function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}
$(document).ready(function() {
	
	$(".successmessagediv").hide();
	setTimeout(function() {
		
	}, 7000);
	$("#examname").val("");
	$("#examdate").val("");
	$("#description").val("");
	$(".errormessagediv").hide();
	
	$("#examdates").datepicker({
		dateFormat : "dd-mm-yy",
		defaultDate : "+1w",
		changeMonth : true,
		changeYear : true,
		numberOfMonths : 1,
		minDate : 0,

		onClose : function(selectedDate) {
			var date2 = $('#examdate').datepicker('getDate');
			date2.setDate(date2.getDate() + 1);
			$("#enddate").datepicker("option", "minDate", date2);

		}
	});
	
	$("#enddate").datepicker({
		dateFormat : "dd-mm-yy",
		defaultDate : "+1w",
		changeMonth : true,
		changeYear : true,
		numberOfMonths : 1,
		minDate : 0,
	});	

});

	
$(document)
.ready(
		function() {
			
		
				var hidden = $('#acaid').val().trim();
				$("#accyear option[value=" + hidden + "]").attr('selected', 'true');
				setTimeout("removeMessage()", 3000);
				setInterval(function() {
					$(".errormessagediv").hide();
				}, 3000);
				
				
				
			
			$("#examcreateid").click(function(){
			
				var examId = $('#examId').val();
				var examname = $('#examnames').val();
				
				var examdate = $('#examdates').val();
				var enddate = $('#enddate').val();
				var accadamicyear = $('#accyear').val();
				var description = $('#descriptions').val();
				//alert(examId);
				
			if(examname =="" || examname==null){
				
				$(".errormessagediv").show();
				
				$(".validateTips").text("Enter Exam Name");
				return false;	
			}
			else if(validateExamName()== 1){
				 $(".errormessagediv").show();
					$(".validateTips").text(" Exam Name already exists");
					return false;
			        }
			else if(examdate=="" || examdate == null){
				$(".errormessagediv").show();
				
				$(".validateTips").text("Select Exam Start Date");
				return false;	
				
			}
			
			else if(enddate=="" || enddate == null){
				$(".errormessagediv").show();
				
				$(".validateTips").text("Select Exam End Date");
				return false;	
				
			}
			else if(accadamicyear=="" || accadamicyear == null){
				$(".errormessagediv").show();
				
				$(".validateTips").text("Select Academic Year");
				return false;	
				
			}
	
			else{
				
			
				var datalist ={
						"examid" : examId ,
						"examname": examname,
						"examdate" : examdate,
						"enddate" :  enddate,
						"accadamicyear" : accadamicyear,
						"description" : description,
						
				};
				
				//alert(examdate);
				$.ajax({
					type : 'POST',
					url : "examCreationPath.html?method=createExamAction",
					data : datalist,
					async : false,
				success : function(data)
				
				{
					
					var result = $.parseJSON(data);
				//	alert("response"+result.jsonResponse);
					if(result.jsonResponse=="Exam Created Successfully")
						{
						$(".errormessagediv").hide();
						$(".successmessagediv").show();
						 $(".validateTips").text("Exam Created Successfully");
						 setTimeout(function(){
								
							 window.location.href="adminMenu.html?method=examList";
						 
						 },2000);
						
						}
					
					
					
					if(result.jsonResponse=="Exam Updated Successfully")
					{
					
						$(".errormessagediv").hide();
					$(".successmessagediv").show();
					 $(".validateTips").text("Exam Updated Successfully");
					 
					 setTimeout(function(){
							
						 window.location.href="adminMenu.html?method=examList";
					 
					 },2000);
					
					}
					
				}
				
				});
			}
				
			$("#accyear")
			.change(
					function() {

						var datesplit = $('#examdates').val()
								.split("-");

						var enddatesplit = $('#enddate').val()
								.split("-");

						var accsplit = $(
								"#accyear option:selected")
								.text().split("-");

						tips = $(".validateTips");

						var bValid = "true";

						if (parseInt(datesplit[2]) !== parseInt(accsplit[0])
								&& parseInt(datesplit[2]) != parseInt(accsplit[1])) {

							$(".validateTips")
									.text("Start Date Should be in Academic year");
							bValid = false;
						}

						else if (parseInt(enddatesplit[2]) != parseInt(accsplit[0])
								&& parseInt(enddatesplit[2]) != parseInt(accsplit[1])) {

							$(".validateTips")
									.text(
											"End Date Should be in Academic year");
							bValid = false;
						}
						if (!bValid)
							$(".errormessagediv").show();

						return bValid;

					});	
			
			
			
		/*	$("#enddate")
			.change(
					function() {

						alert("enddate change");
						var datesplit = $('#examdates').val()
								.split("-");
						var bValid = "true";
						if (datesplit != "") {
							var enddatesplit = $('#enddate')
									.val().split("-");

							tips = $(".validateTips");

							if (parseInt(datesplit[2]) != parseInt(enddatesplit[2])) {

								$(".validateTips")
										.text(
												"Start Date Year And End Date Year Should Be Same");
								bValid = false;
							}
							if (!bValid)
								$(".errormessagediv").show();
						}
						return bValid;

					});
			
			
			
			$("#examdates")
			.change(
					function() {
						alert("startdate change");
						var datesplit = $('#examdates').val()
								.split("-");

						var enddatesplit = $('#enddate').val()
								.split("-");
						var bValid = "true";
						if (enddatesplit != "") {
							tips = $(".validateTips");

							if ($('#enddate').val() != "") {

								if (parseInt(datesplit[2]) != parseInt(enddatesplit[2])) {

									$(".validateTips")
											.text(
													"Start Date Year And End Date Year Should Be Same");
									bValid = false;
								}
							}
							if (!bValid)
								$(".errormessagediv").show();
						}
						return bValid;

					});*/
			 setTimeout(function(){
					
				 location.reload();
			 
			 },3000);
		});

		});

function validateExamName(){
	
	var examname_validate=0;
	
	var examId = $('#examId').val();
	var examname = $('#examnames').val();
	var accadamicyear = $('#accyear').val();
	var streamObject = {
			"examname" : examname, "examid" : examId, "accyear" :accadamicyear	};
	
	$.ajax({

		type : "GET",
		url : 'examCreationPath.html?method=validateExamName',
		data : streamObject,
		async : false,
		success : function(data) {
			
			var result = $.parseJSON(data);
				
		if (result.status=="true") {
			
			examname_validate = 1;
			
			}
			else 
				
			{
				examname_validate = 0;
			}
		
		}
	});
	
	return examname_validate;
	
	
}









