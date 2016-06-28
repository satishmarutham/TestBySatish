function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}
$(document)
		.ready(
				function() {
					
					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);

					
					var hclassid=$("#hclassid").val();
					var hSectionId=$("#hSectionId").val();
					
					
					if(hclassid!=""){
						
						$("#classname option[value="+ hclassid + "]").attr('selected', 'true');
						
						selectClass();
						
						$("#sectionname option[value="+ hSectionId + "]").attr('selected', 'true');
						
					}
					
					
					$('#edit')
							.click(
									function() {

										var count = 0;
										var feecode = null;

										$('input[name="selectBox"]:checked')
												.each(function() {
													count = count + 1;
													feecode = this.value;
												});

										if (count > 1 || count == 0) {
											
											$('.errormessagediv').show();
											$('.validateTips').text("Select any one record");

										} else {
											
											window.location.href = "feecollection.html?method=getFeeCollectionDetails&FeeCode="
													+ feecode;

										}

									});
					
					$('#allstudent tr').each(function(){
						
						
						var isConcession=$(this).find('.isconcession').val();
						
						if(isConcession=='N'){
							
							$(this).find('.concessionamt').attr('readonly', true);
							
						}
					});
					
					var flag=true;
					
					$('.concessionamt ').change(function(){
						
						 flag=false;
						
						var actualAmt=$(this).parent().prev().text();
						
						var tot_concession=0;
						var tot_paidamt=0;
						
						var regexp = /^[0-9]+([\,\.][0-9]+)?$/g;
						
						 if((regexp.test($(this).val()))){
						
						if(parseInt($(this).val())<=parseInt(actualAmt)){
							
							flag=true;
							
							$(this).parent().next().text(parseInt(actualAmt)-parseInt($(this).val()));
						
							$('#allstudent tr').each(function(){
							
							var concessionamt=$(this).find('.concessionamt').val();
							var paidamount=$(this).find('.paidamount').text();
							
							if(concessionamt!=null && concessionamt!=undefined){
								
								tot_concession = tot_concession + parseInt(concessionamt);
							}
							
							if(paidamount !="" && paidamount!='Paid amount'){
								
								tot_paidamt = tot_paidamt + parseInt(paidamount);
								
							}
							
						});
						
						$("#tot_concession_amt").text(tot_concession);
						$("#tot_paid_amt").text(tot_paidamt);
						
					}else{
						
						flag=false;
						
						$('.errormessagediv').show();
						$('.validateTips').text("Concession amount should not be more than Actual amount");
					}
						
				}else{
					
					flag=false;
					
					$('.errormessagediv').show();
					$('.validateTips').text("Enter valid Concession amount");
					
				}
						
			});
					
					
					$("#saveid").click(function(){
						
						
						if(flag){
							
							var addmissionNo=$("#addmissionNo").text();
							var accodemicyear=$("#hyear").val();
							var termid=$("#hterm").val();
							var classd=$("#hclass").val();
							var concession=$("#concessionPercent").text();
							
							var tot_actual_amt=$("#tot_actual_amt").text();
							var tot_concession_amt=$("#tot_concession_amt").text();
							var tot_paid_amt=$("#tot_paid_amt").text();
							
							var feeIdArray=[];
							var actualamtArray=[];
							var concessionAmtArray=[];
							var paidAmtArray=[];
							
							$('#allstudent tr').each(function(){
								
								feeId=$(this).find('.feecode').val();
								actualamt=$(this).find('.actualamount').text();
								concessionAmt=$(this).find('.concessionamt').val();
								paidAmt=$(this).find('.paidamount').text();
								
								if(feeId!=undefined && feeId!=""){
									
									feeIdArray.push(feeId.trim());
								}
								
								if(actualamt!=undefined && actualamt!=""){
									
									actualamtArray.push(actualamt.trim());
								}
								
								if(concessionAmt!=undefined && concessionAmt!=""){
									
									concessionAmtArray.push(concessionAmt.trim());
								}
								
								if(paidAmt!=undefined && paidAmt!=""){
									
									paidAmtArray.push(paidAmt.trim());
								}
								
							});
							
							var datalist={
									
									"addmissionNo":addmissionNo.trim(),
									"accodemicyear":accodemicyear.trim(),
									"termid":termid.trim(),
									"classd":classd.trim(),
									"concession":concession.trim().substring(0, concession.trim().length-1),
									"tot_actual_amt":tot_actual_amt.trim(),
									"tot_concession_amt":tot_concession_amt.trim(),
									"tot_paid_amt":tot_paid_amt.trim(),
									"feeIdArray" : feeIdArray.join(","),
									"actualamtArray" : actualamtArray.join(","),
									"concessionAmtArray" : concessionAmtArray.join(","),
									"paidAmtArray" : paidAmtArray.join(",")
									
							};
							
							
							$.ajax({
								type : "GET",
								url : "feecollection.html?method=saveFeeCollection",
								data :datalist,
								async : false,
								success : function(data) {
									var result = $.parseJSON(data);
									
									
									if(result.status=="true"){
										
										$('.successmessagediv').show();
										$('.validateTips').text("Fee collection details saved successfully");
										
									setTimeout(function(){
										
										 window.location.href="adminMenu.html?method=feeCollection";
									 
									 },6000);
									
									}else{
										
										$('.errormessagediv').show();
										$('.validateTips').text("Fee collection not done.Try later");

									}
								
								}
							});
						
						
						 
							
						}else{
							
							$('.errormessagediv').show();
							$('.validateTips').text("Enter valid Concession amount");
						}
						
					});
					
					
				$("#searchButtonId").click(function(){
					
					var classId=$("#classname").val();
					var sectionId=$("#sectionname").val();
					
					window.location.href="adminMenu.html?method=feeCollection&classId="+classId+"&sectionId="+sectionId;
					
				});
					
					
				
				$('#excelDownload')
				.click(
						function() {
							
							window.location.href = 'feecollection.html?method=downloadfeecollectionXLS';
							
						});
				$("#pdfDownload").click(function(){
        			
        			window.location.href = "feecollection.html?method=downloadfeecollectionPDF";
        				
        		});
				
				
				});

function selectClass(){
	
	var classId=$("#classname").val();
	
	$.ajax({
		type : "GET",
		url : "feecollection.html?method=getSectionByClass",
		data : {"classId":classId},
		async : false,
		success : function(data) {
			var result = $.parseJSON(data);
			
			$("#sectionname").html("");
			$("#sectionname").append(
					'<option value="' + "" + '">' + ""
							+ '</option>');
			
			for (var j = 0; j < result.SectionList.length; j++) {
				

				$("#sectionname").append(
								'<option value="'
										+ result.SectionList[j].sectionId
										+ '">'
										+ result.SectionList[j].sectionname
										+ '</option>');
			}
		
			
		
		}

	});
	

	
}