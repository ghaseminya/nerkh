/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.rss;

/**
 *
 * @author mnm
 */
public class items {

            private String title;
    private int id;
    private String link;
    private String description;
    private String author;
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
     public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
     public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
