package com.centris.campus.util;

public class StreamSqlUtils {

	public static final String INSERT_STREAM_DETAILS = "INSERT INTO campus_classstream (classstream_id_int,classstream_name_var,description, createuser, createdate,modifyuser,modifydate) VALUES (?,?,?,?,?,?,?)";
	public static final String GET_STREAM_DETAILS = "select * from campus_classstream order by length(classstream_id_int),classstream_id_int";
	public static final String GET_STREAM_ID = "select * from campus_classstream where classstream_id_int = ?";
	public static final String UPDATE_STREAM_DETAILS = "update campus_classstream set classstream_name_var= ?,description=?,createuser=?,createdate=?,modifyuser=?,modifydate=? where classstream_id_int= ?";
	public static final String DELETE_STREAM_DETAILS = "DELETE FROM campus_classstream WHERE classstream_id_int =?";
	public static final String SEARCH_STREAM_DETAILS = "select * from campus_classstream where  classstream_name_var like ? or description like ?";
	public static final String VALIDATE_STREAM_NAME_UPDATE = "select count(*)  from campus_classstream where classstream_name_var=? ";
	public static final String VALIDATE_STREAM_NAME_EDIT = "select count(*)  from campus_classstream where classstream_id_int!=? and classstream_name_var=?";
    public static final String  DELETE_STREAM_MAPPING= "select  count(*) classstream_id_int from campus_classdetail where classstream_id_int=?";
}
