<%@page import="paquete.modelos.Rutas_conexion"%>
<%@page import="paquete.modelo.dto.Solicitudes"%>
<%@page import="paquete.modelo.dto.Proyecto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
List<Solicitudes> listaSolicitudes = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_SOLICITUDES) != null) {
	listaSolicitudes = (List<Solicitudes>)request.getAttribute(Rutas_conexion.ATR_LISTA_SOLICITUDES);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_solicitudes");
}

	
List<Proyecto> listaProyectos = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_PROYECTOS) != null) {
	listaProyectos = (List<Proyecto>)request.getAttribute(Rutas_conexion.ATR_LISTA_PROYECTOS);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_proyectos");
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="styles/style.css">
<link rel="stylesheet" href="styles/tablas.css">
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

<div class="dropdown" id="elegirProyecto" style="
	margin-left: 6vw;
	margin-top: 5vh
">
		<button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" style="margin-left: 10vw">
		  Selecciona Proyecto
		</button>
		<ul class="dropdown-menu">
		  
		 <%
					
		 for(Proyecto especifico: listaProyectos) {
							
						
		 %>
		  
		  <li><a class="dropdown-item" href="admin_solicitudes_filtrado?dato=<%=especifico.getId() %>"><%=especifico.getNombre()%></a></li>
		  
		 <% } %>
		  
		</ul>
</div>

<table class="styled-table" style="
    border-collapse: collapse;
    margin-top: 5vh;
    margin-left: 0vw;
    margin-right: 40vw;
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
            <th>ID</th>
            <th>Proyecto</th>
            <th style="width: 150px">Texto</th>
            <th style="width: 150px">Objetivo</th>
            <th>Persona</th>
            <th>Veredicto</th>
        </tr>
    </thead>
    <tbody>
    
    	<%
					
		for(Solicitudes elemento: listaSolicitudes) {	

		%>
        
	        <tr>
	            <td>
	            	<p><%=elemento.getId() %></p>
	            </td>
	            <td>
	            
	            <%
					
				for(Proyecto especificoProyecto: listaProyectos) {	
					
				if(elemento.getProyecto()==especificoProyecto.getId()){
		
				%>
	            
					<p><%=especificoProyecto.getNombre() %></p>
	            
	            <%}%>
	            <%}%>
	            
	            </td>
	            <td style="width: 150px">
					<p style="width: 150px"><%=elemento.getTexto() %></p>
	            </td>
	            <td style="width: 150px">
					<p style="width: 150px"><%=elemento.getObjetivo() %></p>
	            </td>
	           	<td>
					<p><%=elemento.getPersona() %></p>
	            </td>
	            <td>
	            	<% 
	            	if(elemento.getVeredicto()==0){
	            	%>
					<div style="
						margin-left: 1.5vw;
					    background-color: #857E7B;
					    color: white;
					    padding: 20px;
					    border-radius: 15px; /* Aquí se redondean los bordes */
					    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
					    width: 50px;
					    height:50px;
					    text-align: center;
						" class="cuadro-redondeado">
				    </div>
					<%
	            	} else if (elemento.getVeredicto()==1){
					%>
					<div style="
						margin-left: 1.5vw;
					    background-color: #86CB92;
					    color: white;
					    padding: 20px;
					    border-radius: 15px; /* Aquí se redondean los bordes */
					    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
					    width: 50px;
					    height:50px;
					    text-align: center;
						" class="cuadro-redondeado">
				    </div>
					<%
	            	} else {
					%>
					<div style="
						margin-left: 1.5vw;
					    background-color: #BB0A21;
					    color: white;
					    padding: 20px;
					    border-radius: 15px; /* Aquí se redondean los bordes */
					    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
					    width: 50px;
					    height:50px;
					    text-align: center;
						" class="cuadro-redondeado">
				    </div>
					<%}%>
	            </td>
	           	<td>
	            	<button type="button" class="btn btn-dark" id="botonAceptarVeredicto_<%=elemento.getId() %>">Aceptar</button>
	            </td>
	            <td>
	            	<button type="button" class="btn btn-dark" id="botonDenegarVeredicto_<%=elemento.getId() %>">Denegar</button>
	            </td>
	        </tr>

        <%}%>
        
    </tbody>
</table>

<%
					
for(Solicitudes elemento: listaSolicitudes) {	

%>

<script>
	document.getElementById("botonAceptarVeredicto_<%=elemento.getId() %>").addEventListener("click", function() {
		window.location.href = "cambiarVeredicto?idSolicitud=<%=elemento.getId() %>&veredictoNuevo=1";
	});
</script>

<script>
	document.getElementById("botonDenegarVeredicto_<%=elemento.getId() %>").addEventListener("click", function() {
		window.location.href = "cambiarVeredicto?idSolicitud=<%=elemento.getId() %>&veredictoNuevo=2";
	});
</script>

<% } %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>