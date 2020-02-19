import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.SyndFeedOutput;
import com.sun.syndication.io.XmlReader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ImageScrapper extends Thread{
        public void run(){
            try {
                // Execute Second thread every 20 Seconds that will scrap Image Reference from local Feed
                while (true) {
                    try {
                        File inputFile = new File("D:\\a.rss");
                        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                        Document doc = dBuilder.parse(inputFile);
                        doc.getDocumentElement().normalize();
                        NodeList nList = doc.getElementsByTagName("media:content");

                        for (int temp = 0; temp < nList.getLength(); temp++) {
                            Node nNode = nList.item(temp);
                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element eElement = (Element) nNode;
                                System.out.println(eElement.getAttribute("url"));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(20 * 1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}