package util;

public class UtilFunctions {
	public static Double removeDollarSign(String text) {
		return Double.parseDouble(text.replace("$", ""));
	}
}
