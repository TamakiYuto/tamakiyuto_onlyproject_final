package com.example.sample0509;


import java.util.List;
//import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository; 
	
	@Override
	public void run(String... args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Hello CommandLineRunner");

		Person p01 = new Person("ジャックザリッパー", 34, "イングランド");
		Person p02 = new Person("雷電為右衛門", 50, "大阪城");
		Person p03 = new Person("佐々木小次郎", 70, "江戸城");
		Person p04 = new Person("レオナルド・ダ・ヴィンチ", 24, "イタリア");
		Person p05 = new Person("ニコラ・テスラ", 60, "オーストリア");
		Person p06 = new Person("沖田総司", 82, "新潟県");
		Person p07 = new Person("ヘラクレス", 15, "ギリシア");
		Person p08 = new Person("呂布奉先", 48, "中国");
		
		
		personRepository.save(p01);
		personRepository.save(p02);
		personRepository.save(p03);
		personRepository.save(p04);
		personRepository.save(p05);
		personRepository.save(p06);
		personRepository.save(p07);
		personRepository.save(p08);
		
		
//		personRepository.deleteById(2);
		
        // コマンドラインからの検索クエリを受け取る
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("検索する名前を入力してください: ");
//        String searchName = scanner.nextLine();
//        scanner.close();

        // 検索クエリを使用して人物を検索
        List<Person> resultList = personRepository.findAll();
        
        // 検索結果を出力
        // System.out.println("検索結果:");
		for (Person p : resultList) {
			System.out.println(p.getName());;
		}
		
		System.out.println("Bye CommandLineRunner");

	}

}
