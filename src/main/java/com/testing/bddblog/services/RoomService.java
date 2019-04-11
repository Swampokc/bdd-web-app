package com.testing.bddblog.services;

import com.testing.bddblog.core.Room;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoomService {

    void save(Room room);

    Iterable<Room> findAll();

    public Iterable<Room> findRoomsWithACPlaces(Integer aPlaces, Integer cPlaces);

    List<Room> findRoomByName(String name);

    Optional<Room> findById(Integer id);

    void deleteById(Integer id);
}
