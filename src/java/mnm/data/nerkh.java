/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.data;

import java.io.Serializable;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mnm.computation.rss_reader;
import mnm.db.Price;
import mnm.db.PriceJpaController;
import javax.faces.event.ActionEvent;  

/**
 *
 * @author mnm
 */
public class nerkh implements Serializable{
    int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    List<jewerly> jew;
    jewerly selecetedJewerly;
    
    
    List<jewerly> coin;
    jewerly selecetedcoin;
    
    
    List<jewerly> bill;
    jewerly selecetedbill;
    
    List<Price> li_per;
    
    class tala extends TimerTask{
    rss_reader rss=new rss_reader();
    public void run(){
//        rss.rss_read();
        //set date in jsf file
     
        set_Jew();
//        jew=rss.reader();
//        rss.set_in_db();
//        rss.generate_js();
//        
//        setJew();
    }
}

    public void countering(){
        counter--;
        if(counter==0)
            counter=60;
    }
    public void runing(){
        tala t=new tala();
        Timer ta=new Timer();
        ta.schedule(t,0,60000);
    }
    
    
    public nerkh() {
     
        runing();
//     set_combo();
        counter=60;
    }
    public void set_Jew(){
        rss_reader rss=new rss_reader();
        rss.fetching_rss();
        jew=rss.reader();
        coin=rss.reader_coin();
        bill=rss.reader_bill();
        rss.set_in_db();
//        rss.generate_js();
    }

    public List<jewerly> getBill() {
        return bill;
    }

    public void setBill(List<jewerly> bill) {
        this.bill = bill;
    }

    public List<jewerly> getCoin() {
        return coin;
    }

    public void setCoin(List<jewerly> coin) {
        this.coin = coin;
    }

    public jewerly getSelecetedbill() {
        return selecetedbill;
    }

    public void setSelecetedbill(jewerly selecetedbill) {
        this.selecetedbill = selecetedbill;
    }

    public jewerly getSelecetedcoin() {
        return selecetedcoin;
    }

    public void setSelecetedcoin(jewerly selecetedcoin) {
        this.selecetedcoin = selecetedcoin;
    }
    
    public List<jewerly> getJew() {
        return jew;
    }

    public void setJew(List<jewerly> jew) {
        this.jew = jew;
    }

    public jewerly getSelecetedJewerly() {
        return selecetedJewerly;
    }

    public void setSelecetedJewerly(jewerly selecetedJewerly) {
        this.selecetedJewerly = selecetedJewerly;
    }

   
    
    public static void main(String a[]){
        nerkh ne=new nerkh();
        ne.set_Jew();
        System.out.println(ne.jew.size());
    }
}
