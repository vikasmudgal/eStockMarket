package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.CompanyDetails;

public interface CompanyRepository extends JpaRepository<CompanyDetails, Integer>{

}
