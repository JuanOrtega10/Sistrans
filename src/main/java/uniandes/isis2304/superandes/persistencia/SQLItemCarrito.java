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

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superandes.negocio.Factura;
import uniandes.isis2304.superandes.negocio.ItemCarrito;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Carrito de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLItemCarrito 
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
	public SQLItemCarrito (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}



	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ALMACENAMIENTO a la base de datos de SuperAndes
	 * @throws Exception 
	 */
	public long adicionarItemCarrito (PersistenceManager pm, long id, long idCarrito, String idProducto, BigDecimal cantidad, long idEstante) throws Exception 
	{	

		//Verificar que es un nuevo producto el que está añadiendo, sino, se debe añadir a un itemCarrito existente.
		Query verificar = pm.newQuery(SQL, "SELECT count(*) FROM " + ps.darTablaItemCarrito() + " WHERE idProducto = ? AND idCarrito = ? ");
		verificar.setParameters(idProducto, idCarrito);
		BigDecimal hay = (BigDecimal) verificar.executeUnique();

		
		Query volumen = pm.newQuery(SQL, "SELECT IDVOLUMENPRODUCTO FROM (" + ps.darTablaEstante()+ " INNER JOIN " + ps.darTablaAlmacenamiento()+ " ON "+ps.darTablaEstante()+".IDALMACENAMIENTO = "+ps.darTablaAlmacenamiento()+".ID ) WHERE id = ? ");
		volumen.setParameters(idEstante);
		BigDecimal idVolumen = (BigDecimal) volumen.executeUnique();
		System.out.println("El id del volProd es : " + idVolumen);


		Query actualizar = pm.newQuery(SQL, "UPDATE " + ps.darTablaVolumenProducto() + " SET cantidad = cantidad - ? WHERE id  = ? and idProducto = ?");
		actualizar.setParameters(cantidad,idVolumen, idProducto);
		long actualizadas = (long) actualizar.executeUnique();
		
		if(actualizadas == 0) throw new Exception("El estante seleccionado no tiene ese producto");


		if(hay.intValue() == 1) {
			//Debo solo actualizar la cantidad del item ya creado
			Query q = pm.newQuery(SQL, "UPDATE " + ps.darTablaItemCarrito() + " SET cantidad = cantidad + ?");
			q.setParameters(cantidad);
			return (long) q.executeUnique();

		}

		else {
			Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaItemCarrito() + "(id, idCarrito, idProducto, cantidad, idEstante) values (?, ?, ?, ?, ?)");
			q.setParameters(id,idCarrito, idProducto,cantidad, idEstante);
			return (long) q.executeUnique();
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ALMACENAMIENTO de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public ItemCarrito darItemCarritoPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaItemCarrito( ) + " WHERE id = ?");
		q.setResultClass(Factura.class);
		q.setParameters(id);
		return (ItemCarrito) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ALMACENAMIENTO de la 
	 * base de datos de SuperAndes
	 */
	public List<ItemCarrito> darItemCarritos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaItemCarrito());
		q.setResultClass(Factura.class);
		return (List<ItemCarrito>) q.executeList();
	}

	public long eliminarItemCarrito (PersistenceManager pm, long idCarrito, String idProducto, long idEstante )
	{


		Query volumen = pm.newQuery(SQL, "SELECT IDVOLUMENPRODUCTO FROM " + ps.darTablaAlmacenamiento() + " WHERE id = ?");
		volumen.setParameters(idEstante);

		BigDecimal idVolumen = (BigDecimal) volumen.executeUnique();
		System.out.println("El id del volProd es : " + idVolumen);


		Query items = pm.newQuery(SQL, "SELECT * "
				+ "FROM " + ps.darTablaItemCarrito() + " WHERE idProducto = ? AND idCarrito = ?");
		items.setParameters(idProducto, idCarrito);
		items.setResultClass(ItemCarrito.class);

		ItemCarrito itemCarrito = (ItemCarrito) items.executeUnique();


		Query actualizar = pm.newQuery(SQL, "UPDATE " + ps.darTablaVolumenProducto() + " SET cantidad = cantidad + ? WHERE id  = ?");
		actualizar.setParameters(itemCarrito.getCantidad(),idVolumen);


		actualizar.executeUnique();


		Query q = pm.newQuery(SQL, "DELETE FROM " +ps.darTablaItemCarrito() + " WHERE idCarrito  = ? AND idProducto = ?");
		q.setParameters(idCarrito, idProducto);
		return (long) q.executeUnique();            
	}

	public long actualizarCantidadItemCarrito (PersistenceManager pm, long idCarrito, String idProducto, BigDecimal aDevolver, long idEstante) 
	{
		Query volumen = pm.newQuery(SQL, "SELECT IDVOLUMENPRODUCTO FROM " + ps.darTablaAlmacenamiento() + " WHERE id = ?");
		volumen.setParameters(idEstante);
		BigDecimal idVolumen = (BigDecimal) volumen.executeUnique();	

		System.out.println("El id del volProd es : " + idVolumen);


		Query actualizar = pm.newQuery(SQL, "UPDATE " + ps.darTablaVolumenProducto() + " SET cantidad = cantidad + ? WHERE id  = ?");
		actualizar.setParameters(aDevolver,idVolumen);
		actualizar.executeUnique();

		Query q = pm.newQuery(SQL, "UPDATE " + ps.darTablaItemCarrito() + " SET cantidad = cantidad - ? WHERE idCarrito  = ? AND idProducto = ?");
		q.setParameters(aDevolver, idCarrito,idProducto);
		return (long) q.executeUnique();            
	}
}
