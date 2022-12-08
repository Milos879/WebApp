<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="includes/head.jsp"%>
</head>
<body>
<%
boolean error=false;

if(request.getAttribute("error")!=null){
	error=true;
}


%>

<%@ include file="includes/navbar.jsp"%>


	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="login" method="post">


					<div class="form-group">
						<label>Email Address</label> <input type="email"
							class="form-control" name="email" placeholder="Enter email"
							required>
					</div>


					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password" placeholder="*****"
							required>
					</div>
                        <% if(error){%>
                        <h6  style="color:red;">email/password invalid!!!</h6>
                        
                          <%}
                        
                        
                        %>

					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>

					</div>
				</form>



			</div>
		</div>
	</div>




	<%@ include file="includes/footer.jsp"%>
</body>
</html>