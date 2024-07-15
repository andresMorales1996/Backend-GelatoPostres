package com.gelato.controllers;

import com.gelato.models.Productos;
import com.gelato.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/productos/v1")
public class ProductosController {

  @Autowired
  private ProductosService productosService;

  @GetMapping("/allProductos")
  public List<Productos> getAllProductos() {
    return productosService.getAllProductos();
  }

  @GetMapping("/producto/{id}")
  public Productos getProducto(@PathVariable Long id) {
    return productosService.getProducto(id);
  }

  @PostMapping("/createProducto")
  public Productos createProducto(@RequestBody Productos productos) {
    return productosService.createProducto(productos);
  }

  @PutMapping("/updateProducto/{id}")
  public Productos updateProducto(@PathVariable Long id, @RequestBody Productos productos) {
    return productosService.updateProducto(id, productos);
  }

  @DeleteMapping("/deleteProducto/{id}")
  public void deleteProducto(@PathVariable Long id) {
    productosService.deleteProducto(id);
  }

  @PostMapping("/uploadImage/{id}")
  public String uploadImage(@PathVariable Long id, @RequestParam("imagen_producto") MultipartFile file) {
    try {
      productosService.saveImage(id, file);
      return "Imagen subida exitosamente";
    } catch (IOException e) {
      return "Error subiendo la imagen: " + e.getMessage();
    }
  }

}
