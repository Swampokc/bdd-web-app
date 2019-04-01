package com.testing.bddblog.repors;

import com.testing.bddblog.core.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
