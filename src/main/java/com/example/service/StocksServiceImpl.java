package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.AddStocksDto;
import com.example.model.CompanyDetails;
import com.example.model.CompanyStocks;
import com.example.repository.CompanyRepository;
import com.example.repository.StocksRepository;

@Service
public class StocksServiceImpl implements StocksService{

	@Autowired
	private StocksRepository stocksRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	
	@Override
	public List<CompanyStocks> getStocks() {
		
		return stocksRepository.findAll();
	}
	@Override
	
	public List<CompanyStocks> getCompanyStocksByDate(int companyCode1, int companyCode2, Date from,
			Date to) {
		
		return stocksRepository.getCompanyStocksByDate(companyCode1, companyCode2, from, to);
	}
	@Override
	public CompanyStocks getCompanyDetails(int companyid) {
		CompanyStocks cs =  stocksRepository.findById(companyid).get();
		return cs;
	}
	@Override
	public void addStockDetails(AddStocksDto companyStocks) {
		int id = companyStocks.getCompanyid();
		CompanyDetails cd = companyRepository.findById(id).get();
		double stocksprice = companyStocks.getStockPrice();
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		CompanyStocks cstocks=new CompanyStocks();
		cstocks.setDate(date);
		cstocks.setCompany(cd);
		cstocks.setStockPrice(stocksprice);
		stocksRepository.save(cstocks);
	}
	@Override
	public List<CompanyStocks> getStockPriceBetween(int companyid, Date from, Date to) {
		return stocksRepository.getStocksPriceBetween(companyid, from, to);
	}

}
