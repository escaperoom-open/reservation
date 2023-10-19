package com.escaperoom.reservation.cafe.controller;

import com.escaperoom.reservation.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("/")
    public String getCafeList(
            @RequestParam(value = "region", required = false, defaultValue = "홍대") String region,
            Model model
    ) {
        model.addAttribute("cafeList", cafeService.getCafeList(region));
        return "index";
    }
}
