package com.pocimp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pocimp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Integer>{

	List<Product> findAll();

}
