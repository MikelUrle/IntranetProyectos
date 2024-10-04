<%@page import="paquete.modelos.Rutas_conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="styles/style.css">
</head>
<body style="
	background-image: url('images/FondoVerde.png');
	  background-size: cover;
	  background-position: center;
	  background-repeat: no-repeat;
">

<div class="container text-center">
  <div class="row align-items-start">
    <div class="col">
    </div>
    <div class="col" id="prueba">
	    <div id="bordeDelLogin" style="
	    background: green
	    ">
	    <div id="bordeInteriorLogin">
	     

			
			<h1 style="
			margin-bottom: 3vh;
			font-size: 4em
			">LOGIN</h1>
			
					
			<form class="row g-3 needs-validation" method="post" action="Login">
			  <div class="col-md-4">
			    <label for="validationCustom01" class="form-label" style="
			    font-size: 1.6em
			    ">Usuario</label>
			    <input type="text" class="form-control" id="validationCustom01" name="usuario" value="" required>
			  </div>
			  <div class="col-md-4">
			    <label for="validationCustom02" class="form-label" style="
			    font-size: 1.6em
			    ">Contraseña</label>
			    <input type="password" class="form-control" id="validationCustom02" name="contra" value="" required>
			  </div>
			  <div class="col-12">
			    <button class="btn btn-primary" type="submit">Entrar</button>
			  </div>
			</form>
	     
	     
	    </div>
	</div>
    </div>
    <div class="col">
    </div>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

