package com.warner.loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Key myKey = new Key("key.txt"); try { myKey.createKey(); }
		 * catch(Exception e){ System.out.println(e.toString()); }
		 * 
		 * 
		 * DataClass dc = new DataClass(); dc.showMsg();
		 */

		// String keyFile = "key.txt";
		// String dataFile =
		// "D:/JavaCode/Test/bin/classLoader/test/DataClass.class";
		// 包含包的情况
		String dataFile = "com.warner.loader.DataClass";
		/*
		 * Decryption decryption = new Decryption(keyFile,dataFile);
		 * decryption.decryptionData();
		 * 
		 * Encryption encryption = new Encryption(keyFile,dataFile);
		 * encryption.encrypData();
		 */
		MyClassLoader mcl = new MyClassLoader();
		System.out.println("my define class loader === " + mcl);
		try {
			// 调用loadclass方法时，要注意包的层次结构，因此在加载类的字节码时需要注意将包的分隔符替换为文件路径的分隔符，
			// 否则会出现路径不对的情况
			Class<?> myClass = mcl.loadClass(dataFile);
			DataClass dc = (DataClass) myClass.newInstance();
			dc.showMsg("Test");
			Object oc = myClass.newInstance();
			// getMethod的两个参数：第一个表示方法的名称，第二个表示方法的参数
			Method m = oc.getClass().getMethod("showMsg", new Class[] { String.class });
			// invoke方法的两个参数：第一个表示方法的对象，第二个表示实际的参数
			m.invoke(oc, new Object[] { "reflection" });
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("执行结束");

	}

}
