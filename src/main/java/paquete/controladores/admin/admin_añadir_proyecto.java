package paquete.controladores.admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import paquete.modelo.dto.Proyecto;
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;
// Servlet para poder añadir un proyecto nuevo a la base de datos
@WebServlet("/admin_añadir_proyecto")
// Sirve para poder permitir añadir archivos dentro del proyecto
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 2,      // 2 MB
		  maxRequestSize = 1024 * 1024 * 10   // 10 MB
		)
public class admin_añadir_proyecto extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_añadir_proyecto() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Guardado de la imagen en partes
		Part filePart = request.getPart("p_foto");
		String fileName = filePart.getSubmittedFileName();
		
		// Variable para poder guardar el nombre de la foto
		String foto="";
		if (fileName!=null) {
			foto=fileName;
		}
		
		// Variable para poder recoger el texto
		String texto = "";
		
		// Recogemos el texto del formulario
		if(request.getParameter("textoProyecto")!=null) {
			texto=request.getParameter("textoProyecto");
			if (texto.length()>150) {
				texto=texto.substring(0, 150);
			}
		}
		
		// Tomamos en cuenta la sesion de creada para recoger el dato de "usuario" para ya despues utilizarlo como el "creador"
		HttpSession session = request.getSession(false);
		String creador = (String) session.getAttribute("usuario");
		
		// Variable para recoger el nombre del proyecto
		String nombre = "";
		
		// Recogemos el parametro "nombreProyecto" para guardarlo en la variable
		if(request.getParameter("nombreProyecto")!=null) {
			nombre=request.getParameter("nombreProyecto");
			if (nombre.length()>150) {
				nombre=nombre.substring(0, 150);
			}
		}
		
		// Creamos el objeto para guardar los parametro en el
		Proyecto proyectoAñadir= new Proyecto(0 , texto, creador, foto, nombre);
		
		// Llamamos a la funcion del DB_Essential de "añadirProyecto" mandandole el objeto y la conexion para que lo añada a la base de datos
		db.añadirProyecto(con, proyectoAñadir);
		
		// Desconectar la base de datos
		db.desconectar(con);
		
		// Redireccionamos a la ruta de "admin_editar_proyectos" para volver a la pagina que estabamos
		response.sendRedirect("admin_editar_proyectos");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
