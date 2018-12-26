
public class good_suffix {
		 private static String string = "AGAGTAGAG";
		 private static String string2 = "AT-THAT";
		 
		 private int good_suffix_method(char[] comp1, char[] comp2) {
		  int i = 0, count=0;
		  while (i < comp1.length - comp2.length + 1) {
		   int matchcount = 0,startcomp_point = comp2.length - 1;;
		   while (startcomp_point >= 0) {
		    if (comp1[i + startcomp_point] == comp2[startcomp_point]) {
		     matchcount++;
		     startcomp_point--;
		     if (matchcount == comp2.length) {
		      i++;count++; break;
		      //위의 값들 대신 return i; 하면 같아지는 첫번째
		      //Char 순서를 알 수 있다. 맨 아래 return 은 0
		     }
		    }
		    else{
		     break;
		    }
		   }
		   i++;
		  }
		  return count;
		 }
		 
		 public static char[] stringtochar(String str) {
		  return str.toCharArray();
		 }
		 
		 public static void main(String[] args) {
		  char[] char1 = stringtochar(string);
		  char[] char2 = stringtochar(string2);
		  good_suffix bm = new good_suffix();
		  int k = bm.good_suffix_method(char1, char2);
		  System.out.print(k);
		 }
		 
		}
