/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: SuperAndes
 * @version 1.0
 * @author Juan Ortega - Diany Quintero
 * Octubre de 2018
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.superandes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;

import uniandes.isis2304.superandes.persistencia.PersistenciaParranderos;
import uniandes.isis2304.superandes.persistencia.PersistenciaSuperAndes;

/**
 * Clase principal del negocio SuperAndes
 * Satisface todos los requerimientos funcionales del negocio
 *
 * @author ja.ortega - dy.quintero.
 */
public class SuperAndes {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(Parranderos.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaSuperAndes ps;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public SuperAndes ()
	{
		ps = PersistenciaSuperAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public SuperAndes (JsonObject tableConfig)
	{
		ps = PersistenciaSuperAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		ps.cerrarUnidadPersistencia ();
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar las SUCURSALES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una sucursal 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del sucursal
	 * @param direccion - La direccionde la sucursal
	 * @param ciudad - La ciudad de la sucursal
	 * @return El objeto Sucursal adicionado. null si ocurre alguna Excepción
	 */
	public Sucursal adicionarSucursal (String nombre, String direccion, String ciudad)
	{
        log.info ("Adicionando Sucursal: " + nombre);
        Sucursal sucursal = ps.adicionarSucursal (nombre, direccion, ciudad);
        log.info ("Adicionando Sucursal: " + sucursal);
        return sucursal;
	}
	
	/**
	 * Encuentra una Sucursal y su información básica, según su identificador
	 * @param idSucursal - El identificador de la sucursal buscada
	 * @return Un objeto Sucursal que corresponde con el identificador buscado y lleno con su información básica
	 * 			null, si una sucursal con dicho identificador no existe
	 */
	public Sucursal darSucursalPorId (long idSucursal)
	{
        log.info ("Dar información de una sucursal por id: " + idSucursal);
        Sucursal sucursal = ps.darSucursalPorId (idSucursal);
        log.info ("Buscando bebedor por Id: " + sucursal != null ? sucursal : "NO EXISTE");
        return sucursal;
	}
	
	/**
	 * Encuentra todos las sucursales en SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Sucursal con todos las Sucursales que conoce la aplicación, llenos con su información básica
	 */
	public List<Sucursal> darSucursales ()
	{
        log.info ("Listando Sucursales");
        List<Sucursal> sucursales = ps.darSucursales ();	
        log.info ("Listando Sucursales: " + sucursales.size() + " sucursales existentes");
        return sucursales;
	}

	/**
	 * Encuentra todos los bares en Parranderos y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Bar con todos las bares que conoce la aplicación, llenos con su información básica
	 */
	public List<VOSucursal> darVOSucursales ()
	{
		log.info ("Generando los VO de Sucursales");
		List<VOSucursal> voSucursales = new LinkedList<VOSucursal> ();
		for (Sucursal sucursal: ps.darSucursales())
		{
			voSucursales.add (sucursal);
		}
		log.info ("Generando los VO de Sucursales: " + voSucursales.size () + " Sucursales existentes");
		return voSucursales;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los PROVEEDORES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una sucursal 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del proveedor
	 * @param calificacion - La calificacion del proveedor
	 * @param numCalificaciones - El numero de calificaciones del proveedor
	 * @return El objeto Proveedor adicionado. null si ocurre alguna Excepción
	 */
	public Proveedor adicionarProveedor (String nombre, double calificacion, int numCalificaciones)
	{
        log.info ("Adicionando Proveedor: " + nombre);
        Proveedor proveedor = ps.adicionarProveedor (nombre, calificacion, numCalificaciones);
        log.info ("Adicionando Sucursal: " + proveedor);
        return proveedor;
	}
	
	/**
	 * Encuentra una Sucursal y su información básica, según su identificador
	 * @param idProveedor - El identificador de Proveedor buscado
	 * @return Un objeto Proveedor que corresponde con el identificador buscado y lleno con su información básica
	 * 			null, si un Proveedor con dicho identificador no existe
	 */
	public Proveedor darProveedorPorId (long idProveedor)
	{
        log.info ("Dar información de una sucursal por id: " + idProveedor);
        Proveedor proveedor = ps.darProveedorPorId (idProveedor);
        log.info ("Buscando bebedor por Id: " + proveedor != null ? proveedor : "NO EXISTE");
        return proveedor;
	}
	
	/**
	 * Encuentra todos las sucursales en SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Sucursal con todos las Sucursales que conoce la aplicación, llenos con su información básica
	 */
	public List<Sucursal> darSucursales ()
	{
        log.info ("Listando Sucursales");
        List<Sucursal> sucursales = ps.darSucursales ();	
        log.info ("Listando Sucursales: " + sucursales.size() + " sucursales existentes");
        return sucursales;
	}

	/**
	 * Encuentra todos los bares en Parranderos y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Bar con todos las bares que conoce la aplicación, llenos con su información básica
	 */
	public List<VOSucursal> darVOSucursales ()
	{
		log.info ("Generando los VO de Sucursales");
		List<VOSucursal> voSucursales = new LinkedList<VOSucursal> ();
		for (Sucursal sucursal: ps.darSucursales())
		{
			voSucursales.add (sucursal);
		}
		log.info ("Generando los VO de Sucursales: " + voSucursales.size () + " Sucursales existentes");
		return voSucursales;
	}
	
	
	
}
