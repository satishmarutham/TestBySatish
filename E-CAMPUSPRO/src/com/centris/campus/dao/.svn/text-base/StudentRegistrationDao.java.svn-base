package com.centris.campus.dao;

import java.util.List;
import java.util.Map;

import com.centris.campus.forms.StudentRegistrationForm;
import com.centris.campus.vo.StageMasterVo;
import com.centris.campus.vo.StudentRegistrationVo;
import com.centris.campus.vo.TransportTypeVO;
import com.centris.campus.vo.registrationvo;

public interface StudentRegistrationDao {
	public List<StudentRegistrationVo> getAcademicYear() throws Exception;

	public List<StudentRegistrationVo> getStudentquota() throws Exception;

	public Map<String, String> saveStudentRegistration(
			StudentRegistrationForm studentRegistrationForm) throws Exception;

	public List<StudentRegistrationVo> studentSearch(
			StudentRegistrationVo registrationVo);

	/*
	 * public StudentRegistrationVo searchStudentResult( StudentRegistrationVo
	 * registrationVo);
	 */

	public String modifyStudentDetails(StudentRegistrationForm modifyform);

	public List<StudentRegistrationVo> studentSearchByParent(
			StudentRegistrationVo registrationVo);

	public List<StudentRegistrationVo> studentSearchbySibling(
			StudentRegistrationVo registrationVo);

	public String validatePhoneNo(String phoneNo) throws Exception;

	public String validateEmail(String email) throws Exception;

	public List<StudentRegistrationVo> getStudentCaste();

	public int validateDuplicateData(StudentRegistrationForm formObj,
			String type) throws Exception;

	public String validateRollNumber(String rollNumber) throws Exception;

	public String checkApplicationNo(String applicationNo) throws Exception;

	public List<StudentRegistrationVo> getChildCategory();

	public List<StudentRegistrationVo> getClassDetails(String catecory);

	public List<StudentRegistrationVo> getSection(String classval);

	public List<StudentRegistrationVo> getConcessionDetails();

	public List<TransportTypeVO> transportypedetails();

	public List<StageMasterVo> getStageDetails();

	public List<StudentRegistrationVo> getStudentDetails();

	public boolean deactivateStudent(StudentRegistrationVo registrationVo);

	public List<StudentRegistrationVo> searchStudentResult(
			StudentRegistrationVo registrationVo);
	public List<registrationvo> StudentDetails();

	
}
