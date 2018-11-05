package uniandes.isis2304.superandes.test;

import static org.junit.Assert.*;


import java.io.FileReader;
import java.math.BigDecimal;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.superandes.negocio.Carrito;
import uniandes.isis2304.superandes.negocio.ItemCarrito;
import uniandes.isis2304.superandes.negocio.SuperAndes;
import uniandes.isis2304.superandes.persistencia.PersistenciaSuperAndes;

public class PersistenciaTest {

	private static Logger log = Logger.getLogger(PersistenciaSuperAndes.class.getName());


	private static final String CONFIG_TABLAS_A = "./src/main/resources/config/TablasBD_A_SuperAndes.json"; 

	private SuperAndes superAndes1 = null;
	private SuperAndes superAndes2 = null;


	public void setUpEscenario1()
	{
		if(superAndes1 == null || superAndes2 == null)
		{
			superAndes1 = new SuperAndes(openConfig(CONFIG_TABLAS_A));
			superAndes2 = new SuperAndes(openConfig(CONFIG_TABLAS_A));
		}

	}


	@Test
	public void solicitarCarritoDeCompras()
	{
		setUpEscenario1();
		// Caso exitoso (Un cliente exixtente solicita un carrito en una sucursal existente)
		Carrito carrito = superAndes2.solicitarCarrito(6, 1004232331);
		assertNotNull(carrito);
		// Se elimina el carro para que no haya errores
		superAndes2.abandonarCarrito(carrito.getId());

	}

	@Test
	public void solicitarCarritoDeComprasError1()
	{
		setUpEscenario1();
		// Un cliente que no existe solicita un carrito
		Carrito carritoError = superAndes2.solicitarCarrito(5, 0);
		assertNull(carritoError);
	}

	@Test
	public void solicitarCarritoDeComprasError2()
	{
		setUpEscenario1();
		// Un cliente existente vuelve a solicitar un carro
		Carrito carrito = superAndes2.solicitarCarrito(6, 1018513457);
		assertNotNull(carrito);
		Carrito carritoError = superAndes2.solicitarCarrito(6, 1018513457);
		assertNull(carritoError);
		
		superAndes2.abandonarCarrito(carrito.getId());
	}

	@Test
	public void solicitarCarritoDeComprasError3()
	{
		setUpEscenario1();
		// Un cliente existente solicita un carro en una sucursal que no existe
		Carrito carritoError = superAndes2.solicitarCarrito(0, 1004232331);
		assertNull(carritoError);
	}

	@Test
	public void adicionarProductosAlCarrito()
	{
		setUpEscenario1();
		//primero solicito un carrito
		Carrito carro = superAndes2.solicitarCarrito(6, 1018513457);
		//Se agregan los productos
		ItemCarrito producto1 = superAndes2.aniadirProductoAlCarrito(carro.getId(), "14586", new BigDecimal(10), 2);
		assertNotNull(producto1);
		ItemCarrito producto2 = superAndes2.aniadirProductoAlCarrito(carro.getId(), "15452", new BigDecimal(10), 5);
		assertNotNull(producto2);
		
		//se elimina el carro
		superAndes2.abandonarCarrito(carro.getId());
	}
	
	@Test
	public void adicionarProductosAlCarritoError1()
	{
		//El estante no existe
		setUpEscenario1();
		//primero solicito un carrito
		Carrito carro = superAndes1.solicitarCarrito(6, 1018513457);
		//Se agregan los productos
		ItemCarrito producto1 = superAndes1.aniadirProductoAlCarrito(carro.getId(), "14586", new BigDecimal(10), 0 );
		assertNull(producto1);
		
		//se elimina el carro
		superAndes2.abandonarCarrito(carro.getId());
	}
	
	@Test
	public void adicionarProductosAlCarritoError2()
	{
		//El estante no tiene ese producto
		setUpEscenario1();
		//primero solicito un carrito
		Carrito carro = superAndes1.solicitarCarrito(6, 1018513457);
		//Se agregan los productos
		ItemCarrito producto1 = superAndes1.aniadirProductoAlCarrito(carro.getId(), "14586", new BigDecimal(10), 5);
		assertNull(producto1);
		
		//se elimina el carro
		superAndes2.abandonarCarrito(carro.getId());
	}
	
	@Test
	public void adicionarProductosAlCarritoError3()
	{
		//La cantidad de productos es mayor a la que hay en el estante
		setUpEscenario1();
		//primero solicito un carrito
		Carrito carro = superAndes1.solicitarCarrito(6, 1018513457);
		//Se agregan los productos
		ItemCarrito producto1 = superAndes1.aniadirProductoAlCarrito(carro.getId(), "14586", new BigDecimal(1000), 2);
		assertNull(producto1);
		
		//se elimina el carro
		superAndes2.abandonarCarrito(carro.getId());
	}

	@Test
	public void devolverTodasLasUnidadesDeUnProducto()
	{
		//Se adicionan productos
		setUpEscenario1();
		//primero solicito un carrito
		Carrito carro = superAndes2.solicitarCarrito(6, 1018513457);
		//Se agregan los productos
		ItemCarrito producto1 = superAndes2.aniadirProductoAlCarrito(carro.getId(), "14586", new BigDecimal(10), 2);
		assertNotNull(producto1);
		ItemCarrito producto2 = superAndes2.aniadirProductoAlCarrito(carro.getId(), "15452", new BigDecimal(10), 5);
		assertNotNull(producto2);

		//Se devuelven
		long eliminado = superAndes2.eliminarItemCarrito(carro.getId(), "14586");
		assertEquals(1, eliminado);
		
		//se elimina el carro
		superAndes2.abandonarCarrito(carro.getId());
	}
	
	@Test
	public void devolverAlgunasUnidadesDeUnProducto()
	{
		//Se adicionan productos
		setUpEscenario1();
		//primero solicito un carrito
		Carrito carro = superAndes2.solicitarCarrito(6, 1018513457);
		//Se agregan los productos
		ItemCarrito producto1 = superAndes2.aniadirProductoAlCarrito(carro.getId(), "14586", new BigDecimal(10), 2);
		assertNotNull(producto1);
		ItemCarrito producto2 = superAndes2.aniadirProductoAlCarrito(carro.getId(), "15452", new BigDecimal(10), 5);
		assertNotNull(producto2);

		//Se devuelven
		long actualizado = superAndes2.actualizarCantidadItemCarrito(carro.getId(), "14586", new BigDecimal(10));
		assertEquals(1, actualizado);
		
		//se elimina el carro
		superAndes2.abandonarCarrito(carro.getId());
	}
	
	@Test
	public void abandonarCarrito()
	{
		setUpEscenario1();
		Carrito carrito = superAndes2.solicitarCarrito(6, 89541579);
		assertNotNull(carrito);

		long eliminado = superAndes2.abandonarCarrito(carrito.getId());
		assertEquals(1, eliminado);
	}
	
	@Test
	public void abandonarCarritoError1()
	{
		setUpEscenario1();
		
		long eliminado = superAndes2.abandonarCarrito(0);
		assertEquals(0, eliminado);
	}
	
	

	/* **********************
	 * 			Métodos de configuración
	 ***********************/
	/**
	 * Lee datos de configuración para la aplicación, a partir de un archivo JSON o con valores por defecto si hay errores.
	 * @param tipo - El tipo de configuración deseada
	 * @param archConfig - Archivo Json que contiene la configuración
	 * @return Un objeto JSON con la configuración del tipo especificado
	 * 			NULL si hay un error en el archivo.
	 */
	private JsonObject openConfig (String archConfig)
	{
		JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración de tablas válido");
		} 
		catch (Exception e)
		{
			//		e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de tablas válido: ", "TipoBebidaTest", JOptionPane.ERROR_MESSAGE);
		}	
		return config;
	}	

}