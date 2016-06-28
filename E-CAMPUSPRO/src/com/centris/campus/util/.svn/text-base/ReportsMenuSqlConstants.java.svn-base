package com.centris.campus.util;

public class ReportsMenuSqlConstants {

	//Student Information Report queries written by seshu
	
	public static final String GET_ACCYEAR = "select acadamic_id,acadamic_year from campus_acadamicyear";
	public static final String GET_STREAMS = "select classstream_id_int,classstream_name_var from campus_classstream";
	public static final String GET_CLASSES = "select classdetail_id_int,classdetails_name_var from campus_classdetail where classstream_id_int like ?";
	public static final String GET_SECTIONS = "select classsection_id_int,classsection_name_var from campus_classsection where classdetail_id_int=?";
	
	public static final String GET_STUDENTSiNFORMATION = "select student_admissionno_var,concat(student_fname_var,' ',student_lname_var) as studentname,student_age_int,student_doj_var,FatherName,mobileno,student_mothername_var,student_mothermobileno_var from campus_student st,campus_parents p,campus_parentchildrelation pc where pc.stu_addmissionNo=st.student_id_int and pc.parentid=p.ParentID and fms_acadamicyear_id_int=? and fms_classstream_id_int=? and classdetail_id_int=? and classsection_id_int=?";
	
	public static final String GET_SELECTED_ITEMS = "select acc.acadamic_year,s.classstream_name_var,c.classdetails_name_var,sec.classsection_name_var from campus_acadamicyear acc,campus_classstream s,campus_classdetail c,campus_classsection sec where acc.acadamic_id=? and s.classstream_id_int=? and c.classdetail_id_int=? and sec.classsection_id_int=?";
	
	
	
	
	
	//Staff Attendance Information Report queries 
	public static final String GET_STAFF_ATTENDANCE_ITEMS = "select acadamic_year,acadamic_id from campus_acadamicyear where acadamic_id=?";
	public static final String GET_TEACHINGTYPE_LIST = "select concat(tea.FirstName,' ',LastName) as teachername ,att.AttendenceDate,att.AttendenceStatus from campus_teachers tea,campus_teacher_attendence att where att.TeacherID=tea.TeacherID and tea.teachingType='Teaching' and tea.isActive='Y' and att.AttendenceDate between ? and ? and tea.TeacherID like ?";
	 
	public static final String GET_NON_TEACHINGTYPE_LIST = "select concat(tea.FirstName,' ',LastName) as teachername ,att.AttendenceDate,att.AttendenceStatus from campus_teachers tea,campus_teacher_attendence att where att.TeacherID=tea.TeacherID and tea.teachingType='Non-Teaching' and tea.isActive='Y' and att.AttendenceDate between ? and ? and tea.TeacherID like ?";
	public static final String GET_STAFF_TEACHING_LIST = "select TeacherID,concat(FirstName,' ',LastName) as teachername from campus_teachers where teachingType='Teaching' and isActive='Y'";
	public static final String GET_STAFF_NON_TEACHING_LIST = "select TeacherID,concat(FirstName,' ',LastName) as teachername from campus_teachers where teachingType='Non-Teaching' and isActive='Y'";
	public static final String TEACHER_NAMES = "select TeacherID,concat(FirstName,' ',LastName)as teachername from campus_teachers where TeacherID=?";
	
	
	
	
	//student Attendance
	public static final String GET_STUDENT_ATTENDANCE_LIST = "select concat(st.student_fname_var,' ',student_lname_var) as studentname ,str.classstream_name_var,cls.classdetails_name_var,sec.classsection_name_var,att.attendencedate,att.attendence,acc.acadamic_year from campus_student st,campus_classstream str,campus_classdetail cls,campus_classsection sec,campus_attendence att,campus_acadamicyear acc  where  st.fms_classstream_id_int=str.classstream_id_int and st.classdetail_id_int=cls.classdetail_id_int and st.classsection_id_int=sec.classsection_id_int and st.student_id_int=att.addmissionno and st.fms_acadamicyear_id_int=acc.acadamic_id and att.attendencedate between ? and ? and st.student_id_int like ?";
	public static final String GET_STREAM_NAME = "select classstream_name_var,classstream_id_int from campus_classstream where classstream_id_int=?";
	public static final String GET_CLASS_NAME = "select classdetail_id_int,classdetails_name_var from campus_classdetail where classdetail_id_int =?";
	public static final String GET_SECTION_NAME = "select classsection_id_int,classsection_name_var from campus_classsection where classsection_id_int=?";
	public static final String GET_STUDENT_NAME = "select student_id_int, concat(student_fname_var,' ',student_lname_var)as studentname from campus_student where student_id_int=?";
	
	
	//Staff Releiving Order
	public static final String GET_TEACHER_TEACHING_LIST = "select TeacherID,concat(FirstName,' ',LastName) as teachername from campus_teachers where teachingType='Teaching' and role=?";
	public static final String GET_NONTEACHER_TEACHING_LIST = "select TeacherID,concat(FirstName,' ',LastName) as teachername from campus_teachers where teachingType='Non-Teaching' and role=?";
	public static final String GET_USER_LIST = "select RoleCode,RoleName from campus_role order by RoleName";
	public static final String GET_RELEIVING_DETAILS_LIST = "select concat(t.FirstName,' ',LastName)as teachername,t.registerId,t.dateofJoining,des.designationName,sl.EmployeePfNo,sl.CTC from campus_teachers t,campus_designation des, campus_staff_salarydetails sl where t.designation=des.DesignationCode and t.TeacherID=? and t.TeacherID=sl.TeacherID and (SELECT  MAX( sl.CreateDate)FROM campus_staff_salarydetails sl)";
	
	//student Transfer Certificate 
	public static final String GET_CLASS_DETAILS = "select classdetail_id_int,classdetails_name_var from campus_classdetail order by classdetail_id_int";
	public static final String GET_SECTION_DETAILS = "select classsection_id_int,classsection_name_var from campus_classsection where classdetail_id_int=? order by classsection_name_var";
	public static final String GET_STUDENT_DETAILS = "select student_id_int,concat(student_fname_var,' ',student_lname_var) as studentname from campus_student where classsection_id_int=? order by student_fname_var";
	
	
	//Phone Directory
	
	public static final String GET_ADMIN_LIST = "select tea.TeacherID,concat(tea.FirstName,' ',LastName) as adminname,rl.RoleName from campus_teachers tea,campus_role  rl where tea.role=rl.RoleCode and RoleName='Admin'";
	public static final String GET_STUDENTS_LIST = "select student_id_int,concat(student_fname_var,' ',student_lname_var)as studentname from campus_student order by student_fname_var";
	public static final String GET_TEACHERS_LIST = "select tea.TeacherID,concat(tea.FirstName,' ',LastName) as teachername,rl.RoleName from campus_teachers tea,campus_role  rl where tea.role=rl.RoleCode and RoleName='Teacher'";
	public static final String  GET_ALL_TEACHERS_LIST = "select TeacherID,concat(FirstName,' ',LastName) as teachername from campus_teachers order by FirstName";
	public static final String GET_ADMIN_PHONE_DIRECTORYLIST = "select tea.TeacherID,concat(tea.FirstName,' ',LastName) as adminname,rl.RoleName,tea.mobileNo,tea.emailId,tea.permanentAddress from campus_teachers tea,campus_role  rl where tea.role=rl.RoleCode and RoleName='Admin' and tea.TeacherID like ?";
	public static final String GET_STUDENTSPHONE_DIRECTORY_LIST = "select student_id_int,concat(student_fname_var,' ',student_lname_var)as studentname,case when (student_fathermobileno_var is null || student_fathermobileno_var='') then student_gardian_mobileno else student_fathermobileno_var end FatherMobile,case when (student_father_mailid is null || student_father_mailid='') then student_gardian_mailid else student_father_mailid end FatherMailId,student_address from campus_student where student_id_int like ? order by student_fname_var";
	public static final String GET_TEACHERS_PHONE_DIRECTORY_LIST = "select tea.TeacherID,concat(tea.FirstName,' ',LastName) as teachername,rl.RoleName,tea.mobileNo,tea.emailId,tea.permanentAddress from campus_teachers tea,campus_role  rl where tea.role=rl.RoleCode and RoleName='Teacher' and tea.TeacherID like ?";
	public static final String GET_ALL_TEACHERS_DIRECTORY_LIST = "select tea.TeacherID,concat(tea.FirstName,' ',LastName) as teachername,rl.RoleName,tea.mobileNo,tea.emailId,tea.permanentAddress from campus_teachers tea,campus_role  rl where tea.role=rl.RoleCode  and tea.TeacherID like ?";
	public static final String GET_ALL_STUDENTSPHONE_DIRECTORY_LIST = "select student_id_int,concat(student_fname_var,' ',student_lname_var)as studentname,case when (student_fathermobileno_var is null || student_fathermobileno_var='') then student_gardian_mobileno else student_fathermobileno_var end FatherMobile,case when (student_father_mailid is null || student_father_mailid='') then student_gardian_mailid else student_father_mailid end FatherMailId,student_address from campus_student  order by student_fname_var";

	public static final String GET_ALL_STUDENTSPHONE_DIRECTORY_LIST1 = "select student_id_int,concat(student_fname_var,' ',student_lname_var)as studentname,case when (student_fathermobileno_var is null || student_fathermobileno_var='') then student_gardian_mobileno else student_fathermobileno_var end FatherMobile,case when (student_father_mailid is null || student_father_mailid='') then student_gardian_mailid else student_father_mailid end FatherMailId,student_address from campus_student  where student_id_int like ?";
	public static final String GET_ALL_TEACHERS_DIRECTORY_LIST1 = "select tea.TeacherID,concat(tea.FirstName,' ',LastName) as teachername,rl.RoleName,tea.mobileNo,tea.emailId,tea.permanentAddress from campus_teachers tea,campus_role  rl where tea.role=rl.RoleCode  and tea.TeacherID like ?";
	public static final String GET_TEACHERS_NAME = "select TeacherID,concat(FirstName,' ',LastName) as teachername from campus_teachers where TeacherID=?";
	public static final String GET_STUDENTS_NAME = "select student_id_int,concat(student_fname_var,' ',student_lname_var) as studentname from campus_student where student_id_int=?";
	
	//Service Certificate
	
		public static final String GET_TEACHER_DETAILS = "select TeacherID,concat(FirstName,' ',LastName)as teachername from campus_teachers order by FirstName";
		public static final String GET_TEACHER_DETAILS_BY_ID = "select tea.TeacherID,concat(tea.FirstName,' ',LastName) as teachername,tea.dateofJoining,des.designationName from campus_teachers tea,campus_designation des where tea.designation=des.DesignationCode and tea.TeacherID=?";
		
	
	// For FeeCollectionSummaryReport written by seshu
	
	public static final String GET_TOT_CLASSFEE="select concat(cd.classdetails_name_var,' - ',cs.classsection_name_var)ClassName,ft.termname,sum(fstd.feeAmount)ActualAmount,st.classdetail_id_int ClassId,st.classsection_id_int SectionId from campus_student st,campus_fee_setup fst, campus_fee_setupdetails fstd,campus_fee_master fm,campus_fee_termdetails ft,campus_classdetail cd,campus_classsection cs where st.classdetail_id_int=fst.ClassCode and fstd.feeSettingCode=fst.feeSettingcode and fm.FeeCode=fstd.feecode and fst.Termcode=ft.termid and cd.classdetail_id_int=st.classdetail_id_int and cs.classsection_id_int=st.classsection_id_int and  st.classdetail_id_int=? and st.classsection_id_int=? and fst.AccyearCode=? and fst.Termcode=? and st.student_status_var='active'";
	public static final String GET_TOT_TRANSPORTFEE="select sum(fstgd.feeAmount)transportfee from campus_fee_stagesetup fstg,campus_fee_stagesetupdetails fstgd,campus_student st where st.classdetail_id_int=? and st.classsection_id_int=? and st.student_status_var='active' and fstg.ClassCode=st.classdetail_id_int and fstg.stageSettingCode=fstgd.stageSettingCode and fstg.AccyearCode=? and fstg.Termcode=?";
	public static final String GET_TOT_PAID_FEE = "SELECT sum(fc.actualamount)paidfee from campus_fee_collection fc,campus_student st where fc.admissionNo=st.student_admissionno_var and st.classdetail_id_int=? and st.classsection_id_int=? and fc.accYear=? and fc.termcode=?";
	
	public static final String GET_TOT_SECTIONS = "select classsection_name_var,classsection_id_int from campus_classsection where classdetail_id_int=?";
	
	
	

	//Class Teacher Mapped List
	
	public static final String CLASS_TEACHER_MAPPED_LIST = "select cls.classdetail_id_int,cls.classdetails_name_var,sec.classsection_id_int,sec.classsection_name_var ,(case when map.SectionCode=sec.classsection_id_int then (select concat(FirstName,' ',LastName)as teaname from  campus_teachers where TeacherID=map.TeacherCode) else '-' end)teachername ,(case when map.SectionCode=sec.classsection_id_int then (select TeacherID from  campus_teachers where TeacherID=map.TeacherCode) else '-' end)teacherid from campus_classdetail cls,campus_classsection sec left outer join  campus_classteacher map on  map.SectionCode=sec.classsection_id_int where cls.classdetail_id_int=sec.classdetail_id_int order by cls.classdetails_name_var";

	public static final String SEARCH_CLASS_TEACHER = "select distinct cls.classdetail_id_int,cls.classdetails_name_var,sec.classsection_id_int,sec.classsection_name_var ,(case when map.SectionCode=sec.classsection_id_int then (select concat(FirstName,' ',LastName)as teaname from campus_teachers where TeacherID=map.TeacherCode) else '-' end)teachername ,(case when map.SectionCode=sec.classsection_id_int then (select TeacherID from  campus_teachers where TeacherID=map.TeacherCode) else '-' end)teacherid from campus_teachers ct left outer join  campus_classteacher map on ct.TeacherID=map.TeacherCode,campus_classdetail cls,campus_classsection sec where cls.classdetail_id_int=sec.classdetail_id_int and map.TeacherCode =ct.TeacherID and (ct.FirstName like ? or ct.LastName like ? or cls.classdetails_name_var like ? or sec.classsection_name_var like ? )order by cls.classdetails_name_var and sec.classsection_name_var and ct.FirstName and ct.LastName";
	
	
	// Fee paid Status Report written by seshu
	
	public static final String GET_FEE_STATUS_REPORT = "select cd.classdetails_name_var,cls.classsection_name_var,cls.classsection_id_int,st.student_admissionno_var,concat(st.student_fname_var,' ',st.student_lname_var) studentname,fc.totalamount,fc.actualamount,fc.conc_amount,fc.paidDate,case when st.student_admissionno_var=fc.admissionNo then 'Paid' else 'NotPaid' end as feestatus from campus_classdetail cd,campus_classsection cls,campus_student st left outer join campus_fee_collection fc on st.student_admissionno_var=fc.admissionNo and fc.termcode=? and fc.accYear=? where st.classdetail_id_int=cd.classdetail_id_int and st.classdetail_id_int=? and st.classsection_id_int=cls.classsection_id_int and st.classsection_id_int like ? and st.student_status_var='active' order by st.classsection_id_int,studentname";
	
	public static final String GET_CLASS_FEE_AMOUNT = "select sum(fstd.feeAmount)ActualAmount from campus_fee_setup fst, campus_fee_setupdetails fstd where fstd.feeSettingCode=fst.feeSettingcode and  fst.ClassCode=? and fst.AccyearCode=? and fst.Termcode=?";
	
	public static final String GET_STAGE_FEE_AMOUNT = "select sum(fstgd.feeAmount)transportfee from campus_fee_stagesetup fstg,campus_fee_stagesetupdetails fstgd where fstg.ClassCode=? and fstg.stageSettingCode=fstgd.stageSettingCode and fstg.AccyearCode=? and fstg.Termcode=?";
	
	public static final String GET_FEEPAID_STATUS_REPORT = "select cd.classdetails_name_var,cls.classsection_name_var,cls.classsection_id_int,st.student_admissionno_var,concat(st.student_fname_var,' ',st.student_lname_var) studentname,fc.totalamount,fc.actualamount,fc.conc_amount,fc.paidDate from campus_classdetail cd,campus_classsection cls,campus_student st,campus_fee_collection fc  where st.classdetail_id_int=cd.classdetail_id_int and st.classdetail_id_int=? and st.classsection_id_int=cls.classsection_id_int and st.classsection_id_int like ? and st.student_status_var='active' and st.student_admissionno_var=fc.admissionNo and fc.termcode=? and fc.accYear=? order by st.classsection_id_int,studentname";
	
	public static final String GET_FEENOTPAID_STATUS_REPORT = "select cd.classdetails_name_var,cls.classsection_name_var,cls.classsection_id_int,st.student_admissionno_var,concat(st.student_fname_var,' ',st.student_lname_var) studentname from campus_classdetail cd,campus_classsection cls,campus_student st,campus_fee_collection fc where st.classdetail_id_int=cd.classdetail_id_int and st.classdetail_id_int=? and st.classsection_id_int=cls.classsection_id_int and st.classsection_id_int like ? and st.student_status_var='active' and st.student_admissionno_var!=fc.admissionNo and fc.termcode=? and fc.accYear=? order by st.classsection_id_int,studentname";
	
	//pay certificate
	public static final String GET_STUDENTCOUNT ="select count(*) studentcount from campus_student where classdetail_id_int=? and classsection_id_int=? and student_status_var='active'";
	public static final String GET_TEACHER_PAYCERTIFICATE = "select tea.TeacherID,concat(tea.FirstName,' ',LastName) as teachername,des.designationName,mn.Net_Salary,mn.Leave_Deductions,mn.Total_Deductions,mn.Employee_Pf,sa.GrossSalary,sa.CTC from campus_teachers tea,campus_designation des,campus_month_payroll mn,campus_staff_salarydetails sa where tea.designation=des.DesignationCode and tea.TeacherID=mn.Emp_Id and tea.TeacherID=sa.TeacherID and mn.Emp_Id=? and mn.Month=? and mn.Year=?";
	public static final String GET_CLASS_SECTION = "select cls.classdetail_id_int,cls.classdetails_name_var,sec.classsection_id_int,sec.classsection_name_var from campus_classdetail cls,campus_classsection sec where cls.classdetail_id_int=? and sec.classsection_id_int=?";
	public static final String GET_CLASS_SECTION_TEACHER = "select cls.classdetail_id_int,cls.classdetails_name_var,sec.classsection_id_int,sec.classsection_name_var, tea.TeacherID,concat(tea.FirstName,' ',LastName)as teachername from campus_classdetail cls,campus_classsection sec,campus_teachers tea where cls.classdetail_id_int=? and sec.classsection_id_int=? and tea.TeacherID=?";
	public static final String UPDATE_CLASS_TEACHER = "update campus_classteacher set TeacherCode=? where ClassCode=? and SectionCode=?";
	public static final String VALIDATE_CLASS_TEACHER = "select count(*) count from campus_classteacher where ClassCode=? and SectionCode=? and TeacherCode=?";
	public static final String SAVE_CLASS_TEACHER = "insert into campus_classteacher(CTCode,ClassCode,SectionCode,TeacherCode,CreateTime,CreateUser) values(?,?,?,?,?,?)";
	//Online Fee Receipt
	
	public static final String GET_PARENT_STUDENT_DETAILS = "select stu.student_id_int,concat(stu.student_fname_var,' ',student_lname_var) as studentname from campus_student stu,campus_parentchildrelation par where par.stu_addmissionNo=stu.student_id_int and stu.classsection_id_int=? and par.parentid=?";
	public static final String GET_FEE_RECEIPT_LIST = "select fc.feeAmount,fee.admissionNo,fee.paidDate,stu.student_id_int,concat(stu.student_fname_var,' ',student_lname_var)as studentname,cls.classdetails_name_var,sec.classsection_name_var,fee.totalamount,trm.termname,fn.FeeName from campus_fee_collection fee,campus_student stu,campus_classdetail cls,campus_classsection sec,campus_fee_termdetails trm ,campus_fee_master fn,campus_fee_collectiondetails fc where fee.admissionNo=stu.student_admissionno_var and  stu.classdetail_id_int=cls.classdetail_id_int and stu.classsection_id_int=sec.classsection_id_int and fc.feeCode=fn.FeeCode and fee.feeCollectionCode=fc.feeCollectionCode and fee.termcode=trm.termid and fee.accYear=? and stu.student_id_int=?";

	
	//Student Marks Details Report
		
		public static final String GET_STUDENT_MARKS="select st.student_admissionno_var,concat(st.student_fname_var,' ',st.student_lname_var) studentName,ex.examname,sub.subjectName,mu.maximum_marks,mu.required_marks,m.scoredmarks from campus_subject sub,campus_student st,campus_marks_upload mu,campus_marks m,campus_examination ex where mu.examid=ex.examid and mu.subid=sub.subjectID and mu.marks_upload_id=m.marks_upload_id and m.admissionno=st.student_id_int and mu.examid=? and mu.classid=? and mu.sectionid=? and m.admissionno=? and mu.AccYear=?";

	//Student Marks Details Report
		
				public static final String GET_CLASS_WISE_EXAM_DETAILS="select ex.examname,sub.subjectName,mu.maximum_marks,mu.required_marks,ext.examdate,ext.examtime,ext.endtime from campus_examination ex,campus_subject sub,campus_examination_timetable ext left outer join campus_marks_upload mu on mu.examid=ext.examinationid where ex.examid=ext.examinationid and ext.classid=? and ex.acadamicyear=? and sub.subjectID=ext.subjectid";


}
