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
		//创建一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		//用DES算法创建一个KeyGenerator对象
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		//初始化密钥生成器，使其具有确定的密钥长度
		kg.init(sr);
		//生成密钥
		SecretKey sk = kg.generateKey();
		//获取密钥数据
		byte []rawKeyData = sk.getEncoded();
		//将获取到的密钥保存到文件中，待解密时使用
		FileOutputStream fo = new FileOutputStream(new File(keyName));
		fo.write(rawKeyData);
	}
}
