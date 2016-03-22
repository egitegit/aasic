//charcode
package xx.charset;

public class CharCode {
	private String charSet;
	private String charCode;
	
	public CharCode(String charSet, String charCode) {
		this.charSet = charSet;
		this.charCode = charCode;
	}

	public String getCharSet() {
		return charSet;
	}

	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}

	public String getCharCode() {
		return charCode;
	}

	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}
	
	public static String charToCode(String sChar) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] chars = sChar.toCharArray();
		
		for(int i = 0; i < chars.length; i++) {
			stringBuilder.append("0X");
			stringBuilder.append(Integer.toHexString(chars[i]));
			stringBuilder.append(" ");
		}
		stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
		return stringBuilder.toString();
	}
//	
//	public String codeToChar(String sCode) {
//		return new String(Character.toChars(Integer.parseInt(sCode.substring(2), 16)));
//	}
	
	public static String codeToChar(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		String[] strings = s.split(" ");
		int tempB = Integer.parseInt(strings[0].substring(2), 16);
		if(strings.length > 1) {
			int tempA = Integer.parseInt(strings[1].substring(2), 16);
			if(tempB >= 0xD800 && tempB <= 0xDBFF && tempA >= 0xDC00 && tempA <= 0xDFFF) {
				tempB = ((tempB - 0xD800) << 10) + (tempA - 0xDC00) + 0x10000;
			}
		}
		stringBuilder.append(new String(Character.toChars(tempB)));
		return stringBuilder.toString();
	}
}
