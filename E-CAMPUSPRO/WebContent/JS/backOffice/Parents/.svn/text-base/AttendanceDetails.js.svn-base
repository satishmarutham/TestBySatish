$(document)
.ready(
		function() {
			
	
			
			
			var s1=$("#studentid1").val();
			
			
			
		
			 
			if($("#studentid1").val()!="")
			{
				
				$("#studAttnId").show();
				$("#studAttnId option[value="+$("#studentid1").val().trim()+"]").attr("selected",'true');
			}
		 
		
			
			
			
			
			
			
			
			  $("#viewAttendanceId").click(function(){
				  
				  var studentid1=$("#studentid1").val();
				  var studentid=$("#studentid").val();
					 var monthid=$("#monthid").val();
					 var currentyearid=$("#currentyearid").val(); 
					 
					 
				
				
					 
					 if(monthid==""||monthid==null){
						 
							$(".errormessagediv").show();
		     				$(".validateTips").text("Select any one Month");
		     				
		     				return false;
					 }
					 
					 
					
					 
					 else{
						 
						 window.location.href = "parentMenu.html?method=getAttendanceView&studentid="+studentid+"&monthid="+monthid+"&currentyearid="+currentyearid+"&studentid1="+studentid1;
					 }
						 
					 
				  
			  });
			  
			  
			  
			  
			  $("#studAttnId").change(function(){
				  
				  
				  
				  var studentid = $('#studAttnId').val();
				  var parentid = $('#parenthidden').val();
				
				  
				  window.location.href = "parentMenu.html?method=getNextChildAttendance&studentid="+studentid+"&parentid="+parentid;
				  
				  
			  });
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			
			
		});



function getvaldetails(value){
	
	var s1 =value.id;
	

	
	
		var attendance = s1.split(",");
		
		
	
	$("#monthid").val(attendance[0]);
	$("#currentyearid").val(attendance[1]);
}








