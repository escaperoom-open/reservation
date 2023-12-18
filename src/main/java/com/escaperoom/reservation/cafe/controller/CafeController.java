package com.escaperoom.reservation.cafe.controller;

import com.escaperoom.reservation.cafe.domain.Cafe;
import com.escaperoom.reservation.cafe.dto.CafeResponseDTO;
import com.escaperoom.reservation.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("")
    public List<CafeResponseDTO> getCafeList(
            @RequestParam(value = "regionId", required = false, defaultValue = "1") long regionId,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "wishDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate wishDate
            ) {
        return cafeService.getCafeList(regionId, wishDate, name);
    }
}
