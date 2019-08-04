<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@page import = "data.User" %>
<%@page import = "data.Users" %>
<%@page import = "servlet.ProjectConstants" %>

<%@ include file="../includes/Header.jsp" %>
<%@ include file="../includes/Navbar.jsp" %>
<%
 System.out.println("navigated to: UpdateUser.jsp");

 Users users = (Users) request.getServletContext().getAttribute(ProjectConstants.USERS_DB);
 String userId = (String) request.getAttribute("userId");
 User user = users.get(userId);

%>

<form action="<%= request.getContextPath() %>/users" method="POST">
<input type="hidden" name="id" value="<%= userId %>">
    <h1 class="h3 mb-3 font-weight-normal text-center">Change User Information</h1>
    <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" class="form-control input-md" id="firstName" name="firstName" value="<%= user.getFirstName() %>" focus required>
    </div>
    <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" class="form-control input-md" id="lastName" name="lastName" value="<%= user.getLastName() %>" required>
    </div>
    <input class="btn btn-primary" type = "submit" value = "Submit" />
    <a class="btn btn-dark" style="color:white" href="jsp/Users.jsp" >Cancel</a>
</form>


<%@ include file="../includes/FooterBar.jsp" %>
<%@ include file="../includes/Footer.jsp" %>