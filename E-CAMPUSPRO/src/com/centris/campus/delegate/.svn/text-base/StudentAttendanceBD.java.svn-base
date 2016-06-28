package com.centris.campus.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.pojo.SectionPojo;
import com.centris.campus.pojo.StudentAttendancePojo;
import com.centris.campus.service.StudentAttendanceService;
import com.centris.campus.serviceImpl.StudentAttendanceServiceImpl;
import com.centris.campus.vo.ParentVO;
import com.centris.campus.vo.StreamDetailsVO;
import com.centris.campus.vo.StudentAttendanceReportVo;
import com.centris.campus.vo.StudentAttendanceVo;

public class StudentAttendanceBD {

	public ArrayList<StudentAttendanceVo> getStudentsAttendanceList(String startDate,String endDate) {
		// TODO Auto-generated method stub
		StudentAttendanceService attService=new StudentAttendanceServiceImpl();
		
		return attService.getStudentsAttendanceList(startDate,endDate);
	}
	
	public ArrayList<StudentAttendanceVo> getStudentAttendanceDetails(StudentAttendancePojo studentAttPojo) {
		// TODO Auto-generated method stub
		StudentAttendanceService attService=new StudentAttendanceServiceImpl();
		
		return attService.getStudentAttendanceDetails(studentAttPojo);
	}
	
	public String updateAttendanceStatus(StudentAttendancePojo studentAttPojo) {
		// TODO Auto-generated method stub
		StudentAttendanceService attService=new StudentAttendanceServiceImpl();
		
		return attService.updateAttendanceStatus(studentAttPojo);
	}
	
public List<ParentVO> getAllStudent(String classVal, String sectionVal) {
		
		
		StudentAttendanceService service = new StudentAttendanceServiceImpl();
		
		return service.getAllStudentService(classVal,sectionVal);
	}

	public ArrayList<StudentAttendanceReportVo> getStudentAttendanceReportBD(
			StudentAttendanceReportVo vo) {
		
    StudentAttendanceService service = new StudentAttendanceServiceImpl();
		
		return service.getStudentAttendanceReportService(vo);
	}

	public ArrayList<StudentAttendanceReportVo> getStudentAttendanceListReportBD(
			StudentAttendanceReportVo stuvo) {
		
		 StudentAttendanceService service = new StudentAttendanceServiceImpl();
			
			return service.getStudentAttendanceListReportService(stuvo);
	}

	public StreamDetailsVO getStreamNameBD(String stream) {
		
		 StudentAttendanceService service = new StudentAttendanceServiceImpl();
			
			return service.getStreamNameService(stream);
	}

	public ClassPojo getClassNameBD(String classname) {
	
		 StudentAttendanceService service = new StudentAttendanceServiceImpl();
			
			return service.getClassNameService(classname);
	}

	public SectionPojo getSectionNameBD(String sectionname) {
		
		 StudentAttendanceService service = new StudentAttendanceServiceImpl();
			
			return service.getSectionNameService(sectionname);
	}

	public ParentVO getStudentNameBD(String student) {
		 StudentAttendanceService service = new StudentAttendanceServiceImpl();
			
			return service.getStudentNameService(student);
	}

	
	public StudentAttendanceVo getStudentPeriodAttendance(StudentAttendancePojo AttendancePojo) {
		
		 StudentAttendanceService service = new StudentAttendanceServiceImpl();
			
			return service.getStudentPeriodAttendance(AttendancePojo);
	}
	public String updateStudentPeriodAtt(StudentAttendancePojo AttendancePojo) {
		
		 StudentAttendanceService service = new StudentAttendanceServiceImpl();
			
			return service.updateStudentPeriodAtt(AttendancePojo);
	}
	
	
	
}
