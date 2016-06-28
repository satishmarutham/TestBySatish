function removeMessage() {

	$(".successmessagediv").hide();
	$(".successmessagediv").hide();

}

$(document)
		.ready(
				function() {

					setTimeout("removeMessage()", 3000);
					setInterval(function() {
						$(".errormessagediv").hide();
					}, 3000);

					var hpaymenttype = $("#hpaymenttype").val();

					if (hpaymenttype != "" && hpaymenttype != undefined) {

						$(
								"#paymenttype option[value="
										+ hpaymenttype.trim() + "]").attr(
								'selected', 'true');
					}

					var hbankname = $("#hbankname").val();

					if (hbankname != "" && hbankname != undefined) {

						$("#bankid option[value=" + hbankname.trim() + "]")
								.attr('selected', 'true');
					}

					$("#searchbtn")
							.click(
									function() {

										var searhname = $("#searchname").val();

										window.location.href = "adminMenu.html?method=staffEmployementList&searhname="
												+ searhname;

									});

					$('#editTeacher')
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

											window.location.href = "staffemployement.html?method=getStaffEmployementEntry&teachercode="
													+ getData[0];

										}
									});

					$("#submit").click(function() {


						if (validation()) {

							document.getElementById("teacherform").submit();

						}

					});

					$('#excelDownload')
							.click(
									function() {

										window.location.href = 'staffemployement.html?method=downloadStaffEmploymentDetailsXLS';

									});
					$("#pdfDownload")
							.click(
									function() {

										window.location.href = "staffemployement.html?method=downloadStaffEmploymentDetailsPDF";

									});

				});

function salarycalculations()

{


	var re_for_double = '^[0-9]*\.[0-9]*$';
	var int_regex = /^\d+$/;

	var basic = $("#basic").val().trim();
	var hrapercentag = $("#hrapercentag").val().trim();
	var otherallowance = $("#others").val().trim();
	var perfincentive = $("#perfincentive").val().trim();
	var specialallowance = $("#specialallowance").val().trim();
	/*
	 * var shiftallowance = $("#shiftallowance").val().trim();
	 */var foodallowance = $("#foodallowance").val().trim();
	var washingallowance = $("#washingallowance").val().trim();
	var ca = $("#ca").val().trim();
	var medicalallowances = $("#medicalallowances").val().trim();
	var telephonereim = $("#telephonereim").val().trim();

	var standarddedu = $("#standarddedu").val();

	if (basic == "") {

		$(".errormessagediv").show();
		$(".validateTips").text("Basic & DA should not be Empty");

		return false;

	}

	else if (hrapercentag == "") {

		$(".errormessagediv").show();
		$(".validateTips").text("HRA(%) should not be Empty");

		return false;

	} else if (ca != ""
			&& (!((int_regex.test(ca)) || (ca.match(re_for_double))))) {

		$(".errormessagediv").show();
		$(".validateTips").text("Enter valid CA");

		return false;

	} else if (medicalallowances != ""
			&& (!((int_regex.test(medicalallowances)) || (medicalallowances
					.match(re_for_double))))) {

		$(".errormessagediv").show();
		$(".validateTips").text("Enter valid Medical Allowance");

		return false;

	} else if (telephonereim != ""
			&& (!((int_regex.test(telephonereim)) || (telephonereim
					.match(re_for_double))))) {

		$(".errormessagediv").show();
		$(".validateTips").text("Enter valid Telephone Allowance");

		return false;

	} else {

		var basicsalary = {
			"foodallowance" : foodallowance,
			"washingallowance" : washingallowance,
			"basic" : basic,
			"hrapercentag" : hrapercentag,
			"otherallowance" : otherallowance,
			"perfincentive" : perfincentive,
			"specialallowance" : specialallowance,
			"standardded" : standarddedu,
			"ca" : ca,
			"medicalallowances" : medicalallowances,
			"telephonereim" : telephonereim
		};

		$.ajax({

			type : "GET",
			url : "staffemployement.html?method=calculateEmpSalaryDetails",
			data : basicsalary,
			async : false,

			success : function(data) {
				var result = $.parseJSON(data);

				$("#hra").val(result.employeesalarydetails[0].hra);
				$("#ca").val(result.employeesalarydetails[0].ca);
				$("#medicalallowances").val(
						result.employeesalarydetails[0].medicalallowances);
				$("#others").val(result.employeesalarydetails[0].others);
				$("#employerpf")
						.val(result.employeesalarydetails[0].employerpf);
				$("#employerESI").val(
						result.employeesalarydetails[0].employerESI);
				$("#grosssalary").val(
						result.employeesalarydetails[0].grosssalary);
				$("#ctc").val(result.employeesalarydetails[0].ctc);
				$("#demployerpf").val(
						result.employeesalarydetails[0].employerpf);
				$("#employeepf")
						.val(result.employeesalarydetails[0].employeepf);
				$("#incometax").val(result.employeesalarydetails[0].incometax);
				$("#pt").val(result.employeesalarydetails[0].pt);
				$("#employeeESI").val(
						result.employeesalarydetails[0].employeeESI);
				$("#demployerESI").val(
						result.employeesalarydetails[0].employerESI);

				$("#telephonereim").val(
						result.employeesalarydetails[0].telephonereim);

				$("#tdsctc").val(result.employeesalarydetails[0].tdsctc);
				$("#taxbleincomestatury").val(
						result.employeesalarydetails[0].taxbleincomestatury);
				$("#tdspt").val(result.employeesalarydetails[0].tdspt);
				$("#taxpayble").val(result.employeesalarydetails[0].taxpayble);
				$("#standarddedu").val(
						result.employeesalarydetails[0].standarddedu);
				$("#tdspf").val(result.employeesalarydetails[0].tdspf);
				$("#taxableincome").val(
						result.employeesalarydetails[0].taxableincome);

			}
		});

	}

}

function checkEmplPfNO() {
	

	var pfstatus = false;

	var employeepfno = $('#employeepfno').val();
	var empid = $('#hemloyeeid').val();

		var pfnumber = {
			"employeepfno" : employeepfno,
			"empid" : empid
		};

		$.ajax({
			type : "GET",
			url : "staffemployement.html?method=validateEmployeePfNumber",
			data : pfnumber,
			async : false,

			success : function(data) {
				var result = $.parseJSON(data);

				pfstatus = result.status;

			}
		});

	

	return pfstatus;

}

function checkBankAccNo() {

	var bankstatus = false;

	var bankaccnumber = $("#bankaccnumber").val().trim();
	var empid = $('#hemloyeeid').val();

	var accountnumber = {
		"bankaccnumber" : bankaccnumber,
		"empid" : empid
	};

	$.ajax({
		type : "GET",
		url : "staffemployement.html?method=validateBankAccNumber",
		data : accountnumber,
		async : false,

		success : function(data) {
			var result = $.parseJSON(data);

			bankstatus = result.status;

		}
	});

	return bankstatus;

}

function validation() {


	$(".errormessagediv").hide();

	var re_for_double = '^[0-9]*\.[0-9]*$';
	var int_regex = /^\d+$/;

	
	var bankaccnumber = $("#bankaccnumber").val();
	
	var employeepfno = $("#employeepfno").val();
	var bankname = $("#bankid").val();
	
	var ifsccode = $("#IFSCCode").val();
	
	
	var paymenttype = $("#paymenttype").val();
	var basic = $("#basic").val();
	var ca = $("#ca").val().trim();
	var hrapercentag = $("#hrapercentag").val();
	var hra = $("#hra").val();
	var medicalallowances = $("#medicalallowances").val();
	var others = $("#others").val();
	var employerpf = $("#employerpf").val();
	var employerESI = $("#employerESI").val();
	var grosssalary = $("#grosssalary").val();
	var ctc = $("#ctc").val();
	var demployerpf = $("#demployerpf").val();
	var employeepf = $("#employeepf").val();
	var incometax = $("#incometax").val();
	var pt = $("#pt").val();
	var demployerESI = $("#demployerESI").val();
	var employeeESI = $("#employeeESI").val();

		    if(bankaccnumber==null || bankaccnumber==""||bankaccnumber==0){
				$(".errormessagediv").show();
				$(".validateTips").text("Account  number should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else if(!(int_regex.test(bankaccnumber))){
				$(".errormessagediv").show();
				$(".validateTips").text("Account  number should be Numbers");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}
		    
 
 
 
		    if(employeepfno==null || employeepfno==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Employee pf no should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}
 
           if(bankname==null || bankname==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Bank Name should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}
		    
           
           
           if(ifsccode==null || ifsccode==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("IFSC Code should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}
		    
        
        if(paymenttype==null || paymenttype==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Payment Type should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}
        
        
        
        if(basic==0.0 || basic=="0.0"){
			
				$(".errormessagediv").show();
				$(".validateTips").text("Basic&Da should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
			
			}else if(!((int_regex.test(basic)) || (basic.match(re_for_double)))){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Basic&Da");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
		
			}else{
		 		$(".errormessagediv").hide();
		    
			} 
	   
	 
        
        if(ca==null || ca==""){
    		
				$(".errormessagediv").show();
				$(".validateTips").text("Ca should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
		
			}else  if(!((int_regex.test(ca)) || (ca.match(re_for_double)))){
		
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Ca ");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			} 
        
        
        
        if(hrapercentag==0 || hrapercentag=="0"){
       		
				$(".errormessagediv").show();
				$(".validateTips").text("Hra(%) should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
		
			}else{
		 		$(".errormessagediv").hide();
		    
			} 
		   
        
        
        if(hra==null || hra==""){
    		
				$(".errormessagediv").show();
				$(".validateTips").text("Hra should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
		
			}else if(!((int_regex.test(hra)) || (hra.match(re_for_double)))){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Hra ");
				$("#hra").css({'backgroundColor' : '#FFF7F7','border-color':'#B70606'});
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
		
				
			}else{
		 		$(".errormessagediv").hide();
		    
			} 
		   
		  
        if(medicalallowances==null || medicalallowances==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Medicalallowances should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else   if(!((int_regex.test(medicalallowances)) || (medicalallowances.match(re_for_double)))){
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Medicalallowances ");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}


        if(others==null || others==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Other Allowance should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else  if(!((int_regex.test(others)) || (others.match(re_for_double)))){
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Other Allowance ");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}
        
        
        
        if(employerpf==null || employerpf==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Employer PF  should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else  if(!((int_regex.test(employerpf)) || (employerpf.match(re_for_double)))){
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Employer PF ");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		  		$("#employerpf").css({'backgroundColor' : 'transparent','border':'1px solid #ccc'});
		    
			}
        
     
        
       /* if(employerESI==null || employerESI==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Employer ESI  should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else  if(!((int_regex.test(employerESI)) || (employerESI.match(re_for_double)))){
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Employer ESI ");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}*/
        
        
        
        
        if(grosssalary==null || grosssalary==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Gross Salary should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
		
			}else if(!((int_regex.test(grosssalary)) || (grosssalary.match(re_for_double)))){
		
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Gross Salary ");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			} 
		   
		   
 
		    if(ctc==null || ctc==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Ctc should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else  if(!((int_regex.test(ctc)) || (ctc.match(re_for_double)))){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Ctc");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			} 
		    
		    
		   if(demployerpf==null || demployerpf==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Employer PF should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else if(!((int_regex.test(demployerpf)) || (demployerpf.match(re_for_double)))){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Employer PF ");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}
		 
		 
			 if(employeepf==null || employeepf==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Employee PF should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else  if(!((int_regex.test(employeepf)) || (employeepf.match(re_for_double)))){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Employee PF ");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}
			 
			 if(incometax==null || incometax==""){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Incometax should not Empty");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else  if(!((int_regex.test(incometax)) || (incometax.match(re_for_double)))){
				
				$(".errormessagediv").show();
				$(".validateTips").text("Enter valid Incometax ");
				setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
				return false;
				
			}else{
		 		$(".errormessagediv").hide();
		    
			}
			  
			  
			  if(pt==null || pt==""){
					
					$(".errormessagediv").show();
					$(".validateTips").text("Pt should not Empty");
					setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
					return false;
					
				}else if(!((int_regex.test(pt)) || (pt.match(re_for_double)))){
					
					$(".errormessagediv").show();
					$(".validateTips").text("Enter valid PT ");
					setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
					return false;
					
				}else{
			 		$(".errormessagediv").hide();
			    
				}
			  
			  
			  /*if(demployerESI==null || demployerESI==""){
					
					$(".errormessagediv").show();
					$(".validateTips").text("Employer ESI should not Empty");
					setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
					return false;
					
				}else if(!((int_regex.test(demployerESI)) || (demployerESI.match(re_for_double)))){
					
					$(".errormessagediv").show();
					$(".validateTips").text("Enter valid Employer ESI ");
					setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
					return false;
					
				}else{
			 		$(".errormessagediv").hide();
			    
				}*/
	  
			  
			  
			  
			  if(employeeESI==null || employeeESI==""){
					
					$(".errormessagediv").show();
					$(".validateTips").text("Employee ESI should not Empty");
					setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
					return false;
					
				}else if(!((int_regex.test(employeeESI)) || (employeeESI.match(re_for_double)))){
					
					$(".errormessagediv").show();
					$(".validateTips").text("Enter valid Employee ESI ");
					setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
					return false;
					
				}else{
			 		$(".errormessagediv").hide();
				    
					if(checkEmplPfNO()){
						
						$(".errormessagediv").show();
						$(".validateTips").text("Employee PF No already Exist");
						setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
						return false;
						
						
					}else if(checkBankAccNo()){
						
						
						$(".errormessagediv").show();
						$(".validateTips").text("Account Number already Exist");
						setTimeout(function() {$('.errormessagediv').fadeOut();}, 3000);
						return false;
						
					}else{
						$(".errormessagediv").hide();
							return true;
						
					}
					
	
		     }

}
