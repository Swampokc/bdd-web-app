package com.testing.bddblog.controllers;

import com.testing.bddblog.core.Room;
import com.testing.bddblog.repors.RoomRepository;
import com.testing.bddblog.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    RoomService roomService;

    @GetMapping("/index")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name,
                        Map<String, Object> model) {
        model.put("name", name);
        return "index";
    }
}