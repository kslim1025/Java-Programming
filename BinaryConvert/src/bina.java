import java.util.Scanner;

public class bina {

	public bina() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String argc[]) {
		Scanner scan= new Scanner(System.in);
		String a=scan.nextLine();
		int dici=Integer.valueOf(a);
		int digi=0;
		int power=0;
		String result="";
		
		for(int i=10;i>=0; i-- ) {
			digi=dici>>i;
			result +=digi;
			if(digi !=0) {
				dici -=1<<i;
			}
		}
		System.out.println("result"+result);
		
		
	}
	
	
}

