package twitterScraper;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhishingRulesTest {

	@Test
	public void test() {
		String text = "Hello!!!";
		String text2 = "Hello,,You";
		PhishingRule rule = new PhishingRule(",,");
		assertFalse(rule.checkIfMatches(text));
		assertTrue(rule.checkIfMatches(text2));
		PhishingRule rule2 = new PhishingRule("\\!\\!");
		assertTrue(rule2.checkIfMatches(text));
		assertFalse(rule2.checkIfMatches(text2));
		
	}
	
	@Test
	public void test2(){
		String text = "Hey what's up!";
		String bad ="Thsss is badd,,!!";
		assertFalse(PhishingRules.checkForPhishing(text));
		assertTrue(PhishingRules.checkForPhishing(bad));
		assertTrue(PhishingRules.checkForPhishing("Click Me! https://hello.com"));
		assertTrue(PhishingRules.checkForPhishing("BTC"));
		assertTrue(PhishingRules.checkForPhishing("Bitcoin"));
	}

}
