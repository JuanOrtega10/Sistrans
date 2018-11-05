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


package uniandes.isis2304.superandes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.superandes.negocio.Carrito;
import uniandes.isis2304.superandes.negocio.Estante;
import uniandes.isis2304.superandes.negocio.Factura;
import uniandes.isis2304.superandes.negocio.ItemCarrito;
import uniandes.isis2304.superandes.negocio.ItemFactura;
import uniandes.isis2304.superandes.negocio.ItemPedido;
import uniandes.isis2304.superandes.negocio.Provee;
import uniandes.isis2304.superandes.negocio.Reorden;
import uniandes.isis2304.superandes.negocio.VolumenProducto;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Facturas de SuperAndes
 * 
 * @author ja.ortega - dy.quintero.
 */
class SQLFactura 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaSuperAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaSuperAndes ps;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLFactura (PersistenciaSuperAndes ps)
	{
		this.ps = ps;
	}

	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ALMACENAMIENTO a la base de datos de SuperAndes
	 */
	public long adicionarFactura (PersistenceManager pm, long id, Timestamp fecha, long idSucursal, long idCliente) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaFactura() + "(id, fecha, idSucursal, idCliente) values (?, ?, ?, ?)");
		q.setParameters(id, fecha, idSucursal, idCliente);
		return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ALMACENAMIENTO de la 
	 * base de datos de SuperAndes, por su identificador
	 */
	public Factura darFacturaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaFactura( ) + " WHERE id = ?");
		q.setResultClass(Factura.class);
		q.setParameters(id);
		return (Factura) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ALMACENAMIENTO de la 
	 * base de datos de SuperAndes
	 */
	public List<Factura> darFacturas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaFactura());
		q.setResultClass(Factura.class);
		return (List<Factura>) q.executeList();
	}

	public ArrayList<ItemFactura> generarFactura(PersistenceManager pm, List<ItemCarrito> items, SQLUtil2 sql, long idCarro) {

		//Revisar si tiene promoción.


		//Saber el id de la sucursal con el id del carrito.
		Query q = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaCarrito() + " WHERE id = ?");
		q.setParameters(idCarro);
		q.setResultClass(Carrito.class);
		Carrito carr = (Carrito) q.executeUnique();

		//Crear una nueva Factura

		long idFactura = sql.nextval(pm);
		adicionarFactura(pm, idFactura, new Timestamp(System.currentTimeMillis()), carr.getIdSucursal(), carr.getIdCliente());

		ArrayList<ItemFactura> itemsFactura = new ArrayList<ItemFactura>();

		for (ItemCarrito itemCarrito : items) {
			long idNuevo = sql.nextval(pm);
			//Saber el precio base del producto con el itemPedido
			Query s = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaItemPedido() + " WHERE id = ("
					+ "SELECT idItemPedido FROM " + ps.darTablaVolumenProducto() + " WHERE id = "
					+ "(SELECT idVolumenProducto FROM " + ps.darTablaAlmacenamiento() + " WHERE id = "
					+ "(SELECT idEstante FROM " + ps.darTablaItemCarrito() + " WHERE id = ?)))");
			s.setResultClass(ItemPedido.class);

			s.setParameters(itemCarrito.getId());
			ItemPedido itemPedido = (ItemPedido) s.executeUnique();

			ItemFactura itemFact= new ItemFactura(idNuevo, itemCarrito.getCantidad().intValue() , idFactura, itemCarrito.getIdProducto(), itemPedido.getPrecioVenta() * itemCarrito.getCantidad().doubleValue());
			itemsFactura.add(itemFact);
			//Meto el item factura a la base de datos

			Query insertarItemFactura = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaItemFactura() + " (id, cantidad, idFactura, idProducto, precio) values (?, ?, ?, ?, ?)");
			insertarItemFactura.setParameters(idNuevo, itemCarrito.getCantidad().intValue(), idFactura, itemPedido.getIdProducto(), itemPedido.getPrecioVenta() * itemCarrito.getCantidad().doubleValue());
			insertarItemFactura.executeUnique();
			
			//Revisar el nivel de abastecimiento del estante de donde se sacó el producto para ver si toca traer de bodega.
			Query nivelAbastecimiento = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaEstante() + " WHERE idAlmacenamiento = ?");
			nivelAbastecimiento.setParameters(itemCarrito.getIdEstante());
			nivelAbastecimiento.setResultClass(Estante.class);
			Estante est = (Estante) nivelAbastecimiento.executeUnique();
			
			Query idVolumen = pm.newQuery(SQL, "SELECT idVolumenProducto FROM " + ps.darTablaAlmacenamiento() + " WHERE id = ?");
//			nivelAbastecimiento.setClass(Estante.class);
			idVolumen.setParameters(itemCarrito.getIdEstante());
			BigDecimal volEstante = (BigDecimal) idVolumen.executeUnique();

			Query volumen = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaVolumenProducto() + " WHERE id = ?");
			volumen.setParameters(volEstante);
			volumen.setResultClass(VolumenProducto.class);
			VolumenProducto vol = (VolumenProducto) volumen.executeUnique();
			
			if(vol.getCantidad()<est.getNivelAbastecimiento())
			{
				System.out.println("Debo llenar el estante");
				//Lleno el estante
				
				
				//Selecciono una bodega con ese producto
				Query idBodega = pm.newQuery(SQL,"Select idVolumenProducto from"
						+ " (Select idVolumenProducto from " + ps.darTablaBodega() + " a inner join " + ps.darTablaAlmacenamiento() + " b"
							+ " on a.idAlmacenamiento = b.id) c"
					+ " inner join "
						+ "(select * from a_volumenProducto) d"
						+ " on c.idVolumenProducto = d.id  WHERE idProducto = ?");
				idBodega.setParameters(itemCarrito.getIdProducto());
				BigDecimal idBodegaLong = (BigDecimal) idBodega.executeUnique();
				//Restar unidades del producto a la bodega
					//Obtengo la capacidad del estante
					Query capacidad = pm.newQuery(SQL, "SELECT cantidadMax FROM " + ps.darTablaAlmacenamiento() + " WHERE id = ?");
					capacidad.setParameters(itemCarrito.getIdEstante());
					BigDecimal capacidadEstante = (BigDecimal) capacidad.executeUnique();
					
					//Obtengo la capacidad de la bodega
					Query capacidadB = pm.newQuery(SQL, "SELECT cantidadMax FROM " + ps.darTablaAlmacenamiento() + " WHERE id = ?");
					capacidadB.setParameters(idBodegaLong);
					BigDecimal capacidadBodega = (BigDecimal) capacidadB.executeUnique();
					

					//La cantidad anterior del estante
					Query cantidadAnterior = pm.newQuery(SQL, "SELECT cantidad FROM " + ps.darTablaVolumenProducto() + " where id = ?");
					cantidadAnterior.setParameters(volEstante);
					BigDecimal cantidadA = (BigDecimal) cantidadAnterior.executeUnique();
					
					//La cantidad que voy a poner en el estante capacidad máxima
					Query actualizarCantidadEstante = pm.newQuery(SQL, "UPDATE " + ps.darTablaVolumenProducto() + " SET cantidad = ?  where id = ?");
					actualizarCantidadEstante.setParameters(capacidadEstante, volEstante);
					actualizarCantidadEstante.executeUnique();
	
					//Ahora tengo que restar de bodega
					Query actualizarCantidadBodega = pm.newQuery(SQL, "UPDATE " + ps.darTablaVolumenProducto() + " SET cantidad = cantidad - ?  where id = ?");
					actualizarCantidadBodega.setParameters(capacidadEstante.subtract(cantidadA), idBodegaLong);
					actualizarCantidadBodega.executeUnique();
					
					//La cantidad de la bodega
					Query cantidadAnteriorBodega = pm.newQuery(SQL, "SELECT cantidad FROM " + ps.darTablaVolumenProducto() + " where id = ?");
					cantidadAnteriorBodega.setParameters(idBodegaLong);
					BigDecimal cantidadBodega = (BigDecimal) cantidadAnteriorBodega.executeUnique();
					
					//Verificar si tengo que generar un pedido por el reorden
					
					Query reorden = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaReorden() + " where idSucursal = ? and idProducto = ?");
					reorden.setParameters(carr.getIdSucursal(), itemCarrito.getIdProducto());
					reorden.setResultClass(Reorden.class);
					Reorden reo = (Reorden) reorden.executeUnique();
					
					if(cantidadBodega.intValue() < reo.getNivelReorden())
					{
						//Tengo que generar un pedido.
						//Selecciono un proveedor para el pedido

						Query proveedor = pm.newQuery(SQL, "SELECT * FROM " + ps.darTablaProvee() + " where idProducto = ? and rownum = 1");
						proveedor.setParameters(itemCarrito.getIdProducto());	
						proveedor.setResultClass(Provee.class);
						Provee prov = (Provee) proveedor.executeUnique();
					   
						System.out.println(prov.getPrecioCompra());
						//Creo un item Pedido
						Query crearItemPedido = pm.newQuery(SQL, "INSERT INTO " + ps.darTablaItemPedido() + " (id, cantidad, idPedido, idProducto, precioVenta) values (?, ?, ?, ?, ?)");
						crearItemPedido.setParameters(sql.nextval(pm), capacidadBodega.subtract(cantidadBodega).intValue(), null, itemCarrito.getIdProducto(), prov.getPrecioVenta());					
						crearItemPedido.executeUnique();
						
					}
				
			}
			
			
			
		
		}
		System.out.println(itemsFactura.size());
		return itemsFactura;

	}
}
