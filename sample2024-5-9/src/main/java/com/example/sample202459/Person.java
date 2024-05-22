package com.example.sample202459;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Person {	
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String sports;
	private String address;

	public Person (String name,String sports,String address){	
		this.name = name;
		this.sports = sports;
		this.address = address;
	}



}

	
	
	

	
	
//	ボイラープレートコード
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
