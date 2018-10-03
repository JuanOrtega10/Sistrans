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

import uniandes.isis2304.superandes.negocio.PagueXLleveYCantidad;


/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto PromocioPagueXLleveYCantidad de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLPagueXLleveYCantidad 
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
	public SQLPagueXLleveYCantidad (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ALMACENAMIENTO a la base de datos de SuperAndes
	 */
	public long adicionarPromocionPagueXLleveYCantidad (PersistenceManager pm, long id, double x, double y) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaPagueXLleveYCantidad() + "(idPromocion, x, y) values (?,?,?)");
        q.setParameters(id, x, y);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ALMACENAMIENTO de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public PagueXLleveYCantidad darPromocionPagueXLleveYCantidad (PersistenceManager pm, long idPromocion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaPagueXLleveYCantidad( ) + " WHERE idPromocion = ?");
		q.setResultClass(PagueXLleveYCantidad.class);
		q.setParameters(idPromocion);
		return (PagueXLleveYCantidad) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ALMACENAMIENTO de la 
	 * base de datos de SuperAndes
	 */
	public List<PagueXLleveYCantidad> darPromocionesPagueXLleveYCantidad (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaPagueXLleveYCantidad());
		q.setResultClass(PagueXLleveYCantidad.class);
		return (List<PagueXLleveYCantidad>) q.executeList();
	}
}
