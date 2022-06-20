package com.acoustic.SpringPolandSalaryCalculator.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acoustic.SpringPolandSalaryCalculator.rates.Rates;

@Component
public class TaxAmount implements SalaryCalculatorService {


    private final TotalZus totalZus;
    private final HealthInsurance healthInsurance;

    public TaxAmount() {
        this.totalZus = new TotalZus();
        this.healthInsurance = new HealthInsurance();
    }

    @Override
    public BigDecimal apply(BigDecimal grossMonthlySalary) {
        return (grossMonthlySalary.multiply(grossMonthlySalary)
                .compareTo(BigDecimal.valueOf(Rates.TAX_GROSS_AMOUNT_TRASHOLD.getRate())) < 0)
                ? getTaxAmountBasedOnRate(grossMonthlySalary, Rates.TAX_RATE_32)
                : getTaxAmountBasedOnRate(grossMonthlySalary, Rates.TAX_RATE_17);
    }

    @Override
    public String getDescription() {
        return "Tax amount: ";
    }


    private BigDecimal getTaxAmountBasedOnRate(BigDecimal grossMonthlySalary, Rates rate) {
        return grossMonthlySalary.subtract(totalZus.apply(grossMonthlySalary))
                .subtract(healthInsurance.apply(grossMonthlySalary))
                .multiply(BigDecimal.valueOf(rate.getRate()))
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}
