package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	@Column(unique=true)
	private String companyCode;
	private String companyName;
	private String description;
	private String ceo;
	//@min (value=100000000)
	private long turnover;
	private String website;
	private String stockExchange;
	private double currentStockPrice;
}
