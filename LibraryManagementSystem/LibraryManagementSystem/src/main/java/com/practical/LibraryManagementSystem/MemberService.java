package com.practical.LibraryManagementSystem;


import com.practical.LibraryManagementSystem.model.Member;
import com.practical.LibraryManagementSystem.repository.MemberRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public List<Member> getActiveMembers() {
        return memberRepository.findByActiveTrue();
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Optional<Member> updateIssuedBooks(Long id, int issuedBooks) {
        Optional<Member> memberOpt = memberRepository.findById(id);
        memberOpt.ifPresent(m -> {
            m.setIssuedBooks(issuedBooks);
            memberRepository.save(m);
        });
        return memberOpt;
    }

    public void deactivateMember(Long id) {
        memberRepository.findById(id).ifPresent(m -> {
            m.setActive(false);
            memberRepository.save(m);
        });
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
