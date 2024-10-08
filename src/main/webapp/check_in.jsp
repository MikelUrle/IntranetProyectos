<%@page import="paquete.modelos.Rutas_conexion"%>
<%@page import="paquete.modelo.dto.Persona"%>
<%@page import="paquete.modelo.dto.Checkk"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
List<Persona> listaPersonas = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_PERSONAS) != null) {
	listaPersonas = (List<Persona>)request.getAttribute(Rutas_conexion.ATR_LISTA_PERSONAS);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_personas");
}

	
List<Checkk> listaCheckks = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_CHECKK) != null) {
	listaCheckks = (List<Checkk>)request.getAttribute(Rutas_conexion.ATR_LISTA_CHECKK);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_checkk");
}

%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Check-In</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="styles/style.css">
</head>
<body>

<header>
	<nav class="navbar navbar-expand-lg bg-body-tertiary" id="navbarGeneral">
		<div class="container-fluid" id ="navbarEspecifico">
			<a class="navbar-brand" href="#" id="titulo">IntranetProyectos</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav" style="margin-left: 50vw">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="textoNav nav-link" href="check_in">Check-in</a>
					</li>
					<li class="nav-item" style="margin-left: 2vw">
						<a class="textoNav nav-link" href="CargarProyectos">Proyectos</a>
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

<div class="container text-center" style="margin-left: 12vw">
  <div class="row align-items-start">
  
    <div class="col">
    </div>
    
    <div class="col">
      

	      <table class="table" style="margin-top: 12vh">
			  <tbody>
			  
			  	<%
					
				for(Persona elemento: listaPersonas) {
				
				%>
				<%
					
				for(Checkk preciso: listaCheckks) {
				
				%>
			  	<%
			  	
			  	if(preciso.getId_usuario() == elemento.getId()){
			  		
			  	%>
			  		
			  	<tr class="
			  	<%
			  	if(preciso.getEstado()==0){%>
			  	table-primary
			  	<%
			  	} else {%>
			  	table-success
			  	<%
			  	}
			  	%>
			  	">
			      <th scope="row" style="
			      	padding: 50px;
			      	padding-top: 90px
			      "><%=elemento.getId()%></th>
			      <td><img src="images/<%=preciso.getFoto()%>"
			      style="
			      	height: 200px;
			      	width: 300px
			      "></td>
			      <td style="
			      	padding: 50px;
			      	padding-top: 90px;
			      	font-family: roboto;
			      	font-size: 1.6em;
			      "><%=elemento.getNombre()%></td>
			      <td style="
			      	padding-top: 80px;
			      ">
			      <form method="post" action="check_in_post">
				      <div class="form-floating">
					  	<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" name="textoCheckk" style="
					  		width: 600px;
					  	"></textarea>
					  	<label for="floatingTextarea">Escriba aqui el mensaje de lo ocurrido</label>
					  </div>
				  </td>
				  <td style="
				  	padding: 50px;
				  	padding-top: 70px
				  ">
				  	  <input type="hidden" name="idUsuario" value="<%=preciso.getId_usuario()%>">
					  <input type="submit" class="btn btn-success" style="margin-bottom: 10px" value="Entrada">
				  </form>
				  <form method="post" action="check_in_out">
				  	  <input type="hidden" name="idUsuario" value="<%=preciso.getId_usuario()%>">
					  <input type="submit" class="btn btn-success" value="Salida">
				  </form>
				  </td>
			    </tr>
			  		
			  	<% } %>

			    <% } %>
			    <% } %>
			  </tbody>
			</table>

    </div>
    
    <div class="col">
    </div>
    
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>