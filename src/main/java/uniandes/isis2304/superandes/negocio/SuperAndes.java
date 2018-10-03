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

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;

import uniandes.isis2304.superandes.persistencia.PersistenciaParranderos;
import uniandes.isis2304.superandes.persistencia.PersistenciaSuperAndes;

/**
 * Clase principal del negocio SuperAndes
 * Satisface todos los requerimientos funcionales del negocio
 *
 * @author ja.ortega - dy.quintero.
 */
public class SuperAndes {

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(Parranderos.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaSuperAndes ps;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public SuperAndes ()
	{
		ps = PersistenciaSuperAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public SuperAndes (JsonObject tableConfig)
	{
		ps = PersistenciaSuperAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		ps.cerrarUnidadPersistencia ();
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar las SUCURSALES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una sucursal 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del sucursal
	 * @param direccion - La direccionde la sucursal
	 * @param ciudad - La ciudad de la sucursal
	 * @return El objeto Sucursal adicionado. null si ocurre alguna Excepción
	 */
	public Sucursal adicionarSucursal (String nombre, String direccion, String ciudad)
	{
        log.info ("Adicionando Sucursal: " + nombre);
        Sucursal sucursal = ps.adicionarSucursal (nombre, direccion, ciudad);
        log.info ("Adicionando Sucursal: " + sucursal);
        return sucursal;
	}
	
	/**
	 * Encuentra una Sucursal y su información básica, según su identificador
	 * @param idSucursal - El identificador de la sucursal buscada
	 * @return Un objeto Sucursal que corresponde con el identificador buscado y lleno con su información básica
	 * 			null, si una sucursal con dicho identificador no existe
	 */
	public Sucursal darSucursalPorId (long idSucursal)
	{
        log.info ("Dar información de una sucursal por id: " + idSucursal);
        Sucursal sucursal = ps.darSucursalPorId (idSucursal);
        log.info ("Buscando sucursal por Id: " + sucursal != null ? sucursal : "NO EXISTE");
        return sucursal;
	}
	
	/**
	 * Encuentra todos las sucursales en SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Sucursal con todos las Sucursales que conoce la aplicación, llenos con su información básica
	 */
	public List<Sucursal> darSucursales ()
	{
        log.info ("Listando Sucursales");
        List<Sucursal> sucursales = ps.darSucursales ();	
        log.info ("Listando Sucursales: " + sucursales.size() + " sucursales existentes");
        return sucursales;
	}

	/**
	 * Encuentra todos los bares en Parranderos y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Sucursal con todos las sucursales que conoce la aplicación, llenos con su información básica
	 */
	public List<VOSucursal> darVOSucursales ()
	{
		log.info ("Generando los VO de Sucursales");
		List<VOSucursal> voSucursales = new LinkedList<VOSucursal> ();
		for (Sucursal sucursal: ps.darSucursales())
		{
			voSucursales.add (sucursal);
		}
		log.info ("Generando los VO de Sucursales: " + voSucursales.size () + " Sucursales existentes");
		return voSucursales;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los PROVEEDORES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un proveedor 
	 * Adiciona entradas al log de la aplicación
	 * @param nit
	 * @param nombre - El nombre del proveedor
	 * @param calificacion - La calificacion del proveedor
	 * @param numCalificaciones - El numero de calificaciones del proveedor
	 * @return El objeto Proveedor adicionado. null si ocurre alguna Excepción
	 */
	public Proveedor adicionarProveedor (long nit, String nombre, double calificacion, int numCalificaciones)
	{
        log.info ("Adicionando Proveedor: " + nombre);
        Proveedor proveedor = ps.adicionarProveedor (nit,nombre, calificacion, numCalificaciones);
        log.info ("Adicionando Proveedor: " + proveedor);
        return proveedor;
	}
	
	/**
	 * Encuentra un Proveedor y su información básica, según su identificador
	 * @param idProveedor - El identificador de Proveedor buscado
	 * @return Un objeto Proveedor que corresponde con el identificador buscado y lleno con su información básica
	 * 			null, si un Proveedor con dicho identificador no existe
	 */
	public Proveedor darProveedorPorId (long idProveedor)
	{
        log.info ("Dar información de un proveedor por id: " + idProveedor);
        Proveedor proveedor = ps.darProveedorPorId (idProveedor);
        log.info ("Buscando proveedor por Id: " + proveedor != null ? proveedor : "NO EXISTE");
        return proveedor;
	}
	
	/**
	 * Encuentra todos los proveedores en SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos proveedor con todos las proveedores que conoce la aplicación, llenos con su información básica
	 */
	public List<Proveedor> darProveedores ()
	{
        log.info ("Listando Proveedores");
        List<Proveedor> proveedores = ps.darProveedores ();	
        log.info ("Listando Proveedores: " + proveedores.size() + " proveedores existentes");
        return proveedores;
	}

	/**
	 * Encuentra todos los proveedores en superAndes y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Proveedor con todos las proveedores que conoce la aplicación, llenos con su información básica
	 */
	public List<VOProveedor> darVOProveedores ()
	{
		log.info ("Generando los VO de Proveedores");
		List<VOProveedor> voProveedores = new LinkedList<VOProveedor> ();
		for (Proveedor proveedor: ps.darProveedores())
		{
			voProveedores.add (proveedor);
		}
		log.info ("Generando los VO de Proveedores: " + voProveedores.size () + " Proveedores existentes");
		return voProveedores;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los ALMACENAMIENTOS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un almacenamiento 
	 * Adiciona entradas al log de la aplicación
	 * @param cantidadMax 
	 * @param pesoMax
	 * @param volumenMax
	 * @param idSucursal
	 * @param idTipoProducto
	 * @param idVolumenProducto
	 * @return El objeto Almacenamiento adicionado. null si ocurre alguna Excepción
	 */
	public Almacenamiento adicionarAlmacenamiento (int cantidadMax, double pesoMax, double volumenMax, long idSucursal, long idTipoProducto,long idVolumenProducto) 
	{
	      log.info ("Adicionando Almacenamiento: ");
	      Almacenamiento almacenamiento = ps.adicionarAlmacenamiento ( cantidadMax, pesoMax, volumenMax, idSucursal, idTipoProducto, idVolumenProducto);
	      log.info ("Adicionando Almacenamiento: ");
	      return almacenamiento;
	}

	/**
	 * Encuentra un Almacenamiento y su información básica, según su identificador
	 * @param idAlmacenamiento - El identificador de Almacenamiento buscado
	 * @return Un objeto Almacenamiento que corresponde con el identificador buscado y lleno con su información básica
	 * 			null, si un Almacenamiento con dicho identificador no existe
	 */
	public Almacenamiento darAlmacenamientoPorId (long idAlmacenamiento)
	{
	      log.info ("Dar información de un almacenamiento por id: " + idAlmacenamiento);
	      Almacenamiento almacenamiento = ps.darAlmacenamientoPorId (idAlmacenamiento);
	      log.info ("Buscando almacenamiento por Id: " + almacenamiento != null ? almacenamiento : "NO EXISTE");
	      return almacenamiento;
	}

	/**
	 * Encuentra todos los almacenamientos en SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Alamcenamiento con todos las Almacenamientos que conoce la aplicación, llenos con su información básica
	 */
	public List<Almacenamiento> darAlmacenamientos ()
	{
	      log.info ("Listando Almacenamientos");
	      List<Almacenamiento> almacenamientos = ps.darAlmacenamientos ();	
	      log.info ("Listando Almacenamientos: " + almacenamientos.size() + " almacenamientos existentes");
	      return almacenamientos;
	}

	/**
	 * Encuentra todos los almacenamientos en Parranderos y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Bar con todos las bares que conoce la aplicación, llenos con su información básica
	 */
	public List<VOAlmacenamiento> darVOAlmacenamientos ()
	{
	  log.info ("Generando los VO de Almacenamientos");
	  List<VOAlmacenamiento> voAlmacenamientos = new LinkedList<VOAlmacenamiento> ();
	  for (Almacenamiento almacenamiento: ps.darAlmacenamientos())
	  {
	    voAlmacenamientos.add (almacenamiento);
	  }
	  log.info ("Generando los VO de Almacenamientos: " + voAlmacenamientos.size () + " Almacenamientos existentes");
	  return voAlmacenamientos;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar lAS BODEGAS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un bodega 
	 * Adiciona entradas al log de la aplicación
	 * @param direccion 
	 * @return El objeto Bodega adicionado. null si ocurre alguna Excepción
	 */
	public Bodega adicionarBodega ( String direccion)
	{
	      log.info ("Adicionando Bodega: ");
	      Bodega bodega = ps.adicionarBodega ( direccion);
	      log.info ("Adicionando Bodega: ");
	      return bodega;
	}

	/**
	 * Encuentra un Bodega y su información básica, según su identificador
	 * @param idBodega - El identificador de Bodega buscado
	 * @return Un objeto Bodega que corresponde con el identificador buscado y lleno con su información básica
	 * 			null, si un Bodega con dicho identificador no existe
	 */
	public Bodega darBodegaPorId (long idBodega)
	{
	      log.info ("Dar información de un Bodega por id: " + idBodega);
	      Bodega bodega = ps.darBodegaPorId (idBodega);
	      log.info ("Buscando bodega por Id: " + bodega != null ? bodega : "NO EXISTE");
	      return bodega;
	}

	/**
	 * Encuentra todos los bodegas en SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Bodega con todos las bodegas que conoce la aplicación, llenos con su información básica
	 */
	public List<Bodega> darBodegas ()
	{
	      log.info ("Listando Bodegas");
	      List<Bodega> bodegas = ps.darBodegas ();	
	      log.info ("Listando Bodegas: " + bodegas.size() + " bodegas existentes");
	      return bodegas;
	}

	/**
	 * Encuentra todos los bodegas en Parranderos y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Bodega con todos las Bodegas que conoce la aplicación, llenos con su información básica
	 */
	public List<VOBodega> darVOBodegas ()
	{
	  log.info ("Generando los VO de Bodegas");
	  List<VOBodega> voBodegas = new LinkedList<VOBodega> ();
	  for (Bodega bodega: ps.darBodegas())
	  {
	    voBodegas.add(bodega);
	  }
	  log.info ("Generando los VO de Bodegas: " + voBodegas.size () + " Bodegas existentes");
	  return voBodegas;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar lOS ESTANTES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un estante 
	 * Adiciona entradas al log de la aplicación
	 * @param nivelAbastecimiento 
	 * @return El objeto Estante adicionado. null si ocurre alguna Excepción
	 */
	public Estante adicionarEstante ( int nivelAbastecimiento)
	{
	      log.info ("Adicionando Estante: ");
	      Estante estante = ps.adicionarEstante ( nivelAbastecimiento);
	      log.info ("Adicionando Estante: ");
	      return estante;
	}

	/**
	 * Encuentra un Estante y su información básica, según su identificador
	 * @param idEstante - El identificador de Estante buscado
	 * @return Un objeto Estante que corresponde con el identificador buscado y lleno con su información básica
	 * 			null, si un Estante con dicho identificador no existe
	 */
	public Estante darEstantePorId (long idEstante)
	{
	      log.info ("Dar información de un Estante por id: " + idEstante);
	      Estante estante = ps.darEstantePorId (idEstante);
	      log.info ("Buscando estante por Id: " + estante != null ? estante : "NO EXISTE");
	      return estante;
	}

	/**
	 * Encuentra todos los estantes en SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Estante con todos las estantes que conoce la aplicación, llenos con su información básica
	 */
	public List<Estante> darEstantes ()
	{
	      log.info ("Listando Estantes");
	      List<Estante> estantes = ps.darEstantes ();	
	      log.info ("Listando Estantes: " + estantes.size() + " estantes existentes");
	      return estantes;
	}

	/**
	 * Encuentra todos los estantes en Parranderos y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Estante con todos las Estantes que conoce la aplicación, llenos con su información básica
	 */
	public List<VOEstante> darVOEstantes ()
	{
	  log.info ("Generando los VO de Estantes");
	  List<VOEstante> voEstantes = new LinkedList<VOEstante> ();
	  for (Estante estante: ps.darEstantes())
	  {
	    voEstantes.add(estante);
	  }
	  log.info ("Generando los VO de Estantes: " + voEstantes.size () + " Estantes existentes");
	  return voEstantes;
	}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar lOS CLIENTES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un cliente 
	 * Adiciona entradas al log de la aplicación
	 * @param id
	 * @param nombre 
	 * @param correo 
	 * @return El objeto Cliente adicionado. null si ocurre alguna Excepción
	 */
	public Cliente adicionarCliente ( long id, String nombre, String correo) 
	{
	      log.info ("Adicionando Cliente: ");
	      Cliente cliente = ps.adicionarCliente ( id ,nombre, correo) ;
	      log.info ("Adicionando Cliente: ");
	      return cliente;
	}

	/**
	 * Encuentra un Cliente y su información básica, según su identificador
	 * @param idCliente - El identificador de Cliente buscado
	 * @return Un objeto Cliente que corresponde con el identificador buscado y lleno con su información básica
	 * 			null, si un Cliente con dicho identificador no existe
	 */
	public Cliente darClientePorId (long idCliente)
	{
	      log.info ("Dar información de un Cliente por id: " + idCliente);
	      Cliente cliente = ps.darClientePorId (idCliente);
	      log.info ("Buscando cliente por Id: " + cliente != null ? cliente : "NO EXISTE");
	      return cliente;
	}

	/**
	 * Encuentra todos los clientes en SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Cliente con todos las clientes que conoce la aplicación, llenos con su información básica
	 */
	public List<Cliente> darClientes ()
	{
	      log.info ("Listando Clientes");
	      List<Cliente> clientes = ps.darClientes ();	
	      log.info ("Listando Clientes: " + clientes.size() + " clientes existentes");
	      return clientes;
	}

	/**
	 * Encuentra todos los clientes en Parranderos y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Cliente con todos las Clientes que conoce la aplicación, llenos con su información básica
	 */
	public List<VOCliente> darVOClientes ()
	{
	  log.info ("Generando los VO de Clientes");
	  List<VOCliente> voClientes = new LinkedList<VOCliente> ();
	  for (Cliente cliente: ps.darClientes())
	  {
	    voClientes.add (cliente);
	  }
	  log.info ("Generando los VO de Clientes: " + voClientes.size () + " Clientes existentes");
	  return voClientes;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar lOS CLIENTES NATURALES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un clienteNatural
	 * Adiciona entradas al log de la aplicación
	 * @return El objeto ClienteNaturaladicionado. null si ocurre alguna Excepción
	 */
	public ClienteNatural adicionarClienteNatural(long id ) 
	{
	      log.info ("Adicionando ClienteNatural : ");
	      ClienteNatural clienteNatural= ps.adicionarClienteNatural( id) ;
	      log.info ("Adicionando ClienteNatural: ");
	      return clienteNatural;
	}

	/**
	 * Encuentra un ClienteNaturaly su información básica, según su identificador
	 * @param idCliente- El identificador de ClienteNaturalbuscado
	 * @return Un objeto ClienteNaturalque corresponde con el identificador buscado y lleno con su información básica
	 * 			null, si un ClienteNaturalcon dicho identificador no existe
	 */
	public ClienteNatural darClienteNaturalPorId (long idCliente)
	{
	      log.info ("Dar información de un ClienteNatural por id: " + idCliente);
	      ClienteNatural clienteNatural= ps.darClienteNaturalPorId (idCliente);
	      log.info ("Buscando clienteNatural por Id: " + clienteNatural!= null ? clienteNatural: "NO EXISTE");
	      return clienteNatural;
	}

	/**
	 * Encuentra todos los clientesNaturales en SuperAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos ClienteNaturalcon todos las clientesNaturales que conoce la aplicación, llenos con su información básica
	 */
	public List<ClienteNatural> darClientesNaturales ()
	{
	      log.info ("Listando ClientesNaturales");
	      List<ClienteNatural> clientesNaturales = ps.darClientesNaturales ();	
	      log.info ("Listando ClientesNaturales: " + clientesNaturales.size() + " clientesNaturales existentes");
	      return clientesNaturales;
	}

	/**
	 * Encuentra todos los clientesNaturales en Parranderos y los devuelce como VO
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos ClienteNaturalcon todos las ClientesNaturales que conoce la aplicación, llenos con su información básica
	 */
	public List<VOCliente> darVOClientesNaturales ()
	{
	  log.info ("Generando los VO de ClientesNaturales");
	  List<VOCliente> voClientesNaturales = new LinkedList<VOCliente> ();
	  for (ClienteNatural cliente: ps.darClientesNaturales())
	  {
	    voClientesNaturales.add (cliente);
	  }
	  log.info ("Generando los VO de ClientesNaturales: " + voClientesNaturales.size () + " ClientesNaturales existentes");
	  return voClientesNaturales;
	}
	

/* ****************************************************************
 * 			Métodos para manejar lOS CLIENTES EMPRESA
 *****************************************************************/
/**
 * Adiciona de manera persistente un clienteEmpresa
 * Adiciona entradas al log de la aplicación
 * @param id
 * @param direccion
 * @return El objeto ClienteEmpresaadicionado. null si ocurre alguna Excepción
 */
public ClienteEmpresa adicionarClienteEmpresa( long id ,String direccion)  
{
      log.info ("Adicionando ClienteEmpresa : ");
      ClienteEmpresa clienteEmpresa= ps.adicionarClienteEmpresa( id , direccion)  ;
      log.info ("Adicionando ClienteEmpresa: ");
      return clienteEmpresa;
}

/**
 * Encuentra un ClienteEmpresay su información básica, según su identificador
 * @param idCliente- El identificador de ClienteEmpresabuscado
 * @return Un objeto ClienteEmpresa que corresponde con el identificador buscado y lleno con su información básica
 * 			null, si un ClienteEmpresa con dicho identificador no existe
 */
public ClienteEmpresa darClienteEmpresaPorId (long idCliente)
{
      log.info ("Dar información de un ClienteEmpresa por id: " + idCliente);
      ClienteEmpresa clienteEmpresa= ps.darClienteEmpresaPorId (idCliente);
      log.info ("Buscando clienteEmpresa por Id: " + clienteEmpresa!= null ? clienteEmpresa: "NO EXISTE");
      return clienteEmpresa;
}

/**
 * Encuentra todos los clientesEmpresa en SuperAndes
 * Adiciona entradas al log de la aplicación
 * @return Una lista de objetos ClienteEmpresacon todos las clientesEmpresa que conoce la aplicación, llenos con su información básica
 */
public List<ClienteEmpresa> darClientesEmpresa ()
{
      log.info ("Listando ClientesEmpresa");
      List<ClienteEmpresa> clientesEmpresa = ps.darClientesEmpresa ( );	
      log.info ("Listando ClientesEmpresa: " + clientesEmpresa.size( ) + " clientesEmpresa existentes");
      return clientesEmpresa;
}

/**
 * Encuentra todos los clientesEmpresa en Parranderos y los devuelce como VO
 * Adiciona entradas al log de la aplicación
 * @return Una lista de objetos ClienteEmpresacon todos las ClientesEmpresa que conoce la aplicación, llenos con su información básica
 */
public List<VOCliente> darVOClientesEmpresa ()
{
  log.info ("Generando los VO de ClientesEmpresa");
  List<VOCliente> voClientesEmpresa = new LinkedList<VOCliente> ();
  for (ClienteEmpresa cliente: ps.darClientesEmpresa())
  {
    voClientesEmpresa.add (cliente);
  }
  log.info ("Generando los VO de ClientesEmpresa: " + voClientesEmpresa.size () + " ClientesEmpresa existentes");
  return voClientesEmpresa;
}

}



