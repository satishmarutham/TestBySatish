package com.centris.campus.delegate;

import java.util.ArrayList;

import com.centris.campus.pojo.TeacherTimeTablePojo;
import com.centris.campus.pojo.TimeTablePojo;
import com.centris.campus.service.TimeTableService;
import com.centris.campus.serviceImpl.TimeTableServiceImpl;
import com.centris.campus.vo.TeacherTimeTableVo;
import com.centris.campus.vo.TimeTableVo;

public class TimeTableBD {

	TimeTableService obj = new TimeTableServiceImpl();

	public ArrayList<TimeTableVo> getTimeTableDetails(String timetableDetails) {
		ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();

		details = obj.getTimeTableDetails(timetableDetails);

		return details;
	}

	public ArrayList<TimeTableVo> getClassName() {
		ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();

		details = obj.getClassName();

		return details;
	}

	public ArrayList<TimeTableVo> getSectionName(String classid) {
		ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();

		details = obj.getSectionName(classid);

		return details;
	}

	public String updateTimeTableDetails(TimeTablePojo pojo) {
		String result = obj.updateTimeTableDetails(pojo);
		return result;
	}

	public ArrayList<TimeTableVo> getTeacherTimeTableDetails(
			String teacherid, String accyearid) {
		ArrayList<TimeTableVo> details = new ArrayList<TimeTableVo>();

		details = obj.getTeacherTimeTableDetails(teacherid, accyearid);

		return details;
	}

	public ArrayList<TeacherTimeTableVo> getTeacherName() {
		ArrayList<TeacherTimeTableVo> details = new ArrayList<TeacherTimeTableVo>();

		details = obj.getTeacherName();

		return details;
	}
	
	public String updateTeacherTimeTableDetails(TeacherTimeTablePojo pojo) {
		String result = obj.updateTeacherTimeTableDetails(pojo);
		return result;
	}

	public ArrayList<TimeTableVo> getClassTimeTableList(String accyearid,String viewBy) {
		
		return obj.getClassTimeTableList(accyearid,viewBy);
	}
	
	public ArrayList<TimeTableVo> getClassSectionList(){
		
		return obj.getClassSectionList();
	}
	

}