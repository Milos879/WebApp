<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.config.DBConnection"%>
<%@ page import="com.project.repository.PonudeRepository"%>
<%@ page import="com.project.config.DBConnection"%>
<%@ page import="java.util.List"%>
<%@ page import="com.project.model.Ponude"%>



<!DOCTYPE html>
<html>
<head>
<%@ include file="includes/head.jsp"%>
<style>
.r {
    background-image: url('product-image/pozadina.jpg');

}

.card-img-top2 {
    width: 100%;
    height: 15vw;
    object-fit: cover;
}

</style>

</head>
<body class=r>
	<%@  include file="includes/navbar.jsp"%>

	<%
	
	Korisnik k =(Korisnik) request.getSession().getAttribute("auth");


	

		PonudeRepository ur = new PonudeRepository(DBConnection.getConnection());
		List<Ponude> products = ur.getAllActivePonude();
	%>




	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			

				if (!products.isEmpty()) {

					for (Ponude pro : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card" >
					<img class="card-img-top2"
						src="product-image/<%=pro.getImage()%> "  alt="Card image cap">
					
					<div class="card-body">
						<h5 class="card-title"><%=pro.getName()%></h5>
						<h6 class="price"><%=pro.getPrice()%>$</h6>
						<h6 class="category"><%=pro.getCategory()%></h6>
					<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="add-to-cart?id=<%=pro.getId() %>">Rezervisi</a>
							
							<% if(k!=null){ if(korisnik.getRole().equals("admin")|| korisnik.getRole().equals("menadzer")){%>
							
							<a class="btn btn-danger" href="obrisiPonudu?id=<%=pro.getId() %>">Obrisi</a><%} }%>
						</div>
					</div>
				</div>

			</div>
			<%
					}
			}
			%>

		</div>
	</div>



	<%@ include file="includes/footer.jsp"%>
</body>
</html>