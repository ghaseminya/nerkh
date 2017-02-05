/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.computation;

import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mnm.data.jewerly;

import mnm.db.Aiar;
import mnm.db.AiarJpaController;
import mnm.rss.FeedReader;

/**
 *
 * @author mnm
 */
public class compute implements  Serializable{
    String kind_to="";

    public String getAiar() {
        return aiar;
    }

    public void setAiar(String aiar) {
        this.aiar = aiar;
    }

    public String getAiar2() {
        return aiar2;
    }

    public void setAiar2(String aiar2) {
        this.aiar2 = aiar2;
    }

    public List<Aiar> getData() {
        return data;
    }

    public void setData(List<Aiar> data) {
        this.data = data;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getKind_to() {
        return kind_to;
    }

    public void setKind_to(String kind_to) {
        this.kind_to = kind_to;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    String result="";
    String kind="";
    String weight="";
    String aiar="";
    String aiar2="";
     Map<String,String> combo1items = new HashMap<String, String>(); 
    Map<String,String> combo2items = new HashMap<String, String>(); 
    List<Aiar> data;
    public compute() {
        set_combo();
        
        combo2items.put("طلای ۱۸","" );
//        combo2items.put("طلای ۲۴","طلای ۲۴");
    }
    
    public void set_combo(){
      emf =
      Persistence.createEntityManagerFactory("irannerkhPU");
   
        AiarJpaController ap=new  AiarJpaController(emf);  
      List<Aiar> app=ap.findAiarEntities();
      for (Iterator<Aiar> it = app.iterator(); it.hasNext();) {
            Aiar  a= it.next();
                combo1items.put(a.getName(),"_"+a.getIdaiar());
            }

//      emf =
//      Persistence.createEntityManagerFactory("irannerkhPU");
//      AiarJpaController ap=new  AiarJpaController(emf);  
//      List<Aiar> app=ap.findAiarEntities();
//      for (Iterator<Aiar> it = app.iterator(); it.hasNext();) {
//            Aiar  a= it.next();
//            combo2items.put(a.getName(), "_"+a.getIdaiar());
//        }
//      
    }

    public Map<String, String> getCombo1items() {
        return combo1items;
    }

    public void setCombo1items(Map<String, String> combo1items) {
        this.combo1items = combo1items;
    }

    public Map<String, String> getCombo2items() {
        return combo2items;
    }

    public void setCombo2items(Map<String, String> combo2items) {
        this.combo2items = combo2items;
    }
     public void displayLocation() {
        FacesMessage msg = new FacesMessage("Selected", "City:" + weight + ", Suburb: " +result);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
EntityManagerFactory emf;
    public void handle(){
      emf =
      Persistence.createEntityManagerFactory("irannerkhPU");
      AiarJpaController ap=new  AiarJpaController(emf);  
      List<Aiar> app=ap.findAiarEntities();
      for (Iterator<Aiar> it = app.iterator(); it.hasNext();) {
            Aiar  a= it.next();
            if(("_"+a.getIdaiar()).equals(kind)){
                weight=a.getWeight();
                aiar=a.getAiar();
                aiar2=a.getAiar2();
            return;
            }
        }
      
}
    public void compute(){
        handle();
        result=(Double.valueOf(weight)*Double.valueOf(aiar2)/750)+"";
        displayLocation();
    }
    
}
