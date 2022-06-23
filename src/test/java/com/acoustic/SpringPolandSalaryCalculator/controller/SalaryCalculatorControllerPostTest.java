package com.acoustic.SpringPolandSalaryCalculator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.acoustic.SpringPolandSalaryCalculator.jobcategories.JobCategories;
import com.acoustic.SpringPolandSalaryCalculator.service.DataSalaryCalculatorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class SalaryCalculatorControllerPostTest {

    @Autowired
    private DataSalaryCalculatorRepository dataSalaryCalculatorRepository;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void getSalaryCalculation(){

    }









}
