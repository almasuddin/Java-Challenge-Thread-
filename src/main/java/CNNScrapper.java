import com.sun.syndication.feed.synd.*;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.URL;
import java.util.List;

public class CNNScrapper {
    public static void main(String[] args) {
        Reader cnnReader = new Reader();
        cnnReader.getData("http://rss.cnn.com/rss/edition.rss");
    }
}