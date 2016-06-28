package com.centris.campus.dao;

import java.util.ArrayList;
import java.util.List;

import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.pojo.LstmsStudentPOJO;
import com.centris.campus.pojo.SectionPojo;
import com.centris.campus.pojo.StudentAttendancePojo;
import com.centris.campus.vo.ParentVO;
import com.centris.campus.vo.StreamDetailsVO;
import com.centris.campus.vo.StudentAttendanceReportVo;
import com.centris.campus.vo.StudentAttendanceVo;

public interface StudentAttendanceDao {

	public ArrayList<StudentAttendanceVo> getStudentsAttendanceList(String startDate, String endDate);
	public ArrayList<StudentAttendanceVo> getStudentAttendanceDetails(StudentAttendancePojo studentAttPojo);
	public String updateAttendanceStatus(StudentAttendancePojo studentAttPojo);

	List<LstmsStudentPOJO> getAllStudentDao(String classVal, String sectionVal);

	ArrayList<StudentAttendanceReportVo> getStudentAttendanceReportDao(
			StudentAttendanceReportVo vo);

	ArrayList<StudentAttendanceReportVo> getStudentAttendanceListReportDao(
			StudentAttendanceReportVo stuvo);

	StreamDetailsVO getStreamNameDaoImpl(String stream);

	ClassPojo getClassNameDaoImpl(String classname);

	SectionPojo getSectionNameDaoImpl(String sectionname);

	ParentVO getStudentNameDaoImpl(String student);
	
	public StudentAttendanceVo getStudentPeriodAttendance(StudentAttendancePojo AttendancePojo);
	public String updateStudentPeriodAtt(StudentAttendancePojo AttendancePojo);



}
