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

import uniandes.isis2304.superandes.negocio.Provee;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto PROVEE de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLProvee 
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
	public SQLProvee (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un PROVEE a la base de datos de SuperAndes
	 */
	public long adicionarProvee (PersistenceManager pm, long idProveedor, long idProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaProvee( ) + "(idProveedor, idProducto) values (?, ?)");
        q.setParameters(idProveedor, idProducto);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS PROVEE de la 
	 * base de datos de SuperAndes
	 */
	public List<Provee> darProvees (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaProvee( ));
		q.setResultClass(Provee.class);
		return (List<Provee>) q.executeList();
	}
}
