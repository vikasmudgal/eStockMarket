package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.AddStocksDto;
import com.example.model.CompanyStocks;

public interface StocksService {

public List<CompanyStocks> getStocks();
	
	public List<CompanyStocks> getCompanyStocksByDate(int companyCode1,int companyCode2,Date from,Date to);
	
	public CompanyStocks getCompanyDetails(@PathVariable("companyid") int companyid);

	public void addStockDetails(AddStocksDto companyStocks);

	public List<CompanyStocks> getStockPriceBetween(int companyid, Date from, Date to);
}
