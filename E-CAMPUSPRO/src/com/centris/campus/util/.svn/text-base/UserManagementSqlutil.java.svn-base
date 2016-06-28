package com.centris.campus.util;

public class UserManagementSqlutil {

	
	public static final String USERRECORDS = "SELECT TeacherID as Id,UserName as username ,case when LastName is null then FirstName else concat(FirstName, ' ',LastName) end FirstName,mobileno,presentAddress FROM campus_teachers where isActive='Y' UNION All SELECT ParentID as Id,UserName as UserName,FatherName,mobileno,address FROM  campus_parents where pstatus='active'";
	public static final String GET_TEACHERS = "SELECT distinct TeacherID as Id,UserName as username,case when LastName is null then FirstName  else concat(FirstName, ' ',LastName) end FirstName ,mobileno FROM campus_teachers where FirstName like ? or LastName like ? or UserName like ? or mobileno like ? and isActive='Y'";
	public static final String GET_PARENTS = "SELECT ParentID as Id,UserName as username,FatherName as firstname,mobileno FROM campus_parents where FatherName like ? or UserName like ? or mobileno like ? and pstatus='active'";
	public static final String GET_TEACHER = "select FirstName,UserName from  campus_teachers where TeacherID=?";
	public static final String GET_PARENT = "select FirstName,UserName from  campus_parents where ParentID=?";
	public static final String CHANGE_TEACHER_PWD = "update campus_teachers  set password=? where TeacherID=?";
	public static final String CHANGE_PARENT_PWD = "update campus_parents  set password=? where ParentID=?";
	public static final String BLOCK_TEACHER = "update campus_teachers set isActive='N' where TeacherID=? ";
	public static final String BLOCK_PARENT = "update campus_parents set pstatus='deactive' where ParentID=? ";
	
}
