package clase;

// Clase Mercancia - Representa la relacion de Composicion
public class Mercancia {
	private String descripcion;
	private double peso;

	public Mercancia(String descripcion, double peso) {
		this.descripcion = descripcion;
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
