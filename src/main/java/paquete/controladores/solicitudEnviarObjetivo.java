package paquete.controladores;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para añadir la solicitud pero especificando que sea de un objetivo y no de un proyecto completo
@WebServlet("/solicitudEnviarObjetivo")
public class solicitudEnviarObjetivo extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public solicitudEnviarObjetivo() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Contamos con el valor del parametro "usuario" de la sesion para despues utilizarlo
		HttpSession session = request.getSession(false);
		String usuario = (String) session.getAttribute("usuario");
		
		// Variable para guardar el objetivo
		String objetivo="";

		// Recogemos el parametro de "objetivo"
		if(request.getParameter("objetivo")!=null) {
			objetivo=request.getParameter("objetivo");
			if (objetivo.length()>150) {
				objetivo=objetivo.substring(0, 150);
			}
		}
		
		// Variable para guardar el proyecto
		String proyecto = "";
		
		// Recogemos el parametro de "idProyecto"
		if(request.getParameter("idProyecto")!=null) {
			proyecto=request.getParameter("idProyecto");
			if (proyecto.length()>150) {
				proyecto=proyecto.substring(0, 150);
			}
		}
		
		// Variable para guardar el texto
		String texto="";

		// Recogemos el parametro de "texto"
		if(request.getParameter("texto")!=null) {
			texto=request.getParameter("texto");
			if (texto.length()>150) {
				texto=texto.substring(0, 150);
			}
		}
		
		// Llamada a la funcion de DB_Essential de "insertarSolicitud" pasandole la conexion, usuario, proyecto, objetivo y el texto
		db.insertarSolicitud(con, usuario, proyecto, objetivo, texto);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Redireccionamos a la ruta de "Solicitudes" donde estabamos previamente
		response.sendRedirect("Solicitudes");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
