package org.store.webstore.Services;

import org.springframework.stereotype.Service;
import org.store.webstore.Entities.*;
import org.store.webstore.Repositories.*;

import java.util.List;

@Service
public class WebStoreService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;

    public WebStoreService(ProductRepository productRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, OrderItemRepository orderItemRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
    }
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    public List<OrderItem> getOrdersByUser(User user) {
        int userId = user.getId();
        return orderItemRepository.findByOrderUserId(userId);
    }
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
    public List<OrderItem> getOrderItemsByOrder(Order order) {
        int orderId = order.getId();
        return orderItemRepository.findByOrderId(orderId);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }
    public Order getOrderById(User user) {
        return orderRepository.findById(user.getId()).get();
    }
    public List<Product> getCategoryById(Category category) {
        int categoryId = category.getId();
        return productRepository.findByCategoryId(categoryId);
    }
}
