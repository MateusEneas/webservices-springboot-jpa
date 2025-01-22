package com.eneasdev.webservices.config;

import com.eneasdev.webservices.entities.Category;
import com.eneasdev.webservices.entities.Order;
import com.eneasdev.webservices.entities.Product;
import com.eneasdev.webservices.entities.User;
import com.eneasdev.webservices.entities.enums.OrderStatus;
import com.eneasdev.webservices.repositories.CategoryRepository;
import com.eneasdev.webservices.repositories.OrderRepository;
import com.eneasdev.webservices.repositories.ProductRepository;
import com.eneasdev.webservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Mateus Eneas", "mateus@gmail.com","99999999", "12345");
        User u2 = new User(null, "Eliza Maciel", "eliza@gmail.com", "77777777", "98765");

        Order o1 = new Order(null, Instant.parse("2025-01-04T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2025-01-05T10:30:02Z"), OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2025-01-05T14:13:08Z"), OrderStatus.CANCELED, u1);

        Category cat1 = new Category(null, "Eletronicos");
        Category cat2 = new Category(null, "Computadores");
        Category cat3 = new Category(null, "Livros");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Televisão Smart para você navegar na internet.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Maior eficiencia e sem travamentos.", 5250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Jogue o seu mais sonhado jogo.", 4500.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat3);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat2);
        p3.getCategories().add(cat2);
        p4.getCategories().add(cat2);
        p5.getCategories().add(cat3);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }
}
