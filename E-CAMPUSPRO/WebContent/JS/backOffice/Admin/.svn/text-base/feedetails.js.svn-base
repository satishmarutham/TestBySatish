function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}
$(document).ready(function() 
		
		{
	
	setTimeout("removeMessage()", 3000);
	setInterval(function() {
		$(".errormessagediv1").hide();
	}, 3000);
	
	
	$("#delete")
		.click(
				function() 
				
				{
					
					var cnt = 0;

					$(
							'input.academic_Checkbox_Class:checkbox:checked')
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
						
						$(".successmessagediv").hide();
						$(".errormessagediv1").show();
						$(".validateTips1").text("Select Any One Checkbox");
						

					} 
					
					
					else {
						
						
						var x = confirm("Are you sure want to delete this fee details");
						if (x)
						{
							
							var datalist = 'name=' + getData[0];
							


							$
									.ajax({
										type : "GET",
										url : "addfee.html?method=deleteFeeDetails",
										data : datalist,
										async : false,

										success : function(response) {
											
											var result = $.parseJSON(response);
											
											
											window.location.href = "adminMenu.html?method=feeDetailsList&result="+ result.jsonResponse;
										
											
										}
									});

						}

					
					}
				 	   	
					
					
					
					
					
					
				});
	
	
	
	
		
	

	
	$("#feeedit")
	.click(
			function() {

				var cnt = 0;

				$(
						'input.academic_Checkbox_Class:checkbox:checked')
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
					

					$(".successmessagediv").hide();
					$(".errormessagediv1").show();
					$(".validateTips1").text("Select Any One Checkbox");

				} 
				
				
				else {
					
					
					var name = getData[0];
					window.location.href = "addfee.html?method=editFeeDetails&name="+ name;
					
				}
			 	   	
				});
	
	
	
	
	$("#search")
	.click(
			function() 
			
			{
				var searchvalue=$('#searchvalue').val();
				
				
				window.location.href = "adminMenu.html?method=feeDetailsList&searchvalue="+ searchvalue;
				
				
				
			});
					
	$('#excelDownload')
	.click(
			function() {
				
				var searchvalue=$('#feesearchid').val();
				
				
				window.location.href = 'addfee.html?method=FeeDetailsXLS&searchvalue='+searchvalue;
				
			});
	
	$("#pdfDownload").click(function(){
		
		var searchvalue=$('#feesearchid').val();
		
		
		window.location.href = "addfee.html?method=FeeDetailsPDFReport&searchvalue="+searchvalue;
			
	});	

			});
	
	
	
	
	
	



	
	
	