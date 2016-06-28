$(document)
		.ready(
				function() {
					
					
					getClassName();
					
					
					var hiddenclass=$("#hiddenclassid").val().trim(); 
					
					
					
				  
					$("#classname option[value="+ hiddenclass + "]").attr('selected', 'true');
				    var hiddensubject=$("#hiddensubject").val();
					var hiddendescription=$("#hiddendescription").val();
					var hiddenfile=$("#hiddenfile").val();
					
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
                                 
                               /*  else if(!subjtname
											.match(/^[a-z]([a-z_" "])+$/i))
                            	 {
                            	 $(
									".errormessagediv")
									.show();
							$(".validateTips")
									.text(
											"Subject should be Alphabet");
							return false;
                            	 }*/
                              
                                 
                             	
                        /*         
                             else if((!file.match(docreg) && !file.match(pdfreg)))
                            	 {
                                	 
                                	
                                	
                            	 $(
									".errormessagediv")
									.show();
							$(".validateTips")
									.text(
											"Syllabus Should be pdf or word Format");
							return false;
                            	 }
								*/
                                

								 else {
									 $(".errormessagediv").hide();
									document.getElementById("SubjectForm").submit();
									
								}

                            
                            	 
								if (!bValid) {
									$(".errormessagediv").show();
								} else {

									$(".errormessagediv").hide();
								}
							

							/*	
								 setTimeout(function(){
										
									 window.location.href = "adminMenu.html?method=subjectdetails";
								 
								 },2000);
								
								*/
							
								return bValid;
							
							});
				
					
				});

function getClassName() {
	
	
	
	$.ajax({
	url : "sectionPath.html?method=getCampusClassDetailsIDandClassDetailsNameAction",
	async:false,

	success : function(data) {

		

		var result = $.parseJSON(data);
		$(classname).html("");
		$(classname).append(
				'<option value="' + "" + '">' + ""
						+ '</option>');
		for (var j = 0; j < result.classDetailsIDandClassDetailsNameList.length; j++) {

			$(classname).append(
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
	
