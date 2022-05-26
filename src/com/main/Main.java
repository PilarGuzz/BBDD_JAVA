package com.main;

import java.util.Scanner;

import com.bd.Conector;

public class Main {
	public static final String MENU = "------------------MENU------------------"
			+ "1. Mostrar información sobre los clientes."
			+ "2. Mostrar pedidos"
			+ "3. Añadir cliente"
			+ "4. Actualizar un cliente existente"
			+ "5. eliminar cliente"
			+ "6. Añadir pedido"
			+ "7. Incluir lineas"
			+ "8. Salir";
	
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
					
					new Conector().anadirLineaPedido();
				}else {
					System.out.println("Error, inténtelo de nuevo");
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
