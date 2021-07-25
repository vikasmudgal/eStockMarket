package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CompanyDetails;
import com.example.service.CompanyService;
@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyController {



	@Autowired
	private CompanyService companyService;
	
	@PostMapping(value="/add")
	public String addCourseDetails(@RequestBody CompanyDetails companyDetails)  {
		companyService.addCompanyDetails(companyDetails);
		return "added successfully";
	}
	
	@GetMapping("/all")
	public List<CompanyDetails> getCompanies(){
		return companyService.getCompanies();
	}
	
	@DeleteMapping("/{code}")
	public String deleteCompany (@PathVariable("code") int companyId ){
		companyService.deleteCompanyByCompanyId(companyId);
		return "Company deleted with all its stocks details";
	}

@GetMapping("/{companyid}")
	public CompanyDetails getStockDetails(@PathVariable("companyid") int companyid){
		return companyService.getCompanyDetails(companyid);
	}

}
