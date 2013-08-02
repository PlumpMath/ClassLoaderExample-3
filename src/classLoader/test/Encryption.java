/**
 * 
 */
package classLoader.test;
import java.io.*;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author Jacky
 *
 */
public class Encryption {
	private String keyFromFile;
	private String dataFromFile;
	public Encryption(String keyFromFile,String dataFromFile){
		this.keyFromFile = keyFromFile;
		this.dataFromFile = dataFromFile;
System.out.println("test");
System.out.println("change");
	}
	public void encrypData(){
		SecureRandom sr = new SecureRandom();	
		try {
			//���ļ���ȡ��Կ����
			FileInputStream fis = new FileInputStream(new File(keyFromFile));
			byte []rawKeyData = new byte[fis.available()];
			fis.read(rawKeyData);
			fis.close();
			//��ԭʼ��Կ���ݴ���DESKeySpec����
			DESKeySpec dks = new DESKeySpec(rawKeyData);
			//������Կ��������dksת����һ��SecretKey����
			SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(dks);
			//Cipher���ʵ�ʵļ��ܲ���
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
			//��ȡҪ���ܵ������ļ�
			FileInputStream fi = new FileInputStream(new File(dataFromFile));
			byte []data = new byte[fi.available()];
			fi.read(data);
			fi.close();
			//ִ�м��ܲ���
			byte []encryptionData = cipher.doFinal(data);
			//�����ܺ������д���ļ�
			FileOutputStream fos = new FileOutputStream(new File(dataFromFile));
			fos.write(encryptionData);
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
