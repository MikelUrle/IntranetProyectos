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
import paquete.modelo.dto.Solicitudes;
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para filtrar solicitudes
@WebServlet("/admin_solicitudes_filtrado")
public class admin_solicitudes_filtrado extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_solicitudes_filtrado() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para guardar la id del proyecto
		int idProyecto=0;
		
		// Recogemos el parametro "dato" para guardarlo en la variable
		if(request.getParameter("dato")!=null) {
			try {
				// Pa que sea del tipo de valor que queremos "int"
				idProyecto=Integer.parseInt(request.getParameter("dato"));
			} catch (NumberFormatException e) {

				idProyecto = 0;
			}
		}
		
		// Creacion de las listas para guardar los datos sacados de la base de datos
		List<Solicitudes> listaSolicitudes = db.obtenerTodosSolicitudesPorProyecto(con, idProyecto);
		List<Proyecto> listaProyectos = db.obtenerTodosProyectos(con);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front
		request.setAttribute(ATR_LISTA_SOLICITUDES, listaSolicitudes);
		request.setAttribute(ATR_LISTA_PROYECTOS, listaProyectos);
		
		// Llamamos a admin_Solicitudes.jsp
		request.getRequestDispatcher(JSP_ADMIN_SOLICITUDES).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
