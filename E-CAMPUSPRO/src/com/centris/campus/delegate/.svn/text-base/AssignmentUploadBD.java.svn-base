package com.centris.campus.delegate;

import java.util.ArrayList;

import com.centris.campus.forms.AssignmentUploadForm;
import com.centris.campus.service.AssignmentUploadService;
import com.centris.campus.serviceImpl.AssignmentUploadServiceImpl;
import com.centris.campus.vo.AssignmentUploadVo;

public class AssignmentUploadBD {
	

	public ArrayList<AssignmentUploadVo> getStudentDetails(String section) {
	
		AssignmentUploadService assignmentService=new AssignmentUploadServiceImpl();
		return assignmentService.getStudentDetails(section);
	}
	
	public String insertAssignment(AssignmentUploadForm form,String userId,String accYearString) {
		
		AssignmentUploadService assignmentService=new AssignmentUploadServiceImpl();
		
		return assignmentService.insertAssignment(form,userId,accYearString);
		
	}
	
	public ArrayList<AssignmentUploadVo> getAssignment(String userId,String accYearString,String searchTerm) {
		
		AssignmentUploadService assignmentService=new AssignmentUploadServiceImpl();
		return assignmentService.getAssignment(userId, accYearString,searchTerm);
	}
	
	public ArrayList<AssignmentUploadVo> getAssignmentDetails(String assignmentId) {
		
		AssignmentUploadService assignmentService=new AssignmentUploadServiceImpl();
		
		return assignmentService.getAssignmentDetails(assignmentId);
	}
	
	public AssignmentUploadVo getSingleAssignment(String assignmentId) {
		
		AssignmentUploadService assignmentService=new AssignmentUploadServiceImpl();
		
		return assignmentService.getSingleAssignment(assignmentId);
	}
	
	public String updateAssignmentDetails(AssignmentUploadVo assignmentVo) {
		
		AssignmentUploadService assignmentService=new AssignmentUploadServiceImpl();
		
		return assignmentService.updateAssignmentDetails(assignmentVo);
	}
	
	public String deleteAssignment(String assignmentCode) {
		
		AssignmentUploadService assignmentService=new AssignmentUploadServiceImpl();
		
		return assignmentService.deleteAssignment(assignmentCode);
	}
	

}
