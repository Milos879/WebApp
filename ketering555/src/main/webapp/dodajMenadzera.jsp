<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="com.project.config.DBConnection" %>

<html>
<head>
<%@ include file="includes/head.jsp"%>
</head>
<body>
<%
boolean error= false;
if(request.getAttribute("error")!=null){
	error=true;
}

%>

<%@ include file="includes/navbar.jsp"%>


	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Registration</div>
			<div class="card-body">
				<form action="registracija" method="post">


					<div class="form-group">
						<label>Name</label> <input type="text"
							class="form-control" name="name" 
							required>
					</div>


					<div class="form-group">
						<label>Surname</label> <input type="text"
							class="form-control" name="surname" 
							required>
					</div>
					
					<div class="form-group">
						<label>Address</label> <input type="text"
							class="form-control" name="address" 
							required>
					</div>
					
					

                <div class="form-group">
						<label>E-mail</label> <input type="email"
							class="form-control" name="email" placeholder="example@mail.com"
							required><% 
							if(error){%>
								<h6  style="color:red;">E-MAIL POSTOJI!!!</h6>
						<% 	}
							%>
							
					</div>


                 <div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password" placeholder="******"
							required>
					</div>

                  <input type="hidden" name="role" value="menadzer" class="form-input">


					<div class="text-center">
						<button type="submit" class="btn btn-primary">Submit</button>

					</div>
				</form>



			</div>
		</div>
	</div>




	<%@ include file="includes/footer.jsp"%>
</body>
</html>
