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

    @Column (name = "aplaces")
    private Integer aplaces;

    @Column (name="cplaces")
    private Integer cplaces;

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

    public Integer getAplaces() {
        return aplaces;
    }

    public Integer getCplaces() {
        return cplaces;
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
        this.aplaces = adultPlaces;
    }

    public void setChildPlaces(Integer childPlaces) {
        this.cplaces = childPlaces;
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

    public Room() {

    }

    public Room(String name, String description, Integer aplaces, Integer cplaces, Integer count, Integer cost, Integer s_img) {
        this.name = name;
        this.description = description;
        this.aplaces = aplaces;
        this.cplaces = cplaces;
        this.count = count;
        this.cost = cost;
        this.s_img = s_img;
    }
}
