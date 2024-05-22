package com.example.sample0509;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@Autowired
	private MyService service;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日");
        String formattedToday = today.format(formatter);
		
		model.addAttribute("greeting", "Hello Greeting");
        model.addAttribute("today", formattedToday);
		model.addAttribute("msg", "宜しくお願い致します。");

		return "index";
	}
	
	@GetMapping("/people")
	public String getAllPersons(Model model) {
	//    model.addAttribute("people", service.getPersonList());
    model.addAttribute("people", service.getAllPersons());
    return "people";
    
	}
	
    @GetMapping("/people/search")
	public String searchPerson(@RequestParam("keyword") String keyword, Model model) {
		List<Person> persons = service.searchPerson(keyword);
		model.addAttribute("people", persons);
		return "people";
	}
}
