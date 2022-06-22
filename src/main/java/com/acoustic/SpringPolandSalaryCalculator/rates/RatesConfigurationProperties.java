package com.acoustic.SpringPolandSalaryCalculator.rates;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@ConfigurationProperties(prefix = "rate")
@PropertySource("rates.properties")
@Component
public class RatesConfigurationProperties {


    private  BigDecimal pensionZusRate;

    private  BigDecimal disabilityZusRate;

    private  BigDecimal sicknessZusRate;

    private  BigDecimal totalZusRate;

    private  BigDecimal healthRate;

    private  BigDecimal taxRate17Rate;

    private  BigDecimal taxRate32Rate;

    private  BigDecimal taxGrossAmountTrashold;
    private  BigDecimal monthNumber;

    private  BigDecimal minimumSalary;
}
