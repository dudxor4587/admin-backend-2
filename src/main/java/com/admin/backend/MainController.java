package com.admin.backend;

import com.admin.backend.entity.Flight;
import com.admin.backend.entity.Reservation;
import jakarta.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    /** 메인페이지 */
    // TODO : / 요청을 받아 메인 페이지를 보여주는 메서드(get 요청)
    public String index(Model model, HttpSession session) {
        // TODO : 로그인 상태 처리
        // session에서 memberId를 가져옴
        // memberId가 null이 아니면 model에 memberId와 memberName을 추가

        // TODO : 전체 항공편 목록 조회
        // mainService.findAllFlights()를 호출하여 flights의 List를 가져옴
        // model에 flights를 추가
        return "index";
    }

    /** 회원가입 폼 */
    // TODO : /members/signup 요청을 받아 회원가입 폼을 보여주는 메서드(get 요청)
    public String showSignupForm() {
        return "signup";
    }

    /** 회원가입 처리 */
    // TODO : /members/signup 요청을 받아 회원가입 처리를 하는 메서드(post 요청)
    public String processSignup(@RequestParam String memberName,
                                @RequestParam String memberEmail,
                                @RequestParam String memberPassword,
                                @RequestParam String passportNumber) {
        // TODO : 회원가입 처리
        // mainService.signup() 메서드를 호출하여 회원가입 처리
        return "redirect:/members/login";
    }

    /** 로그인 폼 */
    // TODO : /members/login 요청을 받아 로그인 폼을 보여주는 메서드(get 요청)
    public String showLoginForm() {
        return "login";
    }

    /** 로그인 처리 */
    // TODO : /members/login 요청을 받아 로그인 처리를 하는 메서드(post 요청)
    public String processLogin(@RequestParam String email,
                                 @RequestParam String password, 
                                 HttpSession session) {
        // TODO : 로그인 처리
        // mainService.login() 메서드를 호출하여 로그인 처리
        // 로그인 성공 시 session에 memberId와 memberName을 추가
        return "redirect:/";
    }

    /** 로그아웃 처리 */
    // TODO : /members/logout 요청을 받아 로그아웃 처리를 하는 메서드(get 요청)
    public String logout(HttpSession session) {
        // TODO : 로그아웃 처리
        // session.invalidate()를 호출하여 세션을 무효화
        return "redirect:/";
    }

    /** 검색 결과 표시 */
    // TODO : /flights/search 요청을 받아 항공편 검색 결과를 보여주는 메서드(get 요청)
    public String showSearchResults(Model model,
                                    @RequestParam String departureAirport,
                                    @RequestParam String arrivalAirport,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {
        // TODO : 검색 결과 표시
        // mainService.searchFlights() 메서드를 호출하여 항공편 목록을 가져옴
        // model에 flights를 추가
        // model에 formattedDate를 추가하여 검색한 날짜 저장
        // model.addAttribute("formattedDate", departureDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
        return "search_results";
    }

    /** 예약 생성 */
    // TODO : /reservations 요청을 받아 예약 생성을 처리하는 메서드(post 요청)
    public String makeReservation(@RequestParam Long flightId,
                                  HttpSession session) {
        // TODO : 예약 생성
        // session에서 memberId를 가져옴
        // memberId가 null이면 로그인 페이지로 리다이렉트
        // mainService.makeReservation() 메서드를 호출하여 예약 생성

        // 예약이 성공적으로 생성되면 예약 ID를 쿼리 파라미터로 전달하여 예약 완료 페이지로 리다이렉트
        // return "redirect:/reservations/success?reservationId=" + reservation.getReservationId();
        return null;
    }

    /** 예약 완료 페이지 */
    // TODO : /reservations/success 요청을 받아 예약 완료 페이지를 보여주는 메서드(get 요청)
    public String showReservationSuccess(@RequestParam Long reservationId, Model model) {
        // TODO : 예약 완료 페이지
        // mainService.getReservation() 메서드를 호출하여 예약 정보를 가져옴
        // model에 reservation을 추가
        return "reservation_success";
    }

    /** 내 예약 목록 조회 */
    // TODO : /reservations/my 요청을 받아 내 예약 목록을 보여주는 메서드(get 요청)
    public String viewMyReservations(Model model, HttpSession session) {
        // TODO : 내 예약 목록 조회
        // session에서 memberId를 가져옴
        // memberId가 null이면 로그인 페이지로 리다이렉트

        // mainService.getMyReservations() 메서드를 호출하여 예약 목록을 List로 가져옴
        // model에 reservations를 추가
        return "my_reservations";
    }

    /** 예약 취소 */
    // TODO : /reservations/{reservationId}/cancel 요청을 받아 예약 취소를 처리하는 메서드(post 요청)
    public String cancelReservation(@PathVariable Long reservationId, HttpSession session) {
        // TODO : 예약 취소
        // session에서 memberId를 가져옴
        // memberId가 null이면 로그인 페이지로 리다이렉트

        // mainService.cancelReservation() 메서드를 호출하여 예약 취소
        return "redirect:/reservations/my";
    }
}
