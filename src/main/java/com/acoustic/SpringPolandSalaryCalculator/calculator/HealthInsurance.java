package com.acoustic.SpringPolandSalaryCalculator.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acoustic.SpringPolandSalaryCalculator.rates.Rates;

@Component
public class HealthInsurance implements SalaryCalculatorService{
    @Autowired
    SalaryCalculatorService salaryCalculatorService;

    @Override
    public BigDecimal apply(final BigDecimal grossMonthlySalary) {
        return grossMonthlySalary.subtract(grossMonthlySalary.multiply(BigDecimal.valueOf(Rates.TOTAL_ZUS_RATE.getRate())))
                .multiply(BigDecimal.valueOf(Rates.HEALTH_RATE.getRate()))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getDescription() {
        return "Health insurance: ";
    }
}
