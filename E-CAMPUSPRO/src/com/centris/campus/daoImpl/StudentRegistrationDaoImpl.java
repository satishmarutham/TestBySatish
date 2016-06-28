/**
 * 
 */
package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.dao.StudentRegistrationDao;
import com.centris.campus.forms.StudentRegistrationForm;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.SQLUtilConstants;
import com.centris.campus.util.SendMail;
import com.centris.campus.util.StudentRegistrationSQLUtilConstants;
import com.centris.campus.util.StringUtilContants;
import com.centris.campus.vo.StageMasterVo;
import com.centris.campus.vo.StudentInfoVO;
import com.centris.campus.vo.StudentRegistrationVo;
import com.centris.campus.vo.TransportTypeVO;
import com.centris.campus.vo.ViewallSubjectsVo;
import com.centris.campus.vo.registrationvo;

/**
 * @author sathish
 * 
 */
public class StudentRegistrationDaoImpl implements StudentRegistrationDao {
	ArrayList<String> dobList = new ArrayList<String>();
	String dob = null;
	String duplicateStudentName = null;
	String stuAdmissionNo = null;
	String academicYear = "";
	String regno = null;

	/**
	 * Logger instance.
	 */
	private static final Logger logger = Logger
			.getLogger(StudentRegistrationDaoImpl.class);
	
	
	// To Get student related dropdown values

	public List<StudentRegistrationVo> getAcademicYear() throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getAcademicYear Starting");
		List<StudentRegistrationVo> studentRegistrationVos = new ArrayList<StudentRegistrationVo>();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			preparedStatement = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_ACADEMIC_YEAR);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				StudentRegistrationVo studentRegistrationVo = new StudentRegistrationVo();
				studentRegistrationVo.setAcademicYear(resultSet
						.getString(MessageConstants.AcademicYear));
				studentRegistrationVo.setAcademicYearId(resultSet
						.getString(MessageConstants.AcademicYearId));

				studentRegistrationVos.add(studentRegistrationVo);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && (!resultSet.isClosed())) {
					resultSet.close();
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
				+ " Control in StudentRegistrationDaoImpl : getAcademicYear Ending");
		return studentRegistrationVos;
	}

	public int getStudentMaxId() throws SQLException {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getStudentMaxId Starting");
		PreparedStatement pst = null;
		ResultSet rs = null;
		int studentMaxid = 0;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_STUDENT_MAXID);
			rs = pst.executeQuery();
			while (rs.next()) {
				studentMaxid = rs.getInt(1);
			}
			if (studentMaxid == 0) {
				studentMaxid = 1;
			}

		} catch (Exception e) {

			logger.error(e);
		} finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : getStudentMaxId Ending");
		return studentMaxid;
	}

	@Override
	public List<StudentRegistrationVo> getStudentquota() throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getStudentquota Starting");
		List<StudentRegistrationVo> studentRegistrationVos = new ArrayList<StudentRegistrationVo>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			preparedStatement = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_STUDENT_QUOTA);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				StudentRegistrationVo studentRegistrationVo = new StudentRegistrationVo();
				studentRegistrationVo.setStudentquotaname(resultSet
						.getString("Quota_Name"));
				studentRegistrationVo.setStudentquotaid(resultSet
						.getString("Quota_Code"));

				studentRegistrationVos.add(studentRegistrationVo);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && (!resultSet.isClosed())) {
					resultSet.close();
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
				+ " Control in StudentRegistrationDaoImpl : getStudentquota Ending");
		return studentRegistrationVos;
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<StudentRegistrationVo> getStudentCaste() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getStudentCaste Starting");
		List<StudentRegistrationVo> studentReAdmissionVOList = new ArrayList<StudentRegistrationVo>();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			preparedStatement = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_STUDENT_CASTE);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				StudentRegistrationVo studentReAdmissionVO = new StudentRegistrationVo();
				studentReAdmissionVO.setStudentcastename(resultSet
						.getString("caste_name"));
				studentReAdmissionVO.setStudentcasteid(resultSet
						.getString("caste_id"));

				studentReAdmissionVOList.add(studentReAdmissionVO);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && (!resultSet.isClosed())) {
					resultSet.close();
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
				+ " Control in  StudentRegistrationDaoImpl : getStudentCaste Ending");
		return studentReAdmissionVOList;
	}
	
	public List<StudentRegistrationVo> getChildCategory() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getChildCategory  Starting");
		List<StudentRegistrationVo> categorylist = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_CATEGORY);

			rs = pst.executeQuery();
			while (rs.next()) {
				StudentRegistrationVo registrationVo = new StudentRegistrationVo();
				registrationVo
						.setStreemcode(rs.getString("classstream_id_int"));
				registrationVo.setStreemname(rs
						.getString("classstream_name_var"));
				categorylist.add(registrationVo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : getChildCategory  Ending");
		// TODO Auto-generated method stub

		return categorylist;
	}

	public List<StudentRegistrationVo> getClassDetails(String catecory) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getClassDetails  Starting");
		List<StudentRegistrationVo> list = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_CLASS);
			pst.setString(1, catecory);
			rs = pst.executeQuery();
			while (rs.next()) {
				StudentRegistrationVo registrationVo = new StudentRegistrationVo();
				registrationVo.setClasscode(rs.getString("classdetail_id_int"));
				registrationVo.setClassname(rs
						.getString("classdetails_name_var"));
				list.add(registrationVo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : getClassDetails  Ending");
		// TODO Auto-generated method stub

		return list;
	}

	public List<StudentRegistrationVo> getSection(String classval) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getSection  Starting");
		List<StudentRegistrationVo> list = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_SECTION);
			pst.setString(1, classval);
			rs = pst.executeQuery();
			while (rs.next()) {
				StudentRegistrationVo registrationVo = new StudentRegistrationVo();
				registrationVo.setSectioncode(rs
						.getString("classsection_id_int"));
				registrationVo.setSectionnaem(rs
						.getString("classsection_name_var"));
				list.add(registrationVo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : getSection  Ending");
		// TODO Auto-generated method stub

		return list;
	}

	public List<StudentRegistrationVo> getConcessionDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getConcessionDetails  Starting");
		List<StudentRegistrationVo> list = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_CONCESSION);

			rs = pst.executeQuery();
			while (rs.next()) {
				StudentRegistrationVo registrationVo = new StudentRegistrationVo();
				registrationVo.setConcessionid(rs.getString("concessionid"));
				registrationVo.setConcession(rs.getString("concessionname"));
				list.add(registrationVo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : getConcessionDetails  Ending");
		// TODO Auto-generated method stub

		return list;
	}

	public List<TransportTypeVO> transportypedetails() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : transportypedetails  Starting");
		List<TransportTypeVO> list = new ArrayList<TransportTypeVO>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.TRANSPORT_TYPE);

			rs = pst.executeQuery();
			while (rs.next()) {
				TransportTypeVO registrationVo = new TransportTypeVO();
				registrationVo.setTransptyId(rs.getString("type_id"));
				registrationVo.setTransptyname(rs.getString("type_name"));
				list.add(registrationVo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : transportypedetails  Ending");

		// TODO Auto-generated method stub

		return list;

	}

	public List<StageMasterVo> getStageDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getStageDetails  Starting");
		List<StageMasterVo> list = new ArrayList<StageMasterVo>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.TRANSPORT_LOCATION);

			rs = pst.executeQuery();
			while (rs.next()) {
				StageMasterVo registrationVo = new StageMasterVo();
				registrationVo.setStageCode(rs.getString("stage_id"));
				registrationVo.setStageName(rs.getString("stage_name"));
				list.add(registrationVo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : getStageDetails  Ending");
		// TODO Auto-generated method stub
		return list;

	}

	public String getTransportCategoryType(String trnsportTypeId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getTransportCategoryType Starting");

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String transportTypeStatus = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			preparedStatement = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_TRANSPORTSTATUS_TYPE);
			preparedStatement.setString(1, trnsportTypeId);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				transportTypeStatus = rs.getString("type_collectFee");

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
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentRegistrationDaoImpl : getTransportCategoryType Ending");
		return transportTypeStatus;
	}
	
	public ArrayList<ViewallSubjectsVo> getSubjectByClass(String classID) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl: getSubjectByClass Starting");
		PreparedStatement pstmObj = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<ViewallSubjectsVo> subjectList = new ArrayList<ViewallSubjectsVo>();

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmObj = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_SUBJECT_DETAILS);
			pstmObj.setString(1, classID);

			rs = pstmObj.executeQuery();

			while (rs.next()) {

				ViewallSubjectsVo vo = new ViewallSubjectsVo();
				vo.setSubjectid(rs.getString("subjectID"));
				vo.setSubjectname(rs.getString("subjectName"));

				subjectList.add(vo);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (pstmObj != null && (!pstmObj.isClosed())) {
					pstmObj.close();
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
				+ " Control in StudentRegistrationDaoImpl: getSubjectByClass  Ending");
		return subjectList;
	}
	
	//For validation
	
	@Override
	public int validateDuplicateData(StudentRegistrationForm formObj,
			String type) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : validateDuplicateData Starting");
		PreparedStatement pstmt = null;

		int count = 0;
		ResultSet rst = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			if (type.equalsIgnoreCase("Add")) {

				pstmt = conn
						.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_DUPLICATE_CHECK_ADDTIME);
				pstmt.setString(1, formObj.getStudentFirstName());
				pstmt.setString(2, formObj.getCategory());
				pstmt.setString(3, formObj.getStudClassId());
				pstmt.setString(4, formObj.getStudSectionId());

				if (formObj.getFatherName() != null) {
					pstmt.setString(5, formObj.getFatherName().trim());
				} else {
					pstmt.setString(5, "");
				}
				if (formObj.getMotherName() != null) {
					pstmt.setString(6, formObj.getMotherName().trim());
				} else {
					pstmt.setString(6, "");
				}
				if (formObj.getDateofBirth() != null) {
					pstmt.setString(7, HelperClass.convertUIToDatabase(formObj
							.getDateofBirth().trim()));
				} else {
					pstmt.setString(7, "");
				}
				if (formObj.getDateofJoin() != null) {
					pstmt.setString(8, HelperClass.convertUIToDatabase(formObj
							.getDateofJoin().trim()));
				} else {
					pstmt.setString(8, "");
				}

				pstmt.setString(9, formObj.getAcademicYear());

				rst = pstmt.executeQuery();

				while (rst.next()) {
					count = rst.getInt(1);
				}
			} else {
				pstmt = conn
						.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_DUPLICATE_CHECK_UPDATETIME);
				pstmt.setString(1, formObj.getStudentFirstName());
				pstmt.setString(2, formObj.getCategory());
				pstmt.setString(3, formObj.getStudClassId());
				pstmt.setString(4, formObj.getStudSectionId());

				if (formObj.getFatherName() != null) {
					pstmt.setString(5, formObj.getFatherName());
				} else {
					pstmt.setString(5, "");
				}
				if (formObj.getMotherName() != null) {
					pstmt.setString(6, formObj.getMotherName());
				} else {
					pstmt.setString(6, "");
				}
				if (formObj.getDateofBirth() != null) {
					pstmt.setString(7, HelperClass.convertUIToDatabase(formObj
							.getDateofBirth()));
				} else {
					pstmt.setString(7, "");
				}
				if (formObj.getDateofJoin() != null) {
					pstmt.setString(8, HelperClass.convertUIToDatabase(formObj
							.getDateofJoin()));
				} else {
					pstmt.setString(8, "");
				}
				pstmt.setString(9, formObj.getAcademicYear());
				pstmt.setString(10, formObj.getStudentIDgenerator());
				rst = pstmt.executeQuery();

				while (rst.next()) {
					count = rst.getInt(1);
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
				if (rst != null && (!rst.isClosed())) {
					rst.close();
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
				+ " Control in  StudentRegistrationDaoImpl : validateDuplicateData Ending");
		return count;
	}

	public String validateRollNumber(String rollNumber) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : validateRollNumber Starting");
		PreparedStatement preparedStatement = null;
		String successMessage = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			preparedStatement = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.CHECK_ROLL_NUMBER);
			preparedStatement.setString(1, rollNumber);
			rs = preparedStatement.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				successMessage = "True";
			} else {
				successMessage = "False";
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
				+ " Control in  StudentRegistrationDaoImpl : validateRollNumber Ending");
		return successMessage;

	}

	@Override
	public String checkApplicationNo(String applicationNo) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : checkApplicationNo Starting");
		PreparedStatement preparedStatement = null;
		String successMessage = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			preparedStatement = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.CHECK_APPLICATION_NUMBER);
			preparedStatement.setString(1, applicationNo);
			rs = preparedStatement.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				successMessage = "Application No already Exists";
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
				+ " Control in  StudentRegistrationDaoImpl : checkApplicationNo Ending");
		return successMessage;
	}
	
	@Override
	public String validatePhoneNo(String phoneNo) throws Exception {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : validatePhoneNo Starting");
		PreparedStatement preparedStatement = null;
		String successMessage = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			preparedStatement = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.COUNT_PARENT_PHONENO);

			preparedStatement.setString(1, phoneNo);
			preparedStatement.setString(2, phoneNo);
			preparedStatement.setString(3, phoneNo);

			rs = preparedStatement.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				successMessage = "Mobile No already Exists";
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
				+ " Control in  StudentRegistrationDaoImpl : validatePhoneNo Ending");
		return successMessage;

	}

	@Override
	public String validateEmail(String email) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : validateEmail Starting");
		PreparedStatement preparedStatement = null;
		String successMessage = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			preparedStatement = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.COUNT_PARENT_EMAILS);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, email);

			rs = preparedStatement.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				successMessage = "Email already Exists";
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
				+ " Control in  StudentRegistrationDaoImpl : validateEmail Ending");
		return successMessage;

	}

	//To save student
	
	@Override
	public Map<String, String> saveStudentRegistration(
			StudentRegistrationForm registration) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : saveStudentRegistration Starting");

		
		int result = 0;
		String relationship = "";
		Map<String, String> studentIDAdmissionNOMap = new HashMap<String, String>();
		PreparedStatement precategoryName = null;
		Connection conn = null;
		Savepoint sp = null;
		String categoryName=null;
		PreparedStatement academicYearpre=null;
		String className = null;
		String sectionName = null;
		PreparedStatement prclassName = null;
		PreparedStatement prsectionName = null;
		PreparedStatement pstmcount = null;
		
		
		try {

			
			conn = JDBCConnection.getSeparateConnection();

			conn.setAutoCommit(false);
			
			sp = conn.setSavepoint("SavaStudent");

			precategoryName = conn.prepareStatement(StudentRegistrationSQLUtilConstants.CLASS_STREAM);
			precategoryName.setString(1, registration.getCategory());

			ResultSet resultSetcategoryName = precategoryName.executeQuery();
			
			while (resultSetcategoryName.next()) {
				
				categoryName = resultSetcategoryName.getString("classstream_name_var");
			}
			
			academicYearpre = conn.prepareStatement(StudentRegistrationSQLUtilConstants.GET_ACADEMIC_YEAR_BYID);
			academicYearpre.setString(1, registration.getAcademicYear());

			ResultSet rsacademicYear = academicYearpre.executeQuery();

			String academicYear = "";

			while (rsacademicYear.next()) {
				academicYear = rsacademicYear.getString("acadamic_year");
			}
			academicYearpre.close();

			prclassName = conn.prepareStatement(StudentRegistrationSQLUtilConstants.CLASS_NAME);
			prclassName.setString(1, registration.getStudClassId());
			
			ResultSet resultSetclassName = prclassName.executeQuery();

			while (resultSetclassName.next()) {
				className = resultSetclassName.getString("classdetails_name_var");
			}

			prsectionName = conn.prepareStatement(StudentRegistrationSQLUtilConstants.SECTION_NAME);

			prsectionName.setString(1, registration.getStudSectionId());
			ResultSet resultSetsectionName = prsectionName.executeQuery();

			while (resultSetsectionName.next()) {
				
				sectionName = resultSetsectionName.getString("classsection_name_var");

			}
			
			pstmcount = conn.prepareStatement(StudentRegistrationSQLUtilConstants.COUNT_ACADEMIC_YEAR);
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

			PreparedStatement pstmclasscount = conn.prepareStatement(StudentRegistrationSQLUtilConstants.COUNT_CLASS);
			pstmclasscount.setString(1, registration.getStudClassId());
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
			
			int studentDuplicateCount = 0;
			
			
			//To check duplicate student

			PreparedStatement countDuplicate = conn.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_DUPLICATE);
			countDuplicate.setString(1, registration.getStudentFirstName());
			countDuplicate.setString(2, registration.getCategory());
			countDuplicate.setString(3, registration.getStudClassId());
			countDuplicate.setString(4, registration.getStudSectionId());

			if (registration.getFatherName() != null) {
				countDuplicate.setString(5, registration.getFatherName());
			} else {
				countDuplicate.setString(5, "");
			}
			if (registration.getMotherName() != null) {
				countDuplicate.setString(6, registration.getMotherName());
			} else {
				countDuplicate.setString(6, "");
			}
			countDuplicate.setString(7, HelperClass.convertUIToDatabase(registration.getDateofBirth()));
			countDuplicate.setString(8, HelperClass.convertUIToDatabase(registration.getDateofJoin().trim()));
			
			ResultSet duplicateRs = countDuplicate.executeQuery();

			while (duplicateRs.next()) {
				
				studentDuplicateCount = duplicateRs.getInt(1);
			}

			if (studentDuplicateCount != 0) {

				studentIDAdmissionNOMap.put("duplicateMessage",
						"Student Already Registered with these Details");
			} else {
				
				conn.setAutoCommit(false);
				
				
				//To store  student details
				
				PreparedStatement preparedStatement = conn
						.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_REGISTRATION);

				Timestamp createdDate = HelperClass.getCurrentTimestamp();
				
				preparedStatement.setString(1, registration.getStudentIDgenerator().trim());
				preparedStatement.setString(2, studentRegNo); //For roll number
				preparedStatement.setString(3, registration.getStudentrollno().trim()); //For addmission Number
				preparedStatement.setString(4, registration.getCategory().trim());
				preparedStatement.setString(5, registration.getAcademicYear().trim());
				preparedStatement.setString(6, registration.getStudClassId().trim());
				preparedStatement.setString(7, registration.getStudSectionId().trim());
				preparedStatement.setString(8, stuAdmissionNo); // For registartion number
				preparedStatement.setString(9, registration.getStudentFirstName().trim());
				preparedStatement.setString(10, registration.getStudentLastName().trim());
				preparedStatement.setString(11, HelperClass.convertUIToDatabase((registration.getDateofBirth().trim())));
				preparedStatement.setString(12, registration.getGender().trim());
				preparedStatement.setString(13, registration.getBloodGroup().trim());
				preparedStatement.setString(14, registration.getAge().trim());
				preparedStatement.setString(15, registration.getStudentPhoto().trim());
				preparedStatement.setDate(16, HelperClass.getSqlDateFromDdMmYyFormat(registration.getDateofJoin().trim()));
				preparedStatement.setString(17, registration.getReligion().trim());
				preparedStatement.setString(18, registration.getNationality().trim());
				preparedStatement.setString(19, registration.getScholarShip().trim());
				preparedStatement.setString(20, "NOTPROMOTED".trim());
				preparedStatement.setString(21, registration.getPhysicallyChallenged().trim());
				preparedStatement.setString(22, registration.getIdentificationMarks().trim());
				preparedStatement.setString(23, registration.getGrade().trim());
				preparedStatement.setString(24,registration.getStudentSibilingIdInt());
				preparedStatement.setString(25, "active");
				preparedStatement.setString(26, registration.getPreviousHistory().trim());
				preparedStatement.setString(27, registration.getRemarks().trim());
				preparedStatement.setString(28, registration.getCreateUser().trim());
				preparedStatement.setTimestamp(29, createdDate);
				preparedStatement.setString(30, registration.getStudentquotaname().trim());
				preparedStatement.setString(31, registration.getStudentcastename().trim());
				preparedStatement.setString(32, registration.getApplicationNo().trim());
				preparedStatement.setString(33, registration.getTransport().trim());
				preparedStatement.setString(34, registration.getHostel().trim());
				preparedStatement.setString(35, registration.getCencession().trim());
				preparedStatement.setString(36, registration.getRte().trim());
				preparedStatement.setString(37, registration.getTranscategory().trim());
				preparedStatement.setString(38, registration.getTranslocation().trim());
				preparedStatement.setString(39, registration.getEmisNo().trim());
				preparedStatement.setString(40, registration.getPhysicalchalreason().trim());
				preparedStatement.setString(41, registration.getTransferfile());
				preparedStatement.setString(42, registration.getBirthfile());
				
				
				result = preparedStatement.executeUpdate();
				
				preparedStatement.close();
				
				
				
				//Parent Details 
				

				String parentId =null;
				
				
				if (registration.getParentId()==null || "".equalsIgnoreCase(registration.getParentId())) {
					
					PreparedStatement preParentReg = (PreparedStatement) JDBCConnection.getStatement(StudentRegistrationSQLUtilConstants.PARENT_REG);
					
					 parentId = IDGenerator.getPrimaryKeyID("campus_parents");
					
					String parentUserName = parentId.substring(3);

					if (registration.getPrimaryPerson().equals("father")) {
						
						relationship = "father";
						
						String fatherName = registration.getFatherName();
						fatherName = fatherName.replaceAll(" ", "");
						
						preParentReg.setString(1, parentId);
						preParentReg.setString(2, registration.getFatherName());
						preParentReg.setString(3, registration.getFatherQualification());
						preParentReg.setString(4, registration.getFatherMobileNo());
						preParentReg.setString(5, registration.getFatheremailId());
						preParentReg.setString(6, registration.getFatheroccupation());
						preParentReg.setString(7, registration.getMotherName());
						preParentReg.setString(8, registration.getMotherMobileNo());
						preParentReg.setString(9, registration.getMotherQualification());
						preParentReg.setString(10, registration.getMotheremailId());
						preParentReg.setString(11, registration.getMotheroccupation());
						preParentReg.setString(12, registration.getGuardianName());
						preParentReg.setString(13, registration.getGuardianemailId());
						preParentReg.setString(14, registration.getGuardianMobileNo());
						preParentReg.setString(15, fatherName.concat(parentUserName));
						preParentReg.setString(16, fatherName.concat(parentUserName));
						preParentReg.setString(17, registration.getAddress());
						preParentReg.setString(18, registration.getCreateUser());
						preParentReg.setTimestamp(19, HelperClass.getCurrentTimestamp());
						preParentReg.setString(20, "Active");
						

						Thread.sleep(1000);
						if (registration.getFatheremailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getFatheremailId().trim(), fatherName
									.concat(parentUserName), fatherName
									.concat(parentUserName));
						}
						
					} else if (registration.getPrimaryPerson().equals("mother")) {
						
						relationship = "mother";
						String motherName = registration.getMotherName();
						motherName = motherName.replaceAll(" ", "");
						
						preParentReg.setString(1, parentId);
						preParentReg.setString(2, registration.getFatherName());
						preParentReg.setString(3, registration.getFatherQualification());
						preParentReg.setString(4, registration.getFatherMobileNo());
						preParentReg.setString(5, registration.getFatheremailId());
						preParentReg.setString(6, registration.getFatheroccupation());
						preParentReg.setString(7, registration.getMotherName());
						preParentReg.setString(8, registration.getMotherMobileNo());
						preParentReg.setString(9, registration.getMotherQualification());
						preParentReg.setString(10, registration.getMotheremailId());
						preParentReg.setString(11, registration.getMotheroccupation());
						preParentReg.setString(12, registration.getGuardianName());
						preParentReg.setString(13, registration.getGuardianemailId());
						preParentReg.setString(14, registration.getGuardianMobileNo());
						preParentReg.setString(15, motherName.concat(parentUserName));
						preParentReg.setString(16, motherName.concat(parentUserName));
						preParentReg.setString(17, registration.getAddress());
						preParentReg.setString(18, registration.getCreateUser());
						preParentReg.setTimestamp(19, HelperClass.getCurrentTimestamp());
						preParentReg.setString(20, "Active");

						Thread.sleep(1000);
						if (registration.getMotheremailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getMotheremailId().trim(), motherName
									.concat(parentUserName), motherName
									.concat(parentUserName));
						}
					
					} else {
						relationship = "guardian";

						String guardianName = registration.getGuardianName();
						guardianName = guardianName.replaceAll(" ", " ");
						
						preParentReg.setString(1, parentId);
						preParentReg.setString(2, registration.getFatherName());
						preParentReg.setString(3, registration.getFatherQualification());
						preParentReg.setString(4, registration.getFatherMobileNo());
						preParentReg.setString(5, registration.getFatheremailId());
						preParentReg.setString(6, registration.getFatheroccupation());
						preParentReg.setString(7, registration.getMotherName());
						preParentReg.setString(8, registration.getMotherMobileNo());
						preParentReg.setString(9, registration.getMotherQualification());
						preParentReg.setString(10, registration.getMotheremailId());
						preParentReg.setString(11, registration.getMotheroccupation());
						preParentReg.setString(12, registration.getGuardianName());
						preParentReg.setString(13, registration.getGuardianemailId());
						preParentReg.setString(14, registration.getGuardianMobileNo());
						preParentReg.setString(15, guardianName.concat(parentUserName));
						preParentReg.setString(16, guardianName.concat(parentUserName));
						preParentReg.setString(17, registration.getAddress());
						preParentReg.setString(18, registration.getCreateUser());
						preParentReg.setTimestamp(19, HelperClass.getCurrentTimestamp());
						preParentReg.setString(20, "Active");

						Thread.sleep(1000);
						if (registration.getGuardianemailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getGuardianemailId().trim(), guardianName
									.concat(parentUserName), guardianName
									.concat(parentUserName));
						}
					}

					
					preParentReg.execute();
					preParentReg.close();
					
				}else{
					
					PreparedStatement preParentReg = (PreparedStatement) JDBCConnection
							.getStatement(StudentRegistrationSQLUtilConstants.UPDATE_PARENT_INFORMATION);
				
					parentId = registration.getParentId().trim();
					String parentUserName = parentId.substring(3);

					if (registration.getPrimaryPerson().equals("father")) {
						
						relationship = "father";
						
						String fatherName = registration.getFatherName();
						fatherName = fatherName.replaceAll(" ", "");
						
						preParentReg.setString(1, registration.getFatherName());
						preParentReg.setString(2, registration.getFatherQualification());
						preParentReg.setString(3, registration.getFatherMobileNo());
						preParentReg.setString(4, registration.getFatheremailId());
						preParentReg.setString(5, registration.getFatheroccupation());
						preParentReg.setString(6, registration.getMotherName());
						preParentReg.setString(7, registration.getMotherMobileNo());
						preParentReg.setString(8, registration.getMotherQualification());
						preParentReg.setString(9, registration.getMotheremailId());
						preParentReg.setString(10, registration.getMotheroccupation());
						preParentReg.setString(11, registration.getGuardianName());
						preParentReg.setString(12, registration.getGuardianemailId());
						preParentReg.setString(13, registration.getGuardianMobileNo());
						preParentReg.setString(14, fatherName.concat(parentUserName));
						preParentReg.setString(15, fatherName.concat(parentUserName));
						preParentReg.setString(16, registration.getAddress());
						preParentReg.setString(17, registration.getCreateUser());
						preParentReg.setTimestamp(18, HelperClass.getCurrentTimestamp());
						preParentReg.setString(19, parentId);

						Thread.sleep(1000);
						if (registration.getFatheremailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getFatheremailId().trim(), fatherName
									.concat(parentUserName), fatherName
									.concat(parentUserName));
						}
						
					}else if (registration.getPrimaryPerson().equals("mother")) {
						
						relationship = "mother";
						String motherName = registration.getMotherName();
						motherName = motherName.replaceAll(" ", "");
						
						preParentReg.setString(1, registration.getFatherName());
						preParentReg.setString(2, registration.getFatherQualification());
						preParentReg.setString(3, registration.getFatherMobileNo());
						preParentReg.setString(4, registration.getFatheremailId());
						preParentReg.setString(5, registration.getFatheroccupation());
						preParentReg.setString(6, registration.getMotherName());
						preParentReg.setString(7, registration.getMotherMobileNo());
						preParentReg.setString(8, registration.getMotherQualification());
						preParentReg.setString(9, registration.getMotheremailId());
						preParentReg.setString(10, registration.getMotheroccupation());
						preParentReg.setString(11, registration.getGuardianName());
						preParentReg.setString(12, registration.getGuardianemailId());
						preParentReg.setString(13, registration.getGuardianMobileNo());
						preParentReg.setString(14, motherName.concat(parentUserName));
						preParentReg.setString(15, motherName.concat(parentUserName));
						preParentReg.setString(16, registration.getAddress());
						preParentReg.setString(17, registration.getCreateUser());
						preParentReg.setTimestamp(18, HelperClass.getCurrentTimestamp());
						preParentReg.setString(19, parentId);
						

						Thread.sleep(1000);
						if (registration.getMotheremailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getMotheremailId().trim(), motherName
									.concat(parentUserName), motherName
									.concat(parentUserName));
						}
					} else {
						relationship = "guardian";

						String guardianName = registration.getGuardianName();
						guardianName = guardianName.replaceAll(" ", " ");
						
						preParentReg.setString(1, registration.getFatherName());
						preParentReg.setString(2, registration.getFatherQualification());
						preParentReg.setString(3, registration.getFatherMobileNo());
						preParentReg.setString(4, registration.getFatheremailId());
						preParentReg.setString(5, registration.getFatheroccupation());
						preParentReg.setString(6, registration.getMotherName());
						preParentReg.setString(7, registration.getMotherMobileNo());
						preParentReg.setString(8, registration.getMotherQualification());
						preParentReg.setString(9, registration.getMotheremailId());
						preParentReg.setString(10, registration.getMotheroccupation());
						preParentReg.setString(11, registration.getGuardianName());
						preParentReg.setString(12, registration.getGuardianemailId());
						preParentReg.setString(13, registration.getGuardianMobileNo());
						preParentReg.setString(14, guardianName.concat(parentUserName));
						preParentReg.setString(15, guardianName.concat(parentUserName));
						preParentReg.setString(16, registration.getAddress());
						preParentReg.setString(17, registration.getCreateUser());
						preParentReg.setTimestamp(18, HelperClass.getCurrentTimestamp());
						preParentReg.setString(19, parentId);

						Thread.sleep(1000);
						
						if (registration.getGuardianemailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getGuardianemailId().trim(), guardianName
									.concat(parentUserName), guardianName
									.concat(parentUserName));
						}
					}

					
					preParentReg.executeUpdate(); 
					
					preParentReg.close();
					
					
				}
				
				

				PreparedStatement preChildParentUpdate = conn.prepareStatement(StudentRegistrationSQLUtilConstants.PARENT_CHILD_INSERT);

				
				
				if (registration.getPrimaryPerson().equals("father")) {
					
					relationship = "father";
					
				} else if (registration.getPrimaryPerson().equals("mother")) {
					
					relationship = "mother";
					
				} else {

					relationship = "guardian";
					
				}
				
				preChildParentUpdate.setString(1, relationship);
				preChildParentUpdate.setString(2, parentId.trim());
				preChildParentUpdate.setString(3, registration.getStudentIDgenerator().trim());
				
				
				preChildParentUpdate.executeUpdate();
				
				
				PreparedStatement ps_parentChaildsUpdate = conn.prepareStatement(StudentRegistrationSQLUtilConstants.PARENT_CHILDS_UPDATE);

				if (registration.getPrimaryPerson().equals("father")) {
					
					relationship = "father";
					
				} else if (registration.getPrimaryPerson().equals("mother")) {
					
					relationship = "mother";
					
				} else {

					relationship = "guardian";
					
				}
				
				ps_parentChaildsUpdate.setString(1, relationship);
				ps_parentChaildsUpdate.setString(2, parentId.trim());
				
				
				ps_parentChaildsUpdate.executeUpdate();

				
				
				//Updating Enquiry Details
				
				if (registration.getEnquiryId() != null) {

					PreparedStatement enquiryUpdate = conn
							.prepareStatement(StudentRegistrationSQLUtilConstants.UPDATE_ENQUIRY_DETAILS);
					enquiryUpdate.setString(1, "Y");
					enquiryUpdate.setString(2, registration
							.getStudentIDgenerator().trim());
					enquiryUpdate.setString(3, registration.getCreateUser()
							.trim());
					enquiryUpdate.setTimestamp(4,
							HelperClass.getCurrentTimestamp());
					enquiryUpdate.setString(5, registration.getEnquiryId());
					
					
					enquiryUpdate.executeUpdate();

					enquiryUpdate.close();
				}

				conn.commit();

				if (result > 0) {
					studentIDAdmissionNOMap.put("successMessage",
							"Student Registered SuccessFully");

				} else {
					studentIDAdmissionNOMap.put("errorMessage",
							"Student Not Registered");

				}

			}

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
		return studentIDAdmissionNOMap;
	}

	//TO modify Student
	
	//To modify student details
	
	@Override
	public String modifyStudentDetails(StudentRegistrationForm registration) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : modifyStudentDetails Starting");
		
		String successMsg = null;
		String relationship = "";
		int resultModify = 0;
		ResultSet rsClass = null;
		ResultSet rsImagePath = null;
		PreparedStatement preChildParentUpdate = null;
		PreparedStatement preParentRegUpdate = null;
		PreparedStatement getImagePath = null;
		PreparedStatement pstmclasscount = null;
		PreparedStatement academicYearpre = null;
		ResultSet rsacademicYear = null;
		ResultSet resultSetclassName = null;
		PreparedStatement prclassName = null;
		ResultSet rsacademicYearId = null;
		ResultSet duplicateRs = null;
		PreparedStatement pstmmodifyObj = null;
		PreparedStatement pstmacademicYearId = null;
		Connection conn = null;
		PreparedStatement ps_parentChaildsUpdate=null;
	
		try {
			
			conn = JDBCConnection.getSeparateConnection();
			
				pstmmodifyObj = conn.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_REGISTRATION_MODIFY);
				
			

				pstmmodifyObj.setString(1, registration.getStudentrollno());
				pstmmodifyObj.setString(2, registration.getCategory().trim());
				pstmmodifyObj.setString(3, registration.getAcademicYear().trim());
				pstmmodifyObj.setString(4, registration.getStudClassId().trim());
				pstmmodifyObj.setString(5, registration.getStudSectionId().trim());
				pstmmodifyObj.setString(6, registration.getStudentFirstName().trim());
				pstmmodifyObj.setString(7, registration.getStudentLastName().trim());
				pstmmodifyObj.setString(8, HelperClass.convertUIToDatabase(registration.getDateofBirth().trim()));
				pstmmodifyObj.setString(9, registration.getGender().trim());
				pstmmodifyObj.setString(10, registration.getBloodGroup().trim());
				pstmmodifyObj.setString(11, registration.getAge().trim());
				pstmmodifyObj.setString(12, registration.getImageFileName());
				pstmmodifyObj.setString(13, HelperClass.convertUIToDatabase(registration.getDateofJoin().trim()));
				pstmmodifyObj.setString(14, registration.getReligion().trim());
				pstmmodifyObj.setString(15, registration.getNationality().trim());
				pstmmodifyObj.setString(16, registration.getScholarShip().trim());
				pstmmodifyObj.setString(17, "Promoted");
				pstmmodifyObj.setString(18, registration.getPhysicallyChallenged().trim());
				pstmmodifyObj.setString(19, registration.getIdentificationMarks().trim());
				pstmmodifyObj.setString(20, registration.getGrade().trim());
				pstmmodifyObj.setString(21, registration.getStudentSibilingIdInt().trim());
				pstmmodifyObj.setString(22, registration.getStudentstatus().trim());
				pstmmodifyObj.setString(23, registration.getPreviousHistory().trim());
				pstmmodifyObj.setString(24, registration.getRemarks().trim());
				pstmmodifyObj.setString(25, registration.getModifyUser().trim());
				pstmmodifyObj.setString(26, HelperClass.getCurrentTimestamp().toString());
				pstmmodifyObj.setString(27, registration.getStudentquotaname().trim());
				pstmmodifyObj.setString(28, registration.getStudentcastename().trim());
				pstmmodifyObj.setString(29, registration.getApplicationNo().trim());
				pstmmodifyObj.setString(30, registration.getTransport().trim());
				pstmmodifyObj.setString(31, registration.getHostel().trim());
				pstmmodifyObj.setString(32, registration.getCencession());
				pstmmodifyObj.setString(33, registration.getRte());
				pstmmodifyObj.setString(34, registration.getTranscategory());
				pstmmodifyObj.setString(35, registration.getTranslocation());
				pstmmodifyObj.setString(36, registration.getEmisNo().trim());
				pstmmodifyObj.setString(37, registration.getTransferfile().trim());
				pstmmodifyObj.setString(38, registration.getBirthfile().trim());
				pstmmodifyObj.setString(39,registration.getStudentId().trim());
				
				
				resultModify = pstmmodifyObj.executeUpdate();
				
				//Parent Details 
				

				String parentId =null;
				
				
				if (registration.getParentId()==null || "".equalsIgnoreCase(registration.getParentId())) {
					
					PreparedStatement preParentReg = (PreparedStatement) JDBCConnection.getStatement(StudentRegistrationSQLUtilConstants.PARENT_REG);
					
					 parentId = IDGenerator.getPrimaryKeyID("campus_parents");
					
					String parentUserName = parentId.substring(3);

					if (registration.getPrimaryPerson().equals("father")) {
						
						relationship = "father";
						
						String fatherName = registration.getFatherName();
						fatherName = fatherName.replaceAll(" ", "");
						
						preParentReg.setString(1, parentId);
						preParentReg.setString(2, registration.getFatherName());
						preParentReg.setString(3, registration.getFatherQualification());
						preParentReg.setString(4, registration.getFatherMobileNo());
						preParentReg.setString(5, registration.getFatheremailId());
						preParentReg.setString(6, registration.getFatheroccupation());
						preParentReg.setString(7, registration.getMotherName());
						preParentReg.setString(8, registration.getMotherMobileNo());
						preParentReg.setString(9, registration.getMotherQualification());
						preParentReg.setString(10, registration.getMotheremailId());
						preParentReg.setString(11, registration.getMotheroccupation());
						preParentReg.setString(12, registration.getGuardianName());
						preParentReg.setString(13, registration.getGuardianemailId());
						preParentReg.setString(14, registration.getGuardianMobileNo());
						preParentReg.setString(15, fatherName.concat(parentUserName));
						preParentReg.setString(16, fatherName.concat(parentUserName));
						preParentReg.setString(17, registration.getAddress());
						preParentReg.setString(18, registration.getCreateUser());
						preParentReg.setTimestamp(19, HelperClass.getCurrentTimestamp());
						preParentReg.setString(20, "Active");
						

						Thread.sleep(1000);
						if (registration.getFatheremailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getFatheremailId().trim(), fatherName
									.concat(parentUserName), fatherName
									.concat(parentUserName));
						}
						
					} else if (registration.getPrimaryPerson().equals("mother")) {
						
						relationship = "mother";
						String motherName = registration.getMotherName();
						motherName = motherName.replaceAll(" ", "");
						
						preParentReg.setString(1, parentId);
						preParentReg.setString(2, registration.getFatherName());
						preParentReg.setString(3, registration.getFatherQualification());
						preParentReg.setString(4, registration.getFatherMobileNo());
						preParentReg.setString(5, registration.getFatheremailId());
						preParentReg.setString(6, registration.getFatheroccupation());
						preParentReg.setString(7, registration.getMotherName());
						preParentReg.setString(8, registration.getMotherMobileNo());
						preParentReg.setString(9, registration.getMotherQualification());
						preParentReg.setString(10, registration.getMotheremailId());
						preParentReg.setString(11, registration.getMotheroccupation());
						preParentReg.setString(12, registration.getGuardianName());
						preParentReg.setString(13, registration.getGuardianemailId());
						preParentReg.setString(14, registration.getGuardianMobileNo());
						preParentReg.setString(15, motherName.concat(parentUserName));
						preParentReg.setString(16, motherName.concat(parentUserName));
						preParentReg.setString(17, registration.getAddress());
						preParentReg.setString(18, registration.getCreateUser());
						preParentReg.setTimestamp(19, HelperClass.getCurrentTimestamp());
						preParentReg.setString(20, "Active");

						Thread.sleep(1000);
						if (registration.getMotheremailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getMotheremailId().trim(), motherName
									.concat(parentUserName), motherName
									.concat(parentUserName));
						}
					
					} else {
						relationship = "guardian";

						String guardianName = registration.getGuardianName();
						guardianName = guardianName.replaceAll(" ", " ");
						
						preParentReg.setString(1, parentId);
						preParentReg.setString(2, registration.getFatherName());
						preParentReg.setString(3, registration.getFatherQualification());
						preParentReg.setString(4, registration.getFatherMobileNo());
						preParentReg.setString(5, registration.getFatheremailId());
						preParentReg.setString(6, registration.getFatheroccupation());
						preParentReg.setString(7, registration.getMotherName());
						preParentReg.setString(8, registration.getMotherMobileNo());
						preParentReg.setString(9, registration.getMotherQualification());
						preParentReg.setString(10, registration.getMotheremailId());
						preParentReg.setString(11, registration.getMotheroccupation());
						preParentReg.setString(12, registration.getGuardianName());
						preParentReg.setString(13, registration.getGuardianemailId());
						preParentReg.setString(14, registration.getGuardianMobileNo());
						preParentReg.setString(15, guardianName.concat(parentUserName));
						preParentReg.setString(16, guardianName.concat(parentUserName));
						preParentReg.setString(17, registration.getAddress());
						preParentReg.setString(18, registration.getCreateUser());
						preParentReg.setTimestamp(19, HelperClass.getCurrentTimestamp());
						preParentReg.setString(20, "Active");

						Thread.sleep(1000);
						if (registration.getGuardianemailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getGuardianemailId().trim(), guardianName
									.concat(parentUserName), guardianName
									.concat(parentUserName));
						}
					}

					
					preParentReg.execute();
					preParentReg.close();
					
				}else{
					
					PreparedStatement preParentReg = (PreparedStatement) JDBCConnection
							.getStatement(StudentRegistrationSQLUtilConstants.UPDATE_PARENT_INFORMATION);
				
					parentId = registration.getParentId().trim();
					String parentUserName = parentId.substring(3);

					if (registration.getPrimaryPerson().equals("father")) {
						
						relationship = "father";
						
						String fatherName = registration.getFatherName();
						fatherName = fatherName.replaceAll(" ", "");
						
						preParentReg.setString(1, registration.getFatherName());
						preParentReg.setString(2, registration.getFatherQualification());
						preParentReg.setString(3, registration.getFatherMobileNo());
						preParentReg.setString(4, registration.getFatheremailId());
						preParentReg.setString(5, registration.getFatheroccupation());
						preParentReg.setString(6, registration.getMotherName());
						preParentReg.setString(7, registration.getMotherMobileNo());
						preParentReg.setString(8, registration.getMotherQualification());
						preParentReg.setString(9, registration.getMotheremailId());
						preParentReg.setString(10, registration.getMotheroccupation());
						preParentReg.setString(11, registration.getGuardianName());
						preParentReg.setString(12, registration.getGuardianemailId());
						preParentReg.setString(13, registration.getGuardianMobileNo());
						preParentReg.setString(14, fatherName.concat(parentUserName));
						preParentReg.setString(15, fatherName.concat(parentUserName));
						preParentReg.setString(16, registration.getAddress());
						preParentReg.setString(17, registration.getCreateUser());
						preParentReg.setTimestamp(18, HelperClass.getCurrentTimestamp());
						preParentReg.setString(19, parentId);

						Thread.sleep(1000);
						if (registration.getFatheremailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getFatheremailId().trim(), fatherName
									.concat(parentUserName), fatherName
									.concat(parentUserName));
						}
						
					}else if (registration.getPrimaryPerson().equals("mother")) {
						
						relationship = "mother";
						String motherName = registration.getMotherName();
						motherName = motherName.replaceAll(" ", "");
						
						preParentReg.setString(1, registration.getFatherName());
						preParentReg.setString(2, registration.getFatherQualification());
						preParentReg.setString(3, registration.getFatherMobileNo());
						preParentReg.setString(4, registration.getFatheremailId());
						preParentReg.setString(5, registration.getFatheroccupation());
						preParentReg.setString(6, registration.getMotherName());
						preParentReg.setString(7, registration.getMotherMobileNo());
						preParentReg.setString(8, registration.getMotherQualification());
						preParentReg.setString(9, registration.getMotheremailId());
						preParentReg.setString(10, registration.getMotheroccupation());
						preParentReg.setString(11, registration.getGuardianName());
						preParentReg.setString(12, registration.getGuardianemailId());
						preParentReg.setString(13, registration.getGuardianMobileNo());
						preParentReg.setString(14, motherName.concat(parentUserName));
						preParentReg.setString(15, motherName.concat(parentUserName));
						preParentReg.setString(16, registration.getAddress());
						preParentReg.setString(17, registration.getCreateUser());
						preParentReg.setTimestamp(18, HelperClass.getCurrentTimestamp());
						preParentReg.setString(19, parentId);
						

						Thread.sleep(1000);
						if (registration.getMotheremailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getMotheremailId().trim(), motherName
									.concat(parentUserName), motherName
									.concat(parentUserName));
						}
					} else {
						relationship = "guardian";

						String guardianName = registration.getGuardianName();
						guardianName = guardianName.replaceAll(" ", " ");
						
						preParentReg.setString(1, registration.getFatherName());
						preParentReg.setString(2, registration.getFatherQualification());
						preParentReg.setString(3, registration.getFatherMobileNo());
						preParentReg.setString(4, registration.getFatheremailId());
						preParentReg.setString(5, registration.getFatheroccupation());
						preParentReg.setString(6, registration.getMotherName());
						preParentReg.setString(7, registration.getMotherMobileNo());
						preParentReg.setString(8, registration.getMotherQualification());
						preParentReg.setString(9, registration.getMotheremailId());
						preParentReg.setString(10, registration.getMotheroccupation());
						preParentReg.setString(11, registration.getGuardianName());
						preParentReg.setString(12, registration.getGuardianemailId());
						preParentReg.setString(13, registration.getGuardianMobileNo());
						preParentReg.setString(14, guardianName.concat(parentUserName));
						preParentReg.setString(15, guardianName.concat(parentUserName));
						preParentReg.setString(16, registration.getAddress());
						preParentReg.setString(17, registration.getCreateUser());
						preParentReg.setTimestamp(18, HelperClass.getCurrentTimestamp());
						preParentReg.setString(19, parentId);

						Thread.sleep(1000);
						if (registration.getGuardianemailId() == null) {
							new SendMail().sendMailtoChild(registration
									.getGuardianemailId().trim(), guardianName
									.concat(parentUserName), guardianName
									.concat(parentUserName));
						}
					}

					
					preParentReg.executeUpdate(); 
					
					preParentReg.close();
					
					
				}
				
				

				preChildParentUpdate = conn.prepareStatement(StudentRegistrationSQLUtilConstants.PARENT_CHILD_UPDATE);

				if (registration.getPrimaryPerson().equals("father")) {
					
					relationship = "father";
					
				} else if (registration.getPrimaryPerson().equals("mother")) {
					
					relationship = "mother";
					
				} else {

					relationship = "guardian";
					
				}
				
				preChildParentUpdate.setString(1, relationship);
				preChildParentUpdate.setString(2, parentId.trim());
				preChildParentUpdate.setString(3, registration.getStudentId().trim());
				
				
				preChildParentUpdate.executeUpdate();
				
				
				ps_parentChaildsUpdate = conn.prepareStatement(StudentRegistrationSQLUtilConstants.PARENT_CHILDS_UPDATE);

				if (registration.getPrimaryPerson().equals("father")) {
					
					relationship = "father";
					
				} else if (registration.getPrimaryPerson().equals("mother")) {
					
					relationship = "mother";
					
				} else {

					relationship = "guardian";
					
				}
				
				ps_parentChaildsUpdate.setString(1, relationship);
				ps_parentChaildsUpdate.setString(2, parentId.trim());
				
				
				ps_parentChaildsUpdate.executeUpdate();
				
				//For enquiry update

				if (registration.getEnquiryId() != null) {

					PreparedStatement enquiryUpdate = conn.prepareStatement(StudentRegistrationSQLUtilConstants.UPDATE_ENQUIRY_DETAILS);
				
					enquiryUpdate.setString(1, "Y");
					enquiryUpdate.setString(2, registration.getStudentId().trim());
					enquiryUpdate.setString(3, registration.getModifyUser().trim());
					enquiryUpdate.setTimestamp(4,HelperClass.getCurrentTimestamp());
					enquiryUpdate.setString(5, registration.getEnquiryId());
					
					
					enquiryUpdate.executeUpdate();


				}
				
				if (resultModify > 0) {

					successMsg = "successMessage";

				} else {

					successMsg = "errorMessage";
				}
				
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			
		} finally {
			try {
				if (rsClass != null && (!rsClass.isClosed())) {
					rsClass.close();
				}
				if (rsImagePath != null && (!rsImagePath.isClosed())) {
					rsImagePath.close();
				}
				if (preChildParentUpdate != null
						&& (!preChildParentUpdate.isClosed())) {
					preChildParentUpdate.close();
				}
				if (preParentRegUpdate != null
						&& (!preParentRegUpdate.isClosed())) {
					preParentRegUpdate.close();
				}

				if (getImagePath != null && (!getImagePath.isClosed())) {
					getImagePath.close();
				}
				if (rsacademicYear != null && (!rsacademicYear.isClosed())) {
					rsacademicYear.close();
				}

				if (duplicateRs != null && (!duplicateRs.isClosed())) {
					duplicateRs.close();
				}
				if (rsacademicYearId != null && (!rsacademicYearId.isClosed())) {
					rsacademicYearId.close();
				}
				if (resultSetclassName != null
						&& (!resultSetclassName.isClosed())) {
					resultSetclassName.close();
				}

				if (pstmclasscount != null && (!pstmclasscount.isClosed())) {
					pstmclasscount.close();
				}
				if (academicYearpre != null && (!academicYearpre.isClosed())) {
					academicYearpre.close();
				}
				if (prclassName != null && (!prclassName.isClosed())) {
					prclassName.close();
				}
				
				if (pstmmodifyObj != null && (!pstmmodifyObj.isClosed())) {
					pstmmodifyObj.close();
				}
				if (pstmacademicYearId != null
						&& (!pstmacademicYearId.isClosed())) {
					pstmacademicYearId.close();
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
				+ " Control in StudentRegistrationDaoImpl : modifyStudentDetails Ending");
		return successMsg;
	}

	
	//To search student details
	
	
	//To serch student
	@Override
	public List<StudentRegistrationVo> studentSearch(
			StudentRegistrationVo registrationVo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : studentSearch Starting");
		String searchTerm = "%" + registrationVo.getSearchTerm() + "%";
		List<StudentRegistrationVo> registrationList = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pstmObj = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmObj = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_SEARCH_BY_STCLSE);

			pstmObj.setString(1, registrationVo.getAcademicYearId());

			if (registrationVo.getClassDetailId() != null) {
				pstmObj.setString(2, "%" + registrationVo.getClassDetailId()
						+ "%");
			} else {
				pstmObj.setString(2, "%%");
			}
			if (registrationVo.getClassSectionId() != null) {
				pstmObj.setString(3, "%" + registrationVo.getClassSectionId()
						+ "%");
			} else {
				pstmObj.setString(3, "%%");
			}
			pstmObj.setString(4, searchTerm);
			rs = pstmObj.executeQuery();

			while (rs.next()) {
				StudentRegistrationVo studentRegistrationVo = new StudentRegistrationVo();
				studentRegistrationVo.setStudentnamelabel(rs
						.getString("student_fname_var"));
				studentRegistrationVo.setStudentidlabel(rs
						.getString("student_id_int"));

				registrationList.add(studentRegistrationVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pstmObj != null && (!pstmObj.isClosed())) {
					pstmObj.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : studentSearch Ending");

		return registrationList;

	}

	
	@Override
	public List<StudentRegistrationVo> searchStudentResult(StudentRegistrationVo registrationVo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : searchStudentResulto Starting");
		

		List<StudentRegistrationVo> studentVoList = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pstmObj = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmObj = conn.prepareStatement(SQLUtilConstants.GET_STUDENT_DETAIL_BY_SEARCH_TERM);
			pstmObj.setString(1, registrationVo.getSearchTerm());
			rs = pstmObj.executeQuery();

			while (rs.next()) {
				
				StudentRegistrationVo studentvo1 = new StudentRegistrationVo();

				studentvo1.setAcademicYear(rs.getString("acadamic_year"));
				studentvo1.setStreemname(rs.getString("classstream_name_var"));
				studentvo1.setClassname(rs.getString("classdetails_name_var"));
				studentvo1
						.setSectionnaem(rs.getString("classsection_name_var"));
				studentvo1
						.setStudentIDgenerator(registrationVo.getSearchTerm());
				studentvo1.setStudentAdmissionNo(rs
						.getString("student_admissionno_var"));
				studentvo1.setStudentFirstName(rs
						.getString("student_fname_var"));
				
				studentvo1.setApplicationNo(rs
						.getString("student_application_no"));
				studentvo1.setTransport(rs.getString("isTransport"));
				studentvo1.setHostel(rs.getString("isHostel"));

				studentvo1
						.setStudentLastName(rs.getString("student_lname_var"));
				studentvo1.setStudentrollno(rs.getString("student_rollno"));
				studentvo1.setDateofBirth(HelperClass
						.getDateFromSQLDateinDDMMYYYYFormat(rs
								.getDate("student_dob_var")));

				studentvo1.setAge(rs.getString("student_age_int"));

				studentvo1.setGender(rs.getString("student_gender_var"));
				studentvo1.setPhysicallyChallenged(rs
						.getString("student_physicallychallenged"));
				studentvo1
						.setBloodGroup(rs.getString("student_bloodgroup_var"));

				studentvo1.setIdentificationMarks(rs
						.getString("student_identificationmarks_var"));

				studentvo1.setNationality(rs
						.getString("student_nationality_var"));
				studentvo1.setReligion(rs.getString("student_religion_var"));
				studentvo1.setDateofJoin(HelperClass
						.getDateFromSQLDateinDDMMYYYYFormat(rs
								.getDate("student_doj_var")));
				studentvo1.setAcademicYearId(rs
						.getString("fms_acadamicyear_id_int"));
				studentvo1.setCategory(rs.getString("fms_classstream_id_int"));
				studentvo1.setStudClassId(rs.getString("classdetail_id_int"));
				studentvo1
						.setStudSectionId(rs.getString("classsection_id_int"));
				studentvo1.setGrade(rs.getString("student_grade"));
				studentvo1.setStudentquotaid(rs.getString("student_quota"));
				studentvo1.setStudentcastename(rs.getString("student_caste"));
				studentvo1.setStudentStatus(rs.getString("student_status_var"));
				studentvo1.setPromotionStatus(rs
						.getString("student_promotionstatus"));
				studentvo1.setPreviousHistory(rs
						.getString("student_prehistory_var"));
				studentvo1.setRemarks(rs.getString("student_remarks_var"));

				studentvo1.setStudentquotaname(rs.getString("student_quota"));
				studentvo1.setStudentcastename(rs.getString("student_caste"));
				studentvo1
						.setFatherName(rs.getString("student_fathername_var"));
				studentvo1.setFatherQualification(rs
						.getString("student_fatherqualification_var"));
				studentvo1.setFatherMobileNo(rs
						.getString("student_fathermobileno_var"));

				studentvo1
						.setMotherName(rs.getString("student_mothername_var"));
				studentvo1.setMotherMobileNo(rs
						.getString("student_mothermobileno_var"));
				studentvo1.setMotherQualification(rs
						.getString("student_motherqualification_var"));

				studentvo1.setGuardianName(rs
						.getString("student_gaurdianname_var"));
				studentvo1.setPrimaryPerson(rs.getString("relationship"));
				studentvo1.setStudentPhoto(rs.getString("student_imgurl_var"));
				studentvo1.setStudentRegNo(rs.getString("student_regno_var"));
				studentvo1.setParentId(rs.getString("ParentID"));

				studentvo1
						.setStudentIDgenerator(rs.getString("student_id_int"));

				studentvo1.setFatheremailId(rs
						.getString("student_father_mailid"));
				studentvo1.setMotheremailId(rs
						.getString("student_mother_mailid"));
				studentvo1.setGuardianemailId(rs
						.getString("student_gardian_mailid"));
				studentvo1.setGuardianMobileNo(rs
						.getString("student_gardian_mobileno"));
				studentvo1.setIsconcession(rs.getString("isConcession"));

				if (rs.getString("isConcession").equalsIgnoreCase("Y")) {

					studentvo1.setScholarShip(rs
							.getString("student_scholorship_var"));
				} else {

					studentvo1.setScholarShip("");
				}

				studentvo1.setRte(rs.getString("isRTE").trim());

				studentvo1.setTransporttypeId(rs.getString("type_id"));
				studentvo1.setTransporttypeName(rs.getString("type_name"));
				studentvo1.setTransportlocationId(rs.getString("stage_id"));
				studentvo1.setTransportlocationName(rs.getString("stage_name"));
				studentvo1.setTransportcollectType(rs
						.getString("type_collectFee"));

				if (rs.getString("student_siblingname_var") != null) {
					PreparedStatement pstm = conn
							.prepareStatement(SQLUtilConstants.GET_SIBLING_DETAILS);
					pstm.setString(1, registrationVo.getSearchTerm());
					ResultSet rst = pstm.executeQuery();
					while (rs.next()) {
						studentvo1.setSibilingClassId(rst
								.getString("classdetails_name_var"));
						studentvo1.setStudentSibilingIdInt(rst
								.getString("student_id_int"));
						studentvo1.setStudentSibilingRegNo(rst
								.getString("student_admissionno_var"));
						studentvo1.setStudentSibilingName(rst
								.getString("siblingName"));
					}
				} else {
					studentvo1.setSibilingClassId("");
					studentvo1.setStudentSibilingIdInt("");
					studentvo1.setStudentSibilingRegNo("");
					studentvo1.setStudentSibilingName("");
				}
				
				studentVoList.add(studentvo1);
				
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			;
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pstmObj != null && (!pstmObj.isClosed())) {
					pstmObj.close();
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
				+ " Control in StudentRegistrationDaoImpl : searchStudentResult Ending");
		return studentVoList;

	}

	
	@Override
	public List<StudentRegistrationVo> studentSearchByParent(
			StudentRegistrationVo registrationVo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : studentSearchByParent Starting");
		List<StudentRegistrationVo> studentVoList = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pstmObj = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmObj = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_STUDENT_DETAIL_BY_PARENTID);
			pstmObj.setString(1, registrationVo.getSearchTerm());
			rs = pstmObj.executeQuery();

			while (rs.next()) {

				StudentRegistrationVo form = new StudentRegistrationVo();
				form.setSibilingClassId(rs.getString("classdetail_id_int"));
				form.setStudentSibilingIdInt(rs.getString("student_id_int"));
				form.setStudentFirstName(rs.getString("student_fname_var"));
				form.setSibilingadminno(rs.getString("student_admissionno_var"));
				form.setFatherName(rs.getString("FatherName"));
				form.setFatherQualification(rs.getString("Qualification"));
				form.setFatherMobileNo(rs.getString("mobileno"));
				form.setMotherName(rs.getString("student_mothername_var"));
				form.setMotherMobileNo(rs.getString("student_mothermobileno_var"));
				form.setMotherQualification(rs.getString("student_motherqualification_var"));
				form.setGaurdianName(rs.getString("student_gaurdianname_var"));
				form.setSibilingName(rs.getString("student_siblingId"));
				form.setParentId(rs.getString("parentid"));
				form.setSibilingClass(rs.getString("classdetails_name_var"));
				form.setFatheremailId(rs.getString("email"));
				form.setMotheremailId(rs.getString("student_mother_mailid"));
				form.setGuardianMobileNo(rs.getString("student_gardian_mobileno"));
				form.setGuardianemailId(rs.getString("student_gardian_mailid"));
				form.setPrimaryPerson(rs.getString("relationship"));
				form.setStudentIDgenerator(rs.getString("student_id_int"));
				form.setImageFileName(rs.getString("student_imgurl_var"));
				form.setAddress(rs.getString("address"));
				form.setMotheroccupation(rs.getString("student_mother_occupation"));
				form.setFatheroccupation(rs.getString("student_father_occupation"));
				
				studentVoList.add(form);

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
				if (pstmObj != null && (!pstmObj.isClosed())) {
					pstmObj.close();
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
				+ " Control in StudentRegistrationDaoImpl : studentSearchByParent Ending");
		return studentVoList;
	}

	
	public List<StudentRegistrationVo> studentSearchbySibling(
			StudentRegistrationVo registrationVo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : studentSearch Starting");
		String searchTerm = "%" + registrationVo.getSearchTerm() + "%";
		List<StudentRegistrationVo> registrationList = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pstmObj = null;
		ResultSet rs = null;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmObj = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_SEARCH_BY_SIBLING);

			pstmObj.setString(1, searchTerm);
			pstmObj.setString(2, searchTerm);

			rs = pstmObj.executeQuery();

			while (rs.next()) {
				StudentRegistrationVo studentRegistrationVo = new StudentRegistrationVo();
				studentRegistrationVo.setStudentnamelabel(rs
						.getString("StudentName"));
				studentRegistrationVo.setStudentidlabel(rs
						.getString("student_id_int"));
				registrationList.add(studentRegistrationVo);

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
				if (pstmObj != null && (!pstmObj.isClosed())) {
					pstmObj.close();
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
				+ " Control in StudentRegistrationDaoImpl : studentSearch Ending");

		return registrationList;
		// TODO Auto-generated method stub

	}

	public List<StudentRegistrationVo> studentSearchbyClass(
			StudentRegistrationVo registrationVo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : studentSearchbyClass Starting");

		List<StudentRegistrationVo> registrationList = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			String searchTerm = "%" + registrationVo.getSearchTerm() + "%";
			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_SEARCH_BY_CLASSNAME);

			pst.setString(1, registrationVo.getAcademicYearId());

			if (registrationVo.getClassDetailId() != null) {
				pst.setString(2, "%" + registrationVo.getClassDetailId() + "%");
			} else {
				pst.setString(2, "%%");
			}

			pst.setString(3, searchTerm);
			rs = pst.executeQuery();

			while (rs.next()) {
				StudentRegistrationVo studentRegistrationVo = new StudentRegistrationVo();
				studentRegistrationVo.setStudentnamelabel(rs
						.getString("student_fname_var"));
				studentRegistrationVo.setStudentidlabel(rs
						.getString("student_id_int"));

				registrationList.add(studentRegistrationVo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : studentSearchbyClass Ending");

		return registrationList;
	}

	//To delete student
	
	
	//To delete student
	public boolean deactivateStudent(StudentRegistrationVo registrationVo) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl:deactivateStudent Starting");
		PreparedStatement pstmObj = null;
		Connection conn = null;
		int count = 0;
		boolean status = false;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmObj = conn.prepareStatement(StudentRegistrationSQLUtilConstants.STUDENT_DEACTIVATE);
			pstmObj.setString(1, registrationVo.getStudentId());
			count = pstmObj.executeUpdate();

			if (count > 0) {
				status = true;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (pstmObj != null && (!pstmObj.isClosed())) {
					pstmObj.close();
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
				+ " Control in StudentRegistrationDaoImpl:deactivateStudent  Ending");
		return status;
	}

	//To get student edit details


	
	//To edit student
	
	public StudentRegistrationVo editStudent(StudentRegistrationVo registrationVo){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : editStudent Starting");
		
		StudentRegistrationVo studentvo1 = new StudentRegistrationVo();
		PreparedStatement pstmObj = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmObj = conn.prepareStatement(SQLUtilConstants.GET_STUDENT_DETAIL_BY_SEARCH_TERM);
			pstmObj.setString(1, registrationVo.getSearchTerm());
			rs = pstmObj.executeQuery();

			while (rs.next()) {

				studentvo1.setAcademicYear(rs.getString("acadamic_year"));
				studentvo1.setStreemname(rs.getString("classstream_name_var"));
				studentvo1.setClassname(rs.getString("classdetails_name_var"));
				studentvo1.setSectionnaem(rs.getString("classsection_name_var"));
				studentvo1.setStudentIDgenerator(registrationVo.getSearchTerm());
				studentvo1.setStudentAdmissionNo(rs.getString("student_admissionno_var"));
				studentvo1.setStudentFirstName(rs.getString("student_fname_var"));
				studentvo1.setApplicationNo(rs.getString("student_application_no"));
				studentvo1.setTransport(rs.getString("isTransport"));
				studentvo1.setHostel(rs.getString("isHostel"));
				studentvo1.setStudentLastName(rs.getString("student_lname_var"));
				studentvo1.setStudentrollno(rs.getString("student_rollno"));
				studentvo1.setDateofBirth(HelperClass.convertDatabaseToUI(rs.getString("student_dob_var")));
				studentvo1.setAge(rs.getString("student_age_int"));
				studentvo1.setGender(rs.getString("student_gender_var"));
				studentvo1.setPhysicallyChallenged(rs.getString("student_physicallychallenged"));
				studentvo1.setBloodGroup(rs.getString("student_bloodgroup_var"));
				studentvo1.setIdentificationMarks(rs.getString("student_identificationmarks_var"));
				studentvo1.setNationality(rs.getString("student_nationality_var"));
				studentvo1.setReligion(rs.getString("student_religion_var"));
				studentvo1.setDateofJoin(HelperClass.convertDatabaseToUI(rs.getString("student_doj_var")));
				studentvo1.setAcademicYearId(rs.getString("fms_acadamicyear_id_int"));
				studentvo1.setCategory(rs.getString("fms_classstream_id_int"));
				studentvo1.setStudClassId(rs.getString("classdetail_id_int"));
				studentvo1.setStudSectionId(rs.getString("classsection_id_int"));
				studentvo1.setGrade(rs.getString("student_grade"));
				studentvo1.setStudentquotaid(rs.getString("student_quota"));
				studentvo1.setStudentcastename(rs.getString("student_caste"));
				studentvo1.setStudentStatus(rs.getString("student_status_var"));
				studentvo1.setPromotionStatus(rs.getString("student_promotionstatus"));
				studentvo1.setPreviousHistory(rs.getString("student_prehistory_var"));
				studentvo1.setRemarks(rs.getString("student_remarks_var"));
				studentvo1.setStudentquotaname(rs.getString("student_quota"));
				studentvo1.setStudentcastename(rs.getString("student_caste"));
				studentvo1.setFatherName(rs.getString("FatherName"));
				studentvo1.setFatherQualification(rs.getString("Qualification"));
				studentvo1.setFatherMobileNo(rs.getString("mobileno"));
				studentvo1.setMotherName(rs.getString("student_mothername_var"));
				studentvo1.setMotherMobileNo(rs.getString("student_mothermobileno_var"));
				studentvo1.setMotherQualification(rs.getString("student_motherqualification_var"));
				studentvo1.setGuardianName(rs.getString("student_gaurdianname_var"));
				studentvo1.setPrimaryPerson(rs.getString("relationship"));
				studentvo1.setStudentPhoto(rs.getString("student_imgurl_var"));
				studentvo1.setStudentRegNo(rs.getString("student_regno_var"));
				studentvo1.setParentId(rs.getString("ParentID"));
				studentvo1.setStudentIDgenerator(rs.getString("student_id_int"));
				studentvo1.setFatheremailId(rs.getString("email"));
				studentvo1.setMotheremailId(rs.getString("student_mother_mailid"));
				studentvo1.setGuardianemailId(rs.getString("student_gardian_mailid"));
				studentvo1.setGuardianMobileNo(rs.getString("student_gardian_mobileno"));
				studentvo1.setIsconcession(rs.getString("isConcession"));
				
				studentvo1.setImageFileName(rs.getString("student_imgurl_var"));
				studentvo1.setBirthcertificate(rs.getString("student_birthcert_path"));
				studentvo1.setTransferfile(rs.getString("student_tc_path"));
				
				studentvo1.setAddress(rs.getString("address"));
				studentvo1.setMotheroccupation(rs.getString("student_mother_occupation"));
				studentvo1.setFatheroccupation(rs.getString("student_father_occupation"));
				
				studentvo1.setStudentId(registrationVo.getSearchTerm());
				
				
				

				if (rs.getString("isConcession").equalsIgnoreCase("Y")) {

					studentvo1.setScholarShip(rs
							.getString("student_scholorship_var"));
				} else {

					studentvo1.setScholarShip("");
				}

				studentvo1.setRte(rs.getString("isRTE").trim());
				studentvo1.setTransporttypeId(rs.getString("type_id"));
				studentvo1.setTransporttypeName(rs.getString("type_name"));
				studentvo1.setTransportlocationId(rs.getString("stage_id"));
				studentvo1.setTransportlocationName(rs.getString("stage_name"));
				studentvo1.setTransportcollectType(rs.getString("type_collectFee"));
				

				if (rs.getString("student_siblingId") != null) {
					
					PreparedStatement pstm = conn.prepareStatement(SQLUtilConstants.GET_SIBLING_DETAILS);
					pstm.setString(1, registrationVo.getSearchTerm());
					
					
					ResultSet rst = pstm.executeQuery();
					
					while (rst.next()) {
						
						studentvo1.setSibilingClassId(rst.getString("classdetails_name_var"));
						studentvo1.setStudentSibilingIdInt(rst.getString("siblingId"));
						studentvo1.setStudentSibilingRegNo(rst.getString("siblingAdmissionNo"));
						studentvo1.setStudentSibilingName(rst.getString("siblingName"));
					}
					
				} else {
					
					
					studentvo1.setSibilingClassId("");
					studentvo1.setStudentSibilingIdInt("");
					studentvo1.setStudentSibilingRegNo("");
					studentvo1.setStudentSibilingName("");
				}
				
				
				
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			;
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pstmObj != null && (!pstmObj.isClosed())) {
					pstmObj.close();
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
				+ " Control in StudentRegistrationDaoImpl : editStudent Ending");
		return studentvo1;

	}

	//To get student list for listing page
	
	
	//Get student list
	@Override
	public List<registrationvo> StudentDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getStudentDetails  Starting");
		List<registrationvo> list = new ArrayList<registrationvo>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_ALLSTUDENT_DETAILS);

			rs = pst.executeQuery();
			while (rs.next()) {
				registrationvo registrationVo = new registrationvo();
				registrationVo.setStudentId(rs.getString("student_id_int"));
				registrationVo.setStudentAdmissionNo(rs
						.getString("student_admissionno_var"));
				registrationVo.setStudentnamelabel(rs.getString("studentname"));
				registrationVo.setClassSectionId(rs.getString("classsection"));
				registrationVo.setDateofBirth(HelperClass
						.convertDatabaseToUI(rs.getString("student_dob_var")));
				registrationVo.setStudentStatus(rs
						.getString("student_status_var"));

				list.add(registrationVo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : getStudentDetails  Ending");
		// TODO Auto-generated method stub

		return list;
	}
	
	public List<StudentRegistrationVo> getStudentDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : getStudentDetails  Starting");
		List<StudentRegistrationVo> list = new ArrayList<StudentRegistrationVo>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pst = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_ALLSTUDENT_DETAILS);

			rs = pst.executeQuery();
			while (rs.next()) {
				StudentRegistrationVo registrationVo = new StudentRegistrationVo();
				registrationVo.setStudentId(rs.getString("student_id_int"));
				registrationVo.setStudentAdmissionNo(rs
						.getString("student_admissionno_var"));
				registrationVo.setStudentnamelabel(rs.getString("studentname"));
				registrationVo.setClassSectionId(rs.getString("classsection"));
				registrationVo.setDateofBirth(HelperClass
						.convertDatabaseToUI(rs.getString("student_dob_var")));
				registrationVo.setStudentStatus(rs
						.getString("student_status_var"));

				list.add(registrationVo);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pst != null && (!pst.isClosed())) {
					pst.close();
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
				+ " Control in StudentRegistrationDaoImpl : getStudentDetails  Ending");
		// TODO Auto-generated method stub

		return list;
	}

	public ArrayList<StudentInfoVO> getAllStudentsDetails(String classname,
			String accodamicyr) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationDaoImpl : checkApplicationNo Starting");

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<StudentInfoVO> studentList = new ArrayList<StudentInfoVO>();
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			preparedStatement = conn
					.prepareStatement(StudentRegistrationSQLUtilConstants.GET_STUDENT_DETAILS);
			preparedStatement.setString(1, classname);
			preparedStatement.setString(2, accodamicyr);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {

				StudentInfoVO vo = new StudentInfoVO();

				vo.setId(rs.getString("student_id_int"));
				vo.setAdmissionno(rs.getString("student_admissionno_var"));
				vo.setName(rs.getString("student_fname_var"));

				studentList.add(vo);

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
				+ " Control in  StudentRegistrationDaoImpl : checkApplicationNo Ending");
		return studentList;
	}

	
}