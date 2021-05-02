/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Compke implements Serializable{
    private int id;
    private int username;

    public Compke() {
    }

    public Compke(int id, int username) {
        this.id = id;
        this.username = username;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }
    
    
}
