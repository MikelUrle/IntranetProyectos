<%@page import="paquete.modelos.Rutas_conexion"%>
<%@page import="paquete.modelo.dto.Proyecto"%>
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
	
int Id = 0;
if(request.getAttribute(Rutas_conexion.ATR_VAR_DATO_ID_PROYECTO) != null) {
	Id = (int)request.getAttribute(Rutas_conexion.ATR_VAR_DATO_ID_PROYECTO);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo ATR_VAR_DATO_ID_PROYECTO");
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="styles/style.css">
<link rel="stylesheet" href="styles/tablas.css">
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
						<a class="textoNav nav-link" href="admin_checkkall">Check-in</a>
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
    margin-left: 14vw;
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
            <th><p style="width: 250px; margin-top: 18px">Nombre</p></th>
            <th><p style="width: 300px; margin-top: 18px">Texto</p></th>
            <th>Creador</th>
            <th><p style="width: 200px; margin-top: 18px">Imagen</p></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
    
    	<%
					
		for(Proyecto elemento: listaProyectos) {	
			if(Id == elemento.getId()){
		%>
        
        <form method="post" action="modificarProyecto" >
	        <tr>
	            <td>
	            	<p>AN</p>
	            </td>
	            <td>
		           	<div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" name="nombre"><%=elemento.getNombre() %></textarea>
					</div>
	            </td>
	            <td>
		            <div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" name="texto"><%=elemento.getTexto() %></textarea>
					</div>
	            </td>
	            <td>
		            <div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" name="creador"><%=elemento.getCreador() %></textarea>
					</div>
	            </td>
	           	<td>
		            <div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" name="imagen"><%=elemento.getImagen() %></textarea>
					</div>
	            </td>
	            <td style="text-align: center">
	            	<button type="submit" class="btn btn-dark">Modificar</button>
	            </td>
	        </tr>
	        <input type="hidden" name="idProyecto" value="<%= elemento.getId() %>">
        </form>
    
        
        <%}%>
        <%}%>
        
    </tbody>
</table>

<button type="button" class="btn btn-dark" id="botonReturn" style="
	margin-left: 81vw;
	margin-top: 10vh;
	height: 50px;
	width: 100px
">Volver</button>

<script>
    document.getElementById("botonReturn").addEventListener("click", function() {
        window.location.href = "admin_editar_proyectos";
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>