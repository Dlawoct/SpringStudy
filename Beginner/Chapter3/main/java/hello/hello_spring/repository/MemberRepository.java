package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 멤버 저장
    Member save(Member member);

    // ID로 찾기
    Optional<Member> findById(Long id);

    // Name으로 찾기
    Optional<Member> findByName(String name);

    // 저장된 모든 멤버 찾기
    List<Member> findAll();
}
