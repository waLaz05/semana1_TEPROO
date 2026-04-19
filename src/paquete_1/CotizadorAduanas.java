package paquete_1;

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
	
	// Mi lista grupal
	private ArrayList<Cotizacion> listaCotizaciones;
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
		// inicializando la lista
		listaCotizaciones = new ArrayList<Cotizacion>();
		
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
		// el semaforo de botones como le gusta al profe
		if (e.getSource() == btnAdicionar) {
			do_btnAdicionar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
		    do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
		    do_btnModificar_actionPerformed(e);
		}
	}
	
	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		try {
			String cliente = txtCliente.getText();
			String mercancia = txtTipoMercancia.getText();
			double valorUSD = Double.parseDouble(txtValorCarga.getText());
			
			// Matematica con TC 3.75
			double totalSoles = (valorUSD * 3.75) + (chkDesaduanaje.isSelected() ? 500.0 : 0.0) + 200.0;
			
			Cotizacion c = new Cotizacion(cliente, mercancia, valorUSD, totalSoles);
			listaCotizaciones.add(c);
			
			txtS.setText(">>> Cotizacion guardada exitosamente!\n");
			txtS.append(c.obtenerReporte());
			
			txtCliente.setText("");
			txtTipoMercancia.setText("");
			txtValorCarga.setText("");
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error, ingresa numeros correctos en el valor en Dolares.");
		}
	}
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		txtS.setText("--- BUSQUEDA DE CLIENTE ---\n");
		String abuscar = txtBuscarCliente.getText().toLowerCase();
		boolean encontrado = false;
		
		for (int i = 0; i < listaCotizaciones.size(); i++) {
			Cotizacion c = listaCotizaciones.get(i);
			if (c.getCliente().toLowerCase().contains(abuscar)) {
				txtS.append(c.obtenerReporte() + "\n");
				encontrado = true;
			}
		}
		
		if (!encontrado) {
			txtS.append("No se econtro ningun registro.");
		}
	}
	
	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		txtS.setText("=== REPORTE TOTAL ===\n");
		
		if (listaCotizaciones.isEmpty()) {
			txtS.append("Memoria vacía.");
			return;
		}
		
		for (int i = 0; i < listaCotizaciones.size(); i++) {
			Cotizacion c = listaCotizaciones.get(i);
			txtS.append("[" + (i+1) + "] " + c.obtenerReporte() + "\n");
		}
	}
	Cotizacion Buscar(String cliente) {
	    for (int i = 0; i < listaCotizaciones.size(); i++) {
	        Cotizacion c = listaCotizaciones.get(i);
	        if (c.getCliente().equalsIgnoreCase(cliente)) {
	            return c;
	        }
	    }
	    return null;
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		Cotizacion c = Buscar(txtBuscarCliente.getText());

	    if (c != null) {
	        listaCotizaciones.remove(c);
	        txtS.setText(">>> Cotización eliminada correctamente");
	    } else {
	        Mensaje("Cliente no encontrado");
	    }
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		Cotizacion c = Buscar(txtBuscarCliente.getText());

	    if (c != null) {
	        c.setCliente(txtCliente.getText());
	        c.setMercancia(txtTipoMercancia.getText());
	        c.setValorUSD(Double.parseDouble(txtValorCarga.getText()));

	        double totalSoles = (c.getValorUSD() * 3.75) +
	                (chkDesaduanaje.isSelected() ? 500.0 : 0.0) + 200.0;

	        c.setTotalSoles(totalSoles);

	        txtS.setText(">>> Cotización modificada correctamente\n");
	        txtS.append(c.obtenerReporte());

	    } else {
	        Mensaje("Cliente no encontrado");
	    }
	}
	void Mensaje(String s) {
	    JOptionPane.showMessageDialog(this, s);
	}
}
// Validado por Maria
// Validado por franchessco/kevin
// Validado por franchessco/kevin
// Validado por franchessco/kevin
// Revisión y lógica anexada para funcionamiento del botón de Eliminar (Joseph)
// Revisión y lógica anexada para funcionamiento del botón de Eliminar (Joseph)
// Lógica del botón de eliminar revisada por Joseph
