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

import java.math.BigDecimal;

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
	private BigDecimal cantidad;
	
	
	/**
	 * La id del producto que contienen.
	 */
	private String idProducto;
	
	/**
	 * La id del producto que contienen.
	 */
	private long idCarrito;
	
	/**
	 * La id del producto que contienen.
	 */
	private long idEstante;
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ItemCarrito() 
    {
    	this.id = 0;
    	this.cantidad = null;
    	this.idProducto = "";
    	this.idCarrito = 0;
    	this.idEstante = 0;
	}


	/**
	 * @param id
	 * @param cantidad
	 * @param fechaVencimiento
	 */
	public ItemCarrito(long id, BigDecimal cantidad, String idProducto, long idCarrito, long idEstante) {
		this.id = id;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		this.idCarrito = idCarrito;
		this.idEstante = idEstante;
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
	public BigDecimal getCantidad() {
		return cantidad;
	}


	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
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


	/**
	 * @return the idEstante
	 */
	public long getIdEstante() {
		return idEstante;
	}


	/**
	 * @param idEstante the idEstante to set
	 */
	public void setIdEstante(long idEstante) {
		this.idEstante = idEstante;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemCarrito [id=" + id + ", cantidad=" + cantidad + ", idProducto=" + idProducto + ", idCarrito="
				+ idCarrito + ", idEstante=" + idEstante +"]";
	}		
	
	
	
}

