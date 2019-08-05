<!-- Fixed navbar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

    <a class="navbar-brand" href="users">My Exciting Website</a>

<%      String username = request.getRemoteUser();
        String actionJsp, actionText;
        if(username == null) {
            actionJsp = "Login.jsp";
            actionText = "Log In";
        } else {
            actionJsp = "Logout.jsp";
            actionText = "Log Out";
        }
%>

    <a href="<%= request.getContextPath() %>/jsp/<%= actionJsp %>" id="button-logout" class="btn" type="button"><%= actionText %></a>

</nav>

<div class="container-fluid" id="main-page">