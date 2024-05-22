package com.example.sample0509;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>{

	List<Person> findByAge(int age);
	List<Person> findByAgeLessThan(int age);
	List<Person> findByAgeGreaterThan(int age);
	List<Person> findByName(String name);
	List<Person> findByNameLike(String name);
	List<Person> findByNameContaining(String name);
	List<Person> findByAddressLike(String address);
   
	// これは同年齢のPersonがいた場合
	List<Person> findByAgeOrderByNameDesc(int age);
	

	List<Person> findByNameNotLike(String name);
//	List<Person> findAllByNameContainingAndAgeAndAddressContaining(String name, int age, String address);

	



}