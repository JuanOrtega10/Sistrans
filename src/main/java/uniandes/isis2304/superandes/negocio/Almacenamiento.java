
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
 * Clase para modelar el concepto Almacenamiento del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */

public abstract class Almacenamiento implements VOAlmacenamiento
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO del almacenamiento.
	 */
	private long id;
	
	/**
	 * El volumen máximo soportado por el almacenamiento.
	 */
	private double volumenMax;
	
	/**
	 * El peso máximo soportado por el almacenamiento.
	 */
	private double pesoMax;
	
	/**
	 * La cantidad máxima de productos soportado por el almacenamiento.
	 */
	private int cantidadMax;
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public Almacenamiento() 
    {
    	this.id = 0;
		this.volumenMax = 0;
		this.pesoMax = 0;
		this.cantidadMax = 0;
		
	}

	/**
	 * Constructor con valores
	 * @param id - El id del almacenamiento
	 * @param volumenMax - El volumen máximo soportado por el almacenamiento
	 * @param pesoMax - El peso máximo soportado por el almacenamiento
	 * @param cantidadMax - La cantidad máxima de productos soportada por el almacenamiento
	 */
    public Almacenamiento(long id, double volumenMax, double pesoMax, int cantidadMax) 
    {
    	this.id = id;
		this.volumenMax = volumenMax;
		this.pesoMax = pesoMax;
		this.cantidadMax = cantidadMax;
	}
    
    /**
   	 * @return El id del almacenamiento
   	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id - El nuevo id del almacenamiento
	 */
	public void setId(long id) {
		this.id = id;
	}

	 /**
	  * @return El volumen máximo
	  */	
	public double getVolumenMax() {
		return volumenMax;
	}

	/**
	 * @param id - El nuevo volumen máximo del almacenamiento
	 */
	public void setVolumenMax(double volumenMax) {
		this.volumenMax = volumenMax;
	}
	
	 /**
	  * @return El peso máximo
	  */
	public double getPesoMax() {
		return pesoMax;
	}

	/**
	 * @param id - El nuevo peso máximo del almacenamiento
	 */
	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}
	
	 /**
	  * @return La cantidad máxima
	  */
	public int getCantidadMax() {
		return cantidadMax;
	}

	/**
	 * @param id - La nueva cantidad máxima de productos soportada por el almacenamiento
	 */
	public void setCantidadMax(int cantidadMax) {
		this.cantidadMax = cantidadMax;
	}
	

}

