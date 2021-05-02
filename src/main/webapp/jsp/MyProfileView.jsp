
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.controller.MyProfileCtl"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>my profile</title>
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
	<script>
	
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			yearRange : '1970:2030',
			dateFormat : 'dd/mm/yy',
			endDate : '-18y'
		});
	});
</script>
<style type="text/css">
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
.hm-gradient {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png');
	
}
</style>
</head>
<body class="hm-gradient">
	<div class="header">
		<%@include file="Header.jsp"%>
	</div>
	<div class="container-fluid">

		<main>
		<form action="<%=ORSView.MY_PROFILE_CTL%>" method="post">

			<div class="row log1">
				<!-- Grid column -->
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card">
						<div class="card-body">

							<h3 class="text-center default-text py-3">
							 My Profile
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
							
							<span><b>Email Id</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-address-card grey-text"></span>
										</span>
									</div>
									<input type="text" name="emailId" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter emailId" readonly="readonly"
										value="<%=DataUtility.getStringData(dto.getLogin())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("emailId", request)%></font></br>
								
								<span ><b>First Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="far fa-user grey-text"></span>
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
											class="fas fa-user-alt grey-text"></span>
										</span>
									</div>
									<input type="text" name="lastName" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter Last Name"
										value="<%=DataUtility.getStringData(dto.getLastName())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></br>
								
								
								<span><b>Mobile No</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-phone-square grey-text"></span>
										</span>
									</div>
									<input type="text" name="mobileNo" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter mobileNo "
										value="<%=DataUtility.getStringData(dto.getMobileNo())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></br>
								
								
								<span ><b>Gender</b><span style="color:red;">*</span></span> 
								</br> <i class="fa fa-venus-mars prefix  fa-5x grey-text css" style="font-size: 1rem; padding-top: 17px;width: 2.3rem;"></i>
								<div style="margin-left: 30px;">
									<%
										HashMap map = new HashMap();
										map.put("Male", "Male");
										map.put("Female", "Female");

										String htmlList = HTMLUtility.getList("gender", dto.getGender(), map);
									%>
									<%=htmlList%></div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("gender", request)%></font></br>
								
								
								
								<span 
								><b>Date Of Birth</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-calendar-o grey-text"></span>
										</span>
									</div>
									<input type="text" name="dob" class="form-control" id="datepicker"
										style="border: 2px solid #8080803b;" readonly="readonly"
									
										value="<%=DataUtility.getDateString(dto.getDob())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("dob", request)%></font></br>
								
								</br>
							
							</br>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=MyProfileCtl.OP_SAVE%>">
										<input type="submit" name="operation"
									class="btn btn-warning btn-md" style="font-size: 17px"
									value="<%=MyProfileCtl.OP_CHANGE_MY_PASSWORD%>">
							</div>
                         
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