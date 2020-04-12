package com.kiselev.time.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(unique = true, nullable = false)
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Long salary;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private Integer tax;

    private Integer hours;

    private Integer age;

    @Column(nullable = false)
    private boolean anonymous;

    public Profile(Profile profile) {
        this.id = profile.getId();
        this.username = profile.getUsername();
        this.password = profile.getPassword();
        this.salary = profile.getSalary();
        this.currency = profile.getCurrency();
        this.tax = profile.getTax();
        this.hours = profile.getHours();
        this.age = profile.getAge();
        this.anonymous = profile.isAnonymous();
    }
}
