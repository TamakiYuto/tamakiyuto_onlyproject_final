package com.example.sample202459;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MyRestController {
	@Autowired
    PersonRepository personRepository;

	@GetMapping("/weather")
	public WeatherReport getWeather() {
		
		WeatherReport report = new WeatherReport();
		report.setHeadlineText("ヘッドラインです");
		report.setPublishingOffice("玉城天文台");
		report.setTargetArea("オランダ");
		report.setText("テキストです");
		
		return report;
	}
	
	@GetMapping("/reperson")
	public List<Person> getPerson() {
		
		List<Person> p =  personRepository.findAll();
		
		return p;

	}
			
}
