import java.util.HashMap;

import java.util.Map;



public final class BMPattern {

	private String pattern;

	/**

	 * 字符map，key为字符，value为离pattern尾部最近的该字符出现的位置。

	 */

	private Map<Character, Integer> characterMap = new HashMap<Character, Integer>();

	

	/**

	 * 后缀map，key为后缀长度（1 ～ pattern.length()）,value为与当前长度后缀相等的离pattern尾部最近的子串与该后缀的距离。

	 * 如pattern字符串“defefcdef”的suffixMap为{{1, 4}, {2, 4}, {3, 6}}

	 */

	private Map<Integer, Integer> suffixMap = new HashMap<Integer, Integer>();

	

	private Map<Integer, Boolean> suffixIsPrefix = new HashMap<Integer, Boolean>();

	

	public BMPattern(String pattern){

		this.pattern = pattern;

		setCharacterMap();

		setSuffixMap();

		setSuffixIsPrefix();

	}

	

	public String getPattern(){

		return pattern;

	}

	

	public int getLength(){

		return pattern.length();

	}

	

	public int checkBadCharacter(char badCharacter){

		if(characterMap.containsKey(badCharacter)){

			return characterMap.get(badCharacter);

		}

		return -1;

	}

	

	public int checkGoodSuffix(int goodSuffixLength){

		if(suffixMap.containsKey(goodSuffixLength)){

			return suffixMap.get(goodSuffixLength);

		}

		return -1;

	}

	

	private void setCharacterMap(){

		int length = pattern.length();

		for(int i = length - 2;i >= 0;i--){

			char c = pattern.charAt(i);

			if(!characterMap.containsKey(c)){

				characterMap.put(c, i);

			}

		}

	}

	

	private void setSuffixIsPrefix(){

		int length = pattern.length();

		for(int i = length - 1;i >= 0;i--){

			int j = 0, k = i;

			for(;j < length - i;k++, j++){

				if(pattern.charAt(j) != pattern.charAt(k)){

					break;

				}

			}

			if(j != length - i){

				suffixIsPrefix.put(length - i, false);

			}else{

				suffixIsPrefix.put(length - i, true);

			}

		}

	}

	

	private void setSuffixMap(){

		int length = pattern.length();

		for(int i = length - 1;i >= 0;i--){

			int q = i;

			while(q >= 0 && pattern.charAt(q) == pattern.charAt(q + length - 1 - i)){

				if(!suffixMap.containsKey(i - q)){

					suffixMap.put((i - q), length - 1 - i);

				}

				q--;

			}

		}

	}



	public int getGoodSufixShifting(int goodSuffixLength) {

		int shifting = 0;

		if((shifting = checkGoodSuffix(goodSuffixLength)) == -1){

			int i = goodSuffixLength - 1;

			for(;i > 0;i--){

				if(suffixIsPrefix.get(i) == true){

					return pattern.length() - i;

				}

			}

			return pattern.length();

		}else{

			return shifting;

		}

	}

}