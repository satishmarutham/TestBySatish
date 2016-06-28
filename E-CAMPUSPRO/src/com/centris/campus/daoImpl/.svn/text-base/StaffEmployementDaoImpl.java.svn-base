package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.campus.dao.StaffEmployementDao;
import com.centris.campus.forms.StaffEmployementForm;
import com.centris.campus.util.ClassUtilsConstants;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.StaffEmployementUtil;
import com.centris.campus.vo.StaffEmployementVo;
import com.centris.campus.vo.StaffSearchVo;
import com.itextpdf.text.log.SysoLogger;

public class StaffEmployementDaoImpl implements StaffEmployementDao{

	private static final Logger logger = Logger.getLogger(StaffEmployementDaoImpl.class);
	

	@Override
	public StaffEmployementVo                    getStaffEmployementEntry(String teachercode) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffEmployementDaoImpl : getStaffEmployementEntry Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs_salary=null;

		StaffEmployementVo empvo=new StaffEmployementVo();
		
		try {
				conn = JDBCConnection.getSeparateConnection();
				pstmt = conn.prepareStatement(StaffEmployementUtil.GET_SALARY_DETAILS);
				pstmt.setString(1, teachercode);
					
				
				System.out.println("GET_SALARY_DETAILS"+pstmt);
				
				rs_salary=pstmt.executeQuery();
			
				while(rs_salary.next()){
					 
					 empvo.setBankaccnumber(rs_salary.getLong("BankAccNumber"));
					 empvo.setEmployeepfno(rs_salary.getString("EmployeePfNo"));
					 empvo.setBankname(rs_salary.getString("BankName"));
					 empvo.setIFSCCode(rs_salary.getString("IFSCCode"));
					 empvo.setPaymenttype(rs_salary.getString("PaymentType"));
					 
					 empvo.setEmpid(rs_salary.getString("registerId"));
					 empvo.setEmpname(rs_salary.getString("staffName"));
					 
					 empvo.setBasic(rs_salary.getDouble("Basic"));
					 empvo.setCa(rs_salary.getDouble("Ca"));
					 empvo.setHrapercentag(rs_salary.getInt("HraPercentage"));
					 empvo.setHra(rs_salary.getDouble("Hra"));
					 empvo.setMedicalallowances(rs_salary.getDouble("MedicalAllowances"));
					 empvo.setTelephonereim(rs_salary.getDouble("TelephoneAllowance"));
					 empvo.setPerfincentive(rs_salary.getDouble("PerformanceIncentive"));
					 empvo.setSpecialallowance(rs_salary.getDouble("SpecialAllowance"));
					 empvo.setFoodallowance(rs_salary.getDouble("FoodAllowance"));
					 empvo.setWashingallowance(rs_salary.getDouble("WashingAllowance"));
					 empvo.setOthers(rs_salary.getDouble("OtherAllowance"));
					 empvo.setEmployerpf(rs_salary.getDouble("EmployerPf"));
					 empvo.setEmployerESI(rs_salary.getDouble("EmployerESI"));
					 empvo.setGrosssalary(rs_salary.getDouble("GrossSalary"));
					 empvo.setCtc(rs_salary.getDouble("Ctc"));
					 empvo.setDemployerpf(rs_salary.getDouble("DeduEmployerPf"));
					 empvo.setEmployeepf(rs_salary.getDouble("EmployeePf"));
					 empvo.setIncometax(rs_salary.getDouble("IncomeTax"));
					 empvo.setPt(rs_salary.getDouble("Pt"));
					 empvo.setDedmployerESI(rs_salary.getDouble("DeduEmployerESI"));
					 empvo.setEmployeeESI(rs_salary.getDouble("EmployeeESI"));
					 
					 String leave=rs_salary.getString("LeaveDeductions");
					 if(leave==null||leave=="")
					 {
						 System.out.println("leave N loop");
						 empvo.setLeavedeductions("N");
 
					 }
					 else
					 {
						 System.out.println("leave  loop");

						 empvo.setLeavedeductions(leave);

					 }
					 
					 String late=rs_salary.getString("LateDeductions");
					 if(late==null||late=="")
					 {
						 
						 System.out.println("late N loop");

						 empvo.setLatedeductions("N");
 
					 }
					 else
					 {
						 System.out.println("late loop");

						 empvo.setLatedeductions(late);

					 }
					 empvo.setTdsctc(rs_salary.getDouble("TDSCtc"));
					 empvo.setStandarddedu(rs_salary.getDouble("TDSStandardDeductions"));
					 empvo.setTaxbleincomestatury(rs_salary.getDouble("TDSTaxbleIncomeWithStatury"));
					 empvo.setTdspf(rs_salary.getDouble("TDSPF"));
					 empvo.setTdspt(rs_salary.getDouble("TDSPT"));
					 empvo.setTaxableincome(rs_salary.getDouble("TDSTaxbleIncome"));
					 empvo.setTaxpayble(rs_salary.getDouble("TDSTaxPayble"));
					
				 }

			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} finally {
				try {
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
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in StaffEmployementDaoImpl : getStaffEmployementEntry  Starting");
	
	return empvo;

	}

	@Override
	public String saveStaffSalaryDetails(StaffEmployementForm espojo,
			String userId) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffEmployementDaoImpl : saveStaffSalaryDetails Starting");
		Connection conn = null;
		PreparedStatement salarystatement = null;

		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		
		String status=null;
		int count=0;
		
		Timestamp currentdate=HelperClass.getCurrentTimestamp();


		
		int existCount=0;
		
		try {
				conn = JDBCConnection.getSeparateConnection();
				
				System.out.println("DAOIMPL IS WORKING");
				
				
				pstmt1= conn.prepareStatement(StaffEmployementUtil.GET_SALARY_COUNT);
				pstmt1.setString(1, espojo.getHemloyeeid());
				
				System.out.println("pstmt1 :: "+pstmt1);
				
				rs=pstmt1.executeQuery();
				
				while(rs.next()){
					
					existCount=rs.getInt(1);
				}
				
				if(existCount==0){
					
				
					salarystatement = conn.prepareStatement(StaffEmployementUtil.INSERT_SALARY);
				
				
				/*pstmt.setString(1, staffForm.getHempid());
				pstmt.setString(2, staffForm.getAccno());
				pstmt.setString(3, staffForm.getEmppfno());
				pstmt.setString(4, staffForm.getPaymenttype());
				pstmt.setString(5, staffForm.getEsino());
				pstmt.setString(6, staffForm.getPanno());
				pstmt.setString(7, staffForm.getBasic());
				pstmt.setString(8, staffForm.getHra());
				pstmt.setString(9, staffForm.getConviance());
				pstmt.setString(10, staffForm.getGrosssal());
				pstmt.setString(11, staffForm.getCa());
				pstmt.setString(12, staffForm.getDa());
				pstmt.setString(13, staffForm.getEmprpf());
				pstmt.setString(14, staffForm.getEmppf());
				pstmt.setString(15, staffForm.getIncometax());
				pstmt.setString(16, staffForm.getPt());
				pstmt.setString(17, staffForm.getOtherdeductions());
				pstmt.setString(18, staffForm.getLeavedeductions());
				pstmt.setString(19, staffForm.getMedical());
				pstmt.setString(20, staffForm.getOthers());
				pstmt.setString(21, staffForm.getCtc());
				pstmt.setString(22, userId);
				pstmt.setTimestamp(23, HelperClass.getCurrentTimestamp());*/
				
				 salarystatement.setString(1, espojo.getHemloyeeid());
				 salarystatement.setLong(2,espojo.getBankaccnumber());
				 salarystatement.setString(3, espojo.getEmployeepfno());
				 salarystatement.setString(4, espojo.getBankname());
				 salarystatement.setString(5, espojo.getIFSCCode());
				 salarystatement.setString(6, espojo.getPaymenttype());
				 salarystatement.setDouble(7, espojo.getBasic());
				 salarystatement.setDouble(8, espojo.getCa());
				 salarystatement.setInt(9, espojo.getHrapercentag());
				 salarystatement.setDouble(10, espojo.getHra());
				 salarystatement.setDouble(11, espojo.getMedicalallowances());
				 salarystatement.setDouble(12, espojo.getTelephonereim());
				 salarystatement.setDouble(13, espojo.getPerfincentive());
				 salarystatement.setDouble(14, espojo.getSpecialallowance());
				 salarystatement.setDouble(15, espojo.getFoodallowance());
				 salarystatement.setDouble(16, espojo.getWashingallowance());
				 salarystatement.setDouble(17, espojo.getOthers());
				 salarystatement.setDouble(18, espojo.getEmployerpf());
				 salarystatement.setDouble(19,espojo.getEmployerESI());
				 salarystatement.setDouble(20, espojo.getGrosssalary());
				 salarystatement.setDouble(21, espojo.getCtc());
				 salarystatement.setDouble(22, espojo.getDemployerpf());
				 salarystatement.setDouble(23, espojo.getEmployeepf());
				 salarystatement.setDouble(24, espojo.getIncometax());
				 salarystatement.setDouble(25, espojo.getPt());
				 salarystatement.setDouble(26, espojo.getDedmployerESI());
				 salarystatement.setDouble(27, espojo.getEmployeeESI());
				/* 
				 salarystatement.setString(29, espojo.getOt());*/
				 salarystatement.setDouble(28, espojo.getTdsctc());
				 salarystatement.setDouble(29, espojo.getStandarddedu());
				 salarystatement.setDouble(30, espojo.getTaxbleincomestatury());
				 salarystatement.setDouble(31, espojo.getTdspt());
				 salarystatement.setDouble(32, espojo.getTdspf());
				 salarystatement.setDouble(33, espojo.getTaxableincome());
				 salarystatement.setDouble(34, espojo.getTaxpayble());
				 salarystatement.setString(35, userId);
				 salarystatement.setTimestamp(36,currentdate );
				 salarystatement.setString(37, espojo.getLeavedeductions());
				 salarystatement.setString(38, espojo.getLatedeductions());
				 
					System.out.println("insert pstmt :: "+salarystatement);

				
				count=salarystatement.executeUpdate();
				
				}else{
					
					
					
					salarystatement = conn.prepareStatement(StaffEmployementUtil.UPDATE_SALARY);
					

					 salarystatement.setLong(1,espojo.getBankaccnumber());
					 salarystatement.setString(2, espojo.getEmployeepfno());
					 salarystatement.setString(3, espojo.getBankname());
					 salarystatement.setString(4, espojo.getIFSCCode());
					 salarystatement.setString(5, espojo.getPaymenttype());
					 salarystatement.setDouble(6, espojo.getBasic());
					 salarystatement.setDouble(7, espojo.getCa());
					 salarystatement.setInt(8, espojo.getHrapercentag());
					 salarystatement.setDouble(9, espojo.getHra());
					 salarystatement.setDouble(10, espojo.getMedicalallowances());
					 salarystatement.setDouble(11, espojo.getTelephonereim());
					 salarystatement.setDouble(12, espojo.getPerfincentive());
/*					 salarystatement.setDouble(13, espojo.getShiftallowance());
*/					 salarystatement.setDouble(13, espojo.getSpecialallowance());
					 salarystatement.setDouble(14, espojo.getFoodallowance());
					 salarystatement.setDouble(15, espojo.getWashingallowance());
					 salarystatement.setDouble(16, espojo.getOthers());
					 salarystatement.setDouble(17, espojo.getEmployerpf());
					 salarystatement.setDouble(18,espojo.getEmployerESI());
					 salarystatement.setDouble(19, espojo.getGrosssalary());
					 salarystatement.setDouble(20, espojo.getCtc());
					 salarystatement.setDouble(21, espojo.getDemployerpf());
					 salarystatement.setDouble(22, espojo.getEmployeepf());
					 salarystatement.setDouble(23, espojo.getIncometax());
					 salarystatement.setDouble(24, espojo.getPt());
					 salarystatement.setDouble(25, espojo.getDedmployerESI());
					 salarystatement.setDouble(26, espojo.getEmployeeESI());
					 /*
					 salarystatement.setString(30, espojo.getOt());*/
					 salarystatement.setDouble(27, espojo.getTdsctc());
					 salarystatement.setDouble(28, espojo.getStandarddedu());
					 salarystatement.setDouble(29, espojo.getTaxbleincomestatury());
					 salarystatement.setDouble(30, espojo.getTdspt());
					 salarystatement.setDouble(31, espojo.getTdspf());
					 salarystatement.setDouble(32, espojo.getTaxableincome());
					 salarystatement.setDouble(33, espojo.getTaxpayble());
					 salarystatement.setString(34, userId);
					 salarystatement.setTimestamp(35, currentdate);
					 salarystatement.setString(36, espojo.getLeavedeductions());
					 salarystatement.setString(37, espojo.getLatedeductions());
					 salarystatement.setString(38, espojo.getHemloyeeid());
					
					System.out.println("update pstmt :: "+salarystatement);

					/*pstmt.setString(1, staffForm.getAccno());
					pstmt.setString(2, staffForm.getEmppfno());
					pstmt.setString(3, staffForm.getPaymenttype());
					pstmt.setString(4, staffForm.getEsino());
					pstmt.setString(5, staffForm.getPanno());
					pstmt.setString(6, staffForm.getBasic());
					pstmt.setString(7, staffForm.getHra());
					pstmt.setString(8, staffForm.getConviance());
					pstmt.setString(9, staffForm.getGrosssal());
					pstmt.setString(10, staffForm.getCa());
					pstmt.setString(11, staffForm.getDa());
					pstmt.setString(12, staffForm.getEmprpf());
					pstmt.setString(13, staffForm.getEmppf());
					pstmt.setString(14, staffForm.getIncometax());
					pstmt.setString(15, staffForm.getPt());
					pstmt.setString(16, staffForm.getOtherdeductions());
					pstmt.setString(17, staffForm.getLeavedeductions());
					pstmt.setString(18, staffForm.getMedical());
					pstmt.setString(19, staffForm.getOthers());
					pstmt.setString(20, staffForm.getCtc());
					pstmt.setString(21, userId);
					pstmt.setTimestamp(22, HelperClass.getCurrentTimestamp());
					
					pstmt.setString(23, staffForm.getHempid());*/
					
					count=salarystatement.executeUpdate();
					
				}

				if(count>0){
					
					status="true";
				}else{
					
					status="false";
				}
			

			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} finally {
				try {
					if (salarystatement != null && (!salarystatement.isClosed())) {
						salarystatement.close();
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
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in StaffEmployementDaoImpl : saveStaffSalaryDetails  Starting");
	
	return status;

	}
	
	public boolean validateEmployeePfNumber(String emppfno,String empid){

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateEmployeePfNumber : Starting");
		PreparedStatement salarystatement2=null;
		ResultSet rs_salary2=null;
		boolean status=false;
		Connection conn = null;
		int pf_count=0;
		
				try {
					
					conn = JDBCConnection.getSeparateConnection();
					
					salarystatement2=conn.prepareStatement(StaffEmployementUtil.CHECK_DUPLICATE_PF_NO);
					salarystatement2.setString(1, emppfno);
					salarystatement2.setString(2, empid.trim());
					
					System.out.println("CHECK_DUPLICATE_PF_NO"+salarystatement2);
					rs_salary2=salarystatement2.executeQuery();
					
					while(rs_salary2.next()){
						
						pf_count++;						
					}
					
				
					 
					 if(pf_count>0){
						 status=true;
					 }else{
						 
						 status=false;
					 }
					
					 

				}catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle);
				} catch (Exception e1) {
					e1.printStackTrace();
					logger.error(e1);
				}finally{
						try{
							if (salarystatement2 != null && (!salarystatement2.isClosed())) {
								salarystatement2.close();
							}
							if (conn != null && (!conn.isClosed())) {
								conn.close();
							}
						} catch (SQLException sqle) {
							sqle.printStackTrace();
							logger.error(sqle);
						} catch (Exception e1) {
							e1.printStackTrace();
							logger.error(e1);
						}
					}
			
				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in EmployeeSalaryDetailsDaoImpl: validateEmployeePfNumber : Ending");
				
				return status;
			

	}


	public boolean validateBankAccNumber(String accnumber,String empid){

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsDaoImpl: validateBankAccNumber : Starting");

		
		PreparedStatement salarystatement=null;
		ResultSet rs_salary=null;
		boolean status=false;
		Connection conn = null;
		int count=0;

		
				try {
					
					conn = JDBCConnection.getSeparateConnection();
					 salarystatement = conn.prepareStatement(StaffEmployementUtil.CHECK_BANK_ACC_NUMBER);
					 
					 salarystatement.setString(1, accnumber);
					 salarystatement.setString(2, empid);
					 System.out.println("CHECK_BANK_ACC_NUMBER"+salarystatement);
					 rs_salary=salarystatement.executeQuery();
					 
					 while(rs_salary.next()){
						 
						 count=rs_salary.getInt(1);
						 
					 }
					 
					 if(count>0){
						 status=true;
					 }else{
						 
						 status=false;
					 }
					 

				} catch (SQLException sqle) {
					sqle.printStackTrace();
					logger.error(sqle);
				} catch (Exception e1) {
					e1.printStackTrace();
					logger.error(e1);
				}finally{
					try{
						if (salarystatement != null && (!salarystatement.isClosed())) {
							salarystatement.close();
						}
						if (conn != null && (!conn.isClosed())) {
							conn.close();
						}
					} catch (SQLException sqle) {
						sqle.printStackTrace();
						logger.error(sqle);
					} catch (Exception e1) {
						e1.printStackTrace();
						logger.error(e1);
					}
				}
			
				logger.setLevel(Level.DEBUG);
				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in EmployeeSalaryDetailsDaoImpl: validateBankAccNumber : Ending");
				
				return status;
			

	}
}
