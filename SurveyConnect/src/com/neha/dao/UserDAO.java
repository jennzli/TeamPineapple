package com.neha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.neha.bean.UserPO;

public class UserDAO {

	public boolean validateUser(String username, String password) {

		MysqlConnection myConn = new MysqlConnection();
		// connection betwn userdao and mysqlconn object
		Connection connection = myConn.getConnection();

		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// connection = connecting to database
			// statement = sql = select stuff, this declares that statement
			// after execution, data will come into result set

			String sql = "SELECT EMAIL, PASSWORD FROM USER_SIGNUP WHERE EMAIL = '" + username
					+ "' and PASSWORD = '" + password + "'";

			System.out.println(sql);
			// interacting w data base -- connection between userdao
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet != null && resultSet.next()) {
				// if this executes, it is vaiid --> return from herem dont execute anything
				// after this
				System.out.println("i am in while");
				//return "Successfully logged in!";
				return true;

			}

//			while (resultSet != null && resultSet.next()) {
//				// retrieving from result set object (which has database values)
//				String email = resultSet.getString("EMAIL");
//				String pass = resultSet.getString("PASSWORD");
//				System.out.println("email from database= " + email);
//				System.out.println("pass from database= " + pass);
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("i suck");

		// if while didnt exe3cute
		//return "Login Failed. Your Username/Password was incorrect";
		return false;
	}

	public String createUser(UserPO po) {
		// create/pass java object
		MysqlConnection myConn = new MysqlConnection();
		Connection connection = myConn.getConnection();

		try {
			String insertSql = "INSERT INTO USER_SIGNUP(EMAIL,PASSWORD,REPEAT_PW,ACCOUNT_TYPE, DEPT, EXPECTED_GRAD, MAJOR, POSITION) VALUES(?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStmt = connection.prepareStatement(insertSql);
			;
			preparedStmt.setString(1, po.getEmail());
			preparedStmt.setString(2, po.getPassword());
			preparedStmt.setString(3, po.getRepeatPassword());
			preparedStmt.setString(4, po.getAccountType());
			preparedStmt.setString(5, po.getDepartment());
			preparedStmt.setString(6, po.getGradYear());
			preparedStmt.setString(7, po.getMajor());
			preparedStmt.setString(8, po.getPosition());

			preparedStmt.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public UserPO getUserProfile(String email) {
		// create new object of UserPO
		// set vals from database--> need to select values from database like we did in
		String sql = "SELECT MAJOR, EXPECTED_GRAD, ACCOUNT_TYPE,DEPT,POSITION FROM USER_SIGNUP WHERE EMAIL = '" + email +"'";
		UserPO po = new UserPO();
		// todo: fetch vals from db and set to po object

		MysqlConnection myConn = new MysqlConnection();
		// connection betwn userdao and mysqlconn object
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = myConn.getConnection();
			System.out.println(sql);
			// interacting w data base -- connection between userdao
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet != null && resultSet.next()) {
				// if this executes, it is vaiid --> return from herem dont execute anything
	
				String major = resultSet.getString("MAJOR");
				String year = resultSet.getString("EXPECTED_GRAD");
				String accountType = resultSet.getString("ACCOUNT_TYPE");
				String dept = resultSet.getString("DEPT");
				String position = resultSet.getString("POSITION");
				

				
				po.setMajor(major);
				po.setGradYear(year);	
				po.setAccountType(accountType);
				po.setDepartment(dept);
				po.setPosition(position);
				po.setEmail(email);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return po;

	}
	
	
}
