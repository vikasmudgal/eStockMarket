package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.AddStocksDto;
import com.example.model.CompanyStocks;
import com.example.service.StocksService;
@RestController
@CrossOrigin
@RequestMapping
public class StocksController {
	@Autowired
	private StocksService stockService;
	
	@GetMapping("/stock")
	public List<CompanyStocks> getStocks(){
		return stockService.getStocks();
	}
	
	@PostMapping(value="/add")
	public String addStockDetails(@RequestBody AddStocksDto companyStocks)  {
		stockService.addStockDetails(companyStocks);
		return "stock Added Successfully under this company";
	}
	
	@GetMapping("/companydetails/{companyid}")
	public CompanyStocks getCompanyDetails(@PathVariable("companyid") int companyid){
		return stockService.getCompanyDetails(companyid);
	}
		
	@GetMapping("/stockprice/{companyid}/{from}/{to}")
	public List<CompanyStocks> getCompanyDate(@PathVariable("companyid") int companyid, 
			@PathVariable("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from,@PathVariable("to")  @DateTimeFormat(pattern="yyyy-MM-dd") Date to){
		
		return stockService.getStockPriceBetween(companyid,from,to);
	}
}
