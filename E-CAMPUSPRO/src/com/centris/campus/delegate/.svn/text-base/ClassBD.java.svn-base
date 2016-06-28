package com.centris.campus.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.campus.forms.ClassForm;
import com.centris.campus.pojo.AcademicYearPojo;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.service.ClassService;
import com.centris.campus.serviceImpl.ClassServiceImpl;
import com.centris.campus.vo.AcademicYearVO;

public class ClassBD {
	
	public List<ClassPojo> getClassDetails() {
		ClassService classService=new ClassServiceImpl();
		List<ClassPojo> classList=classService.getClassDetails();
		return classList;
	}
	
	public boolean createClass(ClassPojo classPojo,String createUser, String classcode) {
		ClassService classService=new ClassServiceImpl();
		return classService.createClass(classPojo,createUser,classcode);
	}
	
	public List<ClassPojo> getStreamDetailBD() {
		ClassService classService=new ClassServiceImpl();
		List<ClassPojo> classList=classService.getStreamDetailService();
		return classList;
	}
	
	public boolean classNameCheck(ClassPojo classPojo) {
		ClassService classService=new ClassServiceImpl();
		return classService.classNameCheck(classPojo);
	}
	
	public boolean updateclassNameCheck(ClassPojo classPojo) {
		ClassService classService=new ClassServiceImpl();
		return classService.updateclassNameCheck(classPojo);
	}
	
	public ClassPojo editClass(String classCode) {
		ClassService classService=new ClassServiceImpl();
		return classService.editClass(classCode);
	}
	
	public boolean deleteClass(String classCode) {
		ClassService classService=new ClassServiceImpl();
		return classService.deleteClass(classCode);
	}
	
	public boolean updateClass(ClassPojo classPojo) {
		ClassService classService=new ClassServiceImpl();
		return classService.updateClass(classPojo);
	}
	
	public List<ClassPojo> searchClassDetails(String searchText) {
		ClassService classService=new ClassServiceImpl();
		return classService.searchClassDetails(searchText);
	}

}
