package twitter;

import java.util.Date;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		
		final Twitter twitter = new TwitterFactory().getInstance();
		
		Date now = new Date();
		//String latestStatus = "Hey @fib_was, we've just completed task #4 [timestamp: "+now+"]";
		//Status status = twitter.updateStatus(latestStatus);
		ResponseList<Status> idLatTweet = twitter.getUserTimeline("@fib_was");
		Status t = idLatTweet.get(0);
		Long id = t.getId();
		twitter.retweetStatus(id);
		System.out.println(t.getText());       
	}
}
