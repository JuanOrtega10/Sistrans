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
package uniandes.isis2304.superandes.persistencia;


import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superandes.negocio.Producto;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto PRODUCTO de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLProducto 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes ps;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLProducto (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Producto a la base de datos de SuperAndes
	 */
	public long adicionarProducto (PersistenceManager pm, String idProducto, String nombre, String marca, double precioUnitario, String presentacion, double cantidad, String unidadMedida, double precioUnidadMedida, double especificacionEmpaque, int exclusivo, long idTipoProducto, long idCategoria, Timestamp fechaVencimiento) 
	{
		
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaProducto() + "(id,nombre,marca,precioUnitario, presentacion, cantidad, unidadMedida,precioUnidadMedida, especificacionEmpaque, exclusivo, idTipoProducto,idCategoria, fechaVencimiento) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idProducto, nombre, marca , precioUnitario, presentacion, cantidad, unidadMedida, precioUnidadMedida, especificacionEmpaque, exclusivo, idTipoProducto, idCategoria, fechaVencimiento);
        return (long) q.executeUnique();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN BAR de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idBar - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Producto darProductoPorId (PersistenceManager pm, String id) 
	{
		
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaProducto( ) + " WHERE id = ?");
		q.setResultClass(Producto.class);
		q.setParameters(id);
		return (Producto) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<Producto> darProductos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaProducto());
		q.setResultClass(Producto.class);
		return (List<Producto>) q.executeList();
	}

}
