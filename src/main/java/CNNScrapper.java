import com.sun.syndication.feed.synd.*;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.SyndFeedOutput;
import com.sun.syndication.io.XmlReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.List;

public class CNNScrapper {
    public static void main(String[] args) throws IOException, FeedException {
        try {
            //The link of CNN Feed from where we will get the feed entries
            URL feedUrl = new URL("http://rss.cnn.com/rss/edition.rss");

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            Writer writer = new FileWriter("D:\\a.rss");
            SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
            syndFeedOutput.output(feed, writer);
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}