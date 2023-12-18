package com.escaperoom.reservation.region.service;

import com.escaperoom.reservation.region.domain.Region;
import com.escaperoom.reservation.region.domain.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;


    public List<Region> getRegionList() {
        List<Region> regionList = regionRepository.findAll();
        return regionRepository.findAll();
    }
}
