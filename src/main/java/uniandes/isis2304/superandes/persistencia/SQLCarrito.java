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
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superandes.negocio.Carrito;
import uniandes.isis2304.superandes.negocio.Factura;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Carrito de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLCarrito 
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
	public SQLCarrito (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ALMACENAMIENTO a la base de datos de SuperAndes
	 */
	public long solicitarCarrito (PersistenceManager pm, long id, long idSucursal, long idCliente, String estado) 
	{
		System.out.println(ps.darTablaCarrito());
        Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaCarrito() + "(id, idSucursal, idCliente, estado) values (?, ?, ?, ?)");
        q.setParameters(id,idSucursal, idCliente,estado);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ALMACENAMIENTO de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public Carrito darCarritoPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCarrito( ) + " WHERE id = ?");
		q.setResultClass(Factura.class);
		q.setParameters(id);
		return (Carrito) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ALMACENAMIENTO de la 
	 * base de datos de SuperAndes
	 */
	public List<Carrito> darCarritos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCarrito());
		q.setResultClass(Factura.class);
		return (List<Carrito>) q.executeList();
	}
	
	public long eliminarCarrito (PersistenceManager pm, long idCarrito)
	{
		Query sucursal = pm.newQuery(SQL, "SELECT idSucursal FROM " + ps.darTablaCarrito() + " WHERE id = ?");
        sucursal.setParameters(idCarrito);
        BigDecimal idsucursal = (BigDecimal) sucursal.executeUnique();
        System.out.println("La sucursal es : " +idsucursal);
        
        
        Query volumen = pm.newQuery(SQL, "SELECT IDVOLUMENPRODUCTO "
        		+ "FROM (" + ps.darTablaEstante()+ " INNER JOIN " +
        		ps.darTablaAlmacenamiento()+ " ON "+ps.darTablaEstante()+".IDALMACENAMIENTO ="
        				+ " "+ps.darTablaAlmacenamiento()+".ID ) WHERE idSucursal = ?");
        volumen.setParameters(idsucursal);
        List<BigDecimal> idVolumen = new ArrayList();
        idVolumen = volumen.executeList();
        System.out.println("El id del volProd es : " + idVolumen);
        
        for (BigDecimal bigDecimal : idVolumen) {
			System.out.println(bigDecimal.doubleValue());
		}
        
//        Query cantidadActual = pm.newQuery(SQL,"SELECT CANTIDAD FROM "+ ps.darTablaVolumenProducto()+ " WHERE id = ?");
//        cantidadActual.setParameters(idVolumen);
//        BigDecimal cActual = (BigDecimal) cantidadActual.executeUnique();
//        System.out.println("la cantidad Actual es "+ cActual);
//        
//        Query cantidad = pm.newQuery(SQL,"SELECT CANTIDAD FROM "+ ps.darTablaItemCarrito()+ " WHERE idCarrito = ? AND idProducto = ?");
//        cantidad.setParameters(idCarrito);
//        BigDecimal cDevolver = (BigDecimal) cantidad.executeUnique();
//        
//        BigDecimal cNueva = cActual.add(cDevolver);
//        System.out.println("la cantidad nueva es "+ cNueva);
//        
//        
//        Query actualizar = pm.newQuery(SQL, "UPDATE " + ps.darTablaVolumenProducto() + " SET cantidad = ? WHERE id  = ?");
//	    actualizar.setParameters(cNueva,idVolumen);
//	    
//	   
//	    actualizar.executeUnique();
//		
//        Query i = pm.newQuery(SQL, "DELETE FROM " +ps.darTablaItemCarrito() + " WHERE idCarrito  = ?");
//        i.setParameters(idCarrito);
//        i.executeUnique();
//        Query q = pm.newQuery(SQL, "DELETE FROM " +ps.darTablaCarrito() + " WHERE id  = ?");
//        q.setParameters(idCarrito);
//        long ret =(long) q.executeUnique();
//        System.out.println("voy a retornar esto en SQL "+ ret );
//        return ret;
        
        return 0;
	}
}
