package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.SectionDao;
import com.centris.campus.forms.SectionForm;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.pojo.SectionPojo;
import com.centris.campus.util.ClassUtilsConstants;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.SQLUtilConstants;
import com.centris.campus.util.SectionUtilsConstants;

public class SectionDaoImpl implements SectionDao{
	
	private static final Logger logger = Logger
			.getLogger(SectionDaoImpl.class);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	java.util.Date today = new java.util.Date();
	java.sql.Timestamp time_stamp = new java.sql.Timestamp(today.getTime());

	@Override
	public synchronized boolean insertCampusClassSectionDao(
			SectionPojo campusClassSectionPojo) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:insertCampusClassSectionDao  Starting");

		boolean secNameCheck = false;
		boolean status=false;
		String secDetailsId = campusClassSectionPojo.getSecDetailsId();
		String sectionName = campusClassSectionPojo.getSectionName();
		String USER_NAME = campusClassSectionPojo.getCreateUser();

		SectionDaoImpl impl = new SectionDaoImpl();
		secNameCheck = impl.checkSectionName(sectionName, secDetailsId);
		
		int count=0;
		if (secNameCheck==false) {
			Connection conn = null;
			
			try {
				conn = JDBCConnection.getSeparateConnection();

				pstmt=conn.prepareStatement(SectionUtilsConstants.INSERT_DETAILS_CAMPUS_CLASS_SECTION);
				
				pstmt.setString(1,
						IDGenerator.getPrimaryKeyID("campus_classsection"));
				pstmt.setString(2, secDetailsId);
				pstmt.setString(3, sectionName);
				pstmt.setString(4, campusClassSectionPojo.getSectionStrength());
				pstmt.setString(5, USER_NAME);
				pstmt.setTimestamp(6, time_stamp);
				pstmt.setString(7, null);
				pstmt.setString(8, null);
				
				count=pstmt.executeUpdate();
				if(count > 0){
					status=true;
				}
			} catch (SQLException sqlExp) {
				logger.error(sqlExp.getMessage(), sqlExp);
				sqlExp.getStackTrace();
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
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

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:insertCampusClassSectionDao Ending");
		return status;
	}

	@Override
	public synchronized boolean updateCampusClassSectionDao(
			SectionPojo campusClassSectionPojo) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:updateCampusClassSectionDao  Starting");
		// TODO Auto-generated method stub
		String sectionId = campusClassSectionPojo.getSecId();

		boolean secNameCheck = false;
		int count = 0;

		String secDetailsId = campusClassSectionPojo.getSecDetailsId();
		String sectionName = campusClassSectionPojo.getSectionName();
		String sectionStrength = campusClassSectionPojo.getSectionStrength();
		String secId = campusClassSectionPojo.getSecId();
		String USER_NAME = campusClassSectionPojo.getModifyUser();

		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmt=conn.prepareStatement(SectionUtilsConstants.UPDATE_DETAILS_CAMPUS_CLASS_SECTION);
			pstmt.setString(1, secDetailsId);
			pstmt.setString(2, sectionName);
			pstmt.setString(3, sectionStrength);
			pstmt.setString(4, USER_NAME);
			pstmt.setTimestamp(5, time_stamp);
			pstmt.setString(6, secId);
			count = pstmt.executeUpdate();
			

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
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

		if (count > 0) {

			secNameCheck = true;
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:updateCampusClassSectionDao  Ending");
		return secNameCheck;
	}

	@Override
	public synchronized boolean deleteCampusClassSectionDao(
			SectionPojo campusClassSectionPojo) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:deleteCampusClassSectionDao  Starting");
		// TODO Auto-generated method stub
		boolean flag = false;
		String sectionid = campusClassSectionPojo.getSectionId();
		int sectioncount = 0;

		int count = 0;
		PreparedStatement pstmtcountinmarksupload = null;
		PreparedStatement pstmtcountinMeeting = null;
		PreparedStatement pstmtcountinstudent = null;
		PreparedStatement pstmtcountinStudentPromotion = null;
		PreparedStatement pstmtcountinTimeTable = null;
		PreparedStatement pstmtcountinTeacherSettings = null;

		ResultSet rscountinmarksupload = null;
		ResultSet rscountinMeeting = null;
		ResultSet rscountinstudent = null;
		ResultSet rscountinStudentPromotion = null;
		ResultSet rscountinTimeTable = null;
		ResultSet rscountinTeacherSettings = null;

		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			// check section in assignment table
			PreparedStatement pstmtcountinassignment = conn
					.prepareStatement(SectionUtilsConstants.SECTION_COUNT_IN_CAMPUS_ASSIGNMENT);
			pstmtcountinassignment.setString(1, sectionid);
			ResultSet rscountinassignment = pstmtcountinassignment
					.executeQuery();
			while (rscountinassignment.next()) {
				sectioncount = rscountinassignment.getInt(1);
			}
			rscountinassignment.close();
			pstmtcountinassignment.close();
			if (sectioncount == 0) {
				// check section in campus classteacher table
				PreparedStatement pstmtcountinclassTeacher = conn
						.prepareStatement(SectionUtilsConstants.SECTION_COUNT_IN_CAMPUS_CLASSTEACHER);
				pstmtcountinclassTeacher.setString(1, sectionid);
				ResultSet rscountinclassTeacher = pstmtcountinclassTeacher
						.executeQuery();
				while (rscountinclassTeacher.next()) {
					sectioncount = rscountinclassTeacher.getInt(1);
				}
				rscountinclassTeacher.close();
				pstmtcountinclassTeacher.close();

				if (sectioncount == 0) {

					// check SECTION in marks upload

					pstmtcountinmarksupload = conn
							.prepareStatement(SectionUtilsConstants.SECTION_COUNT_IN_MARKS_UPLOAD);
					pstmtcountinmarksupload.setString(1, sectionid);
					rscountinmarksupload = pstmtcountinmarksupload
							.executeQuery();
					while (rscountinmarksupload.next()) {
						sectioncount = rscountinmarksupload.getInt(1);
					}
					rscountinmarksupload.close();
					pstmtcountinmarksupload.close();
					if (sectioncount == 0) {

						// check SECTION in meeting upload

						pstmtcountinMeeting = conn
								.prepareStatement(SectionUtilsConstants.SECTION_COUNT_IN_MEETING);
						pstmtcountinMeeting.setString(1, sectionid);
						rscountinMeeting = pstmtcountinMeeting.executeQuery();
						while (rscountinMeeting.next()) {
							sectioncount = rscountinMeeting.getInt(1);
						}
						rscountinMeeting.close();
						pstmtcountinmarksupload.close();
						if (sectioncount == 0) {

							// check section in student
							// table
							pstmtcountinstudent = conn
									.prepareStatement(SectionUtilsConstants.SECTION_COUNT_IN_CAMPUS_STUDENT);
							pstmtcountinstudent.setString(1, sectionid);
							rscountinstudent = pstmtcountinstudent
									.executeQuery();
							while (rscountinstudent.next()) {
								sectioncount = rscountinstudent.getInt(1);

							}
							rscountinstudent.close();
							pstmtcountinstudent.close();
							
							if (sectioncount == 0) {

								// check section in
								// student promotion
								// table
								pstmtcountinStudentPromotion = conn
										.prepareStatement(SectionUtilsConstants.SECTION_COUNT_IN_CAMPUS_STUDENT_PROMOTION);
								pstmtcountinStudentPromotion.setString(1,
										sectionid);
								pstmtcountinStudentPromotion.setString(2,
										sectionid);
								rscountinStudentPromotion = pstmtcountinStudentPromotion
										.executeQuery();

								while (rscountinStudentPromotion.next()) {
									sectioncount = rscountinStudentPromotion
											.getInt(1);
								}
								rscountinStudentPromotion.close();
								pstmtcountinStudentPromotion.close();
								if (sectioncount == 0) {
									// check section in
									// time table
									pstmtcountinTimeTable = conn
											.prepareStatement(SectionUtilsConstants.SECTION_COUNT_IN_CAMPUS_TIME_TABLE);
									pstmtcountinTimeTable.setString(1,
											sectionid);
									rscountinTimeTable = pstmtcountinTimeTable
											.executeQuery();
									while (rscountinTimeTable.next()) {
										sectioncount = rscountinTimeTable
												.getInt(1);
									}
									rscountinTimeTable.close();
									pstmtcountinTimeTable.close();

									if (sectioncount == 0) {
										// check
										// section in
										// time
										// table
										pstmtcountinTeacherSettings = conn
												.prepareStatement(SectionUtilsConstants.SECTION_COUNT_IN_TEACHERSETTINGS);
										pstmtcountinTeacherSettings.setString(
												1, sectionid);
										rscountinTeacherSettings = pstmtcountinTeacherSettings
												.executeQuery();
										while (rscountinTeacherSettings.next()) {
											sectioncount = rscountinTeacherSettings
													.getInt(1);
										}
										rscountinTeacherSettings.close();
										pstmtcountinTeacherSettings.close();

										if (sectioncount == 0) {
											pstmt = conn
													.prepareStatement(SectionUtilsConstants.DELETE_DETAILS_CAMPUS_CLASS_SECTION);

											pstmt.setString(1, sectionid);
											
											count = pstmt.executeUpdate();

										}

									}// if end for time
										// table

								}// if end for student
									// promotion table

							}// if end for campus
								// student table

						}// if end for meeting

					}// if end for marks upload
						// table
				}// if end for campus_classteacher table

			}// if end for assignment table

			if (count > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		} finally {

			try {
				if (rscountinmarksupload != null
						&& !rscountinmarksupload.isClosed()) {
					rscountinmarksupload.close();
				}
				if (rscountinMeeting != null && !rscountinMeeting.isClosed()) {
					rscountinMeeting.close();
				}
				if (rscountinstudent != null && !rscountinstudent.isClosed()) {
					rscountinstudent.close();
				}
				if (rscountinStudentPromotion != null
						&& !rscountinStudentPromotion.isClosed()) {
					rscountinStudentPromotion.close();
				}
				if (rscountinTimeTable != null
						&& !rscountinTimeTable.isClosed()) {
					rscountinTimeTable.close();
				}
				if (rscountinTeacherSettings != null
						&& !rscountinTeacherSettings.isClosed()) {
					rscountinTeacherSettings.close();
				}
				if (pstmtcountinmarksupload != null
						&& !pstmtcountinmarksupload.isClosed()) {
					pstmtcountinmarksupload.close();
				}
				if (pstmtcountinMeeting != null
						&& !pstmtcountinMeeting.isClosed()) {
					pstmtcountinMeeting.close();
				}
				if (pstmtcountinstudent != null
						&& !pstmtcountinstudent.isClosed()) {
					pstmtcountinstudent.close();
				}
				if (pstmtcountinStudentPromotion != null
						&& !pstmtcountinStudentPromotion.isClosed()) {
					pstmtcountinStudentPromotion.close();
				}
				if (pstmtcountinTimeTable != null
						&& !pstmtcountinTimeTable.isClosed()) {
					pstmtcountinTimeTable.close();
				}
				if (pstmtcountinTeacherSettings != null
						&& !pstmtcountinTeacherSettings.isClosed()) {
					pstmtcountinTeacherSettings.close();
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
				+ " Control in CampusClassSectionDaoImpl:deleteCampusClassSectionDao  Ending");
		return flag;
	}

	@Override
	public synchronized List<SectionPojo> getCampusClassSectionAndClassDetailsDao()
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:getCampusClassSectionAndClassDetailsDao  Starting");
		ResultSet rs = null;
		
		List<SectionPojo> campusClassSectionPojoList = new ArrayList<SectionPojo>();
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn
					.prepareStatement(SectionUtilsConstants.GET_CAMPUS_CLASS_SECTION_AND_CLASS_DETAILS);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SectionPojo campusClassSectionPojo = new SectionPojo();
				campusClassSectionPojo.setSectionId(rs.getString("classsection_id_int"));
				campusClassSectionPojo.setSecDetailsId(rs
						.getString("classdetail_id_int"));
				campusClassSectionPojo.setSecDetailsName(rs
						.getString("classdetails_name_var"));
				campusClassSectionPojo.setStreamName(rs
						.getString("classstream_name_var"));
				campusClassSectionPojo.setSectionId(rs
						.getString("classsection_id_int"));
				campusClassSectionPojo.setSectionName(rs
						.getString("classsection_name_var"));
				campusClassSectionPojo.setSectionStrength(rs
						.getString("classsection_strength_int"));
				campusClassSectionPojoList.add(campusClassSectionPojo);
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
				+ " Control in CampusClassSectionDaoImpl:getCampusClassSectionAndClassDetailsDao  Ending");
		return campusClassSectionPojoList;

	}

	@Override
	public synchronized List<SectionPojo> getCampusClassDetailsIDandClassDetailsNameDao()
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:getCampusClassDetailsIDandClassDetailsNameDao  Starting");
		// TODO Auto-generated method stub
		List<SectionPojo> campusClassDetailsPojoList = new ArrayList<SectionPojo>();
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SectionUtilsConstants.GET_CAMPUS_CLASS_DETAILS_ID_AND_CLASS_DETAILS_NAME);
			
			
			System.out.println("edit class list pstmt "+pstmt);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				SectionPojo campusClassSectionPojo = new SectionPojo();
				campusClassSectionPojo.setSecDetailsId(rs
						.getString("classdetail_id_int"));
				campusClassSectionPojo.setSecDetailsName(rs
						.getString("classdetails_name_var"));
				
				System.out.println("classdetails_name_var "+rs.getString("classdetails_name_var"));
				
				campusClassDetailsPojoList.add(campusClassSectionPojo);
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
				+ " Control in CampusClassSectionDaoImpl:getCampusClassDetailsIDandClassDetailsNameDao  Ending");
		return campusClassDetailsPojoList;

	}

	@Override
	public synchronized boolean checkSectionName(String sectionName, String secDetailId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:checkSectionName  Starting");
		// TODO Auto-generated method stub
		boolean secNameCheck = false;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn.prepareStatement(SectionUtilsConstants.CHECK_SECTION);
			pstmt.setString(1, secDetailId);
			pstmt.setString(2, sectionName);
			rs = pstmt.executeQuery();
			rs.next();
			if (rs.getInt("usercount") > 0) {
				secNameCheck = true;
			} else {
				secNameCheck = false;
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
				+ " Control in CampusClassSectionDaoImpl:checkSectionName  Ending");
		return secNameCheck;
	}

	public synchronized boolean checkSectionNameForUpdate(String sectionId,
			String sectionName, String className) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:checkSectionNameForUpdate  Starting");
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String classId = null;
		boolean secNameCheck = false;
		Connection conn = null;
		PreparedStatement pstmtclassid = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmtclassid = conn
					.prepareStatement(SectionUtilsConstants.GET_CLASS_ID_BY_NAME);
			pstmtclassid.setString(1, className);
			ResultSet rsclassid = pstmtclassid.executeQuery();

			while (rsclassid.next()) {
				classId = rsclassid.getString("classdetail_id_int");
				pstmt = (PreparedStatement) JDBCConnection
						.getStatement(SectionUtilsConstants.CHECK_SECTION_FOR_UPDATE);
				pstmt.setString(1, classId);
				pstmt.setString(2, sectionName);
				pstmt.setString(3, sectionId);
				ResultSet rs = pstmt.executeQuery();

				rs.next();
				if (rs.getInt("usercount") > 0) {
					secNameCheck = true;
				} else {
					secNameCheck = false;
				}
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
				+ " Control in CampusClassSectionDaoImpl:checkSectionNameForUpdate Ending");
		return secNameCheck;
	}
	
	@Override
	public synchronized List<SectionForm> searchSection(SectionForm searchText) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl :searchClassDetails Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int siNo = 0;
		List<SectionForm> getClassDetailsList = new ArrayList<SectionForm>();
		try {
			String searchName=searchText.getSectionName();
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SectionUtilsConstants.GET_SECTION_DETAILS_BY_SEARCH_ID);
			pstmt.setString(1, "%" + searchName + "%");
			pstmt.setString(2, "%" + searchName + "%");
			pstmt.setString(3, "%" + searchName + "%");
			pstmt.setString(4, "%" + searchName + "%");
			
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				SectionForm campusClassSectionPojo = new SectionForm();
				siNo++;
				campusClassSectionPojo.setSectionId(rs.getString("classsection_id_int"));
				campusClassSectionPojo.setSecDetailsId(rs
						.getString("classdetail_id_int"));
				campusClassSectionPojo.setSecDetailsName(rs
						.getString("classdetails_name_var"));
				campusClassSectionPojo.setStreamName(rs
						.getString("classstream_name_var"));
				campusClassSectionPojo.setSectionId(rs
						.getString("classsection_id_int"));
				campusClassSectionPojo.setSectionName(rs
						.getString("classsection_name_var"));
				campusClassSectionPojo.setSectionStrength(rs
						.getString("classsection_strength_int"));
				
			
				
				
				getClassDetailsList.add(campusClassSectionPojo);

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
				+ " Control in ClassDaoImpl :searchClassDetails  Starting");

		return getClassDetailsList;
	}
	
	public synchronized SectionForm editSection(SectionForm secCode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl : editClass  Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SectionForm campusClassSectionPojo = new SectionForm();
		try {
			String secId=secCode.getSectionId();
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SectionUtilsConstants.EDIT_SECTION);
			pstmt.setString(1, secId);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				campusClassSectionPojo.setSectionId(rs.getString("classsection_id_int"));
				campusClassSectionPojo.setSecDetailsId(rs
						.getString("classdetail_id_int"));
				campusClassSectionPojo.setSecDetailsName(rs
						.getString("classsection_name_var"));
				
			
				campusClassSectionPojo.setSectionStrength(rs
						.getString("classsection_strength_int"));
				campusClassSectionPojo.setStatus("update");
			
				
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
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
				+ " Control in ClassDaoImpl : editClass  Starting");
		return campusClassSectionPojo;
	}

	@Override
	public List<SectionPojo> sectiondetailsdownload() throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassSectionDaoImpl:getCampusClassSectionAndClassDetailsDao  Starting");
		ResultSet rs = null;
		// TODO Auto-generated method stub
		List<SectionPojo> campusClassSectionPojoList = new ArrayList<SectionPojo>();
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn
					.prepareStatement(SectionUtilsConstants.GET_CAMPUS_CLASS_SECTION_AND_CLASS_DETAILS);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SectionPojo campusClassSectionPojo = new SectionPojo();
				campusClassSectionPojo.setSectionId(rs.getString("classsection_id_int"));
				campusClassSectionPojo.setSecDetailsId(rs
						.getString("classdetail_id_int"));
				campusClassSectionPojo.setSecDetailsName(rs
						.getString("classdetails_name_var"));
				campusClassSectionPojo.setStreamName(rs
						.getString("classstream_name_var"));
				campusClassSectionPojo.setSectionId(rs
						.getString("classsection_id_int"));
				campusClassSectionPojo.setSectionName(rs
						.getString("classsection_name_var"));
				campusClassSectionPojo.setSectionStrength(rs
						.getString("classsection_strength_int"));
				
				
				
				
				campusClassSectionPojoList.add(campusClassSectionPojo);
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
				+ " Control in CampusClassSectionDaoImpl:getCampusClassSectionAndClassDetailsDao  Ending");
		return campusClassSectionPojoList;

	
		// TODO Auto-generated method stub
		
	}

}
