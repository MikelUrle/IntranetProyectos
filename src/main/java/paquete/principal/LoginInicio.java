package paquete.principal;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Funcion para poder llamar al login
@WebServlet("/LoginInicio")
public class LoginInicio extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public LoginInicio() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Llamamos a "login.jsp"
		request.getRequestDispatcher(JSP_LOGIN).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
