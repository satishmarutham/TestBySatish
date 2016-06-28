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

import com.centris.campus.dao.UserManagementDao;
import com.centris.campus.pojo.UserManagementPojo;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.UserManagementSqlutil;
import com.centris.campus.vo.UserRecordVO;

public class UserManagementDaoImpl implements UserManagementDao {

	private static final Logger logger = Logger	.getLogger(UserManagementDaoImpl.class);
	
	public List<UserRecordVO> getUserRecordsDao() {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in UserManagementDaoImpl : getUserRecordsDao  Starting");
		
		PreparedStatement ps_getUsers = null;
		ResultSet rs_getUsers= null;
		Connection conn = null;
		
		List<UserRecordVO> userRecordsList = new ArrayList<UserRecordVO>();
		try {
			conn = JDBCConnection.getSeparateConnection();
			
			ps_getUsers = conn.prepareStatement(UserManagementSqlutil.USERRECORDS);
			
			rs_getUsers = ps_getUsers.executeQuery();
			
			while (rs_getUsers.next()) {
				
				UserRecordVO userRecordVO = new UserRecordVO();
				userRecordVO.setUserName(rs_getUsers.getString("username"));
				userRecordVO.setMobile(rs_getUsers.getString("mobileno"));
				userRecordVO.setAddress(rs_getUsers.getString("presentAddress"));
				userRecordVO.setFirstName(rs_getUsers.getString("FirstName"));
				
				
				
				if (rs_getUsers.getString("Id").startsWith("PAR")) {
					userRecordVO.setDesignation("Parent");
				} else {
					userRecordVO.setDesignation("Teacher");
				}
				userRecordVO.setUserId(rs_getUsers.getString("Id"));
				
				userRecordsList.add(userRecordVO);
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (rs_getUsers != null	&& !rs_getUsers.isClosed()) {
					rs_getUsers.close();
				}
				if (ps_getUsers != null && !ps_getUsers.isClosed()) {
					ps_getUsers.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in Control in UserManagementDaoImpl : getUserRecordsDao Ending");
	
		
		return userRecordsList;
	}




	public List<UserRecordVO> getSearchUserDetailsDao(UserManagementPojo userManagementPojo) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in UserManagementDaoImpl : getSearchUserDetailsDao  Starting");
		
		PreparedStatement ps_getUsers = null;
		ResultSet rs_getUsers= null;
		Connection conn = null;
		
		List<UserRecordVO> userRecordsList = new ArrayList<UserRecordVO>();
		try {
			conn = JDBCConnection.getSeparateConnection();
			
			if(MessageConstants.TEACHER_SHORT_NAME.equalsIgnoreCase(userManagementPojo.getType())){
				
				ps_getUsers = conn.prepareStatement(UserManagementSqlutil.GET_TEACHERS);
				ps_getUsers.setString(1, "%"+userManagementPojo.getSearchtext()+"%");
				ps_getUsers.setString(2, "%"+userManagementPojo.getSearchtext()+"%");
				ps_getUsers.setString(3, "%"+userManagementPojo.getSearchtext()+"%");
				ps_getUsers.setString(4, "%"+userManagementPojo.getSearchtext()+"%");
				
			}else{
			
		      	ps_getUsers = conn.prepareStatement(UserManagementSqlutil.GET_PARENTS);
		      	ps_getUsers.setString(1, "%"+userManagementPojo.getSearchtext()+"%");
		    	ps_getUsers.setString(2, "%"+userManagementPojo.getSearchtext()+"%");
		    	ps_getUsers.setString(3, "%"+userManagementPojo.getSearchtext()+"%");
		    	
			}
			
			rs_getUsers = ps_getUsers.executeQuery();
			
			while (rs_getUsers.next()) {
				UserRecordVO userRecordVO = new UserRecordVO();
				userRecordVO.setUserName(rs_getUsers.getString("username"));
				userRecordVO.setMobile(rs_getUsers.getString("mobileno"));
				/*userRecordVO.setAddress(rs_getUsers.getString("address"));*/
				userRecordVO.setFirstName(rs_getUsers.getString("FirstName"));
				if (rs_getUsers.getString("Id").startsWith("PAR")) {
					userRecordVO.setDesignation("Parent");
				} else {
					userRecordVO.setDesignation("Teacher");
				}
				userRecordVO.setUserId(rs_getUsers.getString("Id"));
				
				userRecordsList.add(userRecordVO);
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (rs_getUsers != null	&& !rs_getUsers.isClosed()) {
					rs_getUsers.close();
				}
				if (ps_getUsers != null && !ps_getUsers.isClosed()) {
					ps_getUsers.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in Control in UserManagementDaoImpl : getSearchUserDetailsDao Ending");
	
		
		return userRecordsList;
	}





	public UserRecordVO getUserDeatils(UserManagementPojo userManagementPojo) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in UserManagementDaoImpl : getUserDeatils  Starting");
		
		PreparedStatement ps_getUsers = null;
		ResultSet rs_getUsers= null;
		Connection conn = null;
		
		UserRecordVO  userRecordVO=new  UserRecordVO();
		try {
			conn = JDBCConnection.getSeparateConnection();
			
            if(MessageConstants.TEACHER_SHORT_NAME.equalsIgnoreCase(userManagementPojo.getUserId().substring(0, 3))){
				
				ps_getUsers = conn.prepareStatement(UserManagementSqlutil.GET_TEACHER);
				ps_getUsers.setString(1, userManagementPojo.getUserId());
			}else{
			
		      	ps_getUsers = conn.prepareStatement(UserManagementSqlutil.GET_PARENT);
		      	ps_getUsers.setString(1, userManagementPojo.getUserId());
			}
			
			
			rs_getUsers = ps_getUsers.executeQuery();
			
			
			while (rs_getUsers.next()) {
			
				userRecordVO.setFirstName(rs_getUsers.getString("FirstName"));
				userRecordVO.setEmail(rs_getUsers.getString("UserName"));
				
			
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (rs_getUsers != null	&& !rs_getUsers.isClosed()) {
					rs_getUsers.close();
				}
				if (ps_getUsers != null && !ps_getUsers.isClosed()) {
					ps_getUsers.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in Control in UserManagementDaoImpl : getUserDeatils Ending");
	
		
		return userRecordVO;
	}




	public String changePassword(UserManagementPojo userManagementPojo) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in UserManagementDaoImpl : changePassword  Starting");
		
		PreparedStatement ps_updatePwd = null;
		Connection conn = null;
		String result=MessageConstants.FALSE;
		
		try {
			conn = JDBCConnection.getSeparateConnection();
			
            if(MessageConstants.TEACHER_SHORT_NAME.equalsIgnoreCase(userManagementPojo.getUserId().substring(0, 3))){
				
            	ps_updatePwd = conn.prepareStatement(UserManagementSqlutil.CHANGE_TEACHER_PWD);
            	ps_updatePwd.setString(1, userManagementPojo.getPasswrd());
            	ps_updatePwd.setString(2, userManagementPojo.getUserId());
            	
            	

			}else{
			
				ps_updatePwd = conn.prepareStatement(UserManagementSqlutil.CHANGE_PARENT_PWD);
				ps_updatePwd.setString(1, userManagementPojo.getPasswrd());
            	ps_updatePwd.setString(2, userManagementPojo.getUserId());
            	
            	
			}
			
			
			int count  = ps_updatePwd.executeUpdate();
			
			if(count>0){
				
				result = MessageConstants.TRUE;
			}
			
			

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				
				if (ps_updatePwd != null && !ps_updatePwd.isClosed()) {
					ps_updatePwd.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in Control in UserManagementDaoImpl : changePassword Ending");
	
		
		return result;
	}



	public String blockUser(UserManagementPojo userManagementPojo) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in UserManagementDaoImpl : blockUser  Starting");
		
		PreparedStatement ps_blockUser = null;
		Connection conn = null;
		String result=MessageConstants.FALSE;
	
		try {
			conn = JDBCConnection.getSeparateConnection();
			
            if(MessageConstants.TEACHER_SHORT_NAME.equalsIgnoreCase(userManagementPojo.getUserId().substring(0, 3))){
				
            	ps_blockUser = conn.prepareStatement(UserManagementSqlutil.BLOCK_TEACHER);
            	ps_blockUser.setString(1, userManagementPojo.getUserId());

			}else{
			
				ps_blockUser = conn.prepareStatement(UserManagementSqlutil.BLOCK_PARENT);
				ps_blockUser.setString(1, userManagementPojo.getUserId());
			}
			
			int count  = ps_blockUser.executeUpdate();
			
			if(count>0){
				
				result = MessageConstants.TRUE;
			}
			
			

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				
				if (ps_blockUser != null && !ps_blockUser.isClosed()) {
					ps_blockUser.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in Control in UserManagementDaoImpl : blockUser Ending");
	
		
		return result;
	}

}
