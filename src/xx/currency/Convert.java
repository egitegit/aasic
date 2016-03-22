package xx.currency;

public class Convert {
	private String string;
	private static int times = 0;

	public Convert(String s) {
		// TODO Auto-generated constructor stub
		string = s;
	}

	public String toText() {
		if (string.substring(string.length() - 3, string.length()).equals(".00"))
			string = string.substring(0, string.length() - 3);
		String strTemp = string;
		if (string.charAt(string.length() - 3) == '.') {
			strTemp = string.substring(0, string.length() - 3);
		}
		String resultString = toText8(strTemp);
		if (string.charAt(string.length() - 3) == '.') {
			resultString += "点" + toText(string.charAt(string.length() - 2));
			if (string.charAt(string.length() - 1) != '0')
				resultString += toText(string.charAt(string.length() - 1));
		} else {
			resultString += "整";
		}
		char[] temp = resultString.toCharArray();
		char[] result = new char[temp.length];
		int before = 0, after = 0, j = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == '零' && result[0] == 0)
				continue;
			if (temp[i] == '零' && temp[i - 1] != '零') {
				before = j - 1;
			}
			if (temp[i] == '零' && temp[i + 1] != '零') {
				after = i + 1;
				if (result[before] == '万' || result[before] == '亿') {
					if (temp[after] == '万') {
						i++;
					} else if (temp[after] == '亿') {
						if (result[before] == '亿') {
							while (temp[after] == '亿')
								i = after++;
						}
					} else if(temp[after] =='点' || temp[after] == '整') {
						;
					} else {
						result[j++] = '零';
					}
				} else {
					if (temp[after] == '万' || temp[after] == '亿' || temp[after] =='点' || temp[after] == '整') {
						;
					} else {
						result[j++] = '零';
					}
				}
				continue;
			}
			if (temp[i] != '零')
				result[j++] = temp[i];
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0)
				stringBuilder.append(result[i]);
		}
		return stringBuilder.toString();
	}

	private String toText(char c) {
		String[] nameStrings = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆",
				"柒", "捌", "玖" };
		return nameStrings[c - 48];
	}

	private String toText4(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			String string = toText(c[i]);
			stringBuilder.append(string);
			if (string.equals("零"))
				continue;
			switch (i + (4 - c.length)) {
			case 0:
				stringBuilder.append("仟");
				break;
			case 1:
				stringBuilder.append("佰");
				break;
			case 2:
				stringBuilder.append("拾");
				break;
			default:
				break;
			}
		}
		return stringBuilder.toString();
	}

	private String toText8(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		if (s.length() > 8) {
			times++;
			String sub = s.substring(s.length() - 8, s.length());
			stringBuilder.append(toText8(s.substring(0, s.length() - 8)));
			for (int i = 0; i < times; i++)
				stringBuilder.append("亿");
			times--;
			stringBuilder.append(toText4(sub.substring(0, 4)));
			stringBuilder.append("万");
			stringBuilder.append(toText4(sub.substring(4, 8)));
		} else {
			if (s.length() > 4) {
				stringBuilder.append(toText4(s.substring(0, s.length() - 4)));
				stringBuilder.append("万");
				stringBuilder.append(toText4(s.substring(s.length() - 4, s.length())));
			} else {
				stringBuilder.append(toText4(s.substring(0, s.length())));
			}
		}
		return stringBuilder.toString();
	}
}
