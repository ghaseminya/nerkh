/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.data;

import java.io.Serializable;

/**
 *
 * @author mnm
 */
public class jewerly implements Serializable{
    public int id;
    public String name;

    public jewerly() {
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }
    public String sell;
    public String buy;
}
