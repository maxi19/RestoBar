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

<script type="text/javascript">
function agregarCarrito() {
		
	 var myTab = document.getElementById('tabla-menus').innerHTML = "";
	 // LOOP THROUGH EACH ROW OF THE TABLE AFTER HEADER.
	 for (i = 1; i < myTab.rows.length; i++ ) {
		  
		  // GET THE CELLS COLLECTION OF THE CURRENT ROW.
          var objCells = myTab.rows.item(i).cells;
          for (var j = 0; j < objCells.length; j++) {
        	  objCells.item(j);
        	  
        	  
          }
		 
	  }
	
}

</script>

<style type="text/css">

	
    .divTable
    {
        display:  table;
        width:auto;
        background-color:#eee;
        border:1px solid  #666666;
        border-spacing:5px;/*cellspacing:poor IE support for  this*/
       /* border-collapse:separate;*/
    }

    .divRow
    {
       display:table-row;
       width:auto;
    }

    .divCell
    {
        float:left;/*fix for  buggy browsers*/
        display:table-column;
        width:180px;
        background-color:#ccc;
    }

</style>
</head>
<body>

 <%  String idMesa = (String) request.getAttribute("idMesa"); %>  
	<div class="divTable">
		 <div class="headRow">
	         <div class="divCell" align="center">Nombre de menu del dia</div> 
			 <div  class="divCell">Plato principal</div> 
	         <div  class="divCell">Postre</div> 
	         <div  class="divCell">Bebida</div>
	         <div  class="divCell">Precio</div>
	         <div  class="divCell">Cantidad</div>
	         <div  class="divCell">Confirmar</div>
	    </div>
	    
      <%ArrayList<Menu> menus= null; %>
      <% menus= (ArrayList<Menu>)request.getAttribute("menus"); 
       for(Menu menu :menus){ %>
       <form action="${pageContext.request.contextPath}/carrito" method="post">
 	   <div class="divRow">
          <div class="divCell"><%=menu.getTitulo()%></div>
		  <div class="divCell"><%=menu.getPlato()%></div>
	       <div class="divCell"><%=menu.getPostre()%></div>
		   <div class="divCell"><%=menu.getBebida()%></div>
		   <div class="divCell"><%=menu.getPrecio()%></div>
		   <div class="divCell"><input type="text" id="cantidadTxt" name ="cantidadTxt" /> </div>
		   <input id="prodId" name="idMenu" type="hidden"  value="<%=menu.getId()%>">
		    <input id="idMesa" name="idMesa" type="hidden"  value="<%=idMesa%>">
		    <div class="divCell"> <input type="submit" id="onfirmar" value="confirmar"  /> </div>
		    
	    </div>
	    </form>
		<%} %>
	</div>

</body>
</html>