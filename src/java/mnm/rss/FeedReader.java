/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.rss;

import com.sun.syndication.feed.synd.SyndEntry;
import java.net.URL;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * It Reads and prints any RSS/Atom feed type.
 * <p>
 * @author Alejandro Abdelnur
 *
 */
public class FeedReader {

    public static void main(String[] args) throws Exception{
          rss rs=reader("http://goldprice.ir/rs.php?u=iran&p=nerkh");
          
//          System.out.println("rs.getItemss().size():"+rs.getItemss().size());
//          System.out.println("rs.getR_title():"+rs.getItemss().get(3).getTitle());
    }
    public static rss reader(String u){
        rss result = new rss();
        XmlReader reader = null;
//        System.out.println("arived url is :"+u);
        u=u.replaceAll("�",".");
        try {
            URL url = new URL(u);
            reader = new XmlReader(url);
            SyndFeed feed = new SyndFeedInput().build(reader);
            result.setR_title(feed.getTitle());
            result.setCopyright(feed.getCopyright());
            result.setR_description(feed.getDescription());
            result.setLanguage(feed.getLanguage());

            result.setLastBuildDate(feed.getPublishedDate() + "");
            result.setR_link(feed.getLink());
            result.setUrl(u);
//            System.out.println("Feed Title: " + feed.getAuthor());

            List<items> it=new ArrayList<items>();
            for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
                SyndEntry entry = (SyndEntry) i.next();
//                System.out.println(entry.getTitle());
                items temp=new items();
                temp.setAuthor(entry.getAuthor());
                temp.setDescription(entry.getDescription().getValue()+"");
                temp.setLink(entry.getLink());
                temp.setTitle(entry.getTitle());
                it.add(temp);

            }
            result.setItemss(it);
        } catch (Exception s) {
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ss) {
            }
        }
        return result;
    }

}
