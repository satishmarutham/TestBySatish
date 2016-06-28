package com.centris.campus.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.ReportsMenuDao;
import com.centris.campus.daoImpl.ReportsMenuDaoImpl;
import com.centris.campus.forms.ReportMenuForm;
import com.centris.campus.pojo.FeeStatusReportPojo;
import com.centris.campus.pojo.MarksPOJO;
import com.centris.campus.service.ReportsMenuService;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.FeeReportDetailsVo;
import com.centris.campus.vo.MarksUploadVO;
import com.centris.campus.vo.ReportMenuVo;
import com.centris.campus.vo.StudentInfoVO;

public class ReportsMenuServiceImpl implements ReportsMenuService{
	
	private static final Logger logger = Logger.getLogger(ReportsMenuServiceImpl.class);


	@Override
	public ArrayList<ReportMenuVo> getAccYears() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getAccYears Starting");
		ArrayList<ReportMenuVo> yearList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			yearList = dao.getAccYears();
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getAccYears Ending");
		
		return yearList;
	}



	@Override
	public ArrayList<ReportMenuVo> getStream() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStream Starting");
		ArrayList<ReportMenuVo> streamList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			streamList = dao.getStream();
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStream Ending");
		
		return streamList;
	}



	@Override
	public ArrayList<ReportMenuVo> getClassesByStream(String streamId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getClassesByStream Starting");
		ArrayList<ReportMenuVo> classList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			classList = dao.getClassesByStream(streamId);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getClassesByStream Ending");
		
		return classList;
	}



	@Override
	public ArrayList<ReportMenuVo> getSectionsByClass(String classId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getSectionsByClass Starting");
		ArrayList<ReportMenuVo> sectionList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			sectionList = dao.getSectionsByClass(classId);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getSectionsByClass Ending");
		
		return sectionList;
	}



	@Override
	public ArrayList<StudentInfoVO> getStudentDetailsReport(ReportMenuForm reform) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStudentDetailsReport Starting");
		
		ArrayList<StudentInfoVO> studentIfoList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			studentIfoList=dao.getStudentDetailsReport(reform);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStudentDetailsReport Ending");
		
		return studentIfoList;
	}
	
	public ReportMenuVo  getSelectedItems(ReportMenuForm reform){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getSelectedItems Starting");
		
		ReportMenuVo selected = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			selected=dao.getSelectedItems(reform);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getSelectedItems Ending");
		
		return selected;
	}



	@Override
	public HashMap<String, ArrayList<FeeReportDetailsVo>> getStdFeeStatusReportDetails(ReportMenuForm reform) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStdFeeStatusReportDetails Starting");
		
		HashMap<String, ArrayList<FeeReportDetailsVo>> feeStatusList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			feeStatusList=dao.getStdFeeStatusReportDetails(reform);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStdFeeStatusReportDetails Ending");
		
		return feeStatusList;
	}
	
	@Override
	public ArrayList<FeeReportDetailsVo> getStdFeeStatusReportDownload(FeeStatusReportPojo reform) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStdFeeStatusReportDetails Starting");
		
		ArrayList<FeeReportDetailsVo> feeStatusList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			feeStatusList=dao.getStdFeeStatusReportDownload(reform);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStdFeeStatusReportDetails Ending");
		
		return feeStatusList;
	}



	@Override
	public HashMap<String, ArrayList<MarksUploadVO>> getStdMarksDetails(ReportMenuForm reform) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStdMarksDetails Starting");
		
		HashMap<String, ArrayList<MarksUploadVO>> marksList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			marksList=dao.getStdMarksDetails(reform);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStdMarksDetails Ending");
		
		return marksList;
	}



	@Override
	public ArrayList<MarksUploadVO> getStdMarksDetailsDownload(MarksPOJO reform) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStdMarksDetailsDownload Starting");
		
		ArrayList<MarksUploadVO> marksList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			marksList=dao.getStdMarksDetailsDownload(reform);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : getStdMarksDetailsDownload Ending");
		
		return marksList;
	}



	@Override
	public ArrayList<ExaminationDetailsVo> examReportClassWiseDetails(ReportMenuForm reform) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : examReportClassWiseDetails Starting");
		
		ArrayList<ExaminationDetailsVo> examList = null;
		ReportsMenuDao dao = new ReportsMenuDaoImpl();
		try {
			
			examList=dao.examReportClassWiseDetails(reform);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsMenuServiceImpl : examReportClassWiseDetails Ending");
		
		return examList;
	}

}
