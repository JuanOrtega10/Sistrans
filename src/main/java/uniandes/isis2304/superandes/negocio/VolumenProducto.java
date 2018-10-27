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
	
	
	
	public VolumenProducto(){
		this.id = 0;
		this.idTipoProducto = 0;
		this.cantidad = 0;
		this.peso = 0;
		this.volumen = 0;
	}



	/**
	 * @param id
	 * @param idTipoProducto
	 * @param cantidad
	 * @param peso
	 * @param volumen
	 */
	public VolumenProducto(long id,long idTipoProducto,
			int cantidad, double peso, double volumen) {
		this.id = id;
		this.idTipoProducto = idTipoProducto;
		this.cantidad = cantidad;
		this.peso = peso;
		this.volumen = volumen;
	}



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
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
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VolumenProducto [id=" + id + ", idTipoProducto=" + idTipoProducto + ", cantidad=" + cantidad + ", peso="
				+ peso + ", volumen=" + volumen + "]";
	}
	
	

	
}

