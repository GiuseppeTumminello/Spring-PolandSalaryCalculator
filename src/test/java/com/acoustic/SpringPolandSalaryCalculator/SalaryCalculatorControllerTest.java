package com.acoustic.SpringPolandSalaryCalculator;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//@WebMvcTest(SalaryCalculatorController.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SalaryCalculatorControllerTest {

    private final String DEPARTMENT_NAME_ENDPOINT = "/getJobDepartment";
    private final String IT_JOB_TITLE_ENDPOINT = "/getJobDepartment/it";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;



    @Test
    public void getDepartmentName() throws Exception {
        String expected = objectMapper.writeValueAsString(List.of("it","finance", "engineer", "restaurant", "airline"));
        var actual = mockMvc.perform(get(DEPARTMENT_NAME_ENDPOINT).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(expected)).andReturn().getResponse().getContentAsString();
        assertThat(actual.length()).isEqualTo(expected.length());

    }


    @Test
    public void getJobTitlesIt() throws Exception {
        String expected = objectMapper.writeValueAsString(List.of("DevOps Engineer","Software Developer",Cloud System Engineer,Cloud Architect,Network Engineer,IT Support Specialist,Database Administrator,System Architect,Web Administrator,Software Engineer',"));
        var actual = mockMvc.perform(get(IT_JOB_TITLE_ENDPOINT).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(expected)).andReturn().getResponse().getContentAsString();
        assertThat(actual.length()).isEqualTo(expected.length());

    }

}
