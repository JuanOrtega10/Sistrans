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
 * Clase para modelar el concepto Reorden del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class Reorden implements VOReorden
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO del reorden.
	 */
	private long id;
	
	/**
	 * El identificador ÚNICO de la sucursal.
	 */
	private long idSucursal;
	
	/**
	 * El identificador ÚNICO del producto.
	 */
	private String idProducto;
	
	/**
	 * El nivel de reorden para un producto en una sucursal.
	 */
	private int nivelReorden;
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Reorden() 
    {
    	this.id = 0;
		this.idSucursal = 0;
		this.idProducto = "";
		this.nivelReorden = 0;
	}
	
	/**
	 * Constructor con valores
	 * @param id - El id del reorden
	 * @param idSucursal - El id de la sucursal
	 * @param idProducto - El id del producto.
	 * @param nivelReorden - El nivel de reorden.
	 */
    public Reorden(long id, long idSucursal, String idProducto, int nivelReorden)
    {
    	this.id = id;
		this.idSucursal = idSucursal;
		this.idProducto = idProducto;
		this.nivelReorden = nivelReorden;
		
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
	 * @return the idSucursal
	 */
	public long getIdSucursal() {
		return idSucursal;
	}

	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}

	/**
	 * @return the idProducto
	 */
	public String getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the nivelReorden
	 */
	public int getNivelReorden() {
		return nivelReorden;
	}

	/**
	 * @param nivelReorden the nivelReorden to set
	 */
	public void setNivelReorden(int nivelReorden) {
		this.nivelReorden = nivelReorden;
	}

	
	@Override
	public String toString() {
		return "Reorden [id=" + id + ", idSucursal=" + idSucursal + ", idProducto=" + idProducto + ", nivelReorden="
				+ nivelReorden + "]";
	}
    
    

}

