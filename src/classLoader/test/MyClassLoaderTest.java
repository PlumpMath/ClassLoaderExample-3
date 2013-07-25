package classLoader.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Key myKey = new Key("key.txt");
		try
		{
			myKey.createKey();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
		
		DataClass dc = new DataClass();
		dc.showMsg();
		*/
		
		//String keyFile = "key.txt";
		//String dataFile = "D:/JavaCode/Test/bin/classLoader/test/DataClass.class";
		//�����������
		String dataFile = "classLoader.test.DataClass";
		/*
		Decryption decryption = new Decryption(keyFile,dataFile);
		decryption.decryptionData();
		
		Encryption encryption = new Encryption(keyFile,dataFile);
		encryption.encrypData();
		*/
		MyClassLoader mcl = new MyClassLoader();
		try {
			//����loadclass����ʱ��Ҫע����Ĳ�νṹ������ڼ�������ֽ���ʱ��Ҫע�⽫���ķָ����滻Ϊ�ļ�·���ķָ�����
			//��������·�����Ե����
			Class<?> myClass = mcl.loadClass(dataFile);
			DataClass dc = (DataClass)myClass.newInstance();
			dc.showMsg("Test");
			Object oc = myClass.newInstance();
			//getMethod��������������һ����ʾ���������ƣ��ڶ�����ʾ�����Ĳ���
			Method m = oc.getClass().getMethod("showMsg", new Class[]{String.class});
			//invoke������������������һ����ʾ�����Ķ��󣬵ڶ�����ʾʵ�ʵĲ���
			m.invoke(oc, new Object[]{"reflection"});
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
		
		System.out.println("ִ�н���");

	}

}
