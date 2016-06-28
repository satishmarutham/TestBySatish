$(document).ready(function() {
	
	$(".errormessagediv").hide();
	
	$("#date").datepicker({
		dateFormat : "dd-mm-yy",
		maxDate : 0,
		changeMonth : "true",
		changeYear : "true",
		buttonImage : "images/calendar.GIF",
		buttonImageOnly : true
	});
	
	$("#startdate").datepicker({
		dateFormat : "dd-mm-yy",
		maxDate : 0,
		changeMonth : "true",
		changeYear : "true",
		buttonImage : "images/calendar.GIF",
		buttonImageOnly : true
	});
	
	$("#enddate").datepicker({
		dateFormat : "dd-mm-yy",
		maxDate : 0,
		changeMonth : "true",
		changeYear : "true",
		buttonImage : "images/calendar.GIF",
		buttonImageOnly : true
	});
	
	
	
	$("#saveAttendance").click(function(){
		
		var date =$("#date").val();
		
		var teacherIdArray=[];
		var statusArray=[];
		
		$('#allstudent tr').each(function(){
			
			
			var teacherID=$(this).find('.hiddenclass').text();
			var status=$(this).find('.statusclass').val();
			
			
			if(teacherID!="Studentid"){
				
				teacherIdArray.push(teacherID.trim());
			}
			
			if(status!=undefined && status!=""){
				
				statusArray.push(status);
			}
			
		});
		
		
		var datalist={
				
				"date" : date,
				"teacherIdArray" : teacherIdArray.join(),
				"statusArray" : statusArray.join()
				
		};
		
		
		
		
		$.ajax({
			type : "POST",
			url : "StudentAttendanceActionPath.html?method=updateAttendanceStatus",
			data :datalist,
			async : false,
			success : function(data) {
				var result = $.parseJSON(data);
				
				if(result.status=="true"){
					
					$('.successmessagediv').show();
					$('.successmessage').text("Attendance updated successfully");
					
				setTimeout(function(){
					
					 window.location.href="teachermenuaction.html?method=attendaceStatus";
				 
				 },6000);
				
				}else{
					
					$('.errormessagediv').show();
					$('.validateTips').text("Attendance not updated,Try later");

				}
			
			}
		});
		
		
	});
	
	
	$.ajax({
		url : "sectionPath.html?method=getCampusClassDetailsIDandClassDetailsNameAction",
	    async:false,
		success : function(data) {

			var result = $.parseJSON(data);
			
			for ( var j = 0; j < result.classDetailsIDandClassDetailsNameList.length; j++) {
				
				$('#classId')
						.append(
								'<option value="'
										+ result.classDetailsIDandClassDetailsNameList[j].secDetailsId
										+ '">'
										+ result.classDetailsIDandClassDetailsNameList[j].secDetailsName
										+ '</option>');

			}

		}
	});
	
	var hclassId=$("#hclass").val();
	
	if(hclassId!=undefined && hclassId!=""){
		
		$("#classId option[value='"+hclassId +"']").attr('selected', 'true');
		
		
		var classidVal = $("#classId").val();

		datalist = {
			"classidVal" : classidVal
		},
		
		$.ajax({
			type : 'POST',
			url : "studentRegistration.html?method=getClassSection",
			data : datalist,
			async : false,
			success : function(response) {
				var result = $.parseJSON(response);
				$("#section").html("");
				$("#section").append(
						'<option value="' + "" + '">' + "" + '</option>');

				for ( var j = 0; j < result.sectionList.length; j++) {
					$("#section").append(
							'<option value="' + result.sectionList[j].sectioncode
									+ '">' + result.sectionList[j].sectionnaem
									+ '</option>');
				}

			}
		});



		
		$("#section option[value=" + $("#hsection").val().trim() + "]").attr('selected', 'true');
		$("#date").val($("#hdate").val().trim());
	}
	

	$('#allstudent tr td').each(function(){
		
		
		var status=$(this).find('.statusclass').val();
		
		
		if(status!=undefined){
		
		var rowid=$(this).find('.statusclass').attr("id");
		
		$('#'+rowid).find('option').remove();
	
		var statusList=[];
		statusList.push("Present");
		statusList.push("Absent");
		statusList.push("Leave");
		statusList.push("Holiday");
		
		
		for (var j = 0; j < statusList.length; j++) {
			

			$("#"+rowid).append(
							'<option value="'
									+ statusList[j]
									+ '">'
									+ statusList[j]
									+ '</option>');
		}
		
		
		$("#"+rowid+" option[value=" + status + "]").attr('selected', 'true');
		
		}
		
	});
	

$("#searchAttendanceList").click(function(){
	
	var startDate=$("#startdate").val();
	var endDate=$("#enddate").val();
	
	window.location.href="teachermenuaction.html?method=attendaceStatus&startDate="+startDate+"&endDate="+endDate;	
	
	
});




$("#classId").change(function(){
	
	var classidVal = $("#classId").val();

	datalist = {
		"classidVal" : classidVal
	},
	
	$.ajax({
		type : 'POST',
		url : "studentRegistration.html?method=getClassSection",
		data : datalist,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);
			$("#section").html("");
			$("#section").append(
					'<option value="' + "" + '">' + "" + '</option>');

			for ( var j = 0; j < result.sectionList.length; j++) {
				$("#section").append(
						'<option value="' + result.sectionList[j].sectioncode
								+ '">' + result.sectionList[j].sectionnaem
								+ '</option>');
			}

		}
	});


});

$("#search").click(function(){
	
	var classId=$("#classId").val();
	var section=$("#section").val();
	var date=$("#date").val();
	
	if(classId==""){
		
		$('.errormessagediv').show();
		$('.validateTips').text("Select class");
	}else if(section==""){
		
		$('.errormessagediv').show();
		$('.validateTips').text("Select section");
		
	}else if(date==""){
		
		$('.errormessagediv').show();
		$('.validateTips').text("Select Date");
		
	}else{
		
		window.location.href="StudentAttendanceActionPath.html?method=getStudentAttendanceDetails&classId="+classId+"&section="+section+"&date="+date;
		
	}
});

$(".GetTimeTable").click(function(){
	
	var stuId=(this).id;
	var classId=$("#classId option:selected").text();
	var classname=$("#classId option:selected").val();
	
	var sectionId=$("#section option:selected").text();
	var sectionName=$("#section option:selected").val();
	var date=$("#date").val();
	var status=$(this).prev().find('input').val();
		
	window.location.href="StudentAttendanceActionPath.html?method=getStudentPeriodAttendance&classId="+classId+","+classname+"&section="+sectionId+","+sectionName+"&stuId="+stuId+"&date="+date+"&status"+status;
	
	
});

$("#UpdatePeriodAtt").click(function(){
	
	var studentId=$("#hstudentId").val();
	var classsId=$("#hclassId").val();
	var sectionId=$("#hsectionId").val();
	var date=$("#attendancedate").val();
	
	var period1=$("#period1").val();
	var period2=$("#period2").val();
	var period3=$("#period3").val();
	var period4=$("#period4").val();
	var period5=$("#period5").val();
	var period6=$("#period6").val();
	var period7=$("#period7").val();
	var period8=$("#period8").val();
	
	var datalist={
			
			"studentId":studentId,
			"classsId":classsId,
			"sectionId":sectionId,
			"date":date,
			"period1":period1,
			"period2":period2,
			"period3":period3,
			"period4":period4,
			"period5":period5,
			"period6":period6,
			"period7":period7,
			"period8":period8,
	};
		
	
	$.ajax({
		type : 'POST',
		url : "StudentAttendanceActionPath.html?method=updateStudentPeriodAtt",
		data : datalist,
		async : false,
		success : function(response) {
			var result = $.parseJSON(response);
		
			if(result.status=="true"){
				
				$('.successmessagediv').show();
				$('.successmessage').text("Period Attendance Saved Succesfully");
				
				setInterval(
						function() {
							
							var classId=$("#hclassId").val();
							var section=$("#hsectionId").val();
							var date=$("#attendancedate").val();
							
							window.location.href="StudentAttendanceActionPath.html?method=getStudentAttendanceDetails&classId="+classId+"&section="+section+"&date="+date;
							
						}, 3000);
			
				
			}else{
				
				$('.errormessagediv').show();
				$('.validateTips').text("Period Attendance not Saved,Try later");
				
			}

		}
	});
});

$("#back").click(function(){
	
	var classId=$("#hclassId").val();
	var section=$("#hsectionId").val();
	var date=$("#attendancedate").val();
	
	window.location.href="StudentAttendanceActionPath.html?method=getStudentAttendanceDetails&classId="+classId+"&section="+section+"&date="+date;
});
	
$('#excelDownload')
.click(
		function() {
			
			var startDate=$("#startdate").val();
			var endDate=$("#enddate").val();
			
			window.location.href = "StudentAttendanceActionPath.html?method=downloadStudentAttendanceDetailsXLS&startDate=" + startDate + "&endDate=" + endDate;
			
		});
$("#pdfDownload").click(function(){
	
	
	var startDate=$("#startdate").val();
	var endDate=$("#enddate").val();
	
	window.location.href = "StudentAttendanceActionPath.html?method=downloadStudentAttendanceDetailsPDF&startDate=" + startDate + "&endDate=" + endDate;
		
});



});



