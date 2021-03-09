package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.Bean.Chocolate;
import com.example.demo.Service.Exception.ChocolateNotFoundException;
import com.example.demo.repository.ChocolateRepository;

@Component
public class StudentsService implements Myservice {

	@Autowired
	private ChocolateRepository chocolateRepository;

	@Override
	public List<Chocolate> DisplayAll() {
		return chocolateRepository.findAll();

	}

	@Override
	public Chocolate addChoco(Chocolate choco) throws ChocolateNotFoundException {
		List<Chocolate> chocolates = DisplayAll();
			if(chocolates.stream().anyMatch(chocolate->chocolate.getName().equalsIgnoreCase(choco.getName())))
			{
			String err="Chocolate Name Already Found: " + choco.getName();
			errorPage(err);
			throw new ChocolateNotFoundException("Chocolate Name Already Found: " + choco.getName());
			}
		 	 return chocolateRepository.save(choco);
	}

		public String errorPage(String msg) {
		    return "error";
		}
	

	public String updateChocolate(Integer id, Chocolate choco) throws ChocolateNotFoundException {
		if (!chocolateRepository.existsById(id)) {
			errorNotFoundPage();
			throw new ChocolateNotFoundException("Chocolate not found for id: " + id);
		}
		Chocolate c = chocolateRepository.findById(id).get();
		c.setName(choco.getName());
		c.setRupee(choco.getRupee());
		chocolateRepository.save(c);
		return "Updated";
	}

	public String deleteChocolate(Integer id) throws ChocolateNotFoundException {
		Optional<Chocolate> c = chocolateRepository.findById(id);
		if (c.isPresent()) {
			chocolateRepository.deleteById(id);
		} else
		{
			errorNotFoundPage();
			throw new ChocolateNotFoundException("Chocolate not found for id: " + id);
		}
		return "Deleted Chocolated:" + id;
	}

	private String errorNotFoundPage() {
		return "errorNotFound";
		
	}



	}

