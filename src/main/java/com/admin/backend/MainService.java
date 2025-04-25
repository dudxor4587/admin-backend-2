package com.admin.backend;

import com.admin.backend.repository.FlightRepository;
import com.admin.backend.repository.MemberRepository;
import com.admin.backend.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {
    private final FlightRepository flightRepository;
    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;
}
