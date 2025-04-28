package com.admin.backend.repository;

import com.admin.backend.entity.Reservation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 회원 ID로 예약 정보를 조회하는 쿼리
    // 예약 정보는 예약 날짜 기준으로 내림차순 정렬
    // 예약 정보는 Flight와 Member 정보를 조인하여 조회
    List<Reservation> findByMemberMemberId(@Param("memberId") Long memberId);

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 예약 ID로 예약 정보를 조회하는 쿼리
    // 예약 정보는 Flight와 Member 정보를 조인하여 조회
    Optional<Reservation> findById(@Param("id") Long id);

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 예약 ID와 회원 ID로 예약 정보를 조회하는 쿼리
    Reservation findByIdAndMemberId(@Param("reservationId") Long reservationId, @Param("memberId") Long memberId);

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 예약 ID와 회원 ID로 예약 정보를 삭제하는 쿼리
    // Modifying 어노테이션을 사용하여 데이터베이스에 변경을 가한다
    @Modifying
    void deleteReservation(@Param("reservationId") Long reservationId, @Param("memberId") Long memberId);

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 예약 정보를 저장하는 쿼리
    // JPQL은 INSERT INTO 문을 지원하지 않으므로, nativeQuery를 사용하여 SQL 쿼리로 작성
    // value 부분에 INSERT INTO 쿼리 작성
    @Modifying
    @Query(value = "", nativeQuery = true)
    void saveReservation(@Param("memberId") Long memberId,
                         @Param("flightId") Long flightId,
                         @Param("price") Long price,
                         @Param("reservationDate") LocalDateTime reservationDate);

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 회원 ID와 항공편 ID로 예약 정보를 조회하는 쿼리
    // 예약 정보는 예약 날짜 기준으로 내림차순 정렬
    // Limit 1을 사용하여 최신 예약 정보만 조회
    @Query("SELECT r FROM Reservation r " +
            "WHERE r.member.memberId = :memberId AND r.flight.flightId = :flightId " +
            "ORDER BY r.reservationDate DESC LIMIT 1")
    Reservation findLatestReservation(@Param("memberId") Long memberId,
                                      @Param("flightId") Long flightId);
}
