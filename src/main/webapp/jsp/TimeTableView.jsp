<%@page import="in.co.rays.project_3.controller.TimeTableCtl"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add TimeTable</title>

 

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



<body>
	
	<div class="container-fluid">

		<main>
		<form action="<%=ORSView.TIMETABLE_CTL%>" method="post">

			<div class="row log1">
				<jsp:useBean id="dto" class="in.co.rays.project_3.dto.TimeTableDTO"
					scope="request"></jsp:useBean>
				<!-- Grid column -->
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card" style="background-color: #c3646069;">
						<div class="card-body">
							<%
								long id = DataUtility.getLong(request.getParameter("id"));

								if (id > 0) {
							%>
							<h3 class="text-center default-text py-3">Update Time Table</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text py-3">Add Time Table</h3>
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
								<%
									List l = (List) request.getAttribute("courseList");
									List li = (List) request.getAttribute("subjectList");
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
								<span ><b>Course</b><span
									style="color: red;">*</span></span> <div class="input-group mb-3">
									<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-mortar-board"></i></span>
									</div>	
							<%=HTMLUtility.getList("courseName", String.valueOf(dto.getCourseId()), l)%>	
								</div>
									
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("courseName", request)%></font></br>

								<span ><b>Subject</b><span
									style="color: red;">*</span></span>
									<div class="input-group mb-3">
									<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-book"></i></span>
									</div>
									<%=HTMLUtility.getList("subjectName", String.valueOf(dto.getSubId()), li)%>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("subjectName", request)%></font></br>

								<span ><b>Semester</b><span
									style="color: red;">*</span></span> </br> <div class="input-group mb-3">
									<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-sort-desc"></i></span>
									</div>
									<%
										HashMap map = new HashMap();
										map.put("1semester", "1semester");
										map.put("2semester", "2semester");
										map.put("3semester", "3semester");
										map.put("4semester", "4semester");
										map.put("5semester", "5semester");
										map.put("6semester", "6semester");
										map.put("7semester", "7semester");
										map.put("8semester", "8semester");
										
										String htmlList = HTMLUtility.getList("semester", dto.getSemester(), map);
									%>
									<%=htmlList%></div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("semester", request)%></font></br>


								<span ><b>Exam Date</b><span
									style="color: red;">*</span></span> </br>
								<div class="input-group">

									 <div class="input-group-prepend">
										<span class="input-group-text"> <span
											class="fa fa-calendar grey-text"></span>
										</span>
									</div> 
									<input type="text" name="examDate" class="form-control"
										id="date1" style="border: 2px solid #8080803b;"
										 placeholder="Enter Exam Date"
										value="<%=DataUtility.getDateString(dto.getExamDate())%>" readonly="readonly">
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("examDate", request)%></font></br>


								<span ><b>Exam Time</b><span
									style="color: red;">*</span></span> </br> <div class="input-group mb-3">
									<div class="input-group-prepend">
									<span class="input-group-text"><i class="fa fa-sort-desc"></i></span>
									</div>
									<%
										HashMap map1 = new HashMap();
										map1.put("08:00 AM to 11:00 AM", "08:00 AM to 11:00 AM");
										map1.put("12:00PM to 3:00PM", "12:00PM to 3:00PM");
										map1.put("3:00PM to 6:00PM", "3:00PM to 6:00PM");
										String htmlList1 = HTMLUtility.getList("examTime", dto.getExamTime(), map1);
									%>
									<%=htmlList1%></div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("examTime", request)%></font></br>


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
							
	<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("description", request)%></font>
							</div>
							</br>
							<%
								if (id > 0) {
							%>
							<div class="text-center">
								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=TimeTableCtl.OP_UPDATE%>"> <input
									type="submit" name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=TimeTableCtl.OP_CANCEL%>">
							</div>
							<%
								} else {
							%>
							<div class="text-center">
								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=TimeTableCtl.OP_SAVE%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=TimeTableCtl.OP_RESET%>">
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