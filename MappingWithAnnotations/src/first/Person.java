/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OrderBy;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
@SecondaryTable(name = "jobs")
public class Person {
    private int id;
    private String name;
    private Date hireDate;
    private Date time;
    private byte[] icons;
    private int cal;
    private String postion;
    private String jobTitle;

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "name", length = 255)
    @OrderBy("name asc")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "hire")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "time")
    @Temporal(javax.persistence.TemporalType.TIME)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
  //  @Lob
//    @Basic(fetch = FetchType.LAZY)
    @Transient
    public byte[] getIcons() {
        return icons;
    }

    public void setIcons(byte[] icons) {
        this.icons = icons;
    }

    @Transient
    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    @Column(table = "jobs")
    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    @Column(table = "jobs")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", hireDate=" + hireDate + ", time=" + time + ", icons=" + icons + ", cal=" + cal + ", postion=" + postion + ", jobTitle=" + jobTitle + '}';
    }

    
    
    
    
    
}
