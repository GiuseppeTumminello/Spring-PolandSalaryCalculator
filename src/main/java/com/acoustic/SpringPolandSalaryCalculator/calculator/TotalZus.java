package com.acoustic.SpringPolandSalaryCalculator.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acoustic.SpringPolandSalaryCalculator.rates.Rates;

@Component
public class TotalZus implements SalaryCalculatorService{

    @Override
    public String getDescription() {
        return "Total zus: ";
    }

    @Override
    public BigDecimal apply( BigDecimal grossMonthlySalary) {
        return grossMonthlySalary.multiply(BigDecimal.valueOf(Rates.TOTAL_ZUS_RATE.getRate())).setScale(2, RoundingMode.HALF_EVEN);
    }

}
