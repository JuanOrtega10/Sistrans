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
	
	/**
	 * El identificador de la categoria a la que pertenece el tipoProducto.
	 */
	private long idCategoria;
	
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
		this.idCategoria = 0;
	}


	/**
	 * Constructor con valores
	 * @param id
	 * @param nombre
	 */
	public TipoProducto(long id, String nombre, long idCategoria) {
		this.id = id;
		this.nombre = nombre;
		this.idCategoria = idCategoria;
		
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


	/**
	 * @return the idCategoria
	 */
	public long getIdCategoria() {
		return idCategoria;
	}


	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TipoProducto [id=" + id + ", nombre=" + nombre + ", idCategoria=" + idCategoria + "]";
	}
	
	
	
	
}

