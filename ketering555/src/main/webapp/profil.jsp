<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="com.project.model.Korisnik" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="includes/head.jsp"%>
</head>
<body>

<%@ include file="includes/navbar.jsp"%>

<% 
Korisnik k= (Korisnik)request.getSession().getAttribute("auth");


%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Profile</div>
			<div class="card-body">
				<form action="profil" method="post">

					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							name="name" value="<%=k.getName() %>" required>
					</div>


					<div class="form-group">
						<label>Surname</label> <input type="text" class="form-control"
							name="surname"  value="<%=k.getSurname()%>"  required>
					</div>


					<div class="form-group">
						<label>Address</label> <input type="text" class="form-control"
							name="address"  value="<%=k.getAddress()%>" required>
					
					
					
					
					     
             
					
					</div>



 <div class="text-left">
				<a class="btn btn-sm btn-danger" href="profil?id=<%=k.getId()%>">Obrisi profil</a>
             </div>
               


				

					<div class="text-center" >
						<button type="submit" class="btn btn-success">Sacuvaj izmene</button>
                   </div>
              


        
              

				</form>


				</div>



			</div>
		</div>
	





	<%@ include file="includes/footer.jsp"%>
</body>
</html>