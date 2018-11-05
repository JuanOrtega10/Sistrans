/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
SQLFactura.java * Universidad	de	los	Andes	(Bogotá	- Colombia)
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
 * Clase para modelar el concepto Carrito del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class Carrito implements VOCarrito
{
	
	
	
	public final static String EN_USO = "EN_USO";
	

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO del carrito.
	 */
	private long id;
	
	/**
	 * El identificador ÚNICO de la sucursal.
	 */
	private long idSucursal;
	
	/**
	 * El identificador ÚNICO del cliente.
	 */
	private long idCliente;
	
	/**
	 * La fecha en la cual se crea la factura.
	 */
	private String estado;
	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Carrito() 
	{
		this.id = 0;
		this.idSucursal = 0;
		this.idCliente = 0;
		this.estado = "";
	}
	
	/**
	 * Constructor con valores
	 * @param id - El id unico de la facturar
	 * @param idSucursal - El identificador de la  sucursal.
	 * @param idCliente - El id del cliente
	 * @param estado - El estado del Carrito. (En uso, abandonado)
	 */
	public Carrito(long id, long idSucursal, long idCliente) 
	{
		this.id = id;
		this.idSucursal = idSucursal;
		this.idCliente = idCliente;
		this.estado = EN_USO;
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
	 * @return the idCliente
	 */
	public long getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the enUso
	 */
	public static String getEnUso() {
		return EN_USO;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Carrito [id=" + id + ", idSucursal=" + idSucursal + ", idCliente=" + idCliente + ", estado=" + estado
				+ "]";
	}

	

}

