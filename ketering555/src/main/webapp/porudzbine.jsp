<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import= "com.project.model.Cart" %>	
<%@ page import= "java.util.*" %>	
<%@ page import= "com.project.repository.PonudeRepository"%>
<%@ page import="com.project.model.Korisnik"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="includes/head.jsp"%>
</head>
<body>
<%
Korisnik k =(Korisnik) request.getSession().getAttribute("auth");


%>

<div class="card">
  <div class="card-header">
    RACUN
  </div>
  <div class="card-body">
    <form action="plati" method="post">
    <table class="table table-hover table-dark w-50 ">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Proizvod</th>
      <th scope="col">Kolicina</th>
      <th scope="col">Cena</th>
      <th scope="col">Adresa</th>
      <th scope="col">Datum</th>
      
    </tr>
  </thead>
 
  <tbody>
  
    <%

   ArrayList<Cart> cart=(ArrayList<Cart>)request.getSession().getAttribute("cartovi");
   
    if(cart==null){
    	response.sendRedirect("cart.jsp");
    }else{
    double ukupnaCena =  PonudeRepository.ukupnaCena(cart);
   double ukupnaKolicina= PonudeRepository.ukupnaKolicina(cart);
  
   
   
    boolean popustKolicina=false;
   
    if(request.getAttribute("popustKolicina")!=null ){
    	popustKolicina=false;
    	
    	ukupnaCena=ukupnaCena/2;
    }
    
    if(request.getAttribute("prviPopust")!=null){
    	ukupnaCena=ukupnaCena-(ukupnaCena*0.1);
    	
    }
        
    if(ukupnaKolicina>15 && request.getSession().getAttribute("popustKolicina")==null){
    	popustKolicina=true;
    }
  
    
  
    int i=1; for(Cart c: cart){ 
      %>
    	<tr>
    
      <th scope="row"><%= i++%></th>
      <td><%=c.getName()%></td>
      <td><%=c.getQuantity() %></td>
      
      <td><%=c.getPrice()%>$</td>
      <td><%=k.getAddress()%></td>
      <td><input type="date"   name="datum<%=c.getId()%>" required/></td>
    
  </tr>
  
   <% }%>
   
 </tbody>
 
 
</table>
<button type="submit" class="btn btn-primary">PLATI: <%=ukupnaCena%>$</button>
<% 
if(k.getDiscount()==1){%>
<a class="btn btn-sm btn-danger" href="popust?popust=prvi&id=<%=k.getId()%>">POPUST REGISTRACIJA -10%</a>
<%  }%>
 
 <% 
 if(popustKolicina){%>
 
 <a class="btn btn-sm btn-danger" href="popust?popust=kolicina">POPUST KOLICINA -50%</a>
 
 
<%}} %>
 
 </form>   
    
   
  </div>
</div>
</body>
</html>