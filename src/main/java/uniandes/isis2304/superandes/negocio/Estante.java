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
 * Clase para modelar el concepto Estante del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class Estante extends Almacenamiento
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El nivel de abastecimiento del estante
	 */
	private int nivelAbastecimiento;
	
	

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public Estante() 
    {
    	super();
		this.nivelAbastecimiento = 0;
		
	}
	
	
	/**
	 * Constructor con valores
	 * @param id - El id del almacenamiento
	 * @param volumenMax - El volumen máximo soportado por el almacenamiento
	 * @param pesoMax - El peso máximo soportado por el almacenamiento
	 * @param cantidadMax - La cantidad máxima de productos soportada por el almacenamiento
	 */
    public Estante(long id, double volumenMax, double pesoMax, int cantidadMax, int nivelAbastecimiento) 
    {
    	super(id, volumenMax, pesoMax, cantidadMax);
		this.nivelAbastecimiento = nivelAbastecimiento;
	}
    
    /**
   	 * @return La dirección de la bodega en la sucursal
   	 */
	public int getnivelAbastecimiento() {
		return nivelAbastecimiento;
	}

	/**
	 * @param id - La nueva dirección de la bodega.
	 */
	public void setnivelAbastecimiento(int nivelAbastecimiento) {
		this.nivelAbastecimiento = nivelAbastecimiento;
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
				+ ", Nivel Abastecimiento = " + nivelAbastecimiento + "]";
	}


}

