package com.example.service;

import java.util.List;

import com.example.model.CompanyDetails;

public interface CompanyService {

	public List<CompanyDetails> getCompanies();
	public String addCompanyDetails(CompanyDetails companyDetails);
	public void deleteCompanyByCompanyId(int companyId);
 	public CompanyDetails getCompanyDetails(int companyId);
}
