<%@page import="in.co.rays.project_3.controller.MarksheetListCtl"%>
<%@page import="in.co.rays.project_3.dto.MarksheetDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marksheet Merit List</title>

<style type="text/css">
    
    body {
	background-image: url("/project_3/img/h4.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;

} 
.p1 {
	padding-top: 200px;
	font-size: 20px;
	color: #b62f2f;
}



.text {
	text-align: center;
}
</style>

</head>
<%@include file="Header.jsp"%>

<body class="hm-gradient">
	
	<div class="container-fluid">
		<form action="<%=ORSView.MARKSHEET_MERIT_LIST_CTL%>" method="post">



			<div align="center">
				<h1 style="font-size: 40px; padding-top: 24px; color: #162390;">Marksheet Merit
					List</h1>
			</div>

				<div class="row">
				<div class="col-md-4"></div>

				<%
					if (!ServletUtility.getSuccessMessage(request).equals("")) {
				%>

				<div class="col-md-4 alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4><font color="#008000"><%=ServletUtility.getSuccessMessage(request)%></font></h4>
				</div>
				<%
					}
				%>

				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>

				<%
					if (!ServletUtility.getErrorMessage(request).equals("")) {
				%>
				<div class=" col-md-4 alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>
						<font color="red"><%=ServletUtility.getErrorMessage(request)%></font></h4>
				</div>
				<%
					}
				%>
				<div class="col-md-4"></div>
			</div>
			<jsp:useBean id="dto" class="in.co.rays.project_3.dto.MarksheetDTO"
				scope="request"></jsp:useBean>
			


			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;

				List list = ServletUtility.getList(request);
				Iterator<MarksheetDTO> it = list.iterator();
				if (list.size() != 0) {
			%>

			

			</br>
			<div style="padding-left: 48%;">
					<input type="submit" name="operation" class="btn btn-primary btn-md" style="font-size: 17px"
						value="<%=MarksheetListCtl.OP_PRINT%>">
				</div>

			<br>
			<div style="margin-bottom: 20px;" class="table-responsive">
				<table class="table table-bordered table-hover " style="background-color: #e1d3d3;">
					<thead>
						<tr style="background-color: #5d98a5cc;">

							<th class="text">S.NO</th>

							<th class="text">RollNo</th>
							<th class="text">Name</th>
							<th class="text">Physics</th>
							<th class="text">Chemistry</th>
							<th class="text">Maths</th>
							<th class="text">Total</th>
							<th class="text">Percentage(%)</th>
						</tr>
					</thead>
					<%
						while (it.hasNext()) {
								dto = it.next();
					%>

					<tbody>
						<tr>
						
							<td align="center"><%=index++%></td>
							<td align="center"><%=dto.getRollNo()%></td>
							<td align="center"><%=dto.getName()%></td>
							<td align="center"><%=dto.getPhysics()%></td>
							<td align="center"><%=dto.getChemistry()%></td>
							<td align="center"><%=dto.getMaths()%></td>
							<td align="center">
						<%
							int total = (dto.getChemistry() + dto.getPhysics() + dto.getMaths());
						%><%=total%></td>
					<td align="center">
						<%
							float percentage = ((total * 100) / 300);
						%> <%=percentage%></td>
							
						</tr>
					</tbody>
					<%
						}
					%>
				</table>
				</div>
				<div style="padding-left: 48%;">
					<input type="submit" name="operation" class="btn btn-primary btn-md" style="font-size: 17px"
						value="<%=MarksheetListCtl.OP_BACK%>">
				</div>


			
			<%
				}
				
			%>
		
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">


		</form>

	</div>
</br>
</br>
</br>
</body>
<%@include file="Footer.jsp"%></html>