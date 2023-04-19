package dev.guldeniz.cv.business.abstracts;

public interface EmailService {
    public void sendEmail(String to, String subject, String body);
    public boolean isEmailValid(String email);
    public String generateVerificationCode();
}
