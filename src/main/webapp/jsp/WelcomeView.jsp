
<%@page import="in.co.rays.project_3.dto.RoleDto"%>
<%@page import="in.co.rays.project_3.dto.UserDTO"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

<style type="text/css">
    
    body {
	background-image: url("/project_3/img/h4.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center;

} 
</style>

</head>
<body>

 <form action="<%=ORSView.WELCOME_CTL%>">
        <%@ include file="Header.jsp"%>
        
        
        <br>
        <br>
        <br>
        
                    <h1 align="Center">
                        <font size="10px" color="red">Welcome to ORS </font>
                    </h1>
        
                    <%
                    UserDTO beanUserDTO = (UserDTO) session.getAttribute("user");
                        if (beanUserDTO != null) {
                            if (beanUserDTO.getRoleId() == RoleDto.STUDENT) {
                    %>
        
                    <h2 align="Center">
                        <a href="<%=ORSView.GET_MARKSHEET_CTL%>">Click here to see your
                            Marksheet </a>
                    </h2>
                     
                     <%
                            }
                        }
                     %>
                
                </form>
        
        <%@ include file="Footer.jsp"%></body>
</html>