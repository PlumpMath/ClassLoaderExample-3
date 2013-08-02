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
			//从文件获取密钥数据
			FileInputStream fis = new FileInputStream(new File(keyFromFile));
			byte []rawKeyData = new byte[fis.available()];
			fis.read(rawKeyData);
			fis.close();
			//从原始密钥数据创建DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(rawKeyData);
			//利用密钥工厂，将dks转换成一个SecretKey对象
			SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(dks);
			//Cipher完成实际的加密操作
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
			//获取要加密的数据文件
			FileInputStream fi = new FileInputStream(new File(dataFromFile));
			byte []data = new byte[fi.available()];
			fi.read(data);
			fi.close();
			//执行加密操作
			byte []encryptionData = cipher.doFinal(data);
			//将加密后的数据写回文件
			FileOutputStream fos = new FileOutputStream(new File(dataFromFile));
			fos.write(encryptionData);
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
