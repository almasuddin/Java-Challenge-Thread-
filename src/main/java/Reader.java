import com.sun.syndication.feed.synd.*;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.URL;
import java.util.List;

public class Reader {
    public void getData(String url){
        try {
            URL feedUrl = new URL(url);

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            System.out.println("Feed Title: " + feed.getTitle());
            /* Get the entry items... */
            for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
                System.out.println("Title: " + entry.getTitle());
                System.out.println("Unique Identifier: " + entry.getUri());
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}