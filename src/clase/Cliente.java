package clase;

// Clase Cliente - Representa la relacion de Agregacion
public class Cliente {
	private String nombre;
	private String documento;

	public Cliente(String nombre) {
		this.nombre = nombre;
		this.documento = "Por definir";
	}

	public Cliente(String nombre, String documento) {
		this.nombre = nombre;
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
}
