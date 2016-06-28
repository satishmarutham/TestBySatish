package com.centris.campus.util;

public class StudentAttendanceSqlUtil {
	
	public static final String GET_ATTENDANCE_LIST = "select ta.AttendenceDate,count(s.student_id_int) as total_streangth,concat(cls.classdetails_name_var,'-',sec.classsection_name_var) classsection,sum(case when ta.attendence='Present' then 1 else 0 end) TotalPresent,sum(case when ta.attendence='Absent' then 1 else 0 end) TotalAbsent,sum(case when ta.attendence='Holiday' then 1 else 0 end) TotalHoliday,sum(case when ta.attendence='Leave' then 1 else 0 end) Totalleave from campus_attendence ta,campus_student s,campus_classdetail cls,campus_classsection sec where ta.AttendenceDate and s.classdetail_id_int=cls.classdetail_id_int and s.classsection_id_int = sec.classsection_id_int between ?  and ? and s.student_id_int=ta.addmissionno group by ta.AttendenceDate";

	public static final String GET_STUDENT_ATTENDANCE_LIST = "select s.student_id_int,s.student_admissionno_var,concat(s.student_fname_var,' ',s.student_lname_var) studentname,cd.classdetails_name_var,se.classsection_name_var,case when a.attendence is null then 'Present' else a.attendence end status from  campus_student s left outer join campus_attendence a on a.addmissionno=s.student_id_int and a.attendencedate=?,campus_classdetail cd,campus_classsection se  where s.classdetail_id_int=cd.classdetail_id_int and s.classsection_id_int=se.classsection_id_int and s.classdetail_id_int like ? and s.classsection_id_int like ? order by length(s.student_admissionno_var),s.student_admissionno_var";
	
	public static final String GET_ATTENDANCE_COUNT = "select count(*) from campus_attendence where addmissionno=? and AttendenceDate=?";
	
	public static final String UPDATE_ATTENDANCE = "update campus_attendence set attendence=?,updatedBy=?,updateDate=? where  addmissionno=? and attendencedate=?";
	
	public static final String INSERT_ATTENDANCE ="insert into campus_attendence(addmissionno,attendencedate,attendence,createdBy,CreateDate) values(?,?,?,?,?)";

	public static final String GET_STU_PERIOD_ATT ="select * from campus_student_period_attendance where AttendanceDate=? and StudentId=?";

	public static final String UPDATE_STU_PERIOD_ATT = "update campus_student_period_attendance set  Period1=?,Period2=?,Period3=?,Period4=?,Period5=?,Period6=?,Period7=?,Period8=?,UpdatedBy=?,UpdateDate=? where AttendanceDate=? and StudentId=?";
	
	public static final String INSERT_STU_PERIOD_ATT = "insert into campus_student_period_attendance(AttendanceDate,StudentId,Period1,Period2,Period3,Period4,Period5,Period6,Period7,Period8,CreatedBy,CreateDate) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String CHECK_STU_PERIOD_ATT = "select count(*) from campus_student_period_attendance where AttendanceDate=? and StudentId=?";
}


