<!DOCTYPE html>
<html lang="en">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery-ui.custom.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.tooltip.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/timepicker.js"></script>
<script type="text/javascript"
	src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>

<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet" />
<link href="CSS/newUI/modern-business.css" rel="stylesheet" />
<link href="CSS/newUI/custome.css" rel="stylesheet" />
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="JS/backOffice/Admin/TimeTable.js"></script>

<style >

.subject{

width: 150px !important;
height: 30px !important;

}
#allstudent th {
    color: #767676 !important;
}

#allstudent td {
    color: #767676 !important;
}

.days{

	background: #f9f9f9 !important;
    border-bottom: 1px solid #ddd;
    border-top: 1px solid #ddd;
    font-family: Roboto Medium !important;
    font-size: 11pt !important;
    color: #767676 !important;


}

</style>
</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<!-- <p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>Syllabus Details</span>
		</p> -->

		<div class="col-md-7" id="div2">

			<p style="margin: 16px 0px;">
				<img src="images/addstu.png" />&nbsp;<span>Time Table</span>
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
									<a href="#" class="msg-success bg-msg-succes"><span class="successmessage"></span></a>
								</div>
						</div>
			</center>
		</div>
		
		
		<div class="input-group col-md-5">
			
			<label  class="hedderstyle form-control" style="margin: 20px 0px; width: 27% !important; border: none;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;margin-left: 43% !important">Teacher Name</label> 
			
			
			<input type="text" name="emppfno" readonly="readonly" style="width: 30%; margin: 20px 0px; margin-left: 0%;"
											id="classid" maxlength="25" class="form-control" 
											value="<logic:present name="selected_teacherName"><bean:write name="selected_teacherName"/></logic:present>" />
			
			<input type="hidden" id="hiddenClass" value="<logic:present name="selected_teacherid"><bean:write name="selected_teacherid"/></logic:present>"/>
			
			<input type="hidden" id="hviewBy" value="teacher"/>
		
		</div>
		
		<!-- <form method="post"> -->
		<div class="col-md-12" style="padding:0;">
		<div class="panel panel-primary">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title" style="color: #767676;">
						<span class="glyphicon glyphicon-menu-hamburger"></span>&nbsp;&nbsp;Teacher Time Table
						
					</h4>
						<div class="navbar-right" >

							<span  id="UpdateTimeTable" class="save2"><img src="images/save.png"></span>

							<a href="adminMenu.html?method=gettimetable"><span class="glyphicon glyphicon-list2"></span></a>
						</div>
					
				</div><br/>


				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">


					<div id="scrolid" style="padding: 0; overflow: scroll;">
						
						
						<logic:present name="teacherTimeTableDetails" scope="request">
						<display:table id="allstudent" name="teacherTimeTableDetails" class="table"
							
							decorator="com.centris.campus.decorator.TimeTableDecorator"
							export="false">

							<display:column property="dayid" title="Day" class="hidden"
								headerClass="hidden" />
								
							<display:column property="dayname" title="Day" />
							<display:column property="period1" title="Period 1" />
							<display:column property="period2" title="Period 2" />
							<display:column property="period3" title="Period 3" />
							<display:column property="period4" title="Period 4" />
							<display:column property="period5" title="Period 5" />
							<display:column property="period6" title="Period 6" />
							<display:column property="period7" title="Period 7" />
							<display:column property="period8" title="Period 8" />

						</display:table>
					
					</logic:present>
						
				</div>
				</div>
			</div>
			</div>
		</div>

		<!-- </form>  -->
</body>

</html>
