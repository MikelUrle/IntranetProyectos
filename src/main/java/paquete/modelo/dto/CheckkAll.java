package paquete.modelo.dto;

public class CheckkAll {

	private int id;
	private int usuario;
	private String hora_entrada;
	private String hora_salida;
	private String fecha;
	private String texto;
	
	public CheckkAll(int id, int usuario, String hora_entrada, String hora_salida, String fecha, String texto) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.fecha = fecha;
		this.texto = texto;
	}

	public CheckkAll() {
		super();
		this.id = 0;
		this.usuario = 0;
		this.hora_entrada = "";
		this.hora_salida = "";
		this.fecha = "";
		this.texto = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "CheckkAll [id=" + id + ", usuario=" + usuario + ", hora_entrada=" + hora_entrada + ", hora_salida="
				+ hora_salida + ", fecha=" + fecha + ", texto=" + texto + "]";
	}
	
}
