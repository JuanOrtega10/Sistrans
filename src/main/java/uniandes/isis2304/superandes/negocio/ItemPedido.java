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

import java.sql.Timestamp;

/**
 * Clase para modelar el concepto ItemPedido de un producto del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class ItemPedido implements VOItemPedido
{
	
	/**
	 * El identificador ÚNICO del ItemPedido.
	 */
	private long id;
	
	/**
	 * El identificador ÚNICO del pedido al que pertenece.
	 */
	private long idPedido;


	
	/**
	 * La cantidad de items en el pedido
	 */
	private int cantidad;
	
	
	/**
	 * La fecha de vencimiento de los items del pedido
	 */
	private Timestamp fechaVencimiento;
	
	/**
	 * El id del producto
	 */
	private String idProducto;
	
	/**
	 * El precio de venta del producto
	 */
	private double precioCompra;
	
	/**
	 * El precio de venta del producto
	 */
	private double precioVenta;
	
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ItemPedido() 
    {
    	this.id = 0;
    	this.cantidad = 0;
    	this.fechaVencimiento = null;
    	this.idProducto ="";
    	this.precioCompra = 0;
    	this.precioVenta = 0;
	}


	/**
	 * @param id
	 * @param cantidad
	 * @param fechaVencimiento
	 */
	public ItemPedido(long id, int cantidad, Timestamp fechaVencimiento, String idProducto, double precioCompra, double precioVenta) {
		this.id = id;
		this.cantidad = cantidad;
		this.fechaVencimiento = fechaVencimiento;
		this.idProducto = idProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
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
	public Timestamp getFechaVencimiento() {
		return fechaVencimiento;
	}


	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Timestamp fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	/**
	 * @return the idProducto
	 */
	public String getIdProducto() {
		return idProducto;
	}


	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	/**
	 * @return the precioCompra
	 */
	public double getPrecioCompra() {
		return precioCompra;
	}


	/**
	 * @param precioCompra the precioCompra to set
	 */
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}


	/**
	 * @return the precioVenta
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}


	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	/**
	 * @return the idPedido
	 */
	public long getIdPedido() {
		return idPedido;
	}


	/**
	 * @param idItemPedido the idItemPedido to set
	 */
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", idPedido=" + idPedido + ", cantidad=" + cantidad
				+ ", fechaVencimiento=" + fechaVencimiento + ", idProducto=" + idProducto + ", precioCompra="
				+ precioCompra + ", precioVenta=" + precioVenta + "]";
	}


	

	

	
	
	
}

