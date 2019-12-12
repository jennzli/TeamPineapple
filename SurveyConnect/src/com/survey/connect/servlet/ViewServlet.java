package com.survey.connect.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neha.bean.SurveyPO;
import com.neha.dao.SurveyDAO;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("sid");
		
		System.out.println("I am in do get method"+sid);
		StringBuffer sb = new StringBuffer(" WHERE ID ="+sid);
	
		
		SurveyDAO surveyDAO = new SurveyDAO();
		SurveyPO surveyPO = new SurveyPO();
		List<SurveyPO> poList=surveyDAO.getSurveyDetails(surveyPO, sb.toString());
		
		System.out.println("servery po list for a search view.... ="+poList);
		request.setAttribute("SURVEY_POLIST_VIEW", poList);
		
		RequestDispatcher rd =  request.getRequestDispatcher("viewsurvey.jsp"); 
		//request.setAttribute("SEARCH_RESULT",searchInput);
		rd.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am in do post method");
		
		//doGet(request, response);
	}

}
