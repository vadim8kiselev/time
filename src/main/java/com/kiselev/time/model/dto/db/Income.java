package com.kiselev.time.model.dto.db;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "income")
public class Income implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long money;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private Integer tax;

    @Column(nullable = false)
    private boolean main;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    private Profile profile;
}
