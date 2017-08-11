package base.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Decode {

	public static void main(String[] args) {
		// 解密
		String decodePhone = Decode.uc_authcode(
				"aKvpxU1LekEffCeMGt726YAgY255liWH4G6wNjVhsQkT86ht9aQ",
				"DECODE", "user_sercretkey", 0);
		System.out.println("解密:" + decodePhone);
		// 加密
		String encodePhone = Decode.uc_authcode("13047361781", "ENCODE",
				"user_sercretkey", 0);
		System.out.println(encodePhone);
	}

	public static String md5(String input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		byte[] b = md.digest(input.getBytes());
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
		}
		return hs.toString();
	}

	public static String substr(String input, int begin, int length) {
		return input.substring(begin, begin + length);
	}

	public static String substr(String input, int begin) {
		if (begin > 0) {
			return input.substring(begin);
		} else {
			return input.substring(input.length() + begin);
		}
	}

	public static String sprintf(String format, long input) {
		String temp = "0000000000" + input;
		return temp.substring(temp.length() - 10);
	}

	public static String base64_decode(String input) {
		try {
			return new String(Base64.decode(input.toCharArray()), "iso-8859-1");
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String base64_encode(String input) {
		try {
			return new String(Base64.encode(input.getBytes("iso-8859-1")));
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String uc_authcode(String string, String operation, String key,
			int expiry) {
		int ckey_length = 1;
		key = md5(key != null ? key : "12345");
		String keya = md5(substr(key, 0, 16));
		String keyb = md5(substr(key, 16, 16));
		String keyc = "a";
		String cryptkey = keya + md5(keya + keyc);
		int key_length = cryptkey.length();

		string = operation.equals("DECODE") ? base64_decode(substr(string,
				ckey_length)) : sprintf("%010d", expiry > 0 ? expiry : 0)
				+ substr(md5(string + keyb), 0, 16) + string;
		int string_length = string.length();

		StringBuffer result1 = new StringBuffer();

		int[] box = new int[256];
		for (int i = 0; i < 256; i++) {
			box[i] = i;
		}

		int[] rndkey = new int[256];
		for (int i = 0; i <= 255; i++) {
			rndkey[i] = (int) cryptkey.charAt(i % key_length);
		}

		int j = 0;
		for (int i = 0; i < 256; i++) {
			j = (j + box[i] + rndkey[i]) % 256;
			int tmp = box[i];
			box[i] = box[j];
			box[j] = tmp;
		}

		j = 0;
		int a = 0;
		for (int i = 0; i < string_length; i++) {
			a = (a + 1) % 256;
			j = (j + box[a]) % 256;
			int tmp = box[a];
			box[a] = box[j];
			box[j] = tmp;

			result1.append((char) (((int) string.charAt(i)) ^ (box[(box[a] + box[j]) % 256])));

		}

		if (operation.equals("DECODE")) {
			String result = result1.substring(0, result1.length());
			if ((Integer.parseInt(substr(result.toString(), 0, 10)) == 0 || Long
					.parseLong(substr(result.toString(), 0, 10)) > 0)
					&& substr(result.toString(), 10, 16).equals(
							substr(md5(substr(result.toString(), 26) + keyb),
									0, 16))) {
				return substr(result.toString(), 26);
			} else {
				return "";
			}
		} else {
			return keyc + base64_encode(result1.toString()).replaceAll("=", "");
		}
	}

}