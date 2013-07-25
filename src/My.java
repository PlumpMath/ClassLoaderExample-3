import java.lang.reflect.*;

public class My {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println("ok");
		ClassLoader loader = My.class.getClassLoader();
		while(null != loader)
		{
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
		System.out.println(loader);
		int a = 3;
		int b = 3;
		a = 4;
		System.out.println(a);
		System.out.println(b);
	}

}
