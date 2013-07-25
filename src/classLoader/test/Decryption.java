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
			//从文件获取密钥数据
			FileInputStream fis = new FileInputStream(new File(keyFromFile));
			byte []rawKeyData = new byte[fis.available()];
			fis.read(rawKeyData);
			fis.close();
			//从原始密钥数据创建DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(rawKeyData);
			//利用密钥工厂，将dks转换成一个SecretKey对象
			SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(dks);
			//Cipher完成实际的解密操作
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key, sr);
			//获取要解密的数据文件
			FileInputStream fi = new FileInputStream(new File(dataFromFile));
			byte []data = new byte[fi.available()];
			fi.read(data);
			fi.close();
			//执行解密操作
			byte []decryptionData = cipher.doFinal(data);
			//将解密后的数据写回文件
			FileOutputStream fos = new FileOutputStream(new File(dataFromFile));
			fos.write(decryptionData);
			fos.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	

}
