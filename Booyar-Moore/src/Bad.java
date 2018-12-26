public class Bad {

	public int boyerMoore(String target, String pattern){

		BMPattern bmPattern = new BMPattern(pattern);

		int patternLength = bmPattern.getLength();

		int i = patternLength - 1;

		int j = i, k = i;

		while(i < target.length()){

			while(k >= 0 && target.charAt(j) == pattern.charAt(k)){

				j--;

				k--;

			}

			if(k == -1){

				return j + 1;

			}else{

				char badCharacter = target.charAt(j);

				i += Math.max(k - bmPattern.checkBadCharacter(badCharacter), bmPattern.getGoodSufixShifting(patternLength - 1 - k));

				j = i;

				k = patternLength - 1;

			}

		}

		

		return -1;

	}

	

	public static void main(String[] args){

		Bad bm = new Bad();

		System.out.println(bm.boyerMoore("AT-THAT", "AGAGTAGAG"));

	}

}

