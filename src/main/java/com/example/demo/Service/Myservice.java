package com.example.demo.Service;
import com.example.demo.Bean.Chocolate;
import com.example.demo.Service.Exception.ChocolateNotFoundException;

import java.util.List;

import javax.validation.Valid;
public interface Myservice {
		List<Chocolate> DisplayAll();
		Chocolate addChoco(Chocolate c) throws ChocolateNotFoundException;
		String deleteChocolate(Integer id) throws ChocolateNotFoundException;
		String updateChocolate(Integer id, @Valid Chocolate choco) throws ChocolateNotFoundException;
		
		
		
	   
	}
