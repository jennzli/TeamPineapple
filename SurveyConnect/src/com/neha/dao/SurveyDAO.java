package com.neha.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neha.bean.SurveyPO;
import com.survey.connect.util.DataBuilder;

public class SurveyDAO {
	
	public boolean addSurvey(SurveyPO po) {
		
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		
		
		SurveyPO retPo = new SurveyPO();
		String insertSql="INSERT INTO SURVEY_CONTENT (NAME,DEPARTMENT,DESCRIPTION,RESTRICTION,URL_LINKS, CREATED_BY, CREATED_ON) VALUES (?,?,?,?,?,?,?)";
		MysqlConnection myConn = new MysqlConnection();
		Connection connection = null;
		try {
			connection = myConn.getConnection();
			PreparedStatement preparedStmt = connection.prepareStatement(insertSql);
		
			preparedStmt.setString(1, po.getName());
			preparedStmt.setString(2, po.getDepartment());
			preparedStmt.setString(3, po.getDescription());
			preparedStmt.setString(4, po.getRestriction());
			preparedStmt.setString(5, po.getUrlLinks());
			preparedStmt.setString(6, po.getOwner());
			preparedStmt.setTimestamp(7, sqlTime);
			preparedStmt.execute();
			
			connection.close();
			
			
	      return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
	 return false;
	}
	public List<SurveyPO> getSurveyDetails(SurveyPO po, String whereClause) {
		
		List<SurveyPO> poList = new ArrayList<SurveyPO>();
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		MysqlConnection myConn = new MysqlConnection();
		String selectSql=null;
		if(whereClause!=null) {
			selectSql= "SELECT ID,NAME,DEPARTMENT,DESCRIPTION,RESTRICTION,URL_LINKS, CREATED_BY, CREATED_ON FROM SURVEY_CONTENT "+whereClause;
		}else {
			selectSql= "SELECT ID,NAME,DEPARTMENT,DESCRIPTION,RESTRICTION,URL_LINKS, CREATED_BY,CREATED_ON FROM SURVEY_CONTENT";
		}try {
			connection = myConn.getConnection();
			System.out.println("SEARCH SELECT QUERY: ="+selectSql);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectSql);
			poList=DataBuilder.buildSurveyData(resultSet, po);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return poList;
	}


	public Boolean deleteAsurvey(String id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		MysqlConnection myConn = new MysqlConnection();
		String deleteSql=null;
		deleteSql= "DELETE FROM SURVEY_CONTENT WHERE ID="+id;
		try {
		connection = myConn.getConnection();
		System.out.println("delete QUERY: ="+deleteSql);
		statement = connection.createStatement();
		statement.executeUpdate(deleteSql);
		 	return Boolean.TRUE;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return Boolean.FALSE;
		
	}
	
	public boolean updateSurvey(SurveyPO po) {
		SurveyPO retPo = new SurveyPO();
		String updateSql="UPDATE SURVEY_CONTENT set NAME=?,DEPARTMENT=?,DESCRIPTION=?,RESTRICTION=?,URL_LINKS=? where id=?";
		MysqlConnection myConn = new MysqlConnection();
		Connection connection = null;
		try {
		System.out.println("UPDATE SQL: ="+updateSql);
		connection = myConn.getConnection();
		PreparedStatement preparedStmt = connection.prepareStatement(updateSql);
		;
		preparedStmt.setString(1, po.getName());
		preparedStmt.setString(2, po.getDepartment());
		preparedStmt.setString(3, po.getDescription());
		preparedStmt.setString(4, po.getRestriction());
		preparedStmt.setString(5, po.getUrlLinks());
		preparedStmt.setInt(6, po.getId());


		preparedStmt.executeUpdate();

		connection.close();
		
		return true;
		
		}catch(Exception e) {
		e.printStackTrace();
		}
		 return false;
		
	}
	
}
