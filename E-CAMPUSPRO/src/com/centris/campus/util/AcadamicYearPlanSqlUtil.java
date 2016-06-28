package com.centris.campus.util;

public class AcadamicYearPlanSqlUtil {

	public static final String INSERT_ACADAMICYEAR_PLAN = "insert into campus_accyearplan(AccYearPlanCode,Title,Date,WeekDay,StartTime,EndTime,InvitationFile,Description,AcadamicYear,CreatedBy,CreateDate)values(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_ALL_ACADAMICYEAR_PLANS = "select *from campus_accyearplan where AcadamicYear=?";
	public static final String GET_SINGLE_ACADAMICYEAR_PLAN = "select *from campus_accyearplan where AccYearPlanCode=?";
	public static final String GET_SEARCH_ACADAMICYEAR_PLAN = "select * from campus_accyearplan where Title like ?  or WeekDay like ?  or Description like ? and AcadamicYear=?";
	public static final String DELETE_ACADAMICYEAR_PLAN = "delete from campus_accyearplan where AccYearPlanCode=?";
	public static final String UPDATE_ACADAMICYEAR_PLAN = "update campus_accyearplan set Title=?,Date=?,WeekDay=?,StartTime=?,EndTime=?,InvitationFile=?,Description=?,ModifiedBy=?,ModifiedDate=? where AccYearPlanCode=?";
	public static final String VALIDATE_ACADAMICYEAR_PLAN = "select count(*) from campus_accyearplan where Date=? and (? between StartTime and EndTime or ? between StartTime and EndTime)";
	public static final String VALIDATE_ACADAMICYEAR_PLAN_UPDATE = "select count(*) from campus_accyearplan where Date=? and (? between StartTime and EndTime or ? between StartTime and EndTime) and AccYearPlanCode!=?";

}
