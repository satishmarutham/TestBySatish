package com.centris.campus.vo;

import java.util.ArrayList;

public class FeeCollectionVo {

	private String addmissionno;
	private String studentname;
	
	private String term;
	private String termid;
	
	private String classId;
	private String classname;
	
	private String sectionId;
	private String sectionname;
	
	private String accYear;
	private String accYearname;
	
	private String amount;
	private String status;
	private int sno;
	
	private double concession;

	
	private double tot_actual_amt;
	private double tot_concession_amt;
	private double tot_paid_amt;
	
	
	private ArrayList<FeeNameVo> feeNamelist;
	
	private String userID;
	
	
	
	
	
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public String getAccYearname() {
		return accYearname;
	}
	public void setAccYearname(String accYearname) {
		this.accYearname = accYearname;
	}
	
	public double getConcession() {
		return concession;
	}
	public void setConcession(double concession) {
		this.concession = concession;
	}
	public double getTot_actual_amt() {
		return tot_actual_amt;
	}
	public void setTot_actual_amt(double tot_actual_amt) {
		this.tot_actual_amt = tot_actual_amt;
	}
	public double getTot_concession_amt() {
		return tot_concession_amt;
	}
	public void setTot_concession_amt(double tot_concession_amt) {
		this.tot_concession_amt = tot_concession_amt;
	}
	public double getTot_paid_amt() {
		return tot_paid_amt;
	}
	public void setTot_paid_amt(double tot_paid_amt) {
		this.tot_paid_amt = tot_paid_amt;
	}
	public ArrayList<FeeNameVo> getFeeNamelist() {
		return feeNamelist;
	}
	public void setFeeNamelist(ArrayList<FeeNameVo> feeNamelist) {
		this.feeNamelist = feeNamelist;
	}
	public String getAccYear() {
		return accYear;
	}
	public void setAccYear(String accYear) {
		this.accYear = accYear;
	}
	public String getTermid() {
		return termid;
	}
	public void setTermid(String termid) {
		this.termid = termid;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getAddmissionno() {
		return addmissionno;
	}
	public void setAddmissionno(String addmissionno) {
		this.addmissionno = addmissionno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
