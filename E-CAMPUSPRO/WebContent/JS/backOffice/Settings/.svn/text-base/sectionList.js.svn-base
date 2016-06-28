$(document)
		.ready(
				function() {
					setTimeout("removeMessage()" ,2000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);
					
					$('#editClass')
					.click(
							function() {
								
								var count = 0;
								
								$(
										'input.class_Checkbox_Section:checkbox:checked')
										.map(
												function() {

													var class_id = $(
															this).attr(
															"id");
													var split_id = class_id
															.split('_');
													getData = split_id[1]
															.split(',');

													count++;
												});
								if (count == 0 || count > 1) {
									$(".errormessagediv").show();
									$(".validateTips").text(
											"Check any one checkbox");
									return false;

								} else {
									
									window.location.href = "sectionPath.html?method=editSection&classCode="+getData[0];
								  	
									

								
								}
							});
					
					$('#sectionDelete')
					.click(
							function() {
								
								var count = 0;
								$(
										'input.class_Checkbox_Section:checkbox:checked')
										.map(
												function() {
													

													var section_id = $(
															this).attr(
															"id");
													var split_id = section_id
															.split('_');
													getData = split_id[1]
															.split(',');

													count++;
												});
								if (count == 0 || count > 1) {
									$(".errormessagediv").show();
									$(".validateTips").text(
											"Check any one checkbox");
									return false;

								} else {
									var datalist = {
											"sectionCode" : getData[0],
											
										};
									
									$.ajax({
										type : 'POST',
										url : "sectionPath.html?method=deleteCampusClassSectionAction",
										data : datalist,
										success : function(
												response) {
											var result = $.parseJSON(response);
											
											if (result.status == true) {
												var msg = "Section Deleted Successfully";
												window.location.href = "adminMenu.html?method=sectionList&msg="
														+ msg;
									

											} else {
												var msg = "Class is mapped Cannot delete";
												window.location.href = "adminMenu.html?method=sectionList&msg="+msg;
									
											}
										}

									});
								  	
									
		
								
								}
							});
					
					$("#searchClass").click(function(){
						var searchText = $("#searchValue").val().trim();
				window.location.href = "adminMenu.html?method=sectionList&searchText="
						+ searchText;
					});
					
					
					$('#excelDownload')
					.click(
							function() {
								
								
								var searchTerm = $("#searchexamid").val().trim();
								
							
								
								window.location.href = "sectionPath.html?method=downloadSectionDetailsXLS&searchTerm="
									+ searchTerm;
								
							});

					$("#pdfDownload").click(function(){
						
						
						var searchTerm = $("#searchexamid").val().trim();
					
						
						window.location.href = "sectionPath.html?method=downloadSectionDetailsPDF&searchTerm="
									+ searchTerm;
							
					});	
					
					
				});
function checkUpdateClassName() {
	var className = $("#className").val();
	var stream = $("#stream").val(); 
	var updateClassCode = $('#updateClassCode').val();
	var checkClassName = {
		"className" : className,
		"stream" : stream,
		"updateClassCode":updateClassCode,
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


function removeMessage() {
	

	$.ajax({
		type : "GET",
		url : "transport.html?method=removeMessage",
		async : false,
		success : function(data) {
			$('#serverMessage').empty();
		}
	});
}