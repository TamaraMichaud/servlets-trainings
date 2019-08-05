<%@ include file="../includes/Header.jsp" %>
<%@ include file="../includes/Navbar.jsp" %>

<div class="container-fluid jumbotron text-center">

      <h1 class="display-4">Woopsie!</h1>
      <p class="lead">You&#39;ve messed this up a bit I think!</p>
      <hr class="my-4">
      <p>Shall we try again...</p>
      <p class="lead">
        <a class="btn btn-danger btn-lg" href="<%= request.getContextPath() %>/jsp/Users.jsp" role="button">Start Over</a>
      </p>
</div>

<%@ include file="../includes/FooterBar.jsp" %>
<%@ include file="../includes/Footer.jsp" %>