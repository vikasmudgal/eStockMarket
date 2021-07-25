package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.CompanyRepository;
import com.example.repository.StocksRepository;
import com.example.model.CompanyDetails;

@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private StocksRepository stocksRepository;
	
	@Override
	public List<CompanyDetails> getCompanies() {
		
		return companyRepository.findAll();
	}
	
	@Override
	public String addCompanyDetails(CompanyDetails companyDetails) {
		
		companyRepository.save(companyDetails);
		return null;
	}
	
	@Transactional
	@Override
	public void deleteCompanyByCompanyId(int companyId) {
		companyRepository.deleteById(companyId);
		stocksRepository.deleteByCompanyId(companyId);
		
	}

	@Override
	public CompanyDetails getCompanyDetails(int companyid) {
		CompanyDetails cd = companyRepository.findById(companyid).get();
		return cd;
	}


}
