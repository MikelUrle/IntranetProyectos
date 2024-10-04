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
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para editar los objetivos
@WebServlet("/admin_editar_objetivos")
public class admin_editar_objetivos extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_editar_objetivos() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para recoger la id del objetivo
		int dato_id=0;
		
		// Recogemos el parametro "dato" para guardarlo en la variable
		if(request.getParameter("dato")!=null) {
			try {
				dato_id=Integer.parseInt(request.getParameter("dato"));
			} catch (NumberFormatException e) {

				dato_id = 0;
			}
		}
		
		// Creacion de la lista para guardar los datos sacados de la base de datos
		List<Objetivos> listaObjetivos = db.obtenerTodosObjetivos(con);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front
		request.setAttribute(ATR_VAR_DATO_ID_PROYECTO, dato_id);
		request.setAttribute(ATR_LISTA_OBJETIVOS, listaObjetivos);
		
		// Llamamos a EditarObjetivos.jsp
		request.getRequestDispatcher(JSP_EDITAR_OBJETIVOS).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
