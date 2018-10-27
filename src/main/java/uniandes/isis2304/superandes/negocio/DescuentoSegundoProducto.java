
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
 * Clase para modelar el concepto de la promoción "DescuentoSegundoProducto" del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */

public class DescuentoSegundoProducto extends Promocion implements VODescuentoSegundoProducto
{
	/* ****************************************************************
	 * 			Atributoss
	 *****************************************************************/
	
	/**
	 * El descuento aplicado sobre el segundo producto.
	 */
	private double descuento;
	

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public DescuentoSegundoProducto() 
    {
    	super();
    	this.descuento = 0;
	}


	/**
	 * @param id
	 * @param idSucursal
	 * @param idProducto
	 * @param fechaExpiracion
	 */
	public DescuentoSegundoProducto(long id, long idSucursal, String idProducto, Timestamp fechaExpiracion, Double descuento) {
		
		super(id, idSucursal, idProducto, fechaExpiracion);
		this.descuento = descuento;
		
	}


	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return descuento;
	}


	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}


	
	@Override
	public String toString() {
		return "DescuentoSegundoProducto [descuento=" + descuento + super.toString() +"]";
	}
	
	

	
	
}

