$(document).ready(function() {
	
	
	
	$("#compdate").datepicker({

		dateFormat : "dd-mm-yy",
		changeMonth : "true",
		changeYear : "true",
		buttonImage : "images/calendar.GIF",
		buttonImageOnly : true

	});
	$("#assdate").datepicker({

		dateFormat : "dd-mm-yy",
		changeMonth : "true",
		changeYear : "true",
		buttonImage : "images/calendar.GIF",
		buttonImageOnly : true

	});
	
	
	$("#streamid").change(function(){
		
		var streamId=$("#streamid").val();
		
		$.ajax({
			type : "GET",
			url : "reportaction.html?method=getClassesByStream",
			data : {"streamId":streamId},
			async : false,
			success : function(data) {
				
				var result = $.parseJSON(data);
				$("#classid").html("");
				$("#classid").append(
						'<option value="' + "" + '">' + ""
								+ '</option>');

				for (var j = 0; j < result.ClassesList.length; j++) {
					
					$("#classid").append(
									'<option value="'
											+ result.ClassesList[j].classId
											+ '">'
											+ result.ClassesList[j].classname
											+ '</option>');
				}

			}

		});
		
	});
	
	
	$("#classid").change(function(){
		
		var classId=$("#classid").val();
		
		
		$.ajax({
			type : "GET",
			url : "reportaction.html?method=getSectionByClass",
			data : {"classId":classId},
			async : false,
			success : function(data) {
				var result = $.parseJSON(data);
				
				$("#section").html("");
				$("#section").append(
						'<option value="' + "" + '">' + ""
								+ '</option>');
				
				for (var j = 0; j < result.SectionList.length; j++) {
					

					$("#section").append(
									'<option value="'
											+ result.SectionList[j].sectionId
											+ '">'
											+ result.SectionList[j].sectionname
											+ '</option>');
				}
			
				
			
			}

		});
		
	});
	
	
$("#section").change(function(){
		
		var section=$("#section").val();
		
		$.ajax({
			type : "GET",
			url : "assignmentupload.html?method=getStudentDetails",
			data : {"section":section},
			async : false,
			success : function(data) {
				var result = $.parseJSON(data);
				
				$("#student").html("");
				
				for (var j = 0; j < result.StudentList.length; j++) {
					

					$("#student").append(
									'<option value="'
											+ result.StudentList[j].studentId
											+ '">'
											+ result.StudentList[j].studentName +"-"+result.StudentList[j].admissionNo
											+ '</option>');
				}
			
				
			
			}

		});
		
	});



	$('#edit').click(function() {
		
					var count = 0;
					var assignmentId = null;
		
					$('input[name="selectBox"]:checked')
							.each(function() {
								count = count + 1;
								assignmentId = this.value;
							});
		
					if (count > 1 || count == 0) {
						
						$('.errormessagediv').show();
						$('.validateTips').text("Select any one record");
		
					} else {
						
						window.location.href = "assignmentupload.html?method=editAssignment&assignmentId="
								+ assignmentId;
		
					}
		
				});



	$('#save').click(function() {
            
			if(validateform())
				{
				
					document.getElementById("assignmentform").submit();
				
				}; 
			
		});

	
	
});



function validateform(){
	
	
	var assignementName=$("#assname").val();
	var assdate=$("#assdate").val();
	var compdate=$("#compdate").val();
	var maxMarks=$("#maxid").val();
	var streamid=$("#streamid").val();
	var classid=$("#classid").val();
	var section=$("#section").val();
	var subject=$("#subject").val();
	var student=$("#student").val();

	
	if (assignementName=="") {
		
		$(".validateTips").text("Assignment name should not empty");
		$(".errormessagediv").show();
		
		return false;
	}else if (assdate=="") {
		
		$(".validateTips").text("Assignment date should not empty");
		$(".errormessagediv").show();
		
		return false;
	}else if (compdate=="") {
		
		$(".validateTips").text("Assignment completion date should not empty");
		$(".errormessagediv").show();
		
		return false;
	}else if (maxMarks=="") {
		
		$(".validateTips").text("Max marks should not empty");
		$(".errormessagediv").show();
		
		return false;
	}else if (streamid=="") {
		
		$(".validateTips").text("Stream should not empty");
		$(".errormessagediv").show();
		
		return false;
	}else if (classid=="") {
		
		$(".validateTips").text("Class should not empty");
		$(".errormessagediv").show();
		
		return false;
	}else if (section=="") {
		
		$(".validateTips").text("Section should not empty");
		$(".errormessagediv").show();
		
		return false;
	}else if (subject=="") {
		
		$(".validateTips").text("Subject should not empty");
		$(".errormessagediv").show();
		
		return false;
	}else if (student=="") {
		
		$(".validateTips").text("Student should not empty");
		$(".errormessagediv").show();
		
		return false;
	}else{
		
		$(".errormessagediv").hide();
		return true;
	}
	
	

}
