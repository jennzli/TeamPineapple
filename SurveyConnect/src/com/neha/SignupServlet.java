package com.neha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neha.bean.UserPO;
import com.neha.dao.UserDAO;


/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//String email = request.getParameter("emaillogin"); --> getuser prof
		//todo: call userdao get usre profile method from here 
		// 	String returnValue = userDao.validateUser(email, password);
		///request.setAttribute("LOGIN_RESULT", returnValue);--> instead of ret value, put userpo, PROFILE_RESULT
		//* in jsp, import userpo class --> po.get email stuff display like error pafe
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//bundling diff values w object
		String email = request.getParameter("emaillogin");
		String password = request.getParameter("passwordlogin");
		String repPassword = request.getParameter("repassid");// get repassid from new html
		String accountType = request.getParameter("accountType"); // get accid from new html/ decide if we need tto hae	// something like a choosee
		String department = request.getParameter("myInput");
		String gradYear = request.getParameter("year");
		String major = request.getParameter("major");
		String position = request.getParameter("position");
		
		
		UserPO po = new UserPO();
		po.setEmail(email);
		po.setPassword(password);
		po.setRepeatPassword(repPassword);
		po.setAccountType(accountType); 
		po.setDepartment(department);
		po.setGradYear(gradYear);
		po.setMajor(major);
		po.setPosition(position);
		
		System.out.println("hello my PO obj" + po);
		//insertting data into DB
		UserDAO dao = new UserDAO();
		dao.createUser(po);
		
		RequestDispatcher rd =  request.getRequestDispatcher("signup_success.html"); 
		//request.setAttribute("LOGIN_RESULT", "Login Failed. Your Username/Password was incorrect");
		rd.forward(request, response);
		
//		
//		System.out.println("email =" + email + "\t "+"password= " + password + "\t "+"reppass= " + 
//		repPassword+ "\t "+"acctype= " + accountType + "\t "+"dept= " + department + "\t "+"gradyear= " + gradYear
//		+ "\t "+"major= " + major + "\t "+"position= " + position);
		
		//doGet(request, response);
	}

}
