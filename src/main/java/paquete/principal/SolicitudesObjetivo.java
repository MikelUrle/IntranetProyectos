package paquete.principal;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelo.dto.Objetivos;
import paquete.modelo.dto.Persona;
import paquete.modelo.dto.Proyecto;
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Funcion para llamar a las solicitudes de los objetivos
@WebServlet("/SolicitudesObjetivo")
public class SolicitudesObjetivo extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public SolicitudesObjetivo() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Variables para guardar los datos recibidos
		int dato1;
		int dato2;
		
		// Recogemos los datos y los pasamos a "int"
		dato1=Integer.parseInt(request.getParameter("dato1"));
		dato2=Integer.parseInt(request.getParameter("dato2"));
		
		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Creacion de las listas para guardar los datos sacados de la base de datos
		List<Proyecto> listaProyecto = db.obtenerTodosProyectos(con);
		List<Objetivos> listaObjetivos = db.obtenerTodosObjetivos(con);
		List<Persona> listaPersonas = db.obtenerTodasPersonas(con);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front
		request.setAttribute(ATR_VAR_DATO1, dato1);
		request.setAttribute(ATR_VAR_DATO2, dato2);
		request.setAttribute(ATR_LISTA_PROYECTOS, listaProyecto);	
		request.setAttribute(ATR_LISTA_OBJETIVOS, listaObjetivos);
		request.setAttribute(ATR_LISTA_PERSONAS, listaPersonas);
		
		// Llamamos a solicitudesObjetivo.jsp
		request.getRequestDispatcher(JSP_SOLICITUDES_OBJETIVO).forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
