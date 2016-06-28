$(document).ready(function() {
	
	
var trans = $('#radio').val();
	
	if (trans == "Male") {
		$("#genderM").attr("checked", true);
	} else if (trans == "Female") {
		$("#genderF").attr("checked", true);
	}
	
	
	
	
	$("#dateofBirthId").datepicker({
		dateFormat : "dd-mm-yy",
		yearRange : 'c-65:c+65',
		maxDate : -1,
		changeMonth : "true",
		changeYear : "true",
		onClose : function(selectedDate) {
			$("#dateofJoinId").datepicker("option", "minDate", selectedDate);
		}
	});
	
	
	
	$("#dateofJoinId").datepicker({
		
		dateFormat : "dd-mm-yy",
		yearRange : 'c-65:c+65',
		maxDate : -1,
		changeMonth : "true",
		changeYear : "true",
		onClose : function(selectedDate) {
			$("#dateofBirthId").datepicker("option", "maxDate", selectedDate);
		}
	});
	
	
	
	$("#dl_issued_date").datepicker(
			{
				dateFormat : "dd-mm-yy",
				yearRange : 'c-65:c+65',
				maxDate : -1,
				changeMonth : "true",
				changeYear : "true",
				yearRange : '1997:' + (new Date).getFullYear(),
				onClose : function(selectedDate) {
					var date2 = $('#dl_issued_date').datepicker(
							'getDate');
					date2.setDate(date2.getDate() + 1);
					$("#dl_validity").datepicker("option",
							"minDate", date2);

				}
			});
	
	
	$("#dl_validity").datepicker(
			{

				dateFormat : "dd-mm-yy",
				yearRange : 'c-65:c+65',
				changeMonth : "true",
				changeYear : "true",
				onClose : function(selectedDate) {

					var date2 = $('#dl_validity').datepicker(
							'getDate');
					date2.setDate(date2.getDate() - 1);
					$("#dl_issued_date").datepicker("option",
							"maxDate", date2);

				}
			});
	
	
	
	
	
	
	
	$("#saveid").click(function(){
		
	
        	var locList = []; 
            $('#licensetodrive :selected').each(function(i, selected){
            
            locList[i] = $(selected).val(); 
           
            });
            
            var drivercode = $('#drivercode').val();
			var name =  $("#name").val();
			var fatherName =  $("#father_name").val();
			var dob =  $("#dateofBirthId").val();
			var gender=$('input[name=gender]:checked').val();
			var mobile = $("#mobile").val();
			var emerg_contact = $("#emerg_contact").val();
			var enq_dateofJoin = $("#dateofJoinId").val();
			var exp = $("#experience").val();
			var address = $("#address").val();
			var drivingLicenseNo = $("#drivingliecenseNo").val();
			var dl_issued_date = $("#dl_issued_date").val();
			var dlValidity = $("#dl_validity").val();
			var age = $("#ageId").val();
			
			
			
			
			if(name==null || name==""){
				
				  $(".errormessagediv").show();
					$(".validateTips").text("Enter Driver Name");
					return false;
				}
			else if(!name.match(/^[a-z]([a-z_ ])+$/i))
			{
				
				 $(".errormessagediv").show();
				$(".validateTips").text("Driver Name Should Be Alphabet");

				return false;
				
			}
			else if(fatherName==null || fatherName==""){
				
				 $(".errormessagediv").show();
			    $(".validateTips").text("Enter Father's Name");
				return false; 
				
			}
			else if(!fatherName.match(/^[a-z]([a-z_ ])+$/i))
			{
				 $(".errormessagediv").show();
				 $(".validateTips").text("Father's Name Should Be Alphabet");
				return false;
			}
			else if(dob==null || dob==""){
				 $(".errormessagediv").show();
				 $(".validateTips").text("Select Date Of Birth");
				return false;
				
			}
			else if(age < 18){
				 $(".errormessagediv").show();
				 $(".validateTips").text("Age Should be 18 or Older");
				return false;
				
			}
			else if(gender==null || gender==""){
				
				 $(".errormessagediv").show();
				 $(".validateTips").text("Select Gender");
				return false;
				
			}

			else if(mobile==null || mobile==""){
				
				 $(".errormessagediv").show();
				 $(".validateTips").text("Enter Mobile No");
				return false;
			}
			else if(!mobile.match(/^([0-9])+$/i)){
				 $(".errormessagediv").show();
				 $(".validateTips").text("Mobile No Should be Numeric");
				return false;
			}
			else if(mobile.length < 10){
				
				 $(".errormessagediv").show();
				 $(".validateTips").text("Enter valid Mobile No");
				return false;
			}


			else if(emerg_contact==null || emerg_contact==""){
				
				 $(".errormessagediv").show();
				 $(".validateTips").text("Enter Emergency Contact No");
				return false;
			}
			else if(emerg_contact.length < 10){
				
				 $(".errormessagediv").show();
				 $(".validateTips").text("Enter valid Emergency Contact No");
				return false;
			}


			else if(enq_dateofJoin==null || enq_dateofJoin==""){
				 $(".errormessagediv").show();
				 $(".validateTips").text("Select Date of Joining");
				return false;
			}
			else if(exp==null || exp==""){
				
				 $(".errormessagediv").show();
				 $(".validateTips").text("Enter Experience");
				return false;
			}

			else if(!exp.match('^[0-9]*\.[0-9]*$')){
				
				 $(".errormessagediv").show();
				 $(".validateTips").text("Experience Sholud be Numeric");
				return false;
			}

			else if(address==null || address==""){
				 $("#validateTable").show();
			    $(".validateTips").text("Enter Address");
				return false;
			}
			
			else if(drivingLicenseNo==null || drivingLicenseNo==""){
				 
				 $(".errormessagediv").show();
					$(".validateTips").text("Enter Driving License No");
					
					return false;
				}
			
			else if(dl_issued_date==null || dl_issued_date==""){
				
				  $(".errormessagediv").show();
					$(".validateTips").text("Select DL Issued Date");
					return false;
				}
			else if(dlValidity==null || dlValidity==""){
				
				  $(".errormessagediv").show();
					$(".validateTips").text("Select DL Validity Upto");
					return false;
				}
			
			else if(locList==null || locList==""){
				
				  $(".errormessagediv").show();
					$(".validateTips").text("Select License To Drive");
					return false;
				}
			else if(validateDriver()== 1){
				 $(".errormessagediv").show();
					$(".validateTips").text(" Driver already exists");
					return false;
			        }
			
			else{
				
			
			datalist = {
				"drivercode" : drivercode,
				 "name" : name,
				 "fatherName" : fatherName,
					"dob" : dob ,
					"gender" : gender ,
					"mobile" : mobile ,
					 "emerg_contact" : emerg_contact,
					"enq_dateofJoin" : enq_dateofJoin,
					"exp" : exp,
					 "address" : address,
				    "drivingLicenseNo" : drivingLicenseNo,
				    "dl_issued_date" :  dl_issued_date,
				     "dlValidity" : dlValidity,
					"age" : age ,
					"license" : locList.join(",")
						
			};
			
			$.ajax({
				type : 'POST',
				url : "driverDetailsPath.html?method=saveDriver",
				data : datalist ,
				async : false,
				success : function(data){
					
					
					var result = $.parseJSON(data);
					
				
					
					if(result.jsonResponse=="Driver Created Successfully")
						{
						
						$(".errormessagediv").hide();
						$(".successmessagediv").show();
						 $(".validateTips").text("Driver Created Successfully");
						 
						 setTimeout(function(){
							 
						 location.reload();
						 
						 },5000);
						
						}
					
					
					 if(result.jsonResponse=="Driver Update Successfully")
					{
					
						$(".errormessagediv").hide();
					    $(".successmessagediv").show();
					    $(".validateTips").text("Driver Update Successfully");
					    
					     setTimeout(function(){
					    	 
					     window.location.href="adminMenu.html?method=driverget";
					     
						 },7000);
						
						}
					    
				/*	    
					 setTimeout(function(){
							
						 location.reload();
					 
					 },3000); */
					    
					
				
					}
					
					
				//}
			
			
			});
			
			}	
			
	
			 setTimeout(function(){
				
				 location.reload();
			 
			 },3000);
			
			
	});
	
	

	
});



function ageCalculateAdd() {
	
	var doofBirth = $('#dateofBirthId').val();

	var birthYear = doofBirth.split("-")[2];

	var currentYear = new Date().getFullYear();

	var yearDiff = parseInt(currentYear) - parseInt(birthYear);

	$('#ageId').val(yearDiff);

}



function validateDriver(){
	
	var driver_validate=0;
	
	var name =  $("#name").val();
	
	var dob =  $("#dateofBirthId").val();
	
	var mobile = $("#mobile").val();
	
	var enq_dateofJoin = $("#dateofJoinId").val();
	
	 var drivercode = $('#drivercode').val();
	 
	 var streamObject = {
				"name" : name,  "dob" : dob,  "mobile" : mobile,"enq_dateofJoin" : enq_dateofJoin ,"drivercode" : drivercode	};
	 
	 $.ajax({

			type : "GET",
			url : 'driverDetailsPath.html?method=validateDriver',
			data : streamObject,
			async : false,
			success : function(data) {
				
				var result = $.parseJSON(data);
				
			
					
			if (result.status=="true") {
				
				driver_validate = 1;
				
				}
				else 
					
				{
					driver_validate = 0;
				}
			
			}
		});
		
		return driver_validate;
	 
	 
}











