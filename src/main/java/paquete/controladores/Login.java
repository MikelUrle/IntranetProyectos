package paquete.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paquete.modelos.DB_Essential;
import paquete.modelos.Rutas_conexion;

// Servlet para la parte del login de la intranet
@WebServlet("/Login")
public class Login extends HttpServlet implements Rutas_conexion{
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Conexion a la base de datos		
		DB_Essential db = new DB_Essential();
		Connection con = db.conectar();
		
		// Inicializamos las variables para despues guardar en ellos los datos necesarios pal procedimiento de verificacion del usuario
        String username = "";
        String password = "";
        
        // Recogemos el parametro de usuario
		if(request.getParameter("usuario")!=null) {
			username=request.getParameter("usuario");
			if (username.length()>150) {
				username=username.substring(0, 150);
			}
		}
        
		// Recogemos el parametro de contra
		if(request.getParameter("contra")!=null) {
			password=request.getParameter("contra");
			if (password.length()>250) {
				password=password.substring(0, 150);
			}
		}
	
		// Hasheamos la contraseña recogida
        String hashedPassword = db.hashPassword(password);
        
        // Llamamos a la funcion de DB_Essential de "conseguirContraseña" para recoger la contraseña del usuario que le pasamos de la base de datos
        String contraHashDB=db.conseguirContraseña(con, username);
        
        //Comparar los hasheos
        if (hashedPassword.equals(contraHashDB)) {
        	
        	// Si es aceptada, crearemos la sesion con la variable del usuario que ha iniciado la sesion
    		HttpSession session= request.getSession();
    		session.setAttribute("usuario", username);
    		
    		// Y se redirige a la ruta principal de la intranet
    		response.sendRedirect("CargarProyectos");
    		
    		// Desconectamos la base de datos
            db.desconectar(con);
        } else {
        	
        	// Si falla la validacion, le volvemos a dirigir a la pagina de login no dejando entrar al usuario a la intranet
        	response.sendRedirect("LoginInicio");
        	
        	// Se desconecta la base de datos
            db.desconectar(con);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
