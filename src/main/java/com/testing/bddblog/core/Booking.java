package com.testing.bddblog.core;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="room")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="client")
    private Client client;

    @Column(name = "dateIn")
    private Date dateIn;

    @Column(name ="dateOut")
    private Date dateOut;

    public Integer getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Client getClient() {
        return client;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }
}
