<%@page import="paquete.modelos.Rutas_conexion"%>
<%@page import="paquete.modelo.dto.Proyecto"%>
<%@page import="paquete.modelo.dto.Objetivos"%>
<%@page import="paquete.modelo.dto.Persona"%>
<%@page import="paquete.modelo.dto.Solicitudes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
     if (session == null || session.getAttribute("usuario") == null) {
	     response.sendRedirect("LoginInicio");
	     return;
    }
%>

<%
	
List<Proyecto> listaProyectos = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_PROYECTOS) != null) {
	listaProyectos = (List<Proyecto>)request.getAttribute(Rutas_conexion.ATR_LISTA_PROYECTOS);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_proyectos");
}

%>

<%
	
List<Objetivos> listaObjetivos = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_OBJETIVOS) != null) {
	listaObjetivos = (List<Objetivos>)request.getAttribute(Rutas_conexion.ATR_LISTA_OBJETIVOS);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_objetivos");
}

%>

<%
	
List<Persona> listaPersonas = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_PERSONAS) != null) {
	listaPersonas = (List<Persona>)request.getAttribute(Rutas_conexion.ATR_LISTA_PERSONAS);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_personas");
}

%>

<%
	
List<Solicitudes> listaSolicitudes = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_SOLICITUDES) != null) {
	listaSolicitudes = (List<Solicitudes>)request.getAttribute(Rutas_conexion.ATR_LISTA_SOLICITUDES);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_solicitudes");
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
				</ul>
			</div>
		</div>
	</nav>
</header>
      
<div style="display: flex">
      
<table class="styled-table" style="
    border-collapse: collapse;
    margin-top: 10vh;
    margin-left: 25vw;
    margin-right: 5vw;
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
            <th >Nombre</th>
            <th>Objetivos</th>
            <th style="width: 10vw">Texto</th>
            <th>Enviar</th>
        </tr>
    </thead>
    <tbody>
    
    	<%
					
		for(Proyecto elemento: listaProyectos) {	
					
		%>
    
    	<form method="post" action="solicitudEnviar">
        <tr>
            <td><%=elemento.getId() %></td>
            <td><%=elemento.getNombre() %></td>
            <td>
            <button type="button" id="openPopupBtn_<%=elemento.getId() %>" class="btn btn-success">
	            <svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16" style="margin-left: 0.5vw">
				  <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5m.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1z"/>
				</svg>
			</button>
            </td>
            <td style="width: 10vw">
	            <div class="form-floating" style="width: 10vw">
				  <textarea class="form-control" placeholder="Leave a comment here" name="texto" id="floatingTextarea"></textarea>
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
        <%
					
		for(Objetivos especifico: listaObjetivos) {
		if(elemento.getId()==especifico.getProyecto()){
			
		%>
        <div id="popup_<%=elemento.getId() %>" class="popup hidden">
	        <h2>Selecciona el objetivo</h2>
	        
	        		<div class="dropdown" id="elegirProyecto">
					  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
					    Selecciona el Objetivo
					  </button>
					  <ul class="dropdown-menu">
					  
				        <%
									
						for(Objetivos especifico1: listaObjetivos) {
						if(elemento.getId()==especifico1.getProyecto()){
							
						
						%>
					  	
					    <li><a class="dropdown-item" id="objetivoDropdown" href="SolicitudesObjetivo?dato1=<%=elemento.getId() %>&dato2=<%=especifico1.getId() %>"><%=especifico1.getTexto() %></a></li>
					  
					  	<% } %>
					  	<% } %>

					  
					  </ul>
					</div>
	        <input type="hidden" name="objetivo" value=""/>
	        <button id="closePopupBtn_<%=elemento.getId() %>" style="margin-left: 14vw; margin-top: 1vh">Cerrar</button>
	    </div>
	    <%}%>
        <%}%>
        </form>
        <%}%>
        
    </tbody>
</table>

<table class="styled-table" style="
    border-collapse: collapse;
    margin-top: 5vh;
    margin-left: 0vw;
    margin-right: 0vw;
    font-size: 1em;
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
            <th>Texto</th>
            <th>Veredicto</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
    
    	<%
		
    	String usuarioSesion = (String) session.getAttribute("usuario");
    	
		for(Solicitudes especificoSolicitudes: listaSolicitudes) {	
			
		if (usuarioSesion.equals(especificoSolicitudes.getPersona())) {
					
		%>
        <tr>
            <td><%=especificoSolicitudes.getTexto() %></td>
            	            <td>
	            	<% 
	            	if(especificoSolicitudes.getVeredicto()==0){
	            	%>
					<div style="
						margin-left: 0vw;
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
	            	} else if (especificoSolicitudes.getVeredicto()==1){
					%>
					<div style="
						margin-left: 0vw;
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
						margin-left: 0vw;
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
			<button type="button" class="btn btn-dark" id="botonBorrarSolicitud_<%=especificoSolicitudes.getId() %>">Borrar</button>
            </td>
        </tr>      	
        <%}%>
        <%}%>
        
        
    </tbody>
</table>

</div>

<%
					
for(Proyecto elemento: listaProyectos) {	
					
%>

<script>

const popup<%=elemento.getId() %> = document.getElementById('popup_<%=elemento.getId() %>');
const openPopupBtn<%=elemento.getId() %> = document.getElementById('openPopupBtn_<%=elemento.getId() %>');
const closePopupBtn<%=elemento.getId() %> = document.getElementById('closePopupBtn_<%=elemento.getId() %>');

function togglePopup<%=elemento.getId() %>() {
    popup<%=elemento.getId() %>.classList.toggle('hidden');
}

openPopupBtn<%=elemento.getId() %>.addEventListener('click', togglePopup<%=elemento.getId() %>);

closePopupBtn<%=elemento.getId() %>.addEventListener('click', togglePopup<%=elemento.getId() %>);


</script>

<% } %>

<%
					
for(Solicitudes especificoBorrar: listaSolicitudes) {	
					
%>

<script>
	document.getElementById("botonBorrarSolicitud_<%=especificoBorrar.getId()%>").addEventListener("click", function() {
		window.location.href = "eliminarSolicitud?dato=<%=especificoBorrar.getId() %>";
	});
</script>

<% } %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>