package com.admin.backend.repository;

import com.admin.backend.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 이메일과 비밀번호로 회원을 조회하는 쿼리
    Optional<Member> findByMemberEmailAndMemberPassword(@Param("email") String email, @Param("password") String password);

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 회원 ID로 회원을 조회하는 쿼리
    Optional<Member> findById(@Param("id") Long id);

    // TODO : @Query 어노테이션을 사용하여 JPQL 쿼리 작성
    // 회원가입을 처리하는 쿼리
    // JPQL은 INSERT INTO 문을 지원하지 않으므로, nativeQuery를 사용하여 SQL 쿼리로 작성
    // value 부분에 INSERT INTO 쿼리 작성
    @Modifying
    @Query(value = "", nativeQuery = true)
    void saveMember(@Param("memberName") String memberName,
                    @Param("memberEmail") String memberEmail,
                    @Param("memberPassword") String memberPassword,
                    @Param("passportNumber") String passportNumber);
}
