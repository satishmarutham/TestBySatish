package com.centris.campus.service;

import java.util.ArrayList;

import com.centris.campus.forms.AssignmentUploadForm;
import com.centris.campus.vo.AssignmentUploadVo;

public interface AssignmentUploadService {
	
	public ArrayList<AssignmentUploadVo> getStudentDetails(String section);
	public String insertAssignment(AssignmentUploadForm form,String userId,String accYearString);
	public ArrayList<AssignmentUploadVo> getAssignment(String userId,String accYearString,String searchTerm);
	public ArrayList<AssignmentUploadVo> getAssignmentDetails(String assignmentId);
	public AssignmentUploadVo getSingleAssignment(String assignmentId);
	public String updateAssignmentDetails(AssignmentUploadVo assignmentVo);
	public String deleteAssignment(String assignmentCode);

}
