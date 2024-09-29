package com.falynsky.embarkx.app.controllers;

import com.falynsky.embarkx.app.enities.Company;
import com.falynsky.embarkx.app.enities.Job;
import com.falynsky.embarkx.app.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/companies")
public class CompanyController {

    CompanyService companyService;

    @GetMapping()
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.findAll();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}/jobs")
    public ResponseEntity<List<Job>> getJobsByCompanyId(@PathVariable Long id) {
        List<Job> jobs = companyService.findJobsByCompanyId(id);
        return ResponseEntity.ok(jobs);
    }

    @PostMapping()
    public ResponseEntity<Void> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCompany(@RequestBody Company company, @PathVariable Long id) {
        companyService.updateCompany(company, id);
        return ResponseEntity.ok().build();
    }
}
