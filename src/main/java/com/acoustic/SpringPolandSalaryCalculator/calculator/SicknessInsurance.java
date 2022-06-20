package com.acoustic.SpringPolandSalaryCalculator.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acoustic.SpringPolandSalaryCalculator.rates.Rates;

@Component
public class SicknessInsurance implements SalaryCalculatorService{

    @Override
    public BigDecimal apply(final BigDecimal bigDecimal) {
        return bigDecimal.multiply(BigDecimal.valueOf(Rates.SICKNESS_ZUS_RATE.getRate())).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getDescription() {
        return "Sickness insurance: ";
    }
}
