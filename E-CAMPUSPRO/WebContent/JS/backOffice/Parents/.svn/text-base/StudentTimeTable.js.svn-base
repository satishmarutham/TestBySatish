$(document)
		.ready(
				function() {
					
					
					
					var studentid = $("#studentid").val();
				
					
					$("#timetableid option[value ='"+studentid+ "']").attr('selected',true);
					
		        
					
					
					$('#timetableid').change(function(){
						
						var studentid = $(this).val();
						
						window.location.href = "parentMenu.html?method=getStudentTimetable&studentid="+studentid;
						
					});
					
					
				
					
					
				});