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
 * Clase para modelar el concepto VolumenProducto del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */

public class VolumenProducto implements VOVolumenProducto
{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO del reorden.
	 */
	private long id;
	

	/**
	 * El identificador ÚNICO de la factura.
	 */
	private long idFactura;
	

	/**
	 * El identificador ÚNICO del almacenamiento.
	 */
	private long idAlmacenamiento;
	

	/**
	 * El identificador ÚNICO del pedido.
	 */
	private long idPedido;
	

	/**
	 * El identificador ÚNICO del tipoProducto.
	 */
	private long idTipoProducto;
	
	
	/**
	 * La cantidad de productos.
	 */
	private int cantidad;
	
	/**
	 * El peso de los productos.
	 */
	private double peso;
	
	
	/**
	 * El volumen de los productos.
	 */
	private double volumen;
	
	
	/**
	 * El tipo de Volumen.
	 */
	private String tipoVolumen;
	
	
	
	public VolumenProducto(){
		this.id = 0;
		this.idFactura = 0;
		this.idAlmacenamiento = 0;
		this.idPedido = 0;
		this.idTipoProducto = 0;
		this.cantidad = 0;
		this.peso = 0;
		this.volumen = 0;
		this.tipoVolumen = "";
	}



	/**
	 * @param id
	 * @param idFactura
	 * @param idAlmacenamiento
	 * @param idPedido
	 * @param idTipoProducto
	 * @param cantidad
	 * @param peso
	 * @param volumen
	 * @param tipoVolumen
	 */
	public VolumenProducto(long id, long idFactura, long idAlmacenamiento, long idPedido, long idTipoProducto,
			int cantidad, double peso, double volumen, String tipoVolumen) {
		super();
		this.id = id;
		this.idFactura = idFactura;
		this.idAlmacenamiento = idAlmacenamiento;
		this.idPedido = idPedido;
		this.idTipoProducto = idTipoProducto;
		this.cantidad = cantidad;
		this.peso = peso;
		this.volumen = volumen;
		this.tipoVolumen = tipoVolumen;
	}



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}



	/**
	 * @return the idFactura
	 */
	public long getIdFactura() {
		return idFactura;
	}



	/**
	 * @return the idAlmacenamiento
	 */
	public long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}



	/**
	 * @return the idPedido
	 */
	public long getIdPedido() {
		return idPedido;
	}



	/**
	 * @return the idTipoProducto
	 */
	public long getIdTipoProducto() {
		return idTipoProducto;
	}



	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}



	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}



	/**
	 * @return the volumen
	 */
	public double getVolumen() {
		return volumen;
	}



	/**
	 * @return the tipoVolumen
	 */
	public String getTipoVolumen() {
		return tipoVolumen;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}



	/**
	 * @param idFactura the idFactura to set
	 */
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}



	/**
	 * @param idAlmacenamiento the idAlmacenamiento to set
	 */
	public void setIdAlmacenamiento(long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}



	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}



	/**
	 * @param idTipoProducto the idTipoProducto to set
	 */
	public void setIdTipoProducto(long idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}



	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}



	/**
	 * @param volumen the volumen to set
	 */
	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}



	/**
	 * @param tipoVolumen the tipoVolumen to set
	 */
	public void setTipoVolumen(String tipoVolumen) {
		this.tipoVolumen = tipoVolumen;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VolumenProducto [id=" + id + ", idFactura=" + idFactura + ", idAlmacenamiento=" + idAlmacenamiento
				+ ", idPedido=" + idPedido + ", idTipoProducto=" + idTipoProducto + ", cantidad=" + cantidad + ", peso="
				+ peso + ", volumen=" + volumen + ", tipoVolumen=" + tipoVolumen + "]";
	}
	
	

	
}

