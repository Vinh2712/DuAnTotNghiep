package com.example.sd_57_datn.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homepage {
    @GetMapping("/homepage")
    public String home(Model model) {
        return "homepage";
    }
    //phuong
}
