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

// Servlet para eliminar una solicitud
@WebServlet("/eliminarSolicitud")
public class eliminarSolicitud extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public eliminarSolicitud() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para recoger la id de la solicitud
		int idSolicitud = 0;

		// Recogemos el parametro de "dato"
		if(request.getParameter("dato") != null) {
		    try {
		    	idSolicitud = Integer.parseInt(request.getParameter("dato"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Llamada a la funcion que tenemos en DB_Essential de "borrarSolicitud" que le pasamos la conexion y la idSolicitud
		db.borrarSolicitud(con, idSolicitud);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Redireccionamos a la ruta de "Solicitudes" que es la pagina donde estabamos previo a la llamada
		response.sendRedirect("Solicitudes");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
