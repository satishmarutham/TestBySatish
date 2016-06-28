$(document)
		.ready(
				function() {
					
					
					$('.errormessagediv').hide();

					$('#save').click(
							function() {
								
								document.getElementById("rolename").style.border = "1px solid #ccc";
								
								var role_Code = $("#rolecode").val();
								
								var rolename = $("#rolename").val();
								var roleDescription = $("#description").val();
									
							
								if (role_Code=="") {
									
									
									if(rolename==""){
										
										$('.errormessagediv').show();
										$('.validateTips').text("Enter Role Name");
										
										$("#rolename").focus();
										document.getElementById("rolename").style.border = "1px solid #ff0000";
										
									}else if(rolename.match(/^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$/i)==null){
										
										$('.errormessagediv').show();
										$('.validateTips').text("Role name should be only alphanumeric");
										
									}
									
									else if(validateRoleName()==1){
										
										$('.errormessagediv').show();
										$('.validateTips').text("Role Already Exist");
									}
									else{
									
									var datalist={
											"roleCode" : role_Code,
											"roleName": rolename,
											"roleDescription": roleDescription
											
									};
									
									
									$.ajax({
										type : "GET",
										url : "role.html?parameter=Add",
										data :datalist,
										async : false,
										success : function(data) {
											var result = $.parseJSON(data);
											
											$('.errormessagediv').hide();
											
											$('.successmessagediv').show();
											$('.successmessage').text(result.status);
											
											
											 setTimeout(function(){
												   
												 location.reload();
											 
											 },3000);
										
										}
									});
								}
									
								}else{
									
									if(rolename==""){
										
										$('.errormessagediv').show();
										$('.validateTips').text("Enter Role Name");
										
									}else if(validateRoleNameUpdate()==1){
										
										$('.errormessagediv').show();
										$('.validateTips').text("Role already exist");
									
									}else{
									
									var datalist={
											"roleCode" : role_Code,
											"roleName": rolename,
											"roleDescription": roleDescription
											
									};
											
										$.ajax({
												type : "GET",
												url : "role.html?parameter=Update",
												data :datalist,
												async : false,
												success : function(data) {
													var result = $.parseJSON(data);
													
													$("#rolename").val("");
													$("#description").val("");
													
													$('.errormessagediv').hide();
													
													$('.successmessagediv').show();
													$('.successmessage').text(result.status);
												
												}
											});
										
										
										 setTimeout(function(){
											 
											 window.location.href="adminMenu.html?method=roleList";
											
										 
										 },3000);
									
								}
								}
					
				});
					
					
							
				$('#edit').click(function() {
					
							
						var count = 0;
						var role_Code = null;

						$('input[name="rolename"]:checked').each(function() {
							count = count + 1;
							role_Code = this.id;
						});
						

						if (count > 1 || count == 0) {
							
							$('.errormessagediv').show();
							$('.validateTips').text("Select Any Role");

						} else {
							
							window.location.href="role.html?parameter=editRole&ROleCode="+role_Code;
							
							
						}

								
							});
				
				$('#delete').click(function() {
					
					var count = 0;
					var role_Code = null;

					$('input[name="rolename"]:checked').each(function() {
						count = count + 1;
						role_Code = this.id;

					});

					if (count == 0 || count>1) {
						$('.errormessagediv').show();
						$('.validateTips').text("Select Any Role");

					} else {

						var x = confirm("Are you sure to Delete Role");
						if (x) {

							var role = {
								"role_Code" : role_Code
							};
							$
									.ajax({
										type : "GET",
										url : "role.html?parameter=deleteRole",
										data : role,
										async : false,

										success : function(data) {
											var result = $.parseJSON(data);
											
											$('.errormessagediv').hide();
											
											if(result.status=="Role Deleted SuccessFully"){
												
											$(".successmessagediv").show();
											$(".successmessage").text(result.status);
											
											}else{
												
												$('.errormessagediv').show();
												$('.validateTips').text(result.status);
												
											}
											
											
											 setTimeout(function(){
												   
												 location.reload();
											 
											 },3000);
											
										
										}

									});


						}

					}

					
				});
				
				
				
				$("#search").click(function(){
					
					var searchTerm=$("#searchterm").val().trim();
					
					if(searchTerm==""){
					
						$('.errormessagediv').show();
						$('.validateTips').text("Enter search term");
					
					}else{
						
						window.location.href="adminMenu.html?method=roleList&searchTerm="+searchTerm;	
						
					}
					
					
				});
				
				
				$("#clear").click(function(){
					
					window.location.href="role.html?parameter=getRoleEntry";
					
				});
				
				$('#excelDownload')
				.click(
						function() {
							
							
							var searchTerm = $("#searchexamid").val().trim();
							
						
							
							window.location.href = 'role.html?parameter=downloadRoleDetailsXLS&searchTerm='+ searchTerm;
							
						});

				$("#pdfDownload").click(function(){
					
					var searchTerm = $("#searchexamid").val().trim();
					
					window.location.href = "role.html?parameter=RoleDetailsPDFReport&searchTerm="+ searchTerm;
						
				});	
			
				});



function validateRoleNameUpdate() {

	var roleName_validate_update=0;
	var roleName = $('#rolename').val();
	var roleid = $("#rolecode").val();

	var roleObject = {
		"roleName" : roleName,
		"roleid" : roleid
	};

	$.ajax({

		type : "GET",
		url : "role.html?parameter=validateRoleNameUpdate",
		data : roleObject,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			
			if (result) {
				$('.errormessagediv').show();
				$('.validateTips').text("Role Name Already Exists");
				roleName_validate_update = 1;

			} else {
				roleName_validate_update = 0;
			}

		}

	});

	return roleName_validate_update;

}

function validateRoleName() {
	var roleName_validate=0;
	var roleName = $('#rolename').val();
	var roleObject = {
		"roleName" : roleName
	};

	$.ajax({

		type : "GET",
		url : "role.html?parameter=validateRoleName",
		data : roleObject,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result) {

				$('.errormessagediv').show();
				$('.validateTips').text("Role name already exist");
				
				roleName_validate = 1;

			} else {
				roleName_validate = 0;
			}

		}

	});


	return roleName_validate;
}

