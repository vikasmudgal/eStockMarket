package com.example.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.CompanyStocks;

public interface StocksRepository extends JpaRepository<CompanyStocks, Integer> {

	@Query("from CompanyStocks where (company.companyId=:ccode1 or company.companyId=:ccode2) and date between :from and :to order by date")
	List<CompanyStocks> getCompanyStocksByDate(@Param("ccode1") int companyCode1,@Param("ccode2") int companyCode2,
			@Param("from") Date from,@Param("to") Date to);

	@Modifying
	@Query(value="delete from CompanyStocks where company_companyId=?1",nativeQuery = true)
	void deleteByCompanyId(int companyId);

	@Query("from CompanyStocks where (company.companyId=:cid) and date between :from and :to order by date")
	List<CompanyStocks> getStocksPriceBetween(@Param("cid") int companyid,
			@Param("from") Date from,@Param("to") Date to);
}
