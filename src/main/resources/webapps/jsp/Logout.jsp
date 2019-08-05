<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../includes/Header.jsp" %>
<%@ include file="../includes/Navbar.jsp" %>

<%@ page session="true"%>

<h3 class="text-center">User '<%=request.getRemoteUser()%>' has been logged out.</h3>
<% session.invalidate(); %>

<div class="jumbotron text-center">
<a class="btn btn-danger btn-lg" href="<%= request.getContextPath() %>/jsp/Users.jsp" role="button">Start Over</a>
</div>


<%@ include file="../includes/FooterBar.jsp" %>
<%@ include file="../includes/Footer.jsp" %>