$(document).ready(function() {
	
	
	$('#edit').click(function() {
		
		
					var count = 0;
					var assignmentId = null;
		
					$('input[name="selectBox"]:checked')
							.each(function() {
								count = count + 1;
								
								
								assignmentId = this.id.trim();
								
							});
					
		
					if (count > 1 || count == 0) {
						
						$('.errormessagediv').show();
						$('.validateTips').text("Select any one record");
		
					} else {
						
						window.location.href = "assignmentupload.html?method=editAssignment&assignmentId="
								+ assignmentId;
		
					}
		
				});
	
	$('#allstudent').on('focus', '.actualcompleteDate', function() {
		$(this).datepicker({
			dateFormat : "dd-mm-yy",
		});
		$('div#ui-datepicker-div').css({
			'font-size' : '15px'
		});
	});
	
	
	
	
	$("#saveid").click(function(){
		
			var assignmentId=$("#assignmentId").val();
			var maxmarks=$("#maxmarks").text();
			
			var studentIdArray=[];
			var actualcompletionArray=[];
			var aquiredmarksArray=[];
			var remarksArray=[];
			
			$('#allstudent tr').each(function(){
				
				var studentId=$(this).find('.hiddenclass').text();
				var actualDate=$(this).find('.actualcompleteDate').val();
				var aquiredmarks=$(this).find('.acquiredmarks').val();
				var remarks=$(this).find('.remarks').val();
				
				
				if(studentId!="StudentId" ){
					
					studentIdArray.push(studentId.trim());
					
				}
				
				if(actualDate!=undefined ){
					
					actualcompletionArray.push(actualDate.trim());
				}
				
				if(aquiredmarks!=undefined ){
					
					aquiredmarksArray.push(aquiredmarks.trim());
				}
				
				
				if(remarks!=undefined){
					
					if(remarks.trim()==""){
						
						remarksArray.push("null");
					
					}else{
						
						remarksArray.push(remarks.trim());
					}
				}
			});
			
		//	var regexp = /^[0-9]+([\,\.][0-9]+)?$/g;
			var reg = /^\d+$/;
			
			for(var i=0;i<studentIdArray.length;i++){
				
				
				if(aquiredmarksArray[i]==undefined && aquiredmarksArray[i]==""){
					
					$('.errormessagediv').show();
					$('.validateTips').text("Aquired marks should not empty");
					
					return false;
					
				}else if(!(reg.test(aquiredmarksArray[i]))){
					
					$('.errormessagediv').show();
					$('.validateTips').text("Enter valid aquired marks");
					
					return false;
					
				}else if(parseInt(maxmarks)<parseInt(aquiredmarksArray[i])){
					
					$('.errormessagediv').show();
					$('.validateTips').text("Aquired marks should not greater than Max marks");
					
					return false;
					
				}
				
			}
			
			var datalist={
					
					"assignmentId":assignmentId.trim(),
					"studentIdArray" : studentIdArray.join(),
					"actualcompletionArray" : actualcompletionArray.join(),
					"aquiredmarksArray" : aquiredmarksArray.join(),
					"remarksArray" : remarksArray.join()
					
			};
			
			
			
			
			$.ajax({
				type : "GET",
				url : "assignmentupload.html?method=updateAssignmentDetails",
				data :datalist,
				async : false,
				success : function(data) {
					var result = $.parseJSON(data);
					
					
					if(result.status=="true"){
						
						$('.successmessagediv').show();
						$('.validateTips').text("Assignment details updated successfully");
						
					setTimeout(function(){
						
						 window.location.href="teachermenuaction.html?method=assignmentView";
					 
					 },6000);
					
					}else{
						
						$('.errormessagediv').show();
						$('.validateTips').text("Assignment details not updated,Try later");

					}
				
				}
			});
		 
			
		
	});


	$('#trash').click(function() {
		
		var count = 0;
		var assignmentCode = null;

		$('input[name="selectBox"]:checked').each(function() {
			count = count + 1;
			assignmentCode = this.id;

		});

		if (count == 0 || count>1) {
			$('.errormessagediv').show();
			$('.validateTips').text("Select one record");

		} else {

			var x = confirm("Are you sure to delete Assignment");
			if (x) {

				var role = {
					"assignmentCode" : assignmentCode
				};
				$
						.ajax({
							type : "GET",
							url : "assignmentupload.html?method=deleteAssignment",
							data : role,
							async : false,

							success : function(data) {
								var result = $.parseJSON(data);
								
								$('.errormessagediv').hide();
								
								if(result.status=="true"){
									
								$(".successmessagediv").show();
								$(".validateTips").text("Assignment deleted successfully");
								
								}else{
									
									$('.errormessagediv').show();
									$('.validateTips').text("Assignment not deleted,Try later");
									
								}
								
								
								 setTimeout(function(){
									   
									 location.reload();
								 
								 },3000);
								
							
							}

						});


			}

		}

		
	});
	
	$("#searchid").click(function(){
		
			var searchTerm=$("#search").val().trim();
		
			window.location.href="teachermenuaction.html?method=assignmentView&searchTerm="+searchTerm;	
			
		
	});

});
