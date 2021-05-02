<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="in.co.rays.project_3.controller.CourseCtl"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>



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


</head>

<%@include file="Header.jsp"%>

<body>

	
	<div class="container-fluid">
		<jsp:useBean id="dto" class="in.co.rays.project_3.dto.CourseDTO"
			scope="request"></jsp:useBean>

		<main>
		<form action="<%=ORSView.COURSE_CTL%>" method="post">

			<div class="row log1">
				<!-- Grid column -->
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card" style="background-color: #c3646069;">
						<div class="card-body">
							<%
							  long id=DataUtility.getLong(request.getParameter("id"));
							
							
							if (id >0)  {
							%>
							<h3 class="text-center default-text py-3">Update Course</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text py-3">Add Course</h3>
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
							
							
							<span><b>Course Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-book grey-text"></span>
										</span>
									</div>
									<input type="text" name="courseName" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter courseName" 
										value="<%=DataUtility.getStringData(dto.getCourseName())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("courseName", request)%></font></br>
							
				 
							
							
							<span ><b>Duration</b><span style="color:red;">*</span>
							
							<div class="input-group mb-3">
				
					<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-clock-o"></i></span>
					
					</div>
					<%
										HashMap map = new HashMap();
										map.put("1Year", "1Year");
										map.put("2Year", "2Year");
										map.put("3Year", "3Year");
										map.put("4Year", "4Year");
										map.put("5Year", "5Year");
										String HtmlList = HTMLUtility.getList("duration", dto.getDuration(), map);
									%>
									<%=HtmlList%>
					</div>	
							
								<!-- </br> <i class="fa fa-clock-o prefix grey-text css" style="font-size: 1rem; padding-top: 17px;width: 2.3rem;"></i>
									<div style="margin-left: 30px;">

									
								</div> -->
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("duration", request)%></font></br>
								
								
								<span><b>Description</b><span
									style="color: red;">*</span></span> </br>
							<div class="input-group mb-3">
							<div class="input-group-prepend" >
							<span class="input-group-text">
							<i class="fa fa-pencil" style="font-size:24px"></i>
							</span>
							
							</div>
							
				<textarea class="form-control" placeholder="enter Description" name="description" ><%=DataUtility.getStringData(dto.getDescription()) %></textarea>			
							
							</div>
							
	<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("name", request)%></font></br>							
															</div>
							</br> </br>
							<%
								if(id>0) {
							%>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=CourseCtl.OP_UPDATE%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=CourseCtl.OP_CANCEL%>">
							</div>
							<%
								} else {
							%>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=CourseCtl.OP_SAVE%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=CourseCtl.OP_RESET%>">
							</div>
							<%
								}
							%>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-4"></div>
				</div>
		</form>
		</main>


	</div>

</body>
<%@include file="Footer.jsp" %>

</html>