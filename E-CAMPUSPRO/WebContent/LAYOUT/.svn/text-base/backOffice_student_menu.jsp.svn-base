<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<link href="CSS/newUI/custome.css" rel="stylesheet">
<title>eCampus Pro</title>
<body>
	<div class="col-md-2 leftmenu"
		style="padding: 0; background-color: #f5f2f2;">

		<div class="panel panel-primary"
			style="border: none; background-color: transparent; margin: 1px 0px; box-shadow: none;">
			<div class="panel-heading" style="background-color: #07AAB9;">
				<a data-toggle="collapse" data-parent="#accordion2"
					href="#menucollapseOne" style="color: #fff;"><h3
						class="panel-title active">
						Student Management<i class="glyphicon glyphicon-triangle-bottom"
							style="float: right;"></i>
					</h3></a>
			</div>
			<div id="menucollapseOne" class="accordion-body collapse in">
				<div class="panel-body">
					<ul class="nav nav-pills nav-stacked">




						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="adminMenu.html?method=studentList">Student
												Details</a></li>
									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>


						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUENQDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="adminMenu.html?method=studentEnquiryList">Student
												Enquiry</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUPROMDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="adminMenu.html?method=studentPromotionList">Student
												Promotion</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUATTDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a
											href="teachermenuaction.html?method=attendaceStatus">Student
												Attendance</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="UPASSDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a
											href="teachermenuaction.html?method=assignmentView">Upload
												Assignment</a></li>
									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUMRKDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="teachermenuaction.html?method=marksStatus">Student
												Marks</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>


						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUMRKDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a
											href="teachermenuaction.html?method=viewMeetingdandEvents">Meetings&Events</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>




						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUMRKDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a
											href="teachermenuaction.html?method=circularRemainder">Circular&Remainder</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>













						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUINFDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="parentMenu.html?method=studentinformation">Student
												Information</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUATTDTSDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="parentMenu.html?method=attendancedetails">Attendance
												Details</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUASSDTSDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="parentMenu.html?method=assignmentdetails">Assignment
												Details</a></li>
									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="SYBDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="parentMenu.html?method=syllabusdetails">Syllabus
												Details</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="FEBDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="parentMenu.html?method=sendfeedback">Send
												FeedBack</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>





						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="FEBDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a
											href="parentMenu.html?method=meetingandeventsdetails">Meetings&Events</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>


						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="FEBDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="parentMenu.html?method=studentTimeTable">Student
												TimeTable</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>





						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="FEBDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a
											href="parentMenu.html?method=circularRemainderParentAction">Circular&Remainder</a></li>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>




						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="STUDIS" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<li><a href="adminMenu.html?method=studentfileupload">Student
												Excel File Upload</a></li>
									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>







						<!-- <li><a href="parentMenu.html?method=meetingandeventsdetails">Meetings&Events</a></li> 
													<li><a href="parentMenu.html?method=studentTimeTable">Student TimeTable</a></li> -->


					</ul>

				</div>
				<br />
			</div>
		</div>


	</div>
</body>
</html>
