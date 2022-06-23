package com.acoustic.SpringPolandSalaryCalculator.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.acoustic.SpringPolandSalaryCalculator.SpringPolandSalaryCalculatorApplication;


@AutoConfigureMockMvc
 @WebMvcTest
 @ContextConfiguration(classes = {SalaryCalculatorController.class, SpringPolandSalaryCalculatorApplication.class})
class SalaryCalculatorControllerTest {

     @InjectMocks
     private SalaryCalculatorController salaryCalculatorController;
   
    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }
     @Test
    public void getDepartmentId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getJobDepartment")).andExpect(status().isOk());
    }

}
