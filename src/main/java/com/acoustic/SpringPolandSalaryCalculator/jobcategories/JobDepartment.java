package com.acoustic.SpringPolandSalaryCalculator.jobcategories;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ConfigurationProperties(prefix = "department")
@PropertySource("jobDepartment.properties")
public class JobDepartment {

    private String it;
    private String finance;
    private String engineer;
    private String restaurant;
    private String airline;
}
