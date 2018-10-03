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

import uniandes.isis2304.superandes.negocio.Categoria;;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto CATEGORIA de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLCategoria 
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
	public SQLCategoria (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un CATEGORIA a la base de datos de SuperAndes
	 */
	public long adicionarCategoria (PersistenceManager pm, long id, String nombre) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaCategoria( ) + "(id, nombre) values (?, ?)");
        q.setParameters(id, nombre);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UNA CATEGORIA de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public Categoria darCategoriaPorId (PersistenceManager pm, long idCategoria) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCategoria( ) + " WHERE id = ?");
		q.setResultClass(Categoria.class);
		q.setParameters(idCategoria);
		return (Categoria) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LAS CATEGORIA de la 
	 * base de datos de SuperAndes
	 */
	public List<Categoria> darCategorias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCategoria( ));
		q.setResultClass(Categoria.class);
		return (List<Categoria>) q.executeList();
	}
}
