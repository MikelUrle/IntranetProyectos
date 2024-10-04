package paquete.modelo.dto;

public class Usuario {

	private int id;
	private String nombre;
	private String rol;
	public Usuario(int id, String nombre, String rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rol = rol;
	}
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.rol = "";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", rol=" + rol + "]";
	}

}
