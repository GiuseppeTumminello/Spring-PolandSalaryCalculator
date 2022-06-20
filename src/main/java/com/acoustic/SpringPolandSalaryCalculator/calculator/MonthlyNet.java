package com.acoustic.SpringPolandSalaryCalculator.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
public class MonthlyNet implements SalaryCalculatorService {

    private final TotalZus totalZus;
    private final TaxAmount taxAmount;
    private final HealthInsurance healthInsurance;

    public MonthlyNet() {
        this.totalZus = new TotalZus();
        this.taxAmount = new TaxAmount();
        this.healthInsurance = new HealthInsurance();
    }

    @Override
    public String getDescription() {
        return "Monthly net";
    }

    @Override
    public BigDecimal apply(BigDecimal grossMonthlySalary) {
        return grossMonthlySalary.subtract(totalZus.apply(grossMonthlySalary))
                .subtract((taxAmount.apply(grossMonthlySalary)))
                .subtract(healthInsurance.apply(grossMonthlySalary))
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}
