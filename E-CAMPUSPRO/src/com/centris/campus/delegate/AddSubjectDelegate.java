package com.centris.campus.delegate;

import java.util.List;

import com.centris.campus.forms.AddSubjectForm;
import com.centris.campus.service.AddSubjectService;
import com.centris.campus.serviceImpl.AddSubjectServiceImpl;
import com.centris.campus.vo.ViewallSubjectsVo;

public class AddSubjectDelegate {

	AddSubjectService service = new AddSubjectServiceImpl();

	public List<ViewallSubjectsVo> subjectdetails() {
		return service.subjectdetails();
	}

	public boolean DeleteSubject(ViewallSubjectsVo voObj) {
		return service.DeleteSubject(voObj);
	}

	public List<ViewallSubjectsVo> searchsubjectdetails(ViewallSubjectsVo voObj) {
		return service.searchsubjectdetails(voObj);
	}

	public boolean addSubject(AddSubjectForm obj) {
		return service.addSubject(obj);
	}

	public ViewallSubjectsVo getSubjectDetails(ViewallSubjectsVo obj) {
		return service.getSubjectDetails(obj);
	}

	public boolean updateSubjectDetails(AddSubjectForm obj) {
		return service.updateSubjectDetails(obj);
	}

	public String getpath(String classname) {
		return service.getpath(classname);
	}

	public String DdownloadsyllabuspathBD(String subjectid) {
		
		return service.DdownloadsyllabuspathService(subjectid);
	}

}
