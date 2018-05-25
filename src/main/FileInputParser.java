package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileInputParser {
	
	public static Matcher parse(String descr) {
		String patternRegularExp = Utilities.getPatternRegularExp();
		Pattern pattern = Pattern.compile(patternRegularExp);
		Matcher matcher = pattern.matcher(descr);
		matcher.find();
		return matcher;
	}
	
	public static boolean matches(String descr) {
		return Pattern.matches(Utilities.getPatternRegularExp(), descr);
	}

	public static int count (String order) {
		return Integer.valueOf(parse(order).group(1));
	}
	
	public static ItemInterface fileParser(String order) {
		Matcher m = parse(order);
		String name = m.group(2).trim();
		Item item = new Item(1, name, Double.valueOf(m.group(4)));
		if (Utilities.isExempted(name)) {
			item.setExempted(true);
		}
		if (name.contains("imported")) {
			item.setImported(true);;
		}
		return item;
	}
}
