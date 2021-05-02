<%@page import="in.co.rays.project_3.controller.CollegeCtl"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add College</title>
 
 
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
 
 
</head>

<%@include file="Header.jsp"%>


<body class="hm-gradient">
	<div class="header">
		
	</div>
	<div class="container-fluid">

		<main>
		<form action="<%=ORSView.COLLEGE_CTL%>" method="post">

			<div class="row log1">
				<!-- Grid column -->
				<jsp:useBean id="dto" class="in.co.rays.project_3.dto.CollegeDTO"
					scope="request"></jsp:useBean>
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card" style="background-color: #c3646069;">
						<div class="card-body">
							<%
								long id = DataUtility.getLong(request.getParameter("id"));

								if (id > 0) {
							%>
							<h3 class="text-center default-text py-3">Update College</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text py-3">Add College</h3>
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
							
							
								<span><b>Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-institution" style="font-size:16px"></i>
										</span>
									</div>
									<input type="text" name="name"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Enter Name"
										value="<%=DataUtility.getStringData(dto.getName())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("name", request)%></font></br>
							
							
							
								<span ><b>Address</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-address-book grey-text"></span>
										</span>
									</div>
									<input type="text" name="address"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Enter address"
										value="<%=DataUtility.getStringData(dto.getAddress())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("address", request)%></font></br>
								
								
								
								<span ><b>state</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fas fa-key grey-text"></span>
										</span>
									</div>
									<input type="text" name="state"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Enter state"
										value="<%=DataUtility.getStringData(dto.getState())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("state", request)%></font></br>
								
								
								
								
								<span ><b>City</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fas fa-key grey-text"></span>
										</span>
									</div>
									<input type="text" name="city"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Enter city"
										value="<%=DataUtility.getStringData(dto.getCity())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("city", request)%></font></br>
								
								
								
								
								<span><b>Mobile No</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-phone grey-text"></span>
										</span>
									</div>
									<input type="text" name="mobileNo"
										class="form-control" style="border: 2px solid #8080803b;"
										placeholder="Enter mobileNo" maxlength="10"
										value="<%=DataUtility.getStringData(dto.getPhoneNo())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></br>
								
								
								
								
							<%
								if (id > 0) {
							%>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=CollegeCtl.OP_UPDATE%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=CollegeCtl.OP_CANCEL%>">
							</div>
							<%
								} else {
							%>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=CollegeCtl.OP_SAVE%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=CollegeCtl.OP_RESET%>">
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
<%@include file="Footer.jsp"%>


</html>