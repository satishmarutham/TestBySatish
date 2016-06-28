package com.centris.campus.actions;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;
import com.centris.campus.daoImpl.LeaveDetailsReportDaoImpl;
import com.centris.campus.delegate.DepartmentMasterBD;
import com.centris.campus.delegate.LeaveDetailsReportBD;
import com.centris.campus.delegate.ReportsMenuBD;
import com.centris.campus.forms.LeaveDetailsReportForm;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.LeaveReportXLS;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.DepartmentMasterVO;
import com.centris.campus.vo.LeaveDetailsReportVo;
import com.centris.campus.vo.LeaveStatusListVO;
import com.centris.campus.vo.ReportMenuVo;
import com.centris.campus.vo.TeacherVo;



public class LeaveDetailsReportAction extends DispatchAction {


	private static Logger logger = Logger.getLogger(LeaveDetailsReportAction.class);
	
	public ActionForward getLeaveDetailsFilters(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
				
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportAction : getLeaveDetailsFilters Starting");
		
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
	      ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
		  request.setAttribute("AccYearList", accYearList);
		  ArrayList<DepartmentMasterVO> departmentList=new DepartmentMasterBD().getDepartmentDetails();
		  request.setAttribute("DepartmentList", departmentList);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportAction : getLeaveDetailsFilters Ending");
		
		
		return mapping.findForward(MessageConstants.LEAVE_DETAILED_REPORT);
	}
	
	public ActionForward getLeaveDetailsReport(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	{
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportAction : getLeaveDetailsReport Starting");
	
		try{
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_REPORTS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_REPORTS);
			
		LeaveDetailsReportForm detailsReportForm=(LeaveDetailsReportForm)form;
		
		request.setAttribute("AccyearNaame", detailsReportForm.getHaccyear());
		request.setAttribute("Departmentname", detailsReportForm.getHdepartment());
		request.setAttribute("Teachingtype", detailsReportForm.getHteachertype());
		request.setAttribute("TeacherName", detailsReportForm.getHteachername());
		
		 ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
		  request.setAttribute("AccYearList", accYearList);
		  ArrayList<DepartmentMasterVO> departmentList=new DepartmentMasterBD().getDepartmentDetails();
		  request.setAttribute("DepartmentList", departmentList);
			
		
		ArrayList<LeaveDetailsReportVo>	 arrayList=new LeaveDetailsReportBD().getLeaveDetails(detailsReportForm);
		
		ArrayList<LeaveDetailsReportVo>	 LabelList=new LeaveDetailsReportDaoImpl().getLeaveLabelDetails(detailsReportForm);
		
		String filePath = getServlet().getServletContext().getRealPath("")+ "\\MonthReports\\NewLeaveReport.xls";
	        
		
       request.setAttribute("detailsList",arrayList);
        request.getSession(false).setAttribute("detailsListDownload", arrayList);
        
        String accyear = detailsReportForm.getAccyear();
        String teachingtype = detailsReportForm.getTeachingtype();
        String dept = detailsReportForm.getDepartment();
        String teacher = detailsReportForm.getTeachername();
        
        String accyear1 = "";
        String teachingtype1 = "";
        String dept1 = "";
        String teachr1 = "";
  //      ArrayList<LeaveStatusListVO> sl = null;
        
        
       for(int i=0;i<LabelList.size();i++)
       {
    	   accyear1 = LabelList.get(0).getAccyearName();
    	   teachingtype1 = LabelList.get(0).getTeachertype();
    	   dept1 = LabelList.get(0).getDepartmentname();
    	   teachr1 = LabelList.get(0).getTeachername();
    	   
    	   ArrayList<LeaveStatusListVO>  Janlist= arrayList.get(0).getJan();
    	 
    	   ArrayList<LeaveStatusListVO>  Feblist= arrayList.get(0).getFeb();

    	   ArrayList<LeaveStatusListVO>  Marlist= arrayList.get(0).getMar();
    	   
    	   ArrayList<LeaveStatusListVO>  Aprillist= arrayList.get(0).getAprl();


    	   ArrayList<LeaveStatusListVO>  Maylist= arrayList.get(0).getMay();

    	   ArrayList<LeaveStatusListVO>  Junelist= arrayList.get(0).getJune();

    	   ArrayList<LeaveStatusListVO>  Julylist= arrayList.get(0).getJuly();

    	   ArrayList<LeaveStatusListVO>  Auglist= arrayList.get(0).getAug();

    	   ArrayList<LeaveStatusListVO>  seplist= arrayList.get(0).getSep();
    	   
    	   ArrayList<LeaveStatusListVO>  Octlist= arrayList.get(0).getOct();
    	   
    	   ArrayList<LeaveStatusListVO>  Novlist= arrayList.get(0).getNov();

    	   ArrayList<LeaveStatusListVO>  Declist= arrayList.get(0).getDec();
    	
       }
    
       LeaveDetailsReportVo vo = new LeaveDetailsReportVo();
       
       vo.setAccyearId(detailsReportForm.getAccyear());
        
      if("%%".equalsIgnoreCase(teachingtype))
      {
    	  vo.setTeachertype("%%");
    	  
      }else{
    	  
    	  vo.setTeachertype(detailsReportForm.getTeachingtype());
    	 
      }
      
      if("%%".equalsIgnoreCase(dept))
      {
    	  vo.setDepartmentname("All");
    	  vo.setDepartmentid("%%");
    	  
      }else{
    	  
    	  vo.setDepartmentname(dept1);
    	  vo.setDepartmentid(detailsReportForm.getDepartment());
    	  
      }
      
      if("%%".equalsIgnoreCase(teacher))
      {
    	  vo.setTeachername("All");
    	  vo.setTeacherId("%%");
    	  
      }else{
    	  
    	  vo.setTeachername(teachr1);
    	  vo.setTeacherId(detailsReportForm.getTeachername());
    	  
      }
      
     
      request.setAttribute("leavelist", vo);
      
      request.setAttribute("detailsListDownload", arrayList);
		
		LeaveReportXLS excelfile=new LeaveReportXLS();
		excelfile.download(arrayList, filePath);
      
      
        
		
}
		 catch (Exception exception) {
			 logger.error(exception.getMessage(),exception);
		     exception.printStackTrace();
			}
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in  LeaveDetailsReportAction : getLeaveDetailsReport Ending");
			
			
			System.out.println(" Control in LeaveDetailsReportAction : getLeaveDetailsReport Ending");
	
		return mapping.findForward(MessageConstants.LEAVE_DETAILED_REPORT);
		
	}


	
	public ActionForward getTeachername(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
				
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportAction : getTeachername Starting");
		
		
		try {
			
			String department=request.getParameter("department");
			String teachingtype=request.getParameter("teachertype");
			
			ArrayList<TeacherVo> TeacherList=new LeaveDetailsReportBD().getTeachername(teachingtype,department);
		  
			JSONObject object=new JSONObject();
			object.put("TeacherList", TeacherList);
			
			response.getWriter().print(object);
		  
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportAction : getTeachername Ending");
		
		
		return null;
	}
	
	public ActionForward LeaveReportDownloadXLs(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		
		String filePath = getServlet().getServletContext().getRealPath("")
				+ "\\MonthReports\\NewLeaveReport.xls";
		ServletOutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(filePath);
		HttpSession ses = request.getSession();
		
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("content-disposition", "attachment; filename="+ "LeaveReport.xls");

		int octet;
		while ((octet = in.read()) != -1)
			out.write(octet);

		in.close();
		/*out.close();*/
		         
		
		return null;

	}


}
