package paquete.controladores;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelo.dto.Objetivos;
import paquete.modelo.dto.Proyecto;
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

//Servlet para añadir un nuevo objetivo a la base de datos
@WebServlet("/añadirObjetivo")
public class añadirObjetivo extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public añadirObjetivo() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para recoger la id del proyecto
		int idProyecto = 0;
		
		// Recogemos el parametro idProyecto
		if(request.getParameter("idProyecto") != null) {
		    try {
		    	idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		// Variable para recoger el texto
		String texto = "";
		
		// Recogemos el parametro texto
		if(request.getParameter("texto")!=null) {
			texto=request.getParameter("texto");
			if (texto.length()>150) {
				texto=texto.substring(0, 150);
			}
		}
		// Variable para recoger la persona
		String persona="";
		
		// Recogemos el parametro persona
		if(request.getParameter("persona")!=null) {
			persona=request.getParameter("persona");
			if (persona.length()>150) {
				persona=persona.substring(0, 150);
			}
		}
		// Variable para recoger la prioridad
		int prioridad = 0;
		
		// Recogemos el parametro prioridad
		if(request.getParameter("prioridad") != null) {
		    try {
		    	prioridad = Integer.parseInt(request.getParameter("prioridad"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Creamos el objeto "Objetivos" para asignarle los valores y despues mandarlo a la funcion que lo añadira a la bd
		Objetivos objetivoAñadir= new Objetivos( 0, idProyecto, texto, persona, prioridad);
		
		// Llamamos a la funcion que tenemos en DB_Essential de mandandole la conexion y el objeto
		db.añadirObjetivo(con, objetivoAñadir);
		
		// Desconectamos la base de datos para evitar errores
		db.desconectar(con);
		
		// Redireccionamos la ruta mandandole la variable necesaria para el filtrado
		response.sendRedirect("admin_editar_objetivos?dato="+ idProyecto);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
