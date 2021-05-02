<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.controller.UserRegistrationCtl"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


	
<style type="text/css">
    
    body {
	background-image: url("/project_3/img/i3.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;

} 

.log1 {
	padding-top: 2%;
}

</style>




<title>UserRegistration</title>

</head>
<%@include file="Header.jsp"%>

<body class="hm-gradient img-responsive">
	
	<div class="container-fluid">

		<main>
		<form action="<%=ORSView.USER_REGISTRATION_CTL%>" method="post">

			<div class="row log1">
				<!-- Grid column -->
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card" style="background-color: #c3646069;">
						<div class="card-body">

							<h3 class="text-center default-text py-3">User Registration
							</h3>
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

								<span ><b>First Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-user-circle grey-text"></span>
										</span>
									</div> 
									<input type="text" name="firstName" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter First Name"
										value="<%=DataUtility.getStringData(dto.getFirstName())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></br>

								<span ><b>Last Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-user-circle grey-text"></span>
										</span>
									</div> 
									<input type="text" name="lastName" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter lastName"
										value="<%=DataUtility.getStringData(dto.getLastName())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></br>



								<span ><b>Email Id</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"><span class="fa fa-envelope"></span>
										</span>
									</div> 
									<input type="text" name="emailId" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter Email Id"
										value="<%=DataUtility.getStringData(dto.getLogin())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("emailId", request)%></font></br>




								<span ><b> Password</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-key  grey-text"></span>
										</span>
									</div> 
									<input type="password" name="password" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter password"
										value="<%=DataUtility.getStringData(dto.getPassword())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("password", request)%></font></br>




								<span ><b>confirm Password</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-lock  grey-text"></span>
										</span>
									</div>
									<input type="password" name="confirmPassword"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Enter confirmPassword"
										value="<%=DataUtility.getStringData(dto.getConfirmPassword())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></br>
                           
                         <span ><b>Gender</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group mb-3">
								<div class="input-group-prepend">
									 <span class="input-group-text">  <i class="fa fa-user" style="font-size:17px"></i></span>
									 
									 </div>
									<%
										HashMap map = new HashMap();
										map.put("Male", "Male");
										map.put("Female", "Female");

										String htmlList = HTMLUtility.getList("gender", dto.getGender(), map);
									%>
									<%=htmlList%></div>
									  </div>
									
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("gender", request)%></font></br>



								<span ><b>Mobile No</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa  fa-phone-square grey-text"></span>
										</span>
									</div> 
									<input type="text" name="mobileNo" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter Mobile NO" maxlength="10"
										value="<%=DataUtility.getStringData(dto.getMobileNo())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></br>



								<span ><b>Date Of Birth</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-calendar  grey-text"></span>
										</span>
									</div> 
									<input type="text" name="dob" id="date" 
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Enter  DOB"
										value="<%=DataUtility.getDateString(dto.getDob())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("dob", request)%></font></br>


</div>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=UserRegistrationCtl.OP_SIGN_UP%>"> <input
									type="submit" name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px"
									value="<%=UserRegistrationCtl.OP_RESET%>">
							</div>
						</div>




					</div>
				</div>
				<div class="col-md-4 mb-4"></div>
			</div>

		</form>
		</main>


	</div>

<br>
<br>
<br>
<br>
</body>
<%@include file="Footer.jsp"%>
</html>