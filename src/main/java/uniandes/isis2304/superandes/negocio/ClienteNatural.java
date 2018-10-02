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
 * Clase para modelar el concepto ClienteNatural del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public class ClienteNatural extends Cliente implements VOClienteNatural
{
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ClienteNatural() 
    {
    	super();
	}
	
	
	/**
	 * Constructor con valores
	 * @param id - El id del almacenamiento
	 * @param nombre - El volumen máximo soportado por el almacenamiento
	 * @param correo - El peso máximo soportado por el almacenamiento
	 */
    public ClienteNatural(long id, String nombre, String correo)
    {
    	super(id, nombre, correo);
	}
    
    /** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Cliente Natural [Cédula=" + super.getId()
				+ ", Nombre ="  + super.getNombre()
				+ ", Correo =" + super.getCorreo() + "]";
	}
}

