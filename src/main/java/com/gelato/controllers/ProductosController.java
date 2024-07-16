package com.gelato.controllers;

import com.gelato.models.Categorias;
import com.gelato.models.Porciones;
import com.gelato.models.Productos;
import com.gelato.models.Rellenos;
import com.gelato.services.CategoriasService;
import com.gelato.services.PorcionesService;
import com.gelato.services.RellenosService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.io.Resource;
import com.gelato.services.ProductosService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Validated
@RestController
@RequestMapping("/productos/v1")
public class ProductosController {

  @Autowired
  private ProductosService productosService;

  @Autowired
  private CategoriasService categoriasService;

  @Autowired
  private PorcionesService porcionesService;

  @Autowired
  private RellenosService rellenosService;

  @GetMapping("/allProductos")
  public List<Productos> getAllProductos() {
    return productosService.getAllProductos();
  }

  @GetMapping("/producto/{id}")
  public Productos getProducto(@PathVariable Long id) {
    return productosService.getProducto(id);
  }

  @PostMapping(value = "/createProducto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<?> createProducto(
          @RequestParam("file") MultipartFile file,
          @RequestParam("nombre_producto") String nombreProducto,
          @RequestParam("descripcion_producto") String descripcionProducto,
          @RequestParam("estado_producto") boolean estadoProducto,
          @RequestParam("precio_producto") double precioProducto,
          @RequestParam("id_categoria") Long idCategoria,
          @RequestParam("id_porcion") Long idPorcion,
          @RequestParam("id_relleno") Long idRelleno) {

    try {
      if (file.isEmpty()) {
        return ResponseEntity.badRequest().body("Debe seleccionar una imagen para el producto.");
      }

      byte[] imagenBytes = file.getBytes();

      Productos producto = new Productos();
      producto.setNombre_producto(nombreProducto);
      producto.setDescripcion_producto(descripcionProducto);
      producto.setEstado_producto(estadoProducto);
      producto.setPrecio_producto(precioProducto);
      producto.setImagen_producto(imagenBytes);

      Categorias categoria = categoriasService.getCategoria(idCategoria);
      if (categoria == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontró la categoría con el ID proporcionado");
      }
      Porciones porcion = porcionesService.getPorcion(idPorcion);
      Rellenos relleno = rellenosService.getRelleno(idRelleno);

      producto.setCategoria(categoria);
      producto.setPorcion(porcion);
      producto.setRelleno(relleno);

      productosService.createProducto(producto, file);

      return ResponseEntity.ok("Producto creado exitosamente");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body("Error al crear el producto: " + e.getMessage());
    }
  }

  @PutMapping("/updateProducto/{id}")
  public Productos updateProducto(@PathVariable Long id, @RequestBody Productos productos) {
    return productosService.updateProducto(id, productos);
  }

  @DeleteMapping("/deleteProducto/{id}")
  public void deleteProducto(@PathVariable Long id) {
    productosService.deleteProducto(id);
  }


}
