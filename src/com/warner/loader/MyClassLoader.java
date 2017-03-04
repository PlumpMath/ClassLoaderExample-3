package com.warner.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

	// private String rootDir = "D:/JavaCode/Test/bin/";
	private String exType = ".class";
	private String basePath = "/Users/warner/GitHub/ClassLoaderExample/bin/";

	public MyClassLoader(String path) {
		// super();
		this.basePath = path;
	}

	public MyClassLoader(ClassLoader parent, String path) {
		// TODO Auto-generated constructor stub
		super(parent);
		this.basePath = path;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		System.out.println("my class loader");
		byte[] data = loadClassData(name);
		return defineClass(name, data, 0, data.length);

	}

	private byte[] loadClassData(String dataFromFile) {
		String path = dataFromFile.replace('.', File.separatorChar);
		System.out.println("path === " + path);
		try {
			File file = new File(basePath + path + exType);
			System.out.println("path === " + file.getAbsolutePath());
			FileInputStream fi = new FileInputStream(file);
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
