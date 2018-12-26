package slave;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SlaveAnalysis {

	public SlaveAnalysis() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= null;
		BufferedWriter bw= null;
	    
		int i=0;
		String input;
		String[] output;
		ArrayList<String> Original=new ArrayList<>();
		ArrayList<String> CloneCode=new ArrayList<>();
		String Percentage=null;
		
		try{
		br = new BufferedReader(new FileReader("C:\\Users\\kslim\\Documents\\workspace\\SlaveAnalysis\\SlaveAnalysis\\Slave(edit)"));
	    bw = new BufferedWriter(new FileWriter("C:\\Users\\kslim\\Documents\\workspace\\SlaveAnalysis\\SlaveAnalysis\\Slave(result)"));


	    int count=0;	   
		final String[] result= {"Original file name: ","ClonCode Name: ","Percentage"};
		
	    while((input=br.readLine())!=null){
	    	StringTokenizer parse = new StringTokenizer(input," ");
	    	while(parse.hasMoreTokens()) {
	    		String token = parse.nextToken().trim(); //토큰을 하나씩 꺼내오는 중
	    		
	    		//Original File Path
	    		if(token.startsWith("originpath:hdfs://")) {	  
	    			int pFirst=token.indexOf("//");
	    			int pLast=token.lastIndexOf("r/");
	    			int fFirst=token.lastIndexOf("/");
	    			int fLast=token.lastIndexOf("h");
	    			int fLast1=token.lastIndexOf("c");

	    			Original.add("Original Project Name: "+token.substring(pFirst+2,pLast+1));
	    				if(token.endsWith("h")) {
	    				    Original.add("Original File Name: "+token.substring(fFirst+1,fLast+1));
	    				}else if(token.endsWith("c")) {
	    					Original.add("Original File Name: "+token.substring(fFirst+1,fLast1+1));
	    				}	
		    			System.out.println(Original);
	    		}
	    		
	    		//Clone File Path
	    		if(token.startsWith("clonepath:/")) {
	    			int pFirst1=token.indexOf(":/");
	    			int pLast1=token.lastIndexOf("/");
	    			int fFirst1=token.lastIndexOf("/");
	    			int fLast1=token.lastIndexOf("h");
	    			int fLast2=token.lastIndexOf("c");

	    			Original.add("CloneCode Project Name: "+token.substring(pFirst1+16,pLast1+1));
	    				    if(token.endsWith("h")) {
	    				    	Original.add("CloneCode File Name: "+token.substring(fFirst1+1,fLast1+1));
	    					}else if(token.endsWith("c")) {
	    						Original.add("CloneCode File Name: "+token.substring(fFirst1+1,fLast2+1));
	    					}

	    					System.out.println(Original);

	    		}
	    		if(token.equals("similarity:")) {
	    			StringTokenizer parse1 = new StringTokenizer(input,"similarity:");
	    			Percentage = parse.nextToken().trim(); //토큰을 하나씩 꺼내오는 중
	    			Original.add("similarity : "+Percentage);
	    			System.out.println(Original); //꺼내온 토큰 출력
	    		}
	    		/*if(token.equals("mac_esp.c")|token.equals("mpi2.h")|
	    				token.equals("signal.c")|token.equals("fault.c")|
	    				token.equals("sata_nv.c")|token.equals("horizon.h")|
	    				token.equals("idt77252.h")|token.equals("core.c")|
	    				token.equals("tda8290.c")|token.equals("echo.c")
	    			) {
	    			//Original.add("Count : "+count++);
	    	    	System.out.println(count++);
	    		}
*/	    	
			}
		  for(String str : Original) {
		    	bw.write(str);
		    	bw.newLine();
			   
		    }
	    }
    	System.out.println("result: "+count);
		}catch(IOException ioe){
			System.out.println("파일 찾을 수 없음");
		} finally {
		    System.out.println("프로그램 종료");
		}
		
	}

}
