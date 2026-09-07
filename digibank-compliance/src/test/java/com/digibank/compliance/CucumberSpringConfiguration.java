package com.digibank.compliance;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = com.digibank.compliance.service.ComplianceService.class)
public class CucumberSpringConfiguration {
}
