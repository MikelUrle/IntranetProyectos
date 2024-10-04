package paquete.principal;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelo.dto.Proyecto;
import paquete.modelo.dto.Persona;
import paquete.modelo.dto.Checkk;
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Funcion para llamar al checkk_in
@WebServlet("/check_in")
public class check_in extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public check_in() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Creacion de las listas para guardar los datos sacadas de la base de datos
		List<Persona> listaPersonas = db.obtenerTodasPersonas(con);
		List<Checkk> listaCheckks = db.obtenerTodosCheckk(con);
		
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front 
		request.setAttribute(ATR_LISTA_PERSONAS, listaPersonas);
		request.setAttribute(ATR_LISTA_CHECKK, listaCheckks);
		
		// Llamamos a check_in.jsp
		 request.getRequestDispatcher(JSP_CHECK_IN).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
