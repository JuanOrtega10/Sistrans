package view;

import java.io.FileReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;


import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.sun.xml.internal.bind.v2.model.core.ID;

import jdk.nashorn.internal.ir.CatchNode;
import uniandes.isis2304.superandes.negocio.Proveedor;
import uniandes.isis2304.superandes.negocio.SuperAndes;

import uniandes.isis2304.superandes.negocio.VOClienteNatural;
import uniandes.isis2304.superandes.negocio.VODescuentoSegundoProducto;
import uniandes.isis2304.superandes.negocio.VOBodega;
import uniandes.isis2304.superandes.negocio.VOClienteEmpresa;
import uniandes.isis2304.superandes.negocio.VOEstante;
import uniandes.isis2304.superandes.negocio.VOPagueMLleveNUnidades;
import uniandes.isis2304.superandes.negocio.VOPagueXLleveYCantidad;
import uniandes.isis2304.superandes.negocio.VOProducto;
import uniandes.isis2304.superandes.negocio.VOPromocionMenorALaSuma;
import uniandes.isis2304.superandes.negocio.VOPromocionPorcentaje;
import uniandes.isis2304.superandes.negocio.VOProveedor;
import uniandes.isis2304.superandes.negocio.VOSucursal;
import uniandes.isis2304.superandes.negocio.VolumenProducto;


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
				System.out.println("Ingrese el id del producto, en hexa");
				String idProducto = sc.next();
				if(idProducto.matches("-?[0-9a-fA-F]+"))
				{ }
				else {
					System.out.println("El codigo del producto no es valido");
					break;
				}
				System.out.println("Ingrese el nombre del producto");
				String nombreProd = sc.next(); 
				System.out.println("Ingrese la marca del producto");
				String marcaProd = sc.next();
				System.out.println("Ingrese el precio unitario del producto");
				String precioUnitProd = sc.next();
				double precio = 0;
				System.out.println("Ingrese la presentacion del producto");
				String presentacionProd = sc.next();
				System.out.println("Ingrese la cantidad del producto");
				String cantidadProd = sc.next();
				double cantidadP = 0;
				System.out.println("Ingrese la unidad de medida del producto");
				String unidadMedProd = sc.next();
				System.out.println("Ingrese el precio por unidad de medida del producto");
				String precioUnMProd = sc.next();
				double precioUnM = 0;
				System.out.println("Ingrese la especificacion del empaque del producto");
				String espProd = sc.next();
				double esp = 0;
				System.out.println("El producto es exclusivo? 1 si lo es, de lo contrario 0");
				String exclusivo = sc.next();
				int excl = 0;
				System.out.println("Ingrese el id del tipo del producto");
				String idtipoProd = sc.next();
				long tipoProd = 0;
				System.out.println("Ingrese el id de la categoria del producto");
				String categoria = sc.next();
				long cat = 0;
				System.out.println("Ingrese la Fecha de vencimiento del producto si la tiene");
				String fechap = sc.next();
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				Date datep = new Date();

				try {
					
					datep = simpleDateFormat.parse(fechap);
					precio = Double.parseDouble(precioUnitProd);
					cantidadP = Double.parseDouble(cantidadProd);
					precioUnM = Double.parseDouble(precioUnMProd);
					esp = Double.parseDouble(espProd);
					excl = Integer.parseInt(exclusivo);
					tipoProd = Long.parseLong(idtipoProd);
					cat = Long.parseLong(categoria);
				} catch (Exception e) {
					// TODO: handle exception
				}
				VOProducto producto = superAndes.adicionarProducto(idProducto, nombreProd, marcaProd, precio, presentacionProd, cantidadP, unidadMedProd, precioUnM, esp, excl, tipoProd, cat, new Timestamp(datep.getTime()));
				System.out.println(producto.toString());
				break;

			case 3:	

				System.out.println("¿Es un Cliente Natural o una Empresa?");
				System.out.println("1. Cliente Natural");
				System.out.println("2. Cliente Empresa");
				int option1 = sc.nextInt();

				switch (option1) {
				case 1:

					System.out.println("Ingrese la cédula del cliente");
					String id = sc.next();
					long idC = 0;
					System.out.println("Ingrese el nombre del cliente");
					String nombreCliente = sc.next();
					System.out.println("Ingrese el correo del cliente");
					String correo = sc.next();
					
					try {
						idC = Long.parseLong(id);

					}
					catch (Exception e) {
						System.err.println("Información errónea");
						break;
					}

					VOClienteNatural cliente = superAndes.adicionarClienteNatural(idC, nombreCliente, correo);
					if (cliente!= null) System.out.println(cliente.toString());
					else System.out.println("No fue posible añadir al cliente cliente");
					break;

				case 2:

					System.out.println("Ingrese el nit del cliente");
					String id2 = sc.next();
					long idC2 = 0;
					System.out.println("Ingrese el nombre del cliente");
					String nombreCliente2 = sc.next();
					System.out.println("Ingrese el correo del cliente");
					String correo2 = sc.next();
					System.out.println("Ingrese la dirección del cliente");
					String direccion2 = sc.next();

					try {
						idC2 = Long.parseLong(id2);

					}
					catch (Exception e) {
						System.err.println("Información errónea");
						break;
					}

					VOClienteEmpresa cliente2 = superAndes.adicionarClienteEmpresa(idC2, nombreCliente2, correo2, direccion2);
					if (cliente2!= null) System.out.println(cliente2.toString());
					else System.out.println("No fue posible añadir al cliente empresa");
					break;

				}
				break;

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
				System.out.println("Ingrese el nivel de abastecimiento");
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

				System.out.println("¿Qué tipo de promoción es?");
				System.out.println("1. Promocion Descuento segundo producto");
				System.out.println("2. Promoción Porcentaje");
				System.out.println("3. Pague M lleve N unidades");
				System.out.println("4. Pague X lleve Y cantidad");
				System.out.println("5. Menor a la suma");
				int promo = sc.nextInt();


				System.out.println("Ingrese el id de la sucursal");
				String idSucursalPromo = sc.next();
				long idSucursalL  = 0;

				System.out.println("Ingrese el id del producto");
				String idProductoPromo = sc.next();
				


				System.out.println("Ingrese la fecha de vencimiento de la promoción en (YYYY/MM/DD)");
				String fecha = sc.next();
				String pattern2 = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
				Date date = new Date();
				try {
					idSucursalL = Long.parseLong(idSucursalPromo);
					date = simpleDateFormat2.parse(fecha);

				}
				catch (Exception e) {
					System.err.println("Información errónea");
					break;
				}

				switch (promo) {
				case 1:

					System.out.println("Ingrese el porcentaje de descuento en el segundo producto. Ej: 0.23 = 23%");
					String descuento = sc.next();
					double desc = 0;

					try {
						desc = Double.parseDouble(descuento);

					}
					catch (Exception e) {
						System.err.println("Información errónea");
						break;
					}

					VODescuentoSegundoProducto dsp = superAndes.adicionarDescuentoSegundoProducto(desc, new Timestamp(date.getTime()), idSucursalL, idProductoPromo);

					if (dsp != null) System.out.println(dsp.toString());
					else System.out.println("No se pudo crear la promoción");


					break;

				case 2:
					
					System.out.println("Ingrese el porcentaje de descuento del producto. Ej: 0.23 = 23%");
					String descuento2 = sc.next();
					double desc2 = 0;
					
					try {
						desc2 = Double.parseDouble(descuento2);
					}
					catch(Exception e){
						System.err.println("Información errónea");
						break;
					}
					
					VOPromocionPorcentaje pp = superAndes.adicionarPromocionPorcentaje(desc2, new Timestamp(date.getTime()), idSucursalL, idProductoPromo);
					if ( pp != null ) System.out.println(pp.toString());
					else System.out.println("No se pudo crear la promoción");
					break;
				
				case 3:
					System.out.println("Ingrese M");
					String cantidadM = sc.next();
					int m = 0;
					System.out.println("Ingrese N");
					String cantidadN = sc.next();
					int n = 0;
					
					try {
						m = Integer.parseInt(cantidadM);
						n = Integer.parseInt(cantidadN);
						
					} catch (Exception e) {
						System.err.println("Información errónea");
						break;
						
					}
					
					VOPagueMLleveNUnidades promMN = superAndes.adicionarPagueMLleveNUnidades(m, n, new Timestamp(date.getTime()), idSucursalL, idProductoPromo);
					if (promMN != null ) System.out.println(promMN.toString());
					else System.out.println("No se pudo crear la promoción");
					break;
					
				case 4:
					System.out.println("Ingrese X");
					String cantidadX = sc.next();
					double x = 0;
					System.out.println("Ingrese Y");
					String cantidadY = sc.next();
					double y = 0;
					
					try {
						x = Double.parseDouble(cantidadX);
						y = Double.parseDouble(cantidadY);
						
					} catch (Exception e) {
						System.err.println("Información errónea");
						break;
						
					}
					
					VOPagueXLleveYCantidad promXY = superAndes.adicionarPagueXLleveYCantidad(x, y, new Timestamp(date.getTime()), idSucursalL, idProductoPromo);
					if (promXY != null ) System.out.println(promXY.toString());
					else System.out.println("No se pudo crear la promoción");
					break;
					
				case 5:
					System.out.println("Ingrese el id del otro producto de la promoción");
					String idProductoPromo2 = sc.next();
					
					
					try {
					
					}
					catch(Exception e){
						System.err.println("Información errónea");
						break;
					}
					
					VOPromocionMenorALaSuma promoMenor = superAndes.adicionarMenorALaSuma(new Timestamp(date.getTime()), idSucursalL, idProductoPromo, idProductoPromo2);
					
					if (promoMenor != null ) System.out.println(promoMenor.toString());
					else System.out.println("No se pudo crear la promoción");
					break;

				}

				break;

			case 8:

			case 9:

			case 10:

			case 11:

			case 12:

			case 13:

			case 14:

			case 15:

			case 16:
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
		System.out.println("2. Registrar productos");
		System.out.println("3. Registrar clientes");
		System.out.println("4. Registrar sucursales");
		System.out.println("5. Registrar bodega");
		System.out.println("6. Registrar estante");
		System.out.println("7. Registrar promocion");
		System.out.println("8. Finalizar promocion");
		System.out.println("9. Registrar pedido");
		System.out.println("10. Registrar llegada de pedido");
		System.out.println("11. Registrar venta");
		System.out.println("12. dinero recolectado");
		System.out.println("13. 20 promociones mas populares ");
		System.out.println("14. indice ocupacion bodegas y estantes");
		System.out.println("15. productos que cumplen cierta caracteristica");
		System.out.println("16. Salir");
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
