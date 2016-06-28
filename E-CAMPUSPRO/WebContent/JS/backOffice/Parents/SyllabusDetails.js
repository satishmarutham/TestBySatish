
$(document).ready(function() {
	

	if($("#hstreamid").val()!="")
	{
		
		$("#streamId").show();
		$("#streamId option[value="+$("#hstreamid").val().trim()+"]").attr("selected",'true');
		
		
		var hstreamid=$("#hstreamid").val();
		
		
		
		datalist = {
				"streamname" : hstreamid
			},
		
		$.ajax({
			type : 'POST',
			url : "parentMenu.html?method=getClassDetails",
			data : datalist,
			success : function(response) {
				
				var result = $.parseJSON(response);
			
				  $('#classid').html("");
				
				  $('#classid').append(
							
							'<option value="' + "" + '">' + "---Select---"
									
							+ '</option>');
					
					for ( var j = 0; j < result.classlist.length; j++) {

						$('#classid').append(

						'<option value="'

						+ result.classlist[j].classId + '">'

						+ result.classlist[j].className

						+ '</option>');
						
		
					}
					
					$("#classid").show();
					$("#classid option[value="+$("#hclassid").val().trim()+"]").attr("selected",'true');
				
			}
			
		});
		
		
	}
	
	if($("#hclassid").val()!="")
	{
		
		$("#classid").show();
		$("#classid option[value="+$("#hclassid").val().trim()+"]").attr("selected",'true');
		
	}
	
	
	
	$("#streamId").change(function(){
		
		 $('#streamId').show();
		 $('#classid').show();
	 
		getClass(classid,streamId);
		
	});
	
	
	
	$("#classid").change(function(){
		
		 var streamId=$("#streamId").val();	
		var classid = $("#classid").val();
		
	
		
		
		 window.location.href = "parentMenu.html?method=getSubjectDetails&classid="+classid+"&streamId="+streamId;
		
	});
	
	
});

var classlength=0;
function getClass(classid,streamId) {
	
	
	var streamname = $("#streamId").val();
	
	
	
	datalist = {
			"streamname" : streamname
		},
		
		
		$.ajax({
			
			type : 'POST',
			url : "parentMenu.html?method=getClassDetails",
			data : datalist,
			success : function(response) {
			
				var result = $.parseJSON(response);
			
			   $('#classid').html("");
			
	             $('#classid').append(
						
						'<option value="' + "" + '">' + "---Select---"
								
						+ '</option>');
				
				for ( var j = 0; j < result.classlist.length; j++) {

					$('#classid').append(

					'<option value="'

					+ result.classlist[j].classId + '">'

					+ result.classlist[j].className

					+ '</option>');

				}
				
			}
			
		});

}


function getvaldetails(value){
	
	var s1 =value.id;
	
	var subjectid = s1;

	$("#subjectid").val(subjectid);
	
	
}


function downloadfunction(val){
	
	var subid =val.id;
	
	var subjectid=subid.split(",");
	
	

	if(subjectid == ""|| subjectid ==null){
		
		$('.errormessagediv').show();
		$('.validateTips').text("No File for download");
		return false;
		
	}
	
	else{
		
		window.location.href = "parentMenu.html?method=downloadSubject&subjectid="+subjectid[0];
	}
	
	
	
	
}

