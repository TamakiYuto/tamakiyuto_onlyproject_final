package com.example.sample202459;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	 
		@Autowired
	    PersonRepository personRepository;
		
		public MyService(PersonRepository personRepository) {
			this.personRepository = personRepository;
		}
	
	   public List<Person> getPersonList(){
		
		List<Person> person = personRepository.findAll();;
	

		return person;
	}
	   
	   //以下
//	   public List<Person> getPersonSelect(){
//			
//			List<Person> pselect = personRepository.findByAgeLessThan(13);;
//			
//
//			return pselect;
//		}
	   
	   //キーワード検索
	   public List<Person> getPersonChoice(String keyword){
			
			List<Person> pchoice = personRepository.findByNameContaining(keyword);;
			return pchoice;
	   }
	   
	   public List<Person> getCastleChoice(String keyword){
			
			List<Person> pchoice = personRepository.findByAddressContaining(keyword);;
			return pchoice;
	   }
	   
	     public List<Person> findByNameOrAddressContaining(String keyword) {
	         // 'name'にキーワードを含むPersonを検索
	            List<Person> byName = personRepository.findByNameContaining(keyword);
	         // 'address'にキーワードを含むPersonを検索
	            List<Person> byAddress = personRepository.findByAddressContaining(keyword);
	         // 重複を排除するためにHashSetを使用
		        Set<Person> resultSet = new HashSet<>();
		        resultSet.addAll(byName);
		        resultSet.addAll(byAddress);

	         // HashSetをリストに変換して返す
	         return resultSet.stream().collect(Collectors.toList());
	     }   
			
}