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

import uniandes.isis2304.superandes.negocio.VolumenProducto;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto VOLUMENPRODUCTO de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLVolumenProdcuto 
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
	public SQLVolumenProdcuto (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un VOLUMENPRODUCTO a la base de datos de SuperAndes
	 */
	public long adicionarVolumenProducto (PersistenceManager pm, long id, int cantidad, double peso, double volumen, String tipoVolumen, long idPedido, long idFactura,long idProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaVolumenProducto() + "(id, cantidad, peso, volumen, tipoVolumen, idPedido, idFactura, idProducto) values (?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, cantidad, peso, volumen, tipoVolumen, idPedido, idFactura, idProducto);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN VOLUMENPRODUCTO de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public VolumenProducto darVolumenPorId (PersistenceManager pm, long idVolumenProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaVolumenProducto( ) + " WHERE id = ?");
		q.setResultClass(VolumenProducto.class);
		q.setParameters(idVolumenProducto);
		return (VolumenProducto) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS VOLUMENPRODUCTO de la 
	 * base de datos de SuperAndes
	 */
	public List<VolumenProducto> darVolumenes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaVolumenProducto());
		q.setResultClass(VolumenProducto.class);
		return (List<VolumenProducto>) q.executeList();
	}
}
