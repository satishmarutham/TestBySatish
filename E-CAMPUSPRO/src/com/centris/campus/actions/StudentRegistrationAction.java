package com.centris.campus.actions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.campus.daoImpl.IDGenerator;
import com.centris.campus.daoImpl.StudentRegistrationDaoImpl;
import com.centris.campus.delegate.StudentRegistrationDelegate;
import com.centris.campus.delegate.TransportBD;
import com.centris.campus.forms.StudentRegistrationForm;
import com.centris.campus.pojo.StreamDetailsPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.StageMasterVo;
import com.centris.campus.vo.StudentInfoVO;
import com.centris.campus.vo.StudentRegistrationVo;
import com.centris.campus.vo.TransportTypeVO;
import com.centris.campus.vo.registrationvo;
import com.sun.mail.iap.Response;

public class StudentRegistrationAction extends DispatchAction {
	/**
	 * Logger instance.
	 */
	
	static ResourceBundle res = ResourceBundle
			.getBundle("com/centris/campus/properties/CAMPUS");
	private static String ImageName = res.getString("ImageName");
	
	private static final Logger logger = Logger
			.getLogger(StudentRegistrationAction.class);

	/**
	 * <p>
	 * This action method is responsible for getting AcademicYears.
	 * </p>
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return List of StudentRegistrationVo Object.
	 * @throws Exception
	 */

	public ActionForward getAcademicYear(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getAcademicYear Starting");

		List<StudentRegistrationVo> studentRegistrationVos = new StudentRegistrationDelegate()
				.getAcademicYear();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put(MessageConstants.JSON_RESPONSE, studentRegistrationVos);
		response.getWriter().print(jsonObject);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getAcademicYear Ending");
		return null;
	}

	public ActionForward getStudentquota(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getStudentquota Starting");

		List<StudentRegistrationVo> studentRegistrationQuotaList = new StudentRegistrationDelegate()
				.getStudentquota();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put(MessageConstants.JSON_RESPONSE,
				studentRegistrationQuotaList);
		response.getWriter().print(jsonObject);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getStudentquota Ending");
		return null;
	}

	/**
	 * <p>
	 * This action method is responsible for Saving the StudentRegistrationForm.
	 * </p>
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return String
	 * @throws Exception
	 */
	public ActionForward saveStudentRegistration(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info("Control in StudentRegistrationAction: saveStudentRegistration Starting");

		String keyValues = null;
		FormFile imagePath = null;
		String realPath = "";
		FileOutputStream outputStream = null;
		String imagepath;
		String fileName = "";
		int i = 0;
		boolean flag = false;
		StudentRegistrationDelegate registrationDelegate = new StudentRegistrationDelegate();
		StudentRegistrationForm studentRegistrationForm = (StudentRegistrationForm) form;
		FormFile formFile = null;
		String path = null;

		formFile = studentRegistrationForm.getBirthFile();

		String StudentIDGenerator = null;
		

		try {
			
			int count = registrationDelegate.validateDuplicateData(studentRegistrationForm, "Add");
			if (count == 0) {
				
				if (i == 0) {
					
					StudentIDGenerator = IDGenerator.getPrimaryKeyID("campus_student");
					
					String createdUser = HelperClass.getCurrentUserID(request);

					if (studentRegistrationForm.getDateofBirth() != null) {
						
						//To get image path
						
						try {
								
								imagePath = studentRegistrationForm.getStudentImage();
								
								if (imagePath != null) {
									
									fileName = imagePath.getFileName();
								}
								
								if (fileName.length() < 2 && fileName != null) {

									studentRegistrationForm.setStudentPhoto(getServlet().getServletContext().getRealPath("/")+ "FIles/STUDENTIMAGES/" +StudentIDGenerator+"noImage.png");
								
								} else {
									
									imagepath = getServlet().getServletContext().getRealPath("")+ "\\FIles\\STUDENTIMAGES"+ "/"+studentRegistrationForm.getStudentFirstName()+"_"+StudentIDGenerator + "." + "jpg";
									
									realPath = imagepath.substring(imagepath.indexOf("FIles\\"));
									
									outputStream = new FileOutputStream(new File(imagepath));
									outputStream.write(imagePath.getFileData());
									
									studentRegistrationForm.setStudentPhoto(realPath);
								}
						} catch (Exception e) {
							logger.error(e.getMessage(), e);
							e.printStackTrace();
					} finally {
						
						if (outputStream != null) {
							
							outputStream.close();
						}
					}
							
					
					//	To get BirthCertificate path 
								
								try {

									if (studentRegistrationForm.getBirthFile() != null) {
										
									String extension=null;
									
									 int j = studentRegistrationForm.getBirthFile().getFileName().lastIndexOf('.');
									 if (j >= 0) {
									     extension = studentRegistrationForm.getBirthFile().getFileName().substring(i+1);
									 }
									
									String birthcertificate_path = "FIles/STUDENTBIRTHCER/BirthCer_" + StudentIDGenerator+ "." + extension;
									

									String filePath = request.getRealPath("/") + "FIles/STUDENTBIRTHCER/BirthCer_" + StudentIDGenerator
											+ "." +extension;
									if (studentRegistrationForm.getBirthFile().getFileSize() > 0) {
										
										byte[] btDataFile = studentRegistrationForm.getBirthFile().getFileData();
										File of = new File(filePath);
										FileOutputStream osf = new FileOutputStream(of);
										osf.write(btDataFile);
										osf.flush();
									
									} else {
										
										birthcertificate_path = "";
									}
									
									
									studentRegistrationForm.setBirthfile(birthcertificate_path);
										
									}
									
								} catch (Exception e) {
									logger.error(e.getMessage(), e);
									e.printStackTrace();
								} finally {
									if (outputStream != null) {
										outputStream.close();
									}
								}
								
								
							//	To get TransferCertificate path
								
								try {

									if (studentRegistrationForm.getTransferFile() != null) {
										
										String extension=null;
									
									 int k = studentRegistrationForm.getTransferFile().getFileName().lastIndexOf('.');
									
									 if (k >= 0) {
									    
										 extension = studentRegistrationForm.getTransferFile().getFileName().substring(i+1);
									 }
									
									String transfercertificate_path = "FIles/STUDENTTRANSFERCER/TransferCer_" + StudentIDGenerator+ "." + extension;
									

									String filePath = request.getRealPath("/") + "FIles/STUDENTTRANSFERCER/TransferCer_" + StudentIDGenerator
											+ "." +extension;
									
									if (studentRegistrationForm.getTransferFile().getFileSize() > 0) {
										
										byte[] btDataFile = studentRegistrationForm.getTransferFile().getFileData();
										File of = new File(filePath);
										FileOutputStream osf = new FileOutputStream(of);
										osf.write(btDataFile);
										osf.flush();
									
									} else {
										transfercertificate_path = "";
									}
									
									
									studentRegistrationForm.setTransferfile(transfercertificate_path);
										
									}
									
								} catch (Exception e) {
									logger.error(e.getMessage(), e);
									e.printStackTrace();
								} finally {
									if (outputStream != null) {
										outputStream.close();
									}
								}

								


						studentRegistrationForm.setCreateUser(createdUser);
						studentRegistrationForm.setStudentIDgenerator(StudentIDGenerator);
						studentRegistrationForm.getRemarks();
					

								i = i + 1;
								
								Map<String, String> studentRegistrationMap = registrationDelegate.saveStudentRegistration(studentRegistrationForm);

								Set set = studentRegistrationMap.entrySet();
								Iterator iterator = set.iterator();
								
								while (iterator.hasNext()) {
									
									Map.Entry<String, String> m = (Map.Entry) iterator.next();
									keyValues = (String) m.getKey();

									if (keyValues.equalsIgnoreCase("successMessage")) {

										request.setAttribute("StudentCount",StudentIDGenerator);
										request.setAttribute("successMessage","Student Registered SuccessFully");
										request.setAttribute("classId",studentRegistrationForm.getStudClassId());
										request.setAttribute("accyearId",studentRegistrationForm.getAcademicYear());
										request.setAttribute("studentId",StudentIDGenerator);
										request.setAttribute("isConcessionAvailable",studentRegistrationForm.getCencession());
										request.setAttribute("isTransport",studentRegistrationForm.getTransport());
										request.setAttribute("concessionPercentage",studentRegistrationForm.getScholarShip());
										request.setAttribute("studentQuataName",studentRegistrationForm.getStudentquotaname());

									} else if (keyValues.equalsIgnoreCase("errorMessage")) {
										
										request.setAttribute("errorMessage","Student Not Registred");
									
									} else if (keyValues.equalsIgnoreCase("duplicateMessage")) {
										
										request.setAttribute("duplicateMessage","Student Already Registered  with this Details");
									
									} else {
										
										request.setAttribute("refresh ", " ");
									}
								}
						
					}
				}
			} else {
				
				request.setAttribute("duplicateMessage","Student Already Registered  with This Details");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		form = null;

		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction: saveStudentRegistration Ending");

		return mapping.findForward("studentRegistration");

	}

	/**
	 * <p>
	 * This action method is responsible for getting StudentNames By Search.
	 * </p>
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return List of String.
	 * @throws Exception
	 */
	public ActionForward studentSearch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)

	throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info("Control in StudentRegistrationAction: studentSearch Starting");

		List<StudentRegistrationVo> searchStudentList = new ArrayList<StudentRegistrationVo>();
		try {
			StudentRegistrationVo registrationVo = new StudentRegistrationVo();
			String searchterm = request.getParameter("searchTerm");
			String accYearVal = request.getParameter("accYearVal");
			String classId = request.getParameter("classname");
			String sectionId = request.getParameter("section");

			registrationVo.setSearchTerm(searchterm);
			registrationVo.setAcademicYearId(accYearVal);
			registrationVo.setClassDetailId(classId);
			registrationVo.setClassSectionId(sectionId);

			StudentRegistrationDelegate registrationDelegate = new StudentRegistrationDelegate();
			searchStudentList = registrationDelegate
					.studentSearch(registrationVo);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(MessageConstants.JSON_RESPONSE, searchStudentList);

			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction: studentSearch Ending");
		return null;

	}

	public ActionForward searchStudentResult(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info("Control in StudentRegistrationAction: searchStudentResult Starting");

		StudentRegistrationVo registrationVo1 = new StudentRegistrationVo();
		StudentRegistrationDelegate delegate = new StudentRegistrationDelegate();
		try {
			
			String searchTerm = request.getParameter("searchTerm");

			registrationVo1.setSearchTerm(searchTerm);
			
			request.setAttribute("SerchTerm", searchTerm);

			request.setAttribute("studentSearchList", delegate.searchStudentResult(registrationVo1));
			

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction : searchStudentResult Ending");
		
		return mapping.findForward(MessageConstants.ADDSTUDENTREGISTRATION);
	}

	public ActionForward modifyStudentDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info("Control in StudentRegistrationAction : ModifyStudentDetails Starting");
		String success = "";
		FileOutputStream outputStream = null;
		String realPath = "";
		StudentRegistrationForm studentRegistrationForm = (StudentRegistrationForm) form;

		try {

					
					String createdUser = HelperClass.getCurrentUserID(request);

			        String studentid=studentRegistrationForm.getStudentId();
			        
			        
					
					try {
						

						if (studentRegistrationForm.getStudentImage() != null) {
							
								String extension=null;
							
							 int i = studentRegistrationForm.getStudentImage().getFileName().lastIndexOf('.');
							 if (i >= 0) {
								 
							     extension = studentRegistrationForm.getStudentImage().getFileName().substring(i+1);
							 }
							
							String image_path = "FIles/STUDENTIMAGES/"+studentRegistrationForm.getStudentFirstName()+"_" + studentid.trim()+ "." + extension;
							
							String filePath = request.getRealPath("/") + "FIles/STUDENTIMAGES/"+studentRegistrationForm.getStudentFirstName()+"_" + studentid.trim()+ "." +extension;
							
							if (studentRegistrationForm.getStudentImage().getFileSize() > 0) {
								byte[] btDataFile = studentRegistrationForm.getStudentImage().getFileData();
								File of = new File(filePath);
								FileOutputStream osf = new FileOutputStream(of);
								osf.write(btDataFile);
								osf.flush();
							} else {
								
								image_path = studentRegistrationForm.getPreviousImage();
							}
						
							studentRegistrationForm.setImageFileName(image_path);
							
							
						}else{
						
							studentRegistrationForm.setImageFileName(studentRegistrationForm.getPreviousImage());
						}
						
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
						e.printStackTrace();
					} finally {
						if (outputStream != null) {
							outputStream.close();
						}
					}

					try {

						
						if (studentRegistrationForm.getBirthFile() != null) {
							
						String extension=null;
						
						 int i = studentRegistrationForm.getBirthFile().getFileName().lastIndexOf('.');
						 if (i >= 0) {
						     extension = studentRegistrationForm.getBirthFile().getFileName().substring(i+1);
						 }
						
						String idProof_path = "FIles/STUDENTBIRTHCER/BirthCer_" + studentid.trim()+ "." + extension;
						

						String filePath = request.getRealPath("/") + "FIles/STUDENTBIRTHCER/BirthCer_" + studentid.trim()
								+ "." +extension;
						if (studentRegistrationForm.getBirthFile().getFileSize() > 0) {
							
							byte[] btDataFile = studentRegistrationForm.getBirthFile().getFileData();
							File of = new File(filePath);
							FileOutputStream osf = new FileOutputStream(of);
							osf.write(btDataFile);
							osf.flush();
						} else {
							
							idProof_path = studentRegistrationForm.getPreviousBirthCer();
						}
						
						studentRegistrationForm.setBirthfile(idProof_path);
							
						}else{
							studentRegistrationForm.setBirthfile(studentRegistrationForm.getPreviousBirthCer());
						}
						
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
						e.printStackTrace();
					} finally {
						if (outputStream != null) {
							outputStream.close();
						}
					}


					
					try {

						
						if (studentRegistrationForm.getTransferFile() != null) {
							
						String extension=null;
						
						 int i = studentRegistrationForm.getTransferFile().getFileName().lastIndexOf('.');
						 if (i >= 0) {
						     extension = studentRegistrationForm.getTransferFile().getFileName().substring(i+1);
						 }
						
						String idProof_path = "FIles/STUDENTTRANSFERCER/TransferCer_" + studentid.trim()+ "." + extension;
						

						String filePath = request.getRealPath("/") + "FIles/STUDENTTRANSFERCER/TransferCer_" + studentid.trim()
								+ "." +extension;
						if (studentRegistrationForm.getTransferFile().getFileSize() > 0) {
							
							byte[] btDataFile = studentRegistrationForm.getTransferFile().getFileData();
							File of = new File(filePath);
							FileOutputStream osf = new FileOutputStream(of);
							osf.write(btDataFile);
							osf.flush();
						} else {
							
							idProof_path = studentRegistrationForm.getPreviousTransferCer();
						}
						
						studentRegistrationForm.setTransferfile(idProof_path);
							
						}else{
							studentRegistrationForm.setTransferfile(studentRegistrationForm.getPreviousTransferCer());
						}
						
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
						e.printStackTrace();
					} finally {
						if (outputStream != null) {
							outputStream.close();
						}
					}
					
					
					studentRegistrationForm.setStudentPhoto(realPath);
					studentRegistrationForm.setModifyUser(createdUser);
					studentRegistrationForm.setStudentId(studentid);
					
					
					success = new StudentRegistrationDelegate().modifyStudentDetails(studentRegistrationForm);

					if (success.equalsIgnoreCase("successMessage")) {

						request.setAttribute("successMessage","Student details updated Successfully");

					} else if (success.equalsIgnoreCase("errorMessage")) {

						request.setAttribute("duplicateMessage","Student details not Update");

					} else {
						request.setAttribute("duplicateMessage","Student registerd already with this Details");
					}

					

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}

		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction : ModifyStudentDetails Ending");
		return mapping.findForward("studentRegistration");

	}

	public ActionForward deleteStudentSession(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : deleteStudentSession Starting");
		try {
			request.getSession(false).setAttribute("success", null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction : deleteStudentSession Ending");
		return null;
	}

	public ActionForward studentSearchByParent(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info("Control in StudentRegistrationAction : studentSearchByParent Starting");
		List<StudentRegistrationVo> studentSearchList = new ArrayList<StudentRegistrationVo>();
		StudentRegistrationVo registrationVo = new StudentRegistrationVo();
		StudentRegistrationDelegate delegate = new StudentRegistrationDelegate();
		try {
			String searchTerm = request.getParameter("searchTerm");

			registrationVo.setSearchTerm(searchTerm);
			studentSearchList = delegate.studentSearchByParent(registrationVo);

			JSONArray array = new JSONArray();
			array.put(studentSearchList);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put(MessageConstants.JSON_RESPONSE, studentSearchList);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction : studentSearchByParent Ending");
		return null;
	}

	public ActionForward studentSearchbySibling(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info("Control in StudentRegistrationAction : studentSearchbySibling Starting");

		List<StudentRegistrationVo> searchStudentList = new ArrayList<StudentRegistrationVo>();
		try {
			StudentRegistrationVo registrationVo = new StudentRegistrationVo();
			String searchterm = request.getParameter("searchTerm");

			registrationVo.setSearchTerm(searchterm);
			StudentRegistrationDaoImpl daoImpl = new StudentRegistrationDaoImpl();
			searchStudentList = daoImpl.studentSearchbySibling(registrationVo);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(MessageConstants.JSON_RESPONSE, searchStudentList);

			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction : studentSearchbySibling Ending");
		return null;

	}

	public ActionForward validatePhoneNo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : validatePhoneNo Starting");
		try {
			StudentRegistrationDaoImpl registrationDaoImpl = new StudentRegistrationDaoImpl();
			String phoneNO = request.getParameter("phoneId").trim();

			String message = registrationDaoImpl.validatePhoneNo(phoneNO);

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("message", message);

			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentRegistrationAction : validatePhoneNo Ending");
		return null;

	}

	public ActionForward validateEmail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : validateEmail Starting");
		try {
			StudentRegistrationDaoImpl registrationDaoImpl = new StudentRegistrationDaoImpl();
			String email = request.getParameter("emailid").trim();

			String message = registrationDaoImpl.validateEmail(email);
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("message", message);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentRegistrationAction : validateEmail Ending");
		return null;

	}

	public ActionForward getStudentCaste(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getStudentCaste Starting");
		try {
			List<StudentRegistrationVo> studentCastelist = new ArrayList<StudentRegistrationVo>();
			StudentRegistrationDelegate delegate = new StudentRegistrationDelegate();
			studentCastelist = delegate.getStudentCaste();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put(MessageConstants.JSON_RESPONSE, studentCastelist);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getStudentCaste Ending");
		return null;
	}

	public ActionForward validateroleNumber(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : validateroleNumber Starting");
		try {
			StudentRegistrationDaoImpl registrationDaoImpl = new StudentRegistrationDaoImpl();
			String rollNumber = request.getParameter("rollNumber").trim();

			String message = registrationDaoImpl.validateRollNumber(rollNumber);
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("message", message);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentRegistrationAction : validateroleNumber Ending");
		return null;

	}

	public ActionForward checkapplicationNo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : checkApplicationNo Starting");
		try {
			StudentRegistrationDaoImpl registrationDaoImpl = new StudentRegistrationDaoImpl();
			String applicationNo = request.getParameter("applicationNo").trim();

			String message = registrationDaoImpl
					.checkApplicationNo(applicationNo);
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("message", message);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentRegistrationAction:checkApplicationNo Ending");
		return null;

	}

	public ActionForward getAllStudentsByClass(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getAllStudentsByClass Starting");
		try {

			String classname = request.getParameter("classid").trim();
			String accyear = request.getParameter("accyearId").trim();

			ArrayList<StudentInfoVO> studentList = new StudentRegistrationDelegate()
					.getAllStudentsDetails(classname, accyear);

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("studentList", studentList);

			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentRegistrationAction: getAllStudentsByClass Ending");
		return null;

	}

	public ActionForward getTransportCategory(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getTransportCategory Starting");
		try {

			List<TransportTypeVO> tar_type_list = new StudentRegistrationDelegate()
					.transportypedetails();

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("transportCategory", tar_type_list);

			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentRegistrationAction: getTransportCategory Ending");
		return null;

	}

	public ActionForward getTransportStages(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getTransportStages Starting");
		try {

			List<StageMasterVo> masterVos = new StudentRegistrationDelegate()
					.getStageDetails();

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("transportstages", masterVos);

			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentRegistrationAction: getTransportStages Ending");
		return null;

	}

	public ActionForward getTransportCategoryType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getTransportCategoryType Starting");
		try {

			String transportTypeId = request.getParameter("typeId");

			String transportTypeStatus = new StudentRegistrationDelegate()
					.getTransportCategoryType(transportTypeId);


			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("transportTypeStatus", transportTypeStatus);

			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  StudentRegistrationAction: getTransportCategoryType Ending");
		return null;

	}

	public ActionForward studentSearchbyClass(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response)

	throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info("Control in StudentRegistrationAction : studentSearchbyClass Starting");

		List<StudentRegistrationVo> searchStudentList = new ArrayList<StudentRegistrationVo>();
		try {
			StudentRegistrationVo registrationVo = new StudentRegistrationVo();
			String searchterm = request.getParameter("searchTerm");
			String accYearVal = request.getParameter("accYearVal");
			String classId = request.getParameter("classname");

			registrationVo.setSearchTerm(searchterm);
			registrationVo.setAcademicYearId(accYearVal);
			registrationVo.setClassDetailId(classId);

			StudentRegistrationDelegate registrationDelegate = new StudentRegistrationDelegate();
			searchStudentList = registrationDelegate
					.studentSearchbyClass(registrationVo);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(MessageConstants.JSON_RESPONSE, searchStudentList);

			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction : studentSearchbyClass Ending");
		return null;

	}

	public ActionForward getCategory(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction :getCategory Starting");

		try {
			List<StudentRegistrationVo> CategoryList = new StudentRegistrationDelegate()
					.getChildCategory();
			JSONObject jsonObject = new JSONObject(CategoryList);
			jsonObject.accumulate("CategoryList", CategoryList);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction :getCategory Ending");
		return null;
	}

	public ActionForward getClassDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction:getClassDetail Starting");
		try {

			String categoryVal = request.getParameter("categoryVal").trim();
			List<StudentRegistrationVo> ClassList = new StudentRegistrationDelegate()
					.getClassDetails(categoryVal);

			JSONObject jsonObject = new JSONObject(ClassList);
			jsonObject.accumulate("ClassList", ClassList);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction:getClassDetail Ending");
		return null;
	}

	public ActionForward getClassSection(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction:getClassSection Starting");
		try {
			String classidVal = request.getParameter("classidVal");
			List<StudentRegistrationVo> List = new StudentRegistrationDelegate()
					.getSection(classidVal.trim());
			JSONObject jsonObject = new JSONObject(List);
			jsonObject.accumulate("sectionList", List);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction :getClassSection Ending");
		return null;
	}

	public ActionForward getConcessionDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getConcessionDetails Starting");

		try {
			List<StudentRegistrationVo> List = new StudentRegistrationDelegate()
					.getConcessionDetails();
			JSONObject object = new JSONObject();
			object.put("ConcessionDetails", List);
			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : getConcessionDetails Ending");
		return null;
	}

	public ActionForward deactivateStudent(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info("Control in StudentRegistrationAction: deactivateStudent Starting");

		StudentRegistrationVo registrationVo = new StudentRegistrationVo();
		StudentRegistrationDelegate delegate = new StudentRegistrationDelegate();
		try {
			String deletestudentid = request.getParameter("studentid");

			registrationVo.setStudentId(deletestudentid);

			boolean status = delegate.deactivateStudent(registrationVo);

			JSONObject obj = new JSONObject();
			obj.put("status", status);
			response.getWriter().print(obj);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction : deactivateStudent Ending");
		return null;
	}

	public ActionForward editStudent(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info("Control in StudentRegistrationAction: editStudent Starting");

		StudentRegistrationVo registrationVo1 = new StudentRegistrationVo();
		StudentRegistrationDelegate delegate = new StudentRegistrationDelegate();
		try {
			
			String searchTerm = request.getParameter("searchTerm");

			registrationVo1.setSearchTerm(searchTerm);
			
			registrationVo1=delegate.editStudent(registrationVo1);
			
			request.setAttribute("studentSearchList", registrationVo1);
			

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.info(JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info("Control in StudentRegistrationAction : editStudent Ending");
		
		return mapping.findForward(MessageConstants.ADDSTUDENTREGISTRATION);
	}


	public synchronized ActionForward downloadDocument(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction: downloadDocument Starting");

		try {
			String docPath = request.getParameter("Path");
			response.setContentType("application/octet-stream");
			String fileName = "FileName";
			fileName=docPath;
			
			response.addHeader("Content-Disposition", "attachment; filename="+ fileName);
			File docFile = new File(request.getRealPath("/") + docPath);
			response.setContentLength((int) docFile.length());

			FileInputStream input = new FileInputStream(docFile);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			ServletOutputStream stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction: downloadDocument Ending");

		return null;
	}
	
	
	public ActionForward downloadStudentDetailsXLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : downloadStudentDetailsXLS  Starting");
		
		try {
		
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/studentfulldetailsxls.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
						
			List<registrationvo> streamList = new  StudentRegistrationDelegate()
			.StudentDetails();
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					streamList);
			Map parameters = new HashMap();
			
			
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/studentfulldetailsxls.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "studentfulldetailsxls Excel Report" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES,
					sheetNames);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/studentfulldetailsxls.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=studentfulldetailsxls.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
		
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in StudentRegistrationAction : downloadStudentDetailsXLS   Ending");
				return null;
		
		
	}
	
	public ActionForward downloadStudentDetailsPDF(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in StudentRegistrationAction : downloadStudentDetailsPDF  Starting");

			try {


				List<registrationvo> Details = new  StudentRegistrationDelegate()
				.StudentDetails();
				
				String sourceFileName = request
						.getRealPath("Reports/studentfulldetailsPDF.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);

				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						Details);

				String PropfilePath = getServlet().getServletContext().getRealPath(
						"")
						+ "\\images\\" + ImageName.trim();

				String schName = res.getString("SchoolName");
				String schAddLine1 = res.getString("AddressLine1");

				Map parameters = new HashMap();
				
				parameters.put("Image", PropfilePath);


				/*parameters.put("Image", clientImage);

				parameters.put("ClientName", ClientName);

				parameters.put("ClientAddress", ClientAddress_l1);*/

				byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
						parameters, beanColDataSource);

				response.setContentType("application/pdf");

				response.setContentLength(bytes.length);

				response.setHeader("Content-Disposition", "outline; filename=\""
						+ "studentfulldetailsPDF - " + ".pdf\"");

				ServletOutputStream outstream = response.getOutputStream();

				outstream.write(bytes, 0, bytes.length);

				outstream.flush();

			}

			catch (Exception e)

			{
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}

			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in StudentRegistrationAction : downloadStudentDetailsPDF  Ending");
			return null;

		}



}