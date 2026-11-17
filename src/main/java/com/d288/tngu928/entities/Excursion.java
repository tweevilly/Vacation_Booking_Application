package com.d288.tngu928.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "excursions")

public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "excursion_id")
    private Long id;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "excursion_price")
    private BigDecimal excursion_price;

    @Column (name = "excursion_title")
    private String excursion_title;

    @Column (name = "image_url")
    private String image_URL;

    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "excursions")
    private Set<CartItem> cartItems = new HashSet<>();

    public Excursion(Long id, Date create_date, BigDecimal excursion_price, String excursion_title, String image_URL, Date last_update, Vacation vacation, Set<CartItem> cartItems) {
        this.id = id;
        this.create_date = create_date;
        this.excursion_price = excursion_price;
        this.excursion_title = excursion_title;
        this.image_URL = image_URL;
        this.last_update = last_update;
        this.vacation = vacation;
        this.cartItems = cartItems;
    }

    public Excursion() {
    }

}
