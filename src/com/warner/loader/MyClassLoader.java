package com.warner.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

	// private String rootDir = "D:/JavaCode/Test/bin/";
	private String exType = ".class";

	public MyClassLoader() {
		super();

	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		byte[] data = loadClassData(name);
		return defineClass(name, data, 0, data.length);

	}

	private byte[] loadClassData(String dataFromFile) {
		String path = dataFromFile.replace('.', File.separatorChar);
		try {
			FileInputStream fi = new FileInputStream(new File(path + exType));
			byte[] data = new byte[fi.available()];
			fi.read(data);
			fi.close();

			System.out.println("loadClassData");
			return data;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
