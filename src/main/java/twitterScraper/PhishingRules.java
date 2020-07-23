package twitterScraper;

import java.util.ArrayList;
import java.util.List;

public class PhishingRules {
	private static List<PhishingRule> rules;
	static {
		rules = new ArrayList<>();
		rules.add(new PhishingRule(",,"));
		rules.add(new PhishingRule("(Click Me\\!|https:)"));
		rules.add(new PhishingRule("http\\:"));
	}
	
	public static boolean checkForPhishing(String text) {
		for(PhishingRule r:rules) {
			if(r.checkIfMatches(text)) {
				return true;
			}
		};
		return false;
	}
	
}
