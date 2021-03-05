<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.restobar.dominio.*"%> 
    <%@page import="java.util.ArrayList"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
int cantidad = 10;

%>


<table border ="1" width="500" align="center" > 
         <tr bgcolor="00FF7F"> 
          <th><b>Nombre de mesa</b></th> 
          <th><b>Estado</b></th> 
          <th><b>desripcion</b></th> 
          <th><b>Cantidad comensales</b></th>
          <th><b>Reservar</b></th>
         </tr> 

 <%ArrayList<Mesa> mesas = (ArrayList<Mesa>)request.getAttribute("mesas"); 
        for(Mesa mesa :mesas){ %> 
 		
 		<tr>
 		<td><%=mesa.getNombre()%></td>
		<td><%=mesa.getEstado()%></td>
		<td><%=mesa.getDescripcion()%></td>
		<td><a href="${pageContext.request.contextPath}/reserva?idMesa=<%=mesa.getNumeroMesa()%>">reservar</a></td>
		</tr>

<% }%>
</table>


</body>
</html>