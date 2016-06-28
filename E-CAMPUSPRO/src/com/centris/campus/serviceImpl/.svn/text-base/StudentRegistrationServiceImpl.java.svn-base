/**
 * 
 */
package com.centris.campus.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.StudentRegistrationDao;
import com.centris.campus.daoImpl.StudentRegistrationDaoImpl;
import com.centris.campus.forms.StudentRegistrationForm;
import com.centris.campus.service.StudentRegistrationService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
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
public class StudentRegistrationServiceImpl implements
		StudentRegistrationService {
	private static final Logger logger = Logger
			.getLogger(StudentRegistrationServiceImpl.class);

	@Override
	public List<StudentRegistrationVo> getAcademicYear() throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:getAcademicYear  Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:getAcademicYear  Ending");
		// TODO Auto-generated method stub
		return new StudentRegistrationDaoImpl().getAcademicYear();
	}

	@Override
	public Map<String, String> saveStudentRegistration(
			StudentRegistrationForm studentRegistrationForm) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:saveStudentRegistration  Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:saveStudentRegistration Ending");
		return new StudentRegistrationDaoImpl()
				.saveStudentRegistration(studentRegistrationForm);
	}

	@Override
	public List<StudentRegistrationVo> studentSearch(
			StudentRegistrationVo studentRegistrationVo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:studentSearch  Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:studentSearch  Ending");
		// TODO Auto-generated method stub
		return new StudentRegistrationDaoImpl()
				.studentSearch(studentRegistrationVo);
	}

	@Override
	public List<StudentRegistrationVo> searchStudentResult(
			StudentRegistrationVo registrationVo) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:searchStudentResult  Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:searchStudentResult  Ending");
		return new StudentRegistrationDaoImpl()
				.searchStudentResult(registrationVo);
	}

	public String modifyStudentDetails(StudentRegistrationForm modifyform) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl: modifyStudentDetails Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl: modifyStudentDetails  Ending");
		// TODO Auto-generated method stub

		return new StudentRegistrationDaoImpl()
				.modifyStudentDetails(modifyform);
	}

	@Override
	public List<StudentRegistrationVo> getStudentquota() throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:getStudentquota   Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:getStudentquota  Ending");
		// TODO Auto-generated method stub
		return new StudentRegistrationDaoImpl().getStudentquota();
	}

	@Override
	public List<StudentRegistrationVo> studentSearchByParent(
			StudentRegistrationVo registrationVo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:studentSearchByParent   Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:studentSearchByParent Ending");

		// TODO Auto-generated method stub
		return new StudentRegistrationDaoImpl()
				.studentSearchByParent(registrationVo);
	}

	@Override
	public List<StudentRegistrationVo> getStudentCaste() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getStudentCaste  Starting");
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getStudentCaste  Ending");
		// TODO Auto-generated method stub
		return new StudentRegistrationDaoImpl().getStudentCaste();
	}

	@Override
	public int validateDuplicateData(StudentRegistrationForm formObj,
			String type) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : validateDuplicateData  Starting");
		StudentRegistrationDao obj = new StudentRegistrationDaoImpl();
		int count = 0;
		try {
			count = obj.validateDuplicateData(formObj, type);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : validateDuplicateData  Ending");
		return count;
	}

	public ArrayList<StudentInfoVO> getAllStudentsDetails(String classname,
			String accodamicyr) {

		return new StudentRegistrationDaoImpl().getAllStudentsDetails(
				classname, accodamicyr);
	}

	public String getTransportCategoryType(String trnsportTypeId) {

		return new StudentRegistrationDaoImpl()
				.getTransportCategoryType(trnsportTypeId);
	}

	public List<StudentRegistrationVo> studentSearchbyClass(
			StudentRegistrationVo studentRegistrationVo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : studentSearchbyClass  Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : studentSearchbyClass  Ending");
		// TODO Auto-generated method stub
		return new StudentRegistrationDaoImpl()
				.studentSearchbyClass(studentRegistrationVo);
	}

	public List<StudentRegistrationVo> getChildCategory() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getChildCategory  Starting");
		List<StudentRegistrationVo> categorylist = null;
		try {
			categorylist = new StudentRegistrationDaoImpl().getChildCategory();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getChildCategory  Ending");
		// TODO Auto-generated method stub

		return categorylist;
	}

	public List<StudentRegistrationVo> getClassDetails(String catecory) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getClassDetails  Starting");
		List<StudentRegistrationVo> list = null;
		try {
			list = new StudentRegistrationDaoImpl().getClassDetails(catecory);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getClassDetails  Ending");
		// TODO Auto-generated method stub

		return list;
	}

	public List<StudentRegistrationVo> getSection(String classval) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getClassDetails  Starting");
		List<StudentRegistrationVo> list = null;
		try {
			list = new StudentRegistrationDaoImpl().getSection(classval);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getClassDetails  Ending");
		// TODO Auto-generated method stub

		return list;
	}

	public List<StudentRegistrationVo> getConcessionDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getConcessionDetails  Starting");
		List<StudentRegistrationVo> list = null;
		try {
			list = new StudentRegistrationDaoImpl().getConcessionDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getConcessionDetails  Ending");
		// TODO Auto-generated method stub

		return list;
	}

	public List<TransportTypeVO> transportypedetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : transportypedetails  Starting");
		List<TransportTypeVO> list = null;
		try {
			list = new StudentRegistrationDaoImpl().transportypedetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : transportypedetails  Ending");
		// TODO Auto-generated method stub

		return list;

	}

	public List<StageMasterVo> getStageDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getStageDetails  Starting");
		List<StageMasterVo> list = null;
		try {
			list = new StudentRegistrationDaoImpl().getStageDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getStageDetails  Ending");
		// TODO Auto-generated method stub
		return list;

	}

	public List<StudentRegistrationVo> getStudentDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getStudentDetails  Starting");
		List<StudentRegistrationVo> list = null;
		try {
			list = new StudentRegistrationDaoImpl().getStudentDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getStudentDetails  Ending");
		// TODO Auto-generated method stub

		return list;
	}

	public boolean deactivateStudent(StudentRegistrationVo registrationVo) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:deactivateStudent Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl:deactivateStudent  Ending");
		return new StudentRegistrationDaoImpl()
				.deactivateStudent(registrationVo);
	}

	public ArrayList<ViewallSubjectsVo> getSubjectByClass(String classID) {

		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getSubjectByClass Starting");

		ArrayList<ViewallSubjectsVo> subjectList = new ArrayList<ViewallSubjectsVo>();

		try {

			subjectList = new StudentRegistrationDaoImpl()
					.getSubjectByClass(classID);
		} catch (Exception e) {

			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getSubjectByClass  Ending");
		return subjectList;

	}
	
	
	public StudentRegistrationVo editStudent(StudentRegistrationVo registrationVo){
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : editStudent  Starting");
		
		StudentRegistrationVo studentVo=new StudentRegistrationVo();
		
		try{
			
			studentVo=new StudentRegistrationDaoImpl().editStudent(registrationVo);
			
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : editStudent  Ending");
		return studentVo;
	}
	public List<registrationvo> StudentDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getStudentDetails  Starting");
		List<registrationvo> list = null;
		try {
			list = new StudentRegistrationDaoImpl().StudentDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationServiceImpl : getStudentDetails  Ending");
		// TODO Auto-generated method stub

		return list;
	}
}
