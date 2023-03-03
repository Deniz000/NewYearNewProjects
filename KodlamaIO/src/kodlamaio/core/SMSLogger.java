package kodlamaio.core;

public class SMSLogger implements Logger{

	@Override
	public void log(String message) {
		System.out.println("sms gönderildi ");
		System.out.println();

	}

}
