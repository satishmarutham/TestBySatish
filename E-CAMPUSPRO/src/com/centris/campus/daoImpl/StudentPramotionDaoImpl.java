package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.StudentPramotionDao;
import com.centris.campus.pojo.StudentPromotionPOJO;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.StudentPromotionSqlUtil;
import com.centris.campus.util.SendMail;
import com.centris.campus.util.StringUtilContants;
import com.centris.campus.vo.AcadamicYearVO2;
import com.centris.campus.vo.StudentPramotionVO;
import com.centris.campus.vo.StudentRegistrationVo;

public class StudentPramotionDaoImpl implements StudentPramotionDao {

	private static final Logger logger = Logger
			.getLogger(StudentPramotionDaoImpl.class);
	PreparedStatement pstmt;
	PreparedStatement pstmt1;
	String admissionno;
	int result;
	int updateresult;
	PreparedStatement pstmt2;

	public List<AcadamicYearVO2> getAcadamicYear() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentPramotionDaoImpl : getAcadamicYear Starting");

		List<AcadamicYearVO2> yeardetailslist = new ArrayList<AcadamicYearVO2>();

		ResultSet resultsetano = null;

		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(StudentPromotionSqlUtil.RETRIVEYEAR);
			conn = JDBCConnection.getSeparateConnection();
			resultsetano = pstmt.executeQuery();
			while (resultsetano.next()) {
				AcadamicYearVO2 acadamicYearVO2 = new AcadamicYearVO2();
				acadamicYearVO2.setAcadamicyear_id_int(resultsetano
						.getString("acadamic_id"));
				acadamicYearVO2.setAcadamicyear_year(resultsetano
						.getString("acadamic_year"));
				yeardetailslist.add(acadamicYearVO2);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultsetano != null && (!resultsetano.isClosed())) {
					resultsetano.close();
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentPramotionDaoImpl : getAcadamicYear Ending");
		return yeardetailslist;
	}

	public List<StudentPramotionVO> getStudentData(String acadamicYear,
			String section) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentPramotionDaoImpl : getAcadamicYear Starting");

		Connection conn = null;

		List<StudentPramotionVO> studentlist = new ArrayList<StudentPramotionVO>();

		ResultSet resultsetano = null;
		try {

			ArrayList<String> list = HelperClass
					.getNextAccYearDetails(acadamicYear);

			if (list.size() != 0) {

				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn
						.prepareStatement(StudentPromotionSqlUtil.GET_STUDENT_DATA);
				pstmt.setString(1, section);
				pstmt.setString(2, acadamicYear);

				resultsetano = pstmt.executeQuery();
				while (resultsetano.next()) {
					StudentPramotionVO studentPramotionVO = new StudentPramotionVO();
					studentPramotionVO.setStudentid(resultsetano
							.getString("student_id_int"));
					studentPramotionVO.setAdmissionno(resultsetano
							.getString("student_admissionno_var"));
					studentPramotionVO.setStname(resultsetano
							.getString("student_fname_var"));
					studentPramotionVO.setCategoryid(resultsetano
							.getString("classstream_id_int"));
					studentPramotionVO.setCategoryname(resultsetano
							.getString("classstream_name_var"));
					studentPramotionVO.setClassid(resultsetano
							.getString("classdetail_id_int"));
					studentPramotionVO.setClassname(resultsetano
							.getString("classdetails_name_var"));
					studentPramotionVO.setSectionid(resultsetano
							.getString("classsection_id_int"));
					studentPramotionVO.setSectionname(resultsetano
							.getString("classsection_name_var"));
					studentPramotionVO.setAcadamicyearid(list.get(0));
					studentPramotionVO.setAcadamicyear(list.get(1));
					studentPramotionVO.setPerformancegrade("");
					studentPramotionVO.setPramotionstatus(resultsetano
							.getString("student_status_var"));
					studentlist.add(studentPramotionVO);
				}
			} else {
				StudentPramotionVO studentPramotionVO = new StudentPramotionVO();
				studentPramotionVO.setLsitStatus("NoAccYear");

				studentlist.add(studentPramotionVO);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultsetano != null && (!resultsetano.isClosed())) {
					resultsetano.close();
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentPramotionDaoImpl : getAcademicYear Ending");
		return studentlist;
	}

	public StudentPramotionVO insertStudentPromotion(
			StudentPromotionPOJO studentPramotionPOJO) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentPramotionAction : insertStudentPromotion Starting");
		StudentPramotionVO promotionvo = new StudentPramotionVO();
		ResultSet rs = null;
		String[] studentidval = studentPramotionPOJO.getStudentid();
		String fromstream = studentPramotionPOJO.getFromstream();
		String[] tostream = studentPramotionPOJO.getTostream();
		String fromclassval = studentPramotionPOJO.getFromclass();
		String[] toclassval = studentPramotionPOJO.getToclass();
		String fromacadamicyearval = studentPramotionPOJO.getFromacadamicyear();
		String[] toacadamicyearval = studentPramotionPOJO.getToacadamicyear();
		String fromsectionval = studentPramotionPOJO.getFromsection();
		String[] tosectionvaluesval = studentPramotionPOJO.getTosection();
		String[] topramotionstatus = studentPramotionPOJO.getPromotionstatus();

		ArrayList<StudentPramotionVO> notPromotedStudentList = new ArrayList<StudentPramotionVO>();

		Connection conn = null;

		for (int i = 0; i < studentidval.length; i++) {

			try {
				conn = JDBCConnection.getSeparateConnection();

				pstmt = conn
						.prepareStatement(StudentPromotionSqlUtil.GET_ADMISSIONNO_VAL);

				pstmt.setString(1, studentidval[i]);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					admissionno = rs.getString("student_admissionno_var");

					pstmt1 = (PreparedStatement) JDBCConnection
							.getStatement(StudentPromotionSqlUtil.INSERT_STUDENT_PROMOTION);

					for (int j = i; j <= i; j++) {
						for (int k = j; k <= j; k++) {
							for (int l = k; l <= k; l++) {
								for (int m = l; m <= l; m++) {
									for (int n = m; n <= m; n++) {

										StudentRegistrationVo vo = new StudentRegistrationVo();
										vo.setSearchTerm(studentidval[i]);
										List<StudentRegistrationVo> studentList = new StudentRegistrationDaoImpl().searchStudentResult(vo);

										if (checkApplicationNo(
												studentList
														.get(0)
														.getStudentAdmissionNo(),
												toacadamicyearval[k])) {

											promotionvo.setStname(studentList
													.get(0)
													.getStudentFirstName());
											promotionvo
													.setAdmissionno(studentList
															.get(0)
															.getStudentAdmissionNo());
											promotionvo
													.setCategoryname(studentList
															.get(0)
															.getStreemname());
											promotionvo
													.setSectionname(studentList
															.get(0)
															.getSectionnaem());
											promotionvo
													.setClassname(studentList
															.get(0)
															.getClassname());
											promotionvo
													.setAcadamicyear(studentList
															.get(0)
															.getAcademicYear());

										} else {

											pstmt1.setString(
													1,
													studentPramotionPOJO
															.getStudentpramotionid());
											pstmt1.setString(2, admissionno);
											pstmt1.setString(3, studentidval[i]);
											pstmt1.setString(4, fromclassval);
											pstmt1.setString(5, toclassval[j]);
											pstmt1.setString(6,
													fromacadamicyearval);
											pstmt1.setString(7,
													toacadamicyearval[k]);
											pstmt1.setString(8, fromsectionval);
											pstmt1.setString(9,
													tosectionvaluesval[l]);
											pstmt1.setString(10, fromstream);
											pstmt1.setString(11, tostream[m]);
											pstmt1.setString(12,
													studentPramotionPOJO
															.getCreateuser());

											System.out
													.println("insert promotion table");

											result = pstmt1.executeUpdate();

											if (result > 0) {

												System.out
														.println("in student insertion");

												String status = saveStudentRegistration(
														studentList,
														tostream[m],
														toclassval[j],
														tosectionvaluesval[l],
														toacadamicyearval[k],
														studentPramotionPOJO
																.getCreateuser());

												if (status
														.equalsIgnoreCase("true")) {

													pstmt2 = (PreparedStatement) JDBCConnection
															.getStatement(StudentPromotionSqlUtil.UPDATE_STUDENT);

													pstmt2.setString(
															1,
															MessageConstants.PPROMOTION_SUCCESS_STATUS);
													pstmt2.setString(2,
															studentidval[i]);
													updateresult = pstmt2
															.executeUpdate();

												}
												System.out
														.println("status ::::::::::::::: "
																+ status);
												/*
												 * pstmt2 = (PreparedStatement)
												 * JDBCConnection.getStatement(
												 * StudentPromotionSqlUtil
												 * .UPDATE_STUDENT);
												 * 
												 * pstmt2.setString(1,
												 * tostream[m]);
												 * pstmt2.setString(2,
												 * toclassval[j]);
												 * pstmt2.setString(3,
												 * tosectionvaluesval[l]);
												 * pstmt2.setString(4,
												 * toacadamicyearval[k]);
												 * pstmt2.setString(5,
												 * topramotionstatus[n]);
												 * pstmt2.setString(6,
												 * studentidval[i]);
												 * updateresult = pstmt2
												 * .executeUpdate();
												 */
											}

										}
									}
								}
							}
						}
					}
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
					if (pstmt2 != null && (!pstmt2.isClosed())) {
						pstmt2.close();
					}
					if (pstmt1 != null && (!pstmt1.isClosed())) {
						pstmt1.close();
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

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentPramotionDaoImpl : insertStudentPromotion Ending");
		return promotionvo;
	}

	public boolean checkApplicationNo(String admissionNumber, String studentId)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentPramotionDaoImpl : checkApplicationNo Starting");
		PreparedStatement preparedStatement = null;
		boolean flag = false;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			preparedStatement = conn
					.prepareStatement(StudentPromotionSqlUtil.CHECK_DUPLICATE_ADDMISSIONNO);
			preparedStatement.setString(1, admissionNumber);
			preparedStatement.setString(2, studentId);

			rs = preparedStatement.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				flag = true;
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
				if (preparedStatement != null
						&& (!preparedStatement.isClosed())) {
					preparedStatement.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentPramotionDaoImpl : checkApplicationNo Ending");
		return flag;
	}

	public String saveStudentRegistration(
			List<StudentRegistrationVo> registration, String streem,
			String classid, String sectionId, String accyear, String createUser)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : saveStudentRegistration Starting");

		String categoryName = null;
		int result = 0;
		String className = null;
		String sectionName = null;
		// String studentQuota = null;
		int parentsCheckCount = 0;

		String parentID = IDGenerator.getPrimaryKeyID("campus_parents");

		String relationship = "";
		PreparedStatement precategoryName = null;
		PreparedStatement academicYearpre = null;
		PreparedStatement prclassName = null;
		PreparedStatement prsectionName = null;
		PreparedStatement pstmcount = null;
		Connection conn = null;
		Savepoint sp = null;
		String stuAdmissionNo = null;
		String status = null;
		try {

			conn = JDBCConnection.getSeparateConnection();

			conn.setAutoCommit(false);
			sp = conn.setSavepoint("SavaStudent");

			String studentId = IDGenerator.getPrimaryKeyID("campus_student");

			precategoryName = conn
					.prepareStatement(StudentPromotionSqlUtil.CLASS_STREAM);

			precategoryName.setString(1, streem);

			ResultSet resultSetcategoryName = precategoryName.executeQuery();
			while (resultSetcategoryName.next()) {
				categoryName = resultSetcategoryName
						.getString("classstream_name_var");
			}
			academicYearpre = conn
					.prepareStatement(StudentPromotionSqlUtil.GET_ACADEMIC_YEAR_BYID);
			academicYearpre.setString(1, accyear);

			ResultSet rsacademicYear = academicYearpre.executeQuery();

			String academicYear = "";

			while (rsacademicYear.next()) {
				academicYear = rsacademicYear.getString("acadamic_year");
			}
			academicYearpre.close();

			prclassName = conn
					.prepareStatement(StudentPromotionSqlUtil.CLASS_NAME);

			prclassName.setString(1, classid);

			ResultSet resultSetclassName = prclassName.executeQuery();

			while (resultSetclassName.next()) {
				className = resultSetclassName
						.getString("classdetails_name_var");

			}

			prsectionName = conn
					.prepareStatement(StudentPromotionSqlUtil.SECTION_NAME);

			prsectionName.setString(1, sectionId);

			ResultSet resultSetsectionName = prsectionName.executeQuery();

			while (resultSetsectionName.next()) {
				sectionName = resultSetsectionName
						.getString("classsection_name_var");

			}
			prsectionName.close();
			pstmcount = conn
					.prepareStatement(StudentPromotionSqlUtil.COUNT_ACADEMIC_YEAR);
			ResultSet rs = pstmcount.executeQuery();
			rs.next();
			int count = rs.getInt(1);

			if (categoryName != null)

				stuAdmissionNo = StringUtilContants.STUDENT_ADMISSION_NO + "-";
			if (count < 9) {
				int i = count;
				stuAdmissionNo = stuAdmissionNo + "000" + (++i) + "/"
						+ academicYear;
			} else if (count < 99) {
				int i = count;
				stuAdmissionNo = stuAdmissionNo + "00" + (++i) + "/"
						+ academicYear;
			} else if (count < 999) {
				int i = count;
				stuAdmissionNo = stuAdmissionNo + "0" + (++i) + "/"
						+ academicYear;
			} else {
				int i = count;
				stuAdmissionNo = stuAdmissionNo + (++i) + "/" + academicYear;
			}

			PreparedStatement pstmclasscount = conn
					.prepareStatement(StudentPromotionSqlUtil.COUNT_CLASS);
			pstmclasscount.setString(1, classid);
			ResultSet rsClass = pstmclasscount.executeQuery();
			rsClass.next();
			int classcount = rsClass.getInt(1);

			String studentRegNo = null;
			if (className != null)
				studentRegNo = StringUtilContants.STUDENT_REGISTRATION_NO + "-";

			if (classcount < 9) {
				int i = classcount;
				studentRegNo = studentRegNo + "000" + (++i);
			} else if (classcount < 99) {
				int i = classcount;
				studentRegNo = studentRegNo + "00" + (++i);
			} else if (classcount < 999) {
				int i = classcount;
				studentRegNo = studentRegNo + "0" + (++i);
			} else {
				int i = classcount;
				studentRegNo = studentRegNo + (++i);
			}

			rsacademicYear.close();

			conn.setAutoCommit(false);
			PreparedStatement preparedStatement = conn
					.prepareStatement(StudentPromotionSqlUtil.STUDENT_REGISTRATION);

			Timestamp createdDate = HelperClass.getCurrentTimestamp();
			preparedStatement.setString(1, studentId);
			preparedStatement.setString(2, "");
			preparedStatement.setString(3, registration.get(0)
					.getStudentAdmissionNo().trim());
			preparedStatement.setString(4, streem.trim());
			preparedStatement.setString(5, accyear.trim());

			preparedStatement.setString(6, classid.trim());
			preparedStatement.setString(7, sectionId.trim());
			preparedStatement.setString(8, "");
			preparedStatement.setString(9, registration.get(0)
					.getStudentFirstName().trim());
			preparedStatement.setString(10, registration.get(0)
					.getStudentLastName().trim());

			preparedStatement.setString(11, HelperClass
					.convertUIToDatabase((registration.get(0).getDateofBirth()
							.trim())));
			preparedStatement.setString(12, registration.get(0).getGender()
					.trim());
			preparedStatement.setString(13, registration.get(0).getBloodGroup()
					.trim());
			preparedStatement
					.setString(14, registration.get(0).getAge().trim());
			preparedStatement.setString(15, registration.get(0)
					.getStudentPhoto().trim());

			preparedStatement.setDate(
					16,
					HelperClass.getSqlDateFromDdMmYyFormat(registration.get(0)
							.getDateofJoin().trim()));
			preparedStatement.setString(17, registration.get(0).getReligion()
					.trim());
			preparedStatement.setString(18, registration.get(0)
					.getNationality().trim());
			preparedStatement.setString(19, registration.get(0)
					.getScholarShip().trim());
			preparedStatement.setString(20, "NOTPROMOTED".trim());

			preparedStatement.setString(21, registration.get(0)
					.getPhysicallyChallenged().trim());
			preparedStatement.setString(22, registration.get(0)
					.getIdentificationMarks().trim());
			preparedStatement.setString(23, registration.get(0).getGrade()
					.trim());
			preparedStatement.setString(24, registration.get(0).getFatherName()
					.trim());
			preparedStatement.setString(25, registration.get(0).getMotherName()
					.trim());

			preparedStatement.setString(26, registration.get(0)
					.getGuardianName().trim());
			preparedStatement.setString(27, registration.get(0)
					.getFatherQualification().trim());
			preparedStatement.setString(28, registration.get(0)
					.getFatherMobileNo().trim());
			preparedStatement.setString(29, registration.get(0)
					.getMotherMobileNo().trim());
			preparedStatement.setString(30, registration.get(0)
					.getMotherQualification().trim());

			preparedStatement.setString(31, registration.get(0)
					.getStudentSibilingIdInt());
			preparedStatement.setString(32, registration.get(0)
					.getSibilingClassId());
			preparedStatement.setString(33, "active");
			preparedStatement.setString(34, registration.get(0)
					.getPreviousHistory().trim());

			preparedStatement.setString(35, registration.get(0).getRemarks()
					.trim());
			preparedStatement.setString(36, createUser.trim());
			preparedStatement.setTimestamp(37, createdDate);
			preparedStatement.setString(38, registration.get(0)
					.getStudentquotaname().trim());
			preparedStatement.setString(39, registration.get(0)
					.getFatheremailId().trim());

			preparedStatement.setString(40, registration.get(0)
					.getMotheremailId().trim());
			preparedStatement.setString(41, registration.get(0)
					.getGuardianemailId().trim());
			preparedStatement.setString(42, registration.get(0)
					.getGuardianMobileNo().trim());
			preparedStatement.setString(43, registration.get(0)
					.getStudentcastename().trim());

			preparedStatement.setString(44, registration.get(0)
					.getApplicationNo().trim());
			preparedStatement.setString(45, registration.get(0).getTransport()
					.trim());
			preparedStatement.setString(46, registration.get(0).getHostel()
					.trim());
			preparedStatement.setString(47, registration.get(0)
					.getIsconcession().trim());
			preparedStatement
					.setString(48, registration.get(0).getRte().trim());
			preparedStatement.setString(49, registration.get(0)
					.getTransporttypeId());
			preparedStatement.setString(50, registration.get(0)
					.getTransportlocationId());

			System.out.println("preparedStatement ::: "
					+ preparedStatement.toString());

			result = preparedStatement.executeUpdate();
			preparedStatement.close();

			PreparedStatement preParentRegCheck = conn
					.prepareStatement(StudentPromotionSqlUtil.PARENT_REG_CHECK);
			preParentRegCheck.setString(1, registration.get(0).getParentId());

			ResultSet rsParentsCheck = preParentRegCheck.executeQuery();

			while (rsParentsCheck.next()) {
				parentsCheckCount = rsParentsCheck.getInt("parentid");
			}

			if (parentsCheckCount == 0) {
				String full_address = registration.get(0).getAddressstreet1()
						.trim()
						+ ","
						+ registration.get(0).getAddressstreet2().trim()
						+ ","
						+ registration.get(0).getTownandcity().trim()
						+ ","
						+ registration.get(0).getZippostcode().trim()
						+ ","
						+ registration.get(0).getState().trim()
						+ ","
						+ registration.get(0).getCountry();
				PreparedStatement preParentReg = (PreparedStatement) JDBCConnection
						.getStatement(StudentPromotionSqlUtil.PARENT_REG);
				String parentId = registration.get(0).getParentId();
				String parentUserName = parentId.substring(3);

				if (registration.get(0).getPrimaryPerson().equals("father")) {
					relationship = "father";
					String fatherName = registration.get(0).getFatherName();
					fatherName = fatherName.replaceAll(" ", "");
					preParentReg
							.setString(1, registration.get(0).getParentId());
					preParentReg.setString(2, registration.get(0)
							.getFatherName());

					preParentReg.setString(3, registration.get(0)
							.getFatherQualification());
					preParentReg.setString(4, full_address);
					preParentReg.setString(5, registration.get(0)
							.getFatherMobileNo());
					preParentReg
							.setString(6, fatherName.concat(parentUserName));
					preParentReg.setString(7, "male");
					preParentReg.setString(8, registration.get(0)
							.getFatheremailId());
					preParentReg
							.setString(9, fatherName.concat(parentUserName));
					preParentReg.setString(10, "active");

					Thread.sleep(1000);
					if (registration.get(0).getFatheremailId() == null) {
						new SendMail().sendMailtoChild(registration.get(0)
								.getFatheremailId().trim(),
								fatherName.concat(parentUserName),
								fatherName.concat(parentUserName));
					}
				} else if (registration.get(0).getPrimaryPerson()
						.equals("mother")) {
					relationship = "mother";
					String motherName = registration.get(0).getMotherName();
					motherName = motherName.replaceAll(" ", "");
					preParentReg
							.setString(1, registration.get(0).getParentId());
					preParentReg.setString(2, registration.get(0)
							.getMotherName());
					preParentReg.setString(3, registration.get(0)
							.getMotherQualification());
					preParentReg.setString(4, full_address);
					preParentReg.setString(5, registration.get(0)
							.getMotherMobileNo());
					preParentReg
							.setString(6, motherName.concat(parentUserName));
					preParentReg.setString(7, "female");
					preParentReg.setString(8, registration.get(0)
							.getMotheremailId());
					preParentReg
							.setString(9, motherName.concat(parentUserName));
					preParentReg.setString(10, "active");

					Thread.sleep(1000);
					if (registration.get(0).getMotheremailId() == null) {
						new SendMail().sendMailtoChild(registration.get(0)
								.getMotheremailId().trim(),
								motherName.concat(parentUserName),
								motherName.concat(parentUserName));
					}
				} else {
					relationship = "guardian";

					String guardianName = registration.get(0).getGuardianName();
					guardianName = guardianName.replaceAll(" ", " ");
					preParentReg
							.setString(1, registration.get(0).getParentId());
					preParentReg.setString(2, registration.get(0)
							.getGuardianName());
					preParentReg.setString(3, " ");
					preParentReg.setString(4, full_address);
					preParentReg.setString(5, registration.get(0)
							.getGuardianMobileNo());
					preParentReg.setString(6,
							guardianName.concat(parentUserName));
					preParentReg.setString(7, "guar");
					preParentReg.setString(8, registration.get(0)
							.getGuardianemailId());
					preParentReg.setString(9,
							guardianName.concat(parentUserName));
					preParentReg.setString(10, "active");

					Thread.sleep(1000);
					if (registration.get(0).getGuardianemailId() == null) {
						new SendMail().sendMailtoChild(registration.get(0)
								.getGuardianemailId().trim(),
								guardianName.concat(parentUserName),
								guardianName.concat(parentUserName));
					}
				}
				preParentReg.execute();
				preParentReg.close();
			}

			PreparedStatement preParentChild = conn
					.prepareStatement(StudentPromotionSqlUtil.PARENT_CHILD);

			if (registration.get(0).getPrimaryPerson().equals("father")) {

				relationship = "father";
				preParentChild.setString(1, registration.get(0).getParentId());
				preParentChild.setString(2, studentId);
				preParentChild.setString(3, relationship);

			} else if (registration.get(0).getPrimaryPerson().equals("mother")) {
				relationship = "mother";
				preParentChild.setString(1, registration.get(0).getParentId());
				preParentChild.setString(2, studentId);
				preParentChild.setString(3, relationship);

			} else {

				preParentChild.setString(1, registration.get(0).getParentId());
				preParentChild.setString(2, studentId);
				preParentChild.setString(3, "guardian");
			}
			preParentChild.executeUpdate();

			conn.commit();

			if (result > 0) {

				status = "true";

			} else {

				status = "false";

			}

			preParentChild.close();

			conn.commit();

		} catch (Exception exception) {
			conn.rollback(sp);
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
			conn.rollback();
		} finally {
			try {

				if (precategoryName != null && (!precategoryName.isClosed())) {
					precategoryName.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : saveStudentRegistration Ending");
		return status;
	}

	public ArrayList<StudentPramotionVO> getpromotionslist() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl: getpromotionslist  Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentPramotionDaoImpl : getAcadamicYear Starting");

		Connection conn = null;

		ArrayList<StudentPramotionVO> studentlist = new ArrayList<StudentPramotionVO>();

		ResultSet resultsetano = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(StudentPromotionSqlUtil.GET_ENQUIRY_STUDENT_DATA);

			resultsetano = pstmt.executeQuery();
			while (resultsetano.next()) {
				StudentPramotionVO studentPramotionVO = new StudentPramotionVO();
				studentPramotionVO.setStudentid(resultsetano
						.getString("student_id_int"));
				studentPramotionVO.setAdmissionno(resultsetano
						.getString("student_admissionno_var"));
				studentPramotionVO.setStname(resultsetano
						.getString("studentname"));
				studentPramotionVO.setClassname(resultsetano
						.getString("classdetails_name_var"));
				studentPramotionVO.setSectionname(resultsetano
						.getString("classsection_name_var"));
				studentPramotionVO.setAcadamicyear(resultsetano
						.getString("acadamic_year"));

				studentlist.add(studentPramotionVO);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultsetano != null && (!resultsetano.isClosed())) {
					resultsetano.close();
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
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl: getpromotionslist   Ending");

		return studentlist;
	}
}