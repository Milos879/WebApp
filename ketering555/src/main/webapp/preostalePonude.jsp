<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.project.repository.PonudeRepository" %>
<%@ page import="com.project.config.DBConnection" %>
<%@ page import="com.project.model.Ponude" %>
<%@ page import="java.util.*" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="includes/head.jsp"%>


</head>
<body>
	


<%

PonudeRepository por= new PonudeRepository(DBConnection.getConnection());

ArrayList<Ponude> ponude= por.getAllPassivePonude();
System.out.println("radee");
%>




<table class="table table-sm table-info">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Ime</th>
      <th scope="col">Kategorija</th>
      <th scope="col">Cena</th>
      <th scope="col">Akcija</th>
    </tr>
  </thead>
  <tbody>
   <% int i=1; for(Ponude v : ponude){ %>
    <tr>
      <th scope="row"><%=i++%></th>
      <td><%=v.getName() %></td>
      <td><%=v.getCategory() %></td>
      <td><%=v.getPrice()%></td>
     <td> <a class="btn btn-sm btn-success" href="dodajPasivnuPonudu?id=<%=v.getId()%>">DODAJ</a> </td>
     
    </tr>
 <%}%>
  </tbody>
</table>
 <div class="text-left">
				<a class="btn btn-sm btn-warning" href="home.jsp">Nazad</a>
             </div>
               
</body>
</html>