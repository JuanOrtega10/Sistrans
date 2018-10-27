
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

/**
 * Clase para modelar el concepto de la promoción "Menor a la suma" del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
package uniandes.isis2304.superandes.negocio;

import java.sql.Timestamp;


public class MenorALaSuma extends Promocion implements VOPromocionMenorALaSuma
{
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	private String idProducto2;
	
	/**
     * Constructor por defecto
     */
	public MenorALaSuma() 
    {
    	super();
	}
	
	/**
	 * @param id
	 * @param idSucursal
	 * @param idProducto
	 * @param fechaExpiracion
	 */
	public MenorALaSuma(long id, long idSucursal, String idProducto, String idProducto2, Timestamp fechaExpiracion) {
		
		super(id, idSucursal, idProducto, fechaExpiracion);
		this.idProducto2 = idProducto2;

	}

	
	
	/**
	 * @return the idProducto2
	 */
	public String getIdProducto2() {
		return idProducto2;
	}

	/**
	 * @param idProducto2 the idProducto2 to set
	 */
	public void setIdProducto2(String idProducto2) {
		this.idProducto2 = idProducto2;
	}

	@Override
	public String toString() {
		return "MenorALaSuma [" + super.toString() + "]";
	}


}

