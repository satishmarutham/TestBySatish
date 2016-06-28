package com.centris.campus.util;

public class LeaveReportSqlUtils {

	public static final String GET_NO_OF_LEAVES = "select total_leaves,allowed_per_month,SL,PL,CL from campus_teacher_leave_bank where AccyearCode=?";
	
	public static final String GET_EMP_FOR_LEAVES = "select t.TeacherID,concat(t.FirstName,' ',t.LastName) as teacherName,t.dateofJoining from campus_teachers t where t.TeacherID like ? and t.department like ? and t.teachingType like ? and isActive='Y' order by t.FirstName";

	public static final String GET_LEAVES_TYPE_FROM_ATTENDANCE="select LeaveType,ApprovedStartDate from campus_teachers_leave_request where RequestedBy=? and ((substring(ApprovedStartDate,1,4)=? and substring(ApprovedStartDate,6,2)>06) or(substring(ApprovedStartDate,1,4)=? and substring(ApprovedStartDate,6,2)<05))";
	
	public static final String GET_ACC_YEAR="select acadamic_year from campus_acadamicyear where acadamic_id=?";
	
	public static final String GET_ALL_LABEL="select t.TeacherID,concat(t.FirstName,' ',t.LastName) as teacherName,t.teachingType,d.DEPT_NAME from campus_teachers t join campus_department d on d.DEPT_ID=t.department where t.TeacherID like ? and t.department like ? and t.teachingType like ?";

	public static final String GET_TEACHERS="select TeacherID,concat(FirstName,' ',LastName) as teacherName from campus_teachers where teachingType like ? and department like ?";
}
