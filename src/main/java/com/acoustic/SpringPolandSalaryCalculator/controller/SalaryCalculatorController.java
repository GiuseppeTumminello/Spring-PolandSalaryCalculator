package com.acoustic.SpringPolandSalaryCalculator.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acoustic.SpringPolandSalaryCalculator.calculatorservice.SalaryCalculatorService;
import com.acoustic.SpringPolandSalaryCalculator.entity.DataSalaryCalculator;
import com.acoustic.SpringPolandSalaryCalculator.jobcategories.JobCategories;
import com.acoustic.SpringPolandSalaryCalculator.service.DataSalaryCalculatorRepository;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class SalaryCalculatorController {

    private final DataSalaryCalculatorRepository dataSalaryCalculatorRepository;
    private final List<SalaryCalculatorService> salaryCalculatorService;
    private DataSalaryCalculator dataSalaryCalculator;
    private final JobCategories jobCategories;


    @GetMapping("/getJobTitles/{departmentName}")
    public String[] getJobTitles(@PathVariable String departmentName) {
       return jobCategories.getJobDepartmentAndTitles().get(departmentName).split(",");
    }

     @GetMapping("/getJobDepartment")
     public Set<String> getDepartmentName() {
         return jobCategories.getJobDepartmentAndTitles().keySet();
     }


    @PostMapping("/calculate/{grossMonthlySalary}")
    public Map<String, BigDecimal> getSalaryCalculation(@PathVariable BigDecimal grossMonthlySalary , @RequestParam(defaultValue = "0") String departmentName, @RequestParam(defaultValue = "0") int jobTitleId) {
         var response = salaryCalculatorService.stream()
                 .collect(Collectors.toMap(SalaryCalculatorService::getDescription, e -> e.apply(grossMonthlySalary)));
         if (jobCategories.getJobDepartmentAndTitles().containsKey(departmentName.toLowerCase())) {
             BigDecimal average = statistic(departmentName, jobTitleId, grossMonthlySalary);
            if (average != null) {
                 response.put("Average", average);
             }
         }
         return response;
     }





    private BigDecimal statistic(String departmentName, int jobTitleId, BigDecimal grossMonthlySalary) {
        List<String > jobTitlesList = List.of(jobCategories.getJobDepartmentAndTitles().get(departmentName).split(","));
        if (jobTitleId <= jobTitlesList.size() && jobTitleId > 0) {
            dataSalaryCalculatorRepository.save(buildDataSalaryCalculator(grossMonthlySalary, jobTitlesList.get(jobTitleId - 1)));
            return dataSalaryCalculatorRepository.findAverageByJobTitle(jobTitlesList.get(jobTitleId - 1));

        } else {
            return null;
        }

    }


    private DataSalaryCalculator buildDataSalaryCalculator(BigDecimal grossMonthlySalary, String jobTitle) {
        return dataSalaryCalculator = DataSalaryCalculator.builder()
                .annualGross(salaryCalculatorService.get(0).apply(grossMonthlySalary))
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
