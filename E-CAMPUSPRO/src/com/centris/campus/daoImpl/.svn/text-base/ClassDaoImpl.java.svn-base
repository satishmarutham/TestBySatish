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

import com.centris.campus.dao.ClassDao;
import com.centris.campus.pojo.AcademicYearPojo;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.util.AcademicYearSQLUtilConstants;
import com.centris.campus.util.ClassUtilsConstants;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.SQLUtilConstants;
import com.centris.campus.vo.AcademicYearVO;

public class ClassDaoImpl implements ClassDao{
	private static final Logger logger = Logger.getLogger(ClassDaoImpl.class);
	
	@Override
	public synchronized List<ClassPojo> getClassDetails() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl :updateStreamCheck Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;

List<ClassPojo> getClassDetailsList=new ArrayList<ClassPojo>();
			try {
conn = JDBCConnection.getSeparateConnection();
pstmt = conn.prepareStatement(ClassUtilsConstants.GET_CLASS_DETAILS);

			
			ResultSet getStreamDetailsRs=pstmt.executeQuery();
			
		while(getStreamDetailsRs.next()){
			ClassPojo masterPojo=new ClassPojo();
		masterPojo.setClassId(getStreamDetailsRs.getString("classdetail_id_int"));
			masterPojo.setClassName(getStreamDetailsRs.getString("classdetails_name_var"));
			masterPojo.setStreamName(getStreamDetailsRs.getString("classstream_name_var"));
		
			getClassDetailsList.add(masterPojo);
			
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
	return getClassDetailsList;

	}
	
	public synchronized boolean createClass(ClassPojo classPojo,String createUser, String classcode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl : createClass  Starting");
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int count = 0;
		try {
			conn = JDBCConnection.getSeparateConnection();
			  if(!classPojo.getStatus().equals("update")){
				if(classNameCheck(classPojo)==false){ 
			pstmt = conn.prepareStatement(ClassUtilsConstants.CREATE_CLASS);
			pstmt.setString(1, classPojo.getClassId());
			pstmt.setString(2, classPojo.getStreamId());
			pstmt.setString(3, classPojo.getSecDetailName());
			pstmt.setString(4, classPojo.getCreateUser());
			pstmt.setTimestamp(5, HelperClass.getCurrentTimestamp());
				}
			
			count = pstmt.executeUpdate();
			  }else{
				  
				  if(updateclassNameCheck(classPojo)==false){ 
					pstmt = conn.prepareStatement(ClassUtilsConstants.UPDATE_CLASS_DETAIL);
					//pstmt.setString(1, classPojo.getClassId());
					pstmt.setString(1, classPojo.getStreamId());
					pstmt.setString(2, classPojo.getSecDetailName());
					pstmt.setString(3, classPojo.getCreateUser());
					pstmt.setTimestamp(4, HelperClass.getCurrentTimestamp());
					pstmt.setString(5, classPojo.getUpdateClassCode());
					
					count = pstmt.executeUpdate();
			    }
			  }

			if (count > 0) {
				status = true;
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
				+ " Control in ClassDaoImpl : createClass  Starting");
		return status;
	}
	
	@Override
	public synchronized List<ClassPojo> getStreamDetailDao() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassStreamDaoImpl:getStreamDetailDao  Starting");
		// TODO Auto-generated method stub
		List<ClassPojo> streamList = new ArrayList<ClassPojo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
				conn = JDBCConnection.getSeparateConnection();

			pstmt = conn.prepareStatement(ClassUtilsConstants.GET_CLASS_STREAM);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ClassPojo streamPojo = new ClassPojo();
				streamPojo.setStreamId(rs.getString("classstream_id_int"));
				streamPojo.setStreamName(rs.getString("classstream_name_var"));
				streamList.add(streamPojo);
				
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl :getStreamDetailDao  Ending");
		return streamList;
	}
	
	public synchronized boolean classNameCheck(ClassPojo classPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl : classNameCheck  Starting");
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Connection conn1 = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		int count = 0;
		int count1 = 0;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ClassUtilsConstants.CHECK_CLASS_NAME);

			pstmt.setString(1, classPojo.getSecDetailName());
			pstmt.setString(2, classPojo.getStreamId());
			//pstmt.setString(2, classPojo.getUpdateClassCode());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("Classname");
			}

			if (count > 0) {
				status = true;
			} 

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null && (!rs1.isClosed())) {
					rs1.close();
				}
				if (pstmt1 != null && (!pstmt1.isClosed())) {
					pstmt1.close();
				}
				if (conn1 != null && (!conn1.isClosed())) {
					conn1.close();
				}
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
				+ " Control in ClassDaoImpl : classNameCheck  Starting");

		return status;

	}
	
	public synchronized boolean updateclassNameCheck(ClassPojo classPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl : updateclassNameCheck  Starting");
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Connection conn1 = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		int count = 0;
		int count1 = 0;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ClassUtilsConstants.CHECK_UPDATE_CLASS_NAME);

			pstmt.setString(1, classPojo.getSecDetailName());
			pstmt.setString(2, classPojo.getStreamId());
			pstmt.setString(3, classPojo.getUpdateClassCode());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("Classname");
			}

			if (count > 0) {
				status = true;
			} 

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null && (!rs1.isClosed())) {
					rs1.close();
				}
				if (pstmt1 != null && (!pstmt1.isClosed())) {
					pstmt1.close();
				}
				if (conn1 != null && (!conn1.isClosed())) {
					conn1.close();
				}
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
				+ " Control in ClassDaoImpl : updateclassNameCheck  Starting");

		return status;

	}
	
	public synchronized ClassPojo editClass(String classCode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl : editClass  Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassPojo classPojo = new ClassPojo();
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ClassUtilsConstants.EDIT_CLASS);
			pstmt.setString(1, classCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				
                classPojo.setClassId(rs.getString("classdetail_id_int").trim());
				classPojo.setStreamId(rs.getString("classstream_id_int").trim());
				classPojo.setClassName(rs.getString("classdetails_name_var"));
				classPojo.setStatus("update");
			
				
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
		return classPojo;
	}
	
	@Override
	public synchronized boolean deleteClass(String classid) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in CampusClassStreamDaoImpl:deleteClassDao  Starting");
		// TODO Auto-generated method stub
		int val = 0;
		PreparedStatement pstmtcountinClassSection = null;
		PreparedStatement pstmtcountinassignment = null;
		PreparedStatement pstmtcountinclassTeacher = null;
		PreparedStatement pstmtcountinexamtimetable = null;
		PreparedStatement pstmtcountinFeesettings = null;
		PreparedStatement pstmtcountinfeestructur = null;
		PreparedStatement pstmtcountinfeesettings = null;
		PreparedStatement pstmtcountinMeeting = null;
		PreparedStatement pstmtcountinmarksupload = null;
		PreparedStatement pstmtcountinstudent = null;
		PreparedStatement pstmtcountinStudentPromotion = null;
		PreparedStatement pstmtcountinTimeTable = null;
		PreparedStatement pstmtcountinCampusSubject = null;
		PreparedStatement pstmtcountinTeacherSettings = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean status = false;

		int classcount = 0;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			// check class in classsection table
			pstmtcountinClassSection = conn
					.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_CAMPUS_CLASSSECTION);
			pstmtcountinClassSection.setString(1, classid);

			ResultSet rscountinClassSection = pstmtcountinClassSection
					.executeQuery();
			while (rscountinClassSection.next()) {
				classcount = rscountinClassSection.getInt(1);
			}
			rscountinClassSection.close();
			pstmtcountinClassSection.close();

			if (classcount == 0) {
				// check class in assignment table
				pstmtcountinassignment = conn
						.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_CAMPUS_ASSIGNMENT);
				pstmtcountinassignment.setString(1, classid);

				ResultSet rscountinassignment = pstmtcountinassignment
						.executeQuery();
				while (rscountinassignment.next()) {
					classcount = rscountinassignment.getInt(1);
				}
				rscountinassignment.close();
				pstmtcountinassignment.close();
				if (classcount == 0) {
					// check class in campus classteacher table
					pstmtcountinclassTeacher = conn
							.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_CAMPUS_CLASSTEACHER);
					pstmtcountinclassTeacher.setString(1, classid);

					ResultSet rscountinclassTeacher = pstmtcountinclassTeacher
							.executeQuery();
					while (rscountinclassTeacher.next()) {
						classcount = rscountinclassTeacher.getInt(1);
					}
					rscountinclassTeacher.close();
					pstmtcountinclassTeacher.close();

					if (classcount == 0) {

						// check class in exam time table
						pstmtcountinexamtimetable = conn
								.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_CAMPUS_EXAMINATION_TIME_TABLE);
						pstmtcountinexamtimetable.setString(1, classid);

						ResultSet rscountinexamtimetable = pstmtcountinexamtimetable
								.executeQuery();

						while (rscountinexamtimetable.next()) {
							classcount = rscountinexamtimetable.getInt(1);
						}
						rscountinexamtimetable.close();
						pstmtcountinexamtimetable.close();

						if (classcount == 0) {
							// check class in fee_settings table

							pstmtcountinFeesettings = conn
									.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_FEE_SETUP);
							pstmtcountinFeesettings.setString(1, classid);

							ResultSet rscountinFeeSettings = pstmtcountinFeesettings
									.executeQuery();

							while (rscountinFeeSettings.next()) {
								classcount = rscountinFeeSettings.getInt(1);
							}
							rscountinFeeSettings.close();
							pstmtcountinFeesettings.close();

							if (classcount == 0) {
								// check class in campus_meeting
								pstmtcountinMeeting = conn
										.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_CAMPUS_MEETING);
								pstmtcountinMeeting.setString(1, classid);

								ResultSet rscountinmeeting = pstmtcountinMeeting
										.executeQuery();
								while (rscountinmeeting.next()) {
									classcount = rscountinmeeting.getInt(1);
								}
								rscountinmeeting.close();
								pstmtcountinMeeting.close();

								if (classcount == 0) {

									// check stream in marks upload

									pstmtcountinmarksupload = conn
											.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_MARKS_UPLOAD);
									pstmtcountinmarksupload.setString(1,
											classid);

									ResultSet rscountinmarksupload = pstmtcountinmarksupload
											.executeQuery();
									while (rscountinmarksupload.next()) {
										classcount = rscountinmarksupload
												.getInt(1);
									}
									rscountinmarksupload.close();
									pstmtcountinmarksupload.close();

									if (classcount == 0) {

										// check CLASS in student
										// table
										pstmtcountinstudent = conn
												.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_CAMPUS_STUDENT);
										pstmtcountinstudent.setString(1,
												classid);

										ResultSet rscountinstudent = pstmtcountinstudent
												.executeQuery();
										while (rscountinstudent.next()) {
											classcount = rscountinstudent
													.getInt(1);

										}
										rscountinstudent.close();
										pstmtcountinstudent.close();
										if (classcount == 0) {

											// check class in
											// student promotion
											// table
											pstmtcountinStudentPromotion = conn
													.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_CAMPUS_STUDENT_PROMOTION);
											pstmtcountinStudentPromotion
													.setString(1, classid);
											pstmtcountinStudentPromotion
													.setString(2, classid);

											ResultSet rscountinStudentPromotion = pstmtcountinStudentPromotion
													.executeQuery();

											while (rscountinStudentPromotion
													.next()) {
												classcount = rscountinStudentPromotion
														.getInt(1);
											}
											rscountinStudentPromotion.close();
											pstmtcountinStudentPromotion
													.close();
											if (classcount == 0) {
												// check class in
												// time table
												pstmtcountinTimeTable = conn
														.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_CAMPUS_TIME_TABLE);
												pstmtcountinTimeTable
														.setString(1, classid);

												ResultSet rscountinTimeTable = pstmtcountinTimeTable
														.executeQuery();
												while (rscountinTimeTable
														.next()) {
													classcount = rscountinTimeTable
															.getInt(1);
												}
												rscountinTimeTable.close();
												pstmtcountinTimeTable.close();
												if (classcount == 0) {
													// check class
													// in subject
													// table
													pstmtcountinCampusSubject = conn
															.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_CAMPUS_SUBJECT);
													pstmtcountinCampusSubject
															.setString(1,
																	classid);

													ResultSet rscountinCampusSubject = pstmtcountinCampusSubject
															.executeQuery();
													while (rscountinCampusSubject
															.next()) {
														classcount = rscountinCampusSubject
																.getInt(1);
													}
													rscountinCampusSubject
															.close();
													pstmtcountinCampusSubject
															.close();

													if (classcount == 0) {
														// check
														// class in
														// time
														// table
														pstmtcountinTeacherSettings = conn
																.prepareStatement(ClassUtilsConstants.CLASS_COUNT_IN_TEACHERSETTINGS);
														pstmtcountinTeacherSettings
																.setString(1,
																		classid);

														ResultSet rscountinTeacherSettings = pstmtcountinTeacherSettings
																.executeQuery();
														while (rscountinTeacherSettings
																.next()) {
															classcount = rscountinTeacherSettings
																	.getInt(1);
														}
														rscountinCampusSubject
																.close();
														pstmtcountinTeacherSettings
																.close();

														if (classcount == 0) {
															pstmt = conn
																	.prepareStatement(ClassUtilsConstants.DELETE_CLASS_DETAIL);

															pstmt.setString(1,
																	classid);

															val = pstmt.executeUpdate();
															if(val > 0){
																status=true;
															}

														}

													}// //if end for
														// campus
														// subject

												}// if end for time
													// table

											}// if end for student
												// promotion table

										}// if end for campus
											// student table

									}// if end for marks upload
										// table

								}// if end for campus meetng table
							}// if end for feesettings table

							/*
							 * }// if end for fee structure table
							 */
							/*
							 * }// if end for fee_settings table
							 */
						}// if end for examination time table

					}// if end for campus_classteacher table

				}// if end for assignment table

			}// if end for class section table

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmtcountinClassSection != null
						&& !pstmtcountinClassSection.isClosed()) {
					pstmtcountinClassSection.close();
				}
				if (pstmtcountinassignment != null
						&& !pstmtcountinassignment.isClosed()) {
					pstmtcountinassignment.close();
				}
				if (pstmtcountinclassTeacher != null
						&& !pstmtcountinclassTeacher.isClosed()) {
					pstmtcountinclassTeacher.close();
				}
				if (pstmtcountinexamtimetable != null
						&& !pstmtcountinexamtimetable.isClosed()) {
					pstmtcountinexamtimetable.close();
				}
				if (pstmtcountinFeesettings != null
						&& !pstmtcountinFeesettings.isClosed()) {
					pstmtcountinFeesettings.close();
				}
				if (pstmtcountinfeestructur != null
						&& !pstmtcountinfeestructur.isClosed()) {
					pstmtcountinfeestructur.close();
				}
				if (pstmtcountinfeesettings != null
						&& !pstmtcountinfeesettings.isClosed()) {
					pstmtcountinfeesettings.close();
				}
				if (pstmtcountinMeeting != null
						&& !pstmtcountinMeeting.isClosed()) {
					pstmtcountinMeeting.close();
				}
				if (pstmtcountinmarksupload != null
						&& !pstmtcountinmarksupload.isClosed()) {
					pstmtcountinmarksupload.close();
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
				if (pstmtcountinCampusSubject != null
						&& !pstmtcountinCampusSubject.isClosed()) {
					pstmtcountinCampusSubject.close();
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
				+ " Control in ClassDaoImpl :deleteClassDao  Ending");

		return status;
	}
	
	public synchronized boolean updateClass(ClassPojo classPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl : updateClass  Starting");
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Connection conn1 = null;
		PreparedStatement pstmt1 = null;
		int count = 0;
		int count1 = 0;
		ResultSet rs = null;
		try {

				conn1 = JDBCConnection.getSeparateConnection();
			

					conn = JDBCConnection.getSeparateConnection();
					pstmt = conn
							.prepareStatement(ClassUtilsConstants.UPDATE_CLASS_DETAIL);

					pstmt.setString(1, classPojo.getClassName());
					
					pstmt.setString(2, classPojo.getStreamId());
					

					count = pstmt.executeUpdate();

					if (count > 0) {
						status = true;
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
				+ " Control in ClassDaoImpl : updateClass  Starting");
		return status;

	}
	
	@Override
	public synchronized List<ClassPojo> searchClassDetails(String searchText) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassDaoImpl :searchClassDetails Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int siNo = 0;
		List<ClassPojo> getClassDetailsList = new ArrayList<ClassPojo>();
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ClassUtilsConstants.GET_CLASS_DETAILS_BY_SEARCH_ID);
			pstmt.setString(1, "%" + searchText + "%");
			pstmt.setString(2, "%" + searchText + "%");

			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ClassPojo coursePojo = new ClassPojo();
				siNo++;
				coursePojo.setClassId(rs.getString("classdetail_id_int"));
				coursePojo.setClassName(rs.getString("classdetails_name_var"));
				coursePojo.setStreamName(rs.getString("classstream_name_var"));
				
				
				
				getClassDetailsList.add(coursePojo);

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

}
