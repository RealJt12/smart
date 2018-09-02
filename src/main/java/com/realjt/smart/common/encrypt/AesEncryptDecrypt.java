package com.realjt.smart.common.encrypt;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * 
 * 
 * @author RealJt
 * @date 2018年6月27日
 */
public class AesEncryptDecrypt
{
	/**
	 * 加密算法,CBC模式
	 */
	private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

	/**
	 * 用于生成随机iv
	 * 
	 * @param length
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] getSecureRandom(int length) throws NoSuchAlgorithmException
	{
		byte[] randomByte = new byte[length];

		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		secureRandom.nextBytes(randomByte);

		return randomByte;
	}

	/**
	 * 不同长度的种子seed,生成一样长度的key
	 * 
	 * @param seed
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] getSecretKey(byte[] seed) throws NoSuchAlgorithmException
	{
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

		secureRandom.setSeed(seed);
		// 256 bits or 128 bits,192bits
		keyGenerator.init(256, secureRandom);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] result = secretKey.getEncoded();

		return result;
	}

	private static byte[] aesCipher(byte[] source, byte[] key, byte[] iv, int mode)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
	{
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(mode, secretKeySpec, ivParameterSpec);

		return cipher.doFinal(source);
	}

	public static String encrypt(String source, String key) throws Exception
	{
		try
		{
			byte[] iv = getSecureRandom(16);

			byte[] resultByte = aesCipher(source.getBytes(StandardCharsets.UTF_8), getSecretKey(key.getBytes()), iv,
					Cipher.ENCRYPT_MODE);

			Base64.Encoder encoder = Base64.getEncoder();

			// iv值拼接在密文值后面
			return encoder.encodeToString(resultByte).concat(new String(Hex.encodeHex(iv)));
		}
		catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

	public static String decrypt(String source, String key) throws Exception
	{
		try
		{
			// 先分别解析密文值和iv值
			String message = source.substring(0, source.length() - 32);
			String iv = source.substring(source.length() - 32, source.length());

			Base64.Decoder decoder = Base64.getDecoder();

			byte[] resultByte = aesCipher(decoder.decode(message), getSecretKey(key.getBytes()),
					Hex.decodeHex(iv.toCharArray()), Cipher.DECRYPT_MODE);

			return new String(resultByte, StandardCharsets.UTF_8);
		}
		catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
	}

}
