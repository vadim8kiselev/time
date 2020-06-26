package com.kiselev.time.model.dto.internal;

import com.google.common.collect.Sets;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "profile")
public class Profile implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @JoinColumn(name = "profile_id")
    @OneToMany(cascade = CascadeType.ALL,
               orphanRemoval = true)
    private Set<Income> incomes = Sets.newLinkedHashSet();

    private Long spending;

    private Integer age;

    @Column(nullable = false)
    private boolean anonymous;

    public Profile(Profile profile) {
        this.id = profile.getId();
        this.username = profile.getUsername();
        this.password = profile.getPassword();
        this.incomes = profile.getIncomes();
        this.spending = profile.getSpending();
        this.age = profile.getAge();
        this.anonymous = profile.isAnonymous();
    }
}
