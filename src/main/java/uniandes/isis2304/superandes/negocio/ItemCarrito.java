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

package uniandes.isis2304.superandes.negocio;


/**
 * Clase para modelar el concepto ItemCarrito de un producto del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class ItemCarrito implements VOItemCarrito
{
	
	/**
	 * El identificador ÚNICO del ItemPedido.
	 */
	private long id;

	
	/**
	 * La cantidad de items en el pedido
	 */
	private int cantidad;
	
	
	/**
	 * La id del producto que contienen.
	 */
	private long idProducto;
	
	/**
	 * La id del producto que contienen.
	 */
	private long idCarrito;
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ItemCarrito() 
    {
    	this.id = 0;
    	this.cantidad = 0;
    	this.idProducto = 0;
    	this.idCarrito = 0;
	}


	/**
	 * @param id
	 * @param cantidad
	 * @param fechaVencimiento
	 */
	public ItemCarrito(long id, int cantidad, long idProducto, long idCarrito) {
		this.id = id;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		this.idCarrito = idCarrito;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}


	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	/**
	 * @return the fechaVencimiento
	 */
	public long getIdProducto() {
		return idProducto;
	}


	/**
	 * @param idProducto the fechaVencimiento to set
	 */
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	
	


	/**
	 * @return the idCarrito
	 */
	public long getIdCarrito() {
		return idCarrito;
	}


	/**
	 * @param idCarrito the idCarrito to set
	 */
	public void setIdCarrito(long idCarrito) {
		this.idCarrito = idCarrito;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemCarrito [id=" + id + ", cantidad=" + cantidad + ", idProducto=" + idProducto + ", idCarrito="
				+ idCarrito + "]";
	}		
	
	
	
}

