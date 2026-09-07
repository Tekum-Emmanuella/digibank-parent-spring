package com.digibank.compliance.api;

import com.digibank.compliance.service.ComplianceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {

    private final ComplianceService service;

    public ComplianceController(ComplianceService service) {
        this.service = service;
    }

    @GetMapping("/validate/{amount}")
    public ResponseEntity<Map<String, Boolean>> validate(@PathVariable("amount") Double amount) {
        boolean isValid = service.validateTransactionAmount(amount);
        return ResponseEntity.ok(Collections.singletonMap("valid", isValid));
    }
}
