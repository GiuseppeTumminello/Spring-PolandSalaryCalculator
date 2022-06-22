package com.acoustic.SpringPolandSalaryCalculator.jobcategories;

import java.util.List;

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
@PropertySource("jobcategory.properties")

@Component
public class JobCategories {
    @Value("#{'${it}'.split(',')}")
     List<String> jobTitles;

}
