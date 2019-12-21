package pl.kodu.akademia.bodyMassIndex.Model;

import javax.persistence.*;

@Entity( name="tbodymassindex")
public class bodyMassIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int waga;
    private int  wzrost;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Sex sex;
    private double policzoneBMI;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoliczoneBMI() {
        return policzoneBMI;
    }

    public void setPoliczoneBMI(double policzoneBMI) {
        this.policzoneBMI = policzoneBMI;
    }

    public bodyMassIndex() {
    }


    public int  getWaga() {
        return waga;
    }

    public void setWaga(int  waga) {
        this.waga = waga;
    }

    public int  getWzrost() {
        return wzrost;
    }

    public void setWzrost(int  wzrost) {
        this.wzrost = wzrost;
    }
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "bodyMassIndex{" +
                "waga =" + waga +
                ", wzrost = " + wzrost +
                ", plec =  '" + sex;
    }

}


