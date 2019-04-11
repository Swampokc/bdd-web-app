package com.testing.bddblog.repors;

import com.testing.bddblog.core.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

    List<Booking> findByRoom(Integer id);
}
