package com.acoustic.SpringPolandSalaryCalculator.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acoustic.SpringPolandSalaryCalculator.calculatorservice.SalaryCalculatorService;
import com.acoustic.SpringPolandSalaryCalculator.entity.DataSalaryCalculator;
import com.acoustic.SpringPolandSalaryCalculator.exception.NotValidSalaryException;
import com.acoustic.SpringPolandSalaryCalculator.jobcategories.JobCategories;
import com.acoustic.SpringPolandSalaryCalculator.rates.RatesConfigurationProperties;
import com.acoustic.SpringPolandSalaryCalculator.service.DataSalaryCalculatorRepository;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class SalaryCalculatorController {

    private final DataSalaryCalculatorRepository dataSalaryCalculatorRepository;
    private final List<SalaryCalculatorService> salaryCalculatorService;
    private DataSalaryCalculator dataSalaryCalculator;
    private final RatesConfigurationProperties rates;
    private final JobCategories jobCategories;


    @GetMapping("/getJobTitles")
    public Map<Integer, String> getJobTitles(){
        Integer count = 1;
        Map<Integer, String> jobTitleMap = new TreeMap<>();
        for (var jobTitle: jobCategories.getJobTitles()){
            jobTitleMap.put(count++, jobTitle);
        }
        return jobTitleMap;
    }



    @PostMapping("/calculate/{grossMonthlySalary}")
    public Map<String, BigDecimal> calculate(@PathVariable BigDecimal grossMonthlySalary, @RequestParam(defaultValue = "0") int id) {
        if (id < jobCategories.getJobTitles().size() && id > 0) {
            DataSalaryCalculator data = setEntityField(grossMonthlySalary,jobCategories.getJobTitles().get(id-1));
            dataSalaryCalculatorRepository.save(data);
            System.out.println(dataSalaryCalculatorRepository.findJobTitles(jobCategories.getJobTitles().get(id-1)));

        }

        if (grossMonthlySalary.compareTo(rates.getMinimumSalary()) > 0) {
            return salaryCalculatorService.stream()
                    .collect(Collectors.toMap(SalaryCalculatorService::getDescription,
                            e -> e.apply(grossMonthlySalary)));
        } else {
            throw new NotValidSalaryException("Not valid value");
        }
    }

    public Map<String, BigDecimal> calculateNetSalary(@PathVariable BigDecimal grossMonthlySalary, @RequestParam(defaultValue = "0") int id) {
        if (id < jobCategories.getJobTitles().size() && id > 0) {

            DataSalaryCalculator data = setEntityField(grossMonthlySalary,jobCategories.getJobTitles().get(id-1));
            dataSalaryCalculatorRepository.save(data);



        }


        if (grossMonthlySalary.compareTo(rates.getMinimumSalary()) > 0) {
            return salaryCalculatorService.stream()
                    .collect(Collectors.toMap(SalaryCalculatorService::getDescription,
                            e -> e.apply(grossMonthlySalary)));
        } else {
            throw new NotValidSalaryException("Not valid value");

        }
    }




    private DataSalaryCalculator setEntityField(BigDecimal grossMonthlySalary, String jobTitle) {
        return dataSalaryCalculator = DataSalaryCalculator.builder().
                annualGross(salaryCalculatorService.get(0).apply(grossMonthlySalary))
                .annualNet(salaryCalculatorService.get(1).apply(grossMonthlySalary))
                .disabilityZus(salaryCalculatorService.get(2).apply(grossMonthlySalary))
                .health(salaryCalculatorService.get(3).apply(grossMonthlySalary))
                .netMonthly(salaryCalculatorService.get(4).apply(grossMonthlySalary))
                .pensionZus(salaryCalculatorService.get(5).apply(grossMonthlySalary))
                .sicknessZus(salaryCalculatorService.get(6).apply(grossMonthlySalary))
                .tax(salaryCalculatorService.get(7).apply(grossMonthlySalary))
                .totalZus(salaryCalculatorService.get(8).apply(grossMonthlySalary))
                .grossMonthly(grossMonthlySalary)
                .jobTitle(jobTitle)
                .build();
    }

}
