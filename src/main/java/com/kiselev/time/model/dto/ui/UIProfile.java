package com.kiselev.time.model.dto.ui;

import com.google.common.collect.Lists;
import com.kiselev.time.model.dto.db.Income;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UIProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private List<Income> incomes =
            Lists.newArrayList();

    private Long spending;

    private Integer age;

    private boolean anonymous;
}
