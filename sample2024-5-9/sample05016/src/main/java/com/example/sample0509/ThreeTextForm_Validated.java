package com.example.sample0509;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ThreeTextForm_Validated {
	
	@NotBlank(message = "名前を入力してください")
    @Size(min = 3, max = 10, message = "名前は1文字以上10文字以下で入力してください")
	private String paramA = "";

	 @NotBlank(message = "メールアドレスを入力してください")
	 @Email(message = "正しいメールアドレスの形式で入力してください")
	private String paramB = "";
	
	 
	@NotBlank(message = "パスワードを入力してください")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).{10,}$", message = "パスワードは英数字記号をそれぞれ1文字以上含み、かつ10桁以上である必要があります")
	private String paramC = "";

	public String getParamA() {
		return paramA;
	}

	public void setParamA(String paramA) {
		this.paramA = paramA;
	}

	public String getParamB() {
		return paramB;
	}

	public void setParamB(String paramB) {
		this.paramB = paramB;
	}

	public String getParamC() {
		return paramC;
	}

	public void setParamC(String paramC) {
		this.paramC = paramC;
	}
}