package dev.guldeniz.cv.business.rules;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class PasswordRules {

	// SİFRE HASHLEMEK İÇİN GEREKEN KODLAR
	private static final SecureRandom random = new SecureRandom();

	// hash için kod
	public static String generateSalt() {
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return bytesToHex(salt);
	}

	public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
		String passwordWithSalt = password + salt;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashedPassword = md.digest(passwordWithSalt.getBytes());
		return bytesToHex(hashedPassword);

	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	// HASLANAN SİFRE DOĞRU MU
	public static boolean checkPassword(String password, String salt, String expectedHash) throws NoSuchAlgorithmException {
		String actualHash = hashPassword(password, salt);
		return actualHash.equals(expectedHash);
	}
}
