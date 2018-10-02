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
 * Interfaz para los métodos get de ALMACENAMIENTO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author ja.ortega
 */
public interface VOAlmacenamiento 
{
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
     /**
	 * @return El id del almacenamiento
	 */
	public long getId();
	
	
	/**
	 * @return El volumen máximo soportado por el almacenamiento
	 */
	public double getVolumenMax();
	
	/**
	 * @return El peso máximo soportado por el almacenamiento
	 */
	public double getPesoMax();
	
	/**
	 * @return La cantidad máxima de productos soportados por el almacenamiento
	 */
	public int getCantidadMax();



}
