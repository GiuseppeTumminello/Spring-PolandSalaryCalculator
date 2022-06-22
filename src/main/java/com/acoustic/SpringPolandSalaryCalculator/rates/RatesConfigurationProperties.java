package com.acoustic.SpringPolandSalaryCalculator.rates;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@PropertySource("rates.properties")
@Component
@NoArgsConstructor
public class RatesConfigurationProperties {


    private  BigDecimal pensionZusRate;

    private  BigDecimal disabilityZusRate;

    private  BigDecimal sicknessZusRate;

    private  BigDecimal totalZusRate;

    private  BigDecimal healthRate;

    private  BigDecimal taxRate17;

    private  BigDecimal taxRate32;

    private  BigDecimal taxGrossAmountTrashold;

    private  BigDecimal monthNumber;

    private  BigDecimal minimumSalary;
}
