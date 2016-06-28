package com.centris.campus.forms;

import java.sql.Date;
import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;

public class StaffEmployementForm extends ActionForm {/*
	
	private String staffname;
	private String hempid;
	private String deptid;
	private String accno;
	private String esino;
	private String staffId;
	private String paymenttype;
	private String emppfno;
	private String panno;
	
	private String ctc;
	private String hra;
	private String da;
	private String ca;
	private String conviance;
	private String grosssal;
	private String basic;
	private String medical;
	private String others;
	
	
	private String emprpf;
	private String pt;
	private String otherdeductions;
	private String latedeductions;
	private String emppf;
	private String incometax;
	private String leavedeductions;
	private String overtime;
	
	
	
	
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getHempid() {
		return hempid;
	}
	public void setHempid(String hempid) {
		this.hempid = hempid;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getEsino() {
		return esino;
	}
	public void setEsino(String esino) {
		this.esino = esino;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public String getEmppfno() {
		return emppfno;
	}
	public void setEmppfno(String emppfno) {
		this.emppfno = emppfno;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	public String getCtc() {
		return ctc;
	}
	public void setCtc(String ctc) {
		this.ctc = ctc;
	}
	public String getHra() {
		return hra;
	}
	public void setHra(String hra) {
		this.hra = hra;
	}
	public String getDa() {
		return da;
	}
	public void setDa(String da) {
		this.da = da;
	}
	public String getCa() {
		return ca;
	}
	public void setCa(String ca) {
		this.ca = ca;
	}
	public String getConviance() {
		return conviance;
	}
	public void setConviance(String conviance) {
		this.conviance = conviance;
	}
	public String getGrosssal() {
		return grosssal;
	}
	public void setGrosssal(String grosssal) {
		this.grosssal = grosssal;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getMedical() {
		return medical;
	}
	public void setMedical(String medical) {
		this.medical = medical;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getEmprpf() {
		return emprpf;
	}
	public void setEmprpf(String emprpf) {
		this.emprpf = emprpf;
	}
	public String getPt() {
		return pt;
	}
	public void setPt(String pt) {
		this.pt = pt;
	}
	public String getOtherdeductions() {
		return otherdeductions;
	}
	public void setOtherdeductions(String otherdeductions) {
		this.otherdeductions = otherdeductions;
	}
	public String getLatedeductions() {
		return latedeductions;
	}
	public void setLatedeductions(String latedeductions) {
		this.latedeductions = latedeductions;
	}
	public String getEmppf() {
		return emppf;
	}
	public void setEmppf(String emppf) {
		this.emppf = emppf;
	}
	public String getIncometax() {
		return incometax;
	}
	public void setIncometax(String incometax) {
		this.incometax = incometax;
	}
	public String getLeavedeductions() {
		return leavedeductions;
	}
	public void setLeavedeductions(String leavedeductions) {
		this.leavedeductions = leavedeductions;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	
	
	

*/
	

	
	private int year;
	private int month;
	private double basic;
	private double hra;
	private double employerpf;
	private double employeepf;
	private double pt;
	private double ca;
	private long bankaccnumber;
	private String leavedeductions;
	private String latedeductions;
	private String ot;
	private String empid="";
	private double incometax;
	private String employeepfno;
	private double grosssalary;
	private double others;
	private double ctc;
	private String empname;
	private  double employerESI;
	private  double employeeESI;
	private  double dedmployerESI;
	
	private String paymenttype;
	private double demployerpf;
	private String bankname;
	private String IFSCCode;
	private int hrapercentag;
	
	private String email;
	private long payabledays;
	private String designation;
	private String department;
	private String pfnumber;
	private String hempid;
	
	private double medicalallowances;
	private double telephonereim;
	private double perfincentive;
	private double shiftallowance;
	private double specialallowance;
	private double otherallowance;
	private double foodallowance;
	private double washingallowance;
	private Timestamp createddate;
	private String createdby;
	private String hemloyeeid;
	
	
	
	

	public String getHemloyeeid() {
		return hemloyeeid;
	}

	public void setHemloyeeid(String hemloyeeid) {
		this.hemloyeeid = hemloyeeid;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp currentdate) {
		this.createddate = currentdate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getHempid() {
		return hempid;
	}

	public void setHempid(String hempid) {
		this.hempid = hempid;
	}

	public double getMedicalallowances() {
		return medicalallowances;
	}

	public void setMedicalallowances(double medicalallowances) {
		this.medicalallowances = medicalallowances;
	}

	public double getFoodallowance() {
		return foodallowance;
	}

	public void setFoodallowance(double foodallowance) {
		this.foodallowance = foodallowance;
	}

	public double getWashingallowance() {
		return washingallowance;
	}

	public void setWashingallowance(double washingallowance) {
		this.washingallowance = washingallowance;
	}
	private double tdsctc;
	private double standarddedu;
	private double taxbleincomestatury;
	private double tdspf;
	private double tdspt;
	private double taxpayble;
	private double taxableincome;
	
	
	
	
	
	
	public double getTaxableincome() {
		return taxableincome;
	}

	public void setTaxableincome(double taxableincome) {
		this.taxableincome = taxableincome;
	}
	public double getTdsctc() {
		return tdsctc;
	}
	public void setTdsctc(double tdsctc) {
		this.tdsctc = tdsctc;
	}
	public double getStandarddedu() {
		return standarddedu;
	}
	public void setStandarddedu(double standarddedu) {
		this.standarddedu = standarddedu;
	}
	
	public double getTaxbleincomestatury() {
		return taxbleincomestatury;
	}
	public void setTaxbleincomestatury(double taxbleincomestatury) {
		this.taxbleincomestatury = taxbleincomestatury;
	}
	public double getTdspf() {
		return tdspf;
	}
	public void setTdspf(double tdspf) {
		this.tdspf = tdspf;
	}
	public double getTdspt() {
		return tdspt;
	}
	public void setTdspt(double tdspt) {
		this.tdspt = tdspt;
	}
	public double getTaxpayble() {
		return taxpayble;
	}
	public void setTaxpayble(double taxpayble) {
		this.taxpayble = taxpayble;
	}
	public double getOtherallowance() {
		return otherallowance;
	}
	public void setOtherallowance(double otherallowance) {
		this.otherallowance = otherallowance;
	}
	public double getPerfincentive() {
		return perfincentive;
	}
	public void setPerfincentive(double perfincentive) {
		this.perfincentive = perfincentive;
	}
	public double getShiftallowance() {
		return shiftallowance;
	}
	public void setShiftallowance(double shiftallowance) {
		this.shiftallowance = shiftallowance;
	}
	public double getSpecialallowance() {
		return specialallowance;
	}
	public void setSpecialallowance(double specialallowance) {
		this.specialallowance = specialallowance;
	}
	
	public double getTelephonereim() {
		return telephonereim;
	}
	public void setTelephonereim(double telephonereim) {
		this.telephonereim = telephonereim;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getPayabledays() {
		return payabledays;
	}
	public void setPayabledays(long payabledays) {
		this.payabledays = payabledays;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPfnumber() {
		return pfnumber;
	}
	public void setPfnumber(String pfnumber) {
		this.pfnumber = pfnumber;
	}
	public int getHrapercentag() {
		return hrapercentag;
	}
	public void setHrapercentag(int hrapercentag) {
		this.hrapercentag = hrapercentag;
	}
	public double getDemployerpf() {
		return demployerpf;
	}
	public void setDemployerpf(double demployerpf) {
		this.demployerpf = demployerpf;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public double getDedmployerESI() {
		return dedmployerESI;
	}
	public void setDedmployerESI(double dedmployerESI) {
		this.dedmployerESI = dedmployerESI;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getEmployerpf() {
		return employerpf;
	}
	public void setEmployerpf(double employerpf) {
		this.employerpf = employerpf;
	}
	public double getEmployeepf() {
		return employeepf;
	}
	public void setEmployeepf(double employeepf) {
		this.employeepf = employeepf;
	}
	public double getPt() {
		return pt;
	}
	public void setPt(double pt) {
		this.pt = pt;
	}
	public double getCa() {
		return ca;
	}
	public void setCa(double ca) {
		this.ca = ca;
	}
	public long getBankaccnumber() {
		return bankaccnumber;
	}
	public void setBankaccnumber(long bankaccnumber) {
		this.bankaccnumber = bankaccnumber;
	}
	public String getLeavedeductions() {
		return leavedeductions;
	}
	public void setLeavedeductions(String leavedeductions) {
		this.leavedeductions = leavedeductions;
	}
	public String getLatedeductions() {
		return latedeductions;
	}
	public void setLatedeductions(String latedeductions) {
		this.latedeductions = latedeductions;
	}
	public String getOt() {
		return ot;
	}
	public void setOt(String ot) {
		this.ot = ot;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public double getIncometax() {
		return incometax;
	}
	public void setIncometax(double incometax) {
		this.incometax = incometax;
	}
	
	
	public String getEmployeepfno() {
		return employeepfno;
	}
	public void setEmployeepfno(String employeepfno) {
		this.employeepfno = employeepfno;
	}
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
	public int getYear() {
		return year;
	}
	public double getGrosssalary() {
		return grosssalary;
	}
	public void setGrosssalary(double grosssalary) {
		this.grosssalary = grosssalary;
	}
	
	public double getOthers() {
		return others;
	}
	public void setOthers(double others) {
		this.others = others;
	}
	public double getCtc() {
		return ctc;
	}
	public void setCtc(double ctc) {
		this.ctc = ctc;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getEmployerESI() {
		return employerESI;
	}
	public void setEmployerESI(double employerESI) {
		this.employerESI = employerESI;
	}
	public double getEmployeeESI() {
		return employeeESI;
	}
	public void setEmployeeESI(double employeeESI) {
		this.employeeESI = employeeESI;
	}
	
	
	
	
	

	








}
