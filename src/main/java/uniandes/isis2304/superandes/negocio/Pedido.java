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
 * Clase para modelar el concepto Pedido de un producto del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class Pedido implements VOPedido
{
	
	public final static String EN_CAMINO = "EN_CAMINO";
	
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO del Pedido.
	 */
	private long id;
	

	/**
	 * La fecha esperada de entrega del pedido
	 */
	
	private Date fechaEsperadaEntrega;
	
	/**
	 * La fecha de entrega del pedido
	 */
	
	private Date fechaEntrega;
	
	/**
	 * El precio acordado entre el proveedor y la sucursal para el pedido
	 */
	
	private double precioAcordado;
	
	/**
	 * El estado actual del pedido, puede ser EN_CAMINO o ENTREGADO
	 */
	
	private String estado;
	
	/**
	 * El identificador de la sucursal que realiza el pedido
	 */
	private long idSucursal;
	
	/**
	 * El identificador del proveedor al que se le hace el pedido
	 */
	private long idProveedor;
	

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Pedido() 
    {
    	this.id = 0;
		this.fechaEsperadaEntrega = new Date();
		this.fechaEntrega = new Date();
		this.precioAcordado = 0;
		this.estado = "";
		this.idSucursal = 0;
		this.idProveedor = 0;
	}

	
	/**
	 * Constructor con valores
	 * @param id - El id de la bebida
	 * @param fechaEsperadaEntrega - La fecha esperada de entrega del pedido.
	 * @param fechaEntrega - La fecha de entrega del producto
	 * @param precioAcordado - El precio acordado entre la sucursal y el proveedor
	 * @param estado - El estado actual del pedido
	 */
	public Pedido(long id, Date fechaEsperadaEntrega, double precioAcordado, long idSucursal, long idProveedor) 
	{
		this.id = id;
		this.fechaEsperadaEntrega = fechaEsperadaEntrega;
		this.precioAcordado = precioAcordado;
		this.estado = EN_CAMINO;
		this.idSucursal = idSucursal;
		this.idProveedor = idProveedor;
		//A esta instancia, el pedido todavia no tiene fecha de entrega
		this.fechaEntrega = new Date();
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
	 * @return the fechaEsperadaEntrega
	 */
	public Date getFechaEsperadaEntrega() {
		return fechaEsperadaEntrega;
	}


	/**
	 * @param fechaEsperadaEntrega the fechaEsperadaEntrega to set
	 */
	public void setFechaEsperadaEntrega(Date fechaEsperadaEntrega) {
		this.fechaEsperadaEntrega = fechaEsperadaEntrega;
	}


	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}


	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	/**
	 * @return the precioAcordado
	 */
	public double getPrecioAcordado() {
		return precioAcordado;
	}


	/**
	 * @param precioAcordado the precioAcordado to set
	 */
	public void setPrecioAcordado(double precioAcordado) {
		this.precioAcordado = precioAcordado;
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


	@Override
	public String toString() 
	{
		return "Pedido [id=" + id 
				+ ", Fecha esperada entrega =" + this.fechaEsperadaEntrega 
				+ ", Fecha entrega=" + this.fechaEntrega 
				+ ", Precio Acordado =" + this.precioAcordado
				+ ", Estado =" + this.estado
				+ "]";
	}
	
}

