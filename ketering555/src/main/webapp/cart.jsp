<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import= "com.project.model.Cart" %>	
<%@ page import= "java.util.*" %>	
<%@ page import= "com.project.repository.PonudeRepository"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="includes/head.jsp"%>


</head>
<body>
	<%@ include file="includes/navbar.jsp"%>


<%
 
List<Cart> cartovi=null;
double ukupnaCena=0;
if(request.getSession().getAttribute("cartovi")!=null){
	
cartovi= (ArrayList<Cart>)request.getSession().getAttribute("cartovi");
System.out.println(cartovi.size());

ukupnaCena=PonudeRepository.ukupnaCena(cartovi);
}
%>


	<div class="container">
		<div class="d-flex py-3">
			<h3>Ukupan iznos:<%=String.format("%.2f",ukupnaCena)%> $</h3>
			<a class="mx-3 btn btn-primary" href="porudzbine.jsp">Naruci</a>
		</div>
		<table class="table table-loght">
			<thead>
				<tr>
					<th scope="col">Ime</th>
					<th scope="col">Kategorija</th>
					<th scope="col">Cena</th>
					<th scope="col">Kolicina</th>
					<th scope="col">Izbaci</th>
				</tr>

			</thead>
			
			<% 
			if(cartovi!=null){
			  for(Cart cart: cartovi){%>
				  
				  <tbody>
					<tr>
						<td><%=cart.getName()%></td>
						<td><%=cart.getCategory()%></td>
						<td><%=String.format("%.2f",cart.getPrice())%>$</td>
						<td>
							<form action="" method="post" class="form-inline">
								<input type="hidden" name="id" value=<%=cart.getId() %> class="form-input">
								<div class="form-group d-flex justify-content-between">

									<a class="btn btn-sm btn-incre" href="quantity-incre-decre?action=incre&id=<%=cart.getId() %>">
									<i
										class="fas fa-plus-square"> </i></a> 
										<input type="text" name="quantity" class="from-control" value="<%=cart.getQuantity() %>" readonly>
									<a class="btn btn-sm btn-decre" href="quantity-incre-decre?action=decre&id=<%=cart.getId() %>"><i
										class="fas fa-minus-square"> </i></a>

								</div>

							</form>



						</td>

						<td><a class="btn btn-sm btn-danger" href="remove-from-cart?id=<%=cart.getId()%>">Remove</a></td>
					</tr>


				</tbody>
				  
			  <% }}%>
			
			

		</table>

	</div>



	<%@ include file="includes/footer.jsp"%>
</body>
</html>