package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.dao.ParentSettingsDao;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.pojo.RoleMasterPojo;
import com.centris.campus.util.CommunicateUtilConstants;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.ParentModuleUtil;
import com.centris.campus.util.RoleMasterSqlConstants;
import com.centris.campus.util.SQLUtilConstants;
import com.centris.campus.util.StaffPayrollUtil;
import com.centris.campus.util.SubjectSqlUtils;
import com.centris.campus.util.TimeTableSqlConstants;
import com.centris.campus.vo.AssignmentViewVO;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.LeaveRequestVo;
import com.centris.campus.vo.LstmsUpcomingMeetingVO;
import com.centris.campus.vo.ParentFeedbackVo;
import com.centris.campus.vo.ParentVO;
import com.centris.campus.vo.StaffPayrollListVo;
import com.centris.campus.vo.StreamDetailsVO;
import com.centris.campus.vo.StudentAttendanceVo;
import com.centris.campus.vo.StudentRegistrationVo;
import com.centris.campus.vo.TimeTableVo;
import com.centris.campus.vo.UserDetailVO;
import com.centris.campus.vo.ViewallSubjectsVo;

public class ParentSettingsDaoImpl implements ParentSettingsDao {
	private static final Logger logger = Logger
			.getLogger(ParentSettingsDaoImpl.class);

	public ArrayList<ExaminationDetailsVo> getExamListDetailsDao(ParentVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getExamListDetailsDao Starting");

		ArrayList<ExaminationDetailsVo> examlist = new ArrayList<ExaminationDetailsVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int sno1 = 0;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_EXAM_STUDENT_DETAILS);

			pstmt.setString(1, vo.getStudentid());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				sno1++;

				ExaminationDetailsVo vo1 = new ExaminationDetailsVo();

				vo1.setSno1(sno1);
				vo1.setClassname(rs.getString("classdetails_name_var"));
				vo1.setSubjectName(rs.getString("subjectName"));
				vo1.setExamName(rs.getString("examname"));
				vo1.setStartDate(HelperClass.convertDatabaseToUI(rs
						.getString("startdate")));
				vo1.setEndDate(HelperClass.convertDatabaseToUI(rs
						.getString("enddate")));
				vo1.setStartTime(rs.getString("examtime"));
				vo1.setEndTime(rs.getString("endtime"));

				examlist.add(vo1);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getExamListDetailsDao  Ending");

		return examlist;
	}

	public ArrayList<ParentVO> getStudentDao(ParentVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStudentDao Starting");

		ArrayList<ParentVO> stulist = new ArrayList<ParentVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_STUDENT_PARENT_DETAILS);

			pstmt.setString(1, vo.getParentID());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ParentVO vo1 = new ParentVO();
				vo1.setParentID(rs.getString("parentid"));
				vo1.setStdAdmisiionNo(rs.getString("stu_addmissionNo"));
				vo1.setStudentFnameVar(rs.getString("student_fname_var"));

				stulist.add(vo1);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStudentDao  Ending");

		return stulist;
	}

	public ArrayList<ExaminationDetailsVo> getMoreChildExamListDao(
			ExaminationDetailsVo exmvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getMoreChildExamListDao Starting");

		ArrayList<ExaminationDetailsVo> stulist = new ArrayList<ExaminationDetailsVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int sno1 = 0;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_EXAM_STUDENT_DETAILS);

			pstmt.setString(1, exmvo.getStudentid());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sno1++;
				ExaminationDetailsVo vo1 = new ExaminationDetailsVo();
				vo1.setSno1(sno1);
				vo1.setClassname(rs.getString("classdetails_name_var"));
				vo1.setSubjectName(rs.getString("subjectName"));
				vo1.setExamName(rs.getString("examname"));
				vo1.setStartDate(HelperClass.convertDatabaseToUI(rs
						.getString("startdate")));
				vo1.setEndDate(HelperClass.convertDatabaseToUI(rs
						.getString("enddate")));
				vo1.setStartTime(rs.getString("examtime"));
				vo1.setEndTime(rs.getString("endtime"));

				stulist.add(vo1);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getMoreChildExamListDao  Ending");
		return stulist;
	}

	public ArrayList<AssignmentViewVO> getAssignmentListDao(ParentVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getExamListDetailsDao Starting");

		ArrayList<AssignmentViewVO> assignmentlist = new ArrayList<AssignmentViewVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_ASSIGNMENT_STUDENT_DETAILS);

			pstmt.setString(1, vo.getStudentid());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				AssignmentViewVO vo1 = new AssignmentViewVO();

				vo1.setClassname(rs.getString("classdetails_name_var"));
				vo1.setSectionname(rs.getString("classsection_name_var"));
				vo1.setSubjectname(rs.getString("subjectname"));
				vo1.setAssignmentname(rs.getString("Name"));
				vo1.setAssignmentid(rs.getString("AssignmentCode"));
				vo1.setAccname(rs.getString("acadamic_year"));
				vo1.setAssignmentdate(HelperClass.convertDatabaseToUI(rs
						.getString("AssignmentDate")));
				vo1.setCompletiondate(HelperClass.convertDatabaseToUI(rs
						.getString("AssignmentDate")));
				vo1.setMaxmarks(rs.getString("MaxMarks"));

				assignmentlist.add(vo1);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getExamListDetailsDao  Ending");

		return assignmentlist;
	}

	public ArrayList<AssignmentViewVO> getmoreAssidnmentListDao(
			AssignmentViewVO assvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getExamListDetailsDao Starting");

		ArrayList<AssignmentViewVO> assignmentlist = new ArrayList<AssignmentViewVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		// int sno=0;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_ASSIGNMENT_STUDENT_DETAILS);

			pstmt.setString(1, assvo.getStudentid());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// sno++;
				AssignmentViewVO vo1 = new AssignmentViewVO();
				// vo1.setSno(sno);
				vo1.setClassname(rs.getString("classdetails_name_var"));
				vo1.setSectionname(rs.getString("classsection_name_var"));
				vo1.setSubjectname(rs.getString("subjectname"));
				vo1.setAssignmentname(rs.getString("Name"));
				vo1.setAssignmentid(rs.getString("AssignmentCode"));
				vo1.setAccname(rs.getString("acadamic_year"));
				vo1.setAssignmentdate(HelperClass.convertDatabaseToUI(rs
						.getString("AssignmentDate")));
				vo1.setCompletiondate(HelperClass.convertDatabaseToUI(rs
						.getString("CompletionDate")));
				vo1.setMaxmarks(rs.getString("MaxMarks"));

				assignmentlist.add(vo1);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getExamListDetailsDao  Ending");

		return assignmentlist;
	}

	public AssignmentViewVO getviewAssignmentDao(AssignmentViewVO assvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getviewAssignmentDao Starting");

		AssignmentViewVO assignmentlist = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {

			assignmentlist = new AssignmentViewVO();

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_VIEW_ASSIGNMENT_DETAILS);

			pstmt.setString(1, assvo.getAssignmentid());
			pstmt.setString(2, assvo.getStudentid());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				// AssignmentViewVO vo1 = new AssignmentViewVO();

				assignmentlist.setActualcompletedate(rs
						.getString("ActualCompletionDate"));
				assignmentlist.setAcquiredmarks(rs.getString("AcquiredMarks"));
				assignmentlist.setRemarks(rs.getString("Remarks"));
				assignmentlist.setDescription(rs.getString("Description"));
				assignmentlist.setSectionid(rs.getString("AdmissionNo"));

				/*
				 * vo1.setClassname(rs.getString("classdetails_name_var"));
				 * vo1.setSectionname(rs.getString("classsection_name_var"));
				 * vo1.setSubjectname(rs.getString("subjectname"));
				 * vo1.setAssignmentname(rs.getString("Name"));
				 * vo1.setAccname(rs.getString("acadamic_year"));
				 * vo1.setAssignmentdate
				 * (HelperClass.convertDatabaseToUI(rs.getString
				 * ("AssignmentDate")));
				 * vo1.setCompletiondate(HelperClass.convertDatabaseToUI
				 * (rs.getString("CompletionDate")));
				 * vo1.setMaxmarks(rs.getString("MaxMarks"));
				 */

				// assignmentlist.add(vo1);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getviewAssignmentDao  Ending");

		return assignmentlist;
	}

	public StudentRegistrationVo getStudentInfoDao(ParentVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStudentInfoDao Starting");

		StudentRegistrationVo getstudinfo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			getstudinfo = new StudentRegistrationVo();

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_STUDENT_INFO_DETAILS);

			pstmt.setString(1, vo.getStudentid());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				getstudinfo.setStudentFirstName(rs
						.getString("student_fname_var"));
				getstudinfo.setStudentLastName(rs
						.getString("student_lname_var"));
				getstudinfo.setStudentAdmissionNo(rs
						.getString("student_admissionno_var"));
				getstudinfo.setApplicationNo(rs
						.getString("student_application_no"));
				getstudinfo.setDateofJoin(HelperClass.convertDatabaseToUI(rs
						.getString("student_doj_var")));
				getstudinfo.setAcademicYear(rs.getString("acadamic_year"));
				getstudinfo.setStreemname(rs.getString("classstream_name_var"));
				getstudinfo.setClassname(rs.getString("classdetails_name_var"));
				getstudinfo.setSectionnaem(rs
						.getString("classsection_name_var"));
				getstudinfo.setStudentquotaname(rs.getString("Quota_Name"));
				getstudinfo.setGrade(rs.getString("student_grade"));
				getstudinfo.setRte(rs.getString("isRTE"));
				getstudinfo.setEmisNo(rs.getString("emisNo"));
				getstudinfo.setHostel(rs.getString("isHostel"));
				getstudinfo.setConcession(rs.getString("isConcession"));
				getstudinfo.setTransport(rs.getString("isTransport"));
				getstudinfo.setTransporttypeName(rs.getString("VehicleName"));

				getstudinfo
						.setTransportlocationName(rs.getString("stage_name"));
				getstudinfo.setStudentimage(rs.getString("student_imgurl_var"));
				/*
				 * getstudinfo.(rs.getString(""));
				 * getstudinfo.setTransporttypeName(rs.getString(""));
				 */

				getstudinfo.setDateofBirth(HelperClass.convertDatabaseToUI(rs
						.getString("student_dob_var")));
				getstudinfo.setAge(rs.getString("student_age_int"));
				getstudinfo.setGender(rs.getString("student_gender_var"));
				getstudinfo.setIdentificationMarks(rs
						.getString("student_identificationmarks_var"));
				getstudinfo.setBloodGroup(rs
						.getString("student_bloodgroup_var"));
				getstudinfo.setReligion(rs.getString("student_religion_var"));
				getstudinfo.setStudentcastename(rs.getString("student_caste"));
				getstudinfo.setNationality(rs
						.getString("student_nationality_var"));
				getstudinfo.setPhysicallyChallenged(rs
						.getString("student_physicallychallenged"));
				getstudinfo.setPhysicalchalreason(rs
						.getString("physicallychallenged_reason"));
				getstudinfo.setRemarks(rs.getString("student_remarks_var"));

				getstudinfo.setSiblingName(rs
						.getString("student_siblingname_var"));
				getstudinfo.setSibilingClass(rs
						.getString("student_siblingclass_var"));
				getstudinfo.setFatherName(rs
						.getString("FatherName"));
				getstudinfo.setFatherQualification(rs
						.getString("Qualification"));
				getstudinfo.setFatherMobileNo(rs
						.getString("mobileno"));
				getstudinfo.setFatheremailId(rs
						.getString("email"));
				getstudinfo.setMotherName(rs
						.getString("student_mothername_var"));
				getstudinfo.setMotherQualification(rs
						.getString("student_motherqualification_var"));
				getstudinfo.setMotherMobileNo(rs
						.getString("student_mothermobileno_var"));
				getstudinfo.setMotheremailId(rs
						.getString("student_mother_mailid"));
				getstudinfo.setGaurdianName(rs
						.getString("student_gaurdianname_var"));
				getstudinfo.setGuardianMobileNo(rs
						.getString("student_gardian_mobileno"));
				getstudinfo.setGuardianemailId(rs
						.getString("student_gardian_mailid"));
				getstudinfo.setQuardianoccupation(rs
						.getString("gardian_occupation"));
				getstudinfo.setFatheroccupation(rs
						.getString("student_father_occupation"));
				getstudinfo.setMotheroccupation(rs
						.getString("student_mother_occupation"));
				getstudinfo.setAddress(rs.getString("address"));

				getstudinfo.setTransferfile(rs.getString("student_tc_path"));
				getstudinfo.setBirthcertificate(rs
						.getString("student_birthcert_path"));

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStudentInfoDao  Ending");
		return getstudinfo;
	}

	public String saveFeedBackDetailsDao(ParentFeedbackVo fbvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : saveFeedBackDetailsDao Starting");

		java.util.Date today = new java.util.Date();
		java.sql.Timestamp time_stamp = new java.sql.Timestamp(today.getTime());
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String status = MessageConstants.FEEDFALSE;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ParentModuleUtil.SAVE_FEEDBACK);

			pstmt.setString(1, fbvo.getFeedbackid());
			pstmt.setString(2, fbvo.getFeedbackto());
			pstmt.setString(3, fbvo.getDescription());
			pstmt.setString(4, fbvo.getAddfile());
			pstmt.setString(5, fbvo.getCreateUser());
			pstmt.setTimestamp(6, time_stamp);

			int count = pstmt.executeUpdate();

			if (count > 0) {

				status = MessageConstants.FEEDTRUE;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : saveFeedBackDetailsDao  Ending");

		return status;
	}

	public ArrayList<ParentFeedbackVo> getFeedBackDetailsDao(
			ParentFeedbackVo fbvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getFeedBackDetailsDao Starting");

		ArrayList<ParentFeedbackVo> fdlist = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int sno = 0;
		try {

			fdlist = new ArrayList<ParentFeedbackVo>();
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_FEEDBACK_DETAILS);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sno++;

				ParentFeedbackVo fdvo = new ParentFeedbackVo();

				fdvo.setSno(sno);
				fdvo.setFeedbackid(rs.getString("FeedBackCode"));
				fdvo.setFeedbackto(rs.getString("ToUser"));
				fdvo.setDescription(rs.getString("Description"));
				fdvo.setAddfile(rs.getString("FilePath"));

				fdlist.add(fdvo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getFeedBackDetailsDao  Ending");
		return fdlist;
	}

	public StudentRegistrationVo getnextStudentInfoDao(
			StudentRegistrationVo studentinfo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStudentInfoDao Starting");

		StudentRegistrationVo getstudinfo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			getstudinfo = new StudentRegistrationVo();

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_STUDENT_INFO_DETAILS);

			pstmt.setString(1, studentinfo.getStudentId());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				// StudentRegistrationVo getstudinfo = new
				// StudentRegistrationVo();
				getstudinfo.setStudentFirstName(rs
						.getString("student_fname_var"));
				getstudinfo.setStudentLastName(rs
						.getString("student_lname_var"));
				getstudinfo.setStudentAdmissionNo(rs
						.getString("student_admissionno_var"));
				getstudinfo.setApplicationNo(rs
						.getString("student_application_no"));
				getstudinfo.setDateofJoin(HelperClass.convertDatabaseToUI(rs
						.getString("student_doj_var")));
				getstudinfo.setAcademicYear(rs.getString("acadamic_year"));
				getstudinfo.setStreemname(rs.getString("classstream_name_var"));
				getstudinfo.setClassname(rs.getString("classdetails_name_var"));
				getstudinfo.setSectionnaem(rs
						.getString("classsection_name_var"));
				getstudinfo.setStudentquotaname(rs.getString("Quota_Name"));
				getstudinfo.setGrade(rs.getString("student_grade"));
				getstudinfo.setRte(rs.getString("isRTE"));
				getstudinfo.setEmisNo(rs.getString("emisNo"));
				getstudinfo.setHostel(rs.getString("isHostel"));
				getstudinfo.setConcession(rs.getString("isConcession"));
				getstudinfo.setTransport(rs.getString("isTransport"));
				getstudinfo.setTransporttypeName(rs.getString("VehicleName"));

				getstudinfo
						.setTransportlocationName(rs.getString("stage_name"));
				getstudinfo.setStudentimage(rs.getString("student_imgurl_var"));
				/*
				 * getstudinfo.(rs.getString(""));
				 * getstudinfo.setTransporttypeName(rs.getString(""));
				 */

				getstudinfo.setDateofBirth(HelperClass.convertDatabaseToUI(rs
						.getString("student_dob_var")));
				getstudinfo.setAge(rs.getString("student_age_int"));
				getstudinfo.setGender(rs.getString("student_gender_var"));
				getstudinfo.setIdentificationMarks(rs
						.getString("student_identificationmarks_var"));
				getstudinfo.setBloodGroup(rs
						.getString("student_bloodgroup_var"));
				getstudinfo.setReligion(rs.getString("student_religion_var"));
				getstudinfo.setStudentcastename(rs.getString("student_caste"));
				getstudinfo.setNationality(rs
						.getString("student_nationality_var"));
				getstudinfo.setPhysicallyChallenged(rs
						.getString("student_physicallychallenged"));
				getstudinfo.setPhysicalchalreason(rs
						.getString("physicallychallenged_reason"));
				getstudinfo.setRemarks(rs.getString("student_remarks_var"));

				getstudinfo.setSiblingName(rs
						.getString("student_siblingname_var"));
				getstudinfo.setSibilingClass(rs
						.getString("student_siblingclass_var"));
				getstudinfo.setFatherName(rs
						.getString("FatherName"));
				getstudinfo.setFatherQualification(rs
						.getString("Qualification"));
				getstudinfo.setFatherMobileNo(rs
						.getString("mobileno"));
				getstudinfo.setFatheremailId(rs
						.getString("email"));
				getstudinfo.setMotherName(rs
						.getString("student_mothername_var"));
				getstudinfo.setMotherQualification(rs
						.getString("student_motherqualification_var"));
				getstudinfo.setMotherMobileNo(rs
						.getString("student_mothermobileno_var"));
				getstudinfo.setMotheremailId(rs
						.getString("student_mother_mailid"));
				getstudinfo.setGaurdianName(rs
						.getString("student_gaurdianname_var"));
				getstudinfo.setGuardianMobileNo(rs
						.getString("student_gardian_mobileno"));
				getstudinfo.setGuardianemailId(rs
						.getString("student_gardian_mailid"));
				getstudinfo.setQuardianoccupation(rs
						.getString("gardian_occupation"));
				getstudinfo.setFatheroccupation(rs
						.getString("student_father_occupation"));
				getstudinfo.setMotheroccupation(rs
						.getString("student_mother_occupation"));
				getstudinfo.setAddress(rs.getString("address"));

				// getstudinfolist.add(getstudinfo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStudentInfoDao  Ending");

		return getstudinfo;
	}

	public ArrayList<StudentAttendanceVo> getAttendanceMonthListDao(
			String year, String month, ParentVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAttendanceMonthListDao Starting");

		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		Connection conn = null;

		ArrayList<StudentAttendanceVo> attndlist = new ArrayList<StudentAttendanceVo>();
		try {

			conn = JDBCConnection.getSeparateConnection();

			int currentYear = HelperClass.getCurrentYear();
			int mounthcount = 12;

			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_MONTH_ATTENDANCE_DETAILS);
			pstmt1 = conn
					.prepareStatement(ParentModuleUtil.GET_TOTAL_PRESENT_DETAILS);
			pstmt2 = conn
					.prepareStatement(ParentModuleUtil.GET_TOTAL_ABSENT_DETAILS);
			pstmt3 = conn
					.prepareStatement(ParentModuleUtil.GET_TOTAL_LEAVE_DETAILS);
			pstmt4 = conn
					.prepareStatement(ParentModuleUtil.GET_TOTAL_HOLIDAY_DETAILS);

			for (int i = 1; i <= mounthcount; i++) {

				StudentAttendanceVo vo1 = new StudentAttendanceVo();

				vo1.setMonth(HelperClass.getMonthFullName(i + ""));

				pstmt.setString(1, "%%-" + i + "-%%");
				pstmt.setString(2, vo.getStudentid());
				rs = pstmt.executeQuery();

				while (rs.next()) {

					vo1.setTot_count(rs.getString("attendence"));

				}

				int totaldays = HelperClass.getDaysByMonthAndYear(i,
						currentYear);

				vo1.setTotaldays(totaldays);
				vo1.setCurrentyear(currentYear);

				pstmt1.setString(1, "%%-" + i + "-%%");
				pstmt1.setString(2, vo.getStudentid());

				rs4 = pstmt1.executeQuery();

				while (rs4.next()) {

					vo1.setPresent_count(rs4.getString("attendence"));

				}

				pstmt2.setString(1, "%%-" + i + "-%%");
				pstmt2.setString(2, vo.getStudentid());

				rs1 = pstmt2.executeQuery();

				while (rs1.next()) {

					vo1.setAbsent_count(rs1.getString("attendence"));

				}

				pstmt3.setString(1, "%%-" + i + "-%%");
				pstmt3.setString(2, vo.getStudentid());

				rs2 = pstmt3.executeQuery();

				while (rs2.next()) {

					vo1.setLeave_count(rs2.getString("attendence"));

				}

				pstmt4.setString(1, "%%-" + i + "-%%");
				pstmt4.setString(2, vo.getStudentid());

				rs3 = pstmt4.executeQuery();

				while (rs3.next()) {

					vo1.setHoliday_count(rs3.getString("attendence"));

				}

				attndlist.add(vo1);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAttendanceMonthListDao  Ending");

		return attndlist;
	}

	public ArrayList<StudentAttendanceVo> getNextChildAttendanceMonthListDao(
			String year, String month, StudentAttendanceVo studvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAttendanceMonthListDao Starting");

		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		Connection conn = null;

		ArrayList<StudentAttendanceVo> attndlist = new ArrayList<StudentAttendanceVo>();
		try {

			conn = JDBCConnection.getSeparateConnection();

			int currentYear = HelperClass.getCurrentYear();
			int mounthcount = 12;

			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_MONTH_ATTENDANCE_DETAILS);
			pstmt1 = conn
					.prepareStatement(ParentModuleUtil.GET_TOTAL_PRESENT_DETAILS);
			pstmt2 = conn
					.prepareStatement(ParentModuleUtil.GET_TOTAL_ABSENT_DETAILS);
			pstmt3 = conn
					.prepareStatement(ParentModuleUtil.GET_TOTAL_LEAVE_DETAILS);
			pstmt4 = conn
					.prepareStatement(ParentModuleUtil.GET_TOTAL_HOLIDAY_DETAILS);

			for (int i = 1; i <= mounthcount; i++) {

				StudentAttendanceVo vo1 = new StudentAttendanceVo();

				vo1.setMonth(HelperClass.getMonthFullName(i + ""));

				pstmt.setString(1, "%%-" + i + "-%%");
				pstmt.setString(2, studvo.getStudentid());
				rs = pstmt.executeQuery();

				while (rs.next()) {

					vo1.setTot_count(rs.getString("attendence"));

				}

				int totaldays = HelperClass.getDaysByMonthAndYear(i,
						currentYear);

				vo1.setTotaldays(totaldays);
				vo1.setCurrentyear(currentYear);

				pstmt1.setString(1, "%%-" + i + "-%%");
				pstmt1.setString(2, studvo.getStudentid());

				rs4 = pstmt1.executeQuery();

				while (rs4.next()) {

					vo1.setPresent_count(rs4.getString("attendence"));

				}

				pstmt2.setString(1, "%%-" + i + "-%%");
				pstmt2.setString(2, studvo.getStudentid());

				rs1 = pstmt2.executeQuery();

				while (rs1.next()) {

					vo1.setAbsent_count(rs1.getString("attendence"));

				}

				pstmt3.setString(1, "%%-" + i + "-%%");
				pstmt3.setString(2, studvo.getStudentid());

				rs2 = pstmt3.executeQuery();

				while (rs2.next()) {

					vo1.setLeave_count(rs2.getString("attendence"));

				}

				pstmt4.setString(1, "%%-" + i + "-%%");
				pstmt4.setString(2, studvo.getStudentid());

				rs3 = pstmt4.executeQuery();

				while (rs3.next()) {

					vo1.setHoliday_count(rs3.getString("attendence"));

				}

				attndlist.add(vo1);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAttendanceMonthListDao  Ending");

		return attndlist;
	}

	public List<StreamDetailsVO> getStreamListDetailsDao() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStreamListDetailsDao Starting");

		List<StreamDetailsVO> streamvo = null;

		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ParentModuleUtil.GET_STREAM_DETAILS);

			streamvo = new ArrayList<StreamDetailsVO>();
			rs = pstmt.executeQuery();

			while (rs.next()) {

				StreamDetailsVO stream = new StreamDetailsVO();

				stream.setStreamId(rs.getString("classstream_id_int"));
				stream.setStreamName(rs.getString("classstream_name_var"));

				streamvo.add(stream);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStreamListDetailsDao  Ending");

		return streamvo;
	}

	public List<ClassPojo> getClassListDetailsDao(ClassPojo pojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getClassListDetailsDao Starting");

		List<ClassPojo> claspojo = new ArrayList<ClassPojo>();

		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn.prepareStatement(ParentModuleUtil.GET_CLASS_DETAILS);

			pstmt.setString(1, pojo.getStreamId());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ClassPojo getclas = new ClassPojo();
				getclas.setClassId(rs.getString("classdetail_id_int"));
				getclas.setClassName(rs.getString("classdetails_name_var"));

				claspojo.add(getclas);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getClassListDetailsDao  Ending");

		return claspojo;
	}

	public List<ViewallSubjectsVo> getSubjectDetailsDao(ViewallSubjectsVo subvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getSubjectDetailsDao Starting");

		List<ViewallSubjectsVo> subjectlist = new ArrayList<ViewallSubjectsVo>();

		Connection conn = null;
		int sno = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ParentModuleUtil.GET_SUBJECT_DETAILS);

			pstmt.setString(1, subvo.getClassid());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sno++;
				ViewallSubjectsVo vo = new ViewallSubjectsVo();
				vo.setSno(sno);
				vo.setSubjectid(rs.getString("subjectID"));
				vo.setSubjectname(rs.getString("subjectName"));
				vo.setPath(rs.getString("syllabous"));
				vo.setDescription(rs.getString("decription"));

				subjectlist.add(vo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getSubjectDetailsDao  Ending");

		return subjectlist;
	}

	public ArrayList<StudentAttendanceVo> getmoreAttendanceDayListDao(
			StudentAttendanceVo attvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAttendanceDayListDao Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int sno = 0;
		int currentYear = HelperClass.getCurrentYear();
		String month = "";

		ArrayList<StudentAttendanceVo> attndlist1 = new ArrayList<StudentAttendanceVo>();
		try {
			conn = JDBCConnection.getSeparateConnection();

			if (attvo.getMonth().equalsIgnoreCase("January")) {
				month = "01";
			} else if (attvo.getMonth().equalsIgnoreCase("February")) {

				month = "02";
			} else if (attvo.getMonth().equalsIgnoreCase("March")) {

				month = "03";
			} else if (attvo.getMonth().equalsIgnoreCase("April")) {

				month = "04";
			} else if (attvo.getMonth().equalsIgnoreCase("May")) {

				month = "05";
			} else if (attvo.getMonth().equalsIgnoreCase("June")) {

				month = "06";
			} else if (attvo.getMonth().equalsIgnoreCase("July")) {

				month = "07";
			} else if (attvo.getMonth().equalsIgnoreCase("August")) {

				month = "08";
			} else if (attvo.getMonth().equalsIgnoreCase("September")) {

				month = "09";
			} else if (attvo.getMonth().equalsIgnoreCase("October")) {

				month = "10";
			} else if (attvo.getMonth().equalsIgnoreCase("November")) {

				month = "11";
			} else if (attvo.getMonth().equalsIgnoreCase("December")) {

				month = "12";
			}

			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_DAYS_ATTENDANCE_DETAILS);

			pstmt.setString(1, attvo.getStudentid1());
			pstmt.setString(2, "%%-" + month + "-%%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				StudentAttendanceVo attvo1 = new StudentAttendanceVo();
				sno++;
				attvo1.setSno(sno);

				attvo1.setDate(HelperClass.convertDatabaseToUI(rs
						.getString("attendencedate")));
				attvo1.setStatus(rs.getString("attendence"));

				String weekday = HelperClass.getWeekDay(rs
						.getString("attendencedate"));

				attvo1.setWeekday(weekday);

				attndlist1.add(attvo1);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAttendanceDayListDao  Ending");

		return attndlist1;
	}

	public ArrayList<StudentAttendanceVo> getAttendanceDayListDao(
			StudentAttendanceVo attvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAttendanceDayListDao Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int sno = 0;
		int currentYear = HelperClass.getCurrentYear();
		String month = "";

		ArrayList<StudentAttendanceVo> attndlist = new ArrayList<StudentAttendanceVo>();
		try {
			conn = JDBCConnection.getSeparateConnection();

			if (attvo.getMonth().equalsIgnoreCase("January")) {
				month = "01";
			} else if (attvo.getMonth().equalsIgnoreCase("February")) {

				month = "02";
			} else if (attvo.getMonth().equalsIgnoreCase("March")) {

				month = "03";
			} else if (attvo.getMonth().equalsIgnoreCase("April")) {

				month = "04";
			} else if (attvo.getMonth().equalsIgnoreCase("May")) {

				month = "05";
			} else if (attvo.getMonth().equalsIgnoreCase("June")) {

				month = "06";
			} else if (attvo.getMonth().equalsIgnoreCase("July")) {

				month = "07";
			} else if (attvo.getMonth().equalsIgnoreCase("August")) {

				month = "08";
			} else if (attvo.getMonth().equalsIgnoreCase("September")) {

				month = "09";
			} else if (attvo.getMonth().equalsIgnoreCase("October")) {

				month = "10";
			} else if (attvo.getMonth().equalsIgnoreCase("November")) {

				month = "11";
			} else if (attvo.getMonth().equalsIgnoreCase("December")) {

				month = "12";
			}

			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_DAYS_ATTENDANCE_DETAILS);

			pstmt.setString(1, attvo.getStudentid());
			pstmt.setString(2, "%%-" + month + "-%%");

			rs = pstmt.executeQuery();

			while (rs.next()) {

				StudentAttendanceVo attvo1 = new StudentAttendanceVo();
				sno++;
				attvo1.setSno(sno);

				attvo1.setDate(HelperClass.convertDatabaseToUI(rs
						.getString("attendencedate")));
				attvo1.setStatus(rs.getString("attendence"));

				String weekday = HelperClass.getWeekDay(rs
						.getString("attendencedate"));

				attvo1.setWeekday(weekday);

				attndlist.add(attvo1);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getAttendanceDayListDao  Ending");

		return attndlist;
	}

	public String getfeedbackfilepathDao(String fbid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getfeedbackfilepathDao Starting");

		String path = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn.prepareStatement(ParentModuleUtil.FEEDBACK_PATH);
			pstmt.setString(1, fbid);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				path = rs.getString("FilePath");

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getfeedbackfilepathDao  Ending");

		return path;
	}

	public String getsubjectfilepathDao(String subid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getsubjectfilepathDao Starting");

		String path = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.SUBJECT_SYLLABUS_PATH);
			pstmt.setString(1, subid);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				path = rs.getString("syllabous");

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getsubjectfilepathDao  Ending");

		return path;
	}

	public ArrayList<LstmsUpcomingMeetingVO> getMeetingListDetailsDao() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getMeetingListDetailsDao Starting");

		ArrayList<LstmsUpcomingMeetingVO> meetinglist = new ArrayList<LstmsUpcomingMeetingVO>();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Connection connection = null;

		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(ParentModuleUtil.GET_ALL_MEETING_DETAILS);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				LstmsUpcomingMeetingVO meetvo = new LstmsUpcomingMeetingVO();

				String teacherid = rs.getString("TeacherId");
				String studentid = rs.getString("StudentId");

				if (teacherid.contains("TEA")) {

					meetvo.setMeetingid(rs.getString("meetingid"));
					meetvo.setMeetingDate(rs.getString("meetingdate"));
					meetvo.setStartTime(rs.getString("starttime"));
					meetvo.setEndTime(rs.getString("endtime"));
					meetvo.setTitle(rs.getString("title"));
					meetvo.setVenueid(rs.getString("venuedetails"));
					meetvo.setSubjectName(rs.getString("subjectname"));

					pstmt1 = connection
							.prepareStatement(ParentModuleUtil.GET_TEACHER_MEETING);

					pstmt1.setString(1, teacherid);

					rs1 = pstmt1.executeQuery();

					while (rs1.next()) {

						meetvo.setMeetingwith(rs1.getString("FirstName"));

					}

				}

				else if (studentid.contains("STU")) {

					meetvo.setMeetingid(rs.getString("meetingid"));
					meetvo.setMeetingDate(rs.getString("meetingdate"));
					meetvo.setStartTime(rs.getString("starttime"));
					meetvo.setEndTime(rs.getString("endtime"));
					meetvo.setTitle(rs.getString("title"));
					meetvo.setVenueid(rs.getString("venuedetails"));
					meetvo.setSubjectName(rs.getString("subjectname"));

					pstmt2 = connection
							.prepareStatement(ParentModuleUtil.GET_STUDENT_MEETING);

					pstmt2.setString(1, studentid);

					rs2 = pstmt2.executeQuery();

					while (rs2.next()) {

						meetvo.setMeetingwith(rs2
								.getString("student_fname_var"));
						meetvo.setClassname(rs2
								.getString("classdetails_name_var"));
						meetvo.setSectionname(rs2
								.getString("classsection_name_var"));

					}

				}

				meetinglist.add(meetvo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getMeetingListDetailsDao  Ending");

		return meetinglist;
	}

	public ArrayList<LstmsUpcomingMeetingVO> getstudentmeetinglistDao(
			LstmsUpcomingMeetingVO meetvo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getstudentmeetinglistDao Starting");

		ArrayList<LstmsUpcomingMeetingVO> meetinglist = new ArrayList<LstmsUpcomingMeetingVO>();
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		Connection connection = null;
		try {
			connection = JDBCConnection.getSeparateConnection();
			pstmt = connection
					.prepareStatement(ParentModuleUtil.GET_STUDENT_MEETING_DETAILS);

			pstmt.setString(1, meetvo.getStudentid());
			rs = pstmt.executeQuery();

			while (rs.next()) {

				LstmsUpcomingMeetingVO vo = new LstmsUpcomingMeetingVO();

				vo.setMeetingid(rs.getString("meetingid"));
				vo.setMeetingDate(rs.getString("meetingdate"));
				vo.setStartTime(rs.getString("starttime"));
				vo.setEndTime(rs.getString("endtime"));
				vo.setTitle(rs.getString("title"));
				vo.setVenueid(rs.getString("venuedetails"));
				vo.setSubjectName(rs.getString("subjectname"));
				vo.setMeetingwith(rs.getString("studentname"));
				vo.setClassname(rs.getString("classdetails_name_var"));
				vo.setSectionname(rs.getString("classsection_name_var"));
				vo.setStudentid(rs.getString("StudentId"));

				meetinglist.add(vo);
			}

		} catch (Exception e) {

		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getstudentmeetinglistDao  Ending");
		return meetinglist;
	}

	public String leaveRequestEntryDao(LeaveRequestVo leavevo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : leaveRequestEntryDao Starting");

		java.util.Date today = new java.util.Date();
		java.sql.Timestamp time_stamp = new java.sql.Timestamp(today.getTime());
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		String status = MessageConstants.REQUESTFALSE;

		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ParentModuleUtil.SAVE_LEAVE_REQUEST);

			pstmt.setString(1, leavevo.getRequestto());
			pstmt.setString(2, leavevo.getStudentFname());
			pstmt.setString(3, leavevo.getFromdate());
			pstmt.setString(4, leavevo.getTodate());
			pstmt.setString(5, leavevo.getStarttime());
			pstmt.setString(6, leavevo.getEndtime());
			pstmt.setString(7, leavevo.getLeavetype());
			pstmt.setString(8, leavevo.getTotalleave());
			pstmt.setString(9, leavevo.getReason());
			pstmt.setString(10, leavevo.getFileupload());
			pstmt.setString(11, "NOTAPPROVED");
			pstmt.setString(12, leavevo.getCreateuser());
			pstmt.setTimestamp(13, time_stamp);

			int count = pstmt.executeUpdate();

			if (count > 0) {

				status = MessageConstants.REQUESTTRUE;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : leaveRequestEntryDao  Ending");

		return status;
	}

	public ArrayList<LeaveRequestVo> getleaveRequestDetailDao(
			LeaveRequestVo leavevo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getleaveRequestDetailDao Starting");

		ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int sno1 = 0;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_LEAVE_REQUEST_DETAILS);
			
			System.out.println("pstmtpstmt"+pstmt);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				sno1++;

				LeaveRequestVo vo1 = new LeaveRequestVo();

				vo1.setSno(rs.getInt("SNO"));
				vo1.setTotalleave(rs.getString("NoofLeaves"));

				vo1.setFromdate(HelperClass.convertDatabaseToUI(rs
						.getString("StartDate")));
				vo1.setTodate(HelperClass.convertDatabaseToUI(rs
						.getString("EndDate")));
				vo1.setStarttime(rs.getString("SessionStart"));
				vo1.setEndtime(rs.getString("SessionEnd"));
				vo1.setStatus(rs.getString("LeaveStatus"));
				vo1.setReason(rs.getString("ReasonForLeave"));
				vo1.setLeavetype(rs.getString("LeaveType"));
				vo1.setRequestto(rs.getString("teachername"));
				vo1.setStudentname(rs.getString("studentname"));
				vo1.setRequestby(rs.getString("type"));

				leavelist.add(vo1);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SQLUtilConstants.GET_LEAVE_REQUEST_DETAILS);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				sno1++;

				LeaveRequestVo vo1 = new LeaveRequestVo();

				vo1.setSno(rs.getInt("SNO"));
				vo1.setTotalleave(rs.getString("NoofLeaves"));

				vo1.setFromdate(HelperClass.convertDatabaseToUI(rs
						.getString("StartDate")));
				vo1.setTodate(HelperClass.convertDatabaseToUI(rs
						.getString("EndDate")));
				vo1.setStarttime(rs.getString("SessionStart"));
				vo1.setEndtime(rs.getString("SessionEnd"));
				vo1.setStatus(rs.getString("LeaveStatus"));
				vo1.setReason(rs.getString("ReasonForLeave"));
				vo1.setLeavetype(rs.getString("LeaveType"));
				vo1.setRequestto(rs.getString("teachername"));

				vo1.setRequestby(rs.getString("type"));

				leavelist.add(vo1);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getleaveRequestDetailDao  Ending");

		return leavelist;
	}

	public LeaveRequestVo getRequestLeaveDao(int sno) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getRequestLeaveDao Starting");

		LeaveRequestVo leavelist = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			leavelist = new LeaveRequestVo();
			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn.prepareStatement(ParentModuleUtil.GET_LEAVE_DETAILS);

			pstmt.setInt(1, sno);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				leavelist.setRequestto(rs.getString("teachername"));
				leavelist.setTotalleave(rs.getString("NoofLeaves"));
				leavelist.setFromdate(HelperClass.convertDatabaseToUI(rs
						.getString("StartDate")));
				leavelist.setTodate(HelperClass.convertDatabaseToUI(rs
						.getString("EndDate")));
				leavelist.setStarttime(rs.getString("RequestStartTime"));
				leavelist.setEndtime(rs.getString("RequestEndTime"));
				leavelist.setLeavetype(rs.getString("LeaveType"));
				leavelist.setFileupload(rs.getString("filepaath"));
				leavelist.setReason(rs.getString("ReasonForLeave"));
				leavelist.setRequesttoid(rs.getString("RequestedTo"));
				leavelist.setSno(sno);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getRequestLeaveDao  Ending");

		return leavelist;
	}

	public String updateleaveRequestEntryDao(LeaveRequestVo leavevo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updateleaveRequestEntryDao Starting");

		java.util.Date today = new java.util.Date();
		java.sql.Timestamp time_stamp = new java.sql.Timestamp(today.getTime());
		PreparedStatement pstmt = null;
		int rs = 0;
		String result = "";

		Connection conn = null;

		String status = MessageConstants.REQUESTFALSE;

		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.UPDATE_LEAVE_REQUEST);

			pstmt.setString(1, leavevo.getRequestto());
			pstmt.setString(2, leavevo.getTotalleave());
			pstmt.setString(3, leavevo.getFromdate());
			pstmt.setString(4, leavevo.getTodate());
			pstmt.setString(5, leavevo.getStarttime());
			pstmt.setString(6, leavevo.getEndtime());
			pstmt.setString(7, leavevo.getLeavetype());
			pstmt.setString(8, leavevo.getFileupload());
			pstmt.setString(9, leavevo.getReason());
			pstmt.setTimestamp(10, time_stamp);
			pstmt.setString(11, leavevo.getCreateuser());
			pstmt.setString(12, "NOTAPPROVED");
			pstmt.setString(13, leavevo.getStudentid());
			pstmt.setInt(14, leavevo.getSno());

			rs = pstmt.executeUpdate();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : updateleaveRequestEntryDao  Ending");
		return result;
	}

	public LeaveRequestVo deleteRequestLeaveDao(int sno,String userid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : deleteRequestLeaveDao Starting");

		LeaveRequestVo leavelist = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String check = "";
		int leavecount = 0;

		try {


			if (leavecount == 0) {
				leavelist = new LeaveRequestVo();
				conn = JDBCConnection.getSeparateConnection();

				pstmt = conn
						.prepareStatement(ParentModuleUtil.DELETE_TEACHER_LEAVE_DETAILS);

				pstmt.setInt(1, sno);

				int count = pstmt.executeUpdate();

				if (count > 0) {

					check = MessageConstants.DELETE_SUCCESS_LEAVE;
				} else {
					check = MessageConstants.DELETE_FAIL_LEAVE;
				}
			} else {

				check = MessageConstants.DELETE_WARNING_LEAVE;

			}
	
			
			if(userid.contains("PAR")){
				
				
				System.out.println("delete parent");
				
				conn = JDBCConnection.getSeparateConnection();
				
				pstmt = conn.prepareStatement(ParentModuleUtil.DELETE_STUDENT_LEAVE_DETAILS);
				
				pstmt.setInt(1, sno);
				
				System.out.println("pstmt parent"+pstmt);
				
				int count =pstmt.executeUpdate();
				
				if (count > 0) {

					check = MessageConstants.DELETE_SUCCESS_LEAVE;
				} else {
					check = MessageConstants.DELETE_FAIL_LEAVE;
				}
				
			
			}
			
			else if(userid.contains("TEA")){
				
				System.out.println("delete teachet");
				
				conn = JDBCConnection.getSeparateConnection();
				
				pstmt = conn.prepareStatement(ParentModuleUtil.DELETE_TEACHER_LEAVE_DETAILS);
				
				pstmt.setInt(1, sno);
				
				System.out.println("pstmt teacher"+pstmt);
				
				int count =pstmt.executeUpdate();
				
				if (count > 0) {

					check = MessageConstants.DELETE_SUCCESS_LEAVE;
				} else {
					check = MessageConstants.DELETE_FAIL_LEAVE;
				}
				
				
				
			}
			
			
			/*if(leavecount==0){
			leavelist = new LeaveRequestVo();
			conn = JDBCConnection.getSeparateConnection();
			
			pstmt = conn
					.prepareStatement(ParentModuleUtil.DELETE_LEAVE_DETAILS);
			 
			
			pstmt.setInt(1, sno);
			
			
			
			int count =pstmt.executeUpdate();*/
			//}
			
		

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : deleteRequestLeaveDao  Ending");
		return null;
	}

	public ArrayList<TimeTableVo> getStudentTimetableDao(String studentid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStudentTimetableDao Starting");
		ArrayList<TimeTableVo> timetablelist = new ArrayList<TimeTableVo>();
		ResultSet rs = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;

		String timetableid = null;
		String classSection = null;
		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn.prepareStatement(ParentModuleUtil.GET_TIMETABLE_ID);

			pstmt.setString(1, studentid);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				timetableid = rs.getString("timetable_id");
				classSection = rs.getString("classname");

			}

			pstmt1 = conn
					.prepareStatement(ParentModuleUtil.GET_STUDENT_TIME_TABLE);

			pstmt1.setString(1, timetableid);

			rs1 = pstmt1.executeQuery();

			while (rs1.next()) {

				TimeTableVo tableVo = new TimeTableVo();

				tableVo.setDayname(rs1.getString("dayname"));
				tableVo.setDayid(rs1.getString("daycode"));
				tableVo.setPeriod1(rs1.getString("period1"));
				tableVo.setPeriod2(rs1.getString("period2"));
				tableVo.setPeriod3(rs1.getString("period3"));
				tableVo.setPeriod4(rs1.getString("period4"));
				tableVo.setPeriod5(rs1.getString("period5"));
				tableVo.setPeriod6(rs1.getString("period6"));
				tableVo.setPeriod7(rs1.getString("period7"));
				tableVo.setPeriod8(rs1.getString("period8"));

				String dayname = rs1.getString("dayname");

				tableVo.setPeriod1(getSubjectfName(rs1.getString("period1"))
						+ "-"
						+ (getTeacherName("period1", dayname, classSection)));
				tableVo.setPeriod2(getSubjectfName(rs1.getString("period2"))
						+ "-"
						+ (getTeacherName("period2", dayname, classSection)));
				tableVo.setPeriod3(getSubjectfName(rs1.getString("period3"))
						+ "-"
						+ (getTeacherName("period3", dayname, classSection)));
				tableVo.setPeriod4(getSubjectfName(rs1.getString("period4"))
						+ "-"
						+ (getTeacherName("period4", dayname, classSection)));
				tableVo.setPeriod5(getSubjectfName(rs1.getString("period5"))
						+ "-"
						+ (getTeacherName("period5", dayname, classSection)));
				tableVo.setPeriod6(getSubjectfName(rs1.getString("period6"))
						+ "-"
						+ (getTeacherName("period6", dayname, classSection)));
				tableVo.setPeriod7(getSubjectfName(rs1.getString("period7"))
						+ "-"
						+ (getTeacherName("period7", dayname, classSection)));
				tableVo.setPeriod8(getSubjectfName(rs1.getString("period8"))
						+ "-"
						+ (getTeacherName("period8", dayname, classSection)));

				timetablelist.add(tableVo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStudentTimetableDao  Ending");

		return timetablelist;
	}

	public String getTeacherName(String period, String dayname,
			String classSection) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimeTableDaoImpl : getTeacherName Starting");

		String teachername = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;

		try {

			connection = JDBCConnection.getSeparateConnection();

			String query = "select t.FirstName from campus_timetable_teacherdetails tt,campus_teachers t,campus_timetable_teacher timt where tt.teachertimetable_id=timt.teachertimetable_id and timt.teacherid=t.TeacherID and daycode='"
					+ dayname + "' and " + period + "='" + classSection + "'";

			pstmt = connection.prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				teachername = rs.getString("FirstName");

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getTeacherName  Ending");

		return teachername;

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
		String subjectName = null;

		try {
			connection = JDBCConnection.getSeparateConnection();

			pstmt = connection
					.prepareStatement(ParentModuleUtil.GET_SUBJECT_NAME);
			pstmt.setString(1, subjectId);

			rst = pstmt.executeQuery();

			while (rst.next()) {

				subjectName = rst.getString("subjectName");
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

	public ArrayList<TimeTableVo> getFirstStudentTimeTableDao(ParentVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getFirstStudentTimeTableDao Starting");

		ArrayList<TimeTableVo> timetablelist = new ArrayList<TimeTableVo>();
		ResultSet rs = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;

		String timetableid = null;

		String classSection = null;
		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn.prepareStatement(ParentModuleUtil.GET_TIMETABLE_ID);

			pstmt.setString(1, vo.getStudentid());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				timetableid = rs.getString("timetable_id");
				classSection = rs.getString("classname");

			}

			pstmt1 = conn
					.prepareStatement(ParentModuleUtil.GET_STUDENT_TIME_TABLE);

			pstmt1.setString(1, timetableid);

			rs1 = pstmt1.executeQuery();

			while (rs1.next()) {

				TimeTableVo tableVo = new TimeTableVo();

				tableVo.setDayname(rs1.getString("dayname"));
				tableVo.setDayid(rs1.getString("daycode"));
				tableVo.setPeriod1(rs1.getString("period1"));
				tableVo.setPeriod2(rs1.getString("period2"));
				tableVo.setPeriod3(rs1.getString("period3"));
				tableVo.setPeriod4(rs1.getString("period4"));
				tableVo.setPeriod5(rs1.getString("period5"));
				tableVo.setPeriod6(rs1.getString("period6"));
				tableVo.setPeriod7(rs1.getString("period7"));
				tableVo.setPeriod8(rs1.getString("period8"));

				String dayname = rs1.getString("dayname");

				tableVo.setPeriod1(getSubjectfName(rs1.getString("period1"))
						+ "-"
						+ (getTeacherName("period1", dayname, classSection)));
				tableVo.setPeriod2(getSubjectfName(rs1.getString("period2"))
						+ "-"
						+ (getTeacherName("period2", dayname, classSection)));
				tableVo.setPeriod3(getSubjectfName(rs1.getString("period3"))
						+ "-"
						+ (getTeacherName("period3", dayname, classSection)));
				tableVo.setPeriod4(getSubjectfName(rs1.getString("period4"))
						+ "-"
						+ (getTeacherName("period4", dayname, classSection)));
				tableVo.setPeriod5(getSubjectfName(rs1.getString("period5"))
						+ "-"
						+ (getTeacherName("period5", dayname, classSection)));
				tableVo.setPeriod6(getSubjectfName(rs1.getString("period6"))
						+ "-"
						+ (getTeacherName("period6", dayname, classSection)));
				tableVo.setPeriod7(getSubjectfName(rs1.getString("period7"))
						+ "-"
						+ (getTeacherName("period7", dayname, classSection)));
				tableVo.setPeriod8(getSubjectfName(rs1.getString("period8"))
						+ "-"
						+ (getTeacherName("period8", dayname, classSection)));

				timetablelist.add(tableVo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getStudentTimetableDao  Ending");

		return timetablelist;
	}

	//Listingpage
	public ArrayList<LeaveRequestVo> getleaveApprovalDetailDao(
			LeaveRequestVo leavevo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getleaveApprovalDetailDao Starting");

		ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int sno1 = 0;
		try {

			if (leavevo.getUsertype().equalsIgnoreCase("admin")) {

				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn
						.prepareStatement(ParentModuleUtil.GET_LEAVE_APPROVED_BY_ADMIN);

				pstmt.setString(1, leavevo.getUserid());

				rs = pstmt.executeQuery();

				while (rs.next()) {

					sno1++;

					LeaveRequestVo vo1 = new LeaveRequestVo();

					vo1.setSno(rs.getInt("SNO"));
					vo1.setRequestby(rs.getString("name"));

					vo1.setTotalleave(rs.getString("NoofLeaves"));
					vo1.setReason(rs.getString("ReasonForLeave").trim());
					vo1.setFromdate(HelperClass.convertDatabaseToUI(rs
							.getString("StartDate")));
					vo1.setTodate(HelperClass.convertDatabaseToUI(rs
							.getString("EndDate")));
					vo1.setRequesteddate(HelperClass.convertDatabaseToUI(rs
							.getString("RequestedDate")));
					vo1.setStatus(rs.getString("LeaveStatus"));
					vo1.setLeavetype(rs.getString("LeaveType"));
					leavelist.add(vo1);
				}

				PreparedStatement pstmt1 = conn
						.prepareStatement(ParentModuleUtil.GET_LEAVE_APPROVED_BY_TEACHER);

				pstmt1.setString(1, leavevo.getUserid());

				rs = pstmt1.executeQuery();

				while (rs.next()) {

					sno1++;

					LeaveRequestVo vo1 = new LeaveRequestVo();

					vo1.setSno(rs.getInt("SNO"));
					vo1.setRequestby(rs.getString("name"));

					vo1.setTotalleave(rs.getString("NoofLeaves"));
					vo1.setReason(rs.getString("ReasonForLeave").trim());
					vo1.setFromdate(HelperClass.convertDatabaseToUI(rs
							.getString("StartDate")));
					vo1.setTodate(HelperClass.convertDatabaseToUI(rs
							.getString("EndDate")));
					vo1.setRequesteddate(HelperClass.convertDatabaseToUI(rs
							.getString("RequestedDate")));
					vo1.setStatus(rs.getString("LeaveStatus"));
					vo1.setLeavetype(rs.getString("LeaveType"));

					leavelist.add(vo1);
				}

			} else {

				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn
						.prepareStatement(ParentModuleUtil.GET_LEAVE_APPROVED_BY_TEACHER);

				pstmt.setString(1, leavevo.getUserid());

				rs = pstmt.executeQuery();

				while (rs.next()) {

					sno1++;

					LeaveRequestVo vo1 = new LeaveRequestVo();

					vo1.setSno(rs.getInt("SNO"));

					vo1.setRequestby(rs.getString("name"));

					vo1.setTotalleave(rs.getString("NoofLeaves"));

					vo1.setReason(rs.getString("ReasonForLeave").trim());

					vo1.setFromdate(HelperClass.convertDatabaseToUI(rs
							.getString("StartDate")));
					vo1.setTodate(HelperClass.convertDatabaseToUI(rs
							.getString("EndDate")));

					vo1.setRequesteddate(HelperClass.convertDatabaseToUI(rs
							.getString("RequestedDate")));

					vo1.setStatus(rs.getString("LeaveStatus"));

					vo1.setLeavetype(rs.getString("LeaveType"));

					leavelist.add(vo1);

				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getleaveApprovalDetailDao  Ending");

		return leavelist;
	}

	public List<UserDetailVO> getRequestUserListDao(String user) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getRequestUserListDao Starting");

		List<UserDetailVO> userlist = new ArrayList<UserDetailVO>();

		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			/*if (user.contains("PAR")) 
			{

			 conn = JDBCConnection.getSeparateConnection();*/
			
			if(user.contains("PAR"))
			{
			
				pstmt = conn
						.prepareStatement(ParentModuleUtil.GET_PARENT_USER_DETAILS);

			

				rs = pstmt.executeQuery();

				while (rs.next()) {

					UserDetailVO getuser = new UserDetailVO();

					getuser.setEployeecode(rs.getString("employeecode"));
					getuser.setTeachername(rs.getString("teachername"));

					getuser.setClassname(rs.getString("classdetails_name_var"));
					getuser.setTeacherid(rs.getString("teacherID"));

					userlist.add(getuser);
				}

			} else {

				pstmt = conn
						.prepareStatement(ParentModuleUtil.GET_TEACHER_USER_DETAILS);

				rs = pstmt.executeQuery();

				while (rs.next()) {

					UserDetailVO getuser = new UserDetailVO();

					getuser.setEployeecode(rs.getString("employeecode"));

					getuser.setTeachername(rs.getString("teachername"));

					userlist.add(getuser);

				}

			}

		/*} */
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		
	
			JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getRequestUserListDao  Ending");

		return userlist;

	}

	public LeaveRequestVo getLeaveApprovalDao(int sno)

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getRequestLeaveDao Starting");

		/*
		 * LeaveRequestVo leavevo = new LeaveRequestVo();
		 * 
		 * leavevo.setUserid("TEA23"); leavevo.setUsertype("admin");
		 * 
		 * JSONArray array=new JSONArray(); array.put(new
		 * ParentSettingsDaoImpl().getleaveApprovalDetailDao(leavevo));
		 * System.out.println(array);
		 */

		LeaveRequestVo leavelist = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			leavelist = new LeaveRequestVo();
			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_LEAVE_FOR_APPROVE_DETAILS_TEACHER);

			pstmt.setInt(1, sno);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				leavelist.setRequestby(rs.getString("RequestedBy"));
				leavelist.setRequesttype(rs.getString("type"));
				leavelist.setFromdate(HelperClass.convertDatabaseToUI(rs
						.getString("StartDate")));
				leavelist.setTodate(HelperClass.convertDatabaseToUI(rs
						.getString("EndDate")));
				leavelist.setStartsessionDay(rs.getString("SessionStart"));
				leavelist.setEndsessionDay(rs.getString("SessionEnd"));

				leavelist.setLeavetype(rs.getString("LeaveType"));
				leavelist.setTotalleave(rs.getString("NoofLeaves"));
				leavelist.setReason(rs.getString("ReasonForLeave"));

			}
			pstmt = conn
					.prepareStatement(ParentModuleUtil.GET_LEAVE_FOR_APPROVE_DETAILS_STUDENT);

			pstmt.setInt(1, sno);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				leavelist.setRequestby(rs.getString("RequestedBy"));
				leavelist.setRequesttype(rs.getString("type"));
				leavelist.setFromdate(HelperClass.convertDatabaseToUI(rs
						.getString("StartDate")));

				leavelist.setTodate(HelperClass.convertDatabaseToUI(rs
						.getString("EndDate")));
				leavelist.setStartsessionDay(rs.getString("SessionStart"));
				leavelist.setEndsessionDay(rs.getString("SessionEnd"));

				leavelist.setLeavetype(rs.getString("LeaveType"));
				leavelist.setTotalleave(rs.getString("NoofLeaves"));
				leavelist.setReason(rs.getString("ReasonForLeave"));

			}

		}

		catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getRequestLeaveDao  Ending");

		return leavelist;
	}

	public ArrayList<LeaveRequestVo> ApprovingLeaveforleaveRequestDAO(
			LeaveRequestVo leavevo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getleaveApprovalDetailDao Starting");
		java.util.Date today = new java.util.Date();
		java.sql.Timestamp time_stamp = new java.sql.Timestamp(today.getTime());
		ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		int rs = 0;
		Connection conn = null;
		int sno1 = 0;
		try {

			if (leavevo.getUsertype().equalsIgnoreCase("admin")) {

				System.out
						.println("Admin DAOimpl ForApprovingLeaveforleaveRequestDAO is working");

				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn
						.prepareStatement(ParentModuleUtil.GET_LEAVE_APPROVING_BY_ADMIN);

				pstmt.setString(1, leavevo.getLeavesapproved());
				pstmt.setString(2, HelperClass.convertUIToDatabase(leavevo
						.getApprovedstartdate()));

				pstmt.setString(3, HelperClass.convertUIToDatabase(leavevo
						.getApprovedenddate()));

				pstmt.setString(4, leavevo.getApprovedleavestatus());

				pstmt.setString(5, leavevo.getComments());

				pstmt.setString(6, leavevo.getUserid());

				pstmt.setTimestamp(7, time_stamp);

				pstmt.setString(8, leavevo.getApprovedstartsessionDay());

				pstmt.setString(9, leavevo.getApprovedendsessionDay());

				pstmt.setInt(10, leavevo.getSno());

				System.out.println("pstmt" + pstmt);
				rs = pstmt.executeUpdate();
				System.out.println("rs" + rs);

				pstmt1 = conn
						.prepareStatement(ParentModuleUtil.GET_LEAVE_APPROVING_BY_TEACHER);

				pstmt1.setString(1, leavevo.getLeavesapproved());

				pstmt1.setString(2, HelperClass.convertUIToDatabase(leavevo
						.getApprovedstartdate()));

				pstmt1.setString(3, HelperClass.convertUIToDatabase(leavevo
						.getApprovedenddate()));

				pstmt1.setString(4, leavevo.getApprovedleavestatus());

				pstmt1.setString(5, leavevo.getComments());

				pstmt1.setString(6, leavevo.getUserid());
				pstmt1.setTimestamp(7, time_stamp);
				pstmt1.setString(8, leavevo.getApprovedstartsessionDay());

				pstmt1.setString(9, leavevo.getApprovedendsessionDay());

				pstmt1.setInt(10, leavevo.getSno());

				System.out.println("pstmt1" + pstmt1);
				rs = pstmt1.executeUpdate();
				System.out.println("rs" + rs);
			} else {

				System.out
						.println("teacher DAOimpl ForApprovingLeaveforleaveRequestDAO is working");
				conn = JDBCConnection.getSeparateConnection();

				pstmt1 = conn
						.prepareStatement(ParentModuleUtil.GET_LEAVE_APPROVING_BY_TEACHER);

				pstmt1.setString(1, leavevo.getLeavesapproved());
				pstmt1.setString(2, HelperClass.convertUIToDatabase(leavevo
						.getApprovedstartdate()));

				pstmt1.setString(3, HelperClass.convertUIToDatabase(leavevo
						.getApprovedenddate()));

				pstmt1.setString(4, leavevo.getApprovedleavestatus());

				pstmt1.setString(5, leavevo.getComments());

				pstmt1.setString(6, leavevo.getUserid());
				pstmt1.setTimestamp(7, time_stamp);
				pstmt1.setString(8, leavevo.getApprovedstartsessionDay());

				pstmt1.setString(9, leavevo.getApprovedendsessionDay());

				pstmt1.setInt(10, leavevo.getSno());

				System.out.println("pstmt1" + pstmt1);
				rs = pstmt1.executeUpdate();
				System.out.println("rs" + rs);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getleaveApprovalDetailDao  Ending");

		return leavelist;
	}

	@Override
	public ArrayList<LeaveRequestVo> searchleave(String searchTerm) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterDaoImpl:searchRole Starting");
		ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();
		int count=0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
/*			pstmt = conn.prepareStatement(RoleMasterSqlConstants.SEARCH_ROLE);
*/			
			pstmt = conn.prepareStatement(ParentModuleUtil.GET_LEAVE_SEARCH_BY_ADMIN);

			
			
			pstmt.setString(1, "%"+searchTerm+"%");
			pstmt.setString(2, "%"+searchTerm+"%");
			pstmt.setString(3, "%"+searchTerm+"%");
			pstmt.setString(4, "%"+searchTerm+"%");
			pstmt.setString(5, "%"+searchTerm+"%");
			pstmt.setString(6, "%"+searchTerm+"%");
			pstmt.setString(7, "%"+searchTerm+"%");
			pstmt.setString(8, "%"+searchTerm+"%");
			pstmt.setString(9, "%"+searchTerm+"%");
			pstmt.setString(10, "%"+searchTerm+"%");
			pstmt.setString(11, "%"+searchTerm+"%");
			
			rs = pstmt.executeQuery();
			
			System.out.println("searchleavepstmt"+pstmt);
			
			while (rs.next()) {

				count++;

				LeaveRequestVo vo1 = new LeaveRequestVo();

				vo1.setSno(rs.getInt("SNO"));
				vo1.setRequestby(rs.getString("name"));

				vo1.setTotalleave(rs.getString("NoofLeaves"));
				vo1.setReason(rs.getString("ReasonForLeave").trim());
				vo1.setFromdate(HelperClass.convertDatabaseToUI(rs
						.getString("StartDate")));
				vo1.setTodate(HelperClass.convertDatabaseToUI(rs
						.getString("EndDate")));
				vo1.setRequesteddate(HelperClass.convertDatabaseToUI(rs
						.getString("RequestedDate")));
				vo1.setStatus(rs.getString("LeaveStatus"));
				vo1.setLeavetype(rs.getString("LeaveType"));
				leavelist.add(vo1);
			}
			
			PreparedStatement pstmt1 = conn
					.prepareStatement(ParentModuleUtil.GET_LEAVE_SEARCH_BY_TEACHER);

			pstmt1.setString(1, "%"+searchTerm+"%");
			pstmt1.setString(2, "%"+searchTerm+"%");
			pstmt1.setString(3, "%"+searchTerm+"%");
			pstmt1.setString(4, "%"+searchTerm+"%");
			pstmt1.setString(5, "%"+searchTerm+"%");
			pstmt1.setString(6, "%"+searchTerm+"%");
			pstmt1.setString(7, "%"+searchTerm+"%");
			pstmt1.setString(8, "%"+searchTerm+"%");
			pstmt1.setString(9, "%"+searchTerm+"%");
			pstmt1.setString(10, "%"+searchTerm+"%");
			pstmt1.setString(11, "%"+searchTerm+"%");
			
			System.out.println("searchleavepstmt"+pstmt1);


			rs = pstmt1.executeQuery();

			while (rs.next()) {

				count++;

				LeaveRequestVo vo1 = new LeaveRequestVo();

				vo1.setSno(rs.getInt("SNO"));
				vo1.setRequestby(rs.getString("name"));

				vo1.setTotalleave(rs.getString("NoofLeaves"));
				vo1.setReason(rs.getString("ReasonForLeave").trim());
				vo1.setFromdate(HelperClass.convertDatabaseToUI(rs
						.getString("StartDate")));
				vo1.setTodate(HelperClass.convertDatabaseToUI(rs
						.getString("EndDate")));
				vo1.setRequesteddate(HelperClass.convertDatabaseToUI(rs
						.getString("RequestedDate")));
				vo1.setStatus(rs.getString("LeaveStatus"));
				vo1.setLeavetype(rs.getString("LeaveType"));

				leavelist.add(vo1);
			}
			
			
			
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterDaoImpl:searchRole Ending");

		// TODO Auto-generated method stub
		return leavelist;
	}

	@Override
	public ArrayList<LeaveRequestVo> searchleaverequest(String searchTerm) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getleaveRequestDetailDao Starting");

		ArrayList<LeaveRequestVo> leavelist = new ArrayList<LeaveRequestVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		int sno1 = 0;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(ParentModuleUtil.SEARCH_LEAVE_REQUEST_DETAILS);

			
			pstmt.setString(1, "%"+searchTerm+"%");
			pstmt.setString(2, "%"+searchTerm+"%");
			pstmt.setString(3, "%"+searchTerm+"%");
			pstmt.setString(4, "%"+searchTerm+"%");
			pstmt.setString(5, "%"+searchTerm+"%");
			pstmt.setString(6, "%"+searchTerm+"%");
			pstmt.setString(7, "%"+searchTerm+"%");
			pstmt.setString(8, "%"+searchTerm+"%");
			pstmt.setString(9, "%"+searchTerm+"%");
			pstmt.setString(10, "%"+searchTerm+"%");
			pstmt.setString(11, "%"+searchTerm+"%");
			pstmt.setString(12, "%"+searchTerm+"%");
			pstmt.setString(13, "%"+searchTerm+"%");
			
			System.out.println("pstmtpstmt"+pstmt);
			
			rs = pstmt.executeQuery();
			System.out.println("rsrs"+rs);

			while (rs.next()) {

				sno1++;

				LeaveRequestVo vo1 = new LeaveRequestVo();

				vo1.setSno(rs.getInt("SNO"));
				vo1.setTotalleave(rs.getString("NoofLeaves"));

				vo1.setFromdate(HelperClass.convertDatabaseToUI(rs
						.getString("StartDate")));
				vo1.setTodate(HelperClass.convertDatabaseToUI(rs
						.getString("EndDate")));
				vo1.setStarttime(rs.getString("SessionStart"));
				vo1.setEndtime(rs.getString("SessionEnd"));
				vo1.setStatus(rs.getString("LeaveStatus"));
				vo1.setReason(rs.getString("ReasonForLeave"));
				vo1.setLeavetype(rs.getString("LeaveType"));
				vo1.setRequestto(rs.getString("teachername"));
				vo1.setStudentname(rs.getString("studentname"));
				vo1.setRequestby(rs.getString("type"));

				leavelist.add(vo1);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SQLUtilConstants.SEARCH_LEAVE_REQUEST_DETAILS);

			pstmt.setString(1, "%"+searchTerm+"%");
			pstmt.setString(2, "%"+searchTerm+"%");
			pstmt.setString(3, "%"+searchTerm+"%");
			pstmt.setString(4, "%"+searchTerm+"%");
			pstmt.setString(5, "%"+searchTerm+"%");
			pstmt.setString(6, "%"+searchTerm+"%");
			pstmt.setString(7, "%"+searchTerm+"%");
			pstmt.setString(8, "%"+searchTerm+"%");
			pstmt.setString(9, "%"+searchTerm+"%");
			pstmt.setString(10, "%"+searchTerm+"%");
			pstmt.setString(11, "%"+searchTerm+"%");
			
			System.out.println("pstmtpstmtpstmtpstmt"+pstmt);
			
			rs = pstmt.executeQuery();
			System.out.println("rsrsrsrs"+rs);
			

			while (rs.next()) {

				sno1++;

				LeaveRequestVo vo1 = new LeaveRequestVo();

				vo1.setSno(rs.getInt("SNO"));
				vo1.setTotalleave(rs.getString("NoofLeaves"));

				vo1.setFromdate(HelperClass.convertDatabaseToUI(rs
						.getString("StartDate")));
				vo1.setTodate(HelperClass.convertDatabaseToUI(rs
						.getString("EndDate")));
				vo1.setStarttime(rs.getString("SessionStart"));
				vo1.setEndtime(rs.getString("SessionEnd"));
				vo1.setStatus(rs.getString("LeaveStatus"));
				vo1.setReason(rs.getString("ReasonForLeave"));
				vo1.setLeavetype(rs.getString("LeaveType"));
				vo1.setRequestto(rs.getString("teachername"));

				vo1.setRequestby(rs.getString("type"));

				leavelist.add(vo1);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TransportDaoImpl : getleaveRequestDetailDao  Ending");

		return leavelist;
	}

}
