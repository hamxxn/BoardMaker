package com.example.boardmakers.domain.members.repository;

import com.example.boardmakers.domain.members.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
