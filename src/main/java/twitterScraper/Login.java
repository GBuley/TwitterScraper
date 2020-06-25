package twitterScraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class Login {
	
	public AccessToken createAccessToken(String consumerKey, String consumerSecret) throws TwitterException, IOException {
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		RequestToken rt = twitter.getOAuthRequestToken();
		AccessToken at = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    while (null == at) {
	      System.out.println("Open the following URL and grant access to your account:");
	      System.out.println(rt.getAuthorizationURL());
	      System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
	      String pin = br.readLine();
	      try{
	         if(pin.length() > 0){
	           at = twitter.getOAuthAccessToken(rt, pin);
	         }else{
	           at = twitter.getOAuthAccessToken();
	         }
	      } catch (TwitterException te) {
	        if(401 == te.getStatusCode()){
	          System.out.println("Unable to get the access token.");
	        }else{
	          te.printStackTrace();
	        }
	      }
	    }
	    return at;
	}
	
}
