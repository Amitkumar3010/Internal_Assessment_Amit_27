package com.practical.LibraryManagementSystem;

import com.practical.LibraryManagementSystem.model.Member;
import com.practical.LibraryManagementSystem.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAll() {
        return memberService.getAllMembers();
    }

    @GetMapping("/active")
    public List<Member> getActive() {
        return memberService.getActiveMembers();
    }

    @PostMapping
    public Member create(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @PutMapping("/{id}/books/{count}")
    public Optional<Member> updateIssuedBooks(@PathVariable Long id, @PathVariable int count) {
        return memberService.updateIssuedBooks(id, count);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        memberService.deactivateMember(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}

