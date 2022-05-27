package com.bd;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Conector {
	
	
	
	public void mostrarDatosClientes() throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tienda", "root", "rootpass");
		
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select * from Cliente");
		System.out.println("Nombre , Apellidos, email, edad, Género");

		while(resultSet.next()) {
			System.out.println(resultSet.getString(2) + ", "
							+ resultSet.getString(3)
							+ ", " + resultSet.getString(4)
							+ ", " + resultSet.getString(5)
							+ ", " + resultSet.getString(6));
		}
		
		
	}
	
	public void mostrarDatosPedidos() throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tienda", "root", "rootpass");
		
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select p.codigo , p.status ,  CONCAT(c.nombre, \" \",c.apellido ),\n"
				+ "COUNT(l.id),  SUM(l.precio)\n"
				+ "from Linea l , Pedido p , Cliente c\n"
				+ "WHERE c.id = p.idCliente \n"
				+ "AND p.id = l.idPedido \n"
				+ "GROUP BY p.codigo , p.status , CONCAT(c.nombre, \" \", c.apellido )\n"
				+ "ORDER BY SUM(l.precio) DESC;");
		System.out.println("Codigo , Status, Nombre Cliente, Num Productos, Importe");

		while(resultSet.next()) {
			System.out.println(resultSet.getString(1) + ", "
							+ resultSet.getString(2)
							+ ", " + resultSet.getString(3)
							+ ", " + resultSet.getString(4)
							+ ", " + resultSet.getString(5));
		}
		
		
	}
	
	
	public void anadirCliente() throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tienda", "root", "rootpass");
		
		Statement st = connection.createStatement();
		st.executeUpdate("INSERT INTO Cliente (nombre, apellido, email, fechaNacimiento, genero) "
				+ "VALUES ('Rigoberto', 'Ricciardiello', 'rr0@yelp.com', '1983-04-15', 'M');\n");
		
		System.out.println("Añadido");
	}
	
	public void modificarCliente() throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tienda", "root", "rootpass");
		
		Statement st = connection.createStatement();
		st.executeUpdate("UPDATE Cliente SET genero = 'H' where nombre = 'Rigoberto'");
		
		System.out.println("modificado");
	}
	
	public void eliminarCliente() throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tienda", "root", "rootpass");
		
		Statement st = connection.createStatement();
		st.executeUpdate("DELETE FROM Cliente where nombre = 'Rigoberto'");
		
		System.out.println("eliminado");
	}
	
	public void anadirPedido() throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tienda", "root", "rootpass");
		
		Statement st = connection.createStatement();
		st.executeUpdate("insert into Pedido (codigo, status, idCliente) "
				+ "values ('8572011999', 'ENVIADO', 185);");
		
		System.out.println("Añadido");
	}
	
	
	public static void annadirLinea() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "rootpass");
		Statement statement=connection.createStatement();
		ResultSet idLinea=statement.executeQuery("SELECT MAX(ID) FROM Pedido p WHERE status='PROCESANDO';");
		idLinea.next();

		PreparedStatement ps = connection.prepareStatement("INSERT INTO Linea (id, codigo, nombreProducto, idPedido, cantidad, precio) "
		+ " VALUES (?, ?, ?, ?, ?, ?)");
		System.out.println("Introduce id:");
		String id=sc.nextLine();
		System.out.println("Introduce codigo:");
		String codigo=sc.nextLine();
		System.out.println("Introduce nombre del producto:");
		String nombre=sc.nextLine();
		System.out.println("Introduce cantidad:");
		String cantidad= sc.nextLine();
		System.out.println("Introduce precio:");
		String precio = sc.nextLine();


		ps.setString(1, id);
		ps.setString(2, codigo);
		ps.setString(3, nombre);
		ps.setString(4, idLinea.getString(1));
		ps.setString(5, cantidad);
		ps.setString(6, precio);
		ps.executeUpdate();
		}

}
