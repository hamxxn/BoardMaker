package com.example.boardmakers.domain.members.service;

import com.example.boardmakers.domain.members.dto.MemberCreateRequest;
import com.example.boardmakers.domain.members.dto.MemberGetResponse;
import com.example.boardmakers.domain.members.entity.Member;


import java.util.List;


public interface MemberService {
    Long createMember(MemberCreateRequest request);
    MemberGetResponse getMember(Long id);
    List getMembers();
    Member deleteMember(Long id);
    Member updateMember(Long id, Member member);
    Member replaceMember(Long id, Member member);
}
