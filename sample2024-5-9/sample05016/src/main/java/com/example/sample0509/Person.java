package com.example.sample0509;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="people_list")
public class Person {	
	
	public Person (String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int age;
	private String address;
	

	
}