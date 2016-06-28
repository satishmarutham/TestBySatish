package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.dao.ExamTimeTableDao;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.pojo.ExamTimetablePojo;
import com.centris.campus.util.ClassUtilsConstants;
import com.centris.campus.util.ExamTimeTableSqlUtils;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.SQLUtilConstants;

public class ExamTimeTableDaoImpl implements ExamTimeTableDao {
	private static final Logger logger = Logger
			.getLogger(ExamTimeTableDaoImpl.class);

	@Override
	public synchronized List<ExamTimetablePojo> getExamDetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl :updateStreamCheck Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;

		List<ExamTimetablePojo> getExamDetailsList = new ArrayList<ExamTimetablePojo>();
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ExamTimeTableSqlUtils.GET_ALL_EXAM_DETAILS);

			ResultSet getStreamDetailsRs = pstmt.executeQuery();

			while (getStreamDetailsRs.next()) {
				ExamTimetablePojo masterPojo = new ExamTimetablePojo();
				masterPojo.setExamId(getStreamDetailsRs.getString("examid"));
				masterPojo
						.setExamName(getStreamDetailsRs.getString("examname"));
				masterPojo.setDiscription(getStreamDetailsRs
						.getString("description"));
				masterPojo.setStartDate(getStreamDetailsRs
						.getString("startdate"));
				masterPojo.setEndDate(getStreamDetailsRs.getString("enddate"));
				masterPojo.setClassId(getStreamDetailsRs.getString("classid"));
				masterPojo.setExamDate(HelperClass
						.convertDatabaseToUI(getStreamDetailsRs
								.getString("examdate")));
				masterPojo.setExamStartTime(getStreamDetailsRs
						.getString("examtime"));
				masterPojo.setExamEndTime(getStreamDetailsRs
						.getString("endtime"));
				masterPojo.setSubId(getStreamDetailsRs.getString("subjectid"));
				masterPojo.setClassName(getStreamDetailsRs
						.getString("classdetails_name_var"));

				getExamDetailsList.add(masterPojo);

			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl :updateStreamCheck  Starting");
		return getExamDetailsList;

	}

	public ArrayList<ExamTimetablePojo> getExamTimeTableDetails(String classId,
			String exam) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTabledaoIMPL: getAllSubjects Starting");
		PreparedStatement subject_pstmt = null;
		ResultSet subject_pstmt_rs = null;
		ArrayList<ExamTimetablePojo> subject_list = new ArrayList<ExamTimetablePojo>();

		PreparedStatement pstmt_examtimtable = null;
		ResultSet rs_examtimtable = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			subject_pstmt = conn
					.prepareStatement(ExamTimeTableSqlUtils.GET_ALL_SUBJECTS);
			subject_pstmt.setString(1, classId);

			subject_pstmt_rs = subject_pstmt.executeQuery();

			while (subject_pstmt_rs.next()) {
				ExamTimetablePojo voobj = new ExamTimetablePojo();

				String subjectId = subject_pstmt_rs.getString("subjectID");
				String subname = subject_pstmt_rs.getString("subjectName");

				if (checkExamDate(classId, subjectId, exam)) {

					pstmt_examtimtable = conn
							.prepareStatement(ExamTimeTableSqlUtils.GET_EXAM_TIME_TABLE);
					// pstmt_examtimtable.setString(1, category);
					pstmt_examtimtable.setString(1, classId);
					pstmt_examtimtable.setString(2, subjectId);
					pstmt_examtimtable.setString(3, exam);

					rs_examtimtable = pstmt_examtimtable.executeQuery();
					while (rs_examtimtable.next()) {
						voobj.setSubId(subjectId);
						voobj.setSubName(subname);
						voobj.setExamDate((HelperClass
								.convertDatabaseToUI(rs_examtimtable
										.getString("examdate"))));
						voobj.setExamStartTime(rs_examtimtable
								.getString("examtime"));
						voobj.setExamEndTime(rs_examtimtable
								.getString("endtime"));
					}

				} else {
					voobj.setSubId(subject_pstmt_rs.getString("subjectID"));
					voobj.setSubName(subject_pstmt_rs.getString("subjectName"));

				}

				subject_list.add(voobj);
			}

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (rs_examtimtable != null && !rs_examtimtable.isClosed()) {
					rs_examtimtable.close();
				}
				if (subject_pstmt != null && !subject_pstmt.isClosed()) {
					subject_pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTabledaoIMPL: getAllSubjects Ending");
		return subject_list;
	}

	public ExamTimetablePojo getExamDate(String examId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTabledaoIMPL: getExaminations Starting");
		PreparedStatement examination_pstmt = null;
		ResultSet examination_pstmt_rs = null;
		// ExaminationTimeTableVO exams_list=null;
		ExamTimetablePojo voobj = new ExamTimetablePojo();
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			examination_pstmt = conn
					.prepareStatement(ExamTimeTableSqlUtils.GET_EXAM_DATE);
			examination_pstmt.setString(1, examId);

			examination_pstmt_rs = examination_pstmt.executeQuery();

			while (examination_pstmt_rs.next()) {

				// voobj.setExamId(examination_pstmt_rs.getString("examid"));
				// voobj.setExamName(examination_pstmt_rs.getString("examname"));
				voobj.setStartDate(HelperClass
						.convertDatabaseToUI(examination_pstmt_rs
								.getString("startdate")));
				voobj.setEndDate(HelperClass
						.convertDatabaseToUI(examination_pstmt_rs
								.getString("enddate")));

			}

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (examination_pstmt_rs != null
						&& !examination_pstmt_rs.isClosed()) {
					examination_pstmt_rs.close();
				}
				if (examination_pstmt != null && !examination_pstmt.isClosed()) {
					examination_pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTabledaoIMPL: getExaminations Ending");
		return voobj;
	}

	public ArrayList<ExamTimetablePojo> getAllSubjects(String classid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTabledaoIMPL: getAllSubjects Starting");
		PreparedStatement subject_pstmt = null;
		ResultSet subject_pstmt_rs = null;
		ArrayList<ExamTimetablePojo> subject_list = new ArrayList<ExamTimetablePojo>();
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			subject_pstmt = conn
					.prepareStatement(ExamTimeTableSqlUtils.GET_ALL_SUBJECTS);
			subject_pstmt.setString(1, classid);

			subject_pstmt_rs = subject_pstmt.executeQuery();

			while (subject_pstmt_rs.next()) {
				ExamTimetablePojo voobj = new ExamTimetablePojo();
				voobj.setSubId(subject_pstmt_rs.getString("subjectID"));
				voobj.setSubName(subject_pstmt_rs.getString("subjectName"));
				voobj.setClassId(classid);
				subject_list.add(voobj);
			}

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (subject_pstmt_rs != null && !subject_pstmt_rs.isClosed()) {
					subject_pstmt_rs.close();
				}
				if (subject_pstmt != null && !subject_pstmt.isClosed()) {
					subject_pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTabledaoIMPL: getAllSubjects Ending");
		return subject_list;
	}

	public boolean checkExamDate(String classid, String subjectid, String examid) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTabledaoIMPL: checkExamDate  Starting");

		int count = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean status = false;

		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn
					.prepareStatement(ExamTimeTableSqlUtils.CHECK_DUPLICATE_EXAM);
			// pstmt.setString(1, streenId);
			pstmt.setString(1, classid);
			pstmt.setString(2, subjectid);
			pstmt.setString(3, examid);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				count = rs.getInt("examdate");
			}

			if (count >= 1) {

				status = true;
			} else {

				status = false;
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTabledaoIMPL: checkExamDate Ending");
		return status;
	}

	public String saveExaminationClassMapping(
			ArrayList<ExamTimetablePojo> examinationclassmappinglist) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTabledaoIMPL: saveExaminationClassMapping Starting");

		int count = 0;
		String status = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			for (int i = 0; i < examinationclassmappinglist.size(); i++) {

				if (checkExamDate(examinationclassmappinglist.get(i)
						.getClassId(), examinationclassmappinglist.get(i)
						.getSubId(), examinationclassmappinglist.get(i)
						.getExamId())) {

					// UPDATE_EXAMDATE

					pstmt = conn
							.prepareStatement(ExamTimeTableSqlUtils.UPDATE_EXAMDATE);
					pstmt.setString(1, examinationclassmappinglist.get(i)
							.getExamDate());
					pstmt.setString(2, examinationclassmappinglist.get(i)
							.getExamStartTime());
					pstmt.setString(3, examinationclassmappinglist.get(i)
							.getExamEndTime());
					pstmt.setString(4, examinationclassmappinglist.get(i)
							.getCreatedBy());

					pstmt.setString(5, examinationclassmappinglist.get(i)
							.getClassId());
					pstmt.setString(6, examinationclassmappinglist.get(i)
							.getSubId());
					pstmt.setString(7, examinationclassmappinglist.get(i)
							.getExamId());

					count = pstmt.executeUpdate();

				} else {

					pstmt = conn
							.prepareStatement(ExamTimeTableSqlUtils.STORE_EXAM_TIMETABLE_DETAILS);

					pstmt.setString(1, examinationclassmappinglist.get(i)
							.getClassId());
					pstmt.setString(2, examinationclassmappinglist.get(i)
							.getSubId());
					pstmt.setString(3, examinationclassmappinglist.get(i)
							.getExamId());
					pstmt.setString(4, examinationclassmappinglist.get(i)
							.getExamDate());
					pstmt.setString(5, examinationclassmappinglist.get(i)
							.getExamStartTime());
					pstmt.setString(6, examinationclassmappinglist.get(i)
							.getExamEndTime());
					pstmt.setString(7, examinationclassmappinglist.get(i)
							.getCreatedBy());

					count = pstmt.executeUpdate();

				}

			}

			if (count > 0) {

				status = "true";
			} else {
				status = "false";
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTabledaoIMPL: saveExaminationClassMapping Ending");
		return status;
	}

	public ArrayList<ExamTimetablePojo> getExamdetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableServiceIMPL: getExamdetails Starting");
		ArrayList<ExamTimetablePojo> examlist = new ArrayList<ExamTimetablePojo>();

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ExamTimeTableSqlUtils.GET_EXAMDETAILS);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ExamTimetablePojo exampojo = new ExamTimetablePojo();
				exampojo.setExamId(rs.getString("examid"));
				exampojo.setExamName(rs.getString("examname"));
				examlist.add(exampojo);
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTableServiceIMPL: getExamdetails Ending");
		return examlist;

	}

	public ArrayList<ExamTimetablePojo> getclassdetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ExaminationTimeTableServiceIMPL: getclassdetails Starting");
		ArrayList<ExamTimetablePojo> classlist = new ArrayList<ExamTimetablePojo>();

		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {

			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn
					.prepareStatement(ExamTimeTableSqlUtils.GET_CLASSDETAILS);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ExamTimetablePojo exampojo = new ExamTimetablePojo();
				exampojo.setClassId(rs.getString("classdetail_id_int"));
				exampojo.setClassName(rs.getString("classdetails_name_var"));
				classlist.add(exampojo);
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ExaminationTimeTableServiceIMPL: getclassdetails Ending");
		return classlist;

	}
}
