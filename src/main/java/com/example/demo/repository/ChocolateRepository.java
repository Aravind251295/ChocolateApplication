package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Bean.Chocolate;

@Repository
public interface ChocolateRepository extends JpaRepository<Chocolate,Integer>{
	

}
