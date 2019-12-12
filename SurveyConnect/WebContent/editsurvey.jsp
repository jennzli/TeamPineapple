<%@ page import="com.neha.bean.UserPO" %>
<%@ page import="com.neha.bean.SurveyPO" %>
<%@ page import="java.util.*" %>

<html background-color = "#E0C7ED">
    <head>
        <title>Add a Survey</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    </head>
 <%
 Boolean insertResult=(Boolean)request.getAttribute("SURVEY_EDITED_SUCCESS");
 if(insertResult==null){
	  insertResult=false;
 }
 List<SurveyPO> editPoList =(List<SurveyPO> )request.getAttribute("SURVEY_POLIST_EDIT");

// System.out.println("in edit jsp polist for edit " + editPoList);
 		
 		String name="";
 		String department="";
 		String description="";
 		String ristriction="";
 		String slink ="";
 		String sId="";
 		
 		if(editPoList!=null && !editPoList.isEmpty()){
 			SurveyPO surveyObj = (SurveyPO)editPoList.get(0);
 			//System.out.println(" to be edited obj: ="+surveyObj);
 			if(surveyObj!=null){
 				sId=surveyObj.getId()+"";
 				name=surveyObj.getName();
 				department =surveyObj.getDepartment();
 				description=surveyObj.getDescription();
 				ristriction=surveyObj.getRestriction();
 				slink=surveyObj.getUrlLinks();
 			}
 			
 		}
     //System.out.println("SSSID:="+sId);
 	
 %>
 
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
                      <h1 class="title">Add your survey below!</h1>
                      <% if(insertResult==true){ %>
                      	<h3><font color="green"> Your survey has been submitted successfully </font></h3>
                      <%}%> 
                      
                        <div class = "align-right">
                			<button class = "button is-white" ><a href="dashboard.jsp">Click here to go to dash board </a></button>
           				 </div>
                     <form id="editform" action="ManageSurveyServlet" method = "POST">
                     	<input type="hidden" id="surId" name ="surId" value=<%=sId%>>
                          <div class="field">
                              <label class="label">Name:</label>
                              <div class="control">
                                  <input id="name" class="input" type="text" placeholder="Name" name="name" value='<%=name%>'>
                              </div>
                          </div>
                          <div class="field">
                              <label class="label">Department: </label>
                              <div class="control">
                                  <input id="department" class="input" type="text" placeholder="Enter department" name="department" value='<%=description%>'>
                              </div>
                          </div>
                          <div class="field">
                              <label class="label">Description:</label>
                              <div class="control">
                                  <input id="description" class="textarea" type="textarea" placeholder="Write Your Description Here" name="description" value='<%=description%>'>
                              </div>
                          </div>                          
                          <div class="field">
                                <label class="label">Restriction:</label>
                                <div class="control">
                                    <input id="ristriction" class="textarea" type="textarea" placeholder="Write Your Restrictions Here" name="ristriction" value='<%=ristriction%>'>
                                </div>
                            </div>
                            <div class="field">
                                    <label class="label">URL Link to Survey</label>
                                    <div class="control">
                                        <input id="slinks" class="textarea" type="textarea" placeholder="Copy your survey link here" name="slinks" value='<%=slink%>'>
                                        
                                    </div>
                                </div>                                 
                          <div class="field">
                              <div class="control">
                                  <input class="button is-white" type="submit"/>
                              </div>
                          </div>
                      </form>
                  </div>
              </div>
          </div>
      </section>
    </body>
</html>