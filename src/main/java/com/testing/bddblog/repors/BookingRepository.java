package com.testing.bddblog.repors;

import com.testing.bddblog.core.Booking;
import com.testing.bddblog.core.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
