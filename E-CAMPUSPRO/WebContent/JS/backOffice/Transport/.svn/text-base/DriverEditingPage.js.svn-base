

function myFunction() {
	    
			         document.getElementById("myForm").submit();   
				  }







$(document).ready(function() {
	

	
	
$("#editdriver").click(function(){
		
	
	
		 var cnt = 0;
		 $(
			'input.driver_Checkbox_Class:checkbox:checked')
			.map(
					function() {
						
						var check_id = $(
								this)
								.attr(
										"id");
						var split_id = check_id
								.split('_');
						getData = split_id[1]
								.split(',');
						
						
						cnt++;
					});
		
		 if (cnt == 0 || cnt > 1) {
				
				$(".errormessagediv").show();
				$(".validateTips").text("Select any one Driver");
				
				return false;
			} 
		 
		 else
			 {
			 
			 var driverid = getData[0];
			 
			
				window.location.href = "driverDetailsPath.html?method=editDriver&driverid="+driverid;
				
			
			 }
		 
		 
		     setTimeout(function(){
				
			 window.location.href="adminMenu.html?method=driverget";
		 
		     },2000);
		 
             });





$("#delete").click(function(){
	

	
	var depcode = [];
	var count=0;	
	
	$('input.driver_Checkbox_Class:checkbox:checked')
	.map(
			function() {

				var term_id = $(
						this).attr(
						"id");
				var split_id = term_id
						.split('_');
				getData = split_id[1]
						.split(',');
				depcode
						.push(getData[0]);
				
				
				count++;
		});	
	
	if (count == 0) {
		
		$('.errormessagediv').show();
		$('.validateTips').text("Select Any one Driver");
		return false;
	}
	
	else if (depcode != "") {
		var depcode1 = depcode.toString();
		//var x = confirm("Are you sure you want to delete this Driver");
	
		
		//if (x) {
		
		var datalist = 'drivercode=' + depcode1;
		
		$
				.ajax({
					type : "GET",
					url : "driverDetailsPath.html?method=deleteDriver",
					data : datalist,
					async : false,

					success : function(response) {
						
						var result = $.parseJSON(response);
						
						$('.errormessagediv').hide();
						$(".successmessagediv").show();

						$(".validateTips").text("Driver Deleted SuccessFully");

						$(".validateTips").text("Driver Details Deleted SuccessFully");

						
						 setTimeout(function(){
							   
							 location.reload();
						 
						 },2000);
					}
				
				});
		
	//}
	
	}

});
  

$('#excelDownload')
.click(
		function() {
			
			window.location.href = 'driverDetailsPath.html?method=DriverDetailsXLS';
			
		});

$("#pdfDownload").click(function(){
	
	window.location.href = "driverDetailsPath.html?method=DriverDetailsPDFReport";
		
});	












	
});
	
	
	
	
	