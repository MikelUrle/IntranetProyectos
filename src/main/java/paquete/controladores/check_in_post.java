package paquete.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelo.dto.Checkk;
import paquete.modelo.dto.Persona;
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para guardar el dato de que una persona sale
@WebServlet("/check_in_post")
public class check_in_post extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public check_in_post() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para recoger la id del usuario
		int usuario = 0;
		
		// Recogemos el parametro de idUsuario
		if(request.getParameter("idUsuario")!=null) {
			try {
				usuario=Integer.parseInt(request.getParameter("idUsuario"));
			} catch (NumberFormatException e) {
				
				usuario = 0;
			}
		}
		
		// Variable para el texto
		String texto="";

		// Recogemos el parametro de textoCheckk
		if(request.getParameter("textoCheckk")!=null) {
			texto=request.getParameter("textoCheckk");
			if (texto.length()>150) {
				texto=texto.substring(0, 150);
			}
		}
		
		// Llamamos a la funcion que tenemos en DB_Essential de "insertarCheckk_in" pasandole la conexion, el usuario y el texto
		db.insertarCheckk_in(con, usuario, texto);
		
		// Lo mismo para "cambiarEstado" pasandole la conexion y el usuario
		db.cambiarEstado(con, usuario);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Redireccionamos a la ruta de "check_in" para volver a la pagina en la que estabamos
		response.sendRedirect("check_in");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
