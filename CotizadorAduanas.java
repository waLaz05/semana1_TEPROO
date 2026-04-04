import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CotizadorAduanas extends JFrame {

    // aca maria pondrá sus campos de cliente
    private JTextField txtCliente;
    private JTextField txtEmpresa;

    // variables de joseph (mercancia y carga)
    private JLabel lblTipoMercancia;
    private JTextField txtTipoMercancia;
    private JLabel lblValorCarga;
    private JTextField txtValorCarga;

    // espacio para que kevin ponga lo de el
    private JTextField txtPesoVolumen;

    // falta lo de yussef
    private JCheckBox chkDesaduanaje;
    private JCheckBox chkTransporte;

    // botones y textos
    private JButton btnCalcular;
    private JTextArea txtResultados;



    public CotizadorAduanas() {
        setTitle("Software de Cotización de Desaduanaje");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(6, 2, 10, 10));

        // parte de maria
        panelCentro.add(new JLabel("Cliente:"));
        txtCliente = new JTextField();
        panelCentro.add(txtCliente);

        // parte de joseph
        lblTipoMercancia = new JLabel("Tipo de mercancía:");
        txtTipoMercancia = new JTextField();
        
        lblValorCarga = new JLabel("Valor de la carga ($):");
        txtValorCarga = new JTextField();

        panelCentro.add(lblTipoMercancia);
        panelCentro.add(txtTipoMercancia);
        panelCentro.add(lblValorCarga);
        panelCentro.add(txtValorCarga);


        // las otras partes de kevin y yussef
        panelCentro.add(new JLabel("Peso/Volumen:"));
        txtPesoVolumen = new JTextField();
        panelCentro.add(txtPesoVolumen);

        panelCentro.add(new JLabel("Servicios:"));
        JPanel panelServicios = new JPanel();
        chkDesaduanaje = new JCheckBox("Desaduanaje");
        chkDesaduanaje.setSelected(true); // Seleccionado por defecto para la prueba
        panelServicios.add(chkDesaduanaje);
        panelCentro.add(panelServicios);

        add(panelCentro, BorderLayout.NORTH);

        // cuadro de resultados
        txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        add(new JScrollPane(txtResultados), BorderLayout.CENTER);

        // el boton
        btnCalcular = new JButton("Calcular Cotización");
        add(btnCalcular, BorderLayout.SOUTH);

        // que pasa al darle click
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        // avance: por ahora solo probamos que la interfaz lea las cajas de todos
        // la matematica final de los costos queda pendiente
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== AVANCE DEL SISTEMA DE COTIZACION ===\n");
        reporte.append("Cliente: ").append(txtCliente.getText()).append("\n");
        reporte.append("Mercancía (Joseph): ").append(txtTipoMercancia.getText()).append("\n");
        reporte.append("Valor USD (Joseph): $").append(txtValorCarga.getText()).append("\n");
        reporte.append("Peso/Volumen (Kevin): ").append(txtPesoVolumen.getText()).append("\n");
        reporte.append("Con Desaduanaje (Yussef): ").append(chkDesaduanaje.isSelected() ? "Si" : "No").append("\n");
        reporte.append("------------------------------------------\n");
        reporte.append("Nota del grupo: Falta programar las sumas finales y el exporte a PDF.");

        txtResultados.setText(reporte.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CotizadorAduanas().setVisible(true);
        });
    }
}
