package com.acoustic.SpringPolandSalaryCalculator.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.acoustic.SpringPolandSalaryCalculator.rates.Rates;

@Component
public class PensionInsurance implements SalaryCalculatorService {


    @Override
    public BigDecimal apply(BigDecimal bigDecimal) {
        return BigDecimal.valueOf(Rates.DISABILITY_ZUS_RATE.getRate()).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getDescription() {
        return "Pension insurance: ";
    }
}
