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
 * Clase para modelar el concepto Cliente del negocio de superandes.
 *
 * @author ja.ortega - dy.quintero.
 */
public abstract class Cliente implements VOCliente
{
	
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El identificador ÚNICO del cliente.
	 */
	private long id;
	
	/**
	 * @return El nombre del Cliente
	 */
	private String nombre;
	
	
	/**
	 * @return El correo del Cliente
	 */
	private String correo;
	
	/**
	 * @return El correo del Cliente
	 */
	private String password;
	
	
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Cliente() 
    {
    	this.id = 0;
		this.nombre = "";
		this.correo = "";
		this.password = "";
	}
	
	/**
	 * Constructor con valores
	 * @param id - El id del almacenamiento
	 * @param nombre - El nombre del cliente
	 * @param correo - El correo del cliente
	 */
    public Cliente(long id, String nombre, String correo, String password)
    {
    	this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		
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
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}

