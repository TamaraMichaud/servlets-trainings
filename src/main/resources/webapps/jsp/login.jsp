<%@ include file="../includes/Header.jsp" %>
<%@ include file="../includes/Navbar.jsp" %>

<div class="container-fluid">
<form method="POST" action='<%= response.encodeURL("j_security_check") %>' class="form-signin text-center">

     <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
     <label for="inputUsername" class="sr-only">Email address</label>
     <input type="text" name="j_username" id="inputUsername" class="form-control" placeholder="login username" required autofocus>
     <label for="inputPassword" class="sr-only">Password</label>
     <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="login password" required>

     <button class="btn btn-lg btn-primary btn-block mb-1" type="submit" name="login">Log in</button>
     <a class="btn btn-dark btn-lg btn-block mb-1" style="color:white" href="users" >Cancel</a>

</form>
</div>

<%@ include file="../includes/FooterBar.jsp" %>
<%@ include file="../includes/Footer.jsp" %>