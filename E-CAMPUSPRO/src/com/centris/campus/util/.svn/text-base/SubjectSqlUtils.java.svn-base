package com.centris.campus.util;

public class SubjectSqlUtils {
	
	public static final String VIEW_SUBJECT_DETAILS="select  cs.subjectID ,cs.subjectName,cs.syllabous,cs.decription,cd.classdetails_name_var  from campus_subject cs ,campus_classdetail cd where cs.classid=cd.classdetail_id_int and cs.status='active'";
    public static final String DELETE_SUBJECT_DETAILS="update campus_subject set status='inactive' where subjectID=?";
    public static final String SEARCH_SUBJECT_DETAILS="select s.subjectID,s.subjectName,s.syllabous,s.decription,cd.classdetails_name_var from campus_subject s,campus_classdetail cd where (s.subjectName like ? or s.decription like ? or cd.classdetails_name_var like ?) and s.classid=cd.classdetail_id_int";
    public static final String INSERT_ADDSUBJECT_FORM = "insert into campus_subject(subjectID,subjectName,syllabous,classid,decription,createdby) values(?,?,?,?,?,?)";
    public static final String GET_SINGLE_SUBJECT_DETAILS="select * from campus_subject where subjectID=?";
    public static final String UPDATE_SUBJECT = "update campus_subject set subjectName=? ,syllabous=?,classid=?, decription=?, createdby=? where subjectID=?";
    public static final String VALIDATE_CLASS_SUBJECT = "select count(*) count from campus_subject where subjectName=? and classid=?";
    public static final String ViewAllSubjectsPath = "select * from campus_subject where subjectID=?";
    public static final String GET_SYLLABUS_PATH = "select syllabous from campus_subject where subjectID=?";
    
    
    
}
