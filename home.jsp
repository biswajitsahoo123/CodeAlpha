<html>
<head>
    <title>student list page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  </head>
 <body>
 
  <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
			<div class="collapse navbar-collapse">
			<a class="navbar-brand m-1 " href="https://www.gita.edu.in" style="color:hsl(100, 96%, 49%)"><h2>GITA</h2></a>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link btn btn-success" href="/" style="color:white" >-:Home:-</a></li>
				</ul>
			</div>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link btn" href="/logout" style="background-color:#e64444">Logout</a></li>
			</ul>	
		</nav>
 
  <div class="container">
  <h1 style="color:#057ef7">WELCOME TO HOME PAGE :- ${name} </h1>
  <hr>
  <div><a href="list-attendances" class="btn" style="background-color:blue;color:white">TAKE ATTENDANCE</a></div>
  </div>
  <script  src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
 </body>
</html>