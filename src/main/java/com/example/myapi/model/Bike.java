package com.example.myapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bike_table")
public class Bike {

    private long id;
    private String brand;
    private String color;
 
    public Bike() {
  
    }
 
    public Bike( String brand, String color) {
         this.brand = brand;
         this.color = color;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "brand", nullable = false)
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
 
    @Column(name = "color", nullable = false)
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bike [id=" + id + ", brand=" + brand + ", color=" + color
       + "]";
    }
 
}