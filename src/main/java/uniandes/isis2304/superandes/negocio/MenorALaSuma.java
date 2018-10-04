
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

import java.util.Date;

public class MenorALaSuma extends Promocion
{
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
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
	public MenorALaSuma(long id, long idSucursal, long idProducto, Date fechaExpiracion) {
		
		super(id, idSucursal, idProducto, fechaExpiracion);

	}

	
	@Override
	public String toString() {
		return "MenorALaSuma [" + super.toString() + "]";
	}


}

