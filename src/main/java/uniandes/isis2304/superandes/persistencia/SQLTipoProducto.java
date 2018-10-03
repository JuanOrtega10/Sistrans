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

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superandes.negocio.TipoProducto;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto TIPOPRODUCTO de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLTipoProducto 
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
	public SQLTipoProducto (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un REORDEN a la base de datos de SuperAndes
	 */
	public long adicionarTipoProducto (PersistenceManager pm, long id, String nombre, long idCategoria) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaTipoProducto( ) + "(id, nombre, idCategoria) values (?, ?, ?)");
        q.setParameters(id, nombre, idCategoria);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN REORDEN de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public TipoProducto darTipoProdcutoPorId (PersistenceManager pm, long idTipoProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaTipoProducto( ) + " WHERE id = ?");
		q.setResultClass(TipoProducto.class);
		q.setParameters(idTipoProducto);
		return (TipoProducto) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS REORDEN de la 
	 * base de datos de SuperAndes
	 */
	public List<TipoProducto> darTiposProducto (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaTipoProducto( ));
		q.setResultClass(TipoProducto.class);
		return (List<TipoProducto>) q.executeList();
	}
}
