/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.rss;

import java.util.List;

/**
 *
 * @author mnm
 */
public class rss {


    //////rss description
    private String r_title;
    private String r_link;
    private String r_description;
    private String copyright;
    private String language;
    private String managingEditor;
    private String webMaster;
    private String lastBuildDate;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private List<items> itemss;

    public List<items> getItemss() {
        return itemss;
    }

    public void setItemss(List<items> itemss) {
        this.itemss = itemss;
    }
    

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

   
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

        /////items

   

    public String getManagingEditor() {
        return managingEditor;
    }

    public void setManagingEditor(String managingEditor) {
        this.managingEditor = managingEditor;
    }

    public String getR_description() {
        return r_description;
    }

    public void setR_description(String r_description) {
        this.r_description = r_description;
    }

    public String getR_link() {
        return r_link;
    }

    public void setR_link(String r_link) {
        this.r_link = r_link;
    }

    public String getR_title() {
        return r_title;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

   
    public String getWebMaster() {
        return webMaster;
    }

    public void setWebMaster(String webMaster) {
        this.webMaster = webMaster;
    }


}
