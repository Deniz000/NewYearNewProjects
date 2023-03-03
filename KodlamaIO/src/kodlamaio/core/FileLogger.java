package kodlamaio.core;

public class FileLogger implements Logger{

	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		System.out.print("Dosyaya loglandı " + message);
		System.out.println();
	}
	
	}