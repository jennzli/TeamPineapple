package com.survey.connect.util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neha.bean.SurveyPO;

public abstract class DataBuilder {

	public static List<SurveyPO> buildSurveyData(ResultSet rs, SurveyPO pojo) throws Exception{
		List<SurveyPO> poList = new ArrayList<SurveyPO>();
		while (rs != null && rs.next()) {
			SurveyPO po=new SurveyPO();
			po.setId(rs.getInt("ID"));
			po.setName(rs.getString("NAME"));
			po.setDepartment(rs.getString("DEPARTMENT"));
			po.setDescription(rs.getString("DESCRIPTION"));
			po.setRestriction(rs.getString("RESTRICTION"));
			po.setUrlLinks(rs.getString("URL_LINKS"));
			po.setOwner(rs.getString("CREATED_BY"));
			po.setDatecreated(rs.getTimestamp("CREATED_ON"));

			poList.add(po);
		}
			
		return poList;
	}
	public static List<SurveyPO> getDepartments(){
		List<SurveyPO> poList = new ArrayList<SurveyPO>();
		String[] departs = {"African", "African American and Diaspora Studies", 
			    "Air Force ROTC", "Allied Health", "American Studies", "Anesthesiology", 
			    "Anthropology", "Applied Physical Sciences", "Archaeology", "Army ROTC", 
			    "Art and Art History", "Asian Studies", "Biochemistry and Biophysics",
			    "Biology", "Biomedical Engineering", "Biostatistics","Cell Biology and Physiology",
			    "Chemistry", "Chinese", "City and Regional Planning", "Classics", "Communication",
			    "Computer Science", "Dermatology", "Dramatic Art", "Economics", "English and Comparative Literature", 
			    "Environmental Sciences and Engineering", "Epidemiology", "Exercise and Sport Science", 
			    "Family Medicine", "French", "Genetics","General", "Geography", "Geological Sciences", 
			    "Germanic and Slavic Languages and Literatures", "Global Business Center", "Health Behavior",
			    "Health Policy and Management", "History", "Italian", "Linguistics", "Marine Sciences",
			    "Maternal and Child Health", "Mathematics", "Medicine", "Microbiology and Immunology", "Military Science", 
			    "Music", "Navy ROTC", "Neurology", "Nutrition", "Obstetrics and Gynecology", "Operations Research", "Ophthalmology", 
			    "Orthopaedics", "Otolaryngology", "Pathology", "Pediatrics", "Pharmacology", "Philosophy", 
			    "Physical Medicine & Rehabilitation", "Physics and Astronomy", "Political Science", 
			    "Portuguese", "Psychiatry", "Psychology and Neuroscience", "Public Policy", "Religious Studies",
			    "Romance Studies", "Slavic Languages and Literatures", "Social Medicine", "Sociology",
			    "Spanish", "Statistics and Operations Research", "Surgery", "Women’s and Gender Studies"};
		
		
		for(int i=0;i<departs.length;i++) {
			String dept =departs[i];
			//System.out.println(dept);
			SurveyPO po = new SurveyPO();
			po.setDepartment(dept);
			poList.add(po);
		}
		return poList;
		
	}
	public static String buildAwhereClause(String searchByName, String selectedDept) {
		StringBuffer sb = new StringBuffer(" WHERE NAME='"+searchByName+"'" +" AND DEPARTMENT='"+selectedDept+"'");
		
		
		return sb.toString();
	}
}
