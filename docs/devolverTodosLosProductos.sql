	--Obtener el id del Estante
	SELECT idEstante FROM A_ITEMCARRITO WHERE idCarrito = idCarrito AND idProducto = idProducto;

	--Obetener el id del volumen producto pra actualizarlo
	SELECT IDVOLUMENPRODUCTO FROM A_ALMACENAMIENTO WHERE id = idEstante;

	--Obtener la cantidad de ese itemCarrito
	SELECT * FROM A_ITEMCARRITO WHERE idProducto = idProducto AND idCarrito = idCarrito and idEstante = idEstante;
	--Actualizar la cantidad en el estante
	UPDATE A_VOLUMENPRODUCTO SET cantidad = cantidad + itemCarrito.getCantidad() WHERE id  = idVolumen;

	--eliminar el itemCarrito
	DELETE FROM A_ITEMCARRITO WHERE idCarrito  = idCarrito AND idProducto = idProducto and idEstante = idEstante;
