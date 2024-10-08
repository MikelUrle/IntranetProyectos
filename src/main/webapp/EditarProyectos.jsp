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
<link rel="stylesheet" href="styles/formulario.css">
</head>
<body>

<header>
	<nav class="navbar navbar-expand-lg bg-body-tertiary" id="navbarGeneral">
		<div class="container-fluid" id ="navbarEspecifico">
			<a class="navbar-brand" href="#" id="titulo">IntranetProyectos (Zona ADMIN)</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav" style="margin-left: 40vw">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="textoNav nav-link" href="admin_checkkall">Check-in</a>
					</li>
					<li class="nav-item" style="margin-left: 2vw">
						<a class="textoNav nav-link" href="AdminProyectos">Proyectos</a>
					</li>
					<li class="nav-item" style="margin-left: 2vw">
						<a class="textoNav nav-link" href="Solicitudes">Solicitudes</a>
					</li>
					<li class="nav-item" style="margin-left: 2vw">
						<a href="deslogin">
							<svg xmlns="http://www.w3.org/2000/svg" width="45" height="45" fill="currentColor" class="bi bi-box-arrow-in-left" viewBox="0 0 16 16" style="color: black">
							  <path fill-rule="evenodd" d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0z"/>
							  <path fill-rule="evenodd" d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708z"/>
							</svg>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</header>     

<div>
	<div style="margin-left: 5vw; margin-right: 5vw; margin-top: 5vh">
		<form method="post" action="admin_añadir_proyecto" enctype="multipart/form-data">
			<label>Nombre del Proyecto</label>
			<input type="text" name="nombreProyecto" value="" /><br>
			
			<label>Texto</label>
			<div class="form-floating">
			  <textarea class="form-control" placeholder="Leave a comment here" name="textoProyecto" id="floatingTextarea" style="height: 8vh"></textarea>
			</div>
			
			<label>Foto</label>
			<input type="file" name="p_foto" id="p_foto"  required accept="image/*"><br>
			
			<input type="submit" value="Añadir" />
		</form>
	</div>
	<div style="margin-left: 5vw; margin-right: 5vw; margin-top: 5vh">
		<table class="table table-bordered">
	        <thead>
	          <tr>
	            <th scope="col">ID</th>
	            <th scope="col">Nombre</th>
	            <th scope="col">Creador</th>
	            <th scope="col">Imagen</th>
	            <th></th>
	            <th></th>
	            <th></th>
	          </tr>
	        </thead>
	        <tbody>
	          <%
	          for (Proyecto elemento : listaProyectos) { 
	          %>
	          <tr>
	            <td><%= elemento.getId() %></td>
	            <td><%= elemento.getNombre() %></td>
	            <td><%= elemento.getCreador() %></td>
	            <td><%= elemento.getImagen() %></td>
	            <td><a href="admin_modificar_proyecto?id=<%=elemento.getId() %>">Modificar</a></td>
	            <td><a href="admin_editar_objetivos?dato=<%=elemento.getId() %>">Modificar Objetivos</a></td>
	            <td><a href="admin_borrar_proyecto?id=<%=elemento.getId() %>">Borrar</a></td>
	          </tr>
	          <% } %>
	        </tbody>
	    </table>
	</div>
	<div>
	
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>