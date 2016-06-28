package com.centris.campus.util;

public class StaffEmployementUtil {
	
	public static final String GET_STAFTSEARCH_LIST = "select TeacherID,concat(FirstName,' ',LastName) as staffName from campus_teachers where FirstName like ?";
	
	public static final String GET_SALARY_DETAILS = "select concat(t.FirstName,' ',t.LastName) staffName,t.TeacherID,t.registerId,d.DEPT_NAME,ss.BankAccNumber,ss.EmployeePfNo,ss.BankName,ss.IFSCCode,ss.paymentType,ss.Basic,ss.Ca,ss.HRAPercentage,ss.Hra,ss.MedicalAllowances,ss.TelephoneAllowance,ss.PerformanceIncentive,ss.FoodAllowance,ss.SpecialAllowance,ss.OtherAllowance,ss.WashingAllowance,ss.EmployerESI,ss.EmployerPf,ss.CTC,ss.GrossSalary,ss.DeduEmployerPF,ss.DeduEmployerESI,ss.IncomeTax,ss.Pt,ss.LeaveDeductions,ss.LateDeductions,ss.TDSCtc,ss.TDSStandardDeductions,ss.TDSTaxbleIncomeWithStatury,ss.TDSPT,ss.TDSPF,ss.TDSTaxbleIncome,ss.TDSTaxPayble,ss.EmployeePf,ss.EmployeeESI from campus_teachers t left outer join campus_staff_salarydetails ss on ss.TeacherID=t.TeacherID, campus_department d where d.DEPT_ID=t.department and t.TeacherID=?";

	public static final String GET_SALARY_COUNT = "select count(*) from campus_staff_salarydetails where TeacherID=?";

	public static final String INSERT_SALARY = "insert into campus_staff_salarydetails(TeacherID,BankAccNumber,EmployeePfNo,BankName,IFSCCode,paymentType,Basic,Ca,HRAPercentage,Hra,MedicalAllowances,TelephoneAllowance,PerformanceIncentive,SpecialAllowance,FoodAllowance,WashingAllowance,OtherAllowance,EmployerPf,EmployerESI,GrossSalary,CTC,DeduEmployerPF,EmployeePf,IncomeTax,Pt,DeduEmployerESI,EmployeeESI,TDSCtc,TDSStandardDeductions,TDSTaxbleIncomeWithStatury,TDSPT,TDSPF,TDSTaxbleIncome,TDSTaxPayble,CreatedBy,CreateDate,LeaveDeductions,LateDeductions) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_SALARY = "update campus_staff_salarydetails set BankAccNumber=?, EmployeePfNo=?,BankName=?,IFSCCode=?,paymentType=?,Basic=?,Ca=?,HRAPercentage=?,Hra=?,MedicalAllowances=?,TelephoneAllowance=?,PerformanceIncentive=?,SpecialAllowance=?,FoodAllowance=?,WashingAllowance=?,OtherAllowance=?,EmployerPf=?,EmployerESI=?,GrossSalary=?,CTC=?,DeduEmployerPF=?,EmployeePf=?,IncomeTax=?,Pt=?,DeduEmployerESI=?,EmployerESI=?,TDSCtc=?,TDSStandardDeductions=?,TDSTaxbleIncomeWithStatury=?,TDSPT=?,TDSPF=?,TDSTaxbleIncome=?,TDSTaxPayble=?,ModifiedBy=?,ModifiedDate=?,LeaveDeductions=?,LateDeductions=? where TeacherID=?";
	public static final String CHECK_DUPLICATE_PF_NO="select es.TeacherID from campus_staff_salarydetails es,campus_teachers e where es.TeacherID=e.TeacherID and  es.EmployeePfNo=? and es.TeacherID!=?";
	
	public static final String CHECK_BANK_ACC_NUMBER="select count(*) from campus_staff_salarydetails where BankAccNumber=? and TeacherID!=?";
}
