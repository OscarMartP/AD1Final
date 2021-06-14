package AD1.AD1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Funciones {
	static Scanner kb = new Scanner(System.in);

	/**
	 * Funcion que enseña un menu por pantalla
	 * 
	 */
	public static void menu() {
		System.out.println("\t************* ESCOJA LA OPCION QUE DESEA REALIZAR *************");
		System.out.println("1.- Añade un cliente");
		System.out.println("2.- Mostrar un cliente");
		System.out.println("3.- Mostrar todos los clientes");
		System.out.println("4.- Buscar cliente");
		System.out.println("5.- Editar producto");
		System.out.println("6.- EXIT");
		System.out.print("Opcion: ");
	}

	/**
	 * Esta funcion sirve para añadir un cliente a la base de datos
	 * 
	 * @param c
	 */
	public static void añadirUnCliente(Connection c) {

		PreparedStatement st = null;

		System.out.println();
		System.out.println("\t************* CREAR CLIENTE *************");
		System.out.println("Introduzca el codigo del cliente, por favor");
		int codigoCliente = kb.nextInt();
		System.out.println("Introduzca el nombre del cliente, por favor");
		String nombreCliente = kb.nextLine();
		System.out.println("Introduzca el nombre de contacto, por favor");
		String nombreContacto = kb.nextLine();
		System.out.println("Introduzca el apellido del contacto, por favor");
		String apellidoContacto = kb.nextLine();
		System.out.println("Introduzca el telefono, porfavor");
		String telefono = kb.nextLine();
		System.out.println("Introduzca el fax, por favor");
		String fax = kb.nextLine();
		System.out.println("Introduzca la direccion principal , por favor");
		String direccion1 = kb.nextLine();
		System.out.println("Introduzca la direccion secundario, porfavor ");
		String direccion2 = kb.nextLine();
		System.out.println("Introduzca la ciudad, por favor");
		String ciudad = kb.nextLine();
		System.out.println("Introduzca el pais, por favor");
		String pais = kb.nextLine();
		System.out.println("Introduzca la region, por favor");
		String region = kb.nextLine();
		System.out.println("Intrduce el codigo postal , por favor");
		int codPostal = kb.nextInt();
		System.out.println("Introduzca el codigo del empleado, por favor");
		int codEmple = kb.nextInt();
		System.out.println("Introduzca un limite de credito, por favor");
		int limite = kb.nextInt();

		try {
			String sql = "INSERT INTO jardineria.cliente (codigo_cliente,nombre_cliente,nombre_contacto,apellido_contacto,telefono,"
					+ "fax,linea_direccion1,linea_direccion2,ciudad,pais,region,codigo_postal,codigo_empleado_rep_ventas,limite_credito) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			st = c.prepareStatement(sql);

			st.setInt(1, codigoCliente);
			st.setString(2, nombreCliente);
			st.setString(3, nombreContacto);
			st.setString(4, apellidoContacto);
			st.setString(5, telefono);
			st.setString(6, fax);
			st.setString(7, direccion1);
			st.setString(8, direccion2);
			st.setString(9, ciudad);
			st.setString(10, pais);
			st.setString(11, region);
			st.setInt(12, codPostal);
			st.setInt(13, codEmple);
			st.setInt(14, limite);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Esta funcion sirve para mostrar el cliente de la base de datos que el usuario
	 * desee por pantalla
	 * 
	 * @param c
	 */
	public static void mostrarUnCliente(Connection c) {

		Statement st = null;
		ResultSet rs = null;
		try {
			System.out.println();
			System.out.println("\t************* MOSTRAR CLIENTE POR ID *************");
			System.out.println();
			System.out.print("Introduzca el id del cliente que quiere que se muestre por pantalla: ");
			int id = kb.nextInt();
			String sql = "SELECT * FROM jardineria.cliente WHERE codigo_cliente = " + id + ";";
			st = c.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println();
				System.out.println("Cliente = [ " + rs.getString(1) + "  |  " + rs.getString(2) + "  |  "
						+ rs.getString(3) + "  |  " + rs.getString(4) + "  |  " + rs.getString(5) + "  |  "
						+ rs.getString(6) + "  |  " + rs.getString(7) + "  |  " + rs.getString(8) + "  |  "
						+ rs.getString(9) + "  |  " + rs.getString(10) + "  |  " + rs.getString(11) + "  |  "
						+ rs.getString(12) + "  |  " + rs.getString(13) + "  |  " + rs.getString(14) + " ]");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Esta funcion sirve para mostrar todos los clientes de la base de datos por
	 * pantalla
	 * 
	 * @param c
	 */
	public static void mostrarTodosLosCliente(Connection c) {
		System.out.println();
		System.out.println("\t************* MOSTRAR TODOS LOS CLIENTES *************");
		System.out.println();
		String sql = "SELECT * FROM jardineria.cliente ORDER BY nombre_cliente ;";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = c.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Cliente = [ " + rs.getString(1) + "  |  " + rs.getString(2) + "  |  "
						+ rs.getString(3) + "  |  " + rs.getString(4) + "  |  " + rs.getString(5) + "  |  "
						+ rs.getString(6) + "  |  " + rs.getString(7) + "  |  " + rs.getString(8) + "  |  "
						+ rs.getString(9) + "  |  " + rs.getString(10) + "  |  " + rs.getString(11) + "  |  "
						+ rs.getString(12) + "  |  " + rs.getString(13) + "  |  " + rs.getString(14) + " ]");
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Esta funcion sirve para buscar un cliente en la base de datos por su nombre
	 * 
	 * @param c
	 */
	public static void buscarCliente(Connection c) {
		System.out.println();
		System.out.println("\t************* BUSCAR CLIENTE POR NOMBRE *************");
		System.out.println();
		System.out.print("Introduzca el nombre o el apellido del cliente que desea que se muestre por pantalla: ");
		String nombre;
		nombre = kb.nextLine();
		String sql = "SELECT * FROM jardineria.cliente WHERE nombre_cliente = '" + nombre + "' OR nombre_contacto = '"
				+ nombre + "' OR apellido_contacto = '" + nombre + "';";
		Statement st = null;
		ResultSet rs = null;
		try {

			st = c.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println();
				System.out.println("Cliente = [ " + rs.getString(1) + "  |  " + rs.getString(2) + "  |  "
						+ rs.getString(3) + "  |  " + rs.getString(4) + "  |  " + rs.getString(5) + "  |  "
						+ rs.getString(6) + "  |  " + rs.getString(7) + "  |  " + rs.getString(8) + "  |  "
						+ rs.getString(9) + "  |  " + rs.getString(10) + "  |  " + rs.getString(11) + "  |  "
						+ rs.getString(12) + "  |  " + rs.getString(13) + "  |  " + rs.getString(14) + " ]");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editarUnProducto(Connection c) {
		System.out.println();
		System.out.println("\t************* EDITAR UN PRODUCTO *************");
		System.out.println();
	}

}
