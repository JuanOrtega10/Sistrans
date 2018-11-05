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
 * Clase para modelar el concepto Pedido de un producto del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class ItemFactura implements VOItemFactura
{
	
	/**
	 * El identificador ÚNICO del ItemPedido.
	 */
	private long id;

	
	/**
	 * La cantidad de items en el pedido
	 */
	private int cantidad;
	
	/**
	 * El id de la factura
	 */
	private long idFactura;
	
	/**
	 * El id del produto
	 */
	private String idProducto;
	
	/**
	 * El precio de venta del produto
	 */
	private double precio;
	
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ItemFactura() 
    {
    	this.id = 0;
    	this.cantidad = 0;
    	this.idFactura = 0;
    	this.idProducto ="";
    	this.precio = 0;
	}


	/**
	 * @param id
	 * @param cantidad
	 * @param IdFactura
	 */
	public ItemFactura(long id, int cantidad, long idFactura, String idProducto, double precio) {
		this.id = id;
		this.cantidad = cantidad;
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.precio = precio;
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
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}


	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	/**
	 * @return the IdFactura
	 */
	public long getIdFactura() {
		return idFactura;
	}


	/**
	 * @param IdFactura the IdFactura to set
	 */
	public void setIdFactura(long IdFactura) {
		this.idFactura = IdFactura;
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
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}


	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemFactura [id=" + id + ", cantidad=" + cantidad + ", idFactura=" + idFactura + ", idProducto="
				+ idProducto + ", precio=" + precio + "]";
	}


	
	

	
	
	
}

