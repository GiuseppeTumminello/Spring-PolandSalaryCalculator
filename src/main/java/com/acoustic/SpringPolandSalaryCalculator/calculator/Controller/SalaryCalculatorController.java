package com.acoustic.SpringPolandSalaryCalculator.calculator.Controller;

import static java.util.stream.Collectors.toCollection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acoustic.SpringPolandSalaryCalculator.calculator.SalaryCalculatorService;


@RestController
public class SalaryCalculatorController {


    private final List<SalaryCalculatorService> salaryCalculatorService;
    @Autowired
    public SalaryCalculatorController(List<SalaryCalculatorService> salaryCalculatorService) {
        this.salaryCalculatorService = salaryCalculatorService;
    }

    @GetMapping("/getAll")
    public List<BigDecimal> getAll(){
        List<BigDecimal> b = new LinkedList<>();
        for (var a : salaryCalculatorService){
            b.add(a.apply(BigDecimal.valueOf(6000)));

        }
        return b;
    }

}
