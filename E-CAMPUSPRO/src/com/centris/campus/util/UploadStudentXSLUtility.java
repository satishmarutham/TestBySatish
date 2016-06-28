package com.centris.campus.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.upload.FormFile;
import org.json.JSONArray;

import com.centris.campus.pojo.UploadStudentXlsPOJO;



public class UploadStudentXSLUtility {

	FileOutputStream outstream;
    String errorId=null;
	private static Logger logger = Logger.getLogger(UploadStudentXSLUtility.class);


	public Map<String, Object> getExcelData(File fileURL, FormFile file) {
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLUtility : getExcelData : Starting");

		ArrayList<UploadStudentXlsPOJO> employeelist = new ArrayList<UploadStudentXlsPOJO>();
	
		ArrayList<Object> sheetcountlist = new ArrayList<Object>();
         Map<String,Object> map=new HashMap<String,Object>();
		try {
			outstream = new FileOutputStream(fileURL);
			outstream.write(file.getFileData());

			if (!fileURL.exists()) {
				FileOutputStream fileOutStream = new FileOutputStream(fileURL);
				fileURL.mkdir();
				fileOutStream.write(file.getFileData());
				fileOutStream.flush();
				fileOutStream.close();
			}

			FileInputStream inputstream = new FileInputStream(fileURL);
			XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			XSSFRow row;
			XSSFCell cell;

			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				row = (XSSFRow) rows.next();

				for (int i = 0; i < 49; i++) {

					cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);

					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_BLANK:
						System.out.println("blank===>>>"
								+ cell.getStringCellValue() + "\t");
						String listofString1 = cell.getStringCellValue()
								.toString().trim();
						sheetcountlist.add(listofString1);

						System.out.println("count" + sheetcountlist.size());
						break;

					case Cell.CELL_TYPE_BOOLEAN:
						System.out.println("boolean===>>>"
								+ cell.getBooleanCellValue() + "\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							String dateStr = cell.getDateCellValue().toString()
									.trim();

							DateFormat formatter = new SimpleDateFormat(
									"E MMM dd HH:mm:ss Z yyyy");
							Date date1 = (Date) formatter.parse(dateStr);

							Calendar cal = Calendar.getInstance();
							cal.setTime(date1);
							String formatedDate = cal.get(Calendar.DATE) + "-"
									+ (cal.get(Calendar.MONTH) + 1) + "-"
									+ cal.get(Calendar.YEAR);
							System.out.println("formatedDate" + formatedDate);
							sheetcountlist.add(formatedDate);

						} else {

							String sheetNumber = ((long) cell
									.getNumericCellValue()) + "";
							System.out.println("cell numeric value===>>"
									+ sheetNumber);
							sheetcountlist.add(sheetNumber.trim());
						}

						break;
					case Cell.CELL_TYPE_STRING:
						String listofString = cell.getStringCellValue()
								.toString().trim();
						System.out.println("string===>>>"
								+ cell.getStringCellValue() + "\t");
						sheetcountlist.add(listofString);
						break;
					}

				}

			}
			
			for (int i = 49; i <= sheetcountlist.size() - 49;) {
				
				System.out.println("inside for loop");

				UploadStudentXlsPOJO uploadStuXSLPOJO = new UploadStudentXlsPOJO();
				
				String studentid=sheetcountlist.get(i).toString();
				
				uploadStuXSLPOJO.setStudentFirstName(sheetcountlist.get(i).toString());
				i++;
				
				String studentname=sheetcountlist.get(i).toString();
				
				uploadStuXSLPOJO.setStudentLastName(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setStudentAdmissionNo(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setStudentRegNo(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setDateofJoin(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setAcademicYear(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setCategory(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setClassname(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setSectionname(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setStudentquotaname(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setGrade(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setRte(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setEmisNo(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setHostel(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setConcession_applicable(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setConcession_type(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setTransport(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setTranscategory(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setTranslocation(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setDateofBirth(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setAge(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setGender(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setIdentificationMarks(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setBloodGroup(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setReligion(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setCaste(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setMedicalhistory(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setNationality(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setPhysicallyChallenged(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setPhysicalchalreason(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setRemarks(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setStudentstatus(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setStudentsiblingname(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setStudentsiblingadmission(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setStudentsiblingclass(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setPrimaryPerson(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setFatherName(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setFatherMobileNo(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setFatherQualification(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setFatheroccupation(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setFatheremailId(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setMotherName(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setMotherMobileNo(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setMotherQualification(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setMotheremailId(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setGuardianName(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setGuardianMobileNo(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setGuardianemailId(sheetcountlist.get(i).toString());
				i++;
				uploadStuXSLPOJO.setAddress(sheetcountlist.get(i).toString());
				
				
				boolean duplicateList=checkDuplicate(employeelist,studentid);
				if(!duplicateList){
				employeelist.add(uploadStuXSLPOJO);
				}
				else{
					
					map.put("Error","StudentName:"+studentname+" with this StudentId:"+studentid +" is Already Exits in Excel Sheet");
				}
				i++;
				
			
			map.put("List",employeelist);
				
			
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		}

		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadEmpXSLDaoImpl : getExcelData : Ending");
		return map;
	}
	
	public boolean checkDuplicate(List<UploadStudentXlsPOJO> li,String studentid){
		boolean flag=false;
		
		System.out.println("li.size():::"+li.size());
		for(int i=0;i<li.size();i++){
			if(li.get(i).getStudentRegNo().equals(studentid)){
				errorId="Duplicate Entry of Student Id Please Check It";
				flag=true;
				break;
			}
		}
		
		
		
		return flag;
		
	}
	
	

}
