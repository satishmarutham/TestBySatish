<!DOCTYPE html>
<html lang="en">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<head>

<link href="/CSS/newUI/custome.css" rel="stylesheet">
<script type="text/javascript" src="JS/backOffice/Fee/FeeCollection.js"></script>
<script type="text/javascript" src="JS/common.js"></script>

<style >

.form-control{

width: 70%;
}

</style>

</head>

<body>
	<div class="col-md-10"
		style="font-family: Roboto Medium; font-size: 20pt; color: #07aab9; border-bottom: 1px solid #ddd; border-left: 1px solid #ddd; border-right: 1px solid #ddd; margin-top: -6px;">
		<p style="margin: 20px 0px;">
			<img src="images/addstu.png" />&nbsp;<span id="pageHeading">Fee Collection</span>
		</p>
		
		
				<div class="successmessagediv" align="center" style="display: none;">
						<div class="message-item">
							<!-- Warning -->
							<a href="#" class="msg-success bg-msg-succes"><span
								class="validateTips"></span></a>
						</div>
				</div>	

					
				<div class="errormessagediv" align="center" style="display: none;">
					<div class="message-item">
					<!-- Warning -->
				    <a href="#" class="msg-warning bg-msg-warning"><span
					class="validateTips"></span></a>
					</div>
				</div>	
				

				<logic:present name="successmessagediv" scope="request">
					<div class="successmessagediv">
						<div class="message-item">
							<!-- Warning -->
							<a href="#" class="msg-success bg-msg-succes"><span><bean:write
										name="successmessagediv" scope="request" /></span></a>
						</div>
					</div>
				</logic:present>
		
		</center>		

		<form method="post">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" style="color: #767676"> <i
								class="glyphicon glyphicon-menu-hamburger"></i>
								&nbsp;&nbsp;Student Fee
							</a>
						</h4>
					<div class="navbar-right">
							
							
							
							<span id="saveid" class="save2">
							
							<img src="images/save.png" class="save" data-toggle="tooltip" data-placement="bottom" title="Pay Fee">
									
							</Span>	
							
								
						<a href="adminMenu.html?method=feeCollection">
							<span class="glyphicon glyphicon-list2"></span>
						</a>
					</div>
					
					</div>
					
					<script>
	$(document).ready(function(){
	    $('[data-toggle="tooltip"]').tooltip();   
	});
	</script>
					

			<div class="feebody panel-group" id="accordion" role="tablist" aria-multiselectable="true">

					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne" align="center">
						<div class="panel-body">
						
						<input type="hidden" id="hyear" value="<logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="accYear"/></logic:present>"/>
						<input type="hidden" id="hclass" value="<logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="classId"/></logic:present>"/>
						<input type="hidden" id="hterm" value="<logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="termid"/></logic:present>"/>

							
							<div class="col-md-6" id="txtstyle">

								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;" >Admission No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light" id="addmissionNo"><logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="addmissionno"/></logic:present>
										</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Accodamic Year
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light"><logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="accYearname"/></logic:present>
										</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Class-Section
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light"><logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="classname"/></logic:present>-<logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="sectionname"/></logic:present>
										</label>
									</div>
								</div>
								</div>

							<div class="col-md-6" id="txtstyle">

								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Student
										Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light"><logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="studentname"/></logic:present>
										</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Period/Term
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light"><logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="term"/></logic:present>
										</label>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-xs-6"
										style="text-align: right; font-family: sans-serif; line-height: 35px;font-family:Roboto Medium; font-size: 14px;font-weight:lighter;">Concession
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
									<div class="col-xs-6">
										<label for="inputPassword" class="col-xs-12"
											style="text-align: left; line-height: 35px;font-size: 13px;font-family: Open Sans Light" id="concessionPercent"><logic:present name="FeeCollectionVo"><bean:write name="FeeCollectionVo" property="concession"/></logic:present>%
										</label>
									</div>
								</div>
								

							</div>


						</div>
						
						
							<logic:present name="FeeCollectionVo" scope="request">

									<table  class="table" id="allstudent" style="font-family: Open Sans Light;color: #897676;" >
										
										<tr>
											<th class="headth">Sno</th>
											<th class="headth">Fee Name</th>
											<th class="headth">Actual amount</th>
											<th class="headth">Concession amount</th>
											<th class="headth">Paid amount</th>
											
										</tr>
											<logic:iterate name="FeeCollectionVo" property="feeNamelist" id="dateVO">
												
												<tr>
												<input type="hidden" value="<bean:write name="dateVO" property="isconcession" />" class="isconcession"/>
												<input type="hidden" value="<bean:write name="dateVO" property="feecode" />" class="feecode"/>
													<td class="sno" ><bean:write name="dateVO" property="sno" /></td>
													<td class="feename"><bean:write name="dateVO" property="feename" /></td>
													<td class="actualamount"><bean:write name="dateVO" property="actualAmt" /></td>
													<td class="concessionamount"><input type="text" class="concessionamt form-control" style="margin:-7px 0px" value="<bean:write name="dateVO" property="concessionAmt" />"/></td>
													<td class="paidamount"><bean:write name="dateVO" property="paidAmt" /></td>
												
												</tr>
												
												
												
												
											</logic:iterate>
											<tr style="border-top: 1px solid;border-color: #ddd">
											
											<td colspan="2" align="center" style="text-align: center;">Total</td>
											<td id="tot_actual_amt"><bean:write name="FeeCollectionVo" property="tot_actual_amt" /></td>
											<td id="tot_concession_amt"><bean:write name="FeeCollectionVo" property="tot_concession_amt" /></td>
											<td id="tot_paid_amt"><bean:write name="FeeCollectionVo" property="tot_paid_amt" /></td>
											
											</tr>
											
										</table>
				
					</logic:present>
					
						
					</div>

			
				
			</div>
			
			</div>
					</div>

		</form>
				</div>
			
				
			
	
</body>

</html>
