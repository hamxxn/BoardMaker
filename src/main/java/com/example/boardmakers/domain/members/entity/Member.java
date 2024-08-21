package com.example.boardmakers.domain.members.entity;

import jakarta.persistence.*;

@Entity  //해당 클래스가 entity임을 표시
public class Member {

    @Id //DB에서 ID 역할을 함
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB에 entity를 추가하면 ID가 자동으로 1,2,3 순서로 증가되며 할당됨
    @Column(name = "user_id") //DB에 user_id라는 이름으로 변경되어 저장됨


    private Long Id;

    private String name;

    private int age;

    public Member() {
    }

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
}