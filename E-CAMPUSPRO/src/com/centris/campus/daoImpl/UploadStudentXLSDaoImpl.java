package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.pojo.UploadStudentXlsPOJO;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.SendMail;
import com.centris.campus.util.StringUtilContants;
import com.centris.campus.util.StudentRegistrationSQLUtilConstants;
import com.centris.campus.util.UploadStudentXLSqlUtil;
import com.itextpdf.text.log.SysoLogger;


public class UploadStudentXLSDaoImpl {

	private static Logger logger = Logger
			.getLogger(UploadStudentXLSDaoImpl.class);

	public int checkEmpCountBeforeInsert() {
		int beforeInsertCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(UploadStudentXLSqlUtil.CHECK_BEFORINSERT_COUNT);

			System.out.println("CHECK_BEFORINSERT_COUNT:::" + pstmt);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				beforeInsertCount = rs.getInt(1);

			}
		} catch (SQLException se) {
			se.printStackTrace();
			logger.error(se);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {

				if (conn != null) {
					conn.close();
					conn = null;
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadStudentXLSDaoImpl: Ending");

		return beforeInsertCount;
	}

	public int checkStudentID(String studentId, Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : checkEmpID : Starting");

		PreparedStatement ps_emp_count = null;
		ResultSet rs_emp_count = null;

		try {

			ps_emp_count = connection
					.prepareStatement(UploadStudentXLSqlUtil.CHECK_STUDENT_ID);
			ps_emp_count.setString(1, studentId);
			rs_emp_count = ps_emp_count.executeQuery();

			while (rs_emp_count.next()) {
				int count = rs_emp_count.getInt(1);

				return count;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {

			try {

				if (rs_emp_count != null && (!rs_emp_count.isClosed())) {

					rs_emp_count.close();
				}

				if (ps_emp_count != null && (!ps_emp_count.isClosed())) {

					ps_emp_count.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);

			}

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : checkEmpID : Ending");
		return 0;
	}

	public int checkCategorycode(String category, Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : checkEmpID : Starting");

		PreparedStatement ps_emp_count = null;
		ResultSet rs_emp_count = null;

		try {

			ps_emp_count = connection
					.prepareStatement(UploadStudentXLSqlUtil.CHECK_CATEGORY_ID);
			ps_emp_count.setString(1, category);
			rs_emp_count = ps_emp_count.executeQuery();

			while (rs_emp_count.next()) {
				int count = rs_emp_count.getInt(1);

				return count;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {

			try {

				if (rs_emp_count != null && (!rs_emp_count.isClosed())) {

					rs_emp_count.close();
				}

				if (ps_emp_count != null && (!ps_emp_count.isClosed())) {

					ps_emp_count.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);

			}

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : checkEmpID : Ending");
		return 0;
	}

	public int checkClassCode(String classname, Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : checkEmpID : Starting");

		PreparedStatement ps_emp_count = null;
		ResultSet rs_emp_count = null;

		try {

			ps_emp_count = connection
					.prepareStatement(UploadStudentXLSqlUtil.CHECK_CLASS_ID);
			ps_emp_count.setString(1, classname);
			rs_emp_count = ps_emp_count.executeQuery();

			while (rs_emp_count.next()) {
				int count = rs_emp_count.getInt(1);

				return count;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {

			try {

				if (rs_emp_count != null && (!rs_emp_count.isClosed())) {

					rs_emp_count.close();
				}

				if (ps_emp_count != null && (!ps_emp_count.isClosed())) {

					ps_emp_count.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);

			}

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : checkEmpID : Ending");
		return 0;
	}

	public int checkSectionCode(String sectionname, Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : checkEmpID : Starting");

		PreparedStatement ps_emp_count = null;
		ResultSet rs_emp_count = null;

		try {

			ps_emp_count = connection
					.prepareStatement(UploadStudentXLSqlUtil.CHECK_SECTION_ID);
			ps_emp_count.setString(1, sectionname);
			rs_emp_count = ps_emp_count.executeQuery();

			while (rs_emp_count.next()) {
				int count = rs_emp_count.getInt(1);

				return count;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {

			try {

				if (rs_emp_count != null && (!rs_emp_count.isClosed())) {

					rs_emp_count.close();
				}

				if (ps_emp_count != null && (!ps_emp_count.isClosed())) {

					ps_emp_count.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);

			}

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : checkEmpID : Ending");
		return 0;
	}

	public String insertEmpXSL(List<UploadStudentXlsPOJO> successlist,
			Connection connection) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : insertEmpXSL : Starting");
	
		
		
		
		Map<String, String> studentIDAdmissionNOMap = new HashMap<String, String>();
		ResultSet rs_emp_count=null;
		String stuAdmissionNo = null;
		String categoryName=null;
		PreparedStatement pstmcount = null;
		PreparedStatement academicYearpre = null;
		PreparedStatement prclassName=null;
		PreparedStatement preParentReg=null;
		PreparedStatement preChildParentUpdate=null;
		PreparedStatement precategoryName=null;
		 PreparedStatement pstmclasscount =null;
		PreparedStatement prsectionName=null;
		PreparedStatement ps_student_add = null;
		PreparedStatement ps_emp_count= null;
		PreparedStatement countDuplicate=null;
		Connection conn = null;
		String academicYear = "";
		String studentno = null;
		String className = null;
		String relationship = "";
		String parentId="";
		String sectionName="";

		


		int countAfterInsert=0;
		int studentDuplicateCount = 0;

		
		 String returnCount=null;
		try{
			
			System.out.println("DAOIMPL Is Working Student Excel file Upload");
			    conn = JDBCConnection.getSeparateConnection();
			   
/*			    conn.setAutoCommit(false);
*/
			
		    	ps_student_add = conn.prepareStatement(UploadStudentXLSqlUtil.INSERT_STUDENT);
				academicYearpre = conn.prepareStatement(StudentRegistrationSQLUtilConstants.GET_ACADEMIC_YEAR_BYID);
				pstmcount = conn.prepareStatement(StudentRegistrationSQLUtilConstants.COUNT_ACADEMIC_YEAR);
				prclassName = conn.prepareStatement(StudentRegistrationSQLUtilConstants.CLASS_NAME);
			    preParentReg = conn.prepareStatement(StudentRegistrationSQLUtilConstants.PARENT_REG);
			    preChildParentUpdate = conn.prepareStatement(StudentRegistrationSQLUtilConstants.PARENT_CHILD_INSERT);
			    precategoryName = conn.prepareStatement(StudentRegistrationSQLUtilConstants.CLASS_STREAM);
			    prsectionName = conn.prepareStatement(StudentRegistrationSQLUtilConstants.SECTION_NAME);
			    pstmclasscount = conn.prepareStatement(StudentRegistrationSQLUtilConstants.COUNT_CLASS);
				countDuplicate = conn.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_DUPLICATE);


				
			System.out.println("successlist:::"+successlist.size());
			
			 for(int i=0;i<successlist.size();i++){
				 
				 System.out.println("Inside FOR Loop");
				 
				 //duplicate count
					countDuplicate.setString(1, successlist.get(i).getStudentFirstName());
					countDuplicate.setString(2, successlist.get(i).getCategory());
					countDuplicate.setString(3, successlist.get(i).getClassname());
					countDuplicate.setString(4, successlist.get(i).getSectionname());

					if (successlist.get(i).getFatherName() != null) {
						countDuplicate.setString(5, successlist.get(i).getFatherName());
					} else {
						countDuplicate.setString(5, "");
					}
					if (successlist.get(i).getMotherName() != null) {
						countDuplicate.setString(6, successlist.get(i).getMotherName());
					} else {
						countDuplicate.setString(6, "");
					}
					countDuplicate.setString(7, HelperClass.convertUIToDatabase(successlist.get(i).getDateofBirth()));
					countDuplicate.setString(8, HelperClass.convertUIToDatabase(successlist.get(i).getDateofJoin().trim()));
					
					ResultSet duplicateRs = countDuplicate.executeQuery();

					while (duplicateRs.next()) {
						
						studentDuplicateCount = duplicateRs.getInt(1);
					}

					if (studentDuplicateCount != 0) {

						studentIDAdmissionNOMap.put("errorMessage",
								"Student Already Registered with these Details");
					} else {
						
/*						conn.setAutoCommit(false);
*/				 
				 		 
				 
				 
				 precategoryName.setString(1, successlist.get(i).getCategory());

					ResultSet resultSetcategoryName = precategoryName.executeQuery();
					
					while (resultSetcategoryName.next()) {
						
						categoryName = resultSetcategoryName.getString("classstream_name_var");
					}
				   
				 
					
					
					
				 academicYearpre.setString(1, successlist.get(i).getAcademicYear());
					ResultSet rsacademicYear = academicYearpre.executeQuery();
					while (rsacademicYear.next()) {
						academicYear = rsacademicYear.getString("acadamic_year");
					}
					
					
					
					ResultSet rs = pstmcount.executeQuery();
					rs.next();
					int count = rs.getInt(1);
					
					
					
					
					
					prsectionName.setString(1, successlist.get(i).getStudSectionId());
					ResultSet resultSetsectionName = prsectionName.executeQuery();

					while (resultSetsectionName.next()) {
						
						sectionName = resultSetsectionName.getString("classsection_name_var");

					}
					
					
					
					
					
					
					prclassName.setString(1, successlist.get(i).getStudClassId());
					ResultSet resultSetclassName = prclassName.executeQuery();
					while (resultSetclassName.next()) {
						className = resultSetclassName.getString("classdetails_name_var");
						System.out.println("className:::"+className);
					}
					

					
					
					pstmclasscount.setString(1, successlist.get(i).getStudClassId());
					ResultSet rsClass = pstmclasscount.executeQuery();
					rsClass.next();
					int classcount = rsClass.getInt(1);
					String studentRegNo = null;
					if (className != null)
						studentRegNo = StringUtilContants.STUDENT_REGISTRATION_NO + "-";
					if (classcount < 9) {
						int k = classcount;
						studentRegNo = studentRegNo + "000" + (++k);
					} else if (classcount < 99) {
						int k = classcount;
						studentRegNo = studentRegNo + "00" + (++k);
					} else if (classcount < 999) {
						int k = classcount;
						studentRegNo = studentRegNo + "0" + (++k);
					} else {
						int k = classcount;
						studentRegNo = studentRegNo + (++k);
					}

					
					
					if (categoryName != null)
						stuAdmissionNo = StringUtilContants.STUDENT_ADMISSION_NO + "-";
					if (count < 9) {
						int j = count;
						stuAdmissionNo = stuAdmissionNo + "000" + (++j) + "/"+ academicYear;
					} else if (count < 99) {
						int j = count;
						stuAdmissionNo = stuAdmissionNo + "00" + (++j) + "/"+ academicYear;
					} else if (count < 999) {
						int j = count;
						stuAdmissionNo = stuAdmissionNo + "0" + (++j) + "/"+ academicYear;
					} else {
						int j = count;
						stuAdmissionNo = stuAdmissionNo + (++j) + "/" + academicYear;
					}
					
					System.out.println("studentno::"+studentno);
					System.out.println("stuAdmissionNo::"+stuAdmissionNo);
                       
					
					//student registration
					
					
				   String studentidgenerator=new IDGenerator().getPrimaryKeyID("campus_student");
				   Timestamp createdDate = HelperClass.getCurrentTimestamp();
				   System.out.println("createdDate++++"+createdDate);
				    ps_student_add.setString(1,studentidgenerator);
				 	ps_student_add.setString(2, studentRegNo); //For roll number
				 	ps_student_add.setString(3, successlist.get(i).getStudentAdmissionNo().trim()); //For addmission Number
				 	ps_student_add.setString(4, successlist.get(i).getCategory().trim());
				 	ps_student_add.setString(5, successlist.get(i).getAcademicYear().trim());
				 	ps_student_add.setString(6, successlist.get(i).getClassname().trim());
				 	ps_student_add.setString(7, successlist.get(i).getSectionname().trim());
				 	ps_student_add.setString(8, stuAdmissionNo); // For registartion number
				 	ps_student_add.setString(9, successlist.get(i).getStudentFirstName().trim());
				    ps_student_add.setString(10, successlist.get(i).getStudentLastName().trim());
					ps_student_add.setString(11, HelperClass.convertUIToDatabase((successlist.get(i).getDateofBirth().trim())));
					ps_student_add.setString(12, successlist.get(i).getGender().trim());
					ps_student_add.setString(13, successlist.get(i).getBloodGroup().trim());
					ps_student_add.setString(14, successlist.get(i).getAge().trim());
					ps_student_add.setDate(15, HelperClass.getSqlDateFromDdMmYyFormat(successlist.get(i).getDateofJoin().trim()));
					ps_student_add.setString(16, successlist.get(i).getReligion().trim());
					ps_student_add.setString(17, successlist.get(i).getNationality().trim());
					ps_student_add.setString(18, "NOTPROMOTED".trim());
					ps_student_add.setString(19, successlist.get(i).getPhysicallyChallenged().trim());
					ps_student_add.setString(20, successlist.get(i).getIdentificationMarks().trim());
					ps_student_add.setString(21, successlist.get(i).getGrade().trim());
					ps_student_add.setString(22,successlist.get(i).getStudentSibilingIdInt());
					ps_student_add.setString(23, "active");
					ps_student_add.setString(24, successlist.get(i).getMedicalhistory().trim());
					ps_student_add.setString(25, successlist.get(i).getRemarks().trim());
					ps_student_add.setString(26, successlist.get(i).getCreateUser().trim());
					ps_student_add.setTimestamp(27, createdDate);
					ps_student_add.setString(28, successlist.get(i).getStudentquotaname().trim());
					ps_student_add.setString(29, successlist.get(i).getCaste().trim());
					ps_student_add.setString(30, successlist.get(i).getStudentRegNo().trim());
					ps_student_add.setString(31, successlist.get(i).getTransport().trim());
					ps_student_add.setString(32, successlist.get(i).getHostel().trim());
					ps_student_add.setString(33, successlist.get(i).getConcession_applicable().trim());
					ps_student_add.setString(34, successlist.get(i).getRte().trim());
					ps_student_add.setString(35, successlist.get(i).getTranscategory().trim());
					ps_student_add.setString(36, successlist.get(i).getTranslocation().trim());
					ps_student_add.setString(37, successlist.get(i).getEmisNo().trim());
					ps_student_add.setString(38, successlist.get(i).getPhysicalchalreason().trim());
				
					System.out.println("ps_student_add"+ps_student_add);
					
					ps_student_add.executeUpdate();
					
					
						

					
				// Parent Registration	
					 parentId = IDGenerator.getPrimaryKeyID("campus_parents");
					
					String parentUserName = parentId.substring(3);

					if (successlist.get(i).getPrimaryPerson().equals("father")) {
						
						relationship = "father";
						
						String fatherName = successlist.get(i).getFatherName();
						fatherName = fatherName.replaceAll(" ", "");
						
						preParentReg.setString(1, parentId);
						preParentReg.setString(2, successlist.get(i).getFatherName());
						preParentReg.setString(3, successlist.get(i).getFatherQualification());
						preParentReg.setString(4, successlist.get(i).getFatherMobileNo());
						preParentReg.setString(5, successlist.get(i).getFatheremailId());
						preParentReg.setString(6, successlist.get(i).getFatheroccupation());
						preParentReg.setString(7, successlist.get(i).getMotherName());
						preParentReg.setString(8, successlist.get(i).getMotherMobileNo());
						preParentReg.setString(9, successlist.get(i).getMotherQualification());
						preParentReg.setString(10, successlist.get(i).getMotheremailId());
						preParentReg.setString(11, successlist.get(i).getMotheroccupation());
						preParentReg.setString(12, successlist.get(i).getGuardianName());
						preParentReg.setString(13, successlist.get(i).getGuardianemailId());
						preParentReg.setString(14, successlist.get(i).getGuardianMobileNo());
						preParentReg.setString(15, fatherName.concat(parentUserName));
						preParentReg.setString(16, fatherName.concat(parentUserName));
						preParentReg.setString(17, successlist.get(i).getAddress());
						preParentReg.setString(18, successlist.get(i).getCreateUser());
						preParentReg.setTimestamp(19, HelperClass.getCurrentTimestamp());
						preParentReg.setString(20, "Active");
						System.out.println("preParentReg:::"+preParentReg);

						Thread.sleep(1000);
						if (successlist.get(i).getFatheremailId() == null) {
							new SendMail().sendMailtoChild(successlist.get(i)
									.getFatheremailId().trim(), fatherName
									.concat(parentUserName), fatherName
									.concat(parentUserName));
						}
						

						
					} else if (successlist.get(i).getPrimaryPerson().equals("mother")) {
						
						relationship = "mother";
						String motherName = successlist.get(i).getMotherName();
						motherName = motherName.replaceAll(" ", "");
						
						preParentReg.setString(1, parentId);
						preParentReg.setString(2, successlist.get(i).getFatherName());
						preParentReg.setString(3, successlist.get(i).getFatherQualification());
						preParentReg.setString(4, successlist.get(i).getFatherMobileNo());
						preParentReg.setString(5, successlist.get(i).getFatheremailId());
						preParentReg.setString(6, successlist.get(i).getFatheroccupation());
						preParentReg.setString(7, successlist.get(i).getMotherName());
						preParentReg.setString(8, successlist.get(i).getMotherMobileNo());
						preParentReg.setString(9, successlist.get(i).getMotherQualification());
						preParentReg.setString(10, successlist.get(i).getMotheremailId());
						preParentReg.setString(11, successlist.get(i).getMotheroccupation());
						preParentReg.setString(12, successlist.get(i).getGuardianName());
						preParentReg.setString(13, successlist.get(i).getGuardianemailId());
						preParentReg.setString(14, successlist.get(i).getGuardianMobileNo());
						preParentReg.setString(15, motherName.concat(parentUserName));
						preParentReg.setString(16, motherName.concat(parentUserName));
						preParentReg.setString(17, successlist.get(i).getAddress());
						preParentReg.setString(18, successlist.get(i).getCreateUser());
						preParentReg.setTimestamp(19, HelperClass.getCurrentTimestamp());
						preParentReg.setString(20, "Active");

						System.out.println("preParentReg:::"+preParentReg);

						
						Thread.sleep(1000);
						if (successlist.get(i).getMotheremailId() == null) {
							new SendMail().sendMailtoChild(successlist.get(i)
									.getMotheremailId().trim(), motherName
									.concat(parentUserName), motherName
									.concat(parentUserName));
						}
						

					
					} else {
						relationship = "guardian";

						String guardianName = successlist.get(i).getGuardianName();
						guardianName = guardianName.replaceAll(" ", " ");
						
						preParentReg.setString(1, parentId);
						preParentReg.setString(2, successlist.get(i).getFatherName());
						preParentReg.setString(3, successlist.get(i).getFatherQualification());
						preParentReg.setString(4, successlist.get(i).getFatherMobileNo());
						preParentReg.setString(5, successlist.get(i).getFatheremailId());
						preParentReg.setString(6, successlist.get(i).getFatheroccupation());
						preParentReg.setString(7, successlist.get(i).getMotherName());
						preParentReg.setString(8, successlist.get(i).getMotherMobileNo());
						preParentReg.setString(9, successlist.get(i).getMotherQualification());
						preParentReg.setString(10, successlist.get(i).getMotheremailId());
						preParentReg.setString(11, successlist.get(i).getMotheroccupation());
						preParentReg.setString(12, successlist.get(i).getGuardianName());
						preParentReg.setString(13, successlist.get(i).getGuardianemailId());
						preParentReg.setString(14, successlist.get(i).getGuardianMobileNo());
						preParentReg.setString(15, guardianName.concat(parentUserName));
						preParentReg.setString(16, guardianName.concat(parentUserName));
						preParentReg.setString(17, successlist.get(i).getAddress());
						preParentReg.setString(18, successlist.get(i).getCreateUser());
						preParentReg.setTimestamp(19, HelperClass.getCurrentTimestamp());
						preParentReg.setString(20, "Active");

						System.out.println("preParentReg:::"+preParentReg);

						
						Thread.sleep(1000);
						if (successlist.get(i).getGuardianemailId() == null) {
							new SendMail().sendMailtoChild(successlist.get(i)
									.getGuardianemailId().trim(), guardianName
									.concat(parentUserName), guardianName
									.concat(parentUserName));
						}
						
						

					}
					
					preParentReg.execute();

					//Parent Child Relation
					
					if (successlist.get(i).getPrimaryPerson().equals("father")) {
						
						relationship = "father";
						
					} else if (successlist.get(i).getPrimaryPerson().equals("mother")) {
						
						relationship = "mother";
						
					} else {

						relationship = "guardian";
						
					}
					
					preChildParentUpdate.setString(1, relationship);
					preChildParentUpdate.setString(2, parentId.trim());
					preChildParentUpdate.setString(3, studentidgenerator);
					
					
					preChildParentUpdate.executeUpdate();
				
				 
			 }
					
		}
			 
/*			 conn.commit();
*/		
			 }catch (SQLException sqle) {
		       	sqle.printStackTrace();
			   logger.error(sqle.getMessage(),sqle);
		    } 
          catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}finally{
			
			try {if (ps_student_add != null && (!ps_student_add.isClosed())) {

				ps_student_add.close();
			}

			if (rs_emp_count != null && (!rs_emp_count.isClosed())) {

				rs_emp_count.close();
			}

			if (ps_emp_count != null && (!ps_emp_count.isClosed())) {

				ps_emp_count.close();
			}

			if (pstmcount != null && (!pstmcount.isClosed())) {

				pstmcount.close();
			}

			if (pstmclasscount != null && (!pstmclasscount.isClosed())) {

				pstmclasscount.close();
			}

			if (precategoryName != null && (!precategoryName.isClosed())) {

				precategoryName.close();
			}

			if (preChildParentUpdate != null
					&& (!preChildParentUpdate.isClosed())) {

				preChildParentUpdate.close();
			}

			if (preParentReg != null && (!preParentReg.isClosed())) {

				preParentReg.close();
			}

			if (prsectionName != null && (!prsectionName.isClosed())) {

				prsectionName.close();
			}

			if (prclassName != null && (!prclassName.isClosed())) {

				prclassName.close();
			}

			if (academicYearpre != null && (!academicYearpre.isClosed())) {

				academicYearpre.close();
			}

           } catch (SQLException sqle) {
			       	sqle.printStackTrace();
				   logger.error(sqle.getMessage(),sqle);
			     } catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(),e);
			
		        }
		
		
		       }
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : insertEmpXSL : Ending");

		
		return returnCount;
	}
}
