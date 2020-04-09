package com.kiselev.time.model.profile;

import lombok.Data;

@Data
public class Profile {

    private Long salary;

    private String currency;

    private Integer tax = 13;

    private Integer hours = 40;

    private Integer age = 23;
}
