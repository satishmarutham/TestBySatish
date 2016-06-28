$(document)
		.ready(
				function() {
					
					
			
					var teachername = $('#hteacherid').val();	
					
				
					
					$("#teachernameid option[value=" + teachername + "]").attr('selected', 'true');			
					
					
				
				
				 $("#editId").click(function(){
					 

						var classid = $("#classid").val();
						var sectionid = $("#sectionid").val();
						var teacherid = $("#teacherid").val();
						
						
						if(classid=="" && sectionid=="" && teacherid==""){
							
							 $(".errormessagediv").show();
							 $(".validateTips").text("Select CheckBox");
							 
							 return false;
							
						}
						else{
							
							 window.location.href = "classteachermapping.html?method=editClassTeacherAction&classid="+classid+"&sectionid="+sectionid+"&teacherid="+teacherid;
						}
						
						 
				 });
				
				 
				 $("#saveid").click(function(){
				
					    var classid = $("#hclassid").val();
						var sectionid = $("#hsectionid").val();
						var teacherid = $("#teachernameid").val();
						var teacherid1 = $("#hteacherid").val();
						 
						 if(teacherid=="" || teacherid==null){
							 
							 $(".errormessagediv").show();
							 $(".validateTips").text("Select Teacher Name");
							 
							 return false;
							 
						 }
						 
						 if(validateclassTeacher() == 1 ) {
								
	                            $(".errormessagediv").show();
								
								$(".validateTips").text(" Teacher already Mapped for Same Class&Section");
								
								return false;
							}
						 
						 
						 
						 else{
							 
						 alert("call save action");
						 
						 datalist = {
									"classid" : classid,"sectionid" : sectionid, "teacherid" :teacherid, "teacherid1":teacherid1
									
								};
						 $
							.ajax({
								
								type : 'POST',
								url : "classteachermapping.html?method=saveClassTeachetAction",
								data : datalist,
								async : false,
								success : function(
										data) {
									
									
									var result = $.parseJSON(data);
									
									if(result.jsonResponse=="Class Teacher Mapped Successfully"){
										
										$(".errormessagediv").hide();
										$(".successmessagediv").show();
										 $(".validateTips").text("Class Teacher Mapped Successfully");
										 
										 
										
										 
										 setTimeout(function(){
												
											 window.location.href = "adminMenu.html?method=getclassandteacherList";
										 
										 },3000);
										
									}
									
									if(result.jsonResponse=="Class Teacher Mapped Failed"){
										
										$(".errormessagediv").show();
										$(".successmessagediv").hide();
										 $(".validateTips").text("Class Teacher Mapped Failed");
										 
										 setTimeout(function(){
												
											 window.location.href = "adminMenu.html?method=getclassandteacherList";
										 
										 },3000);
										
									}

									
								}
								
							});
					 
						 
						 
						 }
				 });
				 
					
				 
					$("#search").click(function(){
						
						
						var searchTerm=$("#searchterm").val().trim();
						
						if(searchTerm==""){
						
							$('.errormessagediv').show();
							$('.validateTips').text("Enter search term");
						
						}else{
							
							window.location.href="adminMenu.html?method=getclassandteacherList&searchTerm="+searchTerm;	
							
						}
						
						
						
					});
				 
				 
				 
				 
				 
					$('#xls')
					.click(
							function() {
								
								window.location.href = "classteachermapping.html?method=classTeacherMappingXLSReport";
								
							});

					$("#pdfDownload").click(function(){
						
						window.location.href = "classteachermapping.html?method=classTeacherMappingPDFReport";
							
					});	
				 
				 
				 
				 
				 
				 
				 
				 
				 
				});


function validateclassTeacher(){
	
	var classteacher_validate=0;
	
	
	   var classid = $("#hclassid").val();
		var sectionid = $("#hsectionid").val();
		var teacherid = $("#teachernameid").val();
		
		
		
	var datalist = {
					"classid" : classid,"sectionid" : sectionid, "teacherid" :teacherid
					
				};
		 $
			.ajax({
				
				type : 'GET',
				url : "classteachermapping.html?method=viewValidateClassTeacherAction",
				data : datalist,
				async : false,
				success : function(
						data) {
					
					var result = $.parseJSON(data);
					
					
					
					if (result.status=="true") {
						
						classteacher_validate = 1;

					}
					else 
						
					{
						classteacher_validate = 0;
					}
					
					
				}
			});
		 return classteacher_validate;
	
}


function getvaldetails(value){
	
	var s1 =value.id;
	
		var mappedvalues = s1.split(",");
		
		$("#classid").val(mappedvalues[0]);
		$("#sectionid").val(mappedvalues[1]);
		$("#teacherid").val(mappedvalues[2]);
		
	
}











