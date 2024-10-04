package paquete.controladores.admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para poder borrar los objetivos
@WebServlet("/admin_borrar_objetivo")
public class admin_borrar_objetivo extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_borrar_objetivo() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para recoger la id del objetivo que querremos borrar
		int id = 0;

		// Recogemos el parametro "dato" para guardarlo en la variable
		if(request.getParameter("dato") != null) {
		    try {
		    	id = Integer.parseInt(request.getParameter("dato"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Variable para recoger la id del proyecto que estamos editando
		int idPro = 0;

		// Recogemos el parametro "idPro" para guardarlo en la variable
		if(request.getParameter("idPro") != null) {
		    try {
		    	idPro = Integer.parseInt(request.getParameter("idPro"));
		    } catch (NumberFormatException e) {
		        System.out.println("Error: El parámetro no es un número válido");
		    }
		}
		
		// Llamammos a la funcion del DB_Essential "borrarObjetivo" pasandole la conexion y la id del objetivo
		db.borrarObjetivo(con, id);
		
		// Guardamos en la mochila el id del proyecto
		request.setAttribute(ATR_VAR_DATO_ID_PROYECTO, idPro);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Redireccionamos a la ruta de "admin_editar_objetivos" pasandole tambien la id del proyecto
		response.sendRedirect("admin_editar_objetivos?dato=" + idPro);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
