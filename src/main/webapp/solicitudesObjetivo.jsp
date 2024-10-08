<%@page import="paquete.modelos.Rutas_conexion"%>
<%@page import="paquete.modelo.dto.Proyecto"%>
<%@page import="paquete.modelo.dto.Objetivos"%>
<%@page import="paquete.modelo.dto.Persona"%>
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

	
List<Persona> listaPersonas = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_PERSONAS) != null) {
	listaPersonas = (List<Persona>)request.getAttribute(Rutas_conexion.ATR_LISTA_PERSONAS);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_personas");
}

	
int dato1 = 0;
int dato2 = 0;
if(request.getAttribute(Rutas_conexion.ATR_VAR_DATO1) != null || (Rutas_conexion.ATR_VAR_DATO2) != null) {
	dato1 = (int)request.getAttribute(Rutas_conexion.ATR_VAR_DATO1);
	dato2 = (int)request.getAttribute(Rutas_conexion.ATR_VAR_DATO2);

} else {
	out.println("Error de atributos");
	out.println("No llegaron los atributos necesarios");
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proyectos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="styles/style.css">
<link rel="stylesheet" href="styles/solicitudes.css">
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
      
      
<table class="styled-table" style="
    border-collapse: collapse;
    margin-top: 20vh;
    margin-left: 25vw;
    margin-right: 30vw;
    font-size: 1.4em;
    font-family: sans-serif;
    box-shadow: 0 0 40px rgba(0, 0, 0, 0.15);
"
>
    <thead>
        <tr style="
            background-color: #009879;
    		color: #ffffff;
    		text-align: left;
        ">
            <th >Nombre del Proyecto</th>
            <th>Objetivo</th>
            <th style="width: 10vw">Texto</th>
            <th>Enviar</th>
        </tr>
    </thead>
    <tbody>
    
    	<%
					
		for(Proyecto elemento: listaProyectos) {	
			if(elemento.getId()==dato1){			
		%>
	    
	    	<form method="post" action="solicitudEnviarObjetivo">
	        <tr>
	            <input type="hidden" name="idProyecto" value="<%=elemento.getId() %>">
	            <td><%=elemento.getNombre() %></td>
	            <td>

				    <%
					
					for(Objetivos preciso: listaObjetivos) {	
						if(preciso.getId()==dato2){			
					%>

					<%=preciso.getTexto()%>
					<input type="hidden" name="objetivo" value="<%=preciso.getTexto()%>">
					<%}%>
					<%}%>
	            </td>
	            <td style="width: 10vw">
		            <div class="form-floating" style="width: 10vw">
					  <textarea class="form-control" name="texto" id="floatingTextarea"></textarea>
					</div>
	            </td>
	            <td>
	            <input type="hidden" name="idProyecto" value="<%=elemento.getId()%>">
				<button type="submit" class="btn btn-success">
				    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
				        <path d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z"/>
				    </svg>
				</button>
	            </td>
	        </tr>
	
	        </form>
	        <%}%>
        <%}%>
        
    </tbody>
</table>

<button type="button" class="btn btn-dark" id="botonReturn" style="
	margin-left: 67vw;
	margin-top: 10vh;
	height: 50px;
	width: 100px
">Volver</button>

<script>
    document.getElementById("botonReturn").addEventListener("click", function() {
        window.location.href = "Solicitudes";
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>