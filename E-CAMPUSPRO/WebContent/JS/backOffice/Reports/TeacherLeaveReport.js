
$(document).ready(function() {
	
	$('#excelDownload')
	.click(
			function() {
				
				window.location.href = 'teacherLeaveDetailsReport.html?method=LeaveReportDownloadXLs';
				
			});
	
	$("#accyear").click(function(){
		
		$("#haccyear").val($("#accyear option:selected").text().trim());
	});
	
	$("#teachername").click(function(){
		
		$("#hteachername").val($("#teachername option:selected").text().trim());
	});
	
	
	$("#dropdown").click(function(){
		$("#hbox").slideToggle("slow");
		
	});

	$('.col-md-10, .vertical').click(function(){
		$("#hbox").hide();
	});
	
	// for showing search destails

	$("#allstudent").hide();
	$(".selecteditems").hide();
	
	if($("#hideenId").val()!="" && $("#hideenId").val()!=undefined ){
		
		$(".selecteditems").show(1000);
		$("#allstudent").show(1000);
		$("#txtstyle, #txtstyle").slideToggle();
		
	}
	
	$("#search").click(function(){
		
		var accyear=$("#accyear").val();
		var departmet=$("#deptid").val();
		var teachingtype=$("#teachertype").val();
		var teachername=$("#teachername").val();
		
		if(accyear=="" && departmet=="" && teachingtype=="" && teachername==""){
			
			$("#txtstyle, #txtstyle").slideToggle();
			
			
		}
		
		if(accyear==""){
			
			$('.errormessagediv').show();
			$('.validateTips').text("Select Academic Year");
			
			return false;
			
		}if(departmet==""){
			
			$('.errormessagediv').show();
			$('.validateTips').text("Select Department");
			
			return false;
			
		}if(teachingtype==""){
			
			$('.errormessagediv').show();
			$('.validateTips').text("Select Teaching type");
			
			return false;
			
		}if(teachername==""){
			
			$('.errormessagediv').show();
			$('.validateTips').text("Select Teacher");
			
			return false;
			
		}else{
			
			return true;
		}
		
	});

});

function getTeacherName(){
	
	$("#hdepartment").val($("#deptid option:selected").text().trim());
	$("#hteachertype").val($("#teachertype option:selected").text().trim());
	
	var teachertype=$("#teachertype").val();
	var department=$("#deptid").val();
	

		datalist={
				
				"teachertype" : teachertype,
				"department" : department
				
		},
		
		$.ajax({
			
			type : 'POST',
			url : "teacherLeaveDetailsReport.html?method=getTeachername",
			data : datalist,
			async : false,
			success : function(response) {
				
				var result = $.parseJSON(response);
				
				
				$('#teachername').html("");
				
				$('#teachername')
				.append(
						'<option value="'
						+ ""
						+'">'
						+ ""
						+ '</option>');
				if(result.TeacherList.length!=0){
					$('#teachername').append(
							'<option value="'
									+ "all" + '">'
									+ "ALL"
									+ '</option>');
				}
		for ( var j = 0; j < result.TeacherList.length; j++) {
			$('#teachername')
					.append(
							'<option value="'
									+ result.TeacherList[j].teacherId
									+ '">'
									+ result.TeacherList[j].teacherName
									+ '</option>');
		}
				
			}
			
			
		});
		

}