package fr.egym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketplaceApplication {
   public static void main(String[] args) {
    // This spins up the Spring Context and starts an embedded Tomcat server (default port 8080)
    SpringApplication.run(MarketplaceApplication.class, args);
  }
}