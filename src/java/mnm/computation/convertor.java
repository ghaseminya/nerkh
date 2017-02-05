/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.computation;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.*;
import javax.persistence.EntityManagerFactory;
import mnm.data.jewerly;

/**
 *
 * @author mnm
 */
public class convertor implements Serializable {

    String value_from = "";
    String uniq_from = "";
    String uniq_to = "";
    String value_to = "";
    Map<String, String> comboItems = new HashMap<String, String>();

    public Map<String, String> getComboItems() {
        return comboItems;
    }

    public void setComboItems(Map<String, String> comboItems) {
        this.comboItems = comboItems;
    }

    public List<jewerly> getJew() {
        return jew;
    }

    public void setJew(List<jewerly> jew) {
        this.jew = jew;
    }
    List<jewerly> jew;

    public convertor() {
        set_combo();

    }

    public void displayLocation() {
        FacesMessage msg = new FacesMessage("Selected", "City:" + value_to + ", Suburb: " + uniq_to);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void set_combo() {
        rss_reader rs = new rss_reader();
        rs.fetching_rss();
        jew = rs.reader();

        for (Iterator<jewerly> it = jew.iterator(); it.hasNext();) {
            jewerly object = it.next();
            comboItems.put(object.name, "_"+object.id);
        }
    }

    public String getUniq_from() {
        return uniq_from;
    }

    public void setUniq_from(String uniq_from) {
        this.uniq_from = uniq_from;
    }

    public String getUniq_to() {
        return uniq_to;
    }

    public void setUniq_to(String uniq_to) {
        this.uniq_to = uniq_to;
    }

    public String getValue_from() {
        return value_from;
    }

    public void setValue_from(String value_from) {
        this.value_from = value_from;
    }

    public String getValue_to() {
        return value_to;
    }

    public void setValue_to(String value_to) {
        this.value_to = value_to;
    }

    /**
     * @param args the command line arguments
     */
    public void compute() {
        // TODO code application logic here
//        convertor mnm =new convertor();
        value_to = convertor(value_from, uniq_from, uniq_to);
        displayLocation();
        System.out.println(value_to);

    }

    public String convertor(String text_value, String uniq, String uniq2) {
//        System.out.print(uniq);

        double u1 = Double.valueOf(pay_bak(uniq));
        double u2 = Double.valueOf(pay_bak(uniq2));
        double t;
        try {
            t = Double.valueOf(text_value);
        } catch (NumberFormatException s) {
            t = 1;
        }
        double result = t * u1 / u2;
//        result=new Random().nextDouble();
        return result + "";
//        return "1100";
    }
    EntityManagerFactory emf;

    public String pay_bak(String uniq) {
        ///fetch from db uniq value

        for (Iterator<jewerly> it = jew.iterator(); it.hasNext();) {
            jewerly s = it.next();
//            System.out.println(uniq);
//            System.out.print(s.getName());
            String ss = "_"+s.getId();
            if (uniq.equals(ss)) {
//                System.out.println("mnm is ok"+s.getBuy());
                return s.getBuy();
            }
        }

        return "1";
    }

    public static void main(String a[]) {
        convertor con = new convertor();
        System.out.println(con.convertor("1", "انس", "مظنه"));
    }
}