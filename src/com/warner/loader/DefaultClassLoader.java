package com.warner.loader;

public class DefaultClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader loader = DefaultClassLoader.class.getClassLoader();
		while (null != loader) {
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
	}
}
