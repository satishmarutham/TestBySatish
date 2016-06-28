package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.dao.TimeTableDao;
import com.centris.campus.pojo.TeacherTimeTablePojo;
import com.centris.campus.pojo.TimeTablePojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.TimeTableSqlConstants;
import com.centris.campus.vo.TeacherTimeTableVo;
import com.centris.campus.vo.TimeTableVo;

public class TimeTableDaoImpl implements TimeTableDao {
	private static final Logger logger = Logger
			.getLogger(TimeTableDaoImpl.class);

	@Override
	public synchronized ArrayList<TimeTableVo> getTimeTableDetails(String timetableId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getTimeTableDetails Starting");

		ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		
		PreparedStatement pstmt1 = null;
		ResultSet rst1 = null;
		
		int count = 0;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection.prepareStatement(TimeTableSqlConstants.TIMETABLE_DETAILS_COUNT);
			pstmt.setString(1, timetableId.trim());
			rst = pstmt.executeQuery();

			while (rst.next()) {
				count = rst.getInt(1);
			}
			
			System.out.println("count ::: "+count);
			
			if (count > 0) {
				pstmt1 = connection.prepareStatement(TimeTableSqlConstants.TIMETABLE_GET_DETAILS);
				pstmt1.setString(1, timetableId.trim());
				
				System.out.println("get time table :: "+pstmt1);
				
				rst1 = pstmt1.executeQuery();
				
				
				System.out.println(rst1.getFetchSize());

				while(rst1.next()) {
					
					TimeTableVo voObj = new TimeTableVo();
					voObj.setDayid(rst1.getString("daycode"));
					voObj.setDayname(rst1.getString("dayname"));
					voObj.setPeriodId1(rst1.getString("period1"));
					voObj.setPeriodId2(rst1.getString("period2"));
					voObj.setPeriodId3(rst1.getString("period3"));
					voObj.setPeriodId4(rst1.getString("period4"));
					voObj.setPeriodId5(rst1.getString("period5"));
					voObj.setPeriodId6(rst1.getString("period6"));
					voObj.setPeriodId7(rst1.getString("period7"));
					voObj.setPeriodId8(rst1.getString("period8"));
					System.out.println(getSubjectfName(rst1.getString("period1")));
					voObj.setPeriod1(getSubjectfName(rst1.getString("period1")));
					voObj.setPeriod2(getSubjectfName(rst1.getString("period2")));
					voObj.setPeriod3(getSubjectfName(rst1.getString("period3")));
					voObj.setPeriod4(getSubjectfName(rst1.getString("period4")));
					voObj.setPeriod5(getSubjectfName(rst1.getString("period5")));
					voObj.setPeriod6(getSubjectfName(rst1.getString("period6")));
					voObj.setPeriod7(getSubjectfName(rst1.getString("period7")));
					voObj.setPeriod8(getSubjectfName(rst1.getString("period8")));
					details.add(voObj);
				}
			} else {

				pstmt1 = connection.prepareStatement(TimeTableSqlConstants.TIMETABLE_GET_DAYS);
				
				
				rst1 = pstmt1.executeQuery();
				System.out.println("if time table not created :: "+pstmt1);
				while (rst1.next()) {
					TimeTableVo voObj = new TimeTableVo();
					voObj.setDayid(rst1.getString("daycode"));
					voObj.setDayname(rst1.getString("dayname"));
					voObj.setPeriod1("");
					voObj.setPeriod2("");
					voObj.setPeriod3("");
					voObj.setPeriod4("");
					voObj.setPeriod5("");
					voObj.setPeriod6("");
					voObj.setPeriod7("");
					voObj.setPeriod8("");
					voObj.setPeriodId1("");
					voObj.setPeriodId2("");
					voObj.setPeriodId3("");
					voObj.setPeriodId4("");
					voObj.setPeriodId5("");
					voObj.setPeriodId6("");
					voObj.setPeriodId7("");
					voObj.setPeriodId8("");
					details.add(voObj);
				}
			}
		}catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} 
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getTimeTableDetails Ending");
		return details;
	}

	@Override
	public synchronized ArrayList<TimeTableVo> getClassName() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getClassName Starting");

		ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TimeTableSqlConstants.TIMETABLE_GET_CLASSID);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				TimeTableVo voobj = new TimeTableVo();
				voobj.setClassid(rst.getString("classdetail_id_int").trim());
				voobj.setClassname(rst.getString("classdetails_name_var")
						.trim());
				details.add(voobj);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getClassName Ending");
		return details;
	}

	@Override
	public synchronized ArrayList<TimeTableVo> getSectionName(String classid) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getSectionName Starting");
		ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection
					.prepareStatement(TimeTableSqlConstants.TIMETABLE_GET_SECTIONID);
			pstmt.setString(1, classid.trim());
			rst = pstmt.executeQuery();
			while (rst.next()) {
				TimeTableVo voobj = new TimeTableVo();
				voobj.setSectionid(rst.getString("classsection_id_int"));
				voobj.setSectionname(rst.getString("classsection_name_var"));
				details.add(voobj);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getSectionName Ending");
		return details;
	}

	@Override
	public String updateTimeTableDetails(TimeTablePojo pojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : updateTimeTableDetails Starting");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst = null;
		String result = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			
			System.out.println("timetable Id :: "+pojo.getTimetableID());
			
			if ("-".equals(pojo.getTimetableID())) {
			
				String tableId = IDGenerator.getPrimaryKeyID("campus_timetable_student");
				pstmt = connection.prepareStatement(TimeTableSqlConstants.TIMETABLE_DETAILS_INSERT);
				
				pstmt.setString(1, tableId);
				pstmt.setString(2, pojo.getClassid().trim());
				pstmt.setString(3, pojo.getSectionid().trim());
				pstmt.setString(4, pojo.getAccyearid().trim());
				pstmt.setString(5, HelperClass.getCurrentSqlDate() + " "+ HelperClass.getCurrentTime());
				pstmt.setString(6, pojo.getUserid());
				
				int status = pstmt.executeUpdate();

				if (status > 0) {

					for (int i = 0; i < pojo.getDayid().length; i++) {

						pstmt1 = connection.prepareStatement(TimeTableSqlConstants.TIMETABLE_DETAILS_INSERTDETAILS);
						pstmt1.setString(1, tableId);
						pstmt1.setString(2, pojo.getDayid()[i]);
						pstmt1.setString(3, pojo.getPeriod1()[i]);
						pstmt1.setString(4, pojo.getPeriod2()[i]);
						pstmt1.setString(5, pojo.getPeriod3()[i]);
						pstmt1.setString(6, pojo.getPeriod4()[i]);
						pstmt1.setString(7, pojo.getPeriod5()[i]);
						pstmt1.setString(8, pojo.getPeriod6()[i]);
						pstmt1.setString(9, pojo.getPeriod7()[i]);
						pstmt1.setString(10, pojo.getPeriod8()[i]);
						pstmt1.executeUpdate();
					}
					result = "success";
					
				} else {
					
						result = "fail";
					
				}
			} else {
				
				pstmt = connection.prepareStatement(TimeTableSqlConstants.TIMETABLE_DETAILS_DELETE);
				pstmt.setString(1, pojo.getTimetableID().trim());
				
				System.out.println("delete time table :: "+pstmt);
				
				int status = pstmt.executeUpdate();
				
				if (status > 0) {

					for (int i = 0; i < pojo.getDayid().length; i++) {

						pstmt1 = connection.prepareStatement(TimeTableSqlConstants.TIMETABLE_DETAILS_INSERTDETAILS);
					
						pstmt1.setString(1, pojo.getTimetableID());
						pstmt1.setString(2, pojo.getDayid()[i]);
						pstmt1.setString(3, pojo.getPeriod1()[i]);
						pstmt1.setString(4, pojo.getPeriod2()[i]);
						pstmt1.setString(5, pojo.getPeriod3()[i]);
						pstmt1.setString(6, pojo.getPeriod4()[i]);
						pstmt1.setString(7, pojo.getPeriod5()[i]);
						pstmt1.setString(8, pojo.getPeriod6()[i]);
						pstmt1.setString(9, pojo.getPeriod7()[i]);
						pstmt1.setString(10, pojo.getPeriod8()[i]);
						pstmt1.executeUpdate();
					}
						result = "success";
					
				} else {
						result = "fail";
					
				}
				
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (pstmt1 != null && (!pstmt1.isClosed())) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : updateTimeTableDetails Ending");

		return result;
	}

	@Override
	public synchronized ArrayList<TimeTableVo> getTeacherTimeTableDetails(String teacherid, String accyearid) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getTeacherTimeTableDetails Starting");

		ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		int count = 0;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection.prepareStatement(TimeTableSqlConstants.TEACHER_TIMETABLE_DETAILS_COUNT);
			pstmt.setString(1, teacherid.trim());
			pstmt.setString(2, accyearid.trim());
			rst = pstmt.executeQuery();
			
			System.out.println("count ::: "+pstmt);
			
			while (rst.next()) {
				count = rst.getInt(1);
			}
			if (count > 0) {
				pstmt = connection.prepareStatement(TimeTableSqlConstants.TEACHER_TIMETABLE_GET_DETAILS);
				pstmt.setString(1, teacherid.trim());
				pstmt.setString(2, accyearid.trim());
				
				System.out.println("if exist get details :::: "+pstmt);
				rst = pstmt.executeQuery();

				while (rst.next()) {
					TimeTableVo voObj = new TimeTableVo();
					voObj.setDayid(rst.getString("daycode"));
					voObj.setDayname(rst.getString("dayname"));
					voObj.setPeriodId1(rst.getString("period1"));
					voObj.setPeriodId2(rst.getString("period2"));
					voObj.setPeriodId3(rst.getString("period3"));
					voObj.setPeriodId4(rst.getString("period4"));
					voObj.setPeriodId5(rst.getString("period5"));
					voObj.setPeriodId6(rst.getString("period6"));
					voObj.setPeriodId7(rst.getString("period7"));
					voObj.setPeriodId8(rst.getString("period8"));
					System.out.println(getSubjectfName(rst.getString("period1")));
					voObj.setPeriod1(getSubjectfName(rst.getString("period1")));
					voObj.setPeriod2(getSubjectfName(rst.getString("period2")));
					voObj.setPeriod3(getSubjectfName(rst.getString("period3")));
					voObj.setPeriod4(getSubjectfName(rst.getString("period4")));
					voObj.setPeriod5(getSubjectfName(rst.getString("period5")));
					voObj.setPeriod6(getSubjectfName(rst.getString("period6")));
					voObj.setPeriod7(getSubjectfName(rst.getString("period7")));
					voObj.setPeriod8(getSubjectfName(rst.getString("period8")));
					details.add(voObj);
				}
			} else {

				pstmt = connection.prepareStatement(TimeTableSqlConstants.TEACHER_TIMETABLE_GET_DAYS);
				
				System.out.println("if not exist get days :::: "+pstmt);
				
				rst = pstmt.executeQuery();
				while (rst.next()) {
					TimeTableVo voObj = new TimeTableVo();
					voObj.setDayid(rst.getString("daycode"));
					voObj.setDayname(rst.getString("dayname"));
					voObj.setPeriod1("");
					voObj.setPeriod2("");
					voObj.setPeriod3("");
					voObj.setPeriod4("");
					voObj.setPeriod5("");
					voObj.setPeriod6("");
					voObj.setPeriod7("");
					voObj.setPeriod8("");
					voObj.setPeriodId1("");
					voObj.setPeriodId2("");
					voObj.setPeriodId3("");
					voObj.setPeriodId4("");
					voObj.setPeriodId5("");
					voObj.setPeriodId6("");
					voObj.setPeriodId7("");
					voObj.setPeriodId8("");
					details.add(voObj);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getTeacherTimeTableDetails Ending");
		return details;
	}

	public synchronized ArrayList<TeacherTimeTableVo> getTeacherName() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getTeacherName Starting");

		ArrayList<TeacherTimeTableVo> details = new ArrayList<TeacherTimeTableVo>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(TimeTableSqlConstants.TEACHER_IDANDNAME);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				TeacherTimeTableVo voobj = new TeacherTimeTableVo();
				voobj.setTeacherId(rst.getString("TeacherID").trim());
				voobj.setTeacherName(rst.getString("TeacherName").trim());
				details.add(voobj);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getTeacherName Ending");
		return details;
	}

	@Override
	public String updateTeacherTimeTableDetails(TeacherTimeTablePojo pojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : updateTeacherTimeTableDetails Starting");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst = null;
		String result = "fail";
		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			int count = 0;
			pstmt = connection
					.prepareStatement(TimeTableSqlConstants.TEACHER_TIMETABLE_DETAILS_UPDATECOUNT);
			pstmt.setString(1, pojo.getTeacherid().trim());
			pstmt.setString(2, pojo.getAccyearid().trim());
			
			System.out.println("update count ::: "+pstmt);
			
			rst = pstmt.executeQuery();
			while (rst.next()) {
				count = rst.getInt(1);
			}
			if (count == 0) {
				String tableId = IDGenerator.getPrimaryKeyID("campus_timetable_teacher");
				pstmt = connection.prepareStatement(TimeTableSqlConstants.TEACHER_TIMETABLE_DETAILS_INSERT);
				pstmt.setString(1, tableId);
				pstmt.setString(2, pojo.getTeacherid().trim());
				pstmt.setString(3, pojo.getAccyearid().trim());
				pstmt.setString(4, HelperClass.getCurrentSqlDate() + " "
						+ HelperClass.getCurrentTime());
				pstmt.setString(5, pojo.getUserid());
				
				System.out.println("insert 1st table :: "+pstmt);
				
				int status = pstmt.executeUpdate();

				if (status > 0) {

					for (int i = 0; i < pojo.getDayid().length; i++) {

						pstmt1 = connection
								.prepareStatement(TimeTableSqlConstants.TEACHER_TIMETABLE_DETAILS_INSERTDETAILS);
						pstmt1.setString(1, tableId);
						pstmt1.setString(2, pojo.getDayid()[i]);
						pstmt1.setString(3, pojo.getPeriod1()[i]);
						pstmt1.setString(4, pojo.getPeriod2()[i]);
						pstmt1.setString(5, pojo.getPeriod3()[i]);
						pstmt1.setString(6, pojo.getPeriod4()[i]);
						pstmt1.setString(7, pojo.getPeriod5()[i]);
						pstmt1.setString(8, pojo.getPeriod6()[i]);
						pstmt1.setString(9, pojo.getPeriod7()[i]);
						pstmt1.setString(10, pojo.getPeriod8()[i]);
						
						System.out.println("insert into sectond table ::: "+pstmt1);
						
						pstmt1.executeUpdate();
					}
					
				result = "success";
					
				}
			} else {
				String exist_id = null;
				pstmt = connection
						.prepareStatement(TimeTableSqlConstants.TEACHER_TIMETABLE_DETAILS_ID);
				pstmt.setString(1, pojo.getTeacherid().trim());
				pstmt.setString(2, pojo.getAccyearid().trim());
				rst = pstmt.executeQuery();
				while (rst.next()) {
					exist_id = rst.getString("teachertimetable_id");
				}

				pstmt = connection
						.prepareStatement(TimeTableSqlConstants.TEACHER_TIMETABLE_DETAILS_DELETE);
				pstmt.setString(1, pojo.getTeacherid().trim());
				pstmt.setString(2, pojo.getAccyearid().trim());
				int status = pstmt.executeUpdate();
				if (status > 0) {

					for (int i = 0; i < pojo.getDayid().length; i++) {

						pstmt1 = connection
								.prepareStatement(TimeTableSqlConstants.TEACHER_TIMETABLE_DETAILS_INSERTDETAILS);
						pstmt1.setString(1, exist_id);
						pstmt1.setString(2, pojo.getDayid()[i]);
						pstmt1.setString(3, pojo.getPeriod1()[i]);
						pstmt1.setString(4, pojo.getPeriod2()[i]);
						pstmt1.setString(5, pojo.getPeriod3()[i]);
						pstmt1.setString(6, pojo.getPeriod4()[i]);
						pstmt1.setString(7, pojo.getPeriod5()[i]);
						pstmt1.setString(8, pojo.getPeriod6()[i]);
						pstmt1.setString(9, pojo.getPeriod7()[i]);
						pstmt1.setString(10, pojo.getPeriod8()[i]);
						pstmt1.executeUpdate();
					}
					
						result = "success";
					
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : updateTeacherTimeTableDetails Ending");

		return result;
	}

	@Override
	public ArrayList<TimeTableVo> getClassTimeTableList(String accyearid,String viewBy) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getTimeTableDetails Starting");

		ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection connection = null;
		
		try {
			connection = JDBCConnection.getSeparateConnection();
			
			if(viewBy.equalsIgnoreCase("class")){

			pstmt = connection.prepareStatement(TimeTableSqlConstants.GET_CLASS_TIMETABLE_LIST);
			pstmt.setString(1, accyearid.trim());
			
			rst = pstmt.executeQuery();

				while (rst.next()) {
					
					TimeTableVo voObj = new TimeTableVo();
					
					if(rst.getString("timetable_id")==null || "".equalsIgnoreCase(rst.getString("timetable_id"))){
						
						voObj.setClassid(rst.getString("classdetail_id_int"));
						voObj.setClassname(rst.getString("classdetails_name_var"));
						voObj.setSectionid(rst.getString("classsection_id_int"));
						voObj.setSectionname(rst.getString("classsection_name_var"));
						voObj.setTimetableStatus("Yet to Create");
						voObj.setCreatedby("-");
						voObj.setCreateddate("-");
						voObj.setLastupdatedby("-");
						voObj.setLastupdated("-");
						voObj.setTimetableId("-");
						
					}else{
						
						voObj.setClassid(rst.getString("classdetail_id_int"));
						voObj.setClassname(rst.getString("classdetails_name_var"));
						voObj.setSectionid(rst.getString("classsection_id_int"));
						voObj.setSectionname(rst.getString("classsection_name_var"));
						voObj.setTimetableStatus("Created");
						voObj.setCreatedby(getStaffName(rst.getString("created_by")));
						voObj.setCreateddate(rst.getString("created_date"));
						if(rst.getString("updated_by")==null || "".equalsIgnoreCase(rst.getString("updated_by"))){
							
							voObj.setLastupdatedby("-");
							voObj.setLastupdated("-");
					
						}else{
							
							voObj.setLastupdatedby(getStaffName(rst.getString("updated_by")));
							voObj.setLastupdated(rst.getString("updated_time"));
						}
						
						voObj.setTimetableId(rst.getString("timetable_id"));
					
					}
					details.add(voObj);
				}
			
			}else{

				pstmt = connection.prepareStatement(TimeTableSqlConstants.GET_TEACHER_TIMETABLE_LIST);
				pstmt.setString(1, accyearid.trim());
				
				rst = pstmt.executeQuery();

					while (rst.next()) {
						
						TimeTableVo voObj = new TimeTableVo();
						
						if(rst.getString("teachertimetable_id")==null || "".equalsIgnoreCase(rst.getString("teachertimetable_id"))){
							
							voObj.setTeacherId(rst.getString("TeacherID"));
							voObj.setRegno(rst.getString("registerId"));
							voObj.setTeachername(rst.getString("teachername"));
							voObj.setTimetableStatus("Yet to Create");
							voObj.setCreatedby("-");
							voObj.setCreateddate("-");
							voObj.setLastupdatedby("-");
							voObj.setLastupdated("-");
							voObj.setTimetableId("-");
							
						}else{
							
							voObj.setTeacherId(rst.getString("TeacherID"));
							voObj.setRegno(rst.getString("registerId"));
							voObj.setTeachername(rst.getString("teachername"));
							voObj.setTimetableStatus("Created");
							voObj.setCreatedby(getStaffName(rst.getString("created_by")));
							voObj.setCreateddate(rst.getString("created_date"));
							if(rst.getString("updated_date")==null || "".equalsIgnoreCase(rst.getString("updated_date"))){
								
								voObj.setLastupdatedby("-");
								voObj.setLastupdated("-");
						
							}else{
								
								voObj.setLastupdatedby(getStaffName(rst.getString("updated_date")));
								voObj.setLastupdated(rst.getString("updated_time"));
							}
							
							voObj.setTimetableId(rst.getString("teachertimetable_id"));
						
						}
						details.add(voObj);
					}
				
				}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getTimeTableDetails Ending");
		return details;
	}
	
	public String getStaffName(String staffId) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getStaffName Starting");

		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection connection = null;
		String staffname=null;
		
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection.prepareStatement(TimeTableSqlConstants.GET_STAFF_NAME);
			pstmt.setString(1, staffId);
			
			rst = pstmt.executeQuery();

				while (rst.next()) {
					
					staffname=rst.getString("StaffName");
				}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getStaffName Ending");
		return staffname;
	}
	
	public String getSubjectfName(String subjectId) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getSubjectfName Starting");

		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection connection = null;
		String subjectName=null;
		
		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection.prepareStatement(TimeTableSqlConstants.GET_SUBJECT_NAME);
			pstmt.setString(1, subjectId);
			
			rst = pstmt.executeQuery();

				while (rst.next()) {
					
					subjectName=rst.getString("subjectName");
				}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getSubjectfName Ending");
		return subjectName;
	}

	public ArrayList<TimeTableVo> getClassSectionList() {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in TimeTableDaoImpl : getClassSectionList Starting");

	PreparedStatement pstmt = null;
	ResultSet rst = null;
	Connection connection = null;
	ArrayList<TimeTableVo> classSectionList=new ArrayList<TimeTableVo>();
	
	try {
		connection = JDBCConnection.getSeparateConnection();

		pstmt = connection.prepareStatement(TimeTableSqlConstants.GET_CLASS_SECTION_LIST);
		
		rst = pstmt.executeQuery();

			while (rst.next()) {
				
				TimeTableVo timetableVo=new TimeTableVo();
				
				timetableVo.setClassid(rst.getString("classid"));
				timetableVo.setClassname(rst.getString("classname"));
				
				classSectionList.add(timetableVo);
			}
		
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	} finally {
		try {
			if (rst != null && (!rst.isClosed())) {
				rst.close();
			}
			if (pstmt != null && (!pstmt.isClosed())) {
				pstmt.close();
			}
			if (connection != null && (!connection.isClosed())) {
				connection.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in TimeTableDaoImpl : getClassSectionList Ending");
	return classSectionList;
}

	public static void main(String[] args) {
	
		JSONArray array=new JSONArray();
		array.put(new TimeTableDaoImpl().getTeacherTimeTableDetails("TEA23", "ACY1"));
		
		System.out.println(array);
	}
		
	}