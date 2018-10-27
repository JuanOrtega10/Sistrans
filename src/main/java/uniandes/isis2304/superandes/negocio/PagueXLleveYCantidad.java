
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
 * Clase para modelar el concepto de la promoción "Pague X lleve Y Cantidad" del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class PagueXLleveYCantidad extends Promocion implements VOPagueXLleveYCantidad
{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * La cantidad de producto que se lleva al precio de Y
	 */
	private double x;
	
	/**
	 * La cantidad de producto que se llevaría si no existiera la promoción
	 */
	private double y;
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public PagueXLleveYCantidad() 
    {
    	super();
    	this.x = 0;
    	this.y = 0;
	}
	
	/**
	 * @param id
	 * @param idSucursal
	 * @param idProducto
	 * @param fechaExpiracion
	 */
	public PagueXLleveYCantidad(long id, long idSucursal, String idProducto, Timestamp fechaExpiracion, double x, double y) {
		
		super(id, idSucursal, idProducto, fechaExpiracion);
		this.x = x;
		this.y = y;
		
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	
	@Override
	public String toString() {
		return "PagueXLleveYCantidad [x=" + x + ", y=" + y + super.toString() + "]";
	}
	
}

