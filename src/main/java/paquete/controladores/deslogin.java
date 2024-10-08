package paquete.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paquete.modelos.Rutas_conexion;


@WebServlet("/deslogin")
public class deslogin extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public deslogin() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Hay que destruir la sesion primero
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		// Redireccionaremos a la pagina de login
    	response.sendRedirect("LoginInicio");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
