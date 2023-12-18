package com.escaperoom.reservation.cafe.service;

import com.escaperoom.reservation.cafe.domain.Cafe;
import com.escaperoom.reservation.cafe.domain.CafeRepository;
import com.escaperoom.reservation.cafe.dto.CafeResponseDTO;
import com.escaperoom.reservation.region.domain.Region;
import com.escaperoom.reservation.region.domain.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;
    private final RegionRepository regionRepository;

    public List<CafeResponseDTO> getCafeList(long regionId, LocalDate wishDate, String name) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디를 가진 지역은 존재하지 않습니다."));

        LocalDate finalWishDate = (wishDate != null) ? wishDate : LocalDate.now();
        if (name == null || name.isBlank()) {
            return cafeRepository.findAllByRegion(region).stream()
                    .map(cafe -> new CafeResponseDTO(cafe, finalWishDate))
                    .toList();
        }
        return cafeRepository.findAllByRegionAndName(region, name).stream()
                .map(cafe -> new CafeResponseDTO(cafe, finalWishDate))
                .toList();
    }

}
