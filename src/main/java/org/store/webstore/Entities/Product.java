package org.store.webstore.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.context.annotation.EnableMBeanExport;

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


    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ProductDescription description;

    private double price;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int summaryQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;



    public void setName(String name) {
        this.name = name;
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
