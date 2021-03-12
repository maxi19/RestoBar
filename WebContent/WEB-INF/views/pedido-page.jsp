<%@page import="java.util.List"%>
<%@page import="com.restobar.dominio.Pedido"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
 <% List<Pedido> pedidos = null;
  HttpSession misession= (HttpSession) request.getSession();
 
 pedidos = (List<Pedido>) misession.getAttribute("misPedidos");   
 String idMesa =(String)request.getAttribute("idMesa"); 
 %>


	<table border ="1" width="500" align="center" > 
        <tr bgcolor="00FF7F"> 
         <th><b>Nombre</b></th> 
		 <th><b>Cantidad</b></th> 
         <th><b>Importe</b></th> 
         <th><b>Codigo</b></th>
         <th><b>Id</b></th>
         <th><b>Eliminar Pedido</b></th>
          <th><b>Estadp</b></th>
          <th><b>Cantidad</b></th>
        </tr> 
  
      <% for(Pedido pedido :pedidos){ %>
 		<tr>
		<td><%= pedido.getNombre() %></td>
		<td><%= pedido.getCantidad() %></td>
		<td><%= pedido.getImporte() %></td>
		<td><%= pedido.getCodigo() %></td>
		<td><%= pedido.getId() %></td>
		<td> ESTADO </td>
		<td> <a href="${pageContext.request.contextPath}/carrito?idMesa"> Agregar</a></td>
		</tr>
		<%} %>
</table>

<div>
<p><a href="${pageContext.request.contextPath}/carrito?idMesa"> cancelar</a></p>
<p><a href="${pageContext.request.contextPath}/reserva?agregarMas=true&idMesa=<%=idMesa%>"> Agregar mas pedidos</a></p>
</div>

</body>
</html>