package com.testing.bddblog.repors;

import com.testing.bddblog.core.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

    @Query("SELECT r FROM Room r WHERE r.aplaces >= :aPlaces and r.cplaces >= :cPlaces")
    public Iterable<Room> findRoomsWithACPlaces(@Param("aPlaces") Integer aPlaces,
                                                @Param("cPlaces") Integer cPlaces);

    List<Room> findByName(String name);
}
