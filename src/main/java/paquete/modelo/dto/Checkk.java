package paquete.modelo.dto;

public class Checkk {

	private int id;
	private int estado;
	private int id_usuario;
	private String foto;
	
	public Checkk(int id, int estado, int id_usuario, String foto) {
		super();
		this.id = id;
		this.estado = estado;
		this.id_usuario = id_usuario;
		this.foto = foto;
	}
	
	public Checkk() {
		super();
		this.id = 0;
		this.estado = 0;
		this.id_usuario = 0;
		this.foto = "";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Checkk [id=" + id + ", estado=" + estado + ", id_usuario=" + id_usuario + ", foto=" + foto + "]";
	}

}