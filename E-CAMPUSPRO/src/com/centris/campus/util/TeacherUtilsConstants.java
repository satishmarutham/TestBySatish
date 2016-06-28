package com.centris.campus.util;

public class TeacherUtilsConstants {

	public static final String ALL_TEACHER_DETAILS = "select t.registerId,concat(t.FirstName,'',t.LastName) as teacherName,t.Qualification,d.designationName,t.MobileNo,t.TeacherID,t.emailId,dept.DEPT_NAME,ss.BankAccNumber,ss.EmployeePfNo,ss.CTC from campus_teachers t left outer join campus_staff_salarydetails ss on ss.TeacherID=t.TeacherID,campus_designation d,campus_department dept where  t.designation=d.DesignationCode and dept.DEPT_ID=t.department and  t.isActive='Y'";
	public static final String SEARCH_TEACHER_DETAILS="select concat(t.FirstName,'',t.LastName) as teacherName,t.Qualification,d.designationName,t.mobileNo,t.TeacherID,t.emailId from campus_teachers t,campus_designation d where t.designation=d.DesignationCode and t.isActive='Y' and (concat(t.FirstName,'',t.LastName) like ? or t.mobileNo like ?  or t.Qualification like ? or d.designationName like ? or t.emailId like ?)";
    public static final String DELETE_TEACHER_DETAILS="update campus_teachers  set isActive='N' where TeacherID=?";
    public static final String GET_SUBJECTS = "select distinct(subjectName),subjectID  from campus_subject group by subjectName order by subjectName";
    public static final String GET_TEACHER_COUNT = "select count(*) from campus_teachers where UserName=? and TeacherID!=?";
    public static final String GET_TEACHERMAIL_COUNT = "select count(*) from campus_teachers where emailId=? and TeacherID!=?";
    public static final String CHECK_TACHER_COUNT_ = "select count(*) from campus_teachers where UserName=? and department=? and designation=? and MobileNo=? and DateOfBirth=? and DateOfJoining=? ";
    public static final String INSERT_TEACHER = "insert into campus_teachers(TeacherID,FirstName,LastName,Qualification,presentAddress,MobileNo,UserName,emailId,primarySubject,secondarySubject,profilePath,imagePath,DateOfBirth,DateOfJoining,designation,idProofPath,teachingType,department,gender,bloodgroup,fathername,mothername,permanentAddress,createdby,createddate,registerId,password,role) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static String GET_SERVER_URL = "select URL from campus_settings";
    public static final String GET_SINGLE_TEACHER_DEATILS="select * from campus_teachers where TeacherID=?";
    public static final String UPDATE_TEACHER="update campus_teachers set FirstName=?,LastName=?,Qualification=?,presentAddress=?,MobileNo=?,UserName=?,emailId=?,primarySubject=?,secondarySubject=?,profilePath=?,imagePath=?,DateOfBirth=?,DateOfJoining=?,designation=?,idProofPath=?,teachingType=?,department=?,gender=?,bloodgroup=?,fathername=?,mothername=?,permanentAddress=?,updatedby=?,updateddate=?,role=? where TeacherID=?";
   public static final String GET_REGISTRAION_COUNT="select count(*) from campus_teachers where registerId=? and TeacherID!=?";
 
   
   //For Class Mapping
   public static final String GET_MAPPING_CLASSES="select CTCode,ClassCode,SectionCode from campus_classteacher where TeacherCode=?";
   public static final String GET_UNMAPPING_SECTION="select se.classsection_id_int,se.classsection_name_var from campus_classsection se join campus_classdetail cl on cl.classdetail_id_int=se.classdetail_id_int where se.classdetail_id_int=? and se.classsection_id_int not in (select SectionCode from campus_classteacher where TeacherCode!=? and  ClassCode=?)";
   public static final String GET_SECTION_NAME="select classsection_name_var from campus_classsection where classsection_id_int=?";
   
   public static final String DELETE_CLAA_MAPPINGS="delete from campus_classteacher where TeacherCode=?";
   public static final String INSERT_CLASS_MAPPINGS="insert into campus_classteacher(CTCode,ClassCode,SectionCode,TeacherCode,CreateTime,CreateUser) values(?,?,?,?,?,?)";
   
   
   //For Subject Mappings
   
   public static final String DELETE_SUBJECT_MAPPINGS="delete from campus_teachersettings where teacherID=?";
   public static final String INSERT_SUBJECTS_MAPPINGS="insert into campus_teachersettings(teacherID,classID,subjectID,createdBy,createTime) values(?,?,?,?,?)";
   public static final String GET_MAPPING_SUBJECTS="select teacherID,classID,subjectID from campus_teachersettings where teacherID=?";
   

   public static final String SEARCH_TEACHER_EMPLOYEMENT_DETAILS = "select t.registerId,concat(t.FirstName,'',t.LastName) as teacherName,t.Qualification,d.designationName,t.MobileNo,t.TeacherID,t.emailId,dept.DEPT_NAME,ss.BankAccNumber,ss.EmployeePfNo,ss.CTC from campus_teachers t left outer join campus_staff_salarydetails ss on ss.TeacherID=t.TeacherID,campus_designation d,campus_department dept where  t.designation=d.DesignationCode and dept.DEPT_ID=t.department and  t.isActive='Y' and (t.FirstName like ? or t.registerId like ? or dept.DEPT_NAME like ?)";

   
   
   //Insert Into user table
   
   public static final String INSERT_USER_DETAILS = "insert into campus_user(usercode,employeecode,username,password,role,type,createuser,createdate) values(?,?,?,?,?,?,?,?)";
   
   public static final String UPDATE_USER_DETAILS = "update campus_user set username=?,role=?,modifyuser=?,modifydate=? where usercode=?";
}
