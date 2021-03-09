package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import javax.validation.Valid;
import com.example.demo.Service.Myservice;
import com.example.demo.Service.Exception.ChocolateNotFoundException;
import com.example.demo.repository.ChocolateRepository;
import com.example.demo.Bean.Chocolate;


@RestController
public class MyController {

	@Autowired
	private Myservice service;
	
	@Autowired
	private ChocolateRepository repository;
	

	@GetMapping(path = "/demo", produces = "application/json")
	public List<Chocolate> getDemo() {
		return service.DisplayAll();
	}

	@PostMapping(path = "/demo", consumes = "application/json", produces = "application/json")
	public Chocolate addDemo(@RequestBody Chocolate choco) throws ChocolateNotFoundException {
		return service.addChoco(choco);
	}

	@PutMapping(path = "/demo/{id}", consumes = "application/json", produces = "application/json")
	public String updateChoc(@PathVariable Integer id, @Valid @RequestBody Chocolate choco)
			throws ChocolateNotFoundException {
		return service.updateChocolate(id, choco);
	}

	@DeleteMapping(path = "/demo/{id}")
	public String deleteChoco(@PathVariable Integer id) throws ChocolateNotFoundException {
		return service.deleteChocolate(id);
	}
	@GetMapping(value = "/home")
	public ModelAndView getHome() {
		ModelAndView mav= new ModelAndView("home");
		return mav;
	}
	
	@GetMapping(value = "/display")
	public ModelAndView getChocolates() {
		List<Chocolate> choco = getDemo();
		ModelAndView mav= new ModelAndView("display");
		mav.addObject("Chocolates", choco);
		return mav;
	}
	
	@GetMapping(value = "/add")
	public ModelAndView add() {
		Chocolate chocolates =new Chocolate();
		ModelAndView mav= new ModelAndView("add");
		mav.addObject("Choc",chocolates);
		return mav;
	}
	
	@GetMapping(value = "/addChocolate")
	public ModelAndView addChocolate(@ModelAttribute Chocolate chocolate) throws ChocolateNotFoundException {
		ModelAndView mav= new ModelAndView("addSuccess");
		addDemo(chocolate);
		return mav;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView delete() {
		Chocolate chocolate =new Chocolate();
		List<Chocolate> chocolates = getDemo();
		ModelAndView mav= new ModelAndView("delete");
		mav.addObject("Chocolates",chocolates);
		mav.addObject("Chocolate",chocolate);
		return mav;
	}
	
	@GetMapping(value = "/deleteChocolate")
	public ModelAndView deleteChocolate(@ModelAttribute Chocolate chocolate) throws ChocolateNotFoundException {
		ModelAndView mav= new ModelAndView("deleteSuccess");
		deleteChoco(chocolate.getId());
		return mav;
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updateChocolate() {
		Chocolate chocolate =new Chocolate();
		List<Chocolate> chocolates = getDemo();
		ModelAndView mav= new ModelAndView("update");
		mav.addObject("Chocolates",chocolates);
		mav.addObject("Chocolate",chocolate);
		return mav;
	}
	
	@GetMapping(value = "/retrieveChocolate")
	public ModelAndView retrieveChocolate(@ModelAttribute Chocolate chocolate) {
		Chocolate ch = repository.findById(chocolate.getId()).get();
		ModelAndView mav= new ModelAndView("updateChocolate");
		mav.addObject("Ch",ch);
		return mav;
	}
	
	@GetMapping(value = "/updateChocolate")
	public ModelAndView updateChocolate(@ModelAttribute Chocolate chocolate) throws ChocolateNotFoundException {
		System.out.println("NAme"+chocolate.getName());
		System.out.println("ID"+chocolate.getId());
		ModelAndView mav= new ModelAndView("updateSuccess");
		updateChoc(chocolate.getId(), chocolate);
		return mav;
	}

}