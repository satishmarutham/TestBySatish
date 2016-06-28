package com.centris.campus.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.campus.admin.LstmsParents;
import com.centris.campus.admin.LstmsPrinciple;
import com.centris.campus.admin.LstmsTeachers;
import com.centris.campus.admin.lstmsUser;
import com.centris.campus.delegate.LoginBD;
import com.centris.campus.forms.LoginForm;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.HelperClassVo;
import com.centris.campus.vo.LoginVo;
import com.centris.campus.vo.UserDetailVO;

public class LoginAction extends DispatchAction {
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	
	
	public ActionForward checkValidateuser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : checkValidateuser  Starting");
		
		try {
			
			String userName=request.getParameter("UserName");
			String Password=request.getParameter("password");
			
			System.out.println("user name:: "+userName +"  Password ::: "+Password);
			
			LoginBD loginBD = new LoginBD();
			LoginVo loginVo  = loginBD.validateUserBD(userName, Password);
			
			JSONObject object=new JSONObject();
			object.put("Status", loginVo.getUsercode());
			
			response.getWriter().print(object);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : checkValidateuser Ending");

		return null;

	}


	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : login  Starting");
		
		try {
			
			LoginForm lform=(LoginForm)form;
			
			String userName = lform.getUsername();
			String Password = lform.getPassword();
			
			LoginBD loginBD = new LoginBD();
			
			LoginVo loginVo = loginBD.validateUserBD(userName, Password);
			
			
			if (loginVo.getUsercode() != "") {
				
				
				HttpSession session = request.getSession(true);
				
					List<HelperClassVo> accYear = new ArrayList<HelperClassVo>();
					
					request.setAttribute(MessageConstants.MODULE_NAME,MessageConstants.BACKOFFICE_HOMENAME);
					request.setAttribute(MessageConstants.HIGHLIGHT_NAME, null);
					
					session = request.getSession(false);
					String selected = request.getParameter("accYear");

					accYear = HelperClass.getAllAcademicYear();
					session.setAttribute(MessageConstants.ACADAMICYEAR, accYear);
					
					if (selected == null) {
						
						session.setAttribute(MessageConstants.CURRENT_ACADAMICYEAR,HelperClass.getCurrentYearID());
					
					} else {
						
						session.setAttribute(MessageConstants.CURRENT_ACADAMICYEAR,selected.trim());
					}

					UserDetailVO usrVo = loginBD.loadUserBD(loginVo);
					
					session.setAttribute(MessageConstants.USER_DETAILS,usrVo);
					
					
					System.out.println(usrVo.getPermissionmap().size());
					
					session.setAttribute("user", usrVo.getUserNametype());
					
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : login Ending");

		return mapping.findForward(MessageConstants.adminLogin);

	}
	
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : logout  Starting");
		

		try {
			String user = (String) request.getParameter("usernamehidden");

			HttpSession session = request.getSession(false);
			session.invalidate();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : logout Ending");

		return mapping.findForward("Home");
	}

	public ActionForward changePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : changePassword  Starting");

		try {

			String newPassword = (String) request.getParameter("newPassword");
			String currentuser = (String) request.getSession(false)
					.getAttribute("user");
			String currentuserId = HelperClass.getCurrentUserID(request);

			int count = new LoginBD().changePassword(currentuser, newPassword,
					currentuserId);

			JSONObject object = new JSONObject();

			if (count > 0) {

				object.put("status", "true");

			} else {

				object.put("status", "false");
			}

			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : changePassword Ending");

		return null;
	}

	public ActionForward checkCurrentPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : checkCurrentPassword  Starting");

		try {

			String currentuser = (String) request.getSession(false)
					.getAttribute("user");
			String currentPassword = (String) request
					.getParameter("oldPassword");
			String currentuserId = HelperClass.getCurrentUserID(request);

			int count = new LoginBD().checkCurrentPassword(currentuser,
					currentPassword, currentuserId);

			JSONObject object = new JSONObject();
			if (count > 0) {
				object.put("status", "true");
			} else {
				object.put("status", "false");
			}
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : checkCurrentPassword Ending");

		return null;
	}
}