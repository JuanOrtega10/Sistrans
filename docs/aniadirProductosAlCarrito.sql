--Verificar que el carrito sea de la sucursal del estante.
		SELECT count(*) FROM A_ALMACENAMIENTO WHERE id=? AND idSucursal = (SELECT idSucursal FROM A_CARRITO WHERE id = idCarrito);
		--Si el resultado anterior es cero quiere decir que el estante no pertence a la sucursal donde se registró el carrito o no se ha creado uno");


		--Verificar que es un nuevo producto el que está añadiendo, sino, se debe añadir a un itemCarrito existente.
		SELECT count(*) FROM A_ITEMCARRITO WHERE idProducto = idProducto AND idCarrito = idCarrito;
		--si el resultado anterior es 1 se procede a verificar si ya existe un itemCarrito con ese producto y el mismo estante
		SELECT count(*) FROM A_ITEMCARRITO WHERE idProducto = idProducto AND idCarrito = idCarrito AND idEstante = idEstante;
		-- Si el resultado es 1 solo se actualizar la cantidad del item ya creado
				UPDATE A_ITEMCARRITO SET cantidad = cantidad + cantidad WHERE idProducto = idProducto AND idCarrito = idCarrito;


    -- Disminuir de los estantes
    --Primero se obtiene el id del volumenProducto del estante
		SELECT IDVOLUMENPRODUCTO FROM ( A_ESTANTE INNER JOIN A_ALMACENAMIENTO ON A_ESTANTE.IDALMACENAMIENTO = A_ALMACENAMIENTO.ID ) WHERE id = idEstante;
    --Se actualiza la cantidad
		UPDATE A_VOLUMENPRODUCTO SET cantidad = cantidad - cantidad  WHERE id  = idVolumen and idProducto = idProducto;


	  -- si se tiene que crear un itemProducto en vez de actualizarlo
		INSERT INTO A_ITEMCARRITO (id, idCarrito, idProducto, cantidad, idEstante) values (id,idCarrito, idProducto,cantidad, idEstante);

		-- Selecciono lo que voy a retornar (lo que se creo o actualizo)
		SELECT * FROM A_ITEMCARRITO WHERE idProducto = idProducto AND idCarrito = idCarrito and idEstante = idEstante;
