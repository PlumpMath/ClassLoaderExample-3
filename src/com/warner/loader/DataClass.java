package com.warner.loader;

public class DataClass {
	private String userName;

	public DataClass() {
		userName = "Jacky";
	}

	public void showMsg(String str) {
		System.out.println("This is a test." + userName + "===" + str);
	}
	
	public void anotherMethod(){
		System.out.println("this is another method in the class");
	}

}
