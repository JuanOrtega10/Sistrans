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

/**
 * Interfaz para los métodos get de Volumen Producto.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author ja.ortega - dy.quintero
 */
public interface VOVolumenProducto 
{
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/

	/**
	 * @return the id
	 */
	public long getId();
	

	/**
	 * @return the id
	 */
	public long getIdItemPedido();

	
	/**
	 * @return the idTipoProducto
	 */
	public String getIdProducto();



	/**
	 * @return the cantidad
	 */
	public int getCantidad();



	/**
	 * @return the peso
	 */
	public double getPeso();



	/**
	 * @return the volumen
	 */
	public double getVolumen();


	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
