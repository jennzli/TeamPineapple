<%@ page import="com.neha.bean.UserPO" %>
<%@ page import="com.neha.bean.SurveyPO" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <title>Survey Connect</title>
    <link rel="stylesheet" href="dashboard.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
<script src ="https://cdn.jsdelivr.net/npm/lodash@4.17.15/lodash.min.js"> </script>


<script type="text/javascript">
	        function callSurveyServletdoGetMethod() {
	            document.forms[0].action = "SurveyServlet";
	            var dept=document.forms[0].select;
	            document.forms[0].submit();
	        }
	        
</script>
</head>
<body>
<%

UserPO po = (UserPO)session.getAttribute("PROFILE_RESULT");
String searchContentDisplay="";

String searchContent =(String)request.getAttribute("SEARCH_RESULT");
if(searchContent!=null){
	
	searchContentDisplay=searchContent;
}

List<SurveyPO> poList =(List<SurveyPO> )session.getAttribute("SURVEY_POLIST_DEPT");

List<SurveyPO> searchedPoList =(List<SurveyPO> )request.getAttribute("SURVEY_POLIST_SEARCH");

/* System.out.println("in profie polist for departments" + poList);
System.out.println("in jsp searchedPoList for search...." + searchedPoList); 
System.out.println("in profie jsp" + po); */ 
	
String emptyResultMsg ="";
if(searchedPoList!=null && searchedPoList.isEmpty()){
	emptyResultMsg="No survey results found";
}
		//if(searchedPoList!=null){
		//for(int j=0;j<searchedPoList.size();j++){
	//		System.out.println("in  jsp SEARCH OBJ: =" + searchedPoList.get(j).getName()); 

		//}
		//}

%>
    <br>
        
      
      
        <container class = "dashboard">
            <div class = "mypadding, divcenter">
                <h3 class = "subtitle, center">DASHBOARD<h3>
            </div>
            <button class = "button"><a href="/SurveyConnect/landing.jsp"><p>Sign out</p></a>	</button>
            
            <form autocomplete="off">
                        		<h1 class = "darker">Search by Department:</h1>
            <div class = "select">	

                    <select id="deptId" name = "deptId">
                        <option>Choose one</option>
                        <% for(int i=0;i<poList.size();i++){ 
                        	SurveyPO sObj = (SurveyPO)poList.get(i);
        					//int surveyid=sObj.getId();
        					String deptName = sObj.getDepartment();
                        %>
                       	 	<option value='<%=deptName %> '><%=deptName %></option>
                        <%} %>
                    </select>
                
            </div>
            <br>
            <br>
            <h1 class = "darker">OR</h1>
            <br>
            
                <div class="control, autocomplete">
                    <h1 class = "darker">Search by Name: </h1>
                    <input class = "myinput" id="myInput" type="text" name="searchInput" placeholder="Type Here">
                </div>
                <br>
                <br>
                <input class = "button" type="button" value="Search" onclick="callSurveyServletdoGetMethod()">
           
            <br>
            <div class = "results">
            
               
               
               <%  if(searchedPoList!=null){%>
            	   <!-- <ul>You have searched for...</ul> --> 
				<% for(int j=0;j<searchedPoList.size();j++){
					SurveyPO surveyObj = (SurveyPO)searchedPoList.get(j);
					int id=surveyObj.getId();
					String name=surveyObj.getName();
					String deptN = surveyObj.getDepartment();
				
				%>
					<ui><a href="/SurveyConnect/ViewServlet?sid=<%=id %>"" target="_blank"><%=name %></a> | <%= deptN%><ui><br>
            	
            	<%} 
               }
            	%>
            	<% if(emptyResultMsg.length() > 0) { %>
            	<ul><%= emptyResultMsg%></ul>
            	<%} %>
            	<br><br>
         
            
            
       </form>
        </container>

        <script src="dashboard.js"></script>
</body>
</html>