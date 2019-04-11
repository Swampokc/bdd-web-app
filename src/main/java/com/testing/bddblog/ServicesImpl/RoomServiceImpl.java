package com.testing.bddblog.ServicesImpl;

import com.testing.bddblog.core.Room;
import com.testing.bddblog.repors.RoomRepository;
import com.testing.bddblog.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public  RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Iterable<Room> findRoomsWithACPlaces(Integer aPlaces, Integer cPlaces) {
        return roomRepository.findRoomsWithACPlaces(aPlaces, cPlaces);
    }

    @Override
    public List<Room> findRoomByName(String name) {
        return roomRepository.findByName(name);
    }

    @Override
    public Optional<Room> findById(Integer id) {
        return roomRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        roomRepository.deleteById(id);
    }
}
