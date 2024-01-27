package com.escaperoom.reservation.theme.domain;

import com.escaperoom.reservation.cafe.domain.Cafe;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long themeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id", nullable = false)
    private Cafe cafe;

    @Column(length = 100 ,nullable = false)
    private String name;

    @Column(length = 20)
    private String level;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private int minPeopleNum; // 0이면 제공하는 정보가 없는 걸 의미

    @Column(nullable = false)
    private int maxPeopleNum; // 0이면 제공하는 정보가 없는 걸 의미

    @Column(length = 300)
    private String posterImg;

    @Column(length = 50)
    private String genre;

    @Column(nullable = false)
    private int playTime;
}
