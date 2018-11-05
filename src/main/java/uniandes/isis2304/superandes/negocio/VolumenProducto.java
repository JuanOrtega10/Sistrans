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
	 * El identificador ÚNICO del volumenProducto.
	 */
	private long id;
	

	
	
	/**
	 * La cantidad de productos.
	 */
	private int cantidad;
	
	
	/**
	 * La cantidad de productos.
	 */
	private String idProducto;
	
	/**
	 * El peso de los productos.
	 */
	private double peso;
	
	
	/**
	 * El volumen de los productos.
	 */
	private double volumen;
	
	/**
	 * El volumen de los productos.
	 */
	private long idItemPedido;
	
	
	public VolumenProducto(){
		this.id = 0;
		this.idProducto = "";
		this.cantidad = 0;
		this.peso = 0;
		this.volumen = 0;
		this.idItemPedido = 0;
	}



	/**
	 * @param id
	 * @param idTipoProducto
	 * @param cantidad
	 * @param peso
	 * @param volumen
	 */
	public VolumenProducto(long id,String idProducto,
			int cantidad, double peso, double volumen, long idItemPedido) {
		this.id = id;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.peso = peso;
		this.volumen = volumen;
		this.idItemPedido = idItemPedido;
	}



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
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
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the idItemPedido
	 */
	public long getIdItemPedido() {
		return idItemPedido;
	}



	/**
	 * @param idItemPedido the idItemPedido to set
	 */
	public void setIdItemPedido(long idItemPedido) {
		this.idItemPedido = idItemPedido;
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



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VolumenProducto [id=" + id + ", cantidad=" + cantidad + ", idProducto=" + idProducto + ", peso=" + peso
				+ ", volumen=" + volumen + ", idItemPedido=" + idItemPedido + "]";
	}






	

	
}

