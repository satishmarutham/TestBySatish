package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.StaffAttendanceDao;
import com.centris.campus.pojo.StaffAttendancePojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.StaffAttendanceSqlUtil;
import com.centris.campus.vo.StaffAttendanceVo;

public class StaffAttendanceDaoImpl implements StaffAttendanceDao{
	
	private static final Logger logger = Logger.getLogger(StaffAttendanceDaoImpl.class);

	
	public ArrayList<StaffAttendanceVo> getStaffAttendance(String date,String department) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in StaffAttendanceDaoImpl: getStaffAttendance : Starting");
			
			PreparedStatement ps_insertPlan = null;
			ResultSet rs=null;
			Connection conn = null;
			ArrayList<StaffAttendanceVo> staffAttendanceList=new ArrayList<StaffAttendanceVo>();
			int count=0;
			
			try {
				
				conn = JDBCConnection.getSeparateConnection();
			
				ps_insertPlan = conn.prepareStatement(StaffAttendanceSqlUtil.GET_STAFF_ATTENDANCE);
				
				ps_insertPlan.setString(1,date);
				ps_insertPlan.setString(2,department);
				
				System.out.println("get attendance ::: "+ps_insertPlan);
				
				rs=ps_insertPlan.executeQuery();
				
				while(rs.next()){
					
					count++;
					
					StaffAttendanceVo attendanceVo=new StaffAttendanceVo();
					
					attendanceVo.setCount(count);
					attendanceVo.setTeacherId(rs.getString("TeacherID"));
					attendanceVo.setRegid(rs.getString("registerId"));
					attendanceVo.setTeacherName(rs.getString("teacherName"));
					attendanceVo.setDesignation(rs.getString("designationName"));
					attendanceVo.setDepartment(rs.getString("DEPT_NAME"));
					attendanceVo.setStatus(rs.getString("status"));
					
					staffAttendanceList.add(attendanceVo);
					
				}
				
				
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (ps_insertPlan != null&& (!ps_insertPlan.isClosed())) {
						ps_insertPlan.close();
					}
					if (conn != null && (!conn.isClosed())) {
						conn.close();
					}
				} catch (SQLException sqle) {

					logger.error(sqle.getMessage(), sqle);
					sqle.printStackTrace();
				} catch (Exception e1) {

					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				}
			}

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in StaffAttendanceDaoImpl: getStaffAttendance: Ending");
			
			return staffAttendanceList;
		}


	
	public String updateAttendanceStatus(StaffAttendancePojo attPojo) {
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in StaffAttendanceDaoImpl: getStaffAttendance : Starting");
			
			PreparedStatement ps_count = null;
			PreparedStatement ps_insert = null;
			
			ResultSet rs=null;
			Connection conn = null;
			int count=0;
			
			int statuscount=0;
			
			String result=null;
			
			try {
				
				conn = JDBCConnection.getSeparateConnection();
			
				ps_count = conn.prepareStatement(StaffAttendanceSqlUtil.GET_ATTENDANCE_COUNT);
				
				String teacherId[]=attPojo.getTeacherId().split(",");
				String attaStatus[] =attPojo.getStatus().split(",");
				
				for(int i=0;i<teacherId.length;i++){
					
					ps_count.setString(1,teacherId[i]);
					ps_count.setString(2,HelperClass.convertUIToDatabase(attPojo.getDate()));
					
					rs=ps_count.executeQuery();
					
					while(rs.next()){
						
						count=rs.getInt(1);
					}
					
					if(count>0){
						
						ps_insert = conn.prepareStatement(StaffAttendanceSqlUtil.UPDATE_ATTENDANCE);
						ps_insert.setString(1, attaStatus[i]);
						ps_insert.setString(2, attPojo.getUserId());
						ps_insert.setTimestamp(3, HelperClass.getCurrentTimestamp());
						ps_insert.setString(4, teacherId[i]);
						ps_insert.setString(5, HelperClass.convertUIToDatabase(attPojo.getDate()));
						
						statuscount=ps_insert.executeUpdate();
						
						
					}else{
						
						ps_insert = conn.prepareStatement(StaffAttendanceSqlUtil.INSERT_ATTENDANCE);
						ps_insert.setString(1, teacherId[i]);
						ps_insert.setString(2, HelperClass.convertUIToDatabase(attPojo.getDate()));
						ps_insert.setString(3, attaStatus[i]);
						ps_insert.setString(4,"Y" );
						ps_insert.setString(5, attPojo.getUserId());
						ps_insert.setTimestamp(6, HelperClass.getCurrentTimestamp());
						
						statuscount=ps_insert.executeUpdate();
						
					}
				}
				
				if(statuscount>0){
					
					result="true";
				
				}else{
					
					result="false";
				}
				
				
				
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null&& (!rs.isClosed())) {
						rs.close();
					}
					if (ps_insert != null&& (!ps_insert.isClosed())) {
						ps_insert.close();
					}
					if (conn != null && (!conn.isClosed())) {
						conn.close();
					}
				} catch (SQLException sqle) {

					logger.error(sqle.getMessage(), sqle);
					sqle.printStackTrace();
				} catch (Exception e1) {

					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				}
			}

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in StaffAttendanceDaoImpl: getStaffAttendance: Ending");
			
			return result;
		}
	
	
	
	public ArrayList<StaffAttendanceVo> getStaffAttendanceList(String startdate,String enddate) {
		   
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceDaoImpl: getStaffAttendanceList : Starting");
		
		PreparedStatement ps_insertPlan = null;
		ResultSet rs=null;
		Connection conn = null;
		ArrayList<StaffAttendanceVo> staffAttendanceList=new ArrayList<StaffAttendanceVo>();
		int count=0;
		
		try {
			
			conn = JDBCConnection.getSeparateConnection();
			String todayDate=null;
			String startDate=null;
			
			if(startdate==null || "".equalsIgnoreCase(startdate) && enddate==null || "".equalsIgnoreCase(enddate)){
				
			 todayDate=HelperClass.getCurrentSqlDate().toString();
			 startDate=HelperClass.getLastThirtyDateFromNow(todayDate);
			
			}else{
				
				 todayDate=HelperClass.convertUIToDatabase(enddate);
				 startDate=HelperClass.convertUIToDatabase(startdate);
				
			}
			
			
			ps_insertPlan = conn.prepareStatement(StaffAttendanceSqlUtil.GET_ATTENDANCE_LIST);
			
			
			ps_insertPlan.setString(1,startDate);
			ps_insertPlan.setString(2,todayDate);
			
			System.out.println("get attendance ::: "+ps_insertPlan);
			
			rs=ps_insertPlan.executeQuery();
			
			while(rs.next()){
				
				count++;
				
				StaffAttendanceVo attendanceVo=new StaffAttendanceVo();
				
				attendanceVo.setCount(count);
				attendanceVo.setDate(HelperClass.convertDatabaseToUI(rs.getString("AttendenceDate")));
				attendanceVo.setTot_count(rs.getString("total_streangth"));
				attendanceVo.setAbsent_count(rs.getString("TotalAbsent"));
				attendanceVo.setPresent_count(rs.getString("TotalPresent"));
				attendanceVo.setHoliday_count(rs.getString("TotalHoliday"));
				attendanceVo.setLeave_count(rs.getString("Totalleave"));
				
				staffAttendanceList.add(attendanceVo);
				
			}
			
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {
				if (rs != null&& (!rs.isClosed())) {
					rs.close();
				}
				if (ps_insertPlan != null&& (!ps_insertPlan.isClosed())) {
					ps_insertPlan.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (SQLException sqle) {

				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {

				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffAttendanceDaoImpl: getStaffAttendanceList: Ending");
		
		return staffAttendanceList;
	}


}
