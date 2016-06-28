$(document).ready(function()

{

	$(".errormessagediv").hide();
	$("successmessagediv").hide();
	
	$('#saveid').click(function() {

		var depname = $("#departmentid").val().trim();
		var descname = $("#descriptionid").val().trim();

		var department_code = $("#updatedepartmentid").val();

		if (depname == "" || depname == null) {
			$(".errormessagediv").show();
			$(".validateTips").text("Enter Department");
			return false;

		} 
		else if(!depname.match(/[A-Za-z]+$/i)) {
			
			$('.errormessagediv').show();
			$('.validateTips').text("Department Name should be characters");
			return false;
			
		}
		else if (validateDeptName() == 1) {

			$('.errormessagediv').show();
			$('.validateTips').text("Department Name already Exist");
			return false;
		}
		else if (validateDeptNameUpdate() == 1) {

			$('.errormessagediv').show();
			$('.validateTips').text("Department Name already Exist");
			return false;
		}

		else {

			datalist = {
				"departmname" : depname,
				"description" : descname,
				"update_dept" : department_code
			},

			$.ajax({

				type : "POST",

				url : "departmentMenu.html?method=addDepartment",

				data : datalist,

				async : false,
				
				success : function(data) {

					var result = $.parseJSON(data);

					$('.errormessagediv').hide();
					$(".successmessagediv").show();
					$(".successmessage").text(result.status);

					setTimeout(function() {

						location.reload();

					}, 1000);
				}

			});
			return false;
			
		}

	});

});

function validateDeptName() {

	var deptname = $('#departmentid').val();
	var deptid = $('#updatedepartmentid').val();

	var deptname_object = {
		"deptname" : deptname,
		"deptid" : deptid
	};

	$.ajax({

		type : "GET",
		url : "departmentMenu.html?method=validatedepartmentname",
		data : deptname_object,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);

			if (result) {
				$(".errormessagediv1").show();
				$(".validateTips1").text("Department Already Exist");
				desname_validate = 1;

			} else {
				desname_validate = 0;
			}

		}

	});

	return desname_validate;

}

function validateDeptNameUpdate() {

	var DeptName_validate_update = 0;

	var deptname = $('#departmentid').val();
	var deptid = $('#updatedepartmentid').val();

	var deptObject = {
		"deptname" : deptname,
		"deptid" : deptid
	};

	$.ajax({

		type : "GET",
		url : "departmentMenu.html?method=validateDeptNameUpdate",
		data : deptObject,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);

			if (result) {
				$('.errormessagediv').show();
				$('.validateTips').text("Dept Name Already Exists");
				DeptName_validate_update = 1;

			} else {
				DeptName_validate_update = 0;
			}

		}

	});

	return DeptName_validate_update;

}
