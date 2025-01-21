<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
					<li class="nav-item"><a class="nav-link btn btn-success" href="/" style="color:white">-:Home:-</a></li>
				</ul>
			</div>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link btn" href="/logout" style="background-color:#e64444">Logout</a></li>
			</ul>	
		</nav>
 
  <div><h1 style="color: hwb(189 2% 4%)">TAKE ATTENDANCE HERE :--</h1></div>
  <hr>
  <div class="container">
     <h2 style=" color: rgb(57, 245, 5)">STUDENTS OF CST BRANCH ARE:</h2>
  <table class="table">
   <thead>
      <tr>
      <th>Rollno</th>
      <th>Name</th>
      <th>Date</th>
      <th>Present</th>
      <th>Absent</th>
      <th>Update</th>
      </tr>
     </thead>
  <tbody>
  <c:forEach items="${attedances}" var="attendance">
         <tr>
          <td>${attendance.rollno}</td>
          <td>${attendance.name}</td>
          <td>${attendance.date}</td>
          <td>${attendance.present}</td> 
          <td><a href="absent-student?rollno=${attendance.rollno}" class="btn btn-warning">Absent</a></td>
          <td><a href="update-student?rollno=${attendance.rollno}" style="background-color:pink" class="btn">Update</a></td>
         </tr>
  </c:forEach>
  </tbody>
  </table>
  <a href="add-student" class="btn btn-success">Add New Students</a>
  </div>
  <script  src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
 </body>
</html>