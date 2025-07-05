package org.store.webstore.Entities;

import jakarta.persistence.*;

@Entity
public class ProductDescription {
    @Id @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String text;
}
