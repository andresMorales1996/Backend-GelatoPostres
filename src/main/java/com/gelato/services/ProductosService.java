package com.gelato.services;

import com.gelato.models.*;
import com.gelato.repositories.CategoriasRepository;
import com.gelato.repositories.PorcionesRepository;
import com.gelato.repositories.ProductosRepository;
import com.gelato.repositories.RellenosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Autowired
    private PorcionesRepository porcionesRepository;

    @Autowired
    private RellenosRepository rellenosRepository;

    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    public Productos getProducto(Long id) {
        return productosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
    }

    public Productos createProducto(Productos producto) {
        return productosRepository.save(producto);
    }

    public Productos updateProducto(Long id, Productos update) {
        Productos producto = getProducto(id);
        if (producto != null) {
            producto.setNombreProducto(update.getNombreProducto());
            producto.setDescripcionProducto(update.getDescripcionProducto());
            producto.setEstadoProducto(update.getEstadoProducto());
            producto.setImagenProducto(update.getImagenProducto());
            producto.setPrecioProducto(update.getPrecioProducto());
            producto.setCategoria(update.getCategoria());
            producto.setPorcion(update.getPorcion());
            producto.setRelleno(update.getRelleno());
            return productosRepository.save(producto);
        } else {
            return null;
        }
    }

    public void deleteProducto(Long id) {
        Productos producto = getProducto(id);
        productosRepository.delete(producto);
    }

    public List<Categorias> getAllCategorias() {
        return categoriasRepository.findAll();
    }

    public List<Porciones> getAllPorciones() {
        return porcionesRepository.findAll();
    }

    public List<Rellenos> getAllRellenos() {
        return rellenosRepository.findAll();
    }
}
