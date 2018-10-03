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

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superandes.negocio.Pedido;;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto PEDIDO de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLPedido 
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
	public SQLPedido (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ALMACENAMIENTO a la base de datos de SuperAndes
	 */
	public long adicionarPedido (PersistenceManager pm, long id, Date fechaEsperadaEntrega, Date fechaEntrega, double precioAcordado, String estadoPedido, String estadoProducto, long idSucursal,long idProveedor) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaPedido() + "(id, fechaEsperadaEntrega, fechaEntrega, precioAcordado, estadoPedido,estadoProducto, idSucursal, idProveedor) values (?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, fechaEsperadaEntrega,fechaEntrega , precioAcordado,estadoPedido,estadoProducto, idSucursal, idProveedor );
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ALMACENAMIENTO de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public Pedido darPedidoPorId (PersistenceManager pm, long idPedido) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaPedido( ) + " WHERE id = ?");
		q.setResultClass(Pedido.class);
		q.setParameters(idPedido);
		return (Pedido) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ALMACENAMIENTO de la 
	 * base de datos de SuperAndes
	 */
	public List<Pedido> darPedidos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaPedido());
		q.setResultClass(Pedido.class);
		return (List<Pedido>) q.executeList();
	}
}
