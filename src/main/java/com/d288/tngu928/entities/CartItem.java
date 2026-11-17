package com.d288.tngu928.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CartItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private Set<Excursion> excursions = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }
}
