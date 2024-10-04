package paquete.controladores.admin;

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

// Servlet para filtar los proyectos
@WebServlet("/admin_filtro_proyectos")
public class admin_filtro_proyectos extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_filtro_proyectos() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para guardar la id del proyecto
		int dato=0;
		
		// Recogemos el parametro "dato" para guardarlo en la variable
		if(request.getParameter("dato")!=null) {
			try {
				dato=Integer.parseInt(request.getParameter("dato"));
			} catch (NumberFormatException e) {

				dato = 0;
			}
		}
		
		// Creacion de las listas para guardar los datos sacados de la base de datos
		List<Proyecto> listaProyecto = db.obtenerTodosProyectos(con);
		List<Objetivos> listaObjetivos = db.obtenerTodosObjetivos(con);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front
		request.setAttribute(ATR_VAR_DATO, dato);
		request.setAttribute(ATR_LISTA_PROYECTOS, listaProyecto);	
		request.setAttribute(ATR_LISTA_OBJETIVOS, listaObjetivos);
		
		// Llamamos a admin_proyectos_usuario_filtrado.jsp
		 request.getRequestDispatcher(JSP_ADMIN_PROYECTOS_FILTRADO).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
