package intro;

public class Main {

	public static void main(String[] args) {
		String[][] sehirler = new String[3][3];
		
		for(int i = 0; i<sehirler.length;i++) {
			for(int j=0; j<sehirler[0].length;j++) {
				sehirler[i][j] = " + ";
				System.out.print(sehirler[i][j]);
			}
			System.out.println();
		}
		
	}
}
