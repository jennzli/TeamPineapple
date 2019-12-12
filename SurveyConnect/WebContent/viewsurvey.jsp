
<%@ page import="com.neha.bean.UserPO"%>
<%@ page import="com.neha.bean.SurveyPO"%>
<%@ page import="java.util.*"%>

<%
List<SurveyPO> searchedPoList =(List<SurveyPO> )request.getAttribute("SURVEY_POLIST_VIEW");


UserPO po = (UserPO)session.getAttribute("PROFILE_RESULT");
String loggedinname = po.getEmail();
//System.out.println("the logged in user is(from viewsurvey):" + loggedinname);



//System.out.println("in viewservy jsp polist for view search" + searchedPoList);
		
		String name="";
		String department="";
		String description="";
		String ristriction="";
		String slink ="";
		String ownername ="";
		String sId = "";
		
		
		if(searchedPoList!=null && !searchedPoList.isEmpty()){
			SurveyPO surveyObj = (SurveyPO)searchedPoList.get(0);
			//System.out.println("s obj: ="+surveyObj);
			if(surveyObj!=null){
				name=surveyObj.getName();
				department =surveyObj.getDepartment();
				description=surveyObj.getDescription();
				ristriction=surveyObj.getRestriction();
				slink=surveyObj.getUrlLinks();
				ownername = surveyObj.getOwner();
				sId = surveyObj.getId() + "";
			}
			
		}
//System.out.println("ownername from view:" + ownername);
%>
<html>
<head>
<title>Add a Survey</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
<link rel="stylesheet" href="viewsurvey.css">

<script type="text/javascript">
	        function validateOwner(surveyowner, loggedinuser) {
	            /* alert(surveyowner);
	            alert(loggedinuser); */

	        if(surveyowner == loggedinuser) {
	        	
	        	return true;
	        } else {
	            alert("You do not have rights to edit this survey!"); 
		        return false;

	        }
	
	        }
	        
	        
	  
	        
	        
	   	 function validateOwnerDelete(surveyowner, loggedinuser) {
	           
			
	        if(surveyowner == loggedinuser) {
	        	
	        	return true;
	        } else {
	            alert("You do not have rights to delete this survey!"); 
		        return false;

	        }
	
	        } 
</script>
</head>
<body>
	<style>
html {
	background: #E0C7ED;
}
</style>
	<section class="section">
		<div class="container">
			<div class="columns">
				<div class="column">
					<h1 class="title"><%=name %></h1>
					<div class = "align-right">
                			<button class = "button is-white" ><a href="dashboard.jsp">Click here to go to dashboard </a></button>
           				 </div>
           			<br>
					<div class="field">
						<form>
							<div class="field">
								<label class="label">Department: </label>
								<div>
									<p><%=department %></p>
								</div>
							</div>
							<div class="field">
								<label class="label">Description:</label>
								<div>
									<p><%=description %></p>
								</div>
							</div>
							<div class="field">
								<label class="label">Restriction:</label>
								<div>
									<p><%=ristriction %></p>
								</div>
							</div>
							<div class="field">
								<button class="button">
									<a href="<%=slink%>">Click Here to Access the Survey </a>
								</button>
								<button class="button">
									<a
										href="/SurveyConnect/ManageSurveyServlet?task=edit&surveyId=<%=sId%>"
										onclick="return validateOwner('<%=ownername%>','<%=loggedinname%>')">Edit
										Survey </a>
								</button>
								<button class="button">
									<a
										href="/SurveyConnect/ManageSurveyServlet?task=delete&surveyId=<%=sId%>"
										onclick="return validateOwnerDelete('<%=ownername%>','<%=loggedinname%>')">Delete
										the Survey</a>
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
	</section>
</body>
</html>
