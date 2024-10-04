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

import paquete.modelo.dto.CheckkAll;
import paquete.modelo.dto.Usuario;

// Servlet para llamar a la pagina de checkk_in
@WebServlet("/admin_checkkall")
public class admin_checkkall extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_checkkall() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Creacion de las listas para guardar los datos sacados de la base de datos
		List<CheckkAll> listaCheckkAll = db.obtenerTodosCheckkAll(con);
		List<Usuario> listaUsuarios = db.obtenerTodosUsuarios(con);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front
		request.setAttribute(ATR_LISTA_CHECKKALL, listaCheckkAll);
		request.setAttribute(ATR_LISTA_USUARIOS, listaUsuarios);	
		
		// Llamamos a adminCheck_In.jsp
		request.getRequestDispatcher(JSP_ADMIN_CHECKK_IN).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
