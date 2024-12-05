package com.example.boardmakers.domain.members.service;

import com.example.boardmakers.domain.members.dto.MemberCreateRequest;
import com.example.boardmakers.domain.members.dto.MemberGetResponse;

import com.example.boardmakers.domain.members.entity.Member;
import com.example.boardmakers.domain.members.repository.MemberRepository;
import com.example.boardmakers.global.error.exception.BusinessException;
import com.example.boardmakers.global.error.exception.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long createMember(MemberCreateRequest request) {

        // 멤버 객체 생성
        Member member = new Member(request.username(), request.age());

        // 멤버 DB에 저장
        Member save = memberRepository.save(member);

        return save.getId();
    }
    @Override
    public MemberGetResponse getMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

        return new MemberGetResponse(member.getName(), member.getAge());
    }

    @Override
    public List<MemberGetResponse> getMembers(){
        return memberRepository.findAll().
                stream()
                .filter(member -> member.getAge()>0)
                .map(member -> new MemberGetResponse(member.getName(), member.getAge()))
                .toList();
    }

    @Override
    public Member deleteMember(Long id) {
        Member delete=memberRepository.
                findById((id)).orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        memberRepository.deleteById(id);
        return delete;
    }
    @Override
    public Member updateMember(Long id, Member member) {
        Member update=memberRepository.findById((id))
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        if (member.getAge()!=0)
            update.setAge(member.getAge());
        if (member.getName()!=null)
            update.setName(member.getName());
        memberRepository.save(update);
        return update;
    }

    @Override
    public Member replaceMember(Long id, Member member) {
        Member replace=memberRepository.findById((id))
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        replace.setAge(member.getAge());
        replace.setName(member.getName());
        memberRepository.save(replace);
        return replace;
    }
}
