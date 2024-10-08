package paquete.controladores;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelos.DB_Essential;

// Servlet para meter la informacion de que una persona ha salido del trabajo
@WebServlet("/check_in_out")
public class check_in_out extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public check_in_out() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para saber la id del usuario
		int usuario = 0;
		
		// Recogemos el parametro
		if(request.getParameter("idUsuario")!=null) {
			try {
				// Pa que sea del tipo de valor que queremos "int"
				usuario=Integer.parseInt(request.getParameter("idUsuario"));
			} catch (NumberFormatException e) {

				usuario = 0;
			}
		}
		
		// Llamamos a la funcion que tenemos en DB_Essential de "modificarCheckk_out" pasandole la conexion y el parametro de usuario
		db.modificarCheckk_out(con, usuario);
		
		// Llamamos a la funcion de la base de datos "cambiarEstado0" pasandole la conexion y el usuario
		db.cambiarEstado0(con, usuario);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Redireccionamos a la ruta de "check_in" para volver a ver la pagina en donde estabamos
		response.sendRedirect("check_in");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
