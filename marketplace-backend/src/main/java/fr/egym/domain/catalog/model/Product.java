package fr.egym.domain.catalog.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
  String id;
  String name;
  String description;
  double price;
}
