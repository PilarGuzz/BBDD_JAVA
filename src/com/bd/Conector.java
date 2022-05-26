package com.bd;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		ResultSet resultSet = st.executeQuery("select p.codigo , p.status ,  CONCAT(c.nombre,c.apellido ),"
				+ "COUNT(l.id),  SUM(l.precio)"
				+ "from Linea l , Pedido p , Cliente "
				+ "WHERE c.id = p.idCliente"
				+ "AND p.id = l.idPedido "
				+ "GROUP BY p.codigo , p.status , CONCAT(c.nombre, c.apellido )"
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
	
	public void crearTXT() throws SQLException, IOException {
		

		Connection connection = 
				DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tienda", "root", "rootpass");
		
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select * from Cliente");
		
		
		
		File fichero = new File("./files/fichero.txt");
		if (!fichero.exists()) {
			fichero.createNewFile();
			
		}
		PrintWriter p1 = new PrintWriter(fichero);
		
		while(resultSet.next()) {
			System.out.println("Nombre , Apellidos, email, edad, Género");
			System.out.println(resultSet.getString(2) + ", "
							+ resultSet.getString(3)
							+ ", " + resultSet.getString(4)
							+ ", " + resultSet.getString(5)
							+ ", " + resultSet.getString(6));
		}
		p1.close();

	
	}
	
	public void anadirCliente() throws SQLException {
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/tienda", "root", "rootpass");
		
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("insert into Cliente "
		
	}

}
