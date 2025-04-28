package com.admin.backend;

import com.admin.backend.entity.Flight;
import com.admin.backend.entity.Member;
import com.admin.backend.entity.Reservation;
import com.admin.backend.repository.FlightRepository;
import com.admin.backend.repository.MemberRepository;
import com.admin.backend.repository.ReservationRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MainService {
    private final FlightRepository flightRepository;
    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;

    @Transactional
    public void signup(String memberName, String memberEmail, String memberPassword, String passportNumber) {
        // TODO : 회원가입 처리
        // memberRepository의 saveMember 메서드를 호출하여 회원가입 처리
    }

    public Member login(String email, String password) {
        // TODO : 로그인 처리
        // memberRepository의 findByMemberEmailAndMemberPassword 메서드를 호출하여 로그인 처리
        // memberId가 null이면 IllegalArgumentException 예외를 던짐
        // memberId가 null이 아니면 member를 반환
        return null;
    }

    public List<Flight> searchFlights(String departureAirport, String arrivalAirport, LocalDate departureDate) {
        // TODO : 항공편 검색 처리
        // flightRepository의 findByDepartureAirportAndArrivalAirportAndDepartureDate 메서드를 호출하여 항공편 검색
        return null;
    }

    @Transactional
    public Reservation makeReservation(Long memberId, Long flightId) {
        // TODO : 예약 처리
        // memberRepository의 findById 메서드를 호출하여 memberId로 회원 조회
        // flightRepository의 findById 메서드를 호출하여 flightId로 항공편 조회
        // memberId와 flightId로 예약 정보를 reservationRepository의 saveReservation 메서드를 호출하여 저장

        // 예약 정보를 저장한 후, reservationRepository의 findLatestReservation 메서드를 호출하여 저장된 예약 정보를 조회
        return null;
    }

    public Reservation getReservation(Long reservationId) {
        // TODO : 예약 정보 조회
        // reservationRepository의 findById 메서드를 호출하여 reservationId로 예약 정보 조회
        // 예약 정보가 없으면 IllegalArgumentException 예외를 던짐
        // 예약 정보가 있으면 예약 정보를 반환
        return null;
    }

    public List<Reservation> getMyReservations(Long memberId) {
        // TODO : 내 예약 정보 조회
        // reservationRepository의 findByMemberMemberId 메서드를 호출하여 memberId로 예약 정보 조회하여 반환
        return null;
    }

    public List<Flight> findAllFlights() {
        // TODO : 전체 항공편 목록 조회
        // flightRepository의 findAllOrderByDepartureTime 메서드를 호출하여 전체 항공편 목록 조회 후 반환
        return null;
    }

    @Transactional
    public void cancelReservation(Long reservationId, Long memberId) {
        // TODO : 예약 취소 처리
        // reservationRepository의 findByIdAndMemberId 메서드를 호출하여 reservationId와 memberId로 예약 정보 조회
        // 예약 정보가 없거나 취소 권한이 없으면 IllegalArgumentException 예외를 던짐
        // 예약 정보가 있으면 reservationRepository의 deleteReservation 메서드를 호출하여 예약 취소 처리
    }
}
