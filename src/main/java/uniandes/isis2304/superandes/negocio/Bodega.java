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
 * Clase para modelar el concepto Bodega del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class Bodega extends Almacenamiento implements VOBodega
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * La dirección local de la Bodega.
	 */
	private String direccion;
	
	

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public Bodega() 
    {
    	super();
		this.direccion = "";
		
	}
	
	
	/**
	 * Constructor con valores
	 * @param id - El id del almacenamiento
	 * @param volumenMax - El volumen máximo soportado por el almacenamiento
	 * @param pesoMax - El peso máximo soportado por el almacenamiento
	 * @param cantidadMax - La cantidad máxima de productos soportada por el almacenamiento
	 */
    public Bodega(long id, double volumenMax, double pesoMax, int cantidadMax, String direccion, long idSuc, long idTipoProd, long idVolProd) 
    {
    	super(id, volumenMax, pesoMax, cantidadMax,idSuc, idTipoProd,idVolProd);
		this.direccion = direccion;
	}
    
    /**
   	 * @return La dirección de la bodega en la sucursal
   	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param id - La nueva dirección de la bodega.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Bodega [Volumen Máximo =" + super.getVolumenMax()
				+ ", Peso Máximo ="  + super.getPesoMax()
				+ ", Cantidad Máxima =" + super.getCantidadMax()
				+ ", Dirección = " + direccion + "]";
	}
	

}

