package paquete.modelo.dto;

public class Solicitudes {

	private int id;
	private String persona;
	private String texto;
	private int veredicto;
	private String objetivo;
	private int proyecto;
	
	public Solicitudes(int id, String persona, String texto, int veredicto, String objetivo, int proyecto) {
		super();
		this.id = id;
		this.persona = persona;
		this.texto = texto;
		this.veredicto = veredicto;
		this.objetivo = objetivo;
		this.proyecto = proyecto;
	}

	public Solicitudes() {
		super();
		this.id = 0;
		this.persona = "";
		this.texto = "";
		this.veredicto = 0;
		this.objetivo = "";
		this.proyecto = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getVeredicto() {
		return veredicto;
	}

	public void setVeredicto(int veredicto) {
		this.veredicto = veredicto;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public int getProyecto() {
		return proyecto;
	}

	public void setProyecto(int proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public String toString() {
		return "Solicitudes [id=" + id + ", persona=" + persona + ", texto=" + texto + ", veredicto=" + veredicto
				+ ", objetivo=" + objetivo + ", proyecto=" + proyecto + "]";
	}

}
