<!doctype html>
<html lang="en">
   <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <link rel="stylesheet" href="style.css">

      <!--[if IE]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
      <![endif]-->

      <title>Tomcat Login</title>

   </head>
   <body>

    <div class="container-fluid" style="width:50%">
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

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>