package paquete.modelos;

public interface Rutas_conexion {

	// Constantes de DB
	
	String BASE_DATOS = "intranet";
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/"+BASE_DATOS;
	String USUARIO = "root";
	String PASS = "1234";
	
	// Archivos JSP
	
	String JSP_PROYECTOS_USUARIO="proyectos_usuario.jsp";
	String JSP_PROYECTOS_FILTRADO="proyectos_usuario_filtrado.jsp";
	String JSP_CHECK_IN="check_in.jsp";
	String JSP_LOGIN = "login.jsp";
	String JSP_SOLICITUDES = "solicitudes.jsp";
	String JSP_SOLICITUDES_OBJETIVO = "solicitudesObjetivo.jsp";
	
	String JSP_ADMIN_PROYECTOS = "admin_proyectos_usuario.jsp";
	String JSP_ADMIN_PROYECTOS_FILTRADO ="admin_proyectos_usuario_filtrado.jsp";
	String JSP_ADMIN_EDITAR_PROYECTOS = "EditarProyectos.jsp";
	String JSP_EDITAR_OBJETIVOS = "EditarObjetivos.jsp";
	String JSP_EDITAR_OBJETIVO_UNICO = "EditarObjetivoUnico.jsp";
	String JSP_EDITAR_PROYECTO_UNICO = "EditarProyectoUnico.jsp";
	String JSP_ADMIN_CHECKK_IN = "adminCheck_In.jsp";
	String JSP_ADMIN_CHECKK_IN_FILTRADO = "adminCheck_In_Filtrado.jsp";
	String JSP_ADMIN_SOLICITUDES = "admin_Solicitudes.jsp";
	
	// Tablas de la DB
	
	String PRODUCTOS_ID = "id";
	
	String PROYECTO_ID = "id";
	String PROYECTO_TEXTO = "texto";
	String PROYECTO_CREADOR = "creador";
	String PROYECTO_IMAGEN = "imagen";
	String PROYECTO_NOMBRE = "nombre";
	
	String OBJETIVOS_ID = "id";
	String OBJETIVOS_PROYECTO = "proyecto";
	String OBJETIVOS_TEXTO = "texto";
	String OBJETIVOS_PERSONA = "persona";
	String OBJETIVOS_PRIORIDAD = "prioridad";
	
	String PERSONA_ID = "id";
	String PERSONA_NOMBRE = "nombre";
	
	String CHECKK_ID = "id";
	String CHECKK_ESTADO = "estado";
	String CHECKK_ID_USUARIO = "id_usuario";
	String CHECKK_FOTO = "foto";
	
	String CHECKK_GUARD_ID = "id";
	String CHECKK_GUARD_USUARIO = "usuario";
	String CHECKK_GUARD_HORA_ENTRADA = "hora-entrada";
	String CHECKK_GUARD_HORA_SALIDA = "hora-salida";
	String CHECKK_GUARD_FECHA = "fecha";
	String CHECKK_GUARD_TEXTO = "texto";
	
	String CHECKKALL_ID = "id";
	String CHECKKALL_USUARIO = "usuario";
	String CHECKKALL_HORA_ENTRADA = "hora_entrada";
	String CHECKKALL_HORA_SALIDA = "hora_salida";
	String CHECKKALL_FECHA = "fecha";
	String CHECKKALL_TEXTO = "texto";
	
	String USUARIO_ID = "id";
	String USUARIO_NOMBRE = "nombre";
	String USUARIO_ROL = "rol";
	
	String SOLICITUD_ID = "id";
	String SOLICITUD_PERSONA = "persona";
	String SOLICITUD_TEXTO = "texto";
	String SOLICITUD_VEREDICTO = "veredicto";
	String SOLICITUD_OBJETIVO = "objetivo";
	String SOLICITUD_PROYECTO= "proyecto";
	
	
	// Stored Procedures
	
	String SP_OBTENER_PROYECTOS = "call intranet.obtener_proyectos();";
	String SP_OBTENER_OBJETIVOS = "call intranet.obtener_objetivos();";
	String SP_OBTENER_PERSONAS = "call intranet.obtener_personas();";
	String SP_OBTENER_CHECKK = "call intranet.obtener_checkk();";
	String SP_OBTENER_CHECKKALL ="call intranet.obtener_checkk_in_guardado();";
	String SP_OBTENER_USUARIOS = "call intranet.obtener_usuarios();";
	String SP_CHECKK_IN = "call intranet.check_in_total(?, ?);";
	String SP_CHECKK_ESTADO = "call intranet.cambiar_estado(?);";
	String SP_CHECKK_ESTADO_0 = "call intranet.cambiar_estado_0(?);";
	String SP_CHECKK_OUT = "call intranet.check_out_total(?);";
	String SP_OBTENER_CONTRASEÑA = "call intranet.conseguir_contraseña(?);";
	String SP_INSERTAR_SOLICITUD = "call intranet.InsertarSolicitud(?, ?, ?, ?);";
	String SP_OBTENER_ROL ="call intranet.obtener_rol_por_nombre(?);";
	
	// Zona Admin (Stored Procedures)
	
	String SP_AÑADIR_PROYECTO = "call intranet.AñadirProyecto(?, ?, ?, ?);";
	String SP_AÑADIR_OBJETIVO = "call intranet.AñadirObjetivo(?, ?, ?, ?);";
	String SP_MODIFICAR_OBJETIVO = "call intranet.modificar_objetivo(?, ?, ?, ?, ?);";
	String SP_MODIFICAR_PROYECTO = "call intranet.modificar_proyecto(?, ?, ?, ?, ?);";
	String SP_BORRAR_OBJETIVO = "call intranet.BorrarObjetivo(?);";
	String SP_BORRAR_PROYECTO = "call intranet.BorrarProyecto(?);";
	String SP_FILTRAR_CHECKKALL = "call intranet.obtener_checkk_in_guardado_filtrado(?);";
	String SP_OBTENER_SOLICITUDES = "call intranet.obtener_solicitudes();";
	String SP_OBTENER_SOLICITUDES_POR_PROYECTO = "call intranet.obtener_solicitudes_por_proyecto(?);";
	String SP_ACTUALIZAR_VEREDICTO = "call intranet.actualizarVeredicto(?, ?);";
	String SP_ELIMINAR_SOLICITUD = "call intranet.eliminar_Solicitud(?);";
	
	// Atributos de la mochila
	
	String ATR_LISTA_PROYECTOS = "atr_lista_proyectos";
	String ATR_LISTA_OBJETIVOS = "atr_lista_objetivos";
	String ATR_LISTA_PERSONAS = "atr_lista_personas";
	String ATR_LISTA_CHECKK = "atr_lista_checkk";
	String ATR_LISTA_CHECKKALL = "atr_lista_checkkall";
	String ATR_LISTA_USUARIOS = "atr_lista_usuarios";
	String ATR_LISTA_CHECKKALL_FILTRADO = "atr_lista_checkkall_filtrado";
	String ATR_LISTA_SOLICITUDES = "atr_lista_solicitudes";
	
	String ATR_VAR_DATO = "atr_var_dato";
	String ATR_VAR_DATO1 = "atr_var_dato1";
	String ATR_VAR_DATO2 = "atr_var_dato2";
	String ATR_VAR_DATO_ID_PROYECTO = "atr_var_dato_id_proyecto";
	String ATR_VAR_DATO_ID_OBJETIVO = "atr_var_dato_id_objetivo";

	
}
