package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.StaffServiceReportDao;
import com.centris.campus.pojo.TeacherRegistrationPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.ReportsMenuSqlConstants;
import com.centris.campus.util.SQLUtilConstants;
import com.centris.campus.vo.NonBoardSalaryvo;
import com.centris.campus.vo.PayCertificateReportVO;

public class StaffServiceReportDaoImpl implements StaffServiceReportDao{
	
	private static final Logger logger = Logger.getLogger(StaffServiceReportDaoImpl.class);


	public ArrayList<TeacherRegistrationPojo> getTeacherListDetailsDao() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffServiceReportDaoImpl : StaffServiceReportDaoImpl Starting");
		

		ArrayList<TeacherRegistrationPojo> teacherlist = new ArrayList<TeacherRegistrationPojo>();
		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ReportsMenuSqlConstants.GET_TEACHER_DETAILS);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				TeacherRegistrationPojo teapojo = new TeacherRegistrationPojo();
				teapojo.setTeacherId(rs.getString("TeacherID"));
				teapojo.setTfastname(rs.getString("teachername"));
				
				teacherlist.add(teapojo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffServiceReportDaoImpl : StaffServiceReportDaoImpl Ending");
		
		return teacherlist;
	}

	public ArrayList<TeacherRegistrationPojo> getTeacherDetailReportDao(
			TeacherRegistrationPojo teacherpojo) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffServiceReportDaoImpl : getTeacherDetailReportDao Starting");
		
		
		ArrayList<TeacherRegistrationPojo> teacherlist = new ArrayList<TeacherRegistrationPojo>();
		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = JDBCConnection.getSeparateConnection();
			
			pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_TEACHER_DETAILS_BY_ID);

			pstmt.setString(1, teacherpojo.getTeacherId());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				TeacherRegistrationPojo pojo = new TeacherRegistrationPojo();
				
				pojo.setTeacherId(rs.getString("TeacherID"));
				pojo.setTfastname(rs.getString("teachername"));
				pojo.setJoiningdate(HelperClass.convertDatabaseToUI(rs.getString("dateofJoining")));
				pojo.setDesignation(rs.getString("designationName"));
				
				teacherlist.add(pojo);
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffServiceReportDaoImpl : getTeacherDetailReportDao Ending");
		
		return teacherlist;
	}

	public ArrayList<PayCertificateReportVO> getTeacherPayDetailsReportDao(
			String year, String month, String teachername) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffServiceReportDaoImpl : getTeacherPayDetailsReportDao Starting");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
	
		ArrayList<PayCertificateReportVO> teacherpaycertificatelist= new ArrayList<PayCertificateReportVO>();
		
		try {
			
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_TEACHER_PAYCERTIFICATE);
			
			pstmt.setString(1, teachername);
			pstmt.setString(2,month);
			pstmt.setString(3,year);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				PayCertificateReportVO paytVO =new PayCertificateReportVO();
				
				paytVO.setTeacherid(rs.getString("TeacherID"));
				paytVO.setTeachername(rs.getString("teachername"));
				paytVO.setDesignation(rs.getString("designationName"));
				paytVO.setNetsalary(rs.getFloat("Net_Salary"));
				paytVO.setLop(rs.getFloat("Leave_Deductions"));
				paytVO.setTotaldeductions(rs.getFloat("Total_Deductions"));
				paytVO.setGrosssalary(rs.getFloat("GrossSalary"));
				paytVO.setPayamount(rs.getDouble("CTC"));
				paytVO.setPf(rs.getFloat("Employee_Pf"));
				
				
				teacherpaycertificatelist.add(paytVO);
				
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffServiceReportDaoImpl : getTeacherPayDetailsReportDao Ending");
		
		
		return teacherpaycertificatelist;
	}


}
