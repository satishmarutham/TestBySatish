package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.dao.StaffPayrollDao;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.util.StaffEmployementUtil;
import com.centris.campus.util.StaffPayrollUtil;
import com.centris.campus.vo.PayRollVo;
import com.centris.campus.vo.StaffDetailsForPayrollVo;
import com.centris.campus.vo.StaffEmployementVo;
import com.centris.campus.vo.StaffPayrollListVo;


public class StaffPayrollDaoImpl implements StaffPayrollDao{ 
	
	private static final Logger logger = Logger.getLogger(StaffPayrollDaoImpl.class);

	public ArrayList<StaffPayrollListVo> getPayrollList(String year,String month) {
	   
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffPayrollDaoImpl: getPayrollList : Starting");
		
		PreparedStatement ps_payroll_list = null;
		ResultSet rs_payroll=null;
		Connection conn = null;
	    
	    ArrayList<StaffPayrollListVo> payrollList=new ArrayList<StaffPayrollListVo>();
	 	
		try {
			
			conn = JDBCConnection.getSeparateConnection();
			
			int currentYear=HelperClass.getCurrentYear();
			int mounthcount=12;
		
			ps_payroll_list = conn.prepareStatement(StaffPayrollUtil.GET_PAYROLL_LIST);
			
			if(year==null || "".equalsIgnoreCase(year)){
			
			
			for(int i=1;i<=mounthcount;i++){
				
			boolean flag=false;
			
			ps_payroll_list.setInt(1, i);
			ps_payroll_list.setInt(2, currentYear);
			
			System.out.println(HelperClass.getMonthFullName(i+"") +" ::: "+ps_payroll_list);
			
			rs_payroll=ps_payroll_list.executeQuery();
			
			StaffPayrollListVo payrollVo=new StaffPayrollListVo();
			payrollVo.setMonth(HelperClass.getMonthFullName(i+""));
			payrollVo.setYear(currentYear+"");
			payrollVo.setMonth_int(i);
			
			while(rs_payroll.next()){
				
				flag=true;
				
				payrollVo.setStatus("Generated");
				payrollVo.setCreatedby(getCreatedBY(rs_payroll.getString("CreatedBy")));
				payrollVo.setCreateTime(rs_payroll.getString("CreatedDate"));
				if(rs_payroll.getString("UpdatedBy")!=null && "".equalsIgnoreCase(rs_payroll.getString("UpdatedBy")) ){
					
					payrollVo.setUpdatedby(getCreatedBY(rs_payroll.getString("UpdatedBy")));
					payrollVo.setUpdatetime(rs_payroll.getString("UpdatedDate"));
				}else{
					
					payrollVo.setUpdatedby("-");
					payrollVo.setUpdatetime("-");
				}
				
				
			}
			
			if(!flag){
				
				payrollVo.setStatus("Not Generated");
				payrollVo.setCreatedby("-");
				payrollVo.setCreateTime("-");
				payrollVo.setUpdatedby("-");
				payrollVo.setUpdatetime("-");
			}
			
			payrollList.add(payrollVo);
			
			}
			
			}else{
				
			
				boolean flag=false;
				
				ps_payroll_list.setInt(1, Integer.parseInt(month));
				ps_payroll_list.setInt(2, Integer.parseInt(year));
				
				System.out.println(HelperClass.getMonthFullName(month) +" ::: "+ps_payroll_list);
				
				rs_payroll=ps_payroll_list.executeQuery();
				
				StaffPayrollListVo payrollVo=new StaffPayrollListVo();
				payrollVo.setMonth(HelperClass.getMonthFullName(month));
				payrollVo.setYear(year);
				
				while(rs_payroll.next()){
					
					flag=true;
					
					payrollVo.setStatus("Generated");
					payrollVo.setCreatedby(getCreatedBY(rs_payroll.getString("CreatedBy")));
					payrollVo.setCreateTime(rs_payroll.getString("CreatedDate"));
					if(rs_payroll.getString("UpdatedBy")!=null && "".equalsIgnoreCase(rs_payroll.getString("UpdatedBy")) ){
						
						payrollVo.setUpdatedby(getCreatedBY(rs_payroll.getString("UpdatedBy")));
						payrollVo.setUpdatetime(rs_payroll.getString("UpdatedDate"));
					}else{
						
						payrollVo.setUpdatedby("-");
						payrollVo.setUpdatetime("-");
					}
					
					
				}
				
				if(!flag){
					
					payrollVo.setStatus("Not Generated");
					payrollVo.setCreatedby("-");
					payrollVo.setCreateTime("-");
					payrollVo.setUpdatedby("-");
					payrollVo.setUpdatetime("-");
				}
				
				payrollList.add(payrollVo);
				
			}
			
			
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {
				
				if (ps_payroll_list != null&& (!ps_payroll_list.isClosed())) {
					ps_payroll_list.close();
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

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StaffPayrollDaoImpl: getPayrollList: Ending");
		
		return payrollList;
	}
	
	
	
	public String getCreatedBY(String userID){
		   
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in StaffPayrollDaoImpl: getPayrollList : Starting");
			
			PreparedStatement ps_payroll_list = null;
			ResultSet rs_payroll=null;
			Connection conn = null;
			
			String userId="-";
		    
		 	
			try {
				
				conn = JDBCConnection.getSeparateConnection();
				
				
				ps_payroll_list = conn.prepareStatement(StaffPayrollUtil.GET_CREATEDBY);
				
					ps_payroll_list.setString(1, userID);
					
					rs_payroll=ps_payroll_list.executeQuery();
					
					
					while(rs_payroll.next()){
						
						userId=rs_payroll.getString("createdby");
						
					}
					
				
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			} finally {
				try {
					
					if (ps_payroll_list != null&& (!ps_payroll_list.isClosed())) {
						ps_payroll_list.close();
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

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in StaffPayrollDaoImpl: getPayrollList: Ending");
			
			return userId;
		}
	
	
	public synchronized Map<String, StaffDetailsForPayrollVo> getEmployeeDetails(int month, int year,Connection connection) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: getEmployeeDetails :Starting");
		logger.setLevel(Level.DEBUG);
		
		Map<String, StaffDetailsForPayrollVo> salaryDetailsmap = new HashMap<String, StaffDetailsForPayrollVo>();
		StaffDetailsForPayrollVo employeeDetailsVo = null;
		Connection conn=null;
		
		try {
			
			conn=connection;

			List<StaffDetailsForPayrollVo> empList = getEmployeeList();
			
			for (int i = 0; i < empList.size(); i++) {
				
				employeeDetailsVo = new StaffDetailsForPayrollVo();

				String empId = empList.get(i).getEmpId();
				
				employeeDetailsVo.setEmpId(empId);
				employeeDetailsVo.setEmpName(empList.get(i).getEmpName());
				employeeDetailsVo.setRegId(empList.get(i).getRegId());

				employeeDetailsVo.setTotalDaysInMonth(HelperClass.getDaysByMonthAndYear(month, year) + "");

				Map<String, String> attandanceMap=getEmployeeTotalAttendance(empId, month, year);
				
				employeeDetailsVo.setTotalPresent(attandanceMap.get("totalPresent"));
				employeeDetailsVo.setTotalPresentDate(new ArrayList<String>(Arrays.asList(attandanceMap.get("totalpresentdates").split(","))));
				
				employeeDetailsVo.setTotalAbsent(attandanceMap.get("totalabsent"));
				employeeDetailsVo.setTotalAbsentDate(new ArrayList<String>(Arrays.asList(attandanceMap.get("totalabsentdates").split(","))));
				
				employeeDetailsVo.setTotalLeave(attandanceMap.get("totalleave"));
				employeeDetailsVo.setLeavedates(new ArrayList<String>(Arrays.asList(attandanceMap.get("totalleavedates").split(","))));
				
				employeeDetailsVo.setTotalHoliday(attandanceMap.get("totalholiday"));
				employeeDetailsVo.setHolidayDates(new ArrayList<String>(Arrays.asList(attandanceMap.get("totalholidaydates").split(","))));
				
				employeeDetailsVo.setStaffSalaryDetails(new StaffEmployementDaoImpl().getStaffEmployementEntry(empId));
				
				salaryDetailsmap.put(empId, employeeDetailsVo);
				
				
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: getEmployeeDetails: Ending");
		return salaryDetailsmap;
	}

	public synchronized List<StaffDetailsForPayrollVo> getEmployeeList() {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: getEmployeeList :Starting");
		logger.setLevel(Level.DEBUG);
		List<StaffDetailsForPayrollVo> EmployeeList = new ArrayList<StaffDetailsForPayrollVo>();
		PreparedStatement ps_employee = null;
		ResultSet rs_employee = null;
		StaffDetailsForPayrollVo employeeVO = null;

		try {
			ps_employee = (PreparedStatement) JDBCConnection
					.getStatement(StaffPayrollUtil.GET_ACTIVE_EMP);

			rs_employee = ps_employee.executeQuery();
			while (rs_employee.next()) {
				employeeVO = new StaffDetailsForPayrollVo();
				employeeVO.setEmpId(rs_employee.getString("TeacherID"));
				employeeVO.setEmpName(rs_employee.getString("FirstName"));
				employeeVO.setRegId(rs_employee.getString("registerId"));

				EmployeeList.add(employeeVO);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: getEmployeeList: Ending");
		return EmployeeList;

	}

	
	public synchronized Map<String, String> getEmployeeTotalAttendance(String empId, int month, int year) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: getEmployeeTotalAttendance :Starting");
		logger.setLevel(Level.DEBUG);
		Map<String, String> empAttMap = new HashMap<String, String>();
		PreparedStatement ps_totalPresentAbsent = null;
		ResultSet rs_totalPresentAbsent = null;

		try {
			
			ps_totalPresentAbsent = (PreparedStatement) JDBCConnection.getStatement(StaffPayrollUtil.GET_STAFF_ATTENDANCE);
			ps_totalPresentAbsent.setString(1, empId);
			ps_totalPresentAbsent.setString(2, year + "-" + month + "-01");
			ps_totalPresentAbsent.setString(3, year + "-" + month + "-"+ HelperClass.getDaysByMonthAndYear(month, year));
			
			rs_totalPresentAbsent = ps_totalPresentAbsent.executeQuery();
			
			boolean flag = false;
			
			while (rs_totalPresentAbsent.next()) {
				flag = true;
				
				//for present
				
				String totalpresent = rs_totalPresentAbsent.getString("totalPresent");
				
				if (totalpresent == null) {
					
					totalpresent = "0";
				}
				
				empAttMap.put("totalPresent", totalpresent);

				String totalpresentdates = rs_totalPresentAbsent.getString("prsentdate");

				if (totalpresentdates == null) {

					totalpresentdates = "";
				}
				
				empAttMap.put("totalpresentdates",totalpresentdates);
				
				//for absent
				
				String totalabsent = rs_totalPresentAbsent.getString("totalabsent");
				
				if (totalabsent == null) {
					
					totalabsent = "0";
				}
				
				empAttMap.put("totalabsent", totalabsent);

				String totalabsentdates = rs_totalPresentAbsent.getString("absentdate");

				if (totalabsentdates == null) {

					totalabsentdates = "";
				}
				
				empAttMap.put("totalabsentdates",totalabsentdates);
				
				//for leave
				
				String totalleave = rs_totalPresentAbsent.getString("totalleave");
				
				if (totalleave == null) {
					
					totalleave = "0";
				}
				
				empAttMap.put("totalleave", totalleave);

				String totalleavedates = rs_totalPresentAbsent.getString("leavedate");

				if (totalleavedates == null) {

					totalleavedates = "";
				}
				
				empAttMap.put("totalleavedates",totalleavedates);
				
				//for Holiday
				
				String totalholiday = rs_totalPresentAbsent.getString("totalholiday");
				
				if (totalholiday == null) {
					
					totalholiday = "0";
				}
				
				empAttMap.put("totalholiday", totalholiday);

				String totalholidaydates = rs_totalPresentAbsent.getString("holidaydate");

				if (totalholidaydates == null) {

					totalholidaydates = "";
				}
				
				empAttMap.put("totalholidaydates",totalholidaydates);
			}
			
			if (!flag) {
				
				empAttMap.put("totalPresent", "0");
				empAttMap.put("totalpresentdates", "");
				
				empAttMap.put("totalabsent", "0");
				empAttMap.put("totalabsentdates", "");
				
				empAttMap.put("totalleave", "0");
				empAttMap.put("totalleavedates", "");
				
				empAttMap.put("totalholiday", "0");
				empAttMap.put("totalholidaydates","");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: getEmployeeTotalAttendance: Ending");
		return empAttMap;
	}
	
	
	
	public synchronized String savePayrollDetails(ArrayList<PayRollVo> payrollList) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: savePayrollDetails :Starting");
		logger.setLevel(Level.DEBUG);
		
		PreparedStatement ps_payroll = null;
		
		PreparedStatement ps_payroll_count = null;
		ResultSet rs_payroll_count = null;
		
		
		String status=null;
		int count=0;
		

		try {
			
			ps_payroll_count = (PreparedStatement) JDBCConnection.getStatement(StaffPayrollUtil.CHECK_PAYROLL_EXIST);
			
			
			for(int i=0;i<payrollList.size();i++){
				
				int ps_count=0;
				
				ps_payroll_count.setInt(1, payrollList.get(i).getMonth());
				ps_payroll_count.setInt(2, payrollList.get(i).getYear());
				ps_payroll_count.setString(3, payrollList.get(i).getEmpId());
				
				rs_payroll_count=ps_payroll_count.executeQuery();
				
				while(rs_payroll_count.next()){
					
					ps_count=rs_payroll_count.getInt(1);
				}
				
				if(ps_count==0){
				
					ps_payroll = (PreparedStatement) JDBCConnection.getStatement(StaffPayrollUtil.SAVE_PAYROLL_DETAILS);
						ps_payroll.setString(1, payrollList.get(i).getEmpId());
						ps_payroll.setInt(2, payrollList.get(i).getMonthDays());
						ps_payroll.setInt(3, payrollList.get(i).getPayabledays());
						ps_payroll.setDouble(4, payrollList.get(i).getBasic());  
						ps_payroll.setDouble(5, payrollList.get(i).getDa());
						ps_payroll.setDouble(6, payrollList.get(i).getHra());
						ps_payroll.setDouble(7, payrollList.get(i).getCa());
						ps_payroll.setDouble(8, payrollList.get(i).getConvieance());
						ps_payroll.setDouble(9, payrollList.get(i).getMedicalallowances());
						ps_payroll.setDouble(10, payrollList.get(i).getOthers());
						ps_payroll.setDouble(11, payrollList.get(i).getGrosssalary());
						ps_payroll.setDouble(12, payrollList.get(i).getEmployee_pf());
						ps_payroll.setDouble(13, payrollList.get(i).getEmployer_pf());
						ps_payroll.setDouble(14, payrollList.get(i).getPt());
						ps_payroll.setDouble(15, payrollList.get(i).getIncomeTax());
						ps_payroll.setString(16, payrollList.get(i).getAdvanceTaken());
						ps_payroll.setDouble(17, payrollList.get(i).getLeavededuction());
						ps_payroll.setDouble(18, payrollList.get(i).getOtherdeduction());
						ps_payroll.setDouble(19, payrollList.get(i).getTotaldeductions());
						ps_payroll.setDouble(20, payrollList.get(i).getNetsalary());
						ps_payroll.setDouble(21, payrollList.get(i).getCtc());
						ps_payroll.setDouble(22, payrollList.get(i).getMonth());
						ps_payroll.setInt(23, payrollList.get(i).getYear());
						ps_payroll.setString(24, payrollList.get(i).getUserId());
						ps_payroll.setTimestamp(25, HelperClass.getCurrentTimestamp());
						
						System.out.println("insert payroll ::: "+ps_payroll);
						
						count=ps_payroll.executeUpdate();
				
				}else{
					
					ps_payroll = (PreparedStatement) JDBCConnection.getStatement(StaffPayrollUtil.UPDATE_PAYROLL_DETAILS);
					
					ps_payroll.setInt(1, payrollList.get(i).getMonthDays());
					ps_payroll.setInt(2, payrollList.get(i).getPayabledays());
					ps_payroll.setDouble(3, payrollList.get(i).getBasic());  
					ps_payroll.setDouble(4, payrollList.get(i).getDa());
					ps_payroll.setDouble(5, payrollList.get(i).getHra());
					ps_payroll.setDouble(6, payrollList.get(i).getCa());
					ps_payroll.setDouble(7, payrollList.get(i).getConvieance());
					ps_payroll.setDouble(8, payrollList.get(i).getMedicalallowances());
					ps_payroll.setDouble(9, payrollList.get(i).getOthers());
					ps_payroll.setDouble(10, payrollList.get(i).getGrosssalary());
					ps_payroll.setDouble(11, payrollList.get(i).getEmployee_pf());
					ps_payroll.setDouble(12, payrollList.get(i).getEmployer_pf());
					ps_payroll.setDouble(13, payrollList.get(i).getPt());
					ps_payroll.setDouble(14, payrollList.get(i).getIncomeTax());
					ps_payroll.setString(15, payrollList.get(i).getAdvanceTaken());
					ps_payroll.setDouble(16, payrollList.get(i).getLeavededuction());
					ps_payroll.setDouble(17, payrollList.get(i).getOtherdeduction());
					ps_payroll.setDouble(18, payrollList.get(i).getTotaldeductions());
					ps_payroll.setDouble(19, payrollList.get(i).getNetsalary());
					ps_payroll.setDouble(20, payrollList.get(i).getCtc());
					ps_payroll.setString(21, payrollList.get(i).getUserId());
					ps_payroll.setTimestamp(22, HelperClass.getCurrentTimestamp());
					
					ps_payroll.setDouble(23, payrollList.get(i).getMonth());
					ps_payroll.setInt(24, payrollList.get(i).getYear());
					ps_payroll.setString(25, payrollList.get(i).getEmpId());
					
					System.out.println("update payroll ::: "+ps_payroll);
					
					count=ps_payroll.executeUpdate();
					
					
				}
			}
			
			if(count>0){
				
				status="true";
			}else{
				
				status="false";
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: getEmployeeTotalAttendance: Ending");
		
		return status;
	}
	
	
	public synchronized ArrayList<PayRollVo> getPayrollDetails(int month,int year) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: savePayrollDetails :Starting");
		logger.setLevel(Level.DEBUG);
		
		PreparedStatement ps_payroll = null;
		
		ResultSet rs_payroll = null;
		ArrayList<PayRollVo> payrollList =new ArrayList<PayRollVo>();
		int count=0;
		
		try {
			
					ps_payroll = (PreparedStatement) JDBCConnection.getStatement(StaffPayrollUtil.GET_PAYROLL_DETAILS);
					
					ps_payroll.setInt(1, month);
					ps_payroll.setInt(2, year);
					
					System.out.println("Get Payroll ::: "+ps_payroll);
					
					rs_payroll=ps_payroll.executeQuery();
					
					while(rs_payroll.next()){
						
						PayRollVo vo=new PayRollVo();
						count++;
						vo.setEmpId(rs_payroll.getString("Emp_Id"));
						vo.setRegId(rs_payroll.getString("registerId"));
						vo.setEmpName(rs_payroll.getString("teachername"));
						if(rs_payroll.getString("BankAccNumber")==null || "".equalsIgnoreCase(rs_payroll.getString("BankAccNumber"))){
						vo.setAccountnumber("-");
						}else{
							vo.setAccountnumber(rs_payroll.getString("BankAccNumber"));
						}
						vo.setMonthDays(rs_payroll.getInt("No_of_Actualdays"));
						vo.setPayabledays(rs_payroll.getInt("PayableDays"));
						vo.setBasic(rs_payroll.getDouble("Basic"));
						vo.setDa(rs_payroll.getDouble("DA"));
						vo.setHra(rs_payroll.getDouble("HRA"));
						vo.setCa(rs_payroll.getDouble("CA"));
						vo.setMedicalallowances(rs_payroll.getDouble("Medical_Allowances"));
						vo.setConvieance(rs_payroll.getDouble("Conviance"));
						vo.setOthers(rs_payroll.getDouble("Others"));
						vo.setGrosssalary(rs_payroll.getDouble("Gross"));
						vo.setEmployee_pf(rs_payroll.getDouble("Employee_Pf"));
						vo.setEmployer_pf(rs_payroll.getDouble("Employer_Pf"));
						vo.setPt(rs_payroll.getDouble("P_Tax"));
						vo.setIncomeTax(rs_payroll.getDouble("IncomeTax"));
						vo.setLeavededuction(rs_payroll.getDouble("Leave_Deductions"));
						vo.setOtherdeduction(rs_payroll.getDouble("Other_Deductions"));
						if(rs_payroll.getString("Salary_Advance")==null || "".equalsIgnoreCase(rs_payroll.getString("Salary_Advance"))){
						
							vo.setAdvanceTaken("-");
						 
						}else{
							
							vo.setAdvanceTaken(rs_payroll.getString("Salary_Advance"));
						}
						vo.setTotaldeductions(rs_payroll.getDouble("Total_Deductions"));
						vo.setNetsalary(rs_payroll.getDouble("Net_Salary"));
						vo.setSno(count);
						
						payrollList.add(vo);
					}
					
					
				
				
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: getEmployeeTotalAttendance: Ending");
		
		JSONArray array=new JSONArray();
		array.put(payrollList);
		
		System.out.println("array :: "+array);
		
		return payrollList;
	}



	@Override
	public ArrayList<PayRollVo> getEmpMonthPayrollDetails(String month,String  year, String empId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: savePayrollDetails :Starting");
		logger.setLevel(Level.DEBUG);
		
		PreparedStatement ps_payroll = null;
		
		ResultSet rs_payroll = null;
		ArrayList<PayRollVo> payrollList =new ArrayList<PayRollVo>();
		int count=0;
		
		try {
			
					ps_payroll = (PreparedStatement) JDBCConnection.getStatement(StaffPayrollUtil.GET_PAYSLIP_DETAILS);
					
					ps_payroll.setInt(1, Integer.parseInt(month));
					ps_payroll.setInt(2, Integer.parseInt(year));
					ps_payroll.setString(3, empId);
					
					System.out.println("Get Payroll ::: "+ps_payroll);
					
					rs_payroll=ps_payroll.executeQuery();
					
					while(rs_payroll.next()){
						
						PayRollVo vo=new PayRollVo();
						count++;
						
						if(rs_payroll.getString("BankAccNumber")==null || "".equalsIgnoreCase(rs_payroll.getString("BankAccNumber"))){
								
							vo.setPfnumber("-");
							
						}else{
								vo.setPfnumber(rs_payroll.getString("BankAccNumber"));
						}
						
						if(rs_payroll.getString("EmployeePfNo")==null || "".equalsIgnoreCase(rs_payroll.getString("EmployeePfNo"))){
							
							vo.setEsinumber("-");
							
						}else{
								vo.setEsinumber(rs_payroll.getString("EmployeePfNo"));
						}
						
						if(rs_payroll.getString("ESI_No")==null || "".equalsIgnoreCase(rs_payroll.getString("ESI_No"))){
							
							vo.setPannumber("-");
							
						}else{
								vo.setPannumber(rs_payroll.getString("ESI_No"));
						}
						
					
						vo.setEmpId(rs_payroll.getString("Emp_Id"));
						vo.setRegId(rs_payroll.getString("registerId"));
						vo.setEmpName(rs_payroll.getString("teachername"));
						if(rs_payroll.getString("BankAccNumber")==null || "".equalsIgnoreCase(rs_payroll.getString("BankAccNumber"))){
						vo.setAccountnumber("-");
						}else{
							vo.setAccountnumber(rs_payroll.getString("BankAccNumber"));
						}
						vo.setMonthDays(rs_payroll.getInt("No_of_Actualdays"));
						vo.setPayabledays(rs_payroll.getInt("PayableDays"));
						vo.setBasic(rs_payroll.getDouble("Basic"));
						vo.setDa(rs_payroll.getDouble("DA"));
						vo.setHra(rs_payroll.getDouble("HRA"));
						vo.setCa(rs_payroll.getDouble("CA"));
						vo.setMedicalallowances(rs_payroll.getDouble("Medical_Allowances"));
						vo.setConvieance(rs_payroll.getDouble("Conviance"));
						vo.setOthers(rs_payroll.getDouble("Others"));
						vo.setGrosssalary(rs_payroll.getDouble("Gross"));
						vo.setEmployee_pf(rs_payroll.getDouble("Employee_Pf"));
						vo.setEmployer_pf(rs_payroll.getDouble("Employer_Pf"));
						vo.setPt(rs_payroll.getDouble("P_Tax"));
						vo.setIncomeTax(rs_payroll.getDouble("IncomeTax"));
						vo.setLeavededuction(rs_payroll.getDouble("Leave_Deductions"));
						vo.setOtherdeduction(rs_payroll.getDouble("Other_Deductions"));
						if(rs_payroll.getString("Salary_Advance")==null || "".equalsIgnoreCase(rs_payroll.getString("Salary_Advance"))){
						
							vo.setAdvanceTaken("-");
						 
						}else{
							
							vo.setAdvanceTaken(rs_payroll.getString("Salary_Advance"));
						}
						vo.setTotaldeductions(rs_payroll.getDouble("Total_Deductions"));
						vo.setNetsalary(rs_payroll.getDouble("Net_Salary"));
						vo.setSno(count);
						
						payrollList.add(vo);
					}
					
					
				
				
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in SalaryDetailsDaoImpl: getEmployeeTotalAttendance: Ending");
		
		JSONArray array=new JSONArray();
		array.put(payrollList);
		
		System.out.println("array :: "+array);
		
		return payrollList;
	}


	
	
	
	
	
	
}



