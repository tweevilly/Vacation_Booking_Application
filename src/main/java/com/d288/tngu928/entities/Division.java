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
@Table(name = "divisions")
@Getter
@Setter

public class Division {

    @Column (name = "division", nullable = false)
    private String division_name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "division_id")
    private Long id;

    @Column (name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column (name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column (name = "country_id")
    private long country_id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @OneToMany(mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();

}
