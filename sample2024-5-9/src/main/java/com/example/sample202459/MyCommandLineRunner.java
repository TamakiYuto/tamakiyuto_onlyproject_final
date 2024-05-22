package com.example.sample202459;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner{
    
	@Autowired
    PersonRepository personRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("コマンドラインランナーを実行します。");
		
		Person p1 = new Person("あ", "野球", "毎日");
		Person p2 = new Person("い", "サッカー", "毎日");
		Person p3 = new Person("う", "野球", "週3");
		Person p4 = new Person("え", "野球", "週５");
		Person p5 = new Person("お", "野球",  "毎日");
		Person p6 = new Person("か", "サッカー", "休日のみ");
		Person p7 = new Person("き", "サッカー", "平日");
		Person p8 = new Person("く", "サッカー", "毎日");
		
		
		personRepository.save(p1);
		personRepository.save(p2);
		personRepository.save(p3);
		personRepository.save(p4);
		personRepository.save(p5);
		personRepository.save(p6);
		personRepository.save(p7);
		personRepository.save(p8);
		
		//全検索
		
//		List<Person> list = personRepository.findAll();
//		
//		
//		for(Person p : list) {
//			
//			if(p.getId()==1) {
//				personRepository.delete(p);
//			}
//		
//			System.out.println(p.getName());
		
//		    personRepository.deleteById(3);
	
//		 List<Person>list = personRepository.findByNameContaining("家");
//		    
////			List<Person>list=personRepository.findByAgeBetween(15,19);
//			for(Person p : list) {
//				
////				if(p.getName().equals("徳川家康")) {
////					p.setName("竹千代");
////					personRepository.save(p);
////				}
//				
//				System.out.println(p.toString());
//		}
		
		
		System.out.println("コマンドラインランナーを終了します。");
	}
	

}
