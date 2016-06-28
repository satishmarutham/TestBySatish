package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.centris.campus.dao.ClassFeeSetupDao;
import com.centris.campus.pojo.ClassFeeSetupPojo;
import com.centris.campus.util.ClassFeeSetupDetails;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.ClassFeeSetupVo;

public class ClassFeeSetupDaoImpl implements ClassFeeSetupDao {
	
	private static final Logger logger = Logger
			.getLogger(ClassFeeSetupDaoImpl.class);

	public synchronized ArrayList<ClassFeeSetupVo> getFeeSetupDetails(String currentaccyear) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupDaoImpl:getFeeSetupDetails Starting");
		
		ArrayList<ClassFeeSetupVo> feeList = new ArrayList<ClassFeeSetupVo>();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet1 = null;
		Connection conn = null;
		int sno=0;
		int feecount=0;
		
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ClassFeeSetupDetails.GET_CLASS_DETAILS);
			pstmt.setString(1,currentaccyear);

			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				
				ClassFeeSetupVo feevo = new ClassFeeSetupVo();
				sno++;
				feevo.setSno(sno);
				feevo.setFeecount(feecount);
				feevo.setAccyear(resultSet.getString("acadamic_year"));
				feevo.setAccyearid(resultSet.getString("acadamic_id"));
				feevo.setClassid(resultSet.getString("classdetail_id_int"));
				feevo.setClassname(resultSet.getString("classdetails_name_var"));
				feevo.setTermid(resultSet.getString("termid"));
				feevo.setTermname(resultSet.getString("termname"));
				
				pstmt1 = conn.prepareStatement(ClassFeeSetupDetails.GET_FEE_COUNT);
				pstmt1.setString(1, resultSet.getString("classdetail_id_int"));
				pstmt1.setString(2, resultSet.getString("acadamic_id"));
				pstmt1.setString(3, resultSet.getString("termid"));
				
				resultSet1=pstmt1.executeQuery();
				
				while(resultSet1.next()){
					
					feevo.setFeecount(resultSet1.getInt("feecount"));
				}
				
				feeList.add(feevo);
				
				
				}
			
			
			
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
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
				+ " Control in ClassFeeSetupDaoImpl:getFeeSetupDetails Ending");
		
		return feeList;
	}

	@Override
	public ArrayList<ClassFeeSetupVo> getSearchFeeSetupDetails(String searchTerm,String currentaccyear) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupDaoImpl:getSearchFeeSetupDetails Starting");
		
		ArrayList<ClassFeeSetupVo> feeList = new ArrayList<ClassFeeSetupVo>();
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet1 = null;
		Connection conn = null;
		int sno=0;
		int feecount=0;
		
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ClassFeeSetupDetails.SERCH_FEE_DETAILS);
			pstmt.setString(1, "%"+searchTerm+"%");
			pstmt.setString(2, "%"+searchTerm+"%");
			pstmt.setString(3, "%"+searchTerm+"%");
			pstmt.setString(4, currentaccyear);
			
			resultSet = pstmt.executeQuery();
			
			
			
			while (resultSet.next()) {
				
				ClassFeeSetupVo feevo = new ClassFeeSetupVo();
				sno++;
				feevo.setSno(sno);
				feevo.setFeecount(feecount);
				feevo.setAccyear(resultSet.getString("acadamic_year"));
				feevo.setAccyearid(resultSet.getString("acadamic_id"));
				feevo.setClassid(resultSet.getString("classdetail_id_int"));
				feevo.setClassname(resultSet.getString("classdetails_name_var"));
				feevo.setTermid(resultSet.getString("termid"));
				feevo.setTermname(resultSet.getString("termname"));
				
				pstmt1 = conn.prepareStatement(ClassFeeSetupDetails.GET_FEE_COUNT);
				pstmt1.setString(1, resultSet.getString("classdetail_id_int"));
				pstmt1.setString(2, resultSet.getString("acadamic_id"));
				pstmt1.setString(3, resultSet.getString("termid"));
				
				resultSet1=pstmt1.executeQuery();
				
				while(resultSet1.next()){
					
					feevo.setFeecount(resultSet1.getInt("feecount"));
				}
				
				feeList.add(feevo);
				
				
				}
			
			
			
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
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
				+ " Control in ClassFeeSetupDaoImpl:getSearchFeeSetupDetails Ending");
		
		return feeList;
	}
	
	
	public synchronized ArrayList<ClassFeeSetupVo> getApprovedFees(ClassFeeSetupPojo feeSetupPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupDaoImpl: getApprovedFees Starting");

		PreparedStatement pstmt = null;
		ArrayList<ClassFeeSetupVo> approvedFees = new ArrayList<ClassFeeSetupVo>();
		ResultSet resultSet = null;
		Connection conn = null;
		int count = 0;
		try {
			conn = JDBCConnection.getSeparateConnection();
			pstmt = conn.prepareStatement(ClassFeeSetupDetails.GET_APPROVED_FEES);
			
			pstmt.setString(1, feeSetupPojo.getClassId());
			pstmt.setString(2, feeSetupPojo.getAcadamicYear());
			pstmt.setString(3, feeSetupPojo.getTerm());
			

			if (pstmt != null) {
				resultSet = pstmt.executeQuery();

				while (resultSet.next()) {
					count++;
					ClassFeeSetupVo FeeSetupVo = new ClassFeeSetupVo();

					FeeSetupVo.setSno(count);
					FeeSetupVo.setFeecode(resultSet.getString("FeeCode"));
					FeeSetupVo.setFeename(resultSet.getString("FeeName"));
					FeeSetupVo.setFeesettingcode(resultSet
							.getString("feeSettingCode"));
					FeeSetupVo.setFeeamount(resultSet.getString("feeAmount"));
					FeeSetupVo.setAcadamicyear(feeSetupPojo.getAcadamicYear());
					FeeSetupVo.setClassid(feeSetupPojo.getClassId());
					FeeSetupVo.setTerm(feeSetupPojo.getTerm());

					approvedFees.add(FeeSetupVo);
				}
			}
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
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
				+ " Control in ClassFeeSetupDaoImpl: getApprovedFees  Ending");

		return approvedFees;

	}

	@Override
	public ArrayList<ClassFeeSetupVo> getAllFees(ClassFeeSetupPojo feeSetupPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupDaoImpl: getAllFees Starting");

		ArrayList<ClassFeeSetupVo> allfeeslist = new ArrayList<ClassFeeSetupVo>();

		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int count = 0;
		Connection conn = null;
		try {
			conn = JDBCConnection.getSeparateConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(ClassFeeSetupDetails.GET_ALL_FEES);

			pstmt.setString(1, feeSetupPojo.getClassId());
			pstmt.setString(2, feeSetupPojo.getAcadamicYear());
			pstmt.setString(3, feeSetupPojo.getTerm());
			
			System.out.println("get all fees ::: "+pstmt);
			
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				count++;
				ClassFeeSetupVo feeSetupVo = new ClassFeeSetupVo();
				feeSetupVo.setSno(count);
				feeSetupVo.setFeecode(resultSet.getString("FeeCode"));
				feeSetupVo.setFeename(resultSet.getString("FeeName"));

				allfeeslist.add(feeSetupVo);
			}
		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
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
				+ " Control in ClassFeeSetupDaoImpl: getAllFees  Ending");

		return allfeeslist;
	}
	
	
	public synchronized int insertApproveFees(ArrayList<ClassFeeSetupPojo> approvefeelist) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupDaoImpl: insertApproveFees Starting");

		PreparedStatement pstmt = null;
		PreparedStatement pst = null;
		PreparedStatement pstmt1=null;
		ResultSet rs1=null;
		Connection conn = null;
		String setupcode=null;
		int setupcount=0;
		int fee_count = 0;
		int count = 0;
		try {
			conn = JDBCConnection.getSeparateConnection();
			
			System.out.println("list size ::: "+approvefeelist.size());
			
			for (int i=0;i<approvefeelist.size();i++) {

				pstmt1=conn.prepareStatement(ClassFeeSetupDetails.FEE_SETUP_COUNT);
				pstmt1.setString(1, approvefeelist.get(i).getClassId());
				pstmt1.setString(2, approvefeelist.get(i).getAcadamicYear());
				pstmt1.setString(3, approvefeelist.get(i).getTerm());
				rs1=pstmt1.executeQuery();
				
				while(rs1.next()){
					
					setupcount=rs1.getInt(1);
				}
				
				System.out.println("setupcount ::: "+setupcount);
				
				if(setupcount==0){
					
					setupcode=IDGenerator.getPrimaryKeyID("campus_fee_setup");
					
					pst = conn.prepareStatement(ClassFeeSetupDetails.INSERT_APPROVED_FEES_IN_FEE_SETUP);

					pst.setString(1, setupcode);
					pst.setString(2, approvefeelist.get(i).getClassId());
					pst.setString(3, approvefeelist.get(i).getAcadamicYear());
					pst.setString(4, approvefeelist.get(i).getTerm());
					pst.setString(5, approvefeelist.get(i).getCreatedby());
					
					System.out.println("insert into fee setup ::: "+pst);

					count = pst.executeUpdate();
				}
				
				System.out.println("setupcode ::: "+setupcode);
				if(setupcode!=null){
					if (count > 0) {
						PreparedStatement insert_pstmt = conn.prepareStatement(ClassFeeSetupDetails.INSERT_APPROVED_FEES);
						insert_pstmt.setString(1,setupcode);
						insert_pstmt.setString(2, approvefeelist.get(i).getFeeId());
						insert_pstmt.setDouble(3, 0);
						
						System.out.println("insert into fee setupDetails ::: "+insert_pstmt);
						
						fee_count = insert_pstmt.executeUpdate();
					}
					}else{
						PreparedStatement insert_pstmt = conn.prepareStatement(ClassFeeSetupDetails.INSERT_APPROVED_FEES_AMT);
						
						insert_pstmt.setString(1, approvefeelist.get(i).getClassId());
						insert_pstmt.setString(2, approvefeelist.get(i).getAcadamicYear());
						insert_pstmt.setString(3, approvefeelist.get(i).getTerm());
						insert_pstmt.setString(4, approvefeelist.get(i).getFeeId());
						insert_pstmt.setDouble(5, 0);
						
						System.out.println("insert into fee setupDetails ::: "+insert_pstmt);
						
						fee_count = insert_pstmt.executeUpdate();
						
					}
			}
			
		} catch (SQLException sqlExp) {
			
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		} finally {

			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (pst != null && !pst.isClosed()) {
					pst.close();
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
				+ " Control in ClassFeeSetupDaoImpl: insertApproveFees  Ending");

		return fee_count;
	}

	@Override
	public boolean deleteFees(ClassFeeSetupPojo feeSetupPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupDaoImpl: deleteFees Starting");
		int count = 0;
		boolean flag = false;
		PreparedStatement count_pstmt = null;
		Connection conn = null;
		try {

			conn = JDBCConnection.getSeparateConnection();
			count_pstmt = conn
					.prepareStatement(ClassFeeSetupDetails.DELETE_FEE_CODE);

			count_pstmt.setString(1, feeSetupPojo.getFeesettingCode());
			count_pstmt.setString(2, feeSetupPojo.getFeeId());

			count = count_pstmt.executeUpdate();
			if (count > 0) {

				flag = true;
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {

			try {

				if (count_pstmt != null && !count_pstmt.isClosed()) {
					count_pstmt.close();
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
				+ " Control in ClassFeeSetupDaoImpl: deleteFees  Ending");
		return flag;
	}

	public synchronized boolean insertFeeAmount(ArrayList<ClassFeeSetupPojo> feeSetupList) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupDaoImpl: insertFeeAmount Starting");

		int count = 0;
		boolean flag = false;
		PreparedStatement count_pstmt = null;
		Connection connection = null;
		try {

			connection = JDBCConnection.getSeparateConnection();
			count_pstmt = connection.prepareStatement(ClassFeeSetupDetails.UPDATE_FEE_AMOUNT);

			for(int i=0; i<feeSetupList.size();i++){
				
			count_pstmt.setString(1, feeSetupList.get(i).getFeeamount());
			count_pstmt.setString(2, feeSetupList.get(i).getClassId());
			count_pstmt.setString(3, feeSetupList.get(i).getAccYear());
			count_pstmt.setString(4, feeSetupList.get(i).getTermId());
			count_pstmt.setString(5, feeSetupList.get(i).getFeeId());
			
			System.out.println("update fee amount ::: "+count_pstmt);

			count = count_pstmt.executeUpdate();
			}

			if (count > 0) {

				flag = true;
			}

		} catch (SQLException sqlExp) {
			logger.error(sqlExp.getMessage(), sqlExp);
			sqlExp.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {

			try {

				if (count_pstmt != null && !count_pstmt.isClosed()) {
					count_pstmt.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}

			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClassFeeSetupDaoImpl: insertFeeAmount  Ending");
		return flag;
	}
	
}