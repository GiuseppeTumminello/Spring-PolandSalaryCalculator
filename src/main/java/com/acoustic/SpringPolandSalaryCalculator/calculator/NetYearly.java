package com.acoustic.SpringPolandSalaryCalculator.calculator;

import java.math.BigDecimal;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acoustic.SpringPolandSalaryCalculator.rates.Rates;

@Component
public class NetYearly implements SalaryCalculatorService{
    private final MonthlyNet monthlyNet;

    public NetYearly() {
        this.monthlyNet = new MonthlyNet();
    }

    @Override
    public String getDescription() {
        return "Monthly net: ";
    }

    @Override
    public BigDecimal apply(BigDecimal grossMonthlySalary) {
        return monthlyNet.apply(grossMonthlySalary).multiply(BigDecimal.valueOf(Rates.MONTH_NUMBER.getRate()));
    }
}
