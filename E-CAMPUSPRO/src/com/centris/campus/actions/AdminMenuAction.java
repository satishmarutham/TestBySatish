package com.centris.campus.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.campus.delegate.AcadamicYearPlanBD;
import com.centris.campus.delegate.AddDesignationBD;
import com.centris.campus.delegate.ClassFeeSetupBD;
import com.centris.campus.delegate.ClassTeacherLsisBD;
import com.centris.campus.delegate.ClassTeacherMappingDelegate;
import com.centris.campus.delegate.CommunicationSettingsBD;
import com.centris.campus.delegate.CreateExaminationBD;
import com.centris.campus.delegate.CareersViewdelegate;
import com.centris.campus.delegate.DepartmentMasterBD;
import com.centris.campus.delegate.AcademicYearMasterBD;
import com.centris.campus.delegate.ExamDetailsBD;
import com.centris.campus.delegate.AddSubjectDelegate;
import com.centris.campus.delegate.FeeCollectionBD;
import com.centris.campus.delegate.FeeMasterDelegate;
import com.centris.campus.delegate.FeeSetupBD;
import com.centris.campus.delegate.FuelMasterBD;
import com.centris.campus.delegate.LeaveBankDelegate;
import com.centris.campus.delegate.QuotaMasterBD;
import com.centris.campus.delegate.RemainderMasterDelegate;
import com.centris.campus.delegate.ReportsMenuBD;
import com.centris.campus.delegate.RoleMasterBD;
import com.centris.campus.delegate.SectionBD;
import com.centris.campus.delegate.StaffAttendanceBD;
import com.centris.campus.delegate.StaffPayrollBD;
import com.centris.campus.delegate.StageDelegateBD;
import com.centris.campus.delegate.StageFeeSetupBD;
import com.centris.campus.delegate.StreamDetailsBD;
import com.centris.campus.delegate.StudentEnquiryBD;
import com.centris.campus.delegate.StudentPramotionBD;
import com.centris.campus.delegate.StudentRegistrationDelegate;
import com.centris.campus.delegate.TeacherAttendanceBD;
import com.centris.campus.delegate.TeacherRegistrationBD;
import com.centris.campus.delegate.TermMasterDelegate;
import com.centris.campus.delegate.TimeTableBD;
import com.centris.campus.delegate.TransportBD;
import com.centris.campus.delegate.ClassBD;
import com.centris.campus.delegate.TransportTypeBD;
import com.centris.campus.delegate.UserManagementBD;
import com.centris.campus.delegate.UserRolePermissionBD;
import com.centris.campus.delegate.VehicleDriverMappingBD;
import com.centris.campus.forms.AddDesignation;
import com.centris.campus.forms.ConcessionForm;
import com.centris.campus.forms.CreateExaminationForm;
import com.centris.campus.forms.AddStageForm;
import com.centris.campus.forms.SectionForm;
import com.centris.campus.pojo.AcadamicYearPlanPOJO;
import com.centris.campus.pojo.ClassPojo;
import com.centris.campus.pojo.ConcessionDetailsPojo;
import com.centris.campus.pojo.TransportPojo;
import com.centris.campus.pojo.TransportTypePOJO;
import com.centris.campus.pojo.UserManagementPojo;
import com.centris.campus.pojo.RoleMasterPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.AcadamicYearPlanVO;
import com.centris.campus.vo.AddDesignationVO;
import com.centris.campus.vo.AddStageVO;
import com.centris.campus.vo.AllTeacherDetailsVo;
import com.centris.campus.vo.CareersViewVo;
import com.centris.campus.vo.ClassFeeSetupVo;
import com.centris.campus.vo.ClassTeacherMappingVO;
import com.centris.campus.vo.ClassTeacherVo;
import com.centris.campus.vo.DepartmentMasterVO;
import com.centris.campus.vo.AcademicYearVO;
import com.centris.campus.vo.AddFeeVO;
import com.centris.campus.vo.DriverMasterVO;
import com.centris.campus.vo.DriverMsaterListVo;
import com.centris.campus.vo.FeeCollectionVo;
import com.centris.campus.vo.FuelMaintenanceVO;
import com.centris.campus.vo.ExaminationDetailsVo;
import com.centris.campus.vo.LeaveBankVO;
import com.centris.campus.vo.LstmsUpcomingMeetingVO;
import com.centris.campus.vo.PermissionVO;
import com.centris.campus.vo.QuotaMasterVO;
import com.centris.campus.vo.RemainderMasterVO;
import com.centris.campus.vo.ReportMenuVo;
import com.centris.campus.vo.StaffAttendanceVo;
import com.centris.campus.vo.StaffPayrollListVo;
import com.centris.campus.vo.StageFeeSetupVo;
import com.centris.campus.vo.StreamDetailsVO;
import com.centris.campus.vo.StudentEnquiryVo;
import com.centris.campus.vo.StudentPramotionVO;
import com.centris.campus.vo.StudentRegistrationVo;
import com.centris.campus.vo.TeacherAttendanceStatusVo;
import com.centris.campus.vo.TermMasterVo;
import com.centris.campus.vo.TransportTypeVO;
import com.centris.campus.vo.TransportVo;
import com.centris.campus.vo.UpcomingBdayVo;
import com.centris.campus.vo.UpcomingRemarksVO;
import com.centris.campus.vo.UserRecordVO;
import com.centris.campus.vo.UserRolePermissionVO;
import com.centris.campus.vo.VehicleDetailsVO;
import com.centris.campus.vo.VehicleDriverMappingVo;
import com.centris.campus.vo.ViewallSubjectsVo;

public class AdminMenuAction extends DispatchAction {
	private static final Logger logger = Logger
			.getLogger(AdminMenuAction.class);

	public ActionForward Home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : Home Starting");
		try {

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : Home Ending");

		return mapping.findForward(MessageConstants.adminLogin);
	}

	public ActionForward studentList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentList Starting");
		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

			List<StudentRegistrationVo> List = new StudentRegistrationDelegate().getStudentDetails();

			request.setAttribute(MessageConstants.STUDENTDETAILSLIST, List);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentList Ending");

		return mapping.findForward(MessageConstants.STUDENT_LIST);
	}

	public ActionForward staffList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : staffList Starting");
		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STAFF);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STAFF);

			ArrayList<AllTeacherDetailsVo> list = new ArrayList<AllTeacherDetailsVo>();
			list = new TeacherRegistrationBD().getAllTeacherDetails();
			request.setAttribute("allTeacherDetailsList", list);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : staffList Ending");

		return mapping.findForward(MessageConstants.STAFF_LIST);
	}

	public ActionForward examList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : examList Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_EXAM);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_EXAM);
			
			String searchTerm = request.getParameter("searchTerm");
			
			
			List<ExaminationDetailsVo> examvo = new ArrayList<ExaminationDetailsVo>();
			
			ExamDetailsBD examdeligate = new ExamDetailsBD();

			if (searchTerm != null) {

			 examvo = new CreateExaminationBD().searchExamination(searchTerm);

				request.setAttribute("searchexamlist", searchTerm);
			} else {

				
				examvo = examdeligate.getexamdeligate();
				
			}

			

			request.setAttribute("examDetailsList", examvo);


		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : examList Ending");

		return mapping.findForward(MessageConstants.EXAM_LIST);
	}

	public ActionForward streamList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : streamList Starting");
		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			StreamDetailsBD obj = new StreamDetailsBD();
			List<StreamDetailsVO> list = new ArrayList<StreamDetailsVO>();
			
			String SearchName = request.getParameter("searchname");
			
			
			if(SearchName != null){
				
			
				
				list=obj.searchStreamDetailsBD(SearchName);
				request.setAttribute("searchname", SearchName);
				request.setAttribute("searchnamelist", SearchName);
				
				
				
			}
			else{
				
			 list =obj.getStreamDetailsBD();
				
			}
			
			request.setAttribute("streamDetailsList", list);
			
			

			/*request.getSession(false).setAttribute("EXcelDownLoad",list);*/

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : streamList Ending");

		return mapping.findForward(MessageConstants.STREAM_LIST);
	}

	public ActionForward termList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : termList Starting");

		String status = request.getParameter("result");

		if (status != null) {

			if (status.equalsIgnoreCase(MessageConstants.TERM_SUCCESS)) {

				request.setAttribute("successmessagediv",
						MessageConstants.TERM_SUCCESS);
			}
		}

		String name = request.getParameter("searchvalue");

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);

			TermMasterVo vo = new TermMasterVo();

			vo.setTermname(name);
			
			request.setAttribute("searchterm", request.getParameter("searchvalue"));


			ArrayList<TermMasterVo> termlist = new TermMasterDelegate()
					.termList(vo);
			request.setAttribute("termlist", termlist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : termList Ending");

		return mapping.findForward(MessageConstants.TERM_LIST);
	}

	public ActionForward addStudent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : addStudent Starting");
		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : addStudent Ending");

		return mapping.findForward(MessageConstants.ADD_STUDENT);
	}

	public ActionForward departmentDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : departmentDetails Starting");

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			ArrayList<DepartmentMasterVO> deplist = new ArrayList<DepartmentMasterVO>();
				
			
			
			String SearchName = request.getParameter("searchname");
			

			DepartmentMasterVO searchvo = new DepartmentMasterVO();
			searchvo.setSearch_name(SearchName);
			
			
			if(SearchName != null){
				
				
				deplist = new DepartmentMasterBD().searchDepartment(searchvo);
				request.setAttribute("DepartmentDetails", deplist);
				request.setAttribute("searchnamelist", SearchName);
			}
			else
			{
				 deplist = new DepartmentMasterBD().getDepartmentDetails();
				
			}
				
			
			request.setAttribute("DepartmentDetails", deplist);
			request.getSession(false).setAttribute("EXcelDownLoad", deplist);

		}

		catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : departmentDetails Ending");

		return mapping.findForward(MessageConstants.DEPARTMENT_DETAILS);

	}

	public ActionForward classList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : classList Starting");
		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);
			
			String Message = request.getParameter("msg");
			
			List<ClassPojo> classList = new ArrayList<ClassPojo>();
			
			ClassBD delegate = new ClassBD();
			

			
			String searchTextVal = request.getParameter("searchname");
			
			
			if(searchTextVal != null){
				
				
				classList = delegate.searchClassDetails(searchTextVal);
				request.setAttribute("searchnamelist", searchTextVal);
				
			}
			else{
				
				classList = delegate.getClassDetails();
				
			}
			
			request.setAttribute("classList", classList);
			request.setAttribute("successmessagediv", Message);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : classList Ending");

		return mapping.findForward(MessageConstants.CLASS_LIST);
	}

	public ActionForward academicyear(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : academicyear Starting");
		try {

			ArrayList<AcademicYearVO> editacademicyearlist = null;

			String searchTerm = request.getParameter("searhval");

			if (searchTerm != null) {

				editacademicyearlist = new AcademicYearMasterBD()
						.searchAcademicYearDetails(searchTerm);
				
				
				request.setAttribute("searchnamelist", searchTerm);
				
			} else {
				editacademicyearlist = new AcademicYearMasterBD()
						.getAcademicYearDetails();

			}

			request.setAttribute("academicyearlist", editacademicyearlist);

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : academicyear Ending");

		return mapping.findForward(MessageConstants.ACADEMIC_YEAR);
	}

	public ActionForward vehicleList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : vehicleList Starting");
		try {
			String Message = request.getParameter("message");
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			ArrayList<VehicleDetailsVO> getvehiclelist = new TransportBD()
					.getAllvehicleDetails();
			request.setAttribute("getvehiclelist", getvehiclelist);
			request.getSession(false).setAttribute("vehiclelistdownload",
					getvehiclelist);

			request.setAttribute("successmessagediv", Message);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : vehicleList Ending");

		return mapping.findForward(MessageConstants.VEHICLE_LIST);
	}

	public ActionForward roleList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : roleList Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			List<RoleMasterPojo> roleMasterList = new ArrayList<RoleMasterPojo>();

			String searchTerm = request.getParameter("searchTerm");
			RoleMasterBD masterBD = new RoleMasterBD();

			if (searchTerm != null) {

				roleMasterList = masterBD.searchRole(searchTerm);

			
				
				request.setAttribute("searchnamelist", searchTerm);
				

			} else {

				roleMasterList = masterBD.getRoles();

			}

			request.setAttribute("roleMasterList", roleMasterList);
			/*request.getSession(false).setAttribute("EXcelDownLoad",
					roleMasterList);*/

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : roleList Ending");

		return mapping.findForward(MessageConstants.ROLE_LIST);
	}

	public ActionForward getUserRecords(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: getUserRecords Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			List<UserRecordVO> userRecords = new ArrayList<UserRecordVO>();

			String searchText = request.getParameter("searchText");
			String type = request.getParameter("type");

			
			if (searchText != null && type != null) {

				UserManagementPojo userManagementPojo = new UserManagementPojo();
				userManagementPojo.setType(type);
				userManagementPojo.setSearchtext(searchText);

				userRecords = new UserManagementBD()
						.getSearchUserDetailsBD(userManagementPojo);
				
				
				request.setAttribute("SearchText", searchText);
				
				request.setAttribute("SearchText", searchText);
				
				request.setAttribute("Type", type);

			} else {

				userRecords = new UserManagementBD().getUserRecordsBD();
				
				
			

			}

			request.setAttribute("userRecords", userRecords);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: getUserRecords Ending");

		return mapping.findForward(MessageConstants.USERRECORD);

	}

	public ActionForward sectionList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: sectionList Starting");
		
		String user = HelperClass.getCurrentUser(request);
		
		try {

			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);
			
		
			List<SectionForm> ClassSectionAndClassDetailsList = new ArrayList<SectionForm>();

			List<SectionForm> classDetailsIDandClassDetailsNameList = new ArrayList<SectionForm>();
			String Message = request.getParameter("msg");
		
			SectionBD sectionDelegate = new SectionBD();

			classDetailsIDandClassDetailsNameList = sectionDelegate
					.getCampusClassDetailsIDandClassDetailsNameBD();
			
			
			SectionForm secForm = new SectionForm();
			SectionBD bd = new SectionBD();
			
			String searchTextVal = request.getParameter("searchText");
			secForm.setSectionName(searchTextVal);
			
			
			
			if(searchTextVal != null){
				
				
				ClassSectionAndClassDetailsList =  bd.searchSection(secForm);
				
				request.setAttribute("searchnamelist", searchTextVal);
				
				
			}
			else{
				
				
				ClassSectionAndClassDetailsList = sectionDelegate.getCampusClassSectionAndClassDetailsBD();
			}
			
			
			
			request.setAttribute("classDetailsIDandClassDetailsNameList",
					classDetailsIDandClassDetailsNameList);
			
			// for list
			request.setAttribute("ClassSectionAndClassDetailsList",
					ClassSectionAndClassDetailsList);
			
			
			/*request.getSession(false).setAttribute("EXcelDownLoad",
					ClassSectionAndClassDetailsList);*/
			
			request.setAttribute("successmessagediv", Message);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: sectionList Ending");

		return mapping.findForward(MessageConstants.SECTION_LIST);
	}

	public ActionForward feeList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : feeList Starting");
		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : feeList Ending");

		return mapping.findForward(MessageConstants.FEE_LIST);
	}

	// Download need to do
	public ActionForward feeDetailsList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String status = request.getParameter("result");

		if (status != null) {

			if (status.equalsIgnoreCase("true")) {

				request.setAttribute("successmessagediv",
						MessageConstants.DeleteMsg);
			} else {

				request.setAttribute("errormessagediv",
						MessageConstants.DeleteErrorMsg);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : feeDetailsList Starting");
		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);
			AddFeeVO vo = new AddFeeVO();
			
			vo.setName(request.getParameter("searchvalue"));
			
			request.setAttribute("searchfee", request.getParameter("searchvalue"));
			
			ArrayList<AddFeeVO> feelist = new FeeMasterDelegate()
					.getfeedetails(vo);
			request.setAttribute("feelist", feelist);
			// for downloading

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : feeDetailsList Ending");

		return mapping.findForward(MessageConstants.FEE_DETAILS_LIST);
	}

	public ActionForward transportTypeHome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : transportTypeHome Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);

			ArrayList<TransportTypeVO> typeList = new ArrayList<TransportTypeVO>();

			String searchTerm = request.getParameter("searchTerm");

			if (searchTerm != null) {

				TransportTypePOJO transportTypePOJO = new TransportTypePOJO();
				transportTypePOJO.setSearchtext(searchTerm);

				typeList = new TransportTypeBD()
						.getSearchDetails(transportTypePOJO);
				request.setAttribute("searchtransporttype", searchTerm);

			} else {

				typeList = new TransportTypeBD().getAllTransportypeDetails();
			}

			request.setAttribute("typelist", typeList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : transportTypeHome Ending");

		return mapping.findForward(MessageConstants.TRANSPORT_TYPELIST);
	}

	public ActionForward addStream(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : addStream Starting");

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : addStream Ending");

		return mapping.findForward(MessageConstants.ADD_STREAM);
	}

	public ActionForward createExam(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : createExam Starting");

		String status = request.getParameter("result");

		if (status != null) {

			if (status.equalsIgnoreCase("Exam Created Successfully")) {

				request.setAttribute("successmessagediv",
						"Exam Created Successfully");
			}
		}

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_EXAM);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_EXAM);

			CreateExaminationForm examform = new CreateExaminationForm();

			List<Object> examnameslist = null;
			String accyear = examform.getAccyear();

			examnameslist = new CreateExaminationBD().getAllExamNames(examform);

			Map<String, String> map = (Map<String, String>) new CreateExaminationBD()
					.getAccadamicYearsBD();

			request.setAttribute("ALLACCYEARS", map);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : createExam Ending");

		return mapping.findForward(MessageConstants.EXAM_CREATION);

	}

	public ActionForward QuotaDetails(ActionMapping mapping, ActionForm form,

	HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : QuotaDetails Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			ArrayList<QuotaMasterVO> quota_list = new ArrayList<QuotaMasterVO>();
				

			
			QuotaMasterVO searchvo = new QuotaMasterVO();
			String SearchName = request.getParameter("searchname");
			
			
			
			searchvo.setSearch_name(SearchName);
			
			if(SearchName != null){
				
				quota_list = new QuotaMasterBD().searchQuota(searchvo);
				request.setAttribute("searchdetails", SearchName);
				
				request.setAttribute("searchnamelist", SearchName);
			}
			else{
				
				
				
				 quota_list = new QuotaMasterBD().getQuotaDetails();
			}
			
			
			
			
			
			
			
			
			
			request.setAttribute("Quotalist", quota_list);
			/*request.getSession(false).setAttribute("EXcelDownLoad", quota_list);*/
		}

		catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : QuotaDetails Ending");

		return mapping.findForward(MessageConstants.QUOTA_DETAILS);

	}

	public ActionForward designationList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : designationList Starting");

		String result = request.getParameter("value");

		if (result != null) {

			if (result.equalsIgnoreCase(MessageConstants.DESIGNATION_SUCCESS)) {

				request.setAttribute("successmessagediv",
						MessageConstants.DESIGNATION_SUCCESS);
			}

		}

		String result1 = request.getParameter("result");

		if (result1 != null) {

			if (result1
					.equalsIgnoreCase(MessageConstants.ADD_DESIGNATION_SUCCESS)) {

				request.setAttribute("successmessagediv",
						MessageConstants.ADD_DESIGNATION_SUCCESS);
			} else if ((result1
					.equalsIgnoreCase(MessageConstants.ADD_DESIGNATION_FAIL))) {

				request.setAttribute("errormessagediv",
						MessageConstants.ADD_DESIGNATION_FAIL);
			} else if (result1
					.equalsIgnoreCase(MessageConstants.UPDATE_DESIGNATION_SUCCESS)) {
				request.setAttribute("successmessagediv",
						MessageConstants.UPDATE_DESIGNATION_SUCCESS);
			} else if (result1
					.equalsIgnoreCase(MessageConstants.UPDATE_DESIGNATION_FAIL)) {
				request.setAttribute("successmessagediv",
						MessageConstants.UPDATE_DESIGNATION_FAIL);
			}

		}
		String username = null;

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			username = HelperClass.getCurrentUserID(request);

			AddDesignationVO vo = new AddDesignationVO();

			vo.setDesgname(request.getParameter("searchvalue"));

			ArrayList<AddDesignationVO> list = new AddDesignationBD()
					.DesignationDetails(vo);

			request.setAttribute("DesignationDetails", list);

			request.getSession(false).setAttribute("EXcel", list);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : designationList Ending");

		return mapping.findForward(MessageConstants.DESIGNATION_LIST);
	}

	public ActionForward adddesignation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : adddesignation");

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : adddesignation");

		return mapping.findForward(MessageConstants.ADD_DESIGNATION);
	}

	public ActionForward submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : submit Starting");

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			AddDesignation aform = new AddDesignation();

			aform.setDesignation_name(request.getParameter("name"));
			aform.setDesignation_description(request
					.getParameter("description"));
			aform.setDesignationid(request.getParameter("id"));
			aform.setCreatedby(HelperClass.getCurrentUserID(request));

			String name = request.getParameter("name");

			String description = request.getParameter("description");

			String createUser = HelperClass.getCurrentUserID(request);

			String id = request.getParameter("id");

			String delegate = new AddDesignationBD()
					.insertDesignationDetails(aform);

			JSONObject jsonobj = new JSONObject();

			jsonobj.put("jsonResponse", delegate);

			response.getWriter().print(jsonobj);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : submit Ending");

		return null;

	}

	public ActionForward careerupdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: careerupdate Starting");

		CareersViewdelegate careerview;
		try {
			List<CareersViewVo> career = new ArrayList<CareersViewVo>();

			careerview = new CareersViewdelegate();

			String searchTerm = request.getParameter("searhval");

			if (searchTerm != null) {

				career = careerview.searchDetails(searchTerm);
				request.setAttribute("searchnamelist", searchTerm);
				
			} else {
				career = careerview.getAllcareerdetails();
			}
			request.setAttribute("career", career);
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: careerupdate Ending");

		return mapping.findForward(MessageConstants.UPDATE_CAREERS);

	}

	public ActionForward addJob(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: addJob Starting");

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: addJob Ending");

		return mapping.findForward(MessageConstants.ADDJOB);

	}

	public ActionForward remainderdetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: remainderdetails Starting");

		String status = request.getParameter("result");

		if (status != null) {

			if (status.equalsIgnoreCase(MessageConstants.REM_SUCCESS)) {

				request.setAttribute("successmessagediv",
						MessageConstants.REM_SUCCESS);
			}
		}

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			RemainderMasterVO vo = new RemainderMasterVO();

			vo.setName(request.getParameter("searchvalue"));

			ArrayList<RemainderMasterVO> remainderlist = new RemainderMasterDelegate().remainderdetails(vo);
			request.setAttribute("remainderlist", remainderlist);
			
			
			request.setAttribute("searchremainder", request.getParameter("searchvalue"));
			

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: remainderdetails Ending");

		return mapping.findForward(MessageConstants.REMAINDER_DETAILS);

	}

	public ActionForward acdamicYearPlanList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : acdamicYearPlanList Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			ArrayList<AcadamicYearPlanVO> eventlist = new ArrayList<AcadamicYearPlanVO>();

			String searchTerm = request.getParameter("searchTerm");

			if (searchTerm != null) {

				AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
				acadamicYearPlanPOJO.setSerachText(searchTerm);
				acadamicYearPlanPOJO.setAcadamicYear(request.getSession(false)
						.getAttribute("current_academicYear").toString());

				eventlist = new AcadamicYearPlanBD()
						.getSearchDetails(acadamicYearPlanPOJO);
				request.setAttribute("searchTerm", searchTerm);
				
				
				
				request.setAttribute("searchnamelist", searchTerm);
				
				

			} else {

				AcadamicYearPlanPOJO acadamicYearPlanPOJO = new AcadamicYearPlanPOJO();
				acadamicYearPlanPOJO.setAcadamicYear(request.getSession(false)
						.getAttribute("current_academicYear").toString());

				eventlist = new AcadamicYearPlanBD()
						.getAllEventDetails(acadamicYearPlanPOJO);
				
				
				
			}

			request.setAttribute("AcadamicYearPlanList", eventlist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : acdamicYearPlanList Ending");

		return mapping.findForward(MessageConstants.ACADAMICYEAR_PLANlIST);
	}

	public ActionForward fuelMaintenance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: fuelMaintenance Starting");

		String status = request.getParameter("result");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			List<FuelMaintenanceVO> fuelList = new FuelMasterBD()
					.getfuelMaintenanceList();
			request.setAttribute("fuelList", fuelList);

			if (status != null) {

				if (status
						.equalsIgnoreCase(MessageConstants.DELETE_FUEL_MAINTENANCE_SUCCESS)) {

					request.setAttribute("successmessagediv",
							MessageConstants.DELETE_FUEL_MAINTENANCE_SUCCESS);
				}

			}

		}

		catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: fuelMaintenance Ending");

		return mapping.findForward(MessageConstants.FUEL_MAINTENANCE);

	}

	public ActionForward routeMasterSettings(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: routeMasterSettings settings");

		try

		{
			List<TransportVo> getTpMasterDetails = null;

			TransportPojo pojo = new TransportPojo();

			pojo.setRouteName(request.getParameter("searhval"));
			if (pojo.getRouteName() != null) {

				getTpMasterDetails = new TransportBD().searchDetails(pojo);
			} else {

				getTpMasterDetails = new TransportBD()
						.getTransportMasterDetails();
			}

			request.setAttribute("getTpMasterDetails", getTpMasterDetails);
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: routeMasterSettings Ending");

		return mapping.findForward(MessageConstants.TRANSPORTMASTER);
	}

	public ActionForward StageList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : designationList Starting");

		String result = request.getParameter("value");

		if (result != null) {

			if (result.equalsIgnoreCase(MessageConstants.STAGE_SUCCESS)) {

				request.setAttribute("successmessagediv",
						MessageConstants.STAGE_SUCCESS);
			}

		}

		String username = null;
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			username = HelperClass.getCurrentUserID(request);

			AddStageVO vo = new AddStageVO();

			
			
			vo.setStageName(request.getParameter("searchvalue"));

			ArrayList<AddStageVO> list = new StageDelegateBD().StageDetails(vo);

			request.setAttribute("StageDetails", list);
			request.setAttribute("searchnamelist", request.getParameter("searchvalue"));
			/*request.getSession(false).setAttribute("EXcel", list);*/

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : designationList Ending");

		return mapping.findForward(MessageConstants.STAGE_LIST);
	}

	public ActionForward addstage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : adddesignation");

		String result = request.getParameter("result");

		if (result != null) {

			if (result.equalsIgnoreCase(MessageConstants.ADD_STAGE_SUCCESS)) {

				request.setAttribute("successmessagediv",
						MessageConstants.ADD_STAGE_SUCCESS);
			} else if ((result
					.equalsIgnoreCase(MessageConstants.ADD_STAGE_FAIL))) {

				request.setAttribute("errormessagediv",
						MessageConstants.ADD_STAGE_FAIL);
			} else if (result
					.equalsIgnoreCase(MessageConstants.UPDATE_STAGE_SUCCESS)) {
				request.setAttribute("successmessagediv",
						MessageConstants.UPDATE_STAGE_SUCCESS);
			} else if (result
					.equalsIgnoreCase(MessageConstants.UPDATE_STAGE_FAIL)) {
				request.setAttribute("successmessagediv",
						MessageConstants.UPDATE_STAGE_FAIL);
			}

		}

		try {
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : adddesignation");

		return mapping.findForward(MessageConstants.ADD_STAGE);
	}

	public ActionForward savestage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StageAction : submit Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			AddStageForm aform = new AddStageForm();

			aform.setStage_name(request.getParameter("name"));
			aform.setStage_description(request.getParameter("description"));
			aform.setStageid(request.getParameter("id"));
			aform.setCreatedby(HelperClass.getCurrentUserID(request));

			String name = request.getParameter("name");

			String description = request.getParameter("description");

			String createUser = HelperClass.getCurrentUserID(request);

			String id = request.getParameter("id");

			String delegate = new StageDelegateBD().insertStage(aform);

			JSONObject jsonobj = new JSONObject();

			jsonobj.put("jsonResponse", delegate);

			response.getWriter().print(jsonobj);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StageAction : submit Ending");

		return null;

	}

	public ActionForward getUserRolePermission(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getUserRolePermission Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			request.getSession(false).setAttribute("RolePermission",
					new UserRolePermissionBD().getUserRolePermission());
			UserRolePermissionVO VO = new UserRolePermissionBD()
					.getUserRolePermission();

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: getUserRolePermission Ending");

		return mapping.findForward(MessageConstants.USER_ROLE_PERMISSIONS);
	}

	public ActionForward subjectdetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : subjectdetails Starting");

		try {

			String message = request.getParameter("message");
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			List<ViewallSubjectsVo> subjectlist = new ArrayList<ViewallSubjectsVo>();

			String searchTerm = request.getParameter("searchname");
			ViewallSubjectsVo obj = new ViewallSubjectsVo();
			obj.setSearchName(searchTerm);

			if (searchTerm != null) {

				subjectlist = new AddSubjectDelegate()
						.searchsubjectdetails(obj);

				request.setAttribute("searchTerm", searchTerm);

			} else {

				subjectlist = new AddSubjectDelegate().subjectdetails();

			}

			request.setAttribute("allsubjects", subjectlist);
			
			
			request.setAttribute("successmessagediv", message);

			
			request.getSession(false).setAttribute("EXcelDownLoad",subjectlist);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : roleList Ending");

		return mapping.findForward(MessageConstants.SUBJECT_LIST);
	}

	public ActionForward teachermapping(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception

	{

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: teachermapping Starting");

		request.setAttribute(MessageConstants.MODULE_NAME,
				MessageConstants.BACKOFFICE_ADMIN);
		request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
				MessageConstants.MODULE_ADMIN);

		String status = request.getParameter("result");
		if (status != null) {

			if (status.equalsIgnoreCase(MessageConstants.DEL_MAP_SUCCESS)) {

				request.setAttribute("successmessagediv",
						MessageConstants.DEL_MAP_SUCCESS);
			}
		}

		ClassTeacherMappingVO vo = new ClassTeacherMappingVO();

		ArrayList<ClassTeacherMappingVO> getDownloadDetails = new ClassTeacherMappingDelegate()
				.getDownloadDetails(vo);

		LinkedHashMap<String, ArrayList<ClassTeacherMappingVO>> mappinglist = new ClassTeacherMappingDelegate()
				.getclassdetails(vo);

		JSONArray arralist = new JSONArray();
		arralist.put(mappinglist);

		request.setAttribute("mappinglist", mappinglist);

		request.getSession(false).setAttribute("Exceldownload",
				getDownloadDetails);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: teachermapping Ending");

		return mapping.findForward(MessageConstants.TEACHERMAPPING);

	}

	public ActionForward getVehicleDriverMapping(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getVehicleDriverMapping Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			String searchTerm = request.getParameter("searchTerm");

			ArrayList<VehicleDriverMappingVo> vehicleDriverMapList = new ArrayList<VehicleDriverMappingVo>();

			if (searchTerm == null || "".equalsIgnoreCase(searchTerm)) {

				vehicleDriverMapList = new VehicleDriverMappingBD()
						.getVehicleDriverMappingList();

			} else {

				vehicleDriverMapList = new VehicleDriverMappingBD()
						.getSearchVehicleDriverMappingList(searchTerm);

			}

			request.setAttribute("SerchTerm", searchTerm);

			request.setAttribute("VehicleDriverMapList", vehicleDriverMapList);

			JSONArray array = new JSONArray();
			array.put(vehicleDriverMapList);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getVehicleDriverMapping Ending");

		return mapping.findForward(MessageConstants.vehicle_driver_mapping);
	}

	public ActionForward driverList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : driverList Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TRANSPORT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TRANSPORT);

			List<DriverMsaterListVo> driverList = new TransportBD()
					.getdriverList();

			request.setAttribute("driverList", driverList);

			request.getSession(false).setAttribute("DownLoad", driverList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : driverList Ending");

		return mapping.findForward(MessageConstants.driver_list);

	}

	public ActionForward driverget(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : driverget Starting");

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : driverget Ending");

		return mapping.findForward(MessageConstants.ADD_DRIVER_DETAILS);

	}

	public ActionForward getClassFeeSetup(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getClassFeeSetup Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);

			System.out.println(request.getSession(false)
					.getAttribute("current_academicYear").toString());
			String currentaccyear = request.getSession(false)
					.getAttribute("current_academicYear").toString();
			String searchTerm = request.getParameter("searchTerm");

			ArrayList<ClassFeeSetupVo> classSetupList = new ArrayList<ClassFeeSetupVo>();

			if (searchTerm == null || "".equalsIgnoreCase(searchTerm)) {

				classSetupList = new ClassFeeSetupBD()
						.getFeeSetupDetails(currentaccyear);

			} else {

				classSetupList = new ClassFeeSetupBD()
						.getSearchFeeSetupDetails(searchTerm, currentaccyear);

			}

			request.setAttribute("classfeesetupSerchTerm", searchTerm);

			request.setAttribute("classSetupList", classSetupList);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getClassFeeSetup Ending");

		return mapping.findForward(MessageConstants.CLASS_FEE_SETUP);
	}
 
	public ActionForward getStageFeeSetup(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getStageFeeSetup Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);

			String currentaccyear = request.getSession(false)
					.getAttribute("current_academicYear").toString();
			String searchTerm = request.getParameter("searchTerm");

			ArrayList<StageFeeSetupVo> classSetupList = new ArrayList<StageFeeSetupVo>();

			if (searchTerm == null || "".equalsIgnoreCase(searchTerm)) {

				classSetupList = new StageFeeSetupBD()
						.getStageFeeSetupDetails(currentaccyear);

			} else {

				classSetupList = new StageFeeSetupBD()
						.getSearchStageFeeSetupDetails(searchTerm,
								currentaccyear);

			}
			request.setAttribute("SerchTermstagesetup", searchTerm);
			request.setAttribute("classSetupList", classSetupList);

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getStageFeeSetup Ending");

		return mapping.findForward(MessageConstants.STAGE_FEE_SETUP);
	}

	public ActionForward communicationRemarksList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : communicationRemarksList Starting");

		request.setAttribute(MessageConstants.MODULE_NAME,
				MessageConstants.BACKOFFICE_SETTINGS);
		request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
				MessageConstants.MODULE_SETTINGS);

		ArrayList<UpcomingRemarksVO> remarkslist = new CommunicationSettingsBD()
				.getRemarksListDetails();

		request.setAttribute("remarkslist", remarkslist);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : communicationRemarksList Ending");

		return mapping.findForward(MessageConstants.REMARKS_LIST);

	}

	public ActionForward feeCollection(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : feeCollection Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);

			request.setAttribute("ClassList", new ClassBD().getClassDetails());
			String currentYear = request.getSession(false)
					.getAttribute("current_academicYear").toString();

			ArrayList<FeeCollectionVo> feeCollectionList = null;

			String classId = request.getParameter("classId");
			String sectionId = request.getParameter("sectionId");

			if (classId != null) {

				feeCollectionList = new FeeCollectionBD()
						.getSearchFeeCollectionDetails(currentYear, classId,
								sectionId);

				request.setAttribute("ClassId", classId);
				request.setAttribute("SectionId", sectionId);

			} else {

				feeCollectionList = new FeeCollectionBD()
						.getFeeCollectionDetails(currentYear);
			}

			request.setAttribute("FeeCollectionList", feeCollectionList);
			request.getSession(false).setAttribute("downloadfeecollection",
					feeCollectionList);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : feeCollection Ending");

		return mapping.findForward(MessageConstants.FEE_COLLECTION_LIST);

	}

	public ActionForward payRollList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : payRollList Starting");

		/*
		 * request.setAttribute(MessageConstants.MODULE_NAME,
		 * MessageConstants.BACKOFFICE_FEE);
		 * 
		 * request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
		 * MessageConstants.MODULE_FEE);
		 */
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : payRollList Ending");

		return mapping.findForward(MessageConstants.PAYROLL);

	}

	public ActionForward getStaffAttendance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getStaffAttendance Starting");

		try {

			String startdate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");

			ArrayList<StaffAttendanceVo> staffAttendanceList = new StaffAttendanceBD().getStaffAttendanceList(startdate,endDate);

			request.setAttribute("attendancelist", staffAttendanceList);
			request.setAttribute("StartDate", startdate);
			request.setAttribute("EndDate", endDate);
			

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getStaffAttendance Ending");
		return mapping.findForward(MessageConstants.StaffAttendance);

	}

	public ActionForward gettimetable(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getTimeTable Starting");

		try {
			String viewBy = request.getParameter("viewBy");

			String accyearid = request.getSession(false)
					.getAttribute("current_academicYear").toString();

			if (viewBy != null) {
				if (viewBy.equalsIgnoreCase("class")) {

					request.setAttribute("ClassTimeTableList",
							new TimeTableBD().getClassTimeTableList(accyearid,
									viewBy));

				} else {

					request.setAttribute("TeacherTimeTableList",
							new TimeTableBD().getClassTimeTableList(accyearid,
									viewBy));
				}

				request.setAttribute("ViewBy", viewBy);

			} else {

				viewBy = "class";
				request.setAttribute("ClassTimeTableList", new TimeTableBD()
						.getClassTimeTableList(accyearid, viewBy));
			}

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getTimeTable Ending");

		return mapping.findForward(MessageConstants.timetable);

	}

	public ActionForward studentPromotionList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentPromotionscreen Starting");
		try {

			ArrayList<StudentPramotionVO> StudentPramotionlist = new StudentPramotionBD()
					.getpromotionslist();

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

			request.setAttribute("StudentPramotionlist", StudentPramotionlist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentPromotionscreen Ending");

		return mapping.findForward(MessageConstants.STUDENTPROMOTION);
	}

	public ActionForward studentPromotionscreen(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentPromotionscreen Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentPromotionscreen Ending");

		return mapping.findForward(MessageConstants.STUDENTPROMOTIONSCREEN);
	}

	public ActionForward studentPromotionscreenedit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentPromotionscreenedit Starting");
		try {
			String status = "status";
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TEACHERS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);
			request.setAttribute("status", status);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentPromotionscreenedit Ending");

		return mapping.findForward(MessageConstants.STUDENTPROMOTIONSCREEN);
	}

	public ActionForward studentEnquiryList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentEnquiryList Starting");
		StudentEnquiryBD delegateObj = new StudentEnquiryBD();
		List<StudentEnquiryVo> allDetails = new ArrayList<StudentEnquiryVo>();
		try {
			String text = request.getParameter("Code");
			if (text == "" || text == null) {
				allDetails = delegateObj.getAllEnquiryDetails();
			} else {
				allDetails = delegateObj.getSearchEnquiryDetails(text);
			}

			request.setAttribute("EnquiryDetails", allDetails);
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : studentEnquiryList Ending");

		return mapping.findForward(MessageConstants.STUDENTENQUIRY);
	}

	public ActionForward enquiryCreateScreen(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : enquiryCreateScreen Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STUDENT);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STUDENT);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : enquiryCreateScreen Ending");

		return mapping.findForward(MessageConstants.STUDENTENQUIRYCREATE);
	}

	public ActionForward enquiryCreateScreenedit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : enquiryCreateScreenedit Starting");
		try {
			String status = "status";
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_TEACHERS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);
			request.setAttribute("status", status);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : enquiryCreateScreenedit Ending");

		return mapping.findForward(MessageConstants.STUDENTENQUIRYCREATE);
	}

	public ActionForward FeeconcessionDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : enquiryCreateScreenedit Starting");
		try {

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : enquiryCreateScreenedit Ending");

		return mapping.findForward(MessageConstants.STUDENTENQUIRYCREATE);
	}

	public ActionForward FeeConcessionList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : FeeConcessionDetails Starting");

		String result = request.getParameter("value");

		if (result != null) {

			if (result
					.equalsIgnoreCase(MessageConstants.FEE_CONCSEEION_SUCCESS)) {

				request.setAttribute("successmessagediv",
						MessageConstants.FEE_CONCSEEION_SUCCESS);
			}

		}

		String result1 = request.getParameter("result");

		if (result1 != null) {

			if (result1
					.equalsIgnoreCase(MessageConstants.ADD_FEE_CONCSEEION_SUCCESS)) {

				request.setAttribute("successmessagediv",
						MessageConstants.ADD_FEE_CONCSEEION_SUCCESS);
			} else if ((result1
					.equalsIgnoreCase(MessageConstants.ADD_FEE_CONCSEEION_FAIL))) {

				request.setAttribute("errormessagediv",
						MessageConstants.ADD_FEE_CONCSEEION_FAIL);
			} else if (result1
					.equalsIgnoreCase(MessageConstants.UPDATE_FEE_CONCSEEION_SUCCESS)) {
				request.setAttribute("successmessagediv",
						MessageConstants.UPDATE_FEE_CONCSEEION_SUCCESS);
			} else if (result1
					.equalsIgnoreCase(MessageConstants.UPDATE_FEE_CONCSEEION_FAIL)) {
				request.setAttribute("successmessagediv",
						MessageConstants.UPDATE_FEE_CONCSEEION_FAIL);
			}

		}
		String username = null;

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);

			username = HelperClass.getCurrentUserID(request);

			ConcessionDetailsPojo vo = new ConcessionDetailsPojo();

			vo.setConcessionName(request.getParameter("searchvalue"));

			List<ConcessionDetailsPojo> list = new FeeSetupBD()
					.getconcessiondetails(vo);
			
			request.setAttribute("concessiondetailsearch", request.getParameter("searchvalue"));


			request.setAttribute("concessiondetailsList", list);


		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : FeeConcessionDetails Ending");

		return mapping.findForward(MessageConstants.FEE_CONCESSION_LIST);
	}

	
	public ActionForward addfeeconcession(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : addfeeconcession");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : addfeeconcession");

		return mapping.findForward(MessageConstants.ADD_FEE_CONCESSION);
	}

	public ActionForward insertConcesssionDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupAction : insertConcesssionDetails  Starting");

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_FEE);

			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_FEE);
			ConcessionForm detailsForm = new ConcessionForm();

			String createCode = HelperClass.getCurrentUserID(request);

			String concessionName = request.getParameter("concessionname");
			String percentage = request.getParameter("percentage");
			String description = request.getParameter("description");
			String concessionId = request.getParameter("concessionId");

			detailsForm.setConcesionName(concessionName);
			detailsForm.setDescription(description);
			detailsForm.setCreateUser(createCode);
			detailsForm.setPercentage(percentage);
			detailsForm.setConcessionId(concessionId);

			String check = new FeeSetupBD()
					.insertConcesssionDetails(detailsForm);

			JSONObject jsonobj = new JSONObject();

			jsonobj.put("jsonResponse", check);

			response.getWriter().print(jsonobj);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in FeeSetupAction : insertConcesssionDetails  Ending");
		return null;

	}

	public ActionForward staffEmployementList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : staffEmployementList Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STAFF);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STAFF);

			String searhname = request.getParameter("searhname");

			ArrayList<AllTeacherDetailsVo> list = new ArrayList<AllTeacherDetailsVo>();

			if (searhname == null) {

				list = new TeacherRegistrationBD().getAllTeacherDetails();
			} else {

				list = new TeacherRegistrationBD()
						.getSearchTeacherDetails(searhname);
			}

			request.setAttribute("allTeacherDetailsList", list);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : staffEmployementList Ending");

		return mapping.findForward(MessageConstants.STAFF_EMPLOYEMENT);
	}

	public ActionForward getPayrollList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getPayrollList Starting");
		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_STAFF);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_STAFF);

			String month = null;
			String year = null;
			ArrayList<StaffPayrollListVo> list = new StaffPayrollBD()
					.getPayrollList(year, month);

			request.setAttribute("PayrollList", list);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getPayrollList Ending");

		return mapping.findForward(MessageConstants.STAFF_PAYROLL_LIST);
	}

	public ActionForward studPromotion(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: studPromotion Starting");

		try {

			ArrayList<StudentPramotionVO> notptomotedStudentList = (ArrayList<StudentPramotionVO>) request
					.getSession(false).getAttribute("notpromotedStud");

			if (notptomotedStudentList != null) {

				if (notptomotedStudentList.size() != 0) {

					request.setAttribute("error",
							"Displayed students are not promoted,Addmission number already exist");

					request.setAttribute("notptomotedStudentList",
							notptomotedStudentList);
				} else {

					request.setAttribute("success",
							"Selected Students Promoted Succeessfully");
				}
			}

			request.getSession(false).setAttribute("notpromotedStud", null);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction: studPromotion Ending");

		return mapping.findForward(MessageConstants.STUD_PROMOTION);
	}

	public ActionForward getmeeting(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getmeeting Starting");

		request.setAttribute(MessageConstants.MODULE_NAME,
				MessageConstants.BACKOFFICE_SETTINGS);
		request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
				MessageConstants.MODULE_SETTINGS);

		ArrayList<LstmsUpcomingMeetingVO> meetinglist = new CommunicationSettingsBD().getMeetingListDetails();

		String meet = "meeting";

		request.setAttribute("meetinglist", meetinglist);
		request.setAttribute("meeting", meet);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getmeeting Ending");

		return mapping.findForward(MessageConstants.REMARKS_LIST);

	}

	public ActionForward getbdaylist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getbdaylist Starting");

		String bday = "bday";

		request.setAttribute(MessageConstants.MODULE_NAME,
				MessageConstants.BACKOFFICE_SETTINGS);
		request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
				MessageConstants.MODULE_SETTINGS);

		ArrayList<UpcomingBdayVo> bdaylist = new CommunicationSettingsBD()
				.getBdayListDetails();

		request.setAttribute("bdaylist", bdaylist);

		request.setAttribute("birthday", bday);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction :getbdaylist Ending");
		return mapping.findForward(MessageConstants.REMARKS_LIST);
	}

	public ActionForward searchremark(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : searchremark Starting");

		try {

			UpcomingRemarksVO remrakvo = new UpcomingRemarksVO();

			String remarks = request.getParameter("remarks");

			
			
			
			
			String fromdate = request.getParameter("fromdate");
			String todate = request.getParameter("todate");

			remrakvo.setRemarks(remarks);
			remrakvo.setFromdate(HelperClass.convertUIToDatabase(fromdate));
			remrakvo.setTodate(HelperClass.convertUIToDatabase(todate));

			if (remrakvo.getRemarks().equalsIgnoreCase("remarks")) {

				ArrayList<UpcomingRemarksVO> remarkslist = new CommunicationSettingsBD()
						.searchRemarkDetails(remrakvo);

				request.setAttribute("remarkslist", remarkslist);
				request.setAttribute("searchlist", remrakvo);
				
				request.setAttribute("communicatelist", remrakvo);

			}

			LstmsUpcomingMeetingVO meetingvo = new LstmsUpcomingMeetingVO();
			String meeting = request.getParameter("remarks");

			String fromdate1 = request.getParameter("fromdate");
			String todate1 = request.getParameter("todate");

			meetingvo.setTitle(meeting);
			meetingvo.setFromdate(HelperClass.convertUIToDatabase(fromdate1));
			meetingvo.setTodate(HelperClass.convertUIToDatabase(todate1));

			if (meetingvo.getTitle().equalsIgnoreCase("meeting")) {

				ArrayList<LstmsUpcomingMeetingVO> meetinglist = new CommunicationSettingsBD()
						.searchMeetingDetails(meetingvo);

				String meet = "meeting";

				request.setAttribute("meetinglist", meetinglist);
				request.setAttribute("searchlist", meetingvo);
				request.setAttribute("meeting", meet);
				
				request.setAttribute("meetingitems", meetingvo);

			}

			UpcomingBdayVo bdayvo = new UpcomingBdayVo();
			String content = request.getParameter("remarks");

			String fromdate2 = request.getParameter("fromdate");
			String todate2 = request.getParameter("todate");

			bdayvo.setContent(content);
			bdayvo.setFromdate(HelperClass.convertUIToDatabase(fromdate2));
			bdayvo.setTodate(HelperClass.convertUIToDatabase(todate2));

			if (bdayvo.getContent().equalsIgnoreCase("bday")) {

				ArrayList<UpcomingBdayVo> bdaylist = new CommunicationSettingsBD()
						.searchBdayDetails(bdayvo);

				String bday = "bday";

				request.setAttribute("bdaylist", bdaylist);
				request.setAttribute("searchlist", bdayvo);
				request.setAttribute("birthday", bday);
				
				request.setAttribute("bdayitems", bdayvo);

			}
			
			
			
			
		
			
			
			
			
			
			
			

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction :searchremark Ending");

		return mapping.findForward(MessageConstants.REMARKS_LIST);
	}

	public ActionForward LeaveBankList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : LeaveBankList Starting");

		

		
		 String result = request.getParameter("deletekey");
		  
		  if (result != null) {
		  
		  if (result.equalsIgnoreCase(MessageConstants.LEAVEBANK_SUCCESS)) {
		  
		  request.setAttribute("successmessagediv",
		  MessageConstants.LEAVEBANK_SUCCESS); 
		  }
		  else if (result.equalsIgnoreCase(MessageConstants.LEAVEBANK_ERROR)) {
			  
			  request.setAttribute("errormessagediv",
			  MessageConstants.LEAVEBANK_ERROR); 
			  }
		  
		  }
		  
		  String result1 = request.getParameter("result");
		  
		  if (result1 != null) 
		  {
		  
		  if (result1
		  .equalsIgnoreCase(MessageConstants.ADD_LEAVEBANK_SUCCESS)) {
		  
		  request.setAttribute("successmessagediv",
		  MessageConstants.ADD_LEAVEBANK_SUCCESS);
		  } 
		  else if ((result1
		  .equalsIgnoreCase(MessageConstants.ADD_LEAVEBANK_FAILURE))) {
		  
		  request.setAttribute("errormessagediv",
		  MessageConstants.ADD_LEAVEBANK_FAILURE); 
		  }
		  else if (result1
		  .equalsIgnoreCase(MessageConstants.UPDATE_LEAVEBANK_SUCCESS)) {
		  request.setAttribute("successmessagediv",
		  MessageConstants.UPDATE_LEAVEBANK_SUCCESS); 
		  } else if (result1
		  .equalsIgnoreCase(MessageConstants.UPDATE_LEAVEBANK_FAIL)) {
		  request.setAttribute("successmessagediv",
		  MessageConstants.UPDATE_LEAVEBANK_FAIL); }
		  
		  }
		 
		String username = null;

		try {

			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_LEAVE);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_TEACHERS);

			username = HelperClass.getCurrentUserID(request);
			
			
			 
			ArrayList<ReportMenuVo> accYearList=new ReportsMenuBD().getAccYears();
			  request.setAttribute("AccYearList", accYearList);
			
	
			

			LeaveBankVO vo = new LeaveBankVO();

			 vo.setAccyearcode(request.getParameter("searchvalue"));

			ArrayList<LeaveBankVO> list = new LeaveBankDelegate()
					.leavebanklist(vo);
			
			

			request.setAttribute("leaveBank", list);
			
			request.setAttribute("attnhidden", list);



		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : LeaveBankList Ending");

		return mapping.findForward(MessageConstants.LEAVEBANK_LIST);
	}
	
	
	
	public ActionForward getclassandteacherList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getclassandteacherList Starting");

		
	
		try {
			
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);
			
			
			ArrayList<ClassTeacherVo> list =new ArrayList<ClassTeacherVo>();
			
			
			String searchTerm = request.getParameter("searchTerm");
			
			
			
			if(searchTerm !=null){
				
				
				
				 list = new ClassTeacherLsisBD().getSearchClassTeacherListBD(searchTerm);
				 
					request.setAttribute("searchTerm", searchTerm);
				
			}
			
			else{
				
				
				 list = new ClassTeacherLsisBD().getClassTeacherListBD();
			}
			
			
		
	
			
			
			request.setAttribute("classteacherlist", list);
			
			request.getSession(false).setAttribute("EXcelDownLoad",
					list);
			
		
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		
		
		
	
	
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : getclassandteacherList Ending");

		return mapping.findForward(MessageConstants.ClassTeacherMapping);
	}
	
//support Work
	
	public ActionForward Support(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : streamList Starting");
		try {/*
			request.setAttribute(MessageConstants.MODULE_NAME,
					MessageConstants.BACKOFFICE_SETTINGS);
			request.setAttribute(MessageConstants.HIGHLIGHT_NAME,
					MessageConstants.MODULE_SETTINGS);

			System.out.println("Support Action is Working");
			
			StreamDetailsBD obj = new StreamDetailsBD();
			List<StreamDetailsVO> list = new ArrayList<StreamDetailsVO>();
			
			String SearchName = request.getParameter("searchname");
			
			
			if(SearchName != null){
				
			
				
				list=obj.searchStreamDetailsBD(SearchName);
				request.setAttribute("searchname", SearchName);
				request.setAttribute("searchnamelist", SearchName);
				
				
				
			}
			else{
				
			 list =obj.getStreamDetailsBD();
				
			}
			
			request.setAttribute("streamDetailsList", list);
			
			

			request.getSession(false).setAttribute("EXcelDownLoad",list);

		*/} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : streamList Ending");

		return mapping.findForward(MessageConstants.SUPPORT_LIST);
	}
	
	
	//excel file upload
	
	public ActionForward studentfileupload(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction    : EmpExcelUpload : Starting");
		
		try{
		
			
		
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		
		}
			
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMenuAction : EmpExcelUpload : Ending");
		
		return mapping.findForward(MessageConstants.STUDENT_EXCEL_UPLOAD);
	}
	

}
