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
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import com.google.gson.JsonObject;

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
	//	/**
	//	 * El constructor por defecto
	//	 */
	//	public SuperAndes ()
	//	{
	//		ps = PersistenciaSuperAndes.getInstance ();
	//	}

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
		System.out.println("Adicionando Sucursal: " + nombre);
		Sucursal sucursal = ps.adicionarSucursal (nombre, direccion, ciudad);
		System.out.println ("Adicionando Sucursal: " + sucursal);
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
		System.out.println( ("Listando Proveedores"));
		List<Proveedor> proveedores = ps.darProveedores ();	
		System.out.println( ("Listando Proveedores: " + proveedores.size() + " proveedores existentes"));
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
	 * 			Métodos para manejar lAS BODEGAS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un bodega 
	 * Adiciona entradas al log de la aplicación
	 * @param direccion 
	 * @return El objeto Bodega adicionado. null si ocurre alguna Excepción
	 */
	public Bodega adicionarBodega(int cantidadMax, double pesoMax, double volumenMax, long idSucursal, long idTipoProducto,long idVolumenProducto, String direccion)
	{
		System.out.println("Adicionando Almacenamiento: ");
		Long almacenamiento = ps.adicionarAlmacenamiento ( cantidadMax, pesoMax, volumenMax, idSucursal, idTipoProducto, idVolumenProducto);
		System.out.println("Adicionando Almacenamiento: ");
		if(almacenamiento != null)
		{
			System.out.println("Adicionando Bodega: ");
			Bodega bodega = ps.adicionarBodega ( almacenamiento, direccion,cantidadMax, pesoMax, volumenMax, idSucursal, idTipoProducto, idVolumenProducto);
			System.out.println("Adicionando Bodega: ");
			return bodega;
		}
		else
			return null;
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
	public Estante adicionarEstante ( int cantidadMax, double pesoMax, double volumenMax, long idSucursal, long idTipoProducto,long idVolumenProducto,int nivelAbastecimiento)
	{ 
		log.info ("Adicionando Almacenamiento: ");
		Long almacenamiento = ps.adicionarAlmacenamiento ( cantidadMax, pesoMax, volumenMax, idSucursal, idTipoProducto, idVolumenProducto);
		log.info ("Adicionando Almacenamiento: ");
		if(almacenamiento != null )
		{
			log.info ("Adicionando Estante: ");
			Estante estante = ps.adicionarEstante ( almacenamiento, nivelAbastecimiento,cantidadMax, pesoMax, volumenMax, idSucursal, idTipoProducto, idVolumenProducto);
			log.info ("Adicionando Estante: ");
			return estante;

		}
		else return null;
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
		Estante estante = ps.darEstantesPorId (idEstante);
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
	 * 			Métodos para manejar lOS CLIENTES NATURALES
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un clienteNatural
	 * Adiciona entradas al log de la aplicación
	 * @return El objeto ClienteNaturaladicionado. null si ocurre alguna Excepción
	 */
	public ClienteNatural adicionarClienteNatural(long id,String nombre, String correo) 
	{
		System.out.println("Adicionando Cliente: " + id);
		Long cliente = ps.adicionarCliente( id ,nombre, correo) ;
		System.out.println("Adicionando Cliente: " + id);
		if(cliente != null)
		{

			System.out.println("Adicionando ClienteNatural : ");
			ClienteNatural clienteNatural= ps.adicionarClienteNatural(id, nombre, correo) ;
			System.out.println("Adicionando ClienteNatural: ");
			return clienteNatural;

		}

		else return null;
	}
	//	}
	//	/**
	//	 * Encuentra un ClienteNaturaly su información básica, según su identificador
	//	 * @param idCliente- El identificador de ClienteNaturalbuscado
	//	 * @return Un objeto ClienteNaturalque corresponde con el identificador buscado y lleno con su información básica
	//	 * 			null, si un ClienteNaturalcon dicho identificador no existe
	//	 */
	//	public ClienteNatural darClienteNaturalPorId (long idCliente)
	//	{
	//		log.info ("Dar información de un ClienteNatural por id: " + idCliente);
	//		ClienteNatural clienteNatural= ps.darClienteNaturalPorId (idCliente);
	//		log.info ("Buscando clienteNatural por Id: " + clienteNatural!= null ? clienteNatural: "NO EXISTE");
	//		return clienteNatural;
	//	}
	//
	//	/**
	//	 * Encuentra todos los clientesNaturales en SuperAndes
	//	 * Adiciona entradas al log de la aplicación
	//	 * @return Una lista de objetos ClienteNaturalcon todos las clientesNaturales que conoce la aplicación, llenos con su información básica
	//	 */
	//	public List<ClienteNatural> darClientesNaturales ()
	//	{
	//		log.info ("Listando ClientesNaturales");
	//		List<ClienteNatural> clientesNaturales = ps.darClientesNaturales ();	
	//		log.info ("Listando ClientesNaturales: " + clientesNaturales.size() + " clientesNaturales existentes");
	//		return clientesNaturales;
	//	}
	//
	//	/**
	//	 * Encuentra todos los clientesNaturales en Parranderos y los devuelce como VO
	//	 * Adiciona entradas al log de la aplicación
	//	 * @return Una lista de objetos ClienteNaturalcon todos las ClientesNaturales que conoce la aplicación, llenos con su información básica
	//	 */
	//	public List<VOCliente> darVOClientesNaturales ()
	//	{
	//		log.info ("Generando los VO de ClientesNaturales");
	//		List<VOCliente> voClientesNaturales = new LinkedList<VOCliente> ();
	//		for (ClienteNatural cliente: ps.darClientesNaturales())
	//		{
	//			voClientesNaturales.add (cliente);
	//		}
	//		log.info ("Generando los VO de ClientesNaturales: " + voClientesNaturales.size () + " ClientesNaturales existentes");
	//		return voClientesNaturales;
	//	}
	//
	//
	//	/* ****************************************************************
	//	 * 			Métodos para manejar lAS CATEGORIAS
	//	 *****************************************************************/
	//	/**
	//	 * Adiciona de manera persistente un clienteEmpresa
	//	 * Adiciona entradas al log de la aplicación
	//	 * @param id
	//	 * @param direccion
	//	 * @return El objeto ClienteEmpresaadicionado. null si ocurre alguna Excepción
	//	 */
	public ClienteEmpresa adicionarClienteEmpresa( long id ,String nombre, String correo,String direccion)  
	{

		log.info ("Adicionando Cliente: " + id);
		Long cliente = ps.adicionarCliente( id ,nombre, correo);
		log.info ("Adicionando Cliente: " + id);
		if(cliente != null)
		{
			{
				System.out.println("Adicionando ClienteEmpresa : ");
				ClienteEmpresa clienteEmpresa= ps.adicionarClienteEmpresa( id , nombre, correo, direccion)  ;
				System.out.println("Adicionando ClienteEmpresa: ");
				return clienteEmpresa;
			}
		}

		else return null;
	}
	
	//
	//		/**
	//		 * Encuentra un ClienteEmpresay su información básica, según su identificador
	//		 * @param idCliente- El identificador de ClienteEmpresabuscado
	//		 * @return Un objeto ClienteEmpresa que corresponde con el identificador buscado y lleno con su información básica
	//		 * 			null, si un ClienteEmpresa con dicho identificador no existe
	//		 */
	//		public ClienteEmpresa darClienteEmpresaPorId (long idCliente)
	//		{
	//			log.info ("Dar información de un ClienteEmpresa por id: " + idCliente);
	//			ClienteEmpresa clienteEmpresa= ps.darClienteEmpresaPorId (idCliente);
	//			log.info ("Buscando clienteEmpresa por Id: " + clienteEmpresa!= null ? clienteEmpresa: "NO EXISTE");
	//			return clienteEmpresa;
	//		}
	//
	//		/**
	//		 * Encuentra todos los clientesEmpresa en SuperAndes
	//		 * Adiciona entradas al log de la aplicación
	//		 * @return Una lista de objetos ClienteEmpresacon todos las clientesEmpresa que conoce la aplicación, llenos con su información básica
	//		 */
	//		public List<ClienteEmpresa> darClientesEmpresa ()
	//		{
	//			log.info ("Listando ClientesEmpresa");
	//			List<ClienteEmpresa> clientesEmpresa = ps.darClientesEmpresa ( );	
	//			log.info ("Listando ClientesEmpresa: " + clientesEmpresa.size( ) + " clientesEmpresa existentes");
	//			return clientesEmpresa;
	//		}
	//
	//		/**
	//		 * Encuentra todos los clientesEmpresa en Parranderos y los devuelce como VO
	//		 * Adiciona entradas al log de la aplicación
	//		 * @return Una lista de objetos ClienteEmpresacon todos las ClientesEmpresa que conoce la aplicación, llenos con su información básica
	//		 */
	//		public List<VOCliente> darVOClientesEmpresa ()
	//		{
	//			log.info ("Generando los VO de ClientesEmpresa");
	//			List<VOCliente> voClientesEmpresa = new LinkedList<VOCliente> ();
	//			for (ClienteEmpresa cliente: ps.darClientesEmpresa())
	//			{
	//				voClientesEmpresa.add (cliente);
	//			}
	//			log.info ("Generando los VO de ClientesEmpresa: " + voClientesEmpresa.size () + " ClientesEmpresa existentes");
	//			return voClientesEmpresa;
	//		}
	//
	//		/* ****************************************************************
	//		 * 			Métodos para manejar lAS CATEGORIAS
	//		 *****************************************************************/
	//		/**
	//		 * Adiciona de manera persistente un categoria 
	//		 * Adiciona entradas al log de la aplicación
	//		 * @param nombre
	//		 * @return El objeto Categoria adicionado. null si ocurre alguna Excepción
	//		 */
	//		public Categoria adicionarCategoria ( String nombre) 
	//		{
	//			log.info ("Adicionando Categoria: ");
	//			Categoria categoria = ps.adicionarCategoria ( nombre);
	//			log.info ("Adicionando Categoria: ");
	//			return categoria;
	//		}
	//
	//		/**
	//		 * Encuentra un Categoria y su información básica, según su identificador
	//		 * @param idCategoria - El identificador de Categoria buscado
	//		 * @return Un objeto Categoria que corresponde con el identificador buscado y lleno con su información básica
	//		 * 			null, si un Categoria con dicho identificador no existe
	//		 */
	//		public Categoria darCategoriaPorId (long idCategoria)
	//		{
	//			log.info ("Dar información de un categoria por id: " + idCategoria);
	//			Categoria categoria = ps.darCategoriaPorId (idCategoria);
	//			log.info ("Buscando categoria por Id: " + categoria != null ? categoria : "NO EXISTE");
	//			return categoria;
	//		}
	//
	//		/**
	//		 * Encuentra todos los categorias en SuperAndes
	//		 * Adiciona entradas al log de la aplicación
	//		 * @return Una lista de objetos Alamcenamiento con todos las Categorias que conoce la aplicación, llenos con su información básica
	//		 */
	//		public List<Categoria> darCategorias ()
	//		{
	//			log.info ("Listando Categorias");
	//			List<Categoria> categorias = ps.darCategorias ();	
	//			log.info ("Listando Categorias: " + categorias.size() + " categorias existentes");
	//			return categorias;
	//		}
	//
	//		/**
	//		 * Encuentra todos los categorias en Parranderos y los devuelce como VO
	//		 * Adiciona entradas al log de la aplicación
	//		 * @return Una lista de objetos Bar con todos las bares que conoce la aplicación, llenos con su información básica
	//		 */
	//		public List<VOCategoria> darVOCategorias ()
	//		{
	//			log.info ("Generando los VO de Categorias");
	//			List<VOCategoria> voCategorias = new LinkedList<VOCategoria> ();
	//			for (Categoria categoria: ps.darCategorias())
	//			{
	//				voCategorias.add (categoria);
	//			}
	//			log.info ("Generando los VO de Categorias: " + voCategorias.size () + " Categorias existentes");
	//			return voCategorias;
	//		}
	
	
	/* ****************************************************************
	 * 			Métodos para manejar lOS PRODUCTOS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un producto 
	 * Adiciona entradas al log de la aplicación
	 * @param nombre
	 * @return El objeto Producto adicionado. null si ocurre alguna Excepción
	 */
	public Producto adicionarProducto (String id, String nombre, String marca, double precioUnitario, String presentacion, double cantidad, String unidadMedida, double precioUnidadMedida, double especificacionEmpaque, int exclusivo, long idTipoProducto, long idCategoria, Date fechaVencimiento)
	{
		log.info ("Adicionando Producto: ");
		Producto producto = ps.adicionarProducto(id, nombre, marca, precioUnitario, presentacion, cantidad, unidadMedida, precioUnidadMedida, especificacionEmpaque, exclusivo, fechaVencimiento, idTipoProducto, idCategoria);
		log.info ("Adicionando Producto: ");
		return producto;
	}

//	/**
//	 * Encuentra un Producto y su información básica, según su identificador
//	 * @param idProducto - El identificador de Producto buscado
//	 * @return Un objeto Producto que corresponde con el identificador buscado y lleno con su información básica
//	 * 			null, si un Producto con dicho identificador no existe
//	 */
//	public Producto darProductoPorId (long idProducto)
//	{
//		log.info ("Dar información de un producto por id: " + idProducto);
//		Producto producto = ps.darProductoPorId (idProducto);
//		log.info ("Buscando producto por Id: " + producto != null ? producto : "NO EXISTE");
//		return producto;
//	}
//
//	/**
//	 * Encuentra todos los productos en SuperAndes
//	 * Adiciona entradas al log de la aplicación
//	 * @return Una lista de objetos Alamcenamiento con todos las Productos que conoce la aplicación, llenos con su información básica
//	 */
//	public List<Producto> darProductos ()
//	{
//		log.info ("Listando Productos");
//		List<Producto> productos = ps.darProductos ();	
//		log.info ("Listando Productos: " + productos.size() + " productos existentes");
//		return productos;
//	}
//
//	/**
//	 * Encuentra todos los productos en Parranderos y los devuelce como VO
//	 * Adiciona entradas al log de la aplicación
//	 * @return Una lista de objetos Bar con todos las bares que conoce la aplicación, llenos con su información básica
//	 */
//	public List<VOProducto> darVOProductos ()
//	{
//		log.info ("Generando los VO de Productos");
//		List<VOProducto> voProductos = new LinkedList<VOProducto> ();
//		for (Producto producto: ps.darProductos())
//	{
//			voProductos.add (producto);
//	}
//		log.info ("Generando los VO de Productos: " + voProductos.size () + " Productos existentes");
//		return voProductos;
//	}
	
	
	
}



