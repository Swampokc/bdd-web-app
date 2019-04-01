package com.testing.bddblog.core;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "adultPlaces")
    private Integer adultPlaces;

    @Column (name="childPlaces")
    private Integer childPlaces;

    @Column (name="count")
    private Integer count;

    @Column (name="cost")
    private Integer cost;

    @Column (name="s_img")
    private Integer s_img;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAdultPlaces() {
        return adultPlaces;
    }

    public Integer getChildPlaces() {
        return childPlaces;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getS_img() {
        return s_img;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdultPlaces(Integer adultPlaces) {
        this.adultPlaces = adultPlaces;
    }

    public void setChildPlaces(Integer childPlaces) {
        this.childPlaces = childPlaces;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setS_img(Integer s_img) {
        this.s_img = s_img;
    }
}
