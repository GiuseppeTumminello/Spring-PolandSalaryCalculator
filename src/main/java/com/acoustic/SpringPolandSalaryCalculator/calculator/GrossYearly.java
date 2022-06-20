package com.acoustic.SpringPolandSalaryCalculator.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acoustic.SpringPolandSalaryCalculator.rates.Rates;


@Component
@Primary
public class GrossYearly implements SalaryCalculatorService{

    @Override
    public String getDescription() {
        return "Yearly gross: ";
    }

    @Override
    public BigDecimal apply(final BigDecimal grossMonthlySalary) {
       return grossMonthlySalary.multiply(BigDecimal.valueOf(Rates.MONTH_NUMBER.getRate())).setScale(2, RoundingMode.HALF_EVEN);
    }
}
