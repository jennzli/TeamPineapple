package com.survey.connect.servlet;

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
import com.neha.dao.SurveyDAO;

/**
 * Servlet implementation class SurveyServlet
 */
@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchInput = request.getParameter("searchInput");
		String selectedDept = request.getParameter("deptId").trim();
		HttpSession session = request.getSession();
		
		
		System.out.println("request coming from search page..."+searchInput.length()+"\t"+selectedDept);
		
		StringBuffer sb = new StringBuffer(" ");
		if(selectedDept!=null && selectedDept.equalsIgnoreCase("Choose one")) {
			sb.append("WHERE NAME like '%"+searchInput+"%'");
		}else if(selectedDept!=null && !selectedDept.equalsIgnoreCase("Choose one")) {
			sb.append("WHERE DEPARTMENT='"+selectedDept+"'");
		
		}else {
			sb.append("WHERE NAME like '%"+searchInput+"%'" +" AND DEPARTMENT='"+selectedDept+"'");
		}
		//StringBuffer sb = new StringBuffer(" WHERE NAME like '%"+searchInput+"%'" +" AND DEPARTMENT like '%"+selectedDept+"%'");
		
		SurveyDAO surveyDAO = new SurveyDAO();
		SurveyPO surveyPO = new SurveyPO();
		List<SurveyPO> poList=surveyDAO.getSurveyDetails(surveyPO, sb.toString());
		
		System.out.println("servery po list for a search ="+poList);
		request.setAttribute("SURVEY_POLIST_SEARCH", poList);
		
		RequestDispatcher rd =  request.getRequestDispatcher("dashboard.jsp"); 
		request.setAttribute("SEARCH_RESULT",searchInput);
		rd.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String ownername = request.getParameter("ownername");

		System.out.println("ownername from servlet:" + ownername);
		
		
		SurveyPO po = new SurveyPO();
		po.setName(name.trim());
		po.setDescription(description);
		po.setRestriction(ristriction);
		po.setDepartment(department.trim());
		po.setUrlLinks(slinks);
		po.setOwner(ownername);
		
		
		System.out.println("survey po: ="+po);
		SurveyDAO dao=new SurveyDAO();
		boolean result =dao.addSurvey(po);
		request.setAttribute("SURVEY_INSERTED",result);
		
		if(result) {
			RequestDispatcher rd =  request.getRequestDispatcher("addsurvey.jsp"); 
			rd.forward(request, response);
		}else {
			RequestDispatcher rd =  request.getRequestDispatcher("error.jsp"); 
			rd.forward(request, response);
		}
		
		//System.out.println("RETURN SURVERY OBJECT: "+returnPO);
		
		//doGet(request, response);
	}

}
