package paquete.modelo.dto;

public class Objetivos {

	private int id;
	private int proyecto;
	private String texto;
	private String persona;
	private int prioridad;
	
	public Objetivos(int id, int proyecto, String texto, String persona, int prioridad) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.texto = texto;
		this.persona = persona;
		this.prioridad = prioridad;
	}
	
	public Objetivos() {
		super();
		this.id = 0;
		this.proyecto = 0;
		this.texto = "";
		this.persona = "";
		this.prioridad = 0;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProyecto() {
		return proyecto;
	}

	public void setProyecto(int proyecto) {
		this.proyecto = proyecto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "Objetivos [id=" + id + ", proyecto=" + proyecto + ", texto=" + texto + ", persona=" + persona
				+ ", prioridad=" + prioridad + "]";
	}

}