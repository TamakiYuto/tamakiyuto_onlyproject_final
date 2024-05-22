package com.example.sample202459;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@Autowired
	MyService service;
   
	@GetMapping("/users/{name}")//localhost8080/<--これのこと
	public String getHome(Model model) {
		
		Person p = new Person();
		p.setName("徳川家康");
		p.setAge(18);

		model.addAttribute("person",p);
		
		return "home";//home.htmlのこと
	}
	
	@GetMapping("/home2")//localhost8080/home2
	public String getHome2(Model model) {
		
		model.addAttribute("greeting","Hello");
		model.addAttribute("greeting1","Hello");
		model.addAttribute("greeting2","Hello");
		
		
		return "home2";
	}
	
	@GetMapping("/home2/school")
	public String getSchool() {
		return "school";
	}
	
//	@GetMapping("/users/{name}")
//	public String getUsers(@PathVariable String name, Model model) {
//		System.out.println("name = " + name);
//		model.addAttribute("message", name + "さん、こんにちは！");
//		return "hello";
//	}
	
	@GetMapping("/sample1")
	public String sample1(Model model) {
		model.addAttribute("title", "入力画面1です。");
		return "sample1";
	}
	
	@GetMapping("/sample1_result")
	public String sample1_result(@RequestParam String paramA, @RequestParam String paramB, @RequestParam String paramC, Model model) {
	    model.addAttribute("parapara", paramA);
	    model.addAttribute("paramB", paramB);
	    model.addAttribute("paramC", paramC);
	    return "sample1_result";
	}
	
	@GetMapping("/sample2_input")
	public String sample2_input(Model model) {
		model.addAttribute("title", "入力画面2です。");
		return "sample2_input";
	}

	@PostMapping("/sample2_result")
	public String sample2_result(ThreeTextForm inputname, Model model) {
		System.out.println("paramA : " + inputname.getParamA());
		System.out.println("paramB : " + inputname.getParamB());
		System.out.println("paramC : " + inputname.getParamC());
	    model.addAttribute("input", inputname);
	    return "sample2_result";
	}
	
	
	
	@GetMapping("/sample3_input")
	public String sample3_input(Model model) {				
		model.addAttribute("title", "入力画面3です。");
	    model.addAttribute("form", new ThreeTextForm_Validated());        
		return "sample3_input";
	}

	@PostMapping("/sample3_result")
	public String sample3_result(@Validated @ModelAttribute("form") 
	ThreeTextForm_Validated form, BindingResult bindingResult, Model model) {

		System.out.println("paramA : " + form.getParamA());
		System.out.println("paramB : " + form.getParamB());
		System.out.println("paramC : " + form.getParamC());

		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "入力画面3の再入力です。");
	        model.addAttribute("form", form);        
			return "sample3_input";
		}
		
	    model.addAttribute("form", form);
	    
	    return "sample3_result";
	}            
	
	
	@GetMapping("/sample4_input")
	public String sample4_input(Model model) {				
		model.addAttribute("title", "入力画面4です。");
	    model.addAttribute("threeTextForm_Validated", new ThreeTextForm_Validated());        
		return "sample4_input";
	}

	@PostMapping("/sample4_result")
	public String sample4_result(@Validated ThreeTextForm_Validated threeTextForm_Validated, BindingResult bindingResult, Model model) {

		System.out.println("paramA : " + threeTextForm_Validated.getParamA());
		System.out.println("paramB : " + threeTextForm_Validated.getParamB());
		System.out.println("paramC : " + threeTextForm_Validated.getParamC());

		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "入力画面4の再入力です。");
	        model.addAttribute("threeTextForm_Validated", threeTextForm_Validated);        
			return "sample4_input";
		}
		
	    model.addAttribute("threeTextForm_Validated", threeTextForm_Validated);
	    
	    return "sample4_result";
	    
	}
	
	@GetMapping("/person")
	public String person(Model model) {
		model.addAttribute("person",service.getPersonList());
		return "person";
	}
	
	@GetMapping("/websiteProject")
	public String edojidai(Model model) {
		model.addAttribute("person",service.getPersonList());
		model.addAttribute("pSelects",service.getPersonSelect());
//		model.addAttribute("pChoice",service.getPersonChoice());
		return "edojidai";
	}
	
	 @GetMapping("/search")
	    public String search(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
		 
		    if(keyword != "") {
		    	model.addAttribute("pChoice", service. findByNameOrAddressContaining(keyword));
			    model.addAttribute("person",service.getPersonList());
		    }else {
		    	model.addAttribute("person",service.getPersonList());
		    }
		    
	        return"edojidai";
	        
	    }
//	
//	 import org.springframework.beans.factory.annotation.Autowired;
//	 import org.springframework.stereotype.Service;
//
//	 import java.util.HashSet;
//	 import java.util.List;
//	 import java.util.Set;
//	 import java.util.stream.Collectors;
//
//	 @Service
//	 public class PersonService {
//
//	     @Autowired
//	     private PersonRepository personRepository;
//
//	     public List<Person> findByNameOrAddressContaining(String keyword) {
//	         // 'name'にキーワードを含むPersonを検索
//	         List<Person> byName = personRepository.findAll().stream()
//	                 .filter(person -> person.getName().contains(keyword))
//	                 .collect(Collectors.toList());
//
//	         // 'address'にキーワードを含むPersonを検索
//	         List<Person> byAddress = personRepository.findAll().stream()
//	                 .filter(person -> person.getAddress().contains(keyword))
//	                 .collect(Collectors.toList());
//
//	         // 重複を排除するためにHashSetを使用
//	         Set<Person> resultSet = new HashSet<>();
//	         resultSet.addAll(byName);
//	         resultSet.addAll(byAddress);
//
//	         // HashSetをリストに変換して返す
//	         return resultSet.stream().collect(Collectors.toList());
//	     }
//	 }

	
	 

//	@GetMapping("/websiteSelect")
//	public String edoSelect(Model model) {
//		model.addAttribute("pSelects",service.getPersonSelect());
//		return "edojidai";
//	}
	
	@GetMapping("/checkWeather")
	public WeatherReport getWeather() {
		
		WeatherReport report = new WeatherReport();
		report.setHeadlineText("ヘッドラインです");
		report.setPublishingOffice("野崎天文台");
		report.setTargetArea("オランダ");
		report.setText("本日は晴天なり");	
		
		return report;
	}
	
	
	@GetMapping("/checkWeather/{areaCode}")
	public WeatherReport getWeather(@PathVariable String areaCode) {
		
		WeatherReport report = new WeatherReport();
		
		report.setHeadlineText("ヘッドラインです");
		report.setPublishingOffice("野崎天文台");
		report.setTargetArea("areaCodeは" + areaCode + "です。");
		report.setText("本日は晴天なり");	
		
		return report;
	}
	
	
	@PostMapping("/weather")
	public WeatherReport postWeather(@RequestParam String areaCode) {
		
		WeatherReport report = new WeatherReport();
		
		report.setHeadlineText("ヘッドラインです");
		report.setPublishingOffice("野崎天文台");
		report.setTargetArea("areaCodeは" + areaCode + "です。");
		report.setText("本日は晴天なり");	
		
		return report;
	}	
}