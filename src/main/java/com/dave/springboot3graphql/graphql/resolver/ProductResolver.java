package com.dave.springboot3graphql.graphql.resolver;//package com.amalitec.amalitececom.graphql.resolver;
//
//
//import com.amalitec.amalitececom.exception.OrderNotFoundException;
//import com.amalitec.amalitececom.model.Order;
//import com.amalitec.amalitececom.model.Product;
//import com.amalitec.amalitececom.repository.ProductRepository;
//import graphql.kickstart.tools.GraphQLResolver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class ProductResolver implements GraphQLResolver<Order> {
//    @Autowired
//    private ProductRepository productRepository;
//
//
//
//    public Product getProduct(Order order) {
//        final Long orderId = order.getProducts().get(0).getOrder().getId();
//        return productRepository.findById(orderId)
//                .orElseThrow(() -> new OrderNotFoundException(orderId));
//    }
//}
