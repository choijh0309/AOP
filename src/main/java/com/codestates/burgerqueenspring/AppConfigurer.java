package com.codestates.burgerqueenspring;

import com.codestates.burgerqueenspring.aop.LoggingAspect;
import com.codestates.burgerqueenspring.discount.Discount;
import com.codestates.burgerqueenspring.order.Order;
import com.codestates.burgerqueenspring.product.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfigurer {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public Cart cart(){
        return new Cart(productRepository(), menu());
    }

    @Bean
    public Menu menu() {
        return new Menu(productRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    public Order order() {
        return new Order(cart(), discount());
    }

    @Bean
    public Discount discount() {
        return new Discount();
    }

}
