<%@page import="in.co.rays.project_3.controller.UserCtl"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<style type="text/css">
    
    body {
	background-image: url("/project_3/img/h4.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;

} 

.card{

}
.log1 {
	padding-top: 3%;
}



#myInput {
	border: 2px solid #8080803b;
}



i.css {
	border-radius: 6px 0px 0px 6px;
	border: 1px solid #ced4da;
	padding-left: 15px;
	padding-bottom: 18px;
	background-color: #e9ecef;
}


</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>

<body>
	<%@include file="Header.jsp"%>

<script>

$(function(){
	$("#date").datepicker({
		
		changeMonth:true,
		changeYear:true,
	     maxDate:0,
		//minDate: 0+1,
		//beforeShowDay: noSunday,
		//beforeShowDay1: noSunday1,
		
		yearRange:"-67:-18",
		//defaultDate:"01/01/1999"
	});	
}); 
    
</script>
    
	
	<div class="container-fluid">

		
		<form action="<%=ORSView.USER_CTL%>" method="post">
			<jsp:useBean id="dto" class="in.co.rays.project_3.dto.UserDTO"
				scope="request"></jsp:useBean>
			<div class="row log1">
				<div class="col-md-4 mb-4"></div>
				<!-- Grid column -->
				<div class="col-md-4 mb-4">
					<div class="card" style="background-color: #c3646069;">
						<div class="card-body">
							<%
								long id = DataUtility.getLong(request.getParameter("id"));

								if (id > 0) {
							%>
							<h3 class="text-center default-text py-3">Update User</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text py-3">Add User</h3>
							<%
								}
							%>
							<!--Body-->
							<div>
								<%
									List list = (List) request.getAttribute("roleList");
								%>

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

								<span><b>First Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-user"></i>
										</span>
									</div> 
									<input type="text" name="firstName"
										value="<%=DataUtility.getStringData(dto.getFirstName())%>"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Username">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></br>

								<span><b>Last Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-user"></i>
										</span>
									</div> 									<input type="text" name="lastName" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter Last Name"
										value="<%=DataUtility.getStringData(dto.getLastName())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></br>
								<%
									if (id <= 0) {
								%>
								<span><b>Password</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-unlock-alt grey-text"></span>
										</span>
									</div>
									<input type="password" name="password" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter password"
										value="<%=DataUtility.getStringData(dto.getPassword())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("password", request)%></font></br>



								<span><b>Confirm Password</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text">  <span
											class="fa fa-unlock-alt grey-text"></span>
										</span>
									</div> 
									<input type="password" name="confirmPassword"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Enter Confirm Password"
										value="<%=DataUtility.getStringData(dto.getConfirmPassword())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></br>
								<%
									}
								%>


								<span><b>Email Id</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span class="fa fa-envelope" style="font-size:16px;color:##5f5a5a"></span>
										</span>
									</div> 
									<input type="text" name="emailId" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter Email Id"
										value="<%=DataUtility.getStringData(dto.getLogin())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("emailId", request)%></font></br>




								<span><b>Mobile No</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-phone grey-text"></span>
										</span>
									</div> 
									<input type="text" name="mobileNo" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter Mobile No" maxlength="10"
										value="<%=DataUtility.getStringData(dto.getMobileNo())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></br>

								

								<span ><b>Role</b><span
									style="color: red;">*</span></span>
									<div class="input-group mb-3">
									
									<div class="input-group-prepend">
									 <span class="input-group-text">  <i class="fa fa-user" style="font-size:17px"></i></span>
									 
									 </div>
								<%=HTMLUtility.getList("role", String.valueOf(dto.getRoleId()), list)%>
									</div>
									
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("role", request)%></font></br>


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



								<span ><b>Date Of Birth</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-calendar grey-text"></span>
										</span>
									</div> 
									<input type="text" name="dob" class="form-control"
										id="date" style="border: 2px solid #8080803b;"
										 placeholder="Enter Date Of Birth"
										value="<%=DataUtility.getDateString(dto.getDob())%>" readonly="readonly">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("dob", request)%></font></br>

							</div>
							<%
								if (id > 0) {
							%>

							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=UserCtl.OP_UPDATE%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=UserCtl.OP_CANCEL%>">

							</div>
							<%
								} else {
							%>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=UserCtl.OP_SAVE%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=UserCtl.OP_RESET%>">
							</div>

						</div>
						<%
							}
						%>
					</div>
				</div>
		</form>
		</main>
		<div class="col-md-4 mb-4"></div>

	</div>
<br>
<br>
<br>



</body>
<%@include file="Footer.jsp"%>
</body>
</html>