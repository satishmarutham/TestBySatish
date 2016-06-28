package com.centris.campus.util;

public class ExamTimeTableSqlUtils {

	public static final String GET_ALL_EXAM_DETAILS = "select ce.examid,ce.examname,ce.description,ce.startdate,ce.enddate,ct.classid,ct.examdate,ct.examtime,cd.classdetails_name_var,ct.endtime,ct.subjectid from campus_examination ce,campus_examination_timetable ct,campus_classdetail cd where ce.examid=ct.examinationid and cd.classdetail_id_int=ct.classid";
	public static final String GET_EXAM_TIME_TABLE = "select * from campus_examination_timetable where classid=? and subjectid=? and examinationid=?";
	public static final String GET_EXAM_DATE = "select e.startdate, e.enddate from campus_examination e where examid=?";
	public static final String GET_ALL_SUBJECTS = "select s.subjectID,s.subjectName from campus_subject s where classid=?";
	public static final String CHECK_DUPLICATE_EXAM = "select count(*) examdate from campus_examination_timetable where  classid=? and subjectid=? and examinationid=?";
	public static final String UPDATE_EXAMDATE = "update campus_examination_timetable set examdate=?,examtime=?,endtime=?,updateuser=?,updatedate=now()  where classid=? and subjectid=? and examinationid=?";
	public static final String STORE_EXAM_TIMETABLE_DETAILS = "insert into campus_examination_timetable(classid,subjectid,examinationid,examdate,examtime,endtime,createuser,createdate) values (?,?,?,?,?,?,?,now())";

	// chiru

	public static final String GET_EXAMDETAILS = "select examid,examname from campus_examination";
	public static final String GET_CLASSDETAILS = "select classdetail_id_int,classdetails_name_var from campus_classdetail";

}
