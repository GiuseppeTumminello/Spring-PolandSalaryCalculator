package com.acoustic.SpringPolandSalaryCalculator.jobcategories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@PropertySource("classpath:jobcategories.properties")
@ConfigurationProperties(prefix = "jobs")
@Configuration
public class JobCategories {


     @Value("#{${jobs.jobTitles}}")
     Map<String, String> jobDepartmentAndTitles = new HashMap<>();

}
