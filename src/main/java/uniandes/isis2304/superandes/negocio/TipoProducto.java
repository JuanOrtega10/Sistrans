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
 * Clase para modelar el concepto TipoProducto del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class TipoProducto implements VOTipoProducto
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO de un TipoProducto.
	 */
	private long id;
	
	/**
	 * El nombre de un TipoProducto.
	 */
	private String nombre;
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public TipoProducto()
	{
		this.id = 0;
		this.nombre = "";
	}


	/**
	 * Constructor con valores
	 * @param id
	 * @param nombre
	 */
	public TipoProducto(long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	
	

	
}

