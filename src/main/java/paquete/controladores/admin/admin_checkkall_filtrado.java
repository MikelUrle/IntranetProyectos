package paquete.controladores.admin;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paquete.modelo.dto.CheckkAll;
import paquete.modelo.dto.Usuario;
import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para poder llamar a la pagina de Checkk_in con los datos filtrados
@WebServlet("/admin_checkkall_filtrado")
public class admin_checkkall_filtrado extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_checkkall_filtrado() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para recoger la id del usuario
		int id_usuario=0;
		
		// Recogemos el parametro "dato" y lo guardamos en la variable
		if(request.getParameter("dato")!=null) {
			try {
				id_usuario=Integer.parseInt(request.getParameter("dato"));
			} catch (NumberFormatException e) {

				id_usuario = 0;
			}
		}
		
		// Creacion de las listas para guardar los datos ascados de la base de datos
		List<CheckkAll> listaCheckkAllFiltrado = db.obtenerTodosCheckkAllFiltrado(con, id_usuario);
		List<Usuario> listaUsuarios = db.obtenerTodosUsuarios(con);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front
		request.setAttribute(ATR_LISTA_CHECKKALL_FILTRADO, listaCheckkAllFiltrado);
		request.setAttribute(ATR_LISTA_USUARIOS, listaUsuarios);	
		
		// Llamamos a la pagina de adminCheck_In_Filtrado.jsp
		request.getRequestDispatcher(JSP_ADMIN_CHECKK_IN_FILTRADO).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
