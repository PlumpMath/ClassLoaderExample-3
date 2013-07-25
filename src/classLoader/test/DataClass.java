package classLoader.test;

public class DataClass {
	private String userName;
	public DataClass(){
		userName = "Jacky";
	}
	public void showMsg(String str){
		System.out.println("This is a test." + userName + str);
	}

}
