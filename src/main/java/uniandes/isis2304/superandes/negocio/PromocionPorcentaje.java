
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
import java.util.Date;

/**
 * Clase para modelar el concepto de la promoción "Promocion Porcentaje" del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class PromocionPorcentaje extends Promocion implements VOPromocionPorcentaje
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El descuento en porcentaje aplicado sobre el producto
	 */
	
	private double descuento;
	

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public PromocionPorcentaje() 
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
	public PromocionPorcentaje(long id, long idSucursal, long idProducto, Date fechaExpiracion, double descuento) {
		
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PromocionPorcentaje [descuento=" + descuento + super.toString() + "]";
	}
	


}

