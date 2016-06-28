<!DOCTYPE html>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>

<script src="JS/newUI/jquery.js"></script>
<script src="JS/newUI/bootstrap.min.js"></script>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>

<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery-ui.custom.js"></script>

<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
 -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JS/newUI/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery-ui.custom.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.tooltip.js"></script>
<script type="text/javascript" src="JS/newUI/bootstrap.min.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- <script type="text/javascript" src="JS/backOffice/Admin/Latheef.js"></script>
 -->
<script type="text/javascript"
	src="JS/backOffice/Admin/AddTermDetails.js"></script>

<style>
.glyphicon:hover {
	cursor: pointer;
}

#save:hover {
	cursor: pointer;
}
</style>
</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>Add Term Details</span>
		</p>

		<%-- <logic:present name="successmessagediv" scope="request">
			<div class="successmessagediv" align="center">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span><bean:write
								name="successmessagediv" scope="request" /></span></a>
				</div>
			</div>
		</logic:present> --%>

		<div class="successmessagediv" align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-success bg-msg-succes"><span
					class="validateTips"></span></a>
			</div>
		</div>
		<logic:present name="errormessagediv" scope="request">
			<div class="errormessagediv" style="display: none;">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-warning bg-msg-warning"><span
						class="validateTips"><bean:write name="errormessagediv"
								scope="request" /></span></a>
				</div>
			</div>
		</logic:present>

		<div class="errormessagediv1"
			style="display: none; text-align: center;">
			<div class="message-item1">
				<!-- Warning -->
				<a href="#" class="msg-warning1 bg-msg-warning1"
					style="width: 35%; font-size: 13px; color: red;"><span
					class="validateTips1"></span></a>
			</div>
		</div>




		<form method="post">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-primary">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp;Term
								Details
							</a>
						</h4>

						<div class="navbar-right">


							<span id="save" class="save2"> <img src="images/save.png"
								data-toggle="modal" data-toggle="tooltip"
								data-placement="bottom" title="Save">

							</span> <span id="view" class="glyphicon glyphicon-list2"
								data-toggle="modal" data-toggle="tooltip"
								data-placement="bottom" title="List"></span>

						</div>

						<script>
							$(document).ready(function() {
								$('[data-toggle="tooltip"]').tooltip();
							});
						</script>

					</div>
					<br /> <input type="hidden" id="termmasterid"
						value='<logic:present name="editlist"><bean:write name="editlist" property="termid" /></logic:present>'></input>
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Term
										Name</label>
									<div class="col-xs-7">
										<input type="text" class="form-control" id="termname"
											placeholder=""
											value='<logic:present name="editlist"><bean:write name="editlist" property="termname" /></logic:present>'></input>
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Description</label>
									<div class="col-xs-7">
										<input type="text" class="form-control" id="termdescription"
											placeholder=""
											value='<logic:present name="editlist"><bean:write name="editlist" property="description" /></logic:present>'></input>
									</div>
								</div>
								<br />



								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Is
										Transport</label>

									<div class="col-xs-7" id="radiostyle" style="margin-top: 8px">
										<input type="hidden" id="radio"
											value='<logic:present name="editlist"><bean:write name="editlist" property="transporttype" /></logic:present>'></input>
										<input type="radio" class="istrans" name="trans" id="transIdY"
											value="Y" /><label for="Transport">Yes</label> <input
											type="radio" class="istrans" name="trans" id="transIdN"
											value="N" /><label for="Transport">No </label>
									</div>
								</div>
								<br />


								<div class="col-xs-7">
									<input type="hidden" class="form-control" id="AccStartDate"
										value='<logic:present name="acclist"><bean:write name="acclist" property="acastartdate"/></logic:present>'></input>
								</div>
								<div class="col-xs-7">
									<input type="hidden" class="form-control" id="AccEndDate"
										value='<logic:present name="acclist"><bean:write name="acclist" property="acaenddate"/></logic:present>'></input>
								</div>

								<br /> <br /> <br /> <br />
							</div>

							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Start
										Date</label>
									<div class="col-xs-7">
										<input type="text" readonly="readonly" class="form-control"
											id="startdate" placeholder=""
											value='<logic:present name="editlist"><bean:write name="editlist" property="startdate" /></logic:present>'></input>
									</div>
								</div>

								<br />
								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">End Date</label>
									<div class="col-xs-7">
										<input type="text" readonly="readonly" class="form-control"
											id="enddate" placeholder=""
											value='<logic:present name="editlist"><bean:write name="editlist" property="enddate" /></logic:present>'></input>
									</div>
								</div>
								<br /> <br /> <br /> <br />
							</div>
						</div>
					</div>
				</div>
		</form>
	</div>

</body>

</html>
