package com.centris.campus.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.campus.daoImpl.IDGenerator;
import com.centris.campus.daoImpl.JDBCConnection;
import com.centris.campus.daoImpl.UploadStudentXLSDaoImpl;
import com.centris.campus.pojo.UploadStudentXlsPOJO;
import com.centris.campus.service.UploadStudentXSLservice;
import com.centris.campus.util.JDate;
import com.centris.campus.util.JLogger;
import com.centris.campus.util.MessageConstants;
import com.centris.campus.vo.UploadStudentXlsVO;
import com.itextpdf.text.log.SysoLogger;


public class UploadStudentXSLServiceIMPL implements UploadStudentXSLservice {
	
	private static Logger logger = Logger.getLogger(UploadStudentXSLServiceIMPL.class);


	public Set<UploadStudentXlsVO> insertEmpXSL(
			List<UploadStudentXlsPOJO> list, String username, String duplicate) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLServiceImpl : insertEmpXSL : Starting");
		
		Connection connection = null;
		int checkShiftCode=0;
		int checkcategory=0;
		int checkClassCode=0;
		int checkSectionCode=0;
		List<UploadStudentXlsPOJO> successlist=new ArrayList<UploadStudentXlsPOJO>();
		UploadStudentXLSDaoImpl daoImpl=new UploadStudentXLSDaoImpl();
	
		int count = 0;
		boolean pancardflag=false;
		boolean personalemailflag=false;
		boolean officialemailflag=false;
		
	
		Set<UploadStudentXlsVO> failurelist = new LinkedHashSet<UploadStudentXlsVO>();
	
		failurelist.clear();
		successlist.clear();

		try {
			System.out.println("Service IMPL is working for Excel file student");
			connection=JDBCConnection.getSeparateConnection();
			
			String int_regex="^[0-9]*$";
			String numbers_regx = "[0-9//]{10}";
			String string_regx="([a-zA-Z.]+\\s+)*[a-zA-Z.]+";
			String datePattern = "\\d{1,2}\\-\\d{1,2}\\-\\d{4}";
			String regexpforEmailId="/[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]*$/i";
			 
			for (Iterator<UploadStudentXlsPOJO> iterator = list.iterator(); iterator.hasNext();) {

				UploadStudentXlsPOJO uploadStudentXSLPOJO = (UploadStudentXlsPOJO) iterator.next();
									
				UploadStudentXlsVO uploadStudentXSLVo = new UploadStudentXlsVO();

				uploadStudentXSLPOJO.setCreateUser(username);
				
				System.out.println(" primary person -----"+uploadStudentXSLPOJO.getPrimaryPerson());
			
				//uploadStudentXSLVo.setCreateUser(username);
				
				
				uploadStudentXSLVo.setStudentFirstName(uploadStudentXSLPOJO.getStudentFirstName());
				uploadStudentXSLVo.setStudentLastName(uploadStudentXSLPOJO.getStudentLastName());
				uploadStudentXSLVo.setStudentAdmissionNo(uploadStudentXSLPOJO.getStudentAdmissionNo());
				uploadStudentXSLVo.setStudentRegNo(uploadStudentXSLPOJO.getStudentRegNo());
				uploadStudentXSLVo.setDateofJoin(uploadStudentXSLPOJO.getDateofJoin());
				uploadStudentXSLVo.setAcademicYear(uploadStudentXSLPOJO.getAcademicYear());
				uploadStudentXSLVo.setCategory(uploadStudentXSLPOJO.getCategory());
				uploadStudentXSLVo.setClassname(uploadStudentXSLPOJO.getClassname());
				uploadStudentXSLVo.setSectionname(uploadStudentXSLPOJO.getSectionname());
				uploadStudentXSLVo.setStudentquotaname(uploadStudentXSLPOJO.getStudentquotaname());
				uploadStudentXSLVo.setGrade(uploadStudentXSLPOJO.getGrade());
				uploadStudentXSLVo.setRte(uploadStudentXSLPOJO.getRte());
				uploadStudentXSLVo.setEmisNo(uploadStudentXSLPOJO.getEmisNo());
				uploadStudentXSLVo.setHostel(uploadStudentXSLPOJO.getHostel());
				uploadStudentXSLVo.setConcession_applicable(uploadStudentXSLPOJO.getConcession_applicable());
				uploadStudentXSLVo.setConcession_type(uploadStudentXSLPOJO.getConcession_type());
				uploadStudentXSLVo.setTransport(uploadStudentXSLPOJO.getTransport());
				uploadStudentXSLVo.setTranscategory(uploadStudentXSLPOJO.getTranscategory());
				uploadStudentXSLVo.setTranslocation(uploadStudentXSLPOJO.getTranslocation());
				uploadStudentXSLVo.setDateofBirth(uploadStudentXSLPOJO.getDateofBirth());
				uploadStudentXSLVo.setAge(uploadStudentXSLPOJO.getAge());
				uploadStudentXSLVo.setGender(uploadStudentXSLPOJO.getGender());
				uploadStudentXSLVo.setIdentificationMarks(uploadStudentXSLPOJO.getIdentificationMarks());
				uploadStudentXSLVo.setBloodGroup(uploadStudentXSLPOJO.getBloodGroup());
				uploadStudentXSLVo.setReligion(uploadStudentXSLPOJO.getReligion());
				uploadStudentXSLVo.setCaste(uploadStudentXSLPOJO.getCaste());
				uploadStudentXSLVo.setMedicalhistory(uploadStudentXSLPOJO.getMedicalhistory());
				uploadStudentXSLVo.setPhysicallyChallenged(uploadStudentXSLPOJO.getPhysicallyChallenged());
				uploadStudentXSLVo.setNationality(uploadStudentXSLPOJO.getNationality());
				uploadStudentXSLVo.setPhysicalchalreason(uploadStudentXSLPOJO.getPhysicalchalreason());
				uploadStudentXSLVo.setRemarks(uploadStudentXSLPOJO.getRemarks());
				uploadStudentXSLVo.setStudentstatus(uploadStudentXSLPOJO.getStudentstatus());
				uploadStudentXSLVo.setSibilingadminno(uploadStudentXSLPOJO.getSibilingadminno());
				uploadStudentXSLVo.setSibilingClass(uploadStudentXSLPOJO.getSibilingClass());
				uploadStudentXSLVo.setSibilingName(uploadStudentXSLPOJO.getSibilingName());
				uploadStudentXSLVo.setPrimaryPerson(uploadStudentXSLPOJO.getPrimaryPerson());
				uploadStudentXSLVo.setFatherName(uploadStudentXSLPOJO.getFatherName());
				uploadStudentXSLVo.setFatherMobileNo(uploadStudentXSLPOJO.getFatherMobileNo());
				uploadStudentXSLVo.setFatherQualification(uploadStudentXSLPOJO.getFatherQualification());
				uploadStudentXSLVo.setFatheroccupation(uploadStudentXSLPOJO.getFatheroccupation());
				uploadStudentXSLVo.setFatheremailId(uploadStudentXSLPOJO.getFatheremailId());
				uploadStudentXSLVo.setMotherName(uploadStudentXSLPOJO.getMotherName());
				uploadStudentXSLVo.setMotherMobileNo(uploadStudentXSLPOJO.getMotherMobileNo());
				uploadStudentXSLVo.setMotherQualification(uploadStudentXSLPOJO.getMotherQualification());
				uploadStudentXSLVo.setMotheroccupation(uploadStudentXSLPOJO.getMotheroccupation());
				uploadStudentXSLVo.setMotheremailId(uploadStudentXSLPOJO.getMotheremailId());
				uploadStudentXSLVo.setGuardianName(uploadStudentXSLPOJO.getGuardianName());
				uploadStudentXSLVo.setGuardianemailId(uploadStudentXSLPOJO.getGuardianemailId());
				uploadStudentXSLVo.setGuardianMobileNo(uploadStudentXSLPOJO.getGuardianMobileNo());
				uploadStudentXSLVo.setAddress(uploadStudentXSLPOJO.getAddress());
				
				
				
				count = daoImpl.checkStudentID(uploadStudentXSLPOJO.getStudentAdmissionNo(),connection);
				checkcategory=daoImpl.checkCategorycode(uploadStudentXSLPOJO.getCategory(), connection);
				checkClassCode=daoImpl.checkClassCode(uploadStudentXSLPOJO.getClassname(), connection);
				checkSectionCode=daoImpl.checkSectionCode(uploadStudentXSLPOJO.getSectionname(),connection);
				System.out.println("getStudentFirstName:::"+uploadStudentXSLPOJO.getStudentFirstName());
				
				//System.out.println("outside loop"+uploadStudentXSLPOJO.getPrimaryPerson());
				

				if(uploadStudentXSLPOJO.getStudentFirstName()=="" || uploadStudentXSLPOJO.getStudentFirstName().equals("-")){
					System.out.println("FIRSTNAME");
					uploadStudentXSLVo.setReason("Student First Name Should Not Empty");
					failurelist.add(uploadStudentXSLVo);
				}
			   else if(!(uploadStudentXSLPOJO.getStudentFirstName().matches(string_regx))){
					System.out.println("FIRSTNAME REGEX");

				    uploadStudentXSLVo.setReason("Student First Name Should be Alphabet");
					failurelist.add(uploadStudentXSLVo);
				}
			  				
			   else if(uploadStudentXSLPOJO.getStudentAdmissionNo()=="" || uploadStudentXSLPOJO.getStudentAdmissionNo().equals("-")){
				   System.out.println("Admission Number");
					uploadStudentXSLVo.setReason("Student Admission No Should Not Empty");
					failurelist.add(uploadStudentXSLVo);
				}
			   else if(count!=0){
					System.out.println("Admission Number Already exist");

					uploadStudentXSLVo.setReason("Student Admission No Already Exist");
						failurelist.add(uploadStudentXSLVo);
			   }
			   else if(uploadStudentXSLPOJO.getStudentRegNo()=="" || uploadStudentXSLPOJO.getStudentRegNo().equals("-")){
					System.out.println("STUDENT REG NO");

					uploadStudentXSLVo.setReason("Student Application No Should Not Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				
			   else if(uploadStudentXSLPOJO.getDateofJoin()=="" || uploadStudentXSLPOJO.getDateofJoin().equals("-")){
					System.out.println("DATE OF JOIN");

					uploadStudentXSLVo.setReason("Student Date Of Join Should Not Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				
			   else if(uploadStudentXSLPOJO.getAcademicYear()=="" || uploadStudentXSLPOJO.getAcademicYear().equals("-")){
					System.out.println("ACADEMIC YEAR");

					uploadStudentXSLVo.setReason("Student Academic Year Should Not Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
			   else if(uploadStudentXSLPOJO.getCategory()=="" || uploadStudentXSLPOJO.getCategory().equals("-")){
					System.out.println("CATEGORY");

					uploadStudentXSLVo.setReason("Category Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
			   else if(uploadStudentXSLPOJO.getClassname()=="" || uploadStudentXSLPOJO.getClassname().equals("-")){
					System.out.println("CLASS NAME");

					uploadStudentXSLVo.setReason("Class Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
			   else if(uploadStudentXSLPOJO.getSectionname()=="" || uploadStudentXSLPOJO.getSectionname().equals("-")){
					System.out.println("SECTION NAME");

					uploadStudentXSLVo.setReason("Section Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}

				else if(uploadStudentXSLPOJO.getStudentquotaname()=="" || uploadStudentXSLPOJO.getStudentquotaname().equals("-")){
					System.out.println("QUOTA NAME");

					uploadStudentXSLVo.setReason("Quota Name Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				else if(uploadStudentXSLPOJO.getGrade()=="" || uploadStudentXSLPOJO.getGrade().equals("-")){
					System.out.println("GRADE");

					uploadStudentXSLVo.setReason("Grade Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				else if(uploadStudentXSLPOJO.getRte()=="" || uploadStudentXSLPOJO.getRte().equals("-")){
					System.out.println("RTE");

					uploadStudentXSLVo.setReason("RTE Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				else if(uploadStudentXSLPOJO.getHostel()=="" || uploadStudentXSLPOJO.getHostel().equals("-")){
					System.out.println("HOSTEL");

					uploadStudentXSLVo.setReason("Hostel Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				else if(uploadStudentXSLPOJO.getConcession_applicable()=="" || uploadStudentXSLPOJO.getConcession_applicable().equals("-")){
					System.out.println("CONCESSION APPLICABEL");

					uploadStudentXSLVo.setReason("Concession Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				else if(uploadStudentXSLPOJO.getConcession_type().equalsIgnoreCase("Y"))
				{
					
						if(uploadStudentXSLPOJO.getConcession_type()=="" || uploadStudentXSLPOJO.getConcession_type().equals("-"))
						{
							System.out.println("CONCESSION TYPE");

						uploadStudentXSLVo.setReason("Concession Type Should not be Empty");
						failurelist.add(uploadStudentXSLVo);

					}
						/*else{
							successlist.add(uploadStudentXSLPOJO);
							
						}*/
				}
				
				else if(uploadStudentXSLPOJO.getTransport()=="" || uploadStudentXSLPOJO.getTransport().equals("-")){
					
					System.out.println("TRANSPORT SHOULD NOT");

					uploadStudentXSLVo.setReason("Transport Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				else if( uploadStudentXSLPOJO.getTransport().equalsIgnoreCase("Y")){
					
				if(uploadStudentXSLPOJO.getTranscategory()=="" || uploadStudentXSLPOJO.getTransport().equals("-"))
						{
					System.out.println("TRANSPORT CATEGORY");

						uploadStudentXSLVo.setReason("Transport Category Should not be Empty");
						failurelist.add(uploadStudentXSLVo);

					    }
			
				else if(uploadStudentXSLPOJO.getTranslocation()=="" || uploadStudentXSLPOJO.getTranslocation().equalsIgnoreCase("-"))
					{
						System.out.println("TRANSPORT LOCATION");

						uploadStudentXSLVo.setReason("Transport Location Should not be Empty");
						failurelist.add(uploadStudentXSLVo);
					}
				else
				{
					successlist.add(uploadStudentXSLPOJO);
				}

				}
				
				else if(uploadStudentXSLPOJO.getDateofBirth()=="" || uploadStudentXSLPOJO.getDateofBirth().equals("-")){
					System.out.println("DATE OF BIRTH");

					uploadStudentXSLVo.setReason("Enter Date of Birth");
					failurelist.add(uploadStudentXSLVo);
				}
				
				
				
		     else if(!(uploadStudentXSLPOJO.getDateofBirth().matches(datePattern))){
					System.out.println("DATE OF BIRTH");

					uploadStudentXSLVo.setReason("Enter Correct DOB (dd/mm/yyyy");
					failurelist.add(uploadStudentXSLVo);
				}
				
				
				else if(uploadStudentXSLPOJO.getGender()==""  || uploadStudentXSLPOJO.getGender().equals("-")){
					System.out.println("GENDER");

					uploadStudentXSLVo.setReason("Gender Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				else if(uploadStudentXSLPOJO.getIdentificationMarks()=="" || uploadStudentXSLPOJO.getIdentificationMarks().equals("-")){
					System.out.println("IDENTIFICATION MARKS");

					uploadStudentXSLVo.setReason("Identification Marks Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				else if(uploadStudentXSLPOJO.getBloodGroup()==""  || uploadStudentXSLPOJO.getBloodGroup().equals("-")){
					System.out.println("BLOOD GROUP");

					uploadStudentXSLVo.setReason("Blood Group Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				else if(uploadStudentXSLPOJO.getReligion()==""  || uploadStudentXSLPOJO.getReligion().equals("-")){
					System.out.println("RELIGION");

					uploadStudentXSLVo.setReason("Religion Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				else if(uploadStudentXSLPOJO.getCaste()==""  || uploadStudentXSLPOJO.getCaste().equals("-")){
					System.out.println("CASTE");

					uploadStudentXSLVo.setReason("Caste Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				else if(uploadStudentXSLPOJO.getNationality()==""  || uploadStudentXSLPOJO.getNationality().equals("-")){
					System.out.println("NATIONALITY");

					uploadStudentXSLVo.setReason("Nationality Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				else if(uploadStudentXSLPOJO.getPhysicallyChallenged()=="" || uploadStudentXSLPOJO.getPhysicallyChallenged().equals("-")){
					System.out.println("PHYSICAL CHALLENGED");

					uploadStudentXSLVo.setReason("Physicall Challenged Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				
				
				else if(uploadStudentXSLPOJO.getPhysicallyChallenged()=="YES" || uploadStudentXSLPOJO.getPhysicallyChallenged().equals("YES"))
				{
					System.out.println("PHYSICAL CHALLENGE YES");

					if(uploadStudentXSLPOJO.getPhysicalchalreason()=="" || uploadStudentXSLPOJO.getPhysicalchalreason().equals("-"))
					{
						System.out.println("PHYSICAL REASON");

						uploadStudentXSLVo.setReason("Physicall Challenged Reason Should not be Empty");
						failurelist.add(uploadStudentXSLVo);
					}
					else{
						successlist.add(uploadStudentXSLPOJO);
					}
				}
				
				else if(uploadStudentXSLPOJO.getStudentstatus()=="" || uploadStudentXSLPOJO.getStudentstatus().equals("-")){
					System.out.println("STATUS");

					uploadStudentXSLVo.setReason("Status Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				} 
				
				else if(uploadStudentXSLPOJO.getPrimaryPerson()=="" || uploadStudentXSLPOJO.getPrimaryPerson().equals("-")){
					System.out.println("PRIMARY PERSON");

					uploadStudentXSLVo.setReason("Primary Person Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				} 
				else if(uploadStudentXSLPOJO.getFatherName()=="" || uploadStudentXSLPOJO.getFatherName().equals("-"))
				{
					System.out.println("FATHER NAME");

					uploadStudentXSLVo.setReason("Father Name Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				 else if(!(uploadStudentXSLPOJO.getFatherName().matches(string_regx))){
						System.out.println("FTHER ALPHABET ONLY");

						uploadStudentXSLVo.setReason("Father Name Should be Alphabet");
						failurelist.add(uploadStudentXSLVo);
				}
				
			
					
				
				else if(uploadStudentXSLPOJO.getPrimaryPerson().trim().equalsIgnoreCase("father"))
				{
					System.out.println("PRIMARY PERSON:::FATHER");
					System.out.println("uploadStudentXSLPOJO.getFatherQualification()" +uploadStudentXSLPOJO.getFatherQualification().length());
					
					if(uploadStudentXSLPOJO.getFatherQualification().trim()=="" || uploadStudentXSLPOJO.getFatherQualification().trim().equals("-"))
						{
						System.out.println("Father Qualification");

							uploadStudentXSLVo.setReason("Father Qualification Should not be Empty");
							failurelist.add(uploadStudentXSLVo);
						}
					 
					 else if(uploadStudentXSLPOJO.getFatherMobileNo().trim()=="" || uploadStudentXSLPOJO.getFatherMobileNo().trim().equals("-"))
						{
							System.out.println("Father MOBILE");
	
						 uploadStudentXSLVo.setReason("Father Mobile Number Should not be Empty");
							failurelist.add(uploadStudentXSLVo);
						}
					 else if(!(uploadStudentXSLPOJO.getFatherMobileNo().matches(int_regex))){
							uploadStudentXSLVo.setReason("Enter Valid Father Mobile Number");
							failurelist.add(uploadStudentXSLVo);
						}
						
						
						else if(uploadStudentXSLPOJO.getFatherMobileNo().trim().length() > 10 || uploadStudentXSLPOJO.getFatherMobileNo().trim().length() < 10){
							uploadStudentXSLVo.setReason("Length of Father Mobile Number No should be 10");
							failurelist.add(uploadStudentXSLVo);
						}
						else{
							successlist.add(uploadStudentXSLPOJO);
						}
				}
			
				
				
				
				
				else if(uploadStudentXSLPOJO.getMotherName()=="" || uploadStudentXSLPOJO.getMotherName().equals("-"))
				{
					System.out.println("MOTHER ");
					
					uploadStudentXSLVo.setReason("Mother Name Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				 else if(!(uploadStudentXSLPOJO.getMotherName().matches(string_regx))){
						uploadStudentXSLVo.setReason("Mother Name Should be Alphabet");
						failurelist.add(uploadStudentXSLVo);
				}
			
				
				
				
				else if(uploadStudentXSLPOJO.getPrimaryPerson().trim().equalsIgnoreCase("mother"))
				{
					System.out.println("PRIMARYPERSON:::MOTHER" +uploadStudentXSLPOJO.getMotherQualification());

					
					if(uploadStudentXSLPOJO.getMotherQualification().trim()=="" || uploadStudentXSLPOJO.getMotherQualification().trim().equals("-"))
						{
						System.out.println("MOTHER Qualification");

							uploadStudentXSLVo.setReason("Mother Qualification Should not be Empty");
							failurelist.add(uploadStudentXSLVo);
						}
					 
					 else if(uploadStudentXSLPOJO.getMotherMobileNo().trim()=="" || uploadStudentXSLPOJO.getMotherMobileNo().trim().equals("-"))
						{
							System.out.println("MOTHER  MOBILE");

							uploadStudentXSLVo.setReason("Mother Mobile Number Should not be Empty");
							failurelist.add(uploadStudentXSLVo);
						}
					 else if(!(uploadStudentXSLPOJO.getMotherMobileNo().matches(int_regex))){
							uploadStudentXSLVo.setReason("Enter Valid Mother Mobile Number");
							failurelist.add(uploadStudentXSLVo);
						}
						
						
						else if(uploadStudentXSLPOJO.getMotherMobileNo().length() > 10 || uploadStudentXSLPOJO.getMotherMobileNo().length() < 10){
							uploadStudentXSLVo.setReason("Length of Mother Mobile Number No should be 10");
							failurelist.add(uploadStudentXSLVo);
						}
						else{
							successlist.add(uploadStudentXSLPOJO);
						}
				}
			
				
				
				else if(uploadStudentXSLPOJO.getGuardianName()=="" || uploadStudentXSLPOJO.getGuardianName().equals("-"))
				{
					System.out.println("GUARDIAN NAME");

					uploadStudentXSLVo.setReason("Guardian Name Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
				 else if(!(uploadStudentXSLPOJO.getGuardianName().matches(string_regx))){
						uploadStudentXSLVo.setReason("Guardian Name Should be Alphabet");
						failurelist.add(uploadStudentXSLVo);
				}
			
				
				
				
				else if(uploadStudentXSLPOJO.getPrimaryPerson()=="guardian" || uploadStudentXSLPOJO.getPrimaryPerson().equals("guardian"))
				{
					System.out.println("PRIMARYPERSON::::GUARDIAN NAME");

				
					if(uploadStudentXSLPOJO.getGuardianMobileNo().trim()=="" || uploadStudentXSLPOJO.getGuardianMobileNo().trim().equals("-"))
						{
						System.out.println("Guardian Mobile");

							uploadStudentXSLVo.setReason("Guardian Mobile Number Should not be Empty");
							failurelist.add(uploadStudentXSLVo);
						}
					
					else if(!(uploadStudentXSLPOJO.getGuardianMobileNo().matches(int_regex))){
						uploadStudentXSLVo.setReason("Enter Valid Guardian Mobile Number");
						failurelist.add(uploadStudentXSLVo);
					}
					
					
					else if(uploadStudentXSLPOJO.getGuardianMobileNo().length() > 10 || uploadStudentXSLPOJO.getGuardianMobileNo().length() < 10){
						uploadStudentXSLVo.setReason("Length of Guardian Mobile Number No should be 10");
						failurelist.add(uploadStudentXSLVo);
					}
					else{
						successlist.add(uploadStudentXSLPOJO);
					}
					
				}
				else if(uploadStudentXSLPOJO.getAddress()=="" || uploadStudentXSLPOJO.getAddress().equals("-"))
				{
					System.out.println("ADDRESS");

					uploadStudentXSLVo.setReason("Address Should not be Empty");
					failurelist.add(uploadStudentXSLVo);
				}
			
				
		else if(checkcategory==0){
			System.out.println("Stream Doesn't Exist");

			uploadStudentXSLVo.setReason("Stream Doesn't Exist");
			failurelist.add(uploadStudentXSLVo);
			}
				
		else if(checkClassCode==0){
			System.out.println("CLASS Doesn't Exist");

			uploadStudentXSLVo.setReason("Class Doesn't Exist");
			failurelist.add(uploadStudentXSLVo);
			}
				
				
		else if(checkSectionCode==0){
			System.out.println("SECTION Doesn't Exist");

			uploadStudentXSLVo.setReason("Section Doesn't Exist");
			failurelist.add(uploadStudentXSLVo);
			}
				
				
		
					/*successlist.add(uploadStudentXSLPOJO);
					System.out.println("successlist.size()"+successlist.size());*/
     	
				
		else
		{
			
			System.out.println("Inside Else Block");
				successlist.add(uploadStudentXSLPOJO);
				System.out.println("successlist.size()"+successlist.size());
				
				JSONArray j=new JSONArray(successlist);
				System.out.println("j:::"+j);
		}
				
		}
			
		
			
			String success=daoImpl.insertEmpXSL(successlist,connection);
		
		}catch (SQLException sqle) {

			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);

		}finally{
			
			try {
				
				if(connection!=null && (!connection.isClosed())){
					
					connection.close();
				}
			
			} catch (SQLException sqle) {
				   sqle.printStackTrace();
					logger.error(sqle.getMessage(), sqle);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);

			}
		}

		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLServiceImpl : insertEmpXSL : Ending");

		return failurelist;
	}

}
