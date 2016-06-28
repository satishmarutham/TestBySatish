package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.StaffAttendanceReportDao;
import com.centris.campus.forms.ReportMenuForm;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.ReportsMenuSqlConstants;
import com.centris.campus.vo.AllTeacherDetailsVo;
import com.centris.campus.vo.ReportMenuVo;
import com.centris.campus.vo.StaffAttendanceVo;
import com.centris.campus.vo.StudentInfoVO;

public class StaffAttendanceReportDaoImpl implements StaffAttendanceReportDao {

	
	private static final Logger logger = Logger
			.getLogger(StaffAttendanceReportDaoImpl.class);
	
	
	
	public ReportMenuVo getSelectedItemsDaoImpl(String acc) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getSelectedItemsDaoImpl Starting");
		
		
		
		ReportMenuVo selecteditems=new ReportMenuVo();

		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection conn = null;
		
	
		
		int count=0; 
		
		try {
			
			conn = JDBCConnection.getSeparateConnection();
			
			pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_STAFF_ATTENDANCE_ITEMS);
			
			
			pstmt.setString(1, acc);
			
			
			
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				
			
				
				selecteditems.setAccyearname(rs.getString("acadamic_year"));
				selecteditems.setAccyearId(rs.getString("acadamic_id"));
				
				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getSelectedItemsDaoImpl Ending");
		
		return selecteditems;
	}




	public ArrayList<StaffAttendanceVo> getStaffAttendanceReportDaoImpl(ReportMenuVo vo) {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getStaffAttendanceReportDaoImpl Starting");
		
		
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection conn = null;
		ArrayList<StaffAttendanceVo> attendList=new ArrayList<StaffAttendanceVo>();
		int count=0;
		
		
		
		try {
			
			conn = JDBCConnection.getSeparateConnection();
			
			
			if(vo.getTeachertype().contains("nonteaching")){
				
				
			
				pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_NON_TEACHINGTYPE_LIST);
				
			
				
				pstmt.setString(1, vo.getFromdate());
				pstmt.setString(2, vo.getTodate());
				pstmt.setString(3, vo.getTeachertId());
				
				
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					
					StaffAttendanceVo attvo = new StaffAttendanceVo();
					
					
					count++;
					attvo.setCount(count);
					attvo.setTeacherName(rs.getString("teachername"));
					attvo.setDate(HelperClass.convertDatabaseToUI(rs.getString("AttendenceDate")));
					
					attvo.setStatus(rs.getString("AttendenceStatus"));
					
				
					
					
					attendList.add(attvo);
					
					
				}
			}
			
			else{
				
				pstmt = conn.prepareStatement(ReportsMenuSqlConstants.GET_TEACHINGTYPE_LIST);
				
				pstmt.setString(1, vo.getFromdate());
				pstmt.setString(2, vo.getTodate());
				pstmt.setString(3, vo.getTeachertId());
				
				
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					
					
					StaffAttendanceVo attvo = new StaffAttendanceVo();
					
					
					count++;
					attvo.setCount(count);
					attvo.setTeacherName(rs.getString("teachername"));
					attvo.setDate(HelperClass.convertDatabaseToUI(rs.getString("AttendenceDate")));
					
					attvo.setStatus(rs.getString("AttendenceStatus"));
					
					
					
					attendList.add(attvo);
					
				}
				
				
			}
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getStaffAttendanceReportDaoImpl Ending");
		
		return attendList;
	}





	public ArrayList<AllTeacherDetailsVo> getTeachingListDaoImpl(
			AllTeacherDetailsVo vo) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getTeachingListDaoImpl Starting");
		
		ArrayList<AllTeacherDetailsVo> teachinglist = new ArrayList<AllTeacherDetailsVo>();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection conn = null;
		
		try {
			
			
			conn = JDBCConnection.getSeparateConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(ReportsMenuSqlConstants.GET_STAFF_TEACHING_LIST);
			
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				AllTeacherDetailsVo teavo = new AllTeacherDetailsVo();
				
				teavo.setTeacherId(rs.getString("TeacherID"));
				teavo.setTeacherName(rs.getString("teachername"));
				
				
				
				teachinglist.add(teavo);
			}
			
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getTeachingListDaoImpl Ending");
		
		return teachinglist;
	}




	
	public ArrayList<AllTeacherDetailsVo> getNonTeachingListDaoImpl(
			AllTeacherDetailsVo vo) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getNonTeachingListDaoImpl Starting");
		
		ArrayList<AllTeacherDetailsVo> teachinglist = new ArrayList<AllTeacherDetailsVo>();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection conn = null;
		
		try {
			
			
			conn = JDBCConnection.getSeparateConnection();
			
			pstmt = (PreparedStatement) conn.prepareStatement(ReportsMenuSqlConstants.GET_STAFF_NON_TEACHING_LIST);
		
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				AllTeacherDetailsVo teavo = new AllTeacherDetailsVo();
				
				teavo.setTeacherId(rs.getString("TeacherID"));
				teavo.setTeacherName(rs.getString("teachername"));
				
				
				
				teachinglist.add(teavo);
			}
			
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getNonTeachingListDaoImpl Ending");
		
		return teachinglist;
	}




	
	public StaffAttendanceVo getSelectedTeacherNameReportDao(ReportMenuVo vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getSelectedTeacherNameReportDao Starting");
		
		StaffAttendanceVo staffname = new StaffAttendanceVo();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection conn = null;
		
		try {
			
			
			conn = JDBCConnection.getSeparateConnection();
			
         pstmt = (PreparedStatement) conn.prepareStatement(ReportsMenuSqlConstants.TEACHER_NAMES);
		
         pstmt.setString(1, vo.getTeachertId());
         
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				
				

				staffname.setTeacherId(rs.getString("TeacherID"));
				staffname.setTeacherName(rs.getString("teachername"));
				
				
			}
			
			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceReportDaoImpl : getSelectedTeacherNameReportDao Ending");
		
		return staffname;
	}

}
