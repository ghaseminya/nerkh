/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.computation;

/**
 *
 * @author mnm
 */
import java.io.Serializable;  
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mnm.db.Price;
import mnm.db.PriceJpaController;
  
import org.primefaces.model.chart.CartesianChartModel;  
import org.primefaces.model.chart.LineChartSeries;  
  
public class chart implements Serializable {  
  
    
  
    private CartesianChartModel linearModel;  
  
    public chart() {  
        
        createLinearModel();  
    }  
  
    
    public CartesianChartModel getLinearModel() {  
        return linearModel;  
    }  
  
    EntityManagerFactory emf;
    private void createLinearModel() {  
        linearModel = new CartesianChartModel();  
  
        LineChartSeries series1 = new LineChartSeries();  
        series1.setLabel("طلا");  
  
         emf =
      Persistence.createEntityManagerFactory("irannerkhPU");
      PriceJpaController pjpa=new PriceJpaController(emf);
      List<Price> lpi=pjpa.findPriceEntities(1000, 1);
        for (Iterator<Price> it = lpi.iterator(); it.hasNext();) {
            Price price = it.next();
            if(price.getName().equals("\nمظنه"))
            {
                    double value=Double.valueOf(price.getBuy());
                    series1.set(price.getTime().getMinutes()+":"+price.getTime().getSeconds(), value);  
            }
                
        }
      
        
        
        LineChartSeries series2 = new LineChartSeries();  
        series2.setLabel("سکه يک گرمی");  
        series2.setMarkerStyle("diamond");  
  
        for (Iterator<Price> it = lpi.iterator(); it.hasNext();) {
            Price price = it.next();
            if(price.getName().equals("\nسکه يک گرمی"))
            {
                    double value=Double.valueOf(price.getBuy());
                    series2.set(price.getTime().getMinutes()+":"+price.getTime().getSeconds(), value);  
            }
                
        }
        linearModel.addSeries(series1);  
        linearModel.addSeries(series2);  
    }  
}  
