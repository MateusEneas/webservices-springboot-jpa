package com.eneasdev.webservices.config;

import com.eneasdev.webservices.entities.Category;
import com.eneasdev.webservices.entities.Order;
import com.eneasdev.webservices.entities.User;
import com.eneasdev.webservices.entities.enums.OrderStatus;
import com.eneasdev.webservices.repositories.CategoryRepository;
import com.eneasdev.webservices.repositories.OrderRepository;
import com.eneasdev.webservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
