package com.escaperoom.reservation.cafe.domain;

import com.escaperoom.reservation.region.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
    List<Cafe> findAllByRegion(Region region);

    List<Cafe> findAllByRegionAndName(Region region, String name);
}
