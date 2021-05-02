<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project_3.controller.FacultyCtl"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Faculty</title>

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
</style>


<%@include file="Header.jsp"%>
</head>
<script>
 
$(function(){
	$("#date1").datepicker({
		 beforeShowDay:
			function(dt){
			return[dt.getDay()==0 ? false:true]     ///// to disable sunday
		}, 
		changeMonth:true,
		changeYear:true,
		//maxDate:100,
		//maxYear:2,
		stepMonths: 12,
		minDate: 0+1,
		//beforeShowDay: noSunday,
		//beforeShowDay1: noSunday1,
		
		yearRange:'+0:+5',
		//yearRange:"+10:"
		
		
		defaultDate:"01/01/2020"
	});	
}); 
     

</script> 



<body >


 
	
	<div class="container-fluid">
		<jsp:useBean id="dto" class="in.co.rays.project_3.dto.FacultyDTO"
			scope="request"></jsp:useBean>
		<main>
		<form action="<%=ORSView.FACULTY_CTL%>" method="post">
			<%
				List ll = (List) request.getAttribute("collegeList");
				List lli = (List) request.getAttribute("courseList");
				List llist = (List) request.getAttribute("subjectList");
			%>
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
							<h3 class="text-center default-text py-3">Update Faculty</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text py-3">Add Faculty</h3>
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
							<div class="md-form">
							
							
							<span><b>First Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fa fa-user"></i>
										</span>
									</div>
									<input type="text" name="firstName"
										value="<%=DataUtility.getStringData(dto.getFirstName())%>"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Username">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></br>
							

							
							<span><b>last Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"><i class="fa fa-user"></i>
										</span>
									</div>
									<input type="text" name="lastName"
										value="<%=DataUtility.getStringData(dto.getLastName())%>"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="lastName">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></br>
							
							
							
							
							
							
							<span ><b>EmailId</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span class="fa fa-envelope" style="font-size:16px;color:##5f5a5a"></span>
										</span>
									</div>
									<input type="text" name="emailId"
										value="<%=DataUtility.getStringData(dto.getEmailId())%>"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="email Id">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("emailId", request)%></font></br>
							
							
							
							<span><b>Qualification</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text">  <i class="fa fa-mortar-board"></i>
										</span>
									</div>
									<input type="text" name="qualification"
										value="<%=DataUtility.getStringData(dto.getQualification())%>"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="qualification">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("qualification", request)%></font></br>
							
							<span ><b>Mobile No</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-phone grey-text"></span>
										</span>
									</div>
									<input type="text" name="mobileNo" maxlength="10"
										value="<%=DataUtility.getStringData(dto.getMobileNo())%>"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="mobileNo">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></br>
							
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
										id="date1" style="border: 2px solid #8080803b;"
										 placeholder="Enter Date Of Birth"
										value="<%=DataUtility.getDateString(dto.getDob())%>" readonly="readonly">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("dob", request)%></font></br>


							<span><b>College</b><span
									style="color: red;">*</span></span>
								<div class="input-group mb-3">
				
					<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-institution"></i></span>
					
					</div>
					<%=HTMLUtility.getList("collegeName", String.valueOf(dto.getCollegeId()), ll)%>
					</div>
	<font color="red" class="pl-sm-5">  <%=ServletUtility.getErrorMessage("collegeId", request)%></font></br>
                                
								<span ><b>Subject</b><span
									style="color: red;">*</span></span>
									<div class="input-group mb-3">
									<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-book"></i></span>
									</div>
									<%=HTMLUtility.getList("subjectName", String.valueOf(dto.getSubjectId()), llist)%>
								</div>
									
									
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("subjectName", request)%></font></br>

								<span ><b>Course</b><span
									style="color: red;">*</span></span> <div class="input-group mb-3">
									<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-mortar-board"></i></span>
									</div>
									<%=HTMLUtility.getList("courseName", String.valueOf(dto.getCourseId()), lli)%>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("courseName", request)%></font></br>

								</br>
								<%
									if (id > 0) {
								%>
								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=FacultyCtl.OP_UPDATE%>"> <input
										type="submit" name="operation" class="btn btn-warning btn-md"
										style="font-size: 17px" value="<%=FacultyCtl.OP_CANCEL%>">
								</div>
								<%
									} else {
								%>
								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=FacultyCtl.OP_SAVE%>"> <input type="submit"
										name="operation" class="btn btn-warning btn-md"
										style="font-size: 17px" value="<%=FacultyCtl.OP_RESET%>">
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