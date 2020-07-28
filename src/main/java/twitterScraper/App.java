/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package twitterScraper;

import java.io.IOException;
import java.util.ResourceBundle;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class App {
	private static ResourceBundle props = ResourceBundle.getBundle("twitterScraper");
	private static Login twitterLogin = new Login();
	private static Twitter twitter = TwitterFactory.getSingleton();
	
    public static void main(String[] args) throws TwitterException, IOException {
        AccessToken at = twitterLogin.createAccessToken(props.getString("Dtwitter4j.oauth.consumerKey"), props.getString("Dtwitter4j.oauth.consumerSecret"));
        ResponseList<Status> mentions = twitter.getMentionsTimeline();
        ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
        new GUI();
        
    }
}
