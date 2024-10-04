package paquete.modelos;

import java.sql.Connection;
import java.util.List;


import paquete.modelo.dto.Proyecto;
import paquete.modelo.dto.Solicitudes;
import paquete.modelo.dto.Usuario;
import paquete.modelo.dto.CheckkAll;
import paquete.modelo.dto.Objetivos;
import paquete.modelo.dto.Persona;

public interface Metodos_interfaz {
	
	public Connection conectar();

	void desconectar(Connection con);

	List<Proyecto> obtenerTodosProyectos(Connection con);
	
	List<Objetivos> obtenerTodosObjetivos(Connection con);
	
	List<Persona> obtenerTodasPersonas(Connection con);
	
	List<CheckkAll> obtenerTodosCheckkAll(Connection con);
	
	List<Usuario> obtenerTodosUsuarios(Connection con);
	
	List<CheckkAll> obtenerTodosCheckkAllFiltrado(Connection con, int id_usuario);
	
	List<Solicitudes> obtenerTodosSolicitudes(Connection con);
	
	List<Solicitudes> obtenerTodosSolicitudesPorProyecto(Connection con, int idProyecto);
	
	void insertarCheckk_in(Connection con, int id_usuario, String texto);
	
	void modificarCheckk_out(Connection con, int id_usuario);
	
	String conseguirContraseña(Connection con, String usuario);
	
	void cambiarEstado(Connection con, int id_usuario);
	
	void cambiarEstado0(Connection con, int id_usuario);
	
	void cambiarVeredicto(Connection con, int idProyecto, int veredictoNuevo);
	
	void insertarSolicitud(Connection con, String usuario, String proyecto, String texto, String objetivo);
	
	void insertarSolicitudObjetivo(Connection con, String usuario, String proyecto, String texto, String objetivo);
	
	void añadirProyecto(Connection con, Proyecto producInsertar);
	
	void añadirObjetivo(Connection con, Objetivos objetivoAñadir);
	
	void modificarObjetivo(Connection con, Objetivos objetivoModificar);
	
	void modificarProyecto(Connection con, Proyecto proyectoModificar);
	
	void borrarProyecto(Connection con, int id);
	
	void borrarObjetivo(Connection con, int id);
	
	void borrarSolicitud(Connection con, int idSolicitud);

}
