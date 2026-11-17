package com.d288.tngu928.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
public class Cart {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "cart_id")
    private Long id;

    @Column (name = "package_price")
    private BigDecimal package_price;

    @Column (name = "party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @Column (name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "last_update")
    @UpdateTimestamp        //automatically manage time stamp, thus no calling and setting
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    public void add(CartItem item) {
        if (item != null) {
            if (cartItems == null) {
                cartItems = new HashSet<>();
            }
            cartItems.add(item);
            item.setCart(this);
        }
    }

    @ManyToOne
    @JoinColumn (name = "customer_id", nullable = false)
    private Customer customer;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPackage_price(BigDecimal package_price) {
        this.package_price = package_price;
    }

    public void setParty_size(int party_size) {
        this.party_size = party_size;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
