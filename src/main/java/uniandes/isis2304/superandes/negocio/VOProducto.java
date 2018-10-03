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
 * Interfaz para los métodos get de PRODUCTO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author ja.ortega - dy.quintero
 */
public interface VOProducto 
{
	/* ****************************************************************
	 * 	Métodos 
	 *****************************************************************/
	/**
	 * @return the codigo
	 */
	public long getCodigo();

	/**
	 * @return the nombre
	 */
	public String getNombre();

	/**
	 * @return the marca
	 */
	public String getMarca();

	/**
	 * @return the precioUnitario
	 */
	public double getPrecioUnitario();
	/**
	 * @return the presentacion
	 */
	public String getPresentacion();

	/**
	 * @return the precioUnidadMedida
	 */
	public double getPrecioUnidadMedida();

	/**
	 * @return the cantidad
	 */
	public double getCantidad();

	/**
	 * @return the unidadMedida
	 */
	public String getUnidadMedida();

	/**
	 * @return the especificacionEmpaque
	 */
	public double getEspecificacionEmpaque();

	/**
	 * @return the exclusivo
	 */
	public boolean isExclusivo();

	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento();
	
	/**
	 * @return the idTipoProducto
	 */
	public long getIdTipoProducto();
	/**
	 * @return the idCategoria
	 */
	public long getIdCategoria();
	

}