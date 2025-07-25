package com.surya.customerledger.company;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/company")
public class CompanyController {

  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @PostMapping
  public void createCompany(@RequestBody @Valid CompanyDto companyDto) throws ExecutionException, InterruptedException {
    companyService.createCompany(companyDto);
  }

  @GetMapping
  public CompanyRepo.NameEmailOnly getCompany() {
    return companyService.getCompany();
  }

  @PutMapping
  public void editCompany(@RequestBody @Valid CompanyDto companyDto) {
    companyService.editCompany(companyDto);
  }

}
