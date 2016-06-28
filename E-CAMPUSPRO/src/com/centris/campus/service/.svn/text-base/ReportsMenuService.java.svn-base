package com.centris.campus.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.centris.campus.forms.ReportMenuForm;
import com.centris.campus.pojo.FeeStatusReportPojo;
import com.centris.campus.pojo.MarksPOJO;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.FeeReportDetailsVo;
import com.centris.campus.vo.MarksUploadVO;
import com.centris.campus.vo.ReportMenuVo;
import com.centris.campus.vo.StudentInfoVO;

public interface ReportsMenuService {
	
	public ArrayList<ReportMenuVo> getAccYears();
	public ArrayList<ReportMenuVo> getStream();
	public ArrayList<ReportMenuVo> getClassesByStream(String streamId);
	public ArrayList<ReportMenuVo> getSectionsByClass(String classId);
	public ArrayList<StudentInfoVO> getStudentDetailsReport(ReportMenuForm reform);
	public ReportMenuVo  getSelectedItems(ReportMenuForm reform);
	public HashMap<String, ArrayList<FeeReportDetailsVo>>  getStdFeeStatusReportDetails(ReportMenuForm reform);
	public ArrayList<FeeReportDetailsVo> getStdFeeStatusReportDownload(FeeStatusReportPojo reform);
	public HashMap<String, ArrayList<MarksUploadVO>>  getStdMarksDetails(ReportMenuForm reform);
	public ArrayList<MarksUploadVO>  getStdMarksDetailsDownload(MarksPOJO reform);
	public ArrayList<ExaminationDetailsVo>  examReportClassWiseDetails(ReportMenuForm reform);

}
