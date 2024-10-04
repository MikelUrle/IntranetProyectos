package paquete.controladores.admin;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelo.dto.Proyecto;
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para modificar los proyectos
@WebServlet("/admin_modificar_proyecto")
public class admin_modificar_proyecto extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_modificar_proyecto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para guardar la id del proyecto
		int idProyecto = 0;

		// Recogemos el parametro "id" para guardarlo en la variable
		if(request.getParameter("id") != null) {
		    try {
		    	idProyecto = Integer.parseInt(request.getParameter("id"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Creacion de la lista para guardar los proyectos sacados de la base de datos
		List<Proyecto> listaProyecto = db.obtenerTodosProyectos(con);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front
		request.setAttribute(ATR_VAR_DATO_ID_PROYECTO, idProyecto);
		request.setAttribute(ATR_LISTA_PROYECTOS, listaProyecto);
		
		// Llamamos a EditarProyectoUnico.jsp
		request.getRequestDispatcher(JSP_EDITAR_PROYECTO_UNICO).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
