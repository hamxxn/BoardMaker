package com.example.boardmakers.domain.members.dto;

public record MemberCreateRequest(
        String username,
        int age
) {

}
