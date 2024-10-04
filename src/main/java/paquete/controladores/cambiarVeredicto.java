package paquete.controladores;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para cambiar el veredicto en la base de datos
@WebServlet("/cambiarVeredicto")
public class cambiarVeredicto extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public cambiarVeredicto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para recoger la idSolicitud
		int idSolicitud = 0;
		
		// Recogemos el parametro
		if(request.getParameter("idSolicitud")!=null) {
			try {
				idSolicitud=Integer.parseInt(request.getParameter("idSolicitud"));
			} catch (NumberFormatException e) {

				idSolicitud = 0;
			}
		}
		
		// Variable para recoger el veredictoNuevo
		int veredictoNuevo = 0;
		
		// Recogemos el parametro
		if(request.getParameter("veredictoNuevo")!=null) {
			try {
				veredictoNuevo=Integer.parseInt(request.getParameter("veredictoNuevo"));
			} catch (NumberFormatException e) {

				veredictoNuevo = 0;
			}
		}
		
		// Llamada a la funcion que tenemos en DB_Essential de "cambiarVeredicto" pasandole la conexion, la idSOlicitud y el veredictoNuevo
		db.cambiarVeredicto(con, idSolicitud, veredictoNuevo);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		
		// Redirigimos a la ruta "admin_solicitudes"
		response.sendRedirect("admin_solicitudes");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
