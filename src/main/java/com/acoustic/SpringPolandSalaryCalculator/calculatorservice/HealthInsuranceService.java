package com.acoustic.SpringPolandSalaryCalculator.calculatorservice;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.acoustic.SpringPolandSalaryCalculator.rates.RatesConfigurationProperties;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class HealthInsuranceService implements SalaryCalculatorService {

    private final RatesConfigurationProperties rate;

    @Override
    public BigDecimal apply(final BigDecimal grossMonthlySalary) {
        return grossMonthlySalary.subtract(grossMonthlySalary.multiply(rate.getTotalZusRate()))
                .multiply(rate.getHealthRate()).setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getDescription() {
        return "Health insurance";
    }
}
