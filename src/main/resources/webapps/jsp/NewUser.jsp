<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../includes/Header.jsp" %>
<%@ include file="../includes/Navbar.jsp" %>
<%
 System.out.println("navigated to: NewUser.jsp");
%>

<form action="<%= request.getContextPath() %>/users" method="POST">
    <h1 class="h3 mb-3 font-weight-normal text-center">Enter New User Details</h1>
    <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" class="form-control input-md" id="firstName" name="firstName" focus required>
    </div>
    <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" class="form-control input-md" id="lastName" name="lastName" required>
    </div>
    <input class="btn btn-primary" type = "submit" value = "Submit" />
    <a class="btn btn-dark" style="color:white" href="Users.jsp" >Cancel</a>
</form>

<%@ include file="../includes/FooterBar.jsp" %>
<%@ include file="../includes/Footer.jsp" %>