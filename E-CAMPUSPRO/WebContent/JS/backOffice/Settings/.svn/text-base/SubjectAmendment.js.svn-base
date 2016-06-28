$(document)
		.ready(
				function() {
					
					getClassName();		
					
					
					$("#document1btn").hide();
					$("#deleteProfile").hide();	
					
					
				/*	
					
					var success=$("#hsuccessid").val().trim(); 
					if(success == success){
						$("#file").show();
						$("#document1btn").hide();
						$("#deleteProfile").hide();	
						
					}
					
					else{
						
						$("#file").hide();
						$("#document1btn").show();
						$("#deleteProfile").show();	
						
					}*/
					
					var hiddenclass=$("#hiddenclassid").val().trim(); 
					
					
					
				  
					$("#classnameid option[value="+ hiddenclass + "]").attr('selected', 'true');
					
					
				    var hiddensubject=$("#hiddensubject").val();
					var hiddendescription=$("#hiddendescription").val();
					
					
					$("#subjtname").val(hiddensubject);
					$("#description").val(hiddendescription);
					
					
					
				    setTimeout("removeMessage()" ,3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);
					
					
		$('#save')
					.click(
							function() {
								
								
			                
                                var status=$("#statusid").val();
                              
								$(".errormessagediv").show();
								var  classname = $("#classname").val(), subjtname = $("#subjtname").val(), file = $("#file").val(), description = $("#description").val();

								
								 var docreg = /^(([a-zA-Z]:)|(\\{2}\w+)\$?)(\\(\w[\w].*))+(.doc|.docx|.DOC|.DOCX)$/;
							    var pdfreg = /^(([a-zA-Z]:)|(\\{2}\w+)\$?)(\\(\w[\w].*))+(.pdf|.PDF)$/;
								
                                 if(classname=="")
                                	 {
                                	 $(
										".errormessagediv")
										.show();
								$(".validateTips")
										.text(
												"Select Class ");
								return false;
                                	 }
                                 
                                 else if(subjtname=="")
                            	 {
                            	 $(
									".errormessagediv")
									.show();
							$(".validateTips")
									.text(
											"Enter Subject");
							return false;
                            	 }
                          
                                 
                                 else if(subjtname.length < 4)
                            	 {
                            	 $(
									".errormessagediv")
									.show();
							$(".validateTips")
									.text(
											"Subject Should Contain min 4 Characters");
							return false;
                            	 }
                                 
                                 else if(!subjtname
											.match(/^[a-z]([a-z_" "])+$/i))
                            	 {
                            	 $(
									".errormessagediv")
									.show();
							$(".validateTips")
									.text(
											"Subject should be Alphabet");
							return false;
                            	 }
                              
                                 
								 else {
									 $(".errormessagediv").hide();
									document.getElementById("SubjectForm").submit();
									
								}

								
								if (!bValid) {
									$(".errormessagediv").show();
								} else {

									$(".errormessagediv").hide();
								}
								return bValid;

								
							
							});
		
		var path=$("#hiddenfile").val();
		if(path !== "" && path!=undefined){
			
			$("#document1btn").attr('name',path);
			$("#file").hide();
			
			$("#document1btn").show();
			$("#deleteProfile").show();
			
		}
		
		$("#deleteProfile").click(function(){
			
			$("#file").show();
			
			$("#document1btn").hide();
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
				
				
				window.location.href = "subject.html?method=getpathdownload&Path="+ path;
			}
		
			
		});
		
		
		
		
				
					
				});

function getClassName() {
	
	
	
	$.ajax({
	url : "sectionPath.html?method=getCampusClassDetailsIDandClassDetailsNameAction",
	async:false,

	success : function(data) {

		

		var result = $.parseJSON(data);
		$('#classnameid').html("");
		$('#classnameid').append(
				'<option value="' + "" + '">' + ""
						+ '</option>');
		for (var j = 0; j < result.classDetailsIDandClassDetailsNameList.length; j++) {

			$('#classnameid').append(
					'<option value="' + result.classDetailsIDandClassDetailsNameList[j].secDetailsId + '">'
							+ result.classDetailsIDandClassDetailsNameList[j].secDetailsName + '</option>');
		}

	
	
	
	
	}
});}

function clearFields() {


	document.getElementById("classname").value = "";
	document.getElementById("subjtname").value = "";
	document.getElementById("file").value = "";
	document.getElementById("description").value = "";
}

function removeMessage() {
	

	
	$(".successmessagediv").hide();


}
	
