package com.centris.campus.service;

import java.util.List;

import com.centris.campus.forms.AddSubjectForm;
import com.centris.campus.vo.ViewallSubjectsVo;

public interface AddSubjectService {
	public List<ViewallSubjectsVo> subjectdetails();

	public boolean DeleteSubject(ViewallSubjectsVo voObj);

	public List<ViewallSubjectsVo> searchsubjectdetails(ViewallSubjectsVo voObj);

	public boolean addSubject(AddSubjectForm obj);

	public ViewallSubjectsVo getSubjectDetails(ViewallSubjectsVo obj);

	public boolean updateSubjectDetails(AddSubjectForm obj);

	public String getpath(String classname);

	public String DdownloadsyllabuspathService(String subjectid);

}
