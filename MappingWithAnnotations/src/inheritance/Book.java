/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "inherType", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("parent")
public class Book {
    private int id;
    private int isb;

    @Id
    @TableGenerator(allocationSize = 1, name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsb() {
        return isb;
    }

    public void setIsb(int isb) {
        this.isb = isb;
    }
    
    
}
