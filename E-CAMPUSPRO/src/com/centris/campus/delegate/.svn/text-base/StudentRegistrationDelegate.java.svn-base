/**
 * 
 */
package com.centris.campus.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.centris.campus.forms.StudentRegistrationForm;
import com.centris.campus.serviceImpl.StudentRegistrationServiceImpl;
import com.centris.campus.vo.StageMasterVo;
import com.centris.campus.vo.StudentInfoVO;
import com.centris.campus.vo.StudentRegistrationVo;
import com.centris.campus.vo.TransportTypeVO;
import com.centris.campus.vo.ViewallSubjectsVo;
import com.centris.campus.vo.registrationvo;

/**
 * @author sathish
 * 
 */
public class StudentRegistrationDelegate {
	public List<StudentRegistrationVo> getAcademicYear() throws Exception {
		return new StudentRegistrationServiceImpl().getAcademicYear();

	}

	public List<StudentRegistrationVo> getStudentquota() throws Exception {
		return new StudentRegistrationServiceImpl().getStudentquota();

	}

	public Map<String, String> saveStudentRegistration(
			StudentRegistrationForm studentRegistrationForm) throws Exception {
		return new StudentRegistrationServiceImpl()
				.saveStudentRegistration(studentRegistrationForm);
	}

	public List<StudentRegistrationVo> studentSearch(
			StudentRegistrationVo studentSearch) {
		return new StudentRegistrationServiceImpl()
				.studentSearch(studentSearch);
	}

	public List<StudentRegistrationVo> searchStudentResult(
			StudentRegistrationVo registrationVo) {
		return new StudentRegistrationServiceImpl()
				.searchStudentResult(registrationVo);
	}

	public List<StudentRegistrationVo> studentSearchByParent(
			StudentRegistrationVo registrationVo) {
		return new StudentRegistrationServiceImpl()
				.studentSearchByParent(registrationVo);
	}

	public List<StudentRegistrationVo> getStudentCaste() throws Exception {
		return new StudentRegistrationServiceImpl().getStudentCaste();

	}

	public String modifyStudentDetails(StudentRegistrationForm registrationVo) {
		return new StudentRegistrationServiceImpl().modifyStudentDetails(registrationVo);
	}

	public int validateDuplicateData(StudentRegistrationForm formObj,
			String type) {
		return new StudentRegistrationServiceImpl().validateDuplicateData(
				formObj, type);
	}

	public ArrayList<StudentInfoVO> getAllStudentsDetails(String classname,
			String accodamicyr) {

		return new StudentRegistrationServiceImpl().getAllStudentsDetails(
				classname, accodamicyr);
	}

	public String getTransportCategoryType(String trnsportTypeId) {

		return new StudentRegistrationServiceImpl()
				.getTransportCategoryType(trnsportTypeId);
	}

	public List<StudentRegistrationVo> studentSearchbyClass(
			StudentRegistrationVo studentSearch) {
		return new StudentRegistrationServiceImpl()
				.studentSearchbyClass(studentSearch);
	}

	public List<StudentRegistrationVo> getChildCategory() {
		return new StudentRegistrationServiceImpl().getChildCategory();
	}

	public List<StudentRegistrationVo> getClassDetails(String catecory) {
		return new StudentRegistrationServiceImpl().getClassDetails(catecory);
	}

	public List<StudentRegistrationVo> getSection(String classval) {
		return new StudentRegistrationServiceImpl().getSection(classval);
	}

	public List<StudentRegistrationVo> getConcessionDetails() {
		return new StudentRegistrationServiceImpl().getConcessionDetails();
	}

	public List<TransportTypeVO> transportypedetails() {
		return new StudentRegistrationServiceImpl().transportypedetails();
	}

	public List<StageMasterVo> getStageDetails() {
		return new StudentRegistrationServiceImpl().getStageDetails();
	}

	public List<StudentRegistrationVo> getStudentDetails() {
		return new StudentRegistrationServiceImpl().getStudentDetails();
	}

	public boolean deactivateStudent(StudentRegistrationVo registrationVo) {
		return new StudentRegistrationServiceImpl()
				.deactivateStudent(registrationVo);
	}

	public ArrayList<ViewallSubjectsVo> getSubjectByClass(String classID) {
		return new StudentRegistrationServiceImpl().getSubjectByClass(classID);
	}
	
	public StudentRegistrationVo editStudent(StudentRegistrationVo registrationVo) {
		
		return new StudentRegistrationServiceImpl().editStudent(registrationVo);
	}
	public List<registrationvo> StudentDetails() {
		return new StudentRegistrationServiceImpl().StudentDetails();
	}

}
