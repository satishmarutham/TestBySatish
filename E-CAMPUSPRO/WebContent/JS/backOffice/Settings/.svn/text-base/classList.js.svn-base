function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv1").hide();

}


$(document)
		.ready(
				function() {
					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);	
					
					
					$('#editClass')
					.click(
							function() {
								
								var count = 0;
								
								$(
										'input.class_Checkbox_Class:checkbox:checked')
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
									
									window.location.href = "classPath.html?method=editClass&classCode="+getData[0];
								  	
									

								
								}
							});
					
					$('#classDelete')
					.click(
							function() {
								
								var count = 0;
								$(
										'input.class_Checkbox_Class:checkbox:checked')
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
									var datalist = {
											"classCode" : getData[0],
											
										};
									
									$.ajax({
										type : 'POST',
										url : "classPath.html?method=deleteClass",
										data : datalist,
										success : function(
												response) {
											var result = $.parseJSON(response);
											
											if (result.status == true) {
												var msg = "Class Deleted Successfully";
												window.location.href = "adminMenu.html?method=classList&msg="
														+ msg;
												 setTimeout(function(){
														
													 location.reload();
												 
												 },2000);

											} else {
												var msg = "Class is mapped Cannot delete";
												window.location.href = "adminMenu.html?method=classList&msg="+msg;
									
												 setTimeout(function(){
														
													 location.reload();
												 
												 },2000);
												
											}
											
											
											

											 setTimeout(function(){
													
												 location.reload();
											 
											 },2000);	
											
											
											
											
											
										}

									});
								  	
									
		
								
								}
							});
					
					$("#searchClass").click(function(){
						var searchname = $("#searchValue").val().trim();
						
				window.location.href = "adminMenu.html?method=classList&searchname="
						+ searchname;
					});
					

					$('#excelDownload')
					.click(
							function() {
								
								var searchTerm = $("#searchexamid").val().trim();
								
								window.location.href = 'classPath.html?method=classPathDetailsXLS&searchTerm='+ searchTerm;
								
							});

					$("#pdfDownload").click(function(){
						
						var searchTerm = $("#searchexamid").val().trim();
						
						window.location.href = "classPath.html?method=classPathDetailsPDFReport&searchTerm="+ searchTerm;
							
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