$(document).ready(function(){
	
	
/*	$('#deleteProfile').hide();
	$('#document1btn').hide();*/
	

	if($("#hFile").val()!=""){
		
		$('.download').show();
	
		$('#deleteProfile').show();
		$('#file').hide();
		
	}else{
		
		
		$('#file').show();
		
		$('#deleteProfile').hide();
		$('.download').hide();
	}
	
	
	
	$('#datetimepicker3').datetimepicker({
		pickDate : false
	});
	$('#datetimepicker4').datetimepicker({
		pickDate : false
	});
	
	$('#date').datepicker({
		minDate : 0,
		dateFormat : "dd-mm-yy",
		altField : "#dayOfWeekId",
		changeMonth : "true",
		changeYear : "true",
		altFormat : "DD",
		onSelect : function(dateText) {
			var seldate = $(this).datepicker('getDate');
			seldate = seldate.toDateString();
			seldate = seldate.split(' ');
			var weekday = new Array();
			weekday['Mon'] = "Monday";
			weekday['Tue'] = "Tuesday";
			weekday['Wed'] = "Wednesday";
			weekday['Thu'] = "Thursday";
			weekday['Fri'] = "Friday";
			weekday['Sat'] = "Saturday";
			weekday['Sun'] = "Sunday";
			var dayOfWeek = weekday[seldate[0]];
			$("#dayOfWeekId").val(dayOfWeek);

		}

	});
	
	
	
	
	
	
$('#save').click(function() {
				
	
	$(".successmessagediv").hide();
	
	            var eventId = $("#heventId").val();
	
                var title=$("#title").val();
				var date = $("#date").val(); 
				var starttime = $("#starttime").val();	
				var endtime = $("#endtime").val();
				var file = $("#file").val();
				
				var docreg = /^(([a-zA-Z]:)|(\\{2}\w+)\$?)(\\(\w[\w].*))+(.doc|.docx|.DOC|.DOCX)$/;
			    var pdfreg = /^(([a-zA-Z]:)|(\\{2}\w+)\$?)(\\(\w[\w].*))+(.pdf|.PDF)$/;
				
                 if(title==""){
                	 $(".errormessagediv").show();
				     $(".validateTips").text("Enter Title");
				    return false;
                 }else if(title.match(/^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$/i)==null){
	                 $(".errormessagediv").show();
				     $(".validateTips").text("Title should be Alphanumeric");
				     return false;
            	 }else if(date == ""){
	            	  $(".errormessagediv").show();
				      $(".validateTips").text("Enter Date");
				      return false;
            	 }else if(starttime == ""){
			          $(".errormessagediv").show();
					  $(".validateTips").text("Select StartTime");
					  return false;
            	
            	 }else if(endtime == ""){
            		   $(".errormessagediv").show();
 					  $(".validateTips").text("Select EndTime");
 					 return false;
            	 
            	 }else if(!checkTime()){
          		   
					  return false;
         	  
            	 }else if(eventId==""){
            		
            		 if(validateAcadamicYearPlan()==1){
                		 
              		   $(".errormessagediv").show();
    				   $(".validateTips").text("AcadamicYear Plan Already Exist for Selected date and time");
    					 return false;
            	    }else{
            	    	
            	    	$(".errormessagediv").hide();
    					document.getElementById("AcadamicYearPlanForm").submit();
            	    }
            		 
            	 }else if(eventId!=""){
            		
            		 if(validateAcadamicYearPlanUpdate()==1){
                		 
                		   $(".errormessagediv").show();
      				   $(".validateTips").text("AcadamicYear Plan Already Exist for Selected date and time");
      					 return false;
              	    }else{
              	    	
              	    	$(".errormessagediv").hide();
    					document.getElementById("AcadamicYearPlanForm").submit();
    					
    					
    					
              	    }
            		
            		 window.location.href="adminMenu.html?method=acdamicYearPlanList";
            	/*	 setTimeout(function(){
						   
						 window.location.href="adminMenu.html?method=acdamicYearPlanList";
						
					 
					 },3000);*/
            		 
            	}
            	 
            	 else{
            		
            		
            		
            	}
                 
				
	
				
			
			});


 
    $(".download").click(function(){
    	
    	 var filepath = $("input[name=download]").attr('id');
    	 
		
			window.location.href="acadamicYearPlan.html?method=download&filePath="+filepath;	
			
	});
 
 
    
    
    
    
    var path=$("#hFile").val();
    
   
   
  /*  
    if(path==""||path==null){
    	
    	  $(".errormessagediv").show();
		   $(".validateTips").text("No file for Downloading");
			 return false;
    	
    }*/
    
	if(path !== "" && path!=undefined){
		
		$("#document1btn").attr('name',path);
		$("#file").hide();
		
		$(".download").show();
		$("#deleteProfile").show();
		
	}
	
	$("#deleteProfile").click(function(){
		
		$("#file").show();
		
		$(".download").hide();
		$("#deleteProfile").hide();
		
	});
	
	

	
	
	$("#document1btn").click(function(){
		
		
		var path = $(this).attr('name');
		
		
		if(path == ""){
			
			$(".errormessagediv").show();
			$(".validateTips")
			.text(
					"No file for downloading");
		}
		else{
			
			
			window.location.href = "acadamicYearPlan.html?method=getAcadamicYearPlanFilePath&Path="+ path;
		}
	
		
	});
	
	
    
    
    
    
    
    
    
    
    
    
    
    

	
});






var status = false;
function checkTime() {
	
	var ftime = document.getElementById("starttime").value;
	var ttime = document.getElementById("endtime").value;
	
	
	
	if ((ftime != "") && (ttime != "")) {

		var ftimeSplitHour = ftime.split(':')[0];
		var ftimeSplitMin = ftime.split(':')[1];
		var ftimeSplitSec = ftime.split(':')[2];

		var ttimeSplitHour = ttime.split(':')[0];
		var ttimeSplitMin = ttime.split(':')[1];
		var ttimeSplitSec = ttime.split(':')[2];

		if (ftimeSplitHour.charAt(0) == 0) {
			ftimeSplitHour = ftimeSplitHour.charAt(1);
		}
		if (ttimeSplitHour.charAt(0) == 0) {
			ttimeSplitHour = ttimeSplitHour.charAt(1);
		}

		if (ftimeSplitMin.charAt(0) == 0) {
			ftimeSplitMin = ftimeSplitMin.charAt(1);
		}
		if (ttimeSplitMin.charAt(0) == 0) {
			ttimeSplitMin = ttimeSplitMin.charAt(1);
		}

		if (ftimeSplitSec.charAt(0) == 0) {
			ftimeSplitSec = ftimeSplitSec.charAt(1);
		}
		if (ttimeSplitSec.charAt(0) == 0) {
			ttimeSplitSec = ttimeSplitSec.charAt(1);
		}

		ftimeSplitHour = parseInt(ftimeSplitHour);
		ttimeSplitHour = parseInt(ttimeSplitHour);
		ftimeSplitMin = parseInt(ftimeSplitMin);
		ttimeSplitMin = parseInt(ttimeSplitMin);

		ftimeSplitSec = parseInt(ftimeSplitSec);
		ttimeSplitSec = parseInt(ttimeSplitSec);
		
	

		if (ftimeSplitHour > ttimeSplitHour) {
			$(".errormessagediv").show();
			$(".validateTips").text(
					"The End Time should not less than Start Time");
			return false;
			status = false;
			document.getElementById("endtime").value = "";
		}
		if (ttimeSplitHour == ftimeSplitHour) {
			if (ftimeSplitMin > ttimeSplitMin) {
				$(".validateTips").text("The End Time should not less than Start Time");
				$(".errormessagediv").show();
				
				return false;
				status = false;
				document.getElementById("endtime").value = "";

			}
			if (ftimeSplitMin == ttimeSplitMin) {
				if (ftimeSplitSec >= ttimeSplitSec) {
					$(".validateTips").text("The End Time should not less than Start Time");
					$(".errormessagediv").show();
					
					return false;
					status = false;
					document.getElementById("endtime").value = "";
				}
			}
		} else {
			$(".errormessagediv").hide();
			status = true;
		}
	} else {
		status = true;
	}
	return status;
}



function validateAcadamicYearPlan(){
	
	    var title=$("#title").val();
		var date = $("#date").val(); 
		var starttime = $("#starttime").val();	
		var endtime = $("#endtime").val();
	
		var acadamicyearplan_validate=0;
	
		var acadamicyearPlanObject = {
			"title" : title,
			"date" : date,
			"starttime" : starttime,
			"endtime" : endtime,
			
		};

		$.ajax({

			type : "POST",
			url : "acadamicYearPlan.html?method=validateAcadamicYearPlan",
			data : acadamicyearPlanObject,
			async : false,

			success : function(data) {

				var result = $.parseJSON(data);
				
				
				if (result.status=="true") {

					$('.errormessagediv').show();
					$('.validateTips').text("AcadamicYear Plan Already Exist for Selected date and time");
					
					acadamicyearplan_validate = 1;

				} else {
					acadamicyearplan_validate = 0;
				}

			}

		});


		return acadamicyearplan_validate;
	
}


function validateAcadamicYearPlanUpdate(){
	
    var AcadamicYearplanCode = $("#heventId").val();
	   var title=$("#title").val();
		var date = $("#date").val(); 
		var starttime = $("#starttime").val();	
		var endtime = $("#endtime").val();
	
		var acadamicyearplan_validate=0;
	
		var acadamicyearPlanObject = {
			"title" : title,
			"date" : date,
			"starttime" : starttime,
			"endtime" : endtime,
			"AcadamicYearplanCode":AcadamicYearplanCode
		};

		$.ajax({

			type : "POST",
			url : "acadamicYearPlan.html?method=validateAcadamicYearPlanUpdate",
			data : acadamicyearPlanObject,
			async : false,

			success : function(data) {

				var result = $.parseJSON(data);
				
				
				if (result.status=="true") {

					$('.errormessagediv').show();
					$('.validateTips').text("AcadamicYear Plan Already Exist for Selected date and time");
					
					acadamicyearplan_validate = 1;

				} else {
					acadamicyearplan_validate = 0;
				}

			}

		});


		return acadamicyearplan_validate;
	
	
	
}





