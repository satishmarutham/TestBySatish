/**
 * 
 */
package com.centris.campus.vo;

/**
 * @author satish
 * 
 */
public class AllTeacherDetailsVo {
	
	private String teacherName;
	private String mobileNo;
	private String qualification;
	private String designation;
	private String email;
	private String teacherId;
	private String dateofJoining;
	private String dateofBirth;
	private String teacherType;
	private String address;
	private String Image;
	private String Subjectspecialization;
	private String slno;
	private String department;
	private String searchTerm;
	
	private String bankaccountNo="-";
	private String pfnumber="-";
	private Double ctc;
	private String registartionNo="-";
	
	private String usertype;
	
	
	public String getBankaccountNo() {
		return bankaccountNo;
	}

	public void setBankaccountNo(String bankaccountNo) {
		this.bankaccountNo = bankaccountNo;
	}

	public String getPfnumber() {
		return pfnumber;
	}

	public void setPfnumber(String pfnumber) {
		this.pfnumber = pfnumber;
	}

	public Double getCtc() {
		return ctc;
	}

	public void setCtc(Double ctc) {
		this.ctc = ctc;
	}

	public String getRegistartionNo() {
		return registartionNo;
	}

	public void setRegistartionNo(String registartionNo) {
		this.registartionNo = registartionNo;
	}

	public String getSlno() {
		return slno;
	}

	public void setSlno(String slno) {
		this.slno = slno;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getSubjectspecialization() {
		return Subjectspecialization;
	}

	public void setSubjectspecialization(String subjectspecialization) {
		Subjectspecialization = subjectspecialization;
	}

	public String getDateofJoining() {
		return dateofJoining;
	}

	public void setDateofJoining(String dateofJoining) {
		this.dateofJoining = dateofJoining;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getTeacherType() {
		return teacherType;
	}

	public void setTeacherType(String teacherType) {
		this.teacherType = teacherType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
}