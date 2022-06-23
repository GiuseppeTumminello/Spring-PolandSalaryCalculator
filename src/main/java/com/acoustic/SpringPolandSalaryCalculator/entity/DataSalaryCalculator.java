package com.acoustic.SpringPolandSalaryCalculator.entity;


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;


@Entity
@Builder
@Getter
@Table(name = "salary_calculator_spring")
public class DataSalaryCalculator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    @Column(name = "pension_zus")
    private BigDecimal pensionZus;
    @Column(name = "disability_zus")
    private BigDecimal disabilityZus;
    @Column(name = "sickness_zus")
    private BigDecimal sicknessZus;
    @Column(name = "total_zus")
    private BigDecimal totalZus;
    @Column
    private BigDecimal health;
    @Column(name = "gross_yearly")
    private BigDecimal annualGross;
    @Column(name = "tax")
    private BigDecimal tax;
    @Column(name = "net_monthly")
    private BigDecimal netMonthly;
    @Column(name = "net_yearly")
    private BigDecimal annualNet;
    @Column(name = "gross_monthly")
    private BigDecimal grossMonthly;
    @Column(name = "job_title")
    private String jobTitle;

}




