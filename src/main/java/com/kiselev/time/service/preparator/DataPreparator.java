package com.kiselev.time.service.preparator;

import com.google.common.collect.Sets;
import com.kiselev.time.model.dto.db.Income;
import com.kiselev.time.model.dto.db.Profile;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DataPreparator {

    public static Set<Income> prepareIncomes(List<Income> incomes) {
        if (incomes != null) {
            return incomes.stream()
                    .filter(DataPreparator::filterIncome)
                    .collect(Collectors.toCollection(
                            LinkedHashSet::new
                    ));
        }
        return Sets.newLinkedHashSet();
    }

    private static boolean filterIncome(Income income) {
        return income.getMoney() != null
            && income.getCurrency() != null
            && income.getTax() != null;

    }
}
