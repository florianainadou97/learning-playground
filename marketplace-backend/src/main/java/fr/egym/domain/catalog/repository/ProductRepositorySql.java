package fr.egym.domain.catalog.repository;

import fr.egym.domain.catalog.model.Product;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.Optional;

@ApplicationScope
public class ProductRepositorySql {

//  @Override
  public List<Product> findAll() {
    return List.of();
  }

//  @Override
  public Optional<Product> findById(String id) {
    return Optional.empty();
  }
}
