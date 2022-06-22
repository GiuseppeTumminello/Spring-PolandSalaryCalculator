package com.acoustic.SpringPolandSalaryCalculator;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acoustic.SpringPolandSalaryCalculator.calculatorservice.AnnualGrossService;
import com.acoustic.SpringPolandSalaryCalculator.calculatorservice.SalaryCalculatorService;


@SpringBootApplication
public class SpringPolandSalaryCalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringPolandSalaryCalculatorApplication.class, args);

    }
}
