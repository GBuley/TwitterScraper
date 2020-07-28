package twitterScraper;

import java.util.ArrayList;
import java.util.List;

public class PhishingRules {
	private static List<PhishingRule> rules;
	static {
		rules = new ArrayList<>();
		rules.add(new PhishingRule(",,"));
		rules.add(new PhishingRule("(Click Me\\!|https\\:)"));
		rules.add(new PhishingRule("http\\:"));
		rules.add(new PhishingRule("Click here and install"));
		rules.add(new PhishingRule("Click here"));
		rules.add(new PhishingRule("Click here & install"));
		rules.add(new PhishingRule("Click here"));
		rules.add(new PhishingRule("CLICK"));
		rules.add(new PhishingRule("INSTAGRAM"));
		rules.add(new PhishingRule("BTC"));
		rules.add(new PhishingRule("Bitcoin && doubled"));
		rules.add(new PhishingRule("a maximum"));
		rules.add(new PhishingRule("act now!"));
		rules.add(new PhishingRule("Act Now!"));
		rules.add(new PhishingRule("Act Now"));
		rules.add(new PhishingRule("act now"));
		rules.add(new PhishingRule("hurry"));
		rules.add(new PhishingRule("bc"));
		rules.add(new PhishingRule("Bitcoin sent"));
		
		
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
