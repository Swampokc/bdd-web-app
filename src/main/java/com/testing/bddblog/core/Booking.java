package com.testing.bddblog.core;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name="room")
    private Integer room;

    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name="client")
    private Integer client;

    @Column(name = "date_in")
    private String date_in;

    @Column(name ="date_out")
    private String date_out;

    public Integer getId() {
        return id;
    }

    public Integer getRoom() {
        return room;
    }

    public Integer getClient() {
        return client;
    }

    public String getDateIn() {
        return date_in;
    }

    public String getDateOut() {
        return date_out;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public void setDateIn(String dateIn) {
        this.date_in = dateIn;
    }

    public void setDateOut(String dateOut) {
        this.date_out = dateOut;
    }

    public Booking() {

    }

    public Booking(Integer room, Integer client, String dateIn, String dateOut) {
        this.room = room;
        this.client = client;
        this.date_in = dateIn;
        this.date_out = dateOut;
    }
}
