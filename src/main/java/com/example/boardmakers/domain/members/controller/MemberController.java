package com.example.boardmakers.domain.members.controller;

import com.example.boardmakers.domain.members.dto.MemberCreateRequest;
import com.example.boardmakers.domain.members.dto.MemberGetResponse;

import com.example.boardmakers.domain.members.entity.Member;
import com.example.boardmakers.domain.members.service.MemberService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public ResponseEntity<Long> createMember(
            @RequestBody MemberCreateRequest request   //...(4)
    ) {

        Long memberId = memberService.createMember(request);  //...(5)
        return ResponseEntity.ok(memberId); //...(6)
    }
    @GetMapping("/members/{id}")
    public ResponseEntity<MemberGetResponse> getMember(
            @PathVariable("id") Long id
    ){

        MemberGetResponse member=memberService.getMember(id);

        return ResponseEntity.ok(member);
    }
    @GetMapping("/members")
    public ResponseEntity<List<MemberGetResponse>> getMembers(
    ){
        List<MemberGetResponse> members=memberService.getMembers();
        return  ResponseEntity.ok(members);
    }
    @DeleteMapping("/members/{id}")
    public ResponseEntity<Long> deleteMember(
            @PathVariable("id") Long id
    ){
        Member memberId = memberService.deleteMember(id);
        return ResponseEntity.ok(memberId.getId());
    }
    @PutMapping("/memebers/{id}")
    public  ResponseEntity<Member> replaceMember(
            @PathVariable("id") Long id, @RequestBody Member member
    ){
        Member replaced=memberService.replaceMember(id,member) ; //...(5)
        return ResponseEntity.ok(replaced);  //...(6)
    }
    @PatchMapping("/members/{id}")
    public  ResponseEntity<Member> updateMember(
            @PathVariable("id") Long id, @RequestBody Member member
    ){
        Member updated=memberService.updateMember(id,member) ; //...(5)
        return ResponseEntity.ok(updated);  //...(6)
    }


}

