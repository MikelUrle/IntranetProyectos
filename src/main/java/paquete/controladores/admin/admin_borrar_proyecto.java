package paquete.controladores.admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelos.DB_Essential;

// Servlet para poder borrar un proyecto
@WebServlet("/admin_borrar_proyecto")
public class admin_borrar_proyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public admin_borrar_proyecto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para poder recoger la id del proyecto
		int id = 0;
		
		// Recogemos el parametro "id" y lo guardamos en la variable
		if(request.getParameter("id") != null) {
		    try {
		    	id = Integer.parseInt(request.getParameter("id"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Llamamos a la funciond de DB_Essential pasandole la conexion y la id del proyecto
		db.borrarProyecto(con, id);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Redireccionamos a la ruta "admin_editar_proyectos" para poder volver a la pagina donde estabamos
		response.sendRedirect("admin_editar_proyectos");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
