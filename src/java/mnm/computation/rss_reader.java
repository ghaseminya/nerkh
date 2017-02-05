/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.computation;

/**
 *
 * @author mnm
 */
import java.sql.Date;
import java.util.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mnm.data.jewerly;
import mnm.db.Price;
import mnm.db.PriceJpaController;
import mnm.rss.FeedReader;
import mnm.rss.items;
import mnm.rss.rss;

public class rss_reader{
    List<Price> pr_li;
    public void set_in_db(){
emf =
      Persistence.createEntityManagerFactory("irannerkhPU");
        PriceJpaController mnm=new PriceJpaController(emf);
        
        for (Iterator<Price> it = pr_li.iterator(); it.hasNext();) {
            Price price = it.next();
            try{
        mnm.create(price);
        }catch(Exception s){
            
        }
        }
           
    }
    EntityManagerFactory emf;
    public void generate_js(){
        
    }
    
    public void fetching_rss(){
      pr_li= new ArrayList<Price>();
            
      rss rs=new FeedReader().reader("http://goldprice.ir/rs.php?u=iran&p=nerkh");
      List<items> li=rs.getItemss();
        for (Iterator<items> it = li.iterator(); it.hasNext();) {
            items object = it.next();
            Price p=new Price();
            jewerly j=new jewerly();
//            System.out.println(object.getTitle().lastIndexOf("\n")+"\t"+object.getTitle().length());
//            System.out.println(object.getTitle());
//            
            
            String name="";
            String date;
            if(object.getTitle().lastIndexOf("\n")==(object.getTitle().length()-2)){
            name=object.getTitle().substring(0,object.getTitle().lastIndexOf("\n",object.getTitle().length()-4));
             date=object.getTitle().substring(object.getTitle().lastIndexOf("\n",object.getTitle().length()-4));
            
            }
            else{
                name=object.getTitle().substring(0,object.getTitle().lastIndexOf("\n"));
            date=object.getTitle().substring(object.getTitle().lastIndexOf("\n"));
            }
            String da=object.getDescription();
            
//            System.out.println("name\t"+name);
//            System.out.println("date\t"+date);
//            System.out.println("price\t"+da);
//            
            if(date.equals(""))
                date="date";
            
            p.setName(name);
            p.setSell(da);
            p.setPerTime(date);
            p.setBuy(da);
            p.setTime(new java.util.Date());
            pr_li.add(p);
        }
           

    }
    public List<jewerly> reader(){
        List<jewerly> jew=new ArrayList<jewerly>();
        int id=1;
        for (Iterator<Price> it = pr_li.iterator(); it.hasNext();) {
            Price p = it.next();
            jewerly j =new jewerly();
        
            j.setName(p.getName());
            j.setSell(p.getSell());
            j.setBuy(p.getBuy());
            j.setId(id++);
            jew.add(j);
            if(id==5)break;
        }   
           
        return jew;
    }//end of main

    public List<jewerly> reader_bill(){
      List<jewerly> jew=new ArrayList<jewerly>();
        int id=0;
        for (Iterator<Price> it = pr_li.iterator(); it.hasNext();) {
            Price p = it.next();
            id++;
            if(id<56)continue;
            jewerly j =new jewerly();
        
            j.setName(p.getName());
            j.setSell(p.getSell());
            j.setBuy(p.getBuy());
            j.setId(id-55);
            jew.add(j);
            if(id==93)break;
        }
           
        return jew;
    }//end of main
public List<jewerly> reader_coin(){
      List<jewerly> jew=new ArrayList<jewerly>();
        int id=0;
        for (Iterator<Price> it = pr_li.iterator(); it.hasNext();) {
            Price p = it.next();
            id++;
            if(id<5 || id> 8)
                if(id!=94)
                    continue;
            jewerly j =new jewerly();
        
            j.setName(p.getName());
            j.setSell(p.getSell());
            j.setBuy(p.getBuy());
            j.setId(id);
            jew.add(j);
            
        }
            return jew;
    }//end of main

public static void main(String a[]){
    rss_reader rs=new rss_reader();
    rs.reader();
    rs.set_in_db();
}
    
}
