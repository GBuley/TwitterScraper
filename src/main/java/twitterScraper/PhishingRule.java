package twitterScraper;

public class PhishingRule {

	private String pattern;

	public PhishingRule(String pattern) {
		this.pattern = (".*"+pattern+".*");
	}

	public boolean checkIfMatches(String text) {
		
		return text.matches(pattern);
	}

}
