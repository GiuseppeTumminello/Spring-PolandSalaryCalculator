package com.acoustic.SpringPolandSalaryCalculator.rates;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Rates {
    PENSION_ZUS_RATE(0.0976d),
    DISABILITY_ZUS_RATE(0.0150d),
    SICKNESS_ZUS_RATE(0.0245d),
    TOTAL_ZUS_RATE(0.1371d),
    HEALTH_RATE(0.09d),
    GROSS_YEARLY_RATE(12.0d),
    TAX_RATE_17(0.0832d),
    TAX_RATE_32(0.1432d),
    TAX_GROSS_AMOUNT_TRASHOLD(120000.0d),
    MONTH_NUMBER(12.0d),
    MINIMUM_SALARY(2000.00d);

    private final double rate;
}
