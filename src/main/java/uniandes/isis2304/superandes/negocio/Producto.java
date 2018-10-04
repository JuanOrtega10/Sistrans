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
 * Clase para modelar el concepto Producto del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class Producto implements VOProducto
{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El ID UNICO del producto.
	 */
	private String id;
	

	/**
	 * El nombre del producto.
	 */
	private String nombre;
	
	
	/**
	 * La marca del producto.
	 */
	private String marca;
	

	/**
	 * El precio por unidad del producto
	 */
	private double precioUnitario;
	

	/**
	 * La presentación del producto.
	 */
	private String presentacion;
	

	/**
	 * Precio por unidad de medida.
	 */
	private double precioUnidadMedida;

	
	/**
	 * cantidad.
	 */
	private double cantidad;
	

	/**
	 * La unidad de medida para el producto, solo puede ser gr o ml.
	 */
	private String unidadMedida;
	

	/**
	 * La especificación del empaque.
	 */
	private double especificacionEmpaque;
	
	/**
	 * Atributo que indica si el producto es exclusivo o no.
	 */
	private int exclusivo;
	
	
	/**
	 * La fecha de vencimiento del producto (si es perecedero).
	 */
	private Date fechaVencimiento;
	
	/**
	 * El ID del tipo del producto.
	 */
	private long idTipoProducto;
	
	/**
	 * El ID de la categoria del producto.
	 */
	private long idCategoria;
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public Producto() 
    {
    	this.id = "";
    	this.nombre = "";
    	this.marca = "";
    	this.precioUnitario = 0;
    	this.presentacion = "";
    	this.precioUnidadMedida = 0;
    	this.cantidad = 0;
    	this.unidadMedida = "";
    	this.especificacionEmpaque = 0;
    	this.exclusivo = 0;
    	this.fechaVencimiento = new Date();
    	this.idCategoria = 0;
    	this.idTipoProducto = 0;
    	
	}
	
	/**
	 * Constructor con valores
	 * @param codigo - El id del producto
	 * @param nombre - El nombre del producto.
	 * @param marca - La marca del producto.
	 * @param precioUnitario - Precio unitario de un producto.
	 * @param presentacion - La presentación del producto.
	 * @param precioUnidadMedida - El precio por unidad de medida.
	 * @param cantidad - La cantidad del producto de gm o ml
	 * @param unidadMedida - La unidad de medida del producto
	 * @param especificacionEmpaque - Especificación del empaque
	 * @param exclusivo - Indica si el producto es exclusivo
	 * @param fechaVencimiento - La fecha de vencimiento del producto (si es perecedero).
	 */
	
	
    public Producto(String codigo, String nombre, String marca, double precioUnitario, String presentacion, double precioUnidadMedida, double cantidad, String unidadMedida, double especificacionEmpaque, int exclusivo, Date fechaVencimiento, long idCategoria, long idTipoProducto) 
    {
    	this.id = codigo;
    	this.nombre = nombre;
    	this.marca = marca;
    	this.precioUnitario = precioUnitario;
    	this.presentacion = presentacion;
    	this.precioUnidadMedida = precioUnidadMedida;
    	this.cantidad = cantidad;
    	this.unidadMedida = unidadMedida;
    	this.especificacionEmpaque = especificacionEmpaque;
    	this.exclusivo = exclusivo;
    	this.fechaVencimiento = fechaVencimiento;
    	this.idCategoria = idCategoria;
    	this.idTipoProducto = idTipoProducto;
	}

	

	/**
	 * @return the codigo
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setId(String codigo) {
		this.id = codigo;
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

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the precioUnitario
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * @return the presentacion
	 */
	public String getPresentacion() {
		return presentacion;
	}

	/**
	 * @param presentacion the presentacion to set
	 */
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	/**
	 * @return the precioUnidadMedida
	 */
	public double getPrecioUnidadMedida() {
		return precioUnidadMedida;
	}

	/**
	 * @param precioUnidadMedida the precioUnidadMedida to set
	 */
	public void setPrecioUnidadMedida(double precioUnidadMedida) {
		this.precioUnidadMedida = precioUnidadMedida;
	}

	/**
	 * @return the cantidad
	 */
	public double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the unidadMedida
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	/**
	 * @return the especificacionEmpaque
	 */
	public double getEspecificacionEmpaque() {
		return especificacionEmpaque;
	}

	/**
	 * @param especificacionEmpaque the especificacionEmpaque to set
	 */
	public void setEspecificacionEmpaque(double especificacionEmpaque) {
		this.especificacionEmpaque = especificacionEmpaque;
	}

	/**
	 * @return the exclusivo
	 */
	public int getExclusivo() {
		return exclusivo;
	}

	/**
	 * @param exclusivo the exclusivo to set
	 */
	public void setExclusivo(int exclusivo) {
		this.exclusivo = exclusivo;
	}

	/**
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * @return the idTipoProducto
	 */
	public long getIdTipoProducto() {
		return idTipoProducto;
	}

	/**
	 * @param idTipoProducto the idTipoProducto to set
	 */
	public void setIdTipoProducto(long idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	/**
	 * @return the idCategoria
	 */
	public long getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Producto [codigo=" + id + ", nombre=" + nombre + ", marca=" + marca + ", precioUnitario="
				+ precioUnitario + ", presentacion=" + presentacion + ", precioUnidadMedida=" + precioUnidadMedida
				+ ", cantidad=" + cantidad + ", unidadMedida=" + unidadMedida + ", especificacionEmpaque="
				+ especificacionEmpaque + ", exclusivo=" + exclusivo + ", fechaVencimiento=" + fechaVencimiento
				+ ", idTipoProducto=" + idTipoProducto + ", idCategoria=" + idCategoria + "]";
	}
    
	
    
}

