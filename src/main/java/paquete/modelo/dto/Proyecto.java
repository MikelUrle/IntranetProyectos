package paquete.modelo.dto;

public class Proyecto {

	private int id;
	private String texto;
	private String creador;
	private String imagen;
	private String nombre;
	
	public Proyecto(int id, String texto, String creador, String imagen, String nombre) {
		super();
		this.id = id;
		this.texto = texto;
		this.creador = creador;
		this.imagen = imagen;
		this.nombre = nombre;
	}
	
	public Proyecto() {
		super();
		this.id = 0;
		this.texto = "";
		this.creador = "";
		this.imagen = "";
		this.nombre = "";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", texto=" + texto + ", creador=" + creador + ", imagen=" + imagen + ", nombre="
				+ nombre + "]";
	}
	
}