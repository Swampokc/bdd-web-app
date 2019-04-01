package com.testing.bddblog.service;

import com.testing.bddblog.core.Booking;
import com.testing.bddblog.repors.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingService {

    @Autowired
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }
}
