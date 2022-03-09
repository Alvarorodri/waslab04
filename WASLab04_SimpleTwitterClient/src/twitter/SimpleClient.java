package twitter;

import java.io.IOException;
import java.util.Date;

import twitter4j.FilterQuery;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.ResponseList;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class SimpleClient {

	public static void main(String[] args) throws TwitterException, IOException {
		
		/*final Twitter twitter = new TwitterFactory().getInstance();
		
		Date now = new Date();
		//String latestStatus = "Hey @fib_was, we've just completed task #4 [timestamp: "+now+"]";
		//Status status = twitter.updateStatus(latestStatus);
		ResponseList<Status> idLatTweet = twitter.getUserTimeline("@fib_was");
		Status t = idLatTweet.get(0);
		Long id = t.getId();
		twitter.retweetStatus(id);
		System.out.println(t.getText());       */
		
	    StatusListener listener = new StatusListener(){
	        public void onStatus(Status status) {
	            System.out.println(status.getUser().getName() + " : " + status.getText());
	        }
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
	    };

	    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
	    
	    twitterStream.addListener(listener);
	    twitterStream.sample();
	    
	}
}
