package com.testing.bddblog.controllers;

import com.testing.bddblog.core.Booking;
import com.testing.bddblog.core.Client;
import com.testing.bddblog.core.Room;
import com.testing.bddblog.services.BookingService;
import com.testing.bddblog.services.ClientService;
import com.testing.bddblog.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BookingController {

    private final RoomService roomService;
    private final ClientService clientService;
    private final BookingService bookingService;

    @Autowired
    public BookingController(RoomService roomService, ClientService clientService, BookingService bookingService) {
        this.roomService = roomService;
        this.clientService = clientService;
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public String getReq(Map<String, Object> model) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date today = new Date();

        String dateIn = dateFormat.format(today);
        String dateOut = dateFormat.format(cal.getTime());
        Integer aPlaces = 1;
        Integer cPlaces = 0;

        List<Room> freeRooms = findFreeRooms(aPlaces, cPlaces, dateIn, dateOut);

        setParamModule(model, dateIn, dateOut, aPlaces, cPlaces, freeRooms);

        return "booking";
    }

    @PostMapping("/booking")
    public String postFindRooms(@RequestParam String dateIn,
                                @RequestParam String dateOut,
                                @RequestParam Integer aPlaces,
                                @RequestParam Integer cPlaces,
                                @RequestParam Integer idRoom,
                                @RequestParam String name,
                                @RequestParam String phone,
                                @RequestParam String mail,
                                Map<String, Object> model) {

        if (idRoom != -1) {
            List<Client> insertClient = clientService.finClientByPhone(phone);

            if (insertClient.size() == 0) {
                Client client = new Client(name, phone, mail);
                clientService.save(client);
            }

            Integer idClient = clientService.finClientByPhone(phone).get(0).getId();

            Booking bookingRoom = new Booking(idRoom, idClient, dateIn, dateOut);
            bookingService.save(bookingRoom);
        }

        List<Room> freeRooms = findFreeRooms(aPlaces, cPlaces, dateIn, dateOut);

        setParamModule(model, dateIn, dateOut, aPlaces, cPlaces, freeRooms);

        return "booking";
    }

    private List<Room> findFreeRooms(Integer aPlaces, Integer cPlaces, String dateIn, String dateOut) {

        Iterable<Room> rooms = roomService.findRoomsWithACPlaces(aPlaces, cPlaces);

        List<Room> freeRooms = new ArrayList<Room>();

        for (Room room: rooms) {
            List<Booking> bookings = bookingService.findByRoom(room.getId());
            int count = 0;
            for (Booking b : bookings) {
                if (((dateIn.compareTo(b.getDateIn()) >= 0) && (b.getDateOut().compareTo(dateIn) >=0)) ||
                        ((dateOut.compareTo(b.getDateIn()) >= 0) && (b.getDateOut().compareTo(dateOut) >= 0)) ||
                        ((b.getDateIn().compareTo(dateIn) >= 0) && (dateOut.compareTo(b.getDateOut()) >= 0))) {
                    count++;
                }
            }
            System.out.println(count);
            if (count <= room.getCount())
                freeRooms.add(room);
        }

        return freeRooms;
    }

    private void setParamModule(Map<String, Object> model, String dateIn, String dateOut, Integer aPlaces, Integer cPlaces, List<Room> freeRooms) {
        model.put("dateIn", dateIn);
        model.put("dateOut", dateOut);
        model.put("aPlaces", aPlaces);
        model.put("cPlaces", cPlaces);
        model.put("rooms", freeRooms);
        model.put("title", "Бронирование номеров");
    }
}