package com.admin.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    private String flightName;
    private String departure_airport;
    private String arrival_airport;
    private LocalDateTime departure_time;
    private LocalDateTime arrival_time;

    @Builder
    public Flight(String flightName, String departure_airport, String arrival_airport, LocalDateTime departure_time, LocalDateTime arrival_time) {
        this.flightName = flightName;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
    }

}
