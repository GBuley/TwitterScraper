package twitterScraper;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Scraper {
	
	public List<Status> getTweet(String searchText) throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
	    Query query = new Query(searchText);
	    QueryResult results = twitter.search(query);
	    int numResults = results.getCount();
	    
	    if(numResults==0) {
	    	System.out.println("No such status");
	    }
	    else {
	    	for (Status status : results.getTweets()) {
	    		System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	    	}
	    }
	    return results.getTweets();
	}
}
