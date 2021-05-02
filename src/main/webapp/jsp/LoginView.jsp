
<%@page import="in.co.rays.project_3.controller.UserRegistrationCtl"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.controller.LoginCtl"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login view</title>
<link href="<%=ORSView.APP_CONTEXT%>/css/main.css" rel="stylesheet"
	id="bootstrap-css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/js/mdb.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<style type="text/css">
    
    body {
	background-image: url("/project_3/img/h4.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;

} 

.log1 {
	padding-top: 5%;
}




</style>
</head>
<body>
	
		<%@include file="Header.jsp"%>
	
	<div class="container-fluid">

		
		<form action="<%=ORSView.LOGIN_CTL%>" method="post">

			<div class="row log1">
				<!-- Grid column -->
				<div class="col-lg-4 lg-4"></div>
				<div class="col-lg-4 lg-4">
					<div class="card" style="background-color: #c3646069;">
						<div class="card-body">

							<h3 class="text-center default-text py-3">Login</h3>
							<!--Body-->
							<div>

								<jsp:useBean id="dto" class="in.co.rays.project_3.dto.UserDTO"
									scope="request"></jsp:useBean>
								<H4 align="center">
									<%
										if (!ServletUtility.getSuccessMessage(request).equals("")) {
									%>
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getSuccessMessage(request)%>
									</div>
									<%
										}
									%>
								</H4>

								<H4 align="center">
									<%
										if (!ServletUtility.getErrorMessage(request).equals("")) {
									%>
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
											<%=ServletUtility.getErrorMessage(request)%>
									</div>
									<%
										}
									%>

								</H4>
								<%
									String uri = (String) request.getAttribute("uri");
								%>
								<input type="hidden" name="id" value="<%=dto.getId()%>">
								<input type="hidden" name="createdBy"
									value="<%=dto.getCreatedBy()%>"> <input type="hidden"
									name="modifiedBy" value="<%=dto.getModifiedBy()%>"> <input
									type="hidden" name="createdDatetime"
									value="<%=DataUtility.getTimestamp(dto.getCreatedDatetime())%>">
								<input type="hidden" name="modifiedDatetime"
									value="<%=DataUtility.getTimestamp(dto.getModifiedDatetime())%>">
							</div>
							<div class="md-form">
							
							<span><b>Email Id</b><span
									style="color: red;">*</span></span> </br>
								
								<div class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text"><span class="fa fa-envelope"></span></span>
    </div>
   
								
									<input type="text" name="login" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter Email Id"
										value="<%=DataUtility.getStringData(dto.getLogin())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("login", request)%></font></br>
							
							
							<span><b> Password</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-key  grey-text"></span>
										</span>
									</div>
									<input type="password" name="password" class="form-control"
										style="border: 2px solid #8080803b;" placeholder="Enter password" 
										value="<%=DataUtility.getStringData(dto.getPassword())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("password", request)%></font></br>
							
							
							</div>


							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=LoginCtl.OP_SIGN_IN%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px"
									value="<%=UserRegistrationCtl.OP_SIGN_UP%>">
							</div>
							<div class="text-center">
								<a href="<%=ORSView.FORGET_PASSWORD_CTL%>"
									style="color: black; font-size: 15px;"><b>Forget my
										password</b></a>
							</div>
							<input type="hidden" name="uri" value="<%=uri%>">
						</div>
					</div>
				</div>
				<div class="col-lg-4 mb-4"></div>
			</div>

		</form>
		</main>


	</div>

</body>
<%@include file="Footer.jsp"%>
</html>