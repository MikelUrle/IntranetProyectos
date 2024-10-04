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

// Servlet para modificar un objetivo en especifico
@WebServlet("/admin_modificar_objetivo_unico")
public class admin_modificar_objetivo_unico extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_modificar_objetivo_unico() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para recoger la id del objetivo que se quiere modificar
		int idObjetivo = 0;

		// Recogemos el parametro de "idObjetivo" para guardarlo en la variable
		if(request.getParameter("idObjetivo") != null) {
		    try {
		    	idObjetivo = Integer.parseInt(request.getParameter("idObjetivo"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Variable para guardar el dato de la id del proyecto
		int idProyecto = 0;

		// Recogemos el parametro de "idProyecto" para guardarlo en la variable
		if(request.getParameter("idProyecto") != null) {
		    try {
		    	idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Variable para guardar el texto
		String texto = "";
		
		// Recogemos el parametro "texto" para guardarlo en la variable
		if(request.getParameter("texto")!=null) {
			texto=request.getParameter("texto");
			if (texto.length()>150) {
				texto=texto.substring(0, 150);
			}
		}
		
		// Variable para guardar la persona
		String persona = "";
		
		// Recogemos el parametro de "persona" y lo guardamos en la variable
		if(request.getParameter("persona")!=null) {
			persona=request.getParameter("persona");
			if (persona.length()>150) {
				persona=persona.substring(0, 150);
			}
		}
		
		// Variable para guardar la prioridad
		int prioridad = 0;

		// Recpgemos el parametro de "prioridad" y lo guardamos en la variable
		if(request.getParameter("prioridad") != null) {
		    try {
		    	prioridad = Integer.parseInt(request.getParameter("prioridad"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Creamos el objeto "Objetivos" rellenandolo con los datos necesarios
		Objetivos objetivoModificar= new Objetivos( idObjetivo, idProyecto, texto, persona, prioridad);
		
		// Llamada a la funcion de DB_Essential "modificarObjetivo" mandandole la conexion y el objeto 
		db.modificarObjetivo(con, objetivoModificar);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Llamamos a la pagina del front con la "idProyecto" para el filtrado
		 response.sendRedirect("admin_editar_objetivos?dato="+ idProyecto);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
