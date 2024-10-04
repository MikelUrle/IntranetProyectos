<%@page import="paquete.modelos.Rutas_conexion"%>
<%@page import="paquete.modelo.dto.Proyecto"%>
<%@page import="paquete.modelo.dto.Objetivos"%>
<%@page import="paquete.modelo.dto.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <% --%>
//      if (session == null || session.getAttribute("usuario") == null) {
// 	     response.sendRedirect("LoginInicio");
// 	     return;
//     }
<%-- %> --%>

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
	
int Id = 0;
if(request.getAttribute(Rutas_conexion.ATR_VAR_DATO_ID_PROYECTO) != null) {
	Id = (int)request.getAttribute(Rutas_conexion.ATR_VAR_DATO_ID_PROYECTO);

} else {
	out.println("Error de atributos");
	out.println("No llego el atributo atr_var_dato_id_proyecto");
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proyectos</title>
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
				</ul>
			</div>
		</div>
	</nav>
</header>
      
      
<table class="styled-table" style="
    border-collapse: collapse;
    margin-top: 10vh;
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
            <th><p style="width: 300px; margin-top: 18px">Texto<p></th>
            <th>Creador</th>
            <th>Prioridad</th>
             <th></th>
        </tr>
    </thead>
    <tbody>
    
    	<%
					
		for(Objetivos elemento: listaObjetivos) {	
			if(Id == elemento.getProyecto()){
		%>
    
		        <tr>
		            <td><%=elemento.getId() %></td>
		            <td><%=elemento.getTexto() %></td>
		            <td style="text-align: center"><%=elemento.getPersona() %></td>
		            <td style="text-align: center"><%=elemento.getPrioridad() %></td>
		            <td><a href=admin_modificar_objetivo?dato=<%=elemento.getId() %>>Modificar</a> <a href="admin_borrar_objetivo?dato=<%=elemento.getId() %>&idPro=<%=elemento.getProyecto() %>">Borrar</a></td>
		        </tr>
			<%}%>
        <%}%>
        
        <form method="post" action="añadirObjetivo">
	        <tr>
	            <td>
	            	<p>AN</p>
	            </td>
	            <td>
		           	<div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" name="texto"></textarea>
					</div>
	            </td>
	            <td>
		            <div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" name="persona"></textarea>
					</div>
	            </td>
	            <td>
		            <div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" name="prioridad"></textarea>
					</div>
	            </td>
	            <td style="text-align: center">
	            	<button type="submit" class="btn btn-dark">Añadir</button>
	            </td>
	        </tr>
	        <input type="hidden" name="idProyecto" value="<%= Id %>">
        </form>
        
    </tbody>
</table>

<button type="button" class="btn btn-dark" id="botonReturn" style="
	margin-left: 67vw;
	margin-top: 10vh;
	margin-bottom: 5vh;
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