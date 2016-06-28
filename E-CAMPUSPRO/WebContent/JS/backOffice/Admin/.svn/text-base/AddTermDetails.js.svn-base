function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}

function myFunction()

{
	
	var status = false;
	var id=$('#termmasterid').val();
	var name = $('#termname').val();
	var description = $('#termdescription').val();
	var accstartdate = $('#AccStartDate').val();
	var accenddate = $('#AccEndDate').val();
	var startdate = $('#startdate').val();
	var enddate = $('#enddate').val();   
	var transId=$('input[name=trans]:checked').val();
	
	
	if(name=="" || name==null)
		
	{
	
		$(".successmessagediv").hide();
		$(".errormessagediv1").show();
		$(".validateTips1").text("Enter Term Name");
		
		return false;
	
	}
	
	
	
	if (startdate == "" || startdate == undefined) {
		$(".successmessagediv").hide();
		$(".errormessagediv1").show();
		$(".validateTips1").text("Select the StartDate");
		return false;
	}
	
	/*if(accstartdate > startdate ){
		$(".successmessagediv").hide();
		$(".errormessagediv1").show();
		$(".validateTips1").text("Start Date should greater than Accyear Date");
		return false;
		
	}*/
	

	if (enddate == "" || enddate == undefined) {
		$(".successmessagediv").hide();
		$(".errormessagediv1").show();
		$(".validateTips1").text("Select the EndDate");
		return false;
	}
	
	if(startdate >= enddate){
		
		$(".successmessagediv").hide();
		$(".errormessagediv1").show();
		$(".validateTips1").text("End Date should greater than Start Date");
		return false;
		
	}
	
/*	if(enddate < accenddate ){
		
		$(".successmessagediv").hide();
		$(".errormessagediv1").show();
		$(".validateTips1").text("End Date should less than Accyear Date");
		return false;
		
	}*/
	
	
	if (transId == "" || transId == undefined) {
		$(".successmessagediv").hide();
		$(".errormessagediv1").show();
		$(".validateTips1").text("Select Transport Type");
		return false;
	}
	
	
		datalist = {"name" : name, "id" :id},
		
		$.ajax({
			
		type : "POST",
		
		url : "termfee.html?method=getnamecount",
		
		data : datalist,
		async:false,
		
		success : function(data)
		
			{
			
				var result = $.parseJSON(data);
				
				if(result.message)
					
					{
					
						$('#termname').val("");
				
						$(".successmessagediv").hide();
				
						$(".errormessagediv1").show();
				
						$(".validateTips1").text("Name Already Exists");
						
						status=false;
						
						
					}
				
					else
					
					{
						
						status=true;
					
					}
				
				
			}
		
		
	   	
	});
		
		return status;	




}


$(document).ready(function() 
		
		{
	setTimeout("removeMessage()", 3000);
	setInterval(function() {
		$(".errormessagediv1").hide();
	}, 3000);
	
	
	
	var trans = $('#radio').val();
	
	if (trans == "YES") {
		$("#transIdY").attr("checked", true);
	} else if (trans == "NO") {
		$("#transIdN").attr("checked", true);
	}
	
	$("#startdate").datepicker({

		changeMonth : true,
		changeYear : true,
		dateFormat : "dd-mm-yy",

	});

	$("#enddate").datepicker({

		changeMonth : true,
		changeYear : true,
		dateFormat : "dd-mm-yy",

	});
	
	$("#AccStartDate").datepicker({

		changeMonth : true,
		changeYear : true,
		dateFormat : "dd-mm-yy",

	});

	$("#AccEndDate").datepicker({

		changeMonth : true,
		changeYear : true,
		dateFormat : "dd-mm-yy",

	});
	
	
	
	$("#save")
		.click(
				function() 
				
				{
					
					var id=$('#termmasterid').val();
					var name = $('#termname').val();
					var description = $('#termdescription').val();
					var startdate = $('#startdate').val();
					var enddate = $('#enddate').val();
					var transId=$('input[name=trans]:checked').val();
					
					if (myFunction())
					
					{
						
					datalist = {"name" : name, 
							"description" : description, 
							"startdate":startdate, 
							"enddate":enddate, 
							"transId":transId, 
							"id" :id},
					
					$.ajax({
						
					type : "POST",
					
					url : "termfee.html?method=addtermfeedetails",
					
					data : datalist,
					
					success : function(data)
					
						{
						
						
						var result = $.parseJSON(data);


						if (result.jsonResponse == "Term Details Added Successfully") {
							$(
									".errormessagediv")
									.hide();
							$(
									".successmessagediv")
									.show();
							$(
									".validateTips")
									.text(
											"Term Details Added Successfully");

							setTimeout(
									function() {

										window.location.href = "adminMenu.html?method=termList";

									},
									3000);

						}

						if (result.jsonResponse == "Term Details not Added Successfully") {

							$(
									".errormessagediv")
									.hide();
							$(
									".successmessagediv")
									.show();
							$(
									".validateTips")
									.text(
											"Term Details not Added Successfully");

							setTimeout(
									function() {

										window.location.href = "termfee.html?method=addtermdetails";

									},
									3000);

						}
						if (result.jsonResponse == "Term Details Updated Successfully") {
							$(
									".errormessagediv")
									.hide();
							$(
									".successmessagediv")
									.show();
							$(
									".validateTips")
									.text(
											"Term Details Updated Successfully");

							setTimeout(
									function() {

										window.location.href = "adminMenu.html?method=termList";

									},
									3000);

						}

						if (result.jsonResponse == "Term Details not Updated Successfully") {

							$(
									".errormessagediv")
									.hide();
							$(
									".successmessagediv")
									.show();
							$(
									".validateTips")
									.text(
											"Term Details not Updated Successfully");

							setTimeout(
									function() {

										window.location.href = "termfee.html?method=addtermdetails";

									},
									3000);

						}

									
						
						/*
						
							var result = $.parseJSON(data);
							
							if(result.jsonResponse=="Term Details not Added Successfully")
								
								{
								
								$(".successmessagediv").hide();
								$(".errormessagediv1").show();
								$(".validateTips1").text("Term Details not Added Successfully");
								
								
								}
							
							if(result.jsonResponse=="Term Details not Updated Successfully")
								
							{
							
							$(".successmessagediv").hide();
							$(".errormessagediv1").show();
							$(".validateTips1").text("Term Details not Updated Successfully");
							
							}
							
							window.location.href = "termfee.html?method=addtermdetails&result="+result.jsonResponse;
							
							
						*/}
			 	   	
				});
					
				
					}
				
				
				});
	
	
	
	
	$("#view").click(function(event)
			
			
			{
				window.location.href = "adminMenu.html?method=termList";
				
			});
	
		});