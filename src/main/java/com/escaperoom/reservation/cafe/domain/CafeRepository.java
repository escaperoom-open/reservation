package com.escaperoom.reservation.cafe.domain;

import com.escaperoom.reservation.region.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    List<Cafe> findAllByRegion(Region region);

    List<Cafe> findAllByRegionAndName(Region region, String name);
}
