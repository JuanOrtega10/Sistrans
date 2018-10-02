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
 * Clase para modelar el concepto Categoria de un producto del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */

public class Categoria implements VOCategoria
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO de la categoria.
	 */
	private long id;
	
	
	/**
	 * El nombre de la categoria. Puede ser (PERECEDEROS, NO_PERECEDEROS, ASEO, ABARROTES, CONGELADOS, PRENDAS_DE_VESTIR, MUEBLES, HERRAMIENTAS, ELECTRODOMESTICOS)
	 */
	
	private String nombre;
	
	
	

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Categoria() 
    {
    	this.id = 0;
		this.nombre = "";
	}
	
	
	/**
	 * Constructor con valores
	 * @param id - El id de la categoria
	 * @param nombre - El nombre de la categoria.
	 */
    public Categoria(long id, String nombre)
    {
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
    
	@Override
	public String toString() 
	{
		return "Categoria [Id =" + id
				+ ", Nombre =" + this.nombre + "]";
	}

}

