package com.acoustic.SpringPolandSalaryCalculator;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acoustic.SpringPolandSalaryCalculator.calculator.HealthInsurance;
import com.acoustic.SpringPolandSalaryCalculator.calculator.MonthlyNet;
import com.acoustic.SpringPolandSalaryCalculator.calculator.SalaryCalculatorService;
import com.acoustic.SpringPolandSalaryCalculator.calculator.TaxAmount;
import com.acoustic.SpringPolandSalaryCalculator.calculator.TotalZus;


@SpringBootApplication
public class SpringPolandSalaryCalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringPolandSalaryCalculatorApplication.class, args);

    }

}
