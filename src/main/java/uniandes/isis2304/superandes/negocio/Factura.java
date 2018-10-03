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
 * Clase para modelar el concepto FACTURA del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class Factura implements VOFactura
{
	
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO de la factura.
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
	private Date fecha;
	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Factura() 
	{
		this.id = 0;
		this.idSucursal = 0;
		this.idCliente = 0;
		this.fecha = new Date();
	}
	
	/**
	 * Constructor con valores
	 * @param id - El id unico de la facturar
	 * @param idSucursal - El identificador de la  sucursal.
	 * @param idCliente - El id del cliente
	 * @param fecha - La fecha en la que se genera la factura
	 */
	public Factura(long id, long idSucursal, long idCliente, Date fecha) 
	{
		this.id = id;
		this.idSucursal = idSucursal;
		this.idCliente = idCliente;
		this.fecha = fecha;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Factura [id=" + id + ", idSucursal=" + idSucursal + ", idCliente=" + idCliente + ", fecha=" + fecha
				+ "]";
	}

	
}

