$(document).ready(function(){
	
	
	
	$("#saveid")
	.click(
			function() 
			
			{
				var fileName=$("#studentfile").val().split('.').pop().toLowerCase();
				var fileNameCheck=$("#studentfile").val();
				
				
				if(fileNameCheck==""){
					
					 $(".validateTips").text("Select File");
						$(".errormessagediv").show();
					 
					 $("#studentfile").css({'backgroundColor' : '#FFF7F7','border-color':'#B70606'});
					 setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
					return false;
				}else{
					
					document.getElementById("excelfileupload").submit();
					
			 		
					/*$(".errormessagediv").hide();
			  		$("#studentfile").css({'backgroundColor' : 'transparent','border':'1px solid #ccc'});
			 		return true;*/
			 	}
				
			
				
			if(fileName=="xlsx" || fileName=="xls"){
				
				$("#Add").val("xls");

			 		$(".errormessagediv").hide();
			  		$("#studentfile").css({'backgroundColor' : 'transparent','border':'1px solid #ccc'});
			 		
			 
					return true;
				}else{
					
					 $(".errormessagediv").show();
						$(".validateTips").text("Select Excel File Only");
						 $("#studentfile").css({'backgroundColor' : '#FFF7F7','border-color':'#B70606'});
						 setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
					return false;
				}
			alert("Student action is going");
			
			
				

});
});