package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.admin.EmailContent;
import com.centris.campus.admin.SendMail;
import com.centris.campus.dao.TeacherDao;
import com.centris.campus.pojo.TeacherRegistrationPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.TeacherUtilsConstants;
import com.centris.campus.vo.AllTeacherDetailsVo;
import com.centris.campus.vo.TeacherMappingClassesVo;
import com.centris.campus.vo.ViewallSubjectsVo;

public class TeacherDaoImpl implements TeacherDao {

	private static final Logger logger = Logger.getLogger(TeacherDaoImpl.class);
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<AllTeacherDetailsVo> getAllTeacherDetails() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getAllTeacherDetails Starting");

		ArrayList<AllTeacherDetailsVo> getTeacherDetails = new ArrayList<AllTeacherDetailsVo>();
		Connection conn = null;
		int slNo = 1;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TeacherUtilsConstants.ALL_TEACHER_DETAILS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AllTeacherDetailsVo allTeacherDetailsVo = new AllTeacherDetailsVo();
				allTeacherDetailsVo.setSlno(String.valueOf(slNo));
				allTeacherDetailsVo.setTeacherName(rs.getString("teacherName"));
				allTeacherDetailsVo.setTeacherId(rs.getString("TeacherID"));
				allTeacherDetailsVo.setQualification(rs
						.getString("Qualification"));
				allTeacherDetailsVo.setDesignation(rs
						.getString("designationName"));
				allTeacherDetailsVo.setMobileNo(rs.getString("MobileNo"));
				allTeacherDetailsVo.setEmail(rs.getString("emailId"));
				slNo++;
				
				if(rs.getString("BankAccNumber")==null || "".equalsIgnoreCase(rs.getString("BankAccNumber"))){
					
					allTeacherDetailsVo.setBankaccountNo("-");
					
				}else{
				
					allTeacherDetailsVo.setBankaccountNo(rs.getString("BankAccNumber"));
				}
				
				if(rs.getString("EmployeePfNo")==null || "".equalsIgnoreCase(rs.getString("EmployeePfNo"))){
					
					allTeacherDetailsVo.setPfnumber("-");
					
				}else{
				
					allTeacherDetailsVo.setPfnumber(rs.getString("EmployeePfNo"));
				}
				
				allTeacherDetailsVo.setRegistartionNo(rs.getString("registerId"));
				allTeacherDetailsVo.setCtc(rs.getDouble("CTC"));
				allTeacherDetailsVo.setDepartment(rs.getString("DEPT_NAME"));
				
				getTeacherDetails.add(allTeacherDetailsVo);
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getAllTeacherDetails Ending");
		return getTeacherDetails;
	}
	
	
	
	public ArrayList<AllTeacherDetailsVo> getSearchTeacherDetails(String searchterm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getSearchTeacherDetails Starting");

		ArrayList<AllTeacherDetailsVo> getTeacherDetails = new ArrayList<AllTeacherDetailsVo>();
		Connection conn = null;
		int slNo = 1;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(TeacherUtilsConstants.SEARCH_TEACHER_EMPLOYEMENT_DETAILS);
			
			pstmt.setString(1, "%"+searchterm+"%");
			pstmt.setString(2, "%"+searchterm+"%");
			pstmt.setString(3, "%"+searchterm+"%");
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AllTeacherDetailsVo allTeacherDetailsVo = new AllTeacherDetailsVo();
				allTeacherDetailsVo.setSlno(String.valueOf(slNo));
				allTeacherDetailsVo.setTeacherName(rs.getString("teacherName"));
				allTeacherDetailsVo.setTeacherId(rs.getString("TeacherID"));
				allTeacherDetailsVo.setQualification(rs
						.getString("Qualification"));
				allTeacherDetailsVo.setDesignation(rs
						.getString("designationName"));
				allTeacherDetailsVo.setMobileNo(rs.getString("MobileNo"));
				allTeacherDetailsVo.setEmail(rs.getString("emailId"));
				slNo++;
				
				if(rs.getString("BankAccNumber")==null || "".equalsIgnoreCase(rs.getString("BankAccNumber"))){
					
					allTeacherDetailsVo.setBankaccountNo("-");
					
				}else{
				
					allTeacherDetailsVo.setBankaccountNo(rs.getString("BankAccNumber"));
				}
				
				if(rs.getString("EmployeePfNo")==null || "".equalsIgnoreCase(rs.getString("EmployeePfNo"))){
					
					allTeacherDetailsVo.setPfnumber("-");
					
				}else{
				
					allTeacherDetailsVo.setPfnumber(rs.getString("EmployeePfNo"));
				}
				
				allTeacherDetailsVo.setRegistartionNo(rs.getString("registerId"));
				allTeacherDetailsVo.setCtc(rs.getDouble("CTC"));
				allTeacherDetailsVo.setDepartment(rs.getString("DEPT_NAME"));
				
				getTeacherDetails.add(allTeacherDetailsVo);
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getSearchTeacherDetails Ending");
		return getTeacherDetails;
	}

	public ArrayList<AllTeacherDetailsVo> searchStaffDetails(
			AllTeacherDetailsVo obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : searchStaffDetails Starting");

		ArrayList<AllTeacherDetailsVo> getTeacherDetails = new ArrayList<AllTeacherDetailsVo>();
		Connection conn = null;
		int slNo = 1;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TeacherUtilsConstants.SEARCH_TEACHER_DETAILS);
			pstmt.setString(1, "%" + obj.getSearchTerm() + "%");
			pstmt.setString(2, "%" + obj.getSearchTerm() + "%");
			pstmt.setString(3, "%" + obj.getSearchTerm() + "%");
			pstmt.setString(4, "%" + obj.getSearchTerm() + "%");
			pstmt.setString(5, "%" + obj.getSearchTerm() + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AllTeacherDetailsVo allTeacherDetailsVo = new AllTeacherDetailsVo();
				allTeacherDetailsVo.setSlno(String.valueOf(slNo));
				allTeacherDetailsVo.setTeacherName(rs.getString("teacherName"));
				allTeacherDetailsVo.setTeacherId(rs.getString("TeacherID"));
				allTeacherDetailsVo.setQualification(rs
						.getString("Qualification"));
				allTeacherDetailsVo.setDesignation(rs
						.getString("designationName"));
				allTeacherDetailsVo.setMobileNo(rs.getString("MobileNo"));
				allTeacherDetailsVo.setEmail(rs.getString("emailId"));
				slNo++;
				getTeacherDetails.add(allTeacherDetailsVo);
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : searchStaffDetails Ending");
		return getTeacherDetails;

	}

	public boolean deleteStaffDetails(AllTeacherDetailsVo obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : deleteStaffDetails Starting");

		Connection conn = null;
		boolean status = false;
		int count = 0;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TeacherUtilsConstants.DELETE_TEACHER_DETAILS);
			pstmt.setString(1, obj.getTeacherId());

			count = pstmt.executeUpdate();
			if (count > 0) {
				status = true;
			} else {
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : deleteStaffDetails Ending");
		return status;
	}

	public List<ViewallSubjectsVo> getSubjects() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getSubjects  Starting");
		ResultSet resultset = null;
		ArrayList<ViewallSubjectsVo> subjectlist = new ArrayList<ViewallSubjectsVo>();

		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(TeacherUtilsConstants.GET_SUBJECTS);
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				ViewallSubjectsVo viewallSubjectsVo = new ViewallSubjectsVo();
				viewallSubjectsVo
						.setSubjectid(resultset.getString("subjectID"));
				viewallSubjectsVo.setSubjectname(resultset
						.getString("subjectName"));
				subjectlist.add(viewallSubjectsVo);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null && (!resultset.isClosed())) {
					resultset.close();
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
				+ " Control in TeacherDaoImpl : getSubjects  Ending");

		return subjectlist;
	}

	public boolean checkUsername(String username, String teacherId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getSubjects  Starting");
		boolean status = false;
		int count = 0;

		ResultSet resultset = null;

		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TeacherUtilsConstants.GET_TEACHER_COUNT);
			pstmt.setString(1, username);
			pstmt.setString(2, teacherId);
			resultset = pstmt.executeQuery();
			System.out.println("prepared statement " + pstmt);

			while (resultset.next()) {
				count = resultset.getInt(1);
			}

			if (count > 0) {
				status = true;

			} else {

				status = false;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null && (!resultset.isClosed())) {
					resultset.close();
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
				+ " Control in TeacherDaoImpl : teacherUpdate  Ending");
		return status;
	}

	public boolean checkMail(String mailid, String teacherId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : checkUsername  Starting");
		boolean status = false;
		int count = 0;
		ResultSet resultset = null;

		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TeacherUtilsConstants.GET_TEACHERMAIL_COUNT);
			pstmt.setString(1, mailid);
			pstmt.setString(2, teacherId);
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				count = resultset.getInt(1);
			}
			if (count > 0) {
				status = true;
			} else {
				status = false;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null && (!resultset.isClosed())) {
					resultset.close();
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
				+ " Control in TeacherDaoImpl : checkUsername  Ending");
		return status;
	}

	public boolean teacherregister(TeacherRegistrationPojo obj) {
		
		boolean result = false;
		boolean result_class = false;
		boolean result_subject = false;
		
		ResultSet resultsetcount = null;
		PreparedStatement pstmtcount = null;

		Connection conn = null;
		
		PreparedStatement pstmt_clssmap_delete = null;
		
		PreparedStatement  pstmt_classmap= null;
		
		PreparedStatement pstmt_subjectmap_delete = null;
		
		PreparedStatement  pstmt_subjectmap= null;
		
		PreparedStatement  ps_insertuser= null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in TeacherDaoImpl : teacherregister  Starting");

			String genPassword = HelperClass.genaratePasswordForTeacher(obj);

			pstmtcount = conn
					.prepareStatement(TeacherUtilsConstants.CHECK_TACHER_COUNT_);
			pstmtcount.setString(1, obj.getUsername());
			pstmtcount.setString(2, obj.getDept());
			pstmtcount.setString(3, obj.getDesignation());
			pstmtcount.setString(4, obj.getTeachermobno());
			pstmtcount.setString(5, obj.getDateofbirth());
			pstmtcount.setString(6, obj.getJoiningdate());
			resultsetcount = pstmtcount.executeQuery();

			while (resultsetcount.next()) {
				int count = resultsetcount.getInt(1);

				if (count > 0) {
					result = false;
					return result;
				}

				else {

					pstmt = (PreparedStatement) JDBCConnection
							.getStatement(TeacherUtilsConstants.INSERT_TEACHER);
					
					System.out.println("Role ::: "+obj.getRole());

					pstmt.setString(1, obj.getTeacherId());
					pstmt.setString(2, obj.getTfastname());
					pstmt.setString(3, obj.getTlastname());
					pstmt.setString(4, obj.getTqualification());
					pstmt.setString(5, obj.getPresentadd());
					pstmt.setString(6, obj.getTeachermobno());
					pstmt.setString(7, obj.getUsername());
					pstmt.setString(8, obj.getTeacheremail());
					pstmt.setString(9, obj.getPrimary());
					pstmt.setString(10, obj.getSecondary());
					pstmt.setString(11, obj.getProfilepath());
					pstmt.setString(12, obj.getImgpath());
					pstmt.setString(13, obj.getDateofbirth());
					pstmt.setString(14, obj.getJoiningdate());
					pstmt.setString(15, obj.getDesignation());
					pstmt.setString(16, obj.getIdproof());
					pstmt.setString(17, obj.getTeachingtype());
					pstmt.setString(18, obj.getDept());
					pstmt.setString(19, obj.getGender());
					pstmt.setString(20, obj.getBlood());
					pstmt.setString(21, obj.getFathername());
					pstmt.setString(22, obj.getMothername());
					pstmt.setString(23, obj.getPermanentadd());
					pstmt.setString(24, obj.getCreatedby());
					pstmt.setTimestamp(25, HelperClass.getCurrentTimestamp());
					pstmt.setString(26, obj.getRegsitrationNo());
					pstmt.setString(27, genPassword);
					pstmt.setString(28, obj.getRole());

					result = pstmt.execute();
					result = true;
					
					if(result){
						
						String userId=new IDGenerator().getPrimaryKeyID("campus_user"); 
						
						ps_insertuser=conn.prepareStatement(TeacherUtilsConstants.INSERT_USER_DETAILS);
						
						ps_insertuser.setString(1, userId);
						ps_insertuser.setString(2, obj.getTeacherId());
						ps_insertuser.setString(3,obj.getUsername());
						ps_insertuser.setString(4,genPassword);
						ps_insertuser.setString(5, obj.getRole());
						ps_insertuser.setString(6, obj.getUsertype());
						ps_insertuser.setString(7, obj.getCreatedby());
						ps_insertuser.setTimestamp(8, HelperClass.getCurrentTimestamp());
						
						System.out.println("insert user :: "+ps_insertuser);
						
						ps_insertuser.executeUpdate();
						
						
						pstmt_clssmap_delete=conn.prepareStatement(TeacherUtilsConstants.DELETE_CLAA_MAPPINGS);
						pstmt_clssmap_delete.setString(1, obj.getTeacherId());
						
						System.out.println("delete ::: "+pstmt_clssmap_delete);
						
						pstmt_clssmap_delete.executeUpdate();
						
						 Map dynformValues =obj.getClassmap();
					       int mapcount = dynformValues.size()/2;
					         
					        System.out.println("Map Size: " + dynformValues.size());
					        
					        
					        
					        for(int i =0; i<mapcount ; i++){
					        	
					        	String classTeacherId=new IDGenerator().getPrimaryKeyID("campus_classteacher");
					        	
					        	pstmt_classmap=conn.prepareStatement(TeacherUtilsConstants.INSERT_CLASS_MAPPINGS);
					        	pstmt_classmap.setString(1, classTeacherId);
					        	pstmt_classmap.setString(2, (String)dynformValues.get("name"+i));
					        	pstmt_classmap.setString(3, (String)dynformValues.get("value"+i));
					        	pstmt_classmap.setString(4, obj.getTeacherId());
					        	pstmt_classmap.setTimestamp(5, HelperClass.getCurrentTimestamp());
					        	pstmt_classmap.setString(6, obj.getCreatedby());
					        	
					        	
					        	System.out.println("class map :: "+pstmt_classmap);
					        	
					        	pstmt_classmap.executeUpdate();
					        	
					        }
					        
					        result_class=true;
						
					}
					
					if(result_class){

						
						pstmt_subjectmap_delete=conn.prepareStatement(TeacherUtilsConstants.DELETE_SUBJECT_MAPPINGS);
						pstmt_subjectmap_delete.setString(1, obj.getTeacherId());
						
						System.out.println("delete SUBJECT ::: "+pstmt_clssmap_delete);
						
						pstmt_subjectmap_delete.executeUpdate();
						
						 Map dynformValues =obj.getSubjectsmap();
					       int mapcount = dynformValues.size()/2;
					         
					        System.out.println("Map Size: " + dynformValues.size());
					        
					        for(int i =0; i<mapcount ; i++){
					        	
					        	pstmt_subjectmap=conn.prepareStatement(TeacherUtilsConstants.INSERT_SUBJECTS_MAPPINGS);
					        	pstmt_subjectmap.setString(1, obj.getTeacherId());
					        	pstmt_subjectmap.setString(2, (String)dynformValues.get("name"+i));
					        	pstmt_subjectmap.setString(3, (String)dynformValues.get("value"+i));
					        	pstmt_subjectmap.setString(4, obj.getCreatedby());
					        	pstmt_subjectmap.setTimestamp(5, HelperClass.getCurrentTimestamp());
					        	
					        	
					        	System.out.println("subject map :: "+pstmt_subjectmap);
					        	
					        	pstmt_subjectmap.executeUpdate();
					        	
					        }
					        
					        result_subject=true;
						
					}

					if (result) {
						String url = getServerUrlFromBD(conn);
						// String url="www.google.com";
						String set = sendEmailToEmployee(obj.getUsername(),
								obj.getTeacheremail(), genPassword, url);
						result = true;
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
				if (resultsetcount != null && (!resultsetcount.isClosed())) {
					resultsetcount.close();
				}
				if (pstmtcount != null && (!pstmtcount.isClosed())) {
					pstmtcount.close();
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
				+ " Control in TeacherDaoImpl : teacherregister  Ending");
		return result;
	}

	public String getServerUrlFromBD(Connection connection) {
		String url = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection
					.prepareStatement(TeacherUtilsConstants.GET_SERVER_URL);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				url = rs.getString("URL");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return url;
	}

	public String sendEmailToEmployee(String username, String email,
			String password, String url) {
		try {
			EmailContent em = new EmailContent();
			// String[] mails = { emailId };

			System.out.println("email id in s send employee " + email);

			em.setUsername(username);
			em.setPassword(password);

			em.setContent("Greetings from E-CAMPUS PRO...  \n"
					+ " Thank you for Registering with us \n"
					+ "Please use below Url to track / view / update child activities in School \n"
					+ "Login Credentials are : \n" + "URL		: " + url + "\n"
					+ "User Name		: " + username + "\n" + "Password	: "
					+ password + "\n" + "Have a nice day\n\n\n" + "Regards \n"
					+ "E-CAMPUS PRO \n"
					+ "---------------------------------------------------\n"
					+ "This is System generated mail, Please do not reply."
					+ "\n");
			new SendMail().sendMail(email, em);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "sent";
	}

	public TeacherRegistrationPojo getTeacherDetails(TeacherRegistrationPojo obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getTeacherDetails  Starting");
		boolean status = false;
		int count = 0;
		ResultSet resultset = null;

		Connection conn = null;
		TeacherRegistrationPojo obj1 = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TeacherUtilsConstants.GET_SINGLE_TEACHER_DEATILS);
			pstmt.setString(1, obj.getTeacherId());
			System.out.println(" pstmt " + pstmt);
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				obj1 = new TeacherRegistrationPojo();
				obj1.setTeacherId(obj.getTeacherId());
				obj1.setTfastname(resultset.getString("FirstName"));
				obj1.setTlastname(resultset.getString("LastName"));
				obj1.setRegsitrationNo(resultset.getString("registerId"));
				obj1.setDept(resultset.getString("department"));
				obj1.setDesignation(resultset.getString("designation"));
				obj1.setTqualification(resultset.getString("qualification"));
				obj1.setJoiningdate(resultset.getString("dateofJoining"));
				obj1.setTeachingtype(resultset.getString("teachingType"));
				obj1.setPrimary(resultset.getString("primarySubject"));
				obj1.setSecondary(resultset.getString("secondarySubject"));
				obj1.setGender(resultset.getString("gender"));
				obj1.setDateofbirth(resultset.getString("dateofBirth"));
				obj1.setTeachermobno(resultset.getString("mobileNo"));
				obj1.setTeacheremail(resultset.getString("emailId"));
				obj1.setBlood(resultset.getString("bloodgroup"));
				obj1.setImgpath(resultset.getString("imagePath"));
				obj1.setProfilepath(resultset.getString("profilePath"));
				obj1.setIdproof(resultset.getString("idProofPath"));
				obj1.setFathername(resultset.getString("fathername"));
				obj1.setMothername(resultset.getString("mothername"));
				obj1.setPresentadd(resultset.getString("presentAddress"));
				obj1.setPermanentadd(resultset.getString("permanentAddress"));
				obj1.setUsername(resultset.getString("username"));
				obj1.setStatus("update");
				obj1.setRole(resultset.getString("role"));

			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null && (!resultset.isClosed())) {
					resultset.close();
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
				+ " Control in TeacherDaoImpl : getTeacherDetails  Ending");
		return obj1;
	}

	public String teacherUpdate(TeacherRegistrationPojo obj) {

		String result = "";
		ResultSet resultsetcount = null;
		PreparedStatement pstmtcount = null;

		Connection conn = null;
		
		PreparedStatement pstmt_clssmap_delete = null;
		
		PreparedStatement  pstmt_classmap= null;
		
		PreparedStatement pstmt_subjectmap_delete = null;
		
		PreparedStatement  pstmt_subjectmap= null;
		
		PreparedStatement  ps_updateuser= null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in TeacherDaoImpl : teacherregister  Starting");

			pstmt = (PreparedStatement) JDBCConnection
					.getStatement(TeacherUtilsConstants.UPDATE_TEACHER);

			
			pstmt.setString(1, obj.getTfastname());
			pstmt.setString(2, obj.getTlastname());
			pstmt.setString(3, obj.getTqualification());
			pstmt.setString(4, obj.getPresentadd());
			pstmt.setString(5, obj.getTeachermobno());
			pstmt.setString(6, obj.getUsername());
			pstmt.setString(7, obj.getTeacheremail());
			pstmt.setString(8, obj.getPrimary());
			pstmt.setString(9, obj.getSecondary());
			pstmt.setString(10, obj.getProfilepath());
			pstmt.setString(11, obj.getImgpath());
			pstmt.setString(12, obj.getDateofbirth());
			pstmt.setString(13, obj.getJoiningdate());
			pstmt.setString(14, obj.getDesignation());
			pstmt.setString(15, obj.getIdproof());
			pstmt.setString(16, obj.getTeachingtype());
			pstmt.setString(17, obj.getDept());
			pstmt.setString(18, obj.getGender());
			pstmt.setString(19, obj.getBlood());
			pstmt.setString(20, obj.getFathername());
			pstmt.setString(21, obj.getMothername());
			pstmt.setString(22, obj.getPermanentadd());
			pstmt.setString(23, obj.getCreatedby());
			pstmt.setTimestamp(24, HelperClass.getCurrentTimestamp());
			pstmt.setString(25, obj.getRole());
			pstmt.setString(26, obj.getTeacherId());
			
			int update=pstmt.executeUpdate();
			
			if(update>0){
				
				
				ps_updateuser= conn.prepareStatement(TeacherUtilsConstants.UPDATE_USER_DETAILS);
				ps_updateuser.setString(1, obj.getUsername());
				ps_updateuser.setString(2, obj.getRole());
				ps_updateuser.setString(3, obj.getCreatedby());
				ps_updateuser.setTimestamp(4, HelperClass.getCurrentTimestamp());
				ps_updateuser.setString(5, obj.getTeacherId());
				
				System.out.println("update user :: "+ps_updateuser);
				
				ps_updateuser.executeUpdate();
				
				pstmt_clssmap_delete=conn.prepareStatement(TeacherUtilsConstants.DELETE_CLAA_MAPPINGS);
				pstmt_clssmap_delete.setString(1, obj.getTeacherId());
				
				pstmt_clssmap_delete.executeUpdate();
				
				 Map dynformValues =obj.getClassmap();
			       int mapcount = dynformValues.size()/2;
			         
			        System.out.println("Map Size: " + dynformValues.size());
			        
			        
			        
			        for(int i =0; i<mapcount ; i++){
			        	
			        	String classTeacherId=new IDGenerator().getPrimaryKeyID("campus_classteacher");
			        	
			        	pstmt_classmap=conn.prepareStatement(TeacherUtilsConstants.INSERT_CLASS_MAPPINGS);
			        	pstmt_classmap.setString(1, classTeacherId);
			        	pstmt_classmap.setString(2, (String)dynformValues.get("name"+i));
			        	pstmt_classmap.setString(3, (String)dynformValues.get("value"+i));
			        	pstmt_classmap.setString(4, obj.getTeacherId());
			        	pstmt_classmap.setTimestamp(5, HelperClass.getCurrentTimestamp());
			        	pstmt_classmap.setString(6, obj.getCreatedby());
			        	
			        	update=pstmt_classmap.executeUpdate();
			        	
			        }
			        
			}
			
			
			if(update>0){
				
				pstmt_subjectmap_delete=conn.prepareStatement(TeacherUtilsConstants.DELETE_SUBJECT_MAPPINGS);
				pstmt_subjectmap_delete.setString(1, obj.getTeacherId());
				
				pstmt_subjectmap_delete.executeUpdate();
				
				 Map dynformValues =obj.getSubjectsmap();
			       int mapcount = dynformValues.size()/2;
			         
			        System.out.println("Map Size: " + dynformValues.size());
			        
			        
			        
			        for(int i =0; i<mapcount ; i++){
			        	
			        	
			        	pstmt_subjectmap=conn.prepareStatement(TeacherUtilsConstants.INSERT_SUBJECTS_MAPPINGS);
			        	pstmt_subjectmap.setString(1, obj.getTeacherId());
			        	pstmt_subjectmap.setString(2, (String)dynformValues.get("name"+i));
			        	pstmt_subjectmap.setString(3, (String)dynformValues.get("value"+i));
			        	pstmt_subjectmap.setString(4, obj.getCreatedby());
			        	pstmt_subjectmap.setTimestamp(5, HelperClass.getCurrentTimestamp());
			        	
			        	update=pstmt_subjectmap.executeUpdate();
			        	
			        }
			        
			}
			
			
			if(update > 0)
			{
				result="true";
			}
			else{
				result="false";
			}
			
			
			

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultsetcount != null && (!resultsetcount.isClosed())) {
					resultsetcount.close();
				}
				if (pstmtcount != null && (!pstmtcount.isClosed())) {
					pstmtcount.close();
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
				+ " Control in TeacherDaoImpl : teacherregister  Ending");
		return result;

	}
	
	
	
	

	public boolean checkRegistrationNo(String registratn, String teacherId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : checkRegistrationNo  Starting");
		boolean status = false;
		int count = 0;

		ResultSet resultset = null;

		Connection conn = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(TeacherUtilsConstants.GET_REGISTRAION_COUNT);
			pstmt.setString(1, registratn);
			pstmt.setString(2, teacherId);
			resultset = pstmt.executeQuery();
			System.out.println("prepared statement " + pstmt);

			while (resultset.next()) {
				count = resultset.getInt(1);
			}

			if (count > 0) {
				status = true;

			} else {

				status = false;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null && (!resultset.isClosed())) {
					resultset.close();
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
				+ " Control in TeacherDaoImpl : checkRegistrationNo  Ending");
		return status;
	}

	@Override
	public ArrayList<TeacherMappingClassesVo> getMappingClasses(String teacherID) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getMappingClasses  Starting");
		
		PreparedStatement mappingpstmt = null;
		ResultSet resultset = null;
		Connection conn = null;
		ArrayList<TeacherMappingClassesVo> mappinglist=new ArrayList<TeacherMappingClassesVo>();

		try {
			conn = JDBCConnection.getSeparateConnection();
			mappingpstmt = conn.prepareStatement(TeacherUtilsConstants.GET_MAPPING_CLASSES);
			mappingpstmt.setString(1, teacherID);
			
			System.out.println("prepared statement " + mappingpstmt);
			
			resultset = mappingpstmt.executeQuery();
			

			while (resultset.next()) {
				
				TeacherMappingClassesVo mappingvo=new TeacherMappingClassesVo();
				mappingvo.setMappintID(resultset.getString("CTCode"));
				mappingvo.setClassId(resultset.getString("ClassCode"));
				mappingvo.setSectionId(resultset.getString("SectionCode"));
				mappingvo.setTeacherID(teacherID);
				
				mappinglist.add(mappingvo);
			}

		
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null && (!resultset.isClosed())) {
					resultset.close();
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
				+ " Control in TeacherDaoImpl : getMappingClasses  Ending");
		
		return mappinglist;
	}

	@Override
	public ArrayList<TeacherMappingClassesVo> getMappedSection(
			String teacherID, String classId,String SectionID) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getMappedSection  Starting");
		
		PreparedStatement mappingpstmt = null;
		ResultSet resultset = null;
		Connection conn = null;
		ArrayList<TeacherMappingClassesVo> mappinglist=new ArrayList<TeacherMappingClassesVo>();
		
		PreparedStatement sectionpstmt = null;
		ResultSet sectionRs = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			mappingpstmt = conn.prepareStatement(TeacherUtilsConstants.GET_UNMAPPING_SECTION);
			mappingpstmt.setString(1, classId);
			mappingpstmt.setString(2, teacherID);
			mappingpstmt.setString(3, classId);
			
			System.out.println("prepared statement " + mappingpstmt);
			
			resultset = mappingpstmt.executeQuery();
			

			while (resultset.next()) {
				
				
				TeacherMappingClassesVo mappingvo=new TeacherMappingClassesVo();
				
				mappingvo.setSectionId(resultset.getString("classsection_id_int"));
				mappingvo.setSectionname(resultset.getString("classsection_name_var"));
				
				mappinglist.add(mappingvo);
			}
			
			/*sectionpstmt =conn.prepareStatement(TeacherUtilsConstants.GET_SECTION_NAME);
			sectionpstmt.setString(1, SectionID);
			
			sectionRs=sectionpstmt.executeQuery();
			
			while(sectionRs.next()){
				
				TeacherMappingClassesVo mappingvo=new TeacherMappingClassesVo();
				
				mappingvo.setSectionId(SectionID);
				mappingvo.setSectionname(sectionRs.getString("classsection_name_var"));
				
				mappinglist.add(mappingvo);
			}*/
			

		
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null && (!resultset.isClosed())) {
					resultset.close();
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
				+ " Control in TeacherDaoImpl : getMappedSection  Ending");
		
		return mappinglist;
	}
	
	public ArrayList<TeacherMappingClassesVo> getMappingSubjects(String teacherID) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TeacherDaoImpl : getMappingSubjects  Starting");
		
		PreparedStatement mappingpstmt = null;
		ResultSet resultset = null;
		Connection conn = null;
		ArrayList<TeacherMappingClassesVo> mappinglist=new ArrayList<TeacherMappingClassesVo>();

		try {
			conn = JDBCConnection.getSeparateConnection();
			mappingpstmt = conn.prepareStatement(TeacherUtilsConstants.GET_MAPPING_SUBJECTS);
			mappingpstmt.setString(1, teacherID);
			
			System.out.println("prepared statement " + mappingpstmt);
			
			resultset = mappingpstmt.executeQuery();
			

			while (resultset.next()) {
				
				TeacherMappingClassesVo mappingvo=new TeacherMappingClassesVo();
				mappingvo.setClassId(resultset.getString("classID"));
				mappingvo.setSubjectId(resultset.getString("subjectID"));
				mappingvo.setTeacherID(teacherID);
				
				mappinglist.add(mappingvo);
			}

		
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null && (!resultset.isClosed())) {
					resultset.close();
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
				+ " Control in TeacherDaoImpl : getMappingSubjects  Ending");
		
		return mappinglist;
	}


}
