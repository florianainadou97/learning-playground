package fr.egym.domain.catalog.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String id;
  @Column(nullable = false)
  String name;
  String description;
  @Column(nullable = false)
  double price;
}
