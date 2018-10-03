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

import uniandes.isis2304.superandes.negocio.Reorden;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto REORDEN de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLReorden 
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
	public SQLReorden (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un REORDEN a la base de datos de SuperAndes
	 */
	public long adicionarReorden (PersistenceManager pm, long id, int nivelReorden, long idsucursal ,long idProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaReorden( ) + "(id, nivelReorden, idsucursal, idProducto) values (?, ?, ?, ?)");
        q.setParameters(id, nivelReorden, idsucursal, idProducto);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN REORDEN de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public Reorden darReordenPorId (PersistenceManager pm, long idReorden) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaReorden( ) + " WHERE id = ?");
		q.setResultClass(Reorden.class);
		q.setParameters(idReorden);
		return (Reorden) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS REORDEN de la 
	 * base de datos de SuperAndes
	 */
	public List<Reorden> darVolumenes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaReorden( ));
		q.setResultClass(Reorden.class);
		return (List<Reorden>) q.executeList();
	}
}
