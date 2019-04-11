package com.testing.bddblog.controllers;

import com.testing.bddblog.core.Booking;
import com.testing.bddblog.core.Client;
import com.testing.bddblog.core.Room;
import com.testing.bddblog.services.BookingService;
import com.testing.bddblog.services.ClientService;
import com.testing.bddblog.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AdminController {

    private final RoomService roomService;
    private final ClientService clientService;
    private final BookingService bookingService;

    @Autowired
    public AdminController(RoomService roomService, ClientService clientService, BookingService bookingService) {
        this.roomService = roomService;
        this.clientService = clientService;
        this.bookingService = bookingService;
    }

    // контроллер для загрузки админ-страницы
    @GetMapping("/admin")
    public String getReq(Map<String, Object> model) {

        putModelParams(model);
        model.put("message", "1234567890");
        return "admin";
    }

    @PostMapping("/addRoom")
    public String postAddRoom(Map<String, Object> model,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Integer aPlaces,
                              @RequestParam Integer cPlaces,
                              @RequestParam Integer count,
                              @RequestParam Integer cost,
                              @RequestParam Integer s_img) {

        List<Room> rooms = roomService.findRoomByName(name);

        if (rooms.size() == 0) {
            Room room = new Room(name, description, aPlaces, cPlaces, count, cost, s_img);
            roomService.save(room);
            model.put("message", "Комната успешно добавлена");
        } else
            model.put("message", "Комната не добавлена\nКомната с таким название уже существует");

        putModelParams(model);
        return "redirect:/admin";
    }

    @RequestMapping(params = "SaveRoom", method=RequestMethod.POST)
    public String postEditRoom(Map<String, Object> model,
                               @RequestParam Integer id,
                               @RequestParam String name,
                               @RequestParam String description,
                               @RequestParam Integer aPlaces,
                               @RequestParam Integer cPlaces,
                               @RequestParam Integer count,
                               @RequestParam Integer cost,
                               @RequestParam Integer s_img) {

        Optional<Room> room = roomService.findById(id);

        if (room.isPresent()) {

            room.get().setName(name);
            room.get().setDescription(description);
            room.get().setAdultPlaces(aPlaces);
            room.get().setChildPlaces(cPlaces);
            room.get().setCount(count);
            room.get().setCost(cost);
            room.get().setS_img(s_img);

            roomService.save(room.get());
        }

        model.put("message", "Комната успешно отредактирована");
        putModelParams(model);
        return "redirect:/admin";
    }

    @RequestMapping(params = "DeleteRoom", method=RequestMethod.POST)
    public String postDeleteRoom(Map<String, Object> model,
                                 @RequestParam Integer id,
                                 @RequestParam String name) {

        try {
            roomService.deleteById(id);
        } catch (Exception e) {
            return "redirect:/admin";
        }

        model.put("message", "Комната room успешно удалена");
        putModelParams(model);
        return "redirect:/admin";
    }

    @RequestMapping(params = "SaveClient", method=RequestMethod.POST)
    public String postEditClient(Map<String, Object> model,
                               @RequestParam Integer id,
                               @RequestParam String name,
                               @RequestParam String phone,
                               @RequestParam String mail) {

        Optional<Client> client = clientService.findById(id);

        if (client.isPresent()) {

            client.get().setName(name);
            client.get().setPhone(phone);
            client.get().setMail(mail);

            clientService.save(client.get());
        }

        putModelParams(model);
        return "redirect:/admin";
    }

    @RequestMapping(params = "DeleteClient", method=RequestMethod.POST)
    public String postDeleteClient(Map<String, Object> model,
                                 @RequestParam Integer id,
                                 @RequestParam String name) {

        try {
            clientService.deleteById(id);
        } catch (Exception e) {
            return "redirect:/admin";
        }

        putModelParams(model);
        return "redirect:/admin";
    }

    @RequestMapping(params = "EditBooking", method=RequestMethod.POST)
    public String postEditBooking(Map<String, Object> model,
                                  @RequestParam Integer id,
                                  @RequestParam Integer room,
                                  @RequestParam Integer client,
                                  @RequestParam String dateIn,
                                  @RequestParam String dateOut) {

        Optional<Booking> booking = bookingService.findById(id);

        if (booking.isPresent()) {
            booking.get().setRoom(room);
            booking.get().setClient(client);
            booking.get().setDateIn(dateIn);
            booking.get().setDateOut(dateOut);

            bookingService.save(booking.get());
        }

        putModelParams(model);
        return "redirect:/admin";
    }

    @RequestMapping(params = "DeleteBooking", method=RequestMethod.POST)
    public String postDeleteBooking(Map<String, Object> model,
                                    @RequestParam Integer id) {

        try {
            bookingService.deleteById(id);
        } catch (Exception e) {
            return "redirect:/admin";
        }

        putModelParams(model);
        return "redirect:/admin";
    }

    private void putModelParams(Map<String, Object> model) {
        model.put("rooms", roomService.findAll());
        model.put("clients", clientService.findAll());
        model.put("bookings", bookingService.findAll());
    }
}
