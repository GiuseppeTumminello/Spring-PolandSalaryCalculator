package com.acoustic.SpringPolandSalaryCalculator.calculator;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

import org.springframework.stereotype.Component;


@Component
public interface SalaryCalculatorService extends UnaryOperator<BigDecimal>{

    String getDescription();

}
