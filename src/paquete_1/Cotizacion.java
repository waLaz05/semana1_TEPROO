package paquete_1;

public class Cotizacion {
	// Atributos de la cotizacion
	private String cliente;
	private String mercancia;
	private double valorUSD;
	private double totalSoles;

	// Constructor
	public Cotizacion(String cliente, String mercancia, double valorUSD, double totalSoles) {
		this.cliente = cliente;
		this.mercancia = mercancia;
		this.valorUSD = valorUSD;
		this.totalSoles = totalSoles;
	}

	// Getters alternativos que suele pedir el profesor
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getMercancia() {
		return mercancia;
	}

	public void setMercancia(String mercancia) {
		this.mercancia = mercancia;
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

	// Metodo para listar el reporte
	public String obtenerReporte() {
		return "Cliente: " + cliente + " | Mercancía: " + mercancia + " | USD: $" + valorUSD + " | Total: S/" + totalSoles;
	}
}
