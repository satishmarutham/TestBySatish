package com.centris.campus.util;

public class UploadStudentXLSqlUtil {
	
	public static final String CHECK_BEFORINSERT_COUNT= "select count(*) from campus_student";
	public static final String CHECK_STUDENT_ID= "select count(*) from campus_student where  student_admissionno_var=?";
	public static final String CHECK_CATEGORY_ID= "select count(*) from campus_classstream where  classstream_id_int=?";
	public static final String CHECK_CLASS_ID= "select count(*) from campus_classdetail where  classdetail_id_int=?";
	public static final String CHECK_SECTION_ID="select count(*) from campus_classsection where  classsection_id_int=?";
	public static final String INSERT_STUDENT="insert into campus_student(student_id_int,student_rollno,student_admissionno_var,fms_classstream_id_int,fms_acadamicyear_id_int,classdetail_id_int,classsection_id_int,student_regno_var,student_fname_var,student_lname_var,student_dob_var,student_gender_var,student_bloodgroup_var,student_age_int,student_doj_var,student_religion_var,student_nationality_var,student_promotionstatus,student_physicallychallenged,student_identificationmarks_var,student_grade,student_siblingId,student_status_var,student_prehistory_var,student_remarks_var,createuser,createdate,student_quota,student_caste,student_application_no,isTransport,isHostel,isConcession,isRTE,TransportType,StageId,emisNo,physicallychallenged_reason) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

}
