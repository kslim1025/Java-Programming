package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectionAlgorithm {

	public SelectionAlgorithm() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String argc[]) {
		
		int[] ar= {1,5,7,2,4,6,7};
		int temp;
		
		for(int i =0; i<ar.length-1;i++) {
			//System.out.print(ar[i]);
			for(int j=i+1; j<ar.length-1; j++) {
				if(ar[i]>ar[j]) {
					temp = ar[i];
					ar[i]=ar[j];
					ar[j]=temp;
				}
			}
		}//End sort
		
		for(int j=0; j<ar.length-1;j++) {
			System.out.print(ar[j]);
		}
	}
}
