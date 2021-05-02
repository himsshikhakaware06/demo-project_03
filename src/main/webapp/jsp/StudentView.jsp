<%@page import="java.util.List"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="in.co.rays.project_3.controller.StudentCtl"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>



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
	/* padding-left: 30%; */
}


i.css {
	border-radius: 6px 0px 0px 6px;
	border: 1px solid #ced4da;
	padding-left: 15px;
	padding-bottom: 18px;
	background-color: #e9ecef;;
}

</style>

<%@include file="Header.jsp"%>

</head>

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
    




<body>
	
	<div class="container-fluid">
		<jsp:useBean id="dto" class="in.co.rays.project_3.dto.StudentDTO"
			scope="request"></jsp:useBean>
		<main>
		<form action="<%=ORSView.STUDENT_CTL%>" method="post">

			<div class="row log1">
				<!-- Grid column -->
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card" style="background-color: #c3646069;">
						<div class="card-body">
							<%
								long id = DataUtility.getLong(request.getParameter("id"));

								if (id > 0) {
							%>
							<h3 class="text-center default-text py-3">Update Student</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text py-3">Add Student</h3>
							<%
								}
							%>
							<!--Body-->
							<div>


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
							<%
								List li = (List) request.getAttribute("collegeList");
							%>
							<div class="md-form">
								<span><b>College</b><span
									style="color: red;">*</span></span>
								<div class="input-group mb-3">
				
					<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-institution"></i></span>
					
					</div>
					<%=HTMLUtility.getList("collegeName", String.valueOf(dto.getCollegeId()), li)%>
					</div>
									
									<!--  <i
									class="far fa-building prefix grey-text css" style="font-size: 1rem; padding-top: 17px;width: 2.3rem;"></i>
								<div style="margin-left: 30px;"> -->
									
								</div>
								<font color="red" class="pl-sm-5">  <%=ServletUtility.getErrorMessage("collegeId", request)%></font></br>
                                 
                                 
                                 <span><b>First Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-user grey-text"></span>
										</span>
									</div>
									<input type="text" name="firstName" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter firstName" maxlength="10"
										value="<%=DataUtility.getStringData(dto.getFirstName())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></br>
							
							
							
							<span><b>Last Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-user grey-text"></span>
										</span>
									</div>
									<input type="text" name="lastName" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter lastName" maxlength="10"
										value="<%=DataUtility.getStringData(dto.getLastName())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></br>
							
							
                                 	<span ><b>Email Id</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="far fa-envelope grey-text"></span>
										</span>
									</div>
									<input type="text" name="emailId" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter email Id" 
										value="<%=DataUtility.getStringData(dto.getEmail())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("emailId", request)%></font></br>
							
							<span><b>Date of Birth</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-calendar grey-text"></span>
										</span>
									</div>
									<input type="text" name="dob" class="form-control" id="date"
										style="border: 2px solid #8080803b;" readonly="readonly"
										placeholder="Enter dob" 
										value="<%=DataUtility.getDateString(dto.getDob())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("dob", request)%></font></br>
							
							<span ><b>Mobile No</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-phone grey-text"></span>
										</span>
									</div>
									<input type="text" name="mobileNo" class="form-control"
										style="border: 2px solid #8080803b;" maxlength="10"
										placeholder="Enter mobileNo" 
										value="<%=DataUtility.getStringData(dto.getMobileNo())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></br>
							
							
                                 
                                 
								</br>
								<%
									if(id>0) {
								%>
								<div class="text-center">

									<input type="submit" name="operation"	class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=StudentCtl.OP_UPDATE%>"> <input
										type="submit" name="operation" class="btn btn-warning btn-md"
										style="font-size: 17px"
										value="<%=StudentCtl.OP_CANCEL%>">

								</div>
								<%
									} else {
								%>
								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=StudentCtl.OP_SAVE%>"> <input type="submit"
										name="operation" class="btn btn-warning btn-md"
										style="font-size: 17px" value="<%=StudentCtl.OP_RESET%>">

								</div>
								<%
									}
								%>
							</div>
						</div>
					</div>
					
					</div>
					<div class="col-md-4 mb-4"></div>
					</div>
					
		</form>
		</main>


	</div>

</body>
<%@include file="Footer.jsp"%>
</html>