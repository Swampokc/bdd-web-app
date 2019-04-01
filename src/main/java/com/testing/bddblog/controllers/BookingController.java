package com.testing.bddblog.controllers;

import com.testing.bddblog.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BookingController {

    @Autowired
    RoomService roomService;

    @GetMapping("/booking")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name,
                        Map<String, Object> model) {
        model.put("name", name);
        model.put("title", "Бронирование номеров");
        return "booking";
    }
}