package com.practical.LibraryManagementSystem.repository;

import com.practical.LibraryManagementSystem.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByActiveTrue();
}
