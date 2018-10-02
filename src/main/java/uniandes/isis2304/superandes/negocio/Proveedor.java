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
 * Clase para modelar el concepto Proveedor del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */

public class Proveedor implements VOProveedor
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO del Proveedor.
	 */
	private long nit;
	
	
	/**
	 * @return El nombre del Proveedor
	 */
	private String nombre;
	

	/**
	 * @return La calificacion del Proveedor
	 */
	private double calificacion;
	
	/**
	 * @return El numero de calificaciones del Proveedor
	 */
	private int numCalificaciones;
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Proveedor()
	{
		this.nit = 0;
		this.nombre = "";
		this.calificacion = 0;
		this.numCalificaciones = 0;
	}
	
	/**
	 * Constructor con valores
	 * @param pNit - el nit del proveedor
	 * @param pNombre - el nombre del proveedor
	 * @param pCalificacion - calificacion del proveedor
	 * @param pNumCalificaciones - numero de calificaciones del proveedor
	 */
	public Proveedor ( long pNit, String pNombre, double pCalificacion, int pNumCalificaciones )
	{
		this.nit = pNit;
		this.nombre = pNombre;
		this.calificacion = pCalificacion;
		this.numCalificaciones = pNumCalificaciones;
	}

	/**
	 * @return the nit
	 */
	public long getNit() {
		return nit;
	}

	/**
	 * @param nit the nit to set
	 */
	public void setNit(long nit) {
		this.nit = nit;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the calificacion
	 */
	public double getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * @return the numCalificaciones
	 */
	public int getNumCalificaciones() {
		return numCalificaciones;
	}

	/**
	 * @param numCalificaciones the numCalificaciones to set
	 */
	public void setNumCalificaciones(int numCalificaciones) {
		this.numCalificaciones = numCalificaciones;
	}
	

	
}

