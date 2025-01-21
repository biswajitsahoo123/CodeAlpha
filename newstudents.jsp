<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>new students</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
  </head>
 <body>
 
  <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
         <a class="navbar-brand m-1 " href="https://www.gita.edu.in" style="color:hsl(100, 96%, 49%)"><h2>GITA</h2></a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link btn btn-success" href="/" style="color:white">-:Home:-</a></li>
					<li class="nav-item"><a class="nav-link btn" href="/list-attendances" style="background-color: rgb(225, 245, 5)"><---Back-</a></li>
				</ul>
			</div>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link btn" href="/logout" style="background-color:#e64444">Logout</a></li>
			</ul>	
		</nav>
 
  <hr>
  <div class="container">
       <h2 style="color: #f5a905">Enter name of students:-</h2>
      <form:form method="post" modelAttribute="attendance">
      <fieldset class="mb-3">
         <form:label path="name">Name:-</form:label>
         <form:input type="text" path="name" required="required"/>
      </fieldset>
      
       <fieldset class="mb-3">
          <form:label path="date">Date:</form:label>
          <form:input type="text" path="date" required="required"/>
       </fieldset>
      
      <form:errors  path="name" style="color:red"/>
      
      <form:input type="hidden" path="present" required="required"/>
      <form:input type="hidden" path="rollno" required="required"/>
      
      <input type="submit" class="btn btn-success"/>
      </form:form>
     </div>
     <script  src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
      $('#date').datepicker({
    	  format:'yyyy-mm-dd'
      });
    </script>
 </body>
</html>