package com.pocimp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pocimp.entity.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

	Company findByName(String string);

}