package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.actions.AdminMenuAction;
import com.centris.campus.dao.FeeMasterDAO;
import com.centris.campus.forms.addfeedetailsform;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.SQLUtilConstants;
import com.centris.campus.vo.AddFeeVO;

public class FeeMasterDAOIMPL implements FeeMasterDAO {

	private static final Logger logger = Logger
			.getLogger(AdminMenuAction.class);

	public synchronized String insertFeeDetails(AddFeeVO vo)

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : insertFeeDetails Starting");
		String result_Status = "";
		PreparedStatement pstmt = null;
		int result1 = 0;
		Connection conn = null;

	

		try {

				conn = JDBCConnection.getSeparateConnection();

				pstmt = conn.prepareStatement(SQLUtilConstants.ADD_FEE_DETAILS);
				pstmt.setString(1,
						IDGenerator.getPrimaryKeyID("campus_fee_master"));
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getDescription());
				pstmt.setString(4, vo.getCreatedby());
				pstmt.setTimestamp(5, HelperClass.getCurrentTimestamp());
				pstmt.setString(6,vo.getConcessiontype());
				
				System.out.println("pstmt"+pstmt);

				result1 = pstmt.executeUpdate();

				if (result1 == 1) {
					result_Status = MessageConstants.SuccessMsg;
				} else {
					result_Status = MessageConstants.ErrorMsg;
				}
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
					exception.printStackTrace();
				}
			}

		

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : insertFeeDetails Ending");

		
		return result_Status;

	}
	
	
	public synchronized String updateFeeDetails(AddFeeVO vo)
	
	{
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : updateFeeDetails Starting");
		String result_Status = "";
		PreparedStatement pstmt = null;
		int result1 = 0;
		Connection conn = null;
		
		
		try {

			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn
					.prepareStatement(SQLUtilConstants.EDIT_FEE_DETAILS);

			pstmt.setString(1, vo.getName().trim());
			pstmt.setString(2, vo.getDescription().trim());
			pstmt.setString(3, vo.getCreatedby().trim());
			pstmt.setTimestamp(4, HelperClass.getCurrentTimestamp());
			pstmt.setString(5, vo.getConcessiontype());
			pstmt.setString(6, vo.getId().trim());

			System.out.println("pstmtupdate"+pstmt);

			result1 = pstmt.executeUpdate();

			if (result1 == 1) {
				result_Status = MessageConstants.SuccessUpMsg;
			} else {
				result_Status = MessageConstants.ErrorUpMsg;
			}
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
				exception.printStackTrace();
			}
		}
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : updateFeeDetails Ending");
		return result_Status;
		
		
	}
	
	

	public synchronized int getFeeNameCheckDao(String feeName) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : getFeeNameCheckDao Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SQLUtilConstants.ADD_FEE_COUNT);

			pstmt.setString(1, feeName);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
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
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {

					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : getFeeNameCheckDao Ending");
		return count;
	}

	public synchronized boolean getnamecount(AddFeeVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : getnamecount Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		Connection conn = null;
		boolean result = false;
		if (vo.getId().equalsIgnoreCase(""))
			
		{
			try {

				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn.prepareStatement(SQLUtilConstants.ADD_FEE_COUNT);
				pstmt.setString(1, vo.getName().trim());
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					count = rs.getInt(1);
				}

				if (count > 0)

				{
					result = true;
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
					if (pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}
					if (conn != null && !conn.isClosed()) {

						conn.close();
					}

				} catch (Exception exception) {
					logger.error(exception.getMessage(), exception);
					exception.printStackTrace();
				}
			}

		}

		if (!vo.getId().equalsIgnoreCase(""))

		{

			

			try {

				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn.prepareStatement(SQLUtilConstants.EDIT_FEE_COUNT);
				pstmt.setString(1, vo.getId().trim());
				pstmt.setString(2, vo.getName().trim());
				rs = pstmt.executeQuery();
				while (rs.next()) {
					count = rs.getInt(1);
				}

				if (count > 0)

				{
					result = true;
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
					if (pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}
					if (conn != null && !conn.isClosed()) {

						conn.close();
					}

				} catch (Exception exception) {
					logger.error(exception.getMessage(), exception);
					exception.printStackTrace();
				}
			}

		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : getnamecount Ending");
		return result;

	}

	public synchronized ArrayList<AddFeeVO> getfeedetails(AddFeeVO val) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : getfeedetails Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		Connection conn = null;
		boolean result = false;

		ArrayList<AddFeeVO> feedetails = new ArrayList<AddFeeVO>();
		
		if (val.getName()==null || val.getName().equalsIgnoreCase(""))
			
		{
		
			try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SQLUtilConstants.GET_FEE_DETAILS);

			rs = pstmt.executeQuery();
			while (rs.next())

			{

				AddFeeVO vo = new AddFeeVO();

				vo.setId(rs.getString("FeeCode").trim());
				vo.setName(rs.getString("FeeName").trim());
				vo.setConcession(rs.getString("IsConcession"));
				vo.setDescription(rs.getString("description").trim());
				feedetails.add(vo);

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
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {

					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}
		
		}
		
		
		else if (!val.getName().equalsIgnoreCase(""))
		
		{
			
			
			try {

				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn.prepareStatement(SQLUtilConstants.SEARCH_FEE_DETAILS);
				pstmt.setString(1, "%"+val.getName()+"%");
				pstmt.setString(2, "%"+val.getName()+"%");
				pstmt.setString(3, "%"+val.getName()+"%");

				
				System.out.println("pstmtpstmt"+pstmt);
				
				rs = pstmt.executeQuery();
				while (rs.next())

				{

					AddFeeVO vo = new AddFeeVO();

					vo.setId(rs.getString("FeeCode").trim());
					vo.setName(rs.getString("FeeName").trim());
					vo.setDescription(rs.getString("description").trim());
					vo.setConcession(rs.getString("IsConcession"));
					feedetails.add(vo);

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
					if (pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}
					if (conn != null && !conn.isClosed()) {

						conn.close();
					}

				} catch (Exception exception) {
					logger.error(exception.getMessage(), exception);
					exception.printStackTrace();
				}
			}
			
		}
		
		

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : getnamecount Ending");

		return feedetails;
	}

	public synchronized AddFeeVO editFeeDetails(AddFeeVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : editFeeDetails Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Connection conn = null;

		AddFeeVO fee = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SQLUtilConstants.GET_EDIT_DETAILS);

			pstmt.setString(1, vo.getId());

			rs = pstmt.executeQuery();
			while (rs.next())

			{

				fee = new AddFeeVO();
				fee.setId(rs.getString("FeeCode"));
				fee.setName(rs.getString("FeeName"));
				fee.setConcession(rs.getString("IsConcession"));

				fee.setDescription(rs.getString("description"));

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
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {

					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : editFeeDetails Ending");

		return fee;
	}

	public synchronized boolean deleteFeeDetails(AddFeeVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : deleteFeeDetails Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		Connection conn = null;
		boolean result = false;

		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SQLUtilConstants.DELETE_FEE_DETAILS);
			pstmt.setString(1, vo.getId());
			
			count = pstmt.executeUpdate();

			if (count > 0)

			{
				result = true;
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
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {

					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : editFeeDetails Ending");

		return result;

	}

	
	public synchronized ArrayList<AddFeeVO> searchFeeDetails(AddFeeVO vo) {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : searchFeeDetails Starting");
		
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		Connection conn = null;
		boolean result = false;

		ArrayList<AddFeeVO> feedetails = new ArrayList<AddFeeVO>();
		try {

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(SQLUtilConstants.SEARCH_FEE_DETAILS);
			pstmt.setString(1, "%"+vo.getName()+"%");
			
			rs = pstmt.executeQuery();
			while (rs.next())

			{

				AddFeeVO val = new AddFeeVO();

				val.setId(rs.getString("FeeCode").trim());
				val.setName(rs.getString("FeeName").trim());
				val.setDescription(rs.getString("description").trim());
				feedetails.add(val);

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
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {

					conn.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeMasterDAOIMPL : searchFeeDetails Ending");

		return feedetails;
	
		
	}

}
