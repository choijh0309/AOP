package com.codestates.burgerqueenspring;

import com.codestates.burgerqueenspring.order.Order;
import com.codestates.burgerqueenspring.order.OrderApp;
import com.codestates.burgerqueenspring.product.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurer.class);

        ProductRepository productRepository = applicationContext.getBean("productRepository", ProductRepository.class);
        Menu menu = applicationContext.getBean("menu", Menu.class);
        Cart cart = applicationContext.getBean("cart", Cart.class);
        Order order = applicationContext.getBean("order", Order.class);


        OrderApp orderApp = new OrderApp(
                productRepository,
                menu,
                cart,
                order
        );

        orderApp.start();
    }
}