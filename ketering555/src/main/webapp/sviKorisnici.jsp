<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.model.Korisnik"%>
<%@ page import="com.project.repository.KorisnikRepository"%>
<%@ page import="com.project.config.DBConnection"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head><%@ include file="includes/head.jsp"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%

KorisnikRepository por= new KorisnikRepository(DBConnection.getConnection());

ArrayList<Korisnik> ponude= por.getAllKorisnik();

%>




<table class="table table-sm table-info">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Ime</th>
      <th scope="col">Prezime</th>
      <th scope="col">Email</th>
       <th scope="col">Uloga</th>
      <th scope="col">Adresa</th>
      <th scope="col">Obrisi</th>
    </tr>
  </thead>
  <tbody>
   <% int i=1; for(Korisnik v : ponude){ %>
    <tr>
      <th scope="row"><%=i++%></th>
      <td><%=v.getName() %></td>
      <td><%=v.getSurname() %></td>
      <td><%=v.getEmail()%></td>
      <td><%=v.getRole()%></td>
      <td><%=v.getAddress()%></td>
     <td> <a class="btn btn-sm btn-danger" href="obrisi?id=<%=v.getId()%>">Obrisi</a> </td>
     
    </tr>
 <%}%>
  </tbody>
</table>
 <div class="text-left">
			<a class="btn btn-sm btn-warning" href="home.jsp">Nazad</a>
   </div>
   
   <div class="text-center">
			<a class="btn btn-sm btn-success" href="dodajMenadzera.jsp">DODAJ MENADZERA</a>
  </div>
                  
</body>
</html>