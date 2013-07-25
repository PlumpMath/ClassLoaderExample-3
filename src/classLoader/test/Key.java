package classLoader.test;
import java.io.*;
import java.security.SecureRandom;
import javax.crypto.*;

public class Key {
	private String keyName;
	public Key(String keyName){
		this.keyName = keyName;
	}
	public void createKey()throws Exception{
		//����һ�������ε������Դ
		SecureRandom sr = new SecureRandom();
		//��DES�㷨����һ��KeyGenerator����
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		//��ʼ����Կ��������ʹ�����ȷ������Կ����
		kg.init(sr);
		//������Կ
		SecretKey sk = kg.generateKey();
		//��ȡ��Կ����
		byte []rawKeyData = sk.getEncoded();
		//����ȡ������Կ���浽�ļ��У�������ʱʹ��
		FileOutputStream fo = new FileOutputStream(new File(keyName));
		fo.write(rawKeyData);
	}
}
