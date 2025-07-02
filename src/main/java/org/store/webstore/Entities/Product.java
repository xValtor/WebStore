package org.store.webstore.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Имя товара не может быть короче 3 символов")
    @Size(min = 3,max = 50)
    private String name;
    @Column(nullable=true)
    private String description;
    private double price;
    private int summaryQuantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSummaryQuantity(int summaryQuantity) {
        this.summaryQuantity = summaryQuantity;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getSummaryQuantity() {
        return summaryQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
