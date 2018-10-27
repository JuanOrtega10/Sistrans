
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
 * Clase para modelar el concepto Promocion del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */

public abstract class Promocion implements VOPromocion
{
	

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO de la promoción.
	 */
	private long id;
	
	
	/**
	 * El identificador ÚNICO de la sucursal que tiene la promoción.
	 */
	private long idSucursal;
	
	
	/**
	 * El identificador ÚNICO del producto al cual aplica la promoción.
	 */
	private String idProducto;
	
	
	/**
	 * La fecha de expiración de la promoción.
	 */
	private Timestamp fechaExpiracion;
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public Promocion() 
    {
    	this.id = 0;
		this.idSucursal = 0;
		this.idProducto = "";
		this.fechaExpiracion = new Timestamp(0);
		
	}


	/**
	 * @param id
	 * @param idSucursal
	 * @param idProducto
	 * @param fechaExpiracion
	 */
	public Promocion(long id, long idSucursal, String idProducto, Timestamp fechaExpiracion) {
		
		this.id = id;
		this.idSucursal = idSucursal;
		this.idProducto = idProducto;
		this.fechaExpiracion = fechaExpiracion;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @return the idSucursal
	 */
	public long getIdSucursal() {
		return idSucursal;
	}


	/**
	 * @return the idProducto
	 */
	public String getIdProducto() {
		return idProducto;
	}


	/**
	 * @return the fechaExpiracion
	 */
	public Timestamp getFechaExpiracion() {
		return fechaExpiracion;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}


	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	/**
	 * @param fechaExpiracion the fechaExpiracion to set
	 */
	public void setFechaExpiracion(Timestamp fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "id=" + id + ", idSucursal=" + idSucursal + ", idProducto=" + idProducto
				+ ", fechaExpiracion=" + fechaExpiracion ;
	}
	
	

}

