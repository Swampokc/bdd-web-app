package com.testing.bddblog.services;

import com.testing.bddblog.core.Booking;
import com.testing.bddblog.core.Room;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingService {

    void save(Booking booking);

    void deleteById(Integer id);

    Iterable<Booking> findAll();

    List<Booking> findByRoom(Integer id);

    Optional<Booking> findById(Integer id);
}
