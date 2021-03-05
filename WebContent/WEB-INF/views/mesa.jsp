<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.restobar.dominio.Mesa"%> 
         <%@page import="com.restobar.dominio.Menu"%> 
    <%@page import="java.util.ArrayList"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%Mesa mesa =(Mesa)request.getAttribute("mesaInfo"); %>  
<h3> <%=mesa.getNombre()%> </h3>

<form action="${pageContext.request.contextPath}/reserva?" method="post">


<table border ="1" width="500" align="center" > 
         <tr bgcolor="00FF7F"> 
          <th><b>Nombre de menu</b></th> 
		 <th><b>Plato principal</b></th> 
          <th><b>Postre</b></th> 
          <th><b>Bebida</b></th>
          <th><b>Precio</b></th>
          <th><b>cantidad</b></th>
         
         </tr> 

 <%ArrayList<Menu> menus = (ArrayList<Menu>)request.getAttribute("menus"); 
        for(Menu menu :menus){ %> 
 		<tr>
 		<input type="hidden" name="id" value = "<%=menu.getId()%>">
 		<td><%=menu.getTitulo()%></td>
 		<td><%=menu.getPlato()%></td>
		<td><%=menu.getPostre()%></td>
		<td><%=menu.getBebida()%></td>
		<td><%=menu.getPrecio()%></td>
		<td><input type="text" nameo="cantidad" value="">   </td>
		<tr>
		<input type="submit" value="Solicitar pedido">

<% }

%>
</table>

</form>



<div>
<center>
<button onclick="alerta()">confirmar</button>
</center>
</div>
</body>
</html>