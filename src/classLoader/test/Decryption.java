package classLoader.test;

import java.io.*;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class Decryption {
	private String keyFromFile;
	private String dataFromFile;
	public Decryption(String keyFromFile,String dataFromFile){
		this.keyFromFile = keyFromFile;
		this.dataFromFile = dataFromFile;
	}
	public void decryptionData(){
		try{
			SecureRandom sr = new SecureRandom();
			//���ļ���ȡ��Կ����
			FileInputStream fis = new FileInputStream(new File(keyFromFile));
			byte []rawKeyData = new byte[fis.available()];
			fis.read(rawKeyData);
			fis.close();
			//��ԭʼ��Կ���ݴ���DESKeySpec����
			DESKeySpec dks = new DESKeySpec(rawKeyData);
			//������Կ��������dksת����һ��SecretKey����
			SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(dks);
			//Cipher���ʵ�ʵĽ��ܲ���
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
			//��ȡҪ���ܵ������ļ�
			FileInputStream fi = new FileInputStream(new File(dataFromFile));
			byte []data = new byte[fi.available()];
			fi.read(data);
			fi.close();
			//ִ�н��ܲ���
			byte []decryptionData = cipher.doFinal(data);
			//�����ܺ������д���ļ�
			FileOutputStream fos = new FileOutputStream(new File(dataFromFile));
			fos.write(decryptionData);
			fos.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	

}
