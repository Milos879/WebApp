<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.project.repository.PorudzbinaRepository" %>
<%@ page import="com.project.config.DBConnection" %>
<%@ page import="com.project.model.Porudzbina" %>
<%@ page import="java.util.*" %>
<html>
<%@ include file="includes/head.jsp"%>


</head>
<body>
	


<%

PorudzbinaRepository por= new PorudzbinaRepository(DBConnection.getConnection());

ArrayList<Porudzbina> pordzbine= por.getAllPorudzbine();
System.out.println("radee");
%>




<table class="table table-sm table-info">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Datum</th>
      <th scope="col">Cena</th>
      <th scope="col">Kolicina</th>
       <th scope="col">Adresa</th>
       <th scope="col">Ponuda</th>
       <th scope="col">Korisnik</th>
    </tr>
  </thead>
  <tbody>
   <% int i=1; for(Porudzbina v : pordzbine){ %>
    <tr>
      <th scope="row"><%=++i%></th>
      <td><%=v.getDatum() %></td>
      <td><%=v.getPrice() %>$</td>
      <td><%=v.getKolicina()%></td>
     <td><%=v.getAddress()%></td>
     <td><%=v.getPonuda()%></td>
     <td><%=v.getUser()%></td>
    </tr>
 <%} %>
  </tbody>
</table>
 <div class="text-left">
				<a class="btn btn-sm btn-warning" href="home.jsp">Nazad</a>
             </div>
               
</body>
</html>