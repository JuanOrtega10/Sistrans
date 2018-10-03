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
 * Clase para modelar el concepto FACTURA del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class Provee implements VOProvee
{
	
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO del proveedor.
	 */
	private long idProveedor;
	
	/**
	 * El identificador ÚNICO del prodcuto.
	 */
	private long idProducto;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Provee() 
	{
		this.idProducto = 0;
		this.idProveedor = 0;

	}

	/**
	 * Contructor con valores
	 * @param idProveedor
	 * @param idProducto
	 */
	public Provee(long idProveedor, long idProducto) {
		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
	}

	/**
	 * @return the idProveedor
	 */
	public long getIdProveedor() {
		return idProveedor;
	}

	/**
	 * @param idProveedor the idProveedor to set
	 */
	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}

	/**
	 * @return the idProducto
	 */
	public long getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Provee [idProveedor=" + idProveedor + ", idProducto=" + idProducto + "]";
	}
	
	
	
}

