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

// Servlet para modificar los proyectos
@WebServlet("/modificarProyecto")
public class modificarProyecto extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public modificarProyecto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para guardar la id del proyecto
		int idProyecto = 0;

		// Recogemos el parametro de "idProyecto"
		if(request.getParameter("idProyecto") != null) {
		    try {
		    	idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Variable para guardar el texto
		String texto = "";
		
		// Recogemos el parametro "texto"
		if(request.getParameter("texto")!=null) {
			texto=request.getParameter("texto");
			if (texto.length()>150) {
				texto=texto.substring(0, 150);
			}
		}
		
		// Variable para guardar el dato del creador
		String creador = "";
		
		// Recogemos el parametro de "creador"
		if(request.getParameter("creador")!=null) {
			creador=request.getParameter("creador");
			if (creador.length()>150) {
				creador=creador.substring(0, 150);
			}
		}
		
		// Variable para guardar el nombre de la imagen
		String imagen = "";
		
		// Recogemos el parametro de "imagen"
		if(request.getParameter("imagen")!=null) {
			imagen=request.getParameter("imagen");
			if (imagen.length()>150) {
				imagen=imagen.substring(0, 150);
			}
		}
		
		// Variable para guardar el nombre
		String nombre = "";
		
		// Recogemos el parametro de "nombre"
		if(request.getParameter("nombre")!=null) {
			nombre=request.getParameter("nombre");
			if (nombre.length()>150) {
				nombre=nombre.substring(0, 150);
			}
		}
		
		// Creamos el objeto de "Proyecto" y guardamos los datos recogidos en el para despues utilizarlo
		Proyecto proyectoModificar= new Proyecto( idProyecto, texto, creador, imagen, nombre);
		
		// Llamamos a la funcion de DB_Essential de "modificarProyecto" pasandole la conexion y el objeto
		db.modificarProyecto(con, proyectoModificar);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		
		// Redireccionamos a la ruta de "admin_editar_proyectos" donde estabamos previamente
		response.sendRedirect("admin_editar_proyectos");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
