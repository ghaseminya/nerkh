/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.computation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mnm.data.jewerly;
import mnm.data.nerkh;
import mnm.db.Price;
import mnm.db.PriceJpaController;

/**
 *
 * @author mnm
 */
public class js_generator {
    EntityManagerFactory emf;
    List<Price> l;

    public js_generator() {
    getten();
    }
    
    public void getten(){
        ///fetch from db uniq value
        emf =
      Persistence.createEntityManagerFactory("irannerkhPU");
        PriceJpaController mnm=new PriceJpaController(emf);
            l=mnm.findPriceEntities(10, -1);
            
    }
    public void generate(){
        nerkh ne=new nerkh();
        ne.set_Jew();
        List<jewerly> jew=ne.getJew();
         try{
  // Create file 
  FileWriter fstream = new FileWriter("/home/mnm/my_test.js",false);
  BufferedWriter out = new BufferedWriter(fstream);
  out.write("var update=\""+new Date().toLocaleString()+"\"");
  out.write("; var last={");
  
  int i=0;
             for (Iterator<jewerly> it = jew.iterator(); it.hasNext();) {
                 jewerly object = it.next();
                 
                 if(i!=9)
                 out.write("\"0_"+object.id+"\":"+object.buy+",");
                 else
                 out.write("\"0_"+object.id+"\":"+object.buy+"};");    
                 i++;
             }
             
             
             
             out.write("var change={");
  
   i=0;
             for (int j=0;j<10;j++) {
                 
                 if(i!=9)
                 out.write("\"0_"+jew.get(j).id+"\":"+jew.get(j).buy+",");
                 else
                 out.write("\"0_"+jew.get(j).id+"\":"+jew.get(j).buy+"};");    
                 i++;
             }
  out.write(getotherfile());
  //Close the output stream
  out.close();
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
  
        
    }
    public String getotherfile(){
  String strLine="";
        try{
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream("pss.js");
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  
  //Read File Line By Line
  while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
  strLine+=strLine;
  }
  //Close the input stream
  in.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }return strLine;
    }
   
}
