package arrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clase.Cotizacion;
import clase.OperacionAduanera;
import conexion.ConexionMySQL;

// Clase controladora que gestiona la coleccion y persistencia (Estilo Docente)
public class ArrayCotizacion {

	// Listar todas las cotizaciones desde la base de datos
	public ArrayList<OperacionAduanera> ListarCotizaciones() {
		ArrayList<OperacionAduanera> lista = new ArrayList<OperacionAduanera>();
		try {
			Connection cnx = ConexionMySQL.getConexion();
			if (cnx != null) {
				CallableStatement csta = cnx.prepareCall("{call SP_LISTAR_COTIZACIONES()}");
				ResultSet rs = csta.executeQuery();
				while (rs.next()) {
					Cotizacion c = new Cotizacion(
						rs.getString(2),  // Cliente
						rs.getString(3),  // Mercancia
						rs.getDouble(4),  // ValorUSD
						rs.getDouble(6),  // TotalSoles
						rs.getDouble(5)   // Peso
					);
					c.setCodigo(rs.getInt(1)); // Asignar codigo de la BD
					lista.add(c);
				}
				cnx.close();
			}
		} catch (Exception e) {
			System.out.println("Error al listar cotizaciones: " + e.getMessage());
		}
		return lista;
	}

	// Insertar una nueva cotizacion en la base de datos
	public void InsertarCotizacion(Cotizacion c) {
		try {
			Connection cnx = ConexionMySQL.getConexion();
			if (cnx != null) {
				CallableStatement csta = cnx.prepareCall("{call SP_INSERTAR_COTIZACION(?, ?, ?, ?, ?, ?)}");
				csta.setInt(1, c.getCodigo());
				csta.setString(2, c.getCliente());
				csta.setString(3, c.getMercancia());
				csta.setDouble(4, c.getValorUSD());
				csta.setDouble(5, c.getPeso());
				csta.setDouble(6, c.getTotalSoles());
				csta.executeUpdate();
				cnx.close();
			}
		} catch (Exception e) {
			System.out.println("Error al insertar cotizacion: " + e.getMessage());
		}
	}

	// Eliminar una cotizacion de la base de datos
	public void EliminarCotizacion(int codigo) {
		try {
			Connection cnx = ConexionMySQL.getConexion();
			if (cnx != null) {
				CallableStatement csta = cnx.prepareCall("{call SP_ELIMINAR_COTIZACION(?)}");
				csta.setInt(1, codigo);
				csta.executeUpdate();
				cnx.close();
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar cotizacion: " + e.getMessage());
		}
	}

	// Editar/modificar una cotizacion en la base de datos
	public void EditarCotizacion(Cotizacion c) {
		try {
			Connection cnx = ConexionMySQL.getConexion();
			if (cnx != null) {
				CallableStatement csta = cnx.prepareCall("{call SP_EDITAR_COTIZACION(?, ?, ?, ?, ?, ?)}");
				csta.setInt(1, c.getCodigo());
				csta.setString(2, c.getCliente());
				csta.setString(3, c.getMercancia());
				csta.setDouble(4, c.getValorUSD());
				csta.setDouble(5, c.getPeso());
				csta.setDouble(6, c.getTotalSoles());
				csta.executeUpdate();
				cnx.close();
			}
		} catch (Exception e) {
			System.out.println("Error al editar cotizacion: " + e.getMessage());
		}
	}
}
