<%@ include file="../includes/Header.jsp" %>
<%@ include file="../includes/Navbar.jsp" %>
<%
    Users users = (Users) this.getServletContext().getAttribute(ProjectConstants.USERS_DB);




%>

<h1 class="h3 mb-3 font-weight-normal">List of Users</h1>

<table class="table table-striped table-hover" >
    <tr>
        <th>ID</th><th>First Name</th><th>Last Name</th><th>Action</th>
    </tr>
    <tr>
    <td>acb88e2e-a52c</td>
<td><a class="btn btn-info" href="updateuser?id=acb88e2e-a52c-4c8d-a690-6ec145a48a0e">Bill</a></td>
<td>Bloggs</td>
<td><a class="btn btn-info" href="users?action=delete&id=acb88e2e-a52c-4c8d-a690-6ec145a48a0e">delete</a></td>
</tr>
<tr>
<td>313d1c6e-f98d</td>
<td><a class="btn btn-info" href="updateuser?id=313d1c6e-f98d-43bb-9b0b-e7deb639082b">Fred</a></td>
<td>Bloggs</td>
<td><a class="btn btn-info" href="users?action=delete&id=313d1c6e-f98d-43bb-9b0b-e7deb639082b">delete</a></td>
</tr>
</table>
<a class="btn btn-primary" href="newuser"> Add New User </a></div>

<%@ include file="../includes/FooterBar.jsp" %>
<%@ include file="../includes/Footer.jsp" %>
