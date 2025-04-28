package com.admin.backend.repository;

import com.admin.backend.entity.Flight;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 항공편 검색 쿼리
    // 출발 공항, 도착 공항, 출발 날짜를 기준으로 항공편을 조회
    // 출발 날짜는 LocalDate 타입으로 받아야 하며, JPQL 쿼리에서 DATE() 함수를 사용하여 날짜만 비교
    // 출발 시간 기준으로 오름차순 정렬
    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDate(
            @Param("departureAirport") String departureAirport,
            @Param("arrivalAirport") String arrivalAirport,
            @Param("departureDate") LocalDate departureDate
    );

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 항공편 ID로 항공편을 조회
    Optional<Flight> findById(@Param("id") Long id);

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 모든 항공편을 조회
    List<Flight> findAll();

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 모든 항공편을 조회하고 출발 시간 기준으로 오름차순 정렬
    List<Flight> findAllOrderByDepartureTime();
}
