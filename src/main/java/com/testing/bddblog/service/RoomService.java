package com.testing.bddblog.service;

import com.testing.bddblog.core.Room;
import com.testing.bddblog.repors.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room findById(Integer roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }
}
