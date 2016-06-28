package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.LoginSqlUtil;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.SQLUtilConstants;
import com.centris.campus.vo.LoginVo;
import com.centris.campus.vo.UserDetailVO;

public class LoginDaoImpl {
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	public LoginVo validateUserDaoImpl(String username, String password) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LoginDaoImpl : validateUserDaoImpl  Starting");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		LoginVo loginvo=new LoginVo();
		try {

			String sql = null;

			con = JDBCConnection.getSeparateConnection();
			
			sql = "select employeecode,username,password,type,role from  campus_user  where  username = ? and password=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				loginvo.setUsercode(rs.getString("employeecode"));
				loginvo.setUsername(rs.getString("username"));
				loginvo.setUsertype(rs.getString("type"));
				loginvo.setUserrole(rs.getString("role"));
				loginvo.setPassword(rs.getString("password"));
				
			}
			
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
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDaoImpl : validateUserDaoImpl  Ending");
		
		return loginvo;
	}
	
	public UserDetailVO loadUserDaoImpl(LoginVo loginvo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDaoImpl : loadUserServiceImpl  Starting");
		UserDetailVO userDetails = new UserDetailVO();
		PreparedStatement statement = null;
		ResultSet userDetailsResultSet = null;
		
		PreparedStatement ps_permission = null;
		ResultSet rs_permission = null;
		
		HashMap<String, String> permissionmap=new HashMap<String, String>();
		
		Connection con = null;
		String roleCode=null;
		boolean flag=true;
		try {

			con=JDBCConnection.getSeparateConnection();
			
			if(loginvo.getUsertype().equalsIgnoreCase("perent")){
				
				PreparedStatement pstmt=con.prepareStatement(LoginSqlUtil.GET_PARENT_CHAILD_RELATION);
				pstmt.setString(1, loginvo.getUsercode());
				
				ResultSet rs=pstmt.executeQuery();
				
				String relationship=null;
				
				System.out.println("pstmt :: "+pstmt);
				
				while(rs.next()){
					
					relationship=rs.getString("relationship");
				}
			
				if(relationship.endsWith("father")){
					
					statement=con.prepareStatement(LoginSqlUtil.GET_FATHER_DETAILS);
				
				}else if(relationship.endsWith("mother")){
					
					statement=con.prepareStatement(LoginSqlUtil.GET_MOTHER_DETAILS);
				}else{
					
					statement=con.prepareStatement(LoginSqlUtil.GET_GUARDIAN_DETAILS);
				}
			
				
			
			statement.setString(1, loginvo.getUsercode());
			
			System.out.println("statement :: "+statement);
			
			userDetailsResultSet = statement.executeQuery();

			while (userDetailsResultSet.next()) {

				userDetails.setUserId(userDetailsResultSet.getString("ParentID"));
				userDetails.setFirstName(userDetailsResultSet.getString("parentname"));
				userDetails.setQualification(userDetailsResultSet.getString("Qualification"));
				userDetails.setAddress(userDetailsResultSet.getString("address"));
				userDetails.setMobileno(userDetailsResultSet.getString("mobileno"));
				userDetails.setUserName(userDetailsResultSet.getString("UserName"));
				userDetails.setGender("");
				userDetails.setEmail(userDetailsResultSet.getString("email"));
				userDetails.setPassword(userDetailsResultSet.getString("password"));
				userDetails.setLasttimevisit(userDetailsResultSet.getDate("lastLogin"));
				userDetails.setRoleCode(userDetailsResultSet.getString("role"));
				userDetails.setRoleName(userDetailsResultSet.getString("RoleName"));
				roleCode=userDetailsResultSet.getString("role");
				userDetails.setUserNametype(userDetailsResultSet.getString("type"));
			}
			
		 }else{
				
				statement=con.prepareStatement(LoginSqlUtil.GET_STAFF_DETAILS);
				
				statement.setString(1, loginvo.getUsercode());
				
				userDetailsResultSet = statement.executeQuery();

				while (userDetailsResultSet.next()) {

					userDetails.setUserId(userDetailsResultSet.getString("TeacherID"));
					userDetails.setFirstName(userDetailsResultSet.getString("teachername"));
					userDetails.setQualification(userDetailsResultSet.getString("qualification"));
					userDetails.setAddress(userDetailsResultSet.getString("presentAddress"));
					userDetails.setMobileno(userDetailsResultSet.getString("mobileNo"));
					userDetails.setUserName(userDetailsResultSet.getString("username"));
					userDetails.setGender(userDetailsResultSet.getString("gender"));
					userDetails.setEmail(userDetailsResultSet.getString("emailId"));
					userDetails.setPassword(userDetailsResultSet.getString("password"));
					userDetails.setLasttimevisit(userDetailsResultSet.getDate("lastLogin"));
					userDetails.setRoleCode(userDetailsResultSet.getString("role"));
					userDetails.setRoleName(userDetailsResultSet.getString("RoleName"));
					roleCode=userDetailsResultSet.getString("role");
					userDetails.setUserNametype(userDetailsResultSet.getString("type"));
				}
			 
		 }
			
			if(roleCode!=null || roleCode !=""){
				
				ps_permission = con.prepareStatement(LoginSqlUtil.GET_PERMISSION_DETAILS);
				ps_permission.setString(1, roleCode);
				
				System.out.println("Permission Details ::: "+ps_permission);
				
				rs_permission = ps_permission.executeQuery();
				
				while(rs_permission.next()) {
					
					flag=false;
				
					permissionmap.put(rs_permission.getString("shortName"),rs_permission.getString("isApplicable"));
							
					userDetails.setPermissionmap(permissionmap);
					
				} 
				
				if(flag){
					
					userDetails.setPermissionmap(permissionmap);
				}
				
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
			exception.printStackTrace();
			
		} finally {

			try {
				if (userDetailsResultSet != null && !userDetailsResultSet.isClosed()) {
					userDetailsResultSet.close();
				}
				if (statement != null && (!statement.isClosed())) {
					statement.getConnection().close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDaoImpl : loadUserServiceImpl  Ending");
	
			return userDetails;
		
	}

	public int checkCurrentPassword(String currentuser, String currentPassword,
			String currentuserId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDaoImpl : checkCurrentPassword Starting");
		PreparedStatement statement = null;
		ResultSet rs = null;
		int count = 0;
		Connection con = null;
		try {
			con = JDBCConnection.getSeparateConnection();
			if (currentuser.equalsIgnoreCase("userDetails")) {
				statement = con
						.prepareStatement(SQLUtilConstants.CHECK_PARENTS_PASSWORD);
				statement.setString(1, currentuserId.trim());
				statement.setString(2, currentPassword.trim());

			} else if (currentuser.equalsIgnoreCase("Teacher")) {
				statement = con
						.prepareStatement(SQLUtilConstants.CHECK_TEACHERS_PASSWORD);
				statement.setString(1, currentuserId.trim());
				statement.setString(2, currentPassword.trim());

			} else if (currentuser.equalsIgnoreCase("Principle")) {

				statement = con
						.prepareStatement(SQLUtilConstants.CHECK_PRINCIPAL_PASSWORD);
				statement.setString(1, currentuserId.trim());
				statement.setString(2, currentPassword.trim());

			} else {
				statement = con
						.prepareStatement(SQLUtilConstants.CHECK_ADMIN_PASSWORD);
				statement.setString(1, currentuserId.trim());
				statement.setString(2, currentPassword.trim());

			}
			rs = statement.executeQuery();
			while (rs.next()) {

				count = rs.getInt(1);

			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		} finally {

			try {

				if (statement != null && (!statement.isClosed())) {
					statement.getConnection().close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDaoImpl : checkCurrentPassword Ending");

		return count;
	}

	public int changePassword(String currentuser, String newpassword,
			String currentuserId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDaoImpl : checkCurrentPassword Starting");
		PreparedStatement statement = null;
		int count = 0;
		Connection con = null;
		try {
			con = JDBCConnection.getSeparateConnection();

			if (currentuser.equalsIgnoreCase("userDetails")) {
				statement = con
						.prepareStatement(SQLUtilConstants.UPDATE_PERENTS_PASSWORD);

				statement.setString(1, newpassword.trim());
				statement.setString(2, currentuserId.trim());

			} else if (currentuser.equalsIgnoreCase("Teacher")) {
				statement = con
						.prepareStatement(SQLUtilConstants.UPDATE_TEACHERS_PASSWORD);

				statement.setString(1, newpassword.trim());
				statement.setString(2, currentuserId.trim());

			} else if (currentuser.equalsIgnoreCase("Principle")) {
				statement = con
						.prepareStatement(SQLUtilConstants.UPDATE_PRINCIPAL_PASSWORD);

				statement.setString(1, newpassword.trim());
				statement.setString(2, currentuserId.trim());

			} else {

				statement = con
						.prepareStatement(SQLUtilConstants.UPDATE_ADMIN_PASSWORD);
				statement.setString(1, newpassword.trim());
				statement.setString(2, currentuserId.trim());

			}

			count = statement.executeUpdate();

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.getStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.getStackTrace();
		} finally {

			try {
				if (statement != null && (!statement.isClosed())) {
					statement.getConnection().close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.getStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDaoImpl : checkCurrentPassword Ending");

		return count;
	}

	}