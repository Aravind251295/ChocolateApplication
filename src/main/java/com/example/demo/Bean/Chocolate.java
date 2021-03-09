package com.example.demo.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;  

@Entity
@Table(name = "Chocolate")
public class Chocolate {
	
	@Id
	@GeneratedValue
	Integer id;
	String name;
	Integer rupee;
public Chocolate()
{
	
}
	public Chocolate(Integer id, String name, Integer rupee) {
		super();
		this.id = id;
		this.name = name;
		this.rupee = rupee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRupee() {
		return rupee;
	}

	public void setRupee(Integer rupee) {
		this.rupee = rupee;
	}

}
	
