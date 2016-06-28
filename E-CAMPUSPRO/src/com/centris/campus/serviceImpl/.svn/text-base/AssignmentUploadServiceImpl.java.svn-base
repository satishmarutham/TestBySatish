package com.centris.campus.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.AssignmentUploadDao;
import com.centris.campus.dao.FeeSetupDao;
import com.centris.campus.daoImpl.AssignmentUploadDaoImpl;
import com.centris.campus.daoImpl.FeeSetupDaoImpl;
import com.centris.campus.forms.AssignmentUploadForm;
import com.centris.campus.pojo.ConcessionDetailsPojo;
import com.centris.campus.service.AssignmentUploadService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.AssignmentUploadVo;

public class AssignmentUploadServiceImpl implements AssignmentUploadService{
	
	private static final Logger logger = Logger.getLogger(AssignmentUploadServiceImpl.class);

	public ArrayList<AssignmentUploadVo> getStudentDetails(String section) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: getStudentDetails Starting");
		
		AssignmentUploadDao assignmentDao=new AssignmentUploadDaoImpl();
		ArrayList<AssignmentUploadVo> studentList=new ArrayList<AssignmentUploadVo>();
		
		try {
			
			studentList = assignmentDao.getStudentDetails(section);
		
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: getStudentDetails Ending");
		
		return studentList;
	}

	@Override
	public String insertAssignment(AssignmentUploadForm form, String userId,String accYearString) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: insertAssignment Starting");
		
		AssignmentUploadDao assignmentDao=new AssignmentUploadDaoImpl();
		String status=null;
		
		try {
			
			status = assignmentDao.insertAssignment(form,userId,accYearString);
		
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: insertAssignment Ending");
		
		return status;
	}
	
	@Override
	public ArrayList<AssignmentUploadVo> getAssignment(String userId,String accYearString,String searchTerm) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: getAssignment Starting");
		
		AssignmentUploadDao assignmentDao=new AssignmentUploadDaoImpl();
		ArrayList<AssignmentUploadVo> assignmentList=new ArrayList<AssignmentUploadVo>();
		
		try {
			
			assignmentList = assignmentDao.getAssignment(userId,accYearString,searchTerm);
		
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: getAssignment Ending");
		
		return assignmentList;
	}

	@Override
	public ArrayList<AssignmentUploadVo> getAssignmentDetails(String assignmentId) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: getAssignmentDetails Starting");
		
		AssignmentUploadDao assignmentDao=new AssignmentUploadDaoImpl();
		ArrayList<AssignmentUploadVo> assignmentList=new ArrayList<AssignmentUploadVo>();
		
		try {
			
			assignmentList = assignmentDao.getAssignmentDetails(assignmentId);
		
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: getAssignmentDetails Ending");
		
		return assignmentList;
	}

	@Override
	public AssignmentUploadVo getSingleAssignment(String assignmentId) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: getSingleAssignment Starting");
		
		AssignmentUploadDao assignmentDao=new AssignmentUploadDaoImpl();
		AssignmentUploadVo assimentVo=new AssignmentUploadVo();
		
		try {
			
			assimentVo = assignmentDao.getSingleAssignment(assignmentId);
		
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: getSingleAssignment Ending");
		
		return assimentVo;
	}

	@Override
	public String updateAssignmentDetails(AssignmentUploadVo assignmentVo) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: updateAssignmentDetails Starting");
		
		AssignmentUploadDao assignmentDao=new AssignmentUploadDaoImpl();
		String status=null;
		
		try {
			
			status = assignmentDao.updateAssignmentDetails(assignmentVo);
		
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: updateAssignmentDetails Ending");
		
		return status;
	}

	@Override
	public String deleteAssignment(String assignmentCode) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: deleteAssignment Starting");
		
		AssignmentUploadDao assignmentDao=new AssignmentUploadDaoImpl();
		String status=null;
		
		try {
			
			status = assignmentDao.deleteAssignment(assignmentCode);
		
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AssignmentUploadServiceImpl: deleteAssignment Ending");
		
		return status;
	}

	
}
