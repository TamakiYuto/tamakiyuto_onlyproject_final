package com.example.demo;


//import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//このクラスがデータベーステーブルにマッピングされたエンティティであることを示す
@Entity//データベース追加する
//このエンティティに関連付けられたデータベーステーブルの名前を指定
@Table(name = "profile")
public class UserProfile {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getActivityFrequency() {
		return activityFrequency;
	}

	public void setActivityFrequency(String activityFrequency) {
		this.activityFrequency = activityFrequency;
	}
	
//	public String getPR() {
//		return PR;
//	}
//
//	public void setPR(String pR) {
//		PR = pR;
//	}


	@Column(nullable = false)
//    @NotBlank
    private String teamName;
    
    @Column(nullable = false)
//    @NotBlank
    private String sport;
    
    @Column(nullable = false)
//    @NotBlank
    private String activityFrequency;
    
//    @Column(nullable = false)
//    @NotBlank
//    private LocalDate matchDate;
//    
//    @Column(nullable = false)
//    @NotBlank
//    private String PR;


    // Getters and setters
}
