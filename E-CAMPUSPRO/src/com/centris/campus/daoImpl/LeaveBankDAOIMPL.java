package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.LeaveBankDAO;
import com.centris.campus.forms.AddDesignation;
import com.centris.campus.forms.LeaveBankForm;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.SQLUtilConstants;
import com.centris.campus.vo.AddDesignationVO;
import com.centris.campus.vo.LeaveBankVO;
import com.centris.campus.vo.LeaveRequestVo;

public class LeaveBankDAOIMPL implements LeaveBankDAO {
	private static Logger logger = Logger.getLogger(LeaveBankDAOIMPL.class);

	@Override
	public ArrayList<LeaveBankVO> leavebanklist(LeaveBankVO vo)

	{

		System.out.println("Leave BAnk DAOIMPL is Working");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankDAOIMPL: leavebanklist : Starting");
		PreparedStatement leavebank_pstmt = null;

		ResultSet leavebank_rs = null;

		ArrayList<LeaveBankVO> list = new ArrayList<LeaveBankVO>();

		Connection conn = null;
		if (vo.getAccyearcode() == null
				|| vo.getAccyearcode().equalsIgnoreCase(""))

		{
			try {

				conn = JDBCConnection.getSeparateConnection();
				leavebank_pstmt = conn
						.prepareStatement(SQLUtilConstants.LEAVEBANK_DETAILS);

				leavebank_rs = leavebank_pstmt.executeQuery();

				while (leavebank_rs.next()) {
					LeaveBankVO vo1 = new LeaveBankVO();
					vo1.setSno(leavebank_rs.getString("sno"));
					vo1.setAccyear(leavebank_rs.getString("acadamic_id"));
					vo1.setAcademicyear(leavebank_rs.getString("acadamic_year"));
					System.out.println(leavebank_rs.getString("acadamic_year"));
					vo1.setTotalleaves(leavebank_rs.getString("total_leaves"));
					System.out.println(leavebank_rs.getString("total_leaves"));
					vo1.setPermonth(leavebank_rs.getString("allowed_per_month"));
					System.out.println(leavebank_rs
							.getString("allowed_per_month"));
					list.add(vo1);
				}
			}

			catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {

				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					if (leavebank_rs != null && (!leavebank_rs.isClosed())) {
						leavebank_rs.close();
					}
					if (leavebank_pstmt != null
							&& (!leavebank_pstmt.isClosed())) {
						leavebank_pstmt.close();
					}
					if (conn != null && (!conn.isClosed())) {
						conn.close();
					}
				} catch (SQLException sqle) {

					logger.error(sqle.getMessage(), sqle);
					sqle.printStackTrace();
				} catch (Exception e1) {

					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				}
			}
		} else if (!vo.getAccyearcode().equalsIgnoreCase(""))

			try {
				conn = JDBCConnection.getSeparateConnection();

				leavebank_pstmt = conn
						.prepareStatement(SQLUtilConstants.GET_SEARCH_LEAVEBANKDETAILS);

				leavebank_pstmt.setString(1, "%" + vo.getAccyearcode() + "%");
				leavebank_pstmt.setString(2, "%" + vo.getAccyearcode() + "%");
				leavebank_pstmt.setString(3, "%" + vo.getAccyearcode() + "%");

				leavebank_rs = leavebank_pstmt.executeQuery();
				
				System.out.println("leavebank_pstmt"+leavebank_pstmt);

				while (leavebank_rs.next())

				{
					LeaveBankVO bat = new LeaveBankVO();

					bat.setAcademicyear(leavebank_rs.getString("acadamic_year"));
					
					bat.setTotalleaves(leavebank_rs.getString("total_leaves"));

					bat.setPermonth(leavebank_rs.getString("allowed_per_month"));

					list.add(bat);

				}

			} catch (SQLException e)

			{
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}

			catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}

			finally {
				try {
					if (leavebank_rs != null && (!leavebank_rs.isClosed())) {
						leavebank_rs.close();
					}
					if (leavebank_pstmt != null && (!leavebank_pstmt.isClosed())) {
						leavebank_pstmt.close();
					}
					if (conn != null && (!conn.isClosed())) {
						conn.close();
					}
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
					e.printStackTrace();
				}
			}

		return list;

	}

	@Override
	public String insertLeaveBanksDAO(LeaveBankVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankDAOIMPL :insertLeaveBanksDAO :Starting");

		PreparedStatement pstmt = null;

		String status = null;

		Connection conn = null;

		int result1 = 0;

		try {
			System.out.println("LeaveBankDAOIMPL is Working");

			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn
					.prepareStatement(SQLUtilConstants.INSERT_LEAVEBANK_DETAILS);
			pstmt.setString(1, vo.getAcademicyear());
			pstmt.setString(2, vo.getTotalleaves());
			pstmt.setString(3, vo.getPermonth());
			pstmt.setString(4, vo.getCreateuser());
			pstmt.setDouble(5, vo.getSl());
			pstmt.setDouble(6, vo.getPl());

			pstmt.setDouble(7, vo.getCl());

			result1 = pstmt.executeUpdate();

			System.out.println("pstmt" + pstmt);
			System.out.println("result1" + result1);

			if (result1 > 0) {

				status = MessageConstants.ADD_LEAVEBANK_SUCCESS;

			} else {

				status = MessageConstants.ADD_LEAVEBANK_FAILURE;
			}

		}

		catch (SQLException sqle) {

			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankDAOIMPL :insertLeaveBanksDAO- : Ending");
		return status;

	}

	public String updateLeaveBanksDAO(LeaveBankVO vo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl:insertDesignationDetails:Starting");

		PreparedStatement pstmt = null;

		String status = null;

		Connection conn = null;

		int result1 = 0;

		try {

			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn
					.prepareStatement(SQLUtilConstants.UPDATE_LEAVEBANK_DETAILS);

			pstmt.setString(1, vo.getTotalleaves());
			pstmt.setString(2, vo.getPermonth());
			pstmt.setDouble(3, vo.getSl());
			pstmt.setDouble(4, vo.getPl());

			pstmt.setDouble(5, vo.getCl());
			pstmt.setString(6, vo.getAcademicyear());
			pstmt.setString(7, vo.getSno());

			result1 = pstmt.executeUpdate();

			System.out.println("pstmtpstmt" + pstmt);
			System.out.println("result1" + result1);

			if (result1 > 0) {

				status = MessageConstants.UPDATE_LEAVEBANK_SUCCESS;

			} else {
				status = MessageConstants.UPDATE_LEAVEBANK_FAIL;

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

		return status;

	}

	public LeaveBankForm editleavebank(LeaveBankForm aform)

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationDaoImpl:updateDesignationDetails:Starting");

		PreparedStatement leavebank_pstmt = null;

		ResultSet leavebankrs = null;

		Connection conn = null;
		LeaveBankForm leavebankVO = null;

		try {
			conn = JDBCConnection.getSeparateConnection();
			leavebank_pstmt = conn
					.prepareStatement(SQLUtilConstants.EDIT_LEAVEBANK_DETAILS);

			leavebank_pstmt.setString(1, aform.getSno());

			leavebankrs = leavebank_pstmt.executeQuery();

			while (leavebankrs.next()) {
				leavebankVO = new LeaveBankForm();

				leavebankVO.setAcademicyear(leavebankrs
						.getString("AccyearCode"));
				leavebankVO.setTotalleaves(leavebankrs
						.getString("total_leaves"));
				leavebankVO.setPermonth(leavebankrs
						.getString("allowed_per_month"));
				leavebankVO.setCreatedby(leavebankrs.getString("CreatedBy"));
				leavebankVO.setSickleave(leavebankrs.getDouble("SL"));
				leavebankVO.setPaidleave(leavebankrs.getDouble("PL"));
				leavebankVO.setCasualleave(leavebankrs.getDouble("CL"));

			}
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(), sqle);
			sqle.printStackTrace();
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (leavebankrs != null && (!leavebankrs.isClosed())) {
					leavebankrs.close();
				}
				if (leavebank_pstmt != null && (!leavebank_pstmt.isClosed())) {
					leavebank_pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (SQLException e) {

				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {

				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}
		return leavebankVO;

	}

	@Override
	public ArrayList<LeaveBankVO> getSearchDetails(String searchTextVal) {

		logger.setLevel(Level.DEBUG);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankDAOIMPL : getSearchDetails Starting");

		ArrayList<LeaveBankVO> bat_Details = new ArrayList<LeaveBankVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			conn = JDBCConnection.getSeparateConnection();

			pstmt = conn
					.prepareStatement(SQLUtilConstants.GET_SEARCH_LEAVEBANKDETAILS);

			pstmt.setString(1, "%" + searchTextVal + "%");
			pstmt.setString(2, "%" + searchTextVal + "%");
			pstmt.setString(3, "%" + searchTextVal + "%");

			rs = pstmt.executeQuery();

			while (rs.next())

			{
				LeaveBankVO bat = new LeaveBankVO();

				bat.setAcademicyear(rs.getString("AccyearCode"));

				bat.setTotalleaves(rs.getString("total_leaves"));

				bat.setPermonth(rs.getString("allowed_per_month"));

				bat_Details.add(bat);

			}

		} catch (SQLException e)

		{
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		finally {
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
				+ " Control in LeaveBankDAOIMPL : getSearchDetails Ending");

		return bat_Details;

	}

	@Override
	public Boolean deleteLeave(String[] deletelist) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank DaoImpl:delete Leave Starting");

		Connection con = null;
		PreparedStatement pstmt = null;

		Boolean deletestatus = false;

		try {
			con = JDBCConnection.getSeparateConnection();
			
			for (int i = 0; i < deletelist.length; i++) {
				pstmt = con.prepareStatement(SQLUtilConstants.DELETE_LEAVEBANK_DETAILS);
				pstmt.setString(1, deletelist[i]);
				int count = pstmt.executeUpdate();
				
				System.out.println("pstmt"+pstmt);
				
				if (count > 0) {
					deletestatus = true;
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {

			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}
			} catch (SQLException sql) {
				logger.error(sql.getMessage(), sql);
				sql.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankDAOImpl:deleteLeave  Ending");
		return deletestatus;
	
	}

}
