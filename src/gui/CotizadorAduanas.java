package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clase.Cotizacion;
import clase.OperacionAduanera;
import arrayList.ArrayCotizacion;

public class CotizadorAduanas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCliente;
	private JLabel lblMercancia;
	private JLabel lblValor;
	private JLabel lblPeso;
	private JLabel lblBuscar;
	
	private JTextField txtCliente;
	private JTextField txtTipoMercancia;
	private JTextField txtValorCarga;
	private JTextField txtPesoVolumen;
	private JTextField txtBuscarCliente;
	
	private JCheckBox chkDesaduanaje;
	
	private JButton btnAdicionar;
	private JButton btnBuscar;
	private JButton btnReportar;
	
	private JTextArea txtS;
	
	// Referencias a controladores y lista
	private ArrayCotizacion arrayCotizaciones;
	private ArrayList<OperacionAduanera> listaCotizaciones;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CotizadorAduanas frame = new CotizadorAduanas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CotizadorAduanas() {
		// Inicializando controlador y cargando datos de BD
		arrayCotizaciones = new ArrayCotizacion();
		listaCotizaciones = arrayCotizaciones.ListarCotizaciones();
		
		// Sincronizar el contador secuencial con el codigo maximo de la BD
		int maxCodigo = 0;
		for (OperacionAduanera op : listaCotizaciones) {
			if (op.getCodigo() > maxCodigo) {
				maxCodigo = op.getCodigo();
			}
		}
		OperacionAduanera.setContador(maxCodigo);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCliente = new JLabel("Cliente (Nombre):");
		lblCliente.setBounds(30, 20, 120, 14);
		contentPane.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(180, 17, 120, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		lblMercancia = new JLabel("Tipo de mercancía:");
		lblMercancia.setBounds(30, 50, 120, 14);
		contentPane.add(lblMercancia);
		
		txtTipoMercancia = new JTextField();
		txtTipoMercancia.setBounds(180, 47, 120, 20);
		txtTipoMercancia.setColumns(10);
		contentPane.add(txtTipoMercancia);
		
		lblValor = new JLabel("Valor de la carga ($):");
		lblValor.setBounds(30, 80, 140, 14);
		contentPane.add(lblValor);
		
		txtValorCarga = new JTextField();
		txtValorCarga.setBounds(180, 77, 120, 20);
		txtValorCarga.setColumns(10);
		contentPane.add(txtValorCarga);
		
		lblPeso = new JLabel("Peso/Volumen:");
		lblPeso.setBounds(30, 110, 120, 14);
		contentPane.add(lblPeso);
		
		txtPesoVolumen = new JTextField();
		txtPesoVolumen.setBounds(180, 107, 120, 20);
		txtPesoVolumen.setColumns(10);
		contentPane.add(txtPesoVolumen);
		
		chkDesaduanaje = new JCheckBox("Importación c/ Desaduanaje");
		chkDesaduanaje.setBounds(30, 140, 250, 23);
		contentPane.add(chkDesaduanaje);
		
		lblBuscar = new JLabel("Buscar por nombre:");
		lblBuscar.setBounds(30, 180, 140, 14);
		contentPane.add(lblBuscar);
		
		txtBuscarCliente = new JTextField();
		txtBuscarCliente.setBounds(180, 177, 120, 20);
		txtBuscarCliente.setColumns(10);
		contentPane.add(txtBuscarCliente);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(330, 16, 120, 23);
		btnAdicionar.addActionListener(this);
		contentPane.add(btnAdicionar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(330, 176, 120, 23);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
		
		btnReportar = new JButton("Reportar Todos");
		btnReportar.setBounds(47, 237, 380, 23);
		btnReportar.addActionListener(this);
		contentPane.add(btnReportar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 260, 420, 270);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(211, 208, 120, 22);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(58, 208, 120, 22);
		contentPane.add(btnEliminar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnAdicionar) {
			do_btnAdicionar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);
		}
	}
	
	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		try {
			String cliente = txtCliente.getText().trim();
			String mercancia = txtTipoMercancia.getText().trim();

			if (cliente.isEmpty() || mercancia.isEmpty()) {
				Mensaje("Complete todos los campos");
				return;
			}

			double valorUSD = Double.parseDouble(txtValorCarga.getText().trim());
			if (valorUSD <= 0) {
				Mensaje("Ingrese un valor mayor a 0");
				return;
			}

			double peso = Double.parseDouble(txtPesoVolumen.getText().trim());
			if (peso <= 0) {
				Mensaje("El peso/volumen debe ser mayor a 0");
				return;
			}

			// Instanciacion de Cotizacion (Agregacion y Composicion internas)
			Cotizacion c = new Cotizacion(cliente, mercancia, valorUSD, chkDesaduanaje.isSelected(), peso);
			
			// Guardar en memoria y en la base de datos
			listaCotizaciones.add(c);
			arrayCotizaciones.InsertarCotizacion(c);

			txtS.setText(">>> Cotizacion guardada exitosamente!\n");
			txtS.append(c.obtenerReporte());

		} catch (NumberFormatException ex) {
			Mensaje("Ingrese solo numeros validos");
		}
	}
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		txtS.setText("--- BUSQUEDA DE CLIENTE ---\n");
		String abuscar = txtBuscarCliente.getText().toLowerCase().trim();
		boolean encontrado = false;
		
		for (int i = 0; i < listaCotizaciones.size(); i++) {
			OperacionAduanera c = listaCotizaciones.get(i);
			if (c.getCliente().toLowerCase().contains(abuscar)) {
				// Llamada polimorfica a obtenerReporte()
				txtS.append(c.obtenerReporte() + "\n");
				encontrado = true;
			}
		}
		
		if (!encontrado) {
			txtS.append("No se encontro ningun registro.");
		}
	}
	
	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		txtS.setText("=== REPORTE TOTAL ===\n");
		
		if (listaCotizaciones.isEmpty()) {
			txtS.append("Memoria vacía.");
			return;
		}
		
		for (int i = 0; i < listaCotizaciones.size(); i++) {
			OperacionAduanera c = listaCotizaciones.get(i);
			// Uso de polimorfismo
			txtS.append("[" + (i+1) + "] " + c.obtenerReporte() + "\n");
		}
	}

	OperacionAduanera Buscar(String cliente) {
		if (cliente == null || cliente.trim().isEmpty()) {
			return null;
		}
		for (int i = 0; i < listaCotizaciones.size(); i++) {
			OperacionAduanera c = listaCotizaciones.get(i);
			if (c.getCliente().toLowerCase().contains(cliente.toLowerCase().trim())) {
				return c;
			}
		}
		return null;
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		String nombre = txtBuscarCliente.getText().trim();
		if (nombre.isEmpty()) {
			Mensaje("Ingrese un nombre para buscar y eliminar");
			return;
		}

		OperacionAduanera c = Buscar(nombre);
		if (c != null) {
			// Remover de la memoria y eliminar de la base de datos
			listaCotizaciones.remove(c);
			arrayCotizaciones.EliminarCotizacion(c.getCodigo());
			txtS.setText(">>> Cotización eliminada correctamente");
		} else {
			Mensaje("Cliente no encontrado");
		}
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			String nombre = txtBuscarCliente.getText().trim();
			if (nombre.isEmpty()) {
				Mensaje("Ingrese un nombre para buscar");
				return;
			}

			OperacionAduanera op = Buscar(nombre);

			// Downcasting de OperacionAduanera a Cotizacion
			if (op instanceof Cotizacion) {
				Cotizacion c = (Cotizacion) op;
				String cliente = txtCliente.getText().trim();
				String mercancia = txtTipoMercancia.getText().trim();
				String valorStr = txtValorCarga.getText().trim();
				String pesoStr = txtPesoVolumen.getText().trim();

				if (cliente.isEmpty() || mercancia.isEmpty() || valorStr.isEmpty() || pesoStr.isEmpty()) {
					Mensaje("Complete todos los campos");
					return;
				}

				double valorUSD = Double.parseDouble(valorStr);
				double peso = Double.parseDouble(pesoStr);

				if (valorUSD <= 0 || peso <= 0) {
					Mensaje("El valor y el peso deben ser mayores a 0");
					return;
				}

				c.setCliente(cliente);
				c.setMercancia(mercancia);
				c.setValorUSD(valorUSD);
				c.setPeso(peso);

				double totalSoles;
				if (chkDesaduanaje.isSelected()) {
					totalSoles = c.calcularTotal(valorUSD, true);
				} else {
					totalSoles = c.calcularTotal(valorUSD);
				}
				c.setTotalSoles(totalSoles);

				// Actualizar base de datos
				arrayCotizaciones.EditarCotizacion(c);

				txtS.setText(">>> Cotizacion modificada correctamente\n");
				txtS.append(c.obtenerReporte());
			} else {
				Mensaje("Cliente no encontrado");
			}
		} catch (NumberFormatException ex) {
			Mensaje("Ingrese solo numeros validos");
		}
	}

	void Mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
}
