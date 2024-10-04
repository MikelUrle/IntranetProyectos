<%@page import="paquete.modelos.Rutas_conexion"%>
<%@page import="paquete.modelo.dto.Proyecto"%>
<%@page import="paquete.modelo.dto.Objetivos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
if (session == null || session.getAttribute("usuario") == null) {
	response.sendRedirect("LoginInicio");
	return;
}
	
List<Proyecto> listaProyectos = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_PROYECTOS) != null) {
	listaProyectos = (List<Proyecto>)request.getAttribute(Rutas_conexion.ATR_LISTA_PROYECTOS);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_proyectos");
}

int primerId = 0;

for(Proyecto elemento: listaProyectos) {
	
	primerId = elemento.getId();
	
}
	
List<Objetivos> listaObjetivos = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_OBJETIVOS) != null) {
	listaObjetivos = (List<Objetivos>)request.getAttribute(Rutas_conexion.ATR_LISTA_OBJETIVOS);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_objetivos");
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="styles/styleAdmin.css">

</head>
<body>

<header>
	<nav class="navbar navbar-expand-lg bg-body-tertiary" id="navbarGeneral">
		<div class="container-fluid" id ="navbarEspecifico">
			<a class="navbar-brand" href="#" id="titulo">IntranetProyectos (Zona ADMIN)</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavHeader">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="textoNav nav-link" id="check_inHeader" href="admin_checkkall" style="margin-left: 40vw">Check-in</a>
					</li>
					<li class="nav-item">
						<a class="textoNav nav-link" id="proyectosHeader" href="AdminProyectos" style="margin-left: 2vw">Proyectos</a>
					</li>
					<li class="nav-item">
						<a class="textoNav nav-link" id="solicitudesHeader" href="admin_solicitudes" style="margin-left: 2vw">Solicitudes</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</header>


      


<div style="display: flex; margin-top: 5vh">
<div style="width: 50vw">  
    <main style="margin-left: 6vw; margin-bottom: -6vh">
		<div class="imagenBorde">
		
			<%
					
			for(Proyecto elemento: listaProyectos) {
			
					
			%>
			<% if(elemento.getId()==primerId){%>
			<img src="images/
			<%=elemento.getImagen()%>
			" style="width: 40vw; height: 20vw">
			<%}%>
			<% } %>
			
		</div>
	</main>
	
		<div id="des">
			<div class="form-floating">
			<%for(Proyecto elemento: listaProyectos) {%>
			<h2 id="tituloProyecto">
				<% if(elemento.getId()==primerId){%>
			  	<%=elemento.getNombre() %>
			  	<%}%>
			</h2>
			<% if(elemento.getId()==primerId){%>
			  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 24vh; width: 42vw; margin-left: 6vw" readonly>

			<%=elemento.getTexto() %>

	
			  </textarea>
			  <%}%>	
			  <% } %>
			</div>
		</div>
</div>

<div style="width: 50vw">
		<div style="display: flex">
			<div class="dropdown" id="elegirProyecto">
			  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" style="margin-left: 10vw">
			    Selecciona Proyecto
			  </button>
			  <ul class="dropdown-menu">
			  
			  	<%
						
				for(Proyecto elemento: listaProyectos) {
							
						
				%>
			  
			    <li><a class="dropdown-item" href="admin_filtro_proyectos?dato=<%=elemento.getId() %>"><%=elemento.getNombre() %></a></li>
			  
			  	<% } %>
			  
			  </ul>
			</div>
	
			<button type="button" class="btn btn-dark" id="botonEditarProyecto">Editar</button>
		</div>

		<div>
			<%		
			for(Proyecto elemento: listaProyectos) {		
			%>
			<h2 id="tituloProyecto">
				<% if(elemento.getId()==primerId){%>
 			  	<%=elemento.getNombre() %>
			  	<%}%>
			</h2>
			<% } %>
		</div>

		<table class="table-primary" id="tablePriority" style="height: 64vh">
		  <thead>
		    <tr class="cabecera">
		      <th scope="col">#</th>
		      <th scope="col">Objetivo</th>
		      <th scope="col"></th>
		      <th scope="col">Persona</th>
		    </tr>
		  </thead>
		  <tbody>
		    
		  	<%
					
			for(Objetivos elemento: listaObjetivos) {		
					
			%>
		    <% if(elemento.getProyecto()==primerId){%>
		    <tr class="
		    <% if(elemento.getPrioridad()==1){%>
		    primary
		    <%	
		    } else if(elemento.getPrioridad()==2) {%>	
		    secondary	
		    <%	
		    } else {%>	
		    np		
		    <%} %>
		    ">
		      <th scope="row">#</th>
		      <td><%=elemento.getTexto() %></td>
		      <td></td>
		      <td><%=elemento.getPersona() %></td>
		    </tr>
		    <% } %>
		    <% } %>
		  </tbody>
		</table>
</div>  
</div>
      
<script>
    document.getElementById("botonEditarProyecto").addEventListener("click", function() {
        window.location.href = "admin_editar_proyectos";
    });
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>