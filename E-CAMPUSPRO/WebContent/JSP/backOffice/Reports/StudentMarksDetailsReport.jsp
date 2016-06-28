<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<html lang="en">

<head>

<title>eCampus Pro</title>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />

<link href="CSS/newUI/custome.css" rel="stylesheet">
<script src="JQUERY/kendoJs/kendo.all.min.js"></script>
<script src="JS/backOffice/Reports/StudentMarksDetailsReport.js"></script>

<style>
.modal-body {
	text-align: center;
}


</style>
</head>



<body>


	<div class="col-md-10 newstu">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>Student Marks Details </span>
		</p>

		<center>


			<div class="errormessagediv" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-warning bg-msg-warning"><span
						class="validateTips"></span></a>
				</div>
			</div>



			<div class="successmessagediv" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span
						class="successmessage"></span></a>
				</div>
			</div>
		</center>

		<form action="reportaction.html?method=getStdMarksDetails"
			method="post">
			<p id="parent1" style="display: none;">
				<a href="">Expand all</a>
			</p>
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">

					<div class="panel-heading" role="tab" id="headingOne">

						<h4 class="panel-title" id="beforeparent">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Marks Details
							</a>
						</h4>

						<div class="navbar-right">
						
							<img src="images/rightline.png" style="margin-top: -2px;margin-right: 11px;">
							<img src="images/download.png" class="download" id="iconsimg" style="margin-top:4px"
								data-toggle="modal" data-target="#myModal" data-toggle="tooltip"
								data-placement="bottom" title="Download">

						</div>
						<script>
							$(document).ready(function() {
								$('[data-toggle="tooltip"]').tooltip();
							});
						</script>
					</div>
					<!-- pop up -->

					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Download</h4>
								</div>
								<div class="modal-body">
									<span id="excelDownload"><img src="images/xl.png"
										class="xl"></span>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
										id="pdfDownload"><img src="images/pdf.png" class="pdf"></span>
								</div>

							</div>
						</div>
					</div>

					<!-- Filters -->

					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body" id="tabletxt" style="padding: 15px;">

							<div class="col-md-6" id="txtstyle">

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										id="inputnames">Academic Year</label>
									<div class="col-xs-7">
										<select id="accyear" name="accyear" class="form-control"
											required>
											<option value=""></option>

											<logic:present name="AccYearList">

												<logic:iterate id="AccYear" name="AccYearList">

													<option
														value=" <bean:write name="AccYear" property="accyearId"/>">
														<bean:write name="AccYear" property="accyearname" />
													</option>

												</logic:iterate>

											</logic:present>
										</select>
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										id="inputnames">Section</label>
									<div class="col-xs-7">
										<select id="section" name="section" class="form-control"
											required>
											<option value=""></option>
											
										</select>
									</div>
								</div>
								<br />
									<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										id="inputnames">Exam</label>
									<div class="col-xs-7">
										<select id="exam" name="exam" class="form-control"
											required>
											<option value=""></option>
											<logic:present name="examlist">
											
												<logic:iterate id="exam" name="examlist">
													
													<option value="<bean:write name="exam" property="examid"/>">
														<bean:write name="exam" property="examName" />
													</option>
												
												</logic:iterate>
											
											</logic:present>

										</select>
									</div>
								</div>
								
							
							</div>
							<div class="col-md-6" id="txtstyle">

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										id="inputnames">Class</label>
									<div class="col-xs-7">
										<select id="class" name="classname" class="form-control"
											required>
											<option value=""></option>
											<logic:present name="classList">

												<logic:iterate id="classrec" name="classList">

													<option
														value="<bean:write name="classrec" property="classId"/>">
														<bean:write name="classrec" property="classname" />
													</option>

												</logic:iterate>

											</logic:present>

										</select>
									</div>
								</div>
								<br />
							
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										id="inputnames">Student</label>
									<div class="col-xs-7">
										<select id="student" name="studentId" class="form-control" required>
												<option value=""></option>
											
										</select>
									</div>
								</div>
								<br></br>
									<br></br>
							</div>
							<button type="submit" class="btn btn-info col-md-offset-5"
								id="search" onclick="return validate()">Search</button>
							<!-- data-toggle="modal" data-target="#myModal" -->
							<br />

								
						<div class="col-md-12 selecteditems">
								<br /> 
								
								<input type="hidden" id="haccyear" name="haccyear" value="" />
									
								<input type="hidden" id="hclass" name="hclass" value="" />
									
								<input type="hidden" id="hsection" name="hsection" value="" />
									
								<input type="hidden" id="hexam" name="hexam" value="" />
								
								<input type="hidden" id="hstudent" name="studentnamelabel" value="" />
								
								
								
								
								<logic:present name="reportForm">

								<span><b>Academic Year :</b></span>&nbsp;&nbsp;&nbsp;<span><logic:present name="reportForm">
										<bean:write name="reportForm" property="haccyear" />
										
									</logic:present></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span><b>Class :</b></span>&nbsp;&nbsp;&nbsp;<span><logic:present
										name="reportForm">
										<bean:write name="reportForm" property="hclass"/>
										
									</logic:present></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span><b>Section :</b></span>&nbsp;&nbsp;&nbsp;<span><logic:present
										name="reportForm">
										<bean:write name="reportForm" property="hsection"/>
										
									</logic:present></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span ><b>Student :</b></span>&nbsp;&nbsp;&nbsp;<span id="termname"><logic:present
										name="reportForm">
										<bean:write name="reportForm" property="studentnamelabel"/>
									
									</logic:present></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span ><b>Exam :</b></span>&nbsp;&nbsp;&nbsp;<span><logic:present
										name="reportForm">
										<bean:write name="reportForm" property="hexam"/>
										
									</logic:present></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
									
									<input type="hidden" id="haccyearid"  value="<logic:present name="reportForm"><bean:write name="reportForm" property="accyear"/></logic:present>"/>
									<input type="hidden" id="hclassid" value="<logic:present name="reportForm"><bean:write name="reportForm" property="classname"/></logic:present>"/>
									<input type="hidden" id="hsectionid" value="<logic:present name="reportForm"><bean:write name="reportForm" property="section"/></logic:present>"/>
									<input type="hidden" id="hstudentid" value="<logic:present name="reportForm"><bean:write name="reportForm" property="studentId"/></logic:present>"/>
									<input type="hidden" id="hexamid" value="<logic:present name="reportForm"><bean:write name="reportForm" property="exam"/></logic:present>"/>
									
								</logic:present>
							</div>
							<br />
							
							
		<div id="diaplytable">
				<div class="panel-body"
					style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">

					<logic:present name="marksDetailsReport" scope="request">
					
					<input type="hidden" id="hideenId" value="studentlist" />
					
						<logic:iterate id="calMap" name="marksDetailsReport" scope="request">
							<h3 class="accordHead" id="newstyleforaccordin">
								<span class="glyphicon glyphicon-eject"
									style="transform: rotate(180deg); color: #A1A1A1;margin-top: 5px;"></span>
								<bean:write name="calMap" property="key" />
							</h3>
							<div class="accBody">
								<table class="table" id="allstudent" style="text-align: center;">
									<tr class="headth">
										<th>Sno</th>
										<th>Subject Name</th>
										<th>Max Marks</th>
										<th>Required Marks</th>
										<th>Scored Marks</th>
										<th>(%)</th>
										
									</tr>
									
									
										<logic:iterate name="calMap"  property="value" id="datalist">
											<tr class="accordHead">
											
												<td><bean:write name="datalist" property="sno" /></td>
												<td><bean:write name="datalist" property="subjectname" /></td>
												<td><bean:write name="datalist" property="maxmarks" /></td>
												<td><bean:write name="datalist" property="reqmarks" /></td>
												<td><bean:write name="datalist" property="scoredmarks" /></td>
												<td><bean:write name="datalist" property="markspercent" /></td>
												
											</tr>
										</logic:iterate>
									
								</table>
							</div>
						</logic:iterate>
					</logic:present>
				</div>
				<br />
		</div>
		
		<!-- <div class="col-md-8" align="center">
				<div id="example" class="k-content">
					<div class="chart-wrapper">
						<div class="studentAttendance">
						
						</div>
					</div>
				</div>
			</div> -->
							
					

						</div>
					</div>
				</div>
			</div>
			<!-- Button trigger modal -->

		</form>
	</div>

	<span>&nbsp;</span>


	<!-- jQuery -->
	<script src="js/jquery.js"></script>


	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>


	<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
