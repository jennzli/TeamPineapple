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
 * Servlet implementation class ManageSurveyServlet
 */
@WebServlet("/ManageSurveyServlet")
public class ManageSurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageSurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String surveyId = request.getParameter("surveyId");
		String task = request.getParameter("task");
		
		System.out.println(" in do get method of manage survery  "+surveyId+"\t"+task);
		SurveyDAO sDAO = new SurveyDAO();
		if(task.equalsIgnoreCase("delete")) {
			Boolean resutl =sDAO.deleteAsurvey(surveyId);
			request.setAttribute("SURVEY_DELETED", resutl);
			
			RequestDispatcher rd =  request.getRequestDispatcher("delete_success.html"); 
			//request.setAttribute("SEARCH_RESULT",searchInput);
			rd.forward(request, response);
			
		}else if(task.equalsIgnoreCase("edit")) {
			SurveyPO surveyPO = new SurveyPO();
			StringBuffer sb = new StringBuffer(" WHERE ID ="+surveyId);
			List<SurveyPO> poList=sDAO.getSurveyDetails(surveyPO, sb.toString());
			
			System.out.println("servery po list for edit view.... ="+poList);
			request.setAttribute("SURVEY_POLIST_EDIT", poList);
			
			RequestDispatcher rd =  request.getRequestDispatcher("editsurvey.jsp"); 
			//request.setAttribute("SEARCH_RESULT",searchInput);
			rd.forward(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in SurveyServlet do post method...");
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String ristriction = request.getParameter("ristriction");
		String slinks = request.getParameter("slinks");
		String department = request.getParameter("department");
		String sId = request.getParameter("surId");
		
		
		SurveyPO po = new SurveyPO();
		po.setId(new Integer(sId));
		po.setName(name.trim());
		po.setDescription(description);
		po.setRestriction(ristriction);
		po.setDepartment(department.trim());
		po.setUrlLinks(slinks);
		
		System.out.println("survey po in ManageSurvey servlet dopost method ="+po);
		SurveyDAO dao=new SurveyDAO();
		boolean result =dao.updateSurvey(po);
		request.setAttribute("SURVEY_EDITED_SUCCESS",result);
		
		System.out.println("result value in manage survey do post method: = "+result);
		if(result) {
			SurveyPO surveyPO = new SurveyPO();
			StringBuffer sb = new StringBuffer(" WHERE ID ="+sId);
			List<SurveyPO> poList=dao.getSurveyDetails(surveyPO, sb.toString());
			System.out.println("servery po list after edit .... ="+poList);
			request.setAttribute("SURVEY_POLIST_EDIT", poList);
		
			RequestDispatcher rd =  request.getRequestDispatcher("editsurvey.jsp"); 
			rd.forward(request, response);
		}else {
			RequestDispatcher rd =  request.getRequestDispatcher("error.jsp"); 
			rd.forward(request, response);
		}
		
		//System.out.println("RETURN SURVERY OBJECT: "+returnPO);
		
		//doGet(request, response);
	}

}
