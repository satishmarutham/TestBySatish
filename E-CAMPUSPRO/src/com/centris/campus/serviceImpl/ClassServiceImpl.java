package com.centris.campus.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.ClassDao;
import com.centris.campus.daoImpl.ClassDaoImpl;
import com.centris.campus.forms.ClassForm;
import com.centris.campus.pojo.AcademicYearPojo;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.service.ClassService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.AcademicYearVO;

public class ClassServiceImpl implements ClassService{
	private static final Logger logger = Logger.getLogger(ClassServiceImpl.class);
	@Override
	public synchronized List<ClassPojo> getClassDetails() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassServiceImpl: getClassDetails Starting");
		
		List<ClassPojo> classList = new ArrayList<ClassPojo>();
		ClassDao classDao=new ClassDaoImpl();
		classList = classDao.getClassDetails();
		try {
			classList=classDao.getClassDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassServiceImpl: getClassDetails Ending");
		return classList;
	}
	
	@Override
	public synchronized List<ClassPojo> getStreamDetailService() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassStreamServiceImpl:getStreamDetailService  Starting");
		// TODO Auto-generated method stub
		List<ClassPojo> classPojoList = new ArrayList<ClassPojo>();
		ClassDao classDao=new ClassDaoImpl();
		
		try {
			classPojoList = classDao.getStreamDetailDao();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassStreamServiceImpl:getStreamDetailService Ending");
		return classPojoList;
	}
	
	public synchronized boolean createClass(ClassPojo classPojo,String createUser, String classcode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassServiceImpl : createAcademicYear  Starting");
		boolean status = false;
		ClassDao classDao=new ClassDaoImpl();
		try {

			status = classDao.createClass(classPojo,createUser,classcode);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassServiceImpl : createAcademicYear  Starting");
		return status;
	}
	
	public synchronized boolean classNameCheck(ClassPojo classPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassServiceImpl : accyearNameCheck  Starting");
		boolean status = false;
		ClassDao classDao=new ClassDaoImpl();
		try {

			status = classDao.classNameCheck(classPojo);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AcademicYearMasterServiceImpl : accyearNameCheck  Starting");
		return status;

	}
	
	public boolean updateclassNameCheck(ClassPojo classPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassServiceImpl : updateclassNameCheck  Starting");
		boolean status = false;
		ClassDao classDao=new ClassDaoImpl();
		try {

			status = classDao.classNameCheck(classPojo);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AcademicYearMasterServiceImpl : updateclassNameCheck  Starting");
		return status;

	}
	
	public synchronized ClassPojo editClass(String classCode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AcademicYearMasterServiceImpl : editAcademicYear  Starting");
		ClassPojo classDetails = null;
		ClassDao classDao=new ClassDaoImpl();
		try {

			classDetails = classDao.editClass(classCode);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AcademicYearMasterServiceImpl : editAcademicYear  Starting");
		return classDetails;
	}
	
	public synchronized boolean deleteClass(String classCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AcademicYearMasterServiceImpl : deleteAcademicYear  Starting");
		boolean status = false;
		ClassDao classDao=new ClassDaoImpl();
		try {

			status = classDao.deleteClass(classCode);
		

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AcademicYearMasterServiceImpl : deleteAcademicYear  Starting");
		return status;
	}
	
	public synchronized boolean updateClass(ClassPojo classPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AcademicYearMasterServiceImpl : updateAcademicYear  Starting");
		boolean status = false;
		ClassDao classDao=new ClassDaoImpl();
		try {

			status = classDao.updateClass(classPojo);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AcademicYearMasterServiceImpl : updateAcademicYear  Starting");
		return status;

	}
	
	@Override
	public synchronized List<ClassPojo> searchClassDetails(String searchText) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserServiceImpl :searchUserDetails Starting");
		List<ClassPojo> getCourseDetailsBySearchText=new ArrayList<ClassPojo>();
		ClassDao classDao=new ClassDaoImpl();
		try{
			getCourseDetailsBySearchText=classDao.searchClassDetails(searchText);
			
		}
		catch(Exception exception){
			exception.printStackTrace();
			
			logger.error(exception.getMessage(),exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserServiceImpl :searchUserDetails  Ending");
		return getCourseDetailsBySearchText;
	}

}
