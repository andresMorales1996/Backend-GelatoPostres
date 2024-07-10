package com.gelato.controllers;

import com.gelato.models.Productos;
import com.gelato.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @GetMapping
    public List<Productos> getAllProductos() {
        return productosService.getAllProductos();
    }

    @PostMapping
    public Productos addProducto(@RequestBody Productos categoria) {
        return productosService.addProducto(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
        productosService.deleteProducto(id);
    }

    @GetMapping("/{id}")
    public Productos findProducto(@PathVariable Long id){
        return productosService.findProducto(id);
    }

    @PutMapping("/{id}")
    public Productos updateProducto(@PathVariable Long id, @RequestBody Productos categoria) {
        return productosService.updateProducto(id, categoria);
    }
}
