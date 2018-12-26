
public class Bad_character {
	     private static String string = "AGAGTAGAG";
	     private static String string2 = "AT-THAT";
		 private int count;
		 
		 private int bad_character_method(char[] comp1, char[] comp2) {
		 
		  int i = 0;
		  while (i < comp1.length - comp2.length + 1) {
		   int j = comp2.length, matchcount = 0;
		   
		   while (j > 0) {
		    if (comp1[i + comp2.length - 1] == comp2[j - 1]) {
		     break;
		    } else {
		     j--;
		    }
		   }
		   if (j != 0) {
		    i = i + comp2.length-j;
		    for(int k = 0; k < comp2.length;k++){
		     if(comp1[i+k]==comp2[k]){
		      matchcount++;
		      if (matchcount == comp2.length) {
		       i++;count++;break;
		       //위의 값들 대신 return i; 하면 같아지는 첫번째
		       //Char 순서를 알 수 있다. 맨 아래 return 은 0
		      }
		     }
		    }
		   } else {
		    i = i + comp2.length;
		   }
		  }
		  return count;
		 }
		 
		 private static char[] stringtochar(String string3) {
		  return string3.toCharArray();
		 }
		 
		 public static void main(String[] args) {
		  char[] char1 = stringtochar(string);
		  char[] char2 = stringtochar(string2);
		  Bad_character bm = new Bad_character();
		  int k = bm.bad_character_method(char1, char2);
		  System.out.print(k );
		 }
		 
		
}
