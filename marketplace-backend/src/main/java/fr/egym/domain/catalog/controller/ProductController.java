package fr.egym.domain.catalog.controller;

import fr.egym.domain.catalog.dto.ProductDto;
import fr.egym.domain.catalog.model.Product;
import fr.egym.domain.catalog.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductRepository productRepository;

  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @GetMapping("")
  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  @PostMapping("")
  public String saveProduct(@RequestBody ProductDto product) {
    return productRepository.save(
            new Product(
                    product.id(), product.name(), product.description(), product.price())
      ).getId();
  }

}
