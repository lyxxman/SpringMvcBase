package base.utils;

import jodd.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 *
 */
public class AES {

	private static Logger logger = LoggerFactory.getLogger(AES.class);

	public static byte[] encryptToByte(String key,String content) {
		try {
			/*
			 * KeyGenerator kgen = KeyGenerator.getInstance("AES");
			 * kgen.init(128, new SecureRandom(password.getBytes())); SecretKey
			 * secretKey = kgen.generateKey(); byte[] enCodeFormat =
			 * secretKey.getEncoded();
			 */

			byte [] keys = getKey(key);
			SecretKeySpec keySpce = new SecretKeySpec(
					keys, "AES");
			IvParameterSpec iv = new IvParameterSpec(keys);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

			byte[] byteContent = content.getBytes("utf-8");

			cipher.init(Cipher.ENCRYPT_MODE, keySpce, iv);

			byte[] result = cipher.doFinal(byteContent);
			return result; //
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}

		return null;
	}

	public static byte[] decryptToByte(String key,byte[] content) {
		try {
			/*
			 * KeyGenerator kgen = KeyGenerator.getInstance("AES");
			 * kgen.init(128, new SecureRandom(password.getBytes())); SecretKey
			 * secretKey = kgen.generateKey(); byte[] enCodeFormat =
			 * secretKey.getEncoded();
			 */

			byte [] keys = getKey(key);
			SecretKeySpec keySpec = new SecretKeySpec(
					keys, "AES");
			IvParameterSpec iv = new IvParameterSpec(keys);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");//
			cipher.init(Cipher.DECRYPT_MODE, keySpec,iv);//
			byte[] result = cipher.doFinal(content);
			return result; //
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String key,String str) {
		try {
			return new String(decryptToByte(key,Base64.decode(str.replace("-", "+").replace("_", "/"))), "UTF-8");
		} catch (Exception e) {
			logger.info("" + str, e);
		}
		return "";
	}
	
	public static String decrypt(String str) {
		return decrypt(null,str);
	}

	public static String encrypt(String str) {
		return encrypt(null,str);
	}

	public static String encrypt(String key, String str) {
		try {
			byte[] encryptResult = encryptToByte(key,str);
			String af_str = Base64.encodeToString(encryptResult);
			return af_str == null ? null : af_str.replace("+", "-").replace("/", "_");
		} catch (Exception e) {
			logger.info("" + str, e);
		}
		return "";
	}

	private static byte[] getKey(String key) {
		byte[] keyBytes = null;
		if (key == null)
			keyBytes = new byte[] { 121, 100, 77, 52, 43, 127, 99, 73, 85, 39, 27, 103, 6, 48, 87, 68 };
		else {
			byte[] bytes = key.getBytes();
			if (bytes.length != 16 && bytes.length != 24 && bytes.length != 32) {
				keyBytes = new byte[16];
				if (bytes.length > 16){
					System.arraycopy(bytes, 0,keyBytes, 0, keyBytes.length);
				}	
				else{
					System.arraycopy(bytes, 0,keyBytes, 0, bytes.length);
					System.arraycopy(new byte[keyBytes.length-bytes.length], 0,keyBytes, bytes.length-1, keyBytes.length-bytes.length);
				}	
			}else
				keyBytes = bytes;
		}
		return keyBytes;
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(""+af_str);
		// System.out.println("" +decrypt(af_str));
	}

}
