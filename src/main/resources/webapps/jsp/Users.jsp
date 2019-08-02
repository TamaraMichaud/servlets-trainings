<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@page import = "data.User" %>
<%@page import = "data.Users" %>
<%@page import = "servlet.ProjectConstants" %>
<%@page import = "java.util.Map" %>
<%@ include file="../includes/Header.jsp" %>
<%@ include file="../includes/Navbar.jsp" %>
<%
  Users users = (Users) request.getServletContext().getAttribute(ProjectConstants.USERS_DB);
%>

    <h1 class="h3 mb-3 font-weight-normal text-center">List of Users</h1>

    <table class="table table-striped table-hover" >
        <tr>
            <th>ID</th><th>First Name</th><th>Last Name</th><th>Action</th>
        </tr>

<%
  for (Map.Entry<String, User> thing: users.entrySet()) {

    User nextUser = thing.getValue();

%>

        <tr>
            <td><%= nextUser.getId().substring(0,13) %></td>
            <td><a class="btn btn-info" href="<%= request.getContextPath() %>/updateuser?id=<%= nextUser.getId() %>"><%= nextUser.getFirstName() %></a></td>
            <td><%= nextUser.getLastName() %></td>
            <td><a class="btn btn-info" href="<%= request.getContextPath() %>/users?action=delete&id=<%= nextUser.getId() %>">delete</a></td>
        </tr>

<%
  }
%>

    </table>
    <div class="row">
    <a class="btn btn-primary col-lg-12 col-sm-12 col-xs-12" href="NewUser.jsp"> Add New User </a>
    </div>

<%@ include file="../includes/FooterBar.jsp" %>
<%@ include file="../includes/Footer.jsp" %>
