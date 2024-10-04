<%@page import="paquete.modelos.Rutas_conexion"%>
<%@page import="paquete.modelo.dto.CheckkAll"%>
<%@page import="paquete.modelo.dto.Usuario"%>
<%@ page import="java.time.LocalTime, java.time.Duration" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
List<CheckkAll> listaCheckkAll = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_CHECKKALL) != null) {
	listaCheckkAll = (List<CheckkAll>)request.getAttribute(Rutas_conexion.ATR_LISTA_CHECKKALL);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_checkkall");
}

%>    

<%
	
List<Usuario> listaUsuarios = new ArrayList<>();
if(request.getAttribute(Rutas_conexion.ATR_LISTA_USUARIOS) != null) {
	listaUsuarios = (List<Usuario>)request.getAttribute(Rutas_conexion.ATR_LISTA_USUARIOS);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_lista_usuarios");
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
				</ul>
			</div>
		</div>
	</nav>
</header>

<div class="dropdown" id="elegirProyecto" style="
	margin-left: 18vw;
	margin-top: 5vh
">
		<button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" style="margin-left: 10vw">
		  Selecciona Usuario
		</button>
		<ul class="dropdown-menu">
		  
		 <%
					
		 for(Usuario especificoUsu: listaUsuarios) {
							
						
		 %>
		  
		  <li><a class="dropdown-item" href="admin_checkkall_filtrado?dato=<%=especificoUsu.getId() %>"><%=especificoUsu.getNombre()%></a></li>
		  
		 <% } %>
		  
		</ul>
</div>

<table class="styled-table" style="
    border-collapse: collapse;
    margin-top: 5vh;
    margin-left: 22vw;
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
            <th>ID</th>
            <th>Usuario</th>
            <th style="width: 150px">Hora-entrada</th>
            <th style="width: 150px">Hora-salida</th>
            <th>Fecha</th>
            <th>Texto</th>
        </tr>
    </thead>
    <tbody>
    
    	<%
					
		for(CheckkAll elemento: listaCheckkAll) {	

		%>
        
	        <tr>
	            <td>
	            	<p><%=elemento.getId() %></p>
	            </td>
	            <td>
	            
	            <%
					
				for(Usuario especifico: listaUsuarios) {	
					
				if(elemento.getUsuario()==especifico.getId()){
		
				%>
	            
					<p><%=especifico.getNombre() %></p>
	            
	            <%}%>
	            <%}%>
	            
	            </td>
	            <td style="width: 150px">
					<p style="width: 150px"><%=elemento.getHora_entrada() %></p>
	            </td>
	            <td style="width: 150px">
					<p style="width: 150px"><%=elemento.getHora_salida() %></p>
	            </td>
	           	<td>
					<p><%=elemento.getFecha() %></p>
	            </td>
	            <td>
					<p><%=elemento.getTexto() %></p>
	            </td>
	        </tr>

        <%}%>
        
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>