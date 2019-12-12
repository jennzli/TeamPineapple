<html class = "background">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Shrikhand&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="login.css">

<meta name="google-signin-client_id"
	content="294629464047-pg9efo4mvhh0uo6ouqf18fj633506cab.apps.googleusercontent.com">
<!--Google JS API Library-->
<script src="https://apis.google.com/js/platform.js" async defer> </script>


<title>Login</title>
</head>
<body style = "background-color: #E0C7ED">

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="master.js"></script>
	<!-- to get bval from servelet #21, 22 * not String = , will be UserPO = ,,,, to in dashboard html to 30-31 how to import user po in jsp  -->
	<%
		String retVal = (String) request.getAttribute("LOGIN_RESULT");
		System.out.println("in js" + request.getAttribute("LOGIN_RESULT")); //i
	%>

	<section class="section">
		<div class="container">
			<div class="columns">
				<div class="column">
					<%
						if (retVal != null) {
					%>
					<h2>
						<font color=red><%=retVal%></font>
					</h2>
					<%
						}
					%>
					<h1 class="title">Login</h1>
					<!--need another form-->

					<form id="myform" action="LoginServlet" method="POST">
						<!--  <form method="POST" action="LoginServlet">-->
						<div class="field">
							<label class="label">Email</label>
							<div class="control">
								<input id="emailid" class="input" type="text"
									placeholder="Email" name="emaillogin">
							</div>
						</div>
						<div class="field">
							<label class="label">Password</label>
							<div class="control">
								<input id="passid" class="input" type="password"
									placeholder="Password" name="passwordlogin">
							</div>
						</div>

						<div class="field, buttons">
							<div class="control">
								<input class="button is-light" type="submit" value="Submit"
									onClick="submitCreds()" />
							</div>

							<div class="divider"></div>
							
							<script>
								function onSignIn(googleUser) {
									//alert("hello");
									// Fetch data from google
									var profile = googleUser.getBasicProfile();
									//alert("profile from onsign in method" + profile.getEmail());
									//window.location.href = "googleconfirmation.html";
									var answer = window.confirm('Do you want to log in with Google?');
									if(answer) {
										
										window.location.href = "googleconfirmation.html";

										
										
									} else {
										//alert("going to normal login");
									}

								}
								  
								
							</script>
							
							<!-- Once Successfully signed in, calls onSignIn-->
							<div class="g-signin2" data-onsuccess="onSignIn"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

</body>
</html>