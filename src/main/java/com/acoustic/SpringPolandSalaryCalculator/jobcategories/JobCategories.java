package com.acoustic.SpringPolandSalaryCalculator.jobcategories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@PropertySource("jobtitles.properties")
@ConfigurationProperties(prefix = "jobs")
@Component
public class JobCategories {



     List<String> jobTitles = new ArrayList<>();

}
