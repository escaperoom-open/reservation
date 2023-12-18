package com.escaperoom.reservation.cafe.dto;

import com.escaperoom.reservation.cafe.domain.Cafe;
import com.escaperoom.reservation.region.domain.Region;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class CafeResponseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cafeId;

    private String logoImg;

    private String name;

    private LocalDate openDate;

    private LocalTime openTime;

    public CafeResponseDTO(Cafe cafe, LocalDate wishDate) {
        this.cafeId = cafe.getCafeId();
        this.logoImg = cafe.getLogoImg();
        this.name = cafe.getName();
        // 희망 날짜를 포함해서 openDayNum 개 만큼 날짜가 오픈
        // 예시: 희망날짜 23.08.20, 오픈되는 날짜 수 7개 => 20일 - 7일 + 1 = 14일 오픈
        this.openDate = wishDate.minusDays(cafe.getOpenDayNum() + 1);
        this.openTime = cafe.getOpenTime();
    }
}
