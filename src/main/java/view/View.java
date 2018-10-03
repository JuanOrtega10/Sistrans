package view;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;


import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.superandes.interfazApp.InterfazParranderosApp;
import uniandes.isis2304.superandes.negocio.Proveedor;
import uniandes.isis2304.superandes.negocio.SuperAndes;
import uniandes.isis2304.superandes.negocio.VOProveedor;


public class View 

{
	
	//Clase Principal
	private static SuperAndes superAndes;
	
	private static Logger log = Logger.getLogger(View.class.getName());
	
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A_SuperAndes.json"; 	
	
	private static JsonObject tableConfig;
	
	
	
	public static void inicializar()
	{
		tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
		superAndes = new SuperAndes(tableConfig);
	}
	
	
	
	public static void main(String[] args) 
	{
		inicializar();
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		while(!fin)
		{
			printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 1:
				
				System.out.println("Ingrese el nit del proveedor");
				String nitProveedor = sc.next();
				long nit = 0;
				System.out.println("Ingrese el nombre del proveedor");
				String nombreProveedor = sc.next();
				System.out.println("Ingrese la calificacion del proveedor");
				String calificacionProveedor = sc.next();
				double calificacion= 0;
				System.out.println("Ingrese el numero de calificaciones del proveedor");
				String numCalificacionesProveedor = sc.next();
				int numCalificaciones = 0;
				try {
					nit = Long.parseLong(nitProveedor);
					calificacion = Double.parseDouble(calificacionProveedor);
					numCalificaciones = Integer.parseInt(numCalificacionesProveedor);
				}
				catch (Exception e) {
					System.err.println("nit invalido");
					break;
				}
				
				VOProveedor proveedor = superAndes.adicionarProveedor(nit, nombreProveedor, calificacion, numCalificaciones);
				
				System.out.println(proveedor.toString());
				
				break;

			case 2:
				List<Proveedor> prov = superAndes.darProveedores();
				for (Proveedor proveedor2 : prov) {
					System.out.println(proveedor2.toString());
				}
				break;
				
			
			case 3:	
				
			case 4:	

			case 5:	

			case 6:	

			case 7:	

			case 8:
				
			case 9:
			
			case 10:
			
			case 11:
			
			case 12:
			
			case 13:
			
			case 14:
			
			case 15:
			
			case 16:
			
			case 17:
				
			case 18:
				fin=true;
				sc.close();
				break;
			}
		}
	}

	private static void printMenu() {
		System.out.println("---------ISIS SISTEMAS TRANSACCIONALES----------");
		System.out.println("--------------------- ITERACION 1--------------------");
		System.out.println("1. Registrar proveedores");
		System.out.println("18. Salir");
		System.out.println("Digite el numero de opcion para ejecutar la tarea, luego presione enter: (Ej., 1):");

	}

	private static JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
	
}
