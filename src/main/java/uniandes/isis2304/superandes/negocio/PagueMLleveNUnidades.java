
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
 * Clase para modelar el concepto de la promoción "Pague M lleve N unidades" del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */

public class PagueMLleveNUnidades extends Promocion implements VOPagueMLleveNUnidades
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	
	/**
	 * Los productos que se lleva al precio de M
	 */
	private int n;
	
	/**
	 * Los productos que se llevarían si no hubiera promoción
	 */
	private int m;
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public PagueMLleveNUnidades() 
    {
    	super();
    	this.n = 0;
    	this.m = 0;
	}
	
	/**
	 * @param id
	 * @param idSucursal
	 * @param idProducto
	 * @param fechaExpiracion
	 */
	public PagueMLleveNUnidades(long id, long idSucursal, String idProducto, Timestamp fechaExpiracion, int m, int n) {
		
		super(id, idSucursal, idProducto, fechaExpiracion);
		this.n = n;
		this.m = m;
		
	}

	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}

	/**
	 * @return the m
	 */
	public int getM() {
		return m;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}

	/**
	 * @param m the m to set
	 */
	public void setM(int m) {
		this.m = m;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PagueMLleveNUnidades [n=" + n + ", m=" + m + super.toString() + "]";
	}


}

