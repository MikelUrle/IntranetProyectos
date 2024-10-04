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

// Servlet para modificar los objetivos
@WebServlet("/admin_modificar_objetivo")
public class admin_modificar_objetivo extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public admin_modificar_objetivo() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Variable para recoger el id
		int dato_id=0;
		
		// Recogemos el parametro "dato" para guardarlo en la variable
		if(request.getParameter("dato")!=null) {
			try {
				// Pa que sea del tipo de valor que queremos "int"
				dato_id=Integer.parseInt(request.getParameter("dato"));
			} catch (NumberFormatException e) {

				dato_id = 0;
			}
		}
		
		// Creacion de la lista para guardar los objetivos sacados de la base de datos
		List<Objetivos> listaObjetivos = db.obtenerTodosObjetivos(con);
		
		// Desconectamos la base de datos
		db.desconectar(con);
		
		// Preparamos las mochilas para llevar los datos al front	
		request.setAttribute(ATR_LISTA_OBJETIVOS, listaObjetivos);
		request.setAttribute(ATR_VAR_DATO_ID_OBJETIVO, dato_id);
		
		// Llamamos a EditarObjetivoUnico.jsp
		request.getRequestDispatcher(JSP_EDITAR_OBJETIVO_UNICO).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
