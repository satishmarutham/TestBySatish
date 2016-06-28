$(document).ready(function(){

 $("#Edit").click(function(){

		var count = 0;
		var event_Code = null;

		$('input[name="checkboxname"]:checked').each(function() {
			count = count + 1;
			event_Code = this.id;
		});

		if (count > 1 || count == 0) {
			
			$('.errormessagediv').show();
			$('.validateTips').text("Select Any One Acadamic Year Plan");
			
			return false;

		} else {
			
			window.location.href="acadamicYearPlan.html?method=editAcadamicYearPlan&Event_Code="+event_Code;
			
			
		}

 });
 
 
 
 
 
 $("#delete").click(function(){
	 
	    var count = 0;
		var event_Code = null;

		$('input[name="checkboxname"]:checked').each(function() {
			count = count + 1;
			event_Code = this.id;
		});

		if (count > 1 || count == 0) {
			
			$('.errormessagediv').show();
			$('.validateTips').text("Select Any One Acadamic Year Plan");
			
			return false;

		} else {
			
			var x =confirm("Are you sure to delete selected Acadamic Year plan");
			
			if(x){
				var type = {
						"Event_Code" : event_Code
					};
					$
							.ajax({
								type : "GET",
								url : "acadamicYearPlan.html?method=deleteAcadamicYearPlan",
								data : type,
								async : false,
								success : function(data) {
									var result = $.parseJSON(data);
									
									$('.errormessagediv').hide();
									
									if(result.status=="true"){
										
									$(".successmessagediv").show();
									$(".successmessage").text("Acadamic Year Plan Deleted Successfully");
									
									}else{
										
										$('.errormessagediv').show();
										$('.validateTips').text("Acadamic Year Plan Not Delete,Please try again");
										
									}
									
									
									 setTimeout(function(){
										   
										 window.location.href="adminMenu.html?method=acdamicYearPlanList";
										
									 
									 },3000);
									
								
								}

							});
			}
		}
 });
 
 
 
 
 
 
 
	$("#search").click(function(){
		
		var searchTerm=$("#searchterm").val().trim();
		
		if(searchTerm==""){
		
			$('.errormessagediv').show();
			$('.validateTips').text("Enter search term");
			
			return false;
		
		}else{
			
			window.location.href="adminMenu.html?method=acdamicYearPlanList&searchTerm="+searchTerm;	
			
		}
		
		
	});
	$('#excelDownload')
	.click(
			function() {
				var searchTerm = $("#searchexamid").val().trim();
				
				alert("searchTerm "+searchTerm);
				window.location.href = 'acadamicYearPlan.html?method=AcadamicYearPlanXLS&searchTerm='+ searchTerm;
				
			});
	
	$("#pdfDownload").click(function(){
		var searchTerm = $("#searchexamid").val().trim();
		alert("searchTerm "+searchTerm);
		window.location.href = "acadamicYearPlan.html?method=AcadamicYearPlanPDF&searchTerm="+ searchTerm;
			
	});	

 
	
	
	
	
});