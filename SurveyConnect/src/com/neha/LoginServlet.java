package com.neha;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neha.bean.SurveyPO;
import com.neha.bean.UserPO;
import com.neha.dao.SurveyDAO;
import com.neha.dao.UserDAO;
import com.survey.connect.util.DataBuilder;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("this is get");
		//response.getWriter().append("Successfully logged in ");
		//response.sendRedirect("http://localhost:8080/SurveyConnect/login.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get username and pass from browser and printing on console, making sure 
				//that what ever u are entering in html is comin gto server
				String email = request.getParameter("emaillogin");
				String password = request.getParameter("passwordlogin");
				System.out.println("email = " + email);
				System.out.println("password = " + password);
				//send username and pass to database and 
				//validate against the database value/credentials here: TO DO
	
				HttpSession session = request.getSession();
				//session stays even if u navigate from page to page
				session.removeAttribute("GMAIL_USERID");
		UserDAO userDao = new UserDAO();
		boolean returnValue = userDao.validateUser(email, password);
		
		if(returnValue == true) {
			RequestDispatcher rd =  request.getRequestDispatcher("dashboard.jsp");
			
			UserDAO dao = new UserDAO();
			UserPO po = dao.getUserProfile(request.getParameter("emaillogin"));
			session.setAttribute("PROFILE_RESULT", po);
			//if login successful bring departments list to display in dashboard drop down window
			//SurveyDAO surveyDAO = new SurveyDAO();
			//String whereClause=null; // since we want get all rows in SEARCHA_CONTENT table where clasue should be null
			//SurveyPO surveyPO = new SurveyPO();
			//List<SurveyPO> poList=surveyDAO.getSurveyDetails(surveyPO, whereClause);
			//System.out.println("servery po list: ="+poList);
			
			List<SurveyPO> poDeptList= DataBuilder.getDepartments();
			//System.out.println("NEW DEPT LIST: "+poDeptList);
			
			session.setAttribute("SURVEY_POLIST_DEPT", poDeptList);
			
			
			
			rd.forward(request, response); 
		} else {
			RequestDispatcher rd =  request.getRequestDispatcher("login.jsp"); 
			request.setAttribute("LOGIN_RESULT", "Login Failed. Your Username/Password was incorrect");
			rd.forward(request, response); 

		}
		System.out.println(request.getAttribute("LOGIN_RESULT"));
		
		//response.sendRedirect("http://localhost:8080/SurveyConnect/login.jsp");
		
				//doGet(request, response);
			}

	}




