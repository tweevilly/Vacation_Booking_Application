package com.d288.tngu928.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "customer_id")
    private Long id;

    @Column (name = "address", nullable = false)
    private String address;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "customer_first_name", nullable = false)
    private String firstName;

    @Column (name=  "customer_last_name", nullable = false)
    private String lastName;

    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column (name  = "phone", nullable = false)
    private String phone;

    @Column (name = "postal_code", nullable = false)
    private String postal_code;

    @ManyToOne 
    @JoinColumn (name = "division_id")      //no nullable false
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    public Customer(
            String firstName,       //required constructor to match bootstrap
            String lastName,
            String address,
            String postal_code,
            String phone,
            Division division) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.division = division;
    }

    public Customer() {     //JPA requires no-arg constructor

    }

    public void add(Cart cart) {
        if (cart !=null){
            if (carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }
}
