package com.acoustic.SpringPolandSalaryCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.function.LongFunction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import com.acoustic.SpringPolandSalaryCalculator.calculatorservice.AnnualNetService;
import lombok.RequiredArgsConstructor;







@SpringBootTest
@RequiredArgsConstructor
public class AnnualNetServiceTest {
    private final  AnnualNetService annualNetService;

    @ParameterizedTest
    @CsvSource({"6000, 51833,28", "7000, 60468", "15891.68, 190700.16"})
    void getAnnualNetSalary(BigDecimal input, BigDecimal expected){
        System.out.println(input);
        assertThat(annualNetService.apply(input)).isEqualTo(expected);

    }





}
