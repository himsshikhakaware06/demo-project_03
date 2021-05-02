<%@page import="in.co.rays.project_3.controller.MarksheetCtl"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Marksheet</title>



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
<body class="hm-gradient">
	
	<div class="container-fluid">

		<main>
		<form action="<%=ORSView.MARKSHEET_CTL%>" method="post">

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
							<h3 class="text-center default-text py-3">Update Marksheet</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text py-3">Add Marksheet</h3>
							<%
								}
							%>

							<!--Body-->
							<div>
								<%
									List l = (List) request.getAttribute("studenList");
								%>
								<jsp:useBean id="dto"
									class="in.co.rays.project_3.dto.MarksheetDTO" scope="request"></jsp:useBean>
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

								<span><b>Roll No</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-list-ol grey-text"></span>
										</span>
									</div>
									<input type="text" name="roll" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter roll No"
										value="<%=DataUtility.getStringData(dto.getRollNo())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("roll", request)%></font></br>






								<span><b>Student Name</b><span
									style="color: red;">*</span></span> <div class="input-group mb-3">
				
					<div class="input-group-prepend">
					<span class="input-group-text"> <i class="fa fa-user"></i></span>
					
					</div>
									<%=HTMLUtility.getList("studentName", String.valueOf(dto.getStudentId()), l)%>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("studentName", request)%></font></br>



								<span ><b>Physics</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-mobile grey-text"></span>
										</span>
									</div>
									<input type="text" name="physics" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter physics"
										value="<%=DataUtility.getStringData(dto.getPhysics()).equals("0") ? ""
					: DataUtility.getStringData(dto.getPhysics())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("physics", request)%></font></br>


								<span><b>Chemistry</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-flask"></i>
										</span>
									</div>
									<input type="text" name="chemistry" class="form-control"
										style="border: 2px solid #8080803b;"
										placeholder="Enter Chemistry"
										value="<%=DataUtility.getStringData(dto.getChemistry()).equals("0") ? ""
					: DataUtility.getStringData(dto.getChemistry())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("chemistry", request)%></font></br>



								<span ><b>Maths</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									<div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fas fa-equals grey-text"></span>
										</span>
									</div>
									<input type="text" name="maths" class="form-control"
										style="border: 2px solid #8080803b;" placeholder="Enter maths"
										value="<%=DataUtility.getStringData(dto.getMaths()).equals("0") ? ""
					: DataUtility.getStringData(dto.getMaths())%>">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("maths", request)%></font></br>
							</div>
							</br>
							<%
								if (id > 0) {
							%>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=MarksheetCtl.OP_UPDATE%>"> <input
									type="submit" name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=MarksheetCtl.OP_CANCEL%>">
							</div>

							<%
								} else {
							%>

							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=MarksheetCtl.OP_SAVE%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=MarksheetCtl.OP_RESET%>">
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