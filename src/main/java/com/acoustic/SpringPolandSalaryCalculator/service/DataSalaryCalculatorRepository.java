package com.acoustic.SpringPolandSalaryCalculator.service;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acoustic.SpringPolandSalaryCalculator.entity.DataSalaryCalculator;


public interface DataSalaryCalculatorRepository extends JpaRepository<DataSalaryCalculator, Integer> {

    @Query(value = "select avg(gross_monthly) from salary_calculator_spring where job_title=:jobTitle", nativeQuery = true)
    BigDecimal findAverageByJobTitle(@Param("jobTitle") String jobTitle);



}
