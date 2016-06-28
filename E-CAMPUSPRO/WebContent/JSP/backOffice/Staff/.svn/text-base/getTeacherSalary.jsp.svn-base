<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html lang="en">

<head>

<script type="text/javascript" src="JQUERY/jquery-1.9.1.js"></script>
<script type="text/javascript" src="JS/common.js"></script>
<script type="text/javascript" src="JS/newUI/jquery-1.9.1.min.js"></script>


<link href="CSS/newUI/bootstrap.min.css" rel="stylesheet">
<link href="CSS/newUI/modern-business.css" rel="stylesheet">
<link href="CSS/newUI/custome.css" rel="stylesheet">
<link href="CSS/newUI/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="JS/backOffice/Staff/StaffEmployement.js"></script>


<style>
.save:hover {
	cursor: pointer;
}
</style>

</head>

<body>



	<div class="col-md-10"
		style="font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Staff
				Employment</span>
		</p>
		<logic:present name="successMessage" scope="request">

			<div class="successmessagediv">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-success bg-msg-succes"><span> <bean:write
								name="successMessage" scope="request" />
					</span></a>
				</div>
			</div>

		</logic:present>

		<logic:present name="errorMessage" scope="request">

			<div class="successmessagediv" align="center">
				<div class="message-item">
					<!-- Warning -->
					<a href="#" class="msg-warning bg-msg-warning"><span> <bean:write
								name="errorMessage" scope="request" />
					</span></a>
				</div>

			</div>

		</logic:present>

		<div class="errormessagediv"  align="center" style="display: none;">
			<div class="message-item">
				<!-- Warning -->
				<a href="#" class="msg-warning bg-msg-warning"><span
					class="validateTips"></span></a>
			</div>
		</div>



		<form action="staffemployement.html?method=saveStaffSalaryDetails"
			id="teacherform" method="post">

			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">


				<!-- Staff Details  -->

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Staff Details
							</a>
						</h4>

						<div class="navbar-right">


							<span class="save2" id="submit"> <img
								src="images/save.png" class="save" data-toggle="tooltip"
								data-placement="bottom" title="Save">
							</span> <a href="adminMenu.html?method=staffEmployementList"> <span
								class="glyphicon glyphicon-list2" data-toggle="tooltip"
								data-placement="bottom" title="List"></span>
							</a>
						</div>

					</div>

					<script>
						$(document).ready(function() {
							$('[data-toggle="tooltip"]').tooltip();
						});
					</script>

					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">


								<input type="hidden" name="hemloyeeid" id="hemloyeeid"
									value="<logic:present name="teachercode"><bean:write name="teachercode" /></logic:present>" />
								<input type="hidden" name="hempid" id="hempid"
									value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="empid"/></logic:present>" />
								<input type="hidden" id="hpaymenttype"
									value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="paymenttype"/></logic:present>" />
								<input type="hidden" id="hbankname"
									value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="bankname"/></logic:present>" />
							



								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Staff
										Name </label>

									<div class="col-xs-7">

										<input type="text" name="empname" id="empname"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="empname"/></logic:present>" />

									</div>
								</div>

								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Bank
										Account No </label>
									<div class="col-xs-7">
										<input type="text" name="bankaccnumber" id="bankaccnumber"
											maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="bankaccnumber"/></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Bank
										Name </label>
									<div class="col-xs-7">
										<select class="form-control" name="bankname" id="bankid">
											<option value="">----Select----</option>
											<option value="allahabadbank">Allahabad Bank</option>
											<option value="andhrabank">Andhra Bank</option>
											<option value="axisbank">Axis Bank</option>
											<option value="canarabank">Canara Bank</option>
											<option value="federalbank">Federal Bank</option>
											<option value="hdfcbank">HDFC Bank</option>
											<option value="icicibank">ICICI Bank</option>
											<option value="idbibank">IDBI Bank</option>
											<option value="indianbank">Indian Bank</option>
											<option value="ingvysyabank">ING Vysya Bank</option>
											<option value="karnatakabank">Karnataka Bank</option>
											<option value="karurvysyabank">Karur Vysya Bank</option>
											<option value="kotakbank">Kotak Bank</option>
											<option value="statebankofhyderabad">State Bank Of
												Hyderabad</option>
											<option value="statebankofmysore">State Bank Of
												India</option>
											<option value="statebankofmysore">State Bank Of
												Mysore</option>
											<option value="syndicatebank">Syndicate Bank</option>
											<option value="vijayanank">Vijaya Bank</option>
										</select>

									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Payment
										Type </label>
									<div class="col-xs-7">
										<select class="form-control" name="paymenttype"
											id="paymenttype">
											<option value="">----Select----</option>
											<option value="bank">Bank</option>
											<option value="check">Cheque</option>
											<option value="cash">Cash</option>

										</select>
									</div>
								</div>


							</div>


							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Staff ID
									</label>
									<div class="col-xs-7">
										<input type="text" name="staffId" id="staffId" maxlength="25"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="empid"/></logic:present>" />
									</div>
								</div>


								<br />


								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Employee
										PF No</label>
									<div class="col-xs-7">
										<input type="text" name="employeepfno" id="employeepfno"
											maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="employeepfno"/></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">IFSC
										Code </label>
									<div class="col-xs-7">
										<input type="text" name="IFSCCode" id="IFSCCode"
											maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="IFSCCode"/></logic:present>" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>



				<!-- Earnings -->



				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseTwo"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapseTwo"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Earnings
							</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">




								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Basic &
										DA </label>
									<div class="col-xs-7">
										<input type="text" name="basic" id="basic" maxlength="25"
											class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="basic"/></logic:present>" />
									</div>
								</div>
								<br />


								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">HRA(%) </label>
									<div class="col-xs-7">
										<select name="hrapercentag" id="hrapercentag"
											class="form-control" onchange="salarycalculations()">
											<logic:present name="Stafflist" scope="request">
												<option
													value="<bean:write name="Stafflist" property="hrapercentag" />">
													<bean:write name="Stafflist" property="hrapercentag" />
												</option>
											</logic:present>
											<option value="">----Select----</option>
											<option value="20">20</option>
											<option value="25">25</option>
											<option value="30">30</option>
											<option value="35">35</option>
											<option value="40">40</option>
											<option value="45">45</option>
											<option value="50">50</option>
										</select>


									</div>
								</div>
								<br />

								<!-- <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">HRA(%) </label>
									<div class="col-xs-7">
										<select class="form-control" name="hrapercentage"
											id="hrapercentage">
											<option value="">----Select----</option>
											<option value="20">20</option>
											<option value="25">25</option>
											<option value="30">30</option>
											<option value="35">35</option>
											<option value="40">40</option>
											<option value="45">45</option>
											<option value="50">50</option>
										</select> </select>
									</div>
								</div> 
								<br />-->
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Medical
										Allowances </label>
									<div class="col-xs-7">
										<input type="text" name="medicalallowances"
											id="medicalallowances" maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="medicalallowances"/></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Performance
										Incentives </label>
									<div class="col-xs-7">
										<input type="text" name="perfincentive" id="perfincentive"
											maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="perfincentive"/></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Special
										Allowances </label>
									<div class="col-xs-7">
										<input type="text" name="specialallowance"
											id="specialallowance" maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="specialallowance"/></logic:present>" />
									</div>
								</div>

								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Washing
										Allowances </label>
									<div class="col-xs-7">
										<input type="text" name="washingallowance"
											id="washingallowance" maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="washingallowance"/></logic:present>" />
									</div>
								</div>

								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Employer
										PF </label>
									<div class="col-xs-7">
										<input type="text" name="employerpf" id="employerpf"
											maxlength="25" class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="employerpf"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Gross
										Salary </label>
									<div class="col-xs-7">
										<input type="text" name="grosssalary" id="grosssalary"
											maxlength="25" class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="grosssalary"/></logic:present>" />
									</div>
								</div>
								<br />






							</div>

							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">




								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">CA </label>
									<div class="col-xs-7">
										<input type="text" name="ca" id="ca" maxlength="25"
											onchange="salarycalculations()" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="ca"/></logic:present>" />
									</div>
								</div>
								<br />


								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">HRA </label>
									<div class="col-xs-7">
										<input type="text" name="hra" id="hra" maxlength="25"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="hra"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Telephone
										Allowances </label>
									<div class="col-xs-7">
										<input type="text" name="telephonereim" id="telephonereim"
											maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="telephonereim"/></logic:present>" />
									</div>
								</div>

								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Food
										Allowances </label>
									<div class="col-xs-7">
										<input type="text" name="foodallowance" id="foodallowance"
											maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="foodallowance"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Other
										Allowances </label>
									<div class="col-xs-7">
										<input type="text" name="others" id="others" maxlength="25"
											class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="others"/></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Employer
										ESI </label>
									<div class="col-xs-7">
										<input type="text" name="employerESI" id="employerESI"
											maxlength="25" class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="employerESI"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">CTC </label>
									<div class="col-xs-7">
										<input type="text" name="ctc" id="ctc" maxlength="25"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="ctc"/></logic:present>" />
									</div>
								</div>
								<br />
								<%-- <div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Is
										Applicable for OT</label>
									<div class="col-xs-7">

										<logic:present name="Stafflist" scope="request">
											<logic:match name="Stafflist" property="ot" value="Y">

												<input type="radio" name="ot" id="ot" value="Y" checked>Yes 
												<input type="radio" name="ot" id="ot" value="N">No
											</logic:match>

											<logic:match name="Stafflist" property="ot" value="N">
												<input type="radio" name="ot" id="ot" value="Y">Yes 
												<input type="radio" name="ot" id="ot" value="N" checked>No 
											</logic:match>
										</logic:present>
										<logic:notPresent name="Stafflist" scope="request">
											<input type="radio" name="ot" id="ot" value="Y" checked>Yes
                   						<input type="radio" name="ot" id="ot" value="N"> No
									</logic:notPresent>


									</div>
								</div> --%>
							</div>
						</div>
					</div>
				</div>


				<!-- Deductions -->

				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseThree"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapseThree"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Deductions
							</a>
						</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingThree">
						<div class="panel-body">
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">




								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Employer
										PF </label>
									<div class="col-xs-7">
										<input type="text" name="demployerpf" id="demployerpf"
											maxlength="25" class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="demployerpf"/></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Income
										Tax </label>
									<div class="col-xs-7">
										<input type="text" name="incometax" id="incometax"
											maxlength="25" class="form-control"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="incometax"/></logic:present>" />
									</div>
								</div>

								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Employer
										ESI </label>
									<div class="col-xs-7">
										<input type="text" name="dedmployerESI" id="dedmployerESI"
											maxlength="25" class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="dedmployerESI"/></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputPassword" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Leave
										Deductions</label>
									<div class="col-xs-7" id="radiostyle" style="margin-top: 8px">


										<logic:present name="Stafflist" scope="request">

											<logic:match name="Stafflist" property="leavedeductions"
												value="Y">

												<input type="radio" name="leavedeductions"
													id="leavedeductions" value="Y" checked>Yes
										<input type="radio" name="leavedeductions"
													id="leavedeductions" value="N">No
					
									</logic:match>

											<logic:match name="Stafflist" property="leavedeductions"
												value="N">
												<input type="radio" name="leavedeductions"
													id="leavedeductions" value="Y">Yes
										<input type="radio" name="leavedeductions"
													id="leavedeductions" value="N" checked>No
									</logic:match>

										</logic:present>

										<%-- <logic:notPresent name="Stafflist" scope="request">

											<input type="radio" name="leavedeductions"
												id="leavedeductions" value="Y" checked>Yes
                   			<input type="radio" name="leavedeductions"
												id="leavedeductions" value="N"> No
					
						 </logic:notPresent> --%>

									</div>
								</div>  



							</div>
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">


								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Employee
										PF </label>
									<div class="col-xs-7">
										<input type="text" name="employeepf" id="employeepf"
											maxlength="25" class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="employeepf"/></logic:present>" />
									</div>
								</div>
								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">PT </label>
									<div class="col-xs-7">
										<input type="text" name="pt" id="pt" maxlength="25"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="pt"/></logic:present>" />
									</div>
								</div>


								<br />
								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Employee
										ESI </label>
									<div class="col-xs-7">
										<input type="text" name="employeeESI" id="employeeESI"
											maxlength="25" class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist"><bean:write name="Stafflist" property="employeeESI"/></logic:present>" />
									</div>
								</div>
								<br />
							<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Late
										Deductions<font color="red"></font>
									</label>
									<div class="col-xs-7" id="radiostyle" style="margin-top: 8px">


										<logic:present name="Stafflist" scope="request">
											<logic:match name="Stafflist" property="latedeductions"
												value="Y">

												<input type="radio" name="latedeductions"
													id="latedeductions" value="Y" checked>Yes 
					 							<input type="radio" name="latedeductions"
													id="latedeductions" value="N"> No
											</logic:match>

											<logic:match name="Stafflist" property="latedeductions"
												value="N">

												<input type="radio" name="latedeductions"
													id="latedeductions" value="Y">Yes 
					 							<input type="radio" name="latedeductions"
													id="latedeductions" value="N" checked> No
					 						</logic:match>
										</logic:present>
									<%-- 	<logic:notPresent name="Stafflist" scope="request">
											<input type="radio" name="latedeductions" id="latedeductions"
												value="Y" checked>Yes
                    							<input type="radio" name="latedeductions"
												id="latedeductions" value="N">No
                    					</logic:notPresent> --%>

									</div>
								</div>  




							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingFive">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseFive"
								style="color: #767676" aria-expanded="false"
								aria-controls="collapseThree"> <i
								class="glyphicon glyphicon-menu-hamburger"></i> &nbsp;&nbsp;TDS
							</a>
						</h4>
					</div>


					<div id="collapseFive" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingFive">
						<html:hidden property="count" styleId="count" value="0" />
						<div class="panel-body">

							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">
								<input type="hidden" name="depId" id="departmentid"
									value="<logic:present name="deptdetails" scope="request"><bean:write name="deptdetails" property="depId" ></bean:write></logic:present>" />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">CTC(per
										year)<font color="red"></font>
									</label>
									<div class="col-xs-7">
										<input type="text" name="tdsctc" id="tdsctc"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist" scope="request"><bean:write name="Stafflist" property="tdsctc" /></logic:present>" />
									</div>
								</div>
								<br />



								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Taxble
										Income<font color="red"></font>
									</label>
									<div class="col-xs-7">
										<input type="text" name="taxbleincomestatury"
											id="taxbleincomestatury" class="form-control"
											readonly="readonly"
											value="<logic:present name="Stafflist" scope="request"><bean:write name="Stafflist" property="taxbleincomestatury" /></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">PT<font
										color="red"></font></label>
									<div class="col-xs-7">
										<input type="text" name="tdspt" id="tdspt"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist" scope="request"><bean:write name="Stafflist" property="tdspt" /></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Tax
										Payble<font color="red"></font>
									</label>
									<div class="col-xs-7">
										<input type="text" name="taxpayble" id="taxpayble"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist" scope="request"><bean:write name="Stafflist" property="taxpayble" /></logic:present>" />
									</div>
								</div>
								<br />



							</div>
							<div class="col-md-6"
								style="font-family: Open Sans Light; font-size: 11pt; color: #5d5d5d;">

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Standard
										Deductions<font color="red"></font>
									</label>
									<div class="col-xs-7">
										<input type="text" name="standarddedu" id="standarddedu"
											class="form-control" onchange="salarycalculations()"
											value="<logic:present name="Stafflist" scope="request"><bean:write name="Stafflist" property="standarddedu" /></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">PF
										Exemption<font color="red"></font>
									</label>
									<div class="col-xs-7">
										<input type="text" name="tdspf" id="tdspf"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist" scope="request"><bean:write name="Stafflist" property="tdspf" /></logic:present>" />
									</div>
								</div>
								<br />

								<div class="form-group">
									<label for="inputEmail" class="control-label col-xs-4"
										style="text-align: right; line-height: 35px;">Taxble
										Income<font color="red"></font>
									</label>
									<div class="col-xs-7">
										<input type="text" name="taxableincome" id="taxableincome"
											class="form-control" readonly="readonly"
											value="<logic:present name="Stafflist" scope="request"><bean:write name="Stafflist" property="taxableincome" /></logic:present>"
											onchange="salarycalculations()" />
									</div>
								</div>
								<br />

							</div>
						</div>
					</div>
				</div>

			</div>

		</form>
	</div>
</html>
