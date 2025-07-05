package org.store.webstore.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Review {
    @Id @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int rating;
    private String comment;
    private LocalDate reviewDate;

    public Review() {}
    public Review(User user, Product product, int rating, String comment) {
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = LocalDate.now();
    }

}
