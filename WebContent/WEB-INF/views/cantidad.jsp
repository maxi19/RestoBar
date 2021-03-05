
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
<% Mesa mesa = (Mesa) request.getAttribute("mesa"); %>
<h1> Mesa numero ${mesa.getNumeroMesa()}   </h1>
<h3>${mesa.getDescripcion()}</h3>

                
         <form method="GET" action="${pageContext.request.contextPath}/cantidad?">
			<table border ="1" width="500" align="center" > 
				    <tr bgcolor="00FF7F"> 
				          <th><b>Ingresa cantidad de comensales</b></th> 
				           <th><b>Ingrese monto</b></th> 
				      </tr> 	
				 		<tr>
						<td> <input type="text" id="cantidad" name="cantidad"></td>
						<td> <input type="submit" value ="confirmar cantidad"></td>
						</tr>
			
			</table>
		</form>


</body>
</html>