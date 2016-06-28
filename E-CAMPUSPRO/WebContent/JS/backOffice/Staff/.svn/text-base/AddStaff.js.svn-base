$(document)
		.ready(
				function() {
					
					$("#usertype").change(function(){
						
						var usertype=$("#usertype").val();
						
						
						if(usertype=="admin"){
						
						$("#roleId option[value='ROL1' ]").attr('selected', 'true');
						
						$("#roleId").attr('disabled', true);
						
						}
						
						if(usertype=="teacher"){
							
							$("#roleId option[value='ROL2' ]").attr('selected', 'true');
							$("#roleId").attr('disabled', true);
							
							}
						
						
						if(usertype=="custum"){
							
							$("#roleId option[value=' ' ]").attr('selected', 'true');
							$("#roleId").attr('disabled', false);
							
							}
						
						$("#selectedRole").val($("#roleId").val().trim());
						
						
					});
					
					
					$("#roleId").change(function(){
						
						$("#selectedRole").val($("#roleId").val().trim());
						
					});
					
					
					
					$("#imagePreview").hide();
					
					$("#teaImageId").change(function(){
						
											
						$("#imagePreview").show();
						readURL(this);
						
					});
					
					 setTimeout("removeMessage()" ,3000);
						setInterval(function() {
							$(".errormessagediv").hide();
						}, 3000);
					
					
				

					var primary = "#" + "primaryid";
					var secondary = "#" + "secondaryid";

					$
							.ajax({
								type : 'POST',
								url : 'teacherregistration.html?method=getSubjects',
								async : false,
								success : function(response) {
									var data = $.parseJSON(response);
									for (var j = 0; j < data.SubjectList.length; j++) {

										$(primary)
												.append(
														'<option value="'
																+ data.SubjectList[j].subjectid
																+ '">'
																+ data.SubjectList[j].subjectname
																+ '</option>');

										$(secondary)
												.append(
														'<option value="'
																+ data.SubjectList[j].subjectid
																+ '">'
																+ data.SubjectList[j].subjectname
																+ '</option>');

									}

								}

							});
					
					var department = "#" + "department";

					$
							.ajax({
								type : 'POST',
								url : 'teacherregistration.html?method=getDepartment',
								async : false,
								success : function(response) {
									var data = $.parseJSON(response);

									for (var j = 0; j < data.DEPARTMENTLIST.length; j++) {

										$(department)
												.append(
														'<option value="'
																+ data.DEPARTMENTLIST[j].depId
																+ '">'
																+ data.DEPARTMENTLIST[j].depName
																+ '</option>');
									}

								}

							});

					var designation = "#" + "designation";

					$
							.ajax({
								type : 'POST',
								url : 'teacherregistration.html?method=getDesignation',
								async : false,
								success : function(response) {
									var data = $.parseJSON(response);

									for (var j = 0; j < data.DESIGNATIONLIST.length; j++) {

										$(designation)
												.append(
														'<option value="'
																+ data.DESIGNATIONLIST[j].desgid
																+ '">'
																+ data.DESIGNATIONLIST[j].desgname
																+ '</option>');
									}

								}

							});
					
					
					var hiddenprimary=$("#hiddenprimary").val();
					
					$("#primaryid option[value=" + hiddenprimary + "]").attr('selected', 'true');
					
					var hiddensecoundary=$("#hiddensecoundary").val();
					$("#secondaryid option[value=" + hiddensecoundary + "]").attr('selected', 'true');
					
					var hiddendept=$("#hiddendept").val();
					$("#department option[value=" + hiddendept + "]").attr('selected', 'true');
					
					
					var hiddendes=$("#hiddendes").val();
					$("#designation option[value=" + hiddendes + "]").attr('selected', 'true');
					
					var hiddenteatype=$("#hiddenteatype").val();
					$("#teachingtype option[value=" + hiddenteatype + "]").attr('selected', 'true');
					
					var hiddengender=$("#hiddengender").val();
					$("#gender option[value=" + hiddengender + "]").attr('selected', 'true');

					
					$("#dateofbirthid").datepicker(
							{

								dateFormat : "dd-mm-yy",
								yearRange : 'c-65:c+65',
								maxDate : -1,
								changeMonth : "true",
								changeYear : "true",
								onClose : function(selectedDate) {
									$("#joindateid").datepicker("option",
											"minDate", selectedDate);

								}

							});

					$("#joindateid").datepicker(
							{

								dateFormat : "dd-mm-yy",
								yearRange : 'c-65:c+65',
								maxDate : 0,
								changeMonth : "true",
								changeYear : "true",
								onClose : function(selectedDate) {
									$("#dateofbirthid").datepicker("option",
											"maxDate", selectedDate);

								}

							});
					
				
					
					
					$('#save')
					.click(
							function() {
					            
					             
								if(validateform())
									{
									
									/*if(status=="update")
										{
										document.getElementById("teacherupdateform").submit();
										
										}else{*/
									
									document.getElementById("teacherform").submit();
									
									
									
									//}
									}; 
								
							});
					
					
					/*$('#editTeacher')
					.click(
							function() {
								
								
								var count = 0;
								$(
										'input.vehicle_Checkbox_Class:checkbox:checked')
										.map(
												function() {

													var vehicle_id = $(
															this).attr(
															"id");
													var split_id = vehicle_id
															.split('_');
													getData = split_id[1]
															.split(',');

													count++;
												});
								if (count == 0 || count > 1) {
									$(".errormessagediv").show();
									$(".validateTips").text(
											"Check any one checkbox");
									return false;

								} else {
								
									window.location.href = "subject.html?method=getSubjectDetails&subjectcode="+getData[0];
								
								}
							});*/
					
					
				});


function validateform() {
	
	var presentadd=$("#presentadd").val().trim();
	var permanentadd=$("#permanentadd").val().trim();
	var fathername=$("#fathername").val().trim();
	var mothername=$("#mothername").val().trim();
	var teacherId = $("#regno").val().trim();
	var firstname = $("#fname").val().trim();
	var lastname = $("#lname").val().trim();
	var username = $("#uname").val().trim();
	var qualification = $("#qualification").val().trim();
	var primaryid = $("#primaryid").val();
	var secondaryid = $("#secondaryid").val();
	var teacheremail = $("#teacherEmail").val().trim();
	var mobilenumber = $("#mnumber").val().trim();
	/*var address = $("#paddrs").val().trim();*/
	var designation = $("#designation").val();
	var teaprofile = $("#teaprofile").val();
	var teaImageId = $("#teaImageId").val();
	var dateofbirth = $("#dateofbirthid").val();
	var joiningdate = $("#joindateid").val();
	var idproof = $("#idproof").val();
	var teachingtype = $("#teachingtype").val();
	var department = $("#department").val();
	var role = $("#roleId").val();
	var gender = $("#gender").val();
	var location = $("#locationid").val();
    var bvalid=true;
    var usertype=$("#usertype").val();
    
    

	var dob = Date.parse(dateConverter(dateofbirth));
	var doj = Date.parse(dateConverter(joiningdate));

	if (firstname.length == 0) {
		$(".validateTips").text("Enter First Name");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (firstname.length <= 2) {
		$(".validateTips").text("Name contain minimum 3");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (!firstname.match(/^[a-z]([a-z_" "])+$/i)) {
		$(".validateTips").text("Name should be Alphabet");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (lastname.length != 0) {

		if (!lastname.match(/^[a-zA-Z\s]+$/g)) {
			$(".validateTips").text("Name should be Alphabet");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}

	}
	
	
	if (teacherId.length == 0) {
		$(".validateTips").text("Enter Teacher Id");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	if (checkregistrationNo(teacherId)) {
		$(".validateTips").text("Teacher Id Exists");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	if (department.length == 1) {
		$(".validateTips").text("Select Department");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	
	if (joiningdate.length == 0) {
		$(".validateTips").text("Select Date of Joining");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	
	if (designation.length == 1) {
		$(".validateTips").text("Select Designation");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	
	

	if (teachingtype.length == 1) {
		$(".validateTips").text("Select Teaching Type ");
		$(".errormessagediv").show();
		bvalid=false;
		return false;

	}

	if (teachingtype == "Teaching") {

		if (primaryid.length == 1) {
			$(".validateTips").text("Select Primary Subject");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}
	}
	
	

	/*if ((teachingtype == "Teaching" ) && (username.length>0)) {*/
		if (username.length == 0) {
			$(".validateTips").text("Enter Username");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}
		if (username.length < 5) {
			$(".validateTips").text("Username contain minimum 5");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}
		if (!username.match(/^[a-z]([a-zA-Z0-9~@#$^*()_+=[\]{}|\\,.?:-])+$/i)) {
			$(".validateTips").text("Username should start with a Alphabet");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}
		if (checkusername(username)) {
			$(".validateTips").text("User Name already Exists");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}
		/*if (teacheremail.length == 0) {
			$(".validateTips").text("Enter Email Id");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}

		if (!teacheremail
				.match(/^([a-zA-Z])(([a-zA-Z0-9])*([\._-])?([a-zA-Z0-9]))*@(([a-zA-Z0-9\-])+(\.))+([a-zA-Z]{2,4})+$/)) {
			$(".validateTips").text("Enter valid Email ID");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}
		if (checkmail(teacheremail)) {

			$(".validateTips").text("Email ID already Exists");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}*/
	/*}*/
	
		if(usertype.length == 1){
			
			$(".validateTips").text("Select Usertype");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}
	
	if (role.length == 1) {
		$(".validateTips").text("Select Role");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	if (gender.length == 1) {
		$(".validateTips").text("Select Gender");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}

	if (dateofbirth.length == 0) {
		$(".validateTips").text("Select Date of Birth");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	if (dob >= doj) {
		$(".validateTips").text(
				"Date of Joining should be greater than Date of Birth");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (qualification.length == 0) {
		$(".validateTips").text("Enter Qualification");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (qualification.length < 2) {
		$(".validateTips").text("Qualification contain minimum 2");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (!qualification.match(/^[a-z]([a-z,_ ])+$/i)) {
		$(".validateTips").text("Qualification should be Alphabet");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}

	if (mobilenumber.length == 0) {
		$(".validateTips").text("Enter Mobile No");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (mobilenumber.length < 10) {
		$(".validateTips").text("Mobile No should be min 10 & max 11 digits ");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (!mobilenumber.match(/^(?!0{6})([0-9])+$/i)) {
		$(".validateTips").text("Enter valid Mobile No");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}


    if(teacheremail != ""){
	if (!teacheremail
			.match(/^([a-zA-Z])(([a-zA-Z0-9])*([\._-])?([a-zA-Z0-9]))*@(([a-zA-Z0-9\-])+(\.))+([a-zA-Z]{2,4})+$/)) {
		$(".validateTips").text("Enter valid Email ID");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	if (checkmail(teacheremail)) {

		$(".validateTips").text("Email ID already Exists");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	}
     
     if (fathername.length == 0) {
 		$(".validateTips").text("Enter Father Name");
 		$(".errormessagediv").show();
 		bvalid=false;
 		return false;
 	}
 	if (fathername.length <= 2) {
 		$(".validateTips").text("Father Name contain minimum 3");
 		$(".errormessagediv").show();
 		bvalid=false;
 		return false;
 	}
 	if (!fathername.match(/^[a-z]([a-z_" "])+$/i)) {
 		$(".validateTips").text("Father Name be Alphabet");
 		$(".errormessagediv").show();
 		bvalid=false;
 		return false;
 	}
 	
 	
 	  if (mothername.length == 0) {
 	 		$(".validateTips").text("Enter Mother Name");
 	 		$(".errormessagediv").show();
 	 		bvalid=false;
 	 		return false;
 	 	}
 	 	if (mothername.length <= 2) {
 	 		$(".validateTips").text("Mother Name contain minimum 3");
 	 		$(".errormessagediv").show();
 	 		bvalid=false;
 	 		return false;
 	 	}
 	 	if (!mothername.match(/^[a-z]([a-z_" "])+$/i)) {
 	 		$(".validateTips").text("Mother Name be Alphabet");
 	 		$(".errormessagediv").show();
 	 		bvalid=false;
 	 		return false;
 	 	}

	
	
	if (presentadd.length == 0) {
		$(".validateTips").text("Enter Present Address");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (presentadd.length < 5) {
		$(".validateTips").text("Present Address contain minimum 5");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	

	if (permanentadd.length == 0) {
		$(".validateTips").text("Enter Permanent Address");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	if (permanentadd.length < 5) {
		$(".validateTips").text("Permanent Address contain minimum 5");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	


	var docreg = /^(([a-zA-Z]:)|(\\{2}\w+)\$?)(\\(\w[\w].*))+(.doc|.docx|.DOC|.DOCX)$/;
	var pdfreg = /^(([a-zA-Z]:)|(\\{2}\w+)\$?)(\\(\w[\w].*))+(.pdf|.PDF)$/;

	if (teaprofile.length > 0) {
		if (!teaprofile.match(docreg) && !teaprofile.match(pdfreg)) {
			$(".validateTips").text("Profile should be pdf or docs Format ");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}
	}

	var imgReg = /^(([a-zA-Z]:)|(\\{2}\w+)\$?)(\\(\w[\w].*))+(.jpg|.jpeg|.JPEG|.gif|.JPG|.png|.PNG)$/;
	if (teaImageId.length > 0) {
		if (!teaImageId.match(imgReg)) {
			$(".validateTips").text("Upload only Image Format Image");
			$(".errormessagediv").show();
			bvalid=false;
			return false;
		}
	}

	if (dob >= doj) {
		$(".validateTips").text(
				"Joining date should be greater than Date of Birth");
		$(".errormessagediv").show();
		bvalid=false;
		return false;
	}
	
	
	var classarayy=[];
	var sectionarray=[];
	
	$(".teacherclass tr").each(function(){
		
		
		  var classvalue =$(this).find('.select-control').val();
			
		    if(classvalue!=undefined){
			 
		    	classarayy.push(classvalue.trim());

	    	 }
		  
		  var sectionval =$(this).find('.inputbox').val();
			
		    if(sectionval!=undefined){
			 
		    	sectionarray.push(sectionval.trim());

	    	 }
		
		
	});
	
	 for (var i = 0; i < classarayy.length; i++) {
		 
		 if(classarayy[i]==""){
			 
			 $(".validateTips").text("Class shoul not empty");
				$(".errormessagediv").show();
			 bvalid=false;
			 return false;
		 }
		 
		 if(sectionarray[i]==""){
			 
			 $(".validateTips").text("Section shoul not empty");
			 $(".errormessagediv").show();
			 bvalid=false;
			 return false;
			 
		 }
	 }
	 
	   var classsesction=[];
	   
	   for(var i=0;i<classarayy.length;i++){
		   
		   classsesction.push(classarayy[i]+"-"+sectionarray[i]);
	   }
	   
		var sortclasssesction=classsesction.sort();
		  for (var j = 0; j < classsesction.length-1; j++) {
			
			 if(classsesction[j]!="" && sortclasssesction[j + 1] ){
			  if (sortclasssesction[j + 1] == classsesction[j]) {
				  
			    $(".validateTips").text("class & section should not duplicate");
				$(".errormessagediv").show();
					bvalid=false;
					 return false;
			    }
			  }
			  
			}

	return bvalid;
	
}

function dateConverter(dateString) {
	var dateArray = [];
	var dateStringArray = dateString.split("-");
	dateArray.push(dateStringArray[2]);
	dateArray.push(dateStringArray[1]);
	dateArray.push(dateStringArray[0]);
	var dateString1 = dateArray.join("-");
	return dateString1;
}

function checkusername(username,teacherid) {
	
	

	var userdata = {
		"username" : username,
		"teacherId"  : teacherid
	};
	var status1 = false;

	$.ajax({

		type : "GET",
		url : "teacherregistration.html?method=checkUsername",
		data : userdata,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);

			status1 = result.status;

		}

	});

	return status1;
}


function checkmail(mailid) {

	var maildata = {
		"mailid" : mailid
	};
	var status1 = false;

	$.ajax({

		type : "GET",
		url : "teacherregistration.html?method=checkMail",
		data : maildata,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);

			status1 = result.status;

		}

	});

	return status1;

}

function removeMessage() {
	

	
	$(".successmessagediv").hide();
	
	

}

function checkregistrationNo(username,teacherid) {
	
	

	var userdata = {
		"registrtno" : username,
		"teacherId"  : teacherid
	};
	var status1 = false;

	$.ajax({

		type : "GET",
		url : "teacherregistration.html?method=checkRegistrationNo",
		data : userdata,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);

			status1 = result.status;

		}

	});

	return status1;
}


function add(){
	
	
		var elementCount = parseInt(document.getElementById("count").value);
		
		var tr1 = document.createElement('tr');
		
		
		var th0 = document.createElement('td');
		
		var check = document.createElement("input");
		check.type = "checkbox";
		check.id = "check" + elementCount;
		check.setAttribute("class","ckeckboxclass");
		th0.align = 'center';
	
		th0.appendChild(check);
		tr1.appendChild(th0); 
		
	
		/*var th1 = document.createElement('td');
	
		var lable1 = document.createElement("lable");
		lable1.id = "lable" + elementCount;
		th1.align = 'center';
	
		th1.appendChild(lable1);
		tr1.appendChild(th1); */
		
	
		var th2 = document.createElement('td');
	
	    var element1 = document.createElement("select");
        element1.name = "value(name"+elementCount+")";
        element1.id = "nameid"+elementCount;
        element1.setAttribute("class","select-control");
        
        th2.appendChild(element1);
        tr1.appendChild(th2);
        
        
       /* var th3 = document.createElement('td');
    	
     	var lable2 = document.createElement("lable");
    	lable2.id = "lablevalue" + elementCount;
    	th3.align = 'center';
    	
    	th3.appendChild(lable2);
    	tr1.appendChild(th3); */
    	
    	
    		var th4 = document.createElement('td');
    	
    	    var element2 = document.createElement("select");
    	    element2.name = "value(value"+elementCount+")";
    	    element2.id = "valueid"+elementCount;
    	    element2.setAttribute("class","inputbox");
            th4.appendChild(element2);
            
            tr1.appendChild(th4);
        
        
	
        document.getElementById("allstudent").appendChild(tr1);
        
        
   /*     $("#"+lable1.id).text("Class");
        $("#"+lable2.id).text("Section");*/
        
        
        
        $.ajax({
			type : "GET",
			url : "teacherregistration.html?method=getCLasses",
			async : false,

			success : function(data) {
				var result = $.parseJSON(data);
				
				$("#"+element1.id).append(
						'<option value="'
								+ ""
								+ '">'
								+ ""
								+ '</option>');
				
				
				for(var i=0;i<result.classList.length;i++){
					
							$("#"+element1.id).append(
									'<option value="'
								+ result.classList[i].classId.trim()
								+ '">'
								+ result.classList[i].className.trim()
								+ '</option>');
							
							
				}
		
			}
		});
        
        
        $("#"+"nameid"+elementCount).change(function(){
			
			getSection(this.value,element2.id);
			
		});

     
    document.getElementById("count").value = elementCount + parseInt(1);
    
    
    
}

function getSection(clasvalue,sectionid){
	
	
	$.ajax({
		type : "GET",
		url : "teacherregistration.html?method=getMappedSection",
		data : {"classidVal":clasvalue,"TeacherID":"","sectionID":""},
		async : false,

		success : function(data) {
			var result = $.parseJSON(data);
			
			$("#"+sectionid).append(
					'<option value="'
							+ ""
							+ '">'
							+ "-----select-----"
							+ '</option>');
			
			
			for(var i=0;i<result.sectionList.length;i++){
				

					$("#"+sectionid).append(
							'<option value="'
						+ result.sectionList[i].sectionId
						+ '">'
						+ result.sectionList[i].sectionname
						+ '</option>');
				
			}
	
		}
	});
	
}

function deleteClassMapping(){
	
	var checkcount=0;
	
	 $(".table tr").each(function(){
		 
		 var elementCount = parseInt(document.getElementById("count").value);
		 
		   var checkboxvalue=$(this).find('.ckeckboxclass').attr("id");
		   
		   
		   if(checkboxvalue!=undefined && checkboxvalue!=""){
			   
			   var count=parseInt(checkboxvalue.substr(5,checkboxvalue.length));
			   
			   if($('#'+checkboxvalue).is(":checked")){
				   
				   checkcount++;
				   
				   if((count+1)==elementCount){
					   
					   $("#"+checkboxvalue).parent().parent().remove();
					   document.getElementById("count").value = elementCount - parseInt(1);
					   
				   }else{
					   
					   $(".validateTips").text("Delete Class&Section from last row");
						$(".errormessagediv").show();
				   }
			   }
			   
		   }
			   
	 });
	 
	 if(checkcount==0){
		   
		   
		   $(".validateTips").text("Select record to delete");
			$(".errormessagediv").show();
	   }
	
}

function addSubject(){
	
	var elementCount = parseInt(document.getElementById("subjectcount").value);
	
	var tr1 = document.createElement('tr');
	
	
	var th0 = document.createElement('td');
	
	var check = document.createElement("input");
	check.type = "checkbox";
	check.id = "subjectcheck" + elementCount;
	check.setAttribute("class","ckeckboxclass");
	th0.align = 'center';

	th0.appendChild(check);
	tr1.appendChild(th0); 
	

	

	var th2 = document.createElement('td');

    var element1 = document.createElement("select");
    element1.name = "talue(name"+elementCount+")";
    element1.id = "subjectnameid"+elementCount;
    element1.setAttribute("class","select-control");
    
    th2.appendChild(element1);
    tr1.appendChild(th2);
    
	
		var th4 = document.createElement('td');
	
	    var element2 = document.createElement("select");
	    element2.name = "talue(value"+elementCount+")";
	    element2.id = "subjectvalueid"+elementCount;
	    element2.setAttribute("class","inputbox");
        th4.appendChild(element2);
        
        tr1.appendChild(th4);
        
        
       /* 
    	var th5 = document.createElement('td');
    	
	    var element3 = document.createElement("select");
	    element3.name = "value(value"+elementCount+")";
	    element3.id = "subjectid"+elementCount;
	    element3.setAttribute("class","subjectclass");
	    th5.appendChild(element3);
        
        tr1.appendChild(th5);*/
    
    document.getElementById("addstaffsubject").appendChild(tr1);
    
    $.ajax({
		type : "GET",
		url : "teacherregistration.html?method=getCLasses",
		async : false,

		success : function(data) {
			var result = $.parseJSON(data);
			
			$("#"+element1.id).append(
					'<option value="'
							+ ""
							+ '">'
							+ ""
							+ '</option>');
			
			
			for(var i=0;i<result.classList.length;i++){
				
						$("#"+element1.id).append(
								'<option value="'
							+ result.classList[i].classId.trim()
							+ '">'
							+ result.classList[i].className.trim()
							+ '</option>');
						
						
			}
	
		}
	});
    
    
    $("#"+"subjectnameid"+elementCount).change(function(){
		
    	getSubject(this.value,element2.id);
		
	});
    
  

 
document.getElementById("subjectcount").value = elementCount + parseInt(1);



}

function getSubject(clasvalue,subjectID){
	
	$.ajax({
		type : "GET",
		url : "teacherregistration.html?method=getSubject",
		data : {"classidVal":clasvalue},
		async : false,

		success : function(data) {
			var result = $.parseJSON(data);
			
			$("#"+subjectID).append(
					'<option value="'
							+ ""
							+ '">'
							+ "-----select-----"
							+ '</option>');
			
			
			for(var i=0;i<result.subjectList.length;i++){

					$("#"+subjectID).append(
							'<option value="'
						+ result.subjectList[i].subjectid
						+ '">'
						+ result.subjectList[i].subjectname
						+ '</option>');
				
			}
	
		}
	});
	
}

function deleteSubject(){
	
	var checkcount=0;
	
	 $(".teachersubject tr").each(function(){
		 
		 var elementCount = parseInt(document.getElementById("subjectcount").value);
		 
		   var checkboxvalue=$(this).find('.ckeckboxclass').attr("id");
		   
		   
		   if(checkboxvalue!=undefined && checkboxvalue!=""){
			   
			   var count=parseInt(checkboxvalue.substr(12,checkboxvalue.length));
			   
			   if($('#'+checkboxvalue).is(":checked")){
				   
				   checkcount++;
				   
				   if((count+1)==elementCount){
					   
					   $("#"+checkboxvalue).parent().parent().remove();
					   document.getElementById("subjectcount").value = elementCount - parseInt(1);
					   
				   }else{
					   
					   $(".validateTips").text("Delete Class&Subject from last row");
						$(".errormessagediv").show();
				   }
			   }
			   
		   }
			   
		 
	 });
	 
	 if(checkcount==0){
		   
		   
		   $(".validateTips").text("Select record to delete");
			$(".errormessagediv").show();
	   }
	
}

function readURL(input) {

	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#imagePreview').attr('src', e.target.result);
		};

		reader.readAsDataURL(input.files[0]);
	}

}



	