package com.centris.campus.util;

public class SectionUtilsConstants {
	
	public static final String INSERT_DETAILS_CAMPUS_CLASS_SECTION = "INSERT INTO campus_classsection(classsection_id_int,classdetail_id_int,classsection_name_var,classsection_strength_int,createuser,createdate,modifyuser,modifydate) VALUES (?,?,?,?,?,?,?,?)";
	public static final String UPDATE_CAMPUS_CLASS_SECTION_STRENGTH = "UPDATE campus_classsection SET classsection_strength_int=?, modifyuser=?, modifydate=?  WHERE classsection_id_int = ?";
	public static final String UPDATE_DETAILS_CAMPUS_CLASS_SECTION = "UPDATE campus_classsection SET classdetail_id_int=?,classsection_name_var= ?,classsection_strength_int=?, modifyuser=?, modifydate=?  WHERE classsection_id_int = ?";
	public static final String DELETE_DETAILS_CAMPUS_CLASS_SECTION = "DELETE FROM campus_classsection WHERE classsection_id_int =? ";
	public static final String GET_CAMPUS_CLASS_SECTION_AND_CLASS_DETAILS = "select ccd.classdetail_id_int,ccd.classdetails_name_var,ccst.classstream_name_var,ccs.classsection_id_int,ccs.classsection_name_var,ccs.classsection_strength_int from campus_classdetail ccd,campus_classsection ccs,campus_classstream ccst where ccd.classdetail_id_int=ccs.classdetail_id_int and ccd.classstream_id_int=ccst.classstream_id_int order by length(ccs.classsection_id_int),ccs.classsection_id_int";
	public static final String GET_CAMPUS_CLASS_DETAILS_ID_AND_CLASS_DETAILS_NAME = "select DISTINCT classdetails_name_var,classdetail_id_int from campus_classdetail ORDER BY classdetail_id_int ASC";
	public static final String GET_CLASS_DETAIL_ID = "select classdetail_id_int from campus_classdetail where classdetails_name_var=?";
	public static final String CHECK_SECTION = "select count(*) usercount from campus_classsection where classdetail_id_int=? and classsection_name_var=?";
	public static final String SECTION_COUNT_IN_CAMPUS_ASSIGNMENT = "select  count(*) from campus_assignment  where  SectionID=?";
	public static final String SECTION_COUNT_IN_CAMPUS_CLASSTEACHER = "select  count(*) from campus_classteacher  where  ClassCode=?";
	public static final String SECTION_COUNT_IN_MARKS_UPLOAD = "select  count(*) from campus_marks_upload  where  sectionid=?";
	public static final String SECTION_COUNT_IN_MEETING = "select  count(*) from campus_meeting  where  sectionid=?";
	public static final String SECTION_COUNT_IN_CAMPUS_STUDENT = "select  count(*) from campus_student  where  classsection_id_int=?";
	public static final String SECTION_COUNT_IN_CAMPUS_STUDENT_PROMOTION = "select  count(*) from campus_studentpromotion  where  studentpromotion_fromsection_var=? or studentpromotion_tosection_var=?";
	public static final String SECTION_COUNT_IN_CAMPUS_TIME_TABLE = "select  count(*) from campus_timetable  where  classsectionid=?";
	public static final String SECTION_COUNT_IN_TEACHERSETTINGS = "select  count(*) from campus_teachersettings  where  sectionID=?";
	public static final String GET_CLASS_ID_BY_NAME = "select classdetail_id_int from campus_classdetail where classdetails_name_var=?";
	public static final String CHECK_SECTION_FOR_UPDATE = "select count(*) usercount from campus_classsection where classdetail_id_int=? and classsection_name_var=? and classsection_id_int!=?";
	public static final String GET_SECTION_DETAILS_BY_SEARCH_ID="select  ccd.classdetail_id_int,ccd.classdetails_name_var,ccst.classstream_name_var,ccs.classsection_id_int,ccs.classsection_name_var,ccs.classsection_strength_int from campus_classdetail ccd,campus_classsection ccs,campus_classstream ccst where ccd.classdetail_id_int=ccs.classdetail_id_int and ccd.classstream_id_int=ccst.classstream_id_int and (classsection_name_var like ? or ccd.classdetails_name_var like ? or ccst.classstream_name_var like ? or ccs.classsection_strength_int like ?) order by length(ccs.classsection_id_int),ccs.classsection_id_int";
	public static final String EDIT_SECTION = "select classsection_id_int,classdetail_id_int,classsection_name_var,classsection_strength_int from campus_classsection where classsection_id_int = ?";

}
