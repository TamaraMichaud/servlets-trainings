<%@ include file="../includes/Header.jsp" %>
<%@ include file="../includes/Navbar.jsp" %>

<div class="container-fluid jumbotron text-center">

      <h1 class="display-4">Uh oh!</h1>
      <p class="lead">You don&#39;t have access to perform this action</p>
      <hr class="my-4">
      <p>Time to ask for a promotion...</p>
      <p class="lead">
        <a class="btn btn-danger btn-lg" href="<%= request.getContextPath() %>/jsp/Users.jsp" role="button">Start Over</a>
      </p>
</div>

<%@ include file="../includes/FooterBar.jsp" %>
<%@ include file="../includes/Footer.jsp" %>