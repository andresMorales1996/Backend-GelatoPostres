package com.gelato.services;

import com.gelato.models.Coberturas;
import com.gelato.models.Productos;
import com.gelato.repositories.ProductosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    // metodo para mostrar todos los Productos
    public List<Productos> getAllProductos(){
        return productosRepository.findAll();
    }

    // metodo para mostrar una Producto en especifico y ver si existe
    public Productos getProducto(Long id) {
        return productosRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Producto no encontrado, intente con otro"));
    }

    //Agregar un nuevo Producto
    public Productos addProducto(Productos productos){
        return productosRepository.save(productos);
    }

    // meotodo para actualizar un producto
    public Productos updateProducto(Long id, Productos update){
        Productos producto = getProducto(id);
        if(producto != null){
            producto.setNombre_producto(update.getNombre_producto());
            producto.setDescripcion_producto(update.getDescripcion_producto());
            producto.setEstado_producto(update.getEstado_producto());
            producto.setImagen_producto(update.getImagen_producto());

            return productosRepository.save(producto);
        } else {
            return null;
        }
    }
    // metodo para eliminar un Eliminar producto
    public void deleteProducto(Long id){
        Productos eliminar = productosRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Producto no encontrado, no es posible eliminarlo"));
        productosRepository.deleteById(id);
    }


}
