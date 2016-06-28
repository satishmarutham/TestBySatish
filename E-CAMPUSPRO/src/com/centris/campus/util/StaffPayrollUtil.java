package com.centris.campus.util;

public class StaffPayrollUtil {
	
	public static final String GET_PAYROLL_LIST = "select distinct CreatedBy,CreatedDate,UpdatedBy,UpdatedDate from campus_month_payroll where Month=? and Year=?";
	
	public static final String GET_CREATEDBY = "select concat(FirstName,'',LastName) createdby from campus_admin where AdminID=?";

	
	public static final String GET_EMPLOYEE_LIST = "select emp.TeacherID ,emp.FirstName ,emp.LastName from campus_teachers  emp ,campus_teacher_salarydetails empsal where emp.TeacherID =empsal.teacher_id and emp.isActive='Y' order by TeacherID";
	public static final String GET_EMPLOYEE_PRESENT_LIST = "select sum(case when AttendenceStatus='Present' then 1 else 0 end) totalPresent,GROUP_CONCAT(case when AttendenceStatus='Present' then AttendenceDate end) prsentdate from campus_teacher_attendence where TeacherID=? and AttendenceDate between ? and ? group by TeacherID";
	public static final String GET_EMPLOYEE_LEAVE_COUNT = "select sum(NoofLeaves) as count from campus_teachers_leave_request where StartDate between ? and ? and EndDate between ? and ? and RequestedBy=?";
	public static final String GET_EMPLOYEE_ABSENT_LIST = "select sum(case when AttendenceStatus='Absent' then 1 else 0 end) totalAbsent from campus_teacher_attendence where TeacherID=? and AttendenceDate between ? and ? group by TeacherID";
	public static final String GET_EMPLOYEE_SALARY_DETAILS = "select teacher_type,account_no,nonboard_salary,nonboard_pf,advance from campus_teacher_salarydetails where teacher_id=?";
	public static final String GET_EMPLOYEE_LEAVE_BANK_COUNT = "select board_leavebal from campus_teacher_salarydetails where teacher_id=?";
	public static final String INSERT_NON_BOARD_PAYROLL_DETAILS = "insert into campus_payroll_details(userId,month,year,noof_leaves,main_adv,fest_Adv,LOP,salary_amount) values(?,?,?,?,?,?,?,?)";
	public static final String CHECK_NON_BOARD_PAYROLL = "select count(*) from campus_payroll_details where userId=? and month=? and year=?";
	public static final String UPDATE_NON_BOARD_PAYROLL_DETAILS = "update campus_payroll_details set noof_leaves=?,main_adv=?,fest_Adv=?,LOP=?,salary_amount=? where userId=? and month=? and year=?";
	public static final String GET_EMPLOYEE_BOARD_SALARY_DETAILS = "select board_basic,board_da,board_gradepay,board_grossal,board_pf,board_also from campus_teacher_salarydetails where teacher_id=? ";
	public static final String GET_EMPLOYEE_PAYROLL_DETAILS = "select main_adv,fest_Adv,LOP from campus_payroll_details where userId=? and month=? and year=?";
	public static final String CHECK_BOARD_PAYROLL = "select count(*) from campus_payroll_details_board where userId=? and month=? and year=?";
	public static final String UPDATE_BOARD_PAYROLL_DETAILS = "update campus_payroll_details_board set BasicPay=?,Da=?,GradePay=?,GrossSal=?,Pf=?,OtherDeduc=?,NetSal=? where userId=? and month=? and year=?";
	public static final String INSERT_BOARD_PAYROLL_DETAILS = "insert into campus_payroll_details_board(userId,month,year,BasicPay,Da,GradePay,GrossSal,Pf,OtherDeduc,NetSal) values(?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_ADVANCE_PAYROLL_DETAILS = "insert into campus_payroll_advancedetails(userId,month,year,paidamount) values(?,?,?,?)";
	public static final String GET_EMPLOYEE_PAID_AMOUNT = "select sum(paidamount) as amount from campus_payroll_advancedetails where userId=?";
	public static final String CHECK_PAYROLL_DETAILS = "select count(*) from campus_payroll_details where userId=? and month=? and year=?";
	public static final String GET_NON_BOARD_EMPLOYEE_PAYROLL_DETAILS = "select userId,noof_leaves,main_adv,fest_Adv,LOP,salary_amount from campus_payroll_details where userId=? and month=? and year=?";
	public static final String GET_NON_BOARD_PAYROLL = "select userId,noof_leaves,main_adv,fest_Adv,LOP,salary_amount from campus_payroll_details where year=? and month=?";
	public static final String GET_NAME_FROM_ID = "select FirstName from campus_teachers where TeacherID=?";
	public static final String GET_SALARY_FROM_ID = "select nonboard_salary,nonboard_pf from campus_teacher_salarydetails where teacher_id=?";
	public static final String GET_BOARD_PAYROLL = "select userId,BasicPay,Da,GradePay,GrossSal,Pf,OtherDeduc,NetSal from campus_payroll_details_board where month=? and year=?";
	public static final String GET_EMPLOYEE_LEAVE_DAYS = "select sum(case when AttendenceStatus='Leave' then 1 else 0 end) totalLeave,GROUP_CONCAT(case when AttendenceStatus='Leave' then AttendenceDate end) leavedate from campus_teacher_attendence where TeacherID=? and AttendenceDate between ? and ? group by TeacherID";
	public static final String GET_EMPLOYEE_LEAVE_REQUEST = "select RequestedBy,sum(case when LeaveStatus ='APPROVED' then 1 else 0 end) totalRequest,GROUP_CONCAT(case when LeaveStatus='APPROVED' then StartDate end) leaveStartDate,GROUP_CONCAT(case when LeaveStatus='APPROVED' then EndDate end) leaveeNDDate  from campus_teachers_leave_request where RequestedBy=? and StartDate between ? and ? group by RequestedBy ";
	public static final String GET_EMPLOYEE_LEAVE_REQUEST_COUNT = "select sum(NoofLeaves) as noofleave from campus_teachers_leave_request where RequestedBy=? and StartDate like ? and EndDate like ?";

	
	
	
	public static final String GET_STAFF_ATTENDANCE = "select sum(case when AttendenceStatus='Present' then 1 else 0 end) totalPresent,GROUP_CONCAT(case when AttendenceStatus='Present' then AttendenceDate end) prsentdate,sum(case when AttendenceStatus='Absent' then 1 else 0 end) totalabsent,GROUP_CONCAT(case when AttendenceStatus='Absent' then AttendenceDate end) absentdate,sum(case when AttendenceStatus='Leave' then 1 else 0 end) totalleave,GROUP_CONCAT(case when AttendenceStatus='Leave' then AttendenceDate end) leavedate,sum(case when AttendenceStatus='Holiday' then 1 else 0 end) totalholiday,GROUP_CONCAT(case when AttendenceStatus='Holiday' then AttendenceDate end) holidaydate  from campus_teacher_attendence where TeacherID=? and AttendenceDate between ? and ? group by TeacherID";
	public static final String GET_ACTIVE_EMP = "select emp.TeacherID ,emp.FirstName ,emp.LastName,emp.registerId from campus_teachers  emp where isActive='Y' order by length(TeacherID),TeacherID";
	public static final String SAVE_PAYROLL_DETAILS = "insert into campus_month_payroll(Emp_Id,No_of_Actualdays,PayableDays,Basic,DA,HRA,CA,Conviance,Medical_Allowances,Others,Gross,Employee_Pf,Employer_Pf,P_Tax,IncomeTax,Salary_Advance,Leave_Deductions,Other_Deductions,Total_Deductions,Net_Salary,CTC,Month,Year,CreatedBy,CreatedDate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String CHECK_PAYROLL_EXIST = "select count(*) from campus_month_payroll where Month=? and Year=? and Emp_Id=?";

	public static final String UPDATE_PAYROLL_DETAILS = "update  campus_month_payroll set No_of_Actualdays=?,PayableDays=?,Basic=?,DA=?,HRA=?,CA=?,Conviance=?,Medical_Allowances=?,Others=?,Gross=?,Employee_Pf=?,Employer_Pf=?,P_Tax=?,IncomeTax=?,Salary_Advance=?,Leave_Deductions=?,Other_Deductions=?,Total_Deductions=?,Net_Salary=?,CTC=?,UpdatedBy=?,UpdatedDate=? where Month=? and Year=? and Emp_Id=?";

	public static final String GET_PAYROLL_DETAILS ="select mp.Emp_Id,t.registerId,concat(t.FirstName,' ',t.LastName) teachername,ss.BankAccNumber,mp.No_of_Actualdays,mp.PayableDays,mp.Basic,mp.DA,mp.HRA,mp.CA,mp.Conviance,mp.Medical_Allowances,mp.Others,mp.Gross,mp.Employee_Pf,mp.Employer_Pf,mp.P_Tax,mp.IncomeTax,mp.Salary_Advance,mp.Leave_Deductions,mp.Other_Deductions,mp.Total_Deductions,mp.Net_Salary,mp.CTC from campus_month_payroll mp,campus_teachers t left outer join campus_staff_salarydetails  ss on ss.TeacherID=t.TeacherID where t.TeacherID=mp.Emp_Id and Month=? and Year=? order by length(Emp_Id),Emp_Id";
	
	public static final String GET_PAYSLIP_DETAILS = "select ss.EmployeePfNo,ss.ESI_No,ss.PanNo,mp.Emp_Id,t.registerId,concat(t.FirstName,' ',t.LastName) teachername,ss.BankAccNumber,mp.No_of_Actualdays,mp.PayableDays,mp.Basic,mp.DA,mp.HRA,mp.CA,mp.Conviance,mp.Medical_Allowances,mp.Others,mp.Gross,mp.Employee_Pf,mp.Employer_Pf,mp.P_Tax,mp.IncomeTax,mp.Salary_Advance,mp.Leave_Deductions,mp.Other_Deductions,mp.Total_Deductions,mp.Net_Salary,mp.CTC from campus_month_payroll mp,campus_teachers t left outer join campus_staff_salarydetails  ss on ss.TeacherID=t.TeacherID where t.TeacherID=mp.Emp_Id and Month=? and Year=? and mp.Emp_Id=?";
	
	

}
