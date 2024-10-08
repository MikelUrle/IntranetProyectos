package paquete.modelos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import paquete.modelo.dto.Proyecto;
import paquete.modelo.dto.Solicitudes;
import paquete.modelo.dto.Usuario;
import paquete.modelo.dto.Objetivos;
import paquete.modelo.dto.Persona;
import paquete.modelo.dto.Checkk;
import paquete.modelo.dto.CheckkAll;



public class DB_Essential implements Metodos_interfaz, Rutas_conexion{
	
	// Funcion para crear la conexion a la base de datos
	@Override
	public Connection conectar() {
		
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/intranet","root","1234");
			
			System.out.println("DB conectada");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR DE DB");
			System.out.println("No se encontro el driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("ERROR DE DB");
			System.out.println("No se pudo conectar a la base de datos");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE DB");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}
		
		return con;
		
	}
	
	// Funcion para desconectarse de la base de datos
	@Override
	public void desconectar (Connection con) {
		
		try {
			con.close();
			System.out.println("DB desconectada");
		} catch (SQLException e) {
			System.out.println("ERROR DE DB");
			System.out.println("No se pudo desconectar de la base de datos");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE DB");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}
		
	}

	// Funcion para obtener todos los proyectos
	@Override
	public List<Proyecto> obtenerTodosProyectos(Connection con) {
		   
		List<Proyecto> lista = new ArrayList<Proyecto>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_PROYECTOS);
			
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				// Se recogen los datos y se guardan en un objeto "Proyecto"
				while(rs.next()) {
					
					Proyecto proyecto = new Proyecto();
					
					proyecto.setId(rs.getInt(PRODUCTOS_ID));
					proyecto.setTexto(rs.getString(PROYECTO_TEXTO));
					proyecto.setCreador(rs.getString(PROYECTO_CREADOR));
					proyecto.setImagen(rs.getString(PROYECTO_IMAGEN));
					proyecto.setNombre(rs.getString(PROYECTO_NOMBRE));
					
					// El objeto lo guardamos en una lista
					lista.add(proyecto);
				}
				
				return lista;
				
			} else {
				
				System.out.println("No se obtubo una Lista de productos");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return new ArrayList<Proyecto>();
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todos los productos");
			System.out.println(e.getMessage());
			
			return new ArrayList<Proyecto>();
		}
		
	}
	
	// Funcion para obtener todos los objetivos
	@Override
	public List<Objetivos> obtenerTodosObjetivos(Connection con) {
		
		List<Objetivos> lista = new ArrayList<Objetivos>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_OBJETIVOS);
			
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				
				while(rs.next()) {
					
					Objetivos objetivos = new Objetivos();
					
					objetivos.setId(rs.getInt(OBJETIVOS_ID));
					objetivos.setProyecto(rs.getInt(OBJETIVOS_PROYECTO));
					objetivos.setTexto(rs.getString(OBJETIVOS_TEXTO));
					objetivos.setPersona(rs.getString(OBJETIVOS_PERSONA));
					objetivos.setPrioridad(rs.getInt(OBJETIVOS_PRIORIDAD));
					
					lista.add(objetivos);
					
				}
				
				System.out.println(lista);
				return lista;
				
			} else {
				//mensaje de error
				System.out.println("No se obtubo una Lista de objetivos");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return new ArrayList<Objetivos>();
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todos los objetivos");
			System.out.println(e.getMessage());
			
			return new ArrayList<Objetivos>();
		}
		
	}
	
	// Funcion para obtener todas las personas
	@Override
	public List<Persona> obtenerTodasPersonas(Connection con){
		
		List<Persona> lista = new ArrayList<Persona>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_PERSONAS);
			
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				
				while(rs.next()) {
					
					Persona persona = new Persona();
					
					persona.setId(rs.getInt(PERSONA_ID));
					persona.setNombre(rs.getString(PERSONA_NOMBRE));
					
					lista.add(persona);
					
				}
				
				System.out.println(lista);
				return lista;
				
			} else {

				System.out.println("No se obtubo una Lista de pesonas");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return new ArrayList<Persona>();
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todas las personas");
			System.out.println(e.getMessage());
			
			return new ArrayList<Persona>();
		}
		
	}
	
	// Funcion para obtener todos los Checkk_in
	public List<Checkk> obtenerTodosCheckk(Connection con){
		
		List<Checkk> lista = new ArrayList<Checkk>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_CHECKK);
			
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				
				while(rs.next()) {
					
					Checkk checkk = new Checkk();
					
					checkk.setId(rs.getInt(CHECKK_ID));
					checkk.setEstado(rs.getInt(CHECKK_ESTADO));
					checkk.setId_usuario(rs.getInt(CHECKK_ID_USUARIO));
					checkk.setFoto(rs.getString(CHECKK_FOTO));
					
					lista.add(checkk);
					
				}
				
				System.out.println(lista);
				return lista;
				
			} else {
				//mensaje de error
				System.out.println("No se obtubo una Lista de checkks");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return new ArrayList<Checkk>();
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todos los checkks");
			System.out.println(e.getMessage());
			
			return new ArrayList<Checkk>();
		}
		
	}
	
	// Funcion para obtener todos los chekkAll
	@Override
	public List<CheckkAll> obtenerTodosCheckkAll(Connection con) {
		   
		List<CheckkAll> lista = new ArrayList<CheckkAll>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_CHECKKALL);
			
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				
				while(rs.next()) {
					
					CheckkAll checkkall = new CheckkAll();
					
					checkkall.setId(rs.getInt(CHECKKALL_ID));
					checkkall.setUsuario(rs.getInt(CHECKKALL_USUARIO));
					checkkall.setHora_entrada(rs.getString(CHECKKALL_HORA_ENTRADA));
					checkkall.setHora_salida(rs.getString(CHECKKALL_HORA_SALIDA));
					checkkall.setFecha(rs.getString(CHECKKALL_FECHA));
					checkkall.setTexto(rs.getString(CHECKKALL_TEXTO));
					
					lista.add(checkkall);
					
				}

				return lista;
				
			} else {
				//mensaje de error
				System.out.println("No se obtubo una Lista de checkkall");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return new ArrayList<CheckkAll>();
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todos los checkkall");
			System.out.println(e.getMessage());
			
			return new ArrayList<CheckkAll>();
		}
		
	}
	
	// Funcion para obtener todos los usuarios
	@Override
	public List<Usuario> obtenerTodosUsuarios(Connection con) {
		   
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_USUARIOS);
			
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				
				while(rs.next()) {
					
					Usuario usuario = new Usuario();
					
					usuario.setId(rs.getInt(USUARIO_ID));
					usuario.setNombre(rs.getString(USUARIO_NOMBRE));
					usuario.setRol(rs.getString(USUARIO_ROL));
					
					lista.add(usuario);
					
				}
				
				return lista;
				
			} else {

				System.out.println("No se obtubo una Lista de usuarios");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return new ArrayList<Usuario>();
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todos los usuarios");
			System.out.println(e.getMessage());
			
			return new ArrayList<Usuario>();
		}
		
	}
	
	// Funcion para obtener todos los Checkkall ya filtrados habiendole pasado ya la id del usuario
	@Override
	public List<CheckkAll> obtenerTodosCheckkAllFiltrado(Connection con, int id_usuario) {
		   
		List<CheckkAll> lista = new ArrayList<CheckkAll>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_FILTRAR_CHECKKALL);
			
			// Preparamos la id recogida en la stored procedure
			cStmt.setInt(1, id_usuario);
			// La ejecutamos
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				
				while(rs.next()) {
					
					CheckkAll checkkall = new CheckkAll();
					
					checkkall.setId(rs.getInt(CHECKKALL_ID));
					checkkall.setUsuario(rs.getInt(CHECKKALL_USUARIO));
					checkkall.setHora_entrada(rs.getString(CHECKKALL_HORA_ENTRADA));
					checkkall.setHora_salida(rs.getString(CHECKKALL_HORA_SALIDA));
					checkkall.setFecha(rs.getString(CHECKKALL_FECHA));
					checkkall.setTexto(rs.getString(CHECKKALL_TEXTO));
					
					lista.add(checkkall);
					
				}
				
				return lista;
				
			} else {
				
				System.out.println("No se obtubo una Lista de checkkall filtrados");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return new ArrayList<CheckkAll>();
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todos los checkkall filtrados");
			System.out.println(e.getMessage());
			
			return new ArrayList<CheckkAll>();
		}
		
	}
	
	// Funcion para obtener todas las solicitudes
	@Override
	public List<Solicitudes> obtenerTodosSolicitudes(Connection con) {
		   
		List<Solicitudes> lista = new ArrayList<Solicitudes>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_SOLICITUDES);
			
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				
				while(rs.next()) {
					
					Solicitudes solicitudes = new Solicitudes();
					
					solicitudes.setId(rs.getInt(SOLICITUD_ID));
					solicitudes.setPersona(rs.getString(SOLICITUD_PERSONA));
					solicitudes.setTexto(rs.getString(SOLICITUD_TEXTO));
					solicitudes.setVeredicto(rs.getInt(SOLICITUD_VEREDICTO));
					solicitudes.setObjetivo(rs.getString(SOLICITUD_OBJETIVO));
					solicitudes.setProyecto(rs.getInt(SOLICITUD_PROYECTO));
					
					lista.add(solicitudes);
					
				}
				
				return lista;
				
			} else {

				System.out.println("No se obtubo una Lista de solicitudes");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return new ArrayList<Solicitudes>();
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todos los productos");
			System.out.println(e.getMessage());
			
			return new ArrayList<Solicitudes>();
		}
		
	}
	
	// Funcion para obtener todas las solicitudes de un proyecto que se elija
	@Override
	public List<Solicitudes> obtenerTodosSolicitudesPorProyecto(Connection con, int idProyecto) {
		   
		List<Solicitudes> lista = new ArrayList<Solicitudes>();
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_SOLICITUDES_POR_PROYECTO);
			
			// Con la id del proyecto, preparamos la stored procedure
			cStmt.setInt(1, idProyecto);
			// Y la ejecutamos
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				
				while(rs.next()) {
					
					Solicitudes solicitudes = new Solicitudes();
					
					solicitudes.setId(rs.getInt(SOLICITUD_ID));
					solicitudes.setPersona(rs.getString(SOLICITUD_PERSONA));
					solicitudes.setTexto(rs.getString(SOLICITUD_TEXTO));
					solicitudes.setVeredicto(rs.getInt(SOLICITUD_VEREDICTO));
					solicitudes.setObjetivo(rs.getString(SOLICITUD_OBJETIVO));
					solicitudes.setProyecto(rs.getInt(SOLICITUD_PROYECTO));
					
					lista.add(solicitudes);
					
				}
				
				return lista;
				
			} else {

				System.out.println("No se obtubo una Lista de solicitudes");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return new ArrayList<Solicitudes>();
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todos los solicitudes");
			System.out.println(e.getMessage());
			
			return new ArrayList<Solicitudes>();
		}
		
	}
	
	// Funcion para obtener el rol de un usuario
	@Override
	public String obtenerRol(Connection con, String nombre) {
		   
		String rol = null;
		
		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_ROL);
			
			// Con el nombre del usuario, preparamos la stored procedure
			cStmt.setString(1, nombre);
			// Y la ejecutamos
			boolean tieneSlect = cStmt.execute();
			
			if (tieneSlect == true) {
			
				ResultSet rs = cStmt.getResultSet();
				
			    if (rs.next()) {
			        rol = rs.getString("rol");
			    }
				
				return rol;
				
			} else {

				System.out.println("No se obtubo una Lista de solicitudes");
				System.out.println("El stored procedure no tiene un RESULTSET");
				return rol;
			}
			
		} catch (SQLException e) {

			System.out.println("ERROR DE DB: CONSULTA");
			System.out.println("Error al obtener la lista de todos los solicitudes");
			System.out.println(e.getMessage());
			
			return rol;
		}
		
	}
	
	// Funcion para borrar una solicitud
	@Override
	public void borrarSolicitud(Connection con, int idSolicitud) {
	            
		try {

			CallableStatement cStmt = con.prepareCall(SP_ELIMINAR_SOLICITUD);
							
			cStmt.setInt(1, idSolicitud);
							
			cStmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
						
		}
		            
	}
	
	// Funcion para insertar un Checkk_in
	@Override
	public void insertarCheckk_in(Connection con, int id_usuario, String texto) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_CHECKK_IN);
			
			// Se prepara el stored procedure con la id del usuario y el texto que se quiere insertar
			cStmt.setInt(1, id_usuario);
			cStmt.setString(2, texto);
		
			// Y la ejecutamos
			cStmt.executeUpdate();	
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar el checkk_in");
			
		}
			
		
	}
	
	// Funcion para cambiar el estado
	@Override
	public void cambiarEstado(Connection con, int id_usuario) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_CHECKK_ESTADO);
			
			cStmt.setInt(1, id_usuario);
		
			cStmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar el checkk_in_estado");
			
		}
			
	}
	
	// Funcion para cambiar el veredicto de una solicitud
	@Override
	public void cambiarVeredicto(Connection con, int idProyecto, int veredictoNuevo) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_ACTUALIZAR_VEREDICTO);

			cStmt.setInt(1, idProyecto);
			cStmt.setInt(2, veredictoNuevo);
		
			cStmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar el nuevo veredicto");
			
		}
			
		
	}
	
	// Funcion para cambiar el estado a 0 en una solicitud
	@Override
	public void cambiarEstado0(Connection con, int id_usuario) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_CHECKK_ESTADO_0);
			
			cStmt.setInt(1, id_usuario);
		
			cStmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar el checkk_in_estado_0");
			
		}
			
		
	}
	
	// Funcion para modificar el checkk_out
	@Override
	public void modificarCheckk_out(Connection con, int id_usuario) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_CHECKK_OUT);
			
			cStmt.setInt(1, id_usuario);
		
			cStmt.executeUpdate();	
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo modificar el checkk_out");
			
		}
			
		
	}
	
	// Funcion para hashear la contraseña para despues compararla con la que esta guardada en la base de datos
    public String hashPassword(String password) {
        try {
        	// Seleccionamos el metodo de hasheo para usar la "SHA-256"
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            // Devolvemos la contraseña hasheada como un String
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Funcion para conseguir la contraseña de la base de datos para despues compararlo con la contraseña previamente hasheada
	@Override
	public String conseguirContraseña(Connection con, String usuario) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_OBTENER_CONTRASEÑA);
			
			cStmt.setString(1, usuario);
		
			ResultSet rs = cStmt.executeQuery();
			
		    if (rs.next()) {
		        return rs.getString("contraseña");
		    } else {
		        return null;
		    }
			
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo conseguir la contraseña");
			return null;
		}
			
		
	}
	
	// Funcion para insertar una solicitud
	@Override
	public void insertarSolicitud(Connection con, String usuario, String proyecto, String objetivo, String texto) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_SOLICITUD);
			
			cStmt.setString(1, usuario);
			cStmt.setString(2, texto);
			cStmt.setString(3, objetivo);
			cStmt.setString(4, proyecto);
		
			cStmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar la solicitud");
			System.out.println(e);
		}
			
	}
	
	// Funcion para insertar una solicitud sobre un objetivo
	@Override
	public void insertarSolicitudObjetivo(Connection con, String usuario, String proyecto, String texto, String objetivo) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_SOLICITUD);
			
			cStmt.setString(1, usuario);
			cStmt.setString(2, texto);
			cStmt.setString(3, objetivo);
			cStmt.setString(4, proyecto);
		
			cStmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar la solicitud sobre el objetivo");
			System.out.println(e);
		}
			
	}
	
	// Zona ADMIN
	
	// Funcion para añadir un proyecto nuevo
	@Override
	public void añadirProyecto(Connection con, Proyecto proyectoAñadir) {
		
		try {

			// Preparamos la llamada a la base de datos
			CallableStatement cStmt = con.prepareCall(SP_AÑADIR_PROYECTO);
			
			// Al tener distintos datos necesario para el procedimiento almacenado, los rellenamos con las siguientes lineas de codigo
			cStmt.setString(4, proyectoAñadir.getNombre());
			cStmt.setString(2, proyectoAñadir.getCreador());
			cStmt.setString(3, proyectoAñadir.getImagen());
			cStmt.setString(1, proyectoAñadir.getTexto());
			
			// Ejecutamos la llamada
			cStmt.executeUpdate();	
			
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar el producto");
			
		}
			
	}
	
	// Funcion para añadir un objetivo nuevo
	@Override
	public void añadirObjetivo(Connection con, Objetivos objetivoAñadir) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_AÑADIR_OBJETIVO);
			
			cStmt.setInt(1, objetivoAñadir.getProyecto());
			cStmt.setString(2, objetivoAñadir.getTexto());
			cStmt.setString(3, objetivoAñadir.getPersona());
			cStmt.setInt(4, objetivoAñadir.getPrioridad());
		
			cStmt.executeUpdate();	
			
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar el objetivo");
			
		}
			
	}
	
	// Funcion para modificar un objetivo
	@Override
	public void modificarObjetivo(Connection con, Objetivos objetivoModificar) {
	           
		try {

			CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_OBJETIVO);
							
			cStmt.setInt(1, objetivoModificar.getId());
			cStmt.setInt(2, objetivoModificar.getProyecto());
			cStmt.setString(3, objetivoModificar.getTexto());
			cStmt.setString(4, objetivoModificar.getPersona());
			cStmt.setInt(5, objetivoModificar.getPrioridad());
							
			cStmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
						
		}
		            
	}
	
	// Funcion para modificar los proyectos
	@Override
	public void modificarProyecto(Connection con, Proyecto proyectoModificar) {
	        
		try {

			CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_PROYECTO);
							
			cStmt.setInt(1, proyectoModificar.getId());
			cStmt.setString(2, proyectoModificar.getTexto());
			cStmt.setString(3, proyectoModificar.getCreador());
			cStmt.setString(4, proyectoModificar.getImagen());
			cStmt.setString(5, proyectoModificar.getNombre());
							
			cStmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
						
		}
		            
	}
	
	// Funcion para borrar los proyectos
	@Override
	public void borrarProyecto(Connection con, int id) {
	        
	            
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_PROYECTO);
							
			cStmt.setInt(1, id);
							
			cStmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
						
		}
		            
	}
	
	// Funcion para borrar los objetivos
	@Override
	public void borrarObjetivo(Connection con, int id) {
	            
		try {

			CallableStatement cStmt = con.prepareCall(SP_BORRAR_OBJETIVO);
							
			cStmt.setInt(1, id);
							
			cStmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
						
		}
		            
	}
	 
}

