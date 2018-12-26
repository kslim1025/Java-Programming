package Question11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Question {

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\kslim\\Documents\\workspace\\Lenovo_Question11\\src\\11.txt"));
		for(int i=0; i<34;i++){
			String read= br.readLine();
			System.out.println(read.split(" "));
		}
		
	}
}
