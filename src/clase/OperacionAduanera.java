package clase;

// Clase abstracta que representa una operacion aduanera general
public abstract class OperacionAduanera implements Reportable {
	private Cliente cliente; // Relacion de Agregacion (Cliente es un objeto independiente)
	private static int contador = 0;
	private int codigo;

	public OperacionAduanera() {
		contador++;
		this.codigo = contador;
		this.cliente = new Cliente("");
	}

	public OperacionAduanera(String clienteNombre) {
		contador++;
		this.codigo = contador;
		this.cliente = new Cliente(clienteNombre);
	}

	public OperacionAduanera(Cliente cliente) {
		contador++;
		this.codigo = contador;
		this.cliente = cliente;
	}

	public String getCliente() {
		return cliente.getNombre();
	}

	public void setCliente(String clienteNombre) {
		this.cliente.setNombre(clienteNombre);
	}

	public Cliente getClienteObjeto() {
		return cliente;
	}

	public void setClienteObjeto(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int cont) {
		contador = cont;
	}

	// Metodo abstracto para ser implementado por las subclases
	public abstract String obtenerReporte();
}
