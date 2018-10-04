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
import com.sun.xml.internal.bind.v2.model.core.ID;

import jdk.nashorn.internal.ir.CatchNode;
import uniandes.isis2304.superandes.interfazApp.InterfazParranderosApp;
import uniandes.isis2304.superandes.negocio.Proveedor;
import uniandes.isis2304.superandes.negocio.SuperAndes;
import uniandes.isis2304.superandes.negocio.VOBodega;
import uniandes.isis2304.superandes.negocio.VOEstante;
import uniandes.isis2304.superandes.negocio.VOProveedor;
import uniandes.isis2304.superandes.negocio.VOSucursal;


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
//				List<Proveedor> prov = superAndes.darProveedores();
//				for (Proveedor proveedor2 : prov) {
//					System.out.println(proveedor2.toString());
//				}
//				break;
				
			
			case 3:	
				
			case 4:	
				
				System.out.println("Ingrese el nombre de la sucursal");
				String nombreSucursal = sc.next();
				System.out.println("Ingrese la direccion de la sucursal");
				sc.nextLine();
				String direccionSucursal = sc.nextLine();
				System.out.println("Ingrese la ciudad de la sucursal");
				String ciudad = sc.next();
				VOSucursal sucursal = superAndes.adicionarSucursal(nombreSucursal, direccionSucursal, ciudad);
				System.out.println(sucursal.toString());
				break;
				
			case 5:	
				
				System.out.println("Ingrese la cantidad maxima");
				String cantidadMaxima = sc.next();
				int cantidad = 0;
				System.out.println("Ingrese el peso maximo");
				String pesoMaxima = sc.next();
				double peso = 0;
				System.out.println("Ingrese el volumen maximo");
				String volumenMaxima = sc.next();
				double volumen = 0;
				System.out.println("Ingrese id de la Sucursal");
				String idSucursal = sc.next();
				long suc = 0;
				System.out.println("Ingrese id del tipo del producto que se va a almacenar");
				String idTipo = sc.next();
				long tipo = 0;
				System.out.println("Ingrese id  del volumenProducto");
				String idvol = sc.next();
				long idvolP = 0;
				System.out.println("Ingrese la direccion de la bodega");
				sc.nextLine();
				String direccion = sc.nextLine();
				
				try
				{
					cantidad = Integer.parseInt(cantidadMaxima);
					peso = Double.parseDouble(pesoMaxima);
					volumen = Double.parseDouble(volumenMaxima);
					suc = Long.parseLong(idSucursal);
					tipo= Long.parseLong(idTipo);
					idvolP = Long.parseLong(idvol);
				}
				catch(Exception e)
				{
					System.out.println("Errores en elos datos ingresados");
					break;
				}
				
				VOBodega bodega = superAndes.adicionarBodega(cantidad, peso, volumen, suc, tipo, idvolP, direccion);
				System.out.println(bodega.toString());
				

			case 6:	
				
				System.out.println("Ingrese la cantidad maxima");
				String cantidadMaximaE = sc.next();
				int cantidadE = 0;
				System.out.println("Ingrese el peso maximo");
				String pesoMaximaE = sc.next();
				double pesoE = 0;
				System.out.println("Ingrese el volumen maximo");
				String volumenMaximaE = sc.next();
				double volumenE = 0;
				System.out.println("Ingrese id de la Sucursal");
				String idSucursalE = sc.next();
				long sucE = 0;
				System.out.println("Ingrese id del tipo del producto que se va a almacenar");
				String idTipoE = sc.next();
				long tipoE = 0;
				System.out.println("Ingrese id  del volumenProducto");
				String idvolE = sc.next();
				long idvolPE = 0;
				System.out.println("Ingrese el ivel de abastecimiento");
				String abastecimiento = sc.next();
				int abastecimientoE = 0;
				
				try
				{
					cantidadE = Integer.parseInt(cantidadMaximaE);
					pesoE = Double.parseDouble(pesoMaximaE);
					volumenE = Double.parseDouble(volumenMaximaE);
					sucE = Long.parseLong(idSucursalE);
					tipoE= Long.parseLong(idTipoE);
					idvolPE = Long.parseLong(idvolE);
					abastecimientoE = Integer.parseInt(abastecimiento);
				}
				catch(Exception e)
				{
					System.out.println("Errores en los datos ingresados");
					break;
				}
				
				VOEstante estante = superAndes.adicionarEstante(cantidadE, pesoE, volumenE, sucE, tipoE, idvolPE, abastecimientoE);
				System.out.println(estante.toString());
				
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
