package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactPractice {
	
		@CrossOrigin
		@GetMapping("/try")
		public WeatherReport getWeather() {
			
			WeatherReport report = new WeatherReport();
			report.setHeadlineText("ヘッドラインです");
			report.setPublishingOffice("玉城天文台");
			report.setTargetArea("オランダ");
			report.setText("テキストです");
		
		
			return report;
		}
}
