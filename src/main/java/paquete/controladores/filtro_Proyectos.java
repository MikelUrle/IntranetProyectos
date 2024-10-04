package paquete.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelo.dto.Objetivos;
import paquete.modelo.dto.Proyecto;
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para filtrar los proyectos dado el dato que recogemos de la eleccion del usuario del dropdown
@WebServlet("/filtro_Proyectos")
public class filtro_Proyectos extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public filtro_Proyectos() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();

		// Variable para guardar el id del proyecto
		int idProyecto=0;
		
		// Recogemos el parametro "dato" para guardarlo como la id del proyecto
		if(request.getParameter("dato")!=null) {
			try {
				idProyecto=Integer.parseInt(request.getParameter("dato"));
			} catch (NumberFormatException e) {
				idProyecto = 0;
			}
		}
		
		// Creacion de la lista para guardar los datos recogimos de la funcion de DB_Essential de "obtenerTodosProyectos"
		List<Proyecto> listaProyecto = db.obtenerTodosProyectos(con);
		
		// Creacion de la lista para guardar los datos recogimos de la funcion de DB_Essential de "obtenerTodosObjetivos"
		List<Objetivos> listaObjetivos = db.obtenerTodosObjetivos(con);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front
		request.setAttribute(ATR_VAR_DATO, idProyecto);
		request.setAttribute(ATR_LISTA_PROYECTOS, listaProyecto);	
		request.setAttribute(ATR_LISTA_OBJETIVOS, listaObjetivos);
		
		// Llamamos a la pagina del front para que inicie
		 request.getRequestDispatcher(JSP_PROYECTOS_FILTRADO).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
