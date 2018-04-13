package test;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 */
public class AESUtil {

	private static int length=128;
	/**
	 * encryptAES
	 * @param content
	 * @param password
	 * @return
	 */
	private static byte[] encryptAES(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			byte[] byteContent = content.getBytes("UTF-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(byteContent);
			return result;  
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
		}
		return null;
	}

	/**
	 * Byte to HexStr
	 * 
	 * @param buf
	 * @return
	 */
	private static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * HexStr to、Byte
	 * @param hexStr
	 * @return
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	/**
	 * decryptAES
	 * @param content
	 * @param password
	 * @return
	 */
	private static byte[] decryptAES(byte[] content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			 SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG"); 
			secureRandom.setSeed(password.getBytes());


			kgen.init(length, secureRandom);


			SecretKey secretKey = kgen.generateKey();


			byte[] enCodeFormat = secretKey.getEncoded();


			SecretKeySpec key = new SecretKeySpec(enCodeFormat,"AES");


			Cipher cipher = Cipher.getInstance("AES");// 创建密码器


			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化


			byte[] result = cipher.doFinal(content);

			return result;
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
		}
		return null;
	}

	/**
	 * 加密
	 * @param content
	 * @param password
	 * @return
	 */
	public static String encrypt(String content, String password) {
		return parseByte2HexStr(encryptAES(content, password));
	}

	/**
	 * 解密
	 * @param content
	 * @param password
	 * @return
	 */
	public static String decrypt(String content, String password) {
		byte[] decryptResult = decryptAES(parseHexStr2Byte(content), password);
		String str="";
		try {
			str = new String(decryptResult,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			str=content;
		}
		return str;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		String content = "594778433fa7d63a0abe55c0";
		String password = "~!@gwypx63816615";

		System.out.println("原文" + content);
		String encryptResultStr = AESUtil.encrypt(content, password);
		System.out.println("密文" + encryptResultStr);

		//encryptResultStr = "84E6B8E4783C2EDA468305966B4E846839C1C6ED32AF3FAEB8BA53BA3814B2218822AA2E84224C7BEABD62D8BA59E155D0ABB8ECDF1D437742235A9B3B78113F84DEE2FE0A8F7B0BBA4ADB7109EB205E644F96837FFDC97193C93514FE7016509B3556A145A473003CEFE5E881AF618617CF836DDF30D82191D34C753B8C27B12BE359F347290B087C3A3E1329E71859F209CC96F7D55E65DAA3570BDF2AF657";
//		System.out.println("解密" + AESUtil.decrypt(encryptResultStr, password));
		System.out.println("解密" + AESUtil.decrypt("2B3D0F4F07961B0C9A2B971DD157DCFC218F7FE0CC5CEF41FB02AFEC85C7CE0B", password));
		System.out.println("解密" + AESUtil.decrypt("B53923538D9490A370F8FDA38FEEAAF4D82E3A5AAE9DED811C835F6869A76E33E6B681296E97467834907A1777D5F3ED", password));
		

	}
	
	/**
	 * convertString
	 * @param strConvert
	 * @param codeFrom
	 * @param codeTo
	 * @return
	 */
	public static String convertString(String strConvert, String codeFrom, String codeTo){
	    if (strConvert!=null) {
	      try{
	        return new String(strConvert.getBytes(codeFrom),codeTo);
	      }catch(Exception ex){
	        System.err.println("ERROR:"+ex.getMessage());
	        return strConvert;
	      }
	    }else
	      return strConvert;
	}
}
