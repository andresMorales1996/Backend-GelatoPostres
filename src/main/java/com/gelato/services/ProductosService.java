package com.gelato.services;

import com.gelato.models.Productos;
import com.gelato.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {
    // inyección de dependencia
    @Autowired
    private ProductosRepository productosRepository;

    // Obtener todos los productos
    public List<Productos> getAllProductos(){
        return productosRepository.findAll();
    }
    // Crear producto
    public Productos addProducto(Productos productos){
        return productosRepository.save(productos);
    }
    // Eliminar producto
    public void deleteProducto(Long id){
        productosRepository.deleteById(id);
    }
    // Obtener un producto por nombre o id
    public Productos findProducto(Long id) {
        return productosRepository.findById(id).orElse(null);
    }
    // Actualizar un producto
    public Productos updateProducto(Long id, Productos update){
        // Buscar el producto existente por ID
        Productos producto = findProducto(id);
        if(producto != null){
            producto.setNombre_producto(update.getNombre_producto());
            producto.setDescripcion_producto(update.getDescripcion_producto());
            producto.setDisponibilidad(update.getDisponibilidad());
            producto.setImagen_producto(update.getImagen_producto());

            return productosRepository.save(producto);
        } else {
            return null;
        }
    }
}
