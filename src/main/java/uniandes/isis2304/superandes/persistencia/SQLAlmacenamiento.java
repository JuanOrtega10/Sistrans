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

import uniandes.isis2304.superandes.negocio.Almacenamiento;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto ALMACENAMIENTO de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLAlmacenamiento 
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
	public SQLAlmacenamiento (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ALMACENAMIENTO a la base de datos de SuperAndes
	 */
	public long adicionarAlmacenamiento (PersistenceManager pm, long id, int cantidadMax, double pesoMax, double volumenMax, long idSucursal, long idTipoProducto,long idVolumenProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaAlmacenamiento() + "(id, cantidad, peso, volumen, idSucursal, idTipoProducto, idVolumenProducto) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, cantidadMax, pesoMax, volumenMax, idSucursal, idTipoProducto, idVolumenProducto);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ALMACENAMIENTO de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public Almacenamiento darAlmacenamientoPorId (PersistenceManager pm, long idAlmacenamiento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaAlmacenamiento( ) + " WHERE id = ?");
		q.setResultClass(Almacenamiento.class);
		q.setParameters(idAlmacenamiento);
		return (Almacenamiento) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ALMACENAMIENTO de la 
	 * base de datos de SuperAndes
	 */
	public List<Almacenamiento> darAlmacenamientos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaAlmacenamiento());
		q.setResultClass(Almacenamiento.class);
		return (List<Almacenamiento>) q.executeList();
	}
}
