package com.escaperoom.reservation.region.controller;

import com.escaperoom.reservation.region.domain.Region;
import com.escaperoom.reservation.region.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {
    private final RegionService regionService;

    @GetMapping("")
    public List<Region> getRegionList() {
        return regionService.getRegionList();
    }

}
