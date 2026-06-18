package clase;

// Clase Cotizacion - Representa una cotizacion (subclase de OperacionAduanera)
public class Cotizacion extends OperacionAduanera {
	public static final double TIPO_CAMBIO = 3.75; // Modificador final para constante

	private Mercancia mercancia; // Relacion de Composicion, mercancia es parte de Cotizacion
	private double valorUSD;
	private double totalSoles;

	// Constructor 1, completo
	public Cotizacion(String cliente, String mercancia, double valorUSD, double totalSoles) {
		super(cliente);
		this.mercancia = new Mercancia(mercancia, 0);
		this.valorUSD = valorUSD;
		this.totalSoles = totalSoles;
	}

	// Constructor 2, con peso
	public Cotizacion(String cliente, String mercancia, double valorUSD, double totalSoles, double peso) {
		super(cliente);
		this.mercancia = new Mercancia(mercancia, peso);
		this.valorUSD = valorUSD;
		this.totalSoles = totalSoles;
	}

	// Constructor 3, calcula total automaticamente
	public Cotizacion(String cliente, String mercancia, double valorUSD, boolean desaduanaje, double peso) {
		super(cliente);
		this.mercancia = new Mercancia(mercancia, peso);
		this.valorUSD = valorUSD;
		this.totalSoles = calcularTotal(valorUSD, desaduanaje);
	}

	public String getMercancia() {
		return mercancia.getDescripcion();
	}

	public void setMercancia(String mercancia) {
		this.mercancia.setDescripcion(mercancia);
	}

	public double getValorUSD() {
		return valorUSD;
	}

	public void setValorUSD(double valorUSD) {
		this.valorUSD = valorUSD;
	}

	public double getTotalSoles() {
		return totalSoles;
	}

	public void setTotalSoles(double totalSoles) {
		this.totalSoles = totalSoles;
	}

	public double getPeso() {
		return mercancia.getPeso();
	}

	public void setPeso(double peso) {
		this.mercancia.setPeso(peso);
	}

	// Sobrecarga 1: sin desaduanaje
	public double calcularTotal(double valorUSD) {
		return valorUSD * TIPO_CAMBIO + 200 + (getPeso() * 10);
	}

	// Sobrecarga 2: con desaduanaje
	public double calcularTotal(double valorUSD, boolean desaduanaje) {
		return (valorUSD * TIPO_CAMBIO) + 200 + (desaduanaje ? 500 : 0) + (getPeso() * 10);
	}

	@Override
	public String obtenerReporte() {
		return "Codigo: " + getCodigo() + " | Cliente: " + getCliente() + " | Mercancia: " + getMercancia()
				+ " | Peso: " + getPeso() + " kg | USD: $" + valorUSD + " | Total: S/" + totalSoles;
	}
}
