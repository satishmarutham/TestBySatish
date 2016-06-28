package com.centris.campus.delegate;

import java.util.ArrayList;
import java.util.HashMap;

import com.centris.campus.forms.ReportMenuForm;
import com.centris.campus.pojo.FeeStatusReportPojo;
import com.centris.campus.pojo.MarksPOJO;
import com.centris.campus.service.ReportsMenuService;
import com.centris.campus.serviceImpl.ReportsMenuServiceImpl;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.FeeReportDetailsVo;
import com.centris.campus.vo.MarksUploadVO;
import com.centris.campus.vo.ReportMenuVo;
import com.centris.campus.vo.StudentInfoVO;


public class ReportsMenuBD {
	
	
	public ArrayList<ReportMenuVo> getAccYears(){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.getAccYears();
		
	}
	
	public ArrayList<ReportMenuVo> getStream(){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.getStream();
		
	}
	
	public ArrayList<ReportMenuVo> getClassesByStream(String streamId){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.getClassesByStream(streamId);
		
	}
	
	public ArrayList<ReportMenuVo> getSectionsByClass(String classId){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.getSectionsByClass(classId);
		
	}
	
	
	public ArrayList<StudentInfoVO> getStudentDetailsReport(ReportMenuForm reform){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.getStudentDetailsReport(reform);
		
	}
	
	public ReportMenuVo  getSelectedItems(ReportMenuForm reform){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.getSelectedItems(reform);
		
	}
	
	public HashMap<String, ArrayList<FeeReportDetailsVo>>  getStdFeeStatusReportDetails(ReportMenuForm reform){
			
			ReportsMenuService reportservice=new ReportsMenuServiceImpl();
			
			return reportservice.getStdFeeStatusReportDetails(reform);
			
		}
	
	public ArrayList<FeeReportDetailsVo>  getStdFeeStatusReportDownload(FeeStatusReportPojo reform){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.getStdFeeStatusReportDownload(reform);
		
	}
	
	public HashMap<String, ArrayList<MarksUploadVO>>  getStdMarksDetails(ReportMenuForm reform){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.getStdMarksDetails(reform);
		
	}
	
	public ArrayList<MarksUploadVO>  getStdMarksDetailsDownload(MarksPOJO reform){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.getStdMarksDetailsDownload(reform);
		
	}
	
	public ArrayList<ExaminationDetailsVo>  examReportClassWiseDetails(ReportMenuForm reform){
		
		ReportsMenuService reportservice=new ReportsMenuServiceImpl();
		
		return reportservice.examReportClassWiseDetails(reform);
		
	}
	
	

}
