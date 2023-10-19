package com.escaperoom.reservation.cafe.service;

import com.escaperoom.reservation.cafe.domain.Cafe;
import com.escaperoom.reservation.cafe.domain.CafeRepository;
import com.escaperoom.reservation.region.domain.Region;
import com.escaperoom.reservation.region.domain.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;
    private final RegionRepository regionRepository;

    @Transactional(readOnly = true)
    public List<Cafe> getCafeList(String regionName) {
        Region region = regionRepository.findByName(regionName)
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 지역은 존재하지 않습니다."));
        return cafeRepository.findByRegion(region);
    }
}
