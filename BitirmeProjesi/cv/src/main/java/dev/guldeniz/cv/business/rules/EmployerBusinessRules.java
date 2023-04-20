package dev.guldeniz.cv.business.rules;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import dev.guldeniz.cv.dataAccess.abstracts.EmployerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployerBusinessRules {

	private EmployerRepository employerRepository;

	public void checkIfEMailExist(String email) throws Exception {
		if (this.employerRepository.existsByEMail(email)) {
			throw new Exception("Email zaten var");
		}
	}

	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// domainin email domaini ile aynı mı farklı mı olduğunu kontrol eder.
	public void checkIfEMailMatch(String email, String webSite) throws Exception {

		String domain = webSite.replaceFirst("^(http://|https://)?(www\\.)?", "").split("/")[0];
		String emailDomain = email.split("@")[1];

		if (!email.matches(EMAIL_REGEX)) {
			throw new Exception("Invalid email address.");
		}
		if (!domain.equals(emailDomain)) {
			throw new Exception("Website and email domains do not match.");
		}
	}

	// SİFRE HASHLEMEK İÇİN GEREKEN KODLAR
	private static final SecureRandom random = new SecureRandom();

	public static String generateSalt() {
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return bytesToHex(salt);
	}

	public static String hashPassword(String password, String salt) {
		String passwordWithSalt = password + salt;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedPassword = md.digest(passwordWithSalt.getBytes());
			return bytesToHex(hashedPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	// HASLANAN SİFRE DOĞRU MU
	public static boolean checkPassword(String password, String salt, String expectedHash) {
		String actualHash = hashPassword(password, salt);
		return actualHash.equals(expectedHash);
	}

}