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
public class Estante implements VOEstante
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El nivel de abastecimiento del estante
	 */
	private int nivelAbastecimiento;
	
	private long idAlmacenamiento;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	/**
     * Constructor por defecto
     */
	public Estante() 
    {
   
		this.nivelAbastecimiento = 0;
		this.idAlmacenamiento = 0;
		
	}
	
	
	/**
	 * Constructor con valores
	 * @param id - El id del almacenamiento
	 * @param volumenMax - El volumen máximo soportado por el almacenamiento
	 * @param pesoMax - El peso máximo soportado por el almacenamiento
	 * @param cantidadMax - La cantidad máxima de productos soportada por el almacenamiento
	 */
    public Estante(long id, int nivelAbastecimiento) 
    {
    	
		this.nivelAbastecimiento = nivelAbastecimiento;
		this.idAlmacenamiento = id;
	}


	/**
	 * @return the nivelAbastecimiento
	 */
	public int getNivelAbastecimiento() {
		return nivelAbastecimiento;
	}


	/**
	 * @param nivelAbastecimiento the nivelAbastecimiento to set
	 */
	public void setNivelAbastecimiento(int nivelAbastecimiento) {
		this.nivelAbastecimiento = nivelAbastecimiento;
	}


	/**
	 * @return the idAlmacenamiento
	 */
	public long getIdAlmacenamiento() {
		return idAlmacenamiento;
	}


	/**
	 * @param idAlmacenamiento the idAlmacenamiento to set
	 */
	public void setIdAlmacenamiento(long idAlmacenamiento) {
		this.idAlmacenamiento = idAlmacenamiento;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Estante [nivelAbastecimiento=" + nivelAbastecimiento + ", idAlmacenamiento=" + idAlmacenamiento + "]";
	}

    
}

