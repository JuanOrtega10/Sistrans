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
	 */
	public long adicionarItemCarrito (PersistenceManager pm, long id, long idCarrito, String idProducto, BigDecimal cantidad) 
	{	
		
        Query sucursal = pm.newQuery(SQL, "SELECT idSucursal FROM " + ps.darTablaCarrito() + " WHERE id = ?");
        sucursal.setParameters(idCarrito);
        BigDecimal idsucursal = (BigDecimal) sucursal.executeUnique();
        System.out.println("La sucursal es : " +idsucursal);
        
        
        Query volumen = pm.newQuery(SQL, "SELECT IDVOLUMENPRODUCTO FROM (" + ps.darTablaEstante()+ " INNER JOIN " + ps.darTablaAlmacenamiento()+ " ON "+ps.darTablaEstante()+".IDALMACENAMIENTO = "+ps.darTablaAlmacenamiento()+".ID ) WHERE idSucursal = ?");
        volumen.setParameters(idsucursal);
        BigDecimal idVolumen = (BigDecimal) volumen.executeUnique();
        System.out.println("El id del volProd es : " + idVolumen);
        
        
//        
//        Query cantidadActual = pm.newQuery(SQL,"SELECT CANTIDAD FROM "+ ps.darTablaVolumenProducto()+ " WHERE id = ?");
//        cantidadActual.setParameters(idVolumen);
//        BigDecimal cActual = (BigDecimal) cantidadActual.executeUnique();
//        System.out.println("la cantidad Actual es "+ cActual);
//        
//        BigDecimal cNueva = cActual.subtract(cantidad);
//        System.out.println("la cantidad nueva es "+ cNueva);
        
        
        Query actualizar = pm.newQuery(SQL, "UPDATE " + ps.darTablaVolumenProducto() + " SET cantidad = cantidad - ? WHERE id  = ?");
	    actualizar.setParameters(cantidad,idVolumen);
	    
	   
	    actualizar.executeUnique();
	  
        System.out.println(" voy a insertar el itemCarrito");
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaItemCarrito() + "(id, idCarrito, idProducto, cantidad) values (?, ?, ?, ?)");
        q.setParameters(id,idCarrito, idProducto,cantidad);
        return (long) q.executeUnique();
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
	public List<Factura> darItemCarritos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaItemCarrito());
		q.setResultClass(Factura.class);
		return (List<Factura>) q.executeList();
	}
	
	public long eliminarItemCarrito (PersistenceManager pm, long idCarrito, String idProducto )
	{
		Query sucursal = pm.newQuery(SQL, "SELECT idSucursal FROM " + ps.darTablaCarrito() + " WHERE id = ?");
        sucursal.setParameters(idCarrito);
        BigDecimal idsucursal = (BigDecimal) sucursal.executeUnique();
        System.out.println("La sucursal es : " +idsucursal);
        
        
        Query volumen = pm.newQuery(SQL, "SELECT IDVOLUMENPRODUCTO FROM (" + ps.darTablaEstante()+ " INNER JOIN " + ps.darTablaAlmacenamiento()+ " ON "+ps.darTablaEstante()+".IDALMACENAMIENTO = "+ps.darTablaAlmacenamiento()+".ID ) WHERE idSucursal = ?");
        volumen.setParameters(idsucursal);
        BigDecimal idVolumen = (BigDecimal) volumen.executeUnique();
        System.out.println("El id del volProd es : " + idVolumen);
        
        
        
        Query cantidadActual = pm.newQuery(SQL,"SELECT CANTIDAD FROM "+ ps.darTablaVolumenProducto()+ " WHERE id = ?");
        cantidadActual.setParameters(idVolumen);
        BigDecimal cActual = (BigDecimal) cantidadActual.executeUnique();
        System.out.println("la cantidad Actual es "+ cActual);
        
        Query cantidad = pm.newQuery(SQL,"SELECT CANTIDAD FROM "+ ps.darTablaItemCarrito()+ " WHERE idCarrito = ? AND idProducto = ?");
        cantidad.setParameters(idCarrito,idProducto);
        BigDecimal cDevolver = (BigDecimal) cantidad.executeUnique();
        
        BigDecimal cNueva = cActual.add(cDevolver);
        System.out.println("la cantidad nueva es "+ cNueva);
        
        
        Query actualizar = pm.newQuery(SQL, "UPDATE " + ps.darTablaVolumenProducto() + " SET cantidad = ? WHERE id  = ?");
	    actualizar.setParameters(cNueva,idVolumen);
	    
	   
	    actualizar.executeUnique();
	  
		
        Query q = pm.newQuery(SQL, "DELETE FROM " +ps.darTablaItemCarrito() + " WHERE idCarrito  = ? AND idProducto = ?");
        q.setParameters(idCarrito, idProducto);
        return (long) q.executeUnique();            
	}
	
	public long actualizarCantidadItemCarrito (PersistenceManager pm, long idCarrito, String idProducto, BigDecimal aDevolver) 
	{
		Query sucursal = pm.newQuery(SQL, "SELECT idSucursal FROM " + ps.darTablaCarrito() + " WHERE id = ?");
        sucursal.setParameters(idCarrito);
        BigDecimal idsucursal = (BigDecimal) sucursal.executeUnique();
        
        
        Query volumen = pm.newQuery(SQL, "SELECT IDVOLUMENPRODUCTO FROM (" + ps.darTablaEstante()+ " INNER JOIN " + ps.darTablaAlmacenamiento()+ " ON "+ps.darTablaEstante()+".IDALMACENAMIENTO = "+ps.darTablaAlmacenamiento()+".ID ) WHERE idSucursal = ?");
        volumen.setParameters(idsucursal);
        BigDecimal idVolumen = (BigDecimal) volumen.executeUnique();
        
        
        
        Query cantidadActual = pm.newQuery(SQL,"SELECT CANTIDAD FROM "+ ps.darTablaVolumenProducto()+ " WHERE id = ?");
        cantidadActual.setParameters(idVolumen);
        BigDecimal cActual = (BigDecimal) cantidadActual.executeUnique();
		
		 Query x = pm.newQuery(SQL, "SELECT CANTIDAD FROM " + ps.darTablaItemCarrito() + " WHERE idCarrito  = ? AND idProducto = ?");
		 x.setParameters(idCarrito,idProducto);
		 BigDecimal cantidadOriginal = (BigDecimal) x.executeUnique();
		 
		 
		 BigDecimal cantidadNueva = cantidadOriginal.subtract(aDevolver);
		 BigDecimal act = cActual.add(aDevolver);
		 
		 Query actualizar = pm.newQuery(SQL, "UPDATE " + ps.darTablaVolumenProducto() + " SET cantidad = ? WHERE id  = ?");
		 actualizar.setParameters(act,idVolumen);
		    
		   
		 actualizar.executeUnique();
		 
		 Query q = pm.newQuery(SQL, "UPDATE " + ps.darTablaItemCarrito() + " SET cantidad = ? WHERE idCarrito  = ? AND idProducto = ?");
	     q.setParameters(cantidadNueva, idCarrito,idProducto);
	     return (long) q.executeUnique();            
	}
}
