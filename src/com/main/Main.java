package com.main;

import com.bd.Conector;

public class Main {
	
	public static void main(String[] args) {
		try {
			new Conector().mostrarDatosClientes();
			//new Conector().mostrarDatosPedidos();
			//new Conector().crearTXT();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
