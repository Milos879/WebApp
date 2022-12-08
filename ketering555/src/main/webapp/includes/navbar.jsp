<%@ page import="com.project.model.Korisnik"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<div class="container">
		<a class="navbar-brand" href="home.jsp">Catering Service</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

<% Korisnik korisnik =(Korisnik)request.getSession().getAttribute("auth");  %>


		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="home.jsp">Home</a></li>
				
                  <li class="nav-item"><a class="nav-link" href="ponude.jsp">Ponude</a></li>


				<%
				if (korisnik != null) {
				%>
				
				
				
				
				
				
                <li class="nav-item"><a class="nav-link" href="cart.jsp">Rezervacije</a></li>
			   
				
				 <% if(korisnik.getRole().equals("admin")|| korisnik.getRole().equals("menadzer")) {%>
				 
				 <li class="nav-item"><a class="nav-link" href="izvestaj.jsp">IZVESTAJ</a></li>
				 <li class="nav-item"><a class="nav-link" href="preostalePonude.jsp">DODAJ PONUDU</a></li>
				 <%} %>
				 <%  if(korisnik.getRole().equals("admin")) { %> 
				 <li class="nav-item"><a class="nav-link" href="sviKorisnici.jsp">KORISNICI</a></li>
				 
				 <% }%>
				 
				 <li class="nav-item"><a class="nav-link" href="profil.jsp">Profile</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
				
			 
			
				
				
				
				
				
				<%} else {
				%>
          
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="registracija.jsp">Register</a>
				</li>
				<%
				}
				%>
                






			</ul>



		</div>
	</div>
</nav>

