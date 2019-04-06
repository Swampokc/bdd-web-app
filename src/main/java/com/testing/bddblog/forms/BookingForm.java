package com.testing.bddblog.forms;

import java.sql.Date;

public class BookingForm {
    private Date dateIn;
    private Date dateOut;
    private Integer aPlaces;
    private Integer cPlaces;

    public Date getDateIn() {
        return dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public Integer getaPlaces() {
        return aPlaces;
    }

    public Integer getcPlaces() {
        return cPlaces;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public void setaPlaces(Integer aPlaces) {
        this.aPlaces = aPlaces;
    }

    public void setcPlaces(Integer cPlaces) {
        this.cPlaces = cPlaces;
    }
}
