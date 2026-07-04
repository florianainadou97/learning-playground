package fr.egym.domain.catalog.controller;

import fr.egym.domain.catalog.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @GetMapping("")
  public List<Product> getProducts() {
    return List.of(
      new Product("1", "Product 1", "Description 1", 10.0),
      new Product("2", "Product 2", "Description 2", 20.0),
      new Product("3", "Product 3", "Description 3", 30.0)
    );
  }

}
