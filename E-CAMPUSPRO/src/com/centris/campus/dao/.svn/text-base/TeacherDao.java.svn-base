package com.centris.campus.dao;

import java.util.ArrayList;

import com.centris.campus.pojo.TeacherRegistrationPojo;
import com.centris.campus.vo.AllTeacherDetailsVo;
import com.centris.campus.vo.TeacherMappingClassesVo;

public interface TeacherDao {
	
	public ArrayList<AllTeacherDetailsVo> getAllTeacherDetails();
	public ArrayList<AllTeacherDetailsVo> searchStaffDetails(AllTeacherDetailsVo obj);
	public boolean deleteStaffDetails(AllTeacherDetailsVo obj);
	 public boolean teacherregister(TeacherRegistrationPojo obj);
	 public ArrayList<TeacherMappingClassesVo> getMappingClasses(String teacherID);
	 public ArrayList<TeacherMappingClassesVo> getMappedSection(String teacherID,String classId,String SectionID);
	 public ArrayList<TeacherMappingClassesVo> getMappingSubjects(String teacherID);
	 public ArrayList<AllTeacherDetailsVo> getSearchTeacherDetails(String serchName);
	 

}
