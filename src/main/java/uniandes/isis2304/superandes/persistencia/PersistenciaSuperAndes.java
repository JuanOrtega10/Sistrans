package uniandes.isis2304.superandes.persistencia;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.superandes.negocio.Almacenamiento;
import uniandes.isis2304.superandes.negocio.Bebida;
import uniandes.isis2304.superandes.negocio.Bodega;
import uniandes.isis2304.superandes.negocio.Cliente;
import uniandes.isis2304.superandes.negocio.ClienteEmpresa;
import uniandes.isis2304.superandes.negocio.ClienteNatural;
import uniandes.isis2304.superandes.negocio.Estante;
import uniandes.isis2304.superandes.negocio.Producto;
import uniandes.isis2304.superandes.negocio.Proveedor;
import uniandes.isis2304.superandes.negocio.Sucursal;
import uniandes.isis2304.superandes.negocio.TipoBebida;


/**
 * Clase para el manejador de persistencia del proyecto Parranderos
 * Traduce la información entre objetos Java y tuplas de la base de datos, en ambos sentidos
 * Sigue un patrón SINGLETON (Sólo puede haber UN objeto de esta clase) para comunicarse de manera correcta
 * con la base de datos
 * Se apoya en las clases SQL
 * 
 * @author Germán Bravo
 */
public class PersistenciaSuperAndes {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaSuperAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";
	
	

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaSuperAndes instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil2 sqlUtil2;
	
	/**
	 * Atributo para el acceso a la tabla ALMACENAMIENTO de la base de datos
	 */
	private SQLAlmacenamiento sqlAlmacenmiento;
	
	/**
	 * Atributo para el acceso a la tabla BODEGA de la base de datos
	 */
	private SQLBodega sqlBodega;
	
	/**
	 * Atributo para el acceso a la tabla CATEGORIA de la base de datos
	 */
	private SQLCategoria sqlCategoria;
	
	/**
	 * Atributo para el acceso a la tabla CLIENTE de la base de datos
	 */
	private SQLCliente sqlCliente;
	
	/**
	 * Atributo para el acceso a la tabla CLIENTEEMPRESA de la base de datos
	 */
	private SQLClienteEmpresa sqlClienteEmpresa;
	
	/**
	 * Atributo para el acceso a la tabla CLIENTENATURAL de la base de datos
	 */
	private SQLClienteNatural sqlClienteNatural;
	
	/**
	 * Atributo para el acceso a la tabla DESCUENTOSGDOPRODUCTO de la base de datos
	 */
	private SQLDescuentoSegundoProducto sqlDescuentoSegundoProducto;
	
	/**
	 * Atributo para el acceso a la tabla ESTANTE de la base de datos
	 */
	private SQLEstante sqlEstante;
	
	/**
	 * Atributo para el acceso a la tabla FACTURA de la base de datos
	 */
	private SQLFactura sqlFactura;
	
	/**
	 * Atributo para el acceso a la tabla MENORALASUMA de la base de datos
	 */
	private SQLPromocionMenorALaSuma sqlMenorALaSuma;
	
	/**
	 * Atributo para el acceso a la tabla PAGEMLLEVENUNIDADES de la base de datos
	 */
	private SQLPagueMLleveNUnidades sqlPagueMLleveNUnidades;
	
	/**
	 * Atributo para el acceso a la tabla PAGUEXLLEVEYCANTIDAD de la base de datos
	 */
	private SQLPagueXLleveYCantidad sqlPagueXLleveYCantidad;

	/**
	 * Atributo para el acceso a la tabla PEDIDO de la base de datos
	 */
	private SQLPedido sqlPedido;
	
	/**
	 * Atributo para el acceso a la tabla PRODUCTO de la base de datos
	 */
	private SQLProducto sqlProducto;
	
	/**
	 * Atributo para el acceso a la tabla PROMOCION de la base de datos
	 */
	private SQLPromocion sqlPromocion;
	
	/**
	 * Atributo para el acceso a la tabla PROMOCIONPORCENTAJE de la base de datos
	 */
	private SQLPromocionPorcentaje sqlPromocionPorcentaje;

	/**
	 * Atributo para el acceso a la tabla PROVEE de la base de datos
	 */
	private SQLProvee sqlProvee;

	/**
	 * Atributo para el acceso a la tabla PROVEEDOR de la base de datos
	 */
	private SQLProveedor sqlProveedor;

	/**
	 * Atributo para el acceso a la tabla REORDEN de la base de datos
	 */
	private SQLReorden sqlReorden;
	
	/**
	 * Atributo para el acceso a la tabla SUCURSAL de la base de datos
	 */
	private SQLSucursal sqlSucursal;
	
	/**
	 * Atributo para el acceso a la tabla TIPOPRODUCTO de la base de datos
	 */
	private SQLTipoProducto sqlTipoProducto;
	
	/**
	 * Atributo para el acceso a la tabla VOLUMENPRODUCTO de la base de datos
	 */
	private SQLVolumenProdcuto sqlVolumenProdcuto;
	

	
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

//	/**
//	 * Constructor privado con valores por defecto - Patrón SINGLETON
//	 */
//	private PersistenciaSuperAndes()
//	{
//		pmf = JDOHelper.getPersistenceManagerFactory("SuperAndes");		
//		crearClasesSQL ();
//		
//		// Define los nombres por defecto de las tablas de la base de datos
//		tablas = new LinkedList<String> ();
//		tablas.add ("SUPERANDES_SEQUENCE");
//		tablas.add ("ALMACENAMIENTO");
//		tablas.add ("BODEGA");
//		tablas.add ("CATEGORIA");
//		tablas.add ("CLIENTE");
//		tablas.add ("CLIENTEEMPRESA");
//		tablas.add ("CLIENTENATURAL");
//		tablas.add ("DESCUENTOSGDOPRODUCTO");
//		tablas.add ("ESTANTE");
//		tablas.add ("FACTURA");
//		tablas.add ("MENORALASUMA");
//		tablas.add ("PAGEMLLEVENUNIDADES");
//		tablas.add ("PAGUEXLLEVEYCANTIDAD");
//		tablas.add ("PEDIDO");
//		tablas.add ("PRODUCTO");
//		tablas.add ("PROMOCION");
//		tablas.add ("PROMOCIONPORCENTAJE");
//		tablas.add ("PROVEE");
//		tablas.add ("PROVEEDOR");
//		tablas.add ("REORDEN");
//		tablas.add ("SUCURSAL");
//		tablas.add ("TIPOPRODUCTO");
//		tablas.add ("VOLUMENPRODUCTO");
//		
//}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaSuperAndes (JsonObject tableConfig)
	{
		tablas = leerNombresTablas (tableConfig);
		crearClasesSQL ();
		System.out.println(tablas.get(1));
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

//	/**
//	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
//	 */
//	public static PersistenciaSuperAndes getInstance ()
//	{
//		if (instance == null)
//		{
//			instance = new PersistenciaSuperAndes ();
//		}
//		return instance;
//	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaSuperAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaSuperAndes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		
		sqlUtil2 = new SQLUtil2(this);
		
		sqlAlmacenmiento = new SQLAlmacenamiento(this);
		
		sqlBodega = new SQLBodega(this);
		
		sqlCategoria = new SQLCategoria(this);
		
		sqlCliente = new SQLCliente(this);
		
		sqlClienteEmpresa = new SQLClienteEmpresa(this);
		
		sqlClienteNatural = new SQLClienteNatural(this);
		
		sqlDescuentoSegundoProducto = new SQLDescuentoSegundoProducto(this);
		
		sqlEstante = new SQLEstante(this);
		
		sqlFactura = new SQLFactura(this);
		
		sqlMenorALaSuma = new SQLPromocionMenorALaSuma(this);
		
		sqlPagueMLleveNUnidades = new SQLPagueMLleveNUnidades(this);
		
		sqlPagueXLleveYCantidad = new SQLPagueXLleveYCantidad(this);

		sqlPedido = new SQLPedido(this);
		
		sqlProducto = new SQLProducto(this);
		
		sqlPromocion = new SQLPromocion(this);
		
		sqlPromocionPorcentaje = new SQLPromocionPorcentaje(this);

		sqlProvee = new SQLProvee(this);

		sqlProveedor = new SQLProveedor(this);

		sqlReorden = new SQLReorden(this);
		
		sqlSucursal = new SQLSucursal(this);
		
		sqlTipoProducto = new SQLTipoProducto(this);
		
		sqlVolumenProdcuto = new SQLVolumenProdcuto(this);
	}
	
	
	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqSuperAndes()
	{
		return tablas.get (0);
	}


	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebida de parranderos
	 */
	public String darTablaProveedor ()
	{
		return tablas.get (18);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaCategoria ()
	{
		return tablas.get (3);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebedor de parranderos
	 */
	public String darTablaAlmacenamiento ()
	{
		return tablas.get (1);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Gustan de parranderos
	 */
	public String darTablaEstante ()
	{
		return tablas.get (8);
	}


	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaClienteEmpresa ()
	{
		return tablas.get (5);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaClienteNatural()
	{
		return tablas.get (6);
	}


	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaFactura ()
	{
		return tablas.get (9);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPedido ()
	{
		return tablas.get (13);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaProducto ()
	{
		return tablas.get (14);
	}
	
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaProvee()
	{
		return tablas.get (17);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaReorden ()
	{
		return tablas.get (19);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaTipoProducto()
	{
		return tablas.get (21);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaVolumenProducto ()
	{
		return tablas.get (22);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPromocion ()
	{
		return tablas.get (15);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPromocionPorcentaje ()
	{
		return tablas.get (16);
	}
	
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPagueMLleveNUnidades()
	{
		return tablas.get (11);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaPagueXLleveYCantidad()
	{
		return tablas.get (12);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaMenorALaSuma()
	{
		return tablas.get (10);
	}
	

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaDescuentoSegundoProducto()
	{
		return tablas.get (7);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bodega de parranderos
	 */
	public String darTablaBodega() 
	{
		return tablas.get(2);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bodega de parranderos
	 */
	public String darTablaCliente() {
		return tablas.get(4);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bodega de parranderos
	 */
	public String darTablaSucursal() {
		return tablas.get(20);
	}
	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval ()
	{
        long resp = sqlUtil2.nextval (pmf.getPersistenceManager());
        System.out.println ("Generando secuencia: " + resp);
        return resp;
    }

	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	
	
	/* ****************************************************************
	 * 			Métodos para manejar SUCURSAL
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Sucursal
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre de la sucursal
	 * @param direcion - La dirección de la sucursal
	 * @param ciudad - La ciudad de la sucursal.
	 * @return El objeto Sucursal adicionado. null si ocurre alguna Excepción
	 */
	public Sucursal adicionarSucursal(String nombre, String direccion, String ciudad)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval();
            long tuplasInsertadas = sqlSucursal.adicionarSucursal(pm, id, nombre, direccion, ciudad );
            tx.commit();
            
            System.out.println("Inserción de tipo de Sucursal: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Sucursal (id, nombre, direccion, ciudad);
        }
        catch (Exception e)
        {
        	System.out.println("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Sucursal
	 * @return La lista de objetos Sucursal, construidos con base en las tuplas de la tabla SUCURSAL
	 */
	public List<Sucursal> darSucursales ()
	{
		return sqlSucursal.darSucursales(pmf.getPersistenceManager());
	}
	
	
	/**
	 * Método que consulta todas las tuplas en la tabla Sucursal con un identificador dado
	 * @param idSucursal - El identificador del la Sucursal
	 * @return El objeto Sucursal, construido con base en las tuplas de la tabla Sucursal con el identificador dado
	 */
	public Sucursal darSucursalPorId (long idSucursal)
	{
		return sqlSucursal.darSucursalPorId(pmf.getPersistenceManager(), idSucursal);
	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los PROVEEDORES
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Proveedor
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del proveedor.
	 * @param calificacion - La calificación que la sucursal le da al proveedor.
	 * @param numCalificaciones - El número de calificaciones.
	 * @return El objeto Proveedor adicionado. null si ocurre alguna Excepción
	 */
	public Proveedor adicionarProveedor(long id, String nombre, double calificacion, int numCalificaciones ) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlProveedor.adicionarProveedor(pm, id, nombre, calificacion, numCalificaciones);
            tx.commit();

            System.out.println("Llega acá");
            log.trace ("Inserción proveedor: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
           

            
            System.out.println("Inserción de tipo de Sucursal: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Proveedor (id, nombre, calificacion, numCalificaciones);

        }
        catch (Exception e)
        {
        	System.out.println(("Exception : " + e.getMessage() + "\n" + darDetalleException(e)));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Proveedor
	 * @return La lista de objetos Proveedor, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Proveedor> darProveedores ()
	{
		return sqlProveedor.darProveedores(pmf.getPersistenceManager());
	}
	
	/**
	 * Método que consulta el proveedor con el id dado
	 * @return Proveedor, null si existe alguna excepción.
	 */
	public Proveedor darProveedorPorId (long id)
	{
		return sqlProveedor.darProveedorPorId(pmf.getPersistenceManager(), id);
	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los ALMACENAMIENTOS
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Proveedor
	 * Adiciona entradas al log de la aplicación
	 * @param cantidadMax
	 * @param pesoMax
	 * @param volumenMax
	 * @param idSucursal
	 * @param idTipoProducto
	 * @param idVolumenProducto
	 * @return El id del almacenamiento. null si ocurre alguna Excepción
	 */
	public Long adicionarAlmacenamiento(int cantidadMax, double pesoMax, double volumenMax, long idSucursal, long idTipoProducto, long idVolumenProducto ) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	tx.begin();
        	long id = nextval ();
            long tuplasInsertadas = sqlAlmacenmiento.adicionarAlmacenamiento(pm, id, cantidadMax, pesoMax, volumenMax, idSucursal, idTipoProducto, idVolumenProducto);
            tx.commit();
            
            System.out.println("Inserción Almacenamiento: " + cantidadMax + ": " + tuplasInsertadas + " tuplas insertadas");
            return id;
        }
        catch (Exception e)
        {
        	System.out.println ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Proveedor
	 * @return La lista de objetos Proveedor, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Almacenamiento> darAlmacenamientos()
	{
		return sqlAlmacenmiento.darAlmacenamientos(pmf.getPersistenceManager());
	}
	
	/**
	 * Método que consulta el proveedor con el id dado
	 * @return Almacenamiento, null si existe alguna excepción.
	 */
	public Almacenamiento darAlmacenamientoPorId (long id)
	{
		return sqlAlmacenmiento.darAlmacenamientoPorId(pmf.getPersistenceManager(), id);
	}
	
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los BODEGA
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Proveedor
	 * Adiciona entradas al log de la aplicación
	 * @param idAlmacenamiento
	 * @param direccion
	 * @return El objeto Bodega adicionado. null si ocurre alguna Excepción
	 */
	public Bodega adicionarBodega(long idAlmacenamiento, String direccion, int cantidadMax, double pesoMax, double volumenMax, long idSucursal, long idTipoProducto, long idVolumenProducto) 
	{
		
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	 tx.begin();
            long tuplasInsertadas = sqlBodega.adicionarBodega(pm, idAlmacenamiento, direccion);
            tx.commit();
            
            System.out.println ("Inserción Bodega: " + idAlmacenamiento + ": " + tuplasInsertadas + " tuplas insertadas");
            return new Bodega(idAlmacenamiento, volumenMax, pesoMax, cantidadMax, direccion, idSucursal, idTipoProducto, idVolumenProducto);
        }
        catch (Exception e)
        {
        	System.out.println ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Proveedor
	 * @return La lista de objetos Proveedor, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Bodega> darBodegas()
	{
		return sqlBodega.darBodegas(pmf.getPersistenceManager());
	}
	
	/**
	 * Método que consulta el proveedor con el id dado
	 * @return Almacenamiento, null si existe alguna excepción.
	 */
	public Bodega darBodegaPorId (long id)
	{
		return sqlBodega.darBodegaPorId(pmf.getPersistenceManager(), id);
	}
	
	
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los ESTANTES
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Proveedor
	 * Adiciona entradas al log de la aplicación
	 * @param idAlmacenamiento
	 * @param direccion
	 * @return El objeto Bodega adicionado. null si ocurre alguna Excepción
	 */
	public Estante adicionarEstante(long idAlmacenamiento, int nivelAbastecimiento, int cantidadMax, double pesoMax, double volumenMax, long idSucursal, long idTipoProducto, long idVolumenProducto) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	tx.begin();
            long tuplasInsertadas = sqlEstante.adicionarEstante(pm, idAlmacenamiento, nivelAbastecimiento);
            tx.commit();
            
            System.out.println("Inserción Estante: " + idAlmacenamiento + ": " + tuplasInsertadas + " tuplas insertadas");
            return new Estante(idAlmacenamiento, volumenMax, pesoMax, cantidadMax, nivelAbastecimiento, idSucursal, idTipoProducto, idVolumenProducto);
        }
        catch (Exception e)
        {
        	System.out.println("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Proveedor
	 * @return La lista de objetos Estante, construidos con base en las tuplas de la tabla Estante
	 */
	public List<Estante> darEstantes()
	{
		return sqlEstante.darEstantes(pmf.getPersistenceManager());
	}
	
	/**
	 * Método que consulta el proveedor con el id dado
	 * @return Estante, null si existe alguna excepción.
	 */
	public Estante darEstantesPorId (long id)
	{
		return sqlEstante.darEstantePorId(pmf.getPersistenceManager(), id);
	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los CLIENTES
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Proveedor
	 * Adiciona entradas al log de la aplicación
	 * @param cantidadMax
	 * @param pesoMax
	 * @param volumenMax
	 * @param idSucursal
	 * @param idTipoProducto
	 * @param idVolumenProducto
	 * @return El id del almacenamiento. null si ocurre alguna Excepción
	 */
	public Long adicionarCliente(long id, String nombre, String correo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
        	tx.begin();
        	System.out.println("Llega");
            long tuplasInsertadas = sqlCliente.adicionarCliente(pm, id, nombre, correo);
            System.out.println("Llega2");
            tx.commit();
            
           	System.out.println("Inserción Cliente: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            return id;
        }
        catch (Exception e)
        {
        	System.err.println("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que consulta todas las tuplas en la tabla Proveedor
	 * @return La lista de objetos Proveedor, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Cliente> darClientes()
	{
		return sqlCliente.darClientes(pmf.getPersistenceManager());
	}
	
	/**
	 * Método que consulta el proveedor con el id dado
	 * @return Cliente, null si existe alguna excepción.
	 */
	public Cliente darClientePorId(long id)
	{
		return sqlCliente.darClientePorId(pmf.getPersistenceManager(), id);
	}
	
	

	/* ****************************************************************
	 * 			Métodos para manejar los CLIENTES NATURALES
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Proveedor
	 * Adiciona entradas al log de la aplicación
	 * @param idAlmacenamiento
	 * @param direccion
	 * @return El objeto Bodega adicionado. null si ocurre alguna Excepción
	 */
	public ClienteNatural adicionarClienteNatural(long id, String nombre, String correo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	tx.begin();
            long tuplasInsertadas = sqlClienteNatural.adicionarClienteNatural(pm, id);
            tx.commit();
            
            System.out.println("Inserción Cliente Natural: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            return new ClienteNatural(id, nombre, correo);
        }
        catch (Exception e)
        {
        	System.out.println("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	

	/* ****************************************************************
	 * 			Métodos para manejar los CLIENTES EMPRESAS
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Proveedor
	 * Adiciona entradas al log de la aplicación
	 * @param idAlmacenamiento
	 * @param direccion
	 * @return El objeto Bodega adicionado. null si ocurre alguna Excepción
	 */
	public ClienteEmpresa adicionarClienteEmpresa(long id, String nombre, String correo, String direccion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	tx.begin();
            long tuplasInsertadas = sqlClienteEmpresa.adicionarClienteEmpresa(pm, id, direccion);
            tx.commit();
            
            System.out.println("Inserción Cliente Empresa: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            return new ClienteEmpresa(id, nombre, correo, direccion);
        }
        catch (Exception e)
        {
        	System.out.println("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar los PRODUCTOS
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Proveedor
	 * Adiciona entradas al log de la aplicación
	 * @param idAlmacenamiento
	 * @param direccion
	 * @return El objeto Bodega adicionado. null si ocurre alguna Excepción
	 */
	public ClienteEmpresa adicionarProducto(String id, String nombre, String marca, double precioUnitario, String presentacion, double cantidad, String unidadMedida, double precioUnidadMedida, String especificacionEmpaque, int exclusivo, Date fechaVencimiento, long idTipoProducto, long idCategoria)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	tx.begin();
            long tuplasInsertadas = sqlProducto.adicionarProducto(pm, id, nombre, marca, precioUnitario, presentacion, cantidad, unidadMedida, precioUnidadMedida, especificacionEmpaque, exclusivo, idTipoProducto, idCategoria, fechaVencimiento);
            tx.commit();
            
            System.out.println("Inserción Cliente Empresa: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            return new Producto(id, nombre, marca, precioUnitario, presentacion, precioUnidadMedida, cantidad, unidadMedida, especificacionEmpaque, exclusivo, fechaVencimiento, idCategoria, idTipoProducto);
        }
        catch (Exception e)
        {
        	System.out.println("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

}
