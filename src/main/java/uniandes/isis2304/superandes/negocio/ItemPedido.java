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
 * Clase para modelar el concepto Pedido de un producto del negocio de superandes.
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
	 * La cantidad de items en el pedido
	 */
	private int cantidad;
	
	
	/**
	 * La fecha de vencimiento de los items del pedido
	 */
	private Timestamp fechaVencimiento;
	
	
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
	}


	/**
	 * @param id
	 * @param cantidad
	 * @param fechaVencimiento
	 */
	public ItemPedido(long id, int cantidad, Timestamp fechaVencimiento) {
		this.id = id;
		this.cantidad = cantidad;
		this.fechaVencimiento = fechaVencimiento;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", cantidad=" + cantidad + ", fechaVencimiento=" + fechaVencimiento + "]";
	}		
	
	
	
}

