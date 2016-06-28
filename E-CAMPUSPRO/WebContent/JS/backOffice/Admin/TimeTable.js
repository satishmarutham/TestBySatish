$(document)
		.ready(
				function() {
					
					
					$("#classname").change(function(){
						
							var viewBy=$("#classname").val().trim();
							
							window.location.href = "adminMenu.html?method=gettimetable&viewBy="+viewBy;
							
						
					});
					
					var hviewBy=$("#hviewBy").val();
					if(hviewBy!=undefined && hviewBy!=''){
						
						  $("#classname option[value=" +hviewBy+ "]").attr('selected', 'true');
					}
					
					
					$("#edit").click(function(){
						
						var count = 0;
						var TimeTableDetails = null;

						$('input[name="selectBox"]:checked')
								.each(function() {
									count = count + 1;
									TimeTableDetails = this.value;
								});

						if (count > 1 || count == 0) {
							
							$('.errormessagediv').show();
							$('.validateTips').text("Select any one record");

						} else {
							
							var viewBy=$("#classname").val().trim();
							
							if(viewBy=="class"){
							
							window.location.href = "TimeTableActionPath.html?method=getTimeTableDetails&TimeTableDetails="
									+ TimeTableDetails;
							}else{
								
								
								
								window.location.href = "TimeTableActionPath.html?method=getTeacherTimeTableDetails&TimeTableDetails="
									+ TimeTableDetails;
							}
						}
						
					});
					
					
					var viewBy=$("hviewBy").val();
					
					if(viewBy=='class'){
					
					$.ajax({
						type : 'POST',
						url : 'teacherregistration.html?method=getSubjects',
						async : false,
						success : function(response) {
							
							var data = $.parseJSON(response);
							
							for (var j = 0; j < data.SubjectList.length; j++) {

								$(".subject")
										.append(
												'<option value="'
														+ data.SubjectList[j].subjectid
														+ '">'
														+ data.SubjectList[j].subjectname
														+ '</option>');

								

							}

						}

					});
					
					}else{
						
						$.ajax({
							type : 'POST',
							url : 'TimeTableActionPath.html?method=getClassSectionList',
							async : false,
							success : function(response) {
								
								var data = $.parseJSON(response);
								
								for (var j = 0; j < data.ClassSectionList.length; j++) {

									$(".subject")
											.append(
													'<option value="'
															+ data.ClassSectionList[j].classid
															+ '">'
															+ data.ClassSectionList[j].classname
															+ '</option>');

									

								}

							}

						});
						
						}
					
					
					$('#UpdateTimeTable')
					.click(
							function() {

								var dayidArray = [];
								var period1Array = [];
								var period2Array = [];
								var period3Array = [];
								var period4Array = [];
								var period5Array = [];
								var period6Array = [];
								var period7Array = [];
								var period8Array = [];

								$('table#allstudent tr:gt(0)').each(
										function() {
											
											
											var day = $(this).find('[name=dayid]')
													.val().trim();
											var period1 = $(this).find(
													'[name=period1]')
													.val().trim();
											var period2 = $(this).find(
													'[name=period2]')
													.val().trim();
											var period3 = $(this).find(
													'[name=period3]')
													.val().trim();
											var period4 = $(this).find(
													'[name=period4]')
													.val().trim();
											var period5 = $(this).find(
													'[name=period5]')
													.val().trim();
											var period6 = $(this).find(
													'[name=period6]')
													.val().trim();
											var period7 = $(this).find(
													'[name=period7]')
													.val().trim();
											var period8 = $(this).find(
													'[name=period8]')
													.val().trim();

											if (day == '') {
												dayidArray.push('-');
											} else {
												dayidArray.push(day);
											}

											if (period1 == '') {
												period1Array.push('-');
											} else {
												period1Array
														.push(period1);
											}

											if (period2 == '') {
												period2Array.push('-');
											} else {
												period2Array
														.push(period2);
											}

											if (period3 == '') {
												period3Array.push('-');
											} else {
												period3Array
														.push(period3);
											}

											if (period4 == '') {
												period4Array.push('-');
											} else {
												period4Array
														.push(period4);
											}

											if (period5 == '') {
												period5Array.push('-');
											} else {
												period5Array
														.push(period5);
											}

											if (period6 == '') {
												period6Array.push('-');
											} else {
												period6Array
														.push(period6);
											}

											if (period7 == '') {
												period7Array.push('-');
											} else {
												period7Array
														.push(period7);
											}

											if (period8 == '') {
												period8Array.push('-');
											} else {
												period8Array
														.push(period8);
											}
										});
								var ClassId = $("#hiddenClass").val();
								var SectionId= $("#hiddenSection").val();
								var timetableID=$("#hiddenId").val();
								var viewBy=$("hviewBy").val();
								
								var className=$("#classid").val().trim();
								
								var answer = confirm("Are you sure to Save TimeTable Details for "
										+ className + " ?");
								if (answer) {
									var jsonObject = {
										'period1Array' : period1Array
												.join(","),
										'period2Array' : period2Array
												.join(","),

										'period3Array' : period3Array
												.join(","),
										'period4Array' : period4Array
												.join(","),
										'period5Array' : period5Array
												.join(","),

										'period6Array' : period6Array
												.join(","),
										'period7Array' : period7Array
												.join(","),
										'period8Array' : period8Array
												.join(","),

										'timetableID' : timetableID,
										'ClassId' : ClassId,
										'SectionId' : SectionId,
										'viewBy' : viewBy,
										
										'dayidArray' : dayidArray.join(",")
									};
									
									
									var urlpath='';
									
									if(viewBy=='class'){
										
										urlpath='TimeTableActionPath.html?method=updateTimeTableDetails';
										
									}else{
										
										 urlpath='TimeTableActionPath.html?method=updateTeacherTimeTableDetails';
									}
									
									$
											.ajax({
												method : 'POST',
												url : urlpath,
												data : jsonObject,
												async : false,
												success : function(data) {
													var result = $.parseJSON(data);
													
													if (result.timetable_Result == "success") {
														
														$('.successmessagediv').show();
														$('.successmessage').text("TimeTable Details Saved Succesfully");
														
														setInterval(
																function() {
																	
																	window.location.href = "adminMenu.html?method=gettimetable&viewBy="+viewBy;	
																	
																}, 3000);
													} else {
														
														$('.successmessagediv').show();
														$('.successmessage').text("TimeTable Details not Saved, Please try again");
													}	
												}
											});
								}

							});
					
					
					
					
					
					
					
					
					$("#xls").click(function(){
						
						
						var viewBy=$("#classname").val().trim();
						
						if(viewBy=="class")
						{
						
							
							
                        var viewBy=$("#classname").val().trim();
							
							
						window.location.href = "TimeTableActionPath.html?method=classTimeTableDownloadXLS&viewBy="+viewBy;
						
						}
						
						else{
							
							
							 var viewBy=$("#classname").val().trim();
							 
							
							 
							window.location.href = "TimeTableActionPath.html?method=teacherTimeTableDownloadXLS&viewBy="+viewBy;
						}
						
						
					});
					
					
					
					
					
					
					$("#pdfDownload").click(function(){
						
						
						

						var viewBy=$("#classname").val().trim();
						
						if(viewBy=="class")
						{
						
							
							
                        var viewBy=$("#classname").val().trim();
							
							
						window.location.href = "TimeTableActionPath.html?method=classTimeTableDownloadPDF&viewBy="+viewBy;
						
						}
						
						else{
							
							
							 var viewBy=$("#classname").val().trim();
							 
							
							 
							window.location.href = "TimeTableActionPath.html?method=teacherTimeTableDownloadPDF&viewBy="+viewBy;
						}
						
						
						
					});
					
						
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				});









