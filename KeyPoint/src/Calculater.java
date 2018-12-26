/**
 * 
 */

/**
 * @author kslim
 *
 */
public class Calculater {

	private String result = "0";
	private int op = 0, add=1, sub=2, mul=3, div=4, sqrt = 5;//;는 펀하오
	
	private double StringToDouble(String S){
		double y=Double.parseDouble(S); //()코우하오
		return y;
	}
	
	private void operate(String S) {
		Double x = StringToDouble(S);
		Double y = StringToDouble(result);
		switch(op) {
		case 0://마오하오
			result=S;
			break;
		case 1:
			result=String.valueOf(y+x);
			break;
		case 2:
			result= String.valueOf(y-x); //- jian
			break;
		case 3:
			result = String.valueOf(y*x);
			break;
		case 4:
			if(x!=0) {
				result = String.valueOf(y/x); // /는 chuyu
			}else {
				result = "The divisior can not be zero !"; //" ying hao
			}
			break;
		case 5:
			result = String.valueOf(Math.sqrt(x));
			break;
		case 6:
			result = "";
			break;
		}//dao kouhao
	}
	
	public String opAdd(String S) {
		operate(S);
		op=add;
		return result;
	}
	
	public String opSubStract(String S) {
		operate(S);
		op=sub;
		return result;
	}
	
	public String opMultiply(String S) {
		operate(S);
		op= mul;
		return result;
	}
	
	public String opDivide(String S) {
		operate(S);
		op=div;
		return result;
	}
	
	public String opEqual(String S) {
		operate(S);
		op=0;
	    return result;
	}
	
	public String opSqrt(String S) {
		operate(S);
		op=sqrt;
	    return result;
	}
	
	public void opClear() {
		op=0;
	    result = "0";
	}

}
