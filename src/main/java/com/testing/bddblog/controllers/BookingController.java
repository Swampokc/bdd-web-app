package com.testing.bddblog.controllers;

import com.testing.bddblog.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BookingController {

    @Autowired
    RoomService roomService;

    @GetMapping("/booking")
    public String getReq(Map<String, Object> model) {
        model.put("name", "4567");
        model.put("title", "Бронирование номеров");
        return "booking";
    }

    @PostMapping("/booking")
    public String postReq(Map<String, Object> model) {
        model.put("name","fghj");
        model.put("title", "Бронирование номеров");
        return "booking";
    }
}