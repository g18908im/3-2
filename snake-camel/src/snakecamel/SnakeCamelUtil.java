package snakecamel;

public class SnakeCamelUtil {

	public static String snakeToCamelcase(String snake_case) {
		String[] words = snake_case.split("_");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			sb.append(capitalize(words[i]));
		}
		return new String(sb);
	}
	 
	public static String camelToSnakecase(String camelcase) {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < camelcase.length(); i++) {
			char c = camelcase.charAt(i); //i番目の文字をcに格納
			if (Character.isUpperCase(c)) { //cが大文字ならば
				sb.append(camelcase.substring(j, i)); //j番目からi-1番目の文字を追加
				//sb.deleteCharAt(j+1);
				if (sb.length() > 0) { //sbの長さが0より大きければ
					sb.append("_");//_を追加
				}
				sb.append(Character.toLowerCase(c));//cをすべて小文字にする
				j = i+1; 
			}
		}
		sb.append(camelcase.substring(j));//文字の最後尾を追加
		return new String(sb);
	}
	
	static String capitalize(String s) {
		char first = s.charAt(0);
		char upperFirst = Character.toUpperCase(first);
		String rest = s.substring(1);
		return upperFirst + rest;
	}

	static String uncapitalize(String s) {
		char first = s.charAt(0);//sの0番目の文字をfirstに格納
		char lowerFirst = Character.toLowerCase(first);//firstの小文字をlowerFirstを格納
		String rest = s.substring(1);//sの1番目から末尾まで文字をrestに格納
		return lowerFirst + rest;//firstの小文字+1番目から末尾→すべてを小文字にした
	}
	
}
