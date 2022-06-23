package com.acoustic.SpringPolandSalaryCalculator;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.acoustic.SpringPolandSalaryCalculator.jobcategories.JobCategories;
import com.fasterxml.jackson.databind.ObjectMapper;


//@WebMvcTest(SalaryCalculatorController.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SalaryCalculatorControllerGetTest {

    private final String DEPARTMENT_NAME_ENDPOINT = "/getJobDepartment";
    private final String IT_JOB_TITLE_ENDPOINT = "/getJobTitles/it";
    private final String FINANCE_JOB_TITLE_ENDPOINT = "/getJobTitles/finance";
    private final String ENGINEER_JOB_TITLE_ENDPOINT = "/getJobTitles/engineer";
    private final String RESTAURANT_JOB_TITLE_ENDPOINT = "/getJobTitles/restaurant";
    private final String AIRLINE_JOB_TITLE_ENDPOINT = "/getJobTitles/airline";


    @Autowired
    private JobCategories jobCategories;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void getDepartmentName() throws Exception {
        String expected = objectMapper.writeValueAsString(jobCategories.getJobDepartmentAndTitles()
                .entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()));


        var actual = mockMvc.perform(get(DEPARTMENT_NAME_ENDPOINT).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(actual.length()).isEqualTo(expected.length());

    }


    @Test
    public void getJobTitlesIt() throws Exception {
        String expected = objectMapper.writeValueAsString(List.of(jobCategories.getJobDepartmentAndTitles()
                .get("it")
                .split(",")));
        var actual = mockMvc.perform(get(IT_JOB_TITLE_ENDPOINT).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(actual.length()).isEqualTo(expected.length());

    }

    @Test
    public void getJobTitlesFinance() throws Exception {
        String expected = objectMapper.writeValueAsString(List.of(jobCategories.getJobDepartmentAndTitles()
                .get("finance")
                .split(",")));
        var actual = mockMvc.perform(get(FINANCE_JOB_TITLE_ENDPOINT).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(actual.length()).isEqualTo(expected.length());

    }

    @Test
    public void getJobTitlesEngineer() throws Exception {
        String expected = objectMapper.writeValueAsString(List.of(jobCategories.getJobDepartmentAndTitles()
                .get("engineer")
                .split(",")));
        var actual = mockMvc.perform(get(ENGINEER_JOB_TITLE_ENDPOINT).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(actual.length()).isEqualTo(expected.length());

    }

    @Test
    public void getJobTitlesRestaurant() throws Exception {
        String expected = objectMapper.writeValueAsString(List.of(jobCategories.getJobDepartmentAndTitles()
                .get("restaurant")
                .split(",")));
        var actual = mockMvc.perform(get(RESTAURANT_JOB_TITLE_ENDPOINT).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(actual.length()).isEqualTo(expected.length());

    }


    @Test
    public void getJobTitlesAirline() throws Exception {
        String expected = objectMapper.writeValueAsString(List.of(jobCategories.getJobDepartmentAndTitles()
                .get("airline")
                .split(",")));
        var actual = mockMvc.perform(get(AIRLINE_JOB_TITLE_ENDPOINT).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(actual.length()).isEqualTo(expected.length());

    }

}
