package com.coin.parameters;


public class parameter {
	
	//String btn; // +,-,계산 버튼
	String num;		// 동전 종류 >> +,- btn에 의해서 제어됨
	String price;	// 총 가격
	String[] str_P;		// 동전 값 >> K값에 따라 main.jsp에서 생성됨
	String[] str_N;		// 동전 개수 >> K값에 따라 main.jsp에서 생성됨
	
	String result;		// 계산된 동전 경우수
	String str;		// 출력할 결과 (동전 계산법 + 형식)
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String[] getStr_P() {
		return str_P;
	}
	public void setStr_P(String[] str_P) {
		this.str_P = str_P;
	}
	public String[] getStr_N() {
		return str_N;
	}
	public void setStr_N(String[] str_N) {
		this.str_N = str_N;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}
