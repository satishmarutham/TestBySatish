<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css" />
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JS/backOffice/Teacher/LeaveApproval.js"></script>

<style>
.save:hover {
	cursor: pointer;
}
</style>

<style>
#list:hover {
	cursor: pointer;
}
</style>


</head>

<body>

	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span>APPROVE LEAVE </span>
		</p>

		<div class="successmessagediv" align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-success bg-msg-succes"><span
					class="successmessage"></span></a>
			</div>
		</div>

		<div class="errormessagediv1" align="center" style="display: none;">
			<div class="message-item1">
				<!-- Warning -->
				<a href="#" class="msg-warning1 bg-msg-warning1" style="width: 30%;"><span
					class="validateTips1"></span></a>
			</div>
		</div>
		<input type="hidden" name="attnhidden" id="snoid"
			value="<logic:present name="attnhidden" ><bean:write name="attnhidden"/></logic:present>" />
		<input type="hidden" name="leavetype" id="leavetype"
			value="<logic:present name="leaveapprovelist" ><bean:write name="leaveapprovelist" property="leavetype"/></logic:present>" />


		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" style="color: #767676"> <i
							class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp;Leave
							Details
						</a>
					</h4>

					<div class="navbar-right">

						<span id="submit" class="save2"> <img src="images/save.png"
							data-toggle="tooltip" data-placement="bottom" title="Save">
						</span> <a href="teachermenuaction.html?method=leaveApproval"> <span
							class="glyphicon glyphicon-list2"></span>

						</a>
					</div>

				</div>
				<div id="collapseOne" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body">

						<div class="col-md-6" id="txtstyle">

							<div class="form-group">

								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">
									RequestedBy </label>
								<div class="col-xs-7">
									<input type="text" name="requested" id="requested"
										readonly="readonly" class="form-control"
										value="<logic:present name="leaveapprovelist" ><bean:write name="leaveapprovelist" property="requesttype"/></logic:present>"></input>
								</div>
							</div>
							<br />




							<!-- 	<label for="inputEmail" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">RequestedBy
								</label>
								<div class="col-xs-7">
									<select name="requested" id="requested" class="form-control">
										<option value="">----Select----</option>
										<option value="Chiru">Chiru</option>
										<option value="Sathish">Sathish</option>
										<option value="Guru">Guru</option>
										<option value="Priya">Priya</option>
										<option value="Shiva">Shiva</option>
									</select>
								</div>
							</div>
							<br /> -->


							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">From Date
								</label>
								<div class="col-xs-7">
									<input type="text" name="fromdate" id="fromdate"
										readonly="readonly" placeholder="Click Here"
										class="form-control"
										value='<logic:present name="leaveapprovelist" ><bean:write name="leaveapprovelist" property="fromdate" /></logic:present>'
										onchange="setEndDate()"></input>
								</div>
							</div>
							<br />

							<div class="form-group">

								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Session(Start)

								</label>

								<div class="col-xs-7">
									<select name="startsessionDay" id="startsessionDay"
										class="form-control">
										<option value="">----Select----</option>
										<option value="FH">First Half</option>
										<option value="SH">Second Half</option>


									</select>
								</div>


							</div>
							<br />


							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">LeaveType
								</label>
								<div class="col-xs-7">
									<select name="leavetype" id="leavetype" class="form-control">
										<option value="">----Select----</option>
										<option value="SL">SL</option>
										<option value="PL">PL</option>
										<option value="CL">CL</option>

									</select>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Start
									Date</label>
								<div class="col-xs-7">

									<input type="text" name="approvedstartdate"
										id="approvedstartdate" placeholder="Click Here"
										class="form-control"></input>
								</div>
							</div>


							<br />
							<div class="form-group">

								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Session(Start)

								</label>

								<div class="col-xs-7">
									<select name="approvedstartsessionDay"
										id="approvedstartsessionDay" class="form-control">
										<option value="">----Select----</option>
										<option value="FH">First Half</option>
										<option value="SH">Second Half</option>


									</select>
								</div>


							</div>
							<br />

							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;"> No Of
									Leaves </label>
								<div class="col-xs-7">
									<input type="text" name="leavesapproved" id="leavesapproved"
										class="form-control"></input>
								</div>
							</div>

							<br />


							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Leave
									Status </label>
								<div class="col-xs-7">
									<select name="approvedleavestatus" id="approvedleavestatus"
										class="form-control">
										<option value="">----Select----</option>
										<option value="APPROVE">APPROVE</option>
										<option value="REJECT">REJECT</option>
									</select>

								</div>
							</div>
						</div>
						<div class="col-md-6" id="txtstyle">
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;"> Total
									Leave </label>
								<div class="col-xs-7">
									<input type="text" name="totalleaves" readonly="readonly"
										id="totalleaves" class="form-control"
										value="<logic:present name="leaveapprovelist" ><bean:write name="leaveapprovelist" property="totalleave"/></logic:present>"></input>
								</div>
							</div>


							<br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">To Date</label>
								<div class="col-xs-7">
									<input type="text" name="todate" id="todate"
										readonly="readonly" placeholder="Click Here"
										class="form-control"
										value='<logic:present name="leaveapprovelist" ><bean:write name="leaveapprovelist" property="todate" /></logic:present>'></input>
								</div>
							</div>
							<br />
							<div class="form-group">

								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Session(End)

								</label>

								<div class="col-xs-7">
									<select name="endsessionDay" id="endsessionDay"
										class="form-control">
										<option value="">----Select----</option>
										<option value="FH">First Half</option>
										<option value="SH">Second Half</option>


									</select>
								</div>


							</div>
							<br />


							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Reason </label>
								<div class="col-xs-7">
									<textarea style="font-size: 12px;" name="reason"
										class="form-control" readonly="readonly" id="reason">
										
										<logic:present name="leaveapprovelist">
											<bean:write name="leaveapprovelist" property="reason" />
										</logic:present>
										
										
										
										</textarea>

								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">End Date</label>
								<div class="col-xs-7">
									<input type="text" name="approvedenddate" id="approvedenddate"
										placeholder="Click Here" class="form-control"></input>
								</div>
							</div>
							<br />
							
							<div class="form-group">

								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">
									Session(End) </label>

								<div class="col-xs-7">
									<select name="approvedendsessionDay" id="approvedendsessionDay"
										class="form-control">
										<option value="">----Select----</option>
										<option value="FH">First Half</option>
										<option value="SH">Second Half</option>


									</select>
								</div>


							</div>
							<br />
							
							
							<div class="form-group" style="visibility: hidden">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">DG</label>
								<div class="col-xs-7">
									<input type="text" placeholder="Click Here"
										class="form-control"></input>

								</div>
							</div>
							<br />
							
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-4"
									style="text-align: right; line-height: 35px;">Comments
								</label>
								<div class="col-xs-7">
									<textarea style="font-size: 12px;" name="comments"
										class="form-control" id="comments">
										</textarea>

								</div>
							</div>
						</div>
						<input type="hidden" id="duplicateid"
							value='<logic:present name="status" scope="request"><bean:write name="status" scope="request" /></logic:present>'>
						<input type="hidden" id="hiddenleavetype"
							value='<logic:present name="leaveapprovelist" scope="request"><bean:write name="leaveapprovelist" scope="request" property="leavetype"/></logic:present>'>
						<input type="hidden" id="hiddenstartsession"
							value='<logic:present name="leaveapprovelist" scope="request"><bean:write name="leaveapprovelist" scope="request" property="startsessionDay"/></logic:present>'>
						<input type="hidden" id="hiddenendsession"
							value='<logic:present name="leaveapprovelist" scope="request"><bean:write name="leaveapprovelist" scope="request" property="endsessionDay"/></logic:present>'>








					</div>
				</div>

			</div>
		</div>
	</div>
</body>

</html>
