function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}

function myFunction() {
	    
			         document.getElementById("myForm").submit();   
				  }


$(document)
		.ready(
				function() {
					
					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);
				
				
					$("#editstream").click(function(){
						
						$(".successmessagediv").hide();
						
						var cnt = 0;

						$(
								'input.streamDetails_Checkbox_Class:checkbox:checked')
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
		     				$(".validateTips").text("Select any one Stream");
		     				
		     				return false;
		     			} 
		     			else
		     				{
		     			
							var streamid = getData[0];
							window.location.href = "streamDetails.html?method=editStreamDetailsAction&streamid="+ streamid;
		     				}

					});
					
					
					
					
					$("#delete").click(function(){	
												
						
						var depcode = [];
						var count=0;
						$('input.streamDetails_Checkbox_Class:checkbox:checked')
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
						
						
						if (count == 0 || count>1) {
							
							$('.errormessagediv').show();
							$('.validateTips').text("Select Any one Stream");
							return false;
							
						}
						
						else if (depcode != "") {
							var depcode1 = depcode.toString();
							
							
							
								var termcodeToBeDeleted = {
									"streamid" : depcode1
								};
								$
										.ajax({
											type : 'POST',
											url : "streamDetails.html?method=deleteStreamDetailsAction",
											data : termcodeToBeDeleted,
											success : function(
													response) {
												var result = $
														.parseJSON(response);
												
												
												$('.errormessagediv').hide();
												
												if(result.status=="Stream Deleted SuccessFully"){
													
													$(".successmessagediv").show();
													$(".validateTips").text("Stream Deleted SuccessFully");
												}
												
												else if(result.status=="Stream not Deleted SuccessFully"){
													$('.successmessagediv').show();
													$('.validateTips').text("Stream not Deleted SuccessFully");
												}
												
												else if(result.status=="Stream Already Mapped"){
													$('.successmessagediv').show();
													$('.validateTips').text("Stream Already Mapped");
												}
												
												
												 setTimeout(function(){
													   
													 location.reload();
												 
												 },2000);
											
											}

										});
								
							
						}
					
});
								
					$('#excelDownload')
					.click(
							function() {
								
								
								var searchTerm = $("#searchexamid").val().trim();
								
							
								
								window.location.href = 'streamDetails.html?method=downloadStreamDetailsXLS&searchTerm='+ searchTerm;
								
							});
					
					
					$("#pdfDownload").click(function(){
						
						
						var searchTerm = $("#searchexamid").val().trim();
            			
            			window.location.href = 'streamDetails.html?method=downloadStreamDetailsPDF&searchTerm='+ searchTerm;
            				
            		});
							
					
					
					
});				