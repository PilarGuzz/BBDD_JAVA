package com.main;

import java.util.Scanner;

import com.bd.Conector;

public class Main {
	public static final String MENU = "------------------MENU------------------ \n"
			+ "1. Mostrar información sobre los clientes. \n"
			+ "2. Mostrar pedidos\n"
			+ "3. Añadir cliente\n"
			+ "4. Actualizar un cliente existente\n"
			+ "5. eliminar cliente\n"
			+ "6. Añadir pedido\n"
			+ "7. Incluir lineas\n"
			+ "8. Salir\n";
	
	public static void main(String[] args) {
		
		System.out.println(MENU);
		Scanner sc = new Scanner(System.in);
		int opcion = Integer.valueOf(sc.nextLine());
		
		while(opcion != 8) {
			
			try {
				
				if (opcion == 1) {
					
					new Conector().mostrarDatosClientes();
				}else if(opcion == 2){
					
					new Conector().mostrarDatosPedidos();
				}else if(opcion == 3){
					
					new Conector().anadirCliente();
				}else if(opcion == 4){
					
					new Conector().modificarCliente();
				}else if(opcion == 5){
					
					new Conector().eliminarCliente();
				}else if(opcion == 6){
				
					new Conector().anadirPedido();
				}else if(opcion == 7){
					
					new Conector().annadirLinea();
				}else {
					System.out.println("Error, inténtelo de nuevo");
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
